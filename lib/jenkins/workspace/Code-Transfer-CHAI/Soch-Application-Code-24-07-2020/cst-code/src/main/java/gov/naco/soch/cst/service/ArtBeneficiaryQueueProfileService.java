package gov.naco.soch.cst.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.naco.soch.cst.dto.ArtBeneficiaryConcurrentConditionDto;
import gov.naco.soch.cst.dto.ArtBeneficiaryOpportunisticInfectionDto;
import gov.naco.soch.cst.dto.ArtBeneficiaryQueueProfileDto;
import gov.naco.soch.cst.dto.ArtBeneficiarySideEffectDto;
import gov.naco.soch.cst.dto.BeneficiaryFourSSymptomsPerVisitDto;
import gov.naco.soch.cst.dto.BeneficiarySocialWelfareDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.ArtBeneficiaryClinicalDetail;
import gov.naco.soch.entity.ArtBeneficiaryConcurrentCondition;
import gov.naco.soch.entity.ArtBeneficiaryDueList;
import gov.naco.soch.entity.ArtBeneficiaryFollowup;
import gov.naco.soch.entity.ArtBeneficiaryOpportunisticInfection;
import gov.naco.soch.entity.ArtBeneficiaryQueue;
import gov.naco.soch.entity.ArtBeneficiarySideEffect;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryFourSSymptomsPerVisit;
import gov.naco.soch.entity.BeneficiarySocialWelfareScheme;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.MasterArtRegimenAction;
import gov.naco.soch.entity.MasterArtRegimenActionReasons;
import gov.naco.soch.entity.MasterClinicalStage;
import gov.naco.soch.entity.MasterFourSsymptom;
import gov.naco.soch.entity.MasterFunctionalStatus;
import gov.naco.soch.entity.MasterOpportunisticInfection;
import gov.naco.soch.entity.MasterOtherAilment;
import gov.naco.soch.entity.MasterSideEffect;
import gov.naco.soch.entity.MasterSocialWelfare;
import gov.naco.soch.entity.Regimen;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.repository.ArtBeneficiaryClinicalDetailRepository;
import gov.naco.soch.repository.ArtBeneficiaryConcurrentConditionRepository;
import gov.naco.soch.repository.ArtBeneficiaryDueListRepository;
import gov.naco.soch.repository.ArtBeneficiaryFollowupRepository;
import gov.naco.soch.repository.ArtBeneficiaryOpportunisticInfectionRepository;
import gov.naco.soch.repository.ArtBeneficiaryQueueRepository;
import gov.naco.soch.repository.ArtBeneficiarySideEffectRepository;
import gov.naco.soch.repository.BeneficiaryFourSSymptomsPerVisitRepository;
import gov.naco.soch.repository.BeneficiarySocialWelfareRepository;
import gov.naco.soch.repository.BeneficiaryVisitRegisterRepository;
import gov.naco.soch.util.UserUtils;

@Service
@Transactional
public class ArtBeneficiaryQueueProfileService {

	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryQueueProfileService.class);

	@Autowired
	private BeneficiaryVisitRegisterRepository beneficiaryVisitRegisterRepository;

	@Autowired
	private ArtBeneficiaryClinicalDetailRepository artBeneficiaryClinicalDetailRepository;

	@Autowired
	private ArtBeneficiaryFollowupRepository artBeneficiaryFollowupRepository;

	@Autowired
	private ArtBeneficiaryOpportunisticInfectionRepository opportunisticInfectionRepository;

	@Autowired
	private ArtBeneficiarySideEffectRepository sideEffectRepository;

	@Autowired
	private ArtBeneficiaryConcurrentConditionRepository concurrentConditionRepository;

	@Autowired
	private BeneficiaryFourSSymptomsPerVisitRepository beneficiaryFourSSymptomsPerVisitRepository;

	@Autowired
	private ArtBeneficiaryQueueRepository artBeneficiaryQueueRepository;

	@Autowired
	private ArtBeneficiaryDueListRepository artBeneficiaryDueListRepository;

	@Autowired
	private BeneficiarySocialWelfareRepository beneficiarySocialWelfareRepository;

	public ArtBeneficiaryQueueProfileDto getBeneficiaryQueueProfile(Long beneficiaryId) {

		ArtBeneficiaryQueueProfileDto dto = new ArtBeneficiaryQueueProfileDto();

		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		Long visitRegisterId = VisitRegisterService.getVisitRegisterIdForTodayExist(loginResponseDto.getFacilityId(),
				beneficiaryId);
		if (visitRegisterId != null) {

			Optional<BeneficiaryVisitRegister> optVisitDetails = beneficiaryVisitRegisterRepository
					.findById(visitRegisterId);
			if (optVisitDetails.isPresent()) {
				BeneficiaryVisitRegister visitDetails = optVisitDetails.get();

				dto.setVisitRegisterId(visitRegisterId);
				dto.setBeneficiaryId(visitDetails.getBeneficiary().getId());
				dto.setVisitDate(visitDetails.getVisitDate());
				dto.setLastVisitDate(visitDetails.getVisitDate());
				dto.setWeight(visitDetails.getWeight());
				dto.setHeight(visitDetails.getHeight());
				dto.setIsFourSSymptoms(visitDetails.getFoursSymptoms());
				if (visitDetails.getFoursSymptoms() != null && visitDetails.getFoursSymptoms()) {
					List<BeneficiaryFourSSymptomsPerVisit> fourSSymptoms = beneficiaryFourSSymptomsPerVisitRepository
							.findByVisitRegisterId(visitRegisterId);
					List<BeneficiaryFourSSymptomsPerVisitDto> fourSSymptomsPerVisitDtoList = fourSSymptoms.stream()
							.map(f -> {
								BeneficiaryFourSSymptomsPerVisitDto fourSSymptomsPerVisitDto = new BeneficiaryFourSSymptomsPerVisitDto();
								if (f.getMasterFourSSymptom() != null) {
									fourSSymptomsPerVisitDto.setFourSSymptomId(f.getMasterFourSSymptom().getId());
									fourSSymptomsPerVisitDto.setFourSSymptom(f.getMasterFourSSymptom().getName());
								}
								return fourSSymptomsPerVisitDto;
							}).collect(Collectors.toList());
					dto.setFourSSymptomsPerVisitList(fourSSymptomsPerVisitDtoList);
				}

				Optional<ArtBeneficiaryFollowup> optFollowUpDetails = artBeneficiaryFollowupRepository
						.findByVisitRegisterId(visitRegisterId);
				if (optFollowUpDetails.isPresent()) {
					ArtBeneficiaryFollowup followUpDetails = optFollowUpDetails.get();
					dto.setVisitDate(followUpDetails.getVisitDate());
					dto.setLastVisitDate(followUpDetails.getVisitDate());
					dto.setPillsRemaining(followUpDetails.getRemainingPills());
					dto.setAdherenceToArt(followUpDetails.getAdherenceToArt());
					dto.setAnyOtherMedicine(followUpDetails.getAnyOtherMedicine());
					if (followUpDetails.getFunctionalStatusId() != null) {
						dto.setFunctionalStatusId(followUpDetails.getFunctionalStatusId().getId());
						dto.setFunctionalStatus(followUpDetails.getFunctionalStatusId().getName());
					}
					if (followUpDetails.getClinicalStageId() != null) {
						dto.setClinicalStageId(followUpDetails.getClinicalStageId().getId());
						dto.setClinicalStage(followUpDetails.getClinicalStageId().getName());
					}
				}

				List<ArtBeneficiaryOpportunisticInfection> opportunisticInfectionList = opportunisticInfectionRepository
						.findByVisitRegisterId(visitRegisterId);

				if (!CollectionUtils.isEmpty(opportunisticInfectionList)) {
					List<ArtBeneficiaryOpportunisticInfectionDto> opportunisticInfectionDtoList = opportunisticInfectionList
							.stream().map(oi -> {
								ArtBeneficiaryOpportunisticInfectionDto opportunisticInfectionDto = new ArtBeneficiaryOpportunisticInfectionDto();
								if (oi.getMasterOpportunisticInfection() != null) {
									opportunisticInfectionDto
											.setOpportunisticInfectionId(oi.getMasterOpportunisticInfection().getId());
									opportunisticInfectionDto
											.setOpportunisticInfection(oi.getMasterOpportunisticInfection().getName());
								}
								return opportunisticInfectionDto;
							}).collect(Collectors.toList());
					dto.setOpportunisticInfectionList(opportunisticInfectionDtoList);
				}

				List<ArtBeneficiarySideEffect> sideEffectList = sideEffectRepository
						.findByVisitRegisterId(visitRegisterId);
				if (!CollectionUtils.isEmpty(sideEffectList)) {
					List<ArtBeneficiarySideEffectDto> sideEffectDtoList = sideEffectList.stream().map(s -> {
						ArtBeneficiarySideEffectDto sideEffectDto = new ArtBeneficiarySideEffectDto();
						if (s.getMasterSideEffect() != null) {
							sideEffectDto.setSideEffectId(s.getMasterSideEffect().getId());
							sideEffectDto.setSideEffect(s.getMasterSideEffect().getName());
						}
						return sideEffectDto;
					}).collect(Collectors.toList());
					dto.setArtSideEffectsList(sideEffectDtoList);
				}

				List<ArtBeneficiaryConcurrentCondition> concurrentConditionList = concurrentConditionRepository
						.findByVisitRegisterId(visitRegisterId);
				if (!CollectionUtils.isEmpty(concurrentConditionList)) {
					List<ArtBeneficiaryConcurrentConditionDto> concurrentConditionDtoList = concurrentConditionList
							.stream().map(c -> {
								ArtBeneficiaryConcurrentConditionDto concurrentConditionDto = new ArtBeneficiaryConcurrentConditionDto();
								if (c.getMasterOtherAilment() != null) {
									concurrentConditionDto.setConcurrentConditionId(c.getMasterOtherAilment().getId());
									concurrentConditionDto.setConcurrentCondition(c.getMasterOtherAilment().getName());
								}
								return concurrentConditionDto;
							}).collect(Collectors.toList());
					dto.setConcurrentConditionList(concurrentConditionDtoList);
				}

				List<BeneficiarySocialWelfareScheme> socialWelfareSchemeList = beneficiarySocialWelfareRepository
						.findByBeneficiaryId(beneficiaryId);

				if (!CollectionUtils.isEmpty(socialWelfareSchemeList)) {
					List<BeneficiarySocialWelfareDto> socialWelfareSchemeDtoList = socialWelfareSchemeList.stream()
							.map(s -> {
								BeneficiarySocialWelfareDto socialWelfareSchemeDto = new BeneficiarySocialWelfareDto();
								if (s.getMasterSocialWelfare() != null) {
									socialWelfareSchemeDto.setSocialWelfareId(s.getMasterSocialWelfare().getId());
									socialWelfareSchemeDto.setSocialWelfare(s.getMasterSocialWelfare().getName());
								}
								return socialWelfareSchemeDto;
							}).collect(Collectors.toList());
					dto.setSocialWelfareSchemes(socialWelfareSchemeDtoList);
				}

				// regimen from clinical details

				// tb regimen from art_beneficiary_ipt_att_details

			}
		}
		return dto;
	}

	public ArtBeneficiaryQueueProfileDto saveBeneficiaryQueueProfileCounsellor(
			ArtBeneficiaryQueueProfileDto profileDetails) {

		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		Long visitRegisterId = VisitRegisterService.getVisitRegisterIdForToday(loginResponseDto.getFacilityId(),
				profileDetails.getBeneficiaryId());

		Optional<BeneficiaryVisitRegister> optVisitDetails = beneficiaryVisitRegisterRepository
				.findById(visitRegisterId);
		if (optVisitDetails.isPresent()) {
			BeneficiaryVisitRegister visitDetails = optVisitDetails.get();

			UserMaster entryUser = new UserMaster();
			entryUser.setId(loginResponseDto.getUserId());

			visitDetails.setWeight(profileDetails.getWeight());
			visitDetails.setHeight(profileDetails.getHeight());

			Optional<ArtBeneficiaryFollowup> optFollowUpDetails = artBeneficiaryFollowupRepository
					.findByVisitRegisterId(visitRegisterId);
			ArtBeneficiaryFollowup followUpDetails = null;

			if (optFollowUpDetails.isPresent()) {
				followUpDetails = optFollowUpDetails.get();
			} else {
				followUpDetails = new ArtBeneficiaryFollowup();
			}

			followUpDetails.setBeneficiaryVisitRegister(visitDetails);
			followUpDetails.setBeneficiary(visitDetails.getBeneficiary());
			followUpDetails.setVisitDate(profileDetails.getVisitDate());
			followUpDetails.setRemainingPills(profileDetails.getPillsRemaining());
			followUpDetails.setAdherenceToArt(profileDetails.getAdherenceToArt());
			followUpDetails.setAnyOtherMedicine(profileDetails.getAnyOtherMedicine());
			followUpDetails.setEntryUser(entryUser);
			followUpDetails.setTbTreatment(profileDetails.getTbTreatment());
			if (profileDetails.getFunctionalStatusId() != null) {
				MasterFunctionalStatus masterFunctionalStatus = new MasterFunctionalStatus();
				masterFunctionalStatus.setId(profileDetails.getFunctionalStatusId());
				followUpDetails.setFunctionalStatusId(masterFunctionalStatus);
			} else {
				followUpDetails.setFunctionalStatusId(null);
			}
			if (profileDetails.getClinicalStageId() != null) {
				MasterClinicalStage masterClinicalStage = new MasterClinicalStage();
				masterClinicalStage.setId(profileDetails.getClinicalStageId());
				followUpDetails.setClinicalStageId(masterClinicalStage);
			} else {
				followUpDetails.setClinicalStageId(null);
			}
			followUpDetails.setIsActive(Boolean.TRUE);
			followUpDetails.setIsDelete(Boolean.FALSE);
			followUpDetails
					.setDrugsPrescribedForOpportunisticInfectionsProphylaxis(profileDetails.getDrugspPrescribedForOI());

			artBeneficiaryFollowupRepository.save(followUpDetails);

			List<ArtBeneficiarySideEffect> oldSideEffectList = sideEffectRepository
					.findByVisitRegisterId(visitRegisterId);
			sideEffectRepository.deleteAll(oldSideEffectList);

			if (!CollectionUtils.isEmpty(profileDetails.getArtSideEffectsList())) {
				List<ArtBeneficiarySideEffect> sideEffectList = profileDetails.getArtSideEffectsList().stream()
						.map(s -> {
							ArtBeneficiarySideEffect sideEffect = new ArtBeneficiarySideEffect();
							sideEffect.setBeneficiaryVisitRegister(visitDetails);
							MasterSideEffect masterSideEffect = new MasterSideEffect();
							masterSideEffect.setId(s.getSideEffectId());
							sideEffect.setMasterSideEffect(masterSideEffect);
							sideEffect.setIsActive(Boolean.TRUE);
							sideEffect.setIsDelete(Boolean.FALSE);
							return sideEffect;
						}).collect(Collectors.toList());
				sideEffectRepository.saveAll(sideEffectList);
			}

			List<ArtBeneficiaryConcurrentCondition> oldConcurrentConditionList = concurrentConditionRepository
					.findByVisitRegisterId(visitRegisterId);
			concurrentConditionRepository.deleteAll(oldConcurrentConditionList);
			if (!CollectionUtils.isEmpty(profileDetails.getConcurrentConditionList())) {
				List<ArtBeneficiaryConcurrentCondition> concurrentConditionList = profileDetails
						.getConcurrentConditionList().stream().map(c -> {
							ArtBeneficiaryConcurrentCondition concurrentCondition = new ArtBeneficiaryConcurrentCondition();
							concurrentCondition.setBeneficiaryVisitRegister(visitDetails);
							MasterOtherAilment masterOtherAilment = new MasterOtherAilment();
							masterOtherAilment.setId(c.getConcurrentConditionId());
							concurrentCondition.setMasterOtherAilment(masterOtherAilment);
							concurrentCondition.setIsActive(Boolean.TRUE);
							concurrentCondition.setIsDelete(Boolean.FALSE);
							return concurrentCondition;
						}).collect(Collectors.toList());
				concurrentConditionRepository.saveAll(concurrentConditionList);
			}

			List<ArtBeneficiaryOpportunisticInfection> oldOpportunisticInfectionList = opportunisticInfectionRepository
					.findByVisitRegisterId(visitRegisterId);
			opportunisticInfectionRepository.deleteAll(oldOpportunisticInfectionList);

			if (!CollectionUtils.isEmpty(profileDetails.getOpportunisticInfectionList())) {

				List<ArtBeneficiaryOpportunisticInfection> opportunisticInfectionList = profileDetails
						.getOpportunisticInfectionList().stream().map(oi -> {
							ArtBeneficiaryOpportunisticInfection opportunisticInfection = new ArtBeneficiaryOpportunisticInfection();
							MasterOpportunisticInfection masterOpportunisticInfection = new MasterOpportunisticInfection();
							masterOpportunisticInfection.setId(oi.getOpportunisticInfectionId());
							opportunisticInfection.setBeneficiaryVisitRegister(visitDetails);
							opportunisticInfection.setMasterOpportunisticInfection(masterOpportunisticInfection);
							opportunisticInfection.setIsActive(Boolean.TRUE);
							opportunisticInfection.setIsDelete(Boolean.FALSE);
							return opportunisticInfection;
						}).collect(Collectors.toList());
				opportunisticInfectionRepository.saveAll(opportunisticInfectionList);
			}

			List<BeneficiarySocialWelfareScheme> existingSocialWelfareSchemeList = beneficiarySocialWelfareRepository
					.findByBeneficiaryId(visitDetails.getBeneficiary().getId());
			beneficiarySocialWelfareRepository.deleteAll(existingSocialWelfareSchemeList);

			if (!CollectionUtils.isEmpty(profileDetails.getSocialWelfareSchemes())) {
				Beneficiary beneficiary = visitDetails.getBeneficiary();
				List<BeneficiarySocialWelfareScheme> socialWelfareSchemeList = profileDetails.getSocialWelfareSchemes()
						.stream().map(s -> {
							BeneficiarySocialWelfareScheme socialWelfareScheme = new BeneficiarySocialWelfareScheme();
							socialWelfareScheme.setBeneficiary(beneficiary);
							MasterSocialWelfare scheme = new MasterSocialWelfare();
							scheme.setId(s.getSocialWelfareId());
							socialWelfareScheme.setMasterSocialWelfare(scheme);
							return socialWelfareScheme;
						}).collect(Collectors.toList());
				beneficiarySocialWelfareRepository.saveAll(socialWelfareSchemeList);
			}

			Facility facility = new Facility();
			facility.setId(loginResponseDto.getFacilityId());

			logger.debug("Adding to beneficiary queue list");

			Optional<ArtBeneficiaryQueue> currentQueueOpt = artBeneficiaryQueueRepository.findBeneficiaryAssignedTo(
					visitDetails.getBeneficiary().getId(), loginResponseDto.getUserId(),
					loginResponseDto.getFacilityId(), LocalDate.now());
			if (currentQueueOpt.isPresent()) {
				ArtBeneficiaryQueue currentQueue = currentQueueOpt.get();
				currentQueue.setIsVisited(Boolean.TRUE);
				artBeneficiaryQueueRepository.save(currentQueue);
			}

			if (profileDetails.getNextUserId() != null) {

//				Optional<ArtBeneficiaryQueue> beneficiaryQueueOptional = artBeneficiaryQueueRepository
//						.findByVisitRegisterId(visitDetails.getId());
//				if (beneficiaryQueueOptional.isPresent()) {
//					ArtBeneficiaryQueue beneficiaryQueue = beneficiaryQueueOptional.get();
//					beneficiaryQueue.setIsVisited(Boolean.TRUE);
//					artBeneficiaryQueueRepository.save(beneficiaryQueue);
//				}

				UserMaster nextUser = new UserMaster();
				nextUser.setId(profileDetails.getNextUserId());
				ArtBeneficiaryQueue artBeneficiaryQueue = new ArtBeneficiaryQueue();
				artBeneficiaryQueue.setAssignedToUser(nextUser);
				artBeneficiaryQueue.setEntryUser(entryUser);
				artBeneficiaryQueue.setFacility(facility);
				artBeneficiaryQueue.setVisitDate(LocalDate.now());
				artBeneficiaryQueue.setIsVisited(false);
				artBeneficiaryQueue.setIsActive(true);
				artBeneficiaryQueue.setIsDelete(false);
				artBeneficiaryQueue.setBeneficiary(visitDetails.getBeneficiary());
				artBeneficiaryQueue.setBeneficiaryVisitRegister(visitDetails);
				artBeneficiaryQueueRepository.save(artBeneficiaryQueue);
			}

			if (profileDetails.getNextVisitDate() != null) {
				logger.debug("Adding to benificiary due list");
				ArtBeneficiaryDueList artBeneficiaryDueList = new ArtBeneficiaryDueList();
				artBeneficiaryDueList.setIsDelete(false);
				artBeneficiaryDueList.setIsActive(true);
				artBeneficiaryDueList.setIsVisited(false);
				artBeneficiaryDueList.setExpectedVisitDate(profileDetails.getNextVisitDate());
				artBeneficiaryDueList.setVisitedDate(LocalDate.now());
				artBeneficiaryDueList.setEntryUser(entryUser);
				artBeneficiaryDueList.setBeneficiary(visitDetails.getBeneficiary());
				artBeneficiaryDueList.setFacility(facility);
				artBeneficiaryDueList.setBeneficiaryVisitRegister(visitDetails);
				artBeneficiaryDueListRepository.save(artBeneficiaryDueList);
			}

			beneficiaryVisitRegisterRepository.save(visitDetails);
			profileDetails.setVisitRegisterId(visitRegisterId);
		}

		return profileDetails;
	}

	public ArtBeneficiaryQueueProfileDto saveBeneficiaryQueueProfileForMO(
			ArtBeneficiaryQueueProfileDto profileDetails) {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		Long visitRegisterId = VisitRegisterService.getVisitRegisterIdForToday(loginResponseDto.getFacilityId(),
				profileDetails.getBeneficiaryId());

		Optional<BeneficiaryVisitRegister> optVisitDetails = beneficiaryVisitRegisterRepository
				.findById(visitRegisterId);
		if (optVisitDetails.isPresent()) {
			BeneficiaryVisitRegister visitDetails = optVisitDetails.get();

			UserMaster entryUser = new UserMaster();
			entryUser.setId(loginResponseDto.getUserId());

			Facility facility = new Facility();
			facility.setId(loginResponseDto.getFacilityId());

			visitDetails.setWeight(profileDetails.getWeight());
			visitDetails.setHeight(profileDetails.getHeight());

			Optional<ArtBeneficiaryFollowup> optFollowUpDetails = artBeneficiaryFollowupRepository
					.findByVisitRegisterId(visitRegisterId);
			ArtBeneficiaryFollowup followUpDetails = null;

			if (optFollowUpDetails.isPresent()) {
				followUpDetails = optFollowUpDetails.get();
			} else {
				followUpDetails = new ArtBeneficiaryFollowup();
			}

			followUpDetails.setBeneficiaryVisitRegister(visitDetails);
			followUpDetails.setBeneficiary(visitDetails.getBeneficiary());
			followUpDetails.setVisitDate(profileDetails.getVisitDate());
			followUpDetails.setRemainingPills(profileDetails.getPillsRemaining());
			followUpDetails.setAdherenceToArt(profileDetails.getAdherenceToArt());
			followUpDetails.setAnyOtherMedicine(profileDetails.getAnyOtherMedicine());
			followUpDetails.setEntryUser(entryUser);
			followUpDetails.setTbTreatment(profileDetails.getTbTreatment());
			if (profileDetails.getFunctionalStatusId() != null) {
				MasterFunctionalStatus masterFunctionalStatus = new MasterFunctionalStatus();
				masterFunctionalStatus.setId(profileDetails.getFunctionalStatusId());
				followUpDetails.setFunctionalStatusId(masterFunctionalStatus);
			} else {
				followUpDetails.setFunctionalStatusId(null);
			}
			if (profileDetails.getClinicalStageId() != null) {
				MasterClinicalStage masterClinicalStage = new MasterClinicalStage();
				masterClinicalStage.setId(profileDetails.getClinicalStageId());
				followUpDetails.setClinicalStageId(masterClinicalStage);
			} else {
				followUpDetails.setClinicalStageId(null);
			}
			followUpDetails.setIsActive(Boolean.TRUE);
			followUpDetails.setIsDelete(Boolean.FALSE);
			followUpDetails
					.setDrugsPrescribedForOpportunisticInfectionsProphylaxis(profileDetails.getDrugspPrescribedForOI());

			artBeneficiaryFollowupRepository.save(followUpDetails);

			List<ArtBeneficiarySideEffect> oldSideEffectList = sideEffectRepository
					.findByVisitRegisterId(visitRegisterId);
			sideEffectRepository.deleteAll(oldSideEffectList);

			if (!CollectionUtils.isEmpty(profileDetails.getArtSideEffectsList())) {
				List<ArtBeneficiarySideEffect> sideEffectList = profileDetails.getArtSideEffectsList().stream()
						.map(s -> {
							ArtBeneficiarySideEffect sideEffect = new ArtBeneficiarySideEffect();
							sideEffect.setBeneficiaryVisitRegister(visitDetails);
							MasterSideEffect masterSideEffect = new MasterSideEffect();
							masterSideEffect.setId(s.getSideEffectId());
							sideEffect.setMasterSideEffect(masterSideEffect);
							sideEffect.setIsActive(Boolean.TRUE);
							sideEffect.setIsDelete(Boolean.FALSE);
							return sideEffect;
						}).collect(Collectors.toList());
				sideEffectRepository.saveAll(sideEffectList);
			}

			List<ArtBeneficiaryConcurrentCondition> oldConcurrentConditionList = concurrentConditionRepository
					.findByVisitRegisterId(visitRegisterId);
			concurrentConditionRepository.deleteAll(oldConcurrentConditionList);
			if (!CollectionUtils.isEmpty(profileDetails.getConcurrentConditionList())) {
				List<ArtBeneficiaryConcurrentCondition> concurrentConditionList = profileDetails
						.getConcurrentConditionList().stream().map(c -> {
							ArtBeneficiaryConcurrentCondition concurrentCondition = new ArtBeneficiaryConcurrentCondition();
							concurrentCondition.setBeneficiaryVisitRegister(visitDetails);
							MasterOtherAilment masterOtherAilment = new MasterOtherAilment();
							masterOtherAilment.setId(c.getConcurrentConditionId());
							concurrentCondition.setMasterOtherAilment(masterOtherAilment);
							concurrentCondition.setIsActive(Boolean.TRUE);
							concurrentCondition.setIsDelete(Boolean.FALSE);
							return concurrentCondition;
						}).collect(Collectors.toList());
				concurrentConditionRepository.saveAll(concurrentConditionList);
			}

			List<BeneficiarySocialWelfareScheme> existingSocialWelfareSchemeList = beneficiarySocialWelfareRepository
					.findByBeneficiaryId(visitDetails.getBeneficiary().getId());
			beneficiarySocialWelfareRepository.deleteAll(existingSocialWelfareSchemeList);

			if (!CollectionUtils.isEmpty(profileDetails.getSocialWelfareSchemes())) {
				Beneficiary beneficiary = visitDetails.getBeneficiary();
				List<BeneficiarySocialWelfareScheme> socialWelfareSchemeList = profileDetails.getSocialWelfareSchemes()
						.stream().map(s -> {
							BeneficiarySocialWelfareScheme socialWelfareScheme = new BeneficiarySocialWelfareScheme();
							socialWelfareScheme.setBeneficiary(beneficiary);
							MasterSocialWelfare scheme = new MasterSocialWelfare();
							scheme.setId(s.getSocialWelfareId());
							socialWelfareScheme.setMasterSocialWelfare(scheme);
							return socialWelfareScheme;
						}).collect(Collectors.toList());
				beneficiarySocialWelfareRepository.saveAll(socialWelfareSchemeList);
			}

			// regimen from clinical details
			Optional<ArtBeneficiaryClinicalDetail> optClinicalDetails = artBeneficiaryClinicalDetailRepository
					.findByBeneficiaryIdAndVisitRegisterId(profileDetails.getBeneficiaryId(), visitRegisterId);

			if (optClinicalDetails.isPresent()) {

				ArtBeneficiaryClinicalDetail clinicalDetails = optClinicalDetails.get();

				if (profileDetails.getNewRegimenId() != null) {
					Regimen regimen = new Regimen();
					regimen.setId(profileDetails.getNewRegimenId());
					clinicalDetails.setRegimen(regimen);
				}

				if (profileDetails.getArtRegimenActionId() != null) {
					MasterArtRegimenAction action = new MasterArtRegimenAction();
					action.setId(profileDetails.getArtRegimenActionId());
					clinicalDetails.setArtRegimenAction(action);
				}

				if (profileDetails.getArtRegimenActionReasonId() != null) {
					MasterArtRegimenActionReasons reason = new MasterArtRegimenActionReasons();
					reason.setId(profileDetails.getArtRegimenActionReasonId());
					clinicalDetails.setArtRegimenActionReason(reason);
				}
				artBeneficiaryClinicalDetailRepository.save(clinicalDetails);
			} else {

				ArtBeneficiaryClinicalDetail clinicalDetails = new ArtBeneficiaryClinicalDetail();
				clinicalDetails.setBeneficiary(visitDetails.getBeneficiary());
				clinicalDetails.setBeneficiaryVisitRegister(visitDetails);

				clinicalDetails.setEntryDate(LocalDate.now());
				clinicalDetails.setEntryUser(entryUser);
				clinicalDetails.setFacility(facility);
				clinicalDetails.setIsActive(Boolean.TRUE);
				clinicalDetails.setIsDelete(Boolean.FALSE);

				if (profileDetails.getNewRegimenId() != null) {
					Regimen regimen = new Regimen();
					regimen.setId(profileDetails.getNewRegimenId());
					clinicalDetails.setRegimen(regimen);
				}

				if (profileDetails.getArtRegimenActionId() != null) {
					MasterArtRegimenAction action = new MasterArtRegimenAction();
					action.setId(profileDetails.getArtRegimenActionId());
					clinicalDetails.setArtRegimenAction(action);
				}

				if (profileDetails.getArtRegimenActionReasonId() != null) {
					MasterArtRegimenActionReasons reason = new MasterArtRegimenActionReasons();
					reason.setId(profileDetails.getArtRegimenActionReasonId());
					clinicalDetails.setArtRegimenActionReason(reason);
				}

				artBeneficiaryClinicalDetailRepository.save(clinicalDetails);
			}

			// tb regimen from art_beneficiary_ipt_att_details

			List<ArtBeneficiaryOpportunisticInfection> oldOpportunisticInfectionList = opportunisticInfectionRepository
					.findByVisitRegisterId(visitRegisterId);
			opportunisticInfectionRepository.deleteAll(oldOpportunisticInfectionList);

			if (!CollectionUtils.isEmpty(profileDetails.getOpportunisticInfectionList())) {

				List<ArtBeneficiaryOpportunisticInfection> opportunisticInfectionList = profileDetails
						.getOpportunisticInfectionList().stream().map(oi -> {
							ArtBeneficiaryOpportunisticInfection opportunisticInfection = new ArtBeneficiaryOpportunisticInfection();
							MasterOpportunisticInfection masterOpportunisticInfection = new MasterOpportunisticInfection();
							masterOpportunisticInfection.setId(oi.getOpportunisticInfectionId());
							opportunisticInfection.setBeneficiaryVisitRegister(visitDetails);
							opportunisticInfection.setMasterOpportunisticInfection(masterOpportunisticInfection);
							opportunisticInfection.setIsActive(Boolean.TRUE);
							opportunisticInfection.setIsDelete(Boolean.FALSE);
							return opportunisticInfection;
						}).collect(Collectors.toList());
				opportunisticInfectionRepository.saveAll(opportunisticInfectionList);
			}

			visitDetails.setFoursSymptoms(Boolean.FALSE);

			List<BeneficiaryFourSSymptomsPerVisit> oldFourSSymptoms = beneficiaryFourSSymptomsPerVisitRepository
					.findByVisitRegisterId(visitRegisterId);
			beneficiaryFourSSymptomsPerVisitRepository.deleteAll(oldFourSSymptoms);

			if (!CollectionUtils.isEmpty(profileDetails.getFourSSymptomsPerVisitList())) {
				visitDetails.setFoursSymptoms(Boolean.TRUE);
				List<BeneficiaryFourSSymptomsPerVisit> fourSSymptomsPerVisitList = profileDetails
						.getFourSSymptomsPerVisitList().stream().map(f -> {
							BeneficiaryFourSSymptomsPerVisit fourSSymptomsPerVisit = new BeneficiaryFourSSymptomsPerVisit();
							fourSSymptomsPerVisit.setBeneficiaryVisitRegister(visitDetails);
							MasterFourSsymptom fourSSymptom = new MasterFourSsymptom();
							fourSSymptom.setId(f.getFourSSymptomId());
							fourSSymptomsPerVisit.setMasterFourSSymptom(fourSSymptom);
							fourSSymptom.setIsActive(Boolean.TRUE);
							fourSSymptom.setIsDelete(Boolean.FALSE);
							return fourSSymptomsPerVisit;
						}).collect(Collectors.toList());

				beneficiaryFourSSymptomsPerVisitRepository.saveAll(fourSSymptomsPerVisitList);
			}

			logger.debug("Adding to beneficiary queue list");

			Optional<ArtBeneficiaryQueue> currentQueueOpt = artBeneficiaryQueueRepository.findBeneficiaryAssignedTo(
					visitDetails.getBeneficiary().getId(), loginResponseDto.getUserId(),
					loginResponseDto.getFacilityId(), LocalDate.now());
			if (currentQueueOpt.isPresent()) {
				ArtBeneficiaryQueue currentQueue = currentQueueOpt.get();
				currentQueue.setIsVisited(Boolean.TRUE);
				artBeneficiaryQueueRepository.save(currentQueue);
			}

			if (profileDetails.getNextUserId() != null) {

//				Optional<ArtBeneficiaryQueue> beneficiaryQueueOptional = artBeneficiaryQueueRepository
//						.findByVisitRegisterId(visitDetails.getId());
//				if (beneficiaryQueueOptional.isPresent()) {
//					ArtBeneficiaryQueue beneficiaryQueue = beneficiaryQueueOptional.get();
//					beneficiaryQueue.setIsVisited(Boolean.TRUE);
//					artBeneficiaryQueueRepository.save(beneficiaryQueue);
//				}

				UserMaster nextUser = new UserMaster();
				nextUser.setId(profileDetails.getNextUserId());

				ArtBeneficiaryQueue artBeneficiaryQueue = new ArtBeneficiaryQueue();
				artBeneficiaryQueue.setAssignedToUser(nextUser);
				artBeneficiaryQueue.setEntryUser(entryUser);
				artBeneficiaryQueue.setFacility(facility);
				artBeneficiaryQueue.setVisitDate(LocalDate.now());
				artBeneficiaryQueue.setIsVisited(false);
				artBeneficiaryQueue.setIsActive(true);
				artBeneficiaryQueue.setIsDelete(false);
				artBeneficiaryQueue.setBeneficiary(visitDetails.getBeneficiary());
				artBeneficiaryQueue.setBeneficiaryVisitRegister(visitDetails);
				artBeneficiaryQueueRepository.save(artBeneficiaryQueue);
			}

			if (profileDetails.getNextVisitDate() != null) {
				logger.debug("Adding to benificiary due list");
				ArtBeneficiaryDueList artBeneficiaryDueList = new ArtBeneficiaryDueList();
				artBeneficiaryDueList.setIsDelete(false);
				artBeneficiaryDueList.setIsActive(true);
				artBeneficiaryDueList.setIsVisited(false);
				artBeneficiaryDueList.setExpectedVisitDate(profileDetails.getNextVisitDate());
				artBeneficiaryDueList.setVisitedDate(LocalDate.now());
				artBeneficiaryDueList.setEntryUser(entryUser);
				artBeneficiaryDueList.setBeneficiary(visitDetails.getBeneficiary());
				artBeneficiaryDueList.setFacility(facility);
				artBeneficiaryDueList.setBeneficiaryVisitRegister(visitDetails);
				artBeneficiaryDueListRepository.save(artBeneficiaryDueList);
			}

			beneficiaryVisitRegisterRepository.save(visitDetails);
			profileDetails.setVisitRegisterId(visitRegisterId);
		}

		return profileDetails;
	}

}
