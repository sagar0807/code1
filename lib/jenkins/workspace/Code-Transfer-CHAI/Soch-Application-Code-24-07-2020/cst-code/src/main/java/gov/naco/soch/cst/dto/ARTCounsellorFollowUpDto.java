package gov.naco.soch.cst.dto;

import java.time.LocalDate;
import java.util.List;

public class ARTCounsellorFollowUpDto {

	private Long artBeneficiaryFollowupId;
	private Long beneficiaryId;
	private LocalDate visitDate;
	private LocalDate nextVisitDate;
	private Float height;
	private Float weight;
	private Long functionalStatusId;
	private Long clinicalStageId;
	private List<Long> opportunisticInfections;
	private List<String> opportunisticInfectionsName;
	private Boolean drugsPrescribedForOpportunisticInfectionsProphylaxis;
	private Long regimen;
	private Long regimenDose;
	private Long remainingPills;
	private Long adherenceToArt;
	private String otherMedicines;
	private Boolean tBTreatment;
	private List<Long> aRTSideEffects;
	private List<String> aRTSideEffectsName;
	private List<Long> concurrentCondition;
	private List<String> concurrentConditionName;
	private Boolean isPregnant;
	private Boolean condomsGiven;
	private String remarks;
	private Long userMaster1;
	private String otherDrugsForOpportunisticInfections;

	// Linked art facility
	private Long linkedFacilityId;
	private Boolean isLinked;

	// transfer
	private String destinationFacilityType;
	private Long destinationFacilityId;
	private Boolean transferStatus;
	private Long transferStateId;
	private Long transferDistrictId;
	private Boolean isTransfer;
	// Refer
	private Long refferalStatusId;
	private Long referTo;
	private Boolean isRefer;

	// transit
	private List<Long> transistFacilityId;
	private Boolean isTransit;
	private LocalDate transitStartDate;
	private LocalDate transitEndDate;

	// Linkage
	private String linkageInstituteName;
	private Long linkageOrganisationTypeId;
	private List<Long> linkagePurposesId;
	private List<String> linkagePurposesName;

	public Long getArtBeneficiaryFollowupId() {
		return artBeneficiaryFollowupId;
	}

