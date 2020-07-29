package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

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
 * A ICTCTestResult.
 */
@Entity
@Table(name = "ictc_test_result")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ICTCTestResult implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tested_date")
    private LocalDateTime testedDate;

    @Column(name = "result_status")
    private Integer resultStatus;

    @Column(name = "hiv_status")
    private Integer hivStatus;

    @Column(name = "hiv_type")
    private Integer hivType;

    @Column(name = "report_received_date")
    private LocalDate reportReceivedDate;

    @Column(name = "report_delivery_date")
    private LocalDate reportDeliveryDate;

    @Column(name = "is_tested_for_tb")
    private Boolean isTestedForTb;

    @Column(name = "tb_test_result")
    private Integer tbTestResult;

    @Column(name = "is_tested_for_syphilis")
    private Boolean isTestedForSyphilis;

    @Column(name = "syphilis_test_result")
    private Integer syphilisTestResult;

//    @Column(name = "followup_required")
//    private Boolean followupRequired;
//
//    @Column(name = "is_refered_to_ART")
//    private Boolean isReferedToART;

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
    
//    @Column(name = "test_sequence")
//    private Integer testSequence;

    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name = "ictc_beneficiary_id")
    private ICTCBeneficiary ictcBeneficiary;

    @ManyToOne
    @JoinColumn(name = "sample_id")
    private ICTCSampleCollection sample;

    @ManyToOne
    @JoinColumn(name = "visit_id")
    private ICTCVisit visit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getTestedDate() {
		return testedDate;
	}

	public void setTestedDate(LocalDateTime testedDate) {
		this.testedDate = testedDate;
	}

	public Integer getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(Integer resultStatus) {
		this.resultStatus = resultStatus;
	}

	public Integer getHivStatus() {
		return hivStatus;
	}

	public void setHivStatus(Integer hivStatus) {
		this.hivStatus = hivStatus;
	}

	public Integer getHivType() {
		return hivType;
	}

	public void setHivType(Integer hivType) {
		this.hivType = hivType;
	}

	public LocalDate getReportReceivedDate() {
		return reportReceivedDate;
	}

	public void setReportReceivedDate(LocalDate reportReceivedDate) {
		this.reportReceivedDate = reportReceivedDate;
	}

	public LocalDate getReportDeliveryDate() {
		return reportDeliveryDate;
	}

	public void setReportDeliveryDate(LocalDate reportDeliveryDate) {
		this.reportDeliveryDate = reportDeliveryDate;
	}

	public Boolean getIsTestedForTb() {
		return isTestedForTb;
	}

	public void setIsTestedForTb(Boolean isTestedForTb) {
		this.isTestedForTb = isTestedForTb;
	}

	public Integer getTbTestResult() {
		return tbTestResult;
	}

	public void setTbTestResult(Integer tbTestResult) {
		this.tbTestResult = tbTestResult;
	}

	public Boolean getIsTestedForSyphilis() {
		return isTestedForSyphilis;
	}

	public void setIsTestedForSyphilis(Boolean isTestedForSyphilis) {
		this.isTestedForSyphilis = isTestedForSyphilis;
	}

	public Integer getSyphilisTestResult() {
		return syphilisTestResult;
	}

	public void setSyphilisTestResult(Integer syphilisTestResult) {
		this.syphilisTestResult = syphilisTestResult;
	}

//	public Boolean getFollowupRequired() {
//		return followupRequired;
//	}
//
//	public void setFollowupRequired(Boolean followupRequired) {
//		this.followupRequired = followupRequired;
//	}
//
//	public Boolean getIsReferedToART() {
//		return isReferedToART;
//	}
//
//	public void setIsReferedToART(Boolean isReferedToART) {
//		this.isReferedToART = isReferedToART;
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
//
//	public Integer getTestSequence() {
//		return testSequence;
//	}
//
//	public void setTestSequence(Integer testSequence) {
//		this.testSequence = testSequence;
//	}

	public ICTCBeneficiary getIctcBeneficiary() {
		return ictcBeneficiary;
	}

	public void setIctcBeneficiary(ICTCBeneficiary ictcBeneficiary) {
		this.ictcBeneficiary = ictcBeneficiary;
	}

	public ICTCSampleCollection getSample() {
		return sample;
	}

	public void setSample(ICTCSampleCollection sample) {
		this.sample = sample;
	}

	public ICTCVisit getVisit() {
		return visit;
	}

	public void setVisit(ICTCVisit visit) {
		this.visit = visit;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ICTCTestResult iCTCTestResult = (ICTCTestResult) o;
        if (iCTCTestResult.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), iCTCTestResult.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "ICTCTestResult [id=" + id + ", testedDate=" + testedDate + ", resultStatus=" + resultStatus
				+ ", hivStatus=" + hivStatus + ", hivType=" + hivType + ", reportReceivedDate=" + reportReceivedDate
				+ ", reportDeliveryDate=" + reportDeliveryDate + ", isTestedForTb=" + isTestedForTb + ", tbTestResult="
				+ tbTestResult + ", isTestedForSyphilis=" + isTestedForSyphilis + ", syphilisTestResult="
				+ syphilisTestResult + ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", createdBy="
				+ createdBy + ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy + ", modifiedTime="
				+ modifiedTime + ", ictcBeneficiary=" + ictcBeneficiary + ", sample=" + sample + ", visit=" + visit
				+ "]";
	}

}
