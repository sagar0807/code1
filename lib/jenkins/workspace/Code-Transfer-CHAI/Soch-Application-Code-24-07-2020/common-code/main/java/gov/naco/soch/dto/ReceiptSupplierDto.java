package gov.naco.soch.dto;
/**
 * SupplierReceiptDto : Dto class for supplier receipt
 * @author Rishad Basheer
 *
 */

import java.time.LocalDateTime;
import java.util.List;

public class ReceiptSupplierDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private Long dispatchId;
	private Long receiptId;
	private String stnNo;
	private String invoiceNo;
	private List<String> products;
	private String receiptStatus;
	private String grn1;
	private String grn2;
	private LocalDateTime lastActionDate;

	public Long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(Long receiptId) {
		this.receiptId = receiptId;
	}

	public String getStnNo() {
		return stnNo;
	}

	public void setStnNo(String stnNo) {
		this.stnNo = stnNo;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public List<String> getProducts() {
		return products;
	}

	public void setProducts(List<String> products) {
		this.products = products;
	}

	public String getReceiptStatus() {
		return receiptStatus;
	}

	public void setReceiptStatus(String receiptStatus) {
		this.receiptStatus = receiptStatus;
	}

	public String getGrn1() {
		return grn1;
	}

	public void setGrn1(String grn1) {
		this.grn1 = grn1;
	}

	public LocalDateTime getLastActionDate() {
		return lastActionDate;
	}

	public void setLastActionDate(LocalDateTime lastActionDate) {
		this.lastActionDate = lastActionDate;
	}

	public Long getDispatchId() {
		return dispatchId;
	}

	public void setDispatchId(Long dispatchId) {
		this.dispatchId = dispatchId;
	}

	public String getGrn2() {
		return grn2;
	}

	public void setGrn2(String grn2) {
		this.grn2 = grn2;
	}

	@Override
	public String toString() {
		return "SupplierReceiptDto [stnNo=" + stnNo + ", invoiceNo=" + invoiceNo + ", products=" + products
				+ ", receiptStatus=" + receiptStatus + ", grn1 =" + grn1 + ", lastActionDate= " + lastActionDate + "]";
	}
}
