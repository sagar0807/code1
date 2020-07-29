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
 * Criteria class for the {@link gov.naco.soch.domain.ICTCBeneficiaryFollowup} entity. This class is used
 * in {@link gov.naco.soch.web.rest.ICTCBeneficiaryFollowupResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ictc-beneficiary-followups?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ICTCBeneficiaryFollowupCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter firstName;

    private StringFilter middleName;

    private StringFilter lastName;

    private StringFilter mobileNumber;

    private StringFilter followUpType;

    private LocalDateFilter followUpDate;

    private LongFilter beneficiaryId;

    private LongFilter facilityId;

    private StringFilter remarks;

    private BooleanFilter isCompleted;

    private LongFilter visitId;

    private LocalDateFilter expectedDeliveryDate;

    private LocalDateFilter pregnancyLmpDate;

    public ICTCBeneficiaryFollowupCriteria() {
    }

    public ICTCBeneficiaryFollowupCriteria(ICTCBeneficiaryFollowupCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.firstName = other.firstName == null ? null : other.firstName.copy();
        this.middleName = other.middleName == null ? null : other.middleName.copy();
        this.lastName = other.lastName == null ? null : other.lastName.copy();
        this.mobileNumber = other.mobileNumber == null ? null : other.mobileNumber.copy();
        this.followUpType = other.followUpType == null ? null : other.followUpType.copy();
        this.followUpDate = other.followUpDate == null ? null : other.followUpDate.copy();
        this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
        this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
        this.remarks = other.remarks == null ? null : other.remarks.copy();
        this.isCompleted = other.isCompleted == null ? null : other.isCompleted.copy();
        this.visitId = other.visitId == null ? null : other.visitId.copy();
        this.expectedDeliveryDate = other.expectedDeliveryDate == null ? null : other.expectedDeliveryDate.copy();
        this.pregnancyLmpDate = other.pregnancyLmpDate == null ? null : other.pregnancyLmpDate.copy();
    }

    @Override
    public ICTCBeneficiaryFollowupCriteria copy() {
        return new ICTCBeneficiaryFollowupCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getFirstName() {
        return firstName;
    }

    public void setFirstName(StringFilter firstName) {
        this.firstName = firstName;
    }

    public StringFilter getMiddleName() {
        return middleName;
    }

    public void setMiddleName(StringFilter middleName) {
        this.middleName = middleName;
    }

    public StringFilter getLastName() {
        return lastName;
    }

    public void setLastName(StringFilter lastName) {
        this.lastName = lastName;
    }

    public StringFilter getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(StringFilter mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public StringFilter getFollowUpType() {
        return followUpType;
    }

    public void setFollowUpType(StringFilter followUpType) {
        this.followUpType = followUpType;
    }

    public LocalDateFilter getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(LocalDateFilter followUpDate) {
        this.followUpDate = followUpDate;
    }

    public LongFilter getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(LongFilter beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public LongFilter getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(LongFilter facilityId) {
        this.facilityId = facilityId;
    }

    public StringFilter getRemarks() {
        return remarks;
    }

    public void setRemarks(StringFilter remarks) {
        this.remarks = remarks;
    }

    public BooleanFilter getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(BooleanFilter isCompleted) {
        this.isCompleted = isCompleted;
    }

    public LongFilter getVisitId() {
        return visitId;
    }

    public void setVisitId(LongFilter visitId) {
        this.visitId = visitId;
    }

    public LocalDateFilter getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(LocalDateFilter expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public LocalDateFilter getPregnancyLmpDate() {
        return pregnancyLmpDate;
    }

    public void setPregnancyLmpDate(LocalDateFilter pregnancyLmpDate) {
        this.pregnancyLmpDate = pregnancyLmpDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ICTCBeneficiaryFollowupCriteria that = (ICTCBeneficiaryFollowupCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(middleName, that.middleName) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(mobileNumber, that.mobileNumber) &&
            Objects.equals(followUpType, that.followUpType) &&
            Objects.equals(followUpDate, that.followUpDate) &&
            Objects.equals(beneficiaryId, that.beneficiaryId) &&
            Objects.equals(facilityId, that.facilityId) &&
            Objects.equals(remarks, that.remarks) &&
            Objects.equals(isCompleted, that.isCompleted) &&
            Objects.equals(visitId, that.visitId) &&
            Objects.equals(expectedDeliveryDate, that.expectedDeliveryDate) &&
            Objects.equals(pregnancyLmpDate, that.pregnancyLmpDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        firstName,
        middleName,
        lastName,
        mobileNumber,
        followUpType,
        followUpDate,
        beneficiaryId,
        facilityId,
        remarks,
        isCompleted,
        visitId,
        expectedDeliveryDate,
        pregnancyLmpDate
        );
    }

    @Override
    public String toString() {
        return "ICTCBeneficiaryFollowupCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (firstName != null ? "firstName=" + firstName + ", " : "") +
                (middleName != null ? "middleName=" + middleName + ", " : "") +
                (lastName != null ? "lastName=" + lastName + ", " : "") +
                (mobileNumber != null ? "mobileNumber=" + mobileNumber + ", " : "") +
                (followUpType != null ? "followUpType=" + followUpType + ", " : "") +
                (followUpDate != null ? "followUpDate=" + followUpDate + ", " : "") +
                (beneficiaryId != null ? "beneficiaryId=" + beneficiaryId + ", " : "") +
                (facilityId != null ? "facilityId=" + facilityId + ", " : "") +
                (remarks != null ? "remarks=" + remarks + ", " : "") +
                (isCompleted != null ? "isCompleted=" + isCompleted + ", " : "") +
                (visitId != null ? "visitId=" + visitId + ", " : "") +
                (expectedDeliveryDate != null ? "expectedDeliveryDate=" + expectedDeliveryDate + ", " : "") +
                (pregnancyLmpDate != null ? "pregnancyLmpDate=" + pregnancyLmpDate + ", " : "") +
            "}";
    }

}
