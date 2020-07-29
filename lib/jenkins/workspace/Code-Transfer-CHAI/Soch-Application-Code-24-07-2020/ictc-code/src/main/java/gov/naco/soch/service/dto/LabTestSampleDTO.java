package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.LabTestSample} entity.
 */
public class LabTestSampleDTO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Long testBatchId;

    private LocalDateTime sampleCollectedDate;

    private LocalDateTime sampleDispatchDate;

    private LocalDateTime sampleReceivedDate;

    private LocalDateTime resultReceivedDate;

    private LocalDateTime resultApprovedDate;

    private LocalDateTime resultDispatchDate;

    private Integer sampleStatusId;

    private Integer testTypeId;

    private Integer authorizerId;

    private String authorizerSignature;

    private String barcodeNumber;

    private Integer resultTypeId;

    private String resultValue;

    private String logValue;

    private Boolean isError;

    private String errorCode;

    private Integer testMachineTypeId;

    private Integer testMachineId;

    private String typeOfSpecimen;

    private Integer remarksId;

    private Integer labTechnicianId;

    private String labTechnicianSignature;

    private Integer labInchargeId;

    private String labInchargeSignature;

    private String testRequestFormLink;

    private Integer createdBy;

    private LocalDate createdTime;

    private Integer modifiedBy;

    private LocalDate modifiedTime;

    private Boolean isDelete;

    private Long beneficiaryId;
    
    private Long sampleCollectedFacility;
	
	private Long dispatchedToLab;
    
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

    public Boolean isIsError() {
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

    public Integer getLabTechnicianId() {
        return labTechnicianId;
    }

    public void setLabTechnicianId(Integer labTechnicianId) {
        this.labTechnicianId = labTechnicianId;
    }

    public String getLabTechnicianSignature() {
        return labTechnicianSignature;
    }

    public void setLabTechnicianSignature(String labTechnicianSignature) {
        this.labTechnicianSignature = labTechnicianSignature;
    }

    public Integer getLabInchargeId() {
        return labInchargeId;
    }

    public void setLabInchargeId(Integer labInchargeId) {
        this.labInchargeId = labInchargeId;
    }

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

    public Boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
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

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LabTestSampleDTO labTestSampleDTO = (LabTestSampleDTO) o;
        if (labTestSampleDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), labTestSampleDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
	public String toString() {
		return "LabTestSampleDTO [id=" + id + ", testBatchId=" + testBatchId + ", sampleCollectedDate="
				+ sampleCollectedDate + ", sampleDispatchDate=" + sampleDispatchDate + ", sampleReceivedDate="
				+ sampleReceivedDate + ", resultReceivedDate=" + resultReceivedDate + ", resultApprovedDate="
				+ resultApprovedDate + ", resultDispatchDate=" + resultDispatchDate + ", sampleStatusId="
				+ sampleStatusId + ", testTypeId=" + testTypeId + ", authorizerId=" + authorizerId
				+ ", authorizerSignature=" + authorizerSignature + ", barcodeNumber=" + barcodeNumber
				+ ", resultTypeId=" + resultTypeId + ", resultValue=" + resultValue + ", logValue=" + logValue
				+ ", isError=" + isError + ", errorCode=" + errorCode + ", testMachineTypeId=" + testMachineTypeId
				+ ", testMachineId=" + testMachineId + ", typeOfSpecimen=" + typeOfSpecimen + ", remarksId=" + remarksId
				+ ", labTechnicianId=" + labTechnicianId + ", labTechnicianSignature=" + labTechnicianSignature
				+ ", labInchargeId=" + labInchargeId + ", labInchargeSignature=" + labInchargeSignature
				+ ", testRequestFormLink=" + testRequestFormLink + ", createdBy=" + createdBy + ", createdTime="
				+ createdTime + ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime + ", isDelete="
				+ isDelete + ", beneficiaryId=" + beneficiaryId + ", sampleCollectedFacility=" + sampleCollectedFacility
				+ ", dispatchedToLab=" + dispatchedToLab + "]";
	}
}
