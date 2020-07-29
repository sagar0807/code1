package gov.naco.soch.cst.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import gov.naco.soch.cst.dto.ARTCounsellorFollowUpDto;
import gov.naco.soch.dto.LoginResponseDto;
import gov.naco.soch.entity.ArtBeneficiary;
import gov.naco.soch.entity.ArtBeneficiaryConcurrentCondition;
import gov.naco.soch.entity.ArtBeneficiaryDueList;
import gov.naco.soch.entity.ArtBeneficiaryFollowup;
import gov.naco.soch.entity.ArtBeneficiaryLinkagePurposes;
import gov.naco.soch.entity.ArtBeneficiaryOpportunisticInfection;
import gov.naco.soch.entity.ArtBeneficiaryQueue;
import gov.naco.soch.entity.ArtBeneficiarySideEffect;
import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.entity.BeneficiaryTransitFacility;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityLinkedFacilityBeneficiary;
import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.entity.MasterClinicalStage;
import gov.naco.soch.entity.MasterFunctionalStatus;
import gov.naco.soch.entity.MasterOpportunisticInfection;
import gov.naco.soch.entity.MasterOrganisationType;
import gov.naco.soch.entity.MasterOtherAilment;
import gov.naco.soch.entity.MasterPurpos;
import gov.naco.soch.entity.MasterReferralStatus;
import gov.naco.soch.entity.MasterSideEffect;
import gov.naco.soch.entity.Transfer;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.enums.RefferalStatusEnum;
import gov.naco.soch.util.DateUtil;
import gov.naco.soch.util.UserUtils;

public class ArtBeneficiaryFollowupMapper {

	public static ArtBeneficiaryFollowup mapToArtBeneficiaryFollowup(
			ARTCounsellorFollowUpDto artCounsellorFollowUpDto) {
		ArtBeneficiaryFollowup artBeneficiaryFollowup = new ArtBeneficiaryFollowup();
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		UserMaster entryUser = mapToUserMasterDtoId(loginResponseDto.getUserId());
		Facility facility = mapToFacilityDtoId(loginResponseDto.getFacilityId());
		artBeneficiaryFollowup.setFacility(facility);
		if (artCounsellorFollowUpDto.getClinicalStageId() != null) {
			MasterClinicalStage clinicalStage = mapToMasterClinicalStage(artCounsellorFollowUpDto.getClinicalStageId());
			artBeneficiaryFollowup.setClinicalStageId(clinicalStage);
		}
		if (artCounsellorFollowUpDto.getFunctionalStatusId() != null) {
			MasterFunctionalStatus functionalStatus = mapToFunctionalStatus(
					artCounsellorFollowUpDto.getFunctionalStatusId());
			artBeneficiaryFollowup.setFunctionalStatusId(functionalStatus);
		}
		artBeneficiaryFollowup.setDrugsPrescribedForOpportunisticInfectionsProphylaxis(
				artCounsellorFollowUpDto.getDrugsPrescribedForOpportunisticInfectionsProphylaxis());
		artBeneficiaryFollowup.setOtherDrugsForOpportunisticInfections(
				artCounsellorFollowUpDto.getOtherDrugsForOpportunisticInfections());
		artBeneficiaryFollowup.setRemainingPills(artCounsellorFollowUpDto.getRemainingPills());
		artBeneficiaryFollowup.setAdherenceToArt(artCounsellorFollowUpDto.getAdherenceToArt());
		artBeneficiaryFollowup.setAnyOtherMedicine(artCounsellorFollowUpDto.getOtherMedicines());
		artBeneficiaryFollowup.setTbTreatment(artCounsellorFollowUpDto.gettBTreatment());
		artBeneficiaryFollowup.setCondomsGiven(artCounsellorFollowUpDto.getCondomsGiven());
		artBeneficiaryFollowup.setRemarks(artCounsellorFollowUpDto.getRemarks());
		artBeneficiaryFollowup.setEntryUser(entryUser);
		artBeneficiaryFollowup.setVisitDate(artCounsellorFollowUpDto.getVisitDate());
//		if (artCounsellorFollowUpDto.getUserMaster1() != null) {
//			UserMaster assignedUser = mapToUserMasterDtoId(artCounsellorFollowUpDto.getUserMaster1());
//			artBeneficiaryFollowup.setUserMaster1(assignedUser);
//		}
		artBeneficiaryFollowup.setIsActive(Boolean.TRUE);
		artBeneficiaryFollowup.setIsDelete(Boolean.FALSE);
		return artBeneficiaryFollowup;
	}

	private static MasterFunctionalStatus mapToFunctionalStatus(Long functionalStatusId) {
		MasterFunctionalStatus functionalStatus = new MasterFunctionalStatus();
		functionalStatus.setId(functionalStatusId);
		return functionalStatus;
	}

	private static MasterClinicalStage mapToMasterClinicalStage(Long clinicalStageId) {
		MasterClinicalStage clinicalStage = new MasterClinicalStage();
		clinicalStage.setId(clinicalStageId);
		return clinicalStage;
	}

	private static Facility mapToFacilityDtoId(long facilityId) {
		Facility facility = new Facility();
		facility.setId(facilityId);
		return facility;
	}

	public static UserMaster mapToUserMasterDtoId(long userId) {
		UserMaster userMaster = new UserMaster();
		userMaster.setId(userId);
		return userMaster;
	}

	public static ArtBeneficiaryFollowup mapToArtBeneficiaryFollowup(ARTCounsellorFollowUpDto artCounsellorFollowUpDto,
			ArtBeneficiaryFollowup artBeneficiaryFollowup) {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		UserMaster entryUser = mapToUserMasterDtoId(loginResponseDto.getUserId());
		Facility facility = mapToFacilityDtoId(loginResponseDto.getFacilityId());
		artBeneficiaryFollowup.setFacility(facility);
		if (artCounsellorFollowUpDto.getClinicalStageId() != null) {
			MasterClinicalStage clinicalStage = mapToMasterClinicalStage(artCounsellorFollowUpDto.getClinicalStageId());
			artBeneficiaryFollowup.setClinicalStageId(clinicalStage);
		}
		if (artCounsellorFollowUpDto.getFunctionalStatusId() != null) {
			MasterFunctionalStatus functionalStatus = mapToFunctionalStatus(
					artCounsellorFollowUpDto.getFunctionalStatusId());
			artBeneficiaryFollowup.setFunctionalStatusId(functionalStatus);
		}
		artBeneficiaryFollowup.setDrugsPrescribedForOpportunisticInfectionsProphylaxis(
				artCounsellorFollowUpDto.getDrugsPrescribedForOpportunisticInfectionsProphylaxis());
		artBeneficiaryFollowup.setOtherDrugsForOpportunisticInfections(
				artCounsellorFollowUpDto.getOtherDrugsForOpportunisticInfections());
		artBeneficiaryFollowup.setRemainingPills(artCounsellorFollowUpDto.getRemainingPills());
		artBeneficiaryFollowup.setAdherenceToArt(artCounsellorFollowUpDto.getAdherenceToArt());
		artBeneficiaryFollowup.setAnyOtherMedicine(artCounsellorFollowUpDto.getOtherMedicines());
		artBeneficiaryFollowup.setTbTreatment(artCounsellorFollowUpDto.gettBTreatment());
		artBeneficiaryFollowup.setCondomsGiven(artCounsellorFollowUpDto.getCondomsGiven());
		artBeneficiaryFollowup.setRemarks(artCounsellorFollowUpDto.getRemarks());
		artBeneficiaryFollowup.setEntryUser(entryUser);
		artBeneficiaryFollowup.setVisitDate(artCounsellorFollowUpDto.getVisitDate());
//		if (artCounsellorFollowUpDto.getUserMaster1() != null) {
//			UserMaster assignedUser = mapToUserMasterDtoId(artCounsellorFollowUpDto.getUserMaster1());
//			artBeneficiaryFollowup.setUserMaster1(assignedUser);
//		}
		artBeneficiaryFollowup.setIsActive(Boolean.TRUE);
		artBeneficiaryFollowup.setIsDelete(Boolean.FALSE);
		return artBeneficiaryFollowup;
	}

