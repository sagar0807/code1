package gov.naco.soch.dto;

public class ProductDosageDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long dosageId;
	private Long productId;
	private String productName;
	private Long categoryId;
	private String categoryName;
	private Long weightBandId;
	private String weightBand;
	private Float dosagePerMonth;
	private String shortCode;

	public Long getDosageId() {
		return dosageId;
	}

	public void setDosageId(Long dosageId) {
		this.dosageId = dosageId;
	}

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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getWeightBandId() {
		return weightBandId;
	}

	public void setWeightBandId(Long weightBandId) {
		this.weightBandId = weightBandId;
	}

	public String getWeightBand() {
		return weightBand;
	}

	public void setWeightBand(String weightBand) {
		this.weightBand = weightBand;
	}

	public Float getDosagePerMonth() {
		return dosagePerMonth;
	}

	public void setDosagePerMonth(Float dosagePerMonth) {
		this.dosagePerMonth = dosagePerMonth;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProductDosageDto [dosageId=" + dosageId + ", productId=" + productId + ", productName=" + productName
				+ ", categoryId=" + categoryId + ", categoryName=" + categoryName + ", weightBandId=" + weightBandId
				+ ", weightBand=" + weightBand + ", dosagePerMonth=" + dosagePerMonth + ", shortCode=" + shortCode
				+ "]";
	}

}
