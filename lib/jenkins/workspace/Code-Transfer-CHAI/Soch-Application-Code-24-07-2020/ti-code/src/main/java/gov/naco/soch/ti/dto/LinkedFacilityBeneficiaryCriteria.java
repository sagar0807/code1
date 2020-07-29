package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.LongFilter;

public class LinkedFacilityBeneficiaryCriteria implements Serializable, Criteria {

	private static final long serialVersionUID = 1L;

	private LongFilter id;

	private LongFilter linkedFacilityId;

	private BooleanFilter isActive;

	private BooleanFilter isDelete;

	private LongFilter beneficiaryId;

	public LinkedFacilityBeneficiaryCriteria() {
	}

	public LinkedFacilityBeneficiaryCriteria(LinkedFacilityBeneficiaryCriteria other) {
		this.id = other.id == null ? null : other.id.copy();
		this.isActive = other.isActive == null ? null : other.isActive.copy();
		this.isDelete = other.isDelete == null ? null : other.isDelete.copy();
		this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
		this.linkedFacilityId = other.linkedFacilityId == null ? null : other.linkedFacilityId.copy();
	}

	@Override
	public LinkedFacilityBeneficiaryCriteria copy() {
		return new LinkedFacilityBeneficiaryCriteria(this);
	}

	public LongFilter getId() {
		return id;
	}

	public void setId(LongFilter id) {
		this.id = id;
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

	public LongFilter getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(LongFilter beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public LongFilter getLinkedFacilityId() {
		return linkedFacilityId;
	}

	public void setLinkedFacilityId(LongFilter linkedFacilityId) {
		this.linkedFacilityId = linkedFacilityId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final LinkedFacilityBeneficiaryCriteria that = (LinkedFacilityBeneficiaryCriteria) o;
		return Objects.equals(id, that.id) && Objects.equals(isDelete, that.isDelete)
				&& Objects.equals(linkedFacilityId, that.linkedFacilityId) && Objects.equals(isActive, that.isActive)
				&& Objects.equals(beneficiaryId, that.beneficiaryId);

	}

	@Override
	public int hashCode() {
		return Objects.hash(id, isActive, isDelete, beneficiaryId, linkedFacilityId);
	}

	@Override
	public String toString() {
		return "TiOstSatelliteCriteria [id=" + id + ", linkedFacilityId=" + linkedFacilityId + ", isActive=" + isActive
				+ ", isDelete=" + isDelete + ", beneficiaryId=" + beneficiaryId + "]";
	}

}
