package gov.naco.soch.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ArtRegistrationDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long facilityId;
	private Long beneficiaryId;
	private String facilityCode;
	private String firstName;
	private String middleName;
	private String lastName;
	private String contactNumber;
	private String pinCode;
	private String state;
	private String district;
	private String block;
	private Integer houseNumber;
	private LocalDateTime dateOfBirth;
	private String gender;
	private String age;
	private String category;
	private String barCode;
	private String maritalStatus;
	private LocalDate dateOfReg;
	private String preArtNumber;
	private String patientArtStatus;
	private String patientStatus;
	private String weightBand;
	private String artNumber;
	private LocalDate artEligibilityDate;
	private LocalDate artStartDate;
	private LocalDate lastArtDispensationDate;
	private String regimen;
	private String baselineCd4Count;
	private LocalDate baselineCd4Date;
	private LocalDate latestCd4Date;
	private LocalDate nextCd4DueDate;
	private String lastCd4Count;
	private String viralLoadBaselineCount;
	private LocalDate viralLoadBaselineDate;
	private LocalDate latestViralLoadDate;
	private LocalDate viralLoadNextDate;
	private String lastViralCount;
	private String patientPid;
	private String ictccenter;
	private LocalDate hivDate;
	private String hivTestType;
	private String entryPoint;
	private String hivRiskFactor;
	private Boolean pregnant;
	private String monthlyHouseholdIncome;
	private String occupation;
	private String education;
	private Boolean consentDocumented;
	private Long userId;
	private Long roleId;
	private String counsellorSpeciality;
	private Long id;
	private Boolean onTransit;
