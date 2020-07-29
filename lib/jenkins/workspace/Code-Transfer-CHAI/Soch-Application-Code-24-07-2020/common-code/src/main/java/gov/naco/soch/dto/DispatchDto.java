package gov.naco.soch.dto;

import java.time.LocalDate;

public class DispatchDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long dispatchId;
	private String stnNumber;
	private String invoiceNumber;
	private LocalDate invoiceDate;
	private String product;
	private String lotNumber;
	private String consignmentStatus;
	private String receiptStatus;
	private String dispatchStatus;
	private String noaNumber;
	private Long quantity;
	private String consignee;
	

	
	public Long getDispatchId() {
		return dispatchId;
	}

	public void setDispatchId(Long dispatchId) {
		this.dispatchId = dispatchId;
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

	public String getLotNumber() {
		return lotNumber;
	}

	public String getConsignmentStatus() {
		return consignmentStatus;
	}

	public String getReceiptStatus() {
		return receiptStatus;
	}

	public String getDispatchStatus() {
		return dispatchStatus;
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

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}

	public void setConsignmentStatus(String consignmentStatus) {
		this.consignmentStatus = consignmentStatus;
	}

	public void setReceiptStatus(String receiptStatus) {
		this.receiptStatus = receiptStatus;
	}

	public void setDispatchStatus(String dispatchStatus) {
		this.dispatchStatus = dispatchStatus;
	}

	public String getNoaNumber() {
		return noaNumber;
	}

	public Long getQuantity() {
		return quantity;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setNoaNumber(String noaNumber) {
		this.noaNumber = noaNumber;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

}