	public static FacilityLinkedFacilityBeneficiary mapToFacilityLinkedFacilityBeneficiary(
			ARTCounsellorFollowUpDto artCounsellorFollowUpDto) {
		FacilityLinkedFacilityBeneficiary linkedFacilityBeneficiary = new FacilityLinkedFacilityBeneficiary();
		if (artCounsellorFollowUpDto.getIsLinked() == true) {
			linkedFacilityBeneficiary.setIsActive(true);
			linkedFacilityBeneficiary.setIsDelete(false);
			linkedFacilityBeneficiary.setIsLinked(artCounsellorFollowUpDto.getIsLinked());
			LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
			FacilityType facilityType = mapToFacilityTypeId(loginResponseDto.getFacilityTypeId());
			linkedFacilityBeneficiary.setFacilityTypeBean(facilityType);
			Facility facility = mapToFacilityDtoId(loginResponseDto.getFacilityId());
			linkedFacilityBeneficiary.setParentFacility(facility);
			if (artCounsellorFollowUpDto.getLinkedFacilityId() != null) {
				Facility LACfacility = mapToFacilityDtoId(artCounsellorFollowUpDto.getLinkedFacilityId());
				linkedFacilityBeneficiary.setLinkedFacilityId(LACfacility);
			}

		} else {
			linkedFacilityBeneficiary.setIsActive(false);
			linkedFacilityBeneficiary.setIsLinked(artCounsellorFollowUpDto.getIsLinked());
		}
		return linkedFacilityBeneficiary;
	}

	public static FacilityType mapToFacilityTypeId(long facilityTypeId) {
		FacilityType facilityType = new FacilityType();
		facilityType.setId(facilityTypeId);
		return facilityType;
	}

	public static Transfer mapToTransfer(ARTCounsellorFollowUpDto artCounsellorFollowUpDto) {
		Transfer artPatientTransfer = new Transfer();
		artPatientTransfer.setDestinationFacilityType(artCounsellorFollowUpDto.getDestinationFacilityType());
		if (artCounsellorFollowUpDto.getDestinationFacilityId() != null) {
			Facility facility = mapToFacilityDtoId(artCounsellorFollowUpDto.getDestinationFacilityId());
			artPatientTransfer.setFacilityTo(facility);
		}
		artPatientTransfer.setIsActive(Boolean.TRUE);
		artPatientTransfer.setIsDeleted(Boolean.FALSE);
		artPatientTransfer.setInitiationDate(DateUtil.getTodayDateInIST());
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		FacilityType facilityType = mapToFacilityTypeId(loginResponseDto.getFacilityTypeId());
		artPatientTransfer.setSourceFacilityType(facilityType.getFacilityTypeName());
		// artPatientTransfer.setSourceFacilityType(Objects.toString(facilityType.getFacilityTypeName()));
		Facility facility = mapToFacilityDtoId(loginResponseDto.getFacilityId());
		artPatientTransfer.setFacilityFrom(facility);
		return artPatientTransfer;

	}

	public static BeneficiaryReferral mapToBeneficiaryReferral(ARTCounsellorFollowUpDto artCounsellorFollowUpDto) {
		BeneficiaryReferral beneficiaryReferral = new BeneficiaryReferral();
		beneficiaryReferral.setIsActive(Boolean.TRUE);
		beneficiaryReferral.setIsDelete(Boolean.FALSE);
		beneficiaryReferral.setReferDate(DateUtil.getTodayDateInIST());
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		Facility facility = mapToFacilityDtoId(loginResponseDto.getFacilityId());
		beneficiaryReferral.setFacility1(facility);
		if (artCounsellorFollowUpDto.getReferTo() != null) {
			Facility referFacility = mapToFacilityDtoId(artCounsellorFollowUpDto.getReferTo());
			beneficiaryReferral.setFacility2(referFacility);
		}
		MasterReferralStatus masterReferralStatus = new MasterReferralStatus();
		masterReferralStatus.setId(RefferalStatusEnum.Pending.getReferalStatus());
		beneficiaryReferral.setBeneficiaryReferralStatusMaster(masterReferralStatus);
		return beneficiaryReferral;
	}

	public static List<BeneficiaryTransitFacility> mapToBeneficiaryTransitFacility(
			ARTCounsellorFollowUpDto artCounsellorFollowUpDto) {
		List<BeneficiaryTransitFacility> beneficiaryTransitFacilityList = new ArrayList<BeneficiaryTransitFacility>();
		List<Long> transistFacilityId = artCounsellorFollowUpDto.getTransistFacilityId();
		if (transistFacilityId != null && !transistFacilityId.isEmpty()) {
			for (Long facilityId : transistFacilityId) {
				BeneficiaryTransitFacility beneficiaryTransitFacility = new BeneficiaryTransitFacility();
				Facility facility = mapToFacilityDtoId(facilityId);
				beneficiaryTransitFacility.setFacility(facility);
				beneficiaryTransitFacility.setIsActive(Boolean.TRUE);
				beneficiaryTransitFacility.setIsDelete(Boolean.FALSE);
				beneficiaryTransitFacility.setStatus("PENDING");
				beneficiaryTransitFacilityList.add(beneficiaryTransitFacility);
			}
		}
		return beneficiaryTransitFacilityList;
	}

	public static List<ArtBeneficiaryOpportunisticInfection> mapToArtBeneficiaryOpportunisticInfection(
			ARTCounsellorFollowUpDto artCounsellorFollowUpDto) {
		List<ArtBeneficiaryOpportunisticInfection> artBeneficiaryOpportunisticInfectionList = new ArrayList<ArtBeneficiaryOpportunisticInfection>();
		List<Long> opportunisticInfectionIds = artCounsellorFollowUpDto.getOpportunisticInfections();
		if (opportunisticInfectionIds != null && !opportunisticInfectionIds.isEmpty()) {
			for (Long infections : opportunisticInfectionIds) {
				ArtBeneficiaryOpportunisticInfection opportunisticInfection = new ArtBeneficiaryOpportunisticInfection();
				opportunisticInfection.setIsActive(Boolean.TRUE);
				opportunisticInfection.setIsDelete(Boolean.FALSE);
				MasterOpportunisticInfection masterOpportunisticInfection = mapToMasterOpportunisticInfection(
						infections);
				opportunisticInfection.setMasterOpportunisticInfection(masterOpportunisticInfection);
				artBeneficiaryOpportunisticInfectionList.add(opportunisticInfection);
			}
		}
		return artBeneficiaryOpportunisticInfectionList;
	}

	private static MasterOpportunisticInfection mapToMasterOpportunisticInfection(Long opportunisticInfectionIds) {
		MasterOpportunisticInfection infection = new MasterOpportunisticInfection();
		infection.setId(opportunisticInfectionIds);
		return infection;
	}

	public static List<ArtBeneficiarySideEffect> mapToArtBeneficiaryFollowupSideEffect(
			ARTCounsellorFollowUpDto artCounsellorFollowUpDto) {
		List<ArtBeneficiarySideEffect> beneficiaryFollowupSideEffectsList = new ArrayList<ArtBeneficiarySideEffect>();
		List<Long> sideEffectId = artCounsellorFollowUpDto.getaRTSideEffects();
		if (sideEffectId != null && !sideEffectId.isEmpty()) {
			for (Long sideEffect : sideEffectId) {
				ArtBeneficiarySideEffect beneficiaryFollowupSideEffect = new ArtBeneficiarySideEffect();
				beneficiaryFollowupSideEffect.setIsActive(Boolean.TRUE);
				beneficiaryFollowupSideEffect.setIsDelete(Boolean.FALSE);
				MasterSideEffect masterSideEffect = mapToMasterSideEffect(sideEffect);
				beneficiaryFollowupSideEffect.setMasterSideEffect(masterSideEffect);
				beneficiaryFollowupSideEffectsList.add(beneficiaryFollowupSideEffect);
			}
		}
		return beneficiaryFollowupSideEffectsList;
	}

	private static MasterSideEffect mapToMasterSideEffect(Long sideEffect) {
		MasterSideEffect effect = new MasterSideEffect();
		effect.setId(sideEffect);
		return effect;
	}

	public static List<ArtBeneficiaryConcurrentCondition> mapToArtBeneficiaryFollowupConcurrentCondition(
			ARTCounsellorFollowUpDto artCounsellorFollowUpDto) {
		List<ArtBeneficiaryConcurrentCondition> beneficiaryConcurrentConditionsList = new ArrayList<ArtBeneficiaryConcurrentCondition>();
		List<Long> concurrentCondition = artCounsellorFollowUpDto.getConcurrentCondition();
		if (concurrentCondition != null && !concurrentCondition.isEmpty()) {
			for (Long conditions : concurrentCondition) {
				ArtBeneficiaryConcurrentCondition beneficiaryFollowupConcurrentCondition = new ArtBeneficiaryConcurrentCondition();
				beneficiaryFollowupConcurrentCondition.setIsActive(Boolean.TRUE);
				beneficiaryFollowupConcurrentCondition.setIsDelete(Boolean.FALSE);
				MasterOtherAilment masterOtherAilenment = mapToMasterOtherAilment(conditions);
				beneficiaryFollowupConcurrentCondition.setMasterOtherAilment(masterOtherAilenment);
				beneficiaryConcurrentConditionsList.add(beneficiaryFollowupConcurrentCondition);
			}
		}
		return beneficiaryConcurrentConditionsList;
	}

	private static MasterOtherAilment mapToMasterOtherAilment(Long conditions) {
		MasterOtherAilment ailment = new MasterOtherAilment();
		ailment.setId(conditions);
		return ailment;
	}

	public static BeneficiaryVisitRegister maptoBeneficiaryVisitRegister(
			ARTCounsellorFollowUpDto artCounsellorFollowUpDto,
			BeneficiaryVisitRegister beneficiaryVisitRegisterDetails) {
		beneficiaryVisitRegisterDetails.setWeight(artCounsellorFollowUpDto.getWeight());
		beneficiaryVisitRegisterDetails.setHeight(artCounsellorFollowUpDto.getHeight());
		beneficiaryVisitRegisterDetails.setIsPregnant(artCounsellorFollowUpDto.getIsPregnant());
		return beneficiaryVisitRegisterDetails;
	}

	public static ArtBeneficiary mapToArtBeneficiary(ARTCounsellorFollowUpDto artCounsellorFollowUpDto,
			ArtBeneficiary artBeneficary) {
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		UserMaster userMaster = mapToUserMasterDtoId(loginResponseDto.getUserId());
		Facility facility = mapToFacilityDtoId(loginResponseDto.getFacilityId());
		artBeneficary.setFacility(facility);
		artBeneficary.setLacLinked(artCounsellorFollowUpDto.getIsLinked());
		artBeneficary.setLinkageInstituteName(artCounsellorFollowUpDto.getLinkageInstituteName());
		if (artCounsellorFollowUpDto.getUserMaster1() != null) {
			UserMaster assignedUser = mapToUserMasterDtoId(artCounsellorFollowUpDto.getUserMaster1());
			artBeneficary.setUserId(assignedUser);
		}

		if (artCounsellorFollowUpDto.getLinkageOrganisationTypeId() != null) {
			MasterOrganisationType masterOrganisationType = new MasterOrganisationType();
			masterOrganisationType.setId(artCounsellorFollowUpDto.getLinkageOrganisationTypeId());
			artBeneficary.setMasterOrganisationType(masterOrganisationType);
		}

		if (artCounsellorFollowUpDto.getUserMaster1() != null) {
			UserMaster assignedUser = mapToUserMasterDtoId(artCounsellorFollowUpDto.getUserMaster1());
			artBeneficary.setUserId(assignedUser);
		}

		artBeneficary.setUserMaster1(userMaster);
		artBeneficary.setIsActive(Boolean.TRUE);
		artBeneficary.setIsDelete(Boolean.FALSE);
		artBeneficary.setIsTransit(artCounsellorFollowUpDto.getIsTransit());
		artBeneficary.setTransitStartDate(artCounsellorFollowUpDto.getTransitStartDate());
		artBeneficary.setTransitEndDate(artCounsellorFollowUpDto.getTransitEndDate());
		return artBeneficary;
	}

	public static ArtBeneficiaryQueue mapToBeneficiaryQueue(ARTCounsellorFollowUpDto artCounsellorFollowUpDto) {
		ArtBeneficiaryQueue artBeneficiaryQueue = new ArtBeneficiaryQueue();
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		UserMaster userMaster = mapToUserMasterDtoId(loginResponseDto.getUserId());
		Facility facility = mapToFacilityDtoId(loginResponseDto.getFacilityId());
		artBeneficiaryQueue.setEntryUser(userMaster);
		artBeneficiaryQueue.setFacility(facility);
		artBeneficiaryQueue.setVisitDate(DateUtil.getTodayDateInIST());
		UserMaster assignedUser = mapToUserMasterDtoId(artCounsellorFollowUpDto.getUserMaster1());
		artBeneficiaryQueue.setAssignedToUser(assignedUser);
		artBeneficiaryQueue.setIsVisited(Boolean.FALSE);
		artBeneficiaryQueue.setIsActive(Boolean.TRUE);
		artBeneficiaryQueue.setIsDelete(Boolean.FALSE);
		return artBeneficiaryQueue;
	}

	public static ARTCounsellorFollowUpDto mapToArtBeneficiaryFollowupDetails(
			ArtBeneficiaryFollowup artBeneficiaryFollowup,
			List<ArtBeneficiaryConcurrentCondition> artBeneficiaryConcurrentConditionList,
			List<ArtBeneficiarySideEffect> artBeneficiarySideEffectList,
			List<ArtBeneficiaryOpportunisticInfection> beneficiaryOpportunisticInfectionList,
			List<ArtBeneficiaryLinkagePurposes> linkagePurposesList, ArtBeneficiary artBeneficiaries) {
		ARTCounsellorFollowUpDto followUpDto = new ARTCounsellorFollowUpDto();
		followUpDto.setArtBeneficiaryFollowupId(artBeneficiaryFollowup.getId());
		followUpDto.setAdherenceToArt(artBeneficiaryFollowup.getAdherenceToArt());
		followUpDto.setRemainingPills(artBeneficiaryFollowup.getRemainingPills());
		followUpDto.setOtherMedicines(artBeneficiaryFollowup.getAnyOtherMedicine());
		followUpDto.settBTreatment(artBeneficiaryFollowup.getTbTreatment());
		followUpDto.setCondomsGiven(artBeneficiaryFollowup.getCondomsGiven());
		followUpDto.setRemarks(artBeneficiaryFollowup.getRemarks());
		followUpDto.setVisitDate(artBeneficiaryFollowup.getVisitDate());
		followUpDto.setDrugsPrescribedForOpportunisticInfectionsProphylaxis(
				artBeneficiaryFollowup.getDrugsPrescribedForOpportunisticInfectionsProphylaxis());
		followUpDto.setOtherDrugsForOpportunisticInfections(
				artBeneficiaryFollowup.getOtherDrugsForOpportunisticInfections());
		// followUpDto.setNextVisitDate(artBeneficiaryFollowup.getNextVisitDate());

		if (artBeneficiaryFollowup.getBeneficiaryVisitRegister() != null) {
			BeneficiaryVisitRegister beneficiaryVisitRegister = artBeneficiaryFollowup.getBeneficiaryVisitRegister();
			followUpDto.setHeight(beneficiaryVisitRegister.getHeight());
			followUpDto.setWeight(beneficiaryVisitRegister.getWeight());
			followUpDto.setIsPregnant(beneficiaryVisitRegister.getIsPregnant());
			if (artBeneficiaryConcurrentConditionList != null && !artBeneficiaryConcurrentConditionList.isEmpty()) {
				List<ArtBeneficiaryConcurrentCondition> conConditionList = artBeneficiaryConcurrentConditionList
						.stream().filter(t -> !(t.getIsDelete()) && t.getIsActive()).collect(Collectors.toList());
				List<Long> concurrentConditionList = new ArrayList<>();
				List<String> conConditionNameList = new ArrayList<>();
				conConditionList.forEach(conCondition -> {
					MasterOtherAilment ailment = conCondition.getMasterOtherAilment();
					if (ailment != null) {
						concurrentConditionList.add(ailment.getId());
						conConditionNameList.add(ailment.getName());
					}

				});
				followUpDto.setConcurrentCondition(concurrentConditionList);
				followUpDto.setConcurrentConditionName(conConditionNameList);
			}
			if (artBeneficiarySideEffectList != null && !artBeneficiarySideEffectList.isEmpty()) {
				List<ArtBeneficiarySideEffect> artBeneficiarySideEffectsList = artBeneficiarySideEffectList.stream()
						.filter(t -> !(t.getIsDelete()) && t.getIsActive()).collect(Collectors.toList());
				List<Long> sideEffectsList = new ArrayList<>();
				List<String> sideEffectsNameList = new ArrayList<>();
				artBeneficiarySideEffectsList.forEach(sideEffects -> {
					MasterSideEffect masterSideEffect = sideEffects.getMasterSideEffect();
					if (masterSideEffect != null) {
						sideEffectsList.add(masterSideEffect.getId());
						sideEffectsNameList.add(masterSideEffect.getName());
					}

				});
				followUpDto.setaRTSideEffects(sideEffectsList);
				followUpDto.setaRTSideEffectsName(sideEffectsNameList);
			}

			if (beneficiaryOpportunisticInfectionList != null && !beneficiaryOpportunisticInfectionList.isEmpty()) {
				List<ArtBeneficiaryOpportunisticInfection> opportunisticInfectionsList = beneficiaryOpportunisticInfectionList
						.stream().filter(t -> !(t.getIsDelete()) && t.getIsActive()).collect(Collectors.toList());
				List<Long> oppInfectionsList = new ArrayList<>();
				List<String> oppInfectionsNameList = new ArrayList<>();
				opportunisticInfectionsList.forEach(oppInfections -> {
					MasterOpportunisticInfection masterOpportunisticInfection = oppInfections
							.getMasterOpportunisticInfection();
					if (masterOpportunisticInfection != null) {
						oppInfectionsList.add(masterOpportunisticInfection.getId());
						oppInfectionsNameList.add(masterOpportunisticInfection.getName());
					}

				});
				followUpDto.setOpportunisticInfections(oppInfectionsList);
				followUpDto.setOpportunisticInfectionsName(oppInfectionsNameList);
			}
		}

		// if (artBeneficiaryFollowup.getUserMaster1() != null) {
		// followUpDto.setUserMaster1(artBeneficiaryFollowup.getUserMaster1().getId());
		// }

		if (artBeneficiaries != null) {
			followUpDto.setLinkageInstituteName(artBeneficiaries.getLinkageInstituteName());
			if (artBeneficiaries.getMasterOrganisationType() != null) {
				followUpDto.setLinkageOrganisationTypeId(artBeneficiaries.getMasterOrganisationType().getId());
			}
		}

		if (linkagePurposesList != null && !linkagePurposesList.isEmpty()) {
			List<ArtBeneficiaryLinkagePurposes> beneficiaryLinkagePurposesList = linkagePurposesList.stream()
					.filter(t -> !(t.getIsDelete()) && t.getIsActive()).collect(Collectors.toList());
			List<Long> linkagePurposeLists = new ArrayList<>();
			List<String> linkagePurposeNameLists = new ArrayList<>();
			beneficiaryLinkagePurposesList.forEach(purpose -> {
				MasterPurpos masterPurpos = purpose.getMasterPurpos();
				if (masterPurpos != null) {
					linkagePurposeLists.add(masterPurpos.getId());
					linkagePurposeNameLists.add(masterPurpos.getName());
				}
			});
			followUpDto.setLinkagePurposesId(linkagePurposeLists);
			followUpDto.setLinkagePurposesName(linkagePurposeNameLists);
		}

		if (artBeneficiaryFollowup.getBeneficiary() != null) {
			followUpDto.setBeneficiaryId(artBeneficiaryFollowup.getBeneficiary().getId());

		}
		if (artBeneficiaryFollowup.getFunctionalStatusId() != null) {
			followUpDto.setFunctionalStatusId(artBeneficiaryFollowup.getFunctionalStatusId().getId());
		}

		if (artBeneficiaryFollowup.getClinicalStageId() != null) {
			followUpDto.setClinicalStageId(artBeneficiaryFollowup.getClinicalStageId().getId());
		}

		return followUpDto;
	}

