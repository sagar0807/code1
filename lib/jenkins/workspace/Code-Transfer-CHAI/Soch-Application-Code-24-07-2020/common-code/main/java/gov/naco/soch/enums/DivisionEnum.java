package gov.naco.soch.enums;

public enum DivisionEnum {

	NACO(1l), SACS(2l), EXTERNAL_AGENT(3l), REGIONAL_WAREHOUSE(4l), TI(5l), BSD(6l), CST(7l), BLOOD_BANK(
			8l), LABORATORY(9l), OTHERS(10l);

	private Long division;

	DivisionEnum(Long division) {
		this.division = division;
	}

	public Long getDivision() {
		return division;
	}

}
