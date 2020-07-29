package gov.naco.soch.cst.dto;

import java.time.LocalDate;
import java.util.List;

import gov.naco.soch.cst.controller.ArtOpportunisticInfectionSummaryDto;

public class ArtBeneficiaryStaffNurseProfileDto {

	private Long visitRegisterId;
	private Long beneficiaryId;
	private LocalDate visitDate;
	private String socialWelfareScheme;
	private Long pillsRemaining;
	private Long adherenceToArt;
	private String anyOtherMedicine;
	private String updateConsellingNotes;
	private Long regimenId;
	private String regimen;
	private Long newRegimenId;
	private String newRegimen;
	private List<ArtBeneficiaryConcurrentConditionDto> concurrentConditionList;
	private List<ArtBeneficiarySideEffectDto> artSideEffectsList;
	private List<ArtOpportunisticInfectionSummaryDto> concurrentConditionSummary;
	private List<ArtBeneficiaryStatusSummaryDto> beneficiaryArtStatusSummary;
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

	private ArtBeneficiaryIptAttDetailsDto tbOIInformations;

	private Long iptAttDetailsId;
	private Boolean tbHistory;
	private LocalDate iptStartDate;
	private LocalDate iptStopDate;
	private LocalDate iptRestartDate;
	private LocalDate iptEndDate;
	private LocalDate tbDiagnosis;
	private Long nikshayId;
	private LocalDate attStartDate;
	private LocalDate cptStartDate;
	private Boolean rifResistance;
	private Long diagnosedById;
	private Long treatmentUnderId;
	private LocalDate tbTreatmentCompletionDate;
	private LocalDate entryDate;
	private Long fourSScreeningId;
	private Long iptStatusId;
	private Long tbDiagnosisId;
	private Long tbTreatmentStatusId;
	private Long typeOfTest;
	private String tbTestTypeOther;
	
	private Long opportunisticInfectionId;

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

	public String getSocialWelfareScheme() {
		return socialWelfareScheme;
	}

