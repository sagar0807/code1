package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the user_master database table.
 * 
 */
@Entity
@Table(name="user_master")
@NamedQuery(name="UserMaster.findAll", query="SELECT u FROM UserMaster u")
public class UserMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="active_role")
	private Boolean activeRole;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	private String email;

	private String firstname;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_beneficiary")
	private String isBeneficiary;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="landline_number")
	private String landlineNumber;

	@Column(name="last_training_date")
	private Timestamp lastTrainingDate;

	private String lastname;

	@Column(name="mobile_number")
	private String mobileNumber;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="orw_code")
	private String orwCode;

	@Column(name="orw_name")
	private String orwName;

	@Column(name="pe_code")
	private String peCode;

	@Column(name="pe_name")
	private String peName;

	@Column(name="sms_enabled")
	private Boolean smsEnabled;

	@Column(name="whatsapp_enabled")
	private Boolean whatsappEnabled;

	//bi-directional many-to-one association to ArtBeneficiary
	@OneToMany(mappedBy="userMaster1")
	private Set<ArtBeneficiary> artBeneficiaries1;

	//bi-directional many-to-one association to ArtBeneficiary
	@OneToMany(mappedBy="userMaster2")
	private Set<ArtBeneficiary> artBeneficiaries2;

	//bi-directional many-to-one association to ArtBeneficiaryClinicalDetail
	@OneToMany(mappedBy="userMaster")
	private Set<ArtBeneficiaryClinicalDetail> artBeneficiaryClinicalDetails;

	//bi-directional many-to-one association to ArtBeneficiaryCounsellingNote
	@OneToMany(mappedBy="userMaster")
	private Set<ArtBeneficiaryCounsellingNote> artBeneficiaryCounsellingNotes;

	//bi-directional many-to-one association to ArtBeneficiaryDueList
	@OneToMany(mappedBy="userMaster")
	private Set<ArtBeneficiaryDueList> artBeneficiaryDueLists;

	//bi-directional many-to-one association to ArtBeneficiaryFollowup
	@OneToMany(mappedBy="userMaster")
	private Set<ArtBeneficiaryFollowup> artBeneficiaryFollowups;

	//bi-directional many-to-one association to ArtBeneficiaryIptAttDetail
	@OneToMany(mappedBy="userMaster")
	private Set<ArtBeneficiaryIptAttDetail> artBeneficiaryIptAttDetails;

	//bi-directional many-to-one association to ArtBeneficiaryQueue
	@OneToMany(mappedBy="userMaster1")
	private Set<ArtBeneficiaryQueue> artBeneficiaryQueues1;

	//bi-directional many-to-one association to ArtBeneficiaryQueue
	@OneToMany(mappedBy="userMaster2")
	private Set<ArtBeneficiaryQueue> artBeneficiaryQueues2;

	//bi-directional many-to-one association to ArtDispensation
	@OneToMany(mappedBy="userMaster")
	private Set<ArtDispensation> artDispensations;

	//bi-directional many-to-one association to ArtPep
	@OneToMany(mappedBy="userMaster")
	private Set<ArtPep> artPeps;

	//bi-directional many-to-one association to ArtPepDispensation
	@OneToMany(mappedBy="userMaster")
	private Set<ArtPepDispensation> artPepDispensations;

	//bi-directional many-to-one association to ArtPepDueList
	@OneToMany(mappedBy="userMaster")
	private Set<ArtPepDueList> artPepDueLists;

	//bi-directional many-to-one association to ArtPepQueue
	@OneToMany(mappedBy="userMaster1")
	private Set<ArtPepQueue> artPepQueues1;

	//bi-directional many-to-one association to ArtPepQueue
	@OneToMany(mappedBy="userMaster2")
	private Set<ArtPepQueue> artPepQueues2;

	//bi-directional many-to-one association to BeneficiaryReferral
	@OneToMany(mappedBy="userMaster")
	private Set<BeneficiaryReferral> beneficiaryReferrals;

	//bi-directional many-to-one association to ContractStatusTracking
	@OneToMany(mappedBy="userMaster")
	private Set<ContractStatusTracking> contractStatusTrackings;

	//bi-directional many-to-one association to DispatchReceiptRemark
	@OneToMany(mappedBy="userMaster1")
	private Set<DispatchReceiptRemark> dispatchReceiptRemarks1;

	//bi-directional many-to-one association to DispatchReceiptRemark
	@OneToMany(mappedBy="userMaster2")
	private Set<DispatchReceiptRemark> dispatchReceiptRemarks2;

	//bi-directional many-to-one association to DispatchStatusTracking
	@OneToMany(mappedBy="userMaster")
	private Set<DispatchStatusTracking> dispatchStatusTrackings;

	//bi-directional many-to-one association to FacilityDispatchReceiptRemark
	@OneToMany(mappedBy="userMaster1")
	private Set<FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarks1;

	//bi-directional many-to-one association to FacilityDispatchReceiptRemark
	@OneToMany(mappedBy="userMaster2")
	private Set<FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarks2;

	//bi-directional many-to-one association to FacilityDispatchStatusTracking
	@OneToMany(mappedBy="userMaster")
	private Set<FacilityDispatchStatusTracking> facilityDispatchStatusTrackings;

	//bi-directional many-to-one association to FacilityStockAdjustment
	@OneToMany(mappedBy="userMaster1")
	private Set<FacilityStockAdjustment> facilityStockAdjustments1;

	//bi-directional many-to-one association to FacilityStockAdjustment
	@OneToMany(mappedBy="userMaster2")
	private Set<FacilityStockAdjustment> facilityStockAdjustments2;

	//bi-directional many-to-one association to LabTestSample
	@OneToMany(mappedBy="userMaster1")
	private Set<LabTestSample> labTestSamples1;

	//bi-directional many-to-one association to LabTestSample
	@OneToMany(mappedBy="userMaster2")
	private Set<LabTestSample> labTestSamples2;

	//bi-directional many-to-one association to LabTestSample
	@OneToMany(mappedBy="userMaster3")
	private Set<LabTestSample> labTestSamples3;

	//bi-directional many-to-one association to LabTestSampleBatch
	@OneToMany(mappedBy="userMaster1")
	private Set<LabTestSampleBatch> labTestSampleBatches1;

	//bi-directional many-to-one association to LabTestSampleBatch
	@OneToMany(mappedBy="userMaster2")
	private Set<LabTestSampleBatch> labTestSampleBatches2;

	//bi-directional many-to-one association to OrwPeMapping
	@OneToMany(mappedBy="userMaster1")
	private Set<OrwPeMapping> orwPeMappings1;

	//bi-directional many-to-one association to OrwPeMapping
	@OneToMany(mappedBy="userMaster2")
	private Set<OrwPeMapping> orwPeMappings2;

	//bi-directional many-to-one association to UserAuth
	@OneToMany(mappedBy="userMaster")
	private Set<UserAuth> userAuths;

	//bi-directional many-to-one association to Designation
	@ManyToOne
	private Designation designation;

	//bi-directional many-to-one association to Division
	@ManyToOne
	private Division division;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to FacilityType
	@ManyToOne
	@JoinColumn(name="facility_type_id")
	private FacilityType facilityType;

	//bi-directional many-to-one association to MasterStatus
	@ManyToOne
	@JoinColumn(name="status")
	private MasterStatus masterStatus;

	//bi-directional many-to-one association to MasterTrainingType
	@ManyToOne
	@JoinColumn(name="type_of_training_id")
	private MasterTrainingType masterTrainingType;

	//bi-directional many-to-one association to MasterYesOrNo
	@ManyToOne
	@JoinColumn(name="is_trained")
	private MasterYesOrNo masterYesOrNo;

	//bi-directional many-to-one association to UserRoleMapping
	@OneToMany(mappedBy="userMaster")
	private Set<UserRoleMapping> userRoleMappings;

	public UserMaster() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActiveRole() {
		return this.activeRole;
	}

	public void setActiveRole(Boolean activeRole) {
		this.activeRole = activeRole;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getIsBeneficiary() {
		return this.isBeneficiary;
	}

	public void setIsBeneficiary(String isBeneficiary) {
		this.isBeneficiary = isBeneficiary;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getLandlineNumber() {
		return this.landlineNumber;
	}

	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
	}

	public Timestamp getLastTrainingDate() {
		return this.lastTrainingDate;
	}

	public void setLastTrainingDate(Timestamp lastTrainingDate) {
		this.lastTrainingDate = lastTrainingDate;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getOrwCode() {
		return this.orwCode;
	}

	public void setOrwCode(String orwCode) {
		this.orwCode = orwCode;
	}

	public String getOrwName() {
		return this.orwName;
	}

	public void setOrwName(String orwName) {
		this.orwName = orwName;
	}

	public String getPeCode() {
		return this.peCode;
	}

	public void setPeCode(String peCode) {
		this.peCode = peCode;
	}

	public String getPeName() {
		return this.peName;
	}

	public void setPeName(String peName) {
		this.peName = peName;
	}

	public Boolean getSmsEnabled() {
		return this.smsEnabled;
	}

	public void setSmsEnabled(Boolean smsEnabled) {
		this.smsEnabled = smsEnabled;
	}

	public Boolean getWhatsappEnabled() {
		return this.whatsappEnabled;
	}

	public void setWhatsappEnabled(Boolean whatsappEnabled) {
		this.whatsappEnabled = whatsappEnabled;
	}

	public Set<ArtBeneficiary> getArtBeneficiaries1() {
		return this.artBeneficiaries1;
	}

	public void setArtBeneficiaries1(Set<ArtBeneficiary> artBeneficiaries1) {
		this.artBeneficiaries1 = artBeneficiaries1;
	}

	public ArtBeneficiary addArtBeneficiaries1(ArtBeneficiary artBeneficiaries1) {
		getArtBeneficiaries1().add(artBeneficiaries1);
		artBeneficiaries1.setUserMaster1(this);

		return artBeneficiaries1;
	}

	public ArtBeneficiary removeArtBeneficiaries1(ArtBeneficiary artBeneficiaries1) {
		getArtBeneficiaries1().remove(artBeneficiaries1);
		artBeneficiaries1.setUserMaster1(null);

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
		artBeneficiaries2.setUserMaster2(this);

		return artBeneficiaries2;
	}

	public ArtBeneficiary removeArtBeneficiaries2(ArtBeneficiary artBeneficiaries2) {
		getArtBeneficiaries2().remove(artBeneficiaries2);
		artBeneficiaries2.setUserMaster2(null);

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
		artBeneficiaryClinicalDetail.setUserMaster(this);

		return artBeneficiaryClinicalDetail;
	}

	public ArtBeneficiaryClinicalDetail removeArtBeneficiaryClinicalDetail(ArtBeneficiaryClinicalDetail artBeneficiaryClinicalDetail) {
		getArtBeneficiaryClinicalDetails().remove(artBeneficiaryClinicalDetail);
		artBeneficiaryClinicalDetail.setUserMaster(null);

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
		artBeneficiaryCounsellingNote.setUserMaster(this);

		return artBeneficiaryCounsellingNote;
	}

	public ArtBeneficiaryCounsellingNote removeArtBeneficiaryCounsellingNote(ArtBeneficiaryCounsellingNote artBeneficiaryCounsellingNote) {
		getArtBeneficiaryCounsellingNotes().remove(artBeneficiaryCounsellingNote);
		artBeneficiaryCounsellingNote.setUserMaster(null);

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
		artBeneficiaryDueList.setUserMaster(this);

		return artBeneficiaryDueList;
	}

	public ArtBeneficiaryDueList removeArtBeneficiaryDueList(ArtBeneficiaryDueList artBeneficiaryDueList) {
		getArtBeneficiaryDueLists().remove(artBeneficiaryDueList);
		artBeneficiaryDueList.setUserMaster(null);

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
		artBeneficiaryFollowup.setUserMaster(this);

		return artBeneficiaryFollowup;
	}

	public ArtBeneficiaryFollowup removeArtBeneficiaryFollowup(ArtBeneficiaryFollowup artBeneficiaryFollowup) {
		getArtBeneficiaryFollowups().remove(artBeneficiaryFollowup);
		artBeneficiaryFollowup.setUserMaster(null);

		return artBeneficiaryFollowup;
	}

	public Set<ArtBeneficiaryIptAttDetail> getArtBeneficiaryIptAttDetails() {
		return this.artBeneficiaryIptAttDetails;
	}

	public void setArtBeneficiaryIptAttDetails(Set<ArtBeneficiaryIptAttDetail> artBeneficiaryIptAttDetails) {
		this.artBeneficiaryIptAttDetails = artBeneficiaryIptAttDetails;
	}

	public ArtBeneficiaryIptAttDetail addArtBeneficiaryIptAttDetail(ArtBeneficiaryIptAttDetail artBeneficiaryIptAttDetail) {
		getArtBeneficiaryIptAttDetails().add(artBeneficiaryIptAttDetail);
		artBeneficiaryIptAttDetail.setUserMaster(this);

		return artBeneficiaryIptAttDetail;
	}

	public ArtBeneficiaryIptAttDetail removeArtBeneficiaryIptAttDetail(ArtBeneficiaryIptAttDetail artBeneficiaryIptAttDetail) {
		getArtBeneficiaryIptAttDetails().remove(artBeneficiaryIptAttDetail);
		artBeneficiaryIptAttDetail.setUserMaster(null);

		return artBeneficiaryIptAttDetail;
	}

	public Set<ArtBeneficiaryQueue> getArtBeneficiaryQueues1() {
		return this.artBeneficiaryQueues1;
	}

	public void setArtBeneficiaryQueues1(Set<ArtBeneficiaryQueue> artBeneficiaryQueues1) {
		this.artBeneficiaryQueues1 = artBeneficiaryQueues1;
	}

	public ArtBeneficiaryQueue addArtBeneficiaryQueues1(ArtBeneficiaryQueue artBeneficiaryQueues1) {
		getArtBeneficiaryQueues1().add(artBeneficiaryQueues1);
		artBeneficiaryQueues1.setUserMaster1(this);

		return artBeneficiaryQueues1;
	}

	public ArtBeneficiaryQueue removeArtBeneficiaryQueues1(ArtBeneficiaryQueue artBeneficiaryQueues1) {
		getArtBeneficiaryQueues1().remove(artBeneficiaryQueues1);
		artBeneficiaryQueues1.setUserMaster1(null);

		return artBeneficiaryQueues1;
	}

	public Set<ArtBeneficiaryQueue> getArtBeneficiaryQueues2() {
		return this.artBeneficiaryQueues2;
	}

	public void setArtBeneficiaryQueues2(Set<ArtBeneficiaryQueue> artBeneficiaryQueues2) {
		this.artBeneficiaryQueues2 = artBeneficiaryQueues2;
	}

	public ArtBeneficiaryQueue addArtBeneficiaryQueues2(ArtBeneficiaryQueue artBeneficiaryQueues2) {
		getArtBeneficiaryQueues2().add(artBeneficiaryQueues2);
		artBeneficiaryQueues2.setUserMaster2(this);

		return artBeneficiaryQueues2;
	}

	public ArtBeneficiaryQueue removeArtBeneficiaryQueues2(ArtBeneficiaryQueue artBeneficiaryQueues2) {
		getArtBeneficiaryQueues2().remove(artBeneficiaryQueues2);
		artBeneficiaryQueues2.setUserMaster2(null);

		return artBeneficiaryQueues2;
	}

	public Set<ArtDispensation> getArtDispensations() {
		return this.artDispensations;
	}

	public void setArtDispensations(Set<ArtDispensation> artDispensations) {
		this.artDispensations = artDispensations;
	}

	public ArtDispensation addArtDispensation(ArtDispensation artDispensation) {
		getArtDispensations().add(artDispensation);
		artDispensation.setUserMaster(this);

		return artDispensation;
	}

	public ArtDispensation removeArtDispensation(ArtDispensation artDispensation) {
		getArtDispensations().remove(artDispensation);
		artDispensation.setUserMaster(null);

		return artDispensation;
	}

	public Set<ArtPep> getArtPeps() {
		return this.artPeps;
	}

	public void setArtPeps(Set<ArtPep> artPeps) {
		this.artPeps = artPeps;
	}

	public ArtPep addArtPep(ArtPep artPep) {
		getArtPeps().add(artPep);
		artPep.setUserMaster(this);

		return artPep;
	}

	public ArtPep removeArtPep(ArtPep artPep) {
		getArtPeps().remove(artPep);
		artPep.setUserMaster(null);

		return artPep;
	}

	public Set<ArtPepDispensation> getArtPepDispensations() {
		return this.artPepDispensations;
	}

	public void setArtPepDispensations(Set<ArtPepDispensation> artPepDispensations) {
		this.artPepDispensations = artPepDispensations;
	}

	public ArtPepDispensation addArtPepDispensation(ArtPepDispensation artPepDispensation) {
		getArtPepDispensations().add(artPepDispensation);
		artPepDispensation.setUserMaster(this);

		return artPepDispensation;
	}

	public ArtPepDispensation removeArtPepDispensation(ArtPepDispensation artPepDispensation) {
		getArtPepDispensations().remove(artPepDispensation);
		artPepDispensation.setUserMaster(null);

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
		artPepDueList.setUserMaster(this);

		return artPepDueList;
	}

	public ArtPepDueList removeArtPepDueList(ArtPepDueList artPepDueList) {
		getArtPepDueLists().remove(artPepDueList);
		artPepDueList.setUserMaster(null);

		return artPepDueList;
	}

	public Set<ArtPepQueue> getArtPepQueues1() {
		return this.artPepQueues1;
	}

	public void setArtPepQueues1(Set<ArtPepQueue> artPepQueues1) {
		this.artPepQueues1 = artPepQueues1;
	}

	public ArtPepQueue addArtPepQueues1(ArtPepQueue artPepQueues1) {
		getArtPepQueues1().add(artPepQueues1);
		artPepQueues1.setUserMaster1(this);

		return artPepQueues1;
	}

	public ArtPepQueue removeArtPepQueues1(ArtPepQueue artPepQueues1) {
		getArtPepQueues1().remove(artPepQueues1);
		artPepQueues1.setUserMaster1(null);

		return artPepQueues1;
	}

	public Set<ArtPepQueue> getArtPepQueues2() {
		return this.artPepQueues2;
	}

	public void setArtPepQueues2(Set<ArtPepQueue> artPepQueues2) {
		this.artPepQueues2 = artPepQueues2;
	}

	public ArtPepQueue addArtPepQueues2(ArtPepQueue artPepQueues2) {
		getArtPepQueues2().add(artPepQueues2);
		artPepQueues2.setUserMaster2(this);

		return artPepQueues2;
	}

	public ArtPepQueue removeArtPepQueues2(ArtPepQueue artPepQueues2) {
		getArtPepQueues2().remove(artPepQueues2);
		artPepQueues2.setUserMaster2(null);

		return artPepQueues2;
	}

	public Set<BeneficiaryReferral> getBeneficiaryReferrals() {
		return this.beneficiaryReferrals;
	}

	public void setBeneficiaryReferrals(Set<BeneficiaryReferral> beneficiaryReferrals) {
		this.beneficiaryReferrals = beneficiaryReferrals;
	}

	public BeneficiaryReferral addBeneficiaryReferral(BeneficiaryReferral beneficiaryReferral) {
		getBeneficiaryReferrals().add(beneficiaryReferral);
		beneficiaryReferral.setUserMaster(this);

		return beneficiaryReferral;
	}

	public BeneficiaryReferral removeBeneficiaryReferral(BeneficiaryReferral beneficiaryReferral) {
		getBeneficiaryReferrals().remove(beneficiaryReferral);
		beneficiaryReferral.setUserMaster(null);

		return beneficiaryReferral;
	}

	public Set<ContractStatusTracking> getContractStatusTrackings() {
		return this.contractStatusTrackings;
	}

	public void setContractStatusTrackings(Set<ContractStatusTracking> contractStatusTrackings) {
		this.contractStatusTrackings = contractStatusTrackings;
	}

	public ContractStatusTracking addContractStatusTracking(ContractStatusTracking contractStatusTracking) {
		getContractStatusTrackings().add(contractStatusTracking);
		contractStatusTracking.setUserMaster(this);

		return contractStatusTracking;
	}

	public ContractStatusTracking removeContractStatusTracking(ContractStatusTracking contractStatusTracking) {
		getContractStatusTrackings().remove(contractStatusTracking);
		contractStatusTracking.setUserMaster(null);

		return contractStatusTracking;
	}

	public Set<DispatchReceiptRemark> getDispatchReceiptRemarks1() {
		return this.dispatchReceiptRemarks1;
	}

	public void setDispatchReceiptRemarks1(Set<DispatchReceiptRemark> dispatchReceiptRemarks1) {
		this.dispatchReceiptRemarks1 = dispatchReceiptRemarks1;
	}

	public DispatchReceiptRemark addDispatchReceiptRemarks1(DispatchReceiptRemark dispatchReceiptRemarks1) {
		getDispatchReceiptRemarks1().add(dispatchReceiptRemarks1);
		dispatchReceiptRemarks1.setUserMaster1(this);

		return dispatchReceiptRemarks1;
	}

	public DispatchReceiptRemark removeDispatchReceiptRemarks1(DispatchReceiptRemark dispatchReceiptRemarks1) {
		getDispatchReceiptRemarks1().remove(dispatchReceiptRemarks1);
		dispatchReceiptRemarks1.setUserMaster1(null);

		return dispatchReceiptRemarks1;
	}

	public Set<DispatchReceiptRemark> getDispatchReceiptRemarks2() {
		return this.dispatchReceiptRemarks2;
	}

	public void setDispatchReceiptRemarks2(Set<DispatchReceiptRemark> dispatchReceiptRemarks2) {
		this.dispatchReceiptRemarks2 = dispatchReceiptRemarks2;
	}

	public DispatchReceiptRemark addDispatchReceiptRemarks2(DispatchReceiptRemark dispatchReceiptRemarks2) {
		getDispatchReceiptRemarks2().add(dispatchReceiptRemarks2);
		dispatchReceiptRemarks2.setUserMaster2(this);

		return dispatchReceiptRemarks2;
	}

	public DispatchReceiptRemark removeDispatchReceiptRemarks2(DispatchReceiptRemark dispatchReceiptRemarks2) {
		getDispatchReceiptRemarks2().remove(dispatchReceiptRemarks2);
		dispatchReceiptRemarks2.setUserMaster2(null);

		return dispatchReceiptRemarks2;
	}

	public Set<DispatchStatusTracking> getDispatchStatusTrackings() {
		return this.dispatchStatusTrackings;
	}

	public void setDispatchStatusTrackings(Set<DispatchStatusTracking> dispatchStatusTrackings) {
		this.dispatchStatusTrackings = dispatchStatusTrackings;
	}

	public DispatchStatusTracking addDispatchStatusTracking(DispatchStatusTracking dispatchStatusTracking) {
		getDispatchStatusTrackings().add(dispatchStatusTracking);
		dispatchStatusTracking.setUserMaster(this);

		return dispatchStatusTracking;
	}

	public DispatchStatusTracking removeDispatchStatusTracking(DispatchStatusTracking dispatchStatusTracking) {
		getDispatchStatusTrackings().remove(dispatchStatusTracking);
		dispatchStatusTracking.setUserMaster(null);

		return dispatchStatusTracking;
	}

	public Set<FacilityDispatchReceiptRemark> getFacilityDispatchReceiptRemarks1() {
		return this.facilityDispatchReceiptRemarks1;
	}

	public void setFacilityDispatchReceiptRemarks1(Set<FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarks1) {
		this.facilityDispatchReceiptRemarks1 = facilityDispatchReceiptRemarks1;
	}

	public FacilityDispatchReceiptRemark addFacilityDispatchReceiptRemarks1(FacilityDispatchReceiptRemark facilityDispatchReceiptRemarks1) {
		getFacilityDispatchReceiptRemarks1().add(facilityDispatchReceiptRemarks1);
		facilityDispatchReceiptRemarks1.setUserMaster1(this);

		return facilityDispatchReceiptRemarks1;
	}

	public FacilityDispatchReceiptRemark removeFacilityDispatchReceiptRemarks1(FacilityDispatchReceiptRemark facilityDispatchReceiptRemarks1) {
		getFacilityDispatchReceiptRemarks1().remove(facilityDispatchReceiptRemarks1);
		facilityDispatchReceiptRemarks1.setUserMaster1(null);

		return facilityDispatchReceiptRemarks1;
	}

	public Set<FacilityDispatchReceiptRemark> getFacilityDispatchReceiptRemarks2() {
		return this.facilityDispatchReceiptRemarks2;
	}

	public void setFacilityDispatchReceiptRemarks2(Set<FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarks2) {
		this.facilityDispatchReceiptRemarks2 = facilityDispatchReceiptRemarks2;
	}

	public FacilityDispatchReceiptRemark addFacilityDispatchReceiptRemarks2(FacilityDispatchReceiptRemark facilityDispatchReceiptRemarks2) {
		getFacilityDispatchReceiptRemarks2().add(facilityDispatchReceiptRemarks2);
		facilityDispatchReceiptRemarks2.setUserMaster2(this);

		return facilityDispatchReceiptRemarks2;
	}

	public FacilityDispatchReceiptRemark removeFacilityDispatchReceiptRemarks2(FacilityDispatchReceiptRemark facilityDispatchReceiptRemarks2) {
		getFacilityDispatchReceiptRemarks2().remove(facilityDispatchReceiptRemarks2);
		facilityDispatchReceiptRemarks2.setUserMaster2(null);

		return facilityDispatchReceiptRemarks2;
	}

	public Set<FacilityDispatchStatusTracking> getFacilityDispatchStatusTrackings() {
		return this.facilityDispatchStatusTrackings;
	}

	public void setFacilityDispatchStatusTrackings(Set<FacilityDispatchStatusTracking> facilityDispatchStatusTrackings) {
		this.facilityDispatchStatusTrackings = facilityDispatchStatusTrackings;
	}

	public FacilityDispatchStatusTracking addFacilityDispatchStatusTracking(FacilityDispatchStatusTracking facilityDispatchStatusTracking) {
		getFacilityDispatchStatusTrackings().add(facilityDispatchStatusTracking);
		facilityDispatchStatusTracking.setUserMaster(this);

		return facilityDispatchStatusTracking;
	}

	public FacilityDispatchStatusTracking removeFacilityDispatchStatusTracking(FacilityDispatchStatusTracking facilityDispatchStatusTracking) {
		getFacilityDispatchStatusTrackings().remove(facilityDispatchStatusTracking);
		facilityDispatchStatusTracking.setUserMaster(null);

		return facilityDispatchStatusTracking;
	}

	public Set<FacilityStockAdjustment> getFacilityStockAdjustments1() {
		return this.facilityStockAdjustments1;
	}

	public void setFacilityStockAdjustments1(Set<FacilityStockAdjustment> facilityStockAdjustments1) {
		this.facilityStockAdjustments1 = facilityStockAdjustments1;
	}

	public FacilityStockAdjustment addFacilityStockAdjustments1(FacilityStockAdjustment facilityStockAdjustments1) {
		getFacilityStockAdjustments1().add(facilityStockAdjustments1);
		facilityStockAdjustments1.setUserMaster1(this);

		return facilityStockAdjustments1;
	}

	public FacilityStockAdjustment removeFacilityStockAdjustments1(FacilityStockAdjustment facilityStockAdjustments1) {
		getFacilityStockAdjustments1().remove(facilityStockAdjustments1);
		facilityStockAdjustments1.setUserMaster1(null);

		return facilityStockAdjustments1;
	}

	public Set<FacilityStockAdjustment> getFacilityStockAdjustments2() {
		return this.facilityStockAdjustments2;
	}

	public void setFacilityStockAdjustments2(Set<FacilityStockAdjustment> facilityStockAdjustments2) {
		this.facilityStockAdjustments2 = facilityStockAdjustments2;
	}

	public FacilityStockAdjustment addFacilityStockAdjustments2(FacilityStockAdjustment facilityStockAdjustments2) {
		getFacilityStockAdjustments2().add(facilityStockAdjustments2);
		facilityStockAdjustments2.setUserMaster2(this);

		return facilityStockAdjustments2;
	}

	public FacilityStockAdjustment removeFacilityStockAdjustments2(FacilityStockAdjustment facilityStockAdjustments2) {
		getFacilityStockAdjustments2().remove(facilityStockAdjustments2);
		facilityStockAdjustments2.setUserMaster2(null);

		return facilityStockAdjustments2;
	}

	public Set<LabTestSample> getLabTestSamples1() {
		return this.labTestSamples1;
	}

	public void setLabTestSamples1(Set<LabTestSample> labTestSamples1) {
		this.labTestSamples1 = labTestSamples1;
	}

	public LabTestSample addLabTestSamples1(LabTestSample labTestSamples1) {
		getLabTestSamples1().add(labTestSamples1);
		labTestSamples1.setUserMaster1(this);

		return labTestSamples1;
	}

	public LabTestSample removeLabTestSamples1(LabTestSample labTestSamples1) {
		getLabTestSamples1().remove(labTestSamples1);
		labTestSamples1.setUserMaster1(null);

		return labTestSamples1;
	}

	public Set<LabTestSample> getLabTestSamples2() {
		return this.labTestSamples2;
	}

	public void setLabTestSamples2(Set<LabTestSample> labTestSamples2) {
		this.labTestSamples2 = labTestSamples2;
	}

	public LabTestSample addLabTestSamples2(LabTestSample labTestSamples2) {
		getLabTestSamples2().add(labTestSamples2);
		labTestSamples2.setUserMaster2(this);

		return labTestSamples2;
	}

	public LabTestSample removeLabTestSamples2(LabTestSample labTestSamples2) {
		getLabTestSamples2().remove(labTestSamples2);
		labTestSamples2.setUserMaster2(null);

		return labTestSamples2;
	}

	public Set<LabTestSample> getLabTestSamples3() {
		return this.labTestSamples3;
	}

	public void setLabTestSamples3(Set<LabTestSample> labTestSamples3) {
		this.labTestSamples3 = labTestSamples3;
	}

	public LabTestSample addLabTestSamples3(LabTestSample labTestSamples3) {
		getLabTestSamples3().add(labTestSamples3);
		labTestSamples3.setUserMaster3(this);

		return labTestSamples3;
	}

	public LabTestSample removeLabTestSamples3(LabTestSample labTestSamples3) {
		getLabTestSamples3().remove(labTestSamples3);
		labTestSamples3.setUserMaster3(null);

		return labTestSamples3;
	}

	public Set<LabTestSampleBatch> getLabTestSampleBatches1() {
		return this.labTestSampleBatches1;
	}

	public void setLabTestSampleBatches1(Set<LabTestSampleBatch> labTestSampleBatches1) {
		this.labTestSampleBatches1 = labTestSampleBatches1;
	}

	public LabTestSampleBatch addLabTestSampleBatches1(LabTestSampleBatch labTestSampleBatches1) {
		getLabTestSampleBatches1().add(labTestSampleBatches1);
		labTestSampleBatches1.setUserMaster1(this);

		return labTestSampleBatches1;
	}

	public LabTestSampleBatch removeLabTestSampleBatches1(LabTestSampleBatch labTestSampleBatches1) {
		getLabTestSampleBatches1().remove(labTestSampleBatches1);
		labTestSampleBatches1.setUserMaster1(null);

		return labTestSampleBatches1;
	}

	public Set<LabTestSampleBatch> getLabTestSampleBatches2() {
		return this.labTestSampleBatches2;
	}

	public void setLabTestSampleBatches2(Set<LabTestSampleBatch> labTestSampleBatches2) {
		this.labTestSampleBatches2 = labTestSampleBatches2;
	}

	public LabTestSampleBatch addLabTestSampleBatches2(LabTestSampleBatch labTestSampleBatches2) {
		getLabTestSampleBatches2().add(labTestSampleBatches2);
		labTestSampleBatches2.setUserMaster2(this);

		return labTestSampleBatches2;
	}

	public LabTestSampleBatch removeLabTestSampleBatches2(LabTestSampleBatch labTestSampleBatches2) {
		getLabTestSampleBatches2().remove(labTestSampleBatches2);
		labTestSampleBatches2.setUserMaster2(null);

		return labTestSampleBatches2;
	}

	public Set<OrwPeMapping> getOrwPeMappings1() {
		return this.orwPeMappings1;
	}

	public void setOrwPeMappings1(Set<OrwPeMapping> orwPeMappings1) {
		this.orwPeMappings1 = orwPeMappings1;
	}

	public OrwPeMapping addOrwPeMappings1(OrwPeMapping orwPeMappings1) {
		getOrwPeMappings1().add(orwPeMappings1);
		orwPeMappings1.setUserMaster1(this);

		return orwPeMappings1;
	}

	public OrwPeMapping removeOrwPeMappings1(OrwPeMapping orwPeMappings1) {
		getOrwPeMappings1().remove(orwPeMappings1);
		orwPeMappings1.setUserMaster1(null);

		return orwPeMappings1;
	}

	public Set<OrwPeMapping> getOrwPeMappings2() {
		return this.orwPeMappings2;
	}

	public void setOrwPeMappings2(Set<OrwPeMapping> orwPeMappings2) {
		this.orwPeMappings2 = orwPeMappings2;
	}

	public OrwPeMapping addOrwPeMappings2(OrwPeMapping orwPeMappings2) {
		getOrwPeMappings2().add(orwPeMappings2);
		orwPeMappings2.setUserMaster2(this);

		return orwPeMappings2;
	}

	public OrwPeMapping removeOrwPeMappings2(OrwPeMapping orwPeMappings2) {
		getOrwPeMappings2().remove(orwPeMappings2);
		orwPeMappings2.setUserMaster2(null);

		return orwPeMappings2;
	}

	public Set<UserAuth> getUserAuths() {
		return this.userAuths;
	}

	public void setUserAuths(Set<UserAuth> userAuths) {
		this.userAuths = userAuths;
	}

	public UserAuth addUserAuth(UserAuth userAuth) {
		getUserAuths().add(userAuth);
		userAuth.setUserMaster(this);

		return userAuth;
	}

	public UserAuth removeUserAuth(UserAuth userAuth) {
		getUserAuths().remove(userAuth);
		userAuth.setUserMaster(null);

		return userAuth;
	}

	public Designation getDesignation() {
		return this.designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public Division getDivision() {
		return this.division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public FacilityType getFacilityType() {
		return this.facilityType;
	}

	public void setFacilityType(FacilityType facilityType) {
		this.facilityType = facilityType;
	}

	public MasterStatus getMasterStatus() {
		return this.masterStatus;
	}

	public void setMasterStatus(MasterStatus masterStatus) {
		this.masterStatus = masterStatus;
	}

	public MasterTrainingType getMasterTrainingType() {
		return this.masterTrainingType;
	}

	public void setMasterTrainingType(MasterTrainingType masterTrainingType) {
		this.masterTrainingType = masterTrainingType;
	}

	public MasterYesOrNo getMasterYesOrNo() {
		return this.masterYesOrNo;
	}

	public void setMasterYesOrNo(MasterYesOrNo masterYesOrNo) {
		this.masterYesOrNo = masterYesOrNo;
	}

	public Set<UserRoleMapping> getUserRoleMappings() {
		return this.userRoleMappings;
	}

	public void setUserRoleMappings(Set<UserRoleMapping> userRoleMappings) {
		this.userRoleMappings = userRoleMappings;
	}

	public UserRoleMapping addUserRoleMapping(UserRoleMapping userRoleMapping) {
		getUserRoleMappings().add(userRoleMapping);
		userRoleMapping.setUserMaster(this);

		return userRoleMapping;
	}

	public UserRoleMapping removeUserRoleMapping(UserRoleMapping userRoleMapping) {
		getUserRoleMappings().remove(userRoleMapping);
		userRoleMapping.setUserMaster(null);

		return userRoleMapping;
	}

}