package gov.naco.soch.cst.dto;

import java.time.LocalDate;
import java.util.List;

public class ArtBeneficiaryClinicalDetailsDto {

	private Long clinicalDetailsId;

	private String currentMedication;

	private String drugAllergy;

	private Long beneficiaryId;

	private Long beneficiaryVisitRegisterId;

	private Long facilityId;

	private Long habitsAlcoholUseId;

	private String habitsAlcoholUse;

	private Long habitsSmokingId;

	private String habitsSmoking;

	private Long hbvStatusId;

	private String hbvStatus;

	private Long hcvStatusId;

	private String hcvStatus;

	private Long tobaccoUseId;

	private String tobaccoUse;

	private Long obstetricAbortusValue;

	private Long obstetricGravidaValue;

	private Long obstetricParityValue;

	private String gynaecologicalExam;

	private String papSmear;

	private Long regimenId;

	private String regimen;

	private Long artRegimenActionId;

	private String artRegimenAction;

	private Long artRegimenActionReasonId;

	private String artRegimenActionReason;

	private List<BeneficiarySocialWelfareDto> socialWelfareSchemes;

	private List<ArtBeneficiaryCoexistingConditionDto> coexistingConditionsList;

	private List<ArtBeneficiaryContraceptionDto> contraceptionsList;

	private ArtBeneficiaryIptAttDetailsDto tbOIInformations;

	private LocalDate lastMenstrualPeriod;

	private Boolean pregnantNow;

	private Boolean pptctReferred;

	private Long deliveryOutcome;

	private String otherRemarks;

	public Long getClinicalDetailsId() {
		return clinicalDetailsId;
	}

	public void setClinicalDetailsId(Long clinicalDetailsId) {
		this.clinicalDetailsId = clinicalDetailsId;
	}

	public String getCurrentMedication() {
		return currentMedication;
	}

	public void setCurrentMedication(String currentMedication) {
		this.currentMedication = currentMedication;
	}

	public String getDrugAllergy() {
		return drugAllergy;
	}

