package gov.naco.soch.shared.dto;

public class UnregisteredPartnerDto {

	private Long beneficiaryId;
	private Integer ageMonths;
	private Integer ageYears;
	private Boolean isAlive;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private Long genderId;
	private Long hivStatusId;
	private Long relationShipStatusId;

	public Integer getAgeMonths() {
		return ageMonths;
	}

	public void setAgeMonths(Integer ageMonths) {
		this.ageMonths = ageMonths;
	}

	public Integer getAgeYears() {
		return ageYears;
	}

	public void setAgeYears(Integer ageYears) {
		this.ageYears = ageYears;
	}

	public Boolean getIsAlive() {
		return isAlive;
	}

	public void setIsAlive(Boolean isAlive) {
		this.isAlive = isAlive;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getGenderId() {
		return genderId;
	}

	public void setGenderId(Long genderId) {
		this.genderId = genderId;
	}

	public Long getHivStatusId() {
		return hivStatusId;
	}

	public void setHivStatusId(Long hivStatusId) {
		this.hivStatusId = hivStatusId;
	}

	public Long getRelationShipStatusId() {
		return relationShipStatusId;
	}

	public void setRelationShipStatusId(Long relationShipStatusId) {
		this.relationShipStatusId = relationShipStatusId;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

}
