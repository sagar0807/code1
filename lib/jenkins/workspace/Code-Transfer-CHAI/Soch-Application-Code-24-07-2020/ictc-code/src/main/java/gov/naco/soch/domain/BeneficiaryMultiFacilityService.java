package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Beneficiary.
 */
@Entity
@Table(name = "beneficiary_multi_facility_service")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BeneficiaryMultiFacilityService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "beneficiary_id")
	private Long beneficiaryId;
	
	@Column(name = "ictc_visit_id")
	private Long ictcVisitId;
	
	@Column(name = "registered_facility_id")
	private Long registeredFacilityId;
	
	@Column(name = "visited_facility_id")
	private Long visitedFacilityId;
	
	@Column(name = "visit_date")
	private LocalDate visitDate;
	
	@Column(name = "follow_up_date")
	private LocalDate followUpDate;
	
	@Column(name = "is_post_test_counselling_completed")
	private Boolean isIctcPostTestCounsellingCompleted;
	
	@Column(name = "post_test_counselling_date")
	private LocalDate postTestCounsellingDate;
	
	@Column(name = "beneficiary_global_visit_id")
	private Long beneficiaryGlobalVisitId;

	@Column(name = "is_active")
	private Boolean isActive;
	
	@Column(name = "is_deleted")
	private Boolean isDeleted;
	
	@Column(name = "created_by")
	private Long createdBy;
	
	@Column(name = "created_time")
	private LocalDate createdTime;
	
	@Column(name = "modified_by")
	private Long modifiedBy;
	
	@Column(name = "modified_time")
	private LocalDate modifiedTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Long getIctcVisitId() {
		return ictcVisitId;
	}

	public void setIctcVisitId(Long ictcVisitId) {
		this.ictcVisitId = ictcVisitId;
	}

	public Long getRegisteredFacilityId() {
		return registeredFacilityId;
	}

	public void setRegisteredFacilityId(Long registeredFacilityId) {
		this.registeredFacilityId = registeredFacilityId;
	}

	public Long getVisitedFacilityId() {
		return visitedFacilityId;
	}

	public void setVisitedFacilityId(Long visitedFacilityId) {
		this.visitedFacilityId = visitedFacilityId;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public LocalDate getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(LocalDate followUpDate) {
		this.followUpDate = followUpDate;
	}

	public Boolean getIsIctcPostTestCounsellingCompleted() {
		return isIctcPostTestCounsellingCompleted;
	}

	public void setIsIctcPostTestCounsellingCompleted(Boolean isIctcPostTestCounsellingCompleted) {
		this.isIctcPostTestCounsellingCompleted = isIctcPostTestCounsellingCompleted;
	}

	public LocalDate getPostTestCounsellingDate() {
		return postTestCounsellingDate;
	}

	public void setPostTestCounsellingDate(LocalDate postTestCounsellingDate) {
		this.postTestCounsellingDate = postTestCounsellingDate;
	}

	public Long getBeneficiaryGlobalVisitId() {
		return beneficiaryGlobalVisitId;
	}

	public void setBeneficiaryGlobalVisitId(Long beneficiaryGlobalVisitId) {
		this.beneficiaryGlobalVisitId = beneficiaryGlobalVisitId;
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

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDate createdTime) {
		this.createdTime = createdTime;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDate getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDate modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "BeneficiaryMultiFacilityService [id=" + id + ", beneficiaryId=" + beneficiaryId + ", ictcVisitId="
				+ ictcVisitId + ", registeredFacilityId=" + registeredFacilityId + ", visitedFacilityId="
				+ visitedFacilityId + ", visitDate=" + visitDate + ", followUpDate=" + followUpDate
				+ ", isIctcPostTestCounsellingCompleted=" + isIctcPostTestCounsellingCompleted
				+ ", postTestCounsellingDate=" + postTestCounsellingDate + ", beneficiaryGlobalVisitId="
				+ beneficiaryGlobalVisitId + ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", createdBy="
				+ createdBy + ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy + ", modifiedTime="
				+ modifiedTime + "]";
	}
	
}
