package gov.naco.soch.shared.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

public class PartnerLinkageCriteria implements Serializable, Criteria {

	private static final long serialVersionUID = 1L;

	private LongFilter id;

	private IntegerFilter ageMonths;

	private IntegerFilter ageYears;

	private StringFilter familyUid;

	private BooleanFilter isActive;

	private BooleanFilter isDelete;

	private BooleanFilter isAlive;

	private BooleanFilter isBeneficiary;

	private BooleanFilter onArt;

	private LongFilter beneficiaryId;

	private LongFilter partnerBeneficiaryId;

	private StringFilter gender;

	private StringFilter hivStatus;

	private StringFilter relationship;

	public LongFilter getId() {
		return id;
	}

	public void setId(LongFilter id) {
		this.id = id;
	}

	public IntegerFilter getAgeMonths() {
		return ageMonths;
	}

	public void setAgeMonths(IntegerFilter ageMonths) {
		this.ageMonths = ageMonths;
	}

	public IntegerFilter getAgeYears() {
		return ageYears;
	}

	public void setAgeYears(IntegerFilter ageYears) {
		this.ageYears = ageYears;
	}

	public StringFilter getFamilyUid() {
		return familyUid;
	}

	public void setFamilyUid(StringFilter familyUid) {
		this.familyUid = familyUid;
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

	public BooleanFilter getIsAlive() {
		return isAlive;
	}

	public void setIsAlive(BooleanFilter isAlive) {
		this.isAlive = isAlive;
	}

	public BooleanFilter getIsBeneficiary() {
		return isBeneficiary;
	}

	public void setIsBeneficiary(BooleanFilter isBeneficiary) {
		this.isBeneficiary = isBeneficiary;
	}

	public BooleanFilter getOnArt() {
		return onArt;
	}

	public void setOnArt(BooleanFilter onArt) {
		this.onArt = onArt;
	}

	public LongFilter getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(LongFilter beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public LongFilter getPartnerBeneficiaryId() {
		return partnerBeneficiaryId;
	}

	public void setPartnerBeneficiaryId(LongFilter partnerBeneficiaryId) {
		this.partnerBeneficiaryId = partnerBeneficiaryId;
	}

	public StringFilter getGender() {
		return gender;
	}

	public void setGender(StringFilter gender) {
		this.gender = gender;
	}

	public StringFilter getHivStatus() {
		return hivStatus;
	}

	public void setHivStatus(StringFilter hivStatus) {
		this.hivStatus = hivStatus;
	}

	public StringFilter getRelationship() {
		return relationship;
	}

	public void setRelationship(StringFilter relationship) {
		this.relationship = relationship;
	}
	
	public PartnerLinkageCriteria()
	{
		
	}

	public PartnerLinkageCriteria(PartnerLinkageCriteria other) {
        
		this.id = other.id == null ? null : other.id.copy();
		this.ageMonths = other.ageMonths == null ? null : other.ageMonths.copy();
		this.ageYears = other.ageYears == null ? null : other.ageYears.copy();
		this.familyUid = other.familyUid == null ? null : other.familyUid.copy();
		this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
		this.gender = other.gender == null ? null : other.gender.copy();
		this.hivStatus = other.hivStatus == null ? null : other.hivStatus.copy();
		this.isActive = other.isActive == null ? null : other.isActive.copy();
		this.isAlive = other.isAlive == null ? null : other.isAlive.copy();
		this.isBeneficiary = other.isBeneficiary == null ? null : other.isBeneficiary.copy();
		this.isDelete = other.isDelete == null ? null : other.isDelete.copy();
		this.onArt = other.onArt == null ? null : other.onArt.copy();
		this.partnerBeneficiaryId = other.partnerBeneficiaryId == null ? null : other.partnerBeneficiaryId.copy();
		this.relationship = other.relationship == null ? null : other.relationship.copy();

	}

	@Override
	public Criteria copy() {
		// TODO Auto-generated method stub
		return new PartnerLinkageCriteria(this);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final PartnerLinkageCriteria that = (PartnerLinkageCriteria) o;
		return Objects.equals(id, that.id) && Objects.equals(gender, that.gender)
				&& Objects.equals(isActive, that.isActive) && Objects.equals(isAlive, that.isAlive)
				&& Objects.equals(isBeneficiary, that.isBeneficiary) && Objects.equals(isDelete, that.isDelete)
				&& Objects.equals(partnerBeneficiaryId, that.partnerBeneficiaryId)
				&& Objects.equals(beneficiaryId, that.beneficiaryId) && Objects.equals(familyUid, that.familyUid)
				&& Objects.equals(hivStatus, that.hivStatus) && Objects.equals(onArt, that.onArt)
				&& Objects.equals(relationship, that.relationship) && Objects.equals(ageMonths, that.ageMonths)
				&& Objects.equals(ageYears, that.ageYears);

	}

	@Override
	public int hashCode() {
		return Objects.hash(id, gender, isActive, isAlive, isBeneficiary, isDelete, partnerBeneficiaryId, beneficiaryId,
				familyUid, hivStatus, onArt, relationship, ageMonths, ageYears);
	}

}
