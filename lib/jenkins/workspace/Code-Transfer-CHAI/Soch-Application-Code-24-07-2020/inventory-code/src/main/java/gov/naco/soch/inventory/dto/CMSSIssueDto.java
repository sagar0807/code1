package gov.naco.soch.inventory.dto;

import java.time.LocalDate;

public class CMSSIssueDto {

	private Long roId;
	private String issuingStore;
	private Long indentStoreId;
	private String indentStore;
	private String indentNbr;
	private String issueNbr;
	private String productName;
	private String batchNo;
	private LocalDate indentDate;
	private Long issueQty;
	private LocalDate issueDate;
	private LocalDate manufDate;
	private LocalDate expiryDate;
	private Long receivedQty;
	private Long damagedQty;
	private Long receiptStatusId;
	private String receiptStatus;
	private String remarks;

	public Long getRoId() {
		return roId;
	}

	public void setRoId(Long roId) {
		this.roId = roId;
	}

	public String getIssuingStore() {
		return issuingStore;
	}

	public void setIssuingStore(String issuingStore) {
		this.issuingStore = issuingStore;
	}

	public Long getIndentStoreId() {
		return indentStoreId;
	}

	public void setIndentStoreId(Long indentStoreId) {
		this.indentStoreId = indentStoreId;
	}

	public String getIndentStore() {
		return indentStore;
	}

	public void setIndentStore(String indentStore) {
		this.indentStore = indentStore;
	}

	public String getIndentNbr() {
		return indentNbr;
	}

	public void setIndentNbr(String indentNbr) {
		this.indentNbr = indentNbr;
	}

	public String getIssueNbr() {
		return issueNbr;
	}

	public void setIssueNbr(String issueNbr) {
		this.issueNbr = issueNbr;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public LocalDate getIndentDate() {
		return indentDate;
	}

	public void setIndentDate(LocalDate indentDate) {
		this.indentDate = indentDate;
	}

	public Long getIssueQty() {
		return issueQty;
	}

	public void setIssueQty(Long issueQty) {
		this.issueQty = issueQty;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getManufDate() {
		return manufDate;
	}

	public void setManufDate(LocalDate manufDate) {
		this.manufDate = manufDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Long getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(Long receivedQty) {
		this.receivedQty = receivedQty;
	}

	public Long getDamagedQty() {
		return damagedQty;
	}

	public void setDamagedQty(Long damagedQty) {
		this.damagedQty = damagedQty;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
