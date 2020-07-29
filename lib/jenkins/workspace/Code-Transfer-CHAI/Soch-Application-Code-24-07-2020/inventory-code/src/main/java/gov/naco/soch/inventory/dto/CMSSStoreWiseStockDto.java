package gov.naco.soch.inventory.dto;

import java.time.LocalDate;
import java.util.List;

public class CMSSStoreWiseStockDto {

	private String storeId;
	private String storeName;
	private String drugName;
	private String brandId;
	private Long noOfBatch;
	private List<CMSSStockDto> batchList;
	private Long noOfPO;
	private List<CMSSStockDto> poList;
	private Long qtyActive;
	private Long qtyQuar;
	private Long qtyRej;
	private LocalDate manufDate;
	private List<CMSSStockDto> manufList;
	private LocalDate expiryDate;
	private List<CMSSStockDto> expiryList;
	private Long expiryQty;

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

	public Long getNoOfBatch() {
		return noOfBatch;
	}

	public void setNoOfBatch(Long noOfBatch) {
		this.noOfBatch = noOfBatch;
	}

	public List<CMSSStockDto> getBatchList() {
		return batchList;
	}

	public void setBatchList(List<CMSSStockDto> batchList) {
		this.batchList = batchList;
	}

	public Long getNoOfPO() {
		return noOfPO;
	}

	public void setNoOfPO(Long noOfPO) {
		this.noOfPO = noOfPO;
	}

	public List<CMSSStockDto> getPoList() {
		return poList;
	}

	public void setPoList(List<CMSSStockDto> poList) {
		this.poList = poList;
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

	public List<CMSSStockDto> getManufList() {
		return manufList;
	}

	public void setManufList(List<CMSSStockDto> manufList) {
		this.manufList = manufList;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public List<CMSSStockDto> getExpiryList() {
		return expiryList;
	}

	public void setExpiryList(List<CMSSStockDto> expiryList) {
		this.expiryList = expiryList;
	}

	public Long getExpiryQty() {
		return expiryQty;
	}

	public void setExpiryQty(Long expiryQty) {
		this.expiryQty = expiryQty;
	}

}
