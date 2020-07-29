package gov.naco.soch.enums;

public enum RoleEnum {

	SUPER_ADMIN(1l), NACO_ADMIN(2l), ART_PHARMACIST(18l), ART_LAB_TECHNICIAN(19l), ART_DATA_MANAGER(
			20l), ART_MEDICAL_OFFICER(
					21l), ART_STAFF_NURSE(22l), SACEP_COORDINATOR(26l), ART_COUNSELLOR(27l), ART_CARE_COORDINATOR(42l);

	private Long role;

	RoleEnum(Long role) {
		this.role = role;
	}

	public Long getRole() {
		return role;
	}

}