	public void setArtBeneficiaryFollowupId(Long artBeneficiaryFollowupId) {
		this.artBeneficiaryFollowupId = artBeneficiaryFollowupId;
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

	public LocalDate getNextVisitDate() {
		return nextVisitDate;
	}

	public void setNextVisitDate(LocalDate nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Long getFunctionalStatusId() {
		return functionalStatusId;
	}

	public void setFunctionalStatusId(Long functionalStatusId) {
		this.functionalStatusId = functionalStatusId;
	}

	public Long getClinicalStageId() {
		return clinicalStageId;
	}

	public void setClinicalStageId(Long clinicalStageId) {
		this.clinicalStageId = clinicalStageId;
	}

	public Boolean getDrugsPrescribedForOpportunisticInfectionsProphylaxis() {
		return drugsPrescribedForOpportunisticInfectionsProphylaxis;
	}

	public void setDrugsPrescribedForOpportunisticInfectionsProphylaxis(
			Boolean drugsPrescribedForOpportunisticInfectionsProphylaxis) {
		this.drugsPrescribedForOpportunisticInfectionsProphylaxis = drugsPrescribedForOpportunisticInfectionsProphylaxis;
	}

	public Long getRegimen() {
		return regimen;
	}

	public void setRegimen(Long regimen) {
		this.regimen = regimen;
	}

	public Long getRegimenDose() {
		return regimenDose;
	}

	public void setRegimenDose(Long regimenDose) {
		this.regimenDose = regimenDose;
	}

	public Long getRemainingPills() {
		return remainingPills;
	}

	public void setRemainingPills(Long remainingPills) {
		this.remainingPills = remainingPills;
	}

	public Long getAdherenceToArt() {
		return adherenceToArt;
	}

	public void setAdherenceToArt(Long adherenceToArt) {
		this.adherenceToArt = adherenceToArt;
	}

	public String getOtherMedicines() {
		return otherMedicines;
	}

	public void setOtherMedicines(String otherMedicines) {
		this.otherMedicines = otherMedicines;
	}

	public Boolean gettBTreatment() {
		return tBTreatment;
	}

	public void settBTreatment(Boolean tBTreatment) {
		this.tBTreatment = tBTreatment;
	}

	public List<Long> getOpportunisticInfections() {
		return opportunisticInfections;
	}

	public void setOpportunisticInfections(List<Long> opportunisticInfections) {
		this.opportunisticInfections = opportunisticInfections;
	}

	public List<Long> getaRTSideEffects() {
		return aRTSideEffects;
	}

	public void setaRTSideEffects(List<Long> aRTSideEffects) {
		this.aRTSideEffects = aRTSideEffects;
	}

	public List<Long> getConcurrentCondition() {
		return concurrentCondition;
	}

	public void setConcurrentCondition(List<Long> concurrentCondition) {
		this.concurrentCondition = concurrentCondition;
	}

	public Boolean getIsPregnant() {
		return isPregnant;
	}

	public void setIsPregnant(Boolean isPregnant) {
		this.isPregnant = isPregnant;
	}

	public Boolean getCondomsGiven() {
		return condomsGiven;
	}

	public void setCondomsGiven(Boolean condomsGiven) {
		this.condomsGiven = condomsGiven;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getUserMaster1() {
		return userMaster1;
	}

	public void setUserMaster1(Long userMaster1) {
		this.userMaster1 = userMaster1;
	}

	public Long getLinkedFacilityId() {
		return linkedFacilityId;
	}

	public void setLinkedFacilityId(Long linkedFacilityId) {
		this.linkedFacilityId = linkedFacilityId;
	}

	public Boolean getIsLinked() {
		return isLinked;
	}

	public void setIsLinked(Boolean isLinked) {
		this.isLinked = isLinked;
	}

	public String getDestinationFacilityType() {
		return destinationFacilityType;
	}

	public void setDestinationFacilityType(String destinationFacilityType) {
		this.destinationFacilityType = destinationFacilityType;
	}

	public Long getDestinationFacilityId() {
		return destinationFacilityId;
	}

	public void setDestinationFacilityId(Long destinationFacilityId) {
		this.destinationFacilityId = destinationFacilityId;
	}

	public Boolean getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(Boolean transferStatus) {
		this.transferStatus = transferStatus;
	}

	public Long getTransferStateId() {
		return transferStateId;
	}

	public void setTransferStateId(Long transferStateId) {
		this.transferStateId = transferStateId;
	}

	public Long getTransferDistrictId() {
		return transferDistrictId;
	}

	public void setTransferDistrictId(Long transferDistrictId) {
		this.transferDistrictId = transferDistrictId;
	}

	public Long getRefferalStatusId() {
		return refferalStatusId;
	}

	public void setRefferalStatusId(Long refferalStatusId) {
		this.refferalStatusId = refferalStatusId;
	}

	public Long getReferTo() {
		return referTo;
	}

	public void setReferTo(Long referTo) {
		this.referTo = referTo;
	}

	public List<Long> getTransistFacilityId() {
		return transistFacilityId;
	}

	public void setTransistFacilityId(List<Long> transistFacilityId) {
		this.transistFacilityId = transistFacilityId;
	}

	public Boolean getIsTransit() {
		return isTransit;
	}

	public void setIsTransit(Boolean isTransit) {
		this.isTransit = isTransit;
	}

	public LocalDate getTransitStartDate() {
		return transitStartDate;
	}

	public void setTransitStartDate(LocalDate transitStartDate) {
		this.transitStartDate = transitStartDate;
	}

	public LocalDate getTransitEndDate() {
		return transitEndDate;
	}

	public void setTransitEndDate(LocalDate transitEndDate) {
		this.transitEndDate = transitEndDate;
	}

	public String getLinkageInstituteName() {
		return linkageInstituteName;
	}

	public void setLinkageInstituteName(String linkageInstituteName) {
		this.linkageInstituteName = linkageInstituteName;
	}

	public Long getLinkageOrganisationTypeId() {
		return linkageOrganisationTypeId;
	}

	public void setLinkageOrganisationTypeId(Long linkageOrganisationTypeId) {
		this.linkageOrganisationTypeId = linkageOrganisationTypeId;
	}

	public List<Long> getLinkagePurposesId() {
		return linkagePurposesId;
	}

	public void setLinkagePurposesId(List<Long> linkagePurposesId) {
		this.linkagePurposesId = linkagePurposesId;
	}

	public List<String> getOpportunisticInfectionsName() {
		return opportunisticInfectionsName;
	}

	public void setOpportunisticInfectionsName(List<String> opportunisticInfectionsName) {
		this.opportunisticInfectionsName = opportunisticInfectionsName;
	}

	public List<String> getaRTSideEffectsName() {
		return aRTSideEffectsName;
	}

	public void setaRTSideEffectsName(List<String> aRTSideEffectsName) {
		this.aRTSideEffectsName = aRTSideEffectsName;
	}

	public List<String> getConcurrentConditionName() {
		return concurrentConditionName;
	}

	public void setConcurrentConditionName(List<String> concurrentConditionName) {
		this.concurrentConditionName = concurrentConditionName;
	}

	public List<String> getLinkagePurposesName() {
		return linkagePurposesName;
	}

	public void setLinkagePurposesName(List<String> linkagePurposesName) {
		this.linkagePurposesName = linkagePurposesName;
	}

	public Boolean getIsTransfer() {
		return isTransfer;
	}

	public void setIsTransfer(Boolean isTransfer) {
		this.isTransfer = isTransfer;
	}

	public Boolean getIsRefer() {
		return isRefer;
	}

	public void setIsRefer(Boolean isRefer) {
		this.isRefer = isRefer;
	}

	public String getOtherDrugsForOpportunisticInfections() {
		return otherDrugsForOpportunisticInfections;
	}

	public void setOtherDrugsForOpportunisticInfections(String otherDrugsForOpportunisticInfections) {
		this.otherDrugsForOpportunisticInfections = otherDrugsForOpportunisticInfections;
	}

	@Override
	public String toString() {
		return "ARTCounsellorFollowUpDto [artBeneficiaryFollowupId=" + artBeneficiaryFollowupId + ", beneficiaryId="
				+ beneficiaryId + ", visitDate=" + visitDate + ", nextVisitDate=" + nextVisitDate + ", height=" + height
				+ ", weight=" + weight + ", functionalStatusId=" + functionalStatusId + ", clinicalStageId="
				+ clinicalStageId + ", opportunisticInfections=" + opportunisticInfections
				+ ", opportunisticInfectionsName=" + opportunisticInfectionsName
				+ ", drugsPrescribedForOpportunisticInfectionsProphylaxis="
				+ drugsPrescribedForOpportunisticInfectionsProphylaxis + ", regimen=" + regimen + ", regimenDose="
				+ regimenDose + ", remainingPills=" + remainingPills + ", adherenceToArt=" + adherenceToArt
				+ ", otherMedicines=" + otherMedicines + ", tBTreatment=" + tBTreatment + ", aRTSideEffects="
				+ aRTSideEffects + ", aRTSideEffectsName=" + aRTSideEffectsName + ", concurrentCondition="
				+ concurrentCondition + ", concurrentConditionName=" + concurrentConditionName + ", isPregnant="
				+ isPregnant + ", condomsGiven=" + condomsGiven + ", remarks=" + remarks + ", userMaster1=" + userMaster1
				+ ", otherDrugsForOpportunisticInfections=" + otherDrugsForOpportunisticInfections
				+ ", linkedFacilityId=" + linkedFacilityId + ", isLinked=" + isLinked + ", destinationFacilityType="
				+ destinationFacilityType + ", destinationFacilityId=" + destinationFacilityId + ", transferStatus="
				+ transferStatus + ", transferStateId=" + transferStateId + ", transferDistrictId=" + transferDistrictId
				+ ", isTransfer=" + isTransfer + ", refferalStatusId=" + refferalStatusId + ", referTo=" + referTo
				+ ", isRefer=" + isRefer + ", transistFacilityId=" + transistFacilityId + ", isTransit=" + isTransit
				+ ", transitStartDate=" + transitStartDate + ", transitEndDate=" + transitEndDate
				+ ", linkageInstituteName=" + linkageInstituteName + ", linkageOrganisationTypeId="
				+ linkageOrganisationTypeId + ", linkagePurposesId=" + linkagePurposesId + ", linkagePurposesName="
				+ linkagePurposesName + "]";
	}
}
