package gov.naco.soch.dto;

import java.util.List;

public class ReceiptDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long dispatchId;
	private Boolean isProductMatch;
	private Boolean isBatchMatch;
	private String remark;
	private Long userId;
	private Long facilityId;
	private Long productId;
	private Integer productQuantity;
	private List<BatchDto> batches;

	public String getRemark() {
		return remark;
	}

	public List<BatchDto> getBatches() {
		return batches;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getDispatchId() {
		return dispatchId;
	}

	public void setDispatchId(Long dispatchId) {
		this.dispatchId = dispatchId;
	}

	public void setBatches(List<BatchDto> batches) {
		this.batches = batches;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Boolean getIsProductMatch() {
		return isProductMatch;
	}

	public Boolean getIsBatchMatch() {
		return isBatchMatch;
	}

	public void setIsProductMatch(Boolean isProductMatch) {
		this.isProductMatch = isProductMatch;
	}

	public void setIsBatchMatch(Boolean isBatchMatch) {
		this.isBatchMatch = isBatchMatch;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

}
