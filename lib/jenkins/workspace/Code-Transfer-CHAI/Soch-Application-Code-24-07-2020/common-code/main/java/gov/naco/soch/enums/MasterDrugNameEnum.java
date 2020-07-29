package gov.naco.soch.enums;

public enum MasterDrugNameEnum {

	Buprenorphine("Buprenorphine"), Methadone("Methadone");

	private String masterDrugName;

	MasterDrugNameEnum(String masterDrugName) {
		this.masterDrugName = masterDrugName;
	}

	public String getMasterDrugName() {
		return masterDrugName;
	}
}
