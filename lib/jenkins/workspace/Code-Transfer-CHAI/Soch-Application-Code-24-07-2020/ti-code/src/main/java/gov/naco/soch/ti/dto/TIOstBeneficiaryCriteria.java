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

/**
 * Criteria class for the {@link gov.naco.soch.domain.TIBeneficiary} entity.
 * This class is used in {@link gov.naco.soch.web.rest.TIBeneficiaryResource} to
 * receive all the possible filtering options from the Http GET request
 * parameters. For example the following could be a valid request:
 * {@code /ti-beneficiaries?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific
 * {@link Filter} class are used, we need to use fix type specific filters.
 */
public class TIOstBeneficiaryCriteria implements Serializable, Criteria {

	private static final long serialVersionUID = 1L;

	private LongFilter id;

	private LongFilter facilityId;

	private LongFilter linkedFacilityId;

	private BooleanFilter consentDocumented;

	private StringFilter guardianContactNumber;

	private StringFilter guardianName;

	private IntegerFilter guardianRelationshipType;

	private BooleanFilter isActive;

	private BooleanFilter isDeleted;

	private BooleanFilter isOnDot;

	private BooleanFilter isTbDiagnosed;

	private BooleanFilter isTestedForSyphilis;

	private BooleanFilter isTransferOut;

	private BooleanFilter isTransit;

	private StringFilter ostCode;

	private StringFilter ostNumber;

	private IntegerFilter ostStatus;

	private BooleanFilter receivedStiTreatment;

	private IntegerFilter referredFrom;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateFilter registrationDate;

	private BooleanFilter tbSymptoms;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateFilter transitEndDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateFilter transitStartDate;

	private StringFilter param;

	private StringFilter uid;

	private StringFilter firstName;

	private StringFilter mobileNumber;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateFilter visitStartDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateFilter visitEndDate;
	
	 private BooleanFilter isActiveFacility;
	 
	 private StringFilter clientStatus;
	 
	 private LongFilter status;

	public LongFilter getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(LongFilter facilityId) {
		this.facilityId = facilityId;
	}

	public LocalDateFilter getVisitStartDate() {
		return visitStartDate;
	}

	public void setVisitStartDate(LocalDateFilter visitStartDate) {
		this.visitStartDate = visitStartDate;
	}

	public LocalDateFilter getVisitEndDate() {
		return visitEndDate;
	}

	public void setVisitEndDate(LocalDateFilter visitEndDate) {
		this.visitEndDate = visitEndDate;
	}

	public BooleanFilter getConsentDocumented() {
		return consentDocumented;
	}

	public void setConsentDocumented(BooleanFilter consentDocumented) {
		this.consentDocumented = consentDocumented;
	}

	public StringFilter getGuardianContactNumber() {
		return guardianContactNumber;
	}

	public void setGuardianContactNumber(StringFilter guardianContactNumber) {
		this.guardianContactNumber = guardianContactNumber;
	}

	public StringFilter getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(StringFilter guardianName) {
		this.guardianName = guardianName;
	}

	public IntegerFilter getGuardianRelationshipType() {
		return guardianRelationshipType;
	}

	public void setGuardianRelationshipType(IntegerFilter guardianRelationshipType) {
		this.guardianRelationshipType = guardianRelationshipType;
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

	public StringFilter getParam() {
		return param;
	}

	public void setParam(StringFilter param) {
		this.param = param;
	}

	public BooleanFilter getIsOnDot() {
		return isOnDot;
	}

	public void setIsOnDot(BooleanFilter isOnDot) {
		this.isOnDot = isOnDot;
	}

	public BooleanFilter getIsTbDiagnosed() {
		return isTbDiagnosed;
	}

	public void setIsTbDiagnosed(BooleanFilter isTbDiagnosed) {
		this.isTbDiagnosed = isTbDiagnosed;
	}

	public BooleanFilter getIsTestedForSyphilis() {
		return isTestedForSyphilis;
	}

	public void setIsTestedForSyphilis(BooleanFilter isTestedForSyphilis) {
		this.isTestedForSyphilis = isTestedForSyphilis;
	}

	public BooleanFilter getIsTransferOut() {
		return isTransferOut;
	}

	public void setIsTransferOut(BooleanFilter isTransferOut) {
		this.isTransferOut = isTransferOut;
	}

	public BooleanFilter getIsTransit() {
		return isTransit;
	}

	public void setIsTransit(BooleanFilter isTransit) {
		this.isTransit = isTransit;
	}

	public StringFilter getOstCode() {
		return ostCode;
	}

	public void setOstCode(StringFilter ostCode) {
		this.ostCode = ostCode;
	}

	public StringFilter getOstNumber() {
		return ostNumber;
	}

	public void setOstNumber(StringFilter ostNumber) {
		this.ostNumber = ostNumber;
	}

	public IntegerFilter getOstStatus() {
		return ostStatus;
	}

	public void setOstStatus(IntegerFilter ostStatus) {
		this.ostStatus = ostStatus;
	}

	public BooleanFilter getReceivedStiTreatment() {
		return receivedStiTreatment;
	}

	public void setReceivedStiTreatment(BooleanFilter receivedStiTreatment) {
		this.receivedStiTreatment = receivedStiTreatment;
	}

	public IntegerFilter getReferredFrom() {
		return referredFrom;
	}

	public void setReferredFrom(IntegerFilter referredFrom) {
		this.referredFrom = referredFrom;
	}

	public BooleanFilter getIsActiveFacility() {
		return isActiveFacility;
	}

	public void setIsActiveFacility(BooleanFilter isActiveFacility) {
		this.isActiveFacility = isActiveFacility;
	}

	public LocalDateFilter getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateFilter registrationDate) {
		this.registrationDate = registrationDate;
	}

	public StringFilter getClientStatus() {
		return clientStatus;
	}

	public void setClientStatus(StringFilter clientStatus) {
		this.clientStatus = clientStatus;
	}

	public LongFilter getLinkedFacilityId() {
		return linkedFacilityId;
	}

	public void setLinkedFacilityId(LongFilter linkedFacilityId) {
		this.linkedFacilityId = linkedFacilityId;
	}

	public LongFilter getStatus() {
	    return status;
	}

	public void setStatus(LongFilter status) {
	    this.status = status;
	}

	public BooleanFilter getTbSymptoms() {
		return tbSymptoms;
	}

	public void setTbSymptoms(BooleanFilter tbSymptoms) {
		this.tbSymptoms = tbSymptoms;
	}

	public LocalDateFilter getTransitEndDate() {
		return transitEndDate;
	}

	public void setTransitEndDate(LocalDateFilter transitEndDate) {
		this.transitEndDate = transitEndDate;
	}

	public LocalDateFilter getTransitStartDate() {
		return transitStartDate;
	}

	public void setTransitStartDate(LocalDateFilter transitStartDate) {
		this.transitStartDate = transitStartDate;
	}

	public LongFilter getId() {
		return id;
	}

	public void setId(LongFilter id) {
		this.id = id;
	}

	public StringFilter getUid() {
		return uid;
	}

	public void setUid(StringFilter uid) {
		this.uid = uid;
	}

	public StringFilter getFirstName() {
		return firstName;
	}

	public void setFirstName(StringFilter firstName) {
		this.firstName = firstName;
	}

	public StringFilter getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(StringFilter mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public TIOstBeneficiaryCriteria() {
	}

	public TIOstBeneficiaryCriteria(TIOstBeneficiaryCriteria other) {
		this.id = other.id == null ? null : other.id.copy();
		this.isActive = other.isActive == null ? null : other.isActive.copy();
		this.isDeleted = other.isDeleted == null ? null : other.isDeleted.copy();
		this.ostCode = other.ostCode == null ? null : other.ostCode.copy();
		this.ostStatus = other.ostStatus == null ? null : other.ostStatus.copy();
		this.consentDocumented = other.consentDocumented == null ? null : other.consentDocumented.copy();
		this.guardianContactNumber = other.guardianContactNumber == null ? null : other.guardianContactNumber.copy();
		this.guardianName = other.guardianName == null ? null : other.guardianName.copy();
		this.guardianRelationshipType = other.guardianRelationshipType == null ? null
				: other.guardianRelationshipType.copy();
		this.isOnDot = other.isOnDot == null ? null : other.isOnDot.copy();
		this.isTbDiagnosed = other.isTbDiagnosed == null ? null : other.isTbDiagnosed.copy();
		this.isTestedForSyphilis = other.isTestedForSyphilis == null ? null : other.isTestedForSyphilis.copy();
		this.isTransferOut = other.isTransferOut == null ? null : other.isTransferOut.copy();
		this.isTransit = other.isTransit == null ? null : other.isTransit.copy();
		this.ostNumber = other.ostNumber == null ? null : other.ostNumber.copy();
		this.receivedStiTreatment = other.receivedStiTreatment == null ? null : other.receivedStiTreatment.copy();
		this.referredFrom = other.referredFrom == null ? null : other.referredFrom.copy();
		this.registrationDate = other.registrationDate == null ? null : other.registrationDate.copy();
		this.tbSymptoms = other.tbSymptoms == null ? null : other.tbSymptoms.copy();
		this.transitEndDate = other.transitEndDate == null ? null : other.transitEndDate.copy();
		this.transitStartDate = other.transitStartDate == null ? null : other.transitStartDate.copy();
		this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
		this.param = other.param == null ? null : other.param.copy();
		this.firstName = other.firstName == null ? null : other.firstName.copy();
		this.mobileNumber = other.mobileNumber == null ? null : other.mobileNumber.copy();
		this.uid = other.uid == null ? null : other.uid.copy();
		this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
		this.linkedFacilityId = other.linkedFacilityId == null ? null : other.linkedFacilityId.copy();
		this.visitStartDate = other.visitStartDate == null ? null : other.visitStartDate.copy();
		this.visitEndDate = other.visitEndDate == null ? null : other.visitEndDate.copy();
		this.isActiveFacility=other.isActiveFacility==null?null:other.isActiveFacility.copy();
		this.clientStatus=other.clientStatus==null?null:other.clientStatus.copy();
		this.status=other.status==null?null:other.status.copy();
	}

	@Override
	public TIOstBeneficiaryCriteria copy() {
		return new TIOstBeneficiaryCriteria(this);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final TIOstBeneficiaryCriteria that = (TIOstBeneficiaryCriteria) o;
		return Objects.equals(id, that.id) && Objects.equals(isActive, that.isActive)
				&& Objects.equals(isDeleted, that.isDeleted) && Objects.equals(ostCode, that.ostCode)
				&& Objects.equals(ostStatus, that.ostStatus)
				&& Objects.equals(guardianContactNumber, that.guardianContactNumber)
				&& Objects.equals(guardianName, that.guardianName)
				&& Objects.equals(guardianRelationshipType, that.guardianRelationshipType)
				&& Objects.equals(isActive, that.isActive) && Objects.equals(isOnDot, that.isOnDot)
				&& Objects.equals(isTbDiagnosed, that.isTbDiagnosed)
				&& Objects.equals(isTestedForSyphilis, that.isTestedForSyphilis)
				&& Objects.equals(isTransferOut, that.isTransferOut) && Objects.equals(isTransit, that.isTransit)
				&& Objects.equals(ostNumber, that.ostNumber)
				&& Objects.equals(receivedStiTreatment, that.receivedStiTreatment)
				&& Objects.equals(referredFrom, that.ostStatus)
				&& Objects.equals(registrationDate, that.registrationDate) && Objects.equals(tbSymptoms, that.ostStatus)
				&& Objects.equals(transitEndDate, that.transitEndDate)
				&& Objects.equals(transitStartDate, that.transitStartDate)
				&& Objects.equals(facilityId, that.facilityId)
				&& Objects.equals(linkedFacilityId, that.linkedFacilityId)
				&& Objects.equals(isActiveFacility, that.isActiveFacility)
				&& Objects.equals(clientStatus, that.clientStatus)
				&& Objects.equals(status, that.status)
				&& Objects.equals(consentDocumented, that.consentDocumented);

	}

	@Override
	public int hashCode() {
		return Objects.hash(id, isActive, isDeleted, ostCode, ostStatus, consentDocumented, guardianContactNumber,
				guardianName, guardianRelationshipType, isTbDiagnosed, isTestedForSyphilis, isTransferOut, ostNumber,
				receivedStiTreatment, referredFrom, registrationDate, transitEndDate, tbSymptoms, transitStartDate,
				facilityId, linkedFacilityId,isActiveFacility,clientStatus,status

		);
	}

	@Override
	public String toString() {
		return "TIOstBeneficiaryCriteria [id=" + id + ", facilityId=" + facilityId + ", consentDocumented="
				+ consentDocumented + ", guardianContactNumber=" + guardianContactNumber + ", guardianName="
				+ guardianName + ", guardianRelationshipType=" + guardianRelationshipType + ", isActive=" + isActive
				+ ", isDeleted=" + isDeleted + ", isOnDot=" + isOnDot + ", isTbDiagnosed=" + isTbDiagnosed
				+ ", isTestedForSyphilis=" + isTestedForSyphilis + ", isTransferOut=" + isTransferOut + ", isTransit="
				+ isTransit + ", ostCode=" + ostCode + ", ostNumber=" + ostNumber + ", ostStatus=" + ostStatus
				+ ", receivedStiTreatment=" + receivedStiTreatment + ", referredFrom=" + referredFrom
				+ ", registrationDate=" + registrationDate + ", tbSymptoms=" + tbSymptoms + ", transitEndDate="
				+ transitEndDate + ", transitStartDate=" + transitStartDate + ", param=" + param + ", uid=" + uid
				+ ", firstName=" + firstName + ", mobileNumber=" + mobileNumber + ", visitStartDate=" + visitStartDate
				+ ", visitEndDate=" + visitEndDate + "]";
	}

}
