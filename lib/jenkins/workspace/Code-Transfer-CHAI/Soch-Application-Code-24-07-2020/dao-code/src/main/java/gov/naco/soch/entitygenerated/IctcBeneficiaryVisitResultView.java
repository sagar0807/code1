package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ictc_beneficiary_visit_result_view database table.
 * 
 */
@Entity
@Table(name="ictc_beneficiary_visit_result_view")
@NamedQuery(name="IctcBeneficiaryVisitResultView.findAll", query="SELECT i FROM IctcBeneficiaryVisitResultView i")
public class IctcBeneficiaryVisitResultView implements Serializable {
	private static final long serialVersionUID = 1L;

	private String age;

	@Column(name="art_referral_id")
	private Long artReferralId;

	@Column(name="art_referral_name")
	private String artReferralName;

	private String barcode;

	@Column(name="batch_id")
	private Long batchId;

	@Column(name="beneficiary_id")
	private Integer beneficiaryId;

	@Column(name="beneficiary_status")
	private Integer beneficiaryStatus;

	private String category;

	@Column(name="consignment_id")
	private String consignmentId;

	@Column(name="current_test_result_id")
	private Long currentTestResultId;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	@Column(name="dsrc_referral_id")
	private Long dsrcReferralId;

	@Column(name="dsrc_referral_name")
	private String dsrcReferralName;

	@Column(name="facility_id")
	private Long facilityId;

	@Column(name="first_name")
	private String firstName;

	private String gender;

	@Column(name="hiv_status")
	private Integer hivStatus;

	@Column(name="hiv_type")
	private Integer hivType;

	private Integer id;

	@Column(name="infant_breast_fed")
	private Integer infantBreastFed;

	@Column(name="infant_code")
	private String infantCode;

	@Column(name="infant_mother_art_id")
	private Integer infantMotherArtId;

	@Column(name="infant_mother_art_no")
	private String infantMotherArtNo;

	@Column(name="infant_mother_first_name")
	private String infantMotherFirstName;

	@Column(name="infant_mother_last_name")
	private String infantMotherLastName;

	@Column(name="is_consent_documented")
	private Boolean isConsentDocumented;

	@Column(name="is_pregnant")
	private Boolean isPregnant;

	@Column(name="lab_code")
	private String labCode;

	@Column(name="lab_id")
	private Long labId;

	@Column(name="lab_name")
	private String labName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="marital_status")
	private String maritalStatus;

	@Column(name="middle_name")
	private String middleName;

	@Column(name="mobile_number")
	private String mobileNumber;

	private String occupation;

	private String pid;

	@Column(name="recent_visit_id")
	private Long recentVisitId;
//
//	@Column(name="relationship_first_name")
//	private String relationshipFirstName;
//
//	@Column(name="relationship_last_name")
//	private String relationshipLastName;
//
//	@Column(name="relationship_middle_name")
//	private String relationshipMiddleName;

//	@Column(name="relationship_record_id")
//	private Long relationshipRecordId;

//	@Column(name="relationship_type")
//	private Integer relationshipType;

	@Temporal(TemporalType.DATE)
	@Column(name="report_delivery_date")
	private Date reportDeliveryDate;

	@Temporal(TemporalType.DATE)
	@Column(name="report_received_date")
	private Date reportReceivedDate;

	@Column(name="result_status")
	private Integer resultStatus;

	@Column(name="rntcp_referral_id")
	private Long rntcpReferralId;

	@Column(name="rntcp_referral_name")
	private String rntcpReferralName;

	@Temporal(TemporalType.DATE)
	@Column(name="sample_collection_date")
	private Date sampleCollectionDate;

