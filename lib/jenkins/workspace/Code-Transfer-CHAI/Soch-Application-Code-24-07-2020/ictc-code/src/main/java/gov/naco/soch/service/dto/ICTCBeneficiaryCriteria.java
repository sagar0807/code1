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
 * Criteria class for the {@link gov.naco.soch.domain.ICTCBeneficiary} entity. This class is used
 * in {@link gov.naco.soch.web.rest.ICTCBeneficiaryResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ictc-beneficiaries?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ICTCBeneficiaryCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter pid;

    private BooleanFilter isConsentDocumented;
    
    private StringFilter infantCode;
    
    private IntegerFilter referredBy;
    
    private LocalDateFilter registrationDate;
    
    private IntegerFilter createdBy;

    private LocalDateFilter createdTime;

    private IntegerFilter modifiedBy;

    private LocalDateFilter modifiedTime;
    
    private BooleanFilter isActive;

    private BooleanFilter isDeleted;

    private StringFilter infantMotherArtId;

    private LongFilter facilityId;

    private LongFilter beneficiaryId;
    
    private StringFilter beneficiaryCategory;
    
    private IntegerFilter beneficiaryStatus;
    
    public ICTCBeneficiaryCriteria() {
    }

    public ICTCBeneficiaryCriteria(ICTCBeneficiaryCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.pid = other.pid == null ? null : other.pid.copy();
        this.isConsentDocumented = other.isConsentDocumented == null ? null : other.isConsentDocumented.copy();
        this.infantMotherArtId = other.infantMotherArtId == null ? null : other.infantMotherArtId.copy();
        this.infantCode = other.infantCode == null ? null : other.infantCode.copy();
        this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
        this.registrationDate = other.registrationDate == null ? null : other.registrationDate.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
        this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
        this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
        this.isActive = other.isActive == null ? null : other.isActive.copy();
        this.isDeleted = other.isDeleted == null ? null : other.isDeleted.copy();
        this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
        this.beneficiaryCategory = other.beneficiaryCategory == null ? null : other.beneficiaryCategory.copy();
        this.beneficiaryStatus = other.beneficiaryStatus == null ? null : other.beneficiaryStatus.copy();
    }

    @Override
    public ICTCBeneficiaryCriteria copy() {
        return new ICTCBeneficiaryCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getPid() {
        return pid;
    }

    public void setPid(StringFilter pid) {
        this.pid = pid;
    }


    public BooleanFilter getIsConsentDocumented() {
        return isConsentDocumented;
    }

    public void setIsConsentDocumented(BooleanFilter isConsentDocumented) {
        this.isConsentDocumented = isConsentDocumented;
    }

    public StringFilter getInfantMotherArtId() {
        return infantMotherArtId;
    }

    public void setInfantMotherArtId(StringFilter infantMotherArtId) {
        this.infantMotherArtId = infantMotherArtId;
    }

    public StringFilter getInfantCode() {
        return infantCode;
    }

    public void setInfantCode(StringFilter infantCode) {
        this.infantCode = infantCode;
    }

    public LongFilter getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(LongFilter facilityId) {
        this.facilityId = facilityId;
    }

    public LocalDateFilter getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateFilter registrationDate) {
        this.registrationDate = registrationDate;
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

    public IntegerFilter getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(IntegerFilter referredBy) {
		this.referredBy = referredBy;
	}

	public StringFilter getBeneficiaryCategory() {
		return beneficiaryCategory;
	}

	public void setBeneficiaryCategory(StringFilter beneficiaryCategory) {
		this.beneficiaryCategory = beneficiaryCategory;
	}
	
	public IntegerFilter getBeneficiaryStatus() {
		return beneficiaryStatus;
	}

	public void setBeneficiaryStatus(IntegerFilter beneficiaryStatus) {
		this.beneficiaryStatus = beneficiaryStatus;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ICTCBeneficiaryCriteria other = (ICTCBeneficiaryCriteria) obj;
		return Objects.equals(beneficiaryCategory, other.beneficiaryCategory)
				&& Objects.equals(beneficiaryId, other.beneficiaryId)
				&& Objects.equals(beneficiaryStatus, other.beneficiaryStatus)
				&& Objects.equals(createdBy, other.createdBy) && Objects.equals(createdTime, other.createdTime)
				&& Objects.equals(facilityId, other.facilityId) && Objects.equals(id, other.id)
				&& Objects.equals(infantCode, other.infantCode)
				&& Objects.equals(infantMotherArtId, other.infantMotherArtId)
				&& Objects.equals(isActive, other.isActive)
				&& Objects.equals(isConsentDocumented, other.isConsentDocumented)
				&& Objects.equals(isDeleted, other.isDeleted) && Objects.equals(modifiedBy, other.modifiedBy)
				&& Objects.equals(modifiedTime, other.modifiedTime) && Objects.equals(pid, other.pid)
				&& Objects.equals(referredBy, other.referredBy)
				&& Objects.equals(registrationDate, other.registrationDate);
	}

    @Override
	public int hashCode() {
		return Objects.hash(beneficiaryCategory, beneficiaryId, beneficiaryStatus, createdBy, createdTime, facilityId,
				id, infantCode, infantMotherArtId, isActive, isConsentDocumented, isDeleted, modifiedBy, modifiedTime,
				pid, referredBy, registrationDate);
	}

	@Override
	public String toString() {
		return "ICTCBeneficiaryCriteria [id=" + id + ", pid=" + pid + ", isConsentDocumented=" + isConsentDocumented
				+ ", infantCode=" + infantCode + ", referredBy=" + referredBy + ", registrationDate=" + registrationDate
				+ ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy
				+ ", modifiedTime=" + modifiedTime + ", isActive=" + isActive + ", isDeleted=" + isDeleted
				+ ", infantMotherArtId=" + infantMotherArtId + ", facilityId=" + facilityId + ", beneficiaryId="
				+ beneficiaryId + ", beneficiaryCategory=" + beneficiaryCategory + ", beneficiaryStatus="
				+ beneficiaryStatus + "]";
	}

}
