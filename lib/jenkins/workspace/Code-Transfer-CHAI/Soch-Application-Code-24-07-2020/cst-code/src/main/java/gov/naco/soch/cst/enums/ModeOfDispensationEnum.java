package gov.naco.soch.cst.enums;

public enum ModeOfDispensationEnum {

	REPEAT(1L), REGIMEN(2L), PRESCRIPTION(3L), REPEAT_NAME("REPEAT"), REGIMEN_NAME("REGIMEN"), PRESCRIPTION_NAME(
			"PRESCRIPTION");

	private Long modeOfDispensationId;

	private String modeOfDispensation;

	ModeOfDispensationEnum(Long modeOfDispensationId) {
		this.modeOfDispensationId = modeOfDispensationId;

	}

	ModeOfDispensationEnum(String modOfDispensation) {
		this.modeOfDispensation = modOfDispensation;

	}

	public Long getModeOfDispensationId() {
		return modeOfDispensationId;
	}

	public String getModeOfDispensation() {
		return modeOfDispensation;
	}

}
