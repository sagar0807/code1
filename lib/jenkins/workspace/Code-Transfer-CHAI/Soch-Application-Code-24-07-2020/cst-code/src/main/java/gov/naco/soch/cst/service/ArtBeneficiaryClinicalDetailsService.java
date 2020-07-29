package gov.naco.soch.cst.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.naco.soch.cst.dto.ArtBeneficiaryClinicalDetailsDto;
import gov.naco.soch.cst.dto.ArtBeneficiaryCoexistingConditionDto;
import gov.naco.soch.cst.dto.ArtBeneficiaryContraceptionDto;
import gov.naco.soch.cst.dto.ArtBeneficiaryIptAttDetailsDto;
import gov.naco.soch.cst.dto.BeneficiarySocialWelfareDto;
import gov.naco.soch.cst.mapper.ArtBeneficiaryClinicalDetailsmapper;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.ArtBeneficiaryClinicalDetail;
import gov.naco.soch.entity.ArtBeneficiaryCoexistingCondition;
import gov.naco.soch.entity.ArtBeneficiaryContraception;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiarySocialWelfareScheme;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.MasterContraception;
import gov.naco.soch.entity.MasterDeliveryOutcome;
import gov.naco.soch.entity.MasterOtherAilment;
import gov.naco.soch.entity.MasterSocialWelfare;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.repository.ArtBeneficiaryClinicalDetailRepository;
import gov.naco.soch.repository.ArtBeneficiaryCoexistingConditionRepository;
import gov.naco.soch.repository.ArtBeneficiaryContraceptionRepository;
import gov.naco.soch.repository.BeneficiarySocialWelfareRepository;
import gov.naco.soch.repository.BeneficiaryVisitRegisterRepository;
import gov.naco.soch.util.UserUtils;

