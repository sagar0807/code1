package gov.naco.soch.entity;

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
import javax.validation.constraints.Size;

/**
 * A IctcSampleBatch.
 */
@Entity
@Table(name = "ictc_sample_batch")
public class IctcSampleBatch implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 25)
    @Column(name = "consignment_id", length = 25)
    private String consignmentId;

    @Column(name = "dispatch_date")
    private LocalDateTime dispatchDate;

    @Column(name = "batch_status")
    private Long batchStatus;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_time")
    private LocalDate createdTime;

    @Column(name = "modified_by")
    private Long modifiedBy;

    @Column(name = "modified_time")
    private LocalDate modifiedTime;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
    
    @ManyToOne
	@JoinColumn(name = "facility_id")
	private Facility facility;

    @ManyToOne
	@JoinColumn(name = "lab_id")
	private Facility lab;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConsignmentId() {
		return consignmentId;
	}

	public void setConsignmentId(String consignmentId) {
		this.consignmentId = consignmentId;
	}

	public LocalDateTime getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(LocalDateTime dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public Long getBatchStatus() {
		return batchStatus;
	}

	public void setBatchStatus(Long batchStatus) {
		this.batchStatus = batchStatus;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDate createdTime) {
		this.createdTime = createdTime;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDate getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDate modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Facility getLab() {
		return lab;
	}

	public void setLab(Facility lab) {
		this.lab = lab;
	}

	@Override
    public int hashCode() {
        return 31;
    }
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof IctcSampleBatch)) {
			return false;
		}
		return id != null && id.equals(((IctcSampleBatch) o).id);
	}

	@Override
	public String toString() {
		return "IctcSampleBatch [id=" + id + ", consignmentId=" + consignmentId + ", dispatchDate=" + dispatchDate
				+ ", batchStatus=" + batchStatus + ", createdBy=" + createdBy + ", createdTime=" + createdTime
				+ ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime + ", isActive=" + isActive
				+ ", isDeleted=" + isDeleted + ", facility=" + facility + ", lab=" + lab + "]";
	}

}
