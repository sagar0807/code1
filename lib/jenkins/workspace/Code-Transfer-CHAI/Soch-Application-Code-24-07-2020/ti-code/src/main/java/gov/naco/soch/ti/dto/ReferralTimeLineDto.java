package gov.naco.soch.ti.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ReferralTimeLineDto {

	private Long beneficiaryId;
	private Long referralId;
	private String firstName;
	private String lastName;
	private String uId;
	private Integer age;
	private String gender;
	private LocalDate dateOfReg;
	private String registeredFacility;
	private String basicDtlFacilityName;
	private String codeType;
	private String benCode;
	private String clientStatus;
	private List<ReferralTimeLineObjectDto> referrals;

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Long getReferralId() {
		return referralId;
	}

	public void setReferralId(Long referralId) {
		this.referralId = referralId;
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

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfReg() {
		return dateOfReg;
	}

	public void setDateOfReg(LocalDate localDate) {
		this.dateOfReg = localDate;
	}

	public String getRegisteredFacility() {
		return registeredFacility;
	}

	public void setRegisteredFacility(String registeredFacility) {
		this.registeredFacility = registeredFacility;
	}

	public String getBasicDtlFacilityName() {
		return basicDtlFacilityName;
	}

	public void setBasicDtlFacilityName(String basicDtlFacilityName) {
		this.basicDtlFacilityName = basicDtlFacilityName;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getBenCode() {
		return benCode;
	}

	public void setBenCode(String benCode) {
		this.benCode = benCode;
	}

	public List<ReferralTimeLineObjectDto> getReferrals() {
		return referrals;
	}

	public void setReferrals(List<ReferralTimeLineObjectDto> referrals) {
		this.referrals = referrals;
	}

	public String getClientStatus() {
		return clientStatus;
	}

	public void setClientStatus(String clientStatus) {
		this.clientStatus = clientStatus;
	}

}
