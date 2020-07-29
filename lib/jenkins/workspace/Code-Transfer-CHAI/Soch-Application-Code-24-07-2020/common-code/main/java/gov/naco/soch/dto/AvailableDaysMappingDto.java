package gov.naco.soch.dto;

import java.time.LocalDateTime;
import java.util.Set;

//DTO class used for transfer data between front end and back end.
public class AvailableDaysMappingDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Long id;
	private Integer createdBy;
	private LocalDateTime createdTime;
	private Boolean friday;
	private Boolean isActive;
	private Boolean isDelete;
	private Integer modifiedBy;
	private LocalDateTime modifiedTime;
	private Boolean monday;
	private Boolean saturday;
	private Boolean sunday;
	private Boolean thursday;
	private Boolean tuesday;
	private Boolean wednesday;

	private Set<BeneficiaryRegistrationDto> beneficiaryRegistrations;

	// Getters and setters for mentioned properties
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

	public Boolean getFriday() {
		return friday;
	}

	public void setFriday(Boolean friday) {
		this.friday = friday;
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

	public Boolean getMonday() {
		return monday;
	}

	public void setMonday(Boolean monday) {
		this.monday = monday;
	}

	public Boolean getSaturday() {
		return saturday;
	}

	public void setSaturday(Boolean saturday) {
		this.saturday = saturday;
	}

	public Boolean getSunday() {
		return sunday;
	}

	public void setSunday(Boolean sunday) {
		this.sunday = sunday;
	}

	public Boolean getThursday() {
		return thursday;
	}

	public void setThursday(Boolean thursday) {
		this.thursday = thursday;
	}

	public Boolean getTuesday() {
		return tuesday;
	}

	public void setTuesday(Boolean tuesday) {
		this.tuesday = tuesday;
	}

	public Boolean getWednesday() {
		return wednesday;
	}

	public void setWednesday(Boolean wednesday) {
		this.wednesday = wednesday;
	}

	public Set<BeneficiaryRegistrationDto> getBeneficiaryRegistrations() {
		return beneficiaryRegistrations;
	}

	public void setBeneficiaryRegistrations(Set<BeneficiaryRegistrationDto> beneficiaryRegistrations) {
		this.beneficiaryRegistrations = beneficiaryRegistrations;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AvailableDaysMappingDto [id=" + id + ", createdBy=" + createdBy + ", createdTime=" + createdTime
				+ ", friday=" + friday + ", isActive=" + isActive + ", isDelete=" + isDelete + ", modifiedBy="
				+ modifiedBy + ", modifiedTime=" + modifiedTime + ", monday=" + monday + ", saturday=" + saturday
				+ ", sunday=" + sunday + ", thursday=" + thursday + ", tuesday=" + tuesday + ", wednesday=" + wednesday
				+ ", beneficiaryRegistrations=" + beneficiaryRegistrations + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvailableDaysMappingDto other = (AvailableDaysMappingDto) obj;
		if (beneficiaryRegistrations == null) {
			if (other.beneficiaryRegistrations != null)
				return false;
		} else if (!beneficiaryRegistrations.equals(other.beneficiaryRegistrations))
			return false;
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
		if (friday == null) {
			if (other.friday != null)
				return false;
		} else if (!friday.equals(other.friday))
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
		if (monday == null) {
			if (other.monday != null)
				return false;
		} else if (!monday.equals(other.monday))
			return false;
		if (saturday == null) {
			if (other.saturday != null)
				return false;
		} else if (!saturday.equals(other.saturday))
			return false;
		if (sunday == null) {
			if (other.sunday != null)
				return false;
		} else if (!sunday.equals(other.sunday))
			return false;
		if (thursday == null) {
			if (other.thursday != null)
				return false;
		} else if (!thursday.equals(other.thursday))
			return false;
		if (tuesday == null) {
			if (other.tuesday != null)
				return false;
		} else if (!tuesday.equals(other.tuesday))
			return false;
		if (wednesday == null) {
			if (other.wednesday != null)
				return false;
		} else if (!wednesday.equals(other.wednesday))
			return false;
		return true;
	}

}
