package gov.naco.soch.dto;

import java.time.LocalDateTime;
import java.util.List;


public class AddressDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String address;
	private String block;
	private Integer houseNo;
	private String city;
	private Integer createdBy;
	private LocalDateTime createdTime;
	private String geoLatitude;
	private String geoLongitude;
	private Boolean isActive;
	private Boolean isDelete;
	private Integer modifiedBy;
	private LocalDateTime modifiedTime;
	private Long stateId;
	private Long districtId;
	private String pincode;
	private DistrictDto district;
	private StateDto state;

	private List<BeneficiaryDto> beneficiaries;
	private List<FacilityDto> facilities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getGeoLatitude() {
		return geoLatitude;
	}

	public void setGeoLatitude(String geoLatitude) {
		this.geoLatitude = geoLatitude;
	}

	public String getGeoLongitude() {
		return geoLongitude;
	}

	public void setGeoLongitude(String geoLongitude) {
		this.geoLongitude = geoLongitude;
	}

	public Integer getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(Integer houseNo) {
		this.houseNo = houseNo;
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

	public List<BeneficiaryDto> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(List<BeneficiaryDto> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	public List<FacilityDto> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<FacilityDto> facilities) {
		this.facilities = facilities;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public DistrictDto getDistrict() {
		return district;
	}

	public StateDto getState() {
		return state;
	}

	public void setDistrict(DistrictDto district) {
		this.district = district;
	}

	public void setState(StateDto state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
