package gov.naco.soch.enums;

public enum NotificationEventIdEnum {

	ADD_USER("1"), DELETE_USER("2"), ADD_DIVISION("3"), DELETE_DIVISION("4"), ADD_ROLE("5"), DELETE_ROLE("6"),
	ADD_DESIGNATION("7"), DELETE_DESIGNATION("8"), ADD_FACILITY("9"), DELETE_FACILITY("10"), ADD_BENEFICIARY_CST("11"),
	DELETE_BENEFICIARY_CST("12"), ADD_LAC_CST("13"), DELETE_LAC_CST("14"), BENEFICIARY_REFERRAL_CST("15"),
	SEND_REGISTRATION_DETAILS_TO_USER("16"), ADD_SACS("17"), ADD_LABS("18"), ADD_SUPPLIER("19"), ADD_RWH("20"),
	ADD_SACS_FACILITY("21"),RESET_PASSWORD("22");

	private String eventId;

	NotificationEventIdEnum(String eventId) {
		this.eventId = eventId;
	}

	public String getEventId() {
		return this.eventId;
	}

}
