package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the ICTCBeneficiaryFollowUpView entity.
 */
public class ICTCBeneficiaryFollowUpViewDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private Long id;

    private String pid;

    private String uid;

    private String firstName;

    private String lastName;

    private String middleName;

    private String mobileNumber;

    private String age;

    private String gender;

    private String category;

    private LocalDate followUpDate;

    private Integer followUpType;

    private LocalDate expectedDeliveryDate;

    private LocalDate pregnancyLmpDate;

    private LocalDate deliveryDate;

//    private String remarks;

    private Boolean isCompleted;

    private Integer beneficiaryStatus;

    private Long beneficiaryId;

    private Long visitId;

    private Long testResultId;

    private Long ictcBeneficiaryId;

    private Long facilityId;
    
    private LocalDate visitDate; 
    
    private LocalDate dateOfBirth;
    
    private Integer categoryId;

	private Integer genderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(LocalDate followUpDate) {
        this.followUpDate = followUpDate;
    }

    public Integer getFollowUpType() {
        return followUpType;
    }

    public void setFollowUpType(Integer followUpType) {
        this.followUpType = followUpType;
    }

    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public LocalDate getPregnancyLmpDate() {
		return pregnancyLmpDate;
	}

	public void setPregnancyLmpDate(LocalDate pregnancyLmpDate) {
		this.pregnancyLmpDate = pregnancyLmpDate;
	}

	public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

//    public String getRemarks() {
//        return remarks;
//    }
//
//    public void setRemarks(String remarks) {
//        this.remarks = remarks;
//    }

    public Boolean isIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Integer getBeneficiaryStatus() {
        return beneficiaryStatus;
    }

    public void setBeneficiaryStatus(Integer beneficiaryStatus) {
        this.beneficiaryStatus = beneficiaryStatus;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public Long getTestResultId() {
        return testResultId;
    }

    public void setTestResultId(Long testResultId) {
        this.testResultId = testResultId;
    }

    public Long getIctcBeneficiaryId() {
        return ictcBeneficiaryId;
    }

    public void setIctcBeneficiaryId(Long ictcBeneficiaryId) {
        this.ictcBeneficiaryId = ictcBeneficiaryId;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }
    

    public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
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

        ICTCBeneficiaryFollowUpViewDTO iCTCBeneficiaryFollowUpViewDTO = (ICTCBeneficiaryFollowUpViewDTO) o;
        if (iCTCBeneficiaryFollowUpViewDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), iCTCBeneficiaryFollowUpViewDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "ICTCBeneficiaryFollowUpViewDTO [id=" + id + ", pid=" + pid + ", uid=" + uid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", middleName=" + middleName + ", mobileNumber=" + mobileNumber + ", age="
				+ age + ", gender=" + gender + ", category=" + category + ", followUpDate=" + followUpDate
				+ ", followUpType=" + followUpType + ", expectedDeliveryDate=" + expectedDeliveryDate
				+ ", pregnancyLmpDate=" + pregnancyLmpDate + ", deliveryDate=" + deliveryDate + ", isCompleted="
				+ isCompleted + ", beneficiaryStatus=" + beneficiaryStatus + ", beneficiaryId=" + beneficiaryId
				+ ", visitId=" + visitId + ", testResultId=" + testResultId + ", ictcBeneficiaryId=" + ictcBeneficiaryId
				+ ", facilityId=" + facilityId + ", visitDate=" + visitDate + ", dateOfBirth=" + dateOfBirth
				+ ", categoryId=" + categoryId + ", genderId=" + genderId + "]";
	}

}
