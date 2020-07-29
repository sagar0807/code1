package gov.naco.soch.cst.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import gov.naco.soch.entity.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.google.common.base.Joiner;

import gov.naco.soch.cst.criteria.SearchOperation;
import gov.naco.soch.cst.criteria.SearchSpecficationBuilder;
import gov.naco.soch.cst.dto.ArtRegistrationDto;
import gov.naco.soch.cst.dto.ArtSearchResultDto;
import gov.naco.soch.cst.dto.LinkedFacilityBeneficiaryDto;
import gov.naco.soch.cst.mapper.ArtBeneficiaryIctcReferralMapper;
import gov.naco.soch.cst.mapper.ArtIctcReferralMapperUtil;
import gov.naco.soch.cst.mapper.LinkedFacilityBeneficiaryMapper;
import gov.naco.soch.cst.mapper.LinkedFacilityBeneficiaryMapperUtil;
import gov.naco.soch.dto.LacAddDto;
import gov.naco.soch.dto.LacUserDto;
import gov.naco.soch.dto.LoginResponseDto;
//import gov.naco.soch.entity.BeneficiaryDetailsPerVisit;
import gov.naco.soch.enums.RefferalStatusEnum;
import gov.naco.soch.mapper.AddressMapperUtil;
import gov.naco.soch.mapper.LacMapper;
import gov.naco.soch.mapper.UserMapperUtil;
import gov.naco.soch.repository.ArtBeneficiaryRepository;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.repository.LinkedFacilityBeneficiaryRepository;
import gov.naco.soch.repository.UserMasterRepository;
import gov.naco.soch.util.UserUtils;

@Transactional
@Service
public class LacService {

	private static final Logger logger = LoggerFactory.getLogger(LacService.class);
	@Autowired
	private UserMasterRepository userMasterRepository;
	@Autowired
	private FacilityRepository facilityRepository;
	@Autowired
	private LinkedFacilityBeneficiaryRepository linkedFacilityBeneficiaryRepository;
	@Autowired
	private BeneficiaryRepository beneficiaryRepository;
	@Autowired
	private ArtBeneficiaryRepository artBeneficiaryRepository;

	public LacAddDto saveLac(LacAddDto lacAddDto) {
		logger.debug("saveLac method is invoked");
		if (lacAddDto.getLacId() != null && lacAddDto.getLacId() != 0) {
			Optional<Facility> lac_optional = facilityRepository.findById(lacAddDto.getLacId());
			Optional<UserMaster> staffNurse_optional = null;
			Optional<UserMaster> alternatePerson_optional = null;
			if(lacAddDto.getStaffNurseId() != null) {
				staffNurse_optional = userMasterRepository.findById(lacAddDto.getStaffNurseId());	
			}
			if(lacAddDto.getAlternatePersonId() != null) {
				alternatePerson_optional = userMasterRepository
						.findById(lacAddDto.getAlternatePersonId());	
			}
			if (lac_optional.isPresent()) {
				Facility lac = lac_optional.get();
				Address address = AddressMapperUtil.mapToAddressForLac(lacAddDto, lac.getAddress());
				Optional<Facility> parentFacility = facilityRepository.findById(lacAddDto.getFacilityId());
				Facility facility = LacMapper.mapToFacility(lacAddDto, parentFacility.get(), lac);
				facility.setAddress(address);
				facilityRepository.saveAndFlush(facility);
				/*if (staffNurse_optional.isPresent()) {
					UserMaster staffNurse = UserMapperUtil
							.mapToUserMasterForLacNurse(lacAddDto.getLacStaffNurseDetails(), staffNurse_optional.get());
					staffNurse.setFacility(facility);
					UserMaster savedStaffNurse = userMasterRepository.saveAndFlush(staffNurse);
					lacAddDto.setStaffNurseId(savedStaffNurse.getId());
				}
				if (alternatePerson_optional.isPresent()) {
					UserMaster alternatePerson = UserMapperUtil.mapToUserMasterForLacAlternatePerson(
							lacAddDto.getLacAlternatePersonDetails(), alternatePerson_optional.get());
					alternatePerson.setFacility(facility);
					UserMaster savedAlternatePerson = userMasterRepository.saveAndFlush(alternatePerson);
					lacAddDto.setAlternatePersonId(savedAlternatePerson.getId());
					lacAddDto.setLacId(savedAlternatePerson.getFacility().getId());
				}*/

			}
		} else {
			Optional<Facility> parentFacility = facilityRepository.findById(lacAddDto.getFacilityId());
			Address address = AddressMapperUtil.mapToAddressForLac(lacAddDto);
			Facility facility = LacMapper.mapToFacility(lacAddDto, parentFacility.get());
			facility.setAddress(address);
			facilityRepository.saveAndFlush(facility);
			/*if(lacAddDto.getLacStaffNurseDetails() != null && lacAddDto.getLacStaffNurseDetails().getFirstName() != null){
				UserMaster staffNurse = UserMapperUtil.mapToUserMasterForLacNurse(lacAddDto.getLacStaffNurseDetails());
				staffNurse.setFacility(facility);
				UserMaster savedStaffNurse = userMasterRepository.saveAndFlush(staffNurse);
				lacAddDto.setStaffNurseId(savedStaffNurse.getId());	
			}
			if(lacAddDto.getLacAlternatePersonDetails() != null && lacAddDto.getLacAlternatePersonDetails().getFirstName() != null) {
				UserMaster alternatePerson = UserMapperUtil
						.mapToUserMasterForLacAlternatePerson(lacAddDto.getLacAlternatePersonDetails());
				alternatePerson.setFacility(facility);
				UserMaster savedAlternatePerson = userMasterRepository.saveAndFlush(alternatePerson);
				lacAddDto.setAlternatePersonId(savedAlternatePerson.getId());
				lacAddDto.setLacId(savedAlternatePerson.getFacility().getId());	
			}*/
		}
		return lacAddDto;

	}
	

