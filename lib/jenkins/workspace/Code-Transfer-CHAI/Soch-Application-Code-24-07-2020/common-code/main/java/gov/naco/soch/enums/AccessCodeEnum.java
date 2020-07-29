package gov.naco.soch.enums;

public enum AccessCodeEnum {

	PE("TI-CENTER-PE"), ORW("TI-CENTER-ORW");
	
	private String accessCode;

	private AccessCodeEnum(String accessCode) {
		this.accessCode = accessCode;
	}

	public String getAccessCode() {
		return accessCode;
	}
	
}
