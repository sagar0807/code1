package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link gov.naco.soch.domain.TIBenReferral} entity. This class is used
 * in {@link gov.naco.soch.web.rest.TIBenReferralResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ti-ben-referrals?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class TIBenReferralCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private IntegerFilter refferalRequestorId;

    private ZonedDateTimeFilter timeOfAppointment;

    private IntegerFilter referralFacility;

    private IntegerFilter referredFacility;

    private StringFilter transferTo;

    private StringFilter transferFrom;

    private LocalDateFilter transferDate;

    private StringFilter transferStatus;

    private StringFilter referralStatus;

    private LocalDateFilter dateOfReferral;

    private StringFilter hivStatus;

    private IntegerFilter isCompleted;

    private BooleanFilter isActive;

    private BooleanFilter isDelete;

    private IntegerFilter createdBy;

    private ZonedDateTimeFilter createdTime;

    private IntegerFilter modifiedBy;

    private ZonedDateTimeFilter modifiedTime;

    private LongFilter beneficiaryId;
    
    private StringFilter name;
    
    private StringFilter uId;
    
    private StringFilter mobileNumber;

    public TIBenReferralCriteria(){
    }

    public TIBenReferralCriteria(TIBenReferralCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.refferalRequestorId = other.refferalRequestorId == null ? null : other.refferalRequestorId.copy();
        this.timeOfAppointment = other.timeOfAppointment == null ? null : other.timeOfAppointment.copy();
        this.referralFacility = other.referralFacility == null ? null : other.referralFacility.copy();
        this.referredFacility = other.referredFacility == null ? null : other.referredFacility.copy();
        this.transferTo = other.transferTo == null ? null : other.transferTo.copy();
        this.transferFrom = other.transferFrom == null ? null : other.transferFrom.copy();
        this.transferDate = other.transferDate == null ? null : other.transferDate.copy();
        this.transferStatus = other.transferStatus == null ? null : other.transferStatus.copy();
        this.referralStatus = other.referralStatus == null ? null : other.referralStatus.copy();
        this.dateOfReferral = other.dateOfReferral == null ? null : other.dateOfReferral.copy();
        this.hivStatus = other.hivStatus == null ? null : other.hivStatus.copy();
        this.isCompleted = other.isCompleted == null ? null : other.isCompleted.copy();
        this.isActive = other.isActive == null ? null : other.isActive.copy();
        this.isDelete = other.isDelete == null ? null : other.isDelete.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
        this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
        this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
        this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
        this.name = other.name == null ? null : other.name.copy();
        this.uId = other.uId == null ? null : other.uId.copy();
        this.mobileNumber = other.mobileNumber == null ? null : other.mobileNumber.copy();
    }

    @Override
    public TIBenReferralCriteria copy() {
        return new TIBenReferralCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public IntegerFilter getRefferalRequestorId() {
        return refferalRequestorId;
    }

    public void setRefferalRequestorId(IntegerFilter refferalRequestorId) {
        this.refferalRequestorId = refferalRequestorId;
    }

    public ZonedDateTimeFilter getTimeOfAppointment() {
        return timeOfAppointment;
    }

    public void setTimeOfAppointment(ZonedDateTimeFilter timeOfAppointment) {
        this.timeOfAppointment = timeOfAppointment;
    }

    public IntegerFilter getReferralFacility() {
        return referralFacility;
    }

    public void setReferralFacility(IntegerFilter referralFacility) {
        this.referralFacility = referralFacility;
    }

    public IntegerFilter getReferredFacility() {
        return referredFacility;
    }

    public void setReferredFacility(IntegerFilter referredFacility) {
        this.referredFacility = referredFacility;
    }

    public StringFilter getTransferTo() {
        return transferTo;
    }

    public void setTransferTo(StringFilter transferTo) {
        this.transferTo = transferTo;
    }

    public StringFilter getTransferFrom() {
        return transferFrom;
    }

    public void setTransferFrom(StringFilter transferFrom) {
        this.transferFrom = transferFrom;
    }

    public LocalDateFilter getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDateFilter transferDate) {
        this.transferDate = transferDate;
    }

    public StringFilter getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(StringFilter transferStatus) {
        this.transferStatus = transferStatus;
    }

    public StringFilter getReferralStatus() {
        return referralStatus;
    }

    public void setReferralStatus(StringFilter referralStatus) {
        this.referralStatus = referralStatus;
    }

    public LocalDateFilter getDateOfReferral() {
        return dateOfReferral;
    }

    public void setDateOfReferral(LocalDateFilter dateOfReferral) {
        this.dateOfReferral = dateOfReferral;
    }

    public StringFilter getHivStatus() {
        return hivStatus;
    }

    public void setHivStatus(StringFilter hivStatus) {
        this.hivStatus = hivStatus;
    }

    public IntegerFilter getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(IntegerFilter isCompleted) {
        this.isCompleted = isCompleted;
    }

    public BooleanFilter getIsActive() {
        return isActive;
    }

    public void setIsActive(BooleanFilter isActive) {
        this.isActive = isActive;
    }

    public BooleanFilter getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(BooleanFilter isDelete) {
        this.isDelete = isDelete;
    }

    public IntegerFilter getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(IntegerFilter createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTimeFilter getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(ZonedDateTimeFilter createdTime) {
        this.createdTime = createdTime;
    }

    public IntegerFilter getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(IntegerFilter modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public ZonedDateTimeFilter getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(ZonedDateTimeFilter modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public LongFilter getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(LongFilter beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }


    public StringFilter getName() {
		return name;
	}

	public void setName(StringFilter name) {
		this.name = name;
	}

	public StringFilter getuId() {
		return uId;
	}

	public void setuId(StringFilter uId) {
		this.uId = uId;
	}

	public StringFilter getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(StringFilter mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final TIBenReferralCriteria that = (TIBenReferralCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(refferalRequestorId, that.refferalRequestorId) &&
            Objects.equals(timeOfAppointment, that.timeOfAppointment) &&
            Objects.equals(referralFacility, that.referralFacility) &&
            Objects.equals(referredFacility, that.referredFacility) &&
            Objects.equals(transferTo, that.transferTo) &&
            Objects.equals(transferFrom, that.transferFrom) &&
            Objects.equals(transferDate, that.transferDate) &&
            Objects.equals(transferStatus, that.transferStatus) &&
            Objects.equals(referralStatus, that.referralStatus) &&
            Objects.equals(dateOfReferral, that.dateOfReferral) &&
            Objects.equals(hivStatus, that.hivStatus) &&
            Objects.equals(isCompleted, that.isCompleted) &&
            Objects.equals(isActive, that.isActive) &&
            Objects.equals(isDelete, that.isDelete) &&
            Objects.equals(createdBy, that.createdBy) &&
            Objects.equals(createdTime, that.createdTime) &&
            Objects.equals(modifiedBy, that.modifiedBy) &&
            Objects.equals(modifiedTime, that.modifiedTime) &&
            Objects.equals(beneficiaryId, that.beneficiaryId)&&
            Objects.equals(name, that.name)&&
            Objects.equals(uId, that.uId)&&
            Objects.equals(mobileNumber, that.mobileNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        refferalRequestorId,
        timeOfAppointment,
        referralFacility,
        referredFacility,
        transferTo,
        transferFrom,
        transferDate,
        transferStatus,
        referralStatus,
        dateOfReferral,
        hivStatus,
        isCompleted,
        isActive,
        isDelete,
        createdBy,
        createdTime,
        modifiedBy,
        modifiedTime,
        beneficiaryId,
        name,
        uId,
        mobileNumber
        );
    }

    @Override
    public String toString() {
        return "TIBenReferralCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (refferalRequestorId != null ? "refferalRequestorId=" + refferalRequestorId + ", " : "") +
                (timeOfAppointment != null ? "timeOfAppointment=" + timeOfAppointment + ", " : "") +
                (referralFacility != null ? "referralFacility=" + referralFacility + ", " : "") +
                (referredFacility != null ? "referredFacility=" + referredFacility + ", " : "") +
                (transferTo != null ? "transferTo=" + transferTo + ", " : "") +
                (transferFrom != null ? "transferFrom=" + transferFrom + ", " : "") +
                (transferDate != null ? "transferDate=" + transferDate + ", " : "") +
                (transferStatus != null ? "transferStatus=" + transferStatus + ", " : "") +
                (referralStatus != null ? "referralStatus=" + referralStatus + ", " : "") +
                (dateOfReferral != null ? "dateOfReferral=" + dateOfReferral + ", " : "") +
                (hivStatus != null ? "hivStatus=" + hivStatus + ", " : "") +
                (isCompleted != null ? "isCompleted=" + isCompleted + ", " : "") +
                (isActive != null ? "isActive=" + isActive + ", " : "") +
                (isDelete != null ? "isDelete=" + isDelete + ", " : "") +
                (createdBy != null ? "createdBy=" + createdBy + ", " : "") +
                (createdTime != null ? "createdTime=" + createdTime + ", " : "") +
                (modifiedBy != null ? "modifiedBy=" + modifiedBy + ", " : "") +
                (modifiedTime != null ? "modifiedTime=" + modifiedTime + ", " : "") +
                (beneficiaryId != null ? "beneficiaryId=" + beneficiaryId + ", " : "") +
                (name != null ? "name=" + name + ", " : "") +
                (uId != null ? "uId=" + uId + ", " : "") +
                (mobileNumber != null ? "mobileNumber=" + mobileNumber + ", " : "") +
            "}";
    }

}
