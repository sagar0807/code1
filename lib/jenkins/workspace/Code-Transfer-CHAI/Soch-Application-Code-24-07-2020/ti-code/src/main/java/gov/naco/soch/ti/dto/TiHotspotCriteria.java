package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

public class TiHotspotCriteria implements Serializable, Criteria {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LongFilter id;

	private LongFilter facilityId;

	private LongFilter ostFacilityId;

	private StringFilter hotspotName;

	private StringFilter hotspotCode;

	private StringFilter hotspotStatus;

	private BooleanFilter isDelete;

	private BooleanFilter isActive;

	private StringFilter status;

	private LongFilter typologyId;

	public LongFilter getId() {
		return id;
	}

	public void setId(LongFilter id) {
		this.id = id;
	}

	public LongFilter getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(LongFilter facilityId) {
		this.facilityId = facilityId;
	}

	public StringFilter getHotspotName() {
		return hotspotName;
	}

	public void setHotspotName(StringFilter hotspotName) {
		this.hotspotName = hotspotName;
	}

	public StringFilter getHotspotCode() {
		return hotspotCode;
	}

	public void setHotspotCode(StringFilter hotspotCode) {
		this.hotspotCode = hotspotCode;
	}

	public LongFilter getOstFacilityId() {
		return ostFacilityId;
	}

	public void setOstFacilityId(LongFilter ostFacilityId) {
		this.ostFacilityId = ostFacilityId;
	}

	public StringFilter getHotspotStatus() {
		return hotspotStatus;
	}

	public void setHotspotStatus(StringFilter hotspotStatus) {
		this.hotspotStatus = hotspotStatus;
	}

	public BooleanFilter getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(BooleanFilter isDelete) {
		this.isDelete = isDelete;
	}

	public BooleanFilter getIsActive() {
		return isActive;
	}

	public void setIsActive(BooleanFilter isActive) {
		this.isActive = isActive;
	}

	public StringFilter getStatus() {
		return status;
	}

	public void setStatus(StringFilter status) {
		this.status = status;
	}

	public TiHotspotCriteria() {

	}


	public LongFilter getTypologyId() {
		return typologyId;
	}

	public void setTypologyId(LongFilter typologyId) {
		this.typologyId = typologyId;
	}

	public TiHotspotCriteria(TiHotspotCriteria other) {
		this.id = other.id == null ? null : other.id.copy();
		this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
		this.hotspotName = other.hotspotName == null ? null : other.hotspotName.copy();
		this.hotspotCode = other.hotspotCode == null ? null : other.hotspotCode.copy();
		this.hotspotStatus = other.hotspotStatus == null ? null : other.hotspotStatus.copy();
		this.isDelete = other.isDelete == null ? null : other.isDelete.copy();
		this.isActive = other.isActive == null ? null : other.isActive.copy();
		this.status = other.status == null ? null : other.status.copy();
		this.ostFacilityId = other.ostFacilityId == null ? null : other.ostFacilityId.copy();
		this.typologyId = other.typologyId == null ? null : other.typologyId.copy();

	}

	@Override
	public Criteria copy() {

		return new TiHotspotCriteria(this);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final TiHotspotCriteria that = (TiHotspotCriteria) o;
		return Objects.equals(id, that.id) && Objects.equals(facilityId, that.facilityId)
				&& Objects.equals(isActive, that.isActive) && Objects.equals(isDelete, that.isDelete)
				&& Objects.equals(hotspotCode, that.hotspotCode) && Objects.equals(hotspotName, that.hotspotName)
				&& Objects.equals(hotspotStatus, that.hotspotStatus)
				&& Objects.equals(ostFacilityId, that.ostFacilityId) && Objects.equals(status, that.status)
				&& Objects.equals(typologyId, that.typologyId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, facilityId, isActive, isDelete, hotspotCode, hotspotName, hotspotStatus, status,
				ostFacilityId, typologyId);
	}

}
