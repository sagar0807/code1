package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;



/**
 * Criteria class for the ICTCTestResultView entity. This class is used in ICTCTestResultViewResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /ictc-test-result-views?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ICTCTestResultViewCriteria implements Serializable {
    private static final long serialVersionUID = 1L;


    private LongFilter id;

    private StringFilter uid;

    private StringFilter firstName;

    private StringFilter middleName;

    private StringFilter lastName;

    private StringFilter age;

    private StringFilter gender;

    private LocalDateFilter sampleCollectionDate;

    private IntegerFilter testType;

    private IntegerFilter resultStatus;

    private IntegerFilter hivStatus;

    private IntegerFilter hivType;

//    private LocalDateFilter testedDate;

    private LongFilter sampleId;
    
    private LongFilter batchId;

    private StringFilter consignmentId;

    private LongFilter beneficiaryId;

    private LongFilter ictcBeneficiaryId;

    private LongFilter visitId;

    private LocalDateFilter dateOfBirth;

    private IntegerFilter sampleCollectionStatus;

    private IntegerFilter batchStatus;
    
    private StringFilter category;
    
    private LongFilter labId;
    
    private StringFilter labName;
    
    private StringFilter labCode;
    
    private LongFilter facilityId;
    
    private IntegerFilter categoryId;

	private IntegerFilter genderId;
	
	private StringFilter infantCode;

    public ICTCTestResultViewCriteria() {
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

    public LocalDateFilter getSampleCollectionDate() {
        return sampleCollectionDate;
    }

    public void setSampleCollectionDate(LocalDateFilter sampleCollectionDate) {
        this.sampleCollectionDate = sampleCollectionDate;
    }

    public IntegerFilter getTestType() {
        return testType;
    }

    public void setTestType(IntegerFilter testType) {
        this.testType = testType;
    }

    public IntegerFilter getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(IntegerFilter resultStatus) {
        this.resultStatus = resultStatus;
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

//    public LocalDateFilter getTestedDate() {
//        return testedDate;
//    }
//
//    public void setTestedDate(LocalDateFilter testedDate) {
//        this.testedDate = testedDate;
//    }

    public LongFilter getSampleId() {
        return sampleId;
    }

    public void setSampleId(LongFilter sampleId) {
        this.sampleId = sampleId;
    }

    public StringFilter getConsignmentId() {
        return consignmentId;
    }

    public void setConsignmentId(StringFilter consignmentId) {
        this.consignmentId = consignmentId;
    }

    public LongFilter getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(LongFilter beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public LongFilter getIctcBeneficiaryId() {
        return ictcBeneficiaryId;
    }

    public void setIctcBeneficiaryId(LongFilter ictcBeneficiaryId) {
        this.ictcBeneficiaryId = ictcBeneficiaryId;
    }

    public LongFilter getVisitId() {
        return visitId;
    }

    public void setVisitId(LongFilter visitId) {
        this.visitId = visitId;
    }

    public LocalDateFilter getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateFilter dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public IntegerFilter getSampleCollectionStatus() {
        return sampleCollectionStatus;
    }

    public void setSampleCollectionStatus(IntegerFilter sampleCollectionStatus) {
        this.sampleCollectionStatus = sampleCollectionStatus;
    }

    public IntegerFilter getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(IntegerFilter batchStatus) {
        this.batchStatus = batchStatus;
    }
    
    public StringFilter getCategory() {
		return category;
	}

	public void setCategory(StringFilter category) {
		this.category = category;
	}
	
	public LongFilter getBatchId() {
		return batchId;
	}

	public void setBatchId(LongFilter batchId) {
		this.batchId = batchId;
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
	
	public StringFilter getInfantCode() {
		return infantCode;
	}

	public void setInfantCode(StringFilter infantCode) {
		this.infantCode = infantCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, batchId, batchStatus, beneficiaryId, category, categoryId, consignmentId, dateOfBirth,
				facilityId, firstName, gender, genderId, hivStatus, hivType, ictcBeneficiaryId, id, infantCode, labCode,
				labId, labName, lastName, middleName, resultStatus, sampleCollectionDate, sampleCollectionStatus,
				sampleId, testType, uid, visitId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ICTCTestResultViewCriteria other = (ICTCTestResultViewCriteria) obj;
		return Objects.equals(age, other.age) && Objects.equals(batchId, other.batchId)
				&& Objects.equals(batchStatus, other.batchStatus) && Objects.equals(beneficiaryId, other.beneficiaryId)
				&& Objects.equals(category, other.category) && Objects.equals(categoryId, other.categoryId)
				&& Objects.equals(consignmentId, other.consignmentId) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(facilityId, other.facilityId) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(gender, other.gender) && Objects.equals(genderId, other.genderId)
				&& Objects.equals(hivStatus, other.hivStatus) && Objects.equals(hivType, other.hivType)
				&& Objects.equals(ictcBeneficiaryId, other.ictcBeneficiaryId) && Objects.equals(id, other.id)
				&& Objects.equals(infantCode, other.infantCode) && Objects.equals(labCode, other.labCode)
				&& Objects.equals(labId, other.labId) && Objects.equals(labName, other.labName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(middleName, other.middleName)
				&& Objects.equals(resultStatus, other.resultStatus)
				&& Objects.equals(sampleCollectionDate, other.sampleCollectionDate)
				&& Objects.equals(sampleCollectionStatus, other.sampleCollectionStatus)
				&& Objects.equals(sampleId, other.sampleId) && Objects.equals(testType, other.testType)
				&& Objects.equals(uid, other.uid) && Objects.equals(visitId, other.visitId);
	}

	@Override
	public String toString() {
		return "ICTCTestResultViewCriteria [id=" + id + ", uid=" + uid + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender
				+ ", sampleCollectionDate=" + sampleCollectionDate + ", testType=" + testType + ", resultStatus="
				+ resultStatus + ", hivStatus=" + hivStatus + ", hivType=" + hivType + ", sampleId=" + sampleId
				+ ", batchId=" + batchId + ", consignmentId=" + consignmentId + ", beneficiaryId=" + beneficiaryId
				+ ", ictcBeneficiaryId=" + ictcBeneficiaryId + ", visitId=" + visitId + ", dateOfBirth=" + dateOfBirth
				+ ", sampleCollectionStatus=" + sampleCollectionStatus + ", batchStatus=" + batchStatus + ", category="
				+ category + ", labId=" + labId + ", labName=" + labName + ", labCode=" + labCode + ", facilityId="
				+ facilityId + ", categoryId=" + categoryId + ", genderId=" + genderId + ", infantCode=" + infantCode
				+ "]";
	}

}
