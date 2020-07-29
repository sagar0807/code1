package gov.naco.soch.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//DTO class used for transfer data between front end and back end.
public class DesignationDto implements Serializable {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Long id;

	@NotEmpty(message = " title is mandatory")
	@Size(max = 99, message = "title field size shouldn't exceed 99 characters")
	private String title;
	private String description;
	private Boolean isActive;
	private Boolean isDelete;
	private List<FacilityTypeDto> facilityTypeList;

	private List<ErrorDto> errorList;

	// define getter and setter for the above properties.
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean isActive() {
		return isActive;
	}

	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean isDelete() {
		return isDelete;
	}

	public void setDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public List<ErrorDto> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<ErrorDto> errorList) {
		this.errorList = errorList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public List<FacilityTypeDto> getFacilityTypeList() {
		return facilityTypeList;
	}

	public void setFacilityTypeList(List<FacilityTypeDto> facilityTypeList) {
		this.facilityTypeList = facilityTypeList;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DesignationDto other = (DesignationDto) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (errorList == null) {
			if (other.errorList != null)
				return false;
		} else if (!errorList.equals(other.errorList))
			return false;
		if (facilityTypeList == null) {
			if (other.facilityTypeList != null)
				return false;
		} else if (!facilityTypeList.equals(other.facilityTypeList))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive != other.isActive)
			return false;
		if (isDelete != other.isDelete)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DesignationDto [id=" + id + ", title=" + title + ", description=" + description + ", isActive="
				+ isActive + ", isDelete=" + isDelete + ", errorList=" + errorList + "]";
	}


	
}
