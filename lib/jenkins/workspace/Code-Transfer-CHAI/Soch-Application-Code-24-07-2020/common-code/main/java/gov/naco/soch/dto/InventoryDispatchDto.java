package gov.naco.soch.dto;

import java.time.LocalDate;

public class InventoryDispatchDto extends BaseDto{

	private static final long serialVersionUID = 1L;
	private Long productId;
	private Long currentQuantity;
	private Long dispatchQuantity;
	private Long numberOfBoxes;
	private String batchNumber;
	private LocalDate mfgDate;
	private LocalDate expiryDate;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getDispatchQuantity() {
		return dispatchQuantity;
	}
	public void setDispatchQuantity(Long dispatchQuantity) {
		this.dispatchQuantity = dispatchQuantity;
	}
	public Long getNumberOfBoxes() {
		return numberOfBoxes;
	}
	public void setNumberOfBoxes(Long numberOfBoxes) {
		this.numberOfBoxes = numberOfBoxes;
	}
	public Long getCurrentQuantity() {
		return currentQuantity;
	}
	public void setCurrentQuantity(Long currentQuantity) {
		this.currentQuantity = currentQuantity;
	}
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	public LocalDate getMfgDate() {
		return mfgDate;
	}
	public void setMfgDate(LocalDate mfgDate) {
		this.mfgDate = mfgDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "InventoryDispatchDto [productId=" + productId + ", dispatchQuantity=" + dispatchQuantity
				+ ", numberOfBoxes=" + numberOfBoxes + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryDispatchDto other = (InventoryDispatchDto) obj;
		if (dispatchQuantity == null) {
			if (other.dispatchQuantity != null)
				return false;
		} else if (!dispatchQuantity.equals(other.dispatchQuantity))
			return false;
		if (numberOfBoxes == null) {
			if (other.numberOfBoxes != null)
				return false;
		} else if (!numberOfBoxes.equals(other.numberOfBoxes))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}
	
	

}
