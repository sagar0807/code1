package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A Beneficiary.
 */
@Entity
@Table(name = "beneficiary")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Beneficiary implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "uid")
	private String uid;

	@Column(name = "aadhar_number")
	private String aadharNumber;

	@Column(name = "age")
	private String age;

	@Column(name = "beneficiary_type")
	private String beneficiaryType;

	@Column(name = "category")
	private String category;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(name = "education_level")
	private String educationLevel;

	@Column(name = "employment_status")
	private String employmentStatus;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "marital_status")
	private String maritalStatus;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "occupation")
	private String occupation;

	@Column(name = "status")
	private String status;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "created_time")
	private LocalDate createdTime;

	@Column(name = "modified_by")
	private Integer modifiedBy;

	@Column(name = "modified_time")
	private LocalDate modifiedTime;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "pre_art_number")
	private String preArtNumber;

	@Column(name = "art_number")
	private String artNumber;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(unique = true, name = "address_id")
	private Address address;

	@Column(name = "hiv_type_id")
	private Integer hivTypeId;

	@Column(name = "hiv_status_id")
	private Integer hivStatusId;

	@Column(name = "marital_status_id")
	private Integer maritalStatusId;

	@Column(name = "occupation_id")
	private Integer occupationId;

	@Column(name = "monthly_income")
	private Integer monthlyIncomeId;

	@Column(name = "employment_status_id")
	private Integer masterEmploymentStatus;

	@Column(name = "education_level_id")
	private Integer educationLevelId;

	@Column(name = "gender_id")
	private Integer genderId;

	@Column(name = "alternate_phonenumber")
	private String alternatePhonenumber;

	@Column(name = "caregiver_name")
	private String caregiverName;

	@Column(name = "caregiver_phone_number")
	private String caregiverPhoneNumber;

	@Column(name = "caregiver_address_id")
	private Integer caregiverAddressId;

	@Column(name = "death_date")
	private LocalDate deathDate;

	@Column(name = "death_reason")
	private String deathReason;

	@Column(name = "bank_account_name")
	private String bankAccountName;

	@Column(name = "bank_account_number")
	private String bankAccountNumber;

	@Column(name = "bank_ifsc")
	private String bankIfsc;

	@Column(name = "staying_with_id")
	private Integer stayingWithId;

//	@Column(name = "guardian_caregiver_name")
//	private String guardianCaregiverName;

	@Column(name = "guardian_caregiver_highest_education_id")
	private Integer guardianCaregiverHighestEducationId;

	@Column(name = "birth_history_id")
	private Integer birthHistoryId;

	@Column(name = "birth_weight")
	private Integer birthWeight;

	@Column(name = "neo_natal_complications")
	private String neoNatalComplications;

	@Column(name = "category_id")
	private Integer categoryId;

	@Column(name = "client_status")
	private String clientStatus;

	@Column(name = "client_status_id")
	private Integer masterClientStatus;

	@Column(name = "other_employment_status")
	private String otherEmploymentStatus;
	
	@Column(name = "beneficiary_activity_status")
	private String beneficiaryActivityStatus;
	
	@JsonIgnoreProperties({"beneficiary", "facility"})
	@OneToOne(mappedBy = "beneficiary")
	private ICTCBeneficiary ictcBeneficiary;
	
	@Column(name = "ti_code")
	private String tiCode;
	
	@Column(name = "ost_code")
	private String ostCode;
	
	@Column(name = "pid")
	private String pid;
 
    @OneToOne(mappedBy = "beneficiary", fetch = FetchType.EAGER)
    private TIBeneficiary tiBeneficiary;

	public String getBeneficiaryActivityStatus() {
		return beneficiaryActivityStatus;
	}

	public void setBeneficiaryActivityStatus(String beneficiaryActivityStatus) {
		this.beneficiaryActivityStatus = beneficiaryActivityStatus;
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

//	public String getGuardianCaregiverName() {
//		return guardianCaregiverName;
//	}
//
//	public void setGuardianCaregiverName(String guardianCaregiverName) {
//		this.guardianCaregiverName = guardianCaregiverName;
//	}

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

	public String getOtherEmploymentStatus() {
		return otherEmploymentStatus;
	}

	public void setOtherEmploymentStatus(String otherEmploymentStatus) {
		this.otherEmploymentStatus = otherEmploymentStatus;
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

	public Integer getCaregiverAddressId() {
		return caregiverAddressId;
	}

	public void setCaregiverAddressId(Integer caregiverAddressId) {
		this.caregiverAddressId = caregiverAddressId;
	}

	public Integer getStayingWithId() {
		return stayingWithId;
	}

	public void setStayingWithId(Integer stayingWithId) {
		this.stayingWithId = stayingWithId;
	}

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

	public Integer getMasterClientStatus() {
		return masterClientStatus;
	}

	public void setMasterClientStatus(Integer masterClientStatus) {
		this.masterClientStatus = masterClientStatus;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public Integer getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(Integer maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	// jhipster-needle-entity-add-field - JHipster will add fields here, do not
	// remove
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public Beneficiary uid(String uid) {
		this.uid = uid;
		return this;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public Beneficiary aadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
		return this;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getAge() {
		return age;
	}

	public Beneficiary age(String age) {
		this.age = age;
		return this;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBeneficiaryType() {
		return beneficiaryType;
	}

	public Beneficiary beneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
		return this;
	}

	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}

	public String getCategory() {
		return category;
	}

	public Beneficiary category(String category) {
		this.category = category;
		return this;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public Beneficiary dateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public Beneficiary educationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
		return this;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public Beneficiary employmentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
		return this;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public String getFirstName() {
		return firstName;
	}

	public Beneficiary firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public Beneficiary gender(String gender) {
		this.gender = gender;
		return this;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public Beneficiary lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public Beneficiary maritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
		return this;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getMiddleName() {
		return middleName;
	}

	public Beneficiary middleName(String middleName) {
		this.middleName = middleName;
		return this;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public Beneficiary mobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
		return this;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getOccupation() {
		return occupation;
	}

	public Beneficiary occupation(String occupation) {
		this.occupation = occupation;
		return this;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getStatus() {
		return status;
	}

	public Beneficiary status(String status) {
		this.status = status;
		return this;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public Beneficiary createdBy(Integer createdBy) {
		this.createdBy = createdBy;
		return this;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedTime() {
		return createdTime;
	}

	public Beneficiary createdTime(LocalDate createdTime) {
		this.createdTime = createdTime;
		return this;
	}

	public void setCreatedTime(LocalDate createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public Beneficiary modifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
		return this;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDate getModifiedTime() {
		return modifiedTime;
	}

	public Beneficiary modifiedTime(LocalDate modifiedTime) {
		this.modifiedTime = modifiedTime;
		return this;
	}

	public void setModifiedTime(LocalDate modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Boolean isIsActive() {
		return isActive;
	}

	public Beneficiary isActive(Boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean isIsDelete() {
		return isDelete;
	}

	public Beneficiary isDelete(Boolean isDelete) {
		this.isDelete = isDelete;
		return this;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Address getAddress() {
		return address;
	}

	public Beneficiary address(Address address) {
		this.address = address;
		return this;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	// jhipster-needle-entity-add-getters-setters - JHipster will add getters and
	// setters here, do not remove

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
	
	public ICTCBeneficiary getIctcBeneficiary() {
		return ictcBeneficiary;
	}

	public void setIctcBeneficiary(ICTCBeneficiary ictcBeneficiary) {
		this.ictcBeneficiary = ictcBeneficiary;
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
	
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public TIBeneficiary getTiBeneficiary() {
		return tiBeneficiary;
	}

	public void setTiBeneficiary(TIBeneficiary tiBeneficiary) {
		this.tiBeneficiary = tiBeneficiary;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Beneficiary)) {
			return false;
		}
		return id != null && id.equals(((Beneficiary) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		return "Beneficiary [id=" + id + ", uid=" + uid + ", aadharNumber=" + aadharNumber + ", age=" + age
				+ ", beneficiaryType=" + beneficiaryType + ", category=" + category + ", dateOfBirth=" + dateOfBirth
				+ ", educationLevel=" + educationLevel + ", employmentStatus=" + employmentStatus + ", firstName="
				+ firstName + ", gender=" + gender + ", lastName=" + lastName + ", maritalStatus=" + maritalStatus
				+ ", middleName=" + middleName + ", mobileNumber=" + mobileNumber + ", occupation=" + occupation
				+ ", status=" + status + ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", modifiedBy="
				+ modifiedBy + ", modifiedTime=" + modifiedTime + ", isActive=" + isActive + ", isDelete=" + isDelete
				+ ", preArtNumber=" + preArtNumber + ", artNumber=" + artNumber + ", address=" + address
				+ ", hivTypeId=" + hivTypeId + ", hivStatusId=" + hivStatusId + ", maritalStatusId=" + maritalStatusId
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
				+ ", otherEmploymentStatus=" + otherEmploymentStatus + ", beneficiaryActivityStatus="
				+ beneficiaryActivityStatus + ", ictcBeneficiary=" + ictcBeneficiary + ", tiBeneficiary=" + tiBeneficiary + "]";
	}

}
