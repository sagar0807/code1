package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A LabTestSample.
 */
@Entity
@Table(name = "lab_test_sample")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LabTestSample implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "test_batch_id")
    private Long testBatchId;

    @Column(name = "sample_collected_date")
    private LocalDateTime sampleCollectedDate;

    @Column(name = "sample_dispatch_date")
    private LocalDateTime sampleDispatchDate;

    @Column(name = "sample_received_date")
    private LocalDateTime sampleReceivedDate;

    @Column(name = "result_received_date")
    private LocalDateTime resultReceivedDate;

    @Column(name = "result_approved_date")
    private LocalDateTime resultApprovedDate;

    @Column(name = "result_dispatch_date")
    private LocalDateTime resultDispatchDate;

    @Column(name = "sample_status_id")
    private Integer sampleStatusId;

    @Column(name = "test_type_id")
    private Integer testTypeId;

    @Column(name = "authorizer_id")
    private Integer authorizerId;

    @Column(name = "authorizer_signature")
    private String authorizerSignature;

    @Column(name = "barcode_number")
    private String barcodeNumber;

    @Column(name = "result_type_id")
    private Integer resultTypeId;

    @Column(name = "result_value")
    private String resultValue;

    @Column(name = "log_value")
    private String logValue;

    @Column(name = "is_error")
    private Boolean isError;

    @Column(name = "error_code")
	private String errorCode;

    @Column(name = "test_machine_type_id")
    private Integer testMachineTypeId;

    @Column(name = "test_machine_id")
    private Integer testMachineId;

    @Column(name = "type_of_specimen")
    private String typeOfSpecimen;

    @Column(name = "remarks_id")
    private Integer remarksId;

//    @Column(name = "lab_technician_id")
//    private Integer labTechnicianId;

    @Column(name = "lab_technician_signature")
    private String labTechnicianSignature;

