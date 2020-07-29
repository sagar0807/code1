package gov.naco.soch.cst.mapper;

import java.util.Optional;

import gov.naco.soch.cst.dto.ArtBeneficiaryIptAttDetailsDto;
import gov.naco.soch.entity.ArtBeneficiaryIptAttDetails;
import gov.naco.soch.entity.Beneficiary;
import gov.naco.soch.entity.BeneficiaryVisitRegister;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.MasterFourSScreening;
import gov.naco.soch.entity.MasterIptStatus;
import gov.naco.soch.entity.MasterTbRegimen;
import gov.naco.soch.entity.MasterTbResult;
import gov.naco.soch.entity.MasterTbTestType;
import gov.naco.soch.entity.MasterTbTreatmentStatus;
import gov.naco.soch.entity.MasterTreatmentOutcome;
import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.util.DateUtil;

public class ArtBeneficiaryIptAttDetailsMapper {

	public static ArtBeneficiaryIptAttDetails mapArtBeneficiaryIPTATTDetailsDtoToArtBeneficiaryIPTATTDetails(
			ArtBeneficiaryIptAttDetailsDto artBeneficiaryIPTATTDetailsDto, BeneficiaryVisitRegister visitRegister,
			Long facilityId, Long userId, Beneficiary beneficiary,
			Optional<ArtBeneficiaryIptAttDetails> existingOptIptAttDetails) {

		ArtBeneficiaryIptAttDetails iptAttDetails = null;
		if (existingOptIptAttDetails.isPresent()) {
			iptAttDetails = existingOptIptAttDetails.get();
		} else {
			iptAttDetails = new ArtBeneficiaryIptAttDetails();
			iptAttDetails.setId(artBeneficiaryIPTATTDetailsDto.getIptAttDetailsId());
		}
		iptAttDetails.setAttStartDate(artBeneficiaryIPTATTDetailsDto.getAttStartDate());
		iptAttDetails.setBeneficiary(beneficiary);
		iptAttDetails.setBeneficiaryVisitRegister(visitRegister);
		iptAttDetails.setCptStartDate(artBeneficiaryIPTATTDetailsDto.getCptStartDate());
		iptAttDetails.setDiagnosedById(artBeneficiaryIPTATTDetailsDto.getDiagnosedById());
		iptAttDetails.setEntryDate(artBeneficiaryIPTATTDetailsDto.getEntryDate());
		UserMaster user = new UserMaster();
		user.setId(userId);
		iptAttDetails.setEntryUser(user);
		Facility facility = new Facility();
		facility.setId(facilityId);
		iptAttDetails.setFacility(facility);
		iptAttDetails.setIptEndDate(artBeneficiaryIPTATTDetailsDto.getIptEndDate());
		iptAttDetails.setIptRestartDate(artBeneficiaryIPTATTDetailsDto.getIptRestartDate());
		iptAttDetails.setIptStartDate(artBeneficiaryIPTATTDetailsDto.getIptStartDate());
		iptAttDetails.setIptStopDate(artBeneficiaryIPTATTDetailsDto.getIptStopDate());
		iptAttDetails.setIsActive(true);
		iptAttDetails.setIsDelete(false);
		if (artBeneficiaryIPTATTDetailsDto.getFourSScreeningId() != null) {

			MasterFourSScreening fourS = new MasterFourSScreening();
			fourS.setId(artBeneficiaryIPTATTDetailsDto.getFourSScreeningId());
			iptAttDetails.setMasterFourSScreening(fourS);
		}
		if (artBeneficiaryIPTATTDetailsDto.getIptStatusId() != null) {

			MasterIptStatus iptStatus = new MasterIptStatus();
			iptStatus.setId(artBeneficiaryIPTATTDetailsDto.getIptStatusId());
			iptAttDetails.setMasterIptStatus(iptStatus);
		}
		if (artBeneficiaryIPTATTDetailsDto.getTbRegimenId() != null) {

			MasterTbRegimen tbregimen = new MasterTbRegimen();
			tbregimen.setId(artBeneficiaryIPTATTDetailsDto.getTbRegimenId());
			iptAttDetails.setMasterTbRegimen(tbregimen);
		}
		if (artBeneficiaryIPTATTDetailsDto.getTbDiagnosisId() != null) {

			MasterTbResult tbResult = new MasterTbResult();
			tbResult.setId(artBeneficiaryIPTATTDetailsDto.getTbDiagnosisId());
			iptAttDetails.setMasterTbResult(tbResult);
		}
		if (artBeneficiaryIPTATTDetailsDto.getTbTreatmentStatusId() != null) {

			MasterTbTreatmentStatus treatmentStatus = new MasterTbTreatmentStatus();
			treatmentStatus.setId(artBeneficiaryIPTATTDetailsDto.getTbTreatmentStatusId());
			iptAttDetails.setMasterTbTreatmentStatus(treatmentStatus);
		}
		iptAttDetails.setNikshayId(artBeneficiaryIPTATTDetailsDto.getNikshayId());
		iptAttDetails.setRifResistance(artBeneficiaryIPTATTDetailsDto.getRifResistance());
		iptAttDetails.setTbDiagnosis(artBeneficiaryIPTATTDetailsDto.getTbDiagnosis());
		iptAttDetails.setTbHistory(artBeneficiaryIPTATTDetailsDto.getTbHistory());
		iptAttDetails.setTbTreatmentCompletionDate(artBeneficiaryIPTATTDetailsDto.getTbTreatmentCompletionDate());
		iptAttDetails.setTreatmentUnderId(artBeneficiaryIPTATTDetailsDto.getTreatmentUnderId());
		iptAttDetails.setTbTestReferredDate(artBeneficiaryIPTATTDetailsDto.getTbTestingCurrentMonthReferredDate());
		if (artBeneficiaryIPTATTDetailsDto.getTypeOfTest() != null) {
			MasterTbTestType testType = new MasterTbTestType();
			testType.setId(artBeneficiaryIPTATTDetailsDto.getTypeOfTest());
			iptAttDetails.setTbTestTypeId(testType);
		}
		iptAttDetails.setTbReferralFacility(artBeneficiaryIPTATTDetailsDto.getTbReferralFacility());
		iptAttDetails.setTbTestTypeOther(artBeneficiaryIPTATTDetailsDto.getTbTestTypeOther());
		iptAttDetails.setTreatmentOutcomeReason(artBeneficiaryIPTATTDetailsDto.getTreatmentOutcomeReason());
		iptAttDetails.setDrugsPrescribedOiCpt(artBeneficiaryIPTATTDetailsDto.getDrugsPrescribedOiCpt());
		iptAttDetails.setDrugsPrescribedOiOthers(artBeneficiaryIPTATTDetailsDto.getDrugsPrescribedOiOthers());
		if(artBeneficiaryIPTATTDetailsDto.getTreatmentOutcomeId() != null) {
			MasterTreatmentOutcome outcome = new MasterTreatmentOutcome();
			outcome.setId(artBeneficiaryIPTATTDetailsDto.getTreatmentOutcomeId());
			iptAttDetails.setMasterTreatmentOutcome(outcome);
		}

		return iptAttDetails;
	}

