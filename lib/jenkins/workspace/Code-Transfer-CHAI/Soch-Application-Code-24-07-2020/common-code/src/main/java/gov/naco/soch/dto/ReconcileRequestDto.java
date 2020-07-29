package gov.naco.soch.dto;

import java.util.List;

public class ReconcileRequestDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private Long stockTransferId;
	private Long productId;
	private List<String> batchNumbers;
	private String remarks;

	public Long getStockTransferId() {
		return stockTransferId;
	}

	public void setStockTransferId(Long stockTransferId) {
		this.stockTransferId = stockTransferId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public List<String> getBatchNumbers() {
		return batchNumbers;
	}

	public void setBatchNumbers(List<String> batchNumbers) {
		this.batchNumbers = batchNumbers;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