//	private LocalDate startDate;
//	private LocalDate endDate;
	private String uidNumber;

	private boolean transferTo;
	private LocalDate dateOfVisit;
	private Long transferFromId;
	private Long transferToId;
	private LocalDate transferDate;
	private Long lacLinkageId;
	private Long artLinkFacilityId;
	private LocalDate transitStartDate;
	private LocalDate transitEndDate;
	
	private Long beneficiaryQueueId;
	private Long familyId;
	private String priority;
	private String beneficiaryType;
	private String beneficiaryActivityStatus;
	private LocalDate lastVisitDate;
	private Long weight;
	private Long regimenId;
	private Long assignedTo;
	private Long artId;
	private String artCentreCode;
	private String artCentreAddress;
	private Long height;
	private String  address;
	private String  city;
	private String taluk;
	private LocalDate nextVisitedDate;
	private Long transferId;

	public ArtRegistrationDto() {
		super();
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public String getFacilityCode() {
		return facilityCode;
	}

	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public LocalDate getDateOfReg() {
		return dateOfReg;
	}

	public void setDateOfReg(LocalDate dateOfReg) {
		this.dateOfReg = dateOfReg;
	}

	public String getPreArtNumber() {
		return preArtNumber;
	}

	public void setPreArtNumber(String preArtNumber) {
		this.preArtNumber = preArtNumber;
	}

	public String getPatientArtStatus() {
		return patientArtStatus;
	}

	public void setPatientArtStatus(String patientArtStatus) {
		this.patientArtStatus = patientArtStatus;
	}

	public String getPatientStatus() {
		return patientStatus;
	}

	public void setPatientStatus(String patientStatus) {
		this.patientStatus = patientStatus;
	}

	public String getWeightBand() {
		return weightBand;
	}

	public void setWeightBand(String weightBand) {
		this.weightBand = weightBand;
	}

	public String getArtNumber() {
		return artNumber;
	}

	public void setArtNumber(String artNumber) {
		this.artNumber = artNumber;
	}

	public LocalDate getArtEligibilityDate() {
		return artEligibilityDate;
	}

	public void setArtEligibilityDate(LocalDate artEligibilityDate) {
		this.artEligibilityDate = artEligibilityDate;
	}

	public LocalDate getArtStartDate() {
		return artStartDate;
	}

	public void setArtStartDate(LocalDate artStartDate) {
		this.artStartDate = artStartDate;
	}

	public LocalDate getLastArtDispensationDate() {
		return lastArtDispensationDate;
	}

	public void setLastArtDispensationDate(LocalDate lastArtDispensationDate) {
		this.lastArtDispensationDate = lastArtDispensationDate;
	}

	public String getRegimen() {
		return regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

	public String getBaselineCd4Count() {
		return baselineCd4Count;
	}

	public void setBaselineCd4Count(String baselineCd4Count) {
		this.baselineCd4Count = baselineCd4Count;
	}

	public LocalDate getBaselineCd4Date() {
		return baselineCd4Date;
	}

	public void setBaselineCd4Date(LocalDate baselineCd4Date) {
		this.baselineCd4Date = baselineCd4Date;
	}

	public LocalDate getLatestCd4Date() {
		return latestCd4Date;
	}

	public void setLatestCd4Date(LocalDate latestCd4Date) {
		this.latestCd4Date = latestCd4Date;
	}

	public LocalDate getNextCd4DueDate() {
		return nextCd4DueDate;
	}

	public void setNextCd4DueDate(LocalDate nextCd4DueDate) {
		this.nextCd4DueDate = nextCd4DueDate;
	}

	public String getLastCd4Count() {
		return lastCd4Count;
	}

	public void setLastCd4Count(String lastCd4Count) {
		this.lastCd4Count = lastCd4Count;
	}

	public String getViralLoadBaselineCount() {
		return viralLoadBaselineCount;
	}

	public void setViralLoadBaselineCount(String viralLoadBaselineCount) {
		this.viralLoadBaselineCount = viralLoadBaselineCount;
	}

	public LocalDate getViralLoadBaselineDate() {
		return viralLoadBaselineDate;
	}

	public void setViralLoadBaselineDate(LocalDate viralLoadBaselineDate) {
		this.viralLoadBaselineDate = viralLoadBaselineDate;
	}

	public LocalDate getLatestViralLoadDate() {
		return latestViralLoadDate;
	}

	public void setLatestViralLoadDate(LocalDate latestViralLoadDate) {
		this.latestViralLoadDate = latestViralLoadDate;
	}

	public LocalDate getViralLoadNextDate() {
		return viralLoadNextDate;
	}

	public void setViralLoadNextDate(LocalDate viralLoadNextDate) {
		this.viralLoadNextDate = viralLoadNextDate;
	}

	public String getLastViralCount() {
		return lastViralCount;
	}

	public void setLastViralCount(String lastViralCount) {
		this.lastViralCount = lastViralCount;
	}

	public String getPatientPid() {
		return patientPid;
	}

	public void setPatientPid(String patientPid) {
		this.patientPid = patientPid;
	}

	public String getIctccenter() {
		return ictccenter;
	}

	public void setIctccenter(String ictccenter) {
		this.ictccenter = ictccenter;
	}

	public LocalDate getHivDate() {
		return hivDate;
	}

	public void setHivDate(LocalDate hivDate) {
		this.hivDate = hivDate;
	}

	public String getHivTestType() {
		return hivTestType;
	}

	public void setHivTestType(String hivTestType) {
		this.hivTestType = hivTestType;
	}

	public String getEntryPoint() {
		return entryPoint;
	}

	public void setEntryPoint(String entryPoint) {
		this.entryPoint = entryPoint;
	}

	public String getHivRiskFactor() {
		return hivRiskFactor;
	}

	public void setHivRiskFactor(String hivRiskFactor) {
		this.hivRiskFactor = hivRiskFactor;
	}

	public Boolean getPregnant() {
		return pregnant;
	}

	public void setPregnant(Boolean pregnant) {
		this.pregnant = pregnant;
	}

	public String getMonthlyHouseholdIncome() {
		return monthlyHouseholdIncome;
	}

	public void setMonthlyHouseholdIncome(String monthlyHouseholdIncome) {
		this.monthlyHouseholdIncome = monthlyHouseholdIncome;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Boolean getConsentDocumented() {
		return consentDocumented;
	}

	public void setConsentDocumented(Boolean consentDocumented) {
		this.consentDocumented = consentDocumented;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getCounsellorSpeciality() {
		return counsellorSpeciality;
	}

	public void setCounsellorSpeciality(String counsellorSpeciality) {
		this.counsellorSpeciality = counsellorSpeciality;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getOnTransit() {
		return onTransit;
	}

	public void setOnTransit(Boolean onTransit) {
		this.onTransit = onTransit;
	}

	public String getUidNumber() {
		return uidNumber;
	}

	public void setUidNumber(String uidNumber) {
		this.uidNumber = uidNumber;
	}

	public boolean isTransferTo() {
		return transferTo;
	}

	public void setTransferTo(boolean transferTo) {
		this.transferTo = transferTo;
	}

	public LocalDate getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(LocalDate dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	
	public Long getTransferFromId() {
		return transferFromId;
	}

	public void setTransferFromId(Long transferFromId) {
		this.transferFromId = transferFromId;
	}

	public Long getTransferToId() {
		return transferToId;
	}

	public void setTransferToId(Long transferToId) {
		this.transferToId = transferToId;
	}

	public LocalDate getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(LocalDate transferDate) {
		this.transferDate = transferDate;
	}

	public Long getLacLinkageId() {
		return lacLinkageId;
	}

	public void setLacLinkageId(Long lacLinkageId) {
		this.lacLinkageId = lacLinkageId;
	}

	public Long getArtLinkFacilityId() {
		return artLinkFacilityId;
	}

	public void setArtLinkFacilityId(Long artLinkFacilityId) {
		this.artLinkFacilityId = artLinkFacilityId;
	}
	

	public LocalDate getTransitStartDate() {
		return transitStartDate;
	}

	public void setTransitStartDate(LocalDate transitStartDate) {
		this.transitStartDate = transitStartDate;
	}

	public LocalDate getTransitEndDate() {
		return transitEndDate;
	}

	public void setTransitEndDate(LocalDate transitEndDate) {
		this.transitEndDate = transitEndDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getBeneficiaryType() {
		return beneficiaryType;
	}

	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
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

	public Long getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Long assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Long getArtId() {
		return artId;
	}

	public void setArtId(Long artId) {
		this.artId = artId;
	}

	public String getArtCentreCode() {
		return artCentreCode;
	}

	public void setArtCentreCode(String artCentreCode) {
		this.artCentreCode = artCentreCode;
	}

	

	public String getArtCentreAddress() {
		return artCentreAddress;
	}

	public void setArtCentreAddress(String artCentreAddress) {
		this.artCentreAddress = artCentreAddress;
	}

	public Long getHeight() {
		return height;
	}

	public void setHeight(Long height) {
		this.height = height;
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

	public Long getBeneficiaryQueueId() {
		return beneficiaryQueueId;
	}

	public void setBeneficiaryQueueId(Long beneficiaryQueueId) {
		this.beneficiaryQueueId = beneficiaryQueueId;
	}

	public String getTaluk() {
		return taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	public LocalDate getNextVisitedDate() {
		return nextVisitedDate;
	}

	public void setNextVisitedDate(LocalDate nextVisitedDate) {
		this.nextVisitedDate = nextVisitedDate;
	}

	public Long getTransferId() {
		return transferId;
	}

	public void setTransferId(Long transferId) {
		this.transferId = transferId;
	}

	@Override
	public String toString() {
		return "ArtRegistrationDto [facilityId=" + facilityId + ", beneficiaryId=" + beneficiaryId + ", facilityCode="
				+ facilityCode + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", contactNumber=" + contactNumber + ", pinCode=" + pinCode + ", state=" + state + ", district="
				+ district + ", block=" + block + ", houseNumber=" + houseNumber + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", age=" + age + ", category=" + category + ", barCode=" + barCode
				+ ", maritalStatus=" + maritalStatus + ", dateOfReg=" + dateOfReg + ", preArtNumber=" + preArtNumber
				+ ", patientArtStatus=" + patientArtStatus + ", patientStatus=" + patientStatus + ", weightBand="
				+ weightBand + ", artNumber=" + artNumber + ", artEligibilityDate=" + artEligibilityDate
				+ ", artStartDate=" + artStartDate + ", lastArtDispensationDate=" + lastArtDispensationDate
				+ ", regimen=" + regimen + ", baselineCd4Count=" + baselineCd4Count + ", baselineCd4Date="
				+ baselineCd4Date + ", latestCd4Date=" + latestCd4Date + ", nextCd4DueDate=" + nextCd4DueDate
				+ ", lastCd4Count=" + lastCd4Count + ", viralLoadBaselineCount=" + viralLoadBaselineCount
				+ ", viralLoadBaselineDate=" + viralLoadBaselineDate + ", latestViralLoadDate=" + latestViralLoadDate
				+ ", viralLoadNextDate=" + viralLoadNextDate + ", lastViralCount=" + lastViralCount + ", patientPid="
				+ patientPid + ", ictccenter=" + ictccenter + ", hivDate=" + hivDate + ", hivTestType=" + hivTestType
				+ ", entryPoint=" + entryPoint + ", hivRiskFactor=" + hivRiskFactor + ", pregnant=" + pregnant
				+ ", monthlyHouseholdIncome=" + monthlyHouseholdIncome + ", occupation=" + occupation + ", education="
				+ education + ", consentDocumented=" + consentDocumented + ", userId=" + userId + ", roleId=" + roleId
				+ ", counsellorSpeciality=" + counsellorSpeciality + ", id=" + id + ", onTransit=" + onTransit
				+ ", uidNumber=" + uidNumber + ", transferTo=" + transferTo + ", dateOfVisit=" + dateOfVisit
				+ ", transferFromId=" + transferFromId + ", transferToId=" + transferToId + ", transferDate="
				+ transferDate + ", lacLinkageId=" + lacLinkageId + ", artLinkFacilityId=" + artLinkFacilityId
				+ ", transitStartDate=" + transitStartDate + ", transitEndDate=" + transitEndDate
				+ ", beneficiaryQueueId=" + beneficiaryQueueId + ", familyId=" + familyId + ", priority=" + priority
				+ ", beneficiaryType=" + beneficiaryType + ", beneficiaryActivityStatus=" + beneficiaryActivityStatus
				+ ", lastVisitDate=" + lastVisitDate + ", weight=" + weight + ", regimenId=" + regimenId
				+ ", assignedTo=" + assignedTo + ", artId=" + artId + ", artCentreCode=" + artCentreCode
				+ ", artCentreAddress=" + artCentreAddress + ", height=" + height + ", address=" + address + ", city="
				+ city + ", taluk=" + taluk + ", nextVisitedDate=" + nextVisitedDate + ", transferId=" + transferId
				+ "]";
	}

}
