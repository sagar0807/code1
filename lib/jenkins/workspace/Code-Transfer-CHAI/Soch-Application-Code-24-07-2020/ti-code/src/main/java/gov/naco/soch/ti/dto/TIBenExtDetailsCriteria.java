package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.LocalDateFilter;

/**
 * Criteria class for the {@link gov.naco.soch.domain.TIBenExtDetails} entity. This class is used
 * in {@link gov.naco.soch.web.rest.TIBenExtDetailsResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ti-ben-ext-details?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class TIBenExtDetailsCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter withinTheDistrictNoOfTimes;

    private StringFilter withinTheDistrictNoOfDays;

    private StringFilter withinTheStateNoOfTimes;

    private StringFilter withinTheStateNoOfDays;

    private StringFilter outsideTheStateNoOfTimes;

    private StringFilter outsideTheStateNoOfDays;

    private BooleanFilter mondayAvbl;

    private BooleanFilter tuesdayAvbl;

    private BooleanFilter wednesdayAvbl;

    private BooleanFilter thursdayAvbl;

    private BooleanFilter fridayAvbl;

    private BooleanFilter saturdayAvbl;

    private LocalDateFilter syphilisLastScreenDate;

    private StringFilter syphilisStatus;

    private LocalDateFilter syphilisNextScreenDate;

    private LocalDateFilter tbLastScreenDate;

    private StringFilter tbScreeningStatus;

    private StringFilter tbConfStatus;

    private StringFilter hivStatus;

    private LocalDateFilter hivNextScreenDate;

    private BooleanFilter hivArtLinked;

    private StringFilter hivArtCenter;

    private StringFilter hivArtNumber;

    private StringFilter hivArtStatus;

    private StringFilter hivArtAdherence;

    private StringFilter referredFacility;

    private StringFilter referredTo;

    private StringFilter referralStatus;

    private BooleanFilter isOutwardReferal;

    private BooleanFilter isTransit;

    private LocalDateFilter transitStartDate;

    private LocalDateFilter transitEndDate;

    private StringFilter guardianName;

    private StringFilter relation;

    private StringFilter guardianContactNumber;

    private BooleanFilter isTransfer;

    private LongFilter beneficiaryId;

    public TIBenExtDetailsCriteria(){
    }

    public TIBenExtDetailsCriteria(TIBenExtDetailsCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.withinTheDistrictNoOfTimes = other.withinTheDistrictNoOfTimes == null ? null : other.withinTheDistrictNoOfTimes.copy();
        this.withinTheDistrictNoOfDays = other.withinTheDistrictNoOfDays == null ? null : other.withinTheDistrictNoOfDays.copy();
        this.withinTheStateNoOfTimes = other.withinTheStateNoOfTimes == null ? null : other.withinTheStateNoOfTimes.copy();
        this.withinTheStateNoOfDays = other.withinTheStateNoOfDays == null ? null : other.withinTheStateNoOfDays.copy();
        this.outsideTheStateNoOfTimes = other.outsideTheStateNoOfTimes == null ? null : other.outsideTheStateNoOfTimes.copy();
        this.outsideTheStateNoOfDays = other.outsideTheStateNoOfDays == null ? null : other.outsideTheStateNoOfDays.copy();
        this.mondayAvbl = other.mondayAvbl == null ? null : other.mondayAvbl.copy();
        this.tuesdayAvbl = other.tuesdayAvbl == null ? null : other.tuesdayAvbl.copy();
        this.wednesdayAvbl = other.wednesdayAvbl == null ? null : other.wednesdayAvbl.copy();
        this.thursdayAvbl = other.thursdayAvbl == null ? null : other.thursdayAvbl.copy();
        this.fridayAvbl = other.fridayAvbl == null ? null : other.fridayAvbl.copy();
        this.saturdayAvbl = other.saturdayAvbl == null ? null : other.saturdayAvbl.copy();
        this.syphilisLastScreenDate = other.syphilisLastScreenDate == null ? null : other.syphilisLastScreenDate.copy();
        this.syphilisStatus = other.syphilisStatus == null ? null : other.syphilisStatus.copy();
        this.syphilisNextScreenDate = other.syphilisNextScreenDate == null ? null : other.syphilisNextScreenDate.copy();
        this.tbLastScreenDate = other.tbLastScreenDate == null ? null : other.tbLastScreenDate.copy();
        this.tbScreeningStatus = other.tbScreeningStatus == null ? null : other.tbScreeningStatus.copy();
        this.tbConfStatus = other.tbConfStatus == null ? null : other.tbConfStatus.copy();
        this.hivStatus = other.hivStatus == null ? null : other.hivStatus.copy();
        this.hivNextScreenDate = other.hivNextScreenDate == null ? null : other.hivNextScreenDate.copy();
        this.hivArtLinked = other.hivArtLinked == null ? null : other.hivArtLinked.copy();
        this.hivArtCenter = other.hivArtCenter == null ? null : other.hivArtCenter.copy();
        this.hivArtNumber = other.hivArtNumber == null ? null : other.hivArtNumber.copy();
        this.hivArtStatus = other.hivArtStatus == null ? null : other.hivArtStatus.copy();
        this.hivArtAdherence = other.hivArtAdherence == null ? null : other.hivArtAdherence.copy();
        this.referredFacility = other.referredFacility == null ? null : other.referredFacility.copy();
        this.referredTo = other.referredTo == null ? null : other.referredTo.copy();
        this.referralStatus = other.referralStatus == null ? null : other.referralStatus.copy();
        this.isOutwardReferal = other.isOutwardReferal == null ? null : other.isOutwardReferal.copy();
        this.isTransit = other.isTransit == null ? null : other.isTransit.copy();
        this.transitStartDate = other.transitStartDate == null ? null : other.transitStartDate.copy();
        this.transitEndDate = other.transitEndDate == null ? null : other.transitEndDate.copy();
        this.guardianName = other.guardianName == null ? null : other.guardianName.copy();
        this.relation = other.relation == null ? null : other.relation.copy();
        this.guardianContactNumber = other.guardianContactNumber == null ? null : other.guardianContactNumber.copy();
        this.isTransfer = other.isTransfer == null ? null : other.isTransfer.copy();
        this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
    }

    @Override
    public TIBenExtDetailsCriteria copy() {
        return new TIBenExtDetailsCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getWithinTheDistrictNoOfTimes() {
        return withinTheDistrictNoOfTimes;
    }

    public void setWithinTheDistrictNoOfTimes(StringFilter withinTheDistrictNoOfTimes) {
        this.withinTheDistrictNoOfTimes = withinTheDistrictNoOfTimes;
    }

    public StringFilter getWithinTheDistrictNoOfDays() {
        return withinTheDistrictNoOfDays;
    }

    public void setWithinTheDistrictNoOfDays(StringFilter withinTheDistrictNoOfDays) {
        this.withinTheDistrictNoOfDays = withinTheDistrictNoOfDays;
    }

    public StringFilter getWithinTheStateNoOfTimes() {
        return withinTheStateNoOfTimes;
    }

    public void setWithinTheStateNoOfTimes(StringFilter withinTheStateNoOfTimes) {
        this.withinTheStateNoOfTimes = withinTheStateNoOfTimes;
    }

    public StringFilter getWithinTheStateNoOfDays() {
        return withinTheStateNoOfDays;
    }

    public void setWithinTheStateNoOfDays(StringFilter withinTheStateNoOfDays) {
        this.withinTheStateNoOfDays = withinTheStateNoOfDays;
    }

    public StringFilter getOutsideTheStateNoOfTimes() {
        return outsideTheStateNoOfTimes;
    }

    public void setOutsideTheStateNoOfTimes(StringFilter outsideTheStateNoOfTimes) {
        this.outsideTheStateNoOfTimes = outsideTheStateNoOfTimes;
    }

    public StringFilter getOutsideTheStateNoOfDays() {
        return outsideTheStateNoOfDays;
    }

    public void setOutsideTheStateNoOfDays(StringFilter outsideTheStateNoOfDays) {
        this.outsideTheStateNoOfDays = outsideTheStateNoOfDays;
    }

    public BooleanFilter getMondayAvbl() {
        return mondayAvbl;
    }

    public void setMondayAvbl(BooleanFilter mondayAvbl) {
        this.mondayAvbl = mondayAvbl;
    }

    public BooleanFilter getTuesdayAvbl() {
        return tuesdayAvbl;
    }

    public void setTuesdayAvbl(BooleanFilter tuesdayAvbl) {
        this.tuesdayAvbl = tuesdayAvbl;
    }

    public BooleanFilter getWednesdayAvbl() {
        return wednesdayAvbl;
    }

    public void setWednesdayAvbl(BooleanFilter wednesdayAvbl) {
        this.wednesdayAvbl = wednesdayAvbl;
    }

    public BooleanFilter getThursdayAvbl() {
        return thursdayAvbl;
    }

    public void setThursdayAvbl(BooleanFilter thursdayAvbl) {
        this.thursdayAvbl = thursdayAvbl;
    }

    public BooleanFilter getFridayAvbl() {
        return fridayAvbl;
    }

    public void setFridayAvbl(BooleanFilter fridayAvbl) {
        this.fridayAvbl = fridayAvbl;
    }

    public BooleanFilter getSaturdayAvbl() {
        return saturdayAvbl;
    }

    public void setSaturdayAvbl(BooleanFilter saturdayAvbl) {
        this.saturdayAvbl = saturdayAvbl;
    }

    public LocalDateFilter getSyphilisLastScreenDate() {
        return syphilisLastScreenDate;
    }

    public void setSyphilisLastScreenDate(LocalDateFilter syphilisLastScreenDate) {
        this.syphilisLastScreenDate = syphilisLastScreenDate;
    }

    public StringFilter getSyphilisStatus() {
        return syphilisStatus;
    }

    public void setSyphilisStatus(StringFilter syphilisStatus) {
        this.syphilisStatus = syphilisStatus;
    }

    public LocalDateFilter getSyphilisNextScreenDate() {
        return syphilisNextScreenDate;
    }

    public void setSyphilisNextScreenDate(LocalDateFilter syphilisNextScreenDate) {
        this.syphilisNextScreenDate = syphilisNextScreenDate;
    }

    public LocalDateFilter getTbLastScreenDate() {
        return tbLastScreenDate;
    }

    public void setTbLastScreenDate(LocalDateFilter tbLastScreenDate) {
        this.tbLastScreenDate = tbLastScreenDate;
    }

    public StringFilter getTbScreeningStatus() {
        return tbScreeningStatus;
    }

    public void setTbScreeningStatus(StringFilter tbScreeningStatus) {
        this.tbScreeningStatus = tbScreeningStatus;
    }

    public StringFilter getTbConfStatus() {
        return tbConfStatus;
    }

    public void setTbConfStatus(StringFilter tbConfStatus) {
        this.tbConfStatus = tbConfStatus;
    }

    public StringFilter getHivStatus() {
        return hivStatus;
    }

    public void setHivStatus(StringFilter hivStatus) {
        this.hivStatus = hivStatus;
    }

    public LocalDateFilter getHivNextScreenDate() {
        return hivNextScreenDate;
    }

    public void setHivNextScreenDate(LocalDateFilter hivNextScreenDate) {
        this.hivNextScreenDate = hivNextScreenDate;
    }

    public BooleanFilter getHivArtLinked() {
        return hivArtLinked;
    }

    public void setHivArtLinked(BooleanFilter hivArtLinked) {
        this.hivArtLinked = hivArtLinked;
    }

    public StringFilter getHivArtCenter() {
        return hivArtCenter;
    }

    public void setHivArtCenter(StringFilter hivArtCenter) {
        this.hivArtCenter = hivArtCenter;
    }

    public StringFilter getHivArtNumber() {
        return hivArtNumber;
    }

    public void setHivArtNumber(StringFilter hivArtNumber) {
        this.hivArtNumber = hivArtNumber;
    }

    public StringFilter getHivArtStatus() {
        return hivArtStatus;
    }

    public void setHivArtStatus(StringFilter hivArtStatus) {
        this.hivArtStatus = hivArtStatus;
    }

    public StringFilter getHivArtAdherence() {
        return hivArtAdherence;
    }

    public void setHivArtAdherence(StringFilter hivArtAdherence) {
        this.hivArtAdherence = hivArtAdherence;
    }

    public StringFilter getReferredFacility() {
        return referredFacility;
    }

    public void setReferredFacility(StringFilter referredFacility) {
        this.referredFacility = referredFacility;
    }

    public StringFilter getReferredTo() {
        return referredTo;
    }

    public void setReferredTo(StringFilter referredTo) {
        this.referredTo = referredTo;
    }

    public StringFilter getReferralStatus() {
        return referralStatus;
    }

    public void setReferralStatus(StringFilter referralStatus) {
        this.referralStatus = referralStatus;
    }

    public BooleanFilter getIsOutwardReferal() {
        return isOutwardReferal;
    }

    public void setIsOutwardReferal(BooleanFilter isOutwardReferal) {
        this.isOutwardReferal = isOutwardReferal;
    }

    public BooleanFilter getIsTransit() {
        return isTransit;
    }

    public void setIsTransit(BooleanFilter isTransit) {
        this.isTransit = isTransit;
    }

    public LocalDateFilter getTransitStartDate() {
        return transitStartDate;
    }

    public void setTransitStartDate(LocalDateFilter transitStartDate) {
        this.transitStartDate = transitStartDate;
    }

    public LocalDateFilter getTransitEndDate() {
        return transitEndDate;
    }

    public void setTransitEndDate(LocalDateFilter transitEndDate) {
        this.transitEndDate = transitEndDate;
    }

    public StringFilter getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(StringFilter guardianName) {
        this.guardianName = guardianName;
    }

    public StringFilter getRelation() {
        return relation;
    }

    public void setRelation(StringFilter relation) {
        this.relation = relation;
    }

    public StringFilter getGuardianContactNumber() {
        return guardianContactNumber;
    }

    public void setGuardianContactNumber(StringFilter guardianContactNumber) {
        this.guardianContactNumber = guardianContactNumber;
    }

    public BooleanFilter getIsTransfer() {
        return isTransfer;
    }

    public void setIsTransfer(BooleanFilter isTransfer) {
        this.isTransfer = isTransfer;
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
        final TIBenExtDetailsCriteria that = (TIBenExtDetailsCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(withinTheDistrictNoOfTimes, that.withinTheDistrictNoOfTimes) &&
            Objects.equals(withinTheDistrictNoOfDays, that.withinTheDistrictNoOfDays) &&
            Objects.equals(withinTheStateNoOfTimes, that.withinTheStateNoOfTimes) &&
            Objects.equals(withinTheStateNoOfDays, that.withinTheStateNoOfDays) &&
            Objects.equals(outsideTheStateNoOfTimes, that.outsideTheStateNoOfTimes) &&
            Objects.equals(outsideTheStateNoOfDays, that.outsideTheStateNoOfDays) &&
            Objects.equals(mondayAvbl, that.mondayAvbl) &&
            Objects.equals(tuesdayAvbl, that.tuesdayAvbl) &&
            Objects.equals(wednesdayAvbl, that.wednesdayAvbl) &&
            Objects.equals(thursdayAvbl, that.thursdayAvbl) &&
            Objects.equals(fridayAvbl, that.fridayAvbl) &&
            Objects.equals(saturdayAvbl, that.saturdayAvbl) &&
            Objects.equals(syphilisLastScreenDate, that.syphilisLastScreenDate) &&
            Objects.equals(syphilisStatus, that.syphilisStatus) &&
            Objects.equals(syphilisNextScreenDate, that.syphilisNextScreenDate) &&
            Objects.equals(tbLastScreenDate, that.tbLastScreenDate) &&
            Objects.equals(tbScreeningStatus, that.tbScreeningStatus) &&
            Objects.equals(tbConfStatus, that.tbConfStatus) &&
            Objects.equals(hivStatus, that.hivStatus) &&
            Objects.equals(hivNextScreenDate, that.hivNextScreenDate) &&
            Objects.equals(hivArtLinked, that.hivArtLinked) &&
            Objects.equals(hivArtCenter, that.hivArtCenter) &&
            Objects.equals(hivArtNumber, that.hivArtNumber) &&
            Objects.equals(hivArtStatus, that.hivArtStatus) &&
            Objects.equals(hivArtAdherence, that.hivArtAdherence) &&
            Objects.equals(referredFacility, that.referredFacility) &&
            Objects.equals(referredTo, that.referredTo) &&
            Objects.equals(referralStatus, that.referralStatus) &&
            Objects.equals(isOutwardReferal, that.isOutwardReferal) &&
            Objects.equals(isTransit, that.isTransit) &&
            Objects.equals(transitStartDate, that.transitStartDate) &&
            Objects.equals(transitEndDate, that.transitEndDate) &&
            Objects.equals(guardianName, that.guardianName) &&
            Objects.equals(relation, that.relation) &&
            Objects.equals(guardianContactNumber, that.guardianContactNumber) &&
            Objects.equals(isTransfer, that.isTransfer) &&
            Objects.equals(beneficiaryId, that.beneficiaryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        withinTheDistrictNoOfTimes,
        withinTheDistrictNoOfDays,
        withinTheStateNoOfTimes,
        withinTheStateNoOfDays,
        outsideTheStateNoOfTimes,
        outsideTheStateNoOfDays,
        mondayAvbl,
        tuesdayAvbl,
        wednesdayAvbl,
        thursdayAvbl,
        fridayAvbl,
        saturdayAvbl,
        syphilisLastScreenDate,
        syphilisStatus,
        syphilisNextScreenDate,
        tbLastScreenDate,
        tbScreeningStatus,
        tbConfStatus,
        hivStatus,
        hivNextScreenDate,
        hivArtLinked,
        hivArtCenter,
        hivArtNumber,
        hivArtStatus,
        hivArtAdherence,
        referredFacility,
        referredTo,
        referralStatus,
        isOutwardReferal,
        isTransit,
        transitStartDate,
        transitEndDate,
        guardianName,
        relation,
        guardianContactNumber,
        isTransfer,
        beneficiaryId
        );
    }

    @Override
    public String toString() {
        return "TIBenExtDetailsCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (withinTheDistrictNoOfTimes != null ? "withinTheDistrictNoOfTimes=" + withinTheDistrictNoOfTimes + ", " : "") +
                (withinTheDistrictNoOfDays != null ? "withinTheDistrictNoOfDays=" + withinTheDistrictNoOfDays + ", " : "") +
                (withinTheStateNoOfTimes != null ? "withinTheStateNoOfTimes=" + withinTheStateNoOfTimes + ", " : "") +
                (withinTheStateNoOfDays != null ? "withinTheStateNoOfDays=" + withinTheStateNoOfDays + ", " : "") +
                (outsideTheStateNoOfTimes != null ? "outsideTheStateNoOfTimes=" + outsideTheStateNoOfTimes + ", " : "") +
                (outsideTheStateNoOfDays != null ? "outsideTheStateNoOfDays=" + outsideTheStateNoOfDays + ", " : "") +
                (mondayAvbl != null ? "mondayAvbl=" + mondayAvbl + ", " : "") +
                (tuesdayAvbl != null ? "tuesdayAvbl=" + tuesdayAvbl + ", " : "") +
                (wednesdayAvbl != null ? "wednesdayAvbl=" + wednesdayAvbl + ", " : "") +
                (thursdayAvbl != null ? "thursdayAvbl=" + thursdayAvbl + ", " : "") +
                (fridayAvbl != null ? "fridayAvbl=" + fridayAvbl + ", " : "") +
                (saturdayAvbl != null ? "saturdayAvbl=" + saturdayAvbl + ", " : "") +
                (syphilisLastScreenDate != null ? "syphilisLastScreenDate=" + syphilisLastScreenDate + ", " : "") +
                (syphilisStatus != null ? "syphilisStatus=" + syphilisStatus + ", " : "") +
                (syphilisNextScreenDate != null ? "syphilisNextScreenDate=" + syphilisNextScreenDate + ", " : "") +
                (tbLastScreenDate != null ? "tbLastScreenDate=" + tbLastScreenDate + ", " : "") +
                (tbScreeningStatus != null ? "tbScreeningStatus=" + tbScreeningStatus + ", " : "") +
                (tbConfStatus != null ? "tbConfStatus=" + tbConfStatus + ", " : "") +
                (hivStatus != null ? "hivStatus=" + hivStatus + ", " : "") +
                (hivNextScreenDate != null ? "hivNextScreenDate=" + hivNextScreenDate + ", " : "") +
                (hivArtLinked != null ? "hivArtLinked=" + hivArtLinked + ", " : "") +
                (hivArtCenter != null ? "hivArtCenter=" + hivArtCenter + ", " : "") +
                (hivArtNumber != null ? "hivArtNumber=" + hivArtNumber + ", " : "") +
                (hivArtStatus != null ? "hivArtStatus=" + hivArtStatus + ", " : "") +
                (hivArtAdherence != null ? "hivArtAdherence=" + hivArtAdherence + ", " : "") +
                (referredFacility != null ? "referredFacility=" + referredFacility + ", " : "") +
                (referredTo != null ? "referredTo=" + referredTo + ", " : "") +
                (referralStatus != null ? "referralStatus=" + referralStatus + ", " : "") +
                (isOutwardReferal != null ? "isOutwardReferal=" + isOutwardReferal + ", " : "") +
                (isTransit != null ? "isTransit=" + isTransit + ", " : "") +
                (transitStartDate != null ? "transitStartDate=" + transitStartDate + ", " : "") +
                (transitEndDate != null ? "transitEndDate=" + transitEndDate + ", " : "") +
                (guardianName != null ? "guardianName=" + guardianName + ", " : "") +
                (relation != null ? "relation=" + relation + ", " : "") +
                (guardianContactNumber != null ? "guardianContactNumber=" + guardianContactNumber + ", " : "") +
                (isTransfer != null ? "isTransfer=" + isTransfer + ", " : "") +
                (beneficiaryId != null ? "beneficiaryId=" + beneficiaryId + ", " : "") +
            "}";
    }

}
