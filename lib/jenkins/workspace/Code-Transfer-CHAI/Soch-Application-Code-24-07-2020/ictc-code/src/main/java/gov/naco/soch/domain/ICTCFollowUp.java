package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A ICTCFollowUp.
 */
@Entity
@Table(name = "ictc_follow_up")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ICTCFollowUp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "follow_up_type")
    private Integer followUpType;

    @Column(name = "follow_up_date")
    private LocalDate followUpDate;
    
//    @Size(max = 200)
//    @Column(name = "remarks", length = 200)
//    private String remarks;

    @Column(name = "is_completed")
    private Boolean isCompleted;

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
    @NotNull
    @JoinColumn(name = "ictc_beneficiary_id")
    private ICTCBeneficiary ictcBeneficiary;
    
    @ManyToOne
    @JoinColumn(name = "visit_id")
    private ICTCVisit visit;

    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;
    
    @ManyToOne
    @JoinColumn(name = "test_result_id")
    private ICTCTestResult testResult;
    
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFollowUpDate() {
        return followUpDate;
    }

    public ICTCFollowUp followUpDate(LocalDate followUpDate) {
        this.followUpDate = followUpDate;
        return this;
    }

    public void setFollowUpDate(LocalDate followUpDate) {
        this.followUpDate = followUpDate;
    }

//    String getRemarks() {
//        return remarks;
//    }
//
//    public ICTCFollowUp remarks(String remarks) {
//        this.remarks = remarks;
//        return this;
//    }
//
//    public void setRemarks(String remarks) {
//        this.remarks = remarks;
//    }

    public Boolean isIsCompleted() {
        return isCompleted;
    }

    public ICTCFollowUp isCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
        return this;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public ICTCFollowUp createdBy(Integer createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedTime() {
        return createdTime;
    }

    public ICTCFollowUp createdTime(LocalDate createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public void setCreatedTime(LocalDate createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public ICTCFollowUp modifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDate getModifiedTime() {
        return modifiedTime;
    }

    public ICTCFollowUp modifiedTime(LocalDate modifiedTime) {
        this.modifiedTime = modifiedTime;
        return this;
    }

    public void setModifiedTime(LocalDate modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public ICTCFollowUp isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isIsDeleted() {
        return isDeleted;
    }

    public ICTCFollowUp isDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public ICTCVisit getVisit() {
        return visit;
    }

    public ICTCFollowUp visit(ICTCVisit iCTCVisit) {
        this.visit = iCTCVisit;
        return this;
    }

    public void setVisit(ICTCVisit iCTCVisit) {
        this.visit = iCTCVisit;
    }
    
    
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    public Integer getFollowUpType() {
		return followUpType;
	}

	public void setFollowUpType(Integer followUpType) {
		this.followUpType = followUpType;
	}

	public ICTCBeneficiary getIctcBeneficiary() {
		return ictcBeneficiary;
	}

	public void setIctcBeneficiary(ICTCBeneficiary ictcBeneficiary) {
		this.ictcBeneficiary = ictcBeneficiary;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public ICTCTestResult getTestResult() {
		return testResult;
	}

	public void setTestResult(ICTCTestResult testResult) {
		this.testResult = testResult;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ICTCFollowUp)) {
            return false;
        }
        return id != null && id.equals(((ICTCFollowUp) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

	@Override
	public String toString() {
		return "ICTCFollowUp [id=" + id + ", followUpType=" + followUpType + ", followUpDate=" + followUpDate
				+ ", isCompleted=" + isCompleted + ", isActive=" + isActive + ", isDeleted=" + isDeleted
				+ ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy
				+ ", modifiedTime=" + modifiedTime + ", ictcBeneficiary=" + ictcBeneficiary + ", visit=" + visit
				+ ", facility=" + facility + ", testResult=" + testResult + "]";
	}

}
