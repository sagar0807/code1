package gov.naco.soch.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class DispatchDetailedDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long dispatchId;
	private String stnNumber;
	private String indentNumber;
	private String noa;
	private String invoiceNumber;
	private LocalDate invoiceDate;
	private LocalDate indentDate;
	private LocalDate expectedDispatchDate;
	private LocalDate expectedArrivalDate;
	private String transporterAwbNumber;
	private String transporterName;
	private String transporterPhone;
	private String driverName;
	private Long billedToFacilityId;
	private String billedToFacilityName;
	private String billedToFacilityAddress;
	private Long shippedToFacilityId;
	private String shippedToFacilityName;
	private String shippedToFacilityAddress;
	private Long consignerId;
	private String consignorName;
	private String consignorAddress;
	private String consigneeName;
	private ConsigneeAddressDto consigneeAddress;
	private LocalDate allotmentDate;
	private Long productId;
	private String productName;

	private Long contractProductId;
	private Long contractId;
	private Long scheduleId;
	private String scheduleNumber;
	private Long lotId;
	private String lotNumber;
	private String consignmentStatus;
	private String receiptStatus;
	private String dispatchStatus;
	private String remark;
	private Long userId;
	private LocalDateTime receiptDate;
	private Long productQuantity;
	private List<BatchDto> batchDetails;
	private List<DispatchRemarkDto> remarks;
	private List<BatchDto> activeBatchDetails;
	private List<BatchDto> inActiveBatchDetails;
	private String dispatchType;
	private Long goodsRequestId;

	public String getNoa() {
		return noa;
	}

	public void setNoa(String noa) {
		this.noa = noa;
	}

	public LocalDateTime getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(LocalDateTime receiptDate) {
		this.receiptDate = receiptDate;
	}

	public Long getDispatchId() {
		return dispatchId;
	}

	public String getStnNumber() {
		return stnNumber;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public LocalDate getInvoiceDate() {
		return invoiceDate;
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

	public LocalDate getExpectedArrivalDate() {
		return expectedArrivalDate;
	}

	public String getTransporterName() {
		return transporterName;
	}

	public String getTransporterAwbNumber() {
		return transporterAwbNumber;
	}

	public void setTransporterAwbNumber(String transporterAwbNumber) {
		this.transporterAwbNumber = transporterAwbNumber;
	}

	public String getTransporterPhone() {
		return transporterPhone;
	}

	public String getDriverName() {
		return driverName;
	}

	public Long getContractId() {
		return contractId;
	}

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public Long getLotId() {
		return lotId;
	}

	public void setLotId(Long lotId) {
		this.lotId = lotId;
	}

	public Long getBilledToFacilityId() {
		return billedToFacilityId;
	}

	public String getBilledToFacilityName() {
		return billedToFacilityName;
	}

	public String getBilledToFacilityAddress() {
		return billedToFacilityAddress;
	}

	public Long getShippedToFacilityId() {
		return shippedToFacilityId;
	}

	public String getShippedToFacilityName() {
		return shippedToFacilityName;
	}

	public String getShippedToFacilityAddress() {
		return shippedToFacilityAddress;
	}

	public Long getConsignerId() {
		return consignerId;
	}

	public void setConsignerId(Long consignerId) {
		this.consignerId = consignerId;
	}

	public String getProductName() {
		return productName;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getScheduleNumber() {
		return scheduleNumber;
	}

	public String getLotNumber() {
		return lotNumber;
	}

	public String getReceiptStatus() {
		return receiptStatus;
	}

	public void setDispatchId(Long dispatchId) {
		this.dispatchId = dispatchId;
	}

	public void setStnNumber(String stnNumber) {
		this.stnNumber = stnNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public void setExpectedDispatchDate(LocalDate expectedDispatchDate) {
		this.expectedDispatchDate = expectedDispatchDate;
	}

	public void setExpectedArrivalDate(LocalDate expectedArrivalDate) {
		this.expectedArrivalDate = expectedArrivalDate;
	}

	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}

	public void setTransporterPhone(String transporterPhone) {
		this.transporterPhone = transporterPhone;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public void setBilledToFacilityId(Long billedToFacilityId) {
		this.billedToFacilityId = billedToFacilityId;
	}

	public void setBilledToFacilityName(String billedToFacilityName) {
		this.billedToFacilityName = billedToFacilityName;
	}

	public void setBilledToFacilityAddress(String billedToFacilityAddress) {
		this.billedToFacilityAddress = billedToFacilityAddress;
	}

	public void setShippedToFacilityId(Long shippedToFacilityId) {
		this.shippedToFacilityId = shippedToFacilityId;
	}

	public void setShippedToFacilityName(String shippedToFacilityName) {
		this.shippedToFacilityName = shippedToFacilityName;
	}

	public void setShippedToFacilityAddress(String shippedToFacilityAddress) {
		this.shippedToFacilityAddress = shippedToFacilityAddress;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setScheduleNumber(String scheduleNumber) {
		this.scheduleNumber = scheduleNumber;
	}

	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}

	public void setReceiptStatus(String receiptStatus) {
		this.receiptStatus = receiptStatus;
	}

	public List<BatchDto> getBatchDetails() {
		return batchDetails;
	}

	public void setBatchDetails(List<BatchDto> batchDetails) {
		this.batchDetails = batchDetails;
	}

	public List<DispatchRemarkDto> getRemarks() {
		return remarks;
	}

	public void setRemarks(List<DispatchRemarkDto> remarks) {
		this.remarks = remarks;
	}

	public String getConsignmentStatus() {
		return consignmentStatus;
	}

	public void setConsignmentStatus(String consignmentStatus) {
		this.consignmentStatus = consignmentStatus;
	}

	public String getDispatchStatus() {
		return dispatchStatus;
	}

	public void setDispatchStatus(String dispatchStatus) {
		this.dispatchStatus = dispatchStatus;
	}

	public Long getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Long productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getRemark() {
		return remark;
	}

	public Long getUserId() {
		return userId;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getConsignorName() {
		return consignorName;
	}

	public String getConsignorAddress() {
		return consignorAddress;
	}

	public void setConsignorName(String consignorName) {
		this.consignorName = consignorName;
	}

	public void setConsignorAddress(String consignorAddress) {
		this.consignorAddress = consignorAddress;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public ConsigneeAddressDto getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(ConsigneeAddressDto consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public LocalDate getAllotmentDate() {
		return allotmentDate;
	}

	public void setAllotmentDate(LocalDate allotmentDate) {
		this.allotmentDate = allotmentDate;
	}

	public List<BatchDto> getActiveBatchDetails() {
		return activeBatchDetails;
	}

	public List<BatchDto> getInActiveBatchDetails() {
		return inActiveBatchDetails;
	}

	public void setActiveBatchDetails(List<BatchDto> activeBatchDetails) {
		this.activeBatchDetails = activeBatchDetails;
	}

	public void setInActiveBatchDetails(List<BatchDto> inActiveBatchDetails) {
		this.inActiveBatchDetails = inActiveBatchDetails;
	}

	public String getIndentNumber() {
		return indentNumber;
	}

	public void setIndentNumber(String indentNumber) {
		this.indentNumber = indentNumber;
	}

	public String getDispatchType() {
		return dispatchType;
	}

	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
	}

	public Long getGoodsRequestId() {
		return goodsRequestId;
	}

	public void setGoodsRequestId(Long goodsRequestId) {
		this.goodsRequestId = goodsRequestId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getContractProductId() {
		return contractProductId;
	}

	public void setContractProductId(Long contractProductId) {
		this.contractProductId = contractProductId;
	}

	@Override
	public String toString() {
		return "DispatchDetailedDto [dispatchId=" + dispatchId + ", stnNumber=" + stnNumber + ", indentNumber="
				+ indentNumber + ", noa=" + noa + ", invoiceNumber=" + invoiceNumber + ", invoiceDate=" + invoiceDate
				+ ", indentDate=" + indentDate + ", expectedDispatchDate=" + expectedDispatchDate
				+ ", expectedArrivalDate=" + expectedArrivalDate + ", transporterAwbNumber=" + transporterAwbNumber
				+ ", transporterName=" + transporterName + ", transporterPhone=" + transporterPhone + ", driverName="
				+ driverName + ", billedToFacilityId=" + billedToFacilityId + ", billedToFacilityName="
				+ billedToFacilityName + ", billedToFacilityAddress=" + billedToFacilityAddress
				+ ", shippedToFacilityId=" + shippedToFacilityId + ", shippedToFacilityName=" + shippedToFacilityName
				+ ", shippedToFacilityAddress=" + shippedToFacilityAddress + ", consignerId=" + consignerId
				+ ", consignorName=" + consignorName + ", consignorAddress=" + consignorAddress + ", consigneeName="
				+ consigneeName + ", consigneeAddress=" + consigneeAddress + ", allotmentDate=" + allotmentDate
				+ ", productId=" + productId + ", productName=" + productName + ", contractId=" + contractId
				+ ", scheduleId=" + scheduleId + ", scheduleNumber=" + scheduleNumber + ", lotId=" + lotId
				+ ", lotNumber=" + lotNumber + ", consignmentStatus=" + consignmentStatus + ", receiptStatus="
				+ receiptStatus + ", dispatchStatus=" + dispatchStatus + ", remark=" + remark + ", userId=" + userId
				+ ", receiptDate=" + receiptDate + ", productQuantity=" + productQuantity + ", batchDetails="
				+ batchDetails + ", remarks=" + remarks + ", activeBatchDetails=" + activeBatchDetails
				+ ", inActiveBatchDetails=" + inActiveBatchDetails + ", dispatchType=" + dispatchType
				+ ", goodsRequestId=" + goodsRequestId + "]";
	}

}
