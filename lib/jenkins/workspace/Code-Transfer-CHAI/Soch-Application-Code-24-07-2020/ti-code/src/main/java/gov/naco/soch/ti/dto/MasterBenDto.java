package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import gov.naco.soch.dto.BeneficiaryFacilityMappingDto;
import gov.naco.soch.dto.BeneficiaryReferralDto;
import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.dto.TiBeneficiaryAddressDto;
import gov.naco.soch.dto.TransferDto;

public class MasterBenDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String age;

    private LocalDate dateOfBirth;

    private String firstName;

    private Boolean isActive;

    private Boolean isDelete;

    private String lastName;

    private String fullName;

    private String middleName;

    private String mobileNumber;

    private String uid;

    private String otherEmploymentStatus;

    private Boolean regularPartners;

    private String tiCode;

    private String ostCode;

    private LocalDate regDate;
    
    private Boolean isLivingInRelationship;

    private TiBeneficiaryAddressDto address;

    private Set<BeneficiaryReferralDto> beneficiaryReferral;

    private Set<BeneficiaryFacilityMappingDto> beneficiaryFacilityMappings;

    private Set<TransferDto> transfers;

    private MiniMasterDto occupationId;

    private MiniMasterDto educationLevelId;

    private MiniMasterDto masterEmploymentStatus;

    private MiniMasterDto genderId;

    private MiniMasterDto maritalStatusId;

    private MiniMasterDto stayingWithId;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getAge() {
	return age;
    }

    public void setAge(String age) {
	this.age = age;
    }

    public LocalDate getDateOfBirth() {
	return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
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

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getFullName() {
	return fullName;
    }

    public void setFullName(String fullName) {
	this.fullName = fullName;
    }

    public String getMiddleName() {
	return middleName;
    }

    public void setMiddleName(String middleName) {
	this.middleName = middleName;
    }

    public String getMobileNumber() {
	return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
    }

    public String getUid() {
	return uid;
    }

    public void setUid(String uid) {
	this.uid = uid;
    }

    public String getOtherEmploymentStatus() {
	return otherEmploymentStatus;
    }

    public void setOtherEmploymentStatus(String otherEmploymentStatus) {
	this.otherEmploymentStatus = otherEmploymentStatus;
    }

    public Boolean getRegularPartners() {
	return regularPartners;
    }

    public void setRegularPartners(Boolean regularPartners) {
	this.regularPartners = regularPartners;
    }

    public String getTiCode() {
	return tiCode;
    }

    public void setTiCode(String tiCode) {
	this.tiCode = tiCode;
    }

    public Boolean getIsLivingInRelationship() {
	return isLivingInRelationship;
    }

    public void setIsLivingInRelationship(Boolean isLivingInRelationship) {
	this.isLivingInRelationship = isLivingInRelationship;
    }

    public String getOstCode() {
	return ostCode;
    }

    public void setOstCode(String ostCode) {
	this.ostCode = ostCode;
    }

    public LocalDate getRegDate() {
	return regDate;
    }

    public void setRegDate(LocalDate regDate) {
	this.regDate = regDate;
    }

    public TiBeneficiaryAddressDto getAddress() {
	return address;
    }

    public void setAddress(TiBeneficiaryAddressDto address) {
	this.address = address;
    }

    public Set<BeneficiaryReferralDto> getBeneficiaryReferral() {
	return beneficiaryReferral;
    }

    public void setBeneficiaryReferral(Set<BeneficiaryReferralDto> beneficiaryReferral) {
	this.beneficiaryReferral = beneficiaryReferral;
    }

    public Set<BeneficiaryFacilityMappingDto> getBeneficiaryFacilityMappings() {
	return beneficiaryFacilityMappings;
    }

    public void setBeneficiaryFacilityMappings(Set<BeneficiaryFacilityMappingDto> beneficiaryFacilityMappings) {
	this.beneficiaryFacilityMappings = beneficiaryFacilityMappings;
    }

    public Set<TransferDto> getTransfers() {
	return transfers;
    }

    public void setTransfers(Set<TransferDto> transfers) {
	this.transfers = transfers;
    }

    public MiniMasterDto getOccupationId() {
	return occupationId;
    }

    public void setOccupationId(MiniMasterDto occupationId) {
	this.occupationId = occupationId;
    }

    public MiniMasterDto getEducationLevelId() {
	return educationLevelId;
    }

    public void setEducationLevelId(MiniMasterDto educationLevelId) {
	this.educationLevelId = educationLevelId;
    }

    public MiniMasterDto getMasterEmploymentStatus() {
	return masterEmploymentStatus;
    }

    public void setMasterEmploymentStatus(MiniMasterDto masterEmploymentStatus) {
	this.masterEmploymentStatus = masterEmploymentStatus;
    }

    public MiniMasterDto getGenderId() {
	return genderId;
    }

    public void setGenderId(MiniMasterDto genderId) {
	this.genderId = genderId;
    }

    public MiniMasterDto getMaritalStatusId() {
	return maritalStatusId;
    }

    public void setMaritalStatusId(MiniMasterDto maritalStatusId) {
	this.maritalStatusId = maritalStatusId;
    }

    public MiniMasterDto getStayingWithId() {
	return stayingWithId;
    }

    public void setStayingWithId(MiniMasterDto stayingWithId) {
	this.stayingWithId = stayingWithId;
    }

}
