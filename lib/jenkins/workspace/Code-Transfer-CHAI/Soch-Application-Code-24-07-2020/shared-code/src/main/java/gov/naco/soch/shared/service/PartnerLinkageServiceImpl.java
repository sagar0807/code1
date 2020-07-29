package gov.naco.soch.shared.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.dto.PartnerLinkageDTO;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryFamilyDetail;
import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.repository.BeneficiaryFamilyDetailRepository;
import gov.naco.soch.repository.BeneficiaryReferralRepository;
import gov.naco.soch.repository.BeneficiaryRepository;
import gov.naco.soch.shared.dto.BeneficiaryReferralDto;
import gov.naco.soch.shared.dto.PartnerLinkageDto;
import gov.naco.soch.shared.dto.UnregisteredPartnerDto;
import gov.naco.soch.shared.mapper.PartnerLinkageMapper;
import gov.naco.soch.shared.mapper.UnregisteredPartnerMapper;

@Transactional
@Service
public class PartnerLinkageServiceImpl {

	private final Logger log = LoggerFactory.getLogger(PartnerLinkageServiceImpl.class);

	private final BeneficiaryFamilyDetailRepository beneficiaryFamilyDetailRepository;

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	@Autowired
	private BeneficiaryReferralRepository beneficiaryReferralRepository;

	private final PartnerLinkageMapper partnerLinkageMapper;

	public PartnerLinkageServiceImpl(BeneficiaryFamilyDetailRepository beneficiaryFamilyDetailRepository,
			PartnerLinkageMapper partnerLinkageMapper) {
		this.beneficiaryFamilyDetailRepository = beneficiaryFamilyDetailRepository;
		this.partnerLinkageMapper = partnerLinkageMapper;
	}

	public PartnerLinkageDTO save(PartnerLinkageDTO partnerLinkageDTO) {
		partnerLinkageDTO.setFamilyUid("F" + partnerLinkageDTO.getBeneficiary().getId());
		BeneficiaryFamilyDetail beneficiaryFamilyDetail = partnerLinkageMapper.toEntity(partnerLinkageDTO);
		beneficiaryFamilyDetail = beneficiaryFamilyDetailRepository.save(beneficiaryFamilyDetail);
		return partnerLinkageMapper.toDto(beneficiaryFamilyDetail);
	}

	public PartnerLinkageDTO update(PartnerLinkageDTO partnerLinkageDTO) {
		Optional<BeneficiaryFamilyDetail> benFamily = beneficiaryFamilyDetailRepository
				.findById(partnerLinkageDTO.getId());
		if (benFamily.isPresent()) {

			BeneficiaryFamilyDetail beneficiaryFamilyDetail = partnerLinkageMapper.toUpdateEntity(partnerLinkageDTO,
					benFamily.get());

			beneficiaryFamilyDetail = beneficiaryFamilyDetailRepository.save(beneficiaryFamilyDetail);

			return partnerLinkageMapper.toDto(beneficiaryFamilyDetail);
		}
		return null;
	}

	public void delete(Long id) {
		log.debug("Request to delete partner linkage : {}", id);
		Optional<BeneficiaryFamilyDetail> benFamilyDetail = beneficiaryFamilyDetailRepository.findById(id);
		if (benFamilyDetail.isPresent()) {
			BeneficiaryFamilyDetail beneficiaryFamilyDetail = benFamilyDetail.get();
			beneficiaryFamilyDetail.setIsDelete(true);
			beneficiaryFamilyDetailRepository.save(beneficiaryFamilyDetail);
		}

	}

	public boolean validateDuplicatePartner(Long beneficiaryId, Long partnerId) {
		boolean check = beneficiaryFamilyDetailRepository
				.existsByBeneficiary_IdAndPartnerBeneficiary_IdAndIsDelete(beneficiaryId, partnerId, false);
		return check;
	}

	public UnregisteredPartnerDto saveUnregisteredPartner(@Valid UnregisteredPartnerDto unregisteredPartnerDto) {
		Optional<Beneficiary> beneficiaryOptional = beneficiaryRepository
				.findById(unregisteredPartnerDto.getBeneficiaryId());
		if (beneficiaryOptional.isPresent()) {
			Beneficiary beneficiary = beneficiaryOptional.get();
			BeneficiaryFamilyDetail beneficiaryFamilyDetail = beneficiaryFamilyDetailRepository
					.findLatestByBeneficiary_Id(beneficiary.getId());
			beneficiaryFamilyDetail = UnregisteredPartnerMapper.mapUnregisteredPartnerDtoToBeneficiaryFamilyDetail(
					beneficiary, beneficiaryFamilyDetail, unregisteredPartnerDto);
			beneficiaryFamilyDetailRepository.save(beneficiaryFamilyDetail);
		}
		return unregisteredPartnerDto;
	}

	public List<PartnerLinkageDto> getPartnerLinkDetails(Long beneficiaryId) {

		List<BeneficiaryFamilyDetail> beneficiaryFamilyDetails = beneficiaryFamilyDetailRepository
				.findAllByBeneficiary_IdAndIsDelete(beneficiaryId, Boolean.FALSE);
		List<PartnerLinkageDto> partnerLinkageDtos = new ArrayList<PartnerLinkageDto>();
		beneficiaryFamilyDetails.forEach(beneficiaryFamilyDetail -> {
			PartnerLinkageDto partnerLinkageDetail = UnregisteredPartnerMapper
					.mapBeneficiaryFamilyDetailToPartnerLinkageDto(beneficiaryFamilyDetail);
			if (partnerLinkageDetail.getPartnerBeneficiaryId() != null) {
				List<BeneficiaryReferral> referrals = beneficiaryReferralRepository
						.findAllByBeneficiary_Id(partnerLinkageDetail.getPartnerBeneficiaryId());
				List<BeneficiaryReferralDto> referralDetails = UnregisteredPartnerMapper.mapReferralDetails(referrals);
				partnerLinkageDetail.setReferralDetails(referralDetails);
			}
			partnerLinkageDtos.add(partnerLinkageDetail);
		});
		return partnerLinkageDtos;
	}

}
