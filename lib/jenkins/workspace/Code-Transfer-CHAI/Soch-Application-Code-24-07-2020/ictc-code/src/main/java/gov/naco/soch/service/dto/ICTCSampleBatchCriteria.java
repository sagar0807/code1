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
 * Criteria class for the {@link gov.naco.soch.domain.ICTCSampleBatch} entity. This class is used
 * in {@link gov.naco.soch.web.rest.ICTCSampleBatchResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ictc-sample-batches?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ICTCSampleBatchCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter consignmentId;

//    private LocalDateFilter dispatchDate;

    private IntegerFilter batchStatus;

    private IntegerFilter createdBy;

    private LocalDateFilter createdTime;

    private IntegerFilter modifiedBy;

    private LocalDateFilter modifiedTime;

    private BooleanFilter isActive;

    private BooleanFilter isDeleted;
    
    private LongFilter facilityId;
    
    private LongFilter labId;

    public ICTCSampleBatchCriteria() {
    }

    public ICTCSampleBatchCriteria(ICTCSampleBatchCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.labId = other.labId == null ? null : other.labId.copy();
        this.consignmentId = other.consignmentId == null ? null : other.consignmentId.copy();
//        this.dispatchDate = other.dispatchDate == null ? null : other.dispatchDate.copy();
        this.batchStatus = other.batchStatus == null ? null : other.batchStatus.copy();
        this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
        this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
        this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
        this.isActive = other.isActive == null ? null : other.isActive.copy();
        this.isDeleted = other.isDeleted == null ? null : other.isDeleted.copy();
    }

    @Override
    public ICTCSampleBatchCriteria copy() {
        return new ICTCSampleBatchCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public LongFilter getLabId() {
        return labId;
    }

    public void setLabId(LongFilter labId) {
        this.labId = labId;
    }

    public StringFilter getConsignmentId() {
        return consignmentId;
    }

    public void setConsignmentId(StringFilter consignmentId) {
        this.consignmentId = consignmentId;
    }

//    public LocalDateFilter getDispatchDate() {
//        return dispatchDate;
//    }
//
//    public void setDispatchDate(LocalDateFilter dispatchDate) {
//        this.dispatchDate = dispatchDate;
//    }

    public IntegerFilter getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(IntegerFilter batchStatus) {
        this.batchStatus = batchStatus;
    }

    public LongFilter getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(LongFilter facilityId) {
        this.facilityId = facilityId;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ICTCSampleBatchCriteria that = (ICTCSampleBatchCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(labId, that.labId) &&
            Objects.equals(consignmentId, that.consignmentId) &&
//            Objects.equals(dispatchDate, that.dispatchDate) &&
            Objects.equals(batchStatus, that.batchStatus) &&
            Objects.equals(facilityId, that.facilityId) &&
            Objects.equals(createdBy, that.createdBy) &&
            Objects.equals(createdTime, that.createdTime) &&
            Objects.equals(modifiedBy, that.modifiedBy) &&
            Objects.equals(modifiedTime, that.modifiedTime) &&
            Objects.equals(isActive, that.isActive) &&
            Objects.equals(isDeleted, that.isDeleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        labId,
        consignmentId,
//        dispatchDate,
        batchStatus,
        facilityId,
        createdBy,
        createdTime,
        modifiedBy,
        modifiedTime,
        isActive,
        isDeleted
        );
    }

    @Override
    public String toString() {
        return "ICTCSampleBatchCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (labId != null ? "labId=" + labId + ", " : "") +
                (consignmentId != null ? "consignmentId=" + consignmentId + ", " : "") +
//                (dispatchDate != null ? "dispatchDate=" + dispatchDate + ", " : "") +
                (batchStatus != null ? "batchStatus=" + batchStatus + ", " : "") +
                (facilityId != null ? "facilityId=" + facilityId + ", " : "") +
                (createdBy != null ? "createdBy=" + createdBy + ", " : "") +
                (createdTime != null ? "createdTime=" + createdTime + ", " : "") +
                (modifiedBy != null ? "modifiedBy=" + modifiedBy + ", " : "") +
                (modifiedTime != null ? "modifiedTime=" + modifiedTime + ", " : "") +
                (isActive != null ? "isActive=" + isActive + ", " : "") +
                (isDeleted != null ? "isDeleted=" + isDeleted + ", " : "") +
            "}";
    }

}
