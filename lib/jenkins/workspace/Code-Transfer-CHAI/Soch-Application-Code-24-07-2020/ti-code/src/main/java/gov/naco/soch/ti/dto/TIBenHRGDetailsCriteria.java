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
 * Criteria class for the {@link gov.naco.soch.domain.TIBenHRGDetails} entity. This class is used
 * in {@link gov.naco.soch.web.rest.TIBenHRGDetailsResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ti-ben-hrg-details?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class TIBenHRGDetailsCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter hrgPrimaryCategory;

    private StringFilter hrgSecondaryCategory;

    private StringFilter subCategory;

    private IntegerFilter avgNoSexualActsUponReg;

    private IntegerFilter noYearsInSexWork;

    private BooleanFilter consumeAlcohol;

    private IntegerFilter alcoholConsDaysInWeek;

    private IntegerFilter createdBy;

    private ZonedDateTimeFilter createdTime;

    private IntegerFilter modifiedBy;

    private ZonedDateTimeFilter modifiedTime;

    private LongFilter beneficiaryId;

    public TIBenHRGDetailsCriteria(){
    }

    public TIBenHRGDetailsCriteria(TIBenHRGDetailsCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.hrgPrimaryCategory = other.hrgPrimaryCategory == null ? null : other.hrgPrimaryCategory.copy();
        this.hrgSecondaryCategory = other.hrgSecondaryCategory == null ? null : other.hrgSecondaryCategory.copy();
        this.subCategory = other.subCategory == null ? null : other.subCategory.copy();
        this.avgNoSexualActsUponReg = other.avgNoSexualActsUponReg == null ? null : other.avgNoSexualActsUponReg.copy();
        this.noYearsInSexWork = other.noYearsInSexWork == null ? null : other.noYearsInSexWork.copy();
        this.consumeAlcohol = other.consumeAlcohol == null ? null : other.consumeAlcohol.copy();
        this.alcoholConsDaysInWeek = other.alcoholConsDaysInWeek == null ? null : other.alcoholConsDaysInWeek.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
        this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
        this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
        this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
    }

    @Override
    public TIBenHRGDetailsCriteria copy() {
        return new TIBenHRGDetailsCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getHrgPrimaryCategory() {
        return hrgPrimaryCategory;
    }

    public void setHrgPrimaryCategory(StringFilter hrgPrimaryCategory) {
        this.hrgPrimaryCategory = hrgPrimaryCategory;
    }

    public StringFilter getHrgSecondaryCategory() {
        return hrgSecondaryCategory;
    }

    public void setHrgSecondaryCategory(StringFilter hrgSecondaryCategory) {
        this.hrgSecondaryCategory = hrgSecondaryCategory;
    }

    public StringFilter getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(StringFilter subCategory) {
        this.subCategory = subCategory;
    }

    public IntegerFilter getAvgNoSexualActsUponReg() {
        return avgNoSexualActsUponReg;
    }

    public void setAvgNoSexualActsUponReg(IntegerFilter avgNoSexualActsUponReg) {
        this.avgNoSexualActsUponReg = avgNoSexualActsUponReg;
    }

    public IntegerFilter getNoYearsInSexWork() {
        return noYearsInSexWork;
    }

    public void setNoYearsInSexWork(IntegerFilter noYearsInSexWork) {
        this.noYearsInSexWork = noYearsInSexWork;
    }

    public BooleanFilter getConsumeAlcohol() {
        return consumeAlcohol;
    }

    public void setConsumeAlcohol(BooleanFilter consumeAlcohol) {
        this.consumeAlcohol = consumeAlcohol;
    }

    public IntegerFilter getAlcoholConsDaysInWeek() {
        return alcoholConsDaysInWeek;
    }

    public void setAlcoholConsDaysInWeek(IntegerFilter alcoholConsDaysInWeek) {
        this.alcoholConsDaysInWeek = alcoholConsDaysInWeek;
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
        final TIBenHRGDetailsCriteria that = (TIBenHRGDetailsCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(hrgPrimaryCategory, that.hrgPrimaryCategory) &&
            Objects.equals(hrgSecondaryCategory, that.hrgSecondaryCategory) &&
            Objects.equals(subCategory, that.subCategory) &&
            Objects.equals(avgNoSexualActsUponReg, that.avgNoSexualActsUponReg) &&
            Objects.equals(noYearsInSexWork, that.noYearsInSexWork) &&
            Objects.equals(consumeAlcohol, that.consumeAlcohol) &&
            Objects.equals(alcoholConsDaysInWeek, that.alcoholConsDaysInWeek) &&
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
        hrgPrimaryCategory,
        hrgSecondaryCategory,
        subCategory,
        avgNoSexualActsUponReg,
        noYearsInSexWork,
        consumeAlcohol,
        alcoholConsDaysInWeek,
        createdBy,
        createdTime,
        modifiedBy,
        modifiedTime,
        beneficiaryId
        );
    }

    @Override
    public String toString() {
        return "TIBenHRGDetailsCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (hrgPrimaryCategory != null ? "hrgPrimaryCategory=" + hrgPrimaryCategory + ", " : "") +
                (hrgSecondaryCategory != null ? "hrgSecondaryCategory=" + hrgSecondaryCategory + ", " : "") +
                (subCategory != null ? "subCategory=" + subCategory + ", " : "") +
                (avgNoSexualActsUponReg != null ? "avgNoSexualActsUponReg=" + avgNoSexualActsUponReg + ", " : "") +
                (noYearsInSexWork != null ? "noYearsInSexWork=" + noYearsInSexWork + ", " : "") +
                (consumeAlcohol != null ? "consumeAlcohol=" + consumeAlcohol + ", " : "") +
                (alcoholConsDaysInWeek != null ? "alcoholConsDaysInWeek=" + alcoholConsDaysInWeek + ", " : "") +
                (createdBy != null ? "createdBy=" + createdBy + ", " : "") +
                (createdTime != null ? "createdTime=" + createdTime + ", " : "") +
                (modifiedBy != null ? "modifiedBy=" + modifiedBy + ", " : "") +
                (modifiedTime != null ? "modifiedTime=" + modifiedTime + ", " : "") +
                (beneficiaryId != null ? "beneficiaryId=" + beneficiaryId + ", " : "") +
            "}";
    }

}
