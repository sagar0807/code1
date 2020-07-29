package gov.naco.soch.dto;

import java.time.LocalDate;

public class ArtCd4RecordResultDto extends BaseDto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private Long sampleId;
	private Long beneficiaryId;
	private String firstName;
	private String lastName;
	private String uidNumber;
	private String age;
	private String gender;
	private String preArtNumber;
	private String artNumber;
	private String artStatus;

	private String currentTestCount;
	private String samplecollectedDate;
	private LocalDate testDate;

	private String sampleType;

	private Long facilityId;
	private String facilityName;

	private LocalDate nextAppointmentDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSampleId() {
		return sampleId;
	}

	public void setSampleId(Long sampleId) {
		this.sampleId = sampleId;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPreArtNumber() {
		return preArtNumber;
	}

	public void setPreArtNumber(String preArtNumber) {
		this.preArtNumber = preArtNumber;
	}

	public String getArtNumber() {
		return artNumber;
	}

	public void setArtNumber(String artNumber) {
		this.artNumber = artNumber;
	}

	public String getArtStatus() {
		return artStatus;
	}

	public void setArtStatus(String artStatus) {
		this.artStatus = artStatus;
	}

	public String getCurrentTestCount() {
		return currentTestCount;
	}

	public void setCurrentTestCount(String currentTestCount) {
		this.currentTestCount = currentTestCount;
	}

	public String getSamplecollectedDate() {
		return samplecollectedDate;
	}

	public void setSamplecollectedDate(String samplecollectedDate) {
		this.samplecollectedDate = samplecollectedDate;
	}

	public LocalDate getTestDate() {
		return testDate;
	}

	public void setTestDate(LocalDate testDate) {
		this.testDate = testDate;
	}

	public String getSampleType() {
		return sampleType;
	}

	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LocalDate getNextAppointmentDate() {
		return nextAppointmentDate;
	}

	public void setNextAppointmentDate(LocalDate nextAppointmentDate) {
		this.nextAppointmentDate = nextAppointmentDate;
	}

	@Override
	public String toString() {
		return "ArtCd4RecordResultDto [id=" + id + ", sampleId=" + sampleId + ", beneficiaryId=" + beneficiaryId
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", uidNumber=" + uidNumber + ", age=" + age
				+ ", gender=" + gender + ", preArtNumber=" + preArtNumber + ", artNumber=" + artNumber + ", artStatus="
				+ artStatus + ", currentTestCount=" + currentTestCount + ", samplecollectedDate=" + samplecollectedDate
				+ ", testDate=" + testDate + ", sampleType=" + sampleType + ", facilityId=" + facilityId
				+ ", facilityName=" + facilityName + ", nextAppointmentDate=" + nextAppointmentDate + "]";
	}

}
