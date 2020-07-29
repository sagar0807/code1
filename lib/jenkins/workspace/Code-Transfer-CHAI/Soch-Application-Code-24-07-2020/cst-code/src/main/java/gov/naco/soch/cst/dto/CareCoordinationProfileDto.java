package gov.naco.soch.cst.dto;

import java.time.LocalDate;
import java.util.List;

public class CareCoordinationProfileDto {
	private Long id;
	private Long beneficiaryId;
	private LocalDate lastVisitDate;
	private String visitBy;
	private Boolean isFourSSymptoms;
	private List<BeneficiaryFourSSymptomsPerVisitDto> fourSSysmptomsValue;
	private Float previousHeight;
	private Float previousWeight;
	private Float height;
	private Float weight;
	private Long assignToNextUser;
	private BeneficiaryLabTestDetailsDto labTestDetailsDto;
	private Long regimenId;
	private String regimenName;
	private Long lastAdherenceValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getLastVisitDate() {
		return lastVisitDate;
	}

	public void setLastVisitDate(LocalDate lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}

	public String getVisitBy() {
		return visitBy;
	}

	public void setVisitBy(String visitBy) {
		this.visitBy = visitBy;
	}

	public Boolean getIsFourSSymptoms() {
		return isFourSSymptoms;
	}

	public void setIsFourSSymptoms(Boolean isFourSSymptoms) {
		this.isFourSSymptoms = isFourSSymptoms;
	}

	public List<BeneficiaryFourSSymptomsPerVisitDto> getFourSSysmptomsValue() {
		return fourSSysmptomsValue;
	}

	public void setFourSSysmptomsValue(List<BeneficiaryFourSSymptomsPerVisitDto> fourSSysmptomsValue) {
		this.fourSSysmptomsValue = fourSSysmptomsValue;
	}

	public Float getPreviousHeight() {
		return previousHeight;
	}

	public void setPreviousHeight(Float previousHeight) {
		this.previousHeight = previousHeight;
	}

	public Float getPreviousWeight() {
		return previousWeight;
	}

	public void setPreviousWeight(Float previousWeight) {
		this.previousWeight = previousWeight;
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

	public Long getAssignToNextUser() {
		return assignToNextUser;
	}

	public void setAssignToNextUser(Long assignToNextUser) {
		this.assignToNextUser = assignToNextUser;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public BeneficiaryLabTestDetailsDto getLabTestDetailsDto() {
		return labTestDetailsDto;
	}

	public void setLabTestDetailsDto(BeneficiaryLabTestDetailsDto labTestDetailsDto) {
		this.labTestDetailsDto = labTestDetailsDto;
	}

	public Long getRegimenId() {
		return regimenId;
	}

	public void setRegimenId(Long regimenId) {
		this.regimenId = regimenId;
	}

	public String getRegimenName() {
		return regimenName;
	}

	public void setRegimenName(String regimenName) {
		this.regimenName = regimenName;
	}

	public Long getLastAdherenceValue() {
		return lastAdherenceValue;
	}

	public void setLastAdherenceValue(Long lastAdherenceValue) {
		this.lastAdherenceValue = lastAdherenceValue;
	}

	@Override
	public String toString() {
		return "CareCoordinationProfileDto [id=" + id + ", beneficiaryId=" + beneficiaryId + ", lastVisitDate="
				+ lastVisitDate + ", visitBy=" + visitBy + ", isFourSSymptoms=" + isFourSSymptoms
				+ ", fourSSysmptomsValue=" + fourSSysmptomsValue + ", previousHeight=" + previousHeight
				+ ", previousWeight=" + previousWeight + ", height=" + height + ", weight=" + weight
				+ ", assignToNextUser=" + assignToNextUser + ", labTestDetailsDto=" + labTestDetailsDto + ", regimenId="
				+ regimenId + ", regimenName=" + regimenName + ", lastAdherenceValue=" + lastAdherenceValue + "]";
	}
}
