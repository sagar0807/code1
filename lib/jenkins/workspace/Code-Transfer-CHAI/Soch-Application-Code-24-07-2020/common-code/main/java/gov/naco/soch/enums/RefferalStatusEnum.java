package gov.naco.soch.enums;

public enum RefferalStatusEnum {

	Pending(1l), Referred(2l), Accepted(3l), Declined(4l),  Cancelled(5l);

	private Long referalStatus;

	RefferalStatusEnum(Long referalStatus) {
		this.referalStatus = referalStatus;
	}

	public Long getReferalStatus() {
		return referalStatus;
	}


}