@Service
@Transactional
public class ArtBeneficiaryClinicalDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryClinicalDetailsService.class);

	@Autowired
	private ArtBeneficiaryClinicalDetailRepository artBeneficiaryClinicalDetailRepository;

	@Autowired
	private ArtBeneficiaryIptAttDetailService artBeneficiaryIptAttDetailService;

	@Autowired
	private ArtBeneficiaryContraceptionRepository contraceptionRepository;

	@Autowired
	private ArtBeneficiaryCoexistingConditionRepository coexistingConditionRepository;

	@Autowired
	private BeneficiarySocialWelfareRepository beneficiarySocialWelfareRepository;

	@Autowired
	private BeneficiaryVisitRegisterRepository beneficiaryVisitRegisterRepository;

	public ArtBeneficiaryClinicalDetailsDto getBeneficiaryClinicalDetailsForToday(Long beneficiaryId) {

		logger.debug("In getBeneficiaryClinicalDetailsForToday() of ArtBeneficiaryClinicalDetailsService");
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();

		Long visitRegisterId = VisitRegisterService.getVisitRegisterIdForToday(loginResponseDto.getFacilityId(),
				beneficiaryId);

		Optional<ArtBeneficiaryClinicalDetail> optClinicalDetails = artBeneficiaryClinicalDetailRepository
				.findByBeneficiaryIdAndVisitRegisterId(beneficiaryId, visitRegisterId);

		List<ArtBeneficiaryCoexistingCondition> coexistingConditionList = coexistingConditionRepository
				.findByVisitRegisterId(visitRegisterId);

		List<ArtBeneficiaryContraception> contraceptionList = contraceptionRepository
				.findByVisitRegisterId(visitRegisterId);

		ArtBeneficiaryClinicalDetailsDto dto = new ArtBeneficiaryClinicalDetailsDto();
		if (optClinicalDetails.isPresent()) {
			dto = ArtBeneficiaryClinicalDetailsmapper.mapArtBeneficiaryClinicalDetailToArtBeneficiaryClinicalDetailsDto(
					optClinicalDetails.get(), coexistingConditionList, contraceptionList);

		}

		ArtBeneficiaryIptAttDetailsDto tbOIInformation = artBeneficiaryIptAttDetailService
				.getBeneficiaryIptAttDetailsForToday(beneficiaryId);
		if (tbOIInformation != null) {
			dto.setTbOIInformations(tbOIInformation);
		}

		List<BeneficiarySocialWelfareScheme> socialWelfareSchemeList = beneficiarySocialWelfareRepository
				.findByBeneficiaryId(beneficiaryId);

		if (!CollectionUtils.isEmpty(socialWelfareSchemeList)) {
			List<BeneficiarySocialWelfareDto> socialWelfareSchemeDtoList = socialWelfareSchemeList.stream().map(s -> {
				BeneficiarySocialWelfareDto socialWelfareSchemeDto = new BeneficiarySocialWelfareDto();
				if (s.getMasterSocialWelfare() != null) {
					socialWelfareSchemeDto.setSocialWelfareId(s.getMasterSocialWelfare().getId());
					socialWelfareSchemeDto.setSocialWelfare(s.getMasterSocialWelfare().getName());
				}
				return socialWelfareSchemeDto;
			}).collect(Collectors.toList());
			dto.setSocialWelfareSchemes(socialWelfareSchemeDtoList);
		}

		Optional<BeneficiaryVisitRegister> optVisitDetails = beneficiaryVisitRegisterRepository
				.findById(visitRegisterId);

		if (optVisitDetails.isPresent()) {

			BeneficiaryVisitRegister visit = optVisitDetails.get();
			if (visit.getDeliveryOutcome() != null) {
				dto.setDeliveryOutcome(visit.getDeliveryOutcome().getId());
			}
			dto.setLastMenstrualPeriod(visit.getLmp());
			dto.setPregnantNow(visit.getIsPregnant());
		}

		return dto;
	}

	public ArtBeneficiaryClinicalDetailsDto saveBeneficiaryClinicalDetails(
			ArtBeneficiaryClinicalDetailsDto clinicalDetailsDto) {

		logger.debug("In saveBeneficiaryClinicalDetails() of ArtBeneficiaryClinicalDetailsService");

		if (clinicalDetailsDto.getRegimenId() == null) {
			throw new ServiceException("Regimen is required", null, HttpStatus.BAD_REQUEST);
		}

		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();

		Long visitRegisterId = VisitRegisterService.getVisitRegisterIdForToday(loginResponseDto.getFacilityId(),
				clinicalDetailsDto.getBeneficiaryId());

		Optional<BeneficiaryVisitRegister> optVisitDetails = beneficiaryVisitRegisterRepository
				.findById(visitRegisterId);

		if (optVisitDetails.isPresent()) {

			BeneficiaryVisitRegister visit = optVisitDetails.get();

			if (clinicalDetailsDto.getTbOIInformations() != null) {
				clinicalDetailsDto.getTbOIInformations().setBeneficiaryId(clinicalDetailsDto.getBeneficiaryId());
				artBeneficiaryIptAttDetailService
						.saveBeneficiaryIPTATTDetails(clinicalDetailsDto.getTbOIInformations());
			}

			if (clinicalDetailsDto.getDeliveryOutcome() != null) {
				MasterDeliveryOutcome masterDeliveryOutcome = new MasterDeliveryOutcome();
				masterDeliveryOutcome.setId(clinicalDetailsDto.getDeliveryOutcome());
				visit.setDeliveryOutcome(masterDeliveryOutcome);
			}

			visit.setLmp(clinicalDetailsDto.getLastMenstrualPeriod());
			visit.setIsPregnant(clinicalDetailsDto.getPregnantNow());

			visit = beneficiaryVisitRegisterRepository.save(visit);

			Optional<ArtBeneficiaryClinicalDetail> optClinicalDetails = artBeneficiaryClinicalDetailRepository
					.findByBeneficiaryIdAndVisitRegisterId(clinicalDetailsDto.getBeneficiaryId(), visitRegisterId);

			ArtBeneficiaryClinicalDetail clinicalDetails = ArtBeneficiaryClinicalDetailsmapper
					.mapArtBeneficiaryClinicalDetailDtoToArtBeneficiaryClinicalDetails(optClinicalDetails,
							clinicalDetailsDto, loginResponseDto.getUserId(), loginResponseDto.getFacilityId(), visit);

			artBeneficiaryClinicalDetailRepository.save(clinicalDetails);

			List<ArtBeneficiaryCoexistingCondition> oldCoexistingConditionList = coexistingConditionRepository
					.findByVisitRegisterId(visitRegisterId);
			coexistingConditionRepository.deleteAll(oldCoexistingConditionList);

			List<ArtBeneficiaryContraception> oldContraceptionList = contraceptionRepository
					.findByVisitRegisterId(visitRegisterId);
			contraceptionRepository.deleteAll(oldContraceptionList);

			List<ArtBeneficiaryCoexistingCondition> coexistingConditionList = new ArrayList<>();
			if (!CollectionUtils.isEmpty(clinicalDetailsDto.getCoexistingConditionsList())) {

				for (ArtBeneficiaryCoexistingConditionDto dto : clinicalDetailsDto.getCoexistingConditionsList()) {
					ArtBeneficiaryCoexistingCondition coexistingCondition = new ArtBeneficiaryCoexistingCondition();
					MasterOtherAilment otherAilment = new MasterOtherAilment();
					otherAilment.setId(dto.getOtherAilmentId());
					coexistingCondition.setMasterOtherAilment(otherAilment);
					coexistingCondition.setBeneficiaryVisitRegister(visit);
					coexistingCondition.setIsActive(Boolean.TRUE);
					coexistingCondition.setIsDelete(Boolean.FALSE);
					coexistingConditionList.add(coexistingCondition);
				}
				coexistingConditionRepository.saveAll(coexistingConditionList);
			}

			List<ArtBeneficiaryContraception> contraceptionList = new ArrayList<>();
			if (!CollectionUtils.isEmpty(clinicalDetailsDto.getContraceptionsList())) {
				for (ArtBeneficiaryContraceptionDto dto : clinicalDetailsDto.getContraceptionsList()) {
					ArtBeneficiaryContraception contraception = new ArtBeneficiaryContraception();
					MasterContraception masterContraception = new MasterContraception();
					masterContraception.setId(dto.getContraceptionId());
					contraception.setMasterContraception(masterContraception);
					contraception.setBeneficiaryVisitRegister(visit);
					contraception.setIsActive(Boolean.TRUE);
					contraception.setIsDelete(Boolean.FALSE);
					contraceptionList.add(contraception);
				}
				contraceptionRepository.saveAll(contraceptionList);
			}

			List<BeneficiarySocialWelfareScheme> existingSocialWelfareSchemeList = beneficiarySocialWelfareRepository
					.findByBeneficiaryId(visit.getBeneficiary().getId());
			beneficiarySocialWelfareRepository.deleteAll(existingSocialWelfareSchemeList);

			if (!CollectionUtils.isEmpty(clinicalDetailsDto.getSocialWelfareSchemes())) {
				Beneficiary beneficiary = visit.getBeneficiary();
				List<BeneficiarySocialWelfareScheme> socialWelfareSchemeList = clinicalDetailsDto
						.getSocialWelfareSchemes().stream().map(s -> {
							BeneficiarySocialWelfareScheme socialWelfareScheme = new BeneficiarySocialWelfareScheme();
							socialWelfareScheme.setBeneficiary(beneficiary);
							MasterSocialWelfare scheme = new MasterSocialWelfare();
							scheme.setId(s.getSocialWelfareId());
							socialWelfareScheme.setMasterSocialWelfare(scheme);
							return socialWelfareScheme;
						}).collect(Collectors.toList());
				beneficiarySocialWelfareRepository.saveAll(socialWelfareSchemeList);
			}
		} else {
			throw new ServiceException("Invalid visit register Id", null, HttpStatus.BAD_REQUEST);
		}
		return clinicalDetailsDto;
	}

}
