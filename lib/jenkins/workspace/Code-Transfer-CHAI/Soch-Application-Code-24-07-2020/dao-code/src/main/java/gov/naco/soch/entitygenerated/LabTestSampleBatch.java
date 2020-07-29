package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the lab_test_sample_batch database table.
 * 
 */
@Entity
@Table(name="lab_test_sample_batch")
@NamedQuery(name="LabTestSampleBatch.findAll", query="SELECT l FROM LabTestSampleBatch l")
public class LabTestSampleBatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="accepted_samples")
	private Integer acceptedSamples;

	@Column(name="bdn_serial_number")
	private String bdnSerialNumber;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="dispatch_date")
	private Timestamp dispatchDate;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="num_of_samples")
	private Integer numOfSamples;

	@Column(name="received_date")
	private Timestamp receivedDate;

	@Column(name="rejected_samples")
	private Integer rejectedSamples;

	//bi-directional many-to-one association to LabTestSample
	@OneToMany(mappedBy="labTestSampleBatch")
	private Set<LabTestSample> labTestSamples;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="artc_id")
	private Facility facility1;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="lab_id")
	private Facility facility2;

	//bi-directional many-to-one association to MasterBatchStatus
	@ManyToOne
	@JoinColumn(name="batch_status_id")
	private MasterBatchStatus masterBatchStatus;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="artc_lab_tech_id")
	private UserMaster userMaster1;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="lab_tech_id")
	private UserMaster userMaster2;

	public LabTestSampleBatch() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAcceptedSamples() {
		return this.acceptedSamples;
	}

	public void setAcceptedSamples(Integer acceptedSamples) {
		this.acceptedSamples = acceptedSamples;
	}

	public String getBdnSerialNumber() {
		return this.bdnSerialNumber;
	}

	public void setBdnSerialNumber(String bdnSerialNumber) {
		this.bdnSerialNumber = bdnSerialNumber;
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

	public Timestamp getDispatchDate() {
		return this.dispatchDate;
	}

	public void setDispatchDate(Timestamp dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
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

	public Integer getNumOfSamples() {
		return this.numOfSamples;
	}

	public void setNumOfSamples(Integer numOfSamples) {
		this.numOfSamples = numOfSamples;
	}

	public Timestamp getReceivedDate() {
		return this.receivedDate;
	}

	public void setReceivedDate(Timestamp receivedDate) {
		this.receivedDate = receivedDate;
	}

	public Integer getRejectedSamples() {
		return this.rejectedSamples;
	}

	public void setRejectedSamples(Integer rejectedSamples) {
		this.rejectedSamples = rejectedSamples;
	}

	public Set<LabTestSample> getLabTestSamples() {
		return this.labTestSamples;
	}

	public void setLabTestSamples(Set<LabTestSample> labTestSamples) {
		this.labTestSamples = labTestSamples;
	}

	public LabTestSample addLabTestSample(LabTestSample labTestSample) {
		getLabTestSamples().add(labTestSample);
		labTestSample.setLabTestSampleBatch(this);

		return labTestSample;
	}

	public LabTestSample removeLabTestSample(LabTestSample labTestSample) {
		getLabTestSamples().remove(labTestSample);
		labTestSample.setLabTestSampleBatch(null);

		return labTestSample;
	}

	public Facility getFacility1() {
		return this.facility1;
	}

	public void setFacility1(Facility facility1) {
		this.facility1 = facility1;
	}

	public Facility getFacility2() {
		return this.facility2;
	}

	public void setFacility2(Facility facility2) {
		this.facility2 = facility2;
	}

	public MasterBatchStatus getMasterBatchStatus() {
		return this.masterBatchStatus;
	}

	public void setMasterBatchStatus(MasterBatchStatus masterBatchStatus) {
		this.masterBatchStatus = masterBatchStatus;
	}

	public UserMaster getUserMaster1() {
		return this.userMaster1;
	}

	public void setUserMaster1(UserMaster userMaster1) {
		this.userMaster1 = userMaster1;
	}

	public UserMaster getUserMaster2() {
		return this.userMaster2;
	}

	public void setUserMaster2(UserMaster userMaster2) {
		this.userMaster2 = userMaster2;
	}

}