package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link gov.naco.soch.domain.ICTCBatchDetails} entity. This class is used
 * in {@link gov.naco.soch.web.rest.ICTCBatchDetailsResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ictc-batch-details?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ICTCBatchDetailsCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private LongFilter labId;

    private StringFilter consignmentId;

//    private LocalDateFilter dispatchDate;

    private IntegerFilter sampleCount;

    private IntegerFilter acceptedSampleCount;

    private IntegerFilter rejectedSampleCount;

    private StringFilter batchStatus;

    private LongFilter facilityId;
    
    private StringFilter eidLabName;

    public ICTCBatchDetailsCriteria() {
    }

    public ICTCBatchDetailsCriteria(ICTCBatchDetailsCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.labId = other.labId == null ? null : other.labId.copy();
        this.consignmentId = other.consignmentId == null ? null : other.consignmentId.copy();
//        this.dispatchDate = other.dispatchDate == null ? null : other.dispatchDate.copy();
        this.sampleCount = other.sampleCount == null ? null : other.sampleCount.copy();
        this.acceptedSampleCount = other.acceptedSampleCount == null ? null : other.acceptedSampleCount.copy();
        this.rejectedSampleCount = other.rejectedSampleCount == null ? null : other.rejectedSampleCount.copy();
        this.batchStatus = other.batchStatus == null ? null : other.batchStatus.copy();
        this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
    }

    @Override
    public ICTCBatchDetailsCriteria copy() {
        return new ICTCBatchDetailsCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public LongFilter getLabId() {
        return labId;
    }

    public void setLabId(LongFilter labId) {
        this.labId = labId;
    }

    public StringFilter getConsignmentId() {
        return consignmentId;
    }

    public void setConsignmentId(StringFilter consignmentId) {
        this.consignmentId = consignmentId;
    }

//    public LocalDateFilter getDispatchDate() {
//        return dispatchDate;
//    }
//
//    public void setDispatchDate(LocalDateFilter dispatchDate) {
//        this.dispatchDate = dispatchDate;
//    }

    public IntegerFilter getSampleCount() {
        return sampleCount;
    }

    public void setSampleCount(IntegerFilter sampleCount) {
        this.sampleCount = sampleCount;
    }

    public IntegerFilter getAcceptedSampleCount() {
        return acceptedSampleCount;
    }

    public void setAcceptedSampleCount(IntegerFilter acceptedSampleCount) {
        this.acceptedSampleCount = acceptedSampleCount;
    }

    public IntegerFilter getRejectedSampleCount() {
        return rejectedSampleCount;
    }

    public void setRejectedSampleCount(IntegerFilter rejectedSampleCount) {
        this.rejectedSampleCount = rejectedSampleCount;
    }

    public StringFilter getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(StringFilter batchStatus) {
        this.batchStatus = batchStatus;
    }

    public LongFilter getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(LongFilter facilityId) {
        this.facilityId = facilityId;
    }
    
    public StringFilter getEidLabName() {
		return eidLabName;
	}

	public void setEidLabName(StringFilter eidLabName) {
		this.eidLabName = eidLabName;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ICTCBatchDetailsCriteria that = (ICTCBatchDetailsCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(labId, that.labId) &&
            Objects.equals(consignmentId, that.consignmentId) &&
//            Objects.equals(dispatchDate, that.dispatchDate) &&
            Objects.equals(sampleCount, that.sampleCount) &&
            Objects.equals(acceptedSampleCount, that.acceptedSampleCount) &&
            Objects.equals(rejectedSampleCount, that.rejectedSampleCount) &&
            Objects.equals(batchStatus, that.batchStatus) &&
            Objects.equals(facilityId, that.facilityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        labId,
        consignmentId,
//        dispatchDate,
        sampleCount,
        acceptedSampleCount,
        rejectedSampleCount,
        batchStatus,
        facilityId
        );
    }

    @Override
    public String toString() {
        return "ICTCBatchDetailsCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (labId != null ? "labId=" + labId + ", " : "") +
                (consignmentId != null ? "consignmentId=" + consignmentId + ", " : "") +
//                (dispatchDate != null ? "dispatchDate=" + dispatchDate + ", " : "") +
                (sampleCount != null ? "sampleCount=" + sampleCount + ", " : "") +
                (acceptedSampleCount != null ? "acceptedSampleCount=" + acceptedSampleCount + ", " : "") +
                (rejectedSampleCount != null ? "rejectedSampleCount=" + rejectedSampleCount + ", " : "") +
                (batchStatus != null ? "batchStatus=" + batchStatus + ", " : "") +
                (facilityId != null ? "facilityId=" + facilityId + ", " : "") +
            "}";
    }

}
