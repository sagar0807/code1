package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the art_beneficiary database table.
 * 
 */
@Entity
@Table(name="art_beneficiary")
@NamedQuery(name="ArtBeneficiary.findAll", query="SELECT a FROM ArtBeneficiary a")
public class ArtBeneficiary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="art_eligibility_date")
	private Date artEligibilityDate;

	@Temporal(TemporalType.DATE)
	@Column(name="art_registration_date")
	private Date artRegistrationDate;

	@Temporal(TemporalType.DATE)
	@Column(name="art_start_date")
	private Date artStartDate;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="facility_id")
	private Integer facilityId;

	@Column(name="infant_registered_through_eid")
	private Boolean infantRegisteredThroughEid;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="is_transit")
	private Boolean isTransit;

	@Column(name="lac_linked")
	private Boolean lacLinked;

	@Column(name="linkage_institute_name")
	private String linkageInstituteName;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Temporal(TemporalType.DATE)
	@Column(name="record_creation_date")
	private Date recordCreationDate;

	@Temporal(TemporalType.DATE)
	@Column(name="transit_end_date")
	private Date transitEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name="transit_start_date")
	private Date transitStartDate;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	@JoinColumn(name="beneficiary_id")
	private Beneficiary beneficiary1;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	@JoinColumn(name="infant_beneficiary_id")
	private Beneficiary beneficiary2;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="infant_eid_lab_id")
	private Facility facility;

	//bi-directional many-to-one association to MasterArtBeneficiaryStatus
	@ManyToOne
	@JoinColumn(name="registration_treatment_status")
	private MasterArtBeneficiaryStatus masterArtBeneficiaryStatus1;

	//bi-directional many-to-one association to MasterArtBeneficiaryStatus
	@ManyToOne
	@JoinColumn(name="art_beneficiary_status_id")
	private MasterArtBeneficiaryStatus masterArtBeneficiaryStatus2;

	//bi-directional many-to-one association to MasterArtTreatmentStatus
	@ManyToOne
	@JoinColumn(name="registration_treatment_status")
	private MasterArtTreatmentStatus masterArtTreatmentStatus;

	//bi-directional many-to-one association to MasterBeneficiaryActivityStatus
	@ManyToOne
	@JoinColumn(name="art_beneficiary_status_id")
	private MasterBeneficiaryActivityStatus masterBeneficiaryActivityStatus;

	//bi-directional many-to-one association to MasterBeneficiaryArtTransferredFrom
	@ManyToOne
	@JoinColumn(name="art_transferred_from")
	private MasterBeneficiaryArtTransferredFrom masterBeneficiaryArtTransferredFrom;

	//bi-directional many-to-one association to MasterEntryPoint
	@ManyToOne
	@JoinColumn(name="entry_point_id")
	private MasterEntryPoint masterEntryPoint;

	//bi-directional many-to-one association to MasterFourSScreening
	@ManyToOne
	@JoinColumn(name="four_s_screening_id")
	private MasterFourSScreening masterFourSScreening;

	//bi-directional many-to-one association to MasterOrganisationType
	@ManyToOne
	@JoinColumn(name="linkage_organisation_type_id")
	private MasterOrganisationType masterOrganisationType;

	//bi-directional many-to-one association to MasterRiskFactor
	@ManyToOne
	@JoinColumn(name="hiv_risk_factor_id")
	private MasterRiskFactor masterRiskFactor;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="entry_user")
	private UserMaster userMaster1;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="assigned_user_id")
	private UserMaster userMaster2;

//	//bi-directional many-to-one association to IctcBeneficiary
//	@OneToMany(mappedBy="artBeneficiary")
//	private Set<IctcBeneficiary> ictcBeneficiaries;

	//bi-directional many-to-one association to IctcVisit
