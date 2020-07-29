package gov.naco.soch.dto;

public class ConsigneeAddressDto extends BaseDto{
	private Long consigneeId;
	private String address;
	private String block;
	private Integer houseNo;
	private String city;
	private String district;
	private String state;
	private String pin;
	
	public Long getConsigneeId() {
		return consigneeId;
	}
	public void setConsigneeId(Long consigneeId) {
		this.consigneeId = consigneeId;
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
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
}
