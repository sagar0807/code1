package gov.naco.soch.enums;

public enum FacilityStockStatusEnum {

	PENDING("pending"), COMPLETED("completed"),RECONCILED("reconciled"),IN_TRANSIT("in_transit"),RECEIVED("received");

	private String status;

	FacilityStockStatusEnum(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}	

}
