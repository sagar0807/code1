package gov.naco.soch.dto;

import java.time.LocalDate;
import java.util.List;

public class FacilityReceiveStockListDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long facilityDispatchId;
	private Long facilityReciptId;
	private Long facilityId;
	private String stnNumber;
	private String indentNumber;
	private Long consignorId;
	private String consignorName;
	private String consignorAddress;
	private Long consigneeId;
	private String consigneeName;
	private String consigneeAddress;
	private String transporterName;
	private String transporterPhone;
	private String receiptStatus;
	private String consignmentStatus;
	private String dispatchStatus;
	private String grnStatus;
	private String AWBNumber;
	private LocalDate dispatchDate;
	private LocalDate indentDate;
	private Long userId;
	private LocalDate receiptDate;
	private String remark;
	private List<FacilityProductBatchDto> Products;
	private List<DispatchRemarkDto> remarks;

	public String getStnNumber() {
		return stnNumber;
	}

	public String getIndentNumber() {
		return indentNumber;
	}

	public Long getConsignorId() {
		return consignorId;
	}

	public String getConsignorName() {
		return consignorName;
	}

	public String getConsignorAddress() {
		return consignorAddress;
	}

	public Long getFacilityReciptId() {
		return facilityReciptId;
	}

	public void setFacilityReciptId(Long facilityReciptId) {
		this.facilityReciptId = facilityReciptId;
	}

	public Long getConsigneeId() {
		return consigneeId;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public List<DispatchRemarkDto> getRemarks() {
		return remarks;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public void setRemarks(List<DispatchRemarkDto> remarks) {
		this.remarks = remarks;
	}

	public void setStnNumber(String stnNumber) {
		this.stnNumber = stnNumber;
	}

	public void setIndentNumber(String indentNumber) {
		this.indentNumber = indentNumber;
	}

	public void setConsignorId(Long consignorId) {
		this.consignorId = consignorId;
	}

	public void setConsignorName(String consignorName) {
		this.consignorName = consignorName;
	}

	public void setConsignorAddress(String consignorAddress) {
		this.consignorAddress = consignorAddress;
	}

	public Long getFacilityDispatchId() {
		return facilityDispatchId;
	}

	public void setFacilityDispatchId(Long facilityDispatchId) {
		this.facilityDispatchId = facilityDispatchId;
	}

	public void setConsigneeId(Long consigneeId) {
		this.consigneeId = consigneeId;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public List<FacilityProductBatchDto> getProducts() {
		return Products;
	}

	public void setProducts(List<FacilityProductBatchDto> products) {
		Products = products;
	}

	public String getTransporterName() {
		return transporterName;
	}

	public LocalDate getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(LocalDate receiptDate) {
		this.receiptDate = receiptDate;
	}

	public String getTransporterPhone() {
		return transporterPhone;
	}

	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}

	public String getGrnStatus() {
		return grnStatus;
	}

	public void setGrnStatus(String grnStatus) {
		this.grnStatus = grnStatus;
	}

	public void setTransporterPhone(String transporterPhone) {
		this.transporterPhone = transporterPhone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getReceiptStatus() {
		return receiptStatus;
	}

	public String getConsignmentStatus() {
		return consignmentStatus;
	}

	public String getDispatchStatus() {
		return dispatchStatus;
	}

	public String getAWBNumber() {
		return AWBNumber;
	}

	public LocalDate getIndentDate() {
		return indentDate;
	}

	public void setIndentDate(LocalDate indentDate) {
		this.indentDate = indentDate;
	}

	public void setReceiptStatus(String receiptStatus) {
		this.receiptStatus = receiptStatus;
	}

	public void setConsignmentStatus(String consignmentStatus) {
		this.consignmentStatus = consignmentStatus;
	}

	public void setDispatchStatus(String dispatchStatus) {
		this.dispatchStatus = dispatchStatus;
	}

	public void setAWBNumber(String aWBNumber) {
		AWBNumber = aWBNumber;
	}

	public LocalDate getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(LocalDate dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
