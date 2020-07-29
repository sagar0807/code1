package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the lab_test_sample database table.
 * 
 */
@Entity
@Table(name="lab_test_sample")
@NamedQuery(name="LabTestSample.findAll", query="SELECT l FROM LabTestSample l")
public class LabTestSample implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="artc_sample_status")
	private String artcSampleStatus;

	@Column(name="authorizer_signature")
	private String authorizerSignature;

	@Column(name="barcode_number")
	private String barcodeNumber;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="error_code")
	private Integer errorCode;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="is_error")
	private Boolean isError;

	@Column(name="lab_incharge_signature")
	private String labInchargeSignature;

	@Column(name="lab_technician_signature")
	private String labTechnicianSignature;

	@Column(name="log_value")
	private String logValue;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Temporal(TemporalType.DATE)
	@Column(name="next_appointment_date")
	private Date nextAppointmentDate;

	@Column(name="result_approved_date")
	private Timestamp resultApprovedDate;

	@Column(name="result_dispatch_date")
	private Timestamp resultDispatchDate;

	@Column(name="result_received_date")
	private Timestamp resultReceivedDate;

	@Column(name="result_value")
	private String resultValue;

	@Column(name="sample_collected_date")
	private Timestamp sampleCollectedDate;

	@Column(name="sample_dispatch_date")
	private Timestamp sampleDispatchDate;

	@Column(name="sample_received_date")
	private Timestamp sampleReceivedDate;

	@Column(name="test_machine_type_id")
	private Integer testMachineTypeId;

	@Column(name="test_request_form_link")
	private String testRequestFormLink;

	@Column(name="type_of_specimen")
	private String typeOfSpecimen;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="dispatched_to_lab_id")
	private Facility facility1;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="sample_collected_facility_id")
	private Facility facility2;

	//bi-directional many-to-one association to LabTestSampleBatch
	@ManyToOne
	@JoinColumn(name="test_batch_id")
	private LabTestSampleBatch labTestSampleBatch;

	//bi-directional many-to-one association to Machine
	@ManyToOne
	@JoinColumn(name="test_machine_id")
	private Machine machine;

	//bi-directional many-to-one association to MasterRemark
	@ManyToOne
	@JoinColumn(name="remarks_id")
	private MasterRemark masterRemark;

	//bi-directional many-to-one association to MasterResultStatus
	@ManyToOne
	@JoinColumn(name="result_status_id")
	private MasterResultStatus masterResultStatus;

	//bi-directional many-to-one association to MasterResultType
	@ManyToOne
	@JoinColumn(name="result_type_id")
	private MasterResultType masterResultType;

	//bi-directional many-to-one association to MasterSampleStatus
	@ManyToOne
	@JoinColumn(name="sample_status_id")
	private MasterSampleStatus masterSampleStatus;

	//bi-directional many-to-one association to MasterTestType
	@ManyToOne
	@JoinColumn(name="test_type_id")
	private MasterTestType masterTestType;

	//bi-directional many-to-one association to Test
	@ManyToOne
	private Test test;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="authorizer_id")
	private UserMaster userMaster1;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="lab_incharge_id")
	private UserMaster userMaster2;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="lab_technician_id")
	private UserMaster userMaster3;

	public LabTestSample() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArtcSampleStatus() {
		return this.artcSampleStatus;
	}

	public void setArtcSampleStatus(String artcSampleStatus) {
		this.artcSampleStatus = artcSampleStatus;
	}

	public String getAuthorizerSignature() {
		return this.authorizerSignature;
	}

	public void setAuthorizerSignature(String authorizerSignature) {
		this.authorizerSignature = authorizerSignature;
	}

	public String getBarcodeNumber() {
		return this.barcodeNumber;
	}

	public void setBarcodeNumber(String barcodeNumber) {
		this.barcodeNumber = barcodeNumber;
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

	public Integer getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean getIsError() {
		return this.isError;
	}

	public void setIsError(Boolean isError) {
		this.isError = isError;
	}

	public String getLabInchargeSignature() {
		return this.labInchargeSignature;
	}

	public void setLabInchargeSignature(String labInchargeSignature) {
		this.labInchargeSignature = labInchargeSignature;
	}

	public String getLabTechnicianSignature() {
		return this.labTechnicianSignature;
	}

	public void setLabTechnicianSignature(String labTechnicianSignature) {
		this.labTechnicianSignature = labTechnicianSignature;
	}

	public String getLogValue() {
		return this.logValue;
	}

	public void setLogValue(String logValue) {
		this.logValue = logValue;
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

	public Date getNextAppointmentDate() {
		return this.nextAppointmentDate;
	}

	public void setNextAppointmentDate(Date nextAppointmentDate) {
		this.nextAppointmentDate = nextAppointmentDate;
	}

	public Timestamp getResultApprovedDate() {
		return this.resultApprovedDate;
	}

	public void setResultApprovedDate(Timestamp resultApprovedDate) {
		this.resultApprovedDate = resultApprovedDate;
	}

	public Timestamp getResultDispatchDate() {
		return this.resultDispatchDate;
	}

	public void setResultDispatchDate(Timestamp resultDispatchDate) {
		this.resultDispatchDate = resultDispatchDate;
	}

	public Timestamp getResultReceivedDate() {
		return this.resultReceivedDate;
	}

	public void setResultReceivedDate(Timestamp resultReceivedDate) {
		this.resultReceivedDate = resultReceivedDate;
	}

	public String getResultValue() {
		return this.resultValue;
	}

	public void setResultValue(String resultValue) {
		this.resultValue = resultValue;
	}

	public Timestamp getSampleCollectedDate() {
		return this.sampleCollectedDate;
	}

	public void setSampleCollectedDate(Timestamp sampleCollectedDate) {
		this.sampleCollectedDate = sampleCollectedDate;
	}

	public Timestamp getSampleDispatchDate() {
		return this.sampleDispatchDate;
	}

	public void setSampleDispatchDate(Timestamp sampleDispatchDate) {
		this.sampleDispatchDate = sampleDispatchDate;
	}

	public Timestamp getSampleReceivedDate() {
		return this.sampleReceivedDate;
	}

	public void setSampleReceivedDate(Timestamp sampleReceivedDate) {
		this.sampleReceivedDate = sampleReceivedDate;
	}

	public Integer getTestMachineTypeId() {
		return this.testMachineTypeId;
	}

	public void setTestMachineTypeId(Integer testMachineTypeId) {
		this.testMachineTypeId = testMachineTypeId;
	}

	public String getTestRequestFormLink() {
		return this.testRequestFormLink;
	}

	public void setTestRequestFormLink(String testRequestFormLink) {
		this.testRequestFormLink = testRequestFormLink;
	}

	public String getTypeOfSpecimen() {
		return this.typeOfSpecimen;
	}

	public void setTypeOfSpecimen(String typeOfSpecimen) {
		this.typeOfSpecimen = typeOfSpecimen;
	}

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
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

	public LabTestSampleBatch getLabTestSampleBatch() {
		return this.labTestSampleBatch;
	}

	public void setLabTestSampleBatch(LabTestSampleBatch labTestSampleBatch) {
		this.labTestSampleBatch = labTestSampleBatch;
	}

	public Machine getMachine() {
		return this.machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public MasterRemark getMasterRemark() {
		return this.masterRemark;
	}

	public void setMasterRemark(MasterRemark masterRemark) {
		this.masterRemark = masterRemark;
	}

	public MasterResultStatus getMasterResultStatus() {
		return this.masterResultStatus;
	}

	public void setMasterResultStatus(MasterResultStatus masterResultStatus) {
		this.masterResultStatus = masterResultStatus;
	}

	public MasterResultType getMasterResultType() {
		return this.masterResultType;
	}

	public void setMasterResultType(MasterResultType masterResultType) {
		this.masterResultType = masterResultType;
	}

	public MasterSampleStatus getMasterSampleStatus() {
		return this.masterSampleStatus;
	}

	public void setMasterSampleStatus(MasterSampleStatus masterSampleStatus) {
		this.masterSampleStatus = masterSampleStatus;
	}

	public MasterTestType getMasterTestType() {
		return this.masterTestType;
	}

	public void setMasterTestType(MasterTestType masterTestType) {
		this.masterTestType = masterTestType;
	}

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
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

	public UserMaster getUserMaster3() {
		return this.userMaster3;
	}

	public void setUserMaster3(UserMaster userMaster3) {
		this.userMaster3 = userMaster3;
	}

}