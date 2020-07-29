package gov.naco.soch.cst.dto;

import java.time.LocalDate;

import gov.naco.soch.dto.BaseDto;

public class ArtPepDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long Id;
	private String name;
	private Long gender;
	private String contact_no;
	private String pep_no;
	private LocalDate dob;
	private Long assign_to;
	private Long pepqueueid;
	private Long pepdueid;
	private LocalDate registrationDate;
	private String exposedStaffDesignation;
	
	private Long addressId;
	private Long stateId;
	private Long districtId;
	private Long subDistrictId;
	private Long townId;
	private String pinCode;
	private String addressLineOne;
	private String addressLineTwo;

	
	private LocalDate dateOfAccidentalExposure;
	private String modeOfInjuryOrExposure;
	private Long exposedStaffFacilityId;
	private Boolean consentTaken;
	private Long hivExposureCodeId;
	private Long hivSourceStatusId;
	private Long pepPrescriptionId;
	private Long severityOfExposureId;
	private LocalDate pepStartDate;
	private Boolean pepCourseCompleted;
	private Long pepCourseDays;
	private Boolean baselineTestConductedHiv;
	private Long baselineTestConductedHivResultId;
	private Boolean baselineTestConductedHbv;
	private Long baselineTestConductedHbvResultId;
	private Boolean baselineTestConductedHcv;
	private Long baselineTestConductedHcvResultId;
	private Long exposedPersonSeroStatusSixMonthsId;
	private Long exposedPersonSeroStatusThreeMonthsId;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getGender() {
		return gender;
	}
	public void setGender(Long gender) {
		this.gender = gender;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getPep_no() {
		return pep_no;
	}
	public void setPep_no(String pep_no) {
		this.pep_no = pep_no;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Long getAssign_to() {
		return assign_to;
	}
	public void setAssign_to(Long assign_to) {
		this.assign_to = assign_to;
	}
	public Long getPepqueueid() {
		return pepqueueid;
	}
	public void setPepqueueid(Long pepqueueid) {
		this.pepqueueid = pepqueueid;
	}
	public Long getPepdueid() {
		return pepdueid;
	}
	public void setPepdueid(Long pepdueid) {
		this.pepdueid = pepdueid;
	}
	public LocalDate getDateOfAccidentalExposure() {
		return dateOfAccidentalExposure;
	}
	public void setDateOfAccidentalExposure(LocalDate dateOfAccidentalExposure) {
		this.dateOfAccidentalExposure = dateOfAccidentalExposure;
	}
	public String getModeOfInjuryOrExposure() {
		return modeOfInjuryOrExposure;
	}
	public void setModeOfInjuryOrExposure(String modeOfInjuryOrExposure) {
		this.modeOfInjuryOrExposure = modeOfInjuryOrExposure;
	}
	public Boolean getConsentTaken() {
		return consentTaken;
	}
	public void setConsentTaken(Boolean consentTaken) {
		this.consentTaken = consentTaken;
	}
	public Long getHivExposureCodeId() {
		return hivExposureCodeId;
	}
	public void setHivExposureCodeId(Long hivExposureCodeId) {
		this.hivExposureCodeId = hivExposureCodeId;
	}
	public Long getHivSourceStatusId() {
		return hivSourceStatusId;
	}
	public void setHivSourceStatusId(Long hivSourceStatusId) {
		this.hivSourceStatusId = hivSourceStatusId;
	}
	public Long getPepPrescriptionId() {
		return pepPrescriptionId;
	}
	public void setPepPrescriptionId(Long pepPrescriptionId) {
		this.pepPrescriptionId = pepPrescriptionId;
	}
	public LocalDate getPepStartDate() {
		return pepStartDate;
	}
	public void setPepStartDate(LocalDate pepStartDate) {
		this.pepStartDate = pepStartDate;
	}
	public Long getPepCourseDays() {
		return pepCourseDays;
	}
	public void setPepCourseDays(Long pepCourseDays) {
		this.pepCourseDays = pepCourseDays;
	}
	public Boolean getBaselineTestConductedHiv() {
		return baselineTestConductedHiv;
	}
	public void setBaselineTestConductedHiv(Boolean baselineTestConductedHiv) {
		this.baselineTestConductedHiv = baselineTestConductedHiv;
	}
	public Long getBaselineTestConductedHivResultId() {
		return baselineTestConductedHivResultId;
	}
	public void setBaselineTestConductedHivResultId(Long baselineTestConductedHivResultId) {
		this.baselineTestConductedHivResultId = baselineTestConductedHivResultId;
	}
	public Boolean getBaselineTestConductedHbv() {
		return baselineTestConductedHbv;
	}
	public void setBaselineTestConductedHbv(Boolean baselineTestConductedHbv) {
		this.baselineTestConductedHbv = baselineTestConductedHbv;
	}
	public Long getBaselineTestConductedHbvResultId() {
		return baselineTestConductedHbvResultId;
	}
	public void setBaselineTestConductedHbvResultId(Long baselineTestConductedHbvResultId) {
		this.baselineTestConductedHbvResultId = baselineTestConductedHbvResultId;
	}
	public Boolean getBaselineTestConductedHcv() {
		return baselineTestConductedHcv;
	}
	public void setBaselineTestConductedHcv(Boolean baselineTestConductedHcv) {
		this.baselineTestConductedHcv = baselineTestConductedHcv;
	}
	public Long getBaselineTestConductedHcvResultId() {
		return baselineTestConductedHcvResultId;
	}
	public void setBaselineTestConductedHcvResultId(Long baselineTestConductedHcvResultId) {
		this.baselineTestConductedHcvResultId = baselineTestConductedHcvResultId;
	}
	public Long getExposedPersonSeroStatusSixMonthsId() {
		return exposedPersonSeroStatusSixMonthsId;
	}
	public void setExposedPersonSeroStatusSixMonthsId(Long exposedPersonSeroStatusSixMonthsId) {
		this.exposedPersonSeroStatusSixMonthsId = exposedPersonSeroStatusSixMonthsId;
	}
	public Long getExposedPersonSeroStatusThreeMonthsId() {
		return exposedPersonSeroStatusThreeMonthsId;
	}
	public void setExposedPersonSeroStatusThreeMonthsId(Long exposedPersonSeroStatusThreeMonthsId) {
		this.exposedPersonSeroStatusThreeMonthsId = exposedPersonSeroStatusThreeMonthsId;
	}
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getExposedStaffDesignation() {
		return exposedStaffDesignation;
	}
	public void setExposedStaffDesignation(String exposedStaffDesignation) {
		this.exposedStaffDesignation = exposedStaffDesignation;
	}
	public Long getSeverityOfExposureId() {
		return severityOfExposureId;
	}
	public void setSeverityOfExposureId(Long severityOfExposureId) {
		this.severityOfExposureId = severityOfExposureId;
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
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
	public Long getSubDistrictId() {
		return subDistrictId;
	}
	public void setSubDistrictId(Long subDistrictId) {
		this.subDistrictId = subDistrictId;
	}

	public Long getTownId() {
		return townId;
	}
	public void setTownId(Long townId) {
		this.townId = townId;
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
	public Boolean getPepCourseCompleted() {
		return pepCourseCompleted;
	}
	public void setPepCourseCompleted(Boolean pepCourseCompleted) {
		this.pepCourseCompleted = pepCourseCompleted;
	}
	public Long getExposedStaffFacilityId() {
		return exposedStaffFacilityId;
	}
	public void setExposedStaffFacilityId(Long exposedStaffFacilityId) {
		this.exposedStaffFacilityId = exposedStaffFacilityId;
	}
	
	
	


}
