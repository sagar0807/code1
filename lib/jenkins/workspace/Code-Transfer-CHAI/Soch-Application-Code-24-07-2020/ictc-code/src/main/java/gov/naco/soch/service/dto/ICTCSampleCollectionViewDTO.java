package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A DTO for the ICTCSampleCollectionView entity.
 */
public class ICTCSampleCollectionViewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private Long id;

    private String infantCode;

    private String firstName;

    private String middleName;

    private String lastName;

    private String age;

    private String gender;

    private LocalDate visitDate;

    private Integer testType;

    private Long ictcBeneficiaryId;

    private Long visitId;

    private String pid;

    private String uid;

    private Integer sampleCollectionStatus;

    private String barcode;

    private LocalDateTime sampleCollectionDate;
    
    private LocalDate dateOfBirth;
    
    private String category;
    
    private Long batchId;
    
    private Integer resultStatus;
    
    private Long facilityId;
    
    private Integer infantBreastFed;
    
    private Integer categoryId;

	private Integer genderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfantCode() {
        return infantCode;
    }

    public void setInfantCode(String infantCode) {
        this.infantCode = infantCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public Integer getTestType() {
        return testType;
    }

    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    public Long getIctcBeneficiaryId() {
        return ictcBeneficiaryId;
    }

    public void setIctcBeneficiaryId(Long ictcBeneficiaryId) {
        this.ictcBeneficiaryId = ictcBeneficiaryId;
    }

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getSampleCollectionStatus() {
        return sampleCollectionStatus;
    }

    public void setSampleCollectionStatus(Integer sampleCollectionStatus) {
        this.sampleCollectionStatus = sampleCollectionStatus;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public LocalDateTime getSampleCollectionDate() {
        return sampleCollectionDate;
    }

    public void setSampleCollectionDate(LocalDateTime sampleCollectionDate) {
        this.sampleCollectionDate = sampleCollectionDate;
    }
    
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

        ICTCSampleCollectionViewDTO iCTCSampleCollectionViewDTO = (ICTCSampleCollectionViewDTO) o;
        if (iCTCSampleCollectionViewDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), iCTCSampleCollectionViewDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "ICTCSampleCollectionViewDTO [id=" + id + ", infantCode=" + infantCode + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender
				+ ", visitDate=" + visitDate + ", testType=" + testType + ", ictcBeneficiaryId=" + ictcBeneficiaryId
				+ ", visitId=" + visitId + ", pid=" + pid + ", uid=" + uid + ", sampleCollectionStatus="
				+ sampleCollectionStatus + ", barcode=" + barcode + ", sampleCollectionDate=" + sampleCollectionDate
				+ ", dateOfBirth=" + dateOfBirth + ", category=" + category + ", batchId=" + batchId + ", resultStatus="
				+ resultStatus + ", facilityId=" + facilityId + ", infantBreastFed=" + infantBreastFed + ", categoryId="
				+ categoryId + ", genderId=" + genderId + "]";
	}
    
}
