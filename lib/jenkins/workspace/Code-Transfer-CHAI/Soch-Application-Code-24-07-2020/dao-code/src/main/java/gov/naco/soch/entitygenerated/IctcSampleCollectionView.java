package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ictc_sample_collection_view database table.
 * 
 */
@Entity
@Table(name="ictc_sample_collection_view")
@NamedQuery(name="IctcSampleCollectionView.findAll", query="SELECT i FROM IctcSampleCollectionView i")
public class IctcSampleCollectionView implements Serializable {
	private static final long serialVersionUID = 1L;

	private String age;

	private String barcode;

	@Column(name="batch_id")
	private Long batchId;

	private String category;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	@Column(name="facility_id")
	private Long facilityId;

	@Column(name="first_name")
	private String firstName;

	private String gender;

	@Column(name="ictc_beneficiary_id")
	private Integer ictcBeneficiaryId;

	private Integer id;

	@Column(name="infant_breast_fed")
	private Integer infantBreastFed;

	@Column(name="infant_code")
	private String infantCode;

	@Column(name="last_name")
	private String lastName;

	@Column(name="middle_name")
	private String middleName;

	private String pid;

	@Column(name="result_status")
	private Integer resultStatus;

	@Temporal(TemporalType.DATE)
	@Column(name="sample_collection_date")
	private Date sampleCollectionDate;

	@Column(name="sample_collection_status")
	private Integer sampleCollectionStatus;

	@Column(name="test_type")
	private Integer testType;

	private String uid;

	@Temporal(TemporalType.DATE)
	@Column(name="visit_date")
	private Date visitDate;

	@Column(name="visit_id")
	private Integer visitId;

	public IctcSampleCollectionView() {
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
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

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getIctcBeneficiaryId() {
		return this.ictcBeneficiaryId;
	}

	public void setIctcBeneficiaryId(Integer ictcBeneficiaryId) {
		this.ictcBeneficiaryId = ictcBeneficiaryId;
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

	public Integer getTestType() {
		return this.testType;
	}

	public void setTestType(Integer testType) {
		this.testType = testType;
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