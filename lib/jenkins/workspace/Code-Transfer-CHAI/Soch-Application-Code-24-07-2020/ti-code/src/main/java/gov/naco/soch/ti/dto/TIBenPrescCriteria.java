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
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link gov.naco.soch.domain.TIBenPresc} entity. This class is used
 * in {@link gov.naco.soch.web.rest.TIBenPrescResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ti-ben-prescs?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class TIBenPrescCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private IntegerFilter facilityId;

    private ZonedDateTimeFilter initiationDate;

    private IntegerFilter substitutionDrug;

    private BooleanFilter consentTaken;

    private IntegerFilter dosage;

    private StringFilter measureOfUnit;

    private BooleanFilter isActive;

    private BooleanFilter isDelete;

    private IntegerFilter createdBy;

    private ZonedDateTimeFilter createdTime;

    private IntegerFilter modifiedBy;

    private ZonedDateTimeFilter modifiedTime;

    private LongFilter beneficiaryId;

    public TIBenPrescCriteria(){
    }

    public TIBenPrescCriteria(TIBenPrescCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
        this.initiationDate = other.initiationDate == null ? null : other.initiationDate.copy();
        this.substitutionDrug = other.substitutionDrug == null ? null : other.substitutionDrug.copy();
        this.consentTaken = other.consentTaken == null ? null : other.consentTaken.copy();
        this.dosage = other.dosage == null ? null : other.dosage.copy();
        this.measureOfUnit = other.measureOfUnit == null ? null : other.measureOfUnit.copy();
        this.isActive = other.isActive == null ? null : other.isActive.copy();
        this.isDelete = other.isDelete == null ? null : other.isDelete.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
        this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
        this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
        this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
    }

    @Override
    public TIBenPrescCriteria copy() {
        return new TIBenPrescCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public IntegerFilter getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(IntegerFilter facilityId) {
        this.facilityId = facilityId;
    }

    public ZonedDateTimeFilter getInitiationDate() {
        return initiationDate;
    }

    public void setInitiationDate(ZonedDateTimeFilter initiationDate) {
        this.initiationDate = initiationDate;
    }

    public IntegerFilter getSubstitutionDrug() {
        return substitutionDrug;
    }

    public void setSubstitutionDrug(IntegerFilter substitutionDrug) {
        this.substitutionDrug = substitutionDrug;
    }

    public BooleanFilter getConsentTaken() {
        return consentTaken;
    }

    public void setConsentTaken(BooleanFilter consentTaken) {
        this.consentTaken = consentTaken;
    }

    public IntegerFilter getDosage() {
        return dosage;
    }

    public void setDosage(IntegerFilter dosage) {
        this.dosage = dosage;
    }

    public StringFilter getMeasureOfUnit() {
        return measureOfUnit;
    }

    public void setMeasureOfUnit(StringFilter measureOfUnit) {
        this.measureOfUnit = measureOfUnit;
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
        final TIBenPrescCriteria that = (TIBenPrescCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(facilityId, that.facilityId) &&
            Objects.equals(initiationDate, that.initiationDate) &&
            Objects.equals(substitutionDrug, that.substitutionDrug) &&
            Objects.equals(consentTaken, that.consentTaken) &&
            Objects.equals(dosage, that.dosage) &&
            Objects.equals(measureOfUnit, that.measureOfUnit) &&
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
        facilityId,
        initiationDate,
        substitutionDrug,
        consentTaken,
        dosage,
        measureOfUnit,
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
        return "TIBenPrescCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (facilityId != null ? "facilityId=" + facilityId + ", " : "") +
                (initiationDate != null ? "initiationDate=" + initiationDate + ", " : "") +
                (substitutionDrug != null ? "substitutionDrug=" + substitutionDrug + ", " : "") +
                (consentTaken != null ? "consentTaken=" + consentTaken + ", " : "") +
                (dosage != null ? "dosage=" + dosage + ", " : "") +
                (measureOfUnit != null ? "measureOfUnit=" + measureOfUnit + ", " : "") +
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
