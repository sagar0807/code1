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
 * A ICTCTestResultView.
 */
@Entity
@Table(name = "ictc_test_result_view")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ICTCTestResultView implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uid")
    private String uid;

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

    @Column(name = "sample_collection_date")
    private LocalDateTime sampleCollectionDate;

    @Column(name = "test_type")
    private Integer testType;

    @Column(name = "result_status")
    private Integer resultStatus;

    @Column(name = "hiv_status")
    private Integer hivStatus;

    @Column(name = "hiv_type")
    private Integer hivType;

    @Column(name = "tested_date")
    private LocalDateTime testedDate;

    @Column(name = "sample_id")
    private Long sampleId;
    
    @Column(name = "batch_id")
    private Long batchId;

    @Column(name = "consignment_id")
    private String consignmentId;

    @Column(name = "beneficiary_id")
    private Long beneficiaryId;

    @Column(name = "ictc_beneficiary_id")
    private Long ictcBeneficiaryId;

    @Column(name = "visit_id")
    private Long visitId;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "sample_collection_status")
    private Integer sampleCollectionStatus;

    @Column(name = "batch_status")
    private Integer batchStatus;
    
    @Column(name = "category")
    private String category;
    
    @Column(name = "refer_date")
    private LocalDate referDate;
    
    @Column(name = "follow_up_date")
    private LocalDate followUpDate;
    
    @Column(name = "art_center_name")
    private String artCenterName;
    
    @Column(name = "art_center_code")
    private String artCenterCode;
    
    @Column(name = "report_received_date")
    private LocalDate reportReceivedDate;
    
    @Column(name = "report_delivery_date")
    private LocalDate reportDeliveryDate;
    
    @Column(name = "lab_id")
    private Long labId;
    
    @Column(name = "lab_name")
    private String labName;
    
    @Column(name = "lab_code")
    private String labCode;
    
    @Column(name = "facility_id")
    private Long facilityId;
    
    @Column(name = "category_id")
    private Integer categoryId;
    
    @Column(name = "gender_id")
    private Integer genderId;
    
    @Column(name = "barcode")
    private String barcode;
    
    @Column(name = "infant_code")
    private String infantCode;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public ICTCTestResultView uid(String uid) {
        this.uid = uid;
        return this;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public ICTCTestResultView firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public ICTCTestResultView middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public ICTCTestResultView lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public ICTCTestResultView age(String age) {
        this.age = age;
        return this;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public ICTCTestResultView gender(String gender) {
        this.gender = gender;
        return this;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getSampleCollectionDate() {
        return sampleCollectionDate;
    }

    public ICTCTestResultView sampleCollectionDate(LocalDateTime sampleCollectionDate) {
        this.sampleCollectionDate = sampleCollectionDate;
        return this;
    }

    public void setSampleCollectionDate(LocalDateTime sampleCollectionDate) {
        this.sampleCollectionDate = sampleCollectionDate;
    }

    public Integer getTestType() {
        return testType;
    }

    public ICTCTestResultView testType(Integer testType) {
        this.testType = testType;
        return this;
    }

    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    public Integer getResultStatus() {
        return resultStatus;
    }

    public ICTCTestResultView resultStatus(Integer resultStatus) {
        this.resultStatus = resultStatus;
        return this;
    }

    public void setResultStatus(Integer resultStatus) {
        this.resultStatus = resultStatus;
    }

    public Integer getHivStatus() {
        return hivStatus;
    }

    public ICTCTestResultView hivStatus(Integer hivStatus) {
        this.hivStatus = hivStatus;
        return this;
    }

    public void setHivStatus(Integer hivStatus) {
        this.hivStatus = hivStatus;
    }

    public Integer getHivType() {
        return hivType;
    }

    public ICTCTestResultView hivType(Integer hivType) {
        this.hivType = hivType;
        return this;
    }

    public void setHivType(Integer hivType) {
        this.hivType = hivType;
    }

    public LocalDateTime getTestedDate() {
        return testedDate;
    }

    public ICTCTestResultView testedDate(LocalDateTime testedDate) {
        this.testedDate = testedDate;
        return this;
    }

    public void setTestedDate(LocalDateTime testedDate) {
        this.testedDate = testedDate;
    }

    public Long getSampleId() {
        return sampleId;
    }

    public ICTCTestResultView sampleId(Long sampleId) {
        this.sampleId = sampleId;
        return this;
    }

    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
    }

    public String getConsignmentId() {
        return consignmentId;
    }

    public ICTCTestResultView consignmentId(String consignmentId) {
        this.consignmentId = consignmentId;
        return this;
    }

    public void setConsignmentId(String consignmentId) {
        this.consignmentId = consignmentId;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public ICTCTestResultView beneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
        return this;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public Long getIctcBeneficiaryId() {
        return ictcBeneficiaryId;
    }

    public ICTCTestResultView ictcBeneficiaryId(Long ictcBeneficiaryId) {
        this.ictcBeneficiaryId = ictcBeneficiaryId;
        return this;
    }

    public void setIctcBeneficiaryId(Long ictcBeneficiaryId) {
        this.ictcBeneficiaryId = ictcBeneficiaryId;
    }

    public Long getVisitId() {
        return visitId;
    }

    public ICTCTestResultView visitId(Long visitId) {
        this.visitId = visitId;
        return this;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public ICTCTestResultView dateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getSampleCollectionStatus() {
        return sampleCollectionStatus;
    }

    public ICTCTestResultView sampleCollectionStatus(Integer sampleCollectionStatus) {
        this.sampleCollectionStatus = sampleCollectionStatus;
        return this;
    }

    public void setSampleCollectionStatus(Integer sampleCollectionStatus) {
        this.sampleCollectionStatus = sampleCollectionStatus;
    }

    public Integer getBatchStatus() {
        return batchStatus;
    }

    public ICTCTestResultView batchStatus(Integer batchStatus) {
        this.batchStatus = batchStatus;
        return this;
    }

    public void setBatchStatus(Integer batchStatus) {
        this.batchStatus = batchStatus;
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

	public LocalDate getReferDate() {
		return referDate;
	}

	public void setReferDate(LocalDate referDate) {
		this.referDate = referDate;
	}

	public LocalDate getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(LocalDate followUpDate) {
		this.followUpDate = followUpDate;
	}

	public String getArtCenterName() {
		return artCenterName;
	}

	public void setArtCenterName(String artCenterName) {
		this.artCenterName = artCenterName;
	}

	public String getArtCenterCode() {
		return artCenterCode;
	}

	public void setArtCenterCode(String artCenterCode) {
		this.artCenterCode = artCenterCode;
	}
	
	public LocalDate getReportReceivedDate() {
		return reportReceivedDate;
	}

	public void setReportReceivedDate(LocalDate reportReceivedDate) {
		this.reportReceivedDate = reportReceivedDate;
	}

	public LocalDate getReportDeliveryDate() {
		return reportDeliveryDate;
	}

	public void setReportDeliveryDate(LocalDate reportDeliveryDate) {
		this.reportDeliveryDate = reportDeliveryDate;
	}

	public Long getLabId() {
		return labId;
	}

	public void setLabId(Long labId) {
		this.labId = labId;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public String getLabCode() {
		return labCode;
	}

	public void setLabCode(String labCode) {
		this.labCode = labCode;
	}
	
	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
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
	
	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	public String getInfantCode() {
		return infantCode;
	}

	public void setInfantCode(String infantCode) {
		this.infantCode = infantCode;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ICTCTestResultView iCTCTestResultView = (ICTCTestResultView) o;
        if (iCTCTestResultView.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), iCTCTestResultView.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "ICTCTestResultView [id=" + id + ", uid=" + uid + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender
				+ ", sampleCollectionDate=" + sampleCollectionDate + ", testType=" + testType + ", resultStatus="
				+ resultStatus + ", hivStatus=" + hivStatus + ", hivType=" + hivType + ", testedDate=" + testedDate
				+ ", sampleId=" + sampleId + ", batchId=" + batchId + ", consignmentId=" + consignmentId
				+ ", beneficiaryId=" + beneficiaryId + ", ictcBeneficiaryId=" + ictcBeneficiaryId + ", visitId="
				+ visitId + ", dateOfBirth=" + dateOfBirth + ", sampleCollectionStatus=" + sampleCollectionStatus
				+ ", batchStatus=" + batchStatus + ", category=" + category + ", referDate=" + referDate
				+ ", followUpDate=" + followUpDate + ", artCenterName=" + artCenterName + ", artCenterCode="
				+ artCenterCode + ", reportReceivedDate=" + reportReceivedDate + ", reportDeliveryDate="
				+ reportDeliveryDate + ", labId=" + labId + ", labName=" + labName + ", labCode=" + labCode
				+ ", facilityId=" + facilityId + ", categoryId=" + categoryId + ", genderId=" + genderId + ", barcode="
				+ barcode + ", infantCode=" + infantCode + "]";
	}

}
