package gov.naco.soch.dto;

public class TiBeneficiaryAddressDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String address;
	private String block;
	private Integer houseNo;
	private String addressLineOne;
	private String addressLineTwo;
	private String city;
	private String geoLatitude;
	private String geoLongitude;
	private SubdistrictDto subdistrict;
	private StateDto state;
	private DistrictDto district;
	private TownDto town;
	private Long townId;
	private Long subDistrictId;
	private Long stateId;
	private Long districtId;
	private String pincode;

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

	public Integer getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(Integer houseNo) {
		this.houseNo = houseNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public SubdistrictDto getSubdistrict() {
		return subdistrict;
	}

	public void setSubdistrict(SubdistrictDto subdistrict) {
		this.subdistrict = subdistrict;
	}

	public TownDto getTown() {
		return town;
	}

	public void setTown(TownDto town) {
		this.town = town;
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

	public Long getSubDistrictId() {
		return subDistrictId;
	}

	public void setSubDistrictId(Long subDistrictId) {
		this.subDistrictId = subDistrictId;
	}

	public Long getTownId() {
		return townId;
	}

	public void setTownId(Long townId) {
		this.townId = townId;
	}

	public StateDto getState() {
		return state;
	}

	public void setState(StateDto state) {
		this.state = state;
	}

	public DistrictDto getDistrict() {
		return district;
	}

	public void setDistrict(DistrictDto district) {
		this.district = district;
	}
	

}
