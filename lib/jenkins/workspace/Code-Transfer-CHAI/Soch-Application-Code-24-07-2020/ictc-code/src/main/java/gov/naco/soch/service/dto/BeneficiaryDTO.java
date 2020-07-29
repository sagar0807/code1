package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


/**
 * A DTO for the {@link gov.naco.soch.domain.Beneficiary} entity.
 */
public class BeneficiaryDTO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private String uid;

    private String aadharNumber;

    private String age;

    private String beneficiaryType;

    private String category;

    private LocalDate dateOfBirth;

    private String educationLevel;

    private String employmentStatus;

    private String firstName;

    private String gender;

    private String lastName;

    private String maritalStatus;

    private String middleName;

    private String mobileNumber;

    private String occupation;

    private String status;

    private Integer createdBy;

    private LocalDate createdTime;

    private Integer modifiedBy;

    private LocalDate modifiedTime;

    private Boolean isActive;

    private Boolean isDelete;

    private Long addressId;
    
	private Integer hivTypeId;
	
	private Integer hivStatusId;
    
	private Integer occupationId;

	private Integer monthlyIncomeId;

	private Integer masterEmploymentStatus;

	private Integer educationLevelId;

	private Integer genderId;

	private String alternatePhonenumber;

	private String caregiverName;

	private String caregiverPhoneNumber;

	private Integer caregiverAddressId;

	private LocalDate deathDate;

	private String deathReason;

	private String bankAccountName;

	private String bankAccountNumber;

	private String bankIfsc;

	private Integer stayingWithId;

//	private String guardianCaregiverName;

	private Integer guardianCaregiverHighestEducationId;

	private Integer birthHistoryId;

	private Integer birthWeight;

	private String neoNatalComplications;

	private Integer categoryId;

	private String clientStatus;

	private Integer masterClientStatus;

	private String otherEmploymentStatus;
	
	private String artNumber;
	
	private String preArtNumber;
	
	private String beneficiaryActivityStatus;
	
	private String pid;
	
	private String tiCode;
	
	private String ostCode;
	
	private Integer maritalStatusId;
	
	public String getBeneficiaryActivityStatus() {
		return beneficiaryActivityStatus;
	}

	public void setBeneficiaryActivityStatus(String beneficiaryActivityStatus) {
		this.beneficiaryActivityStatus = beneficiaryActivityStatus;
	}

	public String getPreArtNumber() {
		return preArtNumber;
	}

	public void setPreArtNumber(String preArtNumber) {
		this.preArtNumber = preArtNumber;
	}

    public String getArtNumber() {
		return artNumber;
	}

	public void setArtNumber(String artNumber) {
		this.artNumber = artNumber;
	}

	public Integer getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(Integer occupationId) {
		this.occupationId = occupationId;
	}

	public Integer getMonthlyIncomeId() {
		return monthlyIncomeId;
	}

	public void setMonthlyIncomeId(Integer monthlyIncomeId) {
		this.monthlyIncomeId = monthlyIncomeId;
	}

	public Integer getMasterEmploymentStatus() {
		return masterEmploymentStatus;
	}

	public void setMasterEmploymentStatus(Integer masterEmploymentStatus) {
		this.masterEmploymentStatus = masterEmploymentStatus;
	}

	public Integer getEducationLevelId() {
		return educationLevelId;
	}

	public void setEducationLevelId(Integer educationLevelId) {
		this.educationLevelId = educationLevelId;
	}

	public Integer getGenderId() {
		return genderId;
	}

	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
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

	public LocalDate getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(LocalDate deathDate) {
		this.deathDate = deathDate;
	}

	public String getDeathReason() {
		return deathReason;
	}

	public void setDeathReason(String deathReason) {
		this.deathReason = deathReason;
	}

	public String getBankAccountName() {
		return bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankIfsc() {
		return bankIfsc;
	}

	public void setBankIfsc(String bankIfsc) {
		this.bankIfsc = bankIfsc;
	}

	public Integer getStayingWithId() {
		return stayingWithId;
	}

	public void setStayingWithId(Integer stayingWithId) {
		this.stayingWithId = stayingWithId;
	}

//	public String getGuardianCaregiverName() {
//		return guardianCaregiverName;
//	}
//
//	public void setGuardianCaregiverName(String guardianCaregiverName) {
//		this.guardianCaregiverName = guardianCaregiverName;
//	}

	public Integer getGuardianCaregiverHighestEducationId() {
		return guardianCaregiverHighestEducationId;
	}

	public void setGuardianCaregiverHighestEducationId(Integer guardianCaregiverHighestEducationId) {
		this.guardianCaregiverHighestEducationId = guardianCaregiverHighestEducationId;
	}

	public Integer getBirthHistoryId() {
		return birthHistoryId;
	}

	public void setBirthHistoryId(Integer birthHistoryId) {
		this.birthHistoryId = birthHistoryId;
	}

	public Integer getBirthWeight() {
		return birthWeight;
	}

	public void setBirthWeight(Integer birthWeight) {
		this.birthWeight = birthWeight;
	}

	public String getNeoNatalComplications() {
		return neoNatalComplications;
	}

	public void setNeoNatalComplications(String neoNatalComplications) {
		this.neoNatalComplications = neoNatalComplications;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getClientStatus() {
		return clientStatus;
	}

	public void setClientStatus(String clientStatus) {
		this.clientStatus = clientStatus;
	}

	public Integer getMasterClientStatus() {
		return masterClientStatus;
	}

	public void setMasterClientStatus(Integer masterClientStatus) {
		this.masterClientStatus = masterClientStatus;
	}

	public String getOtherEmploymentStatus() {
		return otherEmploymentStatus;
	}

	public void setOtherEmploymentStatus(String otherEmploymentStatus) {
		this.otherEmploymentStatus = otherEmploymentStatus;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getBeneficiaryType() {
        return beneficiaryType;
    }

    public void setBeneficiaryType(String beneficiaryType) {
        this.beneficiaryType = beneficiaryType;
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

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
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


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDate createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDate getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDate modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Integer getHivTypeId() {
		return hivTypeId;
	}

	public void setHivTypeId(Integer hivTypeId) {
		this.hivTypeId = hivTypeId;
	}

	public Integer getHivStatusId() {
		return hivStatusId;
	}

	public void setHivStatusId(Integer hivStatusId) {
		this.hivStatusId = hivStatusId;
	}
	
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getTiCode() {
		return tiCode;
	}

	public void setTiCode(String tiCode) {
		this.tiCode = tiCode;
	}

	public String getOstCode() {
		return ostCode;
	}

	public void setOstCode(String ostCode) {
		this.ostCode = ostCode;
	}

	public Integer getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(Integer maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BeneficiaryDTO beneficiaryDTO = (BeneficiaryDTO) o;
        if (beneficiaryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), beneficiaryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "BeneficiaryDTO [id=" + id + ", uid=" + uid + ", aadharNumber=" + aadharNumber + ", age=" + age
				+ ", beneficiaryType=" + beneficiaryType + ", category=" + category + ", dateOfBirth=" + dateOfBirth
				+ ", educationLevel=" + educationLevel + ", employmentStatus=" + employmentStatus + ", firstName="
				+ firstName + ", gender=" + gender + ", lastName=" + lastName + ", maritalStatus=" + maritalStatus
				+ ", middleName=" + middleName + ", mobileNumber=" + mobileNumber + ", occupation=" + occupation
				+ ", status=" + status + ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", modifiedBy="
				+ modifiedBy + ", modifiedTime=" + modifiedTime + ", isActive=" + isActive + ", isDelete=" + isDelete
				+ ", addressId=" + addressId + ", hivTypeId=" + hivTypeId + ", hivStatusId=" + hivStatusId
				+ ", occupationId=" + occupationId + ", monthlyIncomeId=" + monthlyIncomeId
				+ ", masterEmploymentStatus=" + masterEmploymentStatus + ", educationLevelId=" + educationLevelId
				+ ", genderId=" + genderId + ", alternatePhonenumber=" + alternatePhonenumber + ", caregiverName="
				+ caregiverName + ", caregiverPhoneNumber=" + caregiverPhoneNumber + ", caregiverAddressId="
				+ caregiverAddressId + ", deathDate=" + deathDate + ", deathReason=" + deathReason
				+ ", bankAccountName=" + bankAccountName + ", bankAccountNumber=" + bankAccountNumber + ", bankIfsc="
				+ bankIfsc + ", stayingWithId=" + stayingWithId + ", guardianCaregiverHighestEducationId="
				+ guardianCaregiverHighestEducationId + ", birthHistoryId=" + birthHistoryId + ", birthWeight="
				+ birthWeight + ", neoNatalComplications=" + neoNatalComplications + ", categoryId=" + categoryId
				+ ", clientStatus=" + clientStatus + ", masterClientStatus=" + masterClientStatus
				+ ", otherEmploymentStatus=" + otherEmploymentStatus + ", artNumber=" + artNumber + ", preArtNumber="
				+ preArtNumber + ", beneficiaryActivityStatus=" + beneficiaryActivityStatus + "]";
	}

}