	public void setSocialWelfareScheme(String socialWelfareScheme) {
		this.socialWelfareScheme = socialWelfareScheme;
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

	public ArtBeneficiaryIptAttDetailsDto getTbOIInformations() {
		return tbOIInformations;
	}

	public void setTbOIInformations(ArtBeneficiaryIptAttDetailsDto tbOIInformations) {
		this.tbOIInformations = tbOIInformations;
	}

	public Long getIptAttDetailsId() {
		return iptAttDetailsId;
	}

	public void setIptAttDetailsId(Long iptAttDetailsId) {
		this.iptAttDetailsId = iptAttDetailsId;
	}

	public Boolean getTbHistory() {
		return tbHistory;
	}

	public void setTbHistory(Boolean tbHistory) {
		this.tbHistory = tbHistory;
	}

	public LocalDate getIptStartDate() {
		return iptStartDate;
	}

	public void setIptStartDate(LocalDate iptStartDate) {
		this.iptStartDate = iptStartDate;
	}

	public LocalDate getIptStopDate() {
		return iptStopDate;
	}

	public void setIptStopDate(LocalDate iptStopDate) {
		this.iptStopDate = iptStopDate;
	}

	public LocalDate getIptRestartDate() {
		return iptRestartDate;
	}

	public void setIptRestartDate(LocalDate iptRestartDate) {
		this.iptRestartDate = iptRestartDate;
	}

	public LocalDate getIptEndDate() {
		return iptEndDate;
	}

	public void setIptEndDate(LocalDate iptEndDate) {
		this.iptEndDate = iptEndDate;
	}

	public LocalDate getTbDiagnosis() {
		return tbDiagnosis;
	}

	public void setTbDiagnosis(LocalDate tbDiagnosis) {
		this.tbDiagnosis = tbDiagnosis;
	}

	public Long getNikshayId() {
		return nikshayId;
	}

	public void setNikshayId(Long nikshayId) {
		this.nikshayId = nikshayId;
	}

	public LocalDate getAttStartDate() {
		return attStartDate;
	}

	public void setAttStartDate(LocalDate attStartDate) {
		this.attStartDate = attStartDate;
	}

	public LocalDate getCptStartDate() {
		return cptStartDate;
	}

	public void setCptStartDate(LocalDate cptStartDate) {
		this.cptStartDate = cptStartDate;
	}

	public Boolean getRifResistance() {
		return rifResistance;
	}

	public void setRifResistance(Boolean rifResistance) {
		this.rifResistance = rifResistance;
	}

	public Long getDiagnosedById() {
		return diagnosedById;
	}

	public void setDiagnosedById(Long diagnosedById) {
		this.diagnosedById = diagnosedById;
	}

	public Long getTreatmentUnderId() {
		return treatmentUnderId;
	}

	public void setTreatmentUnderId(Long treatmentUnderId) {
		this.treatmentUnderId = treatmentUnderId;
	}

	public LocalDate getTbTreatmentCompletionDate() {
		return tbTreatmentCompletionDate;
	}

	public void setTbTreatmentCompletionDate(LocalDate tbTreatmentCompletionDate) {
		this.tbTreatmentCompletionDate = tbTreatmentCompletionDate;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	public Long getFourSScreeningId() {
		return fourSScreeningId;
	}

	public void setFourSScreeningId(Long fourSScreeningId) {
		this.fourSScreeningId = fourSScreeningId;
	}

	public Long getIptStatusId() {
		return iptStatusId;
	}

	public void setIptStatusId(Long iptStatusId) {
		this.iptStatusId = iptStatusId;
	}

	public Long getTbDiagnosisId() {
		return tbDiagnosisId;
	}

	public void setTbDiagnosisId(Long tbDiagnosisId) {
		this.tbDiagnosisId = tbDiagnosisId;
	}

	public Long getTbTreatmentStatusId() {
		return tbTreatmentStatusId;
	}

	public void setTbTreatmentStatusId(Long tbTreatmentStatusId) {
		this.tbTreatmentStatusId = tbTreatmentStatusId;
	}

	public Long getTypeOfTest() {
		return typeOfTest;
	}

	public void setTypeOfTest(Long typeOfTest) {
		this.typeOfTest = typeOfTest;
	}
	
	public String getTbTestTypeOther() {
		return tbTestTypeOther;
	}

	public void setTbTestTypeOther(String tbTestTypeOther) {
		this.tbTestTypeOther = tbTestTypeOther;
	}

	public Long getOpportunisticInfectionId() {
		return opportunisticInfectionId;
	}

	public void setOpportunisticInfectionId(Long opportunisticInfectionId) {
		this.opportunisticInfectionId = opportunisticInfectionId;
	}

	public List<ArtOpportunisticInfectionSummaryDto> getConcurrentConditionSummary() {
		return concurrentConditionSummary;
	}

	public void setConcurrentConditionSummary(List<ArtOpportunisticInfectionSummaryDto> concurrentConditionSummary) {
		this.concurrentConditionSummary = concurrentConditionSummary;
	}
	
	public List<ArtBeneficiaryStatusSummaryDto> getBeneficiaryArtStatusSummary() {
		return beneficiaryArtStatusSummary;
	}

	public void setBeneficiaryArtStatusSummary(List<ArtBeneficiaryStatusSummaryDto> beneficiaryArtStatusSummary) {
		this.beneficiaryArtStatusSummary = beneficiaryArtStatusSummary;
	}

	@Override
	public String toString() {
		return "ArtBeneficiaryStaffNurseProfileDto [visitRegisterId=" + visitRegisterId + ", beneficiaryId="
				+ beneficiaryId + ", visitDate=" + visitDate + ", socialWelfareScheme=" + socialWelfareScheme
				+ ", pillsRemaining=" + pillsRemaining + ", adherenceToArt=" + adherenceToArt + ", anyOtherMedicine="
				+ anyOtherMedicine + ", updateConsellingNotes=" + updateConsellingNotes + ", regimenId=" + regimenId
				+ ", regimen=" + regimen + ", newRegimenId=" + newRegimenId + ", newRegimen=" + newRegimen
				+ ", concurrentConditionList=" + concurrentConditionList + ", artSideEffectsList=" + artSideEffectsList
				+ ", concurrentConditionSummary=" + concurrentConditionSummary + ", beneficiaryArtStatusSummary="
				+ beneficiaryArtStatusSummary + ", lastVisitDate=" + lastVisitDate + ", weight=" + weight + ", height="
				+ height + ", functionalStatusId=" + functionalStatusId + ", functionalStatus=" + functionalStatus
				+ ", clinicalStageId=" + clinicalStageId + ", clinicalStage=" + clinicalStage + ", tbTreatment="
				+ tbTreatment + ", tbRegimenId=" + tbRegimenId + ", tbRegimen=" + tbRegimen
				+ ", opportunisticInfectionList=" + opportunisticInfectionList + ", drugspPrescribedForOI="
				+ drugspPrescribedForOI + ", isFourSSymptoms=" + isFourSSymptoms + ", fourSSymptomsPerVisitList="
				+ fourSSymptomsPerVisitList + ", others=" + others + ", nextVisitDate=" + nextVisitDate
				+ ", nextRoleId=" + nextRoleId + ", nextUserId=" + nextUserId + ", tbOIInformations=" + tbOIInformations
				+ ", iptAttDetailsId=" + iptAttDetailsId + ", tbHistory=" + tbHistory + ", iptStartDate=" + iptStartDate
				+ ", iptStopDate=" + iptStopDate + ", iptRestartDate=" + iptRestartDate + ", iptEndDate=" + iptEndDate
				+ ", tbDiagnosis=" + tbDiagnosis + ", nikshayId=" + nikshayId + ", attStartDate=" + attStartDate
				+ ", cptStartDate=" + cptStartDate + ", rifResistance=" + rifResistance + ", diagnosedById="
				+ diagnosedById + ", treatmentUnderId=" + treatmentUnderId + ", tbTreatmentCompletionDate="
				+ tbTreatmentCompletionDate + ", entryDate=" + entryDate + ", fourSScreeningId=" + fourSScreeningId
				+ ", iptStatusId=" + iptStatusId + ", tbDiagnosisId=" + tbDiagnosisId + ", tbTreatmentStatusId="
				+ tbTreatmentStatusId + ", typeOfTest=" + typeOfTest + ", tbTestTypeOther=" + tbTestTypeOther
				+ ", opportunisticInfectionId=" + opportunisticInfectionId + "]";
	}

}
