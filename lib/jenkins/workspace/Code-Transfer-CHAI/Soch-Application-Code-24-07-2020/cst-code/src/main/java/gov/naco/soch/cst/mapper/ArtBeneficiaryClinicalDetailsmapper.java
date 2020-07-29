package gov.naco.soch.cst.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.cst.dto.ArtBeneficiaryClinicalDetailsDto;
import gov.naco.soch.cst.dto.ArtBeneficiaryCoexistingConditionDto;
import gov.naco.soch.cst.dto.ArtBeneficiaryContraceptionDto;
import gov.naco.soch.entity.ArtBeneficiaryClinicalDetail;
import gov.naco.soch.entity.ArtBeneficiaryCoexistingCondition;
import gov.naco.soch.entity.ArtBeneficiaryContraception;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.MasterArtRegimenAction;
import gov.naco.soch.entity.MasterArtRegimenActionReasons;
import gov.naco.soch.entity.MasterHabitsAlcoholUse;
import gov.naco.soch.entity.MasterHabitsSmoking;
import gov.naco.soch.entity.MasterHbvStatus;
import gov.naco.soch.entity.MasterHcvStatus;
import gov.naco.soch.entity.MasterTobaccoUse;
import gov.naco.soch.entity.Regimen;
import gov.naco.soch.entity.UserMaster;

public class ArtBeneficiaryClinicalDetailsmapper {

