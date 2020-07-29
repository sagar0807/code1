package gov.naco.soch.enums;

public enum MasterDrugEnum {
	Buprenorphine(1L), methadone(2l);
	

	private Long masterDrugId;

	MasterDrugEnum(Long masterDrugId) {
		this.masterDrugId = masterDrugId;
	}

	public Long getMasterDrugId() {
		return masterDrugId;
	}
}
