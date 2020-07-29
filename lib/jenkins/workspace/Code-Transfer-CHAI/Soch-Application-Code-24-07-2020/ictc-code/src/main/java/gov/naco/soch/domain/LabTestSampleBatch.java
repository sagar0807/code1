package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A LabTestSampleBatch.
 */
@Entity
@Table(name = "lab_test_sample_batch")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LabTestSampleBatch implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bdn_serial_number")
    private String bdnSerialNumber;
    
    @Column(name = "artc_id")
    private Long artcId;

	@Column(name = "lab_id")
    private Long labId;

    @Column(name = "dispatch_date")
    private LocalDateTime dispatchDate;

    @Column(name = "received_date")
    private LocalDateTime receivedDate;

    @Column(name = "num_of_samples")
    private Integer numOfSamples;

    @Column(name = "accepted_samples")
    private Integer acceptedSamples;

    @Column(name = "rejected_samples")
    private Integer rejectedSamples;

    @Column(name = "batch_status_id")
    private Integer batchStatusId;

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
    
    @ManyToOne
	@JoinColumn(name = "lab_tech_id")
	private UserMaster labTechnician;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBdnSerialNumber() {
        return bdnSerialNumber;
    }

    public LabTestSampleBatch bdnSerialNumber(String bdnSerialNumber) {
        this.bdnSerialNumber = bdnSerialNumber;
        return this;
    }

    public void setBdnSerialNumber(String bdnSerialNumber) {
        this.bdnSerialNumber = bdnSerialNumber;
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

    public LabTestSampleBatch labId(Long labId) {
        this.labId = labId;
        return this;
    }

    public void setLabId(Long labId) {
        this.labId = labId;
    }

    public LocalDateTime getDispatchDate() {
        return dispatchDate;
    }

    public LabTestSampleBatch dispatchDate(LocalDateTime dispatchDate) {
        this.dispatchDate = dispatchDate;
        return this;
    }

    public void setDispatchDate(LocalDateTime dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public LocalDateTime getReceviedDate() {
        return receivedDate;
    }

    public LabTestSampleBatch receviedDate(LocalDateTime receviedDate) {
        this.receivedDate = receviedDate;
        return this;
    }

    public void setReceviedDate(LocalDateTime receviedDate) {
        this.receivedDate = receviedDate;
    }

    public Integer getNumOfSamples() {
        return numOfSamples;
    }

    public LabTestSampleBatch numOfSamples(Integer numOfSamples) {
        this.numOfSamples = numOfSamples;
        return this;
    }

    public void setNumOfSamples(Integer numOfSamples) {
        this.numOfSamples = numOfSamples;
    }

    public Integer getAcceptedSamples() {
        return acceptedSamples;
    }

    public LabTestSampleBatch acceptedSamples(Integer acceptedSamples) {
        this.acceptedSamples = acceptedSamples;
        return this;
    }

    public void setAcceptedSamples(Integer acceptedSamples) {
        this.acceptedSamples = acceptedSamples;
    }

    public Integer getRejectedSamples() {
        return rejectedSamples;
    }

    public LabTestSampleBatch rejectedSamples(Integer rejectedSamples) {
        this.rejectedSamples = rejectedSamples;
        return this;
    }

    public void setRejectedSamples(Integer rejectedSamples) {
        this.rejectedSamples = rejectedSamples;
    }

    public Integer getBatchStatusId() {
        return batchStatusId;
    }

    public LabTestSampleBatch batchStatusId(Integer batchStatusId) {
        this.batchStatusId = batchStatusId;
        return this;
    }

    public void setBatchStatusId(Integer batchStatusId) {
        this.batchStatusId = batchStatusId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public LabTestSampleBatch createdBy(Integer createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedTime() {
        return createdTime;
    }

    public LabTestSampleBatch createdTime(LocalDate createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public void setCreatedTime(LocalDate createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public LabTestSampleBatch modifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDate getModifiedTime() {
        return modifiedTime;
    }

    public LabTestSampleBatch modifiedTime(LocalDate modifiedTime) {
        this.modifiedTime = modifiedTime;
        return this;
    }

    public void setModifiedTime(LocalDate modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Boolean isIsDelete() {
        return isDelete;
    }

    public LabTestSampleBatch isDelete(Boolean isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
    
    
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    public UserMaster getLabTechnician() {
		return labTechnician;
	}

	public void setLabTechnician(UserMaster labTechnician) {
		this.labTechnician = labTechnician;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LabTestSampleBatch)) {
            return false;
        }
        return id != null && id.equals(((LabTestSampleBatch) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

	@Override
	public String toString() {
		return "LabTestSampleBatch [id=" + id + ", bdnSerialNumber=" + bdnSerialNumber + ", artcId=" + artcId
				+ ", labId=" + labId + ", dispatchDate=" + dispatchDate + ", receivedDate=" + receivedDate
				+ ", numOfSamples=" + numOfSamples + ", acceptedSamples=" + acceptedSamples + ", rejectedSamples="
				+ rejectedSamples + ", batchStatusId=" + batchStatusId + ", createdBy=" + createdBy + ", createdTime="
				+ createdTime + ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime + ", isDelete="
				+ isDelete + ", labTechnician=" + labTechnician + "]";
	}

}
