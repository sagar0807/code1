package gov.naco.soch.dto;

public class FacilityListByDistrictAndFacilityTypeDTO extends BaseDto {

	private static final long serialVersionUID = 1L;
	
	private Long facilityId;
	private String facilityName;
	private Long facilityTypeId;
	private String failityTypeName;
	private String facilityCode;
	private String address;
	private String state;
	private String district;
	private String city;
	private String subDistrict;
	private String town;
	private String pincode;
	private Boolean isActive;
	public Long getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	public Long getFacilityTypeId() {
		return facilityTypeId;
	}
	public void setFacilityTypeId(Long facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}
	public String getFailityTypeName() {
		return failityTypeName;
	}
	public void setFailityTypeName(String failityTypeName) {
		this.failityTypeName = failityTypeName;
	}
	public String getFacilityCode() {
		return facilityCode;
	}
	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getSubDistrict() {
		return subDistrict;
	}
	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "FacilityListByDistrictAndFacilityTypeDTO [facilityId=" + facilityId + ", facilityName=" + facilityName
				+ ", facilityTypeId=" + facilityTypeId + ", failityTypeName=" + failityTypeName + ", facilityCode="
				+ facilityCode + ", address=" + address + ", state=" + state + ", district=" + district + ", city="
				+ city + ", subDistrict=" + subDistrict + ", town=" + town + ", pincode=" + pincode + ", isActive="
				+ isActive + "]";
	}
	
	
}
