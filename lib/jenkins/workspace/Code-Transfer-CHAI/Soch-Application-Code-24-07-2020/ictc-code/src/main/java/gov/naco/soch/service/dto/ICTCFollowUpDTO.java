package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.ICTCFollowUp} entity.
 */
public class ICTCFollowUpDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;

	private Integer followUpType;

	private LocalDate followUpDate;

//	private String remarks;

	private Boolean isCompleted;

	private Boolean isActive;

	private Boolean isDeleted;

	private Integer createdBy;

	private LocalDate createdTime;

	private Integer modifiedBy;

	private LocalDate modifiedTime;

	private Long ictcBeneficiaryId;

	private Long visitId;

	private Long facilityId;

	private Long testResultId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getFollowUpType() {
		return followUpType;
	}

	public void setFollowUpType(Integer followUpType) {
		this.followUpType = followUpType;
	}

	public LocalDate getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(LocalDate followUpDate) {
		this.followUpDate = followUpDate;
	}

//	public String getRemarks() {
//		return remarks;
//	}
//
//	public void setRemarks(String remarks) {
//		this.remarks = remarks;
//	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDate createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDate getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDate modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Long getIctcBeneficiaryId() {
		return ictcBeneficiaryId;
	}

	public void setIctcBeneficiaryId(Long ictcBeneficiaryId) {
		this.ictcBeneficiaryId = ictcBeneficiaryId;
	}

	public Long getVisitId() {
		return visitId;
	}

	public void setVisitId(Long visitId) {
		this.visitId = visitId;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public Long getTestResultId() {
		return testResultId;
	}

	public void setTestResultId(Long testResultId) {
		this.testResultId = testResultId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		ICTCFollowUpDTO iCTCFollowUpDTO = (ICTCFollowUpDTO) o;
		if (iCTCFollowUpDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), iCTCFollowUpDTO.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "ICTCFollowUpDTO [id=" + id + ", followUpType=" + followUpType + ", followUpDate=" + followUpDate
				+ ", isCompleted=" + isCompleted + ", isActive=" + isActive + ", isDeleted=" + isDeleted
				+ ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy
				+ ", modifiedTime=" + modifiedTime + ", ictcBeneficiaryId=" + ictcBeneficiaryId + ", visitId=" + visitId
				+ ", facilityId=" + facilityId + ", testResultId=" + testResultId + "]";
	}

}
