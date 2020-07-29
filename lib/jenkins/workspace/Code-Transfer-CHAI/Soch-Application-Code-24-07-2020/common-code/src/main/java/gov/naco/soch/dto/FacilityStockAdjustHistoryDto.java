package gov.naco.soch.dto;

import java.time.LocalDate;

public class FacilityStockAdjustHistoryDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private String batchNumber;
	private LocalDate adjustedDate;
	private Long previousStock;
	private Long adjustedQuantity;
	private Long newStock;
	private String type;
	private String reason;
	private String remark;
	private Long testing;
	private Long qa;
	private Long control;
	private Long wastage;
	private Long forBeneficiary;
	private Long otherQuantity;
	private Long watageQuantity;
	private Long bulkDispensed;

	public String getBatchNumber() {
		return batchNumber;
	}

	public LocalDate getAdjustedDate() {
		return adjustedDate;
	}

	public Long getPreviousStock() {
		return previousStock;
	}

	public Long getAdjustedQuantity() {
		return adjustedQuantity;
	}

	public Long getNewStock() {
		return newStock;
	}

	public String getType() {
		return type;
	}

	public String getReason() {
		return reason;
	}

	public String getRemark() {
		return remark;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public void setAdjustedDate(LocalDate adjustedDate) {
		this.adjustedDate = adjustedDate;
	}

	public void setPreviousStock(Long previousStock) {
		this.previousStock = previousStock;
	}

	public void setAdjustedQuantity(Long adjustedQuantity) {
		this.adjustedQuantity = adjustedQuantity;
	}

	public void setNewStock(Long newStock) {
		this.newStock = newStock;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getTesting() {
		return testing;
	}

	public void setTesting(Long testing) {
		this.testing = testing;
	}

	public Long getQa() {
		return qa;
	}

	public void setQa(Long qa) {
		this.qa = qa;
	}

	public Long getControl() {
		return control;
	}

	public void setControl(Long control) {
		this.control = control;
	}

	public Long getWastage() {
		return wastage;
	}

	public void setWastage(Long wastage) {
		this.wastage = wastage;
	}

	public Long getForBeneficiary() {
		return forBeneficiary;
	}

	public void setForBeneficiary(Long forBeneficiary) {
		this.forBeneficiary = forBeneficiary;
	}

	public Long getOtherQuantity() {
		return otherQuantity;
	}

	public void setOtherQuantity(Long otherQuantity) {
		this.otherQuantity = otherQuantity;
	}

	public Long getWatageQuantity() {
		return watageQuantity;
	}

	public void setWatageQuantity(Long watageQuantity) {
		this.watageQuantity = watageQuantity;
	}

	public Long getBulkDispensed() {
		return bulkDispensed;
	}

	public void setBulkDispensed(Long bulkDispensed) {
		this.bulkDispensed = bulkDispensed;
	}

	@Override
	public String toString() {
		return "FacilityStockAdjustHistoryDto [batchNumber=" + batchNumber + ", adjustedDate=" + adjustedDate
				+ ", previousStock=" + previousStock + ", adjustedQuantity=" + adjustedQuantity + ", newStock="
				+ newStock + ", type=" + type + ", reason=" + reason + ", remark=" + remark + "]";
	}

}
