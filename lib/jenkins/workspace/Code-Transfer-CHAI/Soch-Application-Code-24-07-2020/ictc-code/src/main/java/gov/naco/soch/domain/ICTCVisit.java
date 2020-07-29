package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * A ICTCVisit.
 */
@Entity
@Table(name = "ictc_visit")
public class ICTCVisit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "visit_date")
	private LocalDate visitDate;

	@Column(name = "beneficiary_status")
	private Integer beneficiaryStatus;

	@Column(name = "is_pregnant")
	private Boolean isPregnant;

	@Column(name = "pregnancy_type")
	private Integer pregnancyType;

	@Column(name = "has_tb_symptoms")
	private Boolean hasTbSymptoms;

	@Column(name = "has_sti_rti_symptoms")
	private Boolean hasStiRtiSymptoms;

	@Column(name = "infant_breast_fed")
	private Integer infantBreastFed;

	@Column(name = "arv_prophylaxis")
	private Integer arvProphylaxis;

	@Column(name = "cpt_initiation_date")
	private LocalDate cptInitiationDate;

//	@Column(name = "partner_status_known")
//	private Integer partnerStatusKnown;
//
//	@Column(name = "partner_hiv_status")
//	private Integer partnerHivStatus;

//	@Size(max = 99)
//	@Column(name = "partner_not_tested_reason", length = 99)
//	private String partnerNotTestedReason;
//
//	@Column(name = "partner_test_follow_up_date")
//	private LocalDate partnerTestFollowUpDate;

//	@Column(name = "is_partner_priv_treat_for_hiv")
//	private Boolean isPartnerPrivTreatForHiv;

	@Column(name = "transmission_route")
	private Integer transmissionRoute;

	@Column(name = "pregnancy_lmp_date")
	private LocalDate pregnancyLmpDate;

	@Column(name = "month_of_pregnancy")
	private Integer monthOfPregnancy;

	@Column(name = "expected_delivery_date")
	private LocalDate expectedDeliveryDate;

	@Column(name = "delivery_outcome")
	private Integer deliveryOutcome;

	@Column(name = "delivery_date")
	private LocalDate deliveryDate;

	@Column(name = "gravida")
	private Integer gravida;

	@Column(name = "is_rpq_captured")
	private Boolean isRPQCaptured;
	
	@Column(name = "rpq_survey_id")
	private Long rpqSurveyId;

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

	@Column(name = "is_deleted")
	private Boolean isDeleted;
	
	@Column(name = "is_multi_facility_service")
	private Boolean isMultiFacilityService;

//	@ManyToOne
//	@JoinColumn(name = "partner_art_center_id")
//	private ArtBeneficiary partnerArtCenter;

	@ManyToOne
	@JoinColumn(name = "facility_id")
	private Facility facility;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "ictc_beneficiary_id")
	private ICTCBeneficiary ictcBeneficiary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public Integer getBeneficiaryStatus() {
		return beneficiaryStatus;
	}

	public void setBeneficiaryStatus(Integer beneficiaryStatus) {
		this.beneficiaryStatus = beneficiaryStatus;
	}

	public Boolean getIsPregnant() {
		return isPregnant;
	}

	public void setIsPregnant(Boolean isPregnant) {
		this.isPregnant = isPregnant;
	}

	public Integer getPregnancyType() {
		return pregnancyType;
	}

	public void setPregnancyType(Integer pregnancyType) {
		this.pregnancyType = pregnancyType;
	}

	public Boolean getHasTbSymptoms() {
		return hasTbSymptoms;
	}

	public void setHasTbSymptoms(Boolean hasTbSymptoms) {
		this.hasTbSymptoms = hasTbSymptoms;
	}

	public Boolean getHasStiRtiSymptoms() {
		return hasStiRtiSymptoms;
	}

	public void setHasStiRtiSymptoms(Boolean hasStiRtiSymptoms) {
		this.hasStiRtiSymptoms = hasStiRtiSymptoms;
	}

	public Integer getInfantBreastFed() {
		return infantBreastFed;
	}

	public void setInfantBreastFed(Integer infantBreastFed) {
		this.infantBreastFed = infantBreastFed;
	}

	public Integer getArvProphylaxis() {
		return arvProphylaxis;
	}

	public void setArvProphylaxis(Integer arvProphylaxis) {
		this.arvProphylaxis = arvProphylaxis;
	}

	public LocalDate getCptInitiationDate() {
		return cptInitiationDate;
	}

	public void setCptInitiationDate(LocalDate cptInitiationDate) {
		this.cptInitiationDate = cptInitiationDate;
	}

//	public Integer getPartnerStatusKnown() {
//		return partnerStatusKnown;
//	}
//
//	public void setPartnerStatusKnown(Integer partnerStatusKnown) {
//		this.partnerStatusKnown = partnerStatusKnown;
//	}
//
//	public Integer getPartnerHivStatus() {
//		return partnerHivStatus;
//	}
//
//	public void setPartnerHivStatus(Integer partnerHivStatus) {
//		this.partnerHivStatus = partnerHivStatus;
//	}
//
//	public String getPartnerNotTestedReason() {
//		return partnerNotTestedReason;
//	}
//
//	public void setPartnerNotTestedReason(String partnerNotTestedReason) {
//		this.partnerNotTestedReason = partnerNotTestedReason;
//	}
//
//	public LocalDate getPartnerTestFollowUpDate() {
//		return partnerTestFollowUpDate;
//	}
//
//	public void setPartnerTestFollowUpDate(LocalDate partnerTestFollowUpDate) {
//		this.partnerTestFollowUpDate = partnerTestFollowUpDate;
//	}
//
//	public Boolean getIsPartnerPrivTreatForHiv() {
//		return isPartnerPrivTreatForHiv;
//	}
//
//	public void setIsPartnerPrivTreatForHiv(Boolean isPartnerPrivTreatForHiv) {
//		this.isPartnerPrivTreatForHiv = isPartnerPrivTreatForHiv;
//	}

	public Integer getTransmissionRoute() {
		return transmissionRoute;
	}

	public void setTransmissionRoute(Integer transmissionRoute) {
		this.transmissionRoute = transmissionRoute;
	}

	public LocalDate getPregnancyLmpDate() {
		return pregnancyLmpDate;
	}

	public void setPregnancyLmpDate(LocalDate pregnancyLmpDate) {
		this.pregnancyLmpDate = pregnancyLmpDate;
	}

	public Integer getMonthOfPregnancy() {
		return monthOfPregnancy;
	}

	public void setMonthOfPregnancy(Integer monthOfPregnancy) {
		this.monthOfPregnancy = monthOfPregnancy;
	}

	public LocalDate getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public Integer getDeliveryOutcome() {
		return deliveryOutcome;
	}

	public void setDeliveryOutcome(Integer deliveryOutcome) {
		this.deliveryOutcome = deliveryOutcome;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Integer getGravida() {
		return gravida;
	}

	public void setGravida(Integer gravida) {
		this.gravida = gravida;
	}

	public Boolean getIsRPQCaptured() {
		return isRPQCaptured;
	}

	public void setIsRPQCaptured(Boolean isRPQCaptured) {
		this.isRPQCaptured = isRPQCaptured;
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

//	public ArtBeneficiary getPartnerArtCenter() {
//		return partnerArtCenter;
//	}
//
//	public void setPartnerArtCenter(ArtBeneficiary partnerArtCenter) {
//		this.partnerArtCenter = partnerArtCenter;
//	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public ICTCBeneficiary getIctcBeneficiary() {
		return ictcBeneficiary;
	}

	public void setIctcBeneficiary(ICTCBeneficiary ictcBeneficiary) {
		this.ictcBeneficiary = ictcBeneficiary;
	}

	public ICTCVisit isDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
		return this;
	}
	
	// jhipster-needle-entity-add-getters-setters - JHipster will add getters and
	// setters here, do not remove

	public Long getRpqSurveyId() {
		return rpqSurveyId;
	}

	public void setRpqSurveyId(Long rpqSurveyId) {
		this.rpqSurveyId = rpqSurveyId;
	}
	
	public Boolean getIsMultiFacilityService() {
		return isMultiFacilityService;
	}

	public void setIsMultiFacilityService(Boolean isMultiFacilityService) {
		this.isMultiFacilityService = isMultiFacilityService;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof ICTCVisit)) {
			return false;
		}
		return id != null && id.equals(((ICTCVisit) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		return "ICTCVisit [id=" + id + ", visitDate=" + visitDate + ", beneficiaryStatus=" + beneficiaryStatus
				+ ", isPregnant=" + isPregnant + ", pregnancyType=" + pregnancyType + ", hasTbSymptoms=" + hasTbSymptoms
				+ ", hasStiRtiSymptoms=" + hasStiRtiSymptoms + ", infantBreastFed=" + infantBreastFed
				+ ", arvProphylaxis=" + arvProphylaxis + ", cptInitiationDate=" + cptInitiationDate
				+ ", transmissionRoute=" + transmissionRoute + ", pregnancyLmpDate=" + pregnancyLmpDate
				+ ", monthOfPregnancy=" + monthOfPregnancy + ", expectedDeliveryDate=" + expectedDeliveryDate
				+ ", deliveryOutcome=" + deliveryOutcome + ", deliveryDate=" + deliveryDate + ", gravida=" + gravida
				+ ", isRPQCaptured=" + isRPQCaptured + ", rpqSurveyId=" + rpqSurveyId + ", createdBy=" + createdBy
				+ ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime
				+ ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", isMultiFacilityService="
				+ isMultiFacilityService + ", facility=" + facility + ", ictcBeneficiary=" + ictcBeneficiary + "]";
	}

}
