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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A ICTCSampleCollection.
 */
@Entity
@Table(name = "ictc_sample_collection")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ICTCSampleCollection implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 99)
    @Column(name = "barcode", length = 99)
    private String barcode;

    @Column(name = "test_type")
    private Integer testType;
    
    @Column(name = "sample_collection_date")
    private LocalDateTime sampleCollectionDate;
    
    @Column(name = "sample_collection_status")
    private Integer sampleCollectionStatus;
    
    @Column(name = "sample_received_date")
    private LocalDateTime sampleReceivedDate;
   
    @Column(name = "is_dispatched")
    private Boolean isDispatched;

//    @Column(name = "dispatched_to_lab_id")
//    private Integer dispatchedToLabId;
//
//    @Column(name = "dispatch_date")
//    private LocalDate dispatchDate;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_time")
    private LocalDate createdTime;

    @Column(name = "modified_by")
    private Integer modifiedBy;

    @Column(name = "modified_time")
    private LocalDate modifiedTime;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private ICTCSampleBatch batch;
    
    @ManyToOne(optional = false)
	@JoinColumn(name = "ictc_beneficiary_id")
    @NotNull
	private ICTCBeneficiary ictcBeneficiary;
    
    @ManyToOne
    @JoinColumn(name = "visit_id")
    private ICTCVisit visit;

    @ManyToOne
   	@JoinColumn(name = "facility_id")
   	private Facility facility;
    
    @ManyToOne
   	@JoinColumn(name = "lab_technician_id")
    private UserMaster labTechnician;
	
    @ManyToOne
   	@JoinColumn(name = "lab_incharge_id")
	private UserMaster labIncharge;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Integer getTestType() {
		return testType;
	}

	public void setTestType(Integer testType) {
		this.testType = testType;
	}

	public LocalDateTime getSampleCollectionDate() {
		return sampleCollectionDate;
	}

	public void setSampleCollectionDate(LocalDateTime sampleCollectionDate) {
		this.sampleCollectionDate = sampleCollectionDate;
	}

	public Integer getSampleCollectionStatus() {
		return sampleCollectionStatus;
	}

	public void setSampleCollectionStatus(Integer sampleCollectionStatus) {
		this.sampleCollectionStatus = sampleCollectionStatus;
	}

	public Boolean getIsDispatched() {
		return isDispatched;
	}

	public void setIsDispatched(Boolean isDispatched) {
		this.isDispatched = isDispatched;
	}

//	public Integer getDispatchedToLabId() {
//		return dispatchedToLabId;
//	}
//
//	public void setDispatchedToLabId(Integer dispatchedToLabId) {
//		this.dispatchedToLabId = dispatchedToLabId;
//	}
//
//	public LocalDate getDispatchDate() {
//		return dispatchDate;
//	}
//
//	public void setDispatchDate(LocalDate dispatchDate) {
//		this.dispatchDate = dispatchDate;
//	}

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

	public ICTCSampleBatch getBatch() {
		return batch;
	}

	public void setBatch(ICTCSampleBatch batch) {
		this.batch = batch;
	}

	public ICTCBeneficiary getIctcBeneficiary() {
		return ictcBeneficiary;
	}

	public void setIctcBeneficiary(ICTCBeneficiary ictcBeneficiary) {
		this.ictcBeneficiary = ictcBeneficiary;
	}

	public ICTCVisit getVisit() {
		return visit;
	}

	public void setVisit(ICTCVisit visit) {
		this.visit = visit;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    public UserMaster getLabTechnician() {
		return labTechnician;
	}

	public void setLabTechnician(UserMaster labTechnician) {
		this.labTechnician = labTechnician;
	}

	public UserMaster getLabIncharge() {
		return labIncharge;
	}

	public void setLabIncharge(UserMaster labIncharge) {
		this.labIncharge = labIncharge;
	}
	
	public LocalDateTime getSampleReceivedDate() {
		return sampleReceivedDate;
	}

	public void setSampleReceivedDate(LocalDateTime sampleReceivedDate) {
		this.sampleReceivedDate = sampleReceivedDate;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ICTCSampleCollection)) {
            return false;
        }
        return id != null && id.equals(((ICTCSampleCollection) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

	@Override
	public String toString() {
		return "ICTCSampleCollection [id=" + id + ", barcode=" + barcode + ", testType=" + testType
				+ ", sampleCollectionDate=" + sampleCollectionDate + ", sampleCollectionStatus="
				+ sampleCollectionStatus + ", isDispatched=" + isDispatched + ", isActive=" + isActive + ", isDeleted="
				+ isDeleted + ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy
				+ ", modifiedTime=" + modifiedTime + ", batch=" + batch + ", ictcBeneficiary=" + ictcBeneficiary
				+ ", visit=" + visit + ", facility=" + facility + ", labTechnician=" + labTechnician + ", labIncharge="
				+ labIncharge + "]";
	}

}
