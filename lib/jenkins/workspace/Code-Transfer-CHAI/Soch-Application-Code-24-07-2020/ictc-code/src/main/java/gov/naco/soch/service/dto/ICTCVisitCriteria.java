package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link gov.naco.soch.domain.ICTCVisit} entity. This class is used
 * in {@link gov.naco.soch.web.rest.ICTCVisitResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ictc-visits?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ICTCVisitCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

	private LocalDateFilter visitDate;

	private IntegerFilter beneficiaryStatus;

	private BooleanFilter isPregnant;

	private IntegerFilter pregnancyType;

	private BooleanFilter hasTbSymptoms;

	private BooleanFilter hasStiRtiSymptoms;

	private IntegerFilter infantBreastFed;

	private IntegerFilter arvProphylaxis;

	private LocalDateFilter cptInitiationDate;
//
//	private IntegerFilter partnerStatusKnown;
//
//	private IntegerFilter partnerHivStatus;
//
//	private StringFilter partnerNotTestedReason;
//
//	private LocalDateFilter partnerTestFollowUpDate;
//
//	private BooleanFilter isPartnerPrivTreatForHiv;

	private IntegerFilter transmissionRoute;

	private LocalDateFilter pregnancyLmpDate;

	private IntegerFilter monthOfPregnancy;

	private LocalDateFilter expectedDeliveryDate;

	private IntegerFilter deliveryOutcome;

	private LocalDateFilter deliveryDate;

	private IntegerFilter gravida;

	private BooleanFilter isRPQCaptured;

	private IntegerFilter createdBy;

	private LocalDateFilter createdTime;

	private IntegerFilter modifiedBy;

	private LocalDateFilter modifiedTime;

	private BooleanFilter isActive;

	private BooleanFilter isDeleted;

//	private LongFilter partnerArtCenterId;

	private LongFilter facilityId;

	private LongFilter ictcBeneficiaryId;

    public ICTCVisitCriteria() {
    }

    public ICTCVisitCriteria(ICTCVisitCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.visitDate = other.visitDate == null ? null : other.visitDate.copy();
        this.beneficiaryStatus = other.beneficiaryStatus == null ? null : other.beneficiaryStatus.copy();
        this.isPregnant = other.isPregnant == null ? null : other.isPregnant.copy();
        this.pregnancyType = other.pregnancyType == null ? null : other.pregnancyType.copy();
        this.hasTbSymptoms = other.hasTbSymptoms == null ? null : other.hasTbSymptoms.copy();
        this.hasStiRtiSymptoms = other.hasStiRtiSymptoms == null ? null : other.hasStiRtiSymptoms.copy();
        this.infantBreastFed = other.infantBreastFed == null ? null : other.infantBreastFed.copy();
        this.arvProphylaxis = other.arvProphylaxis == null ? null : other.arvProphylaxis.copy();
        this.cptInitiationDate = other.cptInitiationDate == null ? null : other.cptInitiationDate.copy();
//        this.partnerStatusKnown = other.partnerStatusKnown == null ? null : other.partnerStatusKnown.copy();
//        this.partnerHivStatus = other.partnerHivStatus == null ? null : other.partnerHivStatus.copy();
//        this.partnerNotTestedReason = other.partnerNotTestedReason == null ? null : other.partnerNotTestedReason.copy();
//        this.partnerTestFollowUpDate = other.partnerTestFollowUpDate == null ? null : other.partnerTestFollowUpDate.copy();
//        this.isPartnerPrivTreatForHiv = other.isPartnerPrivTreatForHiv == null ? null : other.isPartnerPrivTreatForHiv.copy();
        this.transmissionRoute = other.transmissionRoute == null ? null : other.transmissionRoute.copy();
        this.pregnancyLmpDate = other.pregnancyLmpDate == null ? null : other.pregnancyLmpDate.copy();
        this.monthOfPregnancy = other.monthOfPregnancy == null ? null : other.monthOfPregnancy.copy();
        this.expectedDeliveryDate = other.expectedDeliveryDate == null ? null : other.expectedDeliveryDate.copy();
        this.deliveryOutcome = other.deliveryOutcome == null ? null : other.deliveryOutcome.copy();
        this.deliveryDate = other.deliveryDate == null ? null : other.deliveryDate.copy();
        this.gravida = other.gravida == null ? null : other.gravida.copy();
        this.isRPQCaptured = other.isRPQCaptured == null ? null : other.isRPQCaptured.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
        this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
        this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
        this.isActive = other.isActive == null ? null : other.isActive.copy();
        this.isDeleted = other.isDeleted == null ? null : other.isDeleted.copy();
        this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
        this.ictcBeneficiaryId = other.ictcBeneficiaryId == null ? null : other.ictcBeneficiaryId.copy();
//        this.partnerArtCenterId = other.partnerArtCenterId == null ? null : other.partnerArtCenterId.copy();
        
    }

    @Override
    public ICTCVisitCriteria copy() {
        return new ICTCVisitCriteria(this);
    }

    public LongFilter getId() {
		return id;
	}

	public void setId(LongFilter id) {
		this.id = id;
	}

	public LocalDateFilter getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDateFilter visitDate) {
		this.visitDate = visitDate;
	}

	public IntegerFilter getBeneficiaryStatus() {
		return beneficiaryStatus;
	}

	public void setBeneficiaryStatus(IntegerFilter beneficiaryStatus) {
		this.beneficiaryStatus = beneficiaryStatus;
	}

	public BooleanFilter getIsPregnant() {
		return isPregnant;
	}

	public void setIsPregnant(BooleanFilter isPregnant) {
		this.isPregnant = isPregnant;
	}

	public IntegerFilter getPregnancyType() {
		return pregnancyType;
	}

	public void setPregnancyType(IntegerFilter pregnancyType) {
		this.pregnancyType = pregnancyType;
	}

	public BooleanFilter getHasTbSymptoms() {
		return hasTbSymptoms;
	}

	public void setHasTbSymptoms(BooleanFilter hasTbSymptoms) {
		this.hasTbSymptoms = hasTbSymptoms;
	}

	public BooleanFilter getHasStiRtiSymptoms() {
		return hasStiRtiSymptoms;
	}

	public void setHasStiRtiSymptoms(BooleanFilter hasStiRtiSymptoms) {
		this.hasStiRtiSymptoms = hasStiRtiSymptoms;
	}

	public IntegerFilter getInfantBreastFed() {
		return infantBreastFed;
	}

	public void setInfantBreastFed(IntegerFilter infantBreastFed) {
		this.infantBreastFed = infantBreastFed;
	}

	public IntegerFilter getArvProphylaxis() {
		return arvProphylaxis;
	}

	public void setArvProphylaxis(IntegerFilter arvProphylaxis) {
		this.arvProphylaxis = arvProphylaxis;
	}

	public LocalDateFilter getCptInitiationDate() {
		return cptInitiationDate;
	}

	public void setCptInitiationDate(LocalDateFilter cptInitiationDate) {
		this.cptInitiationDate = cptInitiationDate;
	}

//	public IntegerFilter getPartnerStatusKnown() {
//		return partnerStatusKnown;
//	}
//
//	public void setPartnerStatusKnown(IntegerFilter partnerStatusKnown) {
//		this.partnerStatusKnown = partnerStatusKnown;
//	}
//
//	public IntegerFilter getPartnerHivStatus() {
//		return partnerHivStatus;
//	}
//
//	public void setPartnerHivStatus(IntegerFilter partnerHivStatus) {
//		this.partnerHivStatus = partnerHivStatus;
//	}
//
//	public StringFilter getPartnerNotTestedReason() {
//		return partnerNotTestedReason;
//	}
//
//	public void setPartnerNotTestedReason(StringFilter partnerNotTestedReason) {
//		this.partnerNotTestedReason = partnerNotTestedReason;
//	}
//
//	public LocalDateFilter getPartnerTestFollowUpDate() {
//		return partnerTestFollowUpDate;
//	}
//
//	public void setPartnerTestFollowUpDate(LocalDateFilter partnerTestFollowUpDate) {
//		this.partnerTestFollowUpDate = partnerTestFollowUpDate;
//	}
//
//	public BooleanFilter getIsPartnerPrivTreatForHiv() {
//		return isPartnerPrivTreatForHiv;
//	}
//
//	public void setIsPartnerPrivTreatForHiv(BooleanFilter isPartnerPrivTreatForHiv) {
//		this.isPartnerPrivTreatForHiv = isPartnerPrivTreatForHiv;
//	}

	public IntegerFilter getTransmissionRoute() {
		return transmissionRoute;
	}

	public void setTransmissionRoute(IntegerFilter transmissionRoute) {
		this.transmissionRoute = transmissionRoute;
	}

	public LocalDateFilter getPregnancyLmpDate() {
		return pregnancyLmpDate;
	}

	public void setPregnancyLmpDate(LocalDateFilter pregnancyLmpDate) {
		this.pregnancyLmpDate = pregnancyLmpDate;
	}

	public IntegerFilter getMonthOfPregnancy() {
		return monthOfPregnancy;
	}

	public void setMonthOfPregnancy(IntegerFilter monthOfPregnancy) {
		this.monthOfPregnancy = monthOfPregnancy;
	}

	public LocalDateFilter getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(LocalDateFilter expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public IntegerFilter getDeliveryOutcome() {
		return deliveryOutcome;
	}

	public void setDeliveryOutcome(IntegerFilter deliveryOutcome) {
		this.deliveryOutcome = deliveryOutcome;
	}

	public LocalDateFilter getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDateFilter deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public IntegerFilter getGravida() {
		return gravida;
	}

	public void setGravida(IntegerFilter gravida) {
		this.gravida = gravida;
	}

	public BooleanFilter getIsRPQCaptured() {
		return isRPQCaptured;
	}

	public void setIsRPQCaptured(BooleanFilter isRPQCaptured) {
		this.isRPQCaptured = isRPQCaptured;
	}

	public IntegerFilter getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(IntegerFilter createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateFilter getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateFilter createdTime) {
		this.createdTime = createdTime;
	}

	public IntegerFilter getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(IntegerFilter modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateFilter getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateFilter modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public BooleanFilter getIsActive() {
		return isActive;
	}

	public void setIsActive(BooleanFilter isActive) {
		this.isActive = isActive;
	}

	public BooleanFilter getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(BooleanFilter isDeleted) {
		this.isDeleted = isDeleted;
	}

//	public LongFilter getPartnerArtCenterId() {
//		return partnerArtCenterId;
//	}
//
//	public void setPartnerArtCenterId(LongFilter partnerArtCenterId) {
//		this.partnerArtCenterId = partnerArtCenterId;
//	}

	public LongFilter getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(LongFilter facilityId) {
		this.facilityId = facilityId;
	}

	public LongFilter getIctcBeneficiaryId() {
		return ictcBeneficiaryId;
	}

	public void setIctcBeneficiaryId(LongFilter ictcBeneficiaryId) {
		this.ictcBeneficiaryId = ictcBeneficiaryId;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(arvProphylaxis, beneficiaryStatus, cptInitiationDate, createdBy, createdTime, deliveryDate,
				deliveryOutcome, expectedDeliveryDate, facilityId, gravida, hasStiRtiSymptoms, hasTbSymptoms,
				ictcBeneficiaryId, id, infantBreastFed, isActive, isDeleted, isPregnant, isRPQCaptured, modifiedBy,
				modifiedTime, monthOfPregnancy, pregnancyLmpDate, pregnancyType, transmissionRoute, visitDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ICTCVisitCriteria other = (ICTCVisitCriteria) obj;
		return Objects.equals(arvProphylaxis, other.arvProphylaxis)
				&& Objects.equals(beneficiaryStatus, other.beneficiaryStatus)
				&& Objects.equals(cptInitiationDate, other.cptInitiationDate)
				&& Objects.equals(createdBy, other.createdBy) && Objects.equals(createdTime, other.createdTime)
				&& Objects.equals(deliveryDate, other.deliveryDate)
				&& Objects.equals(deliveryOutcome, other.deliveryOutcome)
				&& Objects.equals(expectedDeliveryDate, other.expectedDeliveryDate)
				&& Objects.equals(facilityId, other.facilityId) && Objects.equals(gravida, other.gravida)
				&& Objects.equals(hasStiRtiSymptoms, other.hasStiRtiSymptoms)
				&& Objects.equals(hasTbSymptoms, other.hasTbSymptoms)
				&& Objects.equals(ictcBeneficiaryId, other.ictcBeneficiaryId) && Objects.equals(id, other.id)
				&& Objects.equals(infantBreastFed, other.infantBreastFed) && Objects.equals(isActive, other.isActive)
				&& Objects.equals(isDeleted, other.isDeleted) && Objects.equals(isPregnant, other.isPregnant)
				&& Objects.equals(isRPQCaptured, other.isRPQCaptured) && Objects.equals(modifiedBy, other.modifiedBy)
				&& Objects.equals(modifiedTime, other.modifiedTime)
				&& Objects.equals(monthOfPregnancy, other.monthOfPregnancy)
				&& Objects.equals(pregnancyLmpDate, other.pregnancyLmpDate)
				&& Objects.equals(pregnancyType, other.pregnancyType)
				&& Objects.equals(transmissionRoute, other.transmissionRoute)
				&& Objects.equals(visitDate, other.visitDate);
	}

	@Override
	public String toString() {
		return "ICTCVisitCriteria [id=" + id + ", visitDate=" + visitDate + ", beneficiaryStatus=" + beneficiaryStatus
				+ ", isPregnant=" + isPregnant + ", pregnancyType=" + pregnancyType + ", hasTbSymptoms=" + hasTbSymptoms
				+ ", hasStiRtiSymptoms=" + hasStiRtiSymptoms + ", infantBreastFed=" + infantBreastFed
				+ ", arvProphylaxis=" + arvProphylaxis + ", cptInitiationDate=" + cptInitiationDate
				+ ", transmissionRoute=" + transmissionRoute + ", pregnancyLmpDate=" + pregnancyLmpDate
				+ ", monthOfPregnancy=" + monthOfPregnancy + ", expectedDeliveryDate=" + expectedDeliveryDate
				+ ", deliveryOutcome=" + deliveryOutcome + ", deliveryDate=" + deliveryDate + ", gravida=" + gravida
				+ ", isRPQCaptured=" + isRPQCaptured + ", createdBy=" + createdBy + ", createdTime=" + createdTime
				+ ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime + ", isActive=" + isActive
				+ ", isDeleted=" + isDeleted + ", facilityId=" + facilityId + ", ictcBeneficiaryId=" + ictcBeneficiaryId
				+ "]";
	}

}
