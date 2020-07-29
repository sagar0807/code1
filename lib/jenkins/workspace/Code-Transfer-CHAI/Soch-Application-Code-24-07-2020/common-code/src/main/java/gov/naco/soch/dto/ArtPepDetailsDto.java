package gov.naco.soch.dto;

import java.time.LocalDate;
import java.util.List;

import gov.naco.soch.entity.Product;

public class ArtPepDetailsDto extends BaseDto{
	
	private Long Id;
	private String beneficiaryName;
	private LocalDate dob;
	private String gender;
	private Long mobileNumber;
	private Long facilityId;
	private Long userId;
	//New variable added : Rishad Basheer
	private String pepNo;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Long getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getPepNo() {
		return pepNo;
	}
	public void setPepNo(String pepNo) {
		this.pepNo = pepNo;
	}
	
	
	
}