	public List<LinkedFacilityBeneficiaryDto> getAllLacs() {
		List<LinkedFacilityBeneficiaryDto> linkedFacilityBeneficiaryDto = new ArrayList<LinkedFacilityBeneficiaryDto>();
		Long facilityId = UserUtils.getLoggedInUserDetails().getFacilityId();
		System.out.println(facilityId);
		System.out.println(UserUtils.getLoggedInUserDetails().getFacilityTypeId());
		List<LinkedFacilityBeneficiary> lacList = linkedFacilityBeneficiaryRepository.findLacList(facilityId,UserUtils.getLoggedInUserDetails().getFacilityTypeId());
		lacList.forEach(lacBeneficiaryList -> {
			LinkedFacilityBeneficiaryDto lacListDto = LinkedFacilityBeneficiaryMapper.mapLinkedFacilityBeneficiaryDto(lacBeneficiaryList);
			linkedFacilityBeneficiaryDto.add(lacListDto);
		});
		return linkedFacilityBeneficiaryDto;
	}

	
	
	public String deleteLac(Long lacId) {
		Optional<Facility> lacOptional = facilityRepository.findById(lacId);
		if (lacOptional.isPresent()) {
			Facility lac = lacOptional.get();
			lac.setIsDelete(true);
			facilityRepository.save(lac);
			return lac.getName();
		}
		return null;

	}


	public Boolean unlinkLac(Long id, Long lacId) {
		try {
			LinkedFacilityBeneficiary laBeneficiary = linkedFacilityBeneficiaryRepository.findById(id).get();
			if(laBeneficiary != null) {
				Facility facility = new Facility();
				facility.setId(lacId);
				laBeneficiary.setLinkedFacility(facility);
				linkedFacilityBeneficiaryRepository.save(laBeneficiary);
			}
			return true;
		}
		catch (Exception e) {
			return false;
		}
		
	}
		
		public ArtSearchResultDto getLacBeneficiaryList(String searchParameters, Integer pageNumber, Integer pageSize ,Long lacId) {
			/*Long facilityId = UserUtils.getLoggedInUserDetails().getFacilityId();*/

			SearchSpecficationBuilder builder = new SearchSpecficationBuilder();
			ArtSearchResultDto setSearchResult = new ArtSearchResultDto();
			Specification<Beneficiary> beneficiarySpecification = Specification
					.where(builder.joinNumericFields("linkedFacilityBeneficiaries", "linkedFacility", lacId))
					.and(builder.join("linkedFacilityBeneficiaries", "isLinked", true));


			Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("id").descending());
			Page beneficiaryPage = beneficiaryRepository.findAll(beneficiarySpecification.and(resolveSpecification(searchParameters, builder)), pageable);
			Optional<List> beneficiaryListOptional = Optional.ofNullable(beneficiaryPage.getContent());

			if (beneficiaryListOptional.isPresent()) {
				List<Beneficiary> sortedPageableBeneficiaryList = beneficiaryListOptional.get();

				List<ArtRegistrationDto> artBeneficiaries = sortedPageableBeneficiaryList.stream().map(this::mapToArtBeneficiariesDto).collect(Collectors.toList());

				setSearchResult.setSearchResultList(artBeneficiaries);
				setSearchResult.setPageSize(pageSize);
				setSearchResult.setTotalResultCount(beneficiaryPage.getTotalElements());
				setSearchResult.setPageCount(beneficiaryPage.getTotalPages());
				setSearchResult.setFacilityId(lacId);
			}

			return setSearchResult;
		}
		
		private Specification<Beneficiary> resolveSpecification(String searchParameters,SearchSpecficationBuilder builder) {

			Pattern pattern = Pattern
				.compile("(\\p{Punct}?)(\\w+?)(~|!)([^\\s#]+?)#");
			Matcher matcher = pattern.matcher(searchParameters + "#");
			while (matcher.find()) {
			//System.out.println("1"+ matcher.group(1)  + " 2"+ matcher.group(2)+ "3"+matcher.group(3)+"4"+matcher.group(4));
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3),matcher.group(4));
			}

			return builder.build();
		}

	private ArtRegistrationDto getBeneficiaryBasicData(Beneficiary beneficiary, ArtRegistrationDto artRegistrationDto) {

		artRegistrationDto.setUidNumber(beneficiary.getUid());
		artRegistrationDto.setBeneficiaryId(beneficiary.getId());
		artRegistrationDto.setFirstName(beneficiary.getFirstName());
		artRegistrationDto.setMiddleName(beneficiary.getMiddleName());
		artRegistrationDto.setLastName(beneficiary.getLastName());
		artRegistrationDto.setContactNumber(beneficiary.getMobileNumber());
		artRegistrationDto.setAlternatePhoneNumber(beneficiary.getAlternatePhonenumber());
		artRegistrationDto.setBirthDate(beneficiary.getDateOfBirth());
		artRegistrationDto.setDeathDate(beneficiary.getDeathDate());
		artRegistrationDto.setPreArtNumber(beneficiary.getPreArtNumber());
		artRegistrationDto.setArtNumber(beneficiary.getArtNumber());

		artRegistrationDto.setAge(beneficiary.getAge());

		if(beneficiary.getHivTypeId()!=null) {
			artRegistrationDto.setHivTypeId(beneficiary.getHivTypeId().getId());
			artRegistrationDto.setHivTypeName(beneficiary.getHivTypeId().getName());
		}

		if(beneficiary.getMasterEmploymentStatus()!=null) {
			artRegistrationDto.setMasterEmploymentStatus(beneficiary.getMasterEmploymentStatus().getId());
		}
		if(beneficiary.getHivStatusId()!=null) {
			artRegistrationDto.setHivStatusId(beneficiary.getHivStatusId().getId());
		}
		MasterGender gender = beneficiary.getGenderId();
		if(gender!=null) {
			artRegistrationDto.setGenderId(gender.getId());
			artRegistrationDto.setGenderName(gender.getName());
		}
		MasterEducationLevel masterEducationLevel = beneficiary.getEducationLevelId();
		if(masterEducationLevel!=null) {
			artRegistrationDto.setEducationLevelId(masterEducationLevel.getId());
			artRegistrationDto.setEducationLevelName(masterEducationLevel.getName());
		}

		if(beneficiary.getMaritalStatusId()!=null) {
			artRegistrationDto.setMaritalStatusId(beneficiary.getMaritalStatusId().getId());
		}
		MasterOccupation masterOccupation = beneficiary.getOccupationId();
		if(masterOccupation!=null) {
			artRegistrationDto.setOccupationId(masterOccupation.getId());
			artRegistrationDto.setOccupationName(masterOccupation.getName());
		}


		MasterMonthlyIncome monthlyIncome = beneficiary.getMonthlyIncomeId();
		if(monthlyIncome!=null) {
			artRegistrationDto.setMonthlyIncome(monthlyIncome.getId());
			artRegistrationDto.setMonthlyIncomeName(monthlyIncome.getName());
		}

		artRegistrationDto.setBankAccountName(beneficiary.getBankAccountName());
		artRegistrationDto.setBankAccountNumber(beneficiary.getBankAccountNumber());
		artRegistrationDto.setBankIfsc(beneficiary.getBankIfsc());
		MasterBeneficiaryCategory category = beneficiary.getCategoryId();

		if(category!=null) {
			artRegistrationDto.setCategoryId(category.getId());
			artRegistrationDto.setCategoryName(category.getName());
		}

		if(beneficiary.getAddress()!=null) {
			Address address = beneficiary.getAddress();
			artRegistrationDto.setAddressLineOne(address.getAddressLineOne());
			artRegistrationDto.setAddressLineTwo(address.getAddressLineTwo());
			Town town = address.getTown();
			if(town!=null){
				artRegistrationDto.setTown(town.getTownId());
			}

			State state = address.getState();
			if(state!=null){
				artRegistrationDto.setState(state.getId());
				artRegistrationDto.setStateName(state.getName());
			}
			if(address.getDistrict()!=null){
				District district = address.getDistrict();
				artRegistrationDto.setDistrict(district.getId());
				artRegistrationDto.setDistrictName(district.getName());
			}
			if(address.getSubdistrict()!=null){
				Subdistrict subdistrict = address.getSubdistrict();
				artRegistrationDto.setSubDistrictId(subdistrict.getSubdistrictId());
				artRegistrationDto.setSubDistrictName(subdistrict.getSubdistrictName());
			}

			if (address.getPincodeEntity() != null) {
				artRegistrationDto.setPinCode(address.getPincodeEntity().getPincode());
			} else {
				artRegistrationDto.setPinCode(address.getPincode());
			}

		}

		if(beneficiary.getStayingWithId()!=null) {
			artRegistrationDto.setStayingWithId(beneficiary.getStayingWithId().getId());
		}
		artRegistrationDto.setCaregiverName(beneficiary.getCaregiverName());
		artRegistrationDto.setCaregiverPhoneNumber(beneficiary.getCaregiverPhoneNumber());


		Address caregiverAddress = beneficiary.getCaregiverAddressId();
		if(caregiverAddress!=null){
			artRegistrationDto.setCaregiveraddressLineOne(caregiverAddress.getAddressLineOne());
			artRegistrationDto.setCaregiveraddressLineTwo(caregiverAddress.getAddressLineTwo());
			if(caregiverAddress.getState()!=null) {
				artRegistrationDto.setCaregiverState(caregiverAddress.getState().getId());
			}
			if(caregiverAddress.getSubdistrict()!=null) {
				artRegistrationDto.setCaregiverSubDistrictId(caregiverAddress.getSubdistrict().getSubdistrictId());
			}

		}

		return artRegistrationDto;

	}
		
		private ArtRegistrationDto mapToArtBeneficiariesDto(Beneficiary beneficiary) {
			ArtRegistrationDto artRegistrationDto = new ArtRegistrationDto();

			try {
				artRegistrationDto = getBeneficiaryBasicData(beneficiary, artRegistrationDto);
				artRegistrationDto = setArtBeneficiaryFields(beneficiary, artRegistrationDto);

	            //BeneficiaryDetailsPerVisit maxOfBeneficiaryDetailsPerVisit = beneficiary.getBeneficiaryDetailsPerVisits().stream().max(Comparator.comparing(BeneficiaryDetailsPerVisit::getId)).get();
				//setBeneficiaryDetailPerVisitFields(maxOfBeneficiaryDetailsPerVisit,artRegistrationDto);
				setBeneficiaryTransferFields(Optional.ofNullable(beneficiary.getTransfers()),artRegistrationDto);
				setFacilityLinkedBeneficiaryFields(Optional.ofNullable(beneficiary.getFacilityLinkedFacilityBeneficiaries()),artRegistrationDto);
				setBeneficiaryTransitFacilityFields(Optional.ofNullable(beneficiary.getBeneficiaryTransitFacilities()),artRegistrationDto);
				setBeneficiaryTransferFields(Optional.ofNullable(beneficiary.getTransfers()),artRegistrationDto);
				//setBeneficiaryQueueList(Optional.ofNullable(beneficiary.getBeneficiaryQueue()),artRegistrationDto);
				setBeneficiaryDueListFields(Optional.ofNullable(beneficiary.getArtBeneficiaryDueLists()),artRegistrationDto);
				setBeneficiaryReferralFields(Optional.ofNullable(beneficiary.getBeneficiaryReferral()),artRegistrationDto);
				setBeneficiaryFaciltityMappingFields(Optional.ofNullable(beneficiary.getBeneficiaryFacilityMappings()),artRegistrationDto);



			} catch (Exception e) {
				logger.error("Error while mapping to ArtRegistrationDto, {} , {} ", e.getMessage(),e.getCause());
				e.printStackTrace();
			}
			return artRegistrationDto;
		}
		
		private ArtRegistrationDto setArtBeneficiaryFields(Beneficiary beneficiary, ArtRegistrationDto artRegsitrationDto) {

			Optional<Set> artBeneficiarySetOptional = Optional.ofNullable(beneficiary.getArtBeneficiary());

			if (artBeneficiarySetOptional.isPresent()) {

				Set<ArtBeneficiary> artBeneficiarySet = artBeneficiarySetOptional.get();
				Optional<ArtBeneficiary> artBeneficiaryOptional = artBeneficiarySet.stream().findFirst();
				ArtBeneficiary artBeneficiary = artBeneficiaryOptional.get();
				if (artBeneficiaryOptional.isPresent()) {
					artRegsitrationDto.setIsActive(artBeneficiary.getIsActive());
					//artRegsitrationDto.setPreviousClinic(artBeneficiary.getPreviousClinic());
					artRegsitrationDto.setIsTransit(artBeneficiary.getIsTransit());
					artRegsitrationDto.setTransitEndDate(artBeneficiary.getTransitEndDate());
					artRegsitrationDto.setTransitStartDate(artBeneficiary.getTransitStartDate());
					artRegsitrationDto.setIsLinked(artBeneficiary.getLacLinked());
					if(Optional.ofNullable(artBeneficiary.getMasterArtTreatmentStatus()).isPresent() && artBeneficiary.getMasterArtTreatmentStatus().getIsActive()) {
						artRegsitrationDto.setMasterArtTreatmentStatus(artBeneficiary.getMasterArtTreatmentStatus().getId());
					}

					Optional<MasterArtBeneficiaryStatus> masterArtBeneficiaryStatusOptional = Optional.ofNullable(artBeneficiary.getMasterArtBeneficiaryStatus());
					if (masterArtBeneficiaryStatusOptional.isPresent()) {
						artRegsitrationDto.setArtBeneficiaryStatusId(masterArtBeneficiaryStatusOptional.get().getId());
					}
					Optional<MasterBeneficiaryArtTransferredFrom> artTransferredFrom = Optional.ofNullable(artBeneficiary.getMasterBeneficiaryArtTransferredFrom());
					if (artTransferredFrom.isPresent()) {
						artRegsitrationDto.setArtTransferredFrom(artTransferredFrom.get().getId());
					}


					artRegsitrationDto.setArtRegistration_date(artBeneficiary.getArtRegistrationDate());
					artRegsitrationDto.setArtEligibilityDate(artBeneficiary.getArtEligibilityDate());
					artRegsitrationDto.setArtStartDate(artBeneficiary.getArtStartDate());
					Optional<MasterEntryPoint> masterEntryPointOpt = Optional.ofNullable(artBeneficiary.getEntryPointId());
					if (masterEntryPointOpt.isPresent()) {
						artRegsitrationDto.setEntryPointId(masterEntryPointOpt.get().getId());
					}

					Optional<MasterRiskFactor> masterRiskFactorOptional = Optional.ofNullable(artBeneficiary.getMasterRiskFactor());
					if (masterRiskFactorOptional.isPresent()) {
						artRegsitrationDto.setMasterRiskFactor(masterRiskFactorOptional.get().getId());
					}

				}


			}

			return artRegsitrationDto;
		}

		private void setBeneficiaryFaciltityMappingFields(Optional<Set<BeneficiaryFacilityMapping>> beneficiaryFacilityMappingsOpt, ArtRegistrationDto artRegistrationDto) {
			if(beneficiaryFacilityMappingsOpt.isPresent()){
				Set<BeneficiaryFacilityMapping> beneficiaryFacilityMappingSet = beneficiaryFacilityMappingsOpt.get();
				Optional<BeneficiaryFacilityMapping> BeneficiaryFacilityMappingOpt = beneficiaryFacilityMappingSet.stream().filter(t -> !(t.getIsDelete()) && t.getIsActive()).findFirst();
				if(BeneficiaryFacilityMappingOpt.isPresent()){
					BeneficiaryFacilityMapping beneficiaryFacilityMapping = BeneficiaryFacilityMappingOpt.get();
					artRegistrationDto.setPreviousClinic(beneficiaryFacilityMapping.getArtPreviousClinic());
					artRegistrationDto.setPatientPid(beneficiaryFacilityMapping.getPid());

					if(Optional.ofNullable(beneficiaryFacilityMapping.getPreviousNotTransferredArtId()).isPresent()) {
						artRegistrationDto.setPreviousNotTransferredArtId(beneficiaryFacilityMapping.getPreviousNotTransferredArtId().getId());
					}
				}

			}
		}

		private void setBeneficiaryDueListFields(Optional<Set<ArtBeneficiaryDueList>> beneficairyDueSet, ArtRegistrationDto artRegistrationDto) {
			if(beneficairyDueSet.isPresent()){
				Set<ArtBeneficiaryDueList> beneficiaryDueListSet = beneficairyDueSet.get();
				Optional<ArtBeneficiaryDueList> beneficiaryDueListOpt = beneficiaryDueListSet.stream().filter(t -> !(t.getIsVisited()) && !(t.getIsDelete()) &&t.getIsActive()).findFirst();
				if(beneficiaryDueListOpt.isPresent()) {
					ArtBeneficiaryDueList artBeneficiaryDueList = beneficiaryDueListOpt.get();
					artRegistrationDto.setNextVisitDate(artBeneficiaryDueList.getExpectedVisitDate());
					if(Optional.ofNullable(artBeneficiaryDueList.getEntryUser()).isPresent()) {
						artRegistrationDto.setAssignedTo(artBeneficiaryDueList.getEntryUser().getId());
					}
				}

			}
		}
		private void setBeneficiaryTransferFields(Optional<Set<Transfer>> transfersOpt, ArtRegistrationDto artRegistrationDto) {
			if(transfersOpt.isPresent()){
				Set<Transfer> transferSet = transfersOpt.get();
				Optional<Transfer> bnfTransferOpt = transferSet.stream().filter(t -> !(t.getIsDeleted()) && t.getIsActive()).findFirst();
				if(bnfTransferOpt.isPresent()){
					Transfer transfer = bnfTransferOpt.get();
					artRegistrationDto.setDestinationFacilityId(transfer.getFacilityTo().getId());
					Address facilityAddress = transfer.getFacilityTo().getAddress();
					artRegistrationDto.setTransferStateId(facilityAddress.getState().getId());
					artRegistrationDto.setTransferDistrictId(facilityAddress.getDistrict().getId());
				}

			}
		}
		private void setBeneficiaryReferralFields(Optional<Set<BeneficiaryReferral>> BeneficiaryReferralsOpt, ArtRegistrationDto artRegistrationDto) {
			if(BeneficiaryReferralsOpt.isPresent()){
				Set<BeneficiaryReferral> BeneficiaryReferralSet = BeneficiaryReferralsOpt.get();
				Optional<BeneficiaryReferral> bnfBeneficiaryReferralOpt = BeneficiaryReferralSet.stream().filter(t -> !(t.getIsDelete()) && t.getIsActive()).findFirst();
				if(bnfBeneficiaryReferralOpt.isPresent()){
					BeneficiaryReferral beneficiaryReferral = bnfBeneficiaryReferralOpt.get();
					artRegistrationDto.setRefferalStatusId(beneficiaryReferral.getBeneficiaryReferralStatusMaster().getId());
					artRegistrationDto.setReferTo(beneficiaryReferral.getFacility2().getId());

				}

			}
		}

		private void setFacilityLinkedBeneficiaryFields(Optional<Set> facilityLinkedBeneficiarySetOpt, ArtRegistrationDto artRegistrationDto) {
			if(facilityLinkedBeneficiarySetOpt.isPresent()){
				Set<FacilityLinkedFacilityBeneficiary> facilityLinkedFacilityBeneficiarySet = facilityLinkedBeneficiarySetOpt.get();
				Optional<FacilityLinkedFacilityBeneficiary> bnfTransferOpt = facilityLinkedFacilityBeneficiarySet.stream().filter(t -> !(t.getIsDelete()) && t.getIsActive()).findFirst();
				if(bnfTransferOpt.isPresent()){
					FacilityLinkedFacilityBeneficiary facilityLinkedBeneficiary = bnfTransferOpt.get();
					artRegistrationDto.setIsLinked(facilityLinkedBeneficiary.getIsLinked());
					artRegistrationDto.setLinkedFacilityId(facilityLinkedBeneficiary.getLinkedFacilityId().getId());
					artRegistrationDto.setLacName(facilityLinkedBeneficiary.getLinkedFacilityId().getName());

				}

			}
		}

		private void setBeneficiaryTransitFacilityFields(Optional<Set<BeneficiaryTransitFacility>> beneficiaryTransitFacilitySetOptional, ArtRegistrationDto artRegistrationDto) {
			if(beneficiaryTransitFacilitySetOptional.isPresent()){
				Set<BeneficiaryTransitFacility> beneficiaryTransitFacilitySet = beneficiaryTransitFacilitySetOptional.get();
				Optional<BeneficiaryTransitFacility> bnfTransferOpt = beneficiaryTransitFacilitySet.stream().filter(t -> !(t.getIsDelete()) && t.getIsActive()).findFirst();
				List<Long> transitFacilityList = new ArrayList<Long>();
				if(bnfTransferOpt.isPresent()){
					BeneficiaryTransitFacility beneficiaryTransitFacility = bnfTransferOpt.get();
					transitFacilityList.add(beneficiaryTransitFacility.getFacility().getId());
				}
				artRegistrationDto.setTransistFacilityId(transitFacilityList);
			}
		}
		
