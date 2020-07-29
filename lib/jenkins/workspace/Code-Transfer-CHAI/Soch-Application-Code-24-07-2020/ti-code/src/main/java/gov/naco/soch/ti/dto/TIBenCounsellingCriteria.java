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
 * Criteria class for the {@link gov.naco.soch.domain.TIBenCounselling} entity.
 * This class is used in {@link gov.naco.soch.web.rest.TIBenCounsellingResource}
 * to receive all the possible filtering options from the Http GET request
 * parameters. For example the following could be a valid request:
 * {@code /ti-ben-counsellings?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific
 * {@link Filter} class are used, we need to use fix type specific filters.
 */
public class TIBenCounsellingCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private LongFilter facilityId;

    private StringFilter currentHealthStatus;

    private IntegerFilter durationOfCounselling;

    private StringFilter typeOfCounsellingProvided;

    private IntegerFilter noOfCondomsDistributed;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateFilter lastCounsellingDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateFilter counsellingDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateFilter nextCounsellingDate;

    private BooleanFilter isActive;

    private BooleanFilter isDelete;

    private IntegerFilter createdBy;

    private ZonedDateTimeFilter createdTime;

    private IntegerFilter modifiedBy;

    private ZonedDateTimeFilter modifiedTime;

    private LongFilter beneficiaryId;

    private StringFilter clientStatus;

    private StringFilter gender;

    private StringFilter typology;

    private StringFilter basicSearchParam;

    private LongFilter hrgPrimaryCategory;

    private BooleanFilter isActiveFacility;

    private BooleanFilter isEarly;
    
    private LongFilter status;

    public TIBenCounsellingCriteria() {
    }

    public TIBenCounsellingCriteria(TIBenCounsellingCriteria other) {
	this.id = other.id == null ? null : other.id.copy();
	this.currentHealthStatus = other.currentHealthStatus == null ? null : other.currentHealthStatus.copy();
	this.durationOfCounselling = other.durationOfCounselling == null ? null : other.durationOfCounselling.copy();
	this.typeOfCounsellingProvided = other.typeOfCounsellingProvided == null ? null
		: other.typeOfCounsellingProvided.copy();
	this.noOfCondomsDistributed = other.noOfCondomsDistributed == null ? null : other.noOfCondomsDistributed.copy();
	this.lastCounsellingDate = other.lastCounsellingDate == null ? null : other.lastCounsellingDate.copy();
	this.counsellingDate = other.counsellingDate == null ? null : other.counsellingDate.copy();
	this.nextCounsellingDate = other.nextCounsellingDate == null ? null : other.nextCounsellingDate.copy();
	this.isActive = other.isActive == null ? null : other.isActive.copy();
	this.isDelete = other.isDelete == null ? null : other.isDelete.copy();
	this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
	this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
	this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
	this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
	this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
	this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
	this.clientStatus = other.clientStatus == null ? null : other.clientStatus.copy();
	this.gender = other.gender == null ? null : other.gender.copy();
	this.typology = other.typology == null ? null : other.typology.copy();
	this.basicSearchParam = other.basicSearchParam == null ? null : other.basicSearchParam.copy();
	this.hrgPrimaryCategory = other.hrgPrimaryCategory == null ? null : other.hrgPrimaryCategory.copy();
	this.isActiveFacility = other.isActiveFacility == null ? null : other.isActiveFacility.copy();
	this.isEarly = other.isEarly == null ? null : other.isEarly.copy();
	this.status = other.status == null ? null : other.status.copy();
    }

    @Override
    public TIBenCounsellingCriteria copy() {
	return new TIBenCounsellingCriteria(this);
    }

    public LongFilter getId() {
	return id;
    }

    public void setId(LongFilter id) {
	this.id = id;
    }

    public StringFilter getCurrentHealthStatus() {
	return currentHealthStatus;
    }

    public void setCurrentHealthStatus(StringFilter currentHealthStatus) {
	this.currentHealthStatus = currentHealthStatus;
    }

    public IntegerFilter getDurationOfCounselling() {
	return durationOfCounselling;
    }

    public void setDurationOfCounselling(IntegerFilter durationOfCounselling) {
	this.durationOfCounselling = durationOfCounselling;
    }

    public StringFilter getTypeOfCounsellingProvided() {
	return typeOfCounsellingProvided;
    }

    public void setTypeOfCounsellingProvided(StringFilter typeOfCounsellingProvided) {
	this.typeOfCounsellingProvided = typeOfCounsellingProvided;
    }

    public BooleanFilter getIsEarly() {
        return isEarly;
    }

    public void setIsEarly(BooleanFilter isEarly) {
        this.isEarly = isEarly;
    }

    public IntegerFilter getNoOfCondomsDistributed() {
	return noOfCondomsDistributed;
    }

    public void setNoOfCondomsDistributed(IntegerFilter noOfCondomsDistributed) {
	this.noOfCondomsDistributed = noOfCondomsDistributed;
    }

    public LocalDateFilter getLastCounsellingDate() {
	return lastCounsellingDate;
    }

    public void setLastCounsellingDate(LocalDateFilter lastCounsellingDate) {
	this.lastCounsellingDate = lastCounsellingDate;
    }

    public LocalDateFilter getCounsellingDate() {
	return counsellingDate;
    }

    public void setCounsellingDate(LocalDateFilter counsellingDate) {
	this.counsellingDate = counsellingDate;
    }

    public StringFilter getClientStatus() {
	return clientStatus;
    }

    public void setClientStatus(StringFilter clientStatus) {
	this.clientStatus = clientStatus;
    }

    public LocalDateFilter getNextCounsellingDate() {
	return nextCounsellingDate;
    }

    public void setNextCounsellingDate(LocalDateFilter nextCounsellingDate) {
	this.nextCounsellingDate = nextCounsellingDate;
    }

    public LongFilter getFacilityId() {
	return facilityId;
    }

    public void setFacilityId(LongFilter facilityId) {
	this.facilityId = facilityId;
    }

    public BooleanFilter getIsActive() {
	return isActive;
    }

    public void setIsActive(BooleanFilter isActive) {
	this.isActive = isActive;
    }

    public BooleanFilter getIsDelete() {
	return isDelete;
    }

    public void setIsDelete(BooleanFilter isDelete) {
	this.isDelete = isDelete;
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

    public LongFilter getHrgPrimaryCategory() {
	return hrgPrimaryCategory;
    }

    public void setHrgPrimaryCategory(LongFilter hrgPrimaryCategory) {
	this.hrgPrimaryCategory = hrgPrimaryCategory;
    }

    public LongFilter getStatus() {
	return status;
    }

    public void setStatus(LongFilter status) {
	this.status = status;
    }

    public BooleanFilter getIsActiveFacility() {
	return isActiveFacility;
    }

    public void setIsActiveFacility(BooleanFilter isActiveFacility) {
	this.isActiveFacility = isActiveFacility;
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

    public StringFilter getBasicSearchParam() {
	return basicSearchParam;
    }

    public void setBasicSearchParam(StringFilter basicSearchParam) {
	this.basicSearchParam = basicSearchParam;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o) {
	    return true;
	}
	if (o == null || getClass() != o.getClass()) {
	    return false;
	}
	final TIBenCounsellingCriteria that = (TIBenCounsellingCriteria) o;
	return Objects.equals(id, that.id) && Objects.equals(currentHealthStatus, that.currentHealthStatus)
		&& Objects.equals(durationOfCounselling, that.durationOfCounselling)
		&& Objects.equals(typeOfCounsellingProvided, that.typeOfCounsellingProvided)
		&& Objects.equals(noOfCondomsDistributed, that.noOfCondomsDistributed)
		&& Objects.equals(lastCounsellingDate, that.lastCounsellingDate)
		&& Objects.equals(counsellingDate, that.counsellingDate)
		&& Objects.equals(nextCounsellingDate, that.nextCounsellingDate)
		&& Objects.equals(isActive, that.isActive) && Objects.equals(isDelete, that.isDelete)
		&& Objects.equals(createdBy, that.createdBy) && Objects.equals(createdTime, that.createdTime)
		&& Objects.equals(modifiedBy, that.modifiedBy) && Objects.equals(clientStatus, that.clientStatus)
		&& Objects.equals(modifiedTime, that.modifiedTime) && Objects.equals(facilityId, that.facilityId)
		&& Objects.equals(beneficiaryId, that.beneficiaryId) && Objects.equals(gender, that.gender)
		&& Objects.equals(typology, that.typology) && Objects.equals(basicSearchParam, that.basicSearchParam)
		&& Objects.equals(isActiveFacility, that.isActiveFacility)
		&& Objects.equals(isEarly, that.isEarly)
		&& Objects.equals(status, that.status)
		&& Objects.equals(hrgPrimaryCategory, that.hrgPrimaryCategory);
    }

    @Override
    public int hashCode() {
	return Objects.hash(id, currentHealthStatus, durationOfCounselling, typeOfCounsellingProvided,
		noOfCondomsDistributed, lastCounsellingDate, counsellingDate, nextCounsellingDate, isActive, isDelete,
		createdBy, createdTime, modifiedBy, modifiedTime, facilityId, beneficiaryId, clientStatus, gender,
		typology, basicSearchParam, hrgPrimaryCategory, isActiveFacility,isEarly,status);
    }

    @Override
    public String toString() {
	return "TIBenCounsellingCriteria [id=" + id + ", facilityId=" + facilityId + ", currentHealthStatus="
		+ currentHealthStatus + ", durationOfCounselling=" + durationOfCounselling
		+ ", typeOfCounsellingProvided=" + typeOfCounsellingProvided + ", noOfCondomsDistributed="
		+ noOfCondomsDistributed + ", lastCounsellingDate=" + lastCounsellingDate + ", counsellingDate="
		+ counsellingDate + ", nextCounsellingDate=" + nextCounsellingDate + ", isActive=" + isActive
		+ ", isDelete=" + isDelete + ", createdBy=" + createdBy + ", createdTime=" + createdTime
		+ ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime + ", beneficiaryId=" + beneficiaryId
		+ ", gender=" + gender + ", typology=" + typology + ", basicSearchParam=" + basicSearchParam + "]";
    }

}
