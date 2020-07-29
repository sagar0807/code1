package gov.naco.soch.enums;

public enum DispatchStatusEnum {
	PENDING("Pending"), DISPATCHED("dispatched"),REJECTED("Rejected");

	private String dispatchStatus;

	DispatchStatusEnum(String status) {
		this.dispatchStatus = status;
	}

	public String getDispatchStatus() {
		return dispatchStatus;
	}
}
