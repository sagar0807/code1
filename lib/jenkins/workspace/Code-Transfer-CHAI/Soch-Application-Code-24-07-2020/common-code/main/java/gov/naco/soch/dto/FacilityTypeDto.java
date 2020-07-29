/**
 * 
 */
package gov.naco.soch.dto;

import java.io.Serializable;
import java.util.List;

public class FacilityTypeDto implements Serializable , Comparable<FacilityTypeDto>{

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Long id;
	private String facilityTypeName;
	private boolean isActive;

	private List<DivisionDto> division;
	private List<UserMasterDto> user;
	private List<RoleDto> roleDto;
	private List<DesignationDto> designationList;

	public FacilityTypeDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getFacilityTypeName() {
		return facilityTypeName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFacilityTypeName(String facilityTypeName) {
		this.facilityTypeName = facilityTypeName;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<DivisionDto> getDivision() {
		return division;
	}

	public List<UserMasterDto> getUser() {
		return user;
	}

	public void setDivision(List<DivisionDto> division) {
		this.division = division;
	}

	public void setUser(List<UserMasterDto> user) {
		this.user = user;
	}

	public List<RoleDto> getRoleDto() {
		return roleDto;
	}

	public void setRoleDto(List<RoleDto> roleDto) {
		this.roleDto = roleDto;
	}

	public List<DesignationDto> getDesignationList() {
		return designationList;
	}

	public void setDesignationList(List<DesignationDto> designationList) {
		this.designationList = designationList;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "FacilityTypeDto [id=" + id + ", facilityTypeName=" + facilityTypeName + ", isActive=" + isActive
				+ ", division=" + division + ", user=" + user + ", roleDto=" + roleDto + ", designationList="
				+ designationList + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacilityTypeDto other = (FacilityTypeDto) obj;
		if (designationList == null) {
			if (other.designationList != null)
				return false;
		} else if (!designationList.equals(other.designationList))
			return false;
		if (division == null) {
			if (other.division != null)
				return false;
		} else if (!division.equals(other.division))
			return false;
		if (facilityTypeName == null) {
			if (other.facilityTypeName != null)
				return false;
		} else if (!facilityTypeName.equals(other.facilityTypeName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive != other.isActive)
			return false;
		if (roleDto == null) {
			if (other.roleDto != null)
				return false;
		} else if (!roleDto.equals(other.roleDto))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public int compareTo(FacilityTypeDto ft) {
		// TODO Auto-generated method stub
		return this.getFacilityTypeName().compareTo(ft.getFacilityTypeName());
	}

}