	public static List<ArtBeneficiaryLinkagePurposes> mapToArtBeneficiaryLinkagePurposes(
			ARTCounsellorFollowUpDto artCounsellorFollowUpDto) {

		List<ArtBeneficiaryLinkagePurposes> artBeneficiaryLinkagePurposesList = new ArrayList<ArtBeneficiaryLinkagePurposes>();
		List<Long> linkagePurposeId = artCounsellorFollowUpDto.getLinkagePurposesId();
		if (linkagePurposeId != null && !linkagePurposeId.isEmpty()) {
			for (Long purpose : linkagePurposeId) {
				ArtBeneficiaryLinkagePurposes linkagePurposes = new ArtBeneficiaryLinkagePurposes();
				linkagePurposes.setIsActive(Boolean.TRUE);
				linkagePurposes.setIsDelete(Boolean.FALSE);
				MasterPurpos masterPurpos = new MasterPurpos();
				masterPurpos.setId(purpose);
				linkagePurposes.setMasterPurpos(masterPurpos);
				artBeneficiaryLinkagePurposesList.add(linkagePurposes);
			}
		}
		return artBeneficiaryLinkagePurposesList;

	}

	public static ArtBeneficiaryDueList mapToBeneficiaryArtBeneficiaryDueList(
			ARTCounsellorFollowUpDto artCounsellorFollowUpDto, ArtBeneficiaryDueList artBeneficiaryDueList) {
		artBeneficiaryDueList.setIsDelete(false);
		artBeneficiaryDueList.setIsVisited(false);
		artBeneficiaryDueList.setIsActive(true);
		artBeneficiaryDueList.setVisitedDate(LocalDate.now());
		artBeneficiaryDueList.setExpectedVisitDate(artCounsellorFollowUpDto.getNextVisitDate());
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		UserMaster userMaster = mapToUserMasterDtoId(loginResponseDto.getUserId());
		artBeneficiaryDueList.setEntryUser(userMaster);
		return artBeneficiaryDueList;
	}

	public static ArtBeneficiaryDueList mapToBeneficiaryArtBeneficiaryDueList(
			ARTCounsellorFollowUpDto artCounsellorFollowUpDto) {
		ArtBeneficiaryDueList artBeneficiaryDueList = new ArtBeneficiaryDueList();
		artBeneficiaryDueList.setIsDelete(false);
		artBeneficiaryDueList.setIsVisited(false);
		artBeneficiaryDueList.setIsActive(true);
		artBeneficiaryDueList.setVisitedDate(LocalDate.now());
		artBeneficiaryDueList.setExpectedVisitDate(artCounsellorFollowUpDto.getNextVisitDate());
		LoginResponseDto loginResponseDto = UserUtils.getLoggedInUserDetails();
		UserMaster userMaster = mapToUserMasterDtoId(loginResponseDto.getUserId());
		artBeneficiaryDueList.setEntryUser(userMaster);
		return artBeneficiaryDueList;
	}
}
