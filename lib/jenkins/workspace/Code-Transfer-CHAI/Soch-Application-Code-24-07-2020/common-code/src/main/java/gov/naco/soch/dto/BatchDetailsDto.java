package gov.naco.soch.dto;

public class BatchDetailsDto extends BaseDto {
	private static final long serialVersionUID = 1L;

	private Long batchDetailId;
	private String batchNumber;
	private String manufactureDate;
	private String expiryDate;
	private Double quantity;
	private Long numberOfBox;
	private Long productTypeId;
	private String productType;
	private Long uomId;
	private String uom;
	private Long facilityStockId;
	private Double damagedQuantity;
	private Double goodQuantity;

	public Long getBatchDetailId() {
		return batchDetailId;
	}

	public void setBatchDetailId(Long batchDetailId) {
		this.batchDetailId = batchDetailId;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Long getNumberOfBox() {
		return numberOfBox;
	}

	public void setNumberOfBox(Long numberOfBox) {
		this.numberOfBox = numberOfBox;
	}

	public Long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Long getUomId() {
		return uomId;
	}

	public void setUomId(Long uomId) {
		this.uomId = uomId;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public Long getFacilityStockId() {
		return facilityStockId;
	}

	public void setFacilityStockId(Long facilityStockId) {
		this.facilityStockId = facilityStockId;
	}

	public Double getDamagedQuantity() {
		return damagedQuantity;
	}

	public void setDamagedQuantity(Double damagedQuantity) {
		this.damagedQuantity = damagedQuantity;
	}

	public Double getGoodQuantity() {
		return goodQuantity;
	}

	public void setGoodQuantity(Double goodQuantity) {
		this.goodQuantity = goodQuantity;
	}

	@Override
	public String toString() {
		return "BatchDetailsDto [batchDetailId=" + batchDetailId + ", batchNumber=" + batchNumber + ", manufactureDate="
				+ manufactureDate + ", expiryDate=" + expiryDate + ", quantity=" + quantity + ", numberOfBox="
				+ numberOfBox + ", productTypeId=" + productTypeId + ", productType=" + productType + ", uomId=" + uomId
				+ ", uom=" + uom + "]";
	}

}
