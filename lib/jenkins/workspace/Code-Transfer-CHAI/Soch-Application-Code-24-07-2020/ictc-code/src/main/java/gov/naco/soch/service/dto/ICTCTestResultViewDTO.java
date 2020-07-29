package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A DTO for the ICTCTestResultView entity.
 */
public class ICTCTestResultViewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private Long id;

    private String uid;

    private String firstName;

    private String middleName;

    private String lastName;

    private String age;

    private String gender;

    private LocalDateTime sampleCollectionDate;

    private Integer testType;

    private Integer resultStatus;

    private Integer hivStatus;

    private Integer hivType;

    private LocalDateTime testedDate;

    private Long sampleId;
    
    private Long batchId;

    private String consignmentId;

    private Long beneficiaryId;

    private Long ictcBeneficiaryId;

    private Long visitId;

    private LocalDate dateOfBirth;

    private Integer sampleCollectionStatus;

    private Integer batchStatus;
    
    private String category;
    
    private LocalDate referDate;
    
    private LocalDate followUpDate;
    
    private String artCenterName;
    
    private String artCenterCode;
    
    private LocalDate reportReceivedDate;
    
    private LocalDate reportDeliveryDate;
    
    private Long labId;
    
    private String labName;
    
    private String labCode;
    
    private Long facilityId;
    
    private Integer categoryId;

	private Integer genderId;
	
	private String barcode;
	
	private String infantCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public LocalDateTime getSampleCollectionDate() {
        return sampleCollectionDate;
    }

    public void setSampleCollectionDate(LocalDateTime sampleCollectionDate) {
        this.sampleCollectionDate = sampleCollectionDate;
    }

    public Integer getTestType() {
        return testType;
    }

    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    public Integer getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(Integer resultStatus) {
        this.resultStatus = resultStatus;
    }

    public Integer getHivStatus() {
        return hivStatus;
    }

    public void setHivStatus(Integer hivStatus) {
        this.hivStatus = hivStatus;
    }

    public Integer getHivType() {
        return hivType;
    }

    public void setHivType(Integer hivType) {
        this.hivType = hivType;
    }

    public LocalDateTime getTestedDate() {
        return testedDate;
    }

    public void setTestedDate(LocalDateTime testedDate) {
        this.testedDate = testedDate;
    }

    public Long getSampleId() {
        return sampleId;
    }

    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
    }

    public String getConsignmentId() {
        return consignmentId;
    }

    public void setConsignmentId(String consignmentId) {
        this.consignmentId = consignmentId;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getSampleCollectionStatus() {
        return sampleCollectionStatus;
    }

    public void setSampleCollectionStatus(Integer sampleCollectionStatus) {
        this.sampleCollectionStatus = sampleCollectionStatus;
    }

    public Integer getBatchStatus() {
        return batchStatus;
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

        ICTCTestResultViewDTO iCTCTestResultViewDTO = (ICTCTestResultViewDTO) o;
        if (iCTCTestResultViewDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), iCTCTestResultViewDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "ICTCTestResultViewDTO [id=" + id + ", uid=" + uid + ", firstName=" + firstName + ", middleName="
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
