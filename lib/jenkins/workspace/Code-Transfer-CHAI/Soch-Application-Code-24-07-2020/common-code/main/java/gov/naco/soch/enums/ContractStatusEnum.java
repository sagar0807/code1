package gov.naco.soch.enums;

public enum ContractStatusEnum {
	
	DRAFT("Draft"), AWAITING_APPROVAL("Awaiting Approval"),APPROVED("Approved"),CLOSE("Close");

	private String status;

	ContractStatusEnum(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}	
}
