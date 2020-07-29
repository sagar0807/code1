package gov.naco.soch.dto;

import java.io.Serializable;

public class RoleDto implements Serializable, Comparable<RoleDto> {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Long id;
	private String name;
	private Boolean status;
	private Boolean isDelete;
	private Boolean isPrimary;
	private Boolean isActive;
	private Long facilityTypeId;
	private FacilityTypeDto facilityType;

	// getters and setters for the above properties.
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public Boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Long getFacilityTypeId() {
		return facilityTypeId;
	}

	public void setFacilityTypeId(Long facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}

	public FacilityTypeDto getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(FacilityTypeDto facilityType) {
		this.facilityType = facilityType;
	}

	// toString method
	@Override
	public String toString() {
		return "RoleDto [id=" + id + ", name=" + name + ", status=" + status + ", isDelete=" + isDelete + ", isPrimary="
				+ isPrimary + ", isActive=" + isActive + ", facilityTypeId=" + facilityTypeId + "]";
	}

	// equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleDto other = (RoleDto) obj;
		if (facilityTypeId == null) {
			if (other.facilityTypeId != null)
				return false;
		} else if (!facilityTypeId.equals(other.facilityTypeId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (isDelete == null) {
			if (other.isDelete != null)
				return false;
		} else if (!isDelete.equals(other.isDelete))
			return false;
		if (isPrimary == null) {
			if (other.isPrimary != null)
				return false;
		} else if (!isPrimary.equals(other.isPrimary))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public int compareTo(RoleDto o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}

}
