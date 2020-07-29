package gov.naco.soch.enums;

public enum FacilityStockTrackingTypeEnum {

	Receive_From_Supllier(1L), Facility_Stock_Adjustment_Add_Stock(2L),
	Facility_Receive_Stock(3L), Git_Reconciliation_By_Consignor(4L),
	Reconciliation(5L), Ti_Ost_Drug_Dispensation(6L),
	Facility_Stock_Adjustment_Write_Off(7L),Facility_Stock_Adjustment_Write_Off_Expired(8L),
	Facility_Dispatch_Stock(9L),Receive_from_unregistered_source(10L),
	Dispatch_to_unregistered_source(11L),Art_drug_dispensation(12L),
	Consumption(13L),Receive_from_CMSS(13L),Receive_From_CMSS(14L),ART_Return_From_Beneficiary(15L),
	Facility_Assign_Stock_to_Sub_Facility(16L),Sub_Facility_Return_Stock_To_Facility(17L);

	private Long facilityStockTrackingTypeId;

	FacilityStockTrackingTypeEnum(Long facilityStockTrackingTypeId) {
		this.facilityStockTrackingTypeId = facilityStockTrackingTypeId;
	}

	public Long getFacilityStockTrackingTypeId() {
		return facilityStockTrackingTypeId;
	}

}
