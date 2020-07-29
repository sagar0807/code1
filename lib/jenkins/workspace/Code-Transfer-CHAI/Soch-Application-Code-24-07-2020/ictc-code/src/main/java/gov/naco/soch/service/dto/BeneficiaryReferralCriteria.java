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
 * Criteria class for the {@link gov.naco.soch.domain.BeneficiaryReferral} entity. This class is used
 * in {@link gov.naco.soch.web.rest.BeneficiaryReferralResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /beneficiary-referrals?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class BeneficiaryReferralCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

	private LocalDateFilter dateOfHivTest;

	private LocalDateFilter dateOfVisit;

	private StringFilter hivStatus;

	private BooleanFilter isActive;

	private BooleanFilter isDelete;

	private LocalDateFilter referDate;

	private StringFilter referralType;

	private StringFilter typeOfHiv;

	private LocalDateFilter acceptedDate;

	private LocalDateFilter declinedDate;

	private StringFilter referralReason;

	private IntegerFilter referredBy;

	private LongFilter beneficiaryId;

	private LongFilter referedFrom;

	private LongFilter referedTo;

	private IntegerFilter referralStatusId;

	private LongFilter tiBeneficiaryId;

	private LongFilter tiBenScrId;

	private IntegerFilter createdBy;

	private LocalDateFilter createdTime;

	private IntegerFilter modifiedBy;

	private LocalDateFilter modifiedTime;
	
	private IntegerFilter referralTypeId;
	
	private StringFilter beneficiaryName;
	
	private StringFilter referralFacilityName;
	
	private StringFilter mobileNumber;
	
	private StringFilter gender;
	
	private IntegerFilter genderId;

    public BeneficiaryReferralCriteria() {
    }

    public BeneficiaryReferralCriteria(BeneficiaryReferralCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
        this.tiBeneficiaryId = other.tiBeneficiaryId == null ? null : other.tiBeneficiaryId.copy();
        this.tiBenScrId = other.tiBenScrId == null ? null : other.tiBenScrId.copy();
        this.dateOfVisit = other.dateOfVisit == null ? null : other.dateOfVisit.copy();
        this.hivStatus = other.hivStatus == null ? null : other.hivStatus.copy();
        this.referDate = other.referDate == null ? null : other.referDate.copy();
        this.referedFrom = other.referedFrom == null ? null : other.referedFrom.copy();
        this.referedTo = other.referedTo == null ? null : other.referedTo.copy();
        this.referralReason = other.referralReason == null ? null : other.referralReason.copy();
        this.dateOfHivTest = other.dateOfHivTest == null ? null : other.dateOfHivTest.copy();
        this.typeOfHiv = other.typeOfHiv == null ? null : other.typeOfHiv.copy();
        this.referralStatusId = other.referralStatusId == null ? null : other.referralStatusId.copy();
        this.isActive = other.isActive == null ? null : other.isActive.copy();
        this.isDelete = other.isDelete == null ? null : other.isDelete.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
        this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
        this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
        this.referralType = other.referralType == null ? null : other.referralType.copy();
        this.acceptedDate = other.acceptedDate == null ? null : other.acceptedDate.copy();
        this.declinedDate = other.declinedDate == null ? null : other.declinedDate.copy();
        this.referredBy = other.referredBy == null ? null : other.referredBy.copy();
        this.referralTypeId = other.referralTypeId == null ? null : other.referralTypeId.copy();
    }

    @Override
    public BeneficiaryReferralCriteria copy() {
        return new BeneficiaryReferralCriteria(this);
    }

	public LongFilter getId() {
		return id;
	}

	public void setId(LongFilter id) {
		this.id = id;
	}

	public LocalDateFilter getDateOfHivTest() {
		return dateOfHivTest;
	}

	public void setDateOfHivTest(LocalDateFilter dateOfHivTest) {
		this.dateOfHivTest = dateOfHivTest;
	}

	public LocalDateFilter getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(LocalDateFilter dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public StringFilter getHivStatus() {
		return hivStatus;
	}

	public void setHivStatus(StringFilter hivStatus) {
		this.hivStatus = hivStatus;
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

	public LocalDateFilter getReferDate() {
		return referDate;
	}

	public void setReferDate(LocalDateFilter referDate) {
		this.referDate = referDate;
	}

	public StringFilter getReferralType() {
		return referralType;
	}

	public void setReferralType(StringFilter referralType) {
		this.referralType = referralType;
	}

	public StringFilter getTypeOfHiv() {
		return typeOfHiv;
	}

	public void setTypeOfHiv(StringFilter typeOfHiv) {
		this.typeOfHiv = typeOfHiv;
	}

	public LocalDateFilter getAcceptedDate() {
		return acceptedDate;
	}

	public void setAcceptedDate(LocalDateFilter acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

	public LocalDateFilter getDeclinedDate() {
		return declinedDate;
	}

	public void setDeclinedDate(LocalDateFilter declinedDate) {
		this.declinedDate = declinedDate;
	}

	public StringFilter getReferralReason() {
		return referralReason;
	}

	public void setReferralReason(StringFilter referralReason) {
		this.referralReason = referralReason;
	}

	public IntegerFilter getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(IntegerFilter referredBy) {
		this.referredBy = referredBy;
	}

	public LongFilter getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(LongFilter beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public LongFilter getReferedFrom() {
		return referedFrom;
	}

	public void setReferedFrom(LongFilter referedFrom) {
		this.referedFrom = referedFrom;
	}

	public LongFilter getReferedTo() {
		return referedTo;
	}

	public void setReferedTo(LongFilter referedTo) {
		this.referedTo = referedTo;
	}

	public IntegerFilter getReferralStatusId() {
		return referralStatusId;
	}

	public void setReferralStatusId(IntegerFilter referralStatusId) {
		this.referralStatusId = referralStatusId;
	}

	public LongFilter getTiBeneficiaryId() {
		return tiBeneficiaryId;
	}

	public void setTiBeneficiaryId(LongFilter tiBeneficiaryId) {
		this.tiBeneficiaryId = tiBeneficiaryId;
	}

	public LongFilter getTiBenScrId() {
		return tiBenScrId;
	}

	public void setTiBenScrId(LongFilter tiBenScrId) {
		this.tiBenScrId = tiBenScrId;
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
	
	public IntegerFilter getReferralTypeId() {
		return referralTypeId;
	}

	public void setReferralTypeId(IntegerFilter referralTypeId) {
		this.referralTypeId = referralTypeId;
	}

	public StringFilter getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(StringFilter beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public StringFilter getReferralFacilityName() {
		return referralFacilityName;
	}

	public void setReferralFacilityName(StringFilter referralFacilityName) {
		this.referralFacilityName = referralFacilityName;
	}

	public StringFilter getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(StringFilter mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public StringFilter getGender() {
		return gender;
	}

	public void setGender(StringFilter gender) {
		this.gender = gender;
	}
	

	public IntegerFilter getGenderId() {
		return genderId;
	}

	public void setGenderId(IntegerFilter genderId) {
		this.genderId = genderId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(acceptedDate, beneficiaryId, createdBy, createdTime, dateOfHivTest, dateOfVisit,
				declinedDate, hivStatus, id, isActive, isDelete, modifiedBy, modifiedTime, referDate, referedFrom,
				referedTo, referralReason, referralStatusId, referralType, referralTypeId, referredBy, tiBenScrId,
				tiBeneficiaryId, typeOfHiv);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeneficiaryReferralCriteria other = (BeneficiaryReferralCriteria) obj;
		return Objects.equals(acceptedDate, other.acceptedDate) && Objects.equals(beneficiaryId, other.beneficiaryId)
				&& Objects.equals(createdBy, other.createdBy) && Objects.equals(createdTime, other.createdTime)
				&& Objects.equals(dateOfHivTest, other.dateOfHivTest) && Objects.equals(dateOfVisit, other.dateOfVisit)
				&& Objects.equals(declinedDate, other.declinedDate) && Objects.equals(hivStatus, other.hivStatus)
				&& Objects.equals(id, other.id) && Objects.equals(isActive, other.isActive)
				&& Objects.equals(isDelete, other.isDelete) && Objects.equals(modifiedBy, other.modifiedBy)
				&& Objects.equals(modifiedTime, other.modifiedTime) && Objects.equals(referDate, other.referDate)
				&& Objects.equals(referedFrom, other.referedFrom) && Objects.equals(referedTo, other.referedTo)
				&& Objects.equals(referralReason, other.referralReason)
				&& Objects.equals(referralStatusId, other.referralStatusId)
				&& Objects.equals(referralType, other.referralType)
				&& Objects.equals(referralTypeId, other.referralTypeId) && Objects.equals(referredBy, other.referredBy)
				&& Objects.equals(tiBenScrId, other.tiBenScrId)
				&& Objects.equals(tiBeneficiaryId, other.tiBeneficiaryId) && Objects.equals(typeOfHiv, other.typeOfHiv);
	}

	@Override
	public String toString() {
		return "BeneficiaryReferralCriteria [id=" + id + ", dateOfHivTest=" + dateOfHivTest + ", dateOfVisit="
				+ dateOfVisit + ", hivStatus=" + hivStatus + ", isActive=" + isActive + ", isDelete=" + isDelete
				+ ", referDate=" + referDate + ", referralType=" + referralType + ", typeOfHiv=" + typeOfHiv
				+ ", acceptedDate=" + acceptedDate + ", declinedDate=" + declinedDate + ", referralReason="
				+ referralReason + ", referredBy=" + referredBy + ", beneficiaryId=" + beneficiaryId + ", referedFrom="
				+ referedFrom + ", referedTo=" + referedTo + ", referralStatusId=" + referralStatusId
				+ ", tiBeneficiaryId=" + tiBeneficiaryId + ", tiBenScrId=" + tiBenScrId + ", createdBy=" + createdBy
				+ ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime
				+ ", referralTypeId=" + referralTypeId + "]";
	}
	
}
