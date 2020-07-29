package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ictc_batch_status_view database table.
 * 
 */
@Entity
@Table(name="ictc_batch_status_view")
@NamedQuery(name="IctcBatchStatusView.findAll", query="SELECT i FROM IctcBatchStatusView i")
public class IctcBatchStatusView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="accepted_sample_count")
	private Long acceptedSampleCount;

	@Column(name="batch_status")
	private Integer batchStatus;

	@Column(name="consignment_id")
	private String consignmentId;

	@Temporal(TemporalType.DATE)
	@Column(name="dispatch_date")
	private Date dispatchDate;

	@Column(name="eid_lab_address")
	private String eidLabAddress;

	@Column(name="eid_lab_address_line_one")
	private String eidLabAddressLineOne;

	@Column(name="eid_lab_address_line_two")
	private String eidLabAddressLineTwo;

	@Column(name="eid_lab_code")
	private String eidLabCode;

	@Column(name="eid_lab_country")
	private String eidLabCountry;

	@Column(name="eid_lab_district")
	private String eidLabDistrict;

	@Column(name="eid_lab_name")
	private String eidLabName;

	@Column(name="eid_lab_pincode")
	private String eidLabPincode;

	@Column(name="eid_lab_state")
	private String eidLabState;

	@Column(name="eid_lab_town")
	private String eidLabTown;

	@Column(name="facility_id")
	private Long facilityId;

	@Column(name="ictc_code")
	private String ictcCode;

	@Column(name="ictc_name")
	private String ictcName;

	private Integer id;

	@Column(name="lab_id")
	private Long labId;

	@Column(name="rejected_sample_count")
	private Long rejectedSampleCount;

	@Column(name="sample_count")
	private Long sampleCount;

	public IctcBatchStatusView() {
	}

	public Long getAcceptedSampleCount() {
		return this.acceptedSampleCount;
	}

	public void setAcceptedSampleCount(Long acceptedSampleCount) {
		this.acceptedSampleCount = acceptedSampleCount;
	}

	public Integer getBatchStatus() {
		return this.batchStatus;
	}

	public void setBatchStatus(Integer batchStatus) {
		this.batchStatus = batchStatus;
	}

	public String getConsignmentId() {
		return this.consignmentId;
	}

	public void setConsignmentId(String consignmentId) {
		this.consignmentId = consignmentId;
	}

	public Date getDispatchDate() {
		return this.dispatchDate;
	}

	public void setDispatchDate(Date dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public String getEidLabAddress() {
		return this.eidLabAddress;
	}

	public void setEidLabAddress(String eidLabAddress) {
		this.eidLabAddress = eidLabAddress;
	}

	public String getEidLabAddressLineOne() {
		return this.eidLabAddressLineOne;
	}

	public void setEidLabAddressLineOne(String eidLabAddressLineOne) {
		this.eidLabAddressLineOne = eidLabAddressLineOne;
	}

	public String getEidLabAddressLineTwo() {
		return this.eidLabAddressLineTwo;
	}

	public void setEidLabAddressLineTwo(String eidLabAddressLineTwo) {
		this.eidLabAddressLineTwo = eidLabAddressLineTwo;
	}

	public String getEidLabCode() {
		return this.eidLabCode;
	}

	public void setEidLabCode(String eidLabCode) {
		this.eidLabCode = eidLabCode;
	}

	public String getEidLabCountry() {
		return this.eidLabCountry;
	}

	public void setEidLabCountry(String eidLabCountry) {
		this.eidLabCountry = eidLabCountry;
	}

	public String getEidLabDistrict() {
		return this.eidLabDistrict;
	}

	public void setEidLabDistrict(String eidLabDistrict) {
		this.eidLabDistrict = eidLabDistrict;
	}

	public String getEidLabName() {
		return this.eidLabName;
	}

	public void setEidLabName(String eidLabName) {
		this.eidLabName = eidLabName;
	}

	public String getEidLabPincode() {
		return this.eidLabPincode;
	}

	public void setEidLabPincode(String eidLabPincode) {
		this.eidLabPincode = eidLabPincode;
	}

	public String getEidLabState() {
		return this.eidLabState;
	}

	public void setEidLabState(String eidLabState) {
		this.eidLabState = eidLabState;
	}

	public String getEidLabTown() {
		return this.eidLabTown;
	}

	public void setEidLabTown(String eidLabTown) {
		this.eidLabTown = eidLabTown;
	}

	public Long getFacilityId() {
		return this.facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public String getIctcCode() {
		return this.ictcCode;
	}

	public void setIctcCode(String ictcCode) {
		this.ictcCode = ictcCode;
	}

	public String getIctcName() {
		return this.ictcName;
	}

	public void setIctcName(String ictcName) {
		this.ictcName = ictcName;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getLabId() {
		return this.labId;
	}

	public void setLabId(Long labId) {
		this.labId = labId;
	}

	public Long getRejectedSampleCount() {
		return this.rejectedSampleCount;
	}

	public void setRejectedSampleCount(Long rejectedSampleCount) {
		this.rejectedSampleCount = rejectedSampleCount;
	}

	public Long getSampleCount() {
		return this.sampleCount;
	}

	public void setSampleCount(Long sampleCount) {
		this.sampleCount = sampleCount;
	}

}