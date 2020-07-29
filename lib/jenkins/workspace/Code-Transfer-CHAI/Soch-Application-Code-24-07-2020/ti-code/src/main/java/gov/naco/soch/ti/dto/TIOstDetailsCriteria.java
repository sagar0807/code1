package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link gov.naco.soch.domain.TIOstDetails} entity. This class is used
 * in {@link gov.naco.soch.web.rest.TIOstDetailsResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ti-ost-details?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class TIOstDetailsCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter ostId;

    private StringFilter ostCode;

    private IntegerFilter ostNumber;

    private StringFilter ostInitiated;

    private StringFilter currentDose;

    private LocalDateFilter dispensedLastDate;

    private StringFilter dispensationStatus;

    private LocalDateFilter nextFollowUpDate;

    private StringFilter currentOstStatus;

    private BooleanFilter isActive;

    private BooleanFilter isDelete;

    private IntegerFilter createdBy;

    private ZonedDateTimeFilter createdTime;

    private IntegerFilter modifiedBy;

    private ZonedDateTimeFilter modifiedTime;

    private LongFilter beneficiaryId;

    public TIOstDetailsCriteria(){
    }

    public TIOstDetailsCriteria(TIOstDetailsCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.ostId = other.ostId == null ? null : other.ostId.copy();
        this.ostCode = other.ostCode == null ? null : other.ostCode.copy();
        this.ostNumber = other.ostNumber == null ? null : other.ostNumber.copy();
        this.ostInitiated = other.ostInitiated == null ? null : other.ostInitiated.copy();
        this.currentDose = other.currentDose == null ? null : other.currentDose.copy();
        this.dispensedLastDate = other.dispensedLastDate == null ? null : other.dispensedLastDate.copy();
        this.dispensationStatus = other.dispensationStatus == null ? null : other.dispensationStatus.copy();
        this.nextFollowUpDate = other.nextFollowUpDate == null ? null : other.nextFollowUpDate.copy();
        this.currentOstStatus = other.currentOstStatus == null ? null : other.currentOstStatus.copy();
        this.isActive = other.isActive == null ? null : other.isActive.copy();
        this.isDelete = other.isDelete == null ? null : other.isDelete.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
        this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
        this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
        this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
    }

    @Override
    public TIOstDetailsCriteria copy() {
        return new TIOstDetailsCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getOstId() {
        return ostId;
    }

    public void setOstId(StringFilter ostId) {
        this.ostId = ostId;
    }

    public StringFilter getOstCode() {
        return ostCode;
    }

    public void setOstCode(StringFilter ostCode) {
        this.ostCode = ostCode;
    }

    public IntegerFilter getOstNumber() {
        return ostNumber;
    }

    public void setOstNumber(IntegerFilter ostNumber) {
        this.ostNumber = ostNumber;
    }

    public StringFilter getOstInitiated() {
        return ostInitiated;
    }

    public void setOstInitiated(StringFilter ostInitiated) {
        this.ostInitiated = ostInitiated;
    }

    public StringFilter getCurrentDose() {
        return currentDose;
    }

    public void setCurrentDose(StringFilter currentDose) {
        this.currentDose = currentDose;
    }

    public LocalDateFilter getDispensedLastDate() {
        return dispensedLastDate;
    }

    public void setDispensedLastDate(LocalDateFilter dispensedLastDate) {
        this.dispensedLastDate = dispensedLastDate;
    }

    public StringFilter getDispensationStatus() {
        return dispensationStatus;
    }

    public void setDispensationStatus(StringFilter dispensationStatus) {
        this.dispensationStatus = dispensationStatus;
    }

    public LocalDateFilter getNextFollowUpDate() {
        return nextFollowUpDate;
    }

    public void setNextFollowUpDate(LocalDateFilter nextFollowUpDate) {
        this.nextFollowUpDate = nextFollowUpDate;
    }

    public StringFilter getCurrentOstStatus() {
        return currentOstStatus;
    }

    public void setCurrentOstStatus(StringFilter currentOstStatus) {
        this.currentOstStatus = currentOstStatus;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final TIOstDetailsCriteria that = (TIOstDetailsCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(ostId, that.ostId) &&
            Objects.equals(ostCode, that.ostCode) &&
            Objects.equals(ostNumber, that.ostNumber) &&
            Objects.equals(ostInitiated, that.ostInitiated) &&
            Objects.equals(currentDose, that.currentDose) &&
            Objects.equals(dispensedLastDate, that.dispensedLastDate) &&
            Objects.equals(dispensationStatus, that.dispensationStatus) &&
            Objects.equals(nextFollowUpDate, that.nextFollowUpDate) &&
            Objects.equals(currentOstStatus, that.currentOstStatus) &&
            Objects.equals(isActive, that.isActive) &&
            Objects.equals(isDelete, that.isDelete) &&
            Objects.equals(createdBy, that.createdBy) &&
            Objects.equals(createdTime, that.createdTime) &&
            Objects.equals(modifiedBy, that.modifiedBy) &&
            Objects.equals(modifiedTime, that.modifiedTime) &&
            Objects.equals(beneficiaryId, that.beneficiaryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        ostId,
        ostCode,
        ostNumber,
        ostInitiated,
        currentDose,
        dispensedLastDate,
        dispensationStatus,
        nextFollowUpDate,
        currentOstStatus,
        isActive,
        isDelete,
        createdBy,
        createdTime,
        modifiedBy,
        modifiedTime,
        beneficiaryId
        );
    }

    @Override
    public String toString() {
        return "TIOstDetailsCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (ostId != null ? "ostId=" + ostId + ", " : "") +
                (ostCode != null ? "ostCode=" + ostCode + ", " : "") +
                (ostNumber != null ? "ostNumber=" + ostNumber + ", " : "") +
                (ostInitiated != null ? "ostInitiated=" + ostInitiated + ", " : "") +
                (currentDose != null ? "currentDose=" + currentDose + ", " : "") +
                (dispensedLastDate != null ? "dispensedLastDate=" + dispensedLastDate + ", " : "") +
                (dispensationStatus != null ? "dispensationStatus=" + dispensationStatus + ", " : "") +
                (nextFollowUpDate != null ? "nextFollowUpDate=" + nextFollowUpDate + ", " : "") +
                (currentOstStatus != null ? "currentOstStatus=" + currentOstStatus + ", " : "") +
                (isActive != null ? "isActive=" + isActive + ", " : "") +
                (isDelete != null ? "isDelete=" + isDelete + ", " : "") +
                (createdBy != null ? "createdBy=" + createdBy + ", " : "") +
                (createdTime != null ? "createdTime=" + createdTime + ", " : "") +
                (modifiedBy != null ? "modifiedBy=" + modifiedBy + ", " : "") +
                (modifiedTime != null ? "modifiedTime=" + modifiedTime + ", " : "") +
                (beneficiaryId != null ? "beneficiaryId=" + beneficiaryId + ", " : "") +
            "}";
    }

}