//	@OneToMany(mappedBy="artBeneficiary")
//	private Set<IctcVisit> ictcVisits;

	public ArtBeneficiary() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getArtEligibilityDate() {
		return this.artEligibilityDate;
	}

	public void setArtEligibilityDate(Date artEligibilityDate) {
		this.artEligibilityDate = artEligibilityDate;
	}

	public Date getArtRegistrationDate() {
		return this.artRegistrationDate;
	}

	public void setArtRegistrationDate(Date artRegistrationDate) {
		this.artRegistrationDate = artRegistrationDate;
	}

	public Date getArtStartDate() {
		return this.artStartDate;
	}

	public void setArtStartDate(Date artStartDate) {
		this.artStartDate = artStartDate;
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

	public Integer getFacilityId() {
		return this.facilityId;
	}

	public void setFacilityId(Integer facilityId) {
		this.facilityId = facilityId;
	}

	public Boolean getInfantRegisteredThroughEid() {
		return this.infantRegisteredThroughEid;
	}

	public void setInfantRegisteredThroughEid(Boolean infantRegisteredThroughEid) {
		this.infantRegisteredThroughEid = infantRegisteredThroughEid;
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

	public Boolean getIsTransit() {
		return this.isTransit;
	}

	public void setIsTransit(Boolean isTransit) {
		this.isTransit = isTransit;
	}

	public Boolean getLacLinked() {
		return this.lacLinked;
	}

	public void setLacLinked(Boolean lacLinked) {
		this.lacLinked = lacLinked;
	}

	public String getLinkageInstituteName() {
		return this.linkageInstituteName;
	}

	public void setLinkageInstituteName(String linkageInstituteName) {
		this.linkageInstituteName = linkageInstituteName;
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

	public Date getRecordCreationDate() {
		return this.recordCreationDate;
	}

	public void setRecordCreationDate(Date recordCreationDate) {
		this.recordCreationDate = recordCreationDate;
	}

	public Date getTransitEndDate() {
		return this.transitEndDate;
	}

	public void setTransitEndDate(Date transitEndDate) {
		this.transitEndDate = transitEndDate;
	}

	public Date getTransitStartDate() {
		return this.transitStartDate;
	}

	public void setTransitStartDate(Date transitStartDate) {
		this.transitStartDate = transitStartDate;
	}

	public Beneficiary getBeneficiary1() {
		return this.beneficiary1;
	}

	public void setBeneficiary1(Beneficiary beneficiary1) {
		this.beneficiary1 = beneficiary1;
	}

	public Beneficiary getBeneficiary2() {
		return this.beneficiary2;
	}

	public void setBeneficiary2(Beneficiary beneficiary2) {
		this.beneficiary2 = beneficiary2;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public MasterArtBeneficiaryStatus getMasterArtBeneficiaryStatus1() {
		return this.masterArtBeneficiaryStatus1;
	}

	public void setMasterArtBeneficiaryStatus1(MasterArtBeneficiaryStatus masterArtBeneficiaryStatus1) {
		this.masterArtBeneficiaryStatus1 = masterArtBeneficiaryStatus1;
	}

	public MasterArtBeneficiaryStatus getMasterArtBeneficiaryStatus2() {
		return this.masterArtBeneficiaryStatus2;
	}

	public void setMasterArtBeneficiaryStatus2(MasterArtBeneficiaryStatus masterArtBeneficiaryStatus2) {
		this.masterArtBeneficiaryStatus2 = masterArtBeneficiaryStatus2;
	}

	public MasterArtTreatmentStatus getMasterArtTreatmentStatus() {
		return this.masterArtTreatmentStatus;
	}

	public void setMasterArtTreatmentStatus(MasterArtTreatmentStatus masterArtTreatmentStatus) {
		this.masterArtTreatmentStatus = masterArtTreatmentStatus;
	}

	public MasterBeneficiaryActivityStatus getMasterBeneficiaryActivityStatus() {
		return this.masterBeneficiaryActivityStatus;
	}

	public void setMasterBeneficiaryActivityStatus(MasterBeneficiaryActivityStatus masterBeneficiaryActivityStatus) {
		this.masterBeneficiaryActivityStatus = masterBeneficiaryActivityStatus;
	}

	public MasterBeneficiaryArtTransferredFrom getMasterBeneficiaryArtTransferredFrom() {
		return this.masterBeneficiaryArtTransferredFrom;
	}

	public void setMasterBeneficiaryArtTransferredFrom(MasterBeneficiaryArtTransferredFrom masterBeneficiaryArtTransferredFrom) {
		this.masterBeneficiaryArtTransferredFrom = masterBeneficiaryArtTransferredFrom;
	}

	public MasterEntryPoint getMasterEntryPoint() {
		return this.masterEntryPoint;
	}

	public void setMasterEntryPoint(MasterEntryPoint masterEntryPoint) {
		this.masterEntryPoint = masterEntryPoint;
	}

	public MasterFourSScreening getMasterFourSScreening() {
		return this.masterFourSScreening;
	}

	public void setMasterFourSScreening(MasterFourSScreening masterFourSScreening) {
		this.masterFourSScreening = masterFourSScreening;
	}

	public MasterOrganisationType getMasterOrganisationType() {
		return this.masterOrganisationType;
	}

	public void setMasterOrganisationType(MasterOrganisationType masterOrganisationType) {
		this.masterOrganisationType = masterOrganisationType;
	}

	public MasterRiskFactor getMasterRiskFactor() {
		return this.masterRiskFactor;
	}

	public void setMasterRiskFactor(MasterRiskFactor masterRiskFactor) {
		this.masterRiskFactor = masterRiskFactor;
	}

	public UserMaster getUserMaster1() {
		return this.userMaster1;
	}

	public void setUserMaster1(UserMaster userMaster1) {
		this.userMaster1 = userMaster1;
	}

	public UserMaster getUserMaster2() {
		return this.userMaster2;
	}

	public void setUserMaster2(UserMaster userMaster2) {
		this.userMaster2 = userMaster2;
	}

//	public Set<IctcBeneficiary> getIctcBeneficiaries() {
//		return this.ictcBeneficiaries;
//	}
//
//	public void setIctcBeneficiaries(Set<IctcBeneficiary> ictcBeneficiaries) {
//		this.ictcBeneficiaries = ictcBeneficiaries;
//	}
//
//	public IctcBeneficiary addIctcBeneficiary(IctcBeneficiary ictcBeneficiary) {
//		getIctcBeneficiaries().add(ictcBeneficiary);
//		ictcBeneficiary.setArtBeneficiary(this);
//
//		return ictcBeneficiary;
//	}

//	public IctcBeneficiary removeIctcBeneficiary(IctcBeneficiary ictcBeneficiary) {
//		getIctcBeneficiaries().remove(ictcBeneficiary);
//		ictcBeneficiary.setArtBeneficiary(null);
//
//		return ictcBeneficiary;
//	}

//	public Set<IctcVisit> getIctcVisits() {
//		return this.ictcVisits;
//	}
//
//	public void setIctcVisits(Set<IctcVisit> ictcVisits) {
//		this.ictcVisits = ictcVisits;
//	}
//
//	public IctcVisit addIctcVisit(IctcVisit ictcVisit) {
//		getIctcVisits().add(ictcVisit);
//		ictcVisit.setArtBeneficiary(this);
//
//		return ictcVisit;
//	}
//
//	public IctcVisit removeIctcVisit(IctcVisit ictcVisit) {
//		getIctcVisits().remove(ictcVisit);
//		ictcVisit.setArtBeneficiary(null);
//
//		return ictcVisit;
//	}

}