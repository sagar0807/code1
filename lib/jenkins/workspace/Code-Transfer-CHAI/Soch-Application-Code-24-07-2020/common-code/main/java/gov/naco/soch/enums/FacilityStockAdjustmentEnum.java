package gov.naco.soch.enums;

public enum FacilityStockAdjustmentEnum {

	ADD_STOCK(1L), WRITE_OFF(2L), WRITE_OFF_EXPIRED(3L), CONSUMPTION(5l);

	private Long facilityStockAdjustmentType;

	FacilityStockAdjustmentEnum(Long facilityStockAdjustmentType) {
		this.facilityStockAdjustmentType = facilityStockAdjustmentType;
	}

	public Long getFacilityStockAdjustmentType() {
		return facilityStockAdjustmentType;
	}

}
