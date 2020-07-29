package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;

/**
 * Criteria class for the {@link gov.naco.soch.domain.ICTCFollowUp} entity. This class is used
 * in {@link gov.naco.soch.web.rest.ICTCFollowUpResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ictc-follow-ups?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ICTCFollowUpCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private IntegerFilter followUpType;

    private LocalDateFilter followUpDate;

//    private StringFilter remarks;

    private BooleanFilter isCompleted;
    
    private BooleanFilter isActive;

    private BooleanFilter isDeleted;

    private IntegerFilter createdBy;

    private LocalDateFilter createdTime;

    private IntegerFilter modifiedBy;

    private LocalDateFilter modifiedTime;

    private LongFilter ictcBeneficiaryId;

    private LongFilter visitId;
    
    private LongFilter facilityId;
    
    private LongFilter testResultId;

    public ICTCFollowUpCriteria() {
    }

    public ICTCFollowUpCriteria(ICTCFollowUpCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.followUpType = other.followUpType == null ? null : other.followUpType.copy();
        this.followUpDate = other.followUpDate == null ? null : other.followUpDate.copy();
//        this.remarks = other.remarks == null ? null : other.remarks.copy();
        this.isCompleted = other.isCompleted == null ? null : other.isCompleted.copy();
        this.isActive = other.isActive == null ? null : other.isActive.copy();
        this.isDeleted = other.isDeleted == null ? null : other.isDeleted.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
        this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
        this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
        this.visitId = other.visitId == null ? null : other.visitId.copy();
        this.ictcBeneficiaryId = other.ictcBeneficiaryId == null ? null : other.ictcBeneficiaryId.copy();
        this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
        this.testResultId = other.testResultId == null ? null : other.testResultId.copy();
    }

    @Override
    public ICTCFollowUpCriteria copy() {
        return new ICTCFollowUpCriteria(this);
    }

   

    public LongFilter getId() {
		return id;
	}

	public void setId(LongFilter id) {
		this.id = id;
	}

	public IntegerFilter getFollowUpType() {
		return followUpType;
	}

	public void setFollowUpType(IntegerFilter followUpType) {
		this.followUpType = followUpType;
	}

	public LocalDateFilter getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(LocalDateFilter followUpDate) {
		this.followUpDate = followUpDate;
	}

//	public StringFilter getRemarks() {
//		return remarks;
//	}
//
//	public void setRemarks(StringFilter remarks) {
//		this.remarks = remarks;
//	}

	public BooleanFilter getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(BooleanFilter isCompleted) {
		this.isCompleted = isCompleted;
	}

	public BooleanFilter getIsActive() {
		return isActive;
	}

	public void setIsActive(BooleanFilter isActive) {
		this.isActive = isActive;
	}

	public BooleanFilter getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(BooleanFilter isDeleted) {
		this.isDeleted = isDeleted;
	}

	public IntegerFilter getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(IntegerFilter createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateFilter getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateFilter createdTime) {
		this.createdTime = createdTime;
	}

	public IntegerFilter getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(IntegerFilter modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateFilter getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateFilter modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public LongFilter getIctcBeneficiaryId() {
		return ictcBeneficiaryId;
	}

	public void setIctcBeneficiaryId(LongFilter ictcBeneficiaryId) {
		this.ictcBeneficiaryId = ictcBeneficiaryId;
	}

	public LongFilter getVisitId() {
		return visitId;
	}

	public void setVisitId(LongFilter visitId) {
		this.visitId = visitId;
	}

	public LongFilter getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(LongFilter facilityId) {
		this.facilityId = facilityId;
	}

	public LongFilter getTestResultId() {
		return testResultId;
	}

	public void setTestResultId(LongFilter testResultId) {
		this.testResultId = testResultId;
	}

	

    @Override
	public int hashCode() {
		return Objects.hash(createdBy, createdTime, facilityId, followUpDate, followUpType, ictcBeneficiaryId, id,
				isActive, isCompleted, isDeleted, modifiedBy, modifiedTime, testResultId, visitId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ICTCFollowUpCriteria other = (ICTCFollowUpCriteria) obj;
		return Objects.equals(createdBy, other.createdBy) && Objects.equals(createdTime, other.createdTime)
				&& Objects.equals(facilityId, other.facilityId) && Objects.equals(followUpDate, other.followUpDate)
				&& Objects.equals(followUpType, other.followUpType)
				&& Objects.equals(ictcBeneficiaryId, other.ictcBeneficiaryId) && Objects.equals(id, other.id)
				&& Objects.equals(isActive, other.isActive) && Objects.equals(isCompleted, other.isCompleted)
				&& Objects.equals(isDeleted, other.isDeleted) && Objects.equals(modifiedBy, other.modifiedBy)
				&& Objects.equals(modifiedTime, other.modifiedTime) && Objects.equals(testResultId, other.testResultId)
				&& Objects.equals(visitId, other.visitId);
	}

	@Override
	public String toString() {
		return "ICTCFollowUpCriteria [id=" + id + ", followUpType=" + followUpType + ", followUpDate=" + followUpDate
				+ ", isCompleted=" + isCompleted + ", isActive=" + isActive + ", isDeleted=" + isDeleted
				+ ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy
				+ ", modifiedTime=" + modifiedTime + ", ictcBeneficiaryId=" + ictcBeneficiaryId + ", visitId=" + visitId
				+ ", facilityId=" + facilityId + ", testResultId=" + testResultId + "]";
	}

}
