package gov.naco.soch.dto;

import java.util.List;

public class FacilityProductBatchDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long productId;
	private String productName;
	private Long dispatchedQuantity;
	private Long receivedQuantity;
	private List<BatchDto> batches;

	public Long getDispatchedQuantity() {
		return dispatchedQuantity;
	}

	public Long getReceivedQuantity() {
		return receivedQuantity;
	}

	public void setDispatchedQuantity(Long dispatchedQuantity) {
		this.dispatchedQuantity = dispatchedQuantity;
	}

	public void setReceivedQuantity(Long receivedQuantity) {
		this.receivedQuantity = receivedQuantity;
	}

	public Long getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public List<BatchDto> getBatches() {
		return batches;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setBatches(List<BatchDto> batches) {
		this.batches = batches;
	}

}
