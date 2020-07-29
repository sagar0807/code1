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
 * Criteria class for the {@link gov.naco.soch.domain.Transfers} entity. This class is used
 * in {@link gov.naco.soch.web.rest.TransfersResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /transfers?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class TransfersCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter sourceFacilityType;

    private StringFilter transferStatus;

    private StringFilter hivStatus;

    private StringFilter category;

    private StringFilter remarks;

    private LocalDateFilter initiationDate;

    private StringFilter destinationFacilityType;

    private StringFilter dsrcCode;

    private StringFilter tiCode;

    private StringFilter artCode;

    private StringFilter ostCode;

    private StringFilter pidCode;

    private LocalDateFilter reportingDate;

    private IntegerFilter createdBy;

    private LocalDateFilter createdTime;

    private IntegerFilter modifiedBy;

    private LocalDateFilter modifiedTime;

    private BooleanFilter isActive;

    private BooleanFilter isDeleted;

    private LongFilter beneficiaryId;

    private LongFilter sourceFacilityId;

    private LongFilter destinationFacilityId;

    public TransfersCriteria() {
    }

    public TransfersCriteria(TransfersCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.sourceFacilityType = other.sourceFacilityType == null ? null : other.sourceFacilityType.copy();
        this.transferStatus = other.transferStatus == null ? null : other.transferStatus.copy();
        this.hivStatus = other.hivStatus == null ? null : other.hivStatus.copy();
        this.category = other.category == null ? null : other.category.copy();
        this.remarks = other.remarks == null ? null : other.remarks.copy();
        this.initiationDate = other.initiationDate == null ? null : other.initiationDate.copy();
        this.destinationFacilityType = other.destinationFacilityType == null ? null : other.destinationFacilityType.copy();
        this.dsrcCode = other.dsrcCode == null ? null : other.dsrcCode.copy();
        this.tiCode = other.tiCode == null ? null : other.tiCode.copy();
        this.artCode = other.artCode == null ? null : other.artCode.copy();
        this.ostCode = other.ostCode == null ? null : other.ostCode.copy();
        this.pidCode = other.pidCode == null ? null : other.pidCode.copy();
        this.reportingDate = other.reportingDate == null ? null : other.reportingDate.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
        this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
        this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
        this.isActive = other.isActive == null ? null : other.isActive.copy();
        this.isDeleted = other.isDeleted == null ? null : other.isDeleted.copy();
        this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
        this.sourceFacilityId = other.sourceFacilityId == null ? null : other.sourceFacilityId.copy();
        this.destinationFacilityId = other.destinationFacilityId == null ? null : other.destinationFacilityId.copy();
    }

    @Override
    public TransfersCriteria copy() {
        return new TransfersCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getSourceFacilityType() {
        return sourceFacilityType;
    }

    public void setSourceFacilityType(StringFilter sourceFacilityType) {
        this.sourceFacilityType = sourceFacilityType;
    }

    public StringFilter getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(StringFilter transferStatus) {
        this.transferStatus = transferStatus;
    }

    public StringFilter getHivStatus() {
        return hivStatus;
    }

    public void setHivStatus(StringFilter hivStatus) {
        this.hivStatus = hivStatus;
    }

    public StringFilter getCategory() {
        return category;
    }

    public void setCategory(StringFilter category) {
        this.category = category;
    }

    public StringFilter getRemarks() {
        return remarks;
    }

    public void setRemarks(StringFilter remarks) {
        this.remarks = remarks;
    }

    public LocalDateFilter getInitiationDate() {
        return initiationDate;
    }

    public void setInitiationDate(LocalDateFilter initiationDate) {
        this.initiationDate = initiationDate;
    }

    public StringFilter getDestinationFacilityType() {
        return destinationFacilityType;
    }

    public void setDestinationFacilityType(StringFilter destinationFacilityType) {
        this.destinationFacilityType = destinationFacilityType;
    }

    public StringFilter getDsrcCode() {
        return dsrcCode;
    }

    public void setDsrcCode(StringFilter dsrcCode) {
        this.dsrcCode = dsrcCode;
    }

    public StringFilter getTiCode() {
        return tiCode;
    }

    public void setTiCode(StringFilter tiCode) {
        this.tiCode = tiCode;
    }

    public StringFilter getArtCode() {
        return artCode;
    }

    public void setArtCode(StringFilter artCode) {
        this.artCode = artCode;
    }

    public StringFilter getOstCode() {
        return ostCode;
    }

    public void setOstCode(StringFilter ostCode) {
        this.ostCode = ostCode;
    }

    public StringFilter getPidCode() {
        return pidCode;
    }

    public void setPidCode(StringFilter pidCode) {
        this.pidCode = pidCode;
    }

    public LocalDateFilter getReportingDate() {
        return reportingDate;
    }

    public void setReportingDate(LocalDateFilter reportingDate) {
        this.reportingDate = reportingDate;
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

    public LongFilter getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(LongFilter beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public LongFilter getSourceFacilityId() {
        return sourceFacilityId;
    }

    public void setSourceFacilityId(LongFilter sourceFacilityId) {
        this.sourceFacilityId = sourceFacilityId;
    }

    public LongFilter getDestinationFacilityId() {
        return destinationFacilityId;
    }

    public void setDestinationFacilityId(LongFilter destinationFacilityId) {
        this.destinationFacilityId = destinationFacilityId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final TransfersCriteria that = (TransfersCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(sourceFacilityType, that.sourceFacilityType) &&
            Objects.equals(transferStatus, that.transferStatus) &&
            Objects.equals(hivStatus, that.hivStatus) &&
            Objects.equals(category, that.category) &&
            Objects.equals(remarks, that.remarks) &&
            Objects.equals(initiationDate, that.initiationDate) &&
            Objects.equals(destinationFacilityType, that.destinationFacilityType) &&
            Objects.equals(dsrcCode, that.dsrcCode) &&
            Objects.equals(tiCode, that.tiCode) &&
            Objects.equals(artCode, that.artCode) &&
            Objects.equals(ostCode, that.ostCode) &&
            Objects.equals(pidCode, that.pidCode) &&
            Objects.equals(reportingDate, that.reportingDate) &&
            Objects.equals(createdBy, that.createdBy) &&
            Objects.equals(createdTime, that.createdTime) &&
            Objects.equals(modifiedBy, that.modifiedBy) &&
            Objects.equals(modifiedTime, that.modifiedTime) &&
            Objects.equals(isActive, that.isActive) &&
            Objects.equals(isDeleted, that.isDeleted) &&
            Objects.equals(beneficiaryId, that.beneficiaryId) &&
            Objects.equals(sourceFacilityId, that.sourceFacilityId) &&
            Objects.equals(destinationFacilityId, that.destinationFacilityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        sourceFacilityType,
        transferStatus,
        hivStatus,
        category,
        remarks,
        initiationDate,
        destinationFacilityType,
        dsrcCode,
        tiCode,
        artCode,
        ostCode,
        pidCode,
        reportingDate,
        createdBy,
        createdTime,
        modifiedBy,
        modifiedTime,
        isActive,
        isDeleted,
        beneficiaryId,
        sourceFacilityId,
        destinationFacilityId
        );
    }

    @Override
    public String toString() {
        return "TransfersCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (sourceFacilityType != null ? "sourceFacilityType=" + sourceFacilityType + ", " : "") +
                (transferStatus != null ? "transferStatus=" + transferStatus + ", " : "") +
                (hivStatus != null ? "hivStatus=" + hivStatus + ", " : "") +
                (category != null ? "category=" + category + ", " : "") +
                (remarks != null ? "remarks=" + remarks + ", " : "") +
                (initiationDate != null ? "initiationDate=" + initiationDate + ", " : "") +
                (destinationFacilityType != null ? "destinationFacilityType=" + destinationFacilityType + ", " : "") +
                (dsrcCode != null ? "dsrcCode=" + dsrcCode + ", " : "") +
                (tiCode != null ? "tiCode=" + tiCode + ", " : "") +
                (artCode != null ? "artCode=" + artCode + ", " : "") +
                (ostCode != null ? "ostCode=" + ostCode + ", " : "") +
                (pidCode != null ? "pidCode=" + pidCode + ", " : "") +
                (reportingDate != null ? "reportingDate=" + reportingDate + ", " : "") +
                (createdBy != null ? "createdBy=" + createdBy + ", " : "") +
                (createdTime != null ? "createdTime=" + createdTime + ", " : "") +
                (modifiedBy != null ? "modifiedBy=" + modifiedBy + ", " : "") +
                (modifiedTime != null ? "modifiedTime=" + modifiedTime + ", " : "") +
                (isActive != null ? "isActive=" + isActive + ", " : "") +
                (isDeleted != null ? "isDeleted=" + isDeleted + ", " : "") +
                (beneficiaryId != null ? "beneficiaryId=" + beneficiaryId + ", " : "") +
                (sourceFacilityId != null ? "sourceFacilityId=" + sourceFacilityId + ", " : "") +
                (destinationFacilityId != null ? "destinationFacilityId=" + destinationFacilityId + ", " : "") +
            "}";
    }

}
