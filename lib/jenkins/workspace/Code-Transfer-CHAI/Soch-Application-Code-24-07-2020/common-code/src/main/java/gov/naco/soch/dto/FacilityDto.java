package gov.naco.soch.dto;

import java.time.LocalDateTime;
import java.util.Set;

//DTO class used for transfer data between front end and back end
public class FacilityDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Long id;
	private String name;
	private String code;
	private Integer createdBy;
	private LocalDateTime createdTime;
	private Boolean isActive;
	private Boolean isDelete;
	private Integer modifiedBy;
	private LocalDateTime modifiedTime;

	private Long addressId;
	private String facilityAddress;
	private Long stateId;
	private Long districtId;
	private String city;
	private String pincode;
	private Long userFacilityMappingId;
	private Long primaryUserId;
	private Long facilityTypeId;
	private Long divisionId;
	private Long parentFacilityId;

	private AddressDto address;
	private DivisionDto division;
	private FacilityTypeDto facilityType;
	private Set<UserFacilityMappingDto> userFacilityMappingsList;

	// default constructor
	public FacilityDto() {
		super();
	}

	// getters and setters
	public Long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public String getName() {
		return name;
	}

	public AddressDto getAddress() {
		return address;
	}

	public DivisionDto getDivision() {
		return division;
	}

	public FacilityTypeDto getFacilityType() {
		return facilityType;
	}

	public Set<UserFacilityMappingDto> getUserFacilityMappingsList() {
		return userFacilityMappingsList;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAddressId() {
		return addressId;
	}

	public String getFacilityAddress() {
		return facilityAddress;
	}

	public Long getStateId() {
		return stateId;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public String getCity() {
		return city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public void setFacilityAddress(String facilityAddress) {
		this.facilityAddress = facilityAddress;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public void setDivision(DivisionDto division) {
		this.division = division;
	}

	public void setFacilityType(FacilityTypeDto facilityType) {
		this.facilityType = facilityType;
	}

	public void setUserFacilityMappingsList(Set<UserFacilityMappingDto> userFacilityMappingsList) {
		this.userFacilityMappingsList = userFacilityMappingsList;
	}

	public Long getUserFacilityMappingId() {
		return userFacilityMappingId;
	}

	public Long getPrimaryUserId() {
		return primaryUserId;

	}

	public void setPrimaryUserId(Long primaryUserId) {
		this.primaryUserId = primaryUserId;
	}

	public Long getFacilityTypeId() {
		return facilityTypeId;
	}

	public Long getDivisionId() {
		return divisionId;
	}

	public Long getParentFacilityId() {
		return parentFacilityId;
	}

	public void setParentFacilityId(Long parentFacilityId) {
		this.parentFacilityId = parentFacilityId;
	}

	public void setFacilityTypeId(Long facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}

	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}

	public void setUserFacilityMappingId(Long userFacilityMappingId) {
		this.userFacilityMappingId = userFacilityMappingId;
	}

	@Override
	public String toString() {
		return "FacilityDto [id=" + id + ", name=" + name + ", code=" + code + ", createdBy=" + createdBy
				+ ", createdTime=" + createdTime + ", isActive=" + isActive + ", isDelete=" + isDelete + ", modifiedBy="
				+ modifiedBy + ", modifiedTime=" + modifiedTime + ", addressId=" + addressId + ", facilityAddress="
				+ facilityAddress + ", stateId=" + stateId + ", districtId=" + districtId + ", city=" + city
				+ ", pincode=" + pincode + ", userFacilityMappingId=" + userFacilityMappingId + ", primaryUserId="
				+ primaryUserId + ", facilityTypeId=" + facilityTypeId + ", divisionId=" + divisionId
				+ ", parentFacilityId=" + parentFacilityId + ", address=" + address + ", division=" + division
				+ ", facilityType=" + facilityType + ", userFacilityMappingsList=" + userFacilityMappingsList + "]";
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
		FacilityDto other = (FacilityDto) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (userFacilityMappingsList == null) {
			if (other.userFacilityMappingsList != null)
				return false;
		} else if (!userFacilityMappingsList.equals(other.userFacilityMappingsList))
			return false;
		return true;
	}

}
