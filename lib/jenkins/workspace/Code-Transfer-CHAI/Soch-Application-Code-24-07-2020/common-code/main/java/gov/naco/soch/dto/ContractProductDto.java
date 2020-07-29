package gov.naco.soch.dto;

public class ContractProductDto {
	private Long contractProductId;
    private Long productId;
	private String productName;
	private String uom;
	private Integer authorizedQuantity;

	public String getProductName() {
		return productName;
	}

	public String getUom() {
		return uom;
	}

	public Integer getAuthorizedQuantity() {
		return authorizedQuantity;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public void setAuthorizedQuantity(Integer authorizedQuantity) {
		this.authorizedQuantity = authorizedQuantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "ContractProductDto [productName=" + productName + ", uom=" + uom + ", authorizedQuantity="
				+ authorizedQuantity + "]";
	}

}