//    @Column(name = "lab_incharge_id")
//    private Integer labInchargeId;

    @Column(name = "lab_incharge_signature")
    private String labInchargeSignature;

    @Column(name = "test_request_form_link")
    private String testRequestFormLink;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_time")
    private LocalDate createdTime;

    @Column(name = "modified_by")
    private Integer modifiedBy;

    @Column(name = "modified_time")
    private LocalDate modifiedTime;

    @Column(name = "is_delete")
    private Boolean isDelete;
    
    @Column(name = "sample_collected_facility_id")
	private Long sampleCollectedFacility;
	
	@Column(name = "dispatched_to_lab_id")
	private Long dispatchedToLab;
    
    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("labTestSamples")
    @JsonIgnore
    private Beneficiary beneficiary;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lab_incharge_id")
	private UserMaster labInCharge;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lab_technician_id")
	private UserMaster labTecnician;
	
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
   
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTestBatchId() {
		return testBatchId;
	}

	public void setTestBatchId(Long testBatchId) {
		this.testBatchId = testBatchId;
	}

	public LocalDateTime getSampleCollectedDate() {
		return sampleCollectedDate;
	}

	public void setSampleCollectedDate(LocalDateTime sampleCollectedDate) {
		this.sampleCollectedDate = sampleCollectedDate;
	}

	public LocalDateTime getSampleDispatchDate() {
		return sampleDispatchDate;
	}

	public void setSampleDispatchDate(LocalDateTime sampleDispatchDate) {
		this.sampleDispatchDate = sampleDispatchDate;
	}

	public LocalDateTime getSampleReceivedDate() {
		return sampleReceivedDate;
	}

	public void setSampleReceivedDate(LocalDateTime sampleReceivedDate) {
		this.sampleReceivedDate = sampleReceivedDate;
	}

	public LocalDateTime getResultReceivedDate() {
		return resultReceivedDate;
	}

	public void setResultReceivedDate(LocalDateTime resultReceivedDate) {
		this.resultReceivedDate = resultReceivedDate;
	}

	public LocalDateTime getResultApprovedDate() {
		return resultApprovedDate;
	}

	public void setResultApprovedDate(LocalDateTime resultApprovedDate) {
		this.resultApprovedDate = resultApprovedDate;
	}

	public LocalDateTime getResultDispatchDate() {
		return resultDispatchDate;
	}

	public void setResultDispatchDate(LocalDateTime resultDispatchDate) {
		this.resultDispatchDate = resultDispatchDate;
	}

	public Integer getSampleStatusId() {
		return sampleStatusId;
	}

	public void setSampleStatusId(Integer sampleStatusId) {
		this.sampleStatusId = sampleStatusId;
	}

	public Integer getTestTypeId() {
		return testTypeId;
	}

	public void setTestTypeId(Integer testTypeId) {
		this.testTypeId = testTypeId;
	}

	public Integer getAuthorizerId() {
		return authorizerId;
	}

	public void setAuthorizerId(Integer authorizerId) {
		this.authorizerId = authorizerId;
	}

	public String getAuthorizerSignature() {
		return authorizerSignature;
	}

	public void setAuthorizerSignature(String authorizerSignature) {
		this.authorizerSignature = authorizerSignature;
	}

	public String getBarcodeNumber() {
		return barcodeNumber;
	}

	public void setBarcodeNumber(String barcodeNumber) {
		this.barcodeNumber = barcodeNumber;
	}

	public Integer getResultTypeId() {
		return resultTypeId;
	}

	public void setResultTypeId(Integer resultTypeId) {
		this.resultTypeId = resultTypeId;
	}

	public String getResultValue() {
		return resultValue;
	}

	public void setResultValue(String resultValue) {
		this.resultValue = resultValue;
	}

	public String getLogValue() {
		return logValue;
	}

	public void setLogValue(String logValue) {
		this.logValue = logValue;
	}

	public Boolean getIsError() {
		return isError;
	}

	public void setIsError(Boolean isError) {
		this.isError = isError;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Integer getTestMachineTypeId() {
		return testMachineTypeId;
	}

	public void setTestMachineTypeId(Integer testMachineTypeId) {
		this.testMachineTypeId = testMachineTypeId;
	}

	public Integer getTestMachineId() {
		return testMachineId;
	}

	public void setTestMachineId(Integer testMachineId) {
		this.testMachineId = testMachineId;
	}

	public String getTypeOfSpecimen() {
		return typeOfSpecimen;
	}

	public void setTypeOfSpecimen(String typeOfSpecimen) {
		this.typeOfSpecimen = typeOfSpecimen;
	}

	public Integer getRemarksId() {
		return remarksId;
	}

	public void setRemarksId(Integer remarksId) {
		this.remarksId = remarksId;
	}

//	public Integer getLabTechnicianId() {
//		return labTechnicianId;
//	}
//
//	public void setLabTechnicianId(Integer labTechnicianId) {
//		this.labTechnicianId = labTechnicianId;
//	}

	public String getLabTechnicianSignature() {
		return labTechnicianSignature;
	}

	public void setLabTechnicianSignature(String labTechnicianSignature) {
		this.labTechnicianSignature = labTechnicianSignature;
	}

//	public Integer getLabInchargeId() {
//		return labInchargeId;
//	}
//
//	public void setLabInchargeId(Integer labInchargeId) {
//		this.labInchargeId = labInchargeId;
//	}

	public String getLabInchargeSignature() {
		return labInchargeSignature;
	}

	public void setLabInchargeSignature(String labInchargeSignature) {
		this.labInchargeSignature = labInchargeSignature;
	}

	public String getTestRequestFormLink() {
		return testRequestFormLink;
	}

	public void setTestRequestFormLink(String testRequestFormLink) {
		this.testRequestFormLink = testRequestFormLink;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDate createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDate getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDate modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public UserMaster getLabInCharge() {
		return labInCharge;
	}

	public void setLabInCharge(UserMaster labInCharge) {
		this.labInCharge = labInCharge;
	}

	public UserMaster getLabTecnician() {
		return labTecnician;
	}

	public void setLabTecnician(UserMaster labTecnician) {
		this.labTecnician = labTecnician;
	}
	
    public Long getSampleCollectedFacility() {
		return sampleCollectedFacility;
	}

	public void setSampleCollectedFacility(Long sampleCollectedFacility) {
		this.sampleCollectedFacility = sampleCollectedFacility;
	}

	public Long getDispatchedToLab() {
		return dispatchedToLab;
	}

	public void setDispatchedToLab(Long dispatchedToLab) {
		this.dispatchedToLab = dispatchedToLab;
	}

	// jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LabTestSample)) {
            return false;
        }
        return id != null && id.equals(((LabTestSample) o).id);
    }

	@Override
    public int hashCode() {
        return 31;
    }

    @Override
	public String toString() {
		return "LabTestSample [id=" + id + ", testBatchId=" + testBatchId + ", sampleCollectedDate="
				+ sampleCollectedDate + ", sampleDispatchDate=" + sampleDispatchDate + ", sampleReceivedDate="
				+ sampleReceivedDate + ", resultReceivedDate=" + resultReceivedDate + ", resultApprovedDate="
				+ resultApprovedDate + ", resultDispatchDate=" + resultDispatchDate + ", sampleStatusId="
				+ sampleStatusId + ", testTypeId=" + testTypeId + ", authorizerId=" + authorizerId
				+ ", authorizerSignature=" + authorizerSignature + ", barcodeNumber=" + barcodeNumber
				+ ", resultTypeId=" + resultTypeId + ", resultValue=" + resultValue + ", logValue=" + logValue
				+ ", isError=" + isError + ", errorCode=" + errorCode + ", testMachineTypeId=" + testMachineTypeId
				+ ", testMachineId=" + testMachineId + ", typeOfSpecimen=" + typeOfSpecimen + ", remarksId=" + remarksId
				+ ", labTechnicianSignature=" + labTechnicianSignature + ", labInchargeSignature="
				+ labInchargeSignature + ", testRequestFormLink=" + testRequestFormLink + ", createdBy=" + createdBy
				+ ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime
				+ ", isDelete=" + isDelete + ", sampleCollectedFacility=" + sampleCollectedFacility
				+ ", dispatchedToLab=" + dispatchedToLab + ", beneficiary=" + beneficiary + ", labInCharge="
				+ labInCharge + ", labTecnician=" + labTecnician + "]";
	}
}
