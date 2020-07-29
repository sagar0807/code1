package gov.naco.soch.cst.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.cst.dto.ArtBeneficiaryIctcReferralDto;
import gov.naco.soch.cst.dto.ArtRegistrationDto;
import gov.naco.soch.cst.mapper.ArtBeneficiaryIctcReferralMapper;
import gov.naco.soch.cst.mapper.ArtIctcReferralMapperUtil;
import gov.naco.soch.cst.mapper.BeneficiaryRegistrationMapper;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.ArtBeneficiary;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryFacilityMapping;
import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.MasterHivType;
import gov.naco.soch.entity.MasterReferralStatus;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.enums.RefferalStatusEnum;
import gov.naco.soch.projection.ArtBeneficiaryRegistrationProjection;
import gov.naco.soch.projection.ArtIctcReferredProjection;
import gov.naco.soch.repository.ArtBeneficiaryRepository;
import gov.naco.soch.repository.BeneficiaryReferralRepository;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.repository.BeneficiaryVisitRegisterRepository;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.repository.UserMasterRepository;
import gov.naco.soch.util.UserUtils;

@Transactional
@Service
public class BeneficiaryReferralService {

	@Autowired
	private BeneficiaryReferralRepository beneficiaryReferralRepository;

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	@Autowired
	private FacilityRepository facilityRepository;

	@Autowired
	private UserMasterRepository userMasterRepository;

	@Autowired
	private BeneficiaryVisitRegisterRepository beneficiaryVisitRegisterRepository;

	@Autowired
	private ArtBeneficiaryRepository artBeneficiaryRepository;

	private static final Logger logger = LoggerFactory.getLogger(BeneficiaryReferralService.class);

	public List<ArtBeneficiaryIctcReferralDto> getReferralList() {
		logger.debug("inside referral listing service");
		Long facilityId = UserUtils.getLoggedInUserDetails().getFacilityId();
		List<ArtIctcReferredProjection> ictcList = beneficiaryReferralRepository.findIctcreferrals(facilityId,
				RefferalStatusEnum.Referred.getReferalStatus());
		return ArtBeneficiaryIctcReferralMapper.mapProjectionToBeneficiaryReferralDto(ictcList);
	}

	public ArtRegistrationDto saveBeneficiaryFromIctcReferral(ArtRegistrationDto artRegistrationDto) {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		Optional<Facility> facility = facilityRepository.findById(loginResponseDto.getFacilityId());
		Optional<UserMaster> user = userMasterRepository.findById(loginResponseDto.getUserId());
		if (artRegistrationDto.getBeneficiaryId() != null && artRegistrationDto.getBeneficiaryId() != 0) {
			Optional<Beneficiary> beneficiaryOptional = beneficiaryRepository
					.findById(artRegistrationDto.getBeneficiaryId());
			if (beneficiaryOptional.isPresent()) {

				Beneficiary beneficiary = beneficiaryOptional.get();
				beneficiary.setFirstName(artRegistrationDto.getFirstName());
				beneficiary.setMiddleName(artRegistrationDto.getMiddleName());
				beneficiary.setLastName(artRegistrationDto.getLastName());
				Optional<ArtBeneficiaryRegistrationProjection> preArtNumDuplicationCheck = beneficiaryRepository
						.findByPreArtNumber(artRegistrationDto.getPreArtNumber(), loginResponseDto.getFacilityId());
				if (preArtNumDuplicationCheck.isPresent()) {
					ArtRegistrationDto dto = new ArtRegistrationDto();
					dto.setErrorMsg("Duplicate PreARTNumber");
					return dto;
				}
				beneficiary.setPreArtNumber(artRegistrationDto.getPreArtNumber());
				if(artRegistrationDto.getHivTypeId() != null) {
					MasterHivType hivType = new MasterHivType();
					hivType.setId(artRegistrationDto.getHivTypeId());
					beneficiary.setHivTypeId(hivType);
				}
				beneficiaryRepository.save(beneficiary);

				BeneficiaryVisitRegister beneficiaryVisitRegister = BeneficiaryRegistrationMapper
						.mapToBeneficiaryVisitRegister(artRegistrationDto);
				beneficiaryVisitRegister.setBeneficiary(beneficiary);
				beneficiaryVisitRegister.setFacility(facility.get());
				beneficiaryVisitRegisterRepository.save(beneficiaryVisitRegister);

				BeneficiaryFacilityMapping beneficiaryFacilityMapping = BeneficiaryRegistrationMapper
						.mapToBeneficiaryFacilityMapping(artRegistrationDto, facility.get());
				Set<BeneficiaryFacilityMapping> beneficiaryFacilityMappings = new HashSet<>();
				beneficiaryFacilityMapping.setBeneficiary(beneficiary);
				beneficiaryFacilityMappings.add(beneficiaryFacilityMapping);
				beneficiary.setBeneficiaryFacilityMappings(beneficiaryFacilityMappings);

				ArtBeneficiary artBeneficary = BeneficiaryRegistrationMapper.mapToArtBeneficiary(artRegistrationDto);
				artBeneficary.setFacility(facility.get());
				artBeneficary.setUserId(user.get());
				artBeneficary.setBeneficiary(beneficiary);
				artBeneficary.setUserMaster1(user.get());
				ArtBeneficiary benficary = artBeneficiaryRepository.save(artBeneficary);
				if (benficary != null) {
					Optional<BeneficiaryReferral> referral = beneficiaryReferralRepository
							.findById(artRegistrationDto.getBeneficiaryReferralId());
					MasterReferralStatus statusMaster = new MasterReferralStatus();
					statusMaster.setId(RefferalStatusEnum.Accepted.getReferalStatus());
					BeneficiaryReferral benrefer = referral.get();
					benrefer.setBeneficiaryReferralStatusMaster(statusMaster);
					benrefer.setAcceptedDate(LocalDateTime.now());
					beneficiaryReferralRepository.save(benrefer);
				}
			}
		}
		ArtRegistrationDto registrationDto = new ArtRegistrationDto();
		registrationDto.setFacilityId(facility.get().getId());
		registrationDto.setFacilityName(facility.get().getName());
		return registrationDto;
	}

	public List<ArtBeneficiaryIctcReferralDto> getReferralListBySearch(String searchText) {
		List<ArtIctcReferredProjection> referralList = new ArrayList<ArtIctcReferredProjection>();
		Long facilityType = UserUtils.getLoggedInUserDetails().getFacilityTypeId();
		if (searchText != null && !searchText.isEmpty()) {
			referralList = beneficiaryReferralRepository.findIctcreferralsBySearch(searchText.toLowerCase(),
					RefferalStatusEnum.Referred.getReferalStatus(),facilityType);
		}
		return ArtBeneficiaryIctcReferralMapper.mapProjectionToBeneficiaryReferralDto(referralList);
	}

	public List<ArtBeneficiaryIctcReferralDto> getReferralListByAdvanceSearch(Map<String, String> searchValue) {
		List<Object[]> objList = new ArrayList<Object[]>();
		Long facilityType = UserUtils.getLoggedInUserDetails().getFacilityTypeId();
		List<String> searchQuery = ArtIctcReferralMapperUtil.queryCreaterForAdvanceSearch(searchValue,RefferalStatusEnum.Referred.getReferalStatus(),
				facilityType);
		if (!searchQuery.isEmpty()) {
			objList =  beneficiaryReferralRepository.findIctcreferralsByAdvanceSearchs(searchQuery.get(0));
		}
		return ArtBeneficiaryIctcReferralMapper.mapObjectDataBeneficiaryReferralDto(objList);
	}

}
