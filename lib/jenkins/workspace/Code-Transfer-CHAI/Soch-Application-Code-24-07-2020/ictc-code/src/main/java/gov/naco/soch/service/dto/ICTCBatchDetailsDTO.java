package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import gov.naco.soch.domain.LabTestSampleBatch;

/**
 * A DTO for the {@link gov.naco.soch.domain.ICTCBatchDetails} entity.
 */
public class ICTCBatchDetailsDTO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private Long id;

    private Long labId;

    private String consignmentId;

    private LocalDateTime dispatchDate;

    private Integer sampleCount;

    private Integer acceptedSampleCount;

    private Integer rejectedSampleCount;

    private String batchStatus;

    private Long facilityId;

    private String ictcName;
    
    private String ictcCode;
    
    private String eidLabName;
    
    private String eidLabAddressLineOne;
    
    private String eidLabAddressLineTwo;
    
    private String eidLabTown;
    
    private String eidLabDistrict;
    
    private String eidLabState;
    
    private String eidLabCountry;
    
    private String eidLabCode;
    
    private String eidLabPincode;
    
    private String eidLabAddress;
    
    private LocalDateTime sampleCollectionDate;
    
    private LocalDateTime sampleReceivedDate;
    
    private LocalDate reportReceivedDate;

    private LocalDate reportDeliveryDate;
    
    private LabTestSampleBatch eidLabBatchDetails;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLabId() {
        return labId;
    }

    public void setLabId(Long labId) {
        this.labId = labId;
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

    public Integer getSampleCount() {
        return sampleCount;
    }

    public void setSampleCount(Integer sampleCount) {
        this.sampleCount = sampleCount;
    }

    public Integer getAcceptedSampleCount() {
        return acceptedSampleCount;
    }

    public void setAcceptedSampleCount(Integer acceptedSampleCount) {
        this.acceptedSampleCount = acceptedSampleCount;
    }

    public Integer getRejectedSampleCount() {
        return rejectedSampleCount;
    }

    public void setRejectedSampleCount(Integer rejectedSampleCount) {
        this.rejectedSampleCount = rejectedSampleCount;
    }

    public String getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(String batchStatus) {
        this.batchStatus = batchStatus;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }
    
    public String getIctcName() {
		return ictcName;
	}

	public void setIctcName(String ictcName) {
		this.ictcName = ictcName;
	}

	public String getIctcCode() {
		return ictcCode;
	}

	public void setIctcCode(String ictcCode) {
		this.ictcCode = ictcCode;
	}

	public String getEidLabName() {
		return eidLabName;
	}

	public void setEidLabName(String eidLabName) {
		this.eidLabName = eidLabName;
	}

	public String getEidLabAddressLineOne() {
		return eidLabAddressLineOne;
	}

	public void setEidLabAddressLineOne(String eidLabAddressLineOne) {
		this.eidLabAddressLineOne = eidLabAddressLineOne;
	}

	public String getEidLabAddressLineTwo() {
		return eidLabAddressLineTwo;
	}

	public void setEidLabAddressLineTwo(String eidLabAddressLineTwo) {
		this.eidLabAddressLineTwo = eidLabAddressLineTwo;
	}

	public String getEidLabTown() {
		return eidLabTown;
	}

	public void setEidLabTown(String eidLabTown) {
		this.eidLabTown = eidLabTown;
	}

	public String getEidLabDistrict() {
		return eidLabDistrict;
	}

	public void setEidLabDistrict(String eidLabDistrict) {
		this.eidLabDistrict = eidLabDistrict;
	}

	public String getEidLabState() {
		return eidLabState;
	}

	public void setEidLabState(String eidLabState) {
		this.eidLabState = eidLabState;
	}

	public String getEidLabCountry() {
		return eidLabCountry;
	}

	public void setEidLabCountry(String eidLabCountry) {
		this.eidLabCountry = eidLabCountry;
	}

	public String getEidLabCode() {
		return eidLabCode;
	}

	public void setEidLabCode(String eidLabCode) {
		this.eidLabCode = eidLabCode;
	}

	public String getEidLabPincode() {
		return eidLabPincode;
	}

	public void setEidLabPincode(String eidLabPincode) {
		this.eidLabPincode = eidLabPincode;
	}

	public String getEidLabAddress() {
		return eidLabAddress;
	}

	public void setEidLabAddress(String eidLabAddress) {
		this.eidLabAddress = eidLabAddress;
	}
	
	public LabTestSampleBatch getEidLabBatchDetails() {
		return eidLabBatchDetails;
	}

	public void setEidLabBatchDetails(LabTestSampleBatch eidLabBatchDetails) {
		this.eidLabBatchDetails = eidLabBatchDetails;
	}
	
	public LocalDateTime getSampleCollectionDate() {
		return sampleCollectionDate;
	}

	public void setSampleCollectionDate(LocalDateTime sampleCollectionDate) {
		this.sampleCollectionDate = sampleCollectionDate;
	}

	public LocalDateTime getSampleReceivedDate() {
		return sampleReceivedDate;
	}

	public void setSampleReceivedDate(LocalDateTime sampleReceivedDate) {
		this.sampleReceivedDate = sampleReceivedDate;
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

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ICTCBatchDetailsDTO iCTCBatchDetailsDTO = (ICTCBatchDetailsDTO) o;
        if (iCTCBatchDetailsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), iCTCBatchDetailsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "ICTCBatchDetailsDTO [id=" + id + ", labId=" + labId + ", consignmentId=" + consignmentId
				+ ", dispatchDate=" + dispatchDate + ", sampleCount=" + sampleCount + ", acceptedSampleCount="
				+ acceptedSampleCount + ", rejectedSampleCount=" + rejectedSampleCount + ", batchStatus=" + batchStatus
				+ ", facilityId=" + facilityId + ", ictcName=" + ictcName + ", ictcCode=" + ictcCode + ", eidLabName="
				+ eidLabName + ", eidLabAddressLineOne=" + eidLabAddressLineOne + ", eidLabAddressLineTwo="
				+ eidLabAddressLineTwo + ", eidLabTown=" + eidLabTown + ", eidLabDistrict=" + eidLabDistrict
				+ ", eidLabState=" + eidLabState + ", eidLabCountry=" + eidLabCountry + ", eidLabCode=" + eidLabCode
				+ ", eidLabPincode=" + eidLabPincode + ", eidLabAddress=" + eidLabAddress + ", eidLabBatchDetails="
				+ eidLabBatchDetails + "]";
	}

}
