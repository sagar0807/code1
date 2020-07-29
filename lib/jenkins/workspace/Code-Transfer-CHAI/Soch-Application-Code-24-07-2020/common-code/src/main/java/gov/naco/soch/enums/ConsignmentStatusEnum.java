package gov.naco.soch.enums;

public enum ConsignmentStatusEnum {
	PENDING("pending"), RECEIVED("received");
	String consignmentStatus;

	public String getConsignmentStatus() {
		return consignmentStatus;
	}

	private ConsignmentStatusEnum(String consignmentStatus) {
		this.consignmentStatus = consignmentStatus;
	}

	
}
