package gov.naco.soch.dto;

import java.time.LocalDate;
import java.util.List;

public class UnregisteredSourceReceiveStockDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long receiptId;
	private LocalDate receiptDate;
	private Long sourceId;
	private String sourceName;
	private Long addressId;
	private String address;
	private Long stateId;
	private String state;
	private Long districtId;
	private String district;
	private Long subDistrictId;
	private String subDistrict;
	private Long townId;
	private String town;
	private Long pincodeId;
	private String pincode;
	private Long facilityId;
	private String facilityName;
	private List<BatchDto> batchDetails;
	private String remarks;
	private List<RemarkDto> remarksList;
	private List<String> products;
	private Long receiptStatusId;
	private String receiptStatus;
	private Long grnStatusId;
	private String grnStatus;

	private LocalDate indentDate;
	private LocalDate expectedDispatchDate;
	private LocalDate expectedArrivalDate;
	private String transporterAwbNumber;
	private String transporterName;
	private String transporterPhone;

	public Long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(Long receiptId) {
		this.receiptId = receiptId;
	}
	
	public LocalDate getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(LocalDate receiptDate) {
		this.receiptDate = receiptDate;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long id) {
		this.sourceId = id;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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

	public Long getTownId() {
		return townId;
	}

	public void setTownId(Long townId) {
		this.townId = townId;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public Long getPincodeId() {
		return pincodeId;
	}

	public void setPincodeId(Long pincodeId) {
		this.pincodeId = pincodeId;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public List<BatchDto> getBatchDetails() {
		return batchDetails;
	}

	public void setBatchDetails(List<BatchDto> batchDetails) {
		this.batchDetails = batchDetails;
	}

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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<RemarkDto> getRemarksList() {
		return remarksList;
	}

	public void setRemarksList(List<RemarkDto> remarksList) {
		this.remarksList = remarksList;
	}

	public List<String> getProducts() {
		return products;
	}

	public void setProducts(List<String> products) {
		this.products = products;
	}

	public Long getReceiptStatusId() {
		return receiptStatusId;
	}

	public void setReceiptStatusId(Long receiptStatusId) {
		this.receiptStatusId = receiptStatusId;
	}

	public String getReceiptStatus() {
		return receiptStatus;
	}

	public void setReceiptStatus(String receiptStatus) {
		this.receiptStatus = receiptStatus;
	}

	public Long getGrnStatusId() {
		return grnStatusId;
	}

	public void setGrnStatusId(Long grnStatusId) {
		this.grnStatusId = grnStatusId;
	}

	public String getGrnStatus() {
		return grnStatus;
	}

	public void setGrnStatus(String grnStatus) {
		this.grnStatus = grnStatus;
	}

	public LocalDate getIndentDate() {
		return indentDate;
	}

	public void setIndentDate(LocalDate indentDate) {
		this.indentDate = indentDate;
	}

	public LocalDate getExpectedDispatchDate() {
		return expectedDispatchDate;
	}

	public void setExpectedDispatchDate(LocalDate expectedDispatchDate) {
		this.expectedDispatchDate = expectedDispatchDate;
	}

	public LocalDate getExpectedArrivalDate() {
		return expectedArrivalDate;
	}

	public void setExpectedArrivalDate(LocalDate expectedArrivalDate) {
		this.expectedArrivalDate = expectedArrivalDate;
	}

	public String getTransporterAwbNumber() {
		return transporterAwbNumber;
	}

	public void setTransporterAwbNumber(String transporterAwbNumber) {
		this.transporterAwbNumber = transporterAwbNumber;
	}

	public String getTransporterName() {
		return transporterName;
	}

	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}

	public String getTransporterPhone() {
		return transporterPhone;
	}

	public void setTransporterPhone(String transporterPhone) {
		this.transporterPhone = transporterPhone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