//	@Column(name="test_sequence")
//	private Integer testSequence;

	@Column(name="test_type")
	private Integer testType;

	@Temporal(TemporalType.DATE)
	@Column(name="tested_date")
	private Date testedDate;

	@Column(name="ti_referral_id")
	private Long tiReferralId;

	@Column(name="ti_referral_name")
	private String tiReferralName;

	private String uid;

	@Temporal(TemporalType.DATE)
	@Column(name="visit_date")
	private Date visitDate;

	@Column(name="visit_id")
	private Integer visitId;

	public IctcBeneficiaryVisitResultView() {
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Long getArtReferralId() {
		return this.artReferralId;
	}

	public void setArtReferralId(Long artReferralId) {
		this.artReferralId = artReferralId;
	}

	public String getArtReferralName() {
		return this.artReferralName;
	}

	public void setArtReferralName(String artReferralName) {
		this.artReferralName = artReferralName;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Long getBatchId() {
		return this.batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public Integer getBeneficiaryId() {
		return this.beneficiaryId;
	}

	public void setBeneficiaryId(Integer beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Integer getBeneficiaryStatus() {
		return this.beneficiaryStatus;
	}

	public void setBeneficiaryStatus(Integer beneficiaryStatus) {
		this.beneficiaryStatus = beneficiaryStatus;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getConsignmentId() {
		return this.consignmentId;
	}

	public void setConsignmentId(String consignmentId) {
		this.consignmentId = consignmentId;
	}

	public Long getCurrentTestResultId() {
		return this.currentTestResultId;
	}

	public void setCurrentTestResultId(Long currentTestResultId) {
		this.currentTestResultId = currentTestResultId;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Long getDsrcReferralId() {
		return this.dsrcReferralId;
	}

	public void setDsrcReferralId(Long dsrcReferralId) {
		this.dsrcReferralId = dsrcReferralId;
	}

	public String getDsrcReferralName() {
		return this.dsrcReferralName;
	}

	public void setDsrcReferralName(String dsrcReferralName) {
		this.dsrcReferralName = dsrcReferralName;
	}

	public Long getFacilityId() {
		return this.facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getHivStatus() {
		return this.hivStatus;
	}

	public void setHivStatus(Integer hivStatus) {
		this.hivStatus = hivStatus;
	}

	public Integer getHivType() {
		return this.hivType;
	}

	public void setHivType(Integer hivType) {
		this.hivType = hivType;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInfantBreastFed() {
		return this.infantBreastFed;
	}

	public void setInfantBreastFed(Integer infantBreastFed) {
		this.infantBreastFed = infantBreastFed;
	}

	public String getInfantCode() {
		return this.infantCode;
	}

	public void setInfantCode(String infantCode) {
		this.infantCode = infantCode;
	}

	public Integer getInfantMotherArtId() {
		return this.infantMotherArtId;
	}

	public void setInfantMotherArtId(Integer infantMotherArtId) {
		this.infantMotherArtId = infantMotherArtId;
	}

	public String getInfantMotherArtNo() {
		return this.infantMotherArtNo;
	}

	public void setInfantMotherArtNo(String infantMotherArtNo) {
		this.infantMotherArtNo = infantMotherArtNo;
	}

	public String getInfantMotherFirstName() {
		return this.infantMotherFirstName;
	}

	public void setInfantMotherFirstName(String infantMotherFirstName) {
		this.infantMotherFirstName = infantMotherFirstName;
	}

	public String getInfantMotherLastName() {
		return this.infantMotherLastName;
	}

	public void setInfantMotherLastName(String infantMotherLastName) {
		this.infantMotherLastName = infantMotherLastName;
	}

	public Boolean getIsConsentDocumented() {
		return this.isConsentDocumented;
	}

	public void setIsConsentDocumented(Boolean isConsentDocumented) {
		this.isConsentDocumented = isConsentDocumented;
	}

	public Boolean getIsPregnant() {
		return this.isPregnant;
	}

	public void setIsPregnant(Boolean isPregnant) {
		this.isPregnant = isPregnant;
	}

	public String getLabCode() {
		return this.labCode;
	}

	public void setLabCode(String labCode) {
		this.labCode = labCode;
	}

	public Long getLabId() {
		return this.labId;
	}

	public void setLabId(Long labId) {
		this.labId = labId;
	}

	public String getLabName() {
		return this.labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Long getRecentVisitId() {
		return this.recentVisitId;
	}

	public void setRecentVisitId(Long recentVisitId) {
		this.recentVisitId = recentVisitId;
	}

//	public String getRelationshipFirstName() {
//		return this.relationshipFirstName;
//	}
//
//	public void setRelationshipFirstName(String relationshipFirstName) {
//		this.relationshipFirstName = relationshipFirstName;
//	}
//
//	public String getRelationshipLastName() {
//		return this.relationshipLastName;
//	}
//
//	public void setRelationshipLastName(String relationshipLastName) {
//		this.relationshipLastName = relationshipLastName;
//	}
//
//	public String getRelationshipMiddleName() {
//		return this.relationshipMiddleName;
//	}
//
//	public void setRelationshipMiddleName(String relationshipMiddleName) {
//		this.relationshipMiddleName = relationshipMiddleName;
//	}
//
//	public Long getRelationshipRecordId() {
//		return this.relationshipRecordId;
//	}
//
//	public void setRelationshipRecordId(Long relationshipRecordId) {
//		this.relationshipRecordId = relationshipRecordId;
//	}
//
//	public Integer getRelationshipType() {
//		return this.relationshipType;
//	}
//
//	public void setRelationshipType(Integer relationshipType) {
//		this.relationshipType = relationshipType;
//	}

	public Date getReportDeliveryDate() {
		return this.reportDeliveryDate;
	}

	public void setReportDeliveryDate(Date reportDeliveryDate) {
		this.reportDeliveryDate = reportDeliveryDate;
	}

	public Date getReportReceivedDate() {
		return this.reportReceivedDate;
	}

	public void setReportReceivedDate(Date reportReceivedDate) {
		this.reportReceivedDate = reportReceivedDate;
	}

	public Integer getResultStatus() {
		return this.resultStatus;
	}

	public void setResultStatus(Integer resultStatus) {
		this.resultStatus = resultStatus;
	}

	public Long getRntcpReferralId() {
		return this.rntcpReferralId;
	}

	public void setRntcpReferralId(Long rntcpReferralId) {
		this.rntcpReferralId = rntcpReferralId;
	}

	public String getRntcpReferralName() {
		return this.rntcpReferralName;
	}

	public void setRntcpReferralName(String rntcpReferralName) {
		this.rntcpReferralName = rntcpReferralName;
	}

	public Date getSampleCollectionDate() {
		return this.sampleCollectionDate;
	}

	public void setSampleCollectionDate(Date sampleCollectionDate) {
		this.sampleCollectionDate = sampleCollectionDate;
	}
//
//	public Integer getTestSequence() {
//		return this.testSequence;
//	}
//
//	public void setTestSequence(Integer testSequence) {
//		this.testSequence = testSequence;
//	}

	public Integer getTestType() {
		return this.testType;
	}

	public void setTestType(Integer testType) {
		this.testType = testType;
	}

	public Date getTestedDate() {
		return this.testedDate;
	}

	public void setTestedDate(Date testedDate) {
		this.testedDate = testedDate;
	}

	public Long getTiReferralId() {
		return this.tiReferralId;
	}

	public void setTiReferralId(Long tiReferralId) {
		this.tiReferralId = tiReferralId;
	}

	public String getTiReferralName() {
		return this.tiReferralName;
	}

	public void setTiReferralName(String tiReferralName) {
		this.tiReferralName = tiReferralName;
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Date getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Integer getVisitId() {
		return this.visitId;
	}

	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
	}

}