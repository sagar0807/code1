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

/**
 * Criteria class for the {@link gov.naco.soch.domain.TIBeneficiaryCommDis} entity. This class is used
 * in {@link gov.naco.soch.web.rest.TIBeneficiaryCommDisResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ti-beneficiary-comm-dis?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class TIBeneficiaryCommDisCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;
    
    private LongFilter facilityId;

    private IntegerFilter condomsDistributed;

    private IntegerFilter syringesNeedlesDistributed;

    private IntegerFilter syringesNeedlesReturned;

    private StringFilter typeOfContact;

    private BooleanFilter condomUseDuringLastSex;

    private BooleanFilter notSharingNeedleSyringe;

    private BooleanFilter isActive;

    private BooleanFilter isDeleted;

    private LongFilter beneficiaryId;
    
    private BooleanFilter isActiveFacility;
    
    private LocalDateFilter distributionDate;

    public TIBeneficiaryCommDisCriteria(){
    }

    public TIBeneficiaryCommDisCriteria(TIBeneficiaryCommDisCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.condomsDistributed = other.condomsDistributed == null ? null : other.condomsDistributed.copy();
        this.syringesNeedlesDistributed = other.syringesNeedlesDistributed == null ? null : other.syringesNeedlesDistributed.copy();
        this.syringesNeedlesReturned = other.syringesNeedlesReturned == null ? null : other.syringesNeedlesReturned.copy();
        this.typeOfContact = other.typeOfContact == null ? null : other.typeOfContact.copy();
        this.condomUseDuringLastSex = other.condomUseDuringLastSex == null ? null : other.condomUseDuringLastSex.copy();
        this.notSharingNeedleSyringe = other.notSharingNeedleSyringe == null ? null : other.notSharingNeedleSyringe.copy();
        this.isActive = other.isActive == null ? null : other.isActive.copy();
        this.isDeleted = other.isDeleted == null ? null : other.isDeleted.copy();
        this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
        this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
    	this.isActiveFacility=other.isActiveFacility==null?null:other.isActiveFacility.copy();
	this.distributionDate=other.distributionDate==null?null:other.distributionDate.copy();
    }

    @Override
    public TIBeneficiaryCommDisCriteria copy() {
        return new TIBeneficiaryCommDisCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public IntegerFilter getCondomsDistributed() {
        return condomsDistributed;
    }

    public void setCondomsDistributed(IntegerFilter condomsDistributed) {
        this.condomsDistributed = condomsDistributed;
    }

    public BooleanFilter getIsActiveFacility() {
		return isActiveFacility;
	}

	public void setIsActiveFacility(BooleanFilter isActiveFacility) {
		this.isActiveFacility = isActiveFacility;
	}

	public LongFilter getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(LongFilter facilityId) {
		this.facilityId = facilityId;
	}
	
	public LocalDateFilter getDistributionDate() {
	    return distributionDate;
	}

	public void setDistributionDate(LocalDateFilter distributionDate) {
	    this.distributionDate = distributionDate;
	}

	public IntegerFilter getSyringesNeedlesDistributed() {
        return syringesNeedlesDistributed;
    }

    public void setSyringesNeedlesDistributed(IntegerFilter syringesNeedlesDistributed) {
        this.syringesNeedlesDistributed = syringesNeedlesDistributed;
    }

    public IntegerFilter getSyringesNeedlesReturned() {
        return syringesNeedlesReturned;
    }

    public void setSyringesNeedlesReturned(IntegerFilter syringesNeedlesReturned) {
        this.syringesNeedlesReturned = syringesNeedlesReturned;
    }

    public StringFilter getTypeOfContact() {
        return typeOfContact;
    }

    public void setTypeOfContact(StringFilter typeOfContact) {
        this.typeOfContact = typeOfContact;
    }

    public BooleanFilter getCondomUseDuringLastSex() {
        return condomUseDuringLastSex;
    }

    public void setCondomUseDuringLastSex(BooleanFilter condomUseDuringLastSex) {
        this.condomUseDuringLastSex = condomUseDuringLastSex;
    }

    public BooleanFilter getNotSharingNeedleSyringe() {
        return notSharingNeedleSyringe;
    }

    public void setNotSharingNeedleSyringe(BooleanFilter notSharingNeedleSyringe) {
        this.notSharingNeedleSyringe = notSharingNeedleSyringe;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final TIBeneficiaryCommDisCriteria that = (TIBeneficiaryCommDisCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(condomsDistributed, that.condomsDistributed) &&
            Objects.equals(syringesNeedlesDistributed, that.syringesNeedlesDistributed) &&
            Objects.equals(syringesNeedlesReturned, that.syringesNeedlesReturned) &&
            Objects.equals(typeOfContact, that.typeOfContact) &&
            Objects.equals(condomUseDuringLastSex, that.condomUseDuringLastSex) &&
            Objects.equals(notSharingNeedleSyringe, that.notSharingNeedleSyringe) &&
            Objects.equals(isActive, that.isActive) &&
            Objects.equals(isDeleted, that.isDeleted) &&
            Objects.equals(facilityId, that.facilityId) &&
            Objects.equals(isActiveFacility, that.isActiveFacility) &&
            Objects.equals(distributionDate, that.distributionDate) &&
            Objects.equals(beneficiaryId, that.beneficiaryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        condomsDistributed,
        syringesNeedlesDistributed,
        syringesNeedlesReturned,
        typeOfContact,
        condomUseDuringLastSex,
        notSharingNeedleSyringe,
        isActive,
        isDeleted,
        facilityId,
        beneficiaryId,
        isActiveFacility,
        distributionDate
        );
    }

	@Override
	public String toString() {
		return "TIBeneficiaryCommDisCriteria [id=" + id + ", facilityId=" + facilityId + ", condomsDistributed="
				+ condomsDistributed + ", syringesNeedlesDistributed=" + syringesNeedlesDistributed
				+ ", syringesNeedlesReturned=" + syringesNeedlesReturned + ", typeOfContact=" + typeOfContact
				+ ", condomUseDuringLastSex=" + condomUseDuringLastSex + ", notSharingNeedleSyringe="
				+ notSharingNeedleSyringe + ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", beneficiaryId="
				+ beneficiaryId + "]";
	}

   

}
