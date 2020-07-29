package gov.naco.soch.enums;

public enum FacilityTypeEnum {

	NACO(1l), SACS(2l), SUPPLIER(3l), TRANSPORTER(4l),  PROCUREMENT_AGENT(5l), WAREHOUSE(6l), TI_CENTER(7l), LWS_FACILITY(9l),
	OST_FACILITY(10l), ICTC_FACILITY(11l), DSRC(12l), F_ICTC(13l), RNTCP(14l), ART_FACILITY(15l), ART_PLUS_FACILITY(16l),
	CSC_FACILITY(17l), LAC_FACILITY(18l), BLOOD_BANK(19l), LABORATORY_EID(20l), LABORATORY_APEX(21l), LABORATORY_NRL(22l),
	LABORATORY_SRL(23l), LABORATORY_CD4(24l), VL_PUBLIC(25l), VL_PRIVATE(26l), LABORATORY_ICTC_PPTCT(27l), OTHER_SERVICES(28l), 
	TI_SATELLITE_OST(29l);

	private Long facilityType;

	FacilityTypeEnum(Long facilityType) {
		this.facilityType = facilityType;
	}

	public Long getFacilityType() {
		return facilityType;
	}


}
