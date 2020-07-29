package gov.naco.soch.dto;

import java.time.LocalDate;

public class BatchDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long supplierStockId;
	private Long dispatchBatchId;
	private String batchNumber;
	private LocalDate manufactureDate;
	private LocalDate expiryDate;
	private Long quantity;
	private Long productId;
	private String productName;
	private Long supplierId;
	private Long receiptBatchId;
	private Long damagedQuantity;
	private Long receivedQuantity;
	private Long grn2Quantity;
	private Long numberOfBoxes;
	private Long dispatchQuantity;
	private String remainingSelfLife;
	private Long git;
	private Long returnQuantity;
	private Long facilityReceiptBatchId;
	private LocalDate ReconciliationDate;
	private String receiptBatchStatus;
	private Boolean isExpired;

	public String getBatchNumber() {
		return batchNumber;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getSupplierStockId() {
		return supplierStockId;
	}

	public void setSupplierStockId(Long supplierStockId) {
		this.supplierStockId = supplierStockId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Long getDamagedQuantity() {
		return damagedQuantity;
	}

	public Long getReceivedQuantity() {
		return receivedQuantity;
	}

	public void setDamagedQuantity(Long damagedQuantity) {
		this.damagedQuantity = damagedQuantity;
	}

	public void setReceivedQuantity(Long receivedQuantity) {
		this.receivedQuantity = receivedQuantity;
	}

	public Long getDispatchBatchId() {
		return dispatchBatchId;
	}

	public void setDispatchBatchId(Long dispatchBatchId) {
		this.dispatchBatchId = dispatchBatchId;
	}

	public Long getReceiptBatchId() {
		return receiptBatchId;
	}

	public void setReceiptBatchId(Long receiptBatchId) {
		this.receiptBatchId = receiptBatchId;
	}

	public Long getNumberOfBoxes() {
		return numberOfBoxes;
	}

	public void setNumberOfBoxes(Long numberOfBoxes) {
		this.numberOfBoxes = numberOfBoxes;
	}

	public String getRemainingSelfLife() {
		return remainingSelfLife;
	}

	public void setRemainingSelfLife(String remainingSelfLife) {
		this.remainingSelfLife = remainingSelfLife;
	}

	public Long getGit() {
		return git;
	}

	public void setGit(Long git) {
		this.git = git;
	}

	public LocalDate getReconciliationDate() {
		return ReconciliationDate;
	}

	public String getReceiptBatchStatus() {
		return receiptBatchStatus;
	}

	public void setReconciliationDate(LocalDate reconciliationDate) {
		ReconciliationDate = reconciliationDate;
	}

	public void setReceiptBatchStatus(String receiptBatchStatus) {
		this.receiptBatchStatus = receiptBatchStatus;
	}

	public Long getFacilityReceiptBatchId() {
		return facilityReceiptBatchId;
	}

	public void setFacilityReceiptBatchId(Long facilityReceiptBatchId) {
		this.facilityReceiptBatchId = facilityReceiptBatchId;
	}

	public Long getDispatchQuantity() {
		return dispatchQuantity;
	}

	public void setDispatchQuantity(Long dispatchQuantity) {
		this.dispatchQuantity = dispatchQuantity;
	}

	public Long getGrn2Quantity() {
		return grn2Quantity;
	}

	public void setGrn2Quantity(Long grn2Quantity) {
		this.grn2Quantity = grn2Quantity;
	}

	public Long getReturnQuantity() {
		return returnQuantity;
	}

	public void setReturnQuantity(Long returnQuantity) {
		this.returnQuantity = returnQuantity;
	}

	public Boolean getIsExpired() {
		return isExpired;
	}

	public void setIsExpired(Boolean isExpired) {
		this.isExpired = isExpired;
	}

}
