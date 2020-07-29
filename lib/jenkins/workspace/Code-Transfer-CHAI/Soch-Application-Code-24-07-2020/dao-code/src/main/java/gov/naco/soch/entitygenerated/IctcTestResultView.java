package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ictc_test_result_view database table.
 * 
 */
@Entity
@Table(name="ictc_test_result_view")
@NamedQuery(name="IctcTestResultView.findAll", query="SELECT i FROM IctcTestResultView i")
public class IctcTestResultView implements Serializable {
	private static final long serialVersionUID = 1L;

	private String age;

	@Column(name="art_center_code")
	private String artCenterCode;

	@Column(name="art_center_name")
	private String artCenterName;

	@Column(name="batch_id")
	private Long batchId;

	@Column(name="batch_status")
	private Integer batchStatus;

	@Column(name="beneficiary_id")
	private Long beneficiaryId;

	private String category;

	@Column(name="consignment_id")
	private String consignmentId;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	@Column(name="facility_id")
	private Long facilityId;

	@Column(name="first_name")
	private String firstName;

	@Temporal(TemporalType.DATE)
	@Column(name="follow_up_date")
	private Date followUpDate;

	private String gender;

	@Column(name="hiv_status")
	private Integer hivStatus;

	@Column(name="hiv_type")
	private Integer hivType;

	@Column(name="ictc_beneficiary_id")
	private Long ictcBeneficiaryId;

	private Integer id;

	@Column(name="lab_code")
	private String labCode;

	@Column(name="lab_id")
	private Integer labId;

	@Column(name="lab_name")
	private String labName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="middle_name")
	private String middleName;

	private String pid;

	@Temporal(TemporalType.DATE)
	@Column(name="refer_date")
	private Date referDate;

	@Temporal(TemporalType.DATE)
	@Column(name="report_delivery_date")
	private Date reportDeliveryDate;

	@Temporal(TemporalType.DATE)
	@Column(name="report_received_date")
	private Date reportReceivedDate;

	@Column(name="result_status")
	private Integer resultStatus;

	@Temporal(TemporalType.DATE)
	@Column(name="sample_collection_date")
	private Date sampleCollectionDate;

	@Column(name="sample_collection_status")
	private Integer sampleCollectionStatus;

	@Column(name="sample_id")
	private Long sampleId;

	@Column(name="test_type")
	private Integer testType;

	@Temporal(TemporalType.DATE)
	@Column(name="tested_date")
	private Date testedDate;

	private String uid;

	@Column(name="visit_id")
	private Long visitId;

	public IctcTestResultView() {
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getArtCenterCode() {
		return this.artCenterCode;
	}

	public void setArtCenterCode(String artCenterCode) {
		this.artCenterCode = artCenterCode;
	}

	public String getArtCenterName() {
		return this.artCenterName;
	}

	public void setArtCenterName(String artCenterName) {
		this.artCenterName = artCenterName;
	}

	public Long getBatchId() {
		return this.batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public Integer getBatchStatus() {
		return this.batchStatus;
	}

	public void setBatchStatus(Integer batchStatus) {
		this.batchStatus = batchStatus;
	}

	public Long getBeneficiaryId() {
		return this.beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
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

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public Date getFollowUpDate() {
		return this.followUpDate;
	}

	public void setFollowUpDate(Date followUpDate) {
		this.followUpDate = followUpDate;
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

	public Long getIctcBeneficiaryId() {
		return this.ictcBeneficiaryId;
	}

	public void setIctcBeneficiaryId(Long ictcBeneficiaryId) {
		this.ictcBeneficiaryId = ictcBeneficiaryId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabCode() {
		return this.labCode;
	}

	public void setLabCode(String labCode) {
		this.labCode = labCode;
	}

	public Integer getLabId() {
		return this.labId;
	}

	public void setLabId(Integer labId) {
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

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Date getReferDate() {
		return this.referDate;
	}

	public void setReferDate(Date referDate) {
		this.referDate = referDate;
	}

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

	public Date getSampleCollectionDate() {
		return this.sampleCollectionDate;
	}

	public void setSampleCollectionDate(Date sampleCollectionDate) {
		this.sampleCollectionDate = sampleCollectionDate;
	}

	public Integer getSampleCollectionStatus() {
		return this.sampleCollectionStatus;
	}

	public void setSampleCollectionStatus(Integer sampleCollectionStatus) {
		this.sampleCollectionStatus = sampleCollectionStatus;
	}

	public Long getSampleId() {
		return this.sampleId;
	}

	public void setSampleId(Long sampleId) {
		this.sampleId = sampleId;
	}

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

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Long getVisitId() {
		return this.visitId;
	}

	public void setVisitId(Long visitId) {
		this.visitId = visitId;
	}

}