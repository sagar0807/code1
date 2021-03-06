package gov.naco.soch.cst.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.naco.soch.cst.controller.ArtOpportunisticInfectionSummaryDto;
import gov.naco.soch.cst.dto.ArtBeneficiaryConcurrentConditionDto;
import gov.naco.soch.cst.dto.ArtBeneficiaryIptAttDetailsDto;
import gov.naco.soch.cst.dto.ArtBeneficiaryOpportunisticInfectionDto;
import gov.naco.soch.cst.dto.ArtBeneficiarySideEffectDto;
import gov.naco.soch.cst.dto.ArtBeneficiaryStaffNurseProfileDto;
import gov.naco.soch.cst.dto.ArtBeneficiaryStatusSummaryDto;
import gov.naco.soch.cst.dto.BeneficiaryFourSSymptomsPerVisitDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.ArtBeneficiaryConcurrentCondition;
import gov.naco.soch.entity.ArtBeneficiaryDueList;
import gov.naco.soch.entity.ArtBeneficiaryFollowup;
import gov.naco.soch.entity.ArtBeneficiaryIptAttDetails;
import gov.naco.soch.entity.ArtBeneficiaryOpportunisticInfection;
import gov.naco.soch.entity.ArtBeneficiaryQueue;
import gov.naco.soch.entity.ArtBeneficiarySideEffect;
import gov.naco.soch.entity.BeneficiaryArtStatusTracking;
import gov.naco.soch.entity.BeneficiaryFourSSymptomsPerVisit;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.MasterArtBeneficiaryStatus;
import gov.naco.soch.entity.MasterClinicalStage;
import gov.naco.soch.entity.MasterFourSScreening;
import gov.naco.soch.entity.MasterFourSsymptom;
import gov.naco.soch.entity.MasterFunctionalStatus;
import gov.naco.soch.entity.MasterIptStatus;
import gov.naco.soch.entity.MasterOpportunisticInfection;
import gov.naco.soch.entity.MasterOtherAilment;
import gov.naco.soch.entity.MasterSideEffect;
import gov.naco.soch.entity.MasterTbRegimen;
import gov.naco.soch.entity.MasterTbResult;
import gov.naco.soch.entity.MasterTbTestType;
import gov.naco.soch.entity.MasterTbTreatmentStatus;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.projection.ArtBeneficiaryOIDetailsProjection;
import gov.naco.soch.repository.ArtBeneficiaryConcurrentConditionRepository;
import gov.naco.soch.repository.ArtBeneficiaryDueListRepository;
import gov.naco.soch.repository.ArtBeneficiaryFollowupRepository;
import gov.naco.soch.repository.ArtBeneficiaryIptAttDetailsRepository;
import gov.naco.soch.repository.ArtBeneficiaryOpportunisticInfectionRepository;
import gov.naco.soch.repository.ArtBeneficiaryQueueRepository;
import gov.naco.soch.repository.ArtBeneficiarySideEffectRepository;
import gov.naco.soch.repository.BeneficiaryArtStatusTrackingRepository;
import gov.naco.soch.repository.BeneficiaryFourSSymptomsPerVisitRepository;
import gov.naco.soch.repository.BeneficiaryVisitRegisterRepository;
import gov.naco.soch.util.UserUtils;

@Service
@Transactional
public class ArtBeneficiaryStaffNurseProfileService {
	private static final Logger logger = LoggerFactory.getLogger(ArtBeneficiaryQueueProfileService.class);

	@Autowired
	private BeneficiaryVisitRegisterRepository beneficiaryVisitRegisterRepository;

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
	private ArtBeneficiaryIptAttDetailService artBeneficiaryIptAttDetailService;

	@Autowired
	private ArtBeneficiaryIptAttDetailsRepository artBeneficiaryIptAttDetailsRepository;
	
	@Autowired
	private BeneficiaryArtStatusTrackingRepository beneficiaryArtStatusTrackingRepository;

	/*
	 * method to fetch details in staff nurse beneficiary profile
	 * 
	 */
	public ArtBeneficiaryStaffNurseProfileDto getBeneficiaryStaffNurseProfile(Long beneficiaryId) {
		ArtBeneficiaryStaffNurseProfileDto dto = new ArtBeneficiaryStaffNurseProfileDto();

			dto.setConcurrentConditionSummary(getOpportunisticInfectionSummary(beneficiaryId));
			dto.setBeneficiaryArtStatusSummary(getArtBeneficiaryStatusSummary(beneficiaryId));
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
					dto.setDrugspPrescribedForOI(followUpDetails.getDrugsPrescribedForOpportunisticInfectionsProphylaxis());
					if (followUpDetails.getFunctionalStatusId() != null) {
						dto.setFunctionalStatusId(followUpDetails.getFunctionalStatusId().getId());
						dto.setFunctionalStatus(followUpDetails.getFunctionalStatusId().getName());
					}
					if (followUpDetails.getClinicalStageId() != null) {
						dto.setClinicalStageId(followUpDetails.getClinicalStageId().getId());
						dto.setClinicalStage(followUpDetails.getClinicalStageId().getName());
					}
				}
				List<ArtBeneficiaryOpportunisticInfection> opportunisticInfectionList1 = opportunisticInfectionRepository
						.findByVisitRegisterId(visitRegisterId);
				if (!CollectionUtils.isEmpty(opportunisticInfectionList1)) {
					List<ArtBeneficiaryOpportunisticInfectionDto> opportunisticInfectionDtoList = opportunisticInfectionList1
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

				/*
				 * tb regimen from art_beneficiary_ipt_att_details
				 */
				ArtBeneficiaryIptAttDetailsDto tbOIInformation = artBeneficiaryIptAttDetailService
						.getBeneficiaryIptAttDetailsForToday(beneficiaryId);
				if (tbOIInformation != null) {
					dto.setTbOIInformations(tbOIInformation);
				}
			}
		}
		return dto;
	}

	public ArtBeneficiaryStaffNurseProfileDto saveBeneficiaryQueueProfileForStaffNurse(
			ArtBeneficiaryStaffNurseProfileDto profileDetails) {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		Long visitRegisterId = VisitRegisterService.getVisitRegisterIdForToday(loginResponseDto.getFacilityId(),
				profileDetails.getBeneficiaryId());

		Optional<BeneficiaryVisitRegister> beneficiaryVisitRegisterOptional = beneficiaryVisitRegisterRepository
				.findById(visitRegisterId);
		if (beneficiaryVisitRegisterOptional.isPresent()) {
			BeneficiaryVisitRegister beneficiaryVisitRegister = beneficiaryVisitRegisterOptional.get();
			UserMaster entryUser = new UserMaster();
			entryUser.setId(loginResponseDto.getUserId());
			beneficiaryVisitRegister.setWeight(profileDetails.getWeight());
			beneficiaryVisitRegister.setHeight(profileDetails.getHeight());
			
			Optional<ArtBeneficiaryFollowup> optFollowUpDetails = artBeneficiaryFollowupRepository
					.findByVisitRegisterId(visitRegisterId);
			ArtBeneficiaryFollowup followUpDetails = null;

			if (optFollowUpDetails.isPresent()) {
				followUpDetails = optFollowUpDetails.get();
			} else {
				followUpDetails = new ArtBeneficiaryFollowup();
			}

			followUpDetails.setBeneficiaryVisitRegister(beneficiaryVisitRegister);
			followUpDetails.setBeneficiary(beneficiaryVisitRegister.getBeneficiary());
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
			followUpDetails.setDrugsPrescribedForOpportunisticInfectionsProphylaxis(profileDetails.getDrugspPrescribedForOI());

			artBeneficiaryFollowupRepository.save(followUpDetails);

			// Tb informations
			Optional<ArtBeneficiaryIptAttDetails> optIptAttDetails = artBeneficiaryIptAttDetailsRepository
					.findByBeneficiaryIdAndVisitRegisterId(profileDetails.getBeneficiaryId(),
							beneficiaryVisitRegister.getId());
			ArtBeneficiaryIptAttDetails iptAttDetails = null;

			if (optIptAttDetails.isPresent()) {
				iptAttDetails = optIptAttDetails.get();
			} else {
				iptAttDetails = new ArtBeneficiaryIptAttDetails();
			}
			iptAttDetails.setBeneficiary(beneficiaryVisitRegister.getBeneficiary());
			iptAttDetails.setFacility(beneficiaryVisitRegister.getFacility());
			iptAttDetails.setBeneficiaryVisitRegister(beneficiaryVisitRegister);
			iptAttDetails.setCptStartDate(profileDetails.getCptStartDate());
			iptAttDetails.setEntryUser(entryUser);
			Facility facility = new Facility();
			facility.setId(loginResponseDto.getFacilityId());
			iptAttDetails.setFacility(facility);
			if(profileDetails.getDiagnosedById()!=null) {
				iptAttDetails.setDiagnosedById(profileDetails.getDiagnosedById());
			}
			iptAttDetails.setEntryDate(profileDetails.getEntryDate());
			iptAttDetails.setIptEndDate(profileDetails.getIptEndDate());
			iptAttDetails.setIptRestartDate(profileDetails.getIptRestartDate());
			iptAttDetails.setIptStartDate(profileDetails.getIptStartDate());
			iptAttDetails.setIptStopDate(profileDetails.getIptStopDate());
			iptAttDetails.setDrugsPrescribedOiOthers(profileDetails.getOthers());
			iptAttDetails.setDrugsPrescribedOiCpt(profileDetails.getDrugspPrescribedForOI());
			iptAttDetails.setIsActive(Boolean.TRUE);
			iptAttDetails.setIsDelete(Boolean.FALSE);
			if (profileDetails.getTypeOfTest() != null) {
				MasterTbTestType testType = new MasterTbTestType();
				testType.setId(profileDetails.getTypeOfTest());
				iptAttDetails.setTbTestTypeId(testType);
			}
			if (profileDetails.getFourSScreeningId() != null) {

				MasterFourSScreening fourS = new MasterFourSScreening();
				fourS.setId(profileDetails.getFourSScreeningId());
				iptAttDetails.setMasterFourSScreening(fourS);
			}
			if (profileDetails.getIptStatusId() != null) {

				MasterIptStatus iptStatus = new MasterIptStatus();
				iptStatus.setId(profileDetails.getIptStatusId());
				iptAttDetails.setMasterIptStatus(iptStatus);
			}
			if (profileDetails.getTbRegimenId() != null) {

				MasterTbRegimen tbregimen = new MasterTbRegimen();
				tbregimen.setId(profileDetails.getTbRegimenId());
				iptAttDetails.setMasterTbRegimen(tbregimen);
			}
			if (profileDetails.getTbDiagnosisId() != null) {

				MasterTbResult tbResult = new MasterTbResult();
				tbResult.setId(profileDetails.getTbDiagnosisId());
				iptAttDetails.setMasterTbResult(tbResult);
			}
			if (profileDetails.getTbTreatmentStatusId() != null) {

				MasterTbTreatmentStatus treatmentStatus = new MasterTbTreatmentStatus();
				treatmentStatus.setId(profileDetails.getTbTreatmentStatusId());
				iptAttDetails.setMasterTbTreatmentStatus(treatmentStatus);
			}
			iptAttDetails.setNikshayId(profileDetails.getNikshayId());
			iptAttDetails.setTbTestTypeOther(profileDetails.getTbTestTypeOther());
			iptAttDetails.setRifResistance(profileDetails.getRifResistance());
			iptAttDetails.setTbDiagnosis(profileDetails.getTbDiagnosis());
			iptAttDetails.setTbHistory(profileDetails.getTbHistory());
			iptAttDetails.setTbTreatmentCompletionDate(profileDetails.getTbTreatmentCompletionDate());
			iptAttDetails.setTreatmentUnderId(profileDetails.getTreatmentUnderId());
			artBeneficiaryIptAttDetailsRepository.save(iptAttDetails);

			List<ArtBeneficiarySideEffect> oldSideEffectList = sideEffectRepository
					.findByVisitRegisterId(visitRegisterId);
			sideEffectRepository.deleteAll(oldSideEffectList);

			if (!CollectionUtils.isEmpty(profileDetails.getArtSideEffectsList())) {
				List<ArtBeneficiarySideEffect> sideEffectList = profileDetails.getArtSideEffectsList().stream()
						.map(s -> {
							ArtBeneficiarySideEffect sideEffect = new ArtBeneficiarySideEffect();
							sideEffect.setBeneficiaryVisitRegister(beneficiaryVisitRegister);
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
							concurrentCondition.setBeneficiaryVisitRegister(beneficiaryVisitRegister);
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
							opportunisticInfection.setBeneficiaryVisitRegister(beneficiaryVisitRegister);
							opportunisticInfection.setMasterOpportunisticInfection(masterOpportunisticInfection);
							opportunisticInfection.setIsActive(Boolean.TRUE);
							opportunisticInfection.setIsDelete(Boolean.FALSE);
							return opportunisticInfection;
						}).collect(Collectors.toList());
				opportunisticInfectionRepository.saveAll(opportunisticInfectionList);
			}

			beneficiaryVisitRegister.setFoursSymptoms(Boolean.FALSE);

			List<BeneficiaryFourSSymptomsPerVisit> oldFourSSymptoms = beneficiaryFourSSymptomsPerVisitRepository
					.findByVisitRegisterId(visitRegisterId);
			beneficiaryFourSSymptomsPerVisitRepository.deleteAll(oldFourSSymptoms);

			if (!CollectionUtils.isEmpty(profileDetails.getFourSSymptomsPerVisitList())) {
				beneficiaryVisitRegister.setFoursSymptoms(Boolean.TRUE);
				List<BeneficiaryFourSSymptomsPerVisit> fourSSymptomsPerVisitList = profileDetails
						.getFourSSymptomsPerVisitList().stream().map(f -> {
							BeneficiaryFourSSymptomsPerVisit fourSSymptomsPerVisit = new BeneficiaryFourSSymptomsPerVisit();
							fourSSymptomsPerVisit.setBeneficiaryVisitRegister(beneficiaryVisitRegister);
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
					beneficiaryVisitRegister.getBeneficiary().getId(), loginResponseDto.getUserId(),
					loginResponseDto.getFacilityId(), LocalDate.now());
			if (currentQueueOpt.isPresent()) {
				ArtBeneficiaryQueue currentQueue = currentQueueOpt.get();
				currentQueue.setIsVisited(Boolean.TRUE);
				artBeneficiaryQueueRepository.save(currentQueue);
			}

			if (profileDetails.getNextUserId() != null) {

				/*
				 * Optional<ArtBeneficiaryQueue> beneficiaryQueueOptional =
				 * artBeneficiaryQueueRepository
				 * .findByVisitRegisterId(beneficiaryVisitRegister.getId()); if
				 * (beneficiaryQueueOptional.isPresent()) { ArtBeneficiaryQueue beneficiaryQueue
				 * = beneficiaryQueueOptional.get();
				 * beneficiaryQueue.setIsVisited(Boolean.TRUE);
				 * artBeneficiaryQueueRepository.save(beneficiaryQueue); }
				 */

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
				artBeneficiaryQueue.setBeneficiary(beneficiaryVisitRegister.getBeneficiary());
				artBeneficiaryQueue.setBeneficiaryVisitRegister(beneficiaryVisitRegister);
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
				artBeneficiaryDueList.setBeneficiary(beneficiaryVisitRegister.getBeneficiary());
				artBeneficiaryDueList.setFacility(facility);
				artBeneficiaryDueList.setBeneficiaryVisitRegister(beneficiaryVisitRegister);
				artBeneficiaryDueListRepository.save(artBeneficiaryDueList);
			}

			beneficiaryVisitRegisterRepository.save(beneficiaryVisitRegister);
			profileDetails.setVisitRegisterId(visitRegisterId);
		}

		return profileDetails;
	}

	public List<ArtOpportunisticInfectionSummaryDto> getOpportunisticInfectionSummary(Long beneficiaryId) {
		List<ArtBeneficiaryOIDetailsProjection> opportunisticInfectionSummary = opportunisticInfectionRepository
				.findOpportunisticInfections(beneficiaryId);
		List<ArtOpportunisticInfectionSummaryDto> list = new ArrayList<ArtOpportunisticInfectionSummaryDto>();
		if (opportunisticInfectionSummary != null) {
			for (ArtBeneficiaryOIDetailsProjection opportunisticInfection : opportunisticInfectionSummary) {
				ArtOpportunisticInfectionSummaryDto dto =new ArtOpportunisticInfectionSummaryDto();
				dto.setVisitDateOi(opportunisticInfection.getVisitDate());
				dto.setVisiterRegisterId(opportunisticInfection.getVisiterRegisterId());
				dto.setMasterOpportunisticInfectionId(opportunisticInfection.getMasterOpportunisticInfectionId());
				list.add(dto);
			}
		}
		return list;
	}
	public List<ArtBeneficiaryStatusSummaryDto> getArtBeneficiaryStatusSummary(Long beneficiaryId) {
		LoginResponseDto loginResponseDto=UserUtils.getLoggedInUserDetails();
		List<BeneficiaryArtStatusTracking> artStatusTrackingList =beneficiaryArtStatusTrackingRepository.findByBeneficiaryIdAndFaclityIdForSummary(beneficiaryId, loginResponseDto.getFacilityId()); 
		List<ArtBeneficiaryStatusSummaryDto> list = new ArrayList<ArtBeneficiaryStatusSummaryDto>();
		if (artStatusTrackingList != null) {
			for (BeneficiaryArtStatusTracking statusTracking : artStatusTrackingList) {
				ArtBeneficiaryStatusSummaryDto dto =new ArtBeneficiaryStatusSummaryDto();
				dto.setStatusDate(statusTracking.getStatusDate());
				MasterArtBeneficiaryStatus beneficiaryStatus = statusTracking.getCurrentArtBeneficiaryStatus();
				if (beneficiaryStatus != null) {
					dto.setMasterArtBeneficiaryStatusId(beneficiaryStatus.getId());
					dto.setMasterArtBeneficiaryStatusName(beneficiaryStatus.getName());
				}
				list.add(dto);
			}
		}
		return list;
	}

}
