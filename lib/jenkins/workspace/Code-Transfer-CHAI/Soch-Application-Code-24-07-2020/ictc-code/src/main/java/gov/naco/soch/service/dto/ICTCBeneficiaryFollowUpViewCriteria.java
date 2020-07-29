package gov.naco.soch.service.dto;

import java.io.Serializable;

import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;



/**
 * Criteria class for the ICTCBeneficiaryFollowUpView entity. This class is used in ICTCBeneficiaryFollowUpViewResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /ictc-beneficiary-follow-up-views?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ICTCBeneficiaryFollowUpViewCriteria implements Serializable {
    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter pid;

    private StringFilter uid;

    private StringFilter firstName;

    private StringFilter lastName;

    private StringFilter middleName;

    private StringFilter mobileNumber;

    private StringFilter age;

    private StringFilter gender;

    private StringFilter category;

    private LocalDateFilter followUpDate;

    private IntegerFilter followUpType;

    private LocalDateFilter expectedDeliveryDate;

    private LocalDateFilter pregnancyLmpDate;

    private LocalDateFilter deliveryDate;

//    private StringFilter remarks;

    private BooleanFilter isCompleted;

    private IntegerFilter beneficiaryStatus;

    private LongFilter beneficiaryId;

    private LongFilter visitId;

    private LongFilter testResultId;

    private LongFilter ictcBeneficiaryId;

    private LongFilter facilityId;
    
    private LocalDateFilter visitDate;
    
    private LocalDateFilter dateOfBirth;
    
    private IntegerFilter categoryId;

	private IntegerFilter genderId;

    public ICTCBeneficiaryFollowUpViewCriteria() {
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

    public StringFilter getLastName() {
        return lastName;
    }

    public void setLastName(StringFilter lastName) {
        this.lastName = lastName;
    }

    public StringFilter getMiddleName() {
        return middleName;
    }

    public void setMiddleName(StringFilter middleName) {
        this.middleName = middleName;
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

    public StringFilter getGender() {
        return gender;
    }

    public void setGender(StringFilter gender) {
        this.gender = gender;
    }

    public StringFilter getCategory() {
        return category;
    }

    public void setCategory(StringFilter category) {
        this.category = category;
    }

    public LocalDateFilter getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(LocalDateFilter followUpDate) {
        this.followUpDate = followUpDate;
    }

    public IntegerFilter getFollowUpType() {
        return followUpType;
    }

    public void setFollowUpType(IntegerFilter followUpType) {
        this.followUpType = followUpType;
    }

    public LocalDateFilter getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(LocalDateFilter expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public LocalDateFilter getPregnancyLmpDate() {
        return pregnancyLmpDate;
    }

    public void setPregnancyLmpDate(LocalDateFilter pregnancyImpDate) {
        this.pregnancyLmpDate = pregnancyImpDate;
    }

    public LocalDateFilter getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateFilter deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

//    public StringFilter getRemarks() {
//        return remarks;
//    }
//
//    public void setRemarks(StringFilter remarks) {
//        this.remarks = remarks;
//    }

    public BooleanFilter getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(BooleanFilter isCompleted) {
        this.isCompleted = isCompleted;
    }

    public IntegerFilter getBeneficiaryStatus() {
        return beneficiaryStatus;
    }

    public void setBeneficiaryStatus(IntegerFilter beneficiaryStatus) {
        this.beneficiaryStatus = beneficiaryStatus;
    }

    public LongFilter getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(LongFilter beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public LongFilter getVisitId() {
        return visitId;
    }

    public void setVisitId(LongFilter visitId) {
        this.visitId = visitId;
    }

    public LongFilter getTestResultId() {
        return testResultId;
    }

    public void setTestResultId(LongFilter testResultId) {
        this.testResultId = testResultId;
    }

    public LongFilter getIctcBeneficiaryId() {
        return ictcBeneficiaryId;
    }

    public void setIctcBeneficiaryId(LongFilter ictcBeneficiaryId) {
        this.ictcBeneficiaryId = ictcBeneficiaryId;
    }

    public LongFilter getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(LongFilter facilityId) {
        this.facilityId = facilityId;
    }
    

    public LocalDateFilter getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDateFilter visitDate) {
		this.visitDate = visitDate;
	}

	public LocalDateFilter getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateFilter dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	@Override
	public String toString() {
		return "ICTCBeneficiaryFollowUpViewCriteria [id=" + id + ", pid=" + pid + ", uid=" + uid + ", firstName="
				+ firstName + ", lastName=" + lastName + ", middleName=" + middleName + ", mobileNumber=" + mobileNumber
				+ ", age=" + age + ", gender=" + gender + ", category=" + category + ", followUpDate=" + followUpDate
				+ ", followUpType=" + followUpType + ", expectedDeliveryDate=" + expectedDeliveryDate
				+ ", pregnancyLmpDate=" + pregnancyLmpDate + ", deliveryDate=" + deliveryDate + ", isCompleted="
				+ isCompleted + ", beneficiaryStatus=" + beneficiaryStatus + ", beneficiaryId=" + beneficiaryId
				+ ", visitId=" + visitId + ", testResultId=" + testResultId + ", ictcBeneficiaryId=" + ictcBeneficiaryId
				+ ", facilityId=" + facilityId + ", visitDate=" + visitDate + ", dateOfBirth=" + dateOfBirth
				+ ", categoryId=" + categoryId + ", genderId=" + genderId + "]";
	}

}
