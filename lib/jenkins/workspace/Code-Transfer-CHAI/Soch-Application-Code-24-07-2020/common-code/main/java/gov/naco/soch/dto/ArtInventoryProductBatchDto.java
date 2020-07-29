package gov.naco.soch.dto;

import java.time.LocalDate;

public class ArtInventoryProductBatchDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private String batchNumber;
	private LocalDate manufactureDate;
	private LocalDate expiryDate;
	private Long dispatchedQuantity;
	private Long currentQuantity;
	private Long facilityStockTransferDetailId;
	private Long quantityReceived;
	private Long damaged;

	public String getBatchNumber() {
		return batchNumber;
	}

	public Long getDispatchedQuantity() {
		return dispatchedQuantity;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
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

	public Long getCurrentQuantity() {
		return currentQuantity;
	}

	public void setCurrentQuantity(Long currentQuantity) {
		this.currentQuantity = currentQuantity;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public void setDispatchedQuantity(Long dispatchedQuantity) {
		this.dispatchedQuantity = dispatchedQuantity;
	}

	public Long getFacilityStockTransferDetailId() {
		return facilityStockTransferDetailId;
	}

	public void setFacilityStockTransferDetailId(Long facilityStockTransferDetailId) {
		this.facilityStockTransferDetailId = facilityStockTransferDetailId;
	}

	public Long getQuantityReceived() {
		return quantityReceived;
	}

	public void setQuantityReceived(Long quantityReceived) {
		this.quantityReceived = quantityReceived;
	}

	public Long getDamaged() {
		return damaged;
	}

	public void setDamaged(Long damaged) {
		this.damaged = damaged;
	}

	@Override
	public String toString() {
		return "ArtInventoryProductBatchDto [batchNumber=" + batchNumber + ", manufactureDate=" + manufactureDate
				+ ", expiryDate=" + expiryDate + ", dispatchedQuantity=" + dispatchedQuantity + ", currentQuantity="
				+ currentQuantity + ", facilityStockTransferDetailId=" + facilityStockTransferDetailId
				+ ", quantityReceived=" + quantityReceived + ", damaged=" + damaged + "]";
	}

}
