package gov.naco.soch.cst.dto;

import java.time.LocalDate;

import gov.naco.soch.dto.BaseDto;

public class LastDispensationProductDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long artDispensationItemId;
	private Long productId;
	private String productName;
	private String batchNumber;
	private Integer remainingPills;
	private Integer adherance;
	private Long dispensedQuantity;
	private Long facilityStockId;
	private LocalDate manufactureDate;
	private LocalDate expiryDate;
	private Long availabaleQuantity;
	private Float productDosage;
	private Long returnQuantity;

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

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public Integer getRemainingPills() {
		return remainingPills;
	}

	public void setRemainingPills(Integer remainingPills) {
		this.remainingPills = remainingPills;
	}

	public Integer getAdherance() {
		return adherance;
	}

	public void setAdherance(Integer adherance) {
		this.adherance = adherance;
	}

	public Long getDispensedQuantity() {
		return dispensedQuantity;
	}

	public void setDispensedQuantity(Long dispensedQuantity) {
		this.dispensedQuantity = dispensedQuantity;
	}

	public Long getFacilityStockId() {
		return facilityStockId;
	}

	public void setFacilityStockId(Long facilityStockId) {
		this.facilityStockId = facilityStockId;
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

	public Long getAvailabaleQuantity() {
		return availabaleQuantity;
	}

	public Float getProductDosage() {
		return productDosage;
	}

	public void setProductDosage(Float productDosage) {
		this.productDosage = productDosage;
	}

	public Long getArtDispensationItemId() {
		return artDispensationItemId;
	}

	public void setArtDispensationItemId(Long artDispensationItemId) {
		this.artDispensationItemId = artDispensationItemId;
	}

	public Long getReturnQuantity() {
		return returnQuantity;
	}

	public void setReturnQuantity(Long returnQuantity) {
		this.returnQuantity = returnQuantity;
	}

	public void setAvailabaleQuantity(Long availabaleQuantity) {
		this.availabaleQuantity = availabaleQuantity;
	}

}
