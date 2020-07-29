package gov.naco.soch.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.naco.soch.domain.Address} entity.
 */
public class AddressDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String address;

	private String addressLineOne;

	private String addressLineTwo;

	private String block;

	private String city;

	private String country;

	private String geoLatitude;

	private String geoLongitude;

	private Integer houseNo;

	private Boolean isActive;

	private Boolean isDelete;

	private String taluk;

	private Long districtId;

	private String pincode;

	private Long pincodeId;

	private Long stateId;

	private Long subdistrictId;

	private Long townId;

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

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getTaluk() {
		return taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
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

	public Long getPincodeId() {
		return pincodeId;
	}

	public void setPincodeId(Long pincodeId) {
		this.pincodeId = pincodeId;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Long getSubdistrictId() {
		return subdistrictId;
	}

	public void setSubdistrictId(Long subdistrictId) {
		this.subdistrictId = subdistrictId;
	}

	public Long getTownId() {
		return townId;
	}

	public void setTownId(Long townId) {
		this.townId = townId;
	}

	@Override
	public String toString() {
		return "AddressDTO [id=" + id + ", address=" + address + ", addressLineOne=" + addressLineOne
				+ ", addressLineTwo=" + addressLineTwo + ", block=" + block + ", city=" + city + ", country=" + country
				+ ", geoLatitude=" + geoLatitude + ", geoLongitude=" + geoLongitude + ", houseNo=" + houseNo
				+ ", isActive=" + isActive + ", isDelete=" + isDelete + ", taluk=" + taluk + ", districtId="
				+ districtId + ", pincode=" + pincode + ", pincodeId=" + pincodeId + ", stateId=" + stateId
				+ ", subdistrictId=" + subdistrictId + ", townId=" + townId + "]";
	}
	
	
}