	public static BeneficiaryVisitRegister mapArtBeneficiaryIptAttDetailsDtoToBeneficiaryVisitRegister(
			ArtBeneficiaryIptAttDetailsDto artBeneficiaryIptAttDetailsDto, Beneficiary beneficiary, Long facilityId) {

		BeneficiaryVisitRegister visitRegister = new BeneficiaryVisitRegister();
		visitRegister.setBeneficiary(beneficiary);
		Facility facility = new Facility();
		facility.setId(facilityId);
		visitRegister.setFacility(facility);
		if (artBeneficiaryIptAttDetailsDto.getFourSScreeningId() != null
				&& artBeneficiaryIptAttDetailsDto.getFourSScreeningId() != 3) {
			visitRegister.setFoursSymptoms(true);
		}
		visitRegister.setIsActive(true);
		visitRegister.setIsDelete(false);
		visitRegister.setVisitDate(DateUtil.getTodayDateInIST());

		return visitRegister;
	}

	public static ArtBeneficiaryIptAttDetailsDto mapArtBeneficiaryIptAttDetailsToArtBeneficiaryIptAttDetailsDto(
			ArtBeneficiaryIptAttDetails artBeneficiaryIptAttDetails) {
		ArtBeneficiaryIptAttDetailsDto iptAttDetailsDto = new ArtBeneficiaryIptAttDetailsDto();
		iptAttDetailsDto.setAttStartDate(artBeneficiaryIptAttDetails.getAttStartDate());
		iptAttDetailsDto.setBeneficiaryId(artBeneficiaryIptAttDetails.getBeneficiary().getId());
		iptAttDetailsDto
				.setBeneficiaryVisitRegisterId(artBeneficiaryIptAttDetails.getBeneficiaryVisitRegister().getId());
		iptAttDetailsDto.setCptStartDate(artBeneficiaryIptAttDetails.getCptStartDate());
		iptAttDetailsDto.setDiagnosedById(artBeneficiaryIptAttDetails.getDiagnosedById());
		iptAttDetailsDto.setEntryDate(artBeneficiaryIptAttDetails.getEntryDate());
		iptAttDetailsDto.setFacilityId(artBeneficiaryIptAttDetails.getFacility().getId());
		if (artBeneficiaryIptAttDetails.getMasterFourSScreening() != null) {
			iptAttDetailsDto.setFourSScreeningId(artBeneficiaryIptAttDetails.getMasterFourSScreening().getId());
		}
		iptAttDetailsDto.setIptAttDetailsId(artBeneficiaryIptAttDetails.getId());
		iptAttDetailsDto.setIptEndDate(artBeneficiaryIptAttDetails.getIptEndDate());
		iptAttDetailsDto.setIptRestartDate(artBeneficiaryIptAttDetails.getIptRestartDate());
		iptAttDetailsDto.setIptStartDate(artBeneficiaryIptAttDetails.getIptStartDate());
		if (artBeneficiaryIptAttDetails.getMasterIptStatus() != null) {
			iptAttDetailsDto.setIptStatusId(artBeneficiaryIptAttDetails.getMasterIptStatus().getId());
		}
		iptAttDetailsDto.setIptStopDate(artBeneficiaryIptAttDetails.getIptStopDate());
		iptAttDetailsDto.setIsActive(artBeneficiaryIptAttDetails.getIsActive());
		iptAttDetailsDto.setIsDelete(artBeneficiaryIptAttDetails.getIsDelete());
		iptAttDetailsDto.setNikshayId(artBeneficiaryIptAttDetails.getNikshayId());
		iptAttDetailsDto.setRifResistance(artBeneficiaryIptAttDetails.getRifResistance());
		iptAttDetailsDto.setTbDiagnosis(artBeneficiaryIptAttDetails.getTbDiagnosis());
		if (artBeneficiaryIptAttDetails.getMasterTbResult() != null) {
			iptAttDetailsDto.setTbDiagnosisId(artBeneficiaryIptAttDetails.getMasterTbResult().getId());
		}
		iptAttDetailsDto.setTbHistory(artBeneficiaryIptAttDetails.getTbHistory());
		if ((artBeneficiaryIptAttDetails.getMasterTbRegimen()) != null) {

			iptAttDetailsDto.setTbRegimenId(artBeneficiaryIptAttDetails.getMasterTbRegimen().getId());
		}
		iptAttDetailsDto.setTbTreatmentCompletionDate(artBeneficiaryIptAttDetails.getTbTreatmentCompletionDate());
		if (artBeneficiaryIptAttDetails.getMasterTbTreatmentStatus() != null) {
			iptAttDetailsDto.setTbTreatmentStatusId(artBeneficiaryIptAttDetails.getMasterTbTreatmentStatus().getId());
		}
		iptAttDetailsDto.setTreatmentUnderId(artBeneficiaryIptAttDetails.getTreatmentUnderId());
		if(artBeneficiaryIptAttDetails.getTbTestTypeId() != null) {
			iptAttDetailsDto.setTypeOfTest(artBeneficiaryIptAttDetails.getTbTestTypeId().getId());
		}
		iptAttDetailsDto.setTbReferralFacility(artBeneficiaryIptAttDetails.getTbReferralFacility());
		iptAttDetailsDto.setTbTestingCurrentMonthReferredDate(artBeneficiaryIptAttDetails.getTbTestReferredDate());
		iptAttDetailsDto.setTbTestTypeOther(artBeneficiaryIptAttDetails.getTbTestTypeOther());
		iptAttDetailsDto.setTreatmentOutcomeReason(artBeneficiaryIptAttDetails.getTreatmentOutcomeReason());
		iptAttDetailsDto.setDrugsPrescribedOiCpt(artBeneficiaryIptAttDetails.getDrugsPrescribedOiCpt());
		iptAttDetailsDto.setDrugsPrescribedOiOthers(artBeneficiaryIptAttDetails.getDrugsPrescribedOiOthers());
		if(artBeneficiaryIptAttDetails.getMasterTreatmentOutcome() != null) {
			
			iptAttDetailsDto.setTreatmentOutcomeId(artBeneficiaryIptAttDetails.getMasterTreatmentOutcome().getId());
		}
		return iptAttDetailsDto;
	}

}
