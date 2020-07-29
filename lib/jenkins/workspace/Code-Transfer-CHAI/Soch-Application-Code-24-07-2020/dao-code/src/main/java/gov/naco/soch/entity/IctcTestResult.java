package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
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

/**
 * A IctcTestResult.
 */
@Entity
@Table(name = "ictc_test_result")
public class IctcTestResult implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tested_date")
    private LocalDate testedDate;

    @Column(name = "result_status")
    private Long resultStatus;

    @Column(name = "hiv_status")
    private Long hivStatus;

    @Column(name = "hiv_type")
    private Long hivType;

    @Column(name = "report_received_date")
    private LocalDate reportReceivedDate;

    @Column(name = "report_delivery_date")
    private LocalDate reportDeliveryDate;

    @Column(name = "is_tested_for_tb")
    private Boolean isTestedForTb;

    @Column(name = "tb_test_result")
    private Long tbTestResult;

    @Column(name = "is_tested_for_syphilis")
    private Boolean isTestedForSyphilis;

    @Column(name = "syphilis_test_result")
    private Long syphilisTestResult;

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
    private Long createdBy;

    @Column(name = "created_time")
    private LocalDate createdTime;

    @Column(name = "modified_by")
    private Long modifiedBy;

    @Column(name = "modified_time")
    private LocalDate modifiedTime;
    
//    @Column(name = "test_sequence")
//    private Long testSequence;

    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name = "ictc_beneficiary_id")
    private IctcBeneficiary ictcBeneficiary;

    @ManyToOne
    @JoinColumn(name = "sample_id")
    private IctcSampleCollection sample;

    @ManyToOne
    @JoinColumn(name = "visit_id")
    private IctcVisit visit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getTestedDate() {
		return testedDate;
	}

	public void setTestedDate(LocalDate testedDate) {
		this.testedDate = testedDate;
	}

	public Long getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(Long resultStatus) {
		this.resultStatus = resultStatus;
	}

	public Long getHivStatus() {
		return hivStatus;
	}

	public void setHivStatus(Long hivStatus) {
		this.hivStatus = hivStatus;
	}

	public Long getHivType() {
		return hivType;
	}

	public void setHivType(Long hivType) {
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

	public Long getTbTestResult() {
		return tbTestResult;
	}

	public void setTbTestResult(Long tbTestResult) {
		this.tbTestResult = tbTestResult;
	}

	public Boolean getIsTestedForSyphilis() {
		return isTestedForSyphilis;
	}

	public void setIsTestedForSyphilis(Boolean isTestedForSyphilis) {
		this.isTestedForSyphilis = isTestedForSyphilis;
	}

	public Long getSyphilisTestResult() {
		return syphilisTestResult;
	}

	public void setSyphilisTestResult(Long syphilisTestResult) {
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

//	public Long getTestSequence() {
//		return testSequence;
//	}
//
//	public void setTestSequence(Long testSequence) {
//		this.testSequence = testSequence;
//	}

	public IctcBeneficiary getIctcBeneficiary() {
		return ictcBeneficiary;
	}

	public void setIctcBeneficiary(IctcBeneficiary ictcBeneficiary) {
		this.ictcBeneficiary = ictcBeneficiary;
	}

	public IctcSampleCollection getSample() {
		return sample;
	}

	public void setSample(IctcSampleCollection sample) {
		this.sample = sample;
	}

	public IctcVisit getVisit() {
		return visit;
	}

	public void setVisit(IctcVisit visit) {
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
        IctcTestResult IctcTestResult = (IctcTestResult) o;
        if (IctcTestResult.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), IctcTestResult.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "IctcTestResult [id=" + id + ", testedDate=" + testedDate + ", resultStatus=" + resultStatus
				+ ", hivStatus=" + hivStatus + ", hivType=" + hivType + ", reportReceivedDate=" + reportReceivedDate
				+ ", reportDeliveryDate=" + reportDeliveryDate + ", isTestedForTb=" + isTestedForTb + ", tbTestResult="
				+ tbTestResult + ", isTestedForSyphilis=" + isTestedForSyphilis + ", syphilisTestResult="
				+ syphilisTestResult + ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", createdBy="
				+ createdBy + ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy + ", modifiedTime="
				+ modifiedTime + ", ictcBeneficiary=" + ictcBeneficiary + ", sample=" + sample + ", visit=" + visit
				+ "]";
	}

}
