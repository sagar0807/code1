package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.ICTCVisit} entity.
 */
public class ICTCVisitDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
    
	private Long id;

	private LocalDate visitDate;

	private Integer beneficiaryStatus;

	private Boolean isPregnant;

	private Integer pregnancyType;

	private Boolean hasTbSymptoms;

	private Boolean hasStiRtiSymptoms;

	private Integer infantBreastFed;

	private Integer arvProphylaxis;

	private LocalDate cptInitiationDate;

//	private Integer partnerStatusKnown;
//
//	private Integer partnerHivStatus;
//
//	private String partnerNotTestedReason;
//
//	private LocalDate partnerTestFollowUpDate;
//
//	private Boolean isPartnerPrivTreatForHiv;

	private Integer transmissionRoute;

	private LocalDate pregnancyLmpDate;

	private Integer monthOfPregnancy;

	private LocalDate expectedDeliveryDate;

	private Integer deliveryOutcome;

	private LocalDate deliveryDate;

	private Integer gravida;

	private Boolean isRPQCaptured;
	
	private Long rpqSurveyId;

	private Integer createdBy;

	private LocalDate createdTime;

	private Integer modifiedBy;

	private LocalDate modifiedTime;

	private Boolean isActive;

	private Boolean isDeleted;
	
	private Boolean isMultiFacilityService;

//	private Long partnerArtCenterId;

	private Long facilityId;

	private Long ictcBeneficiaryId;
	
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

//	public Long getPartnerArtCenterId() {
//		return partnerArtCenterId;
//	}
//
//	public void setPartnerArtCenterId(Long partnerArtCenterId) {
//		this.partnerArtCenterId = partnerArtCenterId;
//	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public Long getIctcBeneficiaryId() {
		return ictcBeneficiaryId;
	}

	public void setIctcBeneficiaryId(Long ictcBeneficiaryId) {
		this.ictcBeneficiaryId = ictcBeneficiaryId;
	}
	
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
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ICTCVisitDTO iCTCVisitDTO = (ICTCVisitDTO) o;
        if (iCTCVisitDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), iCTCVisitDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "ICTCVisitDTO [id=" + id + ", visitDate=" + visitDate + ", beneficiaryStatus=" + beneficiaryStatus
				+ ", isPregnant=" + isPregnant + ", pregnancyType=" + pregnancyType + ", hasTbSymptoms=" + hasTbSymptoms
				+ ", hasStiRtiSymptoms=" + hasStiRtiSymptoms + ", infantBreastFed=" + infantBreastFed
				+ ", arvProphylaxis=" + arvProphylaxis + ", cptInitiationDate=" + cptInitiationDate
				+ ", transmissionRoute=" + transmissionRoute + ", pregnancyLmpDate=" + pregnancyLmpDate
				+ ", monthOfPregnancy=" + monthOfPregnancy + ", expectedDeliveryDate=" + expectedDeliveryDate
				+ ", deliveryOutcome=" + deliveryOutcome + ", deliveryDate=" + deliveryDate + ", gravida=" + gravida
				+ ", isRPQCaptured=" + isRPQCaptured + ", rpqSurveyId=" + rpqSurveyId + ", createdBy=" + createdBy
				+ ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime
				+ ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", isMultiFacilityService="
				+ isMultiFacilityService + ", facilityId=" + facilityId + ", ictcBeneficiaryId=" + ictcBeneficiaryId
				+ "]";
	}

}
