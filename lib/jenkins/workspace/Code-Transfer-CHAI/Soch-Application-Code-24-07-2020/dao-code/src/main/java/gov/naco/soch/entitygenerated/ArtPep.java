package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the art_pep database table.
 * 
 */
@Entity
@Table(name="art_pep")
@NamedQuery(name="ArtPep.findAll", query="SELECT a FROM ArtPep a")
public class ArtPep implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="baseline_test_conducted_hbv")
	private Boolean baselineTestConductedHbv;

	@Column(name="baseline_test_conducted_hcv")
	private Boolean baselineTestConductedHcv;

	@Column(name="baseline_test_conducted_hiv")
	private Boolean baselineTestConductedHiv;

	@Column(name="consent_taken")
	private Boolean consentTaken;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_accidental_exposure")
	private Date dateOfAccidentalExposure;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	@Column(name="exposed_staff_designation")
	private String exposedStaffDesignation;

	@Column(name="exposed_staff_name")
	private String exposedStaffName;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="mobile_number")
	private String mobileNumber;

	@Column(name="mode_of_injury_or_exposure")
	private String modeOfInjuryOrExposure;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="pep_course_days")
	private Integer pepCourseDays;

	@Column(name="pep_number")
	private String pepNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="pep_start_date")
	private Date pepStartDate;

	@Temporal(TemporalType.DATE)
	@Column(name="registration_date")
	private Date registrationDate;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to MasterExposureSeverity
	@ManyToOne
	@JoinColumn(name="severity_of_exposure")
	private MasterExposureSeverity masterExposureSeverity;

	//bi-directional many-to-one association to MasterGender
	@ManyToOne
	@JoinColumn(name="gender")
	private MasterGender masterGender;

	//bi-directional many-to-one association to MasterHbvStatus
	@ManyToOne
	@JoinColumn(name="baseline_test_conducted_hbv_result")
	private MasterHbvStatus masterHbvStatus;

	//bi-directional many-to-one association to MasterHcvStatus
	@ManyToOne
	@JoinColumn(name="baseline_test_conducted_hcv_result")
	private MasterHcvStatus masterHcvStatus;

	//bi-directional many-to-one association to MasterHivExposureCode
	@ManyToOne
	@JoinColumn(name="hiv_exposure_code")
	private MasterHivExposureCode masterHivExposureCode;

	//bi-directional many-to-one association to MasterHivSourceStatus
	@ManyToOne
	@JoinColumn(name="hiv_source_status")
	private MasterHivSourceStatus masterHivSourceStatus;

	//bi-directional many-to-one association to MasterHivStatus
	@ManyToOne
	@JoinColumn(name="exposed_person_sero_status_six_months")
	private MasterHivStatus masterHivStatus1;

	//bi-directional many-to-one association to MasterHivStatus
	@ManyToOne
	@JoinColumn(name="exposed_person_sero_status_three_months")
	private MasterHivStatus masterHivStatus2;

	//bi-directional many-to-one association to MasterHivStatus
	@ManyToOne
	@JoinColumn(name="baseline_test_conducted_hiv_result")
	private MasterHivStatus masterHivStatus3;

	//bi-directional many-to-one association to MasterPepPrescription
	@ManyToOne
	@JoinColumn(name="pep_prescription_id")
	private MasterPepPrescription masterPepPrescription;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="entry_user")
	private UserMaster userMaster;

	//bi-directional many-to-one association to ArtPepDispensation
	@OneToMany(mappedBy="artPep")
	private Set<ArtPepDispensation> artPepDispensations;

	//bi-directional many-to-one association to ArtPepDueList
	@OneToMany(mappedBy="artPep")
	private Set<ArtPepDueList> artPepDueLists;

	//bi-directional many-to-one association to ArtPepQueue
	@OneToMany(mappedBy="artPep")
	private Set<ArtPepQueue> artPepQueues;

	public ArtPep() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getBaselineTestConductedHbv() {
		return this.baselineTestConductedHbv;
	}

	public void setBaselineTestConductedHbv(Boolean baselineTestConductedHbv) {
		this.baselineTestConductedHbv = baselineTestConductedHbv;
	}

	public Boolean getBaselineTestConductedHcv() {
		return this.baselineTestConductedHcv;
	}

	public void setBaselineTestConductedHcv(Boolean baselineTestConductedHcv) {
		this.baselineTestConductedHcv = baselineTestConductedHcv;
	}

	public Boolean getBaselineTestConductedHiv() {
		return this.baselineTestConductedHiv;
	}

	public void setBaselineTestConductedHiv(Boolean baselineTestConductedHiv) {
		this.baselineTestConductedHiv = baselineTestConductedHiv;
	}

	public Boolean getConsentTaken() {
		return this.consentTaken;
	}

	public void setConsentTaken(Boolean consentTaken) {
		this.consentTaken = consentTaken;
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

	public Date getDateOfAccidentalExposure() {
		return this.dateOfAccidentalExposure;
	}

	public void setDateOfAccidentalExposure(Date dateOfAccidentalExposure) {
		this.dateOfAccidentalExposure = dateOfAccidentalExposure;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getExposedStaffDesignation() {
		return this.exposedStaffDesignation;
	}

	public void setExposedStaffDesignation(String exposedStaffDesignation) {
		this.exposedStaffDesignation = exposedStaffDesignation;
	}

	public String getExposedStaffName() {
		return this.exposedStaffName;
	}

	public void setExposedStaffName(String exposedStaffName) {
		this.exposedStaffName = exposedStaffName;
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

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getModeOfInjuryOrExposure() {
		return this.modeOfInjuryOrExposure;
	}

	public void setModeOfInjuryOrExposure(String modeOfInjuryOrExposure) {
		this.modeOfInjuryOrExposure = modeOfInjuryOrExposure;
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

	public Integer getPepCourseDays() {
		return this.pepCourseDays;
	}

	public void setPepCourseDays(Integer pepCourseDays) {
		this.pepCourseDays = pepCourseDays;
	}

	public String getPepNumber() {
		return this.pepNumber;
	}

	public void setPepNumber(String pepNumber) {
		this.pepNumber = pepNumber;
	}

	public Date getPepStartDate() {
		return this.pepStartDate;
	}

	public void setPepStartDate(Date pepStartDate) {
		this.pepStartDate = pepStartDate;
	}

	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public MasterExposureSeverity getMasterExposureSeverity() {
		return this.masterExposureSeverity;
	}

	public void setMasterExposureSeverity(MasterExposureSeverity masterExposureSeverity) {
		this.masterExposureSeverity = masterExposureSeverity;
	}

	public MasterGender getMasterGender() {
		return this.masterGender;
	}

	public void setMasterGender(MasterGender masterGender) {
		this.masterGender = masterGender;
	}

	public MasterHbvStatus getMasterHbvStatus() {
		return this.masterHbvStatus;
	}

	public void setMasterHbvStatus(MasterHbvStatus masterHbvStatus) {
		this.masterHbvStatus = masterHbvStatus;
	}

	public MasterHcvStatus getMasterHcvStatus() {
		return this.masterHcvStatus;
	}

	public void setMasterHcvStatus(MasterHcvStatus masterHcvStatus) {
		this.masterHcvStatus = masterHcvStatus;
	}

	public MasterHivExposureCode getMasterHivExposureCode() {
		return this.masterHivExposureCode;
	}

	public void setMasterHivExposureCode(MasterHivExposureCode masterHivExposureCode) {
		this.masterHivExposureCode = masterHivExposureCode;
	}

	public MasterHivSourceStatus getMasterHivSourceStatus() {
		return this.masterHivSourceStatus;
	}

	public void setMasterHivSourceStatus(MasterHivSourceStatus masterHivSourceStatus) {
		this.masterHivSourceStatus = masterHivSourceStatus;
	}

	public MasterHivStatus getMasterHivStatus1() {
		return this.masterHivStatus1;
	}

	public void setMasterHivStatus1(MasterHivStatus masterHivStatus1) {
		this.masterHivStatus1 = masterHivStatus1;
	}

	public MasterHivStatus getMasterHivStatus2() {
		return this.masterHivStatus2;
	}

	public void setMasterHivStatus2(MasterHivStatus masterHivStatus2) {
		this.masterHivStatus2 = masterHivStatus2;
	}

	public MasterHivStatus getMasterHivStatus3() {
		return this.masterHivStatus3;
	}

	public void setMasterHivStatus3(MasterHivStatus masterHivStatus3) {
		this.masterHivStatus3 = masterHivStatus3;
	}

	public MasterPepPrescription getMasterPepPrescription() {
		return this.masterPepPrescription;
	}

	public void setMasterPepPrescription(MasterPepPrescription masterPepPrescription) {
		this.masterPepPrescription = masterPepPrescription;
	}

	public UserMaster getUserMaster() {
		return this.userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

	public Set<ArtPepDispensation> getArtPepDispensations() {
		return this.artPepDispensations;
	}

	public void setArtPepDispensations(Set<ArtPepDispensation> artPepDispensations) {
		this.artPepDispensations = artPepDispensations;
	}

	public ArtPepDispensation addArtPepDispensation(ArtPepDispensation artPepDispensation) {
		getArtPepDispensations().add(artPepDispensation);
		artPepDispensation.setArtPep(this);

		return artPepDispensation;
	}

	public ArtPepDispensation removeArtPepDispensation(ArtPepDispensation artPepDispensation) {
		getArtPepDispensations().remove(artPepDispensation);
		artPepDispensation.setArtPep(null);

		return artPepDispensation;
	}

	public Set<ArtPepDueList> getArtPepDueLists() {
		return this.artPepDueLists;
	}

	public void setArtPepDueLists(Set<ArtPepDueList> artPepDueLists) {
		this.artPepDueLists = artPepDueLists;
	}

	public ArtPepDueList addArtPepDueList(ArtPepDueList artPepDueList) {
		getArtPepDueLists().add(artPepDueList);
		artPepDueList.setArtPep(this);

		return artPepDueList;
	}

	public ArtPepDueList removeArtPepDueList(ArtPepDueList artPepDueList) {
		getArtPepDueLists().remove(artPepDueList);
		artPepDueList.setArtPep(null);

		return artPepDueList;
	}

	public Set<ArtPepQueue> getArtPepQueues() {
		return this.artPepQueues;
	}

	public void setArtPepQueues(Set<ArtPepQueue> artPepQueues) {
		this.artPepQueues = artPepQueues;
	}

	public ArtPepQueue addArtPepQueue(ArtPepQueue artPepQueue) {
		getArtPepQueues().add(artPepQueue);
		artPepQueue.setArtPep(this);

		return artPepQueue;
	}

	public ArtPepQueue removeArtPepQueue(ArtPepQueue artPepQueue) {
		getArtPepQueues().remove(artPepQueue);
		artPepQueue.setArtPep(null);

		return artPepQueue;
	}

}