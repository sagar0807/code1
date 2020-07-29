package gov.naco.soch.enums;

public enum MicroservicePortNumberEnum {
	
	ADMIN(8080),CST(8082),NOTIFICATION(8084);

	private Integer portNumber;

	MicroservicePortNumberEnum(Integer portNumber) {
		this.portNumber = portNumber;
	}

	public Integer getPortNumber() {
		return portNumber;
	}	

}
