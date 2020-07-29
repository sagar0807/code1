package gov.naco.soch.cst.dto;

import gov.naco.soch.dto.BaseDto;

public class ArtBeneficiarySearchDto extends BaseDto{

	private static final long serialVersionUID = 1L;
	private Long beneficiaryId;
	private String uid;
	private String firstName;
	private String middleName;
	private String lastName;
	private String artNumber;
	private String preArtNumber;
	private String gender;
	private String age;
	private String isProxy;
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getBeneficiaryId() {
		return beneficiaryId;
	}
	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	public String getArtNumber() {
		return artNumber;
	}
	public void setArtNumber(String artNumber) {
		this.artNumber = artNumber;
	}
	public String getPreArtNumber() {
		return preArtNumber;
	}
	public void setPreArtNumber(String preArtNumber) {
		this.preArtNumber = preArtNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getIsProxy() {
		return isProxy;
	}
	public void setIsProxy(String isProxy) {
		this.isProxy = isProxy;
	}
}
