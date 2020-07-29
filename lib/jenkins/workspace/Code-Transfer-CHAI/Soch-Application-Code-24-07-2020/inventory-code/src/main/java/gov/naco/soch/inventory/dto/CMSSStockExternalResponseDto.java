package gov.naco.soch.inventory.dto;

public class CMSSStockExternalResponseDto {

	private String store_ID;
	private String store_NAME;
	private String drug_NAME;
	private String brand_ID;
	private String batch_NO;
	private String po_NO;
	private String qty_ACTIVE;
	private String qty_QUAR;
	private String qty_REJ;
	private String manuf_DATE;
	private String expiry_DATE;

	public String getStore_ID() {
		return store_ID;
	}

	public void setStore_ID(String store_ID) {
		this.store_ID = store_ID;
	}

	public String getStore_NAME() {
		return store_NAME;
	}

	public void setStore_NAME(String store_NAME) {
		this.store_NAME = store_NAME;
	}

	public String getDrug_NAME() {
		return drug_NAME;
	}

	public void setDrug_NAME(String drug_NAME) {
		this.drug_NAME = drug_NAME;
	}

	public String getBrand_ID() {
		return brand_ID;
	}

	public void setBrand_ID(String brand_ID) {
		this.brand_ID = brand_ID;
	}

	public String getBatch_NO() {
		return batch_NO;
	}

	public void setBatch_NO(String batch_NO) {
		this.batch_NO = batch_NO;
	}

	public String getPo_NO() {
		return po_NO;
	}

	public void setPo_NO(String po_NO) {
		this.po_NO = po_NO;
	}

	public String getQty_ACTIVE() {
		return qty_ACTIVE;
	}

	public void setQty_ACTIVE(String qty_ACTIVE) {
		this.qty_ACTIVE = qty_ACTIVE;
	}

	public String getQty_QUAR() {
		return qty_QUAR;
	}

	public void setQty_QUAR(String qty_QUAR) {
		this.qty_QUAR = qty_QUAR;
	}

	public String getQty_REJ() {
		return qty_REJ;
	}

	public void setQty_REJ(String qty_REJ) {
		this.qty_REJ = qty_REJ;
	}

	public String getManuf_DATE() {
		return manuf_DATE;
	}

	public void setManuf_DATE(String manuf_DATE) {
		this.manuf_DATE = manuf_DATE;
	}

	public String getExpiry_DATE() {
		return expiry_DATE;
	}

	public void setExpiry_DATE(String expiry_DATE) {
		this.expiry_DATE = expiry_DATE;
	}

}