//		private ArtRegistrationDto setBeneficiaryDetailPerVisitFields(BeneficiaryDetailsPerVisit beneficiaryFinalVisitDetails, ArtRegistrationDto artRegsitrationDto) {
//
//			artRegsitrationDto.setWeight(beneficiaryFinalVisitDetails.getWeight());
//			artRegsitrationDto.setHeight(beneficiaryFinalVisitDetails.getHeight());
//			artRegsitrationDto.setIsPregnant(beneficiaryFinalVisitDetails.getIsPregnant());
//			artRegsitrationDto.setLmp(beneficiaryFinalVisitDetails.getLmp());
//			artRegsitrationDto.setPregnantCaseTypeId(beneficiaryFinalVisitDetails.getMasterPregnancyTypeCase().getId());
//			Optional<MasterPregnancyTypeCase> optionalPregnancyTypeCase = Optional.ofNullable(beneficiaryFinalVisitDetails.getMasterPregnancyTypeCase());
//			if(optionalPregnancyTypeCase.isPresent()) {
//				MasterPregnancyTypeCase pregnancyTypeCase = optionalPregnancyTypeCase.get();
//				artRegsitrationDto.setPregnantCaseTypeId(pregnancyTypeCase.getId());
//			}
//
//			return artRegsitrationDto;
//		}


		public List<LinkedFacilityBeneficiaryDto> getLacListByNormalSearch(String searchValue) {
			List<LinkedFacilityBeneficiaryDto> linkedFacilityBeneficiaryDto = new ArrayList<LinkedFacilityBeneficiaryDto>();
			List<LinkedFacilityBeneficiary> lacList = new ArrayList<LinkedFacilityBeneficiary>();
			Long facilityId = UserUtils.getLoggedInUserDetails().getFacilityId();
			if (searchValue != null && !searchValue.isEmpty()) {
				lacList = linkedFacilityBeneficiaryRepository.findlacBySearch(facilityId, searchValue.toLowerCase(),UserUtils.getLoggedInUserDetails().getFacilityTypeId());
			lacList.forEach(lacBeneficiaryList-> {
				LinkedFacilityBeneficiaryDto lacListDto = LinkedFacilityBeneficiaryMapper.mapLinkedFacilityBeneficiaryDto(lacBeneficiaryList);
				linkedFacilityBeneficiaryDto.add(lacListDto);
		    });
			
			}
			return linkedFacilityBeneficiaryDto;
		}


		public List<LinkedFacilityBeneficiaryDto> lacListByAdvanceSearch(Map<String, String> searchValue) {
			List<LinkedFacilityBeneficiaryDto> linkedFacilityBeneficiaryDto = new ArrayList<LinkedFacilityBeneficiaryDto>();
			List<LinkedFacilityBeneficiary> lacList = new ArrayList<LinkedFacilityBeneficiary>();
			Long facilityId = UserUtils.getLoggedInUserDetails().getFacilityId();
			List<String> searchQuery = LinkedFacilityBeneficiaryMapperUtil.queryCreaterForAdvanceSearch(searchValue,
					facilityId,UserUtils.getLoggedInUserDetails().getFacilityTypeId());
			if (!searchQuery.isEmpty()) {
				lacList = linkedFacilityBeneficiaryRepository.findLacListByAdvanceSearch(searchQuery.get(0));
				lacList.forEach(lacBeneficiaryList-> {
					LinkedFacilityBeneficiaryDto lacListDto = LinkedFacilityBeneficiaryMapper.mapLinkedFacilityBeneficiaryDto(lacBeneficiaryList);
					linkedFacilityBeneficiaryDto.add(lacListDto);
			    });
				
			}
			return linkedFacilityBeneficiaryDto;
		}


		public List<LinkedFacilityBeneficiaryDto> getAllLacBeneficiary() {
			List<LinkedFacilityBeneficiaryDto> linkedFacilityBeneficiaryDto = new ArrayList<LinkedFacilityBeneficiaryDto>();
			Long facilityId = UserUtils.getLoggedInUserDetails().getFacilityId();
			List<LinkedFacilityBeneficiary> lacList = linkedFacilityBeneficiaryRepository.findBeneficiaryList(facilityId);
			lacList.forEach(lacBeneficiaryList -> {
				Optional<ArtBeneficiary> artBeneficiaryOptional = artBeneficiaryRepository.findByBenId(lacBeneficiaryList.getBeneficiary().getId());
				ArtBeneficiary artBeneficiary = artBeneficiaryOptional.get();
				if(artBeneficiaryOptional.isPresent()) {
					
				LinkedFacilityBeneficiaryDto lacListDto = LinkedFacilityBeneficiaryMapper.mapLinkedFacilityBeneficiaryDto(lacBeneficiaryList);
				lacListDto.setStatus(artBeneficiary.getMasterArtBeneficiaryStatus().getName());
				linkedFacilityBeneficiaryDto.add(lacListDto);
				
				}
			});
			
			return linkedFacilityBeneficiaryDto;
			
			
			
		}


		public List<LinkedFacilityBeneficiaryDto> getLacBeneficiaryListByNormalSearch(String searchValue) {
			List<LinkedFacilityBeneficiaryDto> linkedFacilityBeneficiaryDto = new ArrayList<LinkedFacilityBeneficiaryDto>();
			List<LinkedFacilityBeneficiary> lacList = new ArrayList<LinkedFacilityBeneficiary>();
			Long facilityId = UserUtils.getLoggedInUserDetails().getFacilityId();
			if (searchValue != null && !searchValue.isEmpty()) {
				lacList = linkedFacilityBeneficiaryRepository.findlacBenListBySearch(facilityId, searchValue.toLowerCase());
			lacList.forEach(lacBeneficiaryList-> {
				Optional<ArtBeneficiary> artBeneficiaryOptional = artBeneficiaryRepository.findByBenId(lacBeneficiaryList.getBeneficiary().getId());
				ArtBeneficiary artBeneficiary = artBeneficiaryOptional.get();
				if(artBeneficiaryOptional.isPresent()) {
					
				LinkedFacilityBeneficiaryDto lacListDto = LinkedFacilityBeneficiaryMapper.mapLinkedFacilityBeneficiaryDto(lacBeneficiaryList);
				lacListDto.setStatus(artBeneficiary.getMasterArtBeneficiaryStatus().getName());
				linkedFacilityBeneficiaryDto.add(lacListDto);
				
				}
		    });
			
			}
			return linkedFacilityBeneficiaryDto;
		}


		public List<LinkedFacilityBeneficiaryDto> getLacBenListByAdvSearch(Map<String, String> searchValue) {
			List<LinkedFacilityBeneficiaryDto> linkedFacilityBeneficiaryDto = new ArrayList<LinkedFacilityBeneficiaryDto>();
			List<LinkedFacilityBeneficiary> lacList = new ArrayList<LinkedFacilityBeneficiary>();
			Long facilityId = UserUtils.getLoggedInUserDetails().getFacilityId();
			List<String> searchQuery = LinkedFacilityBeneficiaryMapperUtil.queryCreaterForBenListAdvanceSearch(searchValue,
					facilityId);
			if (!searchQuery.isEmpty()) {
				lacList = linkedFacilityBeneficiaryRepository.findLacListByAdvanceSearch(searchQuery.get(0));
				lacList.forEach(lacBeneficiaryList-> {
					Optional<ArtBeneficiary> artBeneficiaryOptional = artBeneficiaryRepository.findByBenId(lacBeneficiaryList.getBeneficiary().getId());
					ArtBeneficiary artBeneficiary = artBeneficiaryOptional.get();
					if(artBeneficiaryOptional.isPresent()) {
						
					LinkedFacilityBeneficiaryDto lacListDto = LinkedFacilityBeneficiaryMapper.mapLinkedFacilityBeneficiaryDto(lacBeneficiaryList);
					lacListDto.setStatus(artBeneficiary.getMasterArtBeneficiaryStatus().getName());
					linkedFacilityBeneficiaryDto.add(lacListDto);
					
					}
			    });
				
			}
			return linkedFacilityBeneficiaryDto;
		}


		public Boolean delinkLac(Long beneficiaryId, Long lacId) {
			if (beneficiaryId != null && beneficiaryId !=0 ) {
				Optional<LinkedFacilityBeneficiary> linkedfacilitybeneficiaryOptional = linkedFacilityBeneficiaryRepository.findLacByBeneficiaryId(beneficiaryId,lacId);
				LinkedFacilityBeneficiary linkedFacilityBeneficiary = linkedfacilitybeneficiaryOptional.get();
				Optional<ArtBeneficiary> artOptional = artBeneficiaryRepository.findBeneficiaryId(beneficiaryId);
				ArtBeneficiary artBeneficiary = artOptional.get();
				if(linkedfacilitybeneficiaryOptional.isPresent()) {
					linkedFacilityBeneficiary.setUnlinkDate(LocalDate.now());;
					linkedFacilityBeneficiary.setIsLinked(Boolean.FALSE);
					linkedFacilityBeneficiaryRepository.save(linkedFacilityBeneficiary);
					if(artOptional.isPresent()) {
						artBeneficiary.setLacLinked(Boolean.FALSE);
						artBeneficiaryRepository.save(artBeneficiary);
					}
				}
				return true;
			}
			else {
				return false;
			}
		}
		
		


		


}
