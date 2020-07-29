package gov.naco.soch.dto;

import java.util.List;

public class DescriptionOfProductsDto extends BaseDto  {

	private static final long serialVersionUID = 1L;
	
	private Long productId;
	private String productName;
	private Long totalQuantity;
	private Long totalBox;
	private List<BatchDetailsDto> batchDetails;
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
	public List<BatchDetailsDto> getBatchDetails() {
		return batchDetails;
	}
	
	public Long getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(Long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public void setBatchDetails(List<BatchDetailsDto> batchDetails) {
		this.batchDetails = batchDetails;
	}
	
	public Long getTotalBox() {
		return totalBox;
	}
	public void setTotalBox(Long totalBox) {
		this.totalBox = totalBox;
	}
	@Override
	public String toString() {
		return "DescriptionOfProductsDto [productId=" + productId + ", productName=" + productName + ", totalQuantity="
				+ totalQuantity + ", totalBox=" + totalBox + ", batchDetails=" + batchDetails + "]";
	}
	
	
}
