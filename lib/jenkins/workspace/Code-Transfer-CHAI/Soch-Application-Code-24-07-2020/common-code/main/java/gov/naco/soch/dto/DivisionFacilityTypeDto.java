package gov.naco.soch.dto;

import java.time.LocalDateTime;

public class DivisionFacilityTypeDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long id;

	
	private Integer createdBy;

	
	private LocalDateTime createdTime;

	
	private Boolean isActive;

	
	private Boolean isDelete;

	
	private Integer modifiedBy;

	
	private LocalDateTime modifiedTime;

	
	
	private DivisionDto division;


	private FacilityTypeDto facilityType;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}


	public LocalDateTime getCreatedTime() {
		return createdTime;
	}


	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}


	public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	public Boolean getIsDelete() {
		return isDelete;
	}


	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}


	public Integer getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}


	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}


	public DivisionDto getDivision() {
		return division;
	}


	public void setDivision(DivisionDto division) {
		this.division = division;
	}


	public FacilityTypeDto getFacilityType() {
		return facilityType;
	}


	public void setFacilityType(FacilityTypeDto facilityType) {
		this.facilityType = facilityType;
	}
	

   //toString Method
	@Override
	public String toString() {
		return "DivisionFacilityTypeDto [id=" + id + ", createdBy=" + createdBy + ", createdTime=" + createdTime
				+ ", isActive=" + isActive + ", isDelete=" + isDelete + ", modifiedBy=" + modifiedBy + ", modifiedTime="
				+ modifiedTime + ", division=" + division + ", facilityType=" + facilityType + "]";
	}


	

  //Equals Method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DivisionFacilityTypeDto other = (DivisionFacilityTypeDto) obj;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdTime == null) {
			if (other.createdTime != null)
				return false;
		} else if (!createdTime.equals(other.createdTime))
			return false;
		if (division == null) {
			if (other.division != null)
				return false;
		} else if (!division.equals(other.division))
			return false;
		if (facilityType == null) {
			if (other.facilityType != null)
				return false;
		} else if (!facilityType.equals(other.facilityType))
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
		if (modifiedBy == null) {
			if (other.modifiedBy != null)
				return false;
		} else if (!modifiedBy.equals(other.modifiedBy))
			return false;
		if (modifiedTime == null) {
			if (other.modifiedTime != null)
				return false;
		} else if (!modifiedTime.equals(other.modifiedTime))
			return false;
		return true;
	}


	
	
}
