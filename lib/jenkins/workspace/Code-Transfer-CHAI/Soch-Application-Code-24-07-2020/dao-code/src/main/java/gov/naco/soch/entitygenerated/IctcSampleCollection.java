package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the ictc_sample_collection database table.
 * 
 */
@Entity
@Table(name="ictc_sample_collection")
@NamedQuery(name="IctcSampleCollection.findAll", query="SELECT i FROM IctcSampleCollection i")
public class IctcSampleCollection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String barcode;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

//	@Temporal(TemporalType.DATE)
//	@Column(name="dispatch_date")
//	private Date dispatchDate;
//
//	@Column(name="dispatched_to_lab_id")
//	private Integer dispatchedToLabId;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_deleted")
	private Boolean isDeleted;

	@Column(name="is_dispatched")
	private Boolean isDispatched;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Temporal(TemporalType.DATE)
	@Column(name="sample_collection_date")
	private Date sampleCollectionDate;

	@Column(name="sample_collection_status")
	private Integer sampleCollectionStatus;

	@Column(name="test_type")
	private Integer testType;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to IctcBeneficiary
	@ManyToOne
	@JoinColumn(name="ictc_beneficiary_id")
	private IctcBeneficiary ictcBeneficiary;

	//bi-directional many-to-one association to IctcSampleBatch
	@ManyToOne
	@JoinColumn(name="batch_id")
	private IctcSampleBatch ictcSampleBatch;

	//bi-directional many-to-one association to IctcVisit
	@ManyToOne
	@JoinColumn(name="visit_id")
	private IctcVisit ictcVisit;

	//bi-directional many-to-one association to IctcTestResult
	@OneToMany(mappedBy="ictcSampleCollection")
	private Set<IctcTestResult> ictcTestResults;

	public IctcSampleCollection() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

//	public Date getDispatchDate() {
//		return this.dispatchDate;
//	}
//
//	public void setDispatchDate(Date dispatchDate) {
//		this.dispatchDate = dispatchDate;
//	}
//
//	public Integer getDispatchedToLabId() {
//		return this.dispatchedToLabId;
//	}
//
//	public void setDispatchedToLabId(Integer dispatchedToLabId) {
//		this.dispatchedToLabId = dispatchedToLabId;
//	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Boolean getIsDispatched() {
		return this.isDispatched;
	}

	public void setIsDispatched(Boolean isDispatched) {
		this.isDispatched = isDispatched;
	}

	public Integer getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
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

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public IctcBeneficiary getIctcBeneficiary() {
		return this.ictcBeneficiary;
	}

	public void setIctcBeneficiary(IctcBeneficiary ictcBeneficiary) {
		this.ictcBeneficiary = ictcBeneficiary;
	}

	public IctcSampleBatch getIctcSampleBatch() {
		return this.ictcSampleBatch;
	}

	public void setIctcSampleBatch(IctcSampleBatch ictcSampleBatch) {
		this.ictcSampleBatch = ictcSampleBatch;
	}

	public IctcVisit getIctcVisit() {
		return this.ictcVisit;
	}

	public void setIctcVisit(IctcVisit ictcVisit) {
		this.ictcVisit = ictcVisit;
	}

	public Set<IctcTestResult> getIctcTestResults() {
		return this.ictcTestResults;
	}

	public void setIctcTestResults(Set<IctcTestResult> ictcTestResults) {
		this.ictcTestResults = ictcTestResults;
	}

	public IctcTestResult addIctcTestResult(IctcTestResult ictcTestResult) {
		getIctcTestResults().add(ictcTestResult);
		ictcTestResult.setIctcSampleCollection(this);

		return ictcTestResult;
	}

	public IctcTestResult removeIctcTestResult(IctcTestResult ictcTestResult) {
		getIctcTestResults().remove(ictcTestResult);
		ictcTestResult.setIctcSampleCollection(null);

		return ictcTestResult;
	}

}