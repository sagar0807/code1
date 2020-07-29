package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A ICTCBatchDetails.
 */
@Entity
@Table(name = "ictc_batch_status_view")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ICTCBatchDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lab_id")
    private Long labId;

    @Column(name = "consignment_id")
    private String consignmentId;

    @Column(name = "dispatch_date")
    private LocalDateTime dispatchDate;

    @Column(name = "sample_count")
    private Integer sampleCount;

    @Column(name = "accepted_sample_count")
    private Integer acceptedSampleCount;

    @Column(name = "rejected_sample_count")
    private Integer rejectedSampleCount;

    @Column(name = "batch_status")
    private String batchStatus;

    @Column(name = "facility_id")
    private Long facilityId;
    
    @Column(name = "ictc_name")
    private String ictcName;
    
    @Column(name = "ictc_code")
    private String ictcCode;
    
    @Column(name = "eid_lab_name")
    private String eidLabName;
    
    @Column(name = "eid_lab_address_line_one")
    private String eidLabAddressLineOne;
    
    @Column(name = "eid_lab_address_line_two")
    private String eidLabAddressLineTwo;
    
    @Column(name = "eid_lab_town")
    private String eidLabTown;
    
    @Column(name = "eid_lab_district")
    private String eidLabDistrict;
    
    @Column(name = "eid_lab_state")
    private String eidLabState;
    
    @Column(name = "eid_lab_country")
    private String eidLabCountry;
    
    @Column(name = "eid_lab_code")
    private String eidLabCode;
    
    @Column(name = "eid_lab_pincode")
    private String eidLabPincode;
    
    @Column(name = "eid_lab_address")
    private String eidLabAddress;
    
    @Column(name = "sample_collection_date")
    private LocalDateTime sampleCollectionDate;
    
    @Column(name = "sample_received_date")
    private LocalDateTime sampleReceivedDate;
    
    @Column(name = "report_received_date")
    private LocalDate reportReceivedDate;

    @Column(name = "report_delivery_date")
    private LocalDate reportDeliveryDate;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLabId() {
        return labId;
    }

    public ICTCBatchDetails labId(Long labId) {
        this.labId = labId;
        return this;
    }

    public void setLabId(Long labId) {
        this.labId = labId;
    }

    public String getConsignmentId() {
        return consignmentId;
    }

    public ICTCBatchDetails consignmentId(String consignmentId) {
        this.consignmentId = consignmentId;
        return this;
    }

    public void setConsignmentId(String consignmentId) {
        this.consignmentId = consignmentId;
    }

    public LocalDateTime getDispatchDate() {
        return dispatchDate;
    }

    public ICTCBatchDetails dispatchDate(LocalDateTime dispatchDate) {
        this.dispatchDate = dispatchDate;
        return this;
    }

    public void setDispatchDate(LocalDateTime dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public Integer getSampleCount() {
        return sampleCount;
    }

    public ICTCBatchDetails sampleCount(Integer sampleCount) {
        this.sampleCount = sampleCount;
        return this;
    }

    public void setSampleCount(Integer sampleCount) {
        this.sampleCount = sampleCount;
    }

    public Integer getAcceptedSampleCount() {
        return acceptedSampleCount;
    }

    public ICTCBatchDetails acceptedSampleCount(Integer acceptedSampleCount) {
        this.acceptedSampleCount = acceptedSampleCount;
        return this;
    }

    public void setAcceptedSampleCount(Integer acceptedSampleCount) {
        this.acceptedSampleCount = acceptedSampleCount;
    }

    public Integer getRejectedSampleCount() {
        return rejectedSampleCount;
    }

    public ICTCBatchDetails rejectedSampleCount(Integer rejectedSampleCount) {
        this.rejectedSampleCount = rejectedSampleCount;
        return this;
    }

    public void setRejectedSampleCount(Integer rejectedSampleCount) {
        this.rejectedSampleCount = rejectedSampleCount;
    }

    public String getBatchStatus() {
        return batchStatus;
    }

    public ICTCBatchDetails batchStatus(String batchStatus) {
        this.batchStatus = batchStatus;
        return this;
    }

    public void setBatchStatus(String batchStatus) {
        this.batchStatus = batchStatus;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public ICTCBatchDetails facilityId(Long facilityId) {
        this.facilityId = facilityId;
        return this;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }
    
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

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
        if (!(o instanceof ICTCBatchDetails)) {
            return false;
        }
        return id != null && id.equals(((ICTCBatchDetails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

	@Override
	public String toString() {
		return "ICTCBatchDetails [id=" + id + ", labId=" + labId + ", consignmentId=" + consignmentId
				+ ", dispatchDate=" + dispatchDate + ", sampleCount=" + sampleCount + ", acceptedSampleCount="
				+ acceptedSampleCount + ", rejectedSampleCount=" + rejectedSampleCount + ", batchStatus=" + batchStatus
				+ ", facilityId=" + facilityId + ", ictcName=" + ictcName + ", ictcCode=" + ictcCode + ", eidLabName="
				+ eidLabName + ", eidLabAddressLineOne=" + eidLabAddressLineOne + ", eidLabAddressLineTwo="
				+ eidLabAddressLineTwo + ", eidLabTown=" + eidLabTown + ", eidLabDistrict=" + eidLabDistrict
				+ ", eidLabState=" + eidLabState + ", eidLabCountry=" + eidLabCountry + ", eidLabCenterCode="
				+ eidLabCode + ", eidLabPincode=" + eidLabPincode + ", eidLabAddress=" + eidLabAddress + "]";
	}

}
