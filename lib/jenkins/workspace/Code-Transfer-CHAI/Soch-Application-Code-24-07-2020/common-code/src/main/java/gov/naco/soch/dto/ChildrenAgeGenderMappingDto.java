package gov.naco.soch.dto;

//DTO class used for transfer data between front end and back end.
public class ChildrenAgeGenderMappingDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Long id;
	private String childrenAge;
	private String childrenGender;
	private Boolean isActive;
	private Boolean isDelete;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the childrenAge
	 */
	public String getChildrenAge() {
		return childrenAge;
	}

	/**
	 * @param childrenAge the childrenAge to set
	 */
	public void setChildrenAge(String childrenAge) {
		this.childrenAge = childrenAge;
	}

	/**
	 * @return the childrenGender
	 */
	public String getChildrenGender() {
		return childrenGender;
	}

	/**
	 * @param childrenGender the childrenGender to set
	 */
	public void setChildrenGender(String childrenGender) {
		this.childrenGender = childrenGender;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the isDelete
	 */
	public Boolean getIsDelete() {
		return isDelete;
	}

	/**
	 * @param isDelete the isDelete to set
	 */
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ChildrenAgeGenderMappingDto [id=" + id + ", childrenAge=" + childrenAge + ", childrenGender="
				+ childrenGender + ", isActive=" + isActive + ", isDelete=" + isDelete + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChildrenAgeGenderMappingDto other = (ChildrenAgeGenderMappingDto) obj;
		if (childrenAge == null) {
			if (other.childrenAge != null)
				return false;
		} else if (!childrenAge.equals(other.childrenAge))
			return false;
		if (childrenGender == null) {
			if (other.childrenGender != null)
				return false;
		} else if (!childrenGender.equals(other.childrenGender))
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
		return true;
	}

}