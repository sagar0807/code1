package gov.naco.soch.cst.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ArtBeneficiaryIctcReferralDto {

	private Long id;
	private LocalDateTime dateOfHivTest;
	private LocalDate dateOfVisit;
	private Boolean isActive;
	private Boolean isDelete;
	private LocalDate referDate;
	private String referralType;
	private LocalDateTime acceptedDate;
	private LocalDateTime declinedDate;
	private String referralReason;
	private Integer facilityType;
	private Long beneficiaryId;
	private Long referredFrom;
	private Long referralStatus;
	private Long referredTo;
	private String referredFromFacility;

	private String age;
	private String gender;
	private String status;
	private String firstName;
	private String middleName;
	private String lastName;
	private String mobileNumber;
	private String category;
	private String patientPid;
	private String ictcCenters;
	private String uid;
	private Long genderId;
	private Long hivStatus;
	private Long categoryId;
	private Long ictcId;
	private LocalDate dob;
	private Long hivTypeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateOfHivTest() {
		return dateOfHivTest;
	}

	public void setDateOfHivTest(LocalDateTime dateOfHivTest) {
		this.dateOfHivTest = dateOfHivTest;
	}

	public LocalDate getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(LocalDate dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	public Long getHivStatus() {
		return hivStatus;
	}

	public void setHivStatus(Long hivStatus) {
		this.hivStatus = hivStatus;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public LocalDate getReferDate() {
		return referDate;
	}

	public void setReferDate(LocalDate referDate) {
		this.referDate = referDate;
	}

	public String getReferralType() {
		return referralType;
	}

	public void setReferralType(String referralType) {
		this.referralType = referralType;
	}

	public LocalDateTime getAcceptedDate() {
		return acceptedDate;
	}

	public void setAcceptedDate(LocalDateTime acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

	public LocalDateTime getDeclinedDate() {
		return declinedDate;
	}

	public void setDeclinedDate(LocalDateTime declinedDate) {
		this.declinedDate = declinedDate;
	}

	public String getReferralReason() {
		return referralReason;
	}

	public void setReferralReason(String referralReason) {
		this.referralReason = referralReason;
	}

	public Integer getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(Integer facilityType) {
		this.facilityType = facilityType;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Long getReferredFrom() {
		return referredFrom;
	}

	public void setReferredFrom(Long referredFrom) {
		this.referredFrom = referredFrom;
	}

	public Long getReferralStatus() {
		return referralStatus;
	}

	public void setReferralStatus(Long referralStatus) {
		this.referralStatus = referralStatus;
	}

	public Long getReferredTo() {
		return referredTo;
	}

	public void setReferredTo(Long referredTo) {
		this.referredTo = referredTo;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getReferredFromFacility() {
		return referredFromFacility;
	}

	public void setReferredFromFacility(String referredFromFacility) {
		this.referredFromFacility = referredFromFacility;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPatientPid() {
		return patientPid;
	}

	public void setPatientPid(String patientPid) {
		this.patientPid = patientPid;
	}

	public String getIctcCenters() {
		return ictcCenters;
	}

	public void setIctcCenters(String ictcCenters) {
		this.ictcCenters = ictcCenters;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Long getGenderId() {
		return genderId;
	}

	public void setGenderId(Long genderId) {
		this.genderId = genderId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getIctcId() {
		return ictcId;
	}

	public void setIctcId(Long ictcId) {
		this.ictcId = ictcId;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Long getHivTypeId() {
		return hivTypeId;
	}

	public void setHivTypeId(Long hivTypeId) {
		this.hivTypeId = hivTypeId;
	}
	
	
}
