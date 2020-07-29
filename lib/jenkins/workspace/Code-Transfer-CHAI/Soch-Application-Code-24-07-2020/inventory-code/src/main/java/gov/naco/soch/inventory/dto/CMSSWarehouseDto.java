package gov.naco.soch.inventory.dto;

import gov.naco.soch.dto.BaseDto;

public class CMSSWarehouseDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String storeId;
	private String storeName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

}
