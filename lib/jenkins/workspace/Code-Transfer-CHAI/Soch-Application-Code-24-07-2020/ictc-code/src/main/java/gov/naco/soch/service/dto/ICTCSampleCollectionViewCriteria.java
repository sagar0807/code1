package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;



/**
 * Criteria class for the ICTCSampleCollectionView entity. This class is used in ICTCSampleCollectionViewResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /ictc-sample-collection-views?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ICTCSampleCollectionViewCriteria implements Serializable {
    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter infantCode;

    private StringFilter firstName;

    private StringFilter middleName;

    private StringFilter lastName;

    private StringFilter age;

    private StringFilter gender;

    private LocalDateFilter visitDate;

    private IntegerFilter testType;

    private LongFilter ictcBeneficiaryId;

    private LongFilter visitId;

    private StringFilter pid;

    private StringFilter uid;

    private IntegerFilter sampleCollectionStatus;

    private StringFilter barcode;

    private LocalDateFilter sampleCollectionDate;
    
    private StringFilter category;
    
    private LongFilter batchId;
    
    private IntegerFilter resultStatus;
    
    private LongFilter facilityId;
    
    private IntegerFilter infantBreastFed;
    
    private IntegerFilter categoryId;

	private IntegerFilter genderId;

    public ICTCSampleCollectionViewCriteria() {
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getInfantCode() {
        return infantCode;
    }

    public void setInfantCode(StringFilter infantCode) {
        this.infantCode = infantCode;
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

    public LocalDateFilter getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDateFilter visitDate) {
        this.visitDate = visitDate;
    }

    public IntegerFilter getTestType() {
        return testType;
    }

    public void setTestType(IntegerFilter testType) {
        this.testType = testType;
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

    public IntegerFilter getSampleCollectionStatus() {
        return sampleCollectionStatus;
    }

    public void setSampleCollectionStatus(IntegerFilter sampleCollectionStatus) {
        this.sampleCollectionStatus = sampleCollectionStatus;
    }

    public StringFilter getBarcode() {
        return barcode;
    }

    public void setBarcode(StringFilter barcode) {
        this.barcode = barcode;
    }

    public LocalDateFilter getSampleCollectionDate() {
        return sampleCollectionDate;
    }

    public void setSampleCollectionDate(LocalDateFilter sampleCollectionDate) {
        this.sampleCollectionDate = sampleCollectionDate;
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
	
	public IntegerFilter getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(IntegerFilter resultStatus) {
		this.resultStatus = resultStatus;
	}

	public LongFilter getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(LongFilter facilityId) {
		this.facilityId = facilityId;
	}
	
	public IntegerFilter getInfantBreastFed() {
		return infantBreastFed;
	}

	public void setInfantBreastFed(IntegerFilter infantBreastFed) {
		this.infantBreastFed = infantBreastFed;
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
	public int hashCode() {
		return Objects.hash(age, barcode, batchId, category, categoryId, facilityId, firstName, gender, genderId,
				ictcBeneficiaryId, id, infantBreastFed, infantCode, lastName, middleName, pid, resultStatus,
				sampleCollectionDate, sampleCollectionStatus, testType, uid, visitDate, visitId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ICTCSampleCollectionViewCriteria other = (ICTCSampleCollectionViewCriteria) obj;
		return Objects.equals(age, other.age) && Objects.equals(barcode, other.barcode)
				&& Objects.equals(batchId, other.batchId) && Objects.equals(category, other.category)
				&& Objects.equals(categoryId, other.categoryId) && Objects.equals(facilityId, other.facilityId)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(gender, other.gender)
				&& Objects.equals(genderId, other.genderId)
				&& Objects.equals(ictcBeneficiaryId, other.ictcBeneficiaryId) && Objects.equals(id, other.id)
				&& Objects.equals(infantBreastFed, other.infantBreastFed)
				&& Objects.equals(infantCode, other.infantCode) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(middleName, other.middleName) && Objects.equals(pid, other.pid)
				&& Objects.equals(resultStatus, other.resultStatus)
				&& Objects.equals(sampleCollectionDate, other.sampleCollectionDate)
				&& Objects.equals(sampleCollectionStatus, other.sampleCollectionStatus)
				&& Objects.equals(testType, other.testType) && Objects.equals(uid, other.uid)
				&& Objects.equals(visitDate, other.visitDate) && Objects.equals(visitId, other.visitId);
	}

	@Override
	public String toString() {
		return "ICTCSampleCollectionViewCriteria [id=" + id + ", infantCode=" + infantCode + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender
				+ ", visitDate=" + visitDate + ", testType=" + testType + ", ictcBeneficiaryId=" + ictcBeneficiaryId
				+ ", visitId=" + visitId + ", pid=" + pid + ", uid=" + uid + ", sampleCollectionStatus="
				+ sampleCollectionStatus + ", barcode=" + barcode + ", sampleCollectionDate=" + sampleCollectionDate
				+ ", category=" + category + ", batchId=" + batchId + ", resultStatus=" + resultStatus + ", facilityId="
				+ facilityId + ", infantBreastFed=" + infantBreastFed + ", categoryId=" + categoryId + ", genderId="
				+ genderId + "]";
	}

}