	public void setDrugAllergy(String drugAllergy) {
		this.drugAllergy = drugAllergy;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Long getBeneficiaryVisitRegisterId() {
		return beneficiaryVisitRegisterId;
	}

	public void setBeneficiaryVisitRegisterId(Long beneficiaryVisitRegisterId) {
		this.beneficiaryVisitRegisterId = beneficiaryVisitRegisterId;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public Long getHabitsAlcoholUseId() {
		return habitsAlcoholUseId;
	}

	public void setHabitsAlcoholUseId(Long habitsAlcoholUseId) {
		this.habitsAlcoholUseId = habitsAlcoholUseId;
	}

	public String getHabitsAlcoholUse() {
		return habitsAlcoholUse;
	}

	public void setHabitsAlcoholUse(String habitsAlcoholUse) {
		this.habitsAlcoholUse = habitsAlcoholUse;
	}

	public Long getHabitsSmokingId() {
		return habitsSmokingId;
	}

	public void setHabitsSmokingId(Long habitsSmokingId) {
		this.habitsSmokingId = habitsSmokingId;
	}

	public String getHabitsSmoking() {
		return habitsSmoking;
	}

	public void setHabitsSmoking(String habitsSmoking) {
		this.habitsSmoking = habitsSmoking;
	}

	public Long getHbvStatusId() {
		return hbvStatusId;
	}

	public void setHbvStatusId(Long hbvStatusId) {
		this.hbvStatusId = hbvStatusId;
	}

	public String getHbvStatus() {
		return hbvStatus;
	}

	public void setHbvStatus(String hbvStatus) {
		this.hbvStatus = hbvStatus;
	}

	public Long getHcvStatusId() {
		return hcvStatusId;
	}

	public void setHcvStatusId(Long hcvStatusId) {
		this.hcvStatusId = hcvStatusId;
	}

	public String getHcvStatus() {
		return hcvStatus;
	}

	public void setHcvStatus(String hcvStatus) {
		this.hcvStatus = hcvStatus;
	}

	public Long getTobaccoUseId() {
		return tobaccoUseId;
	}

	public void setTobaccoUseId(Long tobaccoUseId) {
		this.tobaccoUseId = tobaccoUseId;
	}

	public String getTobaccoUse() {
		return tobaccoUse;
	}

	public void setTobaccoUse(String tobaccoUse) {
		this.tobaccoUse = tobaccoUse;
	}

	public Long getObstetricAbortusValue() {
		return obstetricAbortusValue;
	}

	public void setObstetricAbortusValue(Long obstetricAbortusValue) {
		this.obstetricAbortusValue = obstetricAbortusValue;
	}

	public Long getObstetricGravidaValue() {
		return obstetricGravidaValue;
	}

	public void setObstetricGravidaValue(Long obstetricGravidaValue) {
		this.obstetricGravidaValue = obstetricGravidaValue;
	}

	public Long getObstetricParityValue() {
		return obstetricParityValue;
	}

	public void setObstetricParityValue(Long obstetricParityValue) {
		this.obstetricParityValue = obstetricParityValue;
	}

	public String getGynaecologicalExam() {
		return gynaecologicalExam;
	}

	public void setGynaecologicalExam(String gynaecologicalExam) {
		this.gynaecologicalExam = gynaecologicalExam;
	}

	public String getPapSmear() {
		return papSmear;
	}

	public void setPapSmear(String papSmear) {
		this.papSmear = papSmear;
	}

	public Long getRegimenId() {
		return regimenId;
	}

	public void setRegimenId(Long regimenId) {
		this.regimenId = regimenId;
	}

	public String getRegimen() {
		return regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

	public Long getArtRegimenActionId() {
		return artRegimenActionId;
	}

	public void setArtRegimenActionId(Long artRegimenActionId) {
		this.artRegimenActionId = artRegimenActionId;
	}

	public String getArtRegimenAction() {
		return artRegimenAction;
	}

	public void setArtRegimenAction(String artRegimenAction) {
		this.artRegimenAction = artRegimenAction;
	}

	public Long getArtRegimenActionReasonId() {
		return artRegimenActionReasonId;
	}

	public void setArtRegimenActionReasonId(Long artRegimenActionReasonId) {
		this.artRegimenActionReasonId = artRegimenActionReasonId;
	}

	public String getArtRegimenActionReason() {
		return artRegimenActionReason;
	}

	public void setArtRegimenActionReason(String artRegimenActionReason) {
		this.artRegimenActionReason = artRegimenActionReason;
	}

	public List<BeneficiarySocialWelfareDto> getSocialWelfareSchemes() {
		return socialWelfareSchemes;
	}

	public void setSocialWelfareSchemes(List<BeneficiarySocialWelfareDto> socialWelfareSchemes) {
		this.socialWelfareSchemes = socialWelfareSchemes;
	}

	public List<ArtBeneficiaryCoexistingConditionDto> getCoexistingConditionsList() {
		return coexistingConditionsList;
	}

	public void setCoexistingConditionsList(List<ArtBeneficiaryCoexistingConditionDto> coexistingConditionsList) {
		this.coexistingConditionsList = coexistingConditionsList;
	}

	public List<ArtBeneficiaryContraceptionDto> getContraceptionsList() {
		return contraceptionsList;
	}

	public void setContraceptionsList(List<ArtBeneficiaryContraceptionDto> contraceptionsList) {
		this.contraceptionsList = contraceptionsList;
	}

	public ArtBeneficiaryIptAttDetailsDto getTbOIInformations() {
		return tbOIInformations;
	}

	public void setTbOIInformations(ArtBeneficiaryIptAttDetailsDto tbOIInformations) {
		this.tbOIInformations = tbOIInformations;
	}

	public LocalDate getLastMenstrualPeriod() {
		return lastMenstrualPeriod;
	}

	public void setLastMenstrualPeriod(LocalDate lastMenstrualPeriod) {
		this.lastMenstrualPeriod = lastMenstrualPeriod;
	}

	public Boolean getPregnantNow() {
		return pregnantNow;
	}

	public void setPregnantNow(Boolean pregnantNow) {
		this.pregnantNow = pregnantNow;
	}

	public Boolean getPptctReferred() {
		return pptctReferred;
	}

	public void setPptctReferred(Boolean pptctReferred) {
		this.pptctReferred = pptctReferred;
	}

	public Long getDeliveryOutcome() {
		return deliveryOutcome;
	}

	public void setDeliveryOutcome(Long deliveryOutcome) {
		this.deliveryOutcome = deliveryOutcome;
	}

	public String getOtherRemarks() {
		return otherRemarks;
	}

	public void setOtherRemarks(String otherRemarks) {
		this.otherRemarks = otherRemarks;
	}

}
