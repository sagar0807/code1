package gov.naco.soch.dto;

import java.time.LocalDate;

public class ConsignmentBatchDto {

	private String batchNumber;
	private LocalDate manufactureDate;
	private LocalDate expiryDate;
	private Long productId;
	private Long receiptBatchId;
	private Long receivedQuantity;
	private Long damagedQty;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getReceiptBatchId() {
		return receiptBatchId;
	}

	public void setReceiptBatchId(Long receiptBatchId) {
		this.receiptBatchId = receiptBatchId;
	}

	public Long getReceivedQuantity() {
		return receivedQuantity;
	}

	public void setReceivedQuantity(Long receivedQuantity) {
		this.receivedQuantity = receivedQuantity;
	}

	public Long getDamagedQty() {
		return damagedQty;
	}

	public void setDamagedQty(Long damagedQty) {
		this.damagedQty = damagedQty;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

}
