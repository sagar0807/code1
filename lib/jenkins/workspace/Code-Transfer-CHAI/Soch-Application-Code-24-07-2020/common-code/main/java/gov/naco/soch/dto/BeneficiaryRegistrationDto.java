package gov.naco.soch.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

//DTO class used for transfer data between front end and back end.
public class BeneficiaryRegistrationDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Long id;
	private Integer familyId;
	private String addiction;
	private Boolean alcoholConsume;
	private String averageNumberofSexualActsUponRegistration;
	private String beneficiaryCode;
	private String clientStatus;
	private Boolean condomUsage;
	private Boolean consentDocumented;
	private LocalDate dateOfRegistration;
	private String durationOfTheStays;
	private String facilityCode;
	private String howManyDaysAWeekIfAlcoholConsuming;
	private String hrgPrimaryCategory;
	private String hrgSecondaryCategory;
	private Boolean isActive;
	private String isBeneficiary;
	private Boolean isDelete;
	private Integer noOfSexualActivity;
	private Integer numberOfPartners;
	private String numberOfYearsInSexWork;
	private String otherDetails;
	private Integer outsideTheStateNoOfDays;
	private Integer outsideTheStateNoOfTimes;
	private String registrationPlace;
	private String regularPartners;
	private Boolean sexOtherThanSpouse;
	private String stayingWith;
	private String subCategory;
	private String typeOfMobility;
	private LocalDateTime viewPastActivity;
	private Integer withinTheDistrictNoOfDays;
	private Integer withinTheDistrictNoOfTimes;
	private Integer withinTheStateNoOfDays;
	private Integer withinTheStateNoOfTimes;
	private String isTransit;
	private LocalDate transitStartDate;
	private LocalDate transitEndDate;
	private boolean isOutwardReferal;
	private boolean isInwardReferal;
	private boolean isTransferOutTransferredReferal;
	private boolean isTransferOutDueForTransferReferal;
	private boolean isTransferInReferal;
	private boolean isTransitReferal;

	private String entryPoint;
	private String aadharNumber;
	private String age;
	private String barcode;
	private String beneficiaryType;
	private LocalDate dateOfBirth;
	private String educationLevel;
	private String employmentStatus;
	private String otherEmploymentStatus;
	private String firstName;
	private String lastName;
	private String gender;
	private Boolean isPlhiv;
	private String maritalStatus;
	private String middleName;
	private String mobileNumber;
	private String occupation;
	private String status;
	private String uidNumber;
	private String beneficiaryActivityStatus;
	private String ostCode;
	private String tiCode;

	private String block;
	private Integer houseNo;
	private String pincode;

	private Boolean friday;
	private Boolean monday;
	private Boolean saturday;
	private Boolean sunday;
	private Boolean thursday;
	private Boolean tuesday;
	private Boolean wednesday;

	private String screeningStatusHiv;
	private LocalDate lastRiskVulnerabilityAssessment;
	private String tbStatus;
	private String screeningStatusSyphilis;

	private String currentDose;
	private String dispensationStatus;
	private LocalDate dispensedLastDate;
	private LocalDate nextFollowUpDate;
	private String ostInitiated;
	private Integer ostNumber;
	private String currentOstStatus;

	private Long beneficiaryId;
	private Long availableDaysMapId;
	private Long beneficiaryFacilityMapId;
	private Long AddressId;

	private String monthlyHouseholdIncome;
	private Boolean pregnant;
	private String riskFactorForHiv;

	private Long screeningId;
	private String ostId;
	private Long beneficiaryUserMapId;
	private Long userId;
	private Long facilityId;
	private Long refferalId;

	private Integer referralFacility;
	private String referralStatus;
	private String hivStatus;
	private LocalDate dateOfReferral;
	private Integer referredFacility;
	private String transferTo;
	private String transferFrom;
	private LocalDate transferDate;
	private String transferStatus;

	private Long userFacilityId;
	private Set<ChildrenAgeGenderMappingDto> childrenAgeGenderMapping;
	private Set<TiBeneficiaryReferralDto> tiBeneficiaryReferralDto;
//	private Set<TiOstDetailDto> tiOstDetailDto;
	private Set<TiScreeningDetailDto> tiScreeningDetailDto;
	private Set<BeneficiaryFacilityMappingDto> beneficiaryFacilityMappingDto;
	private Set<BeneficiaryUserMappingDto> beneficiaryUserMappingDto;

	// Getters and setters for mentioned properties
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddiction() {
		return addiction;
	}

	public void setAddiction(String addiction) {
		this.addiction = addiction;
	}

	public Boolean getAlcoholConsume() {
		return alcoholConsume;
	}

	public void setAlcoholConsume(Boolean alcoholConsume) {
		this.alcoholConsume = alcoholConsume;
	}

	public String getAverageNumberofSexualActsUponRegistration() {
		return averageNumberofSexualActsUponRegistration;
	}

	public void setAverageNumberofSexualActsUponRegistration(String averageNumberofSexualActsUponRegistration) {
		this.averageNumberofSexualActsUponRegistration = averageNumberofSexualActsUponRegistration;
	}

	public Integer getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Integer familyId) {
		this.familyId = familyId;
	}

	public String getBeneficiaryCode() {
		return beneficiaryCode;
	}

	public void setBeneficiaryCode(String beneficiaryCode) {
		this.beneficiaryCode = beneficiaryCode;
	}

	public String getClientStatus() {
		return clientStatus;
	}

	public void setClientStatus(String clientStatus) {
		this.clientStatus = clientStatus;
	}

	public Boolean getCondomUsage() {
		return condomUsage;
	}

	public void setCondomUsage(Boolean condomUsage) {
		this.condomUsage = condomUsage;
	}

	public Boolean getConsentDocumented() {
		return consentDocumented;
	}

	public void setConsentDocumented(Boolean consentDocumented) {
		this.consentDocumented = consentDocumented;
	}

	public LocalDate getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(LocalDate dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getDurationOfTheStays() {
		return durationOfTheStays;
	}

	public void setDurationOfTheStays(String durationOfTheStays) {
		this.durationOfTheStays = durationOfTheStays;
	}

	public String getFacilityCode() {
		return facilityCode;
	}

	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}

	public String getHowManyDaysAWeekIfAlcoholConsuming() {
		return howManyDaysAWeekIfAlcoholConsuming;
	}

	public void setHowManyDaysAWeekIfAlcoholConsuming(String howManyDaysAWeekIfAlcoholConsuming) {
		this.howManyDaysAWeekIfAlcoholConsuming = howManyDaysAWeekIfAlcoholConsuming;
	}

	public String getHrgPrimaryCategory() {
		return hrgPrimaryCategory;
	}

	public void setHrgPrimaryCategory(String hrgPrimaryCategory) {
		this.hrgPrimaryCategory = hrgPrimaryCategory;
	}

	public String getHrgSecondaryCategory() {
		return hrgSecondaryCategory;
	}

	public void setHrgSecondaryCategory(String hrgSecondaryCategory) {
		this.hrgSecondaryCategory = hrgSecondaryCategory;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isOutwardReferal() {
		return isOutwardReferal;
	}

	public void setOutwardReferal(boolean isOutwardReferal) {
		this.isOutwardReferal = isOutwardReferal;
	}

	public boolean isInwardReferal() {
		return isInwardReferal;
	}

	public void setInwardReferal(boolean isInwardReferal) {
		this.isInwardReferal = isInwardReferal;
	}

	public boolean isTransferOutTransferredReferal() {
		return isTransferOutTransferredReferal;
	}

	public void setTransferOutTransferredReferal(boolean isTransferOutTransferredReferal) {
		this.isTransferOutTransferredReferal = isTransferOutTransferredReferal;
	}

	public boolean isTransferOutDueForTransferReferal() {
		return isTransferOutDueForTransferReferal;
	}

	public void setTransferOutDueForTransferReferal(boolean isTransferOutDueForTransferReferal) {
		this.isTransferOutDueForTransferReferal = isTransferOutDueForTransferReferal;
	}

	public boolean isTransferInReferal() {
		return isTransferInReferal;
	}

	public void setTransferInReferal(boolean isTransferInReferal) {
		this.isTransferInReferal = isTransferInReferal;
	}

	public boolean isTransitReferal() {
		return isTransitReferal;
	}

	public void setTransitReferal(boolean isTransitReferal) {
		this.isTransitReferal = isTransitReferal;
	}

	/*
	 * public String getReferredTo() { return referredTo; }
	 * 
	 * public void setReferredTo(String referredTo) { this.referredTo = referredTo;
	 * }
	 * 
	 * public String getReferredFrom() { return referredFrom; }
	 * 
	 * public void setReferredFrom(String referredFrom) { this.referredFrom =
	 * referredFrom; }
	 */

	public LocalDate getDateOfReferral() {
		return dateOfReferral;
	}

	public void setDateOfReferral(LocalDate dateOfReferral) {
		this.dateOfReferral = dateOfReferral;
	}

	public Integer getReferredFacility() {
		return referredFacility;
	}

	public void setReferredFacility(Integer referredFacility) {
		this.referredFacility = referredFacility;
	}

	public String getTransferTo() {
		return transferTo;
	}

	public void setTransferTo(String transferTo) {
		this.transferTo = transferTo;
	}

	public String getTransferFrom() {
		return transferFrom;
	}

	public void setTransferFrom(String transferFrom) {
		this.transferFrom = transferFrom;
	}

	public LocalDate getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(LocalDate transferDate) {
		this.transferDate = transferDate;
	}

	public String getIsBeneficiary() {
		return isBeneficiary;
	}

	public void setIsBeneficiary(String isBeneficiary) {
		this.isBeneficiary = isBeneficiary;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getNoOfSexualActivity() {
		return noOfSexualActivity;
	}

	public void setNoOfSexualActivity(Integer noOfSexualActivity) {
		this.noOfSexualActivity = noOfSexualActivity;
	}

	public Integer getNumberOfPartners() {
		return numberOfPartners;
	}

	public void setNumberOfPartners(Integer numberOfPartners) {
		this.numberOfPartners = numberOfPartners;
	}

	public String getNumberOfYearsInSexWork() {
		return numberOfYearsInSexWork;
	}

	public void setNumberOfYearsInSexWork(String numberOfYearsInSexWork) {
		this.numberOfYearsInSexWork = numberOfYearsInSexWork;
	}

	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	public Integer getOutsideTheStateNoOfDays() {
		return outsideTheStateNoOfDays;
	}

	public void setOutsideTheStateNoOfDays(Integer outsideTheStateNoOfDays) {
		this.outsideTheStateNoOfDays = outsideTheStateNoOfDays;
	}

	public Integer getOutsideTheStateNoOfTimes() {
		return outsideTheStateNoOfTimes;
	}

	public void setOutsideTheStateNoOfTimes(Integer outsideTheStateNoOfTimes) {
		this.outsideTheStateNoOfTimes = outsideTheStateNoOfTimes;
	}

	public String getRegistrationPlace() {
		return registrationPlace;
	}

	public void setRegistrationPlace(String registrationPlace) {
		this.registrationPlace = registrationPlace;
	}

	public String getRegularPartners() {
		return regularPartners;
	}

	public void setRegularPartners(String regularPartners) {
		this.regularPartners = regularPartners;
	}

	public Boolean getSexOtherThanSpouse() {
		return sexOtherThanSpouse;
	}

	public void setSexOtherThanSpouse(Boolean sexOtherThanSpouse) {
		this.sexOtherThanSpouse = sexOtherThanSpouse;
	}

	public String getStayingWith() {
		return stayingWith;
	}

	public void setStayingWith(String stayingWith) {
		this.stayingWith = stayingWith;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getTypeOfMobility() {
		return typeOfMobility;
	}

	public void setTypeOfMobility(String typeOfMobility) {
		this.typeOfMobility = typeOfMobility;
	}

	public LocalDateTime getViewPastActivity() {
		return viewPastActivity;
	}

	public void setViewPastActivity(LocalDateTime viewPastActivity) {
		this.viewPastActivity = viewPastActivity;
	}

	public Integer getWithinTheDistrictNoOfDays() {
		return withinTheDistrictNoOfDays;
	}

	public void setWithinTheDistrictNoOfDays(Integer withinTheDistrictNoOfDays) {
		this.withinTheDistrictNoOfDays = withinTheDistrictNoOfDays;
	}

	public Integer getWithinTheDistrictNoOfTimes() {
		return withinTheDistrictNoOfTimes;
	}

	public void setWithinTheDistrictNoOfTimes(Integer withinTheDistrictNoOfTimes) {
		this.withinTheDistrictNoOfTimes = withinTheDistrictNoOfTimes;
	}

	public Integer getWithinTheStateNoOfDays() {
		return withinTheStateNoOfDays;
	}

	public void setWithinTheStateNoOfDays(Integer withinTheStateNoOfDays) {
		this.withinTheStateNoOfDays = withinTheStateNoOfDays;
	}

	public Integer getWithinTheStateNoOfTimes() {
		return withinTheStateNoOfTimes;
	}

	public void setWithinTheStateNoOfTimes(Integer withinTheStateNoOfTimes) {
		this.withinTheStateNoOfTimes = withinTheStateNoOfTimes;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getBeneficiaryType() {
		return beneficiaryType;
	}

	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public String getOtherEmploymentStatus() {
		return otherEmploymentStatus;
	}

	public void setOtherEmploymentStatus(String otherEmploymentStatus) {
		this.otherEmploymentStatus = otherEmploymentStatus;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getIsPlhiv() {
		return isPlhiv;
	}

	public void setIsPlhiv(Boolean isPlhiv) {
		this.isPlhiv = isPlhiv;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
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

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUidNumber() {
		return uidNumber;
	}

	public void setUidNumber(String uidNumber) {
		this.uidNumber = uidNumber;
	}

	public String getTiCode() {
		return tiCode;
	}

	public void setTiCode(String tiCode) {
		this.tiCode = tiCode;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public Integer getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(Integer houseNo) {
		this.houseNo = houseNo;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Boolean getFriday() {
		return friday;
	}

	public void setFriday(Boolean friday) {
		this.friday = friday;
	}

	public Boolean getMonday() {
		return monday;
	}

	public void setMonday(Boolean monday) {
		this.monday = monday;
	}

	public Boolean getSaturday() {
		return saturday;
	}

	public void setSaturday(Boolean saturday) {
		this.saturday = saturday;
	}

	public Boolean getSunday() {
		return sunday;
	}

	public void setSunday(Boolean sunday) {
		this.sunday = sunday;
	}

	public Boolean getThursday() {
		return thursday;
	}

	public void setThursday(Boolean thursday) {
		this.thursday = thursday;
	}

	public Boolean getTuesday() {
		return tuesday;
	}

	public void setTuesday(Boolean tuesday) {
		this.tuesday = tuesday;
	}

	public Boolean getWednesday() {
		return wednesday;
	}

	public void setWednesday(Boolean wednesday) {
		this.wednesday = wednesday;
	}

	public String getScreeningStatusHiv() {
		return screeningStatusHiv;
	}

	public void setScreeningStatusHiv(String screeningStatusHiv) {
		this.screeningStatusHiv = screeningStatusHiv;
	}

	public LocalDate getLastRiskVulnerabilityAssessment() {
		return lastRiskVulnerabilityAssessment;
	}

	public void setLastRiskVulnerabilityAssessment(LocalDate lastRiskVulnerabilityAssessment) {
		this.lastRiskVulnerabilityAssessment = lastRiskVulnerabilityAssessment;
	}

	public String getTbStatus() {
		return tbStatus;
	}

	public void setTbStatus(String tbStatus) {
		this.tbStatus = tbStatus;
	}

	public String getScreeningStatusSyphilis() {
		return screeningStatusSyphilis;
	}

	public void setScreeningStatusSyphilis(String screeningStatusSyphilis) {
		this.screeningStatusSyphilis = screeningStatusSyphilis;
	}

	public String getCurrentDose() {
		return currentDose;
	}

	public void setCurrentDose(String currentDose) {
		this.currentDose = currentDose;
	}

	public String getDispensationStatus() {
		return dispensationStatus;
	}

	public void setDispensationStatus(String dispensationStatus) {
		this.dispensationStatus = dispensationStatus;
	}

	public LocalDate getDispensedLastDate() {
		return dispensedLastDate;
	}

	public void setDispensedLastDate(LocalDate dispensedLastDate) {
		this.dispensedLastDate = dispensedLastDate;
	}

	public LocalDate getNextFollowUpDate() {
		return nextFollowUpDate;
	}

	public void setNextFollowUpDate(LocalDate nextFollowUpDate) {
		this.nextFollowUpDate = nextFollowUpDate;
	}

	public String getOstInitiated() {
		return ostInitiated;
	}

	public void setOstInitiated(String ostInitiated) {
		this.ostInitiated = ostInitiated;
	}

	public Integer getOstNumber() {
		return ostNumber;
	}

	public void setOstNumber(Integer ostNumber) {
		this.ostNumber = ostNumber;
	}

	public String getCurrentOstStatus() {
		return currentOstStatus;
	}

	public void setCurrentOstStatus(String currentOstStatus) {
		this.currentOstStatus = currentOstStatus;
	}

	public String getBeneficiaryActivityStatus() {
		return beneficiaryActivityStatus;
	}

	public void setBeneficiaryActivityStatus(String beneficiaryActivityStatus) {
		this.beneficiaryActivityStatus = beneficiaryActivityStatus;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Long getAvailableDaysMapId() {
		return availableDaysMapId;
	}

	public void setAvailableDaysMapId(Long availableDaysMapId) {
		this.availableDaysMapId = availableDaysMapId;
	}

	public Long getBeneficiaryFacilityMapId() {
		return beneficiaryFacilityMapId;
	}

	public void setBeneficiaryFacilityMapId(Long beneficiaryFacilityMapId) {
		this.beneficiaryFacilityMapId = beneficiaryFacilityMapId;
	}

	public Long getAddressId() {
		return AddressId;
	}

	public void setAddressId(Long addressId) {
		AddressId = addressId;
	}

	public Long getScreeningId() {
		return screeningId;
	}

	public void setScreeningId(Long screeningId) {
		this.screeningId = screeningId;
	}

	public String getOstId() {
		return ostId;
	}

	public void setOstId(String ostId) {
		this.ostId = ostId;
	}

	public Long getBeneficiaryUserMapId() {
		return beneficiaryUserMapId;
	}

	public void setBeneficiaryUserMapId(Long beneficiaryUserMapId) {
		this.beneficiaryUserMapId = beneficiaryUserMapId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<ChildrenAgeGenderMappingDto> getChildrenAgeGenderMapping() {
		return childrenAgeGenderMapping;
	}

	public void setChildrenAgeGenderMapping(Set<ChildrenAgeGenderMappingDto> childrenAgeGenderMapping) {
		this.childrenAgeGenderMapping = childrenAgeGenderMapping;
	}

	public Integer getReferralFacility() {
		return referralFacility;
	}

	public void setReferralFacility(Integer referralFacility) {
		this.referralFacility = referralFacility;
	}

	public String getReferralStatus() {
		return referralStatus;
	}

	public String getOstCode() {
		return ostCode;
	}

	public void setOstCode(String ostCode) {
		this.ostCode = ostCode;
	}

	public void setReferralStatus(String referralStatus) {
		this.referralStatus = referralStatus;
	}

	public String getHivStatus() {
		return hivStatus;
	}

	public void setHivStatus(String hivStatus) {
		this.hivStatus = hivStatus;
	}

	public String getIsTransit() {
		return isTransit;
	}

	public void setIsTransit(String isTransit) {
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

	public String getEntryPoint() {
		return entryPoint;
	}

	public void setEntryPoint(String entryPoint) {
		this.entryPoint = entryPoint;
	}

	public String getMonthlyHouseholdIncome() {
		return monthlyHouseholdIncome;
	}

	public void setMonthlyHouseholdIncome(String monthlyHouseholdIncome) {
		this.monthlyHouseholdIncome = monthlyHouseholdIncome;
	}

	public Boolean getPregnant() {
		return pregnant;
	}

	public void setPregnant(Boolean pregnant) {
		this.pregnant = pregnant;
	}

	public String getRiskFactorForHiv() {
		return riskFactorForHiv;
	}

	public void setRiskFactorForHiv(String riskFactorForHiv) {
		this.riskFactorForHiv = riskFactorForHiv;
	}

	public Long getRefferalId() {
		return refferalId;
	}

	public void setRefferalId(Long refferalId) {
		this.refferalId = refferalId;
	}

	public String getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(String transferStatus) {
		this.transferStatus = transferStatus;
	}

	public Long getUserFacilityId() {
		return userFacilityId;
	}

	public void setUserFacilityId(Long userFacilityId) {
		this.userFacilityId = userFacilityId;
	}

	public Set<TiBeneficiaryReferralDto> getTiBeneficiaryReferralDto() {
		return tiBeneficiaryReferralDto;
	}

	public void setTiBeneficiaryReferralDto(Set<TiBeneficiaryReferralDto> tiBeneficiaryReferralDto) {
		this.tiBeneficiaryReferralDto = tiBeneficiaryReferralDto;
	}

//	public Set<TiOstDetailDto> getTiOstDetailDto() {
//		return tiOstDetailDto;
//	}
//
//	public void setTiOstDetailDto(Set<TiOstDetailDto> tiOstDetailDto) {
//		this.tiOstDetailDto = tiOstDetailDto;
//	}

	public Set<TiScreeningDetailDto> getTiScreeningDetailDto() {
		return tiScreeningDetailDto;
	}

	public void setTiScreeningDetailDto(Set<TiScreeningDetailDto> tiScreeningDetailDto) {
		this.tiScreeningDetailDto = tiScreeningDetailDto;
	}

	public Set<BeneficiaryFacilityMappingDto> getBeneficiaryFacilityMappingDto() {
		return beneficiaryFacilityMappingDto;
	}

	public void setBeneficiaryFacilityMappingDto(Set<BeneficiaryFacilityMappingDto> beneficiaryFacilityMappingDto) {
		this.beneficiaryFacilityMappingDto = beneficiaryFacilityMappingDto;
	}

	public Set<BeneficiaryUserMappingDto> getBeneficiaryUserMappingDto() {
		return beneficiaryUserMappingDto;
	}

	public void setBeneficiaryUserMappingDto(Set<BeneficiaryUserMappingDto> beneficiaryUserMappingDto) {
		this.beneficiaryUserMappingDto = beneficiaryUserMappingDto;
	}

	@Override
	public String toString() {
		return "BeneficiaryRegistrationDto [id=" + id + ", familyId=" + familyId + ", addiction=" + addiction
				+ ", alcoholConsume=" + alcoholConsume + ", averageNumberofSexualActsUponRegistration="
				+ averageNumberofSexualActsUponRegistration + ", beneficiaryCode=" + beneficiaryCode + ", clientStatus="
				+ clientStatus + ", condomUsage=" + condomUsage + ", consentDocumented=" + consentDocumented
				+ ", dateOfRegistration=" + dateOfRegistration + ", durationOfTheStays=" + durationOfTheStays
				+ ", facilityCode=" + facilityCode + ", howManyDaysAWeekIfAlcoholConsuming="
				+ howManyDaysAWeekIfAlcoholConsuming + ", hrgPrimaryCategory=" + hrgPrimaryCategory
				+ ", hrgSecondaryCategory=" + hrgSecondaryCategory + ", isActive=" + isActive + ", isBeneficiary="
				+ isBeneficiary + ", isDelete=" + isDelete + ", noOfSexualActivity=" + noOfSexualActivity
				+ ", numberOfPartners=" + numberOfPartners + ", numberOfYearsInSexWork=" + numberOfYearsInSexWork
				+ ", otherDetails=" + otherDetails + ", outsideTheStateNoOfDays=" + outsideTheStateNoOfDays
				+ ", outsideTheStateNoOfTimes=" + outsideTheStateNoOfTimes + ", registrationPlace=" + registrationPlace
				+ ", regularPartners=" + regularPartners + ", sexOtherThanSpouse=" + sexOtherThanSpouse
				+ ", stayingWith=" + stayingWith + ", subCategory=" + subCategory + ", typeOfMobility=" + typeOfMobility
				+ ", viewPastActivity=" + viewPastActivity + ", withinTheDistrictNoOfDays=" + withinTheDistrictNoOfDays
				+ ", withinTheDistrictNoOfTimes=" + withinTheDistrictNoOfTimes + ", withinTheStateNoOfDays="
				+ withinTheStateNoOfDays + ", withinTheStateNoOfTimes=" + withinTheStateNoOfTimes + ", isTransit="
				+ isTransit + ", transitStartDate=" + transitStartDate + ", transitEndDate=" + transitEndDate
				+ ", isOutwardReferal=" + isOutwardReferal + ", isInwardReferal=" + isInwardReferal
				+ ", isTransferOutTransferredReferal=" + isTransferOutTransferredReferal
				+ ", isTransferOutDueForTransferReferal=" + isTransferOutDueForTransferReferal
				+ ", isTransferInReferal=" + isTransferInReferal + ", isTransitReferal=" + isTransitReferal
				+ ", entryPoint=" + entryPoint + ", aadharNumber=" + aadharNumber + ", age=" + age + ", barcode="
				+ barcode + ", beneficiaryType=" + beneficiaryType + ", dateOfBirth=" + dateOfBirth
				+ ", educationLevel=" + educationLevel + ", employmentStatus=" + employmentStatus
				+ ", otherEmploymentStatus=" + otherEmploymentStatus + ", firstName=" + firstName + ", lastName="
				+ lastName + ", gender=" + gender + ", isPlhiv=" + isPlhiv + ", maritalStatus=" + maritalStatus
				+ ", middleName=" + middleName + ", mobileNumber=" + mobileNumber + ", occupation=" + occupation
				+ ", status=" + status + ", uidNumber=" + uidNumber + ", beneficiaryActivityStatus="
				+ beneficiaryActivityStatus + ", ostCode=" + ostCode + ", tiCode=" + tiCode + ", block=" + block
				+ ", houseNo=" + houseNo + ", pincode=" + pincode + ", friday=" + friday + ", monday=" + monday
				+ ", saturday=" + saturday + ", sunday=" + sunday + ", thursday=" + thursday + ", tuesday=" + tuesday
				+ ", wednesday=" + wednesday + ", screeningStatusHiv=" + screeningStatusHiv
				+ ", lastRiskVulnerabilityAssessment=" + lastRiskVulnerabilityAssessment + ", tbStatus=" + tbStatus
				+ ", screeningStatusSyphilis=" + screeningStatusSyphilis + ", currentDose=" + currentDose
				+ ", dispensationStatus=" + dispensationStatus + ", dispensedLastDate=" + dispensedLastDate
				+ ", nextFollowUpDate=" + nextFollowUpDate + ", ostInitiated=" + ostInitiated + ", ostNumber="
				+ ostNumber + ", currentOstStatus=" + currentOstStatus + ", beneficiaryId=" + beneficiaryId
				+ ", availableDaysMapId=" + availableDaysMapId + ", beneficiaryFacilityMapId="
				+ beneficiaryFacilityMapId + ", AddressId=" + AddressId + ", monthlyHouseholdIncome="
				+ monthlyHouseholdIncome + ", pregnant=" + pregnant + ", riskFactorForHiv=" + riskFactorForHiv
				+ ", screeningId=" + screeningId + ", ostId=" + ostId + ", beneficiaryUserMapId=" + beneficiaryUserMapId
				+ ", userId=" + userId + ", facilityId=" + facilityId + ", refferalId=" + refferalId
				+ ", referralFacility=" + referralFacility + ", referralStatus=" + referralStatus + ", hivStatus="
				+ hivStatus + ", dateOfReferral=" + dateOfReferral + ", referredFacility=" + referredFacility
				+ ", transferTo=" + transferTo + ", transferFrom=" + transferFrom + ", transferDate=" + transferDate
				+ ", transferStatus=" + transferStatus + ", userFacilityId=" + userFacilityId
				+ ", childrenAgeGenderMapping=" + childrenAgeGenderMapping + ", tiBeneficiaryReferralDto="
				+ tiBeneficiaryReferralDto+ ", tiScreeningDetailDto="
				+ tiScreeningDetailDto + ", beneficiaryFacilityMappingDto=" + beneficiaryFacilityMappingDto
				+ ", beneficiaryUserMappingDto=" + beneficiaryUserMappingDto + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeneficiaryRegistrationDto other = (BeneficiaryRegistrationDto) obj;
		if (AddressId == null) {
			if (other.AddressId != null)
				return false;
		} else if (!AddressId.equals(other.AddressId))
			return false;
		if (aadharNumber == null) {
			if (other.aadharNumber != null)
				return false;
		} else if (!aadharNumber.equals(other.aadharNumber))
			return false;
		if (addiction == null) {
			if (other.addiction != null)
				return false;
		} else if (!addiction.equals(other.addiction))
			return false;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (alcoholConsume == null) {
			if (other.alcoholConsume != null)
				return false;
		} else if (!alcoholConsume.equals(other.alcoholConsume))
			return false;
		if (availableDaysMapId == null) {
			if (other.availableDaysMapId != null)
				return false;
		} else if (!availableDaysMapId.equals(other.availableDaysMapId))
			return false;
		if (averageNumberofSexualActsUponRegistration == null) {
			if (other.averageNumberofSexualActsUponRegistration != null)
				return false;
		} else if (!averageNumberofSexualActsUponRegistration.equals(other.averageNumberofSexualActsUponRegistration))
			return false;
		if (barcode == null) {
			if (other.barcode != null)
				return false;
		} else if (!barcode.equals(other.barcode))
			return false;
		if (beneficiaryActivityStatus == null) {
			if (other.beneficiaryActivityStatus != null)
				return false;
		} else if (!beneficiaryActivityStatus.equals(other.beneficiaryActivityStatus))
			return false;
		if (beneficiaryCode == null) {
			if (other.beneficiaryCode != null)
				return false;
		} else if (!beneficiaryCode.equals(other.beneficiaryCode))
			return false;
		if (beneficiaryFacilityMapId == null) {
			if (other.beneficiaryFacilityMapId != null)
				return false;
		} else if (!beneficiaryFacilityMapId.equals(other.beneficiaryFacilityMapId))
			return false;
		if (beneficiaryFacilityMappingDto == null) {
			if (other.beneficiaryFacilityMappingDto != null)
				return false;
		} else if (!beneficiaryFacilityMappingDto.equals(other.beneficiaryFacilityMappingDto))
			return false;
		if (beneficiaryId == null) {
			if (other.beneficiaryId != null)
				return false;
		} else if (!beneficiaryId.equals(other.beneficiaryId))
			return false;
		if (beneficiaryType == null) {
			if (other.beneficiaryType != null)
				return false;
		} else if (!beneficiaryType.equals(other.beneficiaryType))
			return false;
		if (beneficiaryUserMapId == null) {
			if (other.beneficiaryUserMapId != null)
				return false;
		} else if (!beneficiaryUserMapId.equals(other.beneficiaryUserMapId))
			return false;
		if (beneficiaryUserMappingDto == null) {
			if (other.beneficiaryUserMappingDto != null)
				return false;
		} else if (!beneficiaryUserMappingDto.equals(other.beneficiaryUserMappingDto))
			return false;
		if (block == null) {
			if (other.block != null)
				return false;
		} else if (!block.equals(other.block))
			return false;
		if (childrenAgeGenderMapping == null) {
			if (other.childrenAgeGenderMapping != null)
				return false;
		} else if (!childrenAgeGenderMapping.equals(other.childrenAgeGenderMapping))
			return false;
		if (clientStatus == null) {
			if (other.clientStatus != null)
				return false;
		} else if (!clientStatus.equals(other.clientStatus))
			return false;
		if (condomUsage == null) {
			if (other.condomUsage != null)
				return false;
		} else if (!condomUsage.equals(other.condomUsage))
			return false;
		if (consentDocumented == null) {
			if (other.consentDocumented != null)
				return false;
		} else if (!consentDocumented.equals(other.consentDocumented))
			return false;
		if (currentDose == null) {
			if (other.currentDose != null)
				return false;
		} else if (!currentDose.equals(other.currentDose))
			return false;
		if (currentOstStatus == null) {
			if (other.currentOstStatus != null)
				return false;
		} else if (!currentOstStatus.equals(other.currentOstStatus))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (dateOfReferral == null) {
			if (other.dateOfReferral != null)
				return false;
		} else if (!dateOfReferral.equals(other.dateOfReferral))
			return false;
		if (dateOfRegistration == null) {
			if (other.dateOfRegistration != null)
				return false;
		} else if (!dateOfRegistration.equals(other.dateOfRegistration))
			return false;
		if (dispensationStatus == null) {
			if (other.dispensationStatus != null)
				return false;
		} else if (!dispensationStatus.equals(other.dispensationStatus))
			return false;
		if (dispensedLastDate == null) {
			if (other.dispensedLastDate != null)
				return false;
		} else if (!dispensedLastDate.equals(other.dispensedLastDate))
			return false;
		if (durationOfTheStays == null) {
			if (other.durationOfTheStays != null)
				return false;
		} else if (!durationOfTheStays.equals(other.durationOfTheStays))
			return false;
		if (educationLevel == null) {
			if (other.educationLevel != null)
				return false;
		} else if (!educationLevel.equals(other.educationLevel))
			return false;
		if (employmentStatus == null) {
			if (other.employmentStatus != null)
				return false;
		} else if (!employmentStatus.equals(other.employmentStatus))
			return false;
		if (entryPoint == null) {
			if (other.entryPoint != null)
				return false;
		} else if (!entryPoint.equals(other.entryPoint))
			return false;
		if (facilityCode == null) {
			if (other.facilityCode != null)
				return false;
		} else if (!facilityCode.equals(other.facilityCode))
			return false;
		if (facilityId == null) {
			if (other.facilityId != null)
				return false;
		} else if (!facilityId.equals(other.facilityId))
			return false;
		if (familyId == null) {
			if (other.familyId != null)
				return false;
		} else if (!familyId.equals(other.familyId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (friday == null) {
			if (other.friday != null)
				return false;
		} else if (!friday.equals(other.friday))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (hivStatus == null) {
			if (other.hivStatus != null)
				return false;
		} else if (!hivStatus.equals(other.hivStatus))
			return false;
		if (houseNo == null) {
			if (other.houseNo != null)
				return false;
		} else if (!houseNo.equals(other.houseNo))
			return false;
		if (howManyDaysAWeekIfAlcoholConsuming == null) {
			if (other.howManyDaysAWeekIfAlcoholConsuming != null)
				return false;
		} else if (!howManyDaysAWeekIfAlcoholConsuming.equals(other.howManyDaysAWeekIfAlcoholConsuming))
			return false;
		if (hrgPrimaryCategory == null) {
			if (other.hrgPrimaryCategory != null)
				return false;
		} else if (!hrgPrimaryCategory.equals(other.hrgPrimaryCategory))
			return false;
		if (hrgSecondaryCategory == null) {
			if (other.hrgSecondaryCategory != null)
				return false;
		} else if (!hrgSecondaryCategory.equals(other.hrgSecondaryCategory))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (isBeneficiary == null) {
			if (other.isBeneficiary != null)
				return false;
		} else if (!isBeneficiary.equals(other.isBeneficiary))
			return false;
		if (isDelete == null) {
			if (other.isDelete != null)
				return false;
		} else if (!isDelete.equals(other.isDelete))
			return false;
		if (isInwardReferal != other.isInwardReferal)
			return false;
		if (isOutwardReferal != other.isOutwardReferal)
			return false;
		if (isPlhiv == null) {
			if (other.isPlhiv != null)
				return false;
		} else if (!isPlhiv.equals(other.isPlhiv))
			return false;
		if (isTransferInReferal != other.isTransferInReferal)
			return false;
		if (isTransferOutDueForTransferReferal != other.isTransferOutDueForTransferReferal)
			return false;
		if (isTransferOutTransferredReferal != other.isTransferOutTransferredReferal)
			return false;
		if (isTransit == null) {
			if (other.isTransit != null)
				return false;
		} else if (!isTransit.equals(other.isTransit))
			return false;
		if (isTransitReferal != other.isTransitReferal)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (lastRiskVulnerabilityAssessment == null) {
			if (other.lastRiskVulnerabilityAssessment != null)
				return false;
		} else if (!lastRiskVulnerabilityAssessment.equals(other.lastRiskVulnerabilityAssessment))
			return false;
		if (maritalStatus == null) {
			if (other.maritalStatus != null)
				return false;
		} else if (!maritalStatus.equals(other.maritalStatus))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (monday == null) {
			if (other.monday != null)
				return false;
		} else if (!monday.equals(other.monday))
			return false;
		if (monthlyHouseholdIncome == null) {
			if (other.monthlyHouseholdIncome != null)
				return false;
		} else if (!monthlyHouseholdIncome.equals(other.monthlyHouseholdIncome))
			return false;
		if (nextFollowUpDate == null) {
			if (other.nextFollowUpDate != null)
				return false;
		} else if (!nextFollowUpDate.equals(other.nextFollowUpDate))
			return false;
		if (noOfSexualActivity == null) {
			if (other.noOfSexualActivity != null)
				return false;
		} else if (!noOfSexualActivity.equals(other.noOfSexualActivity))
			return false;
		if (numberOfPartners == null) {
			if (other.numberOfPartners != null)
				return false;
		} else if (!numberOfPartners.equals(other.numberOfPartners))
			return false;
		if (numberOfYearsInSexWork == null) {
			if (other.numberOfYearsInSexWork != null)
				return false;
		} else if (!numberOfYearsInSexWork.equals(other.numberOfYearsInSexWork))
			return false;
		if (occupation == null) {
			if (other.occupation != null)
				return false;
		} else if (!occupation.equals(other.occupation))
			return false;
		if (ostCode == null) {
			if (other.ostCode != null)
				return false;
		} else if (!ostCode.equals(other.ostCode))
			return false;
		if (ostId == null) {
			if (other.ostId != null)
				return false;
		} else if (!ostId.equals(other.ostId))
			return false;
		if (ostInitiated == null) {
			if (other.ostInitiated != null)
				return false;
		} else if (!ostInitiated.equals(other.ostInitiated))
			return false;
		if (ostNumber == null) {
			if (other.ostNumber != null)
				return false;
		} else if (!ostNumber.equals(other.ostNumber))
			return false;
		if (otherDetails == null) {
			if (other.otherDetails != null)
				return false;
		} else if (!otherDetails.equals(other.otherDetails))
			return false;
		if (otherEmploymentStatus == null) {
			if (other.otherEmploymentStatus != null)
				return false;
		} else if (!otherEmploymentStatus.equals(other.otherEmploymentStatus))
			return false;
		if (outsideTheStateNoOfDays == null) {
			if (other.outsideTheStateNoOfDays != null)
				return false;
		} else if (!outsideTheStateNoOfDays.equals(other.outsideTheStateNoOfDays))
			return false;
		if (outsideTheStateNoOfTimes == null) {
			if (other.outsideTheStateNoOfTimes != null)
				return false;
		} else if (!outsideTheStateNoOfTimes.equals(other.outsideTheStateNoOfTimes))
			return false;
		if (pincode == null) {
			if (other.pincode != null)
				return false;
		} else if (!pincode.equals(other.pincode))
			return false;
		if (pregnant == null) {
			if (other.pregnant != null)
				return false;
		} else if (!pregnant.equals(other.pregnant))
			return false;
		if (referralFacility == null) {
			if (other.referralFacility != null)
				return false;
		} else if (!referralFacility.equals(other.referralFacility))
			return false;
		if (referralStatus == null) {
			if (other.referralStatus != null)
				return false;
		} else if (!referralStatus.equals(other.referralStatus))
			return false;
		if (referredFacility == null) {
			if (other.referredFacility != null)
				return false;
		} else if (!referredFacility.equals(other.referredFacility))
			return false;
		if (refferalId == null) {
			if (other.refferalId != null)
				return false;
		} else if (!refferalId.equals(other.refferalId))
			return false;
		if (registrationPlace == null) {
			if (other.registrationPlace != null)
				return false;
		} else if (!registrationPlace.equals(other.registrationPlace))
			return false;
		if (regularPartners == null) {
			if (other.regularPartners != null)
				return false;
		} else if (!regularPartners.equals(other.regularPartners))
			return false;
		if (riskFactorForHiv == null) {
			if (other.riskFactorForHiv != null)
				return false;
		} else if (!riskFactorForHiv.equals(other.riskFactorForHiv))
			return false;
		if (saturday == null) {
			if (other.saturday != null)
				return false;
		} else if (!saturday.equals(other.saturday))
			return false;
		if (screeningId == null) {
			if (other.screeningId != null)
				return false;
		} else if (!screeningId.equals(other.screeningId))
			return false;
		if (screeningStatusHiv == null) {
			if (other.screeningStatusHiv != null)
				return false;
		} else if (!screeningStatusHiv.equals(other.screeningStatusHiv))
			return false;
		if (screeningStatusSyphilis == null) {
			if (other.screeningStatusSyphilis != null)
				return false;
		} else if (!screeningStatusSyphilis.equals(other.screeningStatusSyphilis))
			return false;
		if (sexOtherThanSpouse == null) {
			if (other.sexOtherThanSpouse != null)
				return false;
		} else if (!sexOtherThanSpouse.equals(other.sexOtherThanSpouse))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (stayingWith == null) {
			if (other.stayingWith != null)
				return false;
		} else if (!stayingWith.equals(other.stayingWith))
			return false;
		if (subCategory == null) {
			if (other.subCategory != null)
				return false;
		} else if (!subCategory.equals(other.subCategory))
			return false;
		if (sunday == null) {
			if (other.sunday != null)
				return false;
		} else if (!sunday.equals(other.sunday))
			return false;
		if (tbStatus == null) {
			if (other.tbStatus != null)
				return false;
		} else if (!tbStatus.equals(other.tbStatus))
			return false;
		if (thursday == null) {
			if (other.thursday != null)
				return false;
		} else if (!thursday.equals(other.thursday))
			return false;
		if (tiBeneficiaryReferralDto == null) {
			if (other.tiBeneficiaryReferralDto != null)
				return false;
		} else if (!tiBeneficiaryReferralDto.equals(other.tiBeneficiaryReferralDto))
			return false;
		if (tiCode == null) {
			if (other.tiCode != null)
				return false;
		} else if (!tiCode.equals(other.tiCode))
			return false;
	
		if (tiScreeningDetailDto == null) {
			if (other.tiScreeningDetailDto != null)
				return false;
		} else if (!tiScreeningDetailDto.equals(other.tiScreeningDetailDto))
			return false;
		if (transferDate == null) {
			if (other.transferDate != null)
				return false;
		} else if (!transferDate.equals(other.transferDate))
			return false;
		if (transferFrom == null) {
			if (other.transferFrom != null)
				return false;
		} else if (!transferFrom.equals(other.transferFrom))
			return false;
		if (transferStatus == null) {
			if (other.transferStatus != null)
				return false;
		} else if (!transferStatus.equals(other.transferStatus))
			return false;
		if (transferTo == null) {
			if (other.transferTo != null)
				return false;
		} else if (!transferTo.equals(other.transferTo))
			return false;
		if (transitEndDate == null) {
			if (other.transitEndDate != null)
				return false;
		} else if (!transitEndDate.equals(other.transitEndDate))
			return false;
		if (transitStartDate == null) {
			if (other.transitStartDate != null)
				return false;
		} else if (!transitStartDate.equals(other.transitStartDate))
			return false;
		if (tuesday == null) {
			if (other.tuesday != null)
				return false;
		} else if (!tuesday.equals(other.tuesday))
			return false;
		if (typeOfMobility == null) {
			if (other.typeOfMobility != null)
				return false;
		} else if (!typeOfMobility.equals(other.typeOfMobility))
			return false;
		if (uidNumber == null) {
			if (other.uidNumber != null)
				return false;
		} else if (!uidNumber.equals(other.uidNumber))
			return false;
		if (userFacilityId == null) {
			if (other.userFacilityId != null)
				return false;
		} else if (!userFacilityId.equals(other.userFacilityId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (viewPastActivity == null) {
			if (other.viewPastActivity != null)
				return false;
		} else if (!viewPastActivity.equals(other.viewPastActivity))
			return false;
		if (wednesday == null) {
			if (other.wednesday != null)
				return false;
		} else if (!wednesday.equals(other.wednesday))
			return false;
		if (withinTheDistrictNoOfDays == null) {
			if (other.withinTheDistrictNoOfDays != null)
				return false;
		} else if (!withinTheDistrictNoOfDays.equals(other.withinTheDistrictNoOfDays))
			return false;
		if (withinTheDistrictNoOfTimes == null) {
			if (other.withinTheDistrictNoOfTimes != null)
				return false;
		} else if (!withinTheDistrictNoOfTimes.equals(other.withinTheDistrictNoOfTimes))
			return false;
		if (withinTheStateNoOfDays == null) {
			if (other.withinTheStateNoOfDays != null)
				return false;
		} else if (!withinTheStateNoOfDays.equals(other.withinTheStateNoOfDays))
			return false;
		if (withinTheStateNoOfTimes == null) {
			if (other.withinTheStateNoOfTimes != null)
				return false;
		} else if (!withinTheStateNoOfTimes.equals(other.withinTheStateNoOfTimes))
			return false;
		return true;
	}

}
