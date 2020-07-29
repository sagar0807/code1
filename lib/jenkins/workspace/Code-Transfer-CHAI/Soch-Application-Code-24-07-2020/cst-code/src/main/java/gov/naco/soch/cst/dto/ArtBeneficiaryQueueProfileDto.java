package gov.naco.soch.cst.dto;

import java.time.LocalDate;
import java.util.List;

public class ArtBeneficiaryQueueProfileDto {

	private Long visitRegisterId;

	private Long beneficiaryId;

	private LocalDate visitDate;
	private List<BeneficiarySocialWelfareDto> socialWelfareSchemes;
	private Long pillsRemaining;
	private Long adherenceToArt;
	private String anyOtherMedicine;
	private String updateConsellingNotes;

	private Long regimenId;
	private String regimen;
	private Long newRegimenId;
	private String newRegimen;
	private Long artRegimenActionId;
	private String artRegimenAction;
	private Long artRegimenActionReasonId;
	private String artRegimenActionReason;

	private List<ArtBeneficiaryConcurrentConditionDto> concurrentConditionList;
	private List<ArtBeneficiarySideEffectDto> artSideEffectsList;

	private LocalDate lastVisitDate;
	private Float weight;
	private Float height;
	private Long functionalStatusId;
	private String functionalStatus;
	private Long clinicalStageId;
	private String clinicalStage;

	private Boolean tbTreatment;

	private Long tbRegimenId;
	private String tbRegimen;

	private List<ArtBeneficiaryOpportunisticInfectionDto> opportunisticInfectionList;
	private Boolean drugspPrescribedForOI;
	private Boolean isFourSSymptoms;
	private List<BeneficiaryFourSSymptomsPerVisitDto> fourSSymptomsPerVisitList;
	private String others;

	private LocalDate nextVisitDate;
	private Long nextRoleId;
	private Long nextUserId;

	public Long getVisitRegisterId() {
		return visitRegisterId;
	}

	public void setVisitRegisterId(Long visitRegisterId) {
		this.visitRegisterId = visitRegisterId;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public List<BeneficiarySocialWelfareDto> getSocialWelfareSchemes() {
		return socialWelfareSchemes;
	}

	public void setSocialWelfareSchemes(List<BeneficiarySocialWelfareDto> socialWelfareSchemes) {
		this.socialWelfareSchemes = socialWelfareSchemes;
	}

	public Long getPillsRemaining() {
		return pillsRemaining;
	}

	public void setPillsRemaining(Long pillsRemaining) {
		this.pillsRemaining = pillsRemaining;
	}

	public Long getAdherenceToArt() {
		return adherenceToArt;
	}

	public void setAdherenceToArt(Long adherenceToArt) {
		this.adherenceToArt = adherenceToArt;
	}

	public String getAnyOtherMedicine() {
		return anyOtherMedicine;
	}

	public void setAnyOtherMedicine(String anyOtherMedicine) {
		this.anyOtherMedicine = anyOtherMedicine;
	}

	public String getUpdateConsellingNotes() {
		return updateConsellingNotes;
	}

	public void setUpdateConsellingNotes(String updateConsellingNotes) {
		this.updateConsellingNotes = updateConsellingNotes;
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

	public Long getNewRegimenId() {
		return newRegimenId;
	}

	public void setNewRegimenId(Long newRegimenId) {
		this.newRegimenId = newRegimenId;
	}

	public String getNewRegimen() {
		return newRegimen;
	}

	public void setNewRegimen(String newRegimen) {
		this.newRegimen = newRegimen;
	}

	public List<ArtBeneficiaryConcurrentConditionDto> getConcurrentConditionList() {
		return concurrentConditionList;
	}

	public void setConcurrentConditionList(List<ArtBeneficiaryConcurrentConditionDto> concurrentConditionList) {
		this.concurrentConditionList = concurrentConditionList;
	}

	public List<ArtBeneficiarySideEffectDto> getArtSideEffectsList() {
		return artSideEffectsList;
	}

	public void setArtSideEffectsList(List<ArtBeneficiarySideEffectDto> artSideEffectsList) {
		this.artSideEffectsList = artSideEffectsList;
	}

	public LocalDate getLastVisitDate() {
		return lastVisitDate;
	}

	public void setLastVisitDate(LocalDate lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Long getFunctionalStatusId() {
		return functionalStatusId;
	}

	public void setFunctionalStatusId(Long functionalStatusId) {
		this.functionalStatusId = functionalStatusId;
	}

	public String getFunctionalStatus() {
		return functionalStatus;
	}

	public void setFunctionalStatus(String functionalStatus) {
		this.functionalStatus = functionalStatus;
	}

	public Long getClinicalStageId() {
		return clinicalStageId;
	}

	public void setClinicalStageId(Long clinicalStageId) {
		this.clinicalStageId = clinicalStageId;
	}

	public String getClinicalStage() {
		return clinicalStage;
	}

	public void setClinicalStage(String clinicalStage) {
		this.clinicalStage = clinicalStage;
	}

	public Boolean getTbTreatment() {
		return tbTreatment;
	}

	public void setTbTreatment(Boolean tbTreatment) {
		this.tbTreatment = tbTreatment;
	}

	public Long getTbRegimenId() {
		return tbRegimenId;
	}

	public void setTbRegimenId(Long tbRegimenId) {
		this.tbRegimenId = tbRegimenId;
	}

	public String getTbRegimen() {
		return tbRegimen;
	}

	public void setTbRegimen(String tbRegimen) {
		this.tbRegimen = tbRegimen;
	}

	public List<ArtBeneficiaryOpportunisticInfectionDto> getOpportunisticInfectionList() {
		return opportunisticInfectionList;
	}

	public void setOpportunisticInfectionList(
			List<ArtBeneficiaryOpportunisticInfectionDto> opportunisticInfectionList) {
		this.opportunisticInfectionList = opportunisticInfectionList;
	}

	public Boolean getDrugspPrescribedForOI() {
		return drugspPrescribedForOI;
	}

	public void setDrugspPrescribedForOI(Boolean drugspPrescribedForOI) {
		this.drugspPrescribedForOI = drugspPrescribedForOI;
	}

	public Boolean getIsFourSSymptoms() {
		return isFourSSymptoms;
	}

	public void setIsFourSSymptoms(Boolean isFourSSymptoms) {
		this.isFourSSymptoms = isFourSSymptoms;
	}

	public List<BeneficiaryFourSSymptomsPerVisitDto> getFourSSymptomsPerVisitList() {
		return fourSSymptomsPerVisitList;
	}

	public void setFourSSymptomsPerVisitList(List<BeneficiaryFourSSymptomsPerVisitDto> fourSSymptomsPerVisitList) {
		this.fourSSymptomsPerVisitList = fourSSymptomsPerVisitList;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public LocalDate getNextVisitDate() {
		return nextVisitDate;
	}

	public void setNextVisitDate(LocalDate nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}

	public Long getNextRoleId() {
		return nextRoleId;
	}

	public void setNextRoleId(Long nextRoleId) {
		this.nextRoleId = nextRoleId;
	}

	public Long getNextUserId() {
		return nextUserId;
	}

	public void setNextUserId(Long nextUserId) {
		this.nextUserId = nextUserId;
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

}
