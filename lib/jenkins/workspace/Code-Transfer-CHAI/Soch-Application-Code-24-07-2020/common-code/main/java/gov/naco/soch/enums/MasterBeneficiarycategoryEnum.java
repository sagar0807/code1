package gov.naco.soch.enums;

public enum MasterBeneficiarycategoryEnum {

	INFANT("INFANT"),PED("PED"),ADULT("ADULT");

	private String category;

	MasterBeneficiarycategoryEnum(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

}
