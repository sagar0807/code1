package gov.naco.soch.enums;

public enum DispatchReceiverStatusEnum {
	PENDING("pending"), RECEIVED("received");

	private String dispatchReceiverStatus;

	private DispatchReceiverStatusEnum(String dispatchReceiverStatus) {
		this.dispatchReceiverStatus = dispatchReceiverStatus;
	}

	public String getDispatchReceiverStatus() {
		return this.dispatchReceiverStatus;
		
	}
}
