package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A ICTCBeneficiaryVisit.
 */
@Entity
@Table(name = "ictc_beneficiary_visit_result_view")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ICTCBeneficiaryVisit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pid")
    private String pid;
    
    @Column(name = "uid")
    private String uid;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "visit_date")
    private LocalDate visitDate;
    
    @Column(name = "beneficiary_id")
    private Long beneficiaryId;
    
    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "age")
    private String age;

    @Column(name = "category")
    private String category;
    
    @Column(name = "is_pregnant")
    private Boolean isPregnant;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "tested_date")
    private LocalDateTime testedDate;
    
    @Column(name = "report_received_date")
    private LocalDate reportReceivedDate;
    
    @Column(name = "report_delivery_date")
    private LocalDate reportDeliveryDate;
    
    @Column(name = "hiv_status")
    private Integer hivStatus;

    @Column(name = "hiv_type")
    private Integer hivType;
    
    @Column(name = "infant_breast_fed")
    private Integer infantBreastFed;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    
    @Column(name = "barcode")
    private String barcode;
    
    @Column(name = "result_status")
    private Integer resultStatus;
    
    @Column(name = "visit_id")
    private Long visitId;
    
    @Column(name = "infant_mother_art_no")
    private String infantMotherArtNo;

    @Column(name = "infant_mother_art_id")
    private Long infantMotherArtId;
    
    @Column(name = "infant_mother_first_name")
    private String infantMotherFirstName;
    
    @Column(name = "infant_mother_last_name")
    private String infantMotherLastName;
    
    @Column(name = "infant_code")
    private String infantCode;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "marital_status")
    private String maritalStatus;
    
    @Column(name = "test_type")
    private Integer testType;
    
    @Column(name = "is_consent_documented")
    private Boolean isConsentDocumented;
    
    @Column(name = "beneficiary_status")
    private Integer beneficiaryStatus;
    
    @Column(name = "current_test_result_id")
    private Long currentTestResultId;
    
//    @Column(name = "relationship_record_id")
//    private Long relationshipRecordId;

//    @Column(name = "relationship_type")
//    private Integer relationshipType;
    
//    @Column(name = "relationship_first_name")
//    private String relationshipFirstName;
//
//    @Column(name = "relationship_last_name")
//    private String relationshipLastName;
//    
//    @Column(name = "relationship_middle_name")
//    private String relationshipMiddleName;
    
