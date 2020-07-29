package gov.naco.soch.dto;

import java.time.LocalDate;

//DTO class used for transfer data between front end and back end.
public class BeneficiaryAssesmentDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	// DTO class properties

	private Long artPatientAssesmentid;
	private Integer familyMemberAge;
	private String familyMemberAlive;
	private String caregiversAddressPhoneNo;
	private String caregiversName;
	private String familyMembersUid;
	private String hivCareOrArtNo;
	private String hivCareRegistrationNo;
	private String familyMemberHivStatus;
	private String idusSubstitutionTherapy;
	private String lacLacplusRegistrationNo;
	private String nameOfLacLacplus;
	private String nameOfPreviousClinic;
	private String onArtTransferred;
	private String relationToPatient;
	private String familyMembersex;
	private LocalDate transferredInDate;
	private String treatmentStatus;
	private Boolean isActive;
	private Boolean isDelete;

	private Long artBeneficaryDetailId;
	private Long beneficiaryId;
	private String category;
	private Long beneficiaryQueueId;
	private String artNumber;
	private String artCentreAddress;
	private String artCentreCode;
	private LocalDate artStartDate;
	private String onArt;

	private Integer artPatientAssessmentDetailId;
	private String optOut;
	private Integer ageOfStoppingBreastfed;
	private String alcoholUsage;
	private String beneficiaryAccountName;
	private Integer beneficiaryAccountNumber;
	private String beneficiaryBankDetails;
	private String birthHistory;
	private String birthWeight;
	private String cancelledChequeOrPassbook;
	private Boolean condomsGiven;
	private String contraception;
	private String counsellingNotes;
	private LocalDate cptInitiatedDate;
	private String currentMedication;
	private LocalDate dateOfCareSupportServices;
	private LocalDate dateOfLinkingWithLac;
	private LocalDate dateOfNextVisitDue;
	private String deliveryOutcome;
	private String detailsOfOtherAilments;
	private String died;
	private String drugAllergy;
	private String guardianAge;
	private String guardianOrCaregiver;
	private String guardianSex;
	private String guardiansOrCaregiversEducation;
	private Boolean hbv;
	private String hbvStatus;
	private Boolean hcv;
	private String hcvStatus;
	private String infantFeeding;
	private String lastMenstrualPeriod;
	private String lostToFollowUp;
	private String milestonesAchievedPerAge;
	private String nameOfCareSupportInstitute;
	private String neonatalComplications;
	private LocalDate nextVisitDate;
	private String obstetricHistory;
	private Boolean onMedicalAdvice;
	private String otherAilments;
	private String otherCoexistingConditions;
	private String otherRemarks;
	private String papSmear;
	private Boolean pregnancy;
	private Boolean pregnantNow;
	private String purposesOfCareSupportServices;
	private Boolean referredToPptct;
	private String remarks;
	private String smokingUsage;
	private String stayingWith;
	private Boolean tbTreatment;
	private String tobaccoUsage;
	private LocalDate lastVisitCorrespondingDate;
	private LocalDate optOutCorrespondingDate;
	private LocalDate diedCorrespondingDate;
	private LocalDate onMedicalAdviceCorrespondingDate;
	private String employmentStatus;

	private Long roleId;
	private Long userId;

	private Long beneficiaryRegisterid;
	private String beneficiaryAge;
	private Long familyId;
	private String entryPoint;
	private LocalDate dateOfBirth;
	private String educationLevel;
	private String occupation;
	private String firstName;
	private String lastName;
	private String gender;
	private String maritalStatus;
	private String mobileNumber;
	private String uidNumber;

	private String address;
	private String city;
	private String taluk;
	private Long stateId;
	private Long districtId;

	private String monthlyHouseholdIncome;
	private String riskFactorForHiv;

	private Integer artDnaPcrResultId;
	private String firstDbs;
	private String fourthAntibodyTest;
	private String secondDbs;
	private String thirdWbb;

	private Integer artImmunizationRecordId;
	private LocalDate ageBirth;
	private String ageBirthvaccine;
	private LocalDate ageBirthdue;
	private LocalDate ageBirthgiven;
	private LocalDate fifteenSixteenYears;
	private String fifteenSixteenYearsvaccine;
	private LocalDate fifteenSixteenYearsdue;
	private LocalDate fifteenSixteenYearsgiven;
	private LocalDate fiveYears;
	private String fiveYearsvaccine;
	private LocalDate fiveYearsdue;
	private LocalDate fiveYearsgiven;
	private LocalDate fourteenWeeks;
	private String fourteenWeeksvaccine;
	private LocalDate fourteenWeeksdue;
	private LocalDate fourteenWeeksgiven;
	private LocalDate sixWeeks;
	private String sixWeeksvaccine;
	private LocalDate sixWeeksdue;
	private LocalDate sixWeeksgiven;
	private LocalDate sixteenToTwentyfourMonths;
	private String sixteenToTwentyfourMonthsvaccine;
	private LocalDate sixteenToTwentyfourMonthsdue;
	private LocalDate sixteenToTwentyfourMonthsgiven;
	private LocalDate tenWeeks;
	private String tenWeeksvaccine;
	private LocalDate tenWeeksdue;
	private LocalDate tenWeeksgiven;
	private LocalDate tenYears;
	private String tenYearsvaccine;
	private LocalDate tenYearsdue;
	private LocalDate tenYearsgiven;
	private LocalDate threeMonths;
	private String threeMonthsvaccine;
	private LocalDate threeMonthsdue;
	private LocalDate threeMonthsgiven;

	private Integer artVitaminARecordId;
	private Boolean eighteenMonths;
	private LocalDate eighteenMonthsDate;
	private Boolean fiftyfourMonths;
	private LocalDate fiftyfourMonthsDate;
	private Boolean fortyeightMonths;
	private LocalDate fortyeightMonthsDate;
	private Boolean fortytwoMonths;
	private LocalDate fortytwoMonthsDate;
	private Boolean nineMonths;
	private LocalDate nineMonthsDate;
	private Boolean sixtyMonths;
	private LocalDate sixtyMonthsDate;
	private Boolean thirtyMonths;
	private LocalDate thirtyMonthsDate;
	private Boolean thirtysixMonths;
	private LocalDate thirtysixMonthsDate;
	private Boolean twentyfourMonths;
	private LocalDate twentyfourMonthsDate;

	public Long getArtPatientAssesmentid() {
		return artPatientAssesmentid;
	}

	public void setArtPatientAssesmentid(Long artPatientAssesmentid) {
		this.artPatientAssesmentid = artPatientAssesmentid;
	}

	public Integer getFamilyMemberAge() {
		return familyMemberAge;
	}

	public void setFamilyMemberAge(Integer familyMemberAge) {
		this.familyMemberAge = familyMemberAge;
	}

	public String getFamilyMemberAlive() {
		return familyMemberAlive;
	}

	public void setFamilyMemberAlive(String familyMemberAlive) {
		this.familyMemberAlive = familyMemberAlive;
	}

	public String getCaregiversAddressPhoneNo() {
		return caregiversAddressPhoneNo;
	}

	public void setCaregiversAddressPhoneNo(String caregiversAddressPhoneNo) {
		this.caregiversAddressPhoneNo = caregiversAddressPhoneNo;
	}

	public String getCaregiversName() {
		return caregiversName;
	}

	public void setCaregiversName(String caregiversName) {
		this.caregiversName = caregiversName;
	}

	public String getFamilyMembersUid() {
		return familyMembersUid;
	}

	public void setFamilyMembersUid(String familyMembersUid) {
		this.familyMembersUid = familyMembersUid;
	}

	public String getHivCareOrArtNo() {
		return hivCareOrArtNo;
	}

	public void setHivCareOrArtNo(String hivCareOrArtNo) {
		this.hivCareOrArtNo = hivCareOrArtNo;
	}

	public String getHivCareRegistrationNo() {
		return hivCareRegistrationNo;
	}

	public void setHivCareRegistrationNo(String hivCareRegistrationNo) {
		this.hivCareRegistrationNo = hivCareRegistrationNo;
	}

	public String getFamilyMemberHivStatus() {
		return familyMemberHivStatus;
	}

	public void setFamilyMemberHivStatus(String familyMemberHivStatus) {
		this.familyMemberHivStatus = familyMemberHivStatus;
	}

	public String getIdusSubstitutionTherapy() {
		return idusSubstitutionTherapy;
	}

	public void setIdusSubstitutionTherapy(String idusSubstitutionTherapy) {
		this.idusSubstitutionTherapy = idusSubstitutionTherapy;
	}

	public String getLacLacplusRegistrationNo() {
		return lacLacplusRegistrationNo;
	}

	public void setLacLacplusRegistrationNo(String lacLacplusRegistrationNo) {
		this.lacLacplusRegistrationNo = lacLacplusRegistrationNo;
	}

	public String getNameOfLacLacplus() {
		return nameOfLacLacplus;
	}

	public void setNameOfLacLacplus(String nameOfLacLacplus) {
		this.nameOfLacLacplus = nameOfLacLacplus;
	}

	public String getNameOfPreviousClinic() {
		return nameOfPreviousClinic;
	}

	public void setNameOfPreviousClinic(String nameOfPreviousClinic) {
		this.nameOfPreviousClinic = nameOfPreviousClinic;
	}

	public String getOnArtTransferred() {
		return onArtTransferred;
	}

	public void setOnArtTransferred(String onArtTransferred) {
		this.onArtTransferred = onArtTransferred;
	}

	public String getRelationToPatient() {
		return relationToPatient;
	}

	public void setRelationToPatient(String relationToPatient) {
		this.relationToPatient = relationToPatient;
	}

	public String getFamilyMembersex() {
		return familyMembersex;
	}

	public void setFamilyMembersex(String familyMembersex) {
		this.familyMembersex = familyMembersex;
	}

	public LocalDate getTransferredInDate() {
		return transferredInDate;
	}

	public void setTransferredInDate(LocalDate transferredInDate) {
		this.transferredInDate = transferredInDate;
	}

	public String getTreatmentStatus() {
		return treatmentStatus;
	}

	public void setTreatmentStatus(String treatmentStatus) {
		this.treatmentStatus = treatmentStatus;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Long getArtBeneficaryDetailId() {
		return artBeneficaryDetailId;
	}

	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public void setArtBeneficaryDetailId(Long artBeneficaryDetailId) {
		this.artBeneficaryDetailId = artBeneficaryDetailId;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getBeneficiaryQueueId() {
		return beneficiaryQueueId;
	}

	public void setBeneficiaryQueueId(Long beneficiaryQueueId) {
		this.beneficiaryQueueId = beneficiaryQueueId;
	}

	public String getArtNumber() {
		return artNumber;
	}

	public void setArtNumber(String artNumber) {
		this.artNumber = artNumber;
	}

	public String getArtCentreAddress() {
		return artCentreAddress;
	}

	public void setArtCentreAddress(String artCentreAddress) {
		this.artCentreAddress = artCentreAddress;
	}

	public String getArtCentreCode() {
		return artCentreCode;
	}

	public void setArtCentreCode(String artCentreCode) {
		this.artCentreCode = artCentreCode;
	}

	public LocalDate getArtStartDate() {
		return artStartDate;
	}

	public void setArtStartDate(LocalDate artStartDate) {
		this.artStartDate = artStartDate;
	}

	public String getOnArt() {
		return onArt;
	}

	public void setOnArt(String onArt) {
		this.onArt = onArt;
	}

	public Integer getArtPatientAssessmentDetailId() {
		return artPatientAssessmentDetailId;
	}

	public void setArtPatientAssessmentDetailId(Integer artPatientAssessmentDetailId) {
		this.artPatientAssessmentDetailId = artPatientAssessmentDetailId;
	}

	public String getOptOut() {
		return optOut;
	}

	public void setOptOut(String optOut) {
		this.optOut = optOut;
	}

	public Integer getAgeOfStoppingBreastfed() {
		return ageOfStoppingBreastfed;
	}

	public void setAgeOfStoppingBreastfed(Integer ageOfStoppingBreastfed) {
		this.ageOfStoppingBreastfed = ageOfStoppingBreastfed;
	}

	public String getAlcoholUsage() {
		return alcoholUsage;
	}

	public void setAlcoholUsage(String alcoholUsage) {
		this.alcoholUsage = alcoholUsage;
	}

	public String getBeneficiaryAccountName() {
		return beneficiaryAccountName;
	}

	public void setBeneficiaryAccountName(String beneficiaryAccountName) {
		this.beneficiaryAccountName = beneficiaryAccountName;
	}

	public Integer getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}

	public void setBeneficiaryAccountNumber(Integer beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	public String getBeneficiaryBankDetails() {
		return beneficiaryBankDetails;
	}

	public void setBeneficiaryBankDetails(String beneficiaryBankDetails) {
		this.beneficiaryBankDetails = beneficiaryBankDetails;
	}

	public String getBirthHistory() {
		return birthHistory;
	}

	public void setBirthHistory(String birthHistory) {
		this.birthHistory = birthHistory;
	}

	public String getBirthWeight() {
		return birthWeight;
	}

	public void setBirthWeight(String birthWeight) {
		this.birthWeight = birthWeight;
	}

	public String getCancelledChequeOrPassbook() {
		return cancelledChequeOrPassbook;
	}

	public void setCancelledChequeOrPassbook(String cancelledChequeOrPassbook) {
		this.cancelledChequeOrPassbook = cancelledChequeOrPassbook;
	}

	public Boolean getCondomsGiven() {
		return condomsGiven;
	}

	public void setCondomsGiven(Boolean condomsGiven) {
		this.condomsGiven = condomsGiven;
	}

	public String getContraception() {
		return contraception;
	}

	public void setContraception(String contraception) {
		this.contraception = contraception;
	}

	public String getCounsellingNotes() {
		return counsellingNotes;
	}

	public void setCounsellingNotes(String counsellingNotes) {
		this.counsellingNotes = counsellingNotes;
	}

	public LocalDate getCptInitiatedDate() {
		return cptInitiatedDate;
	}

	public void setCptInitiatedDate(LocalDate cptInitiatedDate) {
		this.cptInitiatedDate = cptInitiatedDate;
	}

	public String getCurrentMedication() {
		return currentMedication;
	}

	public void setCurrentMedication(String currentMedication) {
		this.currentMedication = currentMedication;
	}

	public LocalDate getDateOfCareSupportServices() {
		return dateOfCareSupportServices;
	}

	public void setDateOfCareSupportServices(LocalDate dateOfCareSupportServices) {
		this.dateOfCareSupportServices = dateOfCareSupportServices;
	}

	public LocalDate getDateOfLinkingWithLac() {
		return dateOfLinkingWithLac;
	}

	public void setDateOfLinkingWithLac(LocalDate dateOfLinkingWithLac) {
		this.dateOfLinkingWithLac = dateOfLinkingWithLac;
	}

	public LocalDate getDateOfNextVisitDue() {
		return dateOfNextVisitDue;
	}

	public void setDateOfNextVisitDue(LocalDate dateOfNextVisitDue) {
		this.dateOfNextVisitDue = dateOfNextVisitDue;
	}

	public String getDeliveryOutcome() {
		return deliveryOutcome;
	}

	public void setDeliveryOutcome(String deliveryOutcome) {
		this.deliveryOutcome = deliveryOutcome;
	}

	public String getDetailsOfOtherAilments() {
		return detailsOfOtherAilments;
	}

	public void setDetailsOfOtherAilments(String detailsOfOtherAilments) {
		this.detailsOfOtherAilments = detailsOfOtherAilments;
	}

	public String getDied() {
		return died;
	}

	public void setDied(String died) {
		this.died = died;
	}

	public String getDrugAllergy() {
		return drugAllergy;
	}

	public void setDrugAllergy(String drugAllergy) {
		this.drugAllergy = drugAllergy;
	}

	public String getGuardianAge() {
		return guardianAge;
	}

	public void setGuardianAge(String guardianAge) {
		this.guardianAge = guardianAge;
	}

	public String getGuardianOrCaregiver() {
		return guardianOrCaregiver;
	}

	public void setGuardianOrCaregiver(String guardianOrCaregiver) {
		this.guardianOrCaregiver = guardianOrCaregiver;
	}

	public String getGuardianSex() {
		return guardianSex;
	}

	public void setGuardianSex(String guardianSex) {
		this.guardianSex = guardianSex;
	}

	public String getGuardiansOrCaregiversEducation() {
		return guardiansOrCaregiversEducation;
	}

	public void setGuardiansOrCaregiversEducation(String guardiansOrCaregiversEducation) {
		this.guardiansOrCaregiversEducation = guardiansOrCaregiversEducation;
	}

	public Boolean getHbv() {
		return hbv;
	}

	public void setHbv(Boolean hbv) {
		this.hbv = hbv;
	}

	public String getHbvStatus() {
		return hbvStatus;
	}

	public void setHbvStatus(String hbvStatus) {
		this.hbvStatus = hbvStatus;
	}

	public Boolean getHcv() {
		return hcv;
	}

	public void setHcv(Boolean hcv) {
		this.hcv = hcv;
	}

	public String getHcvStatus() {
		return hcvStatus;
	}

	public void setHcvStatus(String hcvStatus) {
		this.hcvStatus = hcvStatus;
	}

	public String getInfantFeeding() {
		return infantFeeding;
	}

	public void setInfantFeeding(String infantFeeding) {
		this.infantFeeding = infantFeeding;
	}

	public String getLastMenstrualPeriod() {
		return lastMenstrualPeriod;
	}

	public void setLastMenstrualPeriod(String lastMenstrualPeriod) {
		this.lastMenstrualPeriod = lastMenstrualPeriod;
	}

	public String getLostToFollowUp() {
		return lostToFollowUp;
	}

	public void setLostToFollowUp(String lostToFollowUp) {
		this.lostToFollowUp = lostToFollowUp;
	}

	public String getMilestonesAchievedPerAge() {
		return milestonesAchievedPerAge;
	}

	public void setMilestonesAchievedPerAge(String milestonesAchievedPerAge) {
		this.milestonesAchievedPerAge = milestonesAchievedPerAge;
	}

	public String getNameOfCareSupportInstitute() {
		return nameOfCareSupportInstitute;
	}

	public void setNameOfCareSupportInstitute(String nameOfCareSupportInstitute) {
		this.nameOfCareSupportInstitute = nameOfCareSupportInstitute;
	}

	public String getNeonatalComplications() {
		return neonatalComplications;
	}

	public void setNeonatalComplications(String neonatalComplications) {
		this.neonatalComplications = neonatalComplications;
	}

	public LocalDate getNextVisitDate() {
		return nextVisitDate;
	}

	public void setNextVisitDate(LocalDate nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}

	public String getObstetricHistory() {
		return obstetricHistory;
	}

	public void setObstetricHistory(String obstetricHistory) {
		this.obstetricHistory = obstetricHistory;
	}

	public Boolean getOnMedicalAdvice() {
		return onMedicalAdvice;
	}

	public void setOnMedicalAdvice(Boolean onMedicalAdvice) {
		this.onMedicalAdvice = onMedicalAdvice;
	}

	public String getOtherAilments() {
		return otherAilments;
	}

	public void setOtherAilments(String otherAilments) {
		this.otherAilments = otherAilments;
	}

	public String getOtherCoexistingConditions() {
		return otherCoexistingConditions;
	}

	public void setOtherCoexistingConditions(String otherCoexistingConditions) {
		this.otherCoexistingConditions = otherCoexistingConditions;
	}

	public String getOtherRemarks() {
		return otherRemarks;
	}

	public void setOtherRemarks(String otherRemarks) {
		this.otherRemarks = otherRemarks;
	}

	public String getPapSmear() {
		return papSmear;
	}

	public void setPapSmear(String papSmear) {
		this.papSmear = papSmear;
	}

	public Boolean getPregnancy() {
		return pregnancy;
	}

	public void setPregnancy(Boolean pregnancy) {
		this.pregnancy = pregnancy;
	}

	public Boolean getPregnantNow() {
		return pregnantNow;
	}

	public void setPregnantNow(Boolean pregnantNow) {
		this.pregnantNow = pregnantNow;
	}

	public String getPurposesOfCareSupportServices() {
		return purposesOfCareSupportServices;
	}

	public void setPurposesOfCareSupportServices(String purposesOfCareSupportServices) {
		this.purposesOfCareSupportServices = purposesOfCareSupportServices;
	}

	public Boolean getReferredToPptct() {
		return referredToPptct;
	}

	public void setReferredToPptct(Boolean referredToPptct) {
		this.referredToPptct = referredToPptct;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSmokingUsage() {
		return smokingUsage;
	}

	public void setSmokingUsage(String smokingUsage) {
		this.smokingUsage = smokingUsage;
	}

	public String getStayingWith() {
		return stayingWith;
	}

	public void setStayingWith(String stayingWith) {
		this.stayingWith = stayingWith;
	}

	public Boolean getTbTreatment() {
		return tbTreatment;
	}

	public void setTbTreatment(Boolean tbTreatment) {
		this.tbTreatment = tbTreatment;
	}

	public String getTobaccoUsage() {
		return tobaccoUsage;
	}

	public void setTobaccoUsage(String tobaccoUsage) {
		this.tobaccoUsage = tobaccoUsage;
	}

	public LocalDate getLastVisitCorrespondingDate() {
		return lastVisitCorrespondingDate;
	}

	public void setLastVisitCorrespondingDate(LocalDate lastVisitCorrespondingDate) {
		this.lastVisitCorrespondingDate = lastVisitCorrespondingDate;
	}

	public LocalDate getOptOutCorrespondingDate() {
		return optOutCorrespondingDate;
	}

	public void setOptOutCorrespondingDate(LocalDate optOutCorrespondingDate) {
		this.optOutCorrespondingDate = optOutCorrespondingDate;
	}

	public LocalDate getDiedCorrespondingDate() {
		return diedCorrespondingDate;
	}

	public void setDiedCorrespondingDate(LocalDate diedCorrespondingDate) {
		this.diedCorrespondingDate = diedCorrespondingDate;
	}

	public LocalDate getOnMedicalAdviceCorrespondingDate() {
		return onMedicalAdviceCorrespondingDate;
	}

	public void setOnMedicalAdviceCorrespondingDate(LocalDate onMedicalAdviceCorrespondingDate) {
		this.onMedicalAdviceCorrespondingDate = onMedicalAdviceCorrespondingDate;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBeneficiaryRegisterid() {
		return beneficiaryRegisterid;
	}

	public void setBeneficiaryRegisterid(Long beneficiaryRegisterid) {
		this.beneficiaryRegisterid = beneficiaryRegisterid;
	}

	public String getBeneficiaryAge() {
		return beneficiaryAge;
	}

	public void setBeneficiaryAge(String beneficiaryAge) {
		this.beneficiaryAge = beneficiaryAge;
	}

	public Long getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

	public String getEntryPoint() {
		return entryPoint;
	}

	public void setEntryPoint(String entryPoint) {
		this.entryPoint = entryPoint;
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

	
	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
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

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUidNumber() {
		return uidNumber;
	}

	public void setUidNumber(String uidNumber) {
		this.uidNumber = uidNumber;
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

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public String getMonthlyHouseholdIncome() {
		return monthlyHouseholdIncome;
	}

	public void setMonthlyHouseholdIncome(String monthlyHouseholdIncome) {
		this.monthlyHouseholdIncome = monthlyHouseholdIncome;
	}

	public String getRiskFactorForHiv() {
		return riskFactorForHiv;
	}

	public void setRiskFactorForHiv(String riskFactorForHiv) {
		this.riskFactorForHiv = riskFactorForHiv;
	}

	public Integer getArtDnaPcrResultId() {
		return artDnaPcrResultId;
	}

	public void setArtDnaPcrResultId(Integer artDnaPcrResultId) {
		this.artDnaPcrResultId = artDnaPcrResultId;
	}

	public String getFirstDbs() {
		return firstDbs;
	}

	public void setFirstDbs(String firstDbs) {
		this.firstDbs = firstDbs;
	}

	public String getFourthAntibodyTest() {
		return fourthAntibodyTest;
	}

	public void setFourthAntibodyTest(String fourthAntibodyTest) {
		this.fourthAntibodyTest = fourthAntibodyTest;
	}

	public String getSecondDbs() {
		return secondDbs;
	}

	public void setSecondDbs(String secondDbs) {
		this.secondDbs = secondDbs;
	}

	public String getThirdWbb() {
		return thirdWbb;
	}

	public void setThirdWbb(String thirdWbb) {
		this.thirdWbb = thirdWbb;
	}

	public Integer getArtImmunizationRecordId() {
		return artImmunizationRecordId;
	}

	public void setArtImmunizationRecordId(Integer artImmunizationRecordId) {
		this.artImmunizationRecordId = artImmunizationRecordId;
	}

	public LocalDate getAgeBirth() {
		return ageBirth;
	}

	public void setAgeBirth(LocalDate ageBirth) {
		this.ageBirth = ageBirth;
	}

	public String getAgeBirthvaccine() {
		return ageBirthvaccine;
	}

	public void setAgeBirthvaccine(String ageBirthvaccine) {
		this.ageBirthvaccine = ageBirthvaccine;
	}

	public LocalDate getAgeBirthdue() {
		return ageBirthdue;
	}

	public void setAgeBirthdue(LocalDate ageBirthdue) {
		this.ageBirthdue = ageBirthdue;
	}

	public LocalDate getAgeBirthgiven() {
		return ageBirthgiven;
	}

	public void setAgeBirthgiven(LocalDate ageBirthgiven) {
		this.ageBirthgiven = ageBirthgiven;
	}

	public LocalDate getFifteenSixteenYears() {
		return fifteenSixteenYears;
	}

	public void setFifteenSixteenYears(LocalDate fifteenSixteenYears) {
		this.fifteenSixteenYears = fifteenSixteenYears;
	}

	public String getFifteenSixteenYearsvaccine() {
		return fifteenSixteenYearsvaccine;
	}

	public void setFifteenSixteenYearsvaccine(String fifteenSixteenYearsvaccine) {
		this.fifteenSixteenYearsvaccine = fifteenSixteenYearsvaccine;
	}

	public LocalDate getFifteenSixteenYearsdue() {
		return fifteenSixteenYearsdue;
	}

	public void setFifteenSixteenYearsdue(LocalDate fifteenSixteenYearsdue) {
		this.fifteenSixteenYearsdue = fifteenSixteenYearsdue;
	}

	public LocalDate getFifteenSixteenYearsgiven() {
		return fifteenSixteenYearsgiven;
	}

	public void setFifteenSixteenYearsgiven(LocalDate fifteenSixteenYearsgiven) {
		this.fifteenSixteenYearsgiven = fifteenSixteenYearsgiven;
	}

	public LocalDate getFiveYears() {
		return fiveYears;
	}

	public void setFiveYears(LocalDate fiveYears) {
		this.fiveYears = fiveYears;
	}

	public String getFiveYearsvaccine() {
		return fiveYearsvaccine;
	}

	public void setFiveYearsvaccine(String fiveYearsvaccine) {
		this.fiveYearsvaccine = fiveYearsvaccine;
	}

	public LocalDate getFiveYearsdue() {
		return fiveYearsdue;
	}

	public void setFiveYearsdue(LocalDate fiveYearsdue) {
		this.fiveYearsdue = fiveYearsdue;
	}

	public LocalDate getFiveYearsgiven() {
		return fiveYearsgiven;
	}

	public void setFiveYearsgiven(LocalDate fiveYearsgiven) {
		this.fiveYearsgiven = fiveYearsgiven;
	}

	public LocalDate getFourteenWeeks() {
		return fourteenWeeks;
	}

	public void setFourteenWeeks(LocalDate fourteenWeeks) {
		this.fourteenWeeks = fourteenWeeks;
	}

	public String getFourteenWeeksvaccine() {
		return fourteenWeeksvaccine;
	}

	public void setFourteenWeeksvaccine(String fourteenWeeksvaccine) {
		this.fourteenWeeksvaccine = fourteenWeeksvaccine;
	}

	public LocalDate getFourteenWeeksdue() {
		return fourteenWeeksdue;
	}

	public void setFourteenWeeksdue(LocalDate fourteenWeeksdue) {
		this.fourteenWeeksdue = fourteenWeeksdue;
	}

	public LocalDate getFourteenWeeksgiven() {
		return fourteenWeeksgiven;
	}

	public void setFourteenWeeksgiven(LocalDate fourteenWeeksgiven) {
		this.fourteenWeeksgiven = fourteenWeeksgiven;
	}

	public LocalDate getSixWeeks() {
		return sixWeeks;
	}

	public void setSixWeeks(LocalDate sixWeeks) {
		this.sixWeeks = sixWeeks;
	}

	public String getSixWeeksvaccine() {
		return sixWeeksvaccine;
	}

	public void setSixWeeksvaccine(String sixWeeksvaccine) {
		this.sixWeeksvaccine = sixWeeksvaccine;
	}

	public LocalDate getSixWeeksdue() {
		return sixWeeksdue;
	}

	public void setSixWeeksdue(LocalDate sixWeeksdue) {
		this.sixWeeksdue = sixWeeksdue;
	}

	public LocalDate getSixWeeksgiven() {
		return sixWeeksgiven;
	}

	public void setSixWeeksgiven(LocalDate sixWeeksgiven) {
		this.sixWeeksgiven = sixWeeksgiven;
	}

	public LocalDate getSixteenToTwentyfourMonths() {
		return sixteenToTwentyfourMonths;
	}

	public void setSixteenToTwentyfourMonths(LocalDate sixteenToTwentyfourMonths) {
		this.sixteenToTwentyfourMonths = sixteenToTwentyfourMonths;
	}

	public String getSixteenToTwentyfourMonthsvaccine() {
		return sixteenToTwentyfourMonthsvaccine;
	}

	public void setSixteenToTwentyfourMonthsvaccine(String sixteenToTwentyfourMonthsvaccine) {
		this.sixteenToTwentyfourMonthsvaccine = sixteenToTwentyfourMonthsvaccine;
	}

	public LocalDate getSixteenToTwentyfourMonthsdue() {
		return sixteenToTwentyfourMonthsdue;
	}

	public void setSixteenToTwentyfourMonthsdue(LocalDate sixteenToTwentyfourMonthsdue) {
		this.sixteenToTwentyfourMonthsdue = sixteenToTwentyfourMonthsdue;
	}

	public LocalDate getSixteenToTwentyfourMonthsgiven() {
		return sixteenToTwentyfourMonthsgiven;
	}

	public void setSixteenToTwentyfourMonthsgiven(LocalDate sixteenToTwentyfourMonthsgiven) {
		this.sixteenToTwentyfourMonthsgiven = sixteenToTwentyfourMonthsgiven;
	}

	public LocalDate getTenWeeks() {
		return tenWeeks;
	}

	public void setTenWeeks(LocalDate tenWeeks) {
		this.tenWeeks = tenWeeks;
	}

	public String getTenWeeksvaccine() {
		return tenWeeksvaccine;
	}

	public void setTenWeeksvaccine(String tenWeeksvaccine) {
		this.tenWeeksvaccine = tenWeeksvaccine;
	}

	public LocalDate getTenWeeksdue() {
		return tenWeeksdue;
	}

	public void setTenWeeksdue(LocalDate tenWeeksdue) {
		this.tenWeeksdue = tenWeeksdue;
	}

	public LocalDate getTenWeeksgiven() {
		return tenWeeksgiven;
	}

	public void setTenWeeksgiven(LocalDate tenWeeksgiven) {
		this.tenWeeksgiven = tenWeeksgiven;
	}

	public LocalDate getTenYears() {
		return tenYears;
	}

	public void setTenYears(LocalDate tenYears) {
		this.tenYears = tenYears;
	}

	public String getTenYearsvaccine() {
		return tenYearsvaccine;
	}

	public void setTenYearsvaccine(String tenYearsvaccine) {
		this.tenYearsvaccine = tenYearsvaccine;
	}

	public LocalDate getTenYearsdue() {
		return tenYearsdue;
	}

	public void setTenYearsdue(LocalDate tenYearsdue) {
		this.tenYearsdue = tenYearsdue;
	}

	public LocalDate getTenYearsgiven() {
		return tenYearsgiven;
	}

	public void setTenYearsgiven(LocalDate tenYearsgiven) {
		this.tenYearsgiven = tenYearsgiven;
	}

	public LocalDate getThreeMonths() {
		return threeMonths;
	}

	public void setThreeMonths(LocalDate threeMonths) {
		this.threeMonths = threeMonths;
	}

	public String getThreeMonthsvaccine() {
		return threeMonthsvaccine;
	}

	public void setThreeMonthsvaccine(String threeMonthsvaccine) {
		this.threeMonthsvaccine = threeMonthsvaccine;
	}

	public LocalDate getThreeMonthsdue() {
		return threeMonthsdue;
	}

	public void setThreeMonthsdue(LocalDate threeMonthsdue) {
		this.threeMonthsdue = threeMonthsdue;
	}

	public LocalDate getThreeMonthsgiven() {
		return threeMonthsgiven;
	}

	public void setThreeMonthsgiven(LocalDate threeMonthsgiven) {
		this.threeMonthsgiven = threeMonthsgiven;
	}

	public Integer getArtVitaminARecordId() {
		return artVitaminARecordId;
	}

	public void setArtVitaminARecordId(Integer artVitaminARecordId) {
		this.artVitaminARecordId = artVitaminARecordId;
	}

	public Boolean getEighteenMonths() {
		return eighteenMonths;
	}

	public void setEighteenMonths(Boolean eighteenMonths) {
		this.eighteenMonths = eighteenMonths;
	}

	public LocalDate getEighteenMonthsDate() {
		return eighteenMonthsDate;
	}

	public void setEighteenMonthsDate(LocalDate eighteenMonthsDate) {
		this.eighteenMonthsDate = eighteenMonthsDate;
	}

	public Boolean getFiftyfourMonths() {
		return fiftyfourMonths;
	}

	public void setFiftyfourMonths(Boolean fiftyfourMonths) {
		this.fiftyfourMonths = fiftyfourMonths;
	}

	public LocalDate getFiftyfourMonthsDate() {
		return fiftyfourMonthsDate;
	}

	public void setFiftyfourMonthsDate(LocalDate fiftyfourMonthsDate) {
		this.fiftyfourMonthsDate = fiftyfourMonthsDate;
	}

	public Boolean getFortyeightMonths() {
		return fortyeightMonths;
	}

	public void setFortyeightMonths(Boolean fortyeightMonths) {
		this.fortyeightMonths = fortyeightMonths;
	}

	public LocalDate getFortyeightMonthsDate() {
		return fortyeightMonthsDate;
	}

	public void setFortyeightMonthsDate(LocalDate fortyeightMonthsDate) {
		this.fortyeightMonthsDate = fortyeightMonthsDate;
	}

	public Boolean getFortytwoMonths() {
		return fortytwoMonths;
	}

	public void setFortytwoMonths(Boolean fortytwoMonths) {
		this.fortytwoMonths = fortytwoMonths;
	}

	public LocalDate getFortytwoMonthsDate() {
		return fortytwoMonthsDate;
	}

	public void setFortytwoMonthsDate(LocalDate fortytwoMonthsDate) {
		this.fortytwoMonthsDate = fortytwoMonthsDate;
	}

	public Boolean getNineMonths() {
		return nineMonths;
	}

	public void setNineMonths(Boolean nineMonths) {
		this.nineMonths = nineMonths;
	}

	public LocalDate getNineMonthsDate() {
		return nineMonthsDate;
	}

	public void setNineMonthsDate(LocalDate nineMonthsDate) {
		this.nineMonthsDate = nineMonthsDate;
	}

	public Boolean getSixtyMonths() {
		return sixtyMonths;
	}

	public void setSixtyMonths(Boolean sixtyMonths) {
		this.sixtyMonths = sixtyMonths;
	}

	public LocalDate getSixtyMonthsDate() {
		return sixtyMonthsDate;
	}

	public void setSixtyMonthsDate(LocalDate sixtyMonthsDate) {
		this.sixtyMonthsDate = sixtyMonthsDate;
	}

	public Boolean getThirtyMonths() {
		return thirtyMonths;
	}

	public void setThirtyMonths(Boolean thirtyMonths) {
		this.thirtyMonths = thirtyMonths;
	}

	public LocalDate getThirtyMonthsDate() {
		return thirtyMonthsDate;
	}

	public void setThirtyMonthsDate(LocalDate thirtyMonthsDate) {
		this.thirtyMonthsDate = thirtyMonthsDate;
	}

	public Boolean getThirtysixMonths() {
		return thirtysixMonths;
	}

	public void setThirtysixMonths(Boolean thirtysixMonths) {
		this.thirtysixMonths = thirtysixMonths;
	}

	public LocalDate getThirtysixMonthsDate() {
		return thirtysixMonthsDate;
	}

	public void setThirtysixMonthsDate(LocalDate thirtysixMonthsDate) {
		this.thirtysixMonthsDate = thirtysixMonthsDate;
	}

	public Boolean getTwentyfourMonths() {
		return twentyfourMonths;
	}

	public void setTwentyfourMonths(Boolean twentyfourMonths) {
		this.twentyfourMonths = twentyfourMonths;
	}

	public LocalDate getTwentyfourMonthsDate() {
		return twentyfourMonthsDate;
	}

	public void setTwentyfourMonthsDate(LocalDate twentyfourMonthsDate) {
		this.twentyfourMonthsDate = twentyfourMonthsDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
