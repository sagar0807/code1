package gov.naco.soch.cst.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.cst.dto.ArtBeneficiaryCoexistingConditionDto;
import gov.naco.soch.cst.dto.ArtBeneficiaryContraceptionDto;
import gov.naco.soch.cst.dto.CounsellingDto;
import gov.naco.soch.cst.dto.CounsellingNoteAnswersDto;
import gov.naco.soch.cst.dto.CounsellingNoteDto;
import gov.naco.soch.cst.dto.CounsellingNoteOptionsDto;
import gov.naco.soch.entity.ArtBeneficiaryClinicalDetail;
import gov.naco.soch.entity.ArtBeneficiaryCoexistingCondition;
import gov.naco.soch.entity.ArtBeneficiaryContraception;
import gov.naco.soch.entity.ArtBeneficiaryCounsellingNotes;
import gov.naco.soch.entity.ArtBeneficiaryCounsellingNotesAnswers;
import gov.naco.soch.entity.ArtBeneficiaryIptAttDetails;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.CounsellingNote;
import gov.naco.soch.entity.CounsellingOptions;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.MasterHabitsAlcoholUse;
import gov.naco.soch.entity.MasterHabitsSmoking;
import gov.naco.soch.entity.MasterHbvStatus;
import gov.naco.soch.entity.MasterHcvStatus;
import gov.naco.soch.entity.MasterTobaccoUse;
import gov.naco.soch.entity.UserMaster;

public class CounsellingNoteMapper {

	public static CounsellingNoteDto maptoCounsellingNoteDto(
			ArtBeneficiaryCounsellingNotes artBeneficiaryCounsellingNote) {
		CounsellingNoteDto counsellingNoteDto = new CounsellingNoteDto();
		CounsellingNote counsellingNote = artBeneficiaryCounsellingNote.getCounsellingNote();
		List<CounsellingNoteOptionsDto> counsellingOptions = mapToCounsellingOptionDto(
				counsellingNote.getCounsellingOptions());
		counsellingNoteDto.setCounsellingOptions(counsellingOptions);
		counsellingNoteDto.setId(counsellingNote.getId());
		counsellingNoteDto.setCousellingNote(counsellingNote.getCounsellingNote());
		counsellingNoteDto.setCousellingSection(counsellingNote.getCounsellingSection());
		counsellingNoteDto.setQuestionKey(counsellingNote.getQuestionKey());
		counsellingNoteDto.setFirstVisit(counsellingNote.getFirstVisit());

		if (!CollectionUtils.isEmpty(artBeneficiaryCounsellingNote.getArtBeneficiaryCounsellingNotesAnswers())) {
			List<CounsellingNoteAnswersDto> counsellingNoteAnswers = new ArrayList<CounsellingNoteAnswersDto>();
			for (ArtBeneficiaryCounsellingNotesAnswers answer : artBeneficiaryCounsellingNote
					.getArtBeneficiaryCounsellingNotesAnswers()) {
				CounsellingNoteAnswersDto answersDto = new CounsellingNoteAnswersDto();
				// answersDto.setId(answer.getId());
				answersDto.setArtCounsellingNoteAnswer(answer.getArtCounsellingNoteAnswer());
				counsellingNoteAnswers.add(answersDto);
			}
			counsellingNoteDto.setCounsellingNoteAnswer(counsellingNoteAnswers);
		}

		return counsellingNoteDto;
	}

	private static List<CounsellingNoteOptionsDto> mapToCounsellingOptionDto(
			Set<CounsellingOptions> counsellingOptions) {
		List<CounsellingNoteOptionsDto> dtos = new ArrayList<CounsellingNoteOptionsDto>();
		if (!counsellingOptions.isEmpty() && counsellingOptions != null) {
			for (CounsellingOptions option : counsellingOptions) {
				CounsellingNoteOptionsDto dto = new CounsellingNoteOptionsDto();
				dto.setCounsellingOption(option.getCounsellingOption());
				dto.setId(option.getId());
				dtos.add(dto);
			}
		}
		return dtos;
	}

	public static CounsellingNoteDto maptoCounsellingNoteListDto(CounsellingNote counsellingNote) {
		CounsellingNoteDto counsellingNoteDto = new CounsellingNoteDto();
		List<CounsellingNoteOptionsDto> counsellingOptions = mapToCounsellingOptionDto(
				counsellingNote.getCounsellingOptions());
		counsellingNoteDto.setCounsellingOptions(counsellingOptions);
		counsellingNoteDto.setId(counsellingNote.getId());
		counsellingNoteDto.setCousellingNote(counsellingNote.getCounsellingNote());
		counsellingNoteDto.setCousellingSection(counsellingNote.getCounsellingSection());
		counsellingNoteDto.setQuestionKey(counsellingNote.getQuestionKey());
		counsellingNoteDto.setFirstVisit(counsellingNote.getFirstVisit());
		return counsellingNoteDto;
	}

