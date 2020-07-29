package gov.naco.soch.shared.dto.ictc;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.ICTCSampleCollection} entity.
 */
public class ICTCSampleCollectionDTO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private String barcode;

    private Integer testType;
    
    private LocalDate sampleCollectionDate;
    
    private Integer sampleCollectionStatus;
   
    private Boolean isDispatched;

    private Integer dispatchedToLabId;

    private LocalDate dispatchDate;

    private Boolean isActive;

    private Boolean isDeleted;

    private Integer createdBy;

    private LocalDate createdTime;

    private Integer modifiedBy;

    private LocalDate modifiedTime;

    private Long batchId;
   
	private Long ictcBeneficiaryId;
	
	private Long visitId;
	
	private Long facilityId;
    
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

	public LocalDate getSampleCollectionDate() {
		return sampleCollectionDate;
	}

	public void setSampleCollectionDate(LocalDate sampleCollectionDate) {
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

	public Integer getDispatchedToLabId() {
		return dispatchedToLabId;
	}

	public void setDispatchedToLabId(Integer dispatchedToLabId) {
		this.dispatchedToLabId = dispatchedToLabId;
	}

	public LocalDate getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(LocalDate dispatchDate) {
		this.dispatchDate = dispatchDate;
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

	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public Long getIctcBeneficiaryId() {
		return ictcBeneficiaryId;
	}

	public void setIctcBeneficiaryId(Long ictcBeneficiaryId) {
		this.ictcBeneficiaryId = ictcBeneficiaryId;
	}

	public Long getVisitId() {
		return visitId;
	}

	public void setVisitId(Long visitId) {
		this.visitId = visitId;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ICTCSampleCollectionDTO iCTCSampleCollectionDTO = (ICTCSampleCollectionDTO) o;
        if (iCTCSampleCollectionDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), iCTCSampleCollectionDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "ICTCSampleCollectionDTO [id=" + id + ", barcode=" + barcode + ", testType=" + testType
				+ ", sampleCollectionDate=" + sampleCollectionDate + ", sampleCollectionStatus="
				+ sampleCollectionStatus + ", isDispatched=" + isDispatched + ", dispatchedToLabId=" + dispatchedToLabId
				+ ", dispatchDate=" + dispatchDate + ", isActive=" + isActive + ", isDeleted=" + isDeleted
				+ ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy
				+ ", modifiedTime=" + modifiedTime + ", batchId=" + batchId + ", ictcBeneficiaryId=" + ictcBeneficiaryId
				+ ", visitId=" + visitId + ", facilityId=" + facilityId + "]";
	}
    
}
