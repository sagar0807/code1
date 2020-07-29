package gov.naco.soch.projection;

public interface ProductInventoryProjection {

	String getProductName();

	String getProductCode();

	byte[] getProductImage();

	Double getGit();
	
	Double getDamagedQuantity();

	Long getProductId();

	Long getFacilityId();

	Double getAvailableQuantity();

	Double getExpiredQuantity();
	
	Long getUomId();
	
	String getUomName();

	void setProductName(String productName);

	void setProductCode(String productCode);

	void setProductImage(byte[] productImage);

	void setGit(Double git);

	void setProductId(Long productId);

	void setFacilityId(Long facilityId);

	void setAvailableQuantity(Double availableQuantity);

	void setExpiredQuantity(Double expiredQuantity);

	void setDamagedQuantity(Double damagedQuantity);
	
	void setUomId(Long uomId);
	
	void setUomName(String uomName);

}
