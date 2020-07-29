package gov.naco.soch.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A ICTCBeneficiaryFollowUpView.
 */
@Entity
@Table(name = "ictc_beneficiary_follow_up_view")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ICTCBeneficiaryFollowUpView implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 25)
    @Column(name = "pid", length = 25)
    private String pid;

    @Size(max = 25)
    @Column(name = "uid", length = 25)
    private String uid;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "age")
    private String age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "category")
    private String category;

    @Column(name = "follow_up_date")
    private LocalDate followUpDate;

    @Column(name = "follow_up_type")
    private Integer followUpType;

    @Column(name = "expected_delivery_date")
    private LocalDate expectedDeliveryDate;

    @Column(name = "pregnancy_lmp_date")
    private LocalDate pregnancyLmpDate;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

//    @Column(name = "remarks")
//    private String remarks;

    @Column(name = "is_completed")
    private Boolean isCompleted;

    @Column(name = "beneficiary_status")
    private Integer beneficiaryStatus;

    @Column(name = "beneficiary_id")
    private Long beneficiaryId;

    @Column(name = "visit_id")
    private Long visitId;

    @Column(name = "test_result_id")
    private Long testResultId;

    @Column(name = "ictc_beneficiary_id")
    private Long ictcBeneficiaryId;

    @Column(name = "facility_id")
    private Long facilityId;
    
    @Column(name = "visit_date")
    private LocalDate visitDate; 
    
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    
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

    public String getPid() {
        return pid;
    }

    public ICTCBeneficiaryFollowUpView pid(String pid) {
        this.pid = pid;
        return this;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUid() {
        return uid;
    }

    public ICTCBeneficiaryFollowUpView uid(String uid) {
        this.uid = uid;
        return this;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public ICTCBeneficiaryFollowUpView firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ICTCBeneficiaryFollowUpView lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public ICTCBeneficiaryFollowUpView middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public ICTCBeneficiaryFollowUpView mobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAge() {
        return age;
    }

    public ICTCBeneficiaryFollowUpView age(String age) {
        this.age = age;
        return this;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public ICTCBeneficiaryFollowUpView gender(String gender) {
        this.gender = gender;
        return this;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCategory() {
        return category;
    }

    public ICTCBeneficiaryFollowUpView category(String category) {
        this.category = category;
        return this;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getFollowUpDate() {
        return followUpDate;
    }

    public ICTCBeneficiaryFollowUpView followUpDate(LocalDate followUpDate) {
        this.followUpDate = followUpDate;
        return this;
    }

    public void setFollowUpDate(LocalDate followUpDate) {
        this.followUpDate = followUpDate;
    }

    public Integer getFollowUpType() {
        return followUpType;
    }

    public ICTCBeneficiaryFollowUpView followUpType(Integer followUpType) {
        this.followUpType = followUpType;
        return this;
    }

    public void setFollowUpType(Integer followUpType) {
        this.followUpType = followUpType;
    }

    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public ICTCBeneficiaryFollowUpView expectedDeliveryDate(LocalDate expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
        return this;
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

    public ICTCBeneficiaryFollowUpView deliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

//    public String getRemarks() {
//        return remarks;
//    }
//
//    public ICTCBeneficiaryFollowUpView remarks(String remarks) {
//        this.remarks = remarks;
//        return this;
//    }
//
//    public void setRemarks(String remarks) {
//        this.remarks = remarks;
//    }

    public Boolean isIsCompleted() {
        return isCompleted;
    }

    public ICTCBeneficiaryFollowUpView isCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
        return this;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Integer getBeneficiaryStatus() {
        return beneficiaryStatus;
    }

    public ICTCBeneficiaryFollowUpView beneficiaryStatus(Integer beneficiaryStatus) {
        this.beneficiaryStatus = beneficiaryStatus;
        return this;
    }

    public void setBeneficiaryStatus(Integer beneficiaryStatus) {
        this.beneficiaryStatus = beneficiaryStatus;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public ICTCBeneficiaryFollowUpView beneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
        return this;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public Long getVisitId() {
        return visitId;
    }

    public ICTCBeneficiaryFollowUpView visitId(Long visitId) {
        this.visitId = visitId;
        return this;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    public Long getTestResultId() {
        return testResultId;
    }

    public ICTCBeneficiaryFollowUpView testResultId(Long testResultId) {
        this.testResultId = testResultId;
        return this;
    }

    public void setTestResultId(Long testResultId) {
        this.testResultId = testResultId;
    }

    public Long getIctcBeneficiaryId() {
        return ictcBeneficiaryId;
    }

    public ICTCBeneficiaryFollowUpView ictcBeneficiaryId(Long ictcBeneficiaryId) {
        this.ictcBeneficiaryId = ictcBeneficiaryId;
        return this;
    }

    public void setIctcBeneficiaryId(Long ictcBeneficiaryId) {
        this.ictcBeneficiaryId = ictcBeneficiaryId;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public ICTCBeneficiaryFollowUpView facilityId(Long facilityId) {
        this.facilityId = facilityId;
        return this;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }
    
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

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
        ICTCBeneficiaryFollowUpView iCTCBeneficiaryFollowUpView = (ICTCBeneficiaryFollowUpView) o;
        if (iCTCBeneficiaryFollowUpView.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), iCTCBeneficiaryFollowUpView.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "ICTCBeneficiaryFollowUpView [id=" + id + ", pid=" + pid + ", uid=" + uid + ", firstName=" + firstName
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