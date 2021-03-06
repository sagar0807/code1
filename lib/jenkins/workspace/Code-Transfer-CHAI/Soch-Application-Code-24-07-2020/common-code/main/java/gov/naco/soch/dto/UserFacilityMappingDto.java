package gov.naco.soch.dto;


import java.io.Serializable;
import java.time.LocalDateTime;

public class UserFacilityMappingDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private Integer createdBy;

	private LocalDateTime createdTime;

	private Boolean isActive;

	private Boolean isDelete;

	private Integer modifiedBy;

	private LocalDateTime modifiedTime;

	private FacilityDto facilityDto;

	private UserMasterDto userMasterDto;

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

	public FacilityDto getFacilityDto() {
		return facilityDto;
	}

	public void setFacilityDto(FacilityDto facilityDto) {
		this.facilityDto = facilityDto;
	}

	public UserMasterDto getUserMasterDto() {
		return userMasterDto;
	}

	public void setUserMasterDto(UserMasterDto userMasterDto) {
		this.userMasterDto = userMasterDto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	//toString

	@Override
	public String toString() {
		return "UserFacilityMappingDto [id=" + id + ", createdBy=" + createdBy + ", createdTime=" + createdTime
				+ ", isActive=" + isActive + ", isDelete=" + isDelete + ", modifiedBy=" + modifiedBy + ", modifiedTime="

				+ modifiedTime + ", facilityDto=" + facilityDto + ", userMasterDto=" + userMasterDto + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserFacilityMappingDto other = (UserFacilityMappingDto) obj;
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

		if (facilityDto == null) {
			if (other.facilityDto != null)
				return false;
		} else if (!facilityDto.equals(other.facilityDto))

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
		if (userMasterDto == null) {
			if (other.userMasterDto != null)
				return false;
		} else if (!userMasterDto.equals(other.userMasterDto))
			return false;
		return true;
	}
	
}


