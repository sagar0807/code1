package gov.naco.soch.shared.dto.ictc;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.ICTCBeneficiaryVisit} entity.
 */
public class ICTCBeneficiaryVisitDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String pid;

	private String uid;

	private String firstName;

	private String middleName;

	private String lastName;

	private LocalDate visitDate;

	private Long beneficiaryId;

	private String mobileNumber;

	private String age;

	private String category;

	private Boolean isPregnant;

	private String gender;

	private LocalDate testedDate;

	private LocalDate reportReceivedDate;

	private LocalDate reportDeliveryDate;

	private Integer hivStatus;

	private Integer hivType;

	private Integer infantBreastFed;

	private LocalDate dateOfBirth;

	private String barcode;

	private Integer resultStatus;

	private Long visitId;

	private String infantMotherArtNo;

	private Long infantMotherArtId;

	private String infantMotherLastName;

	private String infantMotherFirstName;

	private String infantCode;

	private String occupation;

	private String maritalStatus;

	private Integer testType;

	private Boolean isConsentDocumented;

	private Integer beneficiaryStatus;

	private Long currentTestResultId;

	private Long relationshipRecordId;

	private Integer relationshipType;

	private String relationshipFirstName;

	private String relationshipLastName;

	private String relationshipMiddleName;

	private Integer testSequence;

	private Long tiReferralId;

	private String tiReferralName;

	private Long artReferralId;

	private String artReferralName;

	private Long dsrcReferralId;

	private String dsrcReferralName;

	private Long rntcpReferralId;

	private String rntcpReferralName;

	private Long batchId;

	private String consignmentId;

	private Long labId;

	private String labName;

	private String labCode;
	
	private LocalDate sampleCollectionDate;
	
	private Long facilityId;

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

	public LocalDate getTestedDate() {
		return testedDate;
	}

	public void setTestedDate(LocalDate testedDate) {
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

	public String getInfantMotherLastName() {
		return infantMotherLastName;
	}

	public void setInfantMotherLastName(String infantMotherLastName) {
		this.infantMotherLastName = infantMotherLastName;
	}

	public String getInfantMotherFirstName() {
		return infantMotherFirstName;
	}

	public void setInfantMotherFirstName(String infantMotherFirstName) {
		this.infantMotherFirstName = infantMotherFirstName;
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

	public String getRelationshipFirstName() {
		return relationshipFirstName;
	}

	public void setRelationshipFirstName(String relationshipFirstName) {
		this.relationshipFirstName = relationshipFirstName;
	}

	public String getRelationshipLastName() {
		return relationshipLastName;
	}

	public void setRelationshipLastName(String relationshipLastName) {
		this.relationshipLastName = relationshipLastName;
	}

	public String getRelationshipMiddleName() {
		return relationshipMiddleName;
	}

	public void setRelationshipMiddleName(String relationshipMiddleName) {
		this.relationshipMiddleName = relationshipMiddleName;
	}

	public Long getRelationshipRecordId() {
		return relationshipRecordId;
	}

	public void setRelationshipRecordId(Long relationshipRecordId) {
		this.relationshipRecordId = relationshipRecordId;
	}

	public Integer getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(Integer relationshipType) {
		this.relationshipType = relationshipType;
	}

	public Integer getTestSequence() {
		return testSequence;
	}

	public void setTestSequence(Integer testSequence) {
		this.testSequence = testSequence;
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
	
	public LocalDate getSampleCollectionDate() {
		return sampleCollectionDate;
	}

	public void setSampleCollectionDate(LocalDate sampleCollectionDate) {
		this.sampleCollectionDate = sampleCollectionDate;
	}
	
	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		ICTCBeneficiaryVisitDTO iCTCBeneficiaryVisitDTO = (ICTCBeneficiaryVisitDTO) o;
		if (iCTCBeneficiaryVisitDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), iCTCBeneficiaryVisitDTO.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "ICTCBeneficiaryVisitDTO [id=" + id + ", pid=" + pid + ", uid=" + uid + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", visitDate=" + visitDate
				+ ", beneficiaryId=" + beneficiaryId + ", mobileNumber=" + mobileNumber + ", age=" + age + ", category="
				+ category + ", isPregnant=" + isPregnant + ", gender=" + gender + ", testedDate=" + testedDate
				+ ", reportReceivedDate=" + reportReceivedDate + ", reportDeliveryDate=" + reportDeliveryDate
				+ ", hivStatus=" + hivStatus + ", hivType=" + hivType + ", infantBreastFed=" + infantBreastFed
				+ ", dateOfBirth=" + dateOfBirth + ", barcode=" + barcode + ", resultStatus=" + resultStatus
				+ ", visitId=" + visitId + ", infantMotherArtNo=" + infantMotherArtNo + ", infantMotherArtId="
				+ infantMotherArtId + ", infantMotherLastName=" + infantMotherLastName + ", infantMotherFirstName="
				+ infantMotherFirstName + ", infantCode=" + infantCode + ", occupation=" + occupation
				+ ", maritalStatus=" + maritalStatus + ", testType=" + testType + ", isConsentDocumented="
				+ isConsentDocumented + ", beneficiaryStatus=" + beneficiaryStatus + ", currentTestResultId="
				+ currentTestResultId + ", relationshipRecordId=" + relationshipRecordId + ", relationshipType="
				+ relationshipType + ", relationshipFirstName=" + relationshipFirstName + ", relationshipLastName="
				+ relationshipLastName + ", relationshipMiddleName=" + relationshipMiddleName + ", testSequence="
				+ testSequence + ", tiReferralId=" + tiReferralId + ", tiReferralName=" + tiReferralName
				+ ", artReferralId=" + artReferralId + ", artReferralName=" + artReferralName + ", dsrcReferralId="
				+ dsrcReferralId + ", dsrcReferralName=" + dsrcReferralName + ", rntcpReferralId=" + rntcpReferralId
				+ ", rntcpReferralName=" + rntcpReferralName + ", batchId=" + batchId + ", consignmentId="
				+ consignmentId + ", labId=" + labId + ", labName=" + labName + ", labCode=" + labCode
				+ ", sampleCollectionDate=" + sampleCollectionDate + "]";
	}

}