	public static CounsellingDto mapClinicalDetailsToCounsellingDto(CounsellingDto dto,
			Optional<ArtBeneficiaryClinicalDetail> clinicalDetailOpt,
			List<ArtBeneficiaryCoexistingCondition> coexistingConditionList,
			List<ArtBeneficiaryContraception> contraceptionList) {

		if (clinicalDetailOpt.isPresent()) {
			ArtBeneficiaryClinicalDetail clinicalDetail = clinicalDetailOpt.get();
			dto.setCurrentMedication(clinicalDetail.getCurrentMedication());
			dto.setDrugAllergy(clinicalDetail.getDrugAllergy());
			dto.setVisitRegisterId(clinicalDetail.getBeneficiaryVisitRegister().getId());

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

	public static ArtBeneficiaryClinicalDetail mapCounsellingDtoToArtBeneficiaryClinicalDetails(
			Optional<ArtBeneficiaryClinicalDetail> existingClinicalDetails, CounsellingDto dto, Long userId,
			Long facilityId, BeneficiaryVisitRegister visitRegister) {

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
		beneficiary.setId(dto.getBeneficiaryId());
		clinicalDetails.setBeneficiary(beneficiary);

		clinicalDetails.setBeneficiaryVisitRegister(visitRegister);

		if (dto.getHabitsAlcoholUseId() != null) {
			MasterHabitsAlcoholUse habitsAlcoholUse = new MasterHabitsAlcoholUse();
			habitsAlcoholUse.setId(dto.getHabitsAlcoholUseId());
			clinicalDetails.setMasterHabitsAlcoholUse(habitsAlcoholUse);
		}

		if (dto.getHabitsSmokingId() != null) {
			MasterHabitsSmoking habitsSmoking = new MasterHabitsSmoking();
			habitsSmoking.setId(dto.getHabitsSmokingId());
			clinicalDetails.setMasterHabitsSmoking(habitsSmoking);
		}

		if (dto.getHbvStatusId() != null) {
			MasterHbvStatus hbvStatus = new MasterHbvStatus();
			hbvStatus.setId(dto.getHbvStatusId());
			clinicalDetails.setMasterHbvStatus(hbvStatus);
		}

		if (dto.getTobaccoUseId() != null) {
			MasterTobaccoUse tobaccoUse = new MasterTobaccoUse();
			tobaccoUse.setId(dto.getTobaccoUseId());
			clinicalDetails.setMasterTobaccoUse(tobaccoUse);
		}

		if (dto.getHcvStatusId() != null) {
			MasterHcvStatus hcvStatus = new MasterHcvStatus();
			hcvStatus.setId(dto.getHcvStatusId());
			clinicalDetails.setMasterHcvStatus(hcvStatus);
		}

		clinicalDetails.setIspptctReferred(dto.getPptctReferred());
		clinicalDetails.setPptctPregnancyRemarks(dto.getOtherRemarks());
		clinicalDetails.setGynaecologicalExam(dto.getGynaecologicalExam());
		clinicalDetails.setPapSmear(dto.getPapSmear());
		clinicalDetails.setCurrentMedication(dto.getCurrentMedication());
		clinicalDetails.setDrugAllergy(dto.getDrugAllergy());
		clinicalDetails.setObstetricAbortusValue(dto.getObstetricAbortusValue());
		clinicalDetails.setObstetricGravidaValue(dto.getObstetricGravidaValue());
		clinicalDetails.setObstetricParityValue(dto.getObstetricParityValue());
		clinicalDetails.setIsActive(Boolean.TRUE);
		clinicalDetails.setIsDelete(Boolean.FALSE);

		return clinicalDetails;
	}

	public static ArtBeneficiaryIptAttDetails mapToArtBeneficiaryIptAttDetails(CounsellingDto dto, Long userId,
			Long facilityId, BeneficiaryVisitRegister visitRegister) {

		ArtBeneficiaryIptAttDetails artBeneficiaryIptAttDetails = new ArtBeneficiaryIptAttDetails();

		UserMaster user = new UserMaster();
		user.setId(userId);
		artBeneficiaryIptAttDetails.setEntryUser(user);

		artBeneficiaryIptAttDetails.setEntryDate(LocalDate.now());

		Facility facility = new Facility();
		facility.setId(facilityId);
		artBeneficiaryIptAttDetails.setFacility(facility);

		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setId(dto.getBeneficiaryId());
		artBeneficiaryIptAttDetails.setBeneficiary(beneficiary);

		artBeneficiaryIptAttDetails.setBeneficiaryVisitRegister(visitRegister);

		artBeneficiaryIptAttDetails.setCptStartDate(dto.getCptInitiatedDate());
		artBeneficiaryIptAttDetails.setIsActive(Boolean.TRUE);
		artBeneficiaryIptAttDetails.setIsDelete(Boolean.FALSE);

		return artBeneficiaryIptAttDetails;
	}
}