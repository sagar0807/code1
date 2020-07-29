package gov.naco.soch.dto;

public class RegimenConstituentDto extends BaseDto{

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long productId;
	private String productName;
	private Long uomId;
	private String uomName;
	private int quantity;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getUomId() {
		return uomId;
	}
	public void setUomId(Long uomId) {
		this.uomId = uomId;
	}
	public String getUomName() {
		return uomName;
	}
	public void setUomName(String uomName) {
		this.uomName = uomName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "RegimenConstituentDto [id=" + id + ", productId=" + productId + ", productName=" + productName
				+ ", uomId=" + uomId + ", uomName=" + uomName + ", quantity=" + quantity + "]";
	}
	
	
}
