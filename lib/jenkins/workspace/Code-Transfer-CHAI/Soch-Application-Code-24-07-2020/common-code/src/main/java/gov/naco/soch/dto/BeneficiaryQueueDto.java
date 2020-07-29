package gov.naco.soch.dto;

import java.time.LocalDate;

public class BeneficiaryQueueDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long beneficiaryQueueId;
	private Long beneficiaryId;
	private String barCode;
	private String beneficiaryStatus;
	private String beneficiaryUid;
	private String contactNumber;
	private String firstname;
	private String middlename;
	private String lastname;
	private String gender;
	private String artNumber;
	private String preArtNumber;
	private Long familyId;
	private String priority;
	private String beneficiaryArtStatus;
	private LocalDate artStartDate;
	private String beneficiaryType;
	private String age;
	private String beneficiaryActivityStatus;
	private LocalDate lastVisitDate;
	private String weightBand;
	private Long weight;
	private Long regimenId;
	private String regimenName;
	private Long assignedTo;
	private Long artId;
	private String artCentreCode;
	private String artCenterAddress;
	String category;
	private Long height;
	private LocalDate dateOfRegistration;
	private String address;
	private String city;
	private String taluk;
	LocalDate dateOfBirth;
	
	public BeneficiaryQueueDto() {
		super();
	}

	public Long getBeneficiaryQueueId() {
		return beneficiaryQueueId;
	}

	public void setBeneficiaryQueueId(Long beneficiaryQueueId) {
		this.beneficiaryQueueId = beneficiaryQueueId;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getBeneficiaryStatus() {
		return beneficiaryStatus;
	}

	public void setBeneficiaryStatus(String beneficiaryStatus) {
		this.beneficiaryStatus = beneficiaryStatus;
	}

	public String getBeneficiaryUid() {
		return beneficiaryUid;
	}

	public void setBeneficiaryUid(String beneficiaryUid) {
		this.beneficiaryUid = beneficiaryUid;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public Long getArtId() {
		return artId;
	}

	public void setArtId(Long artId) {
		this.artId = artId;
	}

	public Long getHeight() {
		return height;
	}

	public void setHeight(Long height) {
		this.height = height;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Long getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getBeneficiaryArtStatus() {
		return beneficiaryArtStatus;
	}

	public void setBeneficiaryArtStatus(String beneficiaryArtStatus) {
		this.beneficiaryArtStatus = beneficiaryArtStatus;
	}

	public LocalDate getArtStartDate() {
		return artStartDate;
	}

	public void setArtStartDate(LocalDate artStartDate) {
		this.artStartDate = artStartDate;
	}

	public String getBeneficiaryType() {
		return beneficiaryType;
	}

	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBeneficiaryActivityStatus() {
		return beneficiaryActivityStatus;
	}

	public void setBeneficiaryActivityStatus(String beneficiaryActivityStatus) {
		this.beneficiaryActivityStatus = beneficiaryActivityStatus;
	}

	public LocalDate getLastVisitDate() {
		return lastVisitDate;
	}

	public void setLastVisitDate(LocalDate lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}

	public String getWeightBand() {
		return weightBand;
	}

	public void setWeightBand(String weightBand) {
		this.weightBand = weightBand;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	public Long getRegimenId() {
		return regimenId;
	}

	public void setRegimenId(Long regimenId) {
		this.regimenId = regimenId;
	}

	public String getRegimenName() {
		return regimenName;
	}

	public void setRegimenName(String regimenName) {
		this.regimenName = regimenName;
	}

	public Long getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Long assignedTo) {
		this.assignedTo = assignedTo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getArtCentreCode() {
		return artCentreCode;
	}

	public void setArtCentreCode(String artCentreCode) {
		this.artCentreCode = artCentreCode;
	}

	public String getArtCenterAddress() {
		return artCenterAddress;
	}

	public void setArtCenterAddress(String artCenterAddress) {
		this.artCenterAddress = artCenterAddress;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(LocalDate dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTaluk() {
		return taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "BeneficiaryQueueDto [beneficiaryQueueId=" + beneficiaryQueueId + ", beneficiaryId=" + beneficiaryId
				+ ", barCode=" + barCode + ", beneficiaryStatus=" + beneficiaryStatus + ", beneficiaryUid="
				+ beneficiaryUid + ", contactNumber=" + contactNumber + ", firstname=" + firstname + ", middlename="
				+ middlename + ", lastname=" + lastname + ", gender=" + gender + ", artNumber=" + artNumber
				+ ", preArtNumber=" + preArtNumber + ", familyId=" + familyId + ", priority=" + priority
				+ ", beneficiaryArtStatus=" + beneficiaryArtStatus + ", artStartDate=" + artStartDate
				+ ", beneficiaryType=" + beneficiaryType + ", age=" + age + ", beneficiaryActivityStatus="
				+ beneficiaryActivityStatus + ", lastVisitDate=" + lastVisitDate + ", weightBand=" + weightBand
				+ ", weight=" + weight + ", regimenId=" + regimenId + ", regimenName=" + regimenName + ", assignedTo="
				+ assignedTo + ", artId=" + artId + ", artCentreCode=" + artCentreCode + ", artCenterAddress="
				+ artCenterAddress + ", category=" + category + ", height=" + height + ", dateOfRegistration="
				+ dateOfRegistration + ", address=" + address + ", city=" + city + ", taluk=" + taluk + ", dateOfBirth="
				+ dateOfBirth + "]";
	}

	
}
