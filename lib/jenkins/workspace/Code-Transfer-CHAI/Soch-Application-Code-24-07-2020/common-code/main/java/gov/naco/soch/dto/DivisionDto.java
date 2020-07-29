package gov.naco.soch.dto;

import java.util.List;

/**
 * Division related DTO class used for transfer data between front end and back
 * end.
 *
 */
public class DivisionDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String code;
	private String name;
	private String headDdgName;
	private String headDdgEmail;
	private String headDdgMobileNo;
	private String npoEmail;
	private String npoMobileNo;
	private String npoName;
	private String sccEmail;
	private String sccMobileNo;
	private String sccName;
	private List<FacilityTypeDto> facilityTypes;
	private Long facilityTypeId;
	private Boolean isActive;
	private Boolean isDelete;
	private String facilityTypeNames;

	private List<Long> facilityTypeIds;

	public Long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getHeadDdgName() {
		return headDdgName;
	}

	public String getHeadDdgEmail() {
		return headDdgEmail;
	}

	public String getHeadDdgMobileNo() {
		return headDdgMobileNo;
	}

	public String getNpoEmail() {
		return npoEmail;
	}

	public String getNpoMobileNo() {
		return npoMobileNo;
	}

	public String getNpoName() {
		return npoName;
	}

	public String getSccEmail() {
		return sccEmail;
	}

	public String getSccMobileNo() {
		return sccMobileNo;
	}

	public String getSccName() {
		return sccName;
	}

	public List<FacilityTypeDto> getFacilityTypes() {
		return facilityTypes;
	}

	public Long getFacilityTypeId() {
		return facilityTypeId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public List<Long> getFacilityTypeIds() {
		return facilityTypeIds;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHeadDdgName(String headDdgName) {
		this.headDdgName = headDdgName;
	}

	public void setHeadDdgEmail(String headDdgEmail) {
		this.headDdgEmail = headDdgEmail;
	}

	public void setHeadDdgMobileNo(String headDdgMobileNo) {
		this.headDdgMobileNo = headDdgMobileNo;
	}

	public void setNpoEmail(String npoEmail) {
		this.npoEmail = npoEmail;
	}

	public void setNpoMobileNo(String npoMobileNo) {
		this.npoMobileNo = npoMobileNo;
	}

	public void setNpoName(String npoName) {
		this.npoName = npoName;
	}

	public void setSccEmail(String sccEmail) {
		this.sccEmail = sccEmail;
	}

	public void setSccMobileNo(String sccMobileNo) {
		this.sccMobileNo = sccMobileNo;
	}

	public void setSccName(String sccName) {
		this.sccName = sccName;
	}

	public void setFacilityTypes(List<FacilityTypeDto> facilityTypes) {
		this.facilityTypes = facilityTypes;
	}

	public void setFacilityTypeId(Long facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public void setFacilityTypeIds(List<Long> facilityTypeIds) {
		this.facilityTypeIds = facilityTypeIds;
	}

	public String getFacilityTypeNames() {
		return facilityTypeNames;
	}

	public void setFacilityTypeNames(String facilityTypeNames) {
		this.facilityTypeNames = facilityTypeNames;
	}

	@Override
	public String toString() {
		return "DivisionDto [id=" + id + ", code=" + code + ", name=" + name + ", headDdgName=" + headDdgName
				+ ", headDdgEmail=" + headDdgEmail + ", headDdgMobileNo=" + headDdgMobileNo + ", npoEmail=" + npoEmail
				+ ", npoMobileNo=" + npoMobileNo + ", npoName=" + npoName + ", sccEmail=" + sccEmail + ", sccMobileNo="
				+ sccMobileNo + ", sccName=" + sccName + ", facilityTypes=" + facilityTypes + ", facilityTypeId="
				+ facilityTypeId + ", isActive=" + isActive + ", isDelete=" + isDelete + ", facilityTypeNames="
				+ facilityTypeNames + ", facilityTypeIds=" + facilityTypeIds + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DivisionDto other = (DivisionDto) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (facilityTypeId == null) {
			if (other.facilityTypeId != null)
				return false;
		} else if (!facilityTypeId.equals(other.facilityTypeId))
			return false;
		if (facilityTypeIds == null) {
			if (other.facilityTypeIds != null)
				return false;
		} else if (!facilityTypeIds.equals(other.facilityTypeIds))
			return false;
		if (facilityTypeNames == null) {
			if (other.facilityTypeNames != null)
				return false;
		} else if (!facilityTypeNames.equals(other.facilityTypeNames))
			return false;
		if (facilityTypes == null) {
			if (other.facilityTypes != null)
				return false;
		} else if (!facilityTypes.equals(other.facilityTypes))
			return false;
		if (headDdgEmail == null) {
			if (other.headDdgEmail != null)
				return false;
		} else if (!headDdgEmail.equals(other.headDdgEmail))
			return false;
		if (headDdgMobileNo == null) {
			if (other.headDdgMobileNo != null)
				return false;
		} else if (!headDdgMobileNo.equals(other.headDdgMobileNo))
			return false;
		if (headDdgName == null) {
			if (other.headDdgName != null)
				return false;
		} else if (!headDdgName.equals(other.headDdgName))
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (npoEmail == null) {
			if (other.npoEmail != null)
				return false;
		} else if (!npoEmail.equals(other.npoEmail))
			return false;
		if (npoMobileNo == null) {
			if (other.npoMobileNo != null)
				return false;
		} else if (!npoMobileNo.equals(other.npoMobileNo))
			return false;
		if (npoName == null) {
			if (other.npoName != null)
				return false;
		} else if (!npoName.equals(other.npoName))
			return false;
		if (sccEmail == null) {
			if (other.sccEmail != null)
				return false;
		} else if (!sccEmail.equals(other.sccEmail))
			return false;
		if (sccMobileNo == null) {
			if (other.sccMobileNo != null)
				return false;
		} else if (!sccMobileNo.equals(other.sccMobileNo))
			return false;
		if (sccName == null) {
			if (other.sccName != null)
				return false;
		} else if (!sccName.equals(other.sccName))
			return false;
		return true;
	}

}
