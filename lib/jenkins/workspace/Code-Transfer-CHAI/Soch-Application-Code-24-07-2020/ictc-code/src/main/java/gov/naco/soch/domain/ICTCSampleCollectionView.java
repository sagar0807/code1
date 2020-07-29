package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A ICTCSampleCollectionView.
 */
@Entity
@Table(name = "ictc_sample_collection_view")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ICTCSampleCollectionView implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "infant_code")
    private String infantCode;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private String age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "visit_date")
    private LocalDate visitDate;

    @Column(name = "test_type")
    private Integer testType;

    @Column(name = "ictc_beneficiary_id")
    private Long ictcBeneficiaryId;

    @Column(name = "visit_id")
    private Long visitId;

    @Column(name = "pid")
    private String pid;

    @Column(name = "uid")
    private String uid;

    @Column(name = "sample_collection_status")
    private Integer sampleCollectionStatus;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "sample_collection_date")
    private LocalDateTime sampleCollectionDate;
    
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    
    @Column(name = "category")
    private String category;
    
    @Column(name = "batch_id")
    private Long batchId;
    
    @Column(name = "result_status")
    private Integer resultStatus;
    
    @Column(name = "facility_id")
    private Long facilityId;
    
    @Column(name = "infant_breast_fed")
    private Integer infantBreastFed;
    
    @Column(name = "category_id")
    private Integer categoryId;
    
    @Column(name = "gender_id")
    private Integer genderId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfantCode() {
        return infantCode;
    }

    public ICTCSampleCollectionView infantCode(String infantCode) {
        this.infantCode = infantCode;
        return this;
    }

    public void setInfantCode(String infantCode) {
        this.infantCode = infantCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public ICTCSampleCollectionView firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public ICTCSampleCollectionView middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public ICTCSampleCollectionView lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public ICTCSampleCollectionView age(String age) {
        this.age = age;
        return this;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public ICTCSampleCollectionView gender(String gender) {
        this.gender = gender;
        return this;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public ICTCSampleCollectionView visitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
        return this;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public Integer getTestType() {
        return testType;
    }

    public ICTCSampleCollectionView testType(Integer testType) {
        this.testType = testType;
        return this;
    }

    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    public Long getIctcBeneficiaryId() {
        return ictcBeneficiaryId;
    }

    public ICTCSampleCollectionView ictcBeneficiaryId(Long ictcBeneficiaryId) {
        this.ictcBeneficiaryId = ictcBeneficiaryId;
        return this;
    }

    public void setIctcBeneficiaryId(Long ictcBeneficiaryId) {
        this.ictcBeneficiaryId = ictcBeneficiaryId;
    }

    public Long getVisitId() {
        return visitId;
    }

    public ICTCSampleCollectionView visitId(Long visitId) {
        this.visitId = visitId;
        return this;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public String getPid() {
        return pid;
    }

    public ICTCSampleCollectionView pid(String pid) {
        this.pid = pid;
        return this;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public ICTCSampleCollectionView uid(String uid) {
        this.uid = uid;
        return this;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getSampleCollectionStatus() {
        return sampleCollectionStatus;
    }

    public ICTCSampleCollectionView sampleCollectionStatus(Integer sampleCollectionStatus) {
        this.sampleCollectionStatus = sampleCollectionStatus;
        return this;
    }

    public void setSampleCollectionStatus(Integer sampleCollectionStatus) {
        this.sampleCollectionStatus = sampleCollectionStatus;
    }

    public String getBarcode() {
        return barcode;
    }

    public ICTCSampleCollectionView barcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public LocalDateTime getSampleCollectionDate() {
        return sampleCollectionDate;
    }

    public ICTCSampleCollectionView sampleCollectionDate(LocalDateTime sampleCollectionDate) {
        this.sampleCollectionDate = sampleCollectionDate;
        return this;
    }

    public void setSampleCollectionDate(LocalDateTime sampleCollectionDate) {
        this.sampleCollectionDate = sampleCollectionDate;
    }
    
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}
	
	public Integer getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(Integer resultStatus) {
		this.resultStatus = resultStatus;
	}
	
	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}
	
	public Integer getInfantBreastFed() {
		return infantBreastFed;
	}

	public void setInfantBreastFed(Integer infantBreastFed) {
		this.infantBreastFed = infantBreastFed;
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getGenderId() {
		return genderId;
	}

	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ICTCSampleCollectionView iCTCSampleCollectionView = (ICTCSampleCollectionView) o;
        if (iCTCSampleCollectionView.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), iCTCSampleCollectionView.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "ICTCSampleCollectionView [id=" + id + ", infantCode=" + infantCode + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender
				+ ", visitDate=" + visitDate + ", testType=" + testType + ", ictcBeneficiaryId=" + ictcBeneficiaryId
				+ ", visitId=" + visitId + ", pid=" + pid + ", uid=" + uid + ", sampleCollectionStatus="
				+ sampleCollectionStatus + ", barcode=" + barcode + ", sampleCollectionDate=" + sampleCollectionDate
				+ ", dateOfBirth=" + dateOfBirth + ", category=" + category + ", batchId=" + batchId + ", resultStatus="
				+ resultStatus + ", facilityId=" + facilityId + ", infantBreastFed=" + infantBreastFed + ", categoryId="
				+ categoryId + ", genderId=" + genderId + "]";
	}

}
