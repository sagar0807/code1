package gov.naco.soch.dto;

public class ArtDispatchSamplesDto {

	private Long id;
	private Long disapatchTo;
	private String BDN;
	private String dispatchedFacilityName;
	private String dispatchDate;
	private Long facilityId;
	private String facilityName;
	private Long beneficiaryId;
	private Long sampleId;

	private String firstName;
	private String middleName;
	private String lastName;
	private String uidNumber;
	private String age;
	private String gender;
	private String preArtNumber;
	private String artNumber;
	private String sampleCollectedDate;
	private String sampleDispatchDate;
	private Long labTechId;
	private String status;
	private Long numberOfSamples;

	public Long getId() {
		return id;
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

	public String getDispatchDate() {
		return dispatchDate;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public Long getSampleId() {
		return sampleId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDisapatchTo() {
		return disapatchTo;
	}

	public void setDisapatchTo(Long disapatchTo) {
		this.disapatchTo = disapatchTo;
	}

	public void setDispatchDate(String dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public void setSampleId(Long sampleId) {
		this.sampleId = sampleId;
	}

	public String getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getSampleCollectedDate() {
		return sampleCollectedDate;
	}

	public void setAge(String age) {
		this.age = age;
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

	public void setSampleCollectedDate(String sampleCollectedDate) {
		this.sampleCollectedDate = sampleCollectedDate;
	}

	public String getUidNumber() {
		return uidNumber;
	}

	public void setUidNumber(String uidNumber) {
		this.uidNumber = uidNumber;
	}

	public String getDispatchedFacilityName() {
		return dispatchedFacilityName;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setDispatchedFacilityName(String dispatchedFacilityName) {
		this.dispatchedFacilityName = dispatchedFacilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getBDN() {
		return BDN;
	}

	public void setBDN(String bDN) {
		BDN = bDN;
	}

	public Long getLabTechId() {
		return labTechId;
	}

	public void setLabTechId(Long labTechId) {
		this.labTechId = labTechId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getNumberOfSamples() {
		return numberOfSamples;
	}

	public void setNumberOfSamples(Long numberOfSamples) {
		this.numberOfSamples = numberOfSamples;
	}

	public String getSampleDispatchDate() {
		return sampleDispatchDate;
	}

	public void setSampleDispatchDate(String sampleDispatchDate) {
		this.sampleDispatchDate = sampleDispatchDate;
	}

	@Override
	public String toString() {
		return "ArtDispatchSamplesDto [id=" + id + ", disapatchTo=" + disapatchTo + ", BDN=" + BDN
				+ ", dispatchedFacilityName=" + dispatchedFacilityName + ", dispatchDate=" + dispatchDate
				+ ", facilityId=" + facilityId + ", facilityName=" + facilityName + ", beneficiaryId=" + beneficiaryId
				+ ", sampleId=" + sampleId + ", firstName=" + firstName + ", lastName=" + lastName + ", uidNumber="
				+ uidNumber + ", age=" + age + ", gender=" + gender + ", preArtNumber=" + preArtNumber + ", artNumber="
				+ artNumber + ", sampleCollectedDate=" + sampleCollectedDate + ", sampleDispatchDate="
				+ sampleDispatchDate + ", labTechId=" + labTechId + ", status=" + status + ", numberOfSamples="
				+ numberOfSamples + "]";
	}

}
