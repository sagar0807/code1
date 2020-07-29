package gov.naco.soch.dto;

import java.util.List;

public class ProductDispatchHistoryDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long facilityDispatchId;
	private String stnNumber;
	private String consignee;
	private Long consigneeId;
	private String dispatchDate;
	private List<String> productNames;
	private Long totalQuantity;
	private Long totalBox;
	private String status;
	private Long statusId;

	private String indentNumber;
	private String indentDate;
	private String transporterOrCourier;
	private String awbNumber;
	private String contactNumber;

	private String consigneeType;
	private String consigneeName;
	private String consigneeAddress;
	private String consigneeStatus;
	private String receiptStatus;

	private String consignorType;
	private Long consignorId;
	private String consignorName;
	private String consignorAddress;

	private Long consignmentStatusId;
	private String consignmentStatus;

	private Long dispatchStatusId;
	private String dispatchStatus;

	private Long requestStatusId;
	private String requestStatus;

	private String dispatchType;

	private List<DescriptionOfProductsDto> descriptionOfGoodsOrDrugs;

	private List<RemarkDto> remarks;

	public Long getFacilityDispatchId() {
		return facilityDispatchId;
	}

	public void setFacilityDispatchId(Long facilityDispatchId) {
		this.facilityDispatchId = facilityDispatchId;
	}

	public String getStnNumber() {
		return stnNumber;
	}

	public void setStnNumber(String stnNumber) {
		this.stnNumber = stnNumber;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(String dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public List<String> getProductNames() {
		return productNames;
	}

	public void setProductNames(List<String> productNames) {
		this.productNames = productNames;
	}

	public Long getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Long getTotalBox() {
		return totalBox;
	}

	public void setTotalBox(Long totalBox) {
		this.totalBox = totalBox;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getIndentNumber() {
		return indentNumber;
	}

	public void setIndentNumber(String indentNumber) {
		this.indentNumber = indentNumber;
	}

	public String getIndentDate() {
		return indentDate;
	}

	public void setIndentDate(String indentDate) {
		this.indentDate = indentDate;
	}

	public String getTransporterOrCourier() {
		return transporterOrCourier;
	}

	public void setTransporterOrCourier(String transporterOrCourier) {
		this.transporterOrCourier = transporterOrCourier;
	}

	public String getAwbNumber() {
		return awbNumber;
	}

	public void setAwbNumber(String awbNumber) {
		this.awbNumber = awbNumber;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getConsigneeType() {
		return consigneeType;
	}

	public void setConsigneeType(String consigneeType) {
		this.consigneeType = consigneeType;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public Long getConsigneeId() {
		return consigneeId;
	}

	public void setConsigneeId(Long consigneeId) {
		this.consigneeId = consigneeId;
	}

	public String getConsigneeStatus() {
		return consigneeStatus;
	}

	public void setConsigneeStatus(String consigneeStatus) {
		this.consigneeStatus = consigneeStatus;
	}

	public String getReceiptStatus() {
		return receiptStatus;
	}

	public void setReceiptStatus(String receiptStatus) {
		this.receiptStatus = receiptStatus;
	}

	public List<DescriptionOfProductsDto> getDescriptionOfGoodsOrDrugs() {
		return descriptionOfGoodsOrDrugs;
	}

	public void setDescriptionOfGoodsOrDrugs(List<DescriptionOfProductsDto> descriptionOfGoodsOrDrugs) {
		this.descriptionOfGoodsOrDrugs = descriptionOfGoodsOrDrugs;
	}

	public List<RemarkDto> getRemarks() {
		return remarks;
	}

	public void setRemarks(List<RemarkDto> remarks) {
		this.remarks = remarks;
	}

	public Long getConsignorId() {
		return consignorId;
	}

	public void setConsignorId(Long consignorId) {
		this.consignorId = consignorId;
	}

	public String getConsignorName() {
		return consignorName;
	}

	public void setConsignorName(String consignorName) {
		this.consignorName = consignorName;
	}

	public String getConsignorAddress() {
		return consignorAddress;
	}

	public void setConsignorAddress(String consignorAddress) {
		this.consignorAddress = consignorAddress;
	}

	public Long getConsignmentStatusId() {
		return consignmentStatusId;
	}

	public void setConsignmentStatusId(Long consignmentStatusId) {
		this.consignmentStatusId = consignmentStatusId;
	}

	public String getConsignmentStatus() {
		return consignmentStatus;
	}

	public void setConsignmentStatus(String consignmentStatus) {
		this.consignmentStatus = consignmentStatus;
	}

	public Long getDispatchStatusId() {
		return dispatchStatusId;
	}

	public void setDispatchStatusId(Long dispatchStatusId) {
		this.dispatchStatusId = dispatchStatusId;
	}

	public String getDispatchStatus() {
		return dispatchStatus;
	}

	public void setDispatchStatus(String dispatchStatus) {
		this.dispatchStatus = dispatchStatus;
	}

	public Long getRequestStatusId() {
		return requestStatusId;
	}

	public void setRequestStatusId(Long requestStatusId) {
		this.requestStatusId = requestStatusId;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getDispatchType() {
		return dispatchType;
	}

	public String getConsignorType() {
		return consignorType;
	}

	public void setConsignorType(String consignorType) {
		this.consignorType = consignorType;
	}

	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProductDispatchHistoryDto [facilityDispatchId=" + facilityDispatchId + ", stnNumber=" + stnNumber
				+ ", consignee=" + consignee + ", consigneeId=" + consigneeId + ", dispatchDate=" + dispatchDate
				+ ", productNames=" + productNames + ", totalQuantity=" + totalQuantity + ", totalBox=" + totalBox
				+ ", status=" + status + ", statusId=" + statusId + ", indentNumber=" + indentNumber + ", indentDate="
				+ indentDate + ", transporterOrCourier=" + transporterOrCourier + ", awbNumber=" + awbNumber
				+ ", contactNumber=" + contactNumber + ", consigneeType=" + consigneeType + ", consigneeName="
				+ consigneeName + ", consigneeAddress=" + consigneeAddress + ", consigneeStatus=" + consigneeStatus
				+ ", receiptStatus=" + receiptStatus + ", consignorId=" + consignorId + ", consignorName="
				+ consignorName + ", consignorAddress=" + consignorAddress + ", consignmentStatusId="
				+ consignmentStatusId + ", consignmentStatus=" + consignmentStatus + ", dispatchStatusId="
				+ dispatchStatusId + ", dispatchStatus=" + dispatchStatus + ", requestStatusId=" + requestStatusId
				+ ", requestStatus=" + requestStatus + ", dispatchType=" + dispatchType + ", descriptionOfGoodsOrDrugs="
				+ descriptionOfGoodsOrDrugs + ", remarks=" + remarks + "]";
	}

}
