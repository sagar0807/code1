package gov.naco.soch.service.dto;

import java.io.Serializable;

import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;



/**
 * Criteria class for the ICTCTestResult entity. This class is used in ICTCTestResultResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /ictc-test-results?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ICTCTestResultCriteria implements Serializable {
    private static final long serialVersionUID = 1L;


    private LongFilter id;

//    private LocalDateFilter testedDate;

    private IntegerFilter resultStatus;

    private IntegerFilter hivStatus;

    private IntegerFilter hivType;

    private LocalDateFilter reportReceivedDate;

    private LocalDateFilter reportDeliveryDate;

    private BooleanFilter isTestedForTb;

    private IntegerFilter tbTestResult;

    private BooleanFilter isTestedForSyphilis;

    private IntegerFilter syphilisTestResult;

//    private BooleanFilter followupRequired;
//
//    private BooleanFilter isReferedToART;

    private BooleanFilter isActive;

    private BooleanFilter isDeleted;

    private IntegerFilter createdBy;

    private LocalDateFilter createdTime;

    private IntegerFilter modifiedBy;

    private LocalDateFilter modifiedTime;

    private LongFilter ictcBeneficiaryId;

    private LongFilter sampleId;

    private LongFilter visitId;

    public ICTCTestResultCriteria() {
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

//    public LocalDateFilter getTestedDate() {
//        return testedDate;
//    }
//
//    public void setTestedDate(LocalDateFilter testedDate) {
//        this.testedDate = testedDate;
//    }

    public IntegerFilter getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(IntegerFilter resultStatus) {
        this.resultStatus = resultStatus;
    }

    public IntegerFilter getHivStatus() {
        return hivStatus;
    }

    public void setHivStatus(IntegerFilter hivStatus) {
        this.hivStatus = hivStatus;
    }

    public IntegerFilter getHivType() {
        return hivType;
    }

    public void setHivType(IntegerFilter hivType) {
        this.hivType = hivType;
    }

    public LocalDateFilter getReportReceivedDate() {
        return reportReceivedDate;
    }

    public void setReportReceivedDate(LocalDateFilter reportReceivedDate) {
        this.reportReceivedDate = reportReceivedDate;
    }

    public LocalDateFilter getReportDeliveryDate() {
        return reportDeliveryDate;
    }

    public void setReportDeliveryDate(LocalDateFilter reportDeliveryDate) {
        this.reportDeliveryDate = reportDeliveryDate;
    }

    public BooleanFilter getIsTestedForTb() {
        return isTestedForTb;
    }

    public void setIsTestedForTb(BooleanFilter isTestedForTb) {
        this.isTestedForTb = isTestedForTb;
    }

    public IntegerFilter getTbTestResult() {
        return tbTestResult;
    }

    public void setTbTestResult(IntegerFilter tbTestResult) {
        this.tbTestResult = tbTestResult;
    }

    public BooleanFilter getIsTestedForSyphilis() {
        return isTestedForSyphilis;
    }

    public void setIsTestedForSyphilis(BooleanFilter isTestedForSyphilis) {
        this.isTestedForSyphilis = isTestedForSyphilis;
    }

    public IntegerFilter getSyphilisTestResult() {
        return syphilisTestResult;
    }

    public void setSyphilisTestResult(IntegerFilter syphilisTestResult) {
        this.syphilisTestResult = syphilisTestResult;
    }

//    public BooleanFilter getFollowupRequired() {
//        return followupRequired;
//    }
//
//    public void setFollowupRequired(BooleanFilter followupRequired) {
//        this.followupRequired = followupRequired;
//    }
//
//    public BooleanFilter getIsReferedToART() {
//        return isReferedToART;
//    }
//
//    public void setIsReferedToART(BooleanFilter isReferedToART) {
//        this.isReferedToART = isReferedToART;
//    }

    public BooleanFilter getIsActive() {
        return isActive;
    }

    public void setIsActive(BooleanFilter isActive) {
        this.isActive = isActive;
    }

    public BooleanFilter getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(BooleanFilter isDeleted) {
        this.isDeleted = isDeleted;
    }

    public IntegerFilter getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(IntegerFilter createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateFilter getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateFilter createdTime) {
        this.createdTime = createdTime;
    }

    public IntegerFilter getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(IntegerFilter modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateFilter getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateFilter modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public LongFilter getIctcBeneficiaryId() {
        return ictcBeneficiaryId;
    }

    public void setIctcBeneficiaryId(LongFilter ictcBeneficiaryId) {
        this.ictcBeneficiaryId = ictcBeneficiaryId;
    }
    
    public LongFilter getSampleId() {
		return sampleId;
	}

	public void setSampleId(LongFilter sampleId) {
		this.sampleId = sampleId;
	}

	public LongFilter getVisitId() {
		return visitId;
	}

	public void setVisitId(LongFilter visitId) {
		this.visitId = visitId;
	}

	@Override
	public String toString() {
		return "ICTCTestResultCriteria [id=" + id + ", resultStatus=" + resultStatus + ", hivStatus=" + hivStatus
				+ ", hivType=" + hivType + ", reportReceivedDate=" + reportReceivedDate + ", reportDeliveryDate="
				+ reportDeliveryDate + ", isTestedForTb=" + isTestedForTb + ", tbTestResult=" + tbTestResult
				+ ", isTestedForSyphilis=" + isTestedForSyphilis + ", syphilisTestResult=" + syphilisTestResult
				+ ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", createdBy=" + createdBy + ", createdTime="
				+ createdTime + ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime + ", ictcBeneficiaryId="
				+ ictcBeneficiaryId + ", sampleId=" + sampleId + ", visitId=" + visitId + "]";
	}

}
