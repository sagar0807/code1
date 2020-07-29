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
 * Criteria class for the {@link gov.naco.soch.domain.TIOstDrugDispensation} entity. This class is used
 * in {@link gov.naco.soch.web.rest.TIOstDrugDispensationResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ti-ost-drug-dispensations?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class TIOstDrugDispensationCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private IntegerFilter productId;

    private LocalDateFilter nextFollowUpDate;

    private BooleanFilter hivTestingDue;

    private StringFilter clientStatus;

    private BooleanFilter isActive;

    private BooleanFilter isDelete;

    private IntegerFilter createdBy;

    private ZonedDateTimeFilter createdTime;

    private IntegerFilter modifiedBy;

    private ZonedDateTimeFilter modifiedTime;

    private LongFilter beneficiaryId;

    public TIOstDrugDispensationCriteria(){
    }

    public TIOstDrugDispensationCriteria(TIOstDrugDispensationCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.productId = other.productId == null ? null : other.productId.copy();
        this.nextFollowUpDate = other.nextFollowUpDate == null ? null : other.nextFollowUpDate.copy();
        this.hivTestingDue = other.hivTestingDue == null ? null : other.hivTestingDue.copy();
        this.clientStatus = other.clientStatus == null ? null : other.clientStatus.copy();
        this.isActive = other.isActive == null ? null : other.isActive.copy();
        this.isDelete = other.isDelete == null ? null : other.isDelete.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
        this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
        this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
        this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
    }

    @Override
    public TIOstDrugDispensationCriteria copy() {
        return new TIOstDrugDispensationCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public IntegerFilter getProductId() {
        return productId;
    }

    public void setProductId(IntegerFilter productId) {
        this.productId = productId;
    }

    public LocalDateFilter getNextFollowUpDate() {
        return nextFollowUpDate;
    }

    public void setNextFollowUpDate(LocalDateFilter nextFollowUpDate) {
        this.nextFollowUpDate = nextFollowUpDate;
    }

    public BooleanFilter getHivTestingDue() {
        return hivTestingDue;
    }

    public void setHivTestingDue(BooleanFilter hivTestingDue) {
        this.hivTestingDue = hivTestingDue;
    }

    public StringFilter getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(StringFilter clientStatus) {
        this.clientStatus = clientStatus;
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
        final TIOstDrugDispensationCriteria that = (TIOstDrugDispensationCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(productId, that.productId) &&
            Objects.equals(nextFollowUpDate, that.nextFollowUpDate) &&
            Objects.equals(hivTestingDue, that.hivTestingDue) &&
            Objects.equals(clientStatus, that.clientStatus) &&
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
        productId,
        nextFollowUpDate,
        hivTestingDue,
        clientStatus,
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
        return "TIOstDrugDispensationCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (productId != null ? "productId=" + productId + ", " : "") +
                (nextFollowUpDate != null ? "nextFollowUpDate=" + nextFollowUpDate + ", " : "") +
                (hivTestingDue != null ? "hivTestingDue=" + hivTestingDue + ", " : "") +
                (clientStatus != null ? "clientStatus=" + clientStatus + ", " : "") +
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
