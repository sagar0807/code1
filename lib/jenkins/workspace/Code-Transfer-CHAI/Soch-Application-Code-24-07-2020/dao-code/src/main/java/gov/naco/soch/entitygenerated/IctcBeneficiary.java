package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the ictc_beneficiary database table.
 * 
 */
@Entity
@Table(name="ictc_beneficiary")
@NamedQuery(name="IctcBeneficiary.findAll", query="SELECT i FROM IctcBeneficiary i")
public class IctcBeneficiary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="art_referral_id")
	private Long artReferralId;

	@Column(name="art_referral_name")
	private String artReferralName;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="current_test_result_id")
	private Long currentTestResultId;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_start_of_anti_tb_treatment")
	private Date dateOfStartOfAntiTbTreatment;

	@Column(name="deleted_reason")
	private Integer deletedReason;

	@Column(name="deleted_reason_comment")
	private String deletedReasonComment;

	@Column(name="dsrc_referral_id")
	private Long dsrcReferralId;

	@Column(name="dsrc_referral_name")
	private String dsrcReferralName;

	@Column(name="infant_code")
	private String infantCode;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_consent_documented")
	private Boolean isConsentDocumented;

	@Column(name="is_deleted")
	private Boolean isDeleted;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="on_syphilis_treatment")
	private Boolean onSyphilisTreatment;

	@Column(name="on_tb_treatment")
	private Boolean onTbTreatment;

	private String pid;

	@Column(name="recent_visit_id")
	private Long recentVisitId;

	@Column(name="referred_by")
	private Integer referredBy;

	@Temporal(TemporalType.DATE)
	@Column(name="registration_date")
	private Date registrationDate;

//	@Column(name="relationship_record_id")
//	private Long relationshipRecordId;
//
//	@Column(name="relationship_type")
//	private Integer relationshipType;

	@Column(name="rntcp_referral_id")
	private Long rntcpReferralId;

	@Column(name="rntcp_referral_name")
	private String rntcpReferralName;

	@Column(name="ti_referral_id")
	private Long tiReferralId;

	@Column(name="ti_referral_name")
	private String tiReferralName;

//	//bi-directional many-to-one association to ArtBeneficiary
//	@ManyToOne
//	@JoinColumn(name="infant_mother_art_id")
//	private ArtBeneficiary artBeneficiary;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to IctcFollowUp
	@OneToMany(mappedBy="ictcBeneficiary")
	private Set<IctcFollowUp> ictcFollowUps;

	//bi-directional many-to-one association to IctcPartnerDetail
	@OneToMany(mappedBy="ictcBeneficiary")
	private Set<IctcPartnerDetail> ictcPartnerDetails;

	//bi-directional many-to-one association to IctcSampleCollection
	@OneToMany(mappedBy="ictcBeneficiary")
	private Set<IctcSampleCollection> ictcSampleCollections;

	//bi-directional many-to-one association to IctcTestResult
	@OneToMany(mappedBy="ictcBeneficiary")
	private Set<IctcTestResult> ictcTestResults;

	//bi-directional many-to-one association to IctcVisit
	@OneToMany(mappedBy="ictcBeneficiary")
	private Set<IctcVisit> ictcVisits;

	public IctcBeneficiary() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getArtReferralId() {
		return this.artReferralId;
	}

	public void setArtReferralId(Long artReferralId) {
		this.artReferralId = artReferralId;
	}

	public String getArtReferralName() {
		return this.artReferralName;
	}

	public void setArtReferralName(String artReferralName) {
		this.artReferralName = artReferralName;
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

	public Long getCurrentTestResultId() {
		return this.currentTestResultId;
	}

	public void setCurrentTestResultId(Long currentTestResultId) {
		this.currentTestResultId = currentTestResultId;
	}

	public Date getDateOfStartOfAntiTbTreatment() {
		return this.dateOfStartOfAntiTbTreatment;
	}

	public void setDateOfStartOfAntiTbTreatment(Date dateOfStartOfAntiTbTreatment) {
		this.dateOfStartOfAntiTbTreatment = dateOfStartOfAntiTbTreatment;
	}

	public Integer getDeletedReason() {
		return this.deletedReason;
	}

	public void setDeletedReason(Integer deletedReason) {
		this.deletedReason = deletedReason;
	}

	public String getDeletedReasonComment() {
		return this.deletedReasonComment;
	}

	public void setDeletedReasonComment(String deletedReasonComment) {
		this.deletedReasonComment = deletedReasonComment;
	}

	public Long getDsrcReferralId() {
		return this.dsrcReferralId;
	}

	public void setDsrcReferralId(Long dsrcReferralId) {
		this.dsrcReferralId = dsrcReferralId;
	}

	public String getDsrcReferralName() {
		return this.dsrcReferralName;
	}

	public void setDsrcReferralName(String dsrcReferralName) {
		this.dsrcReferralName = dsrcReferralName;
	}

	public String getInfantCode() {
		return this.infantCode;
	}

	public void setInfantCode(String infantCode) {
		this.infantCode = infantCode;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsConsentDocumented() {
		return this.isConsentDocumented;
	}

	public void setIsConsentDocumented(Boolean isConsentDocumented) {
		this.isConsentDocumented = isConsentDocumented;
	}

	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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

	public Boolean getOnSyphilisTreatment() {
		return this.onSyphilisTreatment;
	}

	public void setOnSyphilisTreatment(Boolean onSyphilisTreatment) {
		this.onSyphilisTreatment = onSyphilisTreatment;
	}

	public Boolean getOnTbTreatment() {
		return this.onTbTreatment;
	}

	public void setOnTbTreatment(Boolean onTbTreatment) {
		this.onTbTreatment = onTbTreatment;
	}

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Long getRecentVisitId() {
		return this.recentVisitId;
	}

	public void setRecentVisitId(Long recentVisitId) {
		this.recentVisitId = recentVisitId;
	}

	public Integer getReferredBy() {
		return this.referredBy;
	}

	public void setReferredBy(Integer referredBy) {
		this.referredBy = referredBy;
	}

	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

//	public Long getRelationshipRecordId() {
//		return this.relationshipRecordId;
//	}
//
//	public void setRelationshipRecordId(Long relationshipRecordId) {
//		this.relationshipRecordId = relationshipRecordId;
//	}
//
//	public Integer getRelationshipType() {
//		return this.relationshipType;
//	}
//
//	public void setRelationshipType(Integer relationshipType) {
//		this.relationshipType = relationshipType;
//	}

	public Long getRntcpReferralId() {
		return this.rntcpReferralId;
	}

	public void setRntcpReferralId(Long rntcpReferralId) {
		this.rntcpReferralId = rntcpReferralId;
	}

	public String getRntcpReferralName() {
		return this.rntcpReferralName;
	}

	public void setRntcpReferralName(String rntcpReferralName) {
		this.rntcpReferralName = rntcpReferralName;
	}

	public Long getTiReferralId() {
		return this.tiReferralId;
	}

	public void setTiReferralId(Long tiReferralId) {
		this.tiReferralId = tiReferralId;
	}

	public String getTiReferralName() {
		return this.tiReferralName;
	}

	public void setTiReferralName(String tiReferralName) {
		this.tiReferralName = tiReferralName;
	}

//	public ArtBeneficiary getArtBeneficiary() {
//		return this.artBeneficiary;
//	}
//
//	public void setArtBeneficiary(ArtBeneficiary artBeneficiary) {
//		this.artBeneficiary = artBeneficiary;
//	}

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Set<IctcFollowUp> getIctcFollowUps() {
		return this.ictcFollowUps;
	}

	public void setIctcFollowUps(Set<IctcFollowUp> ictcFollowUps) {
		this.ictcFollowUps = ictcFollowUps;
	}

	public IctcFollowUp addIctcFollowUp(IctcFollowUp ictcFollowUp) {
		getIctcFollowUps().add(ictcFollowUp);
		ictcFollowUp.setIctcBeneficiary(this);

		return ictcFollowUp;
	}

	public IctcFollowUp removeIctcFollowUp(IctcFollowUp ictcFollowUp) {
		getIctcFollowUps().remove(ictcFollowUp);
		ictcFollowUp.setIctcBeneficiary(null);

		return ictcFollowUp;
	}

	public Set<IctcPartnerDetail> getIctcPartnerDetails() {
		return this.ictcPartnerDetails;
	}

	public void setIctcPartnerDetails(Set<IctcPartnerDetail> ictcPartnerDetails) {
		this.ictcPartnerDetails = ictcPartnerDetails;
	}

	public IctcPartnerDetail addIctcPartnerDetail(IctcPartnerDetail ictcPartnerDetail) {
		getIctcPartnerDetails().add(ictcPartnerDetail);
		ictcPartnerDetail.setIctcBeneficiary(this);

		return ictcPartnerDetail;
	}

	public IctcPartnerDetail removeIctcPartnerDetail(IctcPartnerDetail ictcPartnerDetail) {
		getIctcPartnerDetails().remove(ictcPartnerDetail);
		ictcPartnerDetail.setIctcBeneficiary(null);

		return ictcPartnerDetail;
	}

	public Set<IctcSampleCollection> getIctcSampleCollections() {
		return this.ictcSampleCollections;
	}

	public void setIctcSampleCollections(Set<IctcSampleCollection> ictcSampleCollections) {
		this.ictcSampleCollections = ictcSampleCollections;
	}

	public IctcSampleCollection addIctcSampleCollection(IctcSampleCollection ictcSampleCollection) {
		getIctcSampleCollections().add(ictcSampleCollection);
		ictcSampleCollection.setIctcBeneficiary(this);

		return ictcSampleCollection;
	}

	public IctcSampleCollection removeIctcSampleCollection(IctcSampleCollection ictcSampleCollection) {
		getIctcSampleCollections().remove(ictcSampleCollection);
		ictcSampleCollection.setIctcBeneficiary(null);

		return ictcSampleCollection;
	}

	public Set<IctcTestResult> getIctcTestResults() {
		return this.ictcTestResults;
	}

	public void setIctcTestResults(Set<IctcTestResult> ictcTestResults) {
		this.ictcTestResults = ictcTestResults;
	}

	public IctcTestResult addIctcTestResult(IctcTestResult ictcTestResult) {
		getIctcTestResults().add(ictcTestResult);
		ictcTestResult.setIctcBeneficiary(this);

		return ictcTestResult;
	}

	public IctcTestResult removeIctcTestResult(IctcTestResult ictcTestResult) {
		getIctcTestResults().remove(ictcTestResult);
		ictcTestResult.setIctcBeneficiary(null);

		return ictcTestResult;
	}

	public Set<IctcVisit> getIctcVisits() {
		return this.ictcVisits;
	}

	public void setIctcVisits(Set<IctcVisit> ictcVisits) {
		this.ictcVisits = ictcVisits;
	}

	public IctcVisit addIctcVisit(IctcVisit ictcVisit) {
		getIctcVisits().add(ictcVisit);
		ictcVisit.setIctcBeneficiary(this);

		return ictcVisit;
	}

	public IctcVisit removeIctcVisit(IctcVisit ictcVisit) {
		getIctcVisits().remove(ictcVisit);
		ictcVisit.setIctcBeneficiary(null);

		return ictcVisit;
	}

}