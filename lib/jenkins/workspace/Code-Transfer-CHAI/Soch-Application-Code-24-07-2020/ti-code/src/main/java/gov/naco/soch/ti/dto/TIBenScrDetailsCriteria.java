package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link gov.naco.soch.domain.TIBenScrDetails} entity.
 * This class is used in {@link gov.naco.soch.web.rest.TIBenScrDetailsResource}
 * to receive all the possible filtering options from the Http GET request
 * parameters. For example the following could be a valid request:
 * {@code /ti-ben-scr-details?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific
 * {@link Filter} class are used, we need to use fix type specific filters.
 */
public class TIBenScrDetailsCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private LongFilter facilityId;

    private StringFilter infection;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private ZonedDateTimeFilter dateOfScreening;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateFilter nextDateOfScreening;

    private StringFilter screeningStatusHiv;

    private StringFilter screeningStatusSyphilis;

    private BooleanFilter prolongedCoughGreaterThanThreeWeeks;

    private BooleanFilter presenceOfSweatGreaterThanThreeWeeks;

    private BooleanFilter weightlossGreaterThan3kgInLastFourWeeks;

    private BooleanFilter feverGreaterThanThreeWeeks;

    private StringFilter currentHivStatus;

    private StringFilter currentSyphilis;

    private StringFilter tbStatus;

    private LocalDateFilter lastRiskVulnerabilityAssessment;
    
    private BooleanFilter isActive;

    private BooleanFilter isDeleted;

    private IntegerFilter createdBy;

    private ZonedDateTimeFilter createdTime;

    private IntegerFilter modifiedBy;

    private ZonedDateTimeFilter modifiedTime;

    private LongFilter beneficiaryId;

    private StringFilter clientStatus;

    private StringFilter param;

    private StringFilter gender;

    private StringFilter typology;

    private LongFilter hrgPrimaryCategory;

    private BooleanFilter isActiveFacility;
    
    private BooleanFilter isEarly;
    
    private LongFilter status;

    public TIBenScrDetailsCriteria() {
    }

    public TIBenScrDetailsCriteria(TIBenScrDetailsCriteria other) {
	this.id = other.id == null ? null : other.id.copy();
	this.infection = other.infection == null ? null : other.infection.copy();
	this.dateOfScreening = other.dateOfScreening == null ? null : other.dateOfScreening.copy();
	this.nextDateOfScreening = other.nextDateOfScreening == null ? null : other.nextDateOfScreening.copy();
	this.screeningStatusHiv = other.screeningStatusHiv == null ? null : other.screeningStatusHiv.copy();
	this.screeningStatusSyphilis = other.screeningStatusSyphilis == null ? null
		: other.screeningStatusSyphilis.copy();
	this.prolongedCoughGreaterThanThreeWeeks = other.prolongedCoughGreaterThanThreeWeeks == null ? null
		: other.prolongedCoughGreaterThanThreeWeeks.copy();
	this.presenceOfSweatGreaterThanThreeWeeks = other.presenceOfSweatGreaterThanThreeWeeks == null ? null
		: other.presenceOfSweatGreaterThanThreeWeeks.copy();
	this.weightlossGreaterThan3kgInLastFourWeeks = other.weightlossGreaterThan3kgInLastFourWeeks == null ? null
		: other.weightlossGreaterThan3kgInLastFourWeeks.copy();
	this.feverGreaterThanThreeWeeks = other.feverGreaterThanThreeWeeks == null ? null
		: other.feverGreaterThanThreeWeeks.copy();
	this.currentHivStatus = other.currentHivStatus == null ? null : other.currentHivStatus.copy();
	this.currentSyphilis = other.currentSyphilis == null ? null : other.currentSyphilis.copy();
	this.tbStatus = other.tbStatus == null ? null : other.tbStatus.copy();
	this.lastRiskVulnerabilityAssessment = other.lastRiskVulnerabilityAssessment == null ? null
		: other.lastRiskVulnerabilityAssessment.copy();
	this.status = other.status == null ? null : other.status.copy();
	this.isActive = other.isActive == null ? null : other.isActive.copy();
	this.isDeleted = other.isDeleted == null ? null : other.isDeleted.copy();
	this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
	this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
	this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
	this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
	this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
	this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
	this.clientStatus = other.clientStatus == null ? null : other.clientStatus.copy();
	this.param = other.param == null ? null : other.param.copy();
	this.gender = other.gender == null ? null : other.gender.copy();
	this.typology = other.typology == null ? null : other.typology.copy();
	this.hrgPrimaryCategory = other.hrgPrimaryCategory == null ? null : other.hrgPrimaryCategory.copy();
	this.isActiveFacility = other.isActiveFacility == null ? null : other.isActiveFacility.copy();
	this.isEarly = other.isEarly == null ? null : other.isEarly.copy();
    }

    @Override
    public TIBenScrDetailsCriteria copy() {
	return new TIBenScrDetailsCriteria(this);
    }

    public LongFilter getId() {
	return id;
    }

    public void setId(LongFilter id) {
	this.id = id;
    }

    public StringFilter getParam() {
	return param;
    }

    public void setParam(StringFilter param) {
	this.param = param;
    }

    public StringFilter getGender() {
	return gender;
    }

    public void setGender(StringFilter gender) {
	this.gender = gender;
    }

    public StringFilter getTypology() {
	return typology;
    }

    public void setTypology(StringFilter typology) {
	this.typology = typology;
    }

    public StringFilter getInfection() {
	return infection;
    }

    public void setInfection(StringFilter infection) {
	this.infection = infection;
    }

    public ZonedDateTimeFilter getDateOfScreening() {
	return dateOfScreening;
    }

    public void setDateOfScreening(ZonedDateTimeFilter dateOfScreening) {
	this.dateOfScreening = dateOfScreening;
    }

    public LocalDateFilter getNextDateOfScreening() {
	return nextDateOfScreening;
    }

    public void setNextDateOfScreening(LocalDateFilter nextDateOfScreening) {
	this.nextDateOfScreening = nextDateOfScreening;
    }

    public LongFilter getFacilityId() {
	return facilityId;
    }

    public void setFacilityId(LongFilter facilityId) {
	this.facilityId = facilityId;
    }

    public LongFilter getStatus() {
        return status;
    }

    public void setStatus(LongFilter status) {
        this.status = status;
    }

    public StringFilter getScreeningStatusHiv() {
	return screeningStatusHiv;
    }

    public void setScreeningStatusHiv(StringFilter screeningStatusHiv) {
	this.screeningStatusHiv = screeningStatusHiv;
    }

    public StringFilter getScreeningStatusSyphilis() {
	return screeningStatusSyphilis;
    }

    public void setScreeningStatusSyphilis(StringFilter screeningStatusSyphilis) {
	this.screeningStatusSyphilis = screeningStatusSyphilis;
    }

    public BooleanFilter getProlongedCoughGreaterThanThreeWeeks() {
	return prolongedCoughGreaterThanThreeWeeks;
    }

    public void setProlongedCoughGreaterThanThreeWeeks(BooleanFilter prolongedCoughGreaterThanThreeWeeks) {
	this.prolongedCoughGreaterThanThreeWeeks = prolongedCoughGreaterThanThreeWeeks;
    }

    public BooleanFilter getPresenceOfSweatGreaterThanThreeWeeks() {
	return presenceOfSweatGreaterThanThreeWeeks;
    }

    public void setPresenceOfSweatGreaterThanThreeWeeks(BooleanFilter presenceOfSweatGreaterThanThreeWeeks) {
	this.presenceOfSweatGreaterThanThreeWeeks = presenceOfSweatGreaterThanThreeWeeks;
    }

    public BooleanFilter getWeightlossGreaterThan3kgInLastFourWeeks() {
	return weightlossGreaterThan3kgInLastFourWeeks;
    }

    public void setWeightlossGreaterThan3kgInLastFourWeeks(BooleanFilter weightlossGreaterThan3kgInLastFourWeeks) {
	this.weightlossGreaterThan3kgInLastFourWeeks = weightlossGreaterThan3kgInLastFourWeeks;
    }

    public BooleanFilter getFeverGreaterThanThreeWeeks() {
	return feverGreaterThanThreeWeeks;
    }

    public void setFeverGreaterThanThreeWeeks(BooleanFilter feverGreaterThanThreeWeeks) {
	this.feverGreaterThanThreeWeeks = feverGreaterThanThreeWeeks;
    }

    public StringFilter getCurrentHivStatus() {
	return currentHivStatus;
    }

    public void setCurrentHivStatus(StringFilter currentHivStatus) {
	this.currentHivStatus = currentHivStatus;
    }

    public StringFilter getCurrentSyphilis() {
	return currentSyphilis;
    }

    public void setCurrentSyphilis(StringFilter currentSyphilis) {
	this.currentSyphilis = currentSyphilis;
    }

    public StringFilter getTbStatus() {
	return tbStatus;
    }

    public void setTbStatus(StringFilter tbStatus) {
	this.tbStatus = tbStatus;
    }

    public LocalDateFilter getLastRiskVulnerabilityAssessment() {
	return lastRiskVulnerabilityAssessment;
    }

    public void setLastRiskVulnerabilityAssessment(LocalDateFilter lastRiskVulnerabilityAssessment) {
	this.lastRiskVulnerabilityAssessment = lastRiskVulnerabilityAssessment;
    }

    public BooleanFilter getIsActiveFacility() {
	return isActiveFacility;
    }

    public void setIsActiveFacility(BooleanFilter isActiveFacility) {
	this.isActiveFacility = isActiveFacility;
    }
    
    public LongFilter getHrgPrimaryCategory() {
	return hrgPrimaryCategory;
    }

    public void setHrgPrimaryCategory(LongFilter hrgPrimaryCategory) {
	this.hrgPrimaryCategory = hrgPrimaryCategory;
    }

    public BooleanFilter getIsEarly() {
	return isEarly;
    }

    public void setIsEarly(BooleanFilter isEarly) {
	this.isEarly = isEarly;
    }

    public StringFilter getClientStatus() {
	return clientStatus;
    }

    public void setClientStatus(StringFilter clientStatus) {
	this.clientStatus = clientStatus;
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

    public IntegerFilter getCreatedBy() {
	return createdBy;
    }

    public void setCreatedBy(IntegerFilter createdBy) {
	this.createdBy = createdBy;
    }

    public ZonedDateTimeFilter getCreatedTime() {
	return createdTime;
    }

    public void setCreatedTime(ZonedDateTimeFilter createdTime) {
	this.createdTime = createdTime;
    }

    public IntegerFilter getModifiedBy() {
	return modifiedBy;
    }

    public void setModifiedBy(IntegerFilter modifiedBy) {
	this.modifiedBy = modifiedBy;
    }

    public ZonedDateTimeFilter getModifiedTime() {
	return modifiedTime;
    }

    public void setModifiedTime(ZonedDateTimeFilter modifiedTime) {
	this.modifiedTime = modifiedTime;
    }

    public LongFilter getBeneficiaryId() {
	return beneficiaryId;
    }

    public void setBeneficiaryId(LongFilter beneficiaryId) {
	this.beneficiaryId = beneficiaryId;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o) {
	    return true;
	}
	if (o == null || getClass() != o.getClass()) {
	    return false;
	}
	final TIBenScrDetailsCriteria that = (TIBenScrDetailsCriteria) o;
	return Objects.equals(id, that.id) && Objects.equals(infection, that.infection)
		&& Objects.equals(dateOfScreening, that.dateOfScreening)
		&& Objects.equals(nextDateOfScreening, that.nextDateOfScreening)
		&& Objects.equals(screeningStatusHiv, that.screeningStatusHiv)
		&& Objects.equals(screeningStatusSyphilis, that.screeningStatusSyphilis)
		&& Objects.equals(prolongedCoughGreaterThanThreeWeeks, that.prolongedCoughGreaterThanThreeWeeks)
		&& Objects.equals(presenceOfSweatGreaterThanThreeWeeks, that.presenceOfSweatGreaterThanThreeWeeks)
		&& Objects.equals(weightlossGreaterThan3kgInLastFourWeeks, that.weightlossGreaterThan3kgInLastFourWeeks)
		&& Objects.equals(feverGreaterThanThreeWeeks, that.feverGreaterThanThreeWeeks)
		&& Objects.equals(currentHivStatus, that.currentHivStatus)
		&& Objects.equals(currentSyphilis, that.currentSyphilis) && Objects.equals(tbStatus, that.tbStatus)
		&& Objects.equals(lastRiskVulnerabilityAssessment, that.lastRiskVulnerabilityAssessment)
		&& Objects.equals(status, that.status) && Objects.equals(isActive, that.isActive)
		&& Objects.equals(isDeleted, that.isDeleted) && Objects.equals(createdBy, that.createdBy)
		&& Objects.equals(createdTime, that.createdTime) && Objects.equals(modifiedBy, that.modifiedBy)
		&& Objects.equals(modifiedTime, that.modifiedTime) && Objects.equals(facilityId, that.facilityId)
		&& Objects.equals(clientStatus, that.clientStatus)
		&& Objects.equals(hrgPrimaryCategory, that.hrgPrimaryCategory)
		&& Objects.equals(isActiveFacility, that.isActiveFacility)
		&& Objects.equals(isEarly, that.isEarly)
		&& Objects.equals(beneficiaryId, that.beneficiaryId);
    }

    @Override
    public int hashCode() {
	return Objects.hash(id, infection, dateOfScreening, nextDateOfScreening, screeningStatusHiv,
		screeningStatusSyphilis, prolongedCoughGreaterThanThreeWeeks, presenceOfSweatGreaterThanThreeWeeks,
		weightlossGreaterThan3kgInLastFourWeeks, feverGreaterThanThreeWeeks, currentHivStatus, currentSyphilis,
		tbStatus, lastRiskVulnerabilityAssessment, status, isActive, isDeleted, createdBy, createdTime,
		modifiedBy, modifiedTime, facilityId, clientStatus, hrgPrimaryCategory, isActiveFacility,
		beneficiaryId,isEarly);
    }

    @Override
    public String toString() {
	return "TIBenScrDetailsCriteria [id=" + id + ", facilityId=" + facilityId + ", infection=" + infection
		+ ", dateOfScreening=" + dateOfScreening + ", nextDateOfScreening=" + nextDateOfScreening
		+ ", screeningStatusHiv=" + screeningStatusHiv + ", screeningStatusSyphilis=" + screeningStatusSyphilis
		+ ", prolongedCoughGreaterThanThreeWeeks=" + prolongedCoughGreaterThanThreeWeeks
		+ ", presenceOfSweatGreaterThanThreeWeeks=" + presenceOfSweatGreaterThanThreeWeeks
		+ ", weightlossGreaterThan3kgInLastFourWeeks=" + weightlossGreaterThan3kgInLastFourWeeks
		+ ", feverGreaterThanThreeWeeks=" + feverGreaterThanThreeWeeks + ", currentHivStatus="
		+ currentHivStatus + ", currentSyphilis=" + currentSyphilis + ", tbStatus=" + tbStatus
		+ ", lastRiskVulnerabilityAssessment=" + lastRiskVulnerabilityAssessment + ", status=" + status
		+ ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", createdBy=" + createdBy + ", createdTime="
		+ createdTime + ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime + ", beneficiaryId="
		+ beneficiaryId + ", clientStatus=" + clientStatus + ", param=" + param + ", gender=" + gender
		+ ", typology=" + typology + "]";
    }

}
