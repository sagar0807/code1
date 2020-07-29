package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the ictc_visit database table.
 * 
 */
@Entity
@Table(name="ictc_visit")
@NamedQuery(name="IctcVisit.findAll", query="SELECT i FROM IctcVisit i")
public class IctcVisit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="arv_prophylaxis")
	private Integer arvProphylaxis;

	@Column(name="beneficiary_status")
	private Integer beneficiaryStatus;

	@Temporal(TemporalType.DATE)
	@Column(name="cpt_initiation_date")
	private Date cptInitiationDate;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Temporal(TemporalType.DATE)
	@Column(name="delivery_date")
	private Date deliveryDate;

	@Column(name="delivery_outcome")
	private Integer deliveryOutcome;

	@Temporal(TemporalType.DATE)
	@Column(name="expected_delivery_date")
	private Date expectedDeliveryDate;

	private Integer gravida;

	@Column(name="has_sti_rti_symptoms")
	private Boolean hasStiRtiSymptoms;

	@Column(name="has_tb_symptoms")
	private Boolean hasTbSymptoms;

	@Column(name="infant_breast_fed")
	private Integer infantBreastFed;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_deleted")
	private Boolean isDeleted;

	@Column(name="is_pregnant")
	private Boolean isPregnant;

	@Column(name="is_rpq_captured")
	private Boolean isRpqCaptured;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="month_of_pregnancy")
	private Integer monthOfPregnancy;
	
//	@Column(name="is_partner_priv_treat_for_hiv")
//	private Boolean isPartnerPrivTreatForHiv;

//	@Column(name="partner_hiv_status")
//	private Integer partnerHivStatus;
//
//	@Column(name="partner_not_tested_reason")
//	private String partnerNotTestedReason;
//
//	@Column(name="partner_status_known")
//	private Integer partnerStatusKnown;

//	@Temporal(TemporalType.DATE)
//	@Column(name="partner_test_follow_up_date")
//	private Date partnerTestFollowUpDate;

	@Temporal(TemporalType.DATE)
	@Column(name="pregnancy_lmp_date")
	private Date pregnancyLmpDate;

	@Column(name="pregnancy_type")
	private Integer pregnancyType;

	@Column(name="rpq_survey_id")
	private Long rpqSurveyId;

	@Column(name="transmission_route")
	private Integer transmissionRoute;

	@Temporal(TemporalType.DATE)
	@Column(name="visit_date")
	private Date visitDate;

	//bi-directional many-to-one association to IctcFollowUp
	@OneToMany(mappedBy="ictcVisit")
	private Set<IctcFollowUp> ictcFollowUps;

	//bi-directional many-to-one association to IctcSampleCollection
	@OneToMany(mappedBy="ictcVisit")
	private Set<IctcSampleCollection> ictcSampleCollections;

	//bi-directional many-to-one association to IctcTestResult
	@OneToMany(mappedBy="ictcVisit")
	private Set<IctcTestResult> ictcTestResults;

//	//bi-directional many-to-one association to ArtBeneficiary
//	@ManyToOne
//	@JoinColumn(name="partner_art_center_id")
//	private ArtBeneficiary artBeneficiary;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to IctcBeneficiary
	@ManyToOne
	@JoinColumn(name="ictc_beneficiary_id")
	private IctcBeneficiary ictcBeneficiary;

	public IctcVisit() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getArvProphylaxis() {
		return this.arvProphylaxis;
	}

	public void setArvProphylaxis(Integer arvProphylaxis) {
		this.arvProphylaxis = arvProphylaxis;
	}

	public Integer getBeneficiaryStatus() {
		return this.beneficiaryStatus;
	}

	public void setBeneficiaryStatus(Integer beneficiaryStatus) {
		this.beneficiaryStatus = beneficiaryStatus;
	}

	public Date getCptInitiationDate() {
		return this.cptInitiationDate;
	}

	public void setCptInitiationDate(Date cptInitiationDate) {
		this.cptInitiationDate = cptInitiationDate;
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

	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Integer getDeliveryOutcome() {
		return this.deliveryOutcome;
	}

	public void setDeliveryOutcome(Integer deliveryOutcome) {
		this.deliveryOutcome = deliveryOutcome;
	}

	public Date getExpectedDeliveryDate() {
		return this.expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public Integer getGravida() {
		return this.gravida;
	}

	public void setGravida(Integer gravida) {
		this.gravida = gravida;
	}

	public Boolean getHasStiRtiSymptoms() {
		return this.hasStiRtiSymptoms;
	}

	public void setHasStiRtiSymptoms(Boolean hasStiRtiSymptoms) {
		this.hasStiRtiSymptoms = hasStiRtiSymptoms;
	}

	public Boolean getHasTbSymptoms() {
		return this.hasTbSymptoms;
	}

	public void setHasTbSymptoms(Boolean hasTbSymptoms) {
		this.hasTbSymptoms = hasTbSymptoms;
	}

	public Integer getInfantBreastFed() {
		return this.infantBreastFed;
	}

	public void setInfantBreastFed(Integer infantBreastFed) {
		this.infantBreastFed = infantBreastFed;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

//	public Boolean getIsPartnerPrivTreatForHiv() {
//		return this.isPartnerPrivTreatForHiv;
//	}
//
//	public void setIsPartnerPrivTreatForHiv(Boolean isPartnerPrivTreatForHiv) {
//		this.isPartnerPrivTreatForHiv = isPartnerPrivTreatForHiv;
//	}

	public Boolean getIsPregnant() {
		return this.isPregnant;
	}

	public void setIsPregnant(Boolean isPregnant) {
		this.isPregnant = isPregnant;
	}

	public Boolean getIsRpqCaptured() {
		return this.isRpqCaptured;
	}

	public void setIsRpqCaptured(Boolean isRpqCaptured) {
		this.isRpqCaptured = isRpqCaptured;
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

	public Integer getMonthOfPregnancy() {
		return this.monthOfPregnancy;
	}

	public void setMonthOfPregnancy(Integer monthOfPregnancy) {
		this.monthOfPregnancy = monthOfPregnancy;
	}

//	public Integer getPartnerHivStatus() {
//		return this.partnerHivStatus;
//	}
//
//	public void setPartnerHivStatus(Integer partnerHivStatus) {
//		this.partnerHivStatus = partnerHivStatus;
//	}
//
//	public String getPartnerNotTestedReason() {
//		return this.partnerNotTestedReason;
//	}
//
//	public void setPartnerNotTestedReason(String partnerNotTestedReason) {
//		this.partnerNotTestedReason = partnerNotTestedReason;
//	}
//
//	public Integer getPartnerStatusKnown() {
//		return this.partnerStatusKnown;
//	}
//
//	public void setPartnerStatusKnown(Integer partnerStatusKnown) {
//		this.partnerStatusKnown = partnerStatusKnown;
//	}
//
//	public Date getPartnerTestFollowUpDate() {
//		return this.partnerTestFollowUpDate;
//	}
//
//	public void setPartnerTestFollowUpDate(Date partnerTestFollowUpDate) {
//		this.partnerTestFollowUpDate = partnerTestFollowUpDate;
//	}

	public Date getPregnancyLmpDate() {
		return this.pregnancyLmpDate;
	}

	public void setPregnancyLmpDate(Date pregnancyLmpDate) {
		this.pregnancyLmpDate = pregnancyLmpDate;
	}

	public Integer getPregnancyType() {
		return this.pregnancyType;
	}

	public void setPregnancyType(Integer pregnancyType) {
		this.pregnancyType = pregnancyType;
	}

	public Long getRpqSurveyId() {
		return this.rpqSurveyId;
	}

	public void setRpqSurveyId(Long rpqSurveyId) {
		this.rpqSurveyId = rpqSurveyId;
	}

	public Integer getTransmissionRoute() {
		return this.transmissionRoute;
	}

	public void setTransmissionRoute(Integer transmissionRoute) {
		this.transmissionRoute = transmissionRoute;
	}

	public Date getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Set<IctcFollowUp> getIctcFollowUps() {
		return this.ictcFollowUps;
	}

	public void setIctcFollowUps(Set<IctcFollowUp> ictcFollowUps) {
		this.ictcFollowUps = ictcFollowUps;
	}

	public IctcFollowUp addIctcFollowUp(IctcFollowUp ictcFollowUp) {
		getIctcFollowUps().add(ictcFollowUp);
		ictcFollowUp.setIctcVisit(this);

		return ictcFollowUp;
	}

	public IctcFollowUp removeIctcFollowUp(IctcFollowUp ictcFollowUp) {
		getIctcFollowUps().remove(ictcFollowUp);
		ictcFollowUp.setIctcVisit(null);

		return ictcFollowUp;
	}

	public Set<IctcSampleCollection> getIctcSampleCollections() {
		return this.ictcSampleCollections;
	}

	public void setIctcSampleCollections(Set<IctcSampleCollection> ictcSampleCollections) {
		this.ictcSampleCollections = ictcSampleCollections;
	}

	public IctcSampleCollection addIctcSampleCollection(IctcSampleCollection ictcSampleCollection) {
		getIctcSampleCollections().add(ictcSampleCollection);
		ictcSampleCollection.setIctcVisit(this);

		return ictcSampleCollection;
	}

	public IctcSampleCollection removeIctcSampleCollection(IctcSampleCollection ictcSampleCollection) {
		getIctcSampleCollections().remove(ictcSampleCollection);
		ictcSampleCollection.setIctcVisit(null);

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
		ictcTestResult.setIctcVisit(this);

		return ictcTestResult;
	}

	public IctcTestResult removeIctcTestResult(IctcTestResult ictcTestResult) {
		getIctcTestResults().remove(ictcTestResult);
		ictcTestResult.setIctcVisit(null);

		return ictcTestResult;
	}

//	public ArtBeneficiary getArtBeneficiary() {
//		return this.artBeneficiary;
//	}
//
//	public void setArtBeneficiary(ArtBeneficiary artBeneficiary) {
//		this.artBeneficiary = artBeneficiary;
//	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public IctcBeneficiary getIctcBeneficiary() {
		return this.ictcBeneficiary;
	}

	public void setIctcBeneficiary(IctcBeneficiary ictcBeneficiary) {
		this.ictcBeneficiary = ictcBeneficiary;
	}

}