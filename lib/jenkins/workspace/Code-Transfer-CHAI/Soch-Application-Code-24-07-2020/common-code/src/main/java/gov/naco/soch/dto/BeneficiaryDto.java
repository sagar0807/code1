package gov.naco.soch.dto;

import java.time.LocalDate;
import java.util.Set;

//DTO class used for transfer data between front end and back end.
public class BeneficiaryDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Long id;
	private String aadharNumber;
	private String age;
	private String barcode;
	private String beneficiaryType;
	private LocalDate dateOfBirth;
	private String educationLevel;
	private String employmentStatus;
	private String otherEmploymentStatus;
	private String firstName;
	private String gender;
	private Boolean isActive;
	private Boolean isDelete;
	private Boolean regularPartners;
	private Integer regularPartnersNumber;
	private Boolean isPlhiv;
	private String lastName;
	private String maritalStatus;
	private String middleName;
	private String mobileNumber;
	private String occupation;
	private String status;
	private String uid;
	private String beneficiaryActivityStatus;
	private String ostCode;
	private String tiCode;
	private String entryPoint;
	private String monthlyHouseholdIncome;
	private Boolean pregnant;
	private String riskFactorForHiv;
	private String clientStatus;
	private Boolean isLivingInRelationship;
	private TiBeneficiaryAddressDto address;
	private Set<BeneficiaryReferralDto> beneficiaryReferral;
	private BeneficiaryAddressDto addressDto;
	private Set<BeneficiaryFacilityMappingDto> beneficiaryFacilityMappings;
	private Set<TransferDto> transfers;
	private Set<BeneficiaryFamilyDetailsDto> beneficiaryFamilyDetails;
	private MiniMasterDto educationLevelId;
	private MiniMasterDto maritalStatusId;
	private MiniMasterDto masterEmploymentStatus;
	private MiniMasterDto masterClientStatus;	
	private MiniMasterDto occupationId;
	private MiniMasterDto genderId;
	private String hivConfirmatoryStatus;
	private String hivType;
	private String ostStatus;
	private LocalDate regDate;

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
	
	public Set<BeneficiaryFacilityMappingDto> getBeneficiaryFacilityMappings() {
		return beneficiaryFacilityMappings;
	}

	public void setBeneficiaryFacilityMappings(Set<BeneficiaryFacilityMappingDto> beneficiaryFacilityMappings) {
		this.beneficiaryFacilityMappings = beneficiaryFacilityMappings;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getBeneficiaryType() {
		return beneficiaryType;
	}

	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}

	public String getHivConfirmatoryStatus() {
		return hivConfirmatoryStatus;
	}

	public void setHivConfirmatoryStatus(String hivConfirmatoryStatus) {
		this.hivConfirmatoryStatus = hivConfirmatoryStatus;
	}

	public String getHivType() {
		return hivType;
	}

	public void setHivType(String hivType) {
		this.hivType = hivType;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getClientStatus() {
		return clientStatus;
	}

	public void setClientStatus(String clientStatus) {
		this.clientStatus = clientStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public TiBeneficiaryAddressDto getAddress() {
		return address;
	}

	public void setAddress(TiBeneficiaryAddressDto address) {
		this.address = address;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}


	public String getOtherEmploymentStatus() {
		return otherEmploymentStatus;
	}


	public MiniMasterDto getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(MiniMasterDto occupationId) {
		this.occupationId = occupationId;
	}

	public void setOtherEmploymentStatus(String otherEmploymentStatus) {
		this.otherEmploymentStatus = otherEmploymentStatus;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Boolean getIsPlhiv() {
		return isPlhiv;
	}

	public void setIsPlhiv(Boolean isPlhiv) {
		this.isPlhiv = isPlhiv;
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

	public String getBeneficiaryActivityStatus() {
		return beneficiaryActivityStatus;
	}

	public void setBeneficiaryActivityStatus(String beneficiaryActivityStatus) {
		this.beneficiaryActivityStatus = beneficiaryActivityStatus;
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

	public void setUid(String uidNumber) {
		this.uid = uidNumber;
	}

	public Set<TransferDto> getTransfers() {
		return transfers;
	}

	public void setTransfers(Set<TransferDto> transfers) {
		this.transfers = transfers;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEntryPoint() {
		return entryPoint;
	}

	public void setEntryPoint(String entryPoint) {
		this.entryPoint = entryPoint;
	}

	public String getMonthlyHouseholdIncome() {
		return monthlyHouseholdIncome;
	}

	public void setMonthlyHouseholdIncome(String monthlyHouseholdIncome) {
		this.monthlyHouseholdIncome = monthlyHouseholdIncome;
	}

	public MiniMasterDto getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(MiniMasterDto maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public MiniMasterDto getEducationLevelId() {
		return educationLevelId;
	}

	public void setEducationLevelId(MiniMasterDto educationLevelId) {
		this.educationLevelId = educationLevelId;
	}

	public MiniMasterDto getMasterClientStatus() {
		return masterClientStatus;
	}

	public void setMasterClientStatus(MiniMasterDto masterClientStatus) {
		this.masterClientStatus = masterClientStatus;
	}

	public MiniMasterDto getMasterEmploymentStatus() {
		return masterEmploymentStatus;
	}

	public void setMasterEmploymentStatus(MiniMasterDto masterEmploymentStatus) {
		this.masterEmploymentStatus = masterEmploymentStatus;
	}

	public Set<BeneficiaryFamilyDetailsDto> getBeneficiaryFamilyDetails() {
		return beneficiaryFamilyDetails;
	}

	public void setBeneficiaryFamilyDetails(Set<BeneficiaryFamilyDetailsDto> beneficiaryFamilyDetails) {
		this.beneficiaryFamilyDetails = beneficiaryFamilyDetails;
	}

	public String getOstStatus() {
		return ostStatus;
	}

	public void setOstStatus(String ostStatus) {
		this.ostStatus = ostStatus;
	}

	public MiniMasterDto getGenderId() {
		return genderId;
	}

	public void setGenderId(MiniMasterDto genderId) {
		this.genderId = genderId;
	}

	public Boolean getPregnant() {
		return pregnant;
	}

	public void setPregnant(Boolean pregnant) {
		this.pregnant = pregnant;
	}

	public String getRiskFactorForHiv() {
		return riskFactorForHiv;
	}

	public void setRiskFactorForHiv(String riskFactorForHiv) {
		this.riskFactorForHiv = riskFactorForHiv;
	}

	public String getOstCode() {
		return ostCode;
	}

	public void setOstCode(String ostCode) {
		this.ostCode = ostCode;
	}

	public String getTiCode() {
		return tiCode;
	}

	public void setTiCode(String tiCode) {
		this.tiCode = tiCode;
	}
	

	public BeneficiaryAddressDto getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(BeneficiaryAddressDto addressDto) {
		this.addressDto = addressDto;
	}


	public Boolean getIsLivingInRelationship() {
	    return isLivingInRelationship;
	}

	public void setIsLivingInRelationship(Boolean isLivingInRelationship) {
	    this.isLivingInRelationship = isLivingInRelationship;
	}

	public Set<BeneficiaryReferralDto> getBeneficiaryReferral() {
		return beneficiaryReferral;
	}

	public void setBeneficiaryReferral(Set<BeneficiaryReferralDto> beneficiaryReferral) {
		this.beneficiaryReferral = beneficiaryReferral;
	}

	public Boolean getRegularPartners() {
		return regularPartners;
	}

	public void setRegularPartners(Boolean regularPartners) {
		this.regularPartners = regularPartners;
	}

	public Integer getRegularPartnersNumber() {
		return regularPartnersNumber;
	}

	public void setRegularPartnersNumber(Integer regularPartnersNumber) {
		this.regularPartnersNumber = regularPartnersNumber;
	}
	
	
	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "BeneficiaryDto [id=" + id + ", aadharNumber=" + aadharNumber + ", age=" + age + ", barcode=" + barcode
				+ ", beneficiaryType=" + beneficiaryType + ", dateOfBirth=" + dateOfBirth + ", educationLevel="
				+ educationLevel + ", employmentStatus=" + employmentStatus + ", otherEmploymentStatus="
				+ otherEmploymentStatus + ", firstName=" + firstName + ", gender=" + gender + ", isActive=" + isActive
				+ ", isDelete=" + isDelete + ", isPlhiv=" + isPlhiv + ", lastName=" + lastName + ", maritalStatus="
				+ maritalStatus + ", middleName=" + middleName + ", mobileNumber=" + mobileNumber + ", occupation="
				+ occupation + ", status=" + status + ", uidNumber=" + uid + ", beneficiaryActivityStatus="
				+ beneficiaryActivityStatus + ", ostCode=" + ostCode + ", tiCode=" + tiCode + ", entryPoint="
				+ entryPoint + ", monthlyHouseholdIncome=" + monthlyHouseholdIncome + ", pregnant=" + pregnant
				+ ", riskFactorForHiv=" + riskFactorForHiv + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeneficiaryDto other = (BeneficiaryDto) obj;
		if (aadharNumber == null) {
			if (other.aadharNumber != null)
				return false;
		} else if (!aadharNumber.equals(other.aadharNumber))
			return false;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (barcode == null) {
			if (other.barcode != null)
				return false;
		} else if (!barcode.equals(other.barcode))
			return false;
		if (beneficiaryActivityStatus == null) {
			if (other.beneficiaryActivityStatus != null)
				return false;
		} else if (!beneficiaryActivityStatus.equals(other.beneficiaryActivityStatus))
			return false;
		if (beneficiaryType == null) {
			if (other.beneficiaryType != null)
				return false;
		} else if (!beneficiaryType.equals(other.beneficiaryType))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (educationLevel == null) {
			if (other.educationLevel != null)
				return false;
		} else if (!educationLevel.equals(other.educationLevel))
			return false;
		if (employmentStatus == null) {
			if (other.employmentStatus != null)
				return false;
		} else if (!employmentStatus.equals(other.employmentStatus))
			return false;
		if (entryPoint == null) {
			if (other.entryPoint != null)
				return false;
		} else if (!entryPoint.equals(other.entryPoint))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (isDelete == null) {
			if (other.isDelete != null)
				return false;
		} else if (!isDelete.equals(other.isDelete))
			return false;
		if (isPlhiv == null) {
			if (other.isPlhiv != null)
				return false;
		} else if (!isPlhiv.equals(other.isPlhiv))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (maritalStatus == null) {
			if (other.maritalStatus != null)
				return false;
		} else if (!maritalStatus.equals(other.maritalStatus))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (monthlyHouseholdIncome == null) {
			if (other.monthlyHouseholdIncome != null)
				return false;
		} else if (!monthlyHouseholdIncome.equals(other.monthlyHouseholdIncome))
			return false;
		if (occupation == null) {
			if (other.occupation != null)
				return false;
		} else if (!occupation.equals(other.occupation))
			return false;
		if (ostCode == null) {
			if (other.ostCode != null)
				return false;
		} else if (!ostCode.equals(other.ostCode))
			return false;
		if (otherEmploymentStatus == null) {
			if (other.otherEmploymentStatus != null)
				return false;
		} else if (!otherEmploymentStatus.equals(other.otherEmploymentStatus))
			return false;
		if (pregnant == null) {
			if (other.pregnant != null)
				return false;
		} else if (!pregnant.equals(other.pregnant))
			return false;
		if (riskFactorForHiv == null) {
			if (other.riskFactorForHiv != null)
				return false;
		} else if (!riskFactorForHiv.equals(other.riskFactorForHiv))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tiCode == null) {
			if (other.tiCode != null)
				return false;
		} else if (!tiCode.equals(other.tiCode))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}
