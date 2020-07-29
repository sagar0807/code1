package gov.naco.soch.ti.dto;

import java.time.LocalDate;
/**
 * 
 * @author Rishad Basheer
 *
 */
public class TiReferralDto {
	Long id;
	String name;
	String uid;
	String ostCode;
	String gender;
	int age;
	String referredFrom;
	String referredTo;
	Integer referralFacility;
	Integer referredFacility;
	String mobileNumber;
	LocalDate dateOfReferral;
	Long tiBenficiaryId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getOstCode() {
		return ostCode;
	}
	public void setOstCode(String ostCode) {
		this.ostCode = ostCode;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getReferredFrom() {
		return referredFrom;
	}
	public void setReferredFrom(String referredFrom) {
		this.referredFrom = referredFrom;
	}
	public String getReferredTo() {
		return referredTo;
	}
	public void setReferredTo(String referredTo) {
		this.referredTo = referredTo;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public LocalDate getDateOfReferral() {
		return dateOfReferral;
	}
	public void setDateOfReferral(LocalDate dateOfReferral) {
		this.dateOfReferral = dateOfReferral;
	}
	public Long getTiBenficiaryId() {
		return tiBenficiaryId;
	}
	public void setTiBenficiaryId(Long tiBenficiaryId) {
		this.tiBenficiaryId = tiBenficiaryId;
	}
	public Integer getReferralFacility() {
		return referralFacility;
	}
	public void setReferralFacility(Integer referralFacility) {
		this.referralFacility = referralFacility;
	}
	public Integer getReferredFacility() {
		return referredFacility;
	}
	public void setReferredFacility(Integer referredFacility) {
		this.referredFacility = referredFacility;
	}
	
	
	
}
