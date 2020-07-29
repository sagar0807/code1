package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the beneficiary database table.
 * 
 */
@Entity
@NamedQuery(name="Beneficiary.findAll", query="SELECT b FROM Beneficiary b")
public class Beneficiary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="aadhar_number")
	private String aadharNumber;

	private String age;

	@Column(name="alternate_phonenumber")
	private String alternatePhonenumber;

	@Column(name="art_number")
	private String artNumber;

	@Column(name="bank_account_name")
	private String bankAccountName;

	@Column(name="bank_account_number")
	private String bankAccountNumber;

	@Column(name="bank_ifsc")
	private String bankIfsc;

	@Column(name="beneficiary_activity_status")
	private String beneficiaryActivityStatus;

	@Column(name="beneficiary_type")
	private String beneficiaryType;

	@Column(name="birth_history_id")
	private Integer birthHistoryId;

	@Column(name="birth_weight")
	private Integer birthWeight;

	@Column(name="caregiver_address_id")
	private Integer caregiverAddressId;

	@Column(name="caregiver_name")
	private String caregiverName;

	@Column(name="caregiver_phone_number")
	private String caregiverPhoneNumber;

	private String category;

	@Column(name="category_id")
	private Integer categoryId;

	@Column(name="client_status")
	private String clientStatus;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	@Temporal(TemporalType.DATE)
	@Column(name="death_date")
	private Date deathDate;

	@Column(name="death_reason")
	private String deathReason;

	@Column(name="education_level")
	private String educationLevel;

	@Column(name="employment_status")
	private String employmentStatus;

	@Column(name="first_name")
	private String firstName;

	private String gender;

	@Column(name="guardian_caregiver_highest_education_id")
	private Integer guardianCaregiverHighestEducationId;

	@Column(name="guardian_caregiver_name")
	private String guardianCaregiverName;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="last_name")
	private String lastName;

	@Column(name="marital_status")
	private String maritalStatus;

	@Column(name="marital_status_id")
	private Integer maritalStatusId;

	@Column(name="middle_name")
	private String middleName;

	@Column(name="mobile_number")
	private String mobileNumber;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="neo_natal_complications")
	private String neoNatalComplications;

	private String occupation;

	@Column(name="other_employment_status")
	private String otherEmploymentStatus;

	@Column(name="pre_art_number")
	private String preArtNumber;

	private String status;

	@Column(name="staying_with_id")
	private Integer stayingWithId;

	private String uid;

	//bi-directional many-to-one association to ArtBeneficiary
	@OneToMany(mappedBy="beneficiary1")
	private Set<ArtBeneficiary> artBeneficiaries1;

	//bi-directional many-to-one association to ArtBeneficiary
	@OneToMany(mappedBy="beneficiary2")
	private Set<ArtBeneficiary> artBeneficiaries2;

	//bi-directional many-to-one association to ArtBeneficiaryClinicalDetail
	@OneToMany(mappedBy="beneficiary")
	private Set<ArtBeneficiaryClinicalDetail> artBeneficiaryClinicalDetails;

	//bi-directional many-to-one association to ArtBeneficiaryCounsellingNote
	@OneToMany(mappedBy="beneficiary")
	private Set<ArtBeneficiaryCounsellingNote> artBeneficiaryCounsellingNotes;

	//bi-directional many-to-one association to ArtBeneficiaryDueList
	@OneToMany(mappedBy="beneficiary")
	private Set<ArtBeneficiaryDueList> artBeneficiaryDueLists;

	//bi-directional many-to-one association to ArtBeneficiaryFollowup
	@OneToMany(mappedBy="beneficiary")
	private Set<ArtBeneficiaryFollowup> artBeneficiaryFollowups;

	//bi-directional many-to-one association to ArtBeneficiaryImmunizationReport
	@OneToMany(mappedBy="beneficiary")
	private Set<ArtBeneficiaryImmunizationReport> artBeneficiaryImmunizationReports;

	//bi-directional many-to-one association to ArtBeneficiaryInvestigation
	@OneToMany(mappedBy="beneficiary")
	private Set<ArtBeneficiaryInvestigation> artBeneficiaryInvestigations;

	//bi-directional many-to-one association to ArtBeneficiaryIptAttDetail
	@OneToMany(mappedBy="beneficiary")
	private Set<ArtBeneficiaryIptAttDetail> artBeneficiaryIptAttDetails;

	//bi-directional many-to-one association to ArtBeneficiaryQueue
	@OneToMany(mappedBy="beneficiary")
	private Set<ArtBeneficiaryQueue> artBeneficiaryQueues;

	//bi-directional many-to-one association to ArtDispensation
	@OneToMany(mappedBy="beneficiary")
	private Set<ArtDispensation> artDispensations;

	//bi-directional many-to-one association to Address
	@ManyToOne
	private Address address;

	//bi-directional many-to-one association to MasterClientStatus
	@ManyToOne
	@JoinColumn(name="client_status_id")
	private MasterClientStatus masterClientStatus;

	//bi-directional many-to-one association to MasterEducationLevel
	@ManyToOne
	@JoinColumn(name="education_level_id")
	private MasterEducationLevel masterEducationLevel;

	//bi-directional many-to-one association to MasterEmploymentStatus
	@ManyToOne
	@JoinColumn(name="employment_status_id")
	private MasterEmploymentStatus masterEmploymentStatus;

	//bi-directional many-to-one association to MasterGender
	@ManyToOne
	@JoinColumn(name="gender_id")
	private MasterGender masterGender;

	//bi-directional many-to-one association to MasterHivStatus
	@ManyToOne
	@JoinColumn(name="hiv_status_id")
	private MasterHivStatus masterHivStatus;

	//bi-directional many-to-one association to MasterHivType
	@ManyToOne
	@JoinColumn(name="hiv_type_id")
	private MasterHivType masterHivType;

	//bi-directional many-to-one association to MasterMonthlyIncome
	@ManyToOne
	@JoinColumn(name="monthly_income")
	private MasterMonthlyIncome masterMonthlyIncome;

	//bi-directional many-to-one association to MasterOccupation
	@ManyToOne
	@JoinColumn(name="occupation_id")
	private MasterOccupation masterOccupation;

	//bi-directional many-to-one association to BeneficiaryFacilityMapping
	@OneToMany(mappedBy="beneficiary")
	private Set<BeneficiaryFacilityMapping> beneficiaryFacilityMappings;

	//bi-directional many-to-one association to BeneficiaryFamilyDetail
	@OneToMany(mappedBy="beneficiary1")
	private Set<BeneficiaryFamilyDetail> beneficiaryFamilyDetails1;

	//bi-directional many-to-one association to BeneficiaryFamilyDetail
	@OneToMany(mappedBy="beneficiary2")
	private Set<BeneficiaryFamilyDetail> beneficiaryFamilyDetails2;

	//bi-directional many-to-one association to BeneficiaryReferral
	@OneToMany(mappedBy="beneficiary")
	private Set<BeneficiaryReferral> beneficiaryReferrals;

	//bi-directional many-to-one association to BeneficiarySocialWelfareScheme
	@OneToMany(mappedBy="beneficiary")
	private Set<BeneficiarySocialWelfareScheme> beneficiarySocialWelfareSchemes;

	//bi-directional many-to-one association to BeneficiaryTransitFacility
	@OneToMany(mappedBy="beneficiary")
	private Set<BeneficiaryTransitFacility> beneficiaryTransitFacilities;

	//bi-directional many-to-one association to BeneficiaryVisitRegister
	@OneToMany(mappedBy="beneficiary")
	private Set<BeneficiaryVisitRegister> beneficiaryVisitRegisters;

	//bi-directional many-to-one association to FacilityLinkedFacilityBeneficiary
	@OneToMany(mappedBy="beneficiary")
	private Set<FacilityLinkedFacilityBeneficiary> facilityLinkedFacilityBeneficiaries;

	//bi-directional many-to-one association to IctcBeneficiary
	@OneToMany(mappedBy="beneficiary")
	private Set<IctcBeneficiary> ictcBeneficiaries;

	//bi-directional many-to-one association to IctcDetail
	@OneToMany(mappedBy="beneficiary")
	private Set<IctcDetail> ictcDetails;

	//bi-directional many-to-one association to LabTestSample
	@OneToMany(mappedBy="beneficiary")
	private Set<LabTestSample> labTestSamples;

	//bi-directional many-to-one association to Referral
	@OneToMany(mappedBy="beneficiary")
	private Set<Referral> referrals;

	//bi-directional many-to-one association to TiBenChildDetail
	@OneToMany(mappedBy="beneficiary")
	private Set<TiBenChildDetail> tiBenChildDetails;

	//bi-directional many-to-one association to TiBenCounselling
	@OneToMany(mappedBy="beneficiary")
	private Set<TiBenCounselling> tiBenCounsellings;

	//bi-directional many-to-one association to TiBenExtDetail
	@OneToMany(mappedBy="beneficiary")
	private Set<TiBenExtDetail> tiBenExtDetails;

	//bi-directional many-to-one association to TiBenFollowUp
	@OneToMany(mappedBy="beneficiary")
	private Set<TiBenFollowUp> tiBenFollowUps;

	//bi-directional many-to-one association to TiBenPresc
	@OneToMany(mappedBy="beneficiary")
	private Set<TiBenPresc> tiBenPrescs;

	//bi-directional many-to-one association to TiBenReferral
	@OneToMany(mappedBy="beneficiary")
	private Set<TiBenReferral> tiBenReferrals;

	//bi-directional many-to-one association to TiBenRvAssessment
	@OneToMany(mappedBy="beneficiary")
	private Set<TiBenRvAssessment> tiBenRvAssessments;

	//bi-directional many-to-one association to TiBenScrDetail
	@OneToMany(mappedBy="beneficiary")
	private Set<TiBenScrDetail> tiBenScrDetails;

	//bi-directional many-to-one association to TiBeneficiary
	@OneToMany(mappedBy="beneficiary")
	private Set<TiBeneficiary> tiBeneficiaries;

	//bi-directional many-to-one association to TiBeneficiaryCommDi
	@OneToMany(mappedBy="beneficiary")
	private Set<TiBeneficiaryCommDi> tiBeneficiaryCommDis;

	//bi-directional many-to-one association to TiCoreBeneficiary
	@OneToMany(mappedBy="beneficiary")
	private Set<TiCoreBeneficiary> tiCoreBeneficiaries;

	//bi-directional many-to-one association to TiOstBeneficiary
	@OneToMany(mappedBy="beneficiary")
	private Set<TiOstBeneficiary> tiOstBeneficiaries;

	//bi-directional many-to-one association to TiOstDetail
	@OneToMany(mappedBy="beneficiary")
	private Set<TiOstDetail> tiOstDetails;

	//bi-directional many-to-one association to TiOstDrugDispensation
	@OneToMany(mappedBy="beneficiary")
	private Set<TiOstDrugDispensation> tiOstDrugDispensations;

	//bi-directional many-to-one association to TiStiTreatment
	@OneToMany(mappedBy="beneficiary")
	private Set<TiStiTreatment> tiStiTreatments;

	//bi-directional many-to-one association to Transfer
	@OneToMany(mappedBy="beneficiary")
	private Set<Transfer> transfers;

	//bi-directional many-to-one association to ArtBeneficiaryDnaPcrResult
	@OneToMany(mappedBy="beneficiary")
	private Set<ArtBeneficiaryDnaPcrResult> artBeneficiaryDnaPcrResults;

	//bi-directional many-to-one association to ArtBeneficiaryLinkagePurpos
	@OneToMany(mappedBy="beneficiary")
	private Set<ArtBeneficiaryLinkagePurpos> artBeneficiaryLinkagePurposes;

	//bi-directional many-to-one association to ArtBeneficiaryVitaminA
	@OneToMany(mappedBy="beneficiary")
	private Set<ArtBeneficiaryVitaminA> artBeneficiaryVitaminAs;

	public Beneficiary() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAadharNumber() {
		return this.aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAlternatePhonenumber() {
		return this.alternatePhonenumber;
	}

	public void setAlternatePhonenumber(String alternatePhonenumber) {
		this.alternatePhonenumber = alternatePhonenumber;
	}

	public String getArtNumber() {
		return this.artNumber;
	}

	public void setArtNumber(String artNumber) {
		this.artNumber = artNumber;
	}

	public String getBankAccountName() {
		return this.bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	public String getBankAccountNumber() {
		return this.bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankIfsc() {
		return this.bankIfsc;
	}

	public void setBankIfsc(String bankIfsc) {
		this.bankIfsc = bankIfsc;
	}

	public String getBeneficiaryActivityStatus() {
		return this.beneficiaryActivityStatus;
	}

	public void setBeneficiaryActivityStatus(String beneficiaryActivityStatus) {
		this.beneficiaryActivityStatus = beneficiaryActivityStatus;
	}

	public String getBeneficiaryType() {
		return this.beneficiaryType;
	}

	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}

	public Integer getBirthHistoryId() {
		return this.birthHistoryId;
	}

	public void setBirthHistoryId(Integer birthHistoryId) {
		this.birthHistoryId = birthHistoryId;
	}

	public Integer getBirthWeight() {
		return this.birthWeight;
	}

	public void setBirthWeight(Integer birthWeight) {
		this.birthWeight = birthWeight;
	}

	public Integer getCaregiverAddressId() {
		return this.caregiverAddressId;
	}

	public void setCaregiverAddressId(Integer caregiverAddressId) {
		this.caregiverAddressId = caregiverAddressId;
	}

	public String getCaregiverName() {
		return this.caregiverName;
	}

	public void setCaregiverName(String caregiverName) {
		this.caregiverName = caregiverName;
	}

	public String getCaregiverPhoneNumber() {
		return this.caregiverPhoneNumber;
	}

	public void setCaregiverPhoneNumber(String caregiverPhoneNumber) {
		this.caregiverPhoneNumber = caregiverPhoneNumber;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getClientStatus() {
		return this.clientStatus;
	}

	public void setClientStatus(String clientStatus) {
		this.clientStatus = clientStatus;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDeathDate() {
		return this.deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public String getDeathReason() {
		return this.deathReason;
	}

	public void setDeathReason(String deathReason) {
		this.deathReason = deathReason;
	}

	public String getEducationLevel() {
		return this.educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public String getEmploymentStatus() {
		return this.employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getGuardianCaregiverHighestEducationId() {
		return this.guardianCaregiverHighestEducationId;
	}

	public void setGuardianCaregiverHighestEducationId(Integer guardianCaregiverHighestEducationId) {
		this.guardianCaregiverHighestEducationId = guardianCaregiverHighestEducationId;
	}

	public String getGuardianCaregiverName() {
		return this.guardianCaregiverName;
	}

	public void setGuardianCaregiverName(String guardianCaregiverName) {
		this.guardianCaregiverName = guardianCaregiverName;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Integer getMaritalStatusId() {
		return this.maritalStatusId;
	}

	public void setMaritalStatusId(Integer maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Integer getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getNeoNatalComplications() {
		return this.neoNatalComplications;
	}

	public void setNeoNatalComplications(String neoNatalComplications) {
		this.neoNatalComplications = neoNatalComplications;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getOtherEmploymentStatus() {
		return this.otherEmploymentStatus;
	}

	public void setOtherEmploymentStatus(String otherEmploymentStatus) {
		this.otherEmploymentStatus = otherEmploymentStatus;
	}

	public String getPreArtNumber() {
		return this.preArtNumber;
	}

	public void setPreArtNumber(String preArtNumber) {
		this.preArtNumber = preArtNumber;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getStayingWithId() {
		return this.stayingWithId;
	}

	public void setStayingWithId(Integer stayingWithId) {
		this.stayingWithId = stayingWithId;
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Set<ArtBeneficiary> getArtBeneficiaries1() {
		return this.artBeneficiaries1;
	}

	public void setArtBeneficiaries1(Set<ArtBeneficiary> artBeneficiaries1) {
		this.artBeneficiaries1 = artBeneficiaries1;
	}

	public ArtBeneficiary addArtBeneficiaries1(ArtBeneficiary artBeneficiaries1) {
		getArtBeneficiaries1().add(artBeneficiaries1);
		artBeneficiaries1.setBeneficiary1(this);

		return artBeneficiaries1;
	}

	public ArtBeneficiary removeArtBeneficiaries1(ArtBeneficiary artBeneficiaries1) {
		getArtBeneficiaries1().remove(artBeneficiaries1);
		artBeneficiaries1.setBeneficiary1(null);

		return artBeneficiaries1;
	}

	public Set<ArtBeneficiary> getArtBeneficiaries2() {
		return this.artBeneficiaries2;
	}

	public void setArtBeneficiaries2(Set<ArtBeneficiary> artBeneficiaries2) {
		this.artBeneficiaries2 = artBeneficiaries2;
	}

	public ArtBeneficiary addArtBeneficiaries2(ArtBeneficiary artBeneficiaries2) {
		getArtBeneficiaries2().add(artBeneficiaries2);
		artBeneficiaries2.setBeneficiary2(this);

		return artBeneficiaries2;
	}

	public ArtBeneficiary removeArtBeneficiaries2(ArtBeneficiary artBeneficiaries2) {
		getArtBeneficiaries2().remove(artBeneficiaries2);
		artBeneficiaries2.setBeneficiary2(null);

		return artBeneficiaries2;
	}

	public Set<ArtBeneficiaryClinicalDetail> getArtBeneficiaryClinicalDetails() {
		return this.artBeneficiaryClinicalDetails;
	}

	public void setArtBeneficiaryClinicalDetails(Set<ArtBeneficiaryClinicalDetail> artBeneficiaryClinicalDetails) {
		this.artBeneficiaryClinicalDetails = artBeneficiaryClinicalDetails;
	}

	public ArtBeneficiaryClinicalDetail addArtBeneficiaryClinicalDetail(ArtBeneficiaryClinicalDetail artBeneficiaryClinicalDetail) {
		getArtBeneficiaryClinicalDetails().add(artBeneficiaryClinicalDetail);
		artBeneficiaryClinicalDetail.setBeneficiary(this);

		return artBeneficiaryClinicalDetail;
	}

	public ArtBeneficiaryClinicalDetail removeArtBeneficiaryClinicalDetail(ArtBeneficiaryClinicalDetail artBeneficiaryClinicalDetail) {
		getArtBeneficiaryClinicalDetails().remove(artBeneficiaryClinicalDetail);
		artBeneficiaryClinicalDetail.setBeneficiary(null);

		return artBeneficiaryClinicalDetail;
	}

	public Set<ArtBeneficiaryCounsellingNote> getArtBeneficiaryCounsellingNotes() {
		return this.artBeneficiaryCounsellingNotes;
	}

	public void setArtBeneficiaryCounsellingNotes(Set<ArtBeneficiaryCounsellingNote> artBeneficiaryCounsellingNotes) {
		this.artBeneficiaryCounsellingNotes = artBeneficiaryCounsellingNotes;
	}

	public ArtBeneficiaryCounsellingNote addArtBeneficiaryCounsellingNote(ArtBeneficiaryCounsellingNote artBeneficiaryCounsellingNote) {
		getArtBeneficiaryCounsellingNotes().add(artBeneficiaryCounsellingNote);
		artBeneficiaryCounsellingNote.setBeneficiary(this);

		return artBeneficiaryCounsellingNote;
	}

	public ArtBeneficiaryCounsellingNote removeArtBeneficiaryCounsellingNote(ArtBeneficiaryCounsellingNote artBeneficiaryCounsellingNote) {
		getArtBeneficiaryCounsellingNotes().remove(artBeneficiaryCounsellingNote);
		artBeneficiaryCounsellingNote.setBeneficiary(null);

		return artBeneficiaryCounsellingNote;
	}

	public Set<ArtBeneficiaryDueList> getArtBeneficiaryDueLists() {
		return this.artBeneficiaryDueLists;
	}

	public void setArtBeneficiaryDueLists(Set<ArtBeneficiaryDueList> artBeneficiaryDueLists) {
		this.artBeneficiaryDueLists = artBeneficiaryDueLists;
	}

	public ArtBeneficiaryDueList addArtBeneficiaryDueList(ArtBeneficiaryDueList artBeneficiaryDueList) {
		getArtBeneficiaryDueLists().add(artBeneficiaryDueList);
		artBeneficiaryDueList.setBeneficiary(this);

		return artBeneficiaryDueList;
	}

	public ArtBeneficiaryDueList removeArtBeneficiaryDueList(ArtBeneficiaryDueList artBeneficiaryDueList) {
		getArtBeneficiaryDueLists().remove(artBeneficiaryDueList);
		artBeneficiaryDueList.setBeneficiary(null);

		return artBeneficiaryDueList;
	}

	public Set<ArtBeneficiaryFollowup> getArtBeneficiaryFollowups() {
		return this.artBeneficiaryFollowups;
	}

	public void setArtBeneficiaryFollowups(Set<ArtBeneficiaryFollowup> artBeneficiaryFollowups) {
		this.artBeneficiaryFollowups = artBeneficiaryFollowups;
	}

	public ArtBeneficiaryFollowup addArtBeneficiaryFollowup(ArtBeneficiaryFollowup artBeneficiaryFollowup) {
		getArtBeneficiaryFollowups().add(artBeneficiaryFollowup);
		artBeneficiaryFollowup.setBeneficiary(this);

		return artBeneficiaryFollowup;
	}

	public ArtBeneficiaryFollowup removeArtBeneficiaryFollowup(ArtBeneficiaryFollowup artBeneficiaryFollowup) {
		getArtBeneficiaryFollowups().remove(artBeneficiaryFollowup);
		artBeneficiaryFollowup.setBeneficiary(null);

		return artBeneficiaryFollowup;
	}

	public Set<ArtBeneficiaryImmunizationReport> getArtBeneficiaryImmunizationReports() {
		return this.artBeneficiaryImmunizationReports;
	}

	public void setArtBeneficiaryImmunizationReports(Set<ArtBeneficiaryImmunizationReport> artBeneficiaryImmunizationReports) {
		this.artBeneficiaryImmunizationReports = artBeneficiaryImmunizationReports;
	}

	public ArtBeneficiaryImmunizationReport addArtBeneficiaryImmunizationReport(ArtBeneficiaryImmunizationReport artBeneficiaryImmunizationReport) {
		getArtBeneficiaryImmunizationReports().add(artBeneficiaryImmunizationReport);
		artBeneficiaryImmunizationReport.setBeneficiary(this);

		return artBeneficiaryImmunizationReport;
	}

	public ArtBeneficiaryImmunizationReport removeArtBeneficiaryImmunizationReport(ArtBeneficiaryImmunizationReport artBeneficiaryImmunizationReport) {
		getArtBeneficiaryImmunizationReports().remove(artBeneficiaryImmunizationReport);
		artBeneficiaryImmunizationReport.setBeneficiary(null);

		return artBeneficiaryImmunizationReport;
	}

	public Set<ArtBeneficiaryInvestigation> getArtBeneficiaryInvestigations() {
		return this.artBeneficiaryInvestigations;
	}

	public void setArtBeneficiaryInvestigations(Set<ArtBeneficiaryInvestigation> artBeneficiaryInvestigations) {
		this.artBeneficiaryInvestigations = artBeneficiaryInvestigations;
	}

	public ArtBeneficiaryInvestigation addArtBeneficiaryInvestigation(ArtBeneficiaryInvestigation artBeneficiaryInvestigation) {
		getArtBeneficiaryInvestigations().add(artBeneficiaryInvestigation);
		artBeneficiaryInvestigation.setBeneficiary(this);

		return artBeneficiaryInvestigation;
	}

	public ArtBeneficiaryInvestigation removeArtBeneficiaryInvestigation(ArtBeneficiaryInvestigation artBeneficiaryInvestigation) {
		getArtBeneficiaryInvestigations().remove(artBeneficiaryInvestigation);
		artBeneficiaryInvestigation.setBeneficiary(null);

		return artBeneficiaryInvestigation;
	}

	public Set<ArtBeneficiaryIptAttDetail> getArtBeneficiaryIptAttDetails() {
		return this.artBeneficiaryIptAttDetails;
	}

	public void setArtBeneficiaryIptAttDetails(Set<ArtBeneficiaryIptAttDetail> artBeneficiaryIptAttDetails) {
		this.artBeneficiaryIptAttDetails = artBeneficiaryIptAttDetails;
	}

	public ArtBeneficiaryIptAttDetail addArtBeneficiaryIptAttDetail(ArtBeneficiaryIptAttDetail artBeneficiaryIptAttDetail) {
		getArtBeneficiaryIptAttDetails().add(artBeneficiaryIptAttDetail);
		artBeneficiaryIptAttDetail.setBeneficiary(this);

		return artBeneficiaryIptAttDetail;
	}

	public ArtBeneficiaryIptAttDetail removeArtBeneficiaryIptAttDetail(ArtBeneficiaryIptAttDetail artBeneficiaryIptAttDetail) {
		getArtBeneficiaryIptAttDetails().remove(artBeneficiaryIptAttDetail);
		artBeneficiaryIptAttDetail.setBeneficiary(null);

		return artBeneficiaryIptAttDetail;
	}

	public Set<ArtBeneficiaryQueue> getArtBeneficiaryQueues() {
		return this.artBeneficiaryQueues;
	}

	public void setArtBeneficiaryQueues(Set<ArtBeneficiaryQueue> artBeneficiaryQueues) {
		this.artBeneficiaryQueues = artBeneficiaryQueues;
	}

	public ArtBeneficiaryQueue addArtBeneficiaryQueue(ArtBeneficiaryQueue artBeneficiaryQueue) {
		getArtBeneficiaryQueues().add(artBeneficiaryQueue);
		artBeneficiaryQueue.setBeneficiary(this);

		return artBeneficiaryQueue;
	}

	public ArtBeneficiaryQueue removeArtBeneficiaryQueue(ArtBeneficiaryQueue artBeneficiaryQueue) {
		getArtBeneficiaryQueues().remove(artBeneficiaryQueue);
		artBeneficiaryQueue.setBeneficiary(null);

		return artBeneficiaryQueue;
	}

	public Set<ArtDispensation> getArtDispensations() {
		return this.artDispensations;
	}

	public void setArtDispensations(Set<ArtDispensation> artDispensations) {
		this.artDispensations = artDispensations;
	}

	public ArtDispensation addArtDispensation(ArtDispensation artDispensation) {
		getArtDispensations().add(artDispensation);
		artDispensation.setBeneficiary(this);

		return artDispensation;
	}

	public ArtDispensation removeArtDispensation(ArtDispensation artDispensation) {
		getArtDispensations().remove(artDispensation);
		artDispensation.setBeneficiary(null);

		return artDispensation;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public MasterClientStatus getMasterClientStatus() {
		return this.masterClientStatus;
	}

	public void setMasterClientStatus(MasterClientStatus masterClientStatus) {
		this.masterClientStatus = masterClientStatus;
	}

	public MasterEducationLevel getMasterEducationLevel() {
		return this.masterEducationLevel;
	}

	public void setMasterEducationLevel(MasterEducationLevel masterEducationLevel) {
		this.masterEducationLevel = masterEducationLevel;
	}

	public MasterEmploymentStatus getMasterEmploymentStatus() {
		return this.masterEmploymentStatus;
	}

	public void setMasterEmploymentStatus(MasterEmploymentStatus masterEmploymentStatus) {
		this.masterEmploymentStatus = masterEmploymentStatus;
	}

	public MasterGender getMasterGender() {
		return this.masterGender;
	}

	public void setMasterGender(MasterGender masterGender) {
		this.masterGender = masterGender;
	}

	public MasterHivStatus getMasterHivStatus() {
		return this.masterHivStatus;
	}

	public void setMasterHivStatus(MasterHivStatus masterHivStatus) {
		this.masterHivStatus = masterHivStatus;
	}

	public MasterHivType getMasterHivType() {
		return this.masterHivType;
	}

	public void setMasterHivType(MasterHivType masterHivType) {
		this.masterHivType = masterHivType;
	}

	public MasterMonthlyIncome getMasterMonthlyIncome() {
		return this.masterMonthlyIncome;
	}

	public void setMasterMonthlyIncome(MasterMonthlyIncome masterMonthlyIncome) {
		this.masterMonthlyIncome = masterMonthlyIncome;
	}

	public MasterOccupation getMasterOccupation() {
		return this.masterOccupation;
	}

	public void setMasterOccupation(MasterOccupation masterOccupation) {
		this.masterOccupation = masterOccupation;
	}


	public Set<BeneficiaryFacilityMapping> getBeneficiaryFacilityMappings() {
		return this.beneficiaryFacilityMappings;
	}

	public void setBeneficiaryFacilityMappings(Set<BeneficiaryFacilityMapping> beneficiaryFacilityMappings) {
		this.beneficiaryFacilityMappings = beneficiaryFacilityMappings;
	}

	public BeneficiaryFacilityMapping addBeneficiaryFacilityMapping(BeneficiaryFacilityMapping beneficiaryFacilityMapping) {
		getBeneficiaryFacilityMappings().add(beneficiaryFacilityMapping);
		beneficiaryFacilityMapping.setBeneficiary(this);

		return beneficiaryFacilityMapping;
	}

	public BeneficiaryFacilityMapping removeBeneficiaryFacilityMapping(BeneficiaryFacilityMapping beneficiaryFacilityMapping) {
		getBeneficiaryFacilityMappings().remove(beneficiaryFacilityMapping);
		beneficiaryFacilityMapping.setBeneficiary(null);

		return beneficiaryFacilityMapping;
	}

	public Set<BeneficiaryFamilyDetail> getBeneficiaryFamilyDetails1() {
		return this.beneficiaryFamilyDetails1;
	}

	public void setBeneficiaryFamilyDetails1(Set<BeneficiaryFamilyDetail> beneficiaryFamilyDetails1) {
		this.beneficiaryFamilyDetails1 = beneficiaryFamilyDetails1;
	}

	public BeneficiaryFamilyDetail addBeneficiaryFamilyDetails1(BeneficiaryFamilyDetail beneficiaryFamilyDetails1) {
		getBeneficiaryFamilyDetails1().add(beneficiaryFamilyDetails1);
		beneficiaryFamilyDetails1.setBeneficiary1(this);

		return beneficiaryFamilyDetails1;
	}

	public BeneficiaryFamilyDetail removeBeneficiaryFamilyDetails1(BeneficiaryFamilyDetail beneficiaryFamilyDetails1) {
		getBeneficiaryFamilyDetails1().remove(beneficiaryFamilyDetails1);
		beneficiaryFamilyDetails1.setBeneficiary1(null);

		return beneficiaryFamilyDetails1;
	}

	public Set<BeneficiaryFamilyDetail> getBeneficiaryFamilyDetails2() {
		return this.beneficiaryFamilyDetails2;
	}

	public void setBeneficiaryFamilyDetails2(Set<BeneficiaryFamilyDetail> beneficiaryFamilyDetails2) {
		this.beneficiaryFamilyDetails2 = beneficiaryFamilyDetails2;
	}

	public BeneficiaryFamilyDetail addBeneficiaryFamilyDetails2(BeneficiaryFamilyDetail beneficiaryFamilyDetails2) {
		getBeneficiaryFamilyDetails2().add(beneficiaryFamilyDetails2);
		beneficiaryFamilyDetails2.setBeneficiary2(this);

		return beneficiaryFamilyDetails2;
	}

	public BeneficiaryFamilyDetail removeBeneficiaryFamilyDetails2(BeneficiaryFamilyDetail beneficiaryFamilyDetails2) {
		getBeneficiaryFamilyDetails2().remove(beneficiaryFamilyDetails2);
		beneficiaryFamilyDetails2.setBeneficiary2(null);

		return beneficiaryFamilyDetails2;
	}

	public Set<BeneficiaryReferral> getBeneficiaryReferrals() {
		return this.beneficiaryReferrals;
	}

	public void setBeneficiaryReferrals(Set<BeneficiaryReferral> beneficiaryReferrals) {
		this.beneficiaryReferrals = beneficiaryReferrals;
	}

	public BeneficiaryReferral addBeneficiaryReferral(BeneficiaryReferral beneficiaryReferral) {
		getBeneficiaryReferrals().add(beneficiaryReferral);
		beneficiaryReferral.setBeneficiary(this);

		return beneficiaryReferral;
	}

	public BeneficiaryReferral removeBeneficiaryReferral(BeneficiaryReferral beneficiaryReferral) {
		getBeneficiaryReferrals().remove(beneficiaryReferral);
		beneficiaryReferral.setBeneficiary(null);

		return beneficiaryReferral;
	}

	public Set<BeneficiarySocialWelfareScheme> getBeneficiarySocialWelfareSchemes() {
		return this.beneficiarySocialWelfareSchemes;
	}

	public void setBeneficiarySocialWelfareSchemes(Set<BeneficiarySocialWelfareScheme> beneficiarySocialWelfareSchemes) {
		this.beneficiarySocialWelfareSchemes = beneficiarySocialWelfareSchemes;
	}

	public BeneficiarySocialWelfareScheme addBeneficiarySocialWelfareScheme(BeneficiarySocialWelfareScheme beneficiarySocialWelfareScheme) {
		getBeneficiarySocialWelfareSchemes().add(beneficiarySocialWelfareScheme);
		beneficiarySocialWelfareScheme.setBeneficiary(this);

		return beneficiarySocialWelfareScheme;
	}

	public BeneficiarySocialWelfareScheme removeBeneficiarySocialWelfareScheme(BeneficiarySocialWelfareScheme beneficiarySocialWelfareScheme) {
		getBeneficiarySocialWelfareSchemes().remove(beneficiarySocialWelfareScheme);
		beneficiarySocialWelfareScheme.setBeneficiary(null);

		return beneficiarySocialWelfareScheme;
	}

	public Set<BeneficiaryTransitFacility> getBeneficiaryTransitFacilities() {
		return this.beneficiaryTransitFacilities;
	}

	public void setBeneficiaryTransitFacilities(Set<BeneficiaryTransitFacility> beneficiaryTransitFacilities) {
		this.beneficiaryTransitFacilities = beneficiaryTransitFacilities;
	}

	public BeneficiaryTransitFacility addBeneficiaryTransitFacility(BeneficiaryTransitFacility beneficiaryTransitFacility) {
		getBeneficiaryTransitFacilities().add(beneficiaryTransitFacility);
		beneficiaryTransitFacility.setBeneficiary(this);

		return beneficiaryTransitFacility;
	}

	public BeneficiaryTransitFacility removeBeneficiaryTransitFacility(BeneficiaryTransitFacility beneficiaryTransitFacility) {
		getBeneficiaryTransitFacilities().remove(beneficiaryTransitFacility);
		beneficiaryTransitFacility.setBeneficiary(null);

		return beneficiaryTransitFacility;
	}

	public Set<BeneficiaryVisitRegister> getBeneficiaryVisitRegisters() {
		return this.beneficiaryVisitRegisters;
	}

	public void setBeneficiaryVisitRegisters(Set<BeneficiaryVisitRegister> beneficiaryVisitRegisters) {
		this.beneficiaryVisitRegisters = beneficiaryVisitRegisters;
	}

	public BeneficiaryVisitRegister addBeneficiaryVisitRegister(BeneficiaryVisitRegister beneficiaryVisitRegister) {
		getBeneficiaryVisitRegisters().add(beneficiaryVisitRegister);
		beneficiaryVisitRegister.setBeneficiary(this);

		return beneficiaryVisitRegister;
	}

	public BeneficiaryVisitRegister removeBeneficiaryVisitRegister(BeneficiaryVisitRegister beneficiaryVisitRegister) {
		getBeneficiaryVisitRegisters().remove(beneficiaryVisitRegister);
		beneficiaryVisitRegister.setBeneficiary(null);

		return beneficiaryVisitRegister;
	}

	public Set<FacilityLinkedFacilityBeneficiary> getFacilityLinkedFacilityBeneficiaries() {
		return this.facilityLinkedFacilityBeneficiaries;
	}

	public void setFacilityLinkedFacilityBeneficiaries(Set<FacilityLinkedFacilityBeneficiary> facilityLinkedFacilityBeneficiaries) {
		this.facilityLinkedFacilityBeneficiaries = facilityLinkedFacilityBeneficiaries;
	}

	public FacilityLinkedFacilityBeneficiary addFacilityLinkedFacilityBeneficiary(FacilityLinkedFacilityBeneficiary facilityLinkedFacilityBeneficiary) {
		getFacilityLinkedFacilityBeneficiaries().add(facilityLinkedFacilityBeneficiary);
		facilityLinkedFacilityBeneficiary.setBeneficiary(this);

		return facilityLinkedFacilityBeneficiary;
	}

	public FacilityLinkedFacilityBeneficiary removeFacilityLinkedFacilityBeneficiary(FacilityLinkedFacilityBeneficiary facilityLinkedFacilityBeneficiary) {
		getFacilityLinkedFacilityBeneficiaries().remove(facilityLinkedFacilityBeneficiary);
		facilityLinkedFacilityBeneficiary.setBeneficiary(null);

		return facilityLinkedFacilityBeneficiary;
	}

	public Set<IctcBeneficiary> getIctcBeneficiaries() {
		return this.ictcBeneficiaries;
	}

	public void setIctcBeneficiaries(Set<IctcBeneficiary> ictcBeneficiaries) {
		this.ictcBeneficiaries = ictcBeneficiaries;
	}

	public IctcBeneficiary addIctcBeneficiary(IctcBeneficiary ictcBeneficiary) {
		getIctcBeneficiaries().add(ictcBeneficiary);
		ictcBeneficiary.setBeneficiary(this);

		return ictcBeneficiary;
	}

	public IctcBeneficiary removeIctcBeneficiary(IctcBeneficiary ictcBeneficiary) {
		getIctcBeneficiaries().remove(ictcBeneficiary);
		ictcBeneficiary.setBeneficiary(null);

		return ictcBeneficiary;
	}

	public Set<IctcDetail> getIctcDetails() {
		return this.ictcDetails;
	}

	public void setIctcDetails(Set<IctcDetail> ictcDetails) {
		this.ictcDetails = ictcDetails;
	}

	public IctcDetail addIctcDetail(IctcDetail ictcDetail) {
		getIctcDetails().add(ictcDetail);
		ictcDetail.setBeneficiary(this);

		return ictcDetail;
	}

	public IctcDetail removeIctcDetail(IctcDetail ictcDetail) {
		getIctcDetails().remove(ictcDetail);
		ictcDetail.setBeneficiary(null);

		return ictcDetail;
	}

	public Set<LabTestSample> getLabTestSamples() {
		return this.labTestSamples;
	}

	public void setLabTestSamples(Set<LabTestSample> labTestSamples) {
		this.labTestSamples = labTestSamples;
	}

	public LabTestSample addLabTestSample(LabTestSample labTestSample) {
		getLabTestSamples().add(labTestSample);
		labTestSample.setBeneficiary(this);

		return labTestSample;
	}

	public LabTestSample removeLabTestSample(LabTestSample labTestSample) {
		getLabTestSamples().remove(labTestSample);
		labTestSample.setBeneficiary(null);

		return labTestSample;
	}


	public Set<Referral> getReferrals() {
		return this.referrals;
	}

	public void setReferrals(Set<Referral> referrals) {
		this.referrals = referrals;
	}

	public Referral addReferral(Referral referral) {
		getReferrals().add(referral);
		referral.setBeneficiary(this);

		return referral;
	}

	public Referral removeReferral(Referral referral) {
		getReferrals().remove(referral);
		referral.setBeneficiary(null);

		return referral;
	}

	public Set<TiBenChildDetail> getTiBenChildDetails() {
		return this.tiBenChildDetails;
	}

	public void setTiBenChildDetails(Set<TiBenChildDetail> tiBenChildDetails) {
		this.tiBenChildDetails = tiBenChildDetails;
	}

	public TiBenChildDetail addTiBenChildDetail(TiBenChildDetail tiBenChildDetail) {
		getTiBenChildDetails().add(tiBenChildDetail);
		tiBenChildDetail.setBeneficiary(this);

		return tiBenChildDetail;
	}

	public TiBenChildDetail removeTiBenChildDetail(TiBenChildDetail tiBenChildDetail) {
		getTiBenChildDetails().remove(tiBenChildDetail);
		tiBenChildDetail.setBeneficiary(null);

		return tiBenChildDetail;
	}

	public Set<TiBenCounselling> getTiBenCounsellings() {
		return this.tiBenCounsellings;
	}

	public void setTiBenCounsellings(Set<TiBenCounselling> tiBenCounsellings) {
		this.tiBenCounsellings = tiBenCounsellings;
	}

	public TiBenCounselling addTiBenCounselling(TiBenCounselling tiBenCounselling) {
		getTiBenCounsellings().add(tiBenCounselling);
		tiBenCounselling.setBeneficiary(this);

		return tiBenCounselling;
	}

	public TiBenCounselling removeTiBenCounselling(TiBenCounselling tiBenCounselling) {
		getTiBenCounsellings().remove(tiBenCounselling);
		tiBenCounselling.setBeneficiary(null);

		return tiBenCounselling;
	}

	public Set<TiBenExtDetail> getTiBenExtDetails() {
		return this.tiBenExtDetails;
	}

	public void setTiBenExtDetails(Set<TiBenExtDetail> tiBenExtDetails) {
		this.tiBenExtDetails = tiBenExtDetails;
	}

	public TiBenExtDetail addTiBenExtDetail(TiBenExtDetail tiBenExtDetail) {
		getTiBenExtDetails().add(tiBenExtDetail);
		tiBenExtDetail.setBeneficiary(this);

		return tiBenExtDetail;
	}

	public TiBenExtDetail removeTiBenExtDetail(TiBenExtDetail tiBenExtDetail) {
		getTiBenExtDetails().remove(tiBenExtDetail);
		tiBenExtDetail.setBeneficiary(null);

		return tiBenExtDetail;
	}

	public Set<TiBenFollowUp> getTiBenFollowUps() {
		return this.tiBenFollowUps;
	}

	public void setTiBenFollowUps(Set<TiBenFollowUp> tiBenFollowUps) {
		this.tiBenFollowUps = tiBenFollowUps;
	}

	public TiBenFollowUp addTiBenFollowUp(TiBenFollowUp tiBenFollowUp) {
		getTiBenFollowUps().add(tiBenFollowUp);
		tiBenFollowUp.setBeneficiary(this);

		return tiBenFollowUp;
	}

	public TiBenFollowUp removeTiBenFollowUp(TiBenFollowUp tiBenFollowUp) {
		getTiBenFollowUps().remove(tiBenFollowUp);
		tiBenFollowUp.setBeneficiary(null);

		return tiBenFollowUp;
	}

	public Set<TiBenPresc> getTiBenPrescs() {
		return this.tiBenPrescs;
	}

	public void setTiBenPrescs(Set<TiBenPresc> tiBenPrescs) {
		this.tiBenPrescs = tiBenPrescs;
	}

	public TiBenPresc addTiBenPresc(TiBenPresc tiBenPresc) {
		getTiBenPrescs().add(tiBenPresc);
		tiBenPresc.setBeneficiary(this);

		return tiBenPresc;
	}

	public TiBenPresc removeTiBenPresc(TiBenPresc tiBenPresc) {
		getTiBenPrescs().remove(tiBenPresc);
		tiBenPresc.setBeneficiary(null);

		return tiBenPresc;
	}

	public Set<TiBenReferral> getTiBenReferrals() {
		return this.tiBenReferrals;
	}

	public void setTiBenReferrals(Set<TiBenReferral> tiBenReferrals) {
		this.tiBenReferrals = tiBenReferrals;
	}

	public TiBenReferral addTiBenReferral(TiBenReferral tiBenReferral) {
		getTiBenReferrals().add(tiBenReferral);
		tiBenReferral.setBeneficiary(this);

		return tiBenReferral;
	}

	public TiBenReferral removeTiBenReferral(TiBenReferral tiBenReferral) {
		getTiBenReferrals().remove(tiBenReferral);
		tiBenReferral.setBeneficiary(null);

		return tiBenReferral;
	}

	public Set<TiBenRvAssessment> getTiBenRvAssessments() {
		return this.tiBenRvAssessments;
	}

	public void setTiBenRvAssessments(Set<TiBenRvAssessment> tiBenRvAssessments) {
		this.tiBenRvAssessments = tiBenRvAssessments;
	}

	public TiBenRvAssessment addTiBenRvAssessment(TiBenRvAssessment tiBenRvAssessment) {
		getTiBenRvAssessments().add(tiBenRvAssessment);
		tiBenRvAssessment.setBeneficiary(this);

		return tiBenRvAssessment;
	}

	public TiBenRvAssessment removeTiBenRvAssessment(TiBenRvAssessment tiBenRvAssessment) {
		getTiBenRvAssessments().remove(tiBenRvAssessment);
		tiBenRvAssessment.setBeneficiary(null);

		return tiBenRvAssessment;
	}

	public Set<TiBenScrDetail> getTiBenScrDetails() {
		return this.tiBenScrDetails;
	}

	public void setTiBenScrDetails(Set<TiBenScrDetail> tiBenScrDetails) {
		this.tiBenScrDetails = tiBenScrDetails;
	}

	public TiBenScrDetail addTiBenScrDetail(TiBenScrDetail tiBenScrDetail) {
		getTiBenScrDetails().add(tiBenScrDetail);
		tiBenScrDetail.setBeneficiary(this);

		return tiBenScrDetail;
	}

	public TiBenScrDetail removeTiBenScrDetail(TiBenScrDetail tiBenScrDetail) {
		getTiBenScrDetails().remove(tiBenScrDetail);
		tiBenScrDetail.setBeneficiary(null);

		return tiBenScrDetail;
	}

	public Set<TiBeneficiary> getTiBeneficiaries() {
		return this.tiBeneficiaries;
	}

	public void setTiBeneficiaries(Set<TiBeneficiary> tiBeneficiaries) {
		this.tiBeneficiaries = tiBeneficiaries;
	}

	public TiBeneficiary addTiBeneficiary(TiBeneficiary tiBeneficiary) {
		getTiBeneficiaries().add(tiBeneficiary);
		tiBeneficiary.setBeneficiary(this);

		return tiBeneficiary;
	}

	public TiBeneficiary removeTiBeneficiary(TiBeneficiary tiBeneficiary) {
		getTiBeneficiaries().remove(tiBeneficiary);
		tiBeneficiary.setBeneficiary(null);

		return tiBeneficiary;
	}

	public Set<TiBeneficiaryCommDi> getTiBeneficiaryCommDis() {
		return this.tiBeneficiaryCommDis;
	}

	public void setTiBeneficiaryCommDis(Set<TiBeneficiaryCommDi> tiBeneficiaryCommDis) {
		this.tiBeneficiaryCommDis = tiBeneficiaryCommDis;
	}

	public TiBeneficiaryCommDi addTiBeneficiaryCommDi(TiBeneficiaryCommDi tiBeneficiaryCommDi) {
		getTiBeneficiaryCommDis().add(tiBeneficiaryCommDi);
		tiBeneficiaryCommDi.setBeneficiary(this);

		return tiBeneficiaryCommDi;
	}

	public TiBeneficiaryCommDi removeTiBeneficiaryCommDi(TiBeneficiaryCommDi tiBeneficiaryCommDi) {
		getTiBeneficiaryCommDis().remove(tiBeneficiaryCommDi);
		tiBeneficiaryCommDi.setBeneficiary(null);

		return tiBeneficiaryCommDi;
	}

	public Set<TiCoreBeneficiary> getTiCoreBeneficiaries() {
		return this.tiCoreBeneficiaries;
	}

	public void setTiCoreBeneficiaries(Set<TiCoreBeneficiary> tiCoreBeneficiaries) {
		this.tiCoreBeneficiaries = tiCoreBeneficiaries;
	}

	public TiCoreBeneficiary addTiCoreBeneficiary(TiCoreBeneficiary tiCoreBeneficiary) {
		getTiCoreBeneficiaries().add(tiCoreBeneficiary);
		tiCoreBeneficiary.setBeneficiary(this);

		return tiCoreBeneficiary;
	}

	public TiCoreBeneficiary removeTiCoreBeneficiary(TiCoreBeneficiary tiCoreBeneficiary) {
		getTiCoreBeneficiaries().remove(tiCoreBeneficiary);
		tiCoreBeneficiary.setBeneficiary(null);

		return tiCoreBeneficiary;
	}

	public Set<TiOstBeneficiary> getTiOstBeneficiaries() {
		return this.tiOstBeneficiaries;
	}

	public void setTiOstBeneficiaries(Set<TiOstBeneficiary> tiOstBeneficiaries) {
		this.tiOstBeneficiaries = tiOstBeneficiaries;
	}

	public TiOstBeneficiary addTiOstBeneficiary(TiOstBeneficiary tiOstBeneficiary) {
		getTiOstBeneficiaries().add(tiOstBeneficiary);
		tiOstBeneficiary.setBeneficiary(this);

		return tiOstBeneficiary;
	}

	public TiOstBeneficiary removeTiOstBeneficiary(TiOstBeneficiary tiOstBeneficiary) {
		getTiOstBeneficiaries().remove(tiOstBeneficiary);
		tiOstBeneficiary.setBeneficiary(null);

		return tiOstBeneficiary;
	}

	public Set<TiOstDetail> getTiOstDetails() {
		return this.tiOstDetails;
	}

	public void setTiOstDetails(Set<TiOstDetail> tiOstDetails) {
		this.tiOstDetails = tiOstDetails;
	}

	public TiOstDetail addTiOstDetail(TiOstDetail tiOstDetail) {
		getTiOstDetails().add(tiOstDetail);
		tiOstDetail.setBeneficiary(this);

		return tiOstDetail;
	}

	public TiOstDetail removeTiOstDetail(TiOstDetail tiOstDetail) {
		getTiOstDetails().remove(tiOstDetail);
		tiOstDetail.setBeneficiary(null);

		return tiOstDetail;
	}

	public Set<TiOstDrugDispensation> getTiOstDrugDispensations() {
		return this.tiOstDrugDispensations;
	}

	public void setTiOstDrugDispensations(Set<TiOstDrugDispensation> tiOstDrugDispensations) {
		this.tiOstDrugDispensations = tiOstDrugDispensations;
	}

	public TiOstDrugDispensation addTiOstDrugDispensation(TiOstDrugDispensation tiOstDrugDispensation) {
		getTiOstDrugDispensations().add(tiOstDrugDispensation);
		tiOstDrugDispensation.setBeneficiary(this);

		return tiOstDrugDispensation;
	}

	public TiOstDrugDispensation removeTiOstDrugDispensation(TiOstDrugDispensation tiOstDrugDispensation) {
		getTiOstDrugDispensations().remove(tiOstDrugDispensation);
		tiOstDrugDispensation.setBeneficiary(null);

		return tiOstDrugDispensation;
	}

	public Set<TiStiTreatment> getTiStiTreatments() {
		return this.tiStiTreatments;
	}

	public void setTiStiTreatments(Set<TiStiTreatment> tiStiTreatments) {
		this.tiStiTreatments = tiStiTreatments;
	}

	public TiStiTreatment addTiStiTreatment(TiStiTreatment tiStiTreatment) {
		getTiStiTreatments().add(tiStiTreatment);
		tiStiTreatment.setBeneficiary(this);

		return tiStiTreatment;
	}

	public TiStiTreatment removeTiStiTreatment(TiStiTreatment tiStiTreatment) {
		getTiStiTreatments().remove(tiStiTreatment);
		tiStiTreatment.setBeneficiary(null);

		return tiStiTreatment;
	}

	public Set<Transfer> getTransfers() {
		return this.transfers;
	}

	public void setTransfers(Set<Transfer> transfers) {
		this.transfers = transfers;
	}

	public Transfer addTransfer(Transfer transfer) {
		getTransfers().add(transfer);
		transfer.setBeneficiary(this);

		return transfer;
	}

	public Transfer removeTransfer(Transfer transfer) {
		getTransfers().remove(transfer);
		transfer.setBeneficiary(null);

		return transfer;
	}

	public Set<ArtBeneficiaryDnaPcrResult> getArtBeneficiaryDnaPcrResults() {
		return this.artBeneficiaryDnaPcrResults;
	}

	public void setArtBeneficiaryDnaPcrResults(Set<ArtBeneficiaryDnaPcrResult> artBeneficiaryDnaPcrResults) {
		this.artBeneficiaryDnaPcrResults = artBeneficiaryDnaPcrResults;
	}

	public ArtBeneficiaryDnaPcrResult addArtBeneficiaryDnaPcrResult(ArtBeneficiaryDnaPcrResult artBeneficiaryDnaPcrResult) {
		getArtBeneficiaryDnaPcrResults().add(artBeneficiaryDnaPcrResult);
		artBeneficiaryDnaPcrResult.setBeneficiary(this);

		return artBeneficiaryDnaPcrResult;
	}

	public ArtBeneficiaryDnaPcrResult removeArtBeneficiaryDnaPcrResult(ArtBeneficiaryDnaPcrResult artBeneficiaryDnaPcrResult) {
		getArtBeneficiaryDnaPcrResults().remove(artBeneficiaryDnaPcrResult);
		artBeneficiaryDnaPcrResult.setBeneficiary(null);

		return artBeneficiaryDnaPcrResult;
	}

	public Set<ArtBeneficiaryLinkagePurpos> getArtBeneficiaryLinkagePurposes() {
		return this.artBeneficiaryLinkagePurposes;
	}

	public void setArtBeneficiaryLinkagePurposes(Set<ArtBeneficiaryLinkagePurpos> artBeneficiaryLinkagePurposes) {
		this.artBeneficiaryLinkagePurposes = artBeneficiaryLinkagePurposes;
	}

	public ArtBeneficiaryLinkagePurpos addArtBeneficiaryLinkagePurpos(ArtBeneficiaryLinkagePurpos artBeneficiaryLinkagePurpos) {
		getArtBeneficiaryLinkagePurposes().add(artBeneficiaryLinkagePurpos);
		artBeneficiaryLinkagePurpos.setBeneficiary(this);

		return artBeneficiaryLinkagePurpos;
	}

	public ArtBeneficiaryLinkagePurpos removeArtBeneficiaryLinkagePurpos(ArtBeneficiaryLinkagePurpos artBeneficiaryLinkagePurpos) {
		getArtBeneficiaryLinkagePurposes().remove(artBeneficiaryLinkagePurpos);
		artBeneficiaryLinkagePurpos.setBeneficiary(null);

		return artBeneficiaryLinkagePurpos;
	}

	public Set<ArtBeneficiaryVitaminA> getArtBeneficiaryVitaminAs() {
		return this.artBeneficiaryVitaminAs;
	}

	public void setArtBeneficiaryVitaminAs(Set<ArtBeneficiaryVitaminA> artBeneficiaryVitaminAs) {
		this.artBeneficiaryVitaminAs = artBeneficiaryVitaminAs;
	}

	public ArtBeneficiaryVitaminA addArtBeneficiaryVitaminA(ArtBeneficiaryVitaminA artBeneficiaryVitaminA) {
		getArtBeneficiaryVitaminAs().add(artBeneficiaryVitaminA);
		artBeneficiaryVitaminA.setBeneficiary(this);

		return artBeneficiaryVitaminA;
	}

	public ArtBeneficiaryVitaminA removeArtBeneficiaryVitaminA(ArtBeneficiaryVitaminA artBeneficiaryVitaminA) {
		getArtBeneficiaryVitaminAs().remove(artBeneficiaryVitaminA);
		artBeneficiaryVitaminA.setBeneficiary(null);

		return artBeneficiaryVitaminA;
	}

}