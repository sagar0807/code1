package gov.naco.soch.dto;

public class BeneficiaryAddressDto extends BaseDto {
//	addressLineOne, addresLineTwo,
//	state, district, taluk, town, pincode

	private Long id;
	private String addressLineOne;
	private String addressLineTwo;
	private Long stateId;
	private Long districtId;
	private String taluk;
	private Long townId;
	private Long subDistrictId;
	private String subDistrict;
	private String city;
	private String pincode;
	private SubdistrictDto subdistrict;
	private StateDto state;
	private DistrictDto district;
	private TownDto town;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTaluk() {
		return taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
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

	public Long getTownId() {
		return townId;
	}

	public void setTownId(Long townId) {
		this.townId = townId;
	}

	public Long getSubDistrictId() {
		return subDistrictId;
	}

	public void setSubDistrictId(Long subDistrictId) {
		this.subDistrictId = subDistrictId;
	}

	public String getSubDistrict() {
		return subDistrict;
	}

	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
	}

	public SubdistrictDto getSubdistrict() {
		return subdistrict;
	}

	public void setSubdistrict(SubdistrictDto subdistrict) {
		this.subdistrict = subdistrict;
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

	public TownDto getTown() {
		return town;
	}

	public void setTown(TownDto town) {
		this.town = town;
	}

}
