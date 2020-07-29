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
 * Criteria class for the {@link gov.naco.soch.domain.ICTCBeneficiaryVisit} entity. This class is used
 * in {@link gov.naco.soch.web.rest.ICTCBeneficiaryVisitResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ictc-beneficiary-visits?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ICTCBeneficiaryVisitCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

	private StringFilter pid;

	private StringFilter uid;

	private StringFilter firstName;

	private StringFilter middleName;

	private StringFilter lastName;

	private LocalDateFilter visitDate;

	private LongFilter beneficiaryId;

	private StringFilter mobileNumber;

	private StringFilter age;

	private StringFilter category;

	private BooleanFilter isPregnant;

	private StringFilter gender;

//	private LocalDateFilter testedDate;

	private LocalDateFilter reportReceivedDate;
	
	private LocalDateFilter reportDeliveryDate;

	private IntegerFilter hivStatus;

	private IntegerFilter hivType;

	private IntegerFilter infantBreastFed;

	private LocalDateFilter dateOfBirth;

	private StringFilter barcode;

	private IntegerFilter resultStatus;

	private LongFilter visitId;

	private StringFilter infantMotherArtNo;

	private LongFilter infantMotherArtId;

	private StringFilter infantMotherFirstName;
	
	private StringFilter infantMotherLastName;

	private StringFilter infantCode;

	private StringFilter occupation;

	private StringFilter maritalStatus;

	private IntegerFilter testType;
	
	private BooleanFilter isConsentDocumented;
	
	private IntegerFilter beneficiaryStatus;
	
	private LongFilter batchId;

	private StringFilter consignmentId;

	private LongFilter labId;

	private StringFilter labName;

	private StringFilter labCode;
	
	private LongFilter facilityId;
	
	private IntegerFilter categoryId;

	private IntegerFilter genderId;
	
	private IntegerFilter deletedReason;
	
	private StringFilter deletedReasonComment;
	
	private BooleanFilter isActive;

	private BooleanFilter isDeleted;

    public ICTCBeneficiaryVisitCriteria() {
    }

    public ICTCBeneficiaryVisitCriteria(ICTCBeneficiaryVisitCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.isConsentDocumented = other.isConsentDocumented == null ? null : other.isConsentDocumented.copy();
        this.beneficiaryStatus = other.beneficiaryStatus == null ? null : other.beneficiaryStatus.copy();
        this.infantMotherFirstName = other.infantMotherFirstName == null ? null : other.infantMotherFirstName.copy();
        this.infantMotherLastName = other.infantMotherLastName == null ? null : other.infantMotherLastName.copy();
        this.pid = other.pid == null ? null : other.pid.copy();
        this.firstName = other.firstName == null ? null : other.firstName.copy();
        this.middleName = other.middleName == null ? null : other.middleName.copy();
        this.lastName = other.lastName == null ? null : other.lastName.copy();
        this.occupation = other.occupation == null ? null : other.occupation.copy();
        this.maritalStatus = other.maritalStatus == null ? null : other.maritalStatus.copy();
        this.gender = other.gender == null ? null : other.gender.copy();
        this.dateOfBirth = other.dateOfBirth == null ? null : other.dateOfBirth.copy();
        this.age = other.age == null ? null : other.age.copy();
        this.mobileNumber = other.mobileNumber == null ? null : other.mobileNumber.copy();
        this.infantBreastFed = other.infantBreastFed == null ? null : other.infantBreastFed.copy();
        this.infantMotherArtNo = other.infantMotherArtNo == null ? null : other.infantMotherArtNo.copy();
        this.infantMotherArtId = other.infantMotherArtId == null ? null : other.infantMotherArtId.copy();
        this.infantCode = other.infantCode == null ? null : other.infantCode.copy();
        this.category = other.category == null ? null : other.category.copy();
        this.visitDate = other.visitDate == null ? null : other.visitDate.copy();
        this.isPregnant = other.isPregnant == null ? null : other.isPregnant.copy();
        this.visitId = other.visitId == null ? null : other.visitId.copy();
        this.testType = other.testType == null ? null : other.testType.copy();
//        this.testedDate = other.testedDate == null ? null : other.testedDate.copy();
        this.resultStatus = other.resultStatus == null ? null : other.resultStatus.copy();
        this.hivStatus = other.hivStatus == null ? null : other.hivStatus.copy();
        this.hivType = other.hivType == null ? null : other.hivType.copy();
        this.reportDeliveryDate = other.reportDeliveryDate == null ? null : other.reportDeliveryDate.copy();
        this.reportReceivedDate = other.reportReceivedDate == null ? null : other.reportReceivedDate.copy();
        this.barcode = other.barcode == null ? null : other.barcode.copy();
        this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
        this.batchId = other.batchId == null ? null : other.batchId.copy();
        this.consignmentId = other.consignmentId == null ? null : other.consignmentId.copy();
        this.labId = other.labId == null ? null : other.labId.copy();
        this.labName = other.labName == null ? null : other.labName.copy();
        this.labCode = other.labCode == null ? null : other.labCode.copy();
        this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
        this.genderId = other.genderId == null ? null : other.genderId.copy();
        this.categoryId = other.categoryId == null ? null : other.categoryId.copy();
        this.deletedReason = other.deletedReason == null ? null : other.deletedReason.copy();
        this.deletedReasonComment = other.deletedReasonComment == null ? null : other.deletedReasonComment.copy();
        this.isActive = other.isActive == null ? null : other.isActive.copy();
        this.isDeleted = other.isDeleted == null ? null : other.isDeleted.copy();
    }

    @Override
    public ICTCBeneficiaryVisitCriteria copy() {
        return new ICTCBeneficiaryVisitCriteria(this);
    }

	public LongFilter getId() {
		return id;
	}

	public void setId(LongFilter id) {
		this.id = id;
	}

	public StringFilter getPid() {
		return pid;
	}

	public void setPid(StringFilter pid) {
		this.pid = pid;
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

	public StringFilter getMiddleName() {
		return middleName;
	}

	public void setMiddleName(StringFilter middleName) {
		this.middleName = middleName;
	}

	public StringFilter getLastName() {
		return lastName;
	}

	public void setLastName(StringFilter lastName) {
		this.lastName = lastName;
	}

	public LocalDateFilter getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDateFilter visitDate) {
		this.visitDate = visitDate;
	}

	public LongFilter getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(LongFilter beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public StringFilter getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(StringFilter mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public StringFilter getAge() {
		return age;
	}

	public void setAge(StringFilter age) {
		this.age = age;
	}

	public StringFilter getCategory() {
		return category;
	}

	public void setCategory(StringFilter category) {
		this.category = category;
	}

	public BooleanFilter getIsPregnant() {
		return isPregnant;
	}

	public void setIsPregnant(BooleanFilter isPregnant) {
		this.isPregnant = isPregnant;
	}

	public StringFilter getGender() {
		return gender;
	}

	public void setGender(StringFilter gender) {
		this.gender = gender;
	}

//	public LocalDateFilter getTestedDate() {
//		return testedDate;
//	}
//
//	public void setTestedDate(LocalDateFilter testedDate) {
//		this.testedDate = testedDate;
//	}

	public LocalDateFilter getReportReceivedDate() {
		return reportReceivedDate;
	}

	public void setReportReceivedDate(LocalDateFilter reportReceivedDate) {
		this.reportReceivedDate = reportReceivedDate;
	}

	public LocalDateFilter getReportDeliveryDate() {
		return reportDeliveryDate;
	}

	public void setReportDeliveryDate(LocalDateFilter reportDeliveryDate) {
		this.reportDeliveryDate = reportDeliveryDate;
	}

	public IntegerFilter getHivStatus() {
		return hivStatus;
	}

	public void setHivStatus(IntegerFilter hivStatus) {
		this.hivStatus = hivStatus;
	}

	public IntegerFilter getHivType() {
		return hivType;
	}

	public void setHivType(IntegerFilter hivType) {
		this.hivType = hivType;
	}

	public IntegerFilter getInfantBreastFed() {
		return infantBreastFed;
	}

	public void setInfantBreastFed(IntegerFilter infantBreastFed) {
		this.infantBreastFed = infantBreastFed;
	}

	public LocalDateFilter getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateFilter dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public StringFilter getBarcode() {
		return barcode;
	}

	public void setBarcode(StringFilter barcode) {
		this.barcode = barcode;
	}

	public IntegerFilter getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(IntegerFilter resultStatus) {
		this.resultStatus = resultStatus;
	}

	public LongFilter getVisitId() {
		return visitId;
	}

	public void setVisitId(LongFilter visitId) {
		this.visitId = visitId;
	}

	public StringFilter getInfantMotherArtNo() {
		return infantMotherArtNo;
	}

	public void setInfantMotherArtNo(StringFilter infantMotherArtNo) {
		this.infantMotherArtNo = infantMotherArtNo;
	}

	public LongFilter getInfantMotherArtId() {
		return infantMotherArtId;
	}

	public void setInfantMotherArtId(LongFilter infantMotherArtId) {
		this.infantMotherArtId = infantMotherArtId;
	}

	public StringFilter getInfantMotherFirstName() {
		return infantMotherFirstName;
	}

	public void setInfantMotherFirstName(StringFilter infantMotherFirstName) {
		this.infantMotherFirstName = infantMotherFirstName;
	}

	public StringFilter getInfantMotherLastName() {
		return infantMotherLastName;
	}

	public void setInfantMotherLastName(StringFilter infantMotherLastName) {
		this.infantMotherLastName = infantMotherLastName;
	}

	public StringFilter getInfantCode() {
		return infantCode;
	}

	public void setInfantCode(StringFilter infantCode) {
		this.infantCode = infantCode;
	}

	public StringFilter getOccupation() {
		return occupation;
	}

	public void setOccupation(StringFilter occupation) {
		this.occupation = occupation;
	}

	public StringFilter getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(StringFilter maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public IntegerFilter getTestType() {
		return testType;
	}

	public void setTestType(IntegerFilter testType) {
		this.testType = testType;
	}
	

	public BooleanFilter getIsConsentDocumented() {
		return isConsentDocumented;
	}

	public void setIsConsentDocumented(BooleanFilter isConsentDocumented) {
		this.isConsentDocumented = isConsentDocumented;
	}

	public IntegerFilter getBeneficiaryStatus() {
		return beneficiaryStatus;
	}

	public void setBeneficiaryStatus(IntegerFilter beneficiaryStatus) {
		this.beneficiaryStatus = beneficiaryStatus;
	}
	
	public LongFilter getBatchId() {
		return batchId;
	}

	public void setBatchId(LongFilter batchId) {
		this.batchId = batchId;
	}

	public StringFilter getConsignmentId() {
		return consignmentId;
	}

	public void setConsignmentId(StringFilter consignmentId) {
		this.consignmentId = consignmentId;
	}

	public LongFilter getLabId() {
		return labId;
	}

	public void setLabId(LongFilter labId) {
		this.labId = labId;
	}

	public StringFilter getLabName() {
		return labName;
	}

	public void setLabName(StringFilter labName) {
		this.labName = labName;
	}

	public StringFilter getLabCode() {
		return labCode;
	}

	public void setLabCode(StringFilter labCode) {
		this.labCode = labCode;
	}
	
	public LongFilter getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(LongFilter facilityId) {
		this.facilityId = facilityId;
	}
	
	public IntegerFilter getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(IntegerFilter categoryId) {
		this.categoryId = categoryId;
	}

	public IntegerFilter getGenderId() {
		return genderId;
	}

	public void setGenderId(IntegerFilter genderId) {
		this.genderId = genderId;
	}
	
	public IntegerFilter getDeletedReason() {
		return deletedReason;
	}

	public void setDeletedReason(IntegerFilter deletedReason) {
		this.deletedReason = deletedReason;
	}

	public StringFilter getDeletedReasonComment() {
		return deletedReasonComment;
	}

	public void setDeletedReasonComment(StringFilter deletedReasonComment) {
		this.deletedReasonComment = deletedReasonComment;
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

	@Override
	public int hashCode() {
		return Objects.hash(age, barcode, batchId, beneficiaryId, beneficiaryStatus, category, categoryId,
				consignmentId, dateOfBirth, facilityId, firstName, gender, genderId, hivStatus, hivType, id,
				infantBreastFed, infantCode, infantMotherArtId, infantMotherArtNo, infantMotherFirstName,
				infantMotherLastName, isActive, isConsentDocumented, isDeleted, isPregnant, labCode, labId, labName,
				lastName, maritalStatus, middleName, mobileNumber, occupation, pid, reportDeliveryDate,
				reportReceivedDate, resultStatus, testType, uid, visitDate, visitId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ICTCBeneficiaryVisitCriteria other = (ICTCBeneficiaryVisitCriteria) obj;
		return Objects.equals(age, other.age) && Objects.equals(barcode, other.barcode)
				&& Objects.equals(batchId, other.batchId) && Objects.equals(beneficiaryId, other.beneficiaryId)
				&& Objects.equals(beneficiaryStatus, other.beneficiaryStatus)
				&& Objects.equals(category, other.category) && Objects.equals(categoryId, other.categoryId)
				&& Objects.equals(consignmentId, other.consignmentId) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(facilityId, other.facilityId) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(gender, other.gender) && Objects.equals(genderId, other.genderId)
				&& Objects.equals(hivStatus, other.hivStatus) && Objects.equals(hivType, other.hivType)
				&& Objects.equals(id, other.id) && Objects.equals(infantBreastFed, other.infantBreastFed)
				&& Objects.equals(infantCode, other.infantCode)
				&& Objects.equals(infantMotherArtId, other.infantMotherArtId)
				&& Objects.equals(infantMotherArtNo, other.infantMotherArtNo)
				&& Objects.equals(infantMotherFirstName, other.infantMotherFirstName)
				&& Objects.equals(infantMotherLastName, other.infantMotherLastName)
				&& Objects.equals(isActive, other.isActive)
				&& Objects.equals(deletedReason, other.deletedReason)
				&& Objects.equals(deletedReasonComment, other.deletedReasonComment)
				&& Objects.equals(isConsentDocumented, other.isConsentDocumented)
				&& Objects.equals(isDeleted, other.isDeleted) && Objects.equals(isPregnant, other.isPregnant)
				&& Objects.equals(labCode, other.labCode) && Objects.equals(labId, other.labId)
				&& Objects.equals(labName, other.labName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(maritalStatus, other.maritalStatus) && Objects.equals(middleName, other.middleName)
				&& Objects.equals(mobileNumber, other.mobileNumber) && Objects.equals(occupation, other.occupation)
				&& Objects.equals(pid, other.pid) && Objects.equals(reportDeliveryDate, other.reportDeliveryDate)
				&& Objects.equals(reportReceivedDate, other.reportReceivedDate)
				&& Objects.equals(resultStatus, other.resultStatus) && Objects.equals(testType, other.testType)
				&& Objects.equals(uid, other.uid) && Objects.equals(visitDate, other.visitDate)
				&& Objects.equals(visitId, other.visitId);
	}

	@Override
	public String toString() {
		return "ICTCBeneficiaryVisitCriteria [id=" + id + ", pid=" + pid + ", uid=" + uid + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", visitDate=" + visitDate
				+ ", beneficiaryId=" + beneficiaryId + ", mobileNumber=" + mobileNumber + ", age=" + age + ", category="
				+ category + ", isPregnant=" + isPregnant + ", gender=" + gender + ", reportReceivedDate="
				+ reportReceivedDate + ", reportDeliveryDate=" + reportDeliveryDate + ", hivStatus=" + hivStatus
				+ ", hivType=" + hivType + ", infantBreastFed=" + infantBreastFed + ", dateOfBirth=" + dateOfBirth
				+ ", barcode=" + barcode + ", resultStatus=" + resultStatus + ", visitId=" + visitId
				+ ", infantMotherArtNo=" + infantMotherArtNo + ", infantMotherArtId=" + infantMotherArtId
				+ ", infantMotherFirstName=" + infantMotherFirstName + ", infantMotherLastName=" + infantMotherLastName
				+ ", infantCode=" + infantCode + ", occupation=" + occupation + ", maritalStatus=" + maritalStatus
				+ ", testType=" + testType + ", isConsentDocumented=" + isConsentDocumented + ", beneficiaryStatus="
				+ beneficiaryStatus + ", batchId=" + batchId + ", consignmentId=" + consignmentId + ", labId=" + labId
				+ ", labName=" + labName + ", labCode=" + labCode + ", facilityId=" + facilityId + ", categoryId="
				+ categoryId + ", genderId=" + genderId + ", isActive=" + isActive + ", isDeleted=" + isDeleted
				+ ", deletedReason=" + deletedReason + ", deletedReasonComment=" + deletedReasonComment + "]";

	}

}
