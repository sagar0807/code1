package gov.naco.soch.cst.dto;

import java.time.LocalDate;
import java.util.List;

public class ArtRegistrationDto {
	private Long id;
	private Long beneficiaryId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String contactNumber;
	private String uidNumber;
	private LocalDate artRegistration_date;
	private LocalDate artEligibilityDate;
	private Long artBeneficiaryStatusId;
	private String preArtNumber;
	private String artNumber;
	private Long genderId;
	private String genderName;
	private LocalDate birthDate;
	private Long categoryId;
	private String categoryName;
	private String alternatePhoneNumber;
	private String caregiverName;
	private String caregiverPhoneNumber;
	private String age;
	private String aadharNumber;

	private Long occupationId;
	private String occupationName;
	private Long educationLevelId;
	private String educationLevelName;
	private Long masterEmploymentStatus;
	private Long beneficiaryReferralId;
	private String alternateAddress;
	private String artTransferStatus;
	private Long linkageOrganiationTypeId;
	private Long masterTreatmentLine;
	private Long deliveryOutcomeId;
	private Boolean infantRegisteredThroughEid;
	private Long infantEidLabId;
	private Long infantBeneficiaryId;
	private List<Long> masterSocialWelfare;
	private LocalDate hivDate;
	private String pinCode;
	private Long state;
	private String stateName;
	private String districtName;
	private String subdistrictName;
	private Long district;
	private String city;
	private Long town;
	private String townName;
	private Long subDistrictId;
	private String subDistrictName;
	private String addressLineOne;
	private String addressLineTwo;
	private Long artTransferredFrom;
	private String caregiverPinCode;
	private Long caregiverState;
	private Long caregiverDistrict;
	private Long caregivertown;
	private Long caregiverSubDistrictId;
	private String caregiveraddressLineOne;
	private String caregiveraddressLineTwo;
	private Long maritalStatusId;
	private Long monthlyIncome;
	private String monthlyIncomeName;
	private Long hivStatusId;
	private LocalDate deathDate;
	private String deathReason;
	private String bankAccountName;
	private String bankAccountNumber;
	private String bankIfsc;
	private Long stayingWithId;
	private String stayingWithName;
	private List<Long> linkagePurposesId;
	private Float weight;
	private Float height;
	private Long visitRegisterId;
	private Float previousHeight;
	private Float previousWeight;
	String previousPreArtNumber;


	private String previousFunctionalStatus;
	private String previousClinicalStage;
	private Boolean isPregnant;
	private Long pregnantCaseTypeId;
	private LocalDate lmp;
	private Boolean isActive;

	// ClincalDetails
	Long lastRegimenId;
	
	private String previousClinic;
	private LocalDate artStartDate;
	private String linkageInstituteName;
	private Long masterRiskFactor;
	private String masterRiskFactorName;
	private Long masterPurpos;
	private Integer dispensationLatestAdherenceValue;
	private Long counsellingLatestAdherenceValue;
	private Long entryPointId;
	private String entryPointName;
	private LocalDate artDispensationDate;
	private LocalDate nextAppointmentDate;
	private Long fourSScreening;
	private Long regimenId;
	private String regimenName;
	private Long masterArtTreatmentStatus;
	private Boolean isTransit;
	private LocalDate transitStartDate;
	private LocalDate transitEndDate;
	private Long transitFacilityId;
	private String patientPid;
	private Long hivTypeId;
	private String hivTypeName;
	private Long ictcCenters;
	private String ictcCenterName;
	private LocalDate hivTestDate;
	private Long linkedFacilityId;
	private Boolean isLinked;
	private String destinationFacilityType;
	private Long destinationFacilityId;
	private Boolean transferStatus;
	private Long transferStateId;
	private Long transferDistrictId;
	private LocalDate nextVisitDate;
	private Long assignedTo;
	private Long refferalStatusId;
	private String refferalStatus;
	private Long referTo;
	private List<Long> transistFacilityId;
	private Long previousNotTransferredArtId;
	private String artBeneficiaryStatusName;
	private String pregnantCaseTypeName;
	private BeneficiaryLabTestDetailsDto beneficiaryLabTestDetils;
	private LocalDate lastDispenseDate;
	private Long lastDispensedQty;
	private Integer remainingPills;
	private String dispensationRegimenName;
	private Long adherenceToArt;
	private ArtBeneficiaryIptAttDetailsDto artBeneficiaryIptAttDetails;
	private Long dispensationRegimenId;
	private Float dosageQty;
	boolean ifBeneficiaryUnStable = false;
	private String errorMsg;
	private String lacName;
	private Long presentFacilityId;
	private String facilityName;
	private Long facilityId;
	private Boolean pptctReferred;
	private String pptctPregnancyRemarks; 
	private String papSmear;
	private LocalDate previousVisitDate;
	private String previousArtNumber;
	// transferred From
	private String transferredFrom;
	private Boolean isConsentTaken;
	private LocalDate dateTransferredIn;
	private Long masterClosePersonRelationType;
	private String closePersonName;

	public ArtRegistrationDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getUidNumber() {
		return uidNumber;
	}

	public void setUidNumber(String uidNumber) {
		this.uidNumber = uidNumber;
	}

	public LocalDate getArtRegistration_date() {
		return artRegistration_date;
	}

	public void setArtRegistration_date(LocalDate artRegistration_date) {
		this.artRegistration_date = artRegistration_date;
	}

	public String getAlternateAddress() {
		return alternateAddress;
	}

	public void setAlternateAddress(String alternateAddress) {
		this.alternateAddress = alternateAddress;
	}

	public LocalDate getArtEligibilityDate() {
		return artEligibilityDate;
	}

	public void setArtEligibilityDate(LocalDate artEligibilityDate) {
		this.artEligibilityDate = artEligibilityDate;
	}

	public Long getArtBeneficiaryStatusId() {
		return artBeneficiaryStatusId;
	}

	public void setArtBeneficiaryStatusId(Long artBeneficiaryStatusId) {
		this.artBeneficiaryStatusId = artBeneficiaryStatusId;
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

	public Long getGenderId() {
		return genderId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getSubdistrictName() {
		return subdistrictName;
	}

	public void setSubdistrictName(String subdistrictName) {
		this.subdistrictName = subdistrictName;
	}

	public String getSubDistrictName() {
		return subDistrictName;
	}

	public void setSubDistrictName(String subDistrictName) {
		this.subDistrictName = subDistrictName;
	}

	public void setGenderId(Long genderId) {
		this.genderId = genderId;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getAlternatePhoneNumber() {
		return alternatePhoneNumber;
	}

	public void setAlternatePhoneNumber(String alternatePhoneNumber) {
		this.alternatePhoneNumber = alternatePhoneNumber;
	}

	public String getCaregiverName() {
		return caregiverName;
	}

	public void setCaregiverName(String caregiverName) {
		this.caregiverName = caregiverName;
	}

	public String getCaregiverPhoneNumber() {
		return caregiverPhoneNumber;
	}

	public void setCaregiverPhoneNumber(String caregiverPhoneNumber) {
		this.caregiverPhoneNumber = caregiverPhoneNumber;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public Long getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(Long occupationId) {
		this.occupationId = occupationId;
	}

	public Long getEducationLevelId() {
		return educationLevelId;
	}

	public void setEducationLevelId(Long educationLevelId) {
		this.educationLevelId = educationLevelId;
	}

	public Long getMasterEmploymentStatus() {
		return masterEmploymentStatus;
	}

	public void setMasterEmploymentStatus(Long masterEmploymentStatus) {
		this.masterEmploymentStatus = masterEmploymentStatus;
	}

	public Long getBeneficiaryReferralId() {
		return beneficiaryReferralId;
	}

	public void setBeneficiaryReferralId(Long beneficiaryReferralId) {
		this.beneficiaryReferralId = beneficiaryReferralId;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	public Long getDistrict() {
		return district;
	}

	public void setDistrict(Long district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getTown() {
		return town;
	}

	public void setTown(Long town) {
		this.town = town;
	}

	public String getTownName() {
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public Long getSubDistrictId() {
		return subDistrictId;
	}

	public void setSubDistrictId(Long subDistrictId) {
		this.subDistrictId = subDistrictId;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getArtTransferStatus() {
		return artTransferStatus;
	}

	public void setArtTransferStatus(String artTransferStatus) {
		this.artTransferStatus = artTransferStatus;
	}

	public Long getArtTransferredFrom() {
		return artTransferredFrom;
	}

	public void setArtTransferredFrom(Long artTransferredFrom) {
		this.artTransferredFrom = artTransferredFrom;
	}

	public String getCaregiverPinCode() {
		return caregiverPinCode;
	}

	public void setCaregiverPinCode(String caregiverPinCode) {
		this.caregiverPinCode = caregiverPinCode;
	}

	public Long getCaregiverState() {
		return caregiverState;
	}

	public void setCaregiverState(Long caregiverState) {
		this.caregiverState = caregiverState;
	}

	public Long getCaregiverDistrict() {
		return caregiverDistrict;
	}

	public void setCaregiverDistrict(Long caregiverDistrict) {
		this.caregiverDistrict = caregiverDistrict;
	}

	public Long getCaregivertown() {
		return caregivertown;
	}

	public void setCaregivertown(Long caregivertown) {
		this.caregivertown = caregivertown;
	}

	public Long getCaregiverSubDistrictId() {
		return caregiverSubDistrictId;
	}

	public void setCaregiverSubDistrictId(Long caregiverSubDistrictId) {
		this.caregiverSubDistrictId = caregiverSubDistrictId;
	}

	public BeneficiaryLabTestDetailsDto getBeneficiaryLabTestDetils() {
		return beneficiaryLabTestDetils;
	}

	public void setBeneficiaryLabTestDetils(BeneficiaryLabTestDetailsDto beneficiaryLabTestDetils) {
		this.beneficiaryLabTestDetils = beneficiaryLabTestDetils;
	}

	public String getCaregiveraddressLineOne() {
		return caregiveraddressLineOne;
	}

	public void setCaregiveraddressLineOne(String caregiveraddressLineOne) {
		this.caregiveraddressLineOne = caregiveraddressLineOne;
	}

	public String getCaregiveraddressLineTwo() {
		return caregiveraddressLineTwo;
	}

	public void setCaregiveraddressLineTwo(String caregiveraddressLineTwo) {
		this.caregiveraddressLineTwo = caregiveraddressLineTwo;
	}

	public Long getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(Long maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public Long getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(Long monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public Long getHivStatusId() {
		return hivStatusId;
	}

	public void setHivStatusId(Long hivStatusId) {
		this.hivStatusId = hivStatusId;
	}

	public LocalDate getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(LocalDate deathDate) {
		this.deathDate = deathDate;
	}

	public String getDeathReason() {
		return deathReason;
	}

	public void setDeathReason(String deathReason) {
		this.deathReason = deathReason;
	}

	public String getBankAccountName() {
		return bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public String getOccupationName() {
		return occupationName;
	}

	public void setOccupationName(String occupationName) {
		this.occupationName = occupationName;
	}

	public String getEducationLevelName() {
		return educationLevelName;
	}

	public void setEducationLevelName(String educationLevelName) {
		this.educationLevelName = educationLevelName;
	}

	public String getMonthlyIncomeName() {
		return monthlyIncomeName;
	}

	public void setMonthlyIncomeName(String monthlyIncomeName) {
		this.monthlyIncomeName = monthlyIncomeName;
	}

	public String getMasterRiskFactorName() {
		return masterRiskFactorName;
	}

	public void setMasterRiskFactorName(String masterRiskFactorName) {
		this.masterRiskFactorName = masterRiskFactorName;
	}

	public String getEntryPointName() {
		return entryPointName;
	}

	public void setEntryPointName(String entryPointName) {
		this.entryPointName = entryPointName;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankIfsc() {
		return bankIfsc;
	}

	public void setBankIfsc(String bankIfsc) {
		this.bankIfsc = bankIfsc;
	}

	public Long getStayingWithId() {
		return stayingWithId;
	}

	public void setStayingWithId(Long stayingWithId) {
		this.stayingWithId = stayingWithId;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Long getPregnantCaseTypeId() {
		return pregnantCaseTypeId;
	}

	public void setPregnantCaseTypeId(Long pregnantCaseTypeId) {
		this.pregnantCaseTypeId = pregnantCaseTypeId;
	}

	public LocalDate getLmp() {
		return lmp;
	}

	public void setLmp(LocalDate lmp) {
		this.lmp = lmp;
	}

	public String getPreviousClinic() {
		return previousClinic;
	}

	public void setPreviousClinic(String previousClinic) {
		this.previousClinic = previousClinic;
	}

	public LocalDate getArtStartDate() {
		return artStartDate;
	}

	public void setArtStartDate(LocalDate artStartDate) {
		this.artStartDate = artStartDate;
	}

	public String getLinkageInstituteName() {
		return linkageInstituteName;
	}

	public void setLinkageInstituteName(String linkageInstituteName) {
		this.linkageInstituteName = linkageInstituteName;
	}

	public Long getMasterRiskFactor() {
		return masterRiskFactor;
	}

	public void setMasterRiskFactor(Long masterRiskFactor) {
		this.masterRiskFactor = masterRiskFactor;
	}

	public Long getMasterPurpos() {
		return masterPurpos;
	}

	public void setMasterPurpos(Long masterPurpos) {
		this.masterPurpos = masterPurpos;
	}

	public Integer getDispensationLatestAdherenceValue() {
		return dispensationLatestAdherenceValue;
	}

	public void setDispensationLatestAdherenceValue(Integer dispensationLatestAdherenceValue) {
		this.dispensationLatestAdherenceValue = dispensationLatestAdherenceValue;
	}

	public Long getCounsellingLatestAdherenceValue() {
		return counsellingLatestAdherenceValue;
	}

	public void setCounsellingLatestAdherenceValue(Long counsellingLatestAdherenceValue) {
		this.counsellingLatestAdherenceValue = counsellingLatestAdherenceValue;
	}

	public void setVisitRegisterId(Long visitRegisterId) {
		this.visitRegisterId = visitRegisterId;
	}

	public Long getVisitRegisterId() {
		return visitRegisterId;
	}

	public Long getEntryPointId() {
		return entryPointId;
	}

	public void setEntryPointId(Long entryPointId) {
		this.entryPointId = entryPointId;
	}

	public LocalDate getArtDispensationDate() {
		return artDispensationDate;
	}

	public void setArtDispensationDate(LocalDate artDispensationDate) {
		this.artDispensationDate = artDispensationDate;
	}

	public LocalDate getNextAppointmentDate() {
		return nextAppointmentDate;
	}

	public void setNextAppointmentDate(LocalDate nextAppointmentDate) {
		this.nextAppointmentDate = nextAppointmentDate;
	}

	public Long getFourSScreening() {
		return fourSScreening;
	}

	public void setFourSScreening(Long fourSScreening) {
		this.fourSScreening = fourSScreening;
	}

	public Long getRegimenId() {
		return regimenId;
	}

	public void setRegimenId(Long regimenId) {
		this.regimenId = regimenId;
	}

	public Long getMasterArtTreatmentStatus() {
		return masterArtTreatmentStatus;
	}

	public void setMasterArtTreatmentStatus(Long masterArtTreatmentStatus) {
		this.masterArtTreatmentStatus = masterArtTreatmentStatus;
	}

	public Boolean getIsTransit() {
		return isTransit;
	}

	public void setIsTransit(Boolean isTransit) {
		this.isTransit = isTransit;
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

	public Long getTransitFacilityId() {
		return transitFacilityId;
	}

	public void setTransitFacilityId(Long transitFacilityId) {
		this.transitFacilityId = transitFacilityId;
	}

	public String getPatientPid() {
		return patientPid;
	}

	public void setPatientPid(String patientPid) {
		this.patientPid = patientPid;
	}

	public Long getHivTypeId() {
		return hivTypeId;
	}

	public void setHivTypeId(Long hivTypeId) {
		this.hivTypeId = hivTypeId;
	}

	public String getHivTypeName() {
		return hivTypeName;
	}

	public void setHivTypeName(String hivTypeName) {
		this.hivTypeName = hivTypeName;
	}

	public Long getIctcCenters() {
		return ictcCenters;
	}

	public void setIctcCenters(Long ictcCenters) {
		this.ictcCenters = ictcCenters;
	}

	public String getIctcCenterName() {
		return ictcCenterName;
	}

	public void setIctcCenterName(String ictcCenterName) {
		this.ictcCenterName = ictcCenterName;
	}

	public LocalDate getHivTestDate() {
		return hivTestDate;
	}

	public void setHivTestDate(LocalDate hivTestDate) {
		this.hivTestDate = hivTestDate;
	}

	public Long getLinkedFacilityId() {
		return linkedFacilityId;
	}

	public void setLinkedFacilityId(Long linkedFacilityId) {
		this.linkedFacilityId = linkedFacilityId;
	}

	public Boolean getIsLinked() {
		return isLinked;
	}

	public void setIsLinked(Boolean isLinked) {
		this.isLinked = isLinked;
	}

	public String getDestinationFacilityType() {
		return destinationFacilityType;
	}

	public void setDestinationFacilityType(String destinationFacilityType) {
		this.destinationFacilityType = destinationFacilityType;
	}

	public Long getDestinationFacilityId() {
		return destinationFacilityId;
	}

	public void setDestinationFacilityId(Long destinationFacilityId) {
		this.destinationFacilityId = destinationFacilityId;
	}

	public Boolean getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(Boolean transferStatus) {
		this.transferStatus = transferStatus;
	}

	public Long getTransferStateId() {
		return transferStateId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setTransferStateId(Long transferStateId) {
		this.transferStateId = transferStateId;
	}

	public Long getTransferDistrictId() {
		return transferDistrictId;
	}

	public void setTransferDistrictId(Long transferDistrictId) {
		this.transferDistrictId = transferDistrictId;
	}

	public LocalDate getNextVisitDate() {
		return nextVisitDate;
	}

	public void setNextVisitDate(LocalDate nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}

	public Long getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Long assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Long getRefferalStatusId() {
		return refferalStatusId;
	}

	public void setRefferalStatusId(Long refferalStatusId) {
		this.refferalStatusId = refferalStatusId;
	}

	public String getRefferalStatus() {
		return refferalStatus;
	}

	public void setRefferalStatus(String refferalStatus) {
		this.refferalStatus = refferalStatus;
	}

	public Long getReferTo() {
		return referTo;
	}

	public void setReferTo(Long referTo) {
		this.referTo = referTo;
	}

	public List<Long> getTransistFacilityId() {
		return transistFacilityId;
	}

	public void setTransistFacilityId(List<Long> transistFacilityId) {
		this.transistFacilityId = transistFacilityId;
	}

	public Long getPreviousNotTransferredArtId() {
		return previousNotTransferredArtId;
	}

	public void setArtBeneficiaryStatusName(String artBeneficiaryStatusName) {
		this.artBeneficiaryStatusName = artBeneficiaryStatusName;
	}

	public String getArtBeneficiaryStatusName() {
		return artBeneficiaryStatusName;
	}

	public void setPreviousNotTransferredArtId(Long previousNotTransferredArtId) {
		this.previousNotTransferredArtId = previousNotTransferredArtId;
	}

	public void setPregnantCaseTypeName(String pregnantCaseTypeName) {
		this.pregnantCaseTypeName = pregnantCaseTypeName;
	}

	public String getPregnantCaseTypeName() {
		return pregnantCaseTypeName;
	}

	public Float getPreviousHeight() {
		return previousHeight;
	}

	public void setPreviousHeight(Float previousHeight) {
		this.previousHeight = previousHeight;
	}

	public Float getPreviousWeight() {
		return previousWeight;
	}

	public void setPreviousWeight(Float previousWeight) {
		this.previousWeight = previousWeight;
	}

	public Long getLastRegimenId() {
		return lastRegimenId;
	}

	public void setLastRegimenId(Long lastRegimenId) {
		this.lastRegimenId = lastRegimenId;
	}

	public String getPreviousFunctionalStatus() {
		return previousFunctionalStatus;
	}

	public void setPreviousFunctionalStatus(String previousFunctionalStatus) {
		this.previousFunctionalStatus = previousFunctionalStatus;
	}

	public String getPreviousClinicalStage() {
		return previousClinicalStage;
	}

	public void setPreviousClinicalStage(String previousClinicalStage) {
		this.previousClinicalStage = previousClinicalStage;
	}

	public LocalDate getLastDispenseDate() {
		return lastDispenseDate;
	}

	public String getRegimenName() {
		return regimenName;
	}

	public void setRegimenName(String regimenName) {
		this.regimenName = regimenName;
	}

	public void setLastDispenseDate(LocalDate lastDispenseDate) {
		this.lastDispenseDate = lastDispenseDate;
	}

	public Long getLastDispensedQty() {
		return lastDispensedQty;
	}

	public void setLastDispensedQty(Long lastDispensedQty) {
		this.lastDispensedQty = lastDispensedQty;
	}

	public ArtBeneficiaryIptAttDetailsDto getArtBeneficiaryIptAttDetails() {
		return artBeneficiaryIptAttDetails;
	}

	public void setArtBeneficiaryIptAttDetails(ArtBeneficiaryIptAttDetailsDto artBeneficiaryIptAttDetails) {
		this.artBeneficiaryIptAttDetails = artBeneficiaryIptAttDetails;
	}

	public void setRemainingPills(Integer remainingPills) {
		this.remainingPills = remainingPills;
	}

	public Integer getRemainingPills() {
		return remainingPills;
	}

	public void setDispensationRegimenName(String dispensationRegimenName) {
		this.dispensationRegimenName = dispensationRegimenName;
	}

	public String getDispensationRegimenName() {
		return dispensationRegimenName;
	}

	public void setDispensationRegimenId(Long dispensationRegimenId) {
		this.dispensationRegimenId = dispensationRegimenId;
	}

	public Long getDispensationRegimenId() {
		return dispensationRegimenId;
	}

	public Long getLinkageOrganiationTypeId() {
		return linkageOrganiationTypeId;
	}

	public void setLinkageOrganiationTypeId(Long linkageOrganiationTypeId) {
		this.linkageOrganiationTypeId = linkageOrganiationTypeId;
	}

	public String getStayingWithName() {
		return stayingWithName;
	}

	public void setStayingWithName(String stayingWithName) {
		this.stayingWithName = stayingWithName;
	}

	public List<Long> getLinkagePurposesId() {
		return linkagePurposesId;
	}

	public void setLinkagePurposesId(List<Long> linkagePurposesId) {
		this.linkagePurposesId = linkagePurposesId;
	}

	public Long getMasterTreatmentLine() {
		return masterTreatmentLine;
	}

	public void setMasterTreatmentLine(Long masterTreatmentLine) {
		this.masterTreatmentLine = masterTreatmentLine;
	}

	public Long getDeliveryOutcomeId() {
		return deliveryOutcomeId;
	}

	public void setDeliveryOutcomeId(Long deliveryOutcomeId) {
		this.deliveryOutcomeId = deliveryOutcomeId;
	}

	public Boolean getInfantRegisteredThroughEid() {
		return infantRegisteredThroughEid;
	}

	public void setInfantRegisteredThroughEid(Boolean infantRegisteredThroughEid) {
		this.infantRegisteredThroughEid = infantRegisteredThroughEid;
	}

	public Long getInfantEidLabId() {
		return infantEidLabId;
	}

	public void setInfantEidLabId(Long infantEidLabId) {
		this.infantEidLabId = infantEidLabId;
	}

	public Long getInfantBeneficiaryId() {
		return infantBeneficiaryId;
	}

	public void setInfantBeneficiaryId(Long infantBeneficiaryId) {
		this.infantBeneficiaryId = infantBeneficiaryId;
	}

	public List<Long> getMasterSocialWelfare() {
		return masterSocialWelfare;
	}

	public void setMasterSocialWelfare(List<Long> masterSocialWelfare) {
		this.masterSocialWelfare = masterSocialWelfare;
	}

	public void setAdherenceToArt(Long adherenceToArt) {
		this.adherenceToArt = adherenceToArt;
	}

	public Long getAdherenceToArt() {
		return adherenceToArt;
	}

	public void setDosageQty(Float dosageQty) {
		this.dosageQty = dosageQty;
	}

	public Float getDosageQty() {
		return dosageQty;
	}

	public String getLacName() {
		return lacName;
	}

	public void setLacName(String lacName) {
		this.lacName = lacName;
	}

	public void setIfBeneficiaryUnStable(boolean ifBeneficiaryUnStable) {
		this.ifBeneficiaryUnStable = ifBeneficiaryUnStable;
	}

	public boolean getIfBeneficiaryUnStable() {
		return ifBeneficiaryUnStable;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public void setPresentFacilityId(Long presentFacilityId) {
		this.presentFacilityId = presentFacilityId;
	}

	public Long getPresentFacilityId() {
		return presentFacilityId;
	}

	public LocalDate getHivDate() {
		return hivDate;
	}

	public void setHivDate(LocalDate hivDate) {
		this.hivDate = hivDate;
	}
	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public Boolean getIsPregnant() {
		return isPregnant;
	}

	public void setIsPregnant(Boolean isPregnant) {
		this.isPregnant = isPregnant;
	}

	public Boolean getPptctReferred() {
		return pptctReferred;
	}

	public void setPptctReferred(Boolean pptctReferred) {
		this.pptctReferred = pptctReferred;
	}

	public String getPptctPregnancyRemarks() {
		return pptctPregnancyRemarks;
	}

	public void setPptctPregnancyRemarks(String pptctPregnancyRemarks) {
		this.pptctPregnancyRemarks = pptctPregnancyRemarks;
	}

	public String getPapSmear() {
		return papSmear;
	}

	public void setPapSmear(String papSmear) {
		this.papSmear = papSmear;
	}

    public void setPreviousVisitDate(LocalDate previousVisitDate) {
        this.previousVisitDate = previousVisitDate;
    }

    public LocalDate getPreviousVisitDate() {
        return previousVisitDate;
    }

	public void setPreviousPreArtNumber(String previousPreArtNumber) {
		this.previousPreArtNumber = previousPreArtNumber;
	}

	public String getPreviousPreArtNumber() {
		return previousPreArtNumber;
	}

	public void setPreviousArtNumber(String previousArtNumber) {
		this.previousArtNumber = previousArtNumber;
	}

	public String getPreviousArtNumber() {
		return previousArtNumber;
	}


	public void setTransferredFrom(String transferredFrom) {
		this.transferredFrom = transferredFrom;
	}
	public String getTransferredFrom() {
		return transferredFrom;
	}

	public Boolean getIsConsentTaken() {
		return isConsentTaken;
	}

	public void setIsConsentTaken(Boolean isConsentTaken) {
		this.isConsentTaken = isConsentTaken;
	}

	public LocalDate getDateTransferredIn() {
		return dateTransferredIn;
	}

	public void setDateTransferredIn(LocalDate dateTransferredIn) {
		this.dateTransferredIn = dateTransferredIn;
	}

	public Long getMasterClosePersonRelationType() {
		return masterClosePersonRelationType;
	}

	public void setMasterClosePersonRelationType(Long masterClosePersonRelationType) {
		this.masterClosePersonRelationType = masterClosePersonRelationType;
	}

	public String getClosePersonName() {
		return closePersonName;
	}

	public void setClosePersonName(String closePersonName) {
		this.closePersonName = closePersonName;
	}

}
