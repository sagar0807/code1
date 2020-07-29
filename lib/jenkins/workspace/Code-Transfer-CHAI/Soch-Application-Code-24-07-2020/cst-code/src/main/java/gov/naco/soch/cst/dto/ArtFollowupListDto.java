package gov.naco.soch.cst.dto;

import java.time.LocalDate;

import gov.naco.soch.dto.BaseDto;

public class ArtFollowupListDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer yearGenerated;
	private Integer monthGenerated;
	private Long facilityId;
	private Long beneficiaryId;
	private Long artBeneficiaryStatusIdCaptured;
	private String artBeneficiaryStatusNameCaptured;
	private String artNumber;
	private String preArtNumber;
	private String beneficiaryName;
	private String mobileNumber;
	private Long genderId;
	private String genderName;
	private String uid;
	private String age;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getYearGenerated() {
		return yearGenerated;
	}
	public void setYearGenerated(Integer yearGenerated) {
		this.yearGenerated = yearGenerated;
	}
	public Integer getMonthGenerated() {
		return monthGenerated;
	}
	public void setMonthGenerated(Integer monthGenerated) {
		this.monthGenerated = monthGenerated;
	}
	public Long getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}
	public Long getBeneficiaryId() {
		return beneficiaryId;
	}
	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	public Long getArtBeneficiaryStatusIdCaptured() {
		return artBeneficiaryStatusIdCaptured;
	}
	public void setArtBeneficiaryStatusIdCaptured(Long artBeneficiaryStatusIdCaptured) {
		this.artBeneficiaryStatusIdCaptured = artBeneficiaryStatusIdCaptured;
	}
	public String getArtBeneficiaryStatusNameCaptured() {
		return artBeneficiaryStatusNameCaptured;
	}
	public void setArtBeneficiaryStatusNameCaptured(String artBeneficiaryStatusNameCaptured) {
		this.artBeneficiaryStatusNameCaptured = artBeneficiaryStatusNameCaptured;
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
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
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
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
		
	
	
}
