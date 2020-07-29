package gov.naco.soch.dto;

import java.time.LocalDate;

public class OstDispenseBatchDto {

	private String batchNumber;
	private Double availableQuantity;
	private Double dispensedQuantity;
	private Integer facilityStockId;
	private Long productId;
	private Double dosage;
	private LocalDate manufactureDate;
	private LocalDate expiryDate;

	public String getBatchNumber() {
		return batchNumber;
	}

	public Double getAvailableQuantity() {
		return availableQuantity;
	}

	public Double getDispensedQuantity() {
		return dispensedQuantity;
	}

	public Integer getFacilityStockId() {
		return facilityStockId;
	}

	public Double getDosage() {
		return dosage;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public void setAvailableQuantity(Double availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public void setDispensedQuantity(Double dispensedQuantity) {
		this.dispensedQuantity = dispensedQuantity;
	}

	public void setFacilityStockId(Integer facilityStockId) {
		this.facilityStockId = facilityStockId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public void setDosage(Double dosage) {
		this.dosage = dosage;
	}

}
