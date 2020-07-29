package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link gov.naco.soch.domain.ICTCSampleCollection} entity. This class is used
 * in {@link gov.naco.soch.web.rest.ICTCSampleCollectionResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ictc-sample-collections?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ICTCSampleCollectionCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter barcode;

    private IntegerFilter testType;
    
    private LocalDateFilter sampleCollectionDate;
    
    private IntegerFilter sampleCollectionStatus;
   
    private BooleanFilter isDispatched;

//    private IntegerFilter dispatchedToLabId;
//
//    private LocalDateFilter dispatchDate;

    private BooleanFilter isActive;

    private BooleanFilter isDeleted;

    private IntegerFilter createdBy;

    private LocalDateFilter createdTime;

    private IntegerFilter modifiedBy;

    private LocalDateFilter modifiedTime;

    private LongFilter batchId;
   
	private LongFilter ictcBeneficiaryId;
	
	private LongFilter visitId;
	
	private LongFilter facilityId;

    public ICTCSampleCollectionCriteria() {
    }

    public ICTCSampleCollectionCriteria(ICTCSampleCollectionCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.barcode = other.barcode == null ? null : other.barcode.copy();
        this.testType = other.testType == null ? null : other.testType.copy();
        this.sampleCollectionDate = other.sampleCollectionDate == null ? null : other.sampleCollectionDate.copy();
        this.sampleCollectionStatus = other.sampleCollectionStatus == null ? null : other.sampleCollectionStatus.copy();
        this.isDispatched = other.isDispatched == null ? null : other.isDispatched.copy();
//        this.dispatchedToLabId = other.dispatchedToLabId == null ? null : other.dispatchedToLabId.copy();
//        this.dispatchDate = other.dispatchDate == null ? null : other.dispatchDate.copy();
        this.isActive = other.isActive == null ? null : other.isActive.copy();
        this.isDeleted = other.isDeleted == null ? null : other.isDeleted.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
        this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
        this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
        this.ictcBeneficiaryId = other.ictcBeneficiaryId == null ? null : other.ictcBeneficiaryId.copy();
        this.visitId = other.visitId == null ? null : other.visitId.copy();
        this.batchId = other.batchId == null ? null : other.batchId.copy();
        this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
    }

    @Override
    public ICTCSampleCollectionCriteria copy() {
        return new ICTCSampleCollectionCriteria(this);
    }

    public LongFilter getId() {
		return id;
	}

	public void setId(LongFilter id) {
		this.id = id;
	}

	public StringFilter getBarcode() {
		return barcode;
	}

	public void setBarcode(StringFilter barcode) {
		this.barcode = barcode;
	}

	public IntegerFilter getTestType() {
		return testType;
	}

	public void setTestType(IntegerFilter testType) {
		this.testType = testType;
	}

	public LocalDateFilter getSampleCollectionDate() {
		return sampleCollectionDate;
	}

	public void setSampleCollectionDate(LocalDateFilter sampleCollectionDate) {
		this.sampleCollectionDate = sampleCollectionDate;
	}

	public IntegerFilter getSampleCollectionStatus() {
		return sampleCollectionStatus;
	}

	public void setSampleCollectionStatus(IntegerFilter sampleCollectionStatus) {
		this.sampleCollectionStatus = sampleCollectionStatus;
	}

	public BooleanFilter getIsDispatched() {
		return isDispatched;
	}

	public void setIsDispatched(BooleanFilter isDispatched) {
		this.isDispatched = isDispatched;
	}

//	public IntegerFilter getDispatchedToLabId() {
//		return dispatchedToLabId;
//	}
//
//	public void setDispatchedToLabId(IntegerFilter dispatchedToLabId) {
//		this.dispatchedToLabId = dispatchedToLabId;
//	}
//
//	public LocalDateFilter getDispatchDate() {
//		return dispatchDate;
//	}
//
//	public void setDispatchDate(LocalDateFilter dispatchDate) {
//		this.dispatchDate = dispatchDate;
//	}

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

	public LongFilter getBatchId() {
		return batchId;
	}

	public void setBatchId(LongFilter batchId) {
		this.batchId = batchId;
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
	
    @Override
	public int hashCode() {
		return Objects.hash(barcode, batchId, createdBy, createdTime, facilityId, ictcBeneficiaryId, id, isActive,
				isDeleted, isDispatched, modifiedBy, modifiedTime, sampleCollectionDate, sampleCollectionStatus,
				testType, visitId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ICTCSampleCollectionCriteria other = (ICTCSampleCollectionCriteria) obj;
		return Objects.equals(barcode, other.barcode) && Objects.equals(batchId, other.batchId)
				&& Objects.equals(createdBy, other.createdBy) && Objects.equals(createdTime, other.createdTime)
				&& Objects.equals(facilityId, other.facilityId)
				&& Objects.equals(ictcBeneficiaryId, other.ictcBeneficiaryId) && Objects.equals(id, other.id)
				&& Objects.equals(isActive, other.isActive) && Objects.equals(isDeleted, other.isDeleted)
				&& Objects.equals(isDispatched, other.isDispatched) && Objects.equals(modifiedBy, other.modifiedBy)
				&& Objects.equals(modifiedTime, other.modifiedTime)
				&& Objects.equals(sampleCollectionDate, other.sampleCollectionDate)
				&& Objects.equals(sampleCollectionStatus, other.sampleCollectionStatus)
				&& Objects.equals(testType, other.testType) && Objects.equals(visitId, other.visitId);
	}

	@Override
	public String toString() {
		return "ICTCSampleCollectionCriteria [id=" + id + ", barcode=" + barcode + ", testType=" + testType
				+ ", sampleCollectionDate=" + sampleCollectionDate + ", sampleCollectionStatus="
				+ sampleCollectionStatus + ", isDispatched=" + isDispatched + ", isActive=" + isActive + ", isDeleted="
				+ isDeleted + ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy
				+ ", modifiedTime=" + modifiedTime + ", batchId=" + batchId + ", ictcBeneficiaryId=" + ictcBeneficiaryId
				+ ", visitId=" + visitId + ", facilityId=" + facilityId + "]";
	}

}
