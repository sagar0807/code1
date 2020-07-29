package gov.naco.soch.dto;

public class ReturnDispDrugDto extends BaseDto{
	private static final long serialVersionUID = 1L;
	Long productId;
	Long dispensationId;
	int returnQty;
	Long beneficiaryId;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getReturnQty() {
		return returnQty;
	}
	public void setReturnQty(int returnQty) {
		this.returnQty = returnQty;
	}
	public Long getBeneficiaryId() {
		return beneficiaryId;
	}
	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	public Long getDispensationId() {
		return dispensationId;
	}
	public void setDispensationId(Long dispensationId) {
		this.dispensationId = dispensationId;
	}
	
	
}