	public static ArtBeneficiaryClinicalDetailsDto mapArtBeneficiaryClinicalDetailToArtBeneficiaryClinicalDetailsDto(
			ArtBeneficiaryClinicalDetail clinicalDetail,
			List<ArtBeneficiaryCoexistingCondition> coexistingConditionList,
			List<ArtBeneficiaryContraception> contraceptionList) {
		ArtBeneficiaryClinicalDetailsDto dto = new ArtBeneficiaryClinicalDetailsDto();

		dto.setClinicalDetailsId(clinicalDetail.getId());
		dto.setCurrentMedication(clinicalDetail.getCurrentMedication());
		dto.setDrugAllergy(clinicalDetail.getDrugAllergy());
		dto.setBeneficiaryVisitRegisterId(clinicalDetail.getBeneficiaryVisitRegister().getId());

		if (clinicalDetail.getRegimen() != null) {
			dto.setRegimenId(clinicalDetail.getRegimen().getId());
			dto.setRegimen(clinicalDetail.getRegimen().getRegimenName());
		}

		if (clinicalDetail.getMasterHabitsAlcoholUse() != null) {
			dto.setHabitsAlcoholUseId(clinicalDetail.getMasterHabitsAlcoholUse().getId());
			dto.setHabitsAlcoholUse(clinicalDetail.getMasterHabitsAlcoholUse().getName());
		}

		if (clinicalDetail.getMasterHabitsSmoking() != null) {
			dto.setHabitsSmokingId(clinicalDetail.getMasterHabitsSmoking().getId());
			dto.setHabitsSmoking(clinicalDetail.getMasterHabitsSmoking().getName());
		}

		if (clinicalDetail.getMasterHbvStatus() != null) {
			dto.setHbvStatusId(clinicalDetail.getMasterHbvStatus().getId());
			dto.setHbvStatus(clinicalDetail.getMasterHbvStatus().getName());
		}

		if (clinicalDetail.getMasterHcvStatus() != null) {
			dto.setHcvStatusId(clinicalDetail.getMasterHcvStatus().getId());
			dto.setHcvStatus(clinicalDetail.getMasterHcvStatus().getName());
		}

		if (clinicalDetail.getMasterTobaccoUse() != null) {
			dto.setTobaccoUseId(clinicalDetail.getMasterTobaccoUse().getId());
			dto.setTobaccoUse(clinicalDetail.getMasterTobaccoUse().getName());
		}

		dto.setObstetricAbortusValue(clinicalDetail.getObstetricAbortusValue());
		dto.setObstetricGravidaValue(clinicalDetail.getObstetricGravidaValue());
		dto.setObstetricParityValue(clinicalDetail.getObstetricParityValue());
		dto.setGynaecologicalExam(clinicalDetail.getGynaecologicalExam());
		dto.setPapSmear(clinicalDetail.getPapSmear());
		dto.setPptctReferred(clinicalDetail.getIspptctReferred());
		dto.setOtherRemarks(clinicalDetail.getPptctPregnancyRemarks());

		if (clinicalDetail.getRegimen() != null) {
			dto.setRegimenId(clinicalDetail.getRegimen().getId());
			dto.setRegimen(clinicalDetail.getRegimen().getRegimenName());
		}

		if (clinicalDetail.getArtRegimenAction() != null) {
			dto.setArtRegimenActionId(clinicalDetail.getArtRegimenAction().getId());
			dto.setArtRegimenAction(clinicalDetail.getArtRegimenAction().getName());
		}

		if (clinicalDetail.getArtRegimenActionReason() != null) {
			dto.setArtRegimenActionReasonId(clinicalDetail.getArtRegimenActionReason().getId());
			dto.setArtRegimenActionReason(clinicalDetail.getArtRegimenActionReason().getName());
		}

		if (!CollectionUtils.isEmpty(coexistingConditionList)) {
			List<ArtBeneficiaryCoexistingConditionDto> coexistingConditionsList = new ArrayList<>();
			for (ArtBeneficiaryCoexistingCondition coexistingCondition : coexistingConditionList) {
				ArtBeneficiaryCoexistingConditionDto coexistingConditionDto = new ArtBeneficiaryCoexistingConditionDto();
				coexistingConditionDto.setClinicalDetailsCoexistingConditionId(coexistingCondition.getId());
				coexistingConditionDto.setOtherAilmentId(coexistingCondition.getMasterOtherAilment().getId());
				coexistingConditionDto.setOtherAilment(coexistingCondition.getMasterOtherAilment().getName());
				coexistingConditionsList.add(coexistingConditionDto);
			}
			dto.setCoexistingConditionsList(coexistingConditionsList);
		}

		if (!CollectionUtils.isEmpty(contraceptionList)) {
			List<ArtBeneficiaryContraceptionDto> contraceptionsList = new ArrayList<>();

			for (ArtBeneficiaryContraception contraceptions : contraceptionList) {
				ArtBeneficiaryContraceptionDto contraceptionsDto = new ArtBeneficiaryContraceptionDto();
				contraceptionsDto.setClinicalDetailsContraceptionId(contraceptions.getId());
				contraceptionsDto.setContraceptionId(contraceptions.getMasterContraception().getId());
				contraceptionsDto.setContraception(contraceptions.getMasterContraception().getName());
				contraceptionsList.add(contraceptionsDto);
			}
			dto.setContraceptionsList(contraceptionsList);
		}
		return dto;
	}

	public static ArtBeneficiaryClinicalDetail mapArtBeneficiaryClinicalDetailDtoToArtBeneficiaryClinicalDetails(
			Optional<ArtBeneficiaryClinicalDetail> existingClinicalDetails,
			ArtBeneficiaryClinicalDetailsDto clinicalDetailsDto, Long userId, Long facilityId,
			BeneficiaryVisitRegister visitRegister) {

		ArtBeneficiaryClinicalDetail clinicalDetails = null;
		if (existingClinicalDetails.isPresent()) {
			clinicalDetails = existingClinicalDetails.get();
		} else {
			clinicalDetails = new ArtBeneficiaryClinicalDetail();
		}
		clinicalDetails.setEntryDate(LocalDate.now());

		UserMaster user = new UserMaster();
		user.setId(userId);
		clinicalDetails.setEntryUser(user);

		Facility facility = new Facility();
		facility.setId(facilityId);
		clinicalDetails.setFacility(facility);

		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setId(clinicalDetailsDto.getBeneficiaryId());
		clinicalDetails.setBeneficiary(beneficiary);

		clinicalDetails.setBeneficiaryVisitRegister(visitRegister);

		if (clinicalDetailsDto.getHabitsAlcoholUseId() != null) {
			MasterHabitsAlcoholUse habitsAlcoholUse = new MasterHabitsAlcoholUse();
			habitsAlcoholUse.setId(clinicalDetailsDto.getHabitsAlcoholUseId());
			clinicalDetails.setMasterHabitsAlcoholUse(habitsAlcoholUse);
		}

		if (clinicalDetailsDto.getHabitsSmokingId() != null) {
			MasterHabitsSmoking habitsSmoking = new MasterHabitsSmoking();
			habitsSmoking.setId(clinicalDetailsDto.getHabitsSmokingId());
			clinicalDetails.setMasterHabitsSmoking(habitsSmoking);
		}

		if (clinicalDetailsDto.getHbvStatusId() != null) {
			MasterHbvStatus hbvStatus = new MasterHbvStatus();
			hbvStatus.setId(clinicalDetailsDto.getHbvStatusId());
			clinicalDetails.setMasterHbvStatus(hbvStatus);
		}

		if (clinicalDetailsDto.getTobaccoUseId() != null) {
			MasterTobaccoUse tobaccoUse = new MasterTobaccoUse();
			tobaccoUse.setId(clinicalDetailsDto.getTobaccoUseId());
			clinicalDetails.setMasterTobaccoUse(tobaccoUse);
		}

		if (clinicalDetailsDto.getHcvStatusId() != null) {
			MasterHcvStatus hcvStatus = new MasterHcvStatus();
			hcvStatus.setId(clinicalDetailsDto.getHcvStatusId());
			clinicalDetails.setMasterHcvStatus(hcvStatus);
		}

		if (clinicalDetailsDto.getRegimenId() != null) {
			Regimen regimen = new Regimen();
			regimen.setId(clinicalDetailsDto.getRegimenId());
			clinicalDetails.setRegimen(regimen);
		}

		if (clinicalDetailsDto.getRegimenId() != null) {
			Regimen regimen = new Regimen();
			regimen.setId(clinicalDetailsDto.getRegimenId());
			clinicalDetails.setRegimen(regimen);
		}

		if (clinicalDetailsDto.getArtRegimenActionId() != null) {
			MasterArtRegimenAction action = new MasterArtRegimenAction();
			action.setId(clinicalDetailsDto.getArtRegimenActionId());
			clinicalDetails.setArtRegimenAction(action);
		}

		if (clinicalDetailsDto.getArtRegimenActionReasonId() != null) {
			MasterArtRegimenActionReasons reason = new MasterArtRegimenActionReasons();
			reason.setId(clinicalDetailsDto.getArtRegimenActionReasonId());
			clinicalDetails.setArtRegimenActionReason(reason);
		}

		clinicalDetails.setCurrentMedication(clinicalDetailsDto.getCurrentMedication());
		clinicalDetails.setDrugAllergy(clinicalDetailsDto.getDrugAllergy());
		clinicalDetails.setObstetricAbortusValue(clinicalDetailsDto.getObstetricAbortusValue());
		clinicalDetails.setObstetricGravidaValue(clinicalDetailsDto.getObstetricGravidaValue());
		clinicalDetails.setObstetricParityValue(clinicalDetailsDto.getObstetricParityValue());
		clinicalDetails.setGynaecologicalExam(clinicalDetailsDto.getGynaecologicalExam());
		clinicalDetails.setPapSmear(clinicalDetailsDto.getPapSmear());
		clinicalDetails.setIspptctReferred(clinicalDetailsDto.getPptctReferred());
		clinicalDetails.setPptctPregnancyRemarks(clinicalDetailsDto.getOtherRemarks());
		clinicalDetails.setIsActive(Boolean.TRUE);
		clinicalDetails.setIsDelete(Boolean.FALSE);

		return clinicalDetails;
	}

}
