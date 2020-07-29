package gov.naco.soch.shared.dto;

import java.util.List;

public class PartnerLinkageDto {

	private Long id;
	private String firstName;
	private String lastName;
	private Long genderId;
	private String gender;
	private Integer ageMonths;
	private Integer ageYears;
	private String mobileNumber;
	private Long relationShipStatusId;
	private String relationShipStatus;
	private Long hivStatusId;
	private String hivStatus;
	private Boolean isAlive;
	private Boolean isUnreg;
	private Long beneficiaryId;
	private String uid;
	private Long partnerBeneficiaryId;
	private List<BeneficiaryReferralDto>referralDetails;

	public Long getId() {
		return id;
	}
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	public void setId(Long id) {
		this.id = id;
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

	public Long getGenderId() {
		return genderId;
	}

	public void setGenderId(Long genderId) {
		this.genderId = genderId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getRelationShipStatusId() {
		return relationShipStatusId;
	}

	public void setRelationShipStatusId(Long relationShipStatusId) {
		this.relationShipStatusId = relationShipStatusId;
	}

	public String getRelationShipStatus() {
		return relationShipStatus;
	}

	public void setRelationShipStatus(String relationShipStatus) {
		this.relationShipStatus = relationShipStatus;
	}

	public Long getHivStatusId() {
		return hivStatusId;
	}

	public void setHivStatusId(Long hivStatusId) {
		this.hivStatusId = hivStatusId;
	}

	public String getHivStatus() {
		return hivStatus;
	}

	public void setHivStatus(String hivStatus) {
		this.hivStatus = hivStatus;
	}

	public Boolean getIsAlive() {
		return isAlive;
	}

	public void setIsAlive(Boolean isAlive) {
		this.isAlive = isAlive;
	}

	public Boolean getIsUnreg() {
		return isUnreg;
	}

	public void setIsUnreg(Boolean isUnreg) {
		this.isUnreg = isUnreg;
	}

	public List<BeneficiaryReferralDto> getReferralDetails() {
		return referralDetails;
	}

	public void setReferralDetails(List<BeneficiaryReferralDto> referralDetails) {
		this.referralDetails = referralDetails;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Long getPartnerBeneficiaryId() {
		return partnerBeneficiaryId;
	}

	public void setPartnerBeneficiaryId(Long partnerBeneficiaryId) {
		this.partnerBeneficiaryId = partnerBeneficiaryId;
	}

}