//    @Column(name = "test_sequence")
//    private Integer testSequence;
    
    @Column(name = "ti_referral_id")
    private Long tiReferralId;
    
    @Column(name = "ti_referral_name")
    private String tiReferralName;
    
    @Column(name = "art_referral_id")
    private Long artReferralId;
    
    @Column(name = "art_referral_name")
    private String artReferralName;
    
    @Column(name = "dsrc_referral_id")
    private Long dsrcReferralId;
    
    @Column(name = "dsrc_referral_name")
    private String dsrcReferralName;
    
    @Column(name = "rntcp_referral_id")
    private Long rntcpReferralId;
    
    @Column(name = "rntcp_referral_name")
    private String rntcpReferralName;
    
    @Column(name = "batch_id")
    private Long batchId;
    
    @Column(name = "consignment_id")
    private String consignmentId;
    
    @Column(name = "lab_id")
    private Long labId;
    
    @Column(name = "lab_name")
    private String labName;
    
    @Column(name = "lab_code")
    private String labCode;
    
    @Column(name = "sample_collection_date")
    private LocalDateTime sampleCollectionDate;
    
    @Column(name = "facility_id")
    private Long facilityId;
    
    @Column(name = "category_id")
    private Integer categoryId;
    
    @Column(name = "gender_id")
    private Integer genderId;
    
    @Column(name = "ictc_ben_is_active")
    private Boolean isActive;
    
    @Column(name = "ictc_ben_is_deleted")
    private Boolean isDeleted;
    
    @Column(name = "ictc_ben_deleted_reason")
    private Integer deletedReason;
    
    @Column(name = "ictc_ben_deleted_reason_comment")
    private String deletedReasonComment;
    
    @Column(name = "registered_facility_id")
    private Long registeredFacilityId;
    
    @Column(name = "infant_mother_beneficiary_id")
    private Long infantMotherBeneficiaryId;

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

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Boolean getIsPregnant() {
		return isPregnant;
	}

	public void setIsPregnant(Boolean isPregnant) {
		this.isPregnant = isPregnant;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDateTime getTestedDate() {
		return testedDate;
	}

	public void setTestedDate(LocalDateTime testedDate) {
		this.testedDate = testedDate;
	}

	public LocalDate getReportReceivedDate() {
		return reportReceivedDate;
	}

	public void setReportReceivedDate(LocalDate reportReceivedDate) {
		this.reportReceivedDate = reportReceivedDate;
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

	public Integer getInfantBreastFed() {
		return infantBreastFed;
	}

	public void setInfantBreastFed(Integer infantBreastFed) {
		this.infantBreastFed = infantBreastFed;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Integer getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(Integer resultStatus) {
		this.resultStatus = resultStatus;
	}

	public Long getVisitId() {
		return visitId;
	}

	public void setVisitId(Long visitId) {
		this.visitId = visitId;
	}

	public String getInfantMotherArtNo() {
		return infantMotherArtNo;
	}

	public void setInfantMotherArtNo(String infantMotherArtNo) {
		this.infantMotherArtNo = infantMotherArtNo;
	}

	public Long getInfantMotherArtId() {
		return infantMotherArtId;
	}

	public void setInfantMotherArtId(Long infantMotherArtId) {
		this.infantMotherArtId = infantMotherArtId;
	}

	public String getInfantCode() {
		return infantCode;
	}

	public void setInfantCode(String infantCode) {
		this.infantCode = infantCode;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Integer getTestType() {
		return testType;
	}

	public void setTestType(Integer testType) {
		this.testType = testType;
	}
	

	public LocalDate getReportDeliveryDate() {
		return reportDeliveryDate;
	}

	public void setReportDeliveryDate(LocalDate reportDeliveryDate) {
		this.reportDeliveryDate = reportDeliveryDate;
	}
	
	public String getInfantMotherFirstName() {
		return infantMotherFirstName;
	}

	public void setInfantMotherFirstName(String infantMotherFirstName) {
		this.infantMotherFirstName = infantMotherFirstName;
	}

	public String getInfantMotherLastName() {
		return infantMotherLastName;
	}

	public void setInfantMotherLastName(String infantMotherLastName) {
		this.infantMotherLastName = infantMotherLastName;
	}
	
	public Boolean getIsConsentDocumented() {
		return isConsentDocumented;
	}

	public void setIsConsentDocumented(Boolean isConsentDocumented) {
		this.isConsentDocumented = isConsentDocumented;
	}
	
	public Integer getBeneficiaryStatus() {
		return beneficiaryStatus;
	}

	public void setBeneficiaryStatus(Integer beneficiaryStatus) {
		this.beneficiaryStatus = beneficiaryStatus;
	}
	
	public Long getCurrentTestResultId() {
		return currentTestResultId;
	}

	public void setCurrentTestResultId(Long currentTestResultId) {
		this.currentTestResultId = currentTestResultId;
	}
	
	public Long getTiReferralId() {
		return tiReferralId;
	}

	public void setTiReferralId(Long tiReferralId) {
		this.tiReferralId = tiReferralId;
	}

	public String getTiReferralName() {
		return tiReferralName;
	}

	public void setTiReferralName(String tiReferralName) {
		this.tiReferralName = tiReferralName;
	}

	public Long getArtReferralId() {
		return artReferralId;
	}

	public void setArtReferralId(Long artReferralId) {
		this.artReferralId = artReferralId;
	}

	public String getArtReferralName() {
		return artReferralName;
	}

	public void setArtReferralName(String artReferralName) {
		this.artReferralName = artReferralName;
	}

	public Long getDsrcReferralId() {
		return dsrcReferralId;
	}

	public void setDsrcReferralId(Long dsrcReferralId) {
		this.dsrcReferralId = dsrcReferralId;
	}

	public String getDsrcReferralName() {
		return dsrcReferralName;
	}

	public void setDsrcReferralName(String dsrcReferralName) {
		this.dsrcReferralName = dsrcReferralName;
	}

	public Long getRntcpReferralId() {
		return rntcpReferralId;
	}

	public void setRntcpReferralId(Long rntcpReferralId) {
		this.rntcpReferralId = rntcpReferralId;
	}

	public String getRntcpReferralName() {
		return rntcpReferralName;
	}

	public void setRntcpReferralName(String rntcpReferralName) {
		this.rntcpReferralName = rntcpReferralName;
	}
	
	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public String getConsignmentId() {
		return consignmentId;
	}

	public void setConsignmentId(String consignmentId) {
		this.consignmentId = consignmentId;
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
	
	public LocalDateTime getSampleCollectionDate() {
		return sampleCollectionDate;
	}

	public void setSampleCollectionDate(LocalDateTime sampleCollectionDate) {
		this.sampleCollectionDate = sampleCollectionDate;
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
	
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getDeletedReason() {
		return deletedReason;
	}

	public void setDeletedReason(Integer deletedReason) {
		this.deletedReason = deletedReason;
	}

	public String getDeletedReasonComment() {
		return deletedReasonComment;
	}

	public void setDeletedReasonComment(String deletedReasonComment) {
		this.deletedReasonComment = deletedReasonComment;
	}
	
	public Long getRegisteredFacilityId() {
		return registeredFacilityId;
	}

	public void setRegisteredFacilityId(Long registeredFacilityId) {
		this.registeredFacilityId = registeredFacilityId;
	}

	public Long getInfantMotherBeneficiaryId() {
		return infantMotherBeneficiaryId;
	}

	public void setInfantMotherBeneficiaryId(Long infantMotherBeneficiaryId) {
		this.infantMotherBeneficiaryId = infantMotherBeneficiaryId;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ICTCBeneficiaryVisit)) {
            return false;
        }
        return id != null && id.equals(((ICTCBeneficiaryVisit) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

	@Override
	public String toString() {
		return "ICTCBeneficiaryVisit [id=" + id + ", pid=" + pid + ", uid=" + uid + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", visitDate=" + visitDate
				+ ", beneficiaryId=" + beneficiaryId + ", mobileNumber=" + mobileNumber + ", age=" + age + ", category="
				+ category + ", isPregnant=" + isPregnant + ", gender=" + gender + ", testedDate=" + testedDate
				+ ", reportReceivedDate=" + reportReceivedDate + ", reportDeliveryDate=" + reportDeliveryDate
				+ ", hivStatus=" + hivStatus + ", hivType=" + hivType + ", infantBreastFed=" + infantBreastFed
				+ ", dateOfBirth=" + dateOfBirth + ", barcode=" + barcode + ", resultStatus=" + resultStatus
				+ ", visitId=" + visitId + ", infantMotherArtNo=" + infantMotherArtNo + ", infantMotherArtId="
				+ infantMotherArtId + ", infantMotherFirstName=" + infantMotherFirstName + ", infantMotherLastName="
				+ infantMotherLastName + ", infantCode=" + infantCode + ", occupation=" + occupation
				+ ", maritalStatus=" + maritalStatus + ", testType=" + testType + ", isConsentDocumented="
				+ isConsentDocumented + ", beneficiaryStatus=" + beneficiaryStatus + ", currentTestResultId="
				+ currentTestResultId + ", tiReferralId=" + tiReferralId + ", tiReferralName=" + tiReferralName
				+ ", artReferralId=" + artReferralId + ", artReferralName=" + artReferralName + ", dsrcReferralId="
				+ dsrcReferralId + ", dsrcReferralName=" + dsrcReferralName + ", rntcpReferralId=" + rntcpReferralId
				+ ", rntcpReferralName=" + rntcpReferralName + ", batchId=" + batchId + ", consignmentId="
				+ consignmentId + ", labId=" + labId + ", labName=" + labName + ", labCode=" + labCode
				+ ", sampleCollectionDate=" + sampleCollectionDate + ", facilityId=" + facilityId + ", categoryId="
				+ categoryId + ", genderId=" + genderId + ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", deletedReason=" + deletedReason + ", deletedReasonComment=" + deletedReasonComment + "]";
	}

}
