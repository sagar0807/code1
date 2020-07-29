package gov.naco.soch.inventory.dto;

import java.time.LocalDate;

public class CMSSStockDto {

	private String storeId;
	private String storeName;
	private String drugName;
	private String brandId;
	private String batchNo;
	private String poNo;
	private Long qtyActive;
	private Long qtyQuar;
	private Long qtyRej;
	private LocalDate manufDate;
	private LocalDate expiryDate;

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public Long getQtyActive() {
		return qtyActive;
	}

	public void setQtyActive(Long qtyActive) {
		this.qtyActive = qtyActive;
	}

	public Long getQtyQuar() {
		return qtyQuar;
	}

	public void setQtyQuar(Long qtyQuar) {
		this.qtyQuar = qtyQuar;
	}

	public Long getQtyRej() {
		return qtyRej;
	}

	public void setQtyRej(Long qtyRej) {
		this.qtyRej = qtyRej;
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

}
