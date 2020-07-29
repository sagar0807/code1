package gov.naco.soch.dto;

import java.util.List;

public class ArtSampleCollectionDto extends BaseDto {

	/**
	 * default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	// properties
	private long id;
	private long beneficiaryId;
	private long facilityId;
	private List<TestDetails> testDetails;
	private Long testId;
	private String test;
	private String testType;
	private Long testTypeId;
	private String sampleCollectedDate;
	private String firstName;
	private String lastName;
	private String middleName;
	private String uidNumber;
	private String age;
	private String artNumber;
	private String preArtNumber;
	private String gender;
	private Long sampleId;
	private String patientStatus;
	private String patientArtStatus;
	private Long labTechId;
	private String labTechnicianName;
	private String barcode;
	private String resultStatus;
	private Long resultStatusId;
	private String sampleDispatchDate;
	private String sampleReceivedDate;
	private String resultReceivedDate;
	private String resultApprovedDate;
	private String hivStatus;
	private String resultValue;
	private String dateOfBirth;
	private String sampleStatus;
	private String resultDispatchDate;
	private String typeOfSpecimen;
	private String resultType;
	private String testMachineName;
	private String labInchargeName;
	private Long labInchargeId;
	private Long labFacilityTypeId;
	private String lastTestCount;
	private String lastTestDate;

	private String populationType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(long facilityId) {
		this.facilityId = facilityId;
	}

	public List<TestDetails> getTestDetails() {
		return testDetails;
	}

	public void setTestDetails(List<TestDetails> testDetails) {
		this.testDetails = testDetails;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public Long getTestTypeId() {
		return testTypeId;
	}

	public void setTestTypeId(Long testTypeId) {
		this.testTypeId = testTypeId;
	}

	public String getSampleCollectedDate() {
		return sampleCollectedDate;
	}

	public void setSampleCollectedDate(String sampleCollectedDate) {
		this.sampleCollectedDate = sampleCollectedDate;
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

	public String getUidNumber() {
		return uidNumber;
	}

	public void setUidNumber(String uidNumber) {
		this.uidNumber = uidNumber;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getArtNumber() {
		return artNumber;
	}

	public void setArtNumber(String artNumber) {
		this.artNumber = artNumber;
	}

	public String getPreArtNumber() {
		return preArtNumber;
	}

	public void setPreArtNumber(String preArtNumber) {
		this.preArtNumber = preArtNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getSampleId() {
		return sampleId;
	}

	public void setSampleId(Long sampleId) {
		this.sampleId = sampleId;
	}

	public String getPatientStatus() {
		return patientStatus;
	}

	public void setPatientStatus(String patientStatus) {
		this.patientStatus = patientStatus;
	}

	public String getPatientArtStatus() {
		return patientArtStatus;
	}

	public void setPatientArtStatus(String patientArtStatus) {
		this.patientArtStatus = patientArtStatus;
	}

	public Long getLabTechId() {
		return labTechId;
	}

	public void setLabTechId(Long labTechId) {
		this.labTechId = labTechId;
	}

	public String getLabTechnicianName() {
		return labTechnicianName;
	}

	public void setLabTechnicianName(String labTechnicianName) {
		this.labTechnicianName = labTechnicianName;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

	public Long getResultStatusId() {
		return resultStatusId;
	}

	public void setResultStatusId(Long resultStatusId) {
		this.resultStatusId = resultStatusId;
	}

	public String getSampleDispatchDate() {
		return sampleDispatchDate;
	}

	public void setSampleDispatchDate(String sampleDispatchDate) {
		this.sampleDispatchDate = sampleDispatchDate;
	}

	public String getSampleReceivedDate() {
		return sampleReceivedDate;
	}

	public void setSampleReceivedDate(String sampleReceivedDate) {
		this.sampleReceivedDate = sampleReceivedDate;
	}

	public String getResultReceivedDate() {
		return resultReceivedDate;
	}

	public void setResultReceivedDate(String resultReceivedDate) {
		this.resultReceivedDate = resultReceivedDate;
	}

	public String getResultApprovedDate() {
		return resultApprovedDate;
	}

	public void setResultApprovedDate(String resultApprovedDate) {
		this.resultApprovedDate = resultApprovedDate;
	}

	public String getHivStatus() {
		return hivStatus;
	}

	public void setHivStatus(String hivStatus) {
		this.hivStatus = hivStatus;
	}

	public String getResultValue() {
		return resultValue;
	}

	public void setResultValue(String resultValue) {
		this.resultValue = resultValue;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSampleStatus() {
		return sampleStatus;
	}

	public void setSampleStatus(String sampleStatus) {
		this.sampleStatus = sampleStatus;
	}

	public String getResultDispatchDate() {
		return resultDispatchDate;
	}

	public void setResultDispatchDate(String resultDispatchDate) {
		this.resultDispatchDate = resultDispatchDate;
	}

	public String getTypeOfSpecimen() {
		return typeOfSpecimen;
	}

	public void setTypeOfSpecimen(String typeOfSpecimen) {
		this.typeOfSpecimen = typeOfSpecimen;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public String getTestMachineName() {
		return testMachineName;
	}

	public void setTestMachineName(String testMachineName) {
		this.testMachineName = testMachineName;
	}

	public String getLabInchargeName() {
		return labInchargeName;
	}

	public void setLabInchargeName(String labInchargeName) {
		this.labInchargeName = labInchargeName;
	}

	public Long getLabInchargeId() {
		return labInchargeId;
	}

	public void setLabInchargeId(Long labInchargeId) {
		this.labInchargeId = labInchargeId;
	}

	public String getPopulationType() {
		return populationType;
	}

	public void setPopulationType(String populationType) {
		this.populationType = populationType;
	}

	public Long getLabFacilityTypeId() {
		return labFacilityTypeId;
	}

	public void setLabFacilityTypeId(Long labFacilityTypeId) {
		this.labFacilityTypeId = labFacilityTypeId;
	}

	public String getLastTestCount() {
		return lastTestCount;
	}

	public void setLastTestCount(String lastTestCount) {
		this.lastTestCount = lastTestCount;
	}

	public String getLastTestDate() {
		return lastTestDate;
	}

	public void setLastTestDate(String lastTestDate) {
		this.lastTestDate = lastTestDate;
	}

	@Override
	public String toString() {
		return "ArtSampleCollectionDto [id=" + id + ", beneficiaryId=" + beneficiaryId + ", facilityId=" + facilityId
				+ ", testDetails=" + testDetails + ", testType=" + testType + ", testTypeId=" + testTypeId
				+ ", sampleCollectedDate=" + sampleCollectedDate + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", middleName=" + middleName + ", uidNumber=" + uidNumber + ", age=" + age + ", artNumber="
				+ artNumber + ", preArtNumber=" + preArtNumber + ", gender=" + gender + ", sampleId=" + sampleId
				+ ", patientStatus=" + patientStatus + ", patientArtStatus=" + patientArtStatus + ", labTechId="
				+ labTechId + ", labTechnicianName=" + labTechnicianName + ", barcode=" + barcode + ", resultStatus="
				+ resultStatus + ", resultStatusId=" + resultStatusId + ", sampleDispatchDate=" + sampleDispatchDate
				+ ", sampleReceivedDate=" + sampleReceivedDate + ", resultReceivedDate=" + resultReceivedDate
				+ ", resultApprovedDate=" + resultApprovedDate + ", hivStatus=" + hivStatus + ", resultValue="
				+ resultValue + ", dateOfBirth=" + dateOfBirth + ", sampleStatus=" + sampleStatus
				+ ", resultDispatchDate=" + resultDispatchDate + ", typeOfSpecimen=" + typeOfSpecimen + ", resultType="
				+ resultType + ", testMachineName=" + testMachineName + ", labInchargeName=" + labInchargeName
				+ ", labInchargeId=" + labInchargeId + ", labFacilityTypeId=" + labFacilityTypeId + ", lastTestCount="
				+ lastTestCount + ", lastTestDate=" + lastTestDate + ", populationType=" + populationType + "]";
	}

}
