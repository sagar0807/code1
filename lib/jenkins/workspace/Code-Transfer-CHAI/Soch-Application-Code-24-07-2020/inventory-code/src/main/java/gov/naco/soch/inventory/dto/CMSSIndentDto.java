package gov.naco.soch.inventory.dto;

import java.time.LocalDate;

public class CMSSIndentDto {

	private String indentNbr;
	private Long indentStoreId;
	private String indentStore;
	private String issuingStore;
	private LocalDate indentDate;
	private String productName;
	private Long indentQty;

	public String getIndentNbr() {
		return indentNbr;
	}

	public void setIndentNbr(String indentNbr) {
		this.indentNbr = indentNbr;
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

	public String getIssuingStore() {
		return issuingStore;
	}

	public void setIssuingStore(String issuingStore) {
		this.issuingStore = issuingStore;
	}

	public LocalDate getIndentDate() {
		return indentDate;
	}

	public void setIndentDate(LocalDate indentDate) {
		this.indentDate = indentDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getIndentQty() {
		return indentQty;
	}

	public void setIndentQty(Long indentQty) {
		this.indentQty = indentQty;
	}

}
