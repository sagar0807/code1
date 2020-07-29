package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link gov.naco.soch.domain.IctcLinkedFacility} entity. This class is used
 * in {@link gov.naco.soch.web.rest.IctcLinkedFacilityResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ictc-linked-facilities?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class IctcLinkedFacilityCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter facilityName;

    private LongFilter linkedFacilityId;

    private LongFilter facilityId;

    private StringFilter facilityType;

    private BooleanFilter isActive;

    private BooleanFilter isDeleted;

    private StringFilter status;

    private LongFilter createdBy;

    private LocalDateFilter createdTime;

    private LongFilter modifiedBy;

    private LocalDateFilter modifiedTime;

    public IctcLinkedFacilityCriteria() {
    }

    public IctcLinkedFacilityCriteria(IctcLinkedFacilityCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.facilityName = other.facilityName == null ? null : other.facilityName.copy();
        this.linkedFacilityId = other.linkedFacilityId == null ? null : other.linkedFacilityId.copy();
        this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
        this.facilityType = other.facilityType == null ? null : other.facilityType.copy();
        this.isActive = other.isActive == null ? null : other.isActive.copy();
        this.isDeleted = other.isDeleted == null ? null : other.isDeleted.copy();
        this.status = other.status == null ? null : other.status.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
        this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
        this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
    }

    @Override
    public IctcLinkedFacilityCriteria copy() {
        return new IctcLinkedFacilityCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(StringFilter facilityName) {
        this.facilityName = facilityName;
    }

    public LongFilter getLinkedFacilityId() {
        return linkedFacilityId;
    }

    public void setLinkedFacilityId(LongFilter linkedFacilityId) {
        this.linkedFacilityId = linkedFacilityId;
    }

    public LongFilter getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(LongFilter facilityId) {
        this.facilityId = facilityId;
    }

    public StringFilter getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(StringFilter facilityType) {
        this.facilityType = facilityType;
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

    public StringFilter getStatus() {
        return status;
    }

    public void setStatus(StringFilter status) {
        this.status = status;
    }

    public LongFilter getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(LongFilter createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateFilter getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateFilter createdTime) {
        this.createdTime = createdTime;
    }

    public LongFilter getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(LongFilter modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateFilter getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateFilter modifiedTime) {
        this.modifiedTime = modifiedTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final IctcLinkedFacilityCriteria that = (IctcLinkedFacilityCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(facilityName, that.facilityName) &&
            Objects.equals(linkedFacilityId, that.linkedFacilityId) &&
            Objects.equals(facilityId, that.facilityId) &&
            Objects.equals(facilityType, that.facilityType) &&
            Objects.equals(isActive, that.isActive) &&
            Objects.equals(isDeleted, that.isDeleted) &&
            Objects.equals(status, that.status) &&
            Objects.equals(createdBy, that.createdBy) &&
            Objects.equals(createdTime, that.createdTime) &&
            Objects.equals(modifiedBy, that.modifiedBy) &&
            Objects.equals(modifiedTime, that.modifiedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        facilityName,
        linkedFacilityId,
        facilityId,
        facilityType,
        isActive,
        isDeleted,
        status,
        createdBy,
        createdTime,
        modifiedBy,
        modifiedTime
        );
    }

    @Override
    public String toString() {
        return "IctcLinkedFacilityCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (facilityName != null ? "facilityName=" + facilityName + ", " : "") +
                (linkedFacilityId != null ? "linkedFacilityId=" + linkedFacilityId + ", " : "") +
                (facilityId != null ? "facilityId=" + facilityId + ", " : "") +
                (facilityType != null ? "facilityType=" + facilityType + ", " : "") +
                (isActive != null ? "isActive=" + isActive + ", " : "") +
                (isDeleted != null ? "isDeleted=" + isDeleted + ", " : "") +
                (status != null ? "status=" + status + ", " : "") +
                (createdBy != null ? "createdBy=" + createdBy + ", " : "") +
                (createdTime != null ? "createdTime=" + createdTime + ", " : "") +
                (modifiedBy != null ? "modifiedBy=" + modifiedBy + ", " : "") +
                (modifiedTime != null ? "modifiedTime=" + modifiedTime + ", " : "") +
            "}";
    }

}
