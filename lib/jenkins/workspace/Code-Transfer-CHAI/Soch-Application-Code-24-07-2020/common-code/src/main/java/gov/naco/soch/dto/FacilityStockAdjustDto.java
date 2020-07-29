package gov.naco.soch.dto;

import java.time.LocalDate;

public class FacilityStockAdjustDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long facilityId;
	private Long productId;
	private String batchNumber;
	private LocalDate manufactureDate;
	private LocalDate expiryDate;
	private Long type;
	private Long reasonCode;
	private Long adjustedQuantity;
	private Long currentQuantity;
	private String remarks;

	private LocalDate dateOfAdditionOrConsumption;
	private Long bulkDispenseQuantity;
	private Long wastageQuantity;
	private Long testingQuantity;
	private Long qaQuantity;
	private Long controlQuantity;
	private Long beneficiaryQuantity;
	private Long otherQuantity;
	private Long totalQuantity;

	public Long getFacilityId() {
		return facilityId;
	}

	public Long getProductId() {
		return productId;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public Long getType() {
		return type;
	}

	public Long getReasonCode() {
		return reasonCode;
	}

	public Long getAdjustedQuantity() {
		return adjustedQuantity;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public void setReasonCode(Long reasonCode) {
		this.reasonCode = reasonCode;
	}

	public void setAdjustedQuantity(Long adjustedQuantity) {
		this.adjustedQuantity = adjustedQuantity;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Long getCurrentQuantity() {
		return currentQuantity;
	}

	public void setCurrentQuantity(Long currentQuantity) {
		this.currentQuantity = currentQuantity;
	}

	public LocalDate getDateOfAdditionOrConsumption() {
		return dateOfAdditionOrConsumption;
	}

	public void setDateOfAdditionOrConsumption(LocalDate dateOfAdditionOrConsumption) {
		this.dateOfAdditionOrConsumption = dateOfAdditionOrConsumption;
	}

	public Long getBulkDispenseQuantity() {
		return bulkDispenseQuantity;
	}

	public void setBulkDispenseQuantity(Long bulkDispenseQuantity) {
		this.bulkDispenseQuantity = bulkDispenseQuantity;
	}

	public Long getWastageQuantity() {
		return wastageQuantity;
	}

	public void setWastageQuantity(Long wastageQuantity) {
		this.wastageQuantity = wastageQuantity;
	}

	public Long getTestingQuantity() {
		return testingQuantity;
	}

	public void setTestingQuantity(Long testingQuantity) {
		this.testingQuantity = testingQuantity;
	}

	public Long getQaQuantity() {
		return qaQuantity;
	}

	public void setQaQuantity(Long qaQuantity) {
		this.qaQuantity = qaQuantity;
	}

	public Long getControlQuantity() {
		return controlQuantity;
	}

	public void setControlQuantity(Long controlQuantity) {
		this.controlQuantity = controlQuantity;
	}

	public Long getBeneficiaryQuantity() {
		return beneficiaryQuantity;
	}

	public void setBeneficiaryQuantity(Long beneficiaryQuantity) {
		this.beneficiaryQuantity = beneficiaryQuantity;
	}

	public Long getOtherQuantity() {
		return otherQuantity;
	}

	public void setOtherQuantity(Long otherQuantity) {
		this.otherQuantity = otherQuantity;
	}

	public Long getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

}
