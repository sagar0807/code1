package gov.naco.soch.service.dto;

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

/**
 * Criteria class for the {@link gov.naco.soch.domain.BeneficiaryFamilyDetails} entity. This class is used
 * in {@link gov.naco.soch.web.rest.BeneficiaryFamilyDetailsResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /beneficiary-family-details?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class BeneficiaryFamilyDetailsCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter familyUid;

    private IntegerFilter relationshipId;

    private LongFilter beneficiaryId;

    private StringFilter firstName;

    private StringFilter middleName;

    private StringFilter lastName;

    private IntegerFilter genderId;

    private IntegerFilter ageYears;

    private IntegerFilter ageMonths;

    private BooleanFilter isAlive;

    private IntegerFilter hivStatusId;

    private BooleanFilter onArt;

    private BooleanFilter isBeneficiary;

    private LongFilter memberBeneficiaryId;

    private IntegerFilter createdBy;

    private LocalDateFilter createdTime;

    private IntegerFilter modifiedBy;

    private LocalDateFilter modifiedTime;

    private BooleanFilter isActive;

    private BooleanFilter isDelete;

    public BeneficiaryFamilyDetailsCriteria() {
    }

    public BeneficiaryFamilyDetailsCriteria(BeneficiaryFamilyDetailsCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.familyUid = other.familyUid == null ? null : other.familyUid.copy();
        this.relationshipId = other.relationshipId == null ? null : other.relationshipId.copy();
        this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
        this.firstName = other.firstName == null ? null : other.firstName.copy();
        this.middleName = other.middleName == null ? null : other.middleName.copy();
        this.lastName = other.lastName == null ? null : other.lastName.copy();
        this.genderId = other.genderId == null ? null : other.genderId.copy();
        this.ageYears = other.ageYears == null ? null : other.ageYears.copy();
        this.ageMonths = other.ageMonths == null ? null : other.ageMonths.copy();
        this.isAlive = other.isAlive == null ? null : other.isAlive.copy();
        this.hivStatusId = other.hivStatusId == null ? null : other.hivStatusId.copy();
        this.onArt = other.onArt == null ? null : other.onArt.copy();
        this.isBeneficiary = other.isBeneficiary == null ? null : other.isBeneficiary.copy();
        this.memberBeneficiaryId = other.memberBeneficiaryId == null ? null : other.memberBeneficiaryId.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
        this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
        this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
        this.isActive = other.isActive == null ? null : other.isActive.copy();
        this.isDelete = other.isDelete == null ? null : other.isDelete.copy();
    }

    @Override
    public BeneficiaryFamilyDetailsCriteria copy() {
        return new BeneficiaryFamilyDetailsCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getFamilyUid() {
        return familyUid;
    }

    public void setFamilyUid(StringFilter familyUid) {
        this.familyUid = familyUid;
    }

    public IntegerFilter getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(IntegerFilter relationshipId) {
        this.relationshipId = relationshipId;
    }

    public LongFilter getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(LongFilter beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
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

    public IntegerFilter getGenderId() {
        return genderId;
    }

    public void setGenderId(IntegerFilter genderId) {
        this.genderId = genderId;
    }

    public IntegerFilter getAgeYears() {
        return ageYears;
    }

    public void setAgeYears(IntegerFilter ageYears) {
        this.ageYears = ageYears;
    }

    public IntegerFilter getAgeMonths() {
        return ageMonths;
    }

    public void setAgeMonths(IntegerFilter ageMonths) {
        this.ageMonths = ageMonths;
    }

    public BooleanFilter getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(BooleanFilter isAlive) {
        this.isAlive = isAlive;
    }

    public IntegerFilter getHivStatusId() {
        return hivStatusId;
    }

    public void setHivStatusId(IntegerFilter hivStatusId) {
        this.hivStatusId = hivStatusId;
    }

    public BooleanFilter getOnArt() {
        return onArt;
    }

    public void setOnArt(BooleanFilter onArt) {
        this.onArt = onArt;
    }

    public BooleanFilter getIsBeneficiary() {
        return isBeneficiary;
    }

    public void setIsBeneficiary(BooleanFilter isBeneficiary) {
        this.isBeneficiary = isBeneficiary;
    }

    public LongFilter getMemberBeneficiaryId() {
        return memberBeneficiaryId;
    }

    public void setMemberBeneficiaryId(LongFilter memberBeneficiaryId) {
        this.memberBeneficiaryId = memberBeneficiaryId;
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

    public BooleanFilter getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(BooleanFilter isDelete) {
        this.isDelete = isDelete;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BeneficiaryFamilyDetailsCriteria that = (BeneficiaryFamilyDetailsCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(familyUid, that.familyUid) &&
            Objects.equals(relationshipId, that.relationshipId) &&
            Objects.equals(beneficiaryId, that.beneficiaryId) &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(middleName, that.middleName) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(genderId, that.genderId) &&
            Objects.equals(ageYears, that.ageYears) &&
            Objects.equals(ageMonths, that.ageMonths) &&
            Objects.equals(isAlive, that.isAlive) &&
            Objects.equals(hivStatusId, that.hivStatusId) &&
            Objects.equals(onArt, that.onArt) &&
            Objects.equals(isBeneficiary, that.isBeneficiary) &&
            Objects.equals(memberBeneficiaryId, that.memberBeneficiaryId) &&
            Objects.equals(createdBy, that.createdBy) &&
            Objects.equals(createdTime, that.createdTime) &&
            Objects.equals(modifiedBy, that.modifiedBy) &&
            Objects.equals(modifiedTime, that.modifiedTime) &&
            Objects.equals(isActive, that.isActive) &&
            Objects.equals(isDelete, that.isDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        familyUid,
        relationshipId,
        beneficiaryId,
        firstName,
        middleName,
        lastName,
        genderId,
        ageYears,
        ageMonths,
        isAlive,
        hivStatusId,
        onArt,
        isBeneficiary,
        memberBeneficiaryId,
        createdBy,
        createdTime,
        modifiedBy,
        modifiedTime,
        isActive,
        isDelete
        );
    }

    @Override
    public String toString() {
        return "BeneficiaryFamilyDetailsCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (familyUid != null ? "familyUid=" + familyUid + ", " : "") +
                (relationshipId != null ? "relationshipId=" + relationshipId + ", " : "") +
                (beneficiaryId != null ? "beneficiaryId=" + beneficiaryId + ", " : "") +
                (firstName != null ? "firstName=" + firstName + ", " : "") +
                (middleName != null ? "middleName=" + middleName + ", " : "") +
                (lastName != null ? "lastName=" + lastName + ", " : "") +
                (genderId != null ? "genderId=" + genderId + ", " : "") +
                (ageYears != null ? "ageYears=" + ageYears + ", " : "") +
                (ageMonths != null ? "ageMonths=" + ageMonths + ", " : "") +
                (isAlive != null ? "isAlive=" + isAlive + ", " : "") +
                (hivStatusId != null ? "hivStatusId=" + hivStatusId + ", " : "") +
                (onArt != null ? "onArt=" + onArt + ", " : "") +
                (isBeneficiary != null ? "isBeneficiary=" + isBeneficiary + ", " : "") +
                (memberBeneficiaryId != null ? "memberBeneficiaryId=" + memberBeneficiaryId + ", " : "") +
                (createdBy != null ? "createdBy=" + createdBy + ", " : "") +
                (createdTime != null ? "createdTime=" + createdTime + ", " : "") +
                (modifiedBy != null ? "modifiedBy=" + modifiedBy + ", " : "") +
                (modifiedTime != null ? "modifiedTime=" + modifiedTime + ", " : "") +
                (isActive != null ? "isActive=" + isActive + ", " : "") +
                (isDelete != null ? "isDelete=" + isDelete + ", " : "") +
            "}";
    }

}
