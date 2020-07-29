package gov.naco.soch.shared.dto;

import java.time.LocalDate;
import java.util.Set;

import gov.naco.soch.constructordto.ArtDetailsDTO;
import gov.naco.soch.constructordto.IctcDetailsDTO;
import gov.naco.soch.dto.BaseDto;
import gov.naco.soch.dto.BeneficiaryFacilityMappingDto;
import gov.naco.soch.dto.BeneficiaryFamilyDetailsDto;
import gov.naco.soch.dto.BeneficiaryReferralDto;
import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.dto.TiBeneficiaryAddressDto;
import gov.naco.soch.dto.TransferDto;
import gov.naco.soch.shared.dto.ti.TIBeneficiaryDTO;
import gov.naco.soch.shared.dto.ti.TIOstBeneficiaryDTO;

public class GlobalBeneficiaryViewCardDTO extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String aadharNumber;

	private String age;

	private String beneficiaryActivityStatus;

	private String beneficiaryType;

	private String category;

	private LocalDate dateOfBirth;
	
	private String firstName;
	
	private Boolean isActive;

	private Boolean isDelete;

	private String lastName;

	private String middleName;

	private String mobileNumber;

	private String status;

	private String uid;

	private String alternatePhonenumber;

	private String caregiverName;

	private String caregiverPhoneNumber;

	private Integer caregiverAddressId;
	
	private MiniMasterDto educationLevelId;
	
	private MiniMasterDto maritalStatusId;
	
	private MiniMasterDto masterEmploymentStatus;
	
	private MiniMasterDto masterClientStatus;	
	
	private MiniMasterDto occupationId;
	
	private MiniMasterDto genderId;
	
	private String gender;

	private TIBeneficiaryDTO tiBeneficiary;

	private TIOstBeneficiaryDTO ostBeneficiary;

	private TiBeneficiaryAddressDto address;
	
	private Set<BeneficiaryReferralDto> beneficiaryReferral;
	
	private Set<TransferDto> transfers;
	
	private Set<BeneficiaryFacilityMappingDto> beneficiaryFacilityMappings;
	
	private Set<BeneficiaryFamilyDetailsDto> beneficiaryFamilyDetails;
	
	private ArtDetailsDTO artDetails;
	
	private IctcDetailsDTO ictcDetails;
	
	private String artNumber;
	
	private String preArtNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBeneficiaryActivityStatus() {
		return beneficiaryActivityStatus;
	}

	public void setBeneficiaryActivityStatus(String beneficiaryActivityStatus) {
		this.beneficiaryActivityStatus = beneficiaryActivityStatus;
	}

	public String getBeneficiaryType() {
		return beneficiaryType;
	}

	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}

	public Set<BeneficiaryFamilyDetailsDto> getBeneficiaryFamilyDetails() {
		return beneficiaryFamilyDetails;
	}

	public void setBeneficiaryFamilyDetails(Set<BeneficiaryFamilyDetailsDto> beneficiaryFamilyDetails) {
		this.beneficiaryFamilyDetails = beneficiaryFamilyDetails;
	}

	public ArtDetailsDTO getArtDetails() {
		return artDetails;
	}

	public void setArtDetails(ArtDetailsDTO artDetails) {
		this.artDetails = artDetails;
	}

	public IctcDetailsDTO getIctcDetails() {
		return ictcDetails;
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

	public void setIctcDetails(IctcDetailsDTO ictcDetails) {
		this.ictcDetails = ictcDetails;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
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

	public String getAlternatePhonenumber() {
		return alternatePhonenumber;
	}

	public void setAlternatePhonenumber(String alternatePhonenumber) {
		this.alternatePhonenumber = alternatePhonenumber;
	}

	public String getCaregiverName() {
		return caregiverName;
	}

	public void setCaregiverName(String caregiverName) {
		this.caregiverName = caregiverName;
	}

	public String getCaregiverPhoneNumber() {
		return caregiverPhoneNumber;
	}

	public void setCaregiverPhoneNumber(String caregiverPhoneNumber) {
		this.caregiverPhoneNumber = caregiverPhoneNumber;
	}

	public Integer getCaregiverAddressId() {
		return caregiverAddressId;
	}

	public void setCaregiverAddressId(Integer caregiverAddressId) {
		this.caregiverAddressId = caregiverAddressId;
	}


	public TIBeneficiaryDTO getTiBeneficiary() {
		return tiBeneficiary;
	}

	public void setTiBeneficiary(TIBeneficiaryDTO tiBeneficiary) {
		this.tiBeneficiary = tiBeneficiary;
	}

	public TIOstBeneficiaryDTO getOstBeneficiary() {
		return ostBeneficiary;
	}

	public void setOstBeneficiary(TIOstBeneficiaryDTO ostBeneficiary) {
		this.ostBeneficiary = ostBeneficiary;
	}

	public TiBeneficiaryAddressDto getAddress() {
		return address;
	}

	public void setAddress(TiBeneficiaryAddressDto address) {
		this.address = address;
	}

	public MiniMasterDto getEducationLevelId() {
		return educationLevelId;
	}

	public void setEducationLevelId(MiniMasterDto educationLevelId) {
		this.educationLevelId = educationLevelId;
	}

	public MiniMasterDto getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(MiniMasterDto maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public MiniMasterDto getMasterEmploymentStatus() {
		return masterEmploymentStatus;
	}

	public void setMasterEmploymentStatus(MiniMasterDto masterEmploymentStatus) {
		this.masterEmploymentStatus = masterEmploymentStatus;
	}

	public MiniMasterDto getMasterClientStatus() {
		return masterClientStatus;
	}

	public void setMasterClientStatus(MiniMasterDto masterClientStatus) {
		this.masterClientStatus = masterClientStatus;
	}

	public MiniMasterDto getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(MiniMasterDto occupationId) {
		this.occupationId = occupationId;
	}

	public MiniMasterDto getGenderId() {
		return genderId;
	}

	public void setGenderId(MiniMasterDto genderId) {
		this.genderId = genderId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
