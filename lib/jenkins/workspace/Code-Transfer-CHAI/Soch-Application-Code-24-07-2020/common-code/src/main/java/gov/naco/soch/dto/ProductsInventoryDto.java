package gov.naco.soch.dto;

import java.util.List;

public class ProductsInventoryDto extends BaseDto  {

	private static final long serialVersionUID = 1L;
	
	
	private Long facilityAggregateStockId;
	private Double availableQuantity;
	private Double expiredQuantity;
	private Double damagedQuantity;
	private Double git;
	
	private Long facilityId;
	private String facilityCode;
	private String facilityName;
	
	private Long productId;
	private String batchNumber;
	private byte[] productImage;
	private String productName;
	private String productCode;
	private Float productDosage;
	
	private String status;
	private List<BatchDetailsDto> activeBatchDetails;
	private List<BatchDetailsDto> expiredBatchDetails;
	
	public Long getFacilityAggregateStockId() {
		return facilityAggregateStockId;
	}
	public void setFacilityAggregateStockId(Long facilityAggregateStockId) {
		this.facilityAggregateStockId = facilityAggregateStockId;
	}
	
	public Long getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}
	public String getFacilityCode() {
		return facilityCode;
	}
	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	
	public byte[] getProductImage() {
		return productImage;
	}
	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<BatchDetailsDto> getActiveBatchDetails() {
		return activeBatchDetails;
	}
	public void setActiveBatchDetails(List<BatchDetailsDto> activeBatchDetails) {
		this.activeBatchDetails = activeBatchDetails;
	}
	

	public Float getProductDosage() {
		return productDosage;
	}
	public void setProductDosage(Float productDosage) {
		this.productDosage = productDosage;
	}
	public List<BatchDetailsDto> getExpiredBatchDetails() {
		return expiredBatchDetails;
	}
	public void setExpiredBatchDetails(List<BatchDetailsDto> expiredBatchDetails) {
		this.expiredBatchDetails = expiredBatchDetails;
	}
	public Double getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(Double availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public Double getExpiredQuantity() {
		return expiredQuantity;
	}
	public void setExpiredQuantity(Double expiredQuantity) {
		this.expiredQuantity = expiredQuantity;
	}
	public Double getGit() {
		return git;
	}
	public Double getDamagedQuantity() {
		return damagedQuantity;
	}
	public void setDamagedQuantity(Double damagedQuantity) {
		this.damagedQuantity = damagedQuantity;
	}
	public void setGit(Double git) {
		this.git = git;
	}
	@Override
	public String toString() {
		return "SacsProductsInventoryDto [facilityAggregateStockId=" + facilityAggregateStockId + ", availableQuantity="
				+ availableQuantity + ", expiredQuantity=" + expiredQuantity + ", git=" + git + ", facilityId="
				+ facilityId + ", facilityCode=" + facilityCode + ", facilityName=" + facilityName + ", productId="
				+ productId + ", batchNumber=" + batchNumber + ", productImage=" + productImage + ", productName="
				+ productName + ", productCode=" + productCode + ", status=" + status + ", activeBatchDetails="
				+ activeBatchDetails + ", expiredBatchDetails=" + expiredBatchDetails + "]";
	}
	
	

}
