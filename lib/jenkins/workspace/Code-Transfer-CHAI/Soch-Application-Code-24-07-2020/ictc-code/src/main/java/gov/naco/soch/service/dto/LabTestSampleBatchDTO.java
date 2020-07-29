package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.LabTestSampleBatch} entity.
 */
public class LabTestSampleBatchDTO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private Long id;

    private String bdnSerialNumber;

    private Long sourceLabId;

    private Long sourceLabTechId;

    private Long labId;
    
    private Long artcId;

	private Long labTechId;

    private LocalDateTime dispatchDate;

    private LocalDateTime receviedDate;

    private Integer numOfSamples;

    private Integer acceptedSamples;

    private Integer rejectedSamples;

    private Integer batchStatusId;

    private Integer createdBy;

    private LocalDate createdTime;

    private Integer modifiedBy;

    private LocalDate modifiedTime;

    private Boolean isDelete;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBdnSerialNumber() {
        return bdnSerialNumber;
    }

    public void setBdnSerialNumber(String bdnSerialNumber) {
        this.bdnSerialNumber = bdnSerialNumber;
    }

    public Long getSourceLabId() {
        return sourceLabId;
    }

    public void setSourceLabId(Long sourceLabId) {
        this.sourceLabId = sourceLabId;
    }

    public Long getSourceLabTechId() {
        return sourceLabTechId;
    }

    public void setSourceLabTechId(Long sourceLabTechId) {
        this.sourceLabTechId = sourceLabTechId;
    }
    
    
    public Long getArtcId() {
		return artcId;
	}

	public void setArtcId(Long artcId) {
		this.artcId = artcId;
	}

    public Long getLabId() {
        return labId;
    }

    public void setLabId(Long labId) {
        this.labId = labId;
    }

    public Long getLabTechId() {
        return labTechId;
    }

    public void setLabTechId(Long labTechId) {
        this.labTechId = labTechId;
    }

    public LocalDateTime getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(LocalDateTime dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public LocalDateTime getReceviedDate() {
        return receviedDate;
    }

    public void setReceviedDate(LocalDateTime receviedDate) {
        this.receviedDate = receviedDate;
    }

    public Integer getNumOfSamples() {
        return numOfSamples;
    }

    public void setNumOfSamples(Integer numOfSamples) {
        this.numOfSamples = numOfSamples;
    }

    public Integer getAcceptedSamples() {
        return acceptedSamples;
    }

    public void setAcceptedSamples(Integer acceptedSamples) {
        this.acceptedSamples = acceptedSamples;
    }

    public Integer getRejectedSamples() {
        return rejectedSamples;
    }

    public void setRejectedSamples(Integer rejectedSamples) {
        this.rejectedSamples = rejectedSamples;
    }

    public Integer getBatchStatusId() {
        return batchStatusId;
    }

    public void setBatchStatusId(Integer batchStatusId) {
        this.batchStatusId = batchStatusId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LabTestSampleBatchDTO labTestSampleBatchDTO = (LabTestSampleBatchDTO) o;
        if (labTestSampleBatchDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), labTestSampleBatchDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "LabTestSampleBatchDTO{" +
            "id=" + getId() +
            ", bdnSerialNumber='" + getBdnSerialNumber() + "'" +
            ", sourceLabId=" + getSourceLabId() +
            ", sourceLabTechId=" + getSourceLabTechId() +
            ", labId=" + getLabId() +
            ", labTechId=" + getLabTechId() +
            ", dispatchDate='" + getDispatchDate() + "'" +
            ", receviedDate='" + getReceviedDate() + "'" +
            ", numOfSamples=" + getNumOfSamples() +
            ", acceptedSamples=" + getAcceptedSamples() +
            ", rejectedSamples=" + getRejectedSamples() +
            ", batchStatusId=" + getBatchStatusId() +
            ", createdBy=" + getCreatedBy() +
            ", createdTime='" + getCreatedTime() + "'" +
            ", modifiedBy=" + getModifiedBy() +
            ", modifiedTime='" + getModifiedTime() + "'" +
            ", isDelete='" + isIsDelete() + "'" +
            "}";
    }
}
