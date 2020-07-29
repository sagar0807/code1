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
 * Criteria class for the {@link gov.naco.soch.domain.TIBenRVAssessment} entity.
 * This class is used in
 * {@link gov.naco.soch.web.rest.TIBenRVAssessmentResource} to receive all the
 * possible filtering options from the Http GET request parameters. For example
 * the following could be a valid request:
 * {@code /ti-ben-rv-assessments?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific
 * {@link Filter} class are used, we need to use fix type specific filters.
 */
public class TIBenRVAssessmentCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private IntegerFilter ostId;

    private LongFilter facilityId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateFilter dueDateOfAssessment;

    private IntegerFilter assessmentPending;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateFilter assessmentDate;

    private IntegerFilter highNumberOfSexualEncounters;

    private IntegerFilter lowCondomUse;

    private IntegerFilter firstYearInSexWorkAndBelowAgeOf25Years;

    private IntegerFilter stiReportedInLastThreeMonthsTi;

    private IntegerFilter alcohol;

    private IntegerFilter unsafeSex;

    private IntegerFilter violence;

    private IntegerFilter condomRequirementPerWeek;

    private IntegerFilter highNumberOfDrugUsingPartners;

    private IntegerFilter sharingOfNeedlesSyringes;

    private IntegerFilter injectingGreaterThanThreeTimes;

    private IntegerFilter stiReportedInLastThreeMonthsIdu;

    private IntegerFilter useOfAlcoholAndOtherDrugsApartFromInjections;

    private IntegerFilter unsafeSexSexWithNonRegularPartner;

    private IntegerFilter mobilityFromOneHotspotToAnother;

    private IntegerFilter condomRequirementPerWeekIdu;

    private IntegerFilter needlesSyringesRequirementPerWeek;

    private BooleanFilter isActive;

    private BooleanFilter isDelete;

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

    public TIBenRVAssessmentCriteria() {
    }

    public TIBenRVAssessmentCriteria(TIBenRVAssessmentCriteria other) {
	this.id = other.id == null ? null : other.id.copy();
	this.ostId = other.ostId == null ? null : other.ostId.copy();
	this.dueDateOfAssessment = other.dueDateOfAssessment == null ? null : other.dueDateOfAssessment.copy();
	this.assessmentPending = other.assessmentPending == null ? null : other.assessmentPending.copy();
	this.assessmentDate = other.assessmentDate == null ? null : other.assessmentDate.copy();
	this.highNumberOfSexualEncounters = other.highNumberOfSexualEncounters == null ? null
		: other.highNumberOfSexualEncounters.copy();
	this.lowCondomUse = other.lowCondomUse == null ? null : other.lowCondomUse.copy();
	this.firstYearInSexWorkAndBelowAgeOf25Years = other.firstYearInSexWorkAndBelowAgeOf25Years == null ? null
		: other.firstYearInSexWorkAndBelowAgeOf25Years.copy();
	this.stiReportedInLastThreeMonthsTi = other.stiReportedInLastThreeMonthsTi == null ? null
		: other.stiReportedInLastThreeMonthsTi.copy();
	this.alcohol = other.alcohol == null ? null : other.alcohol.copy();
	this.unsafeSex = other.unsafeSex == null ? null : other.unsafeSex.copy();
	this.violence = other.violence == null ? null : other.violence.copy();
	this.condomRequirementPerWeek = other.condomRequirementPerWeek == null ? null
		: other.condomRequirementPerWeek.copy();
	this.highNumberOfDrugUsingPartners = other.highNumberOfDrugUsingPartners == null ? null
		: other.highNumberOfDrugUsingPartners.copy();
	this.sharingOfNeedlesSyringes = other.sharingOfNeedlesSyringes == null ? null
		: other.sharingOfNeedlesSyringes.copy();
	this.injectingGreaterThanThreeTimes = other.injectingGreaterThanThreeTimes == null ? null
		: other.injectingGreaterThanThreeTimes.copy();
	this.stiReportedInLastThreeMonthsIdu = other.stiReportedInLastThreeMonthsIdu == null ? null
		: other.stiReportedInLastThreeMonthsIdu.copy();
	this.useOfAlcoholAndOtherDrugsApartFromInjections = other.useOfAlcoholAndOtherDrugsApartFromInjections == null
		? null
		: other.useOfAlcoholAndOtherDrugsApartFromInjections.copy();
	this.unsafeSexSexWithNonRegularPartner = other.unsafeSexSexWithNonRegularPartner == null ? null
		: other.unsafeSexSexWithNonRegularPartner.copy();
	this.mobilityFromOneHotspotToAnother = other.mobilityFromOneHotspotToAnother == null ? null
		: other.mobilityFromOneHotspotToAnother.copy();
	this.condomRequirementPerWeekIdu = other.condomRequirementPerWeekIdu == null ? null
		: other.condomRequirementPerWeekIdu.copy();
	this.needlesSyringesRequirementPerWeek = other.needlesSyringesRequirementPerWeek == null ? null
		: other.needlesSyringesRequirementPerWeek.copy();
	this.isActive = other.isActive == null ? null : other.isActive.copy();
	this.isDelete = other.isDelete == null ? null : other.isDelete.copy();
	this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
	this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
	this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
	this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
	this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
	this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
	this.clientStatus = other.clientStatus == null ? null : other.clientStatus.copy();
	this.typology = other.typology == null ? null : other.typology.copy();
	this.gender = other.gender == null ? null : other.gender.copy();
	this.param = other.param == null ? null : other.param.copy();
	this.hrgPrimaryCategory = other.hrgPrimaryCategory == null ? null : other.hrgPrimaryCategory.copy();
	this.isActiveFacility = other.isActiveFacility == null ? null : other.isActiveFacility.copy();
	this.isEarly = other.isEarly == null ? null : other.isEarly.copy();
	this.status = other.status == null ? null : other.status.copy();
    }

    @Override
    public TIBenRVAssessmentCriteria copy() {
	return new TIBenRVAssessmentCriteria(this);
    }

    public LongFilter getId() {
	return id;
    }

    public void setId(LongFilter id) {
	this.id = id;
    }

    public IntegerFilter getOstId() {
	return ostId;
    }

    public void setOstId(IntegerFilter ostId) {
	this.ostId = ostId;
    }

    public LocalDateFilter getDueDateOfAssessment() {
	return dueDateOfAssessment;
    }

    public void setDueDateOfAssessment(LocalDateFilter dueDateOfAssessment) {
	this.dueDateOfAssessment = dueDateOfAssessment;
    }

    public IntegerFilter getAssessmentPending() {
	return assessmentPending;
    }

    public void setAssessmentPending(IntegerFilter assessmentPending) {
	this.assessmentPending = assessmentPending;
    }

    public LocalDateFilter getAssessmentDate() {
	return assessmentDate;
    }

    public void setAssessmentDate(LocalDateFilter assessmentDate) {
	this.assessmentDate = assessmentDate;
    }

    public IntegerFilter getHighNumberOfSexualEncounters() {
	return highNumberOfSexualEncounters;
    }

    public void setHighNumberOfSexualEncounters(IntegerFilter highNumberOfSexualEncounters) {
	this.highNumberOfSexualEncounters = highNumberOfSexualEncounters;
    }

    public IntegerFilter getLowCondomUse() {
	return lowCondomUse;
    }

    public void setLowCondomUse(IntegerFilter lowCondomUse) {
	this.lowCondomUse = lowCondomUse;
    }

    public IntegerFilter getFirstYearInSexWorkAndBelowAgeOf25Years() {
	return firstYearInSexWorkAndBelowAgeOf25Years;
    }

    public void setFirstYearInSexWorkAndBelowAgeOf25Years(IntegerFilter firstYearInSexWorkAndBelowAgeOf25Years) {
	this.firstYearInSexWorkAndBelowAgeOf25Years = firstYearInSexWorkAndBelowAgeOf25Years;
    }

    public IntegerFilter getStiReportedInLastThreeMonthsTi() {
	return stiReportedInLastThreeMonthsTi;
    }

    public void setStiReportedInLastThreeMonthsTi(IntegerFilter stiReportedInLastThreeMonthsTi) {
	this.stiReportedInLastThreeMonthsTi = stiReportedInLastThreeMonthsTi;
    }

    public IntegerFilter getAlcohol() {
	return alcohol;
    }

    public void setAlcohol(IntegerFilter alcohol) {
	this.alcohol = alcohol;
    }

    public IntegerFilter getUnsafeSex() {
	return unsafeSex;
    }

    public void setUnsafeSex(IntegerFilter unsafeSex) {
	this.unsafeSex = unsafeSex;
    }

    public IntegerFilter getViolence() {
	return violence;
    }

    public void setViolence(IntegerFilter violence) {
	this.violence = violence;
    }

    public IntegerFilter getCondomRequirementPerWeek() {
	return condomRequirementPerWeek;
    }

    public void setCondomRequirementPerWeek(IntegerFilter condomRequirementPerWeek) {
	this.condomRequirementPerWeek = condomRequirementPerWeek;
    }

    public IntegerFilter getHighNumberOfDrugUsingPartners() {
	return highNumberOfDrugUsingPartners;
    }

    public void setHighNumberOfDrugUsingPartners(IntegerFilter highNumberOfDrugUsingPartners) {
	this.highNumberOfDrugUsingPartners = highNumberOfDrugUsingPartners;
    }

    public IntegerFilter getSharingOfNeedlesSyringes() {
	return sharingOfNeedlesSyringes;
    }

    public void setSharingOfNeedlesSyringes(IntegerFilter sharingOfNeedlesSyringes) {
	this.sharingOfNeedlesSyringes = sharingOfNeedlesSyringes;
    }

    public IntegerFilter getInjectingGreaterThanThreeTimes() {
	return injectingGreaterThanThreeTimes;
    }

    public void setInjectingGreaterThanThreeTimes(IntegerFilter injectingGreaterThanThreeTimes) {
	this.injectingGreaterThanThreeTimes = injectingGreaterThanThreeTimes;
    }

    public IntegerFilter getStiReportedInLastThreeMonthsIdu() {
	return stiReportedInLastThreeMonthsIdu;
    }

    public void setStiReportedInLastThreeMonthsIdu(IntegerFilter stiReportedInLastThreeMonthsIdu) {
	this.stiReportedInLastThreeMonthsIdu = stiReportedInLastThreeMonthsIdu;
    }

    public IntegerFilter getUseOfAlcoholAndOtherDrugsApartFromInjections() {
	return useOfAlcoholAndOtherDrugsApartFromInjections;
    }

    public void setUseOfAlcoholAndOtherDrugsApartFromInjections(
	    IntegerFilter useOfAlcoholAndOtherDrugsApartFromInjections) {
	this.useOfAlcoholAndOtherDrugsApartFromInjections = useOfAlcoholAndOtherDrugsApartFromInjections;
    }

    public IntegerFilter getUnsafeSexSexWithNonRegularPartner() {
	return unsafeSexSexWithNonRegularPartner;
    }

    public void setUnsafeSexSexWithNonRegularPartner(IntegerFilter unsafeSexSexWithNonRegularPartner) {
	this.unsafeSexSexWithNonRegularPartner = unsafeSexSexWithNonRegularPartner;
    }

    public IntegerFilter getMobilityFromOneHotspotToAnother() {
	return mobilityFromOneHotspotToAnother;
    }

    public void setMobilityFromOneHotspotToAnother(IntegerFilter mobilityFromOneHotspotToAnother) {
	this.mobilityFromOneHotspotToAnother = mobilityFromOneHotspotToAnother;
    }

    public IntegerFilter getCondomRequirementPerWeekIdu() {
	return condomRequirementPerWeekIdu;
    }

    public void setCondomRequirementPerWeekIdu(IntegerFilter condomRequirementPerWeekIdu) {
	this.condomRequirementPerWeekIdu = condomRequirementPerWeekIdu;
    }

    public BooleanFilter getIsActiveFacility() {
	return isActiveFacility;
    }

    public void setIsActiveFacility(BooleanFilter isActiveFacility) {
	this.isActiveFacility = isActiveFacility;
    }

    public LongFilter getFacilityId() {
	return facilityId;
    }

    public void setFacilityId(LongFilter facilityId) {
	this.facilityId = facilityId;
    }

    public StringFilter getClientStatus() {
	return clientStatus;
    }

    public void setClientStatus(StringFilter clientStatus) {
	this.clientStatus = clientStatus;
    }

    public BooleanFilter getIsEarly() {
	return isEarly;
    }

    public void setIsEarly(BooleanFilter isEarly) {
	this.isEarly = isEarly;
    }

    public IntegerFilter getNeedlesSyringesRequirementPerWeek() {
	return needlesSyringesRequirementPerWeek;
    }

    public void setNeedlesSyringesRequirementPerWeek(IntegerFilter needlesSyringesRequirementPerWeek) {
	this.needlesSyringesRequirementPerWeek = needlesSyringesRequirementPerWeek;
    }

    public LongFilter getHrgPrimaryCategory() {
	return hrgPrimaryCategory;
    }

    public void setHrgPrimaryCategory(LongFilter hrgPrimaryCategory) {
	this.hrgPrimaryCategory = hrgPrimaryCategory;
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

    public LongFilter getStatus() {
	return status;
    }

    public void setStatus(LongFilter status) {
	this.status = status;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o) {
	    return true;
	}
	if (o == null || getClass() != o.getClass()) {
	    return false;
	}
	final TIBenRVAssessmentCriteria that = (TIBenRVAssessmentCriteria) o;
	return Objects.equals(id, that.id) && Objects.equals(ostId, that.ostId)
		&& Objects.equals(dueDateOfAssessment, that.dueDateOfAssessment)
		&& Objects.equals(assessmentPending, that.assessmentPending)
		&& Objects.equals(assessmentDate, that.assessmentDate)
		&& Objects.equals(highNumberOfSexualEncounters, that.highNumberOfSexualEncounters)
		&& Objects.equals(lowCondomUse, that.lowCondomUse)
		&& Objects.equals(firstYearInSexWorkAndBelowAgeOf25Years, that.firstYearInSexWorkAndBelowAgeOf25Years)
		&& Objects.equals(stiReportedInLastThreeMonthsTi, that.stiReportedInLastThreeMonthsTi)
		&& Objects.equals(alcohol, that.alcohol) && Objects.equals(unsafeSex, that.unsafeSex)
		&& Objects.equals(violence, that.violence)
		&& Objects.equals(condomRequirementPerWeek, that.condomRequirementPerWeek)
		&& Objects.equals(highNumberOfDrugUsingPartners, that.highNumberOfDrugUsingPartners)
		&& Objects.equals(sharingOfNeedlesSyringes, that.sharingOfNeedlesSyringes)
		&& Objects.equals(injectingGreaterThanThreeTimes, that.injectingGreaterThanThreeTimes)
		&& Objects.equals(stiReportedInLastThreeMonthsIdu, that.stiReportedInLastThreeMonthsIdu)
		&& Objects.equals(useOfAlcoholAndOtherDrugsApartFromInjections,
			that.useOfAlcoholAndOtherDrugsApartFromInjections)
		&& Objects.equals(unsafeSexSexWithNonRegularPartner, that.unsafeSexSexWithNonRegularPartner)
		&& Objects.equals(mobilityFromOneHotspotToAnother, that.mobilityFromOneHotspotToAnother)
		&& Objects.equals(condomRequirementPerWeekIdu, that.condomRequirementPerWeekIdu)
		&& Objects.equals(needlesSyringesRequirementPerWeek, that.needlesSyringesRequirementPerWeek)
		&& Objects.equals(isActive, that.isActive) && Objects.equals(isDelete, that.isDelete)
		&& Objects.equals(createdBy, that.createdBy) && Objects.equals(createdTime, that.createdTime)
		&& Objects.equals(modifiedBy, that.modifiedBy) && Objects.equals(clientStatus, that.clientStatus)
		&& Objects.equals(modifiedTime, that.modifiedTime) && Objects.equals(facilityId, that.facilityId)
		&& Objects.equals(hrgPrimaryCategory, that.hrgPrimaryCategory)
		&& Objects.equals(beneficiaryId, that.beneficiaryId)
		&& Objects.equals(isActiveFacility, that.isActiveFacility) && Objects.equals(param, that.param)
		&& Objects.equals(status, that.status) 
		&& Objects.equals(gender, that.gender) && Objects.equals(isEarly, that.isEarly)&&Objects.equals(typology, that.typology);
    }

    @Override
    public int hashCode() {
	return Objects.hash(id, ostId, dueDateOfAssessment, assessmentPending, assessmentDate,
		highNumberOfSexualEncounters, lowCondomUse, firstYearInSexWorkAndBelowAgeOf25Years,
		stiReportedInLastThreeMonthsTi, alcohol, unsafeSex, violence, condomRequirementPerWeek,
		highNumberOfDrugUsingPartners, sharingOfNeedlesSyringes, injectingGreaterThanThreeTimes,
		stiReportedInLastThreeMonthsIdu, useOfAlcoholAndOtherDrugsApartFromInjections,
		unsafeSexSexWithNonRegularPartner, mobilityFromOneHotspotToAnother, condomRequirementPerWeekIdu,
		needlesSyringesRequirementPerWeek, isActive, isDelete, createdBy, createdTime, modifiedBy, modifiedTime,
		facilityId, beneficiaryId, clientStatus, gender, typology, param, hrgPrimaryCategory, isActiveFacility,isEarly,status);
    }

    @Override
    public String toString() {
	return "TIBenRVAssessmentCriteria [id=" + id + ", ostId=" + ostId + ", facilityId=" + facilityId
		+ ", dueDateOfAssessment=" + dueDateOfAssessment + ", assessmentPending=" + assessmentPending
		+ ", assessmentDate=" + assessmentDate + ", highNumberOfSexualEncounters="
		+ highNumberOfSexualEncounters + ", lowCondomUse=" + lowCondomUse
		+ ", firstYearInSexWorkAndBelowAgeOf25Years=" + firstYearInSexWorkAndBelowAgeOf25Years
		+ ", stiReportedInLastThreeMonthsTi=" + stiReportedInLastThreeMonthsTi + ", alcohol=" + alcohol
		+ ", unsafeSex=" + unsafeSex + ", violence=" + violence + ", condomRequirementPerWeekTi="
		+ condomRequirementPerWeek + ", highNumberOfDrugUsingPartners=" + highNumberOfDrugUsingPartners
		+ ", sharingOfNeedlesSyringes=" + sharingOfNeedlesSyringes + ", injectingGreaterThanThreeTimes="
		+ injectingGreaterThanThreeTimes + ", stiReportedInLastThreeMonthsIdu="
		+ stiReportedInLastThreeMonthsIdu + ", useOfAlcoholAndOtherDrugsApartFromInjections="
		+ useOfAlcoholAndOtherDrugsApartFromInjections + ", unsafeSexSexWithNonRegularPartner="
		+ unsafeSexSexWithNonRegularPartner + ", mobilityFromOneHotspotToAnother="
		+ mobilityFromOneHotspotToAnother + ", condomRequirementPerWeekIdu=" + condomRequirementPerWeekIdu
		+ ", needlesSyringesRequirementPerWeek=" + needlesSyringesRequirementPerWeek + ", isActive=" + isActive
		+ ", isDelete=" + isDelete + ", createdBy=" + createdBy + ", createdTime=" + createdTime
		+ ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime + ", beneficiaryId=" + beneficiaryId
		+ "param=" + param + " gender=" + gender + " typology=" + typology + "]";
    }

}
