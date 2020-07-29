package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the facility_dispatch database table.
 * 
 */
@Entity
@Table(name="facility_dispatch")
@NamedQuery(name="FacilityDispatch.findAll", query="SELECT f FROM FacilityDispatch f")
public class FacilityDispatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="facility_dispatch_id")
	private Integer facilityDispatchId;

	@Column(name="awb_num")
	private String awbNum;

	@Column(name="contact_num")
	private String contactNum;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="dispatch_type")
	private String dispatchType;

	@Column(name="driver_name")
	private String driverName;

	@Temporal(TemporalType.DATE)
	@Column(name="expected_arrival_date")
	private Date expectedArrivalDate;

	@Temporal(TemporalType.DATE)
	@Column(name="expected_dispatch_date")
	private Date expectedDispatchDate;

	@Temporal(TemporalType.DATE)
	@Column(name="indent_date")
	private Date indentDate;

	@Column(name="indent_num")
	private String indentNum;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="stn_number")
	private String stnNumber;

	@Column(name="transporter_name")
	private String transporterName;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="consignee_facility_id")
	private Facility facility1;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="consignor_facility_id")
	private Facility facility2;

	//bi-directional many-to-one association to FacilityConsignmentStatusMaster
	@ManyToOne
	@JoinColumn(name="facility_consignment_status_id")
	private FacilityConsignmentStatusMaster facilityConsignmentStatusMaster;

	//bi-directional many-to-one association to FacilityDispatchStatusMaster
	@ManyToOne
	@JoinColumn(name="facility_dispatch_status_id")
	private FacilityDispatchStatusMaster facilityDispatchStatusMaster;

	//bi-directional many-to-one association to FacilityRelocationRequestStatusMaster
	@ManyToOne
	@JoinColumn(name="facility_relocation_request_status_id")
	private FacilityRelocationRequestStatusMaster facilityRelocationRequestStatusMaster;

	//bi-directional many-to-one association to MasterInventoryUnregisteredSource
	@ManyToOne
	@JoinColumn(name="unregistered_source_id")
	private MasterInventoryUnregisteredSource masterInventoryUnregisteredSource;

	//bi-directional many-to-one association to FacilityDispatchProduct
	@OneToMany(mappedBy="facilityDispatch")
	private Set<FacilityDispatchProduct> facilityDispatchProducts;

	//bi-directional many-to-one association to FacilityDispatchReceiptRemark
	@OneToMany(mappedBy="facilityDispatch")
	private Set<FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarks;

	//bi-directional many-to-one association to FacilityDispatchStatusTracking
	@OneToMany(mappedBy="facilityDispatch")
	private Set<FacilityDispatchStatusTracking> facilityDispatchStatusTrackings;

	//bi-directional many-to-one association to FacilityReceipt
	@OneToMany(mappedBy="facilityDispatch")
	private Set<FacilityReceipt> facilityReceipts;

	public FacilityDispatch() {
	}

	public Integer getFacilityDispatchId() {
		return this.facilityDispatchId;
	}

	public void setFacilityDispatchId(Integer facilityDispatchId) {
		this.facilityDispatchId = facilityDispatchId;
	}

	public String getAwbNum() {
		return this.awbNum;
	}

	public void setAwbNum(String awbNum) {
		this.awbNum = awbNum;
	}

	public String getContactNum() {
		return this.contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public String getDispatchType() {
		return this.dispatchType;
	}

	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
	}

	public String getDriverName() {
		return this.driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Date getExpectedArrivalDate() {
		return this.expectedArrivalDate;
	}

	public void setExpectedArrivalDate(Date expectedArrivalDate) {
		this.expectedArrivalDate = expectedArrivalDate;
	}

	public Date getExpectedDispatchDate() {
		return this.expectedDispatchDate;
	}

	public void setExpectedDispatchDate(Date expectedDispatchDate) {
		this.expectedDispatchDate = expectedDispatchDate;
	}

	public Date getIndentDate() {
		return this.indentDate;
	}

	public void setIndentDate(Date indentDate) {
		this.indentDate = indentDate;
	}

	public String getIndentNum() {
		return this.indentNum;
	}

	public void setIndentNum(String indentNum) {
		this.indentNum = indentNum;
	}

	public Integer getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getStnNumber() {
		return this.stnNumber;
	}

	public void setStnNumber(String stnNumber) {
		this.stnNumber = stnNumber;
	}

	public String getTransporterName() {
		return this.transporterName;
	}

	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}

	public Facility getFacility1() {
		return this.facility1;
	}

	public void setFacility1(Facility facility1) {
		this.facility1 = facility1;
	}

	public Facility getFacility2() {
		return this.facility2;
	}

	public void setFacility2(Facility facility2) {
		this.facility2 = facility2;
	}

	public FacilityConsignmentStatusMaster getFacilityConsignmentStatusMaster() {
		return this.facilityConsignmentStatusMaster;
	}

	public void setFacilityConsignmentStatusMaster(FacilityConsignmentStatusMaster facilityConsignmentStatusMaster) {
		this.facilityConsignmentStatusMaster = facilityConsignmentStatusMaster;
	}

	public FacilityDispatchStatusMaster getFacilityDispatchStatusMaster() {
		return this.facilityDispatchStatusMaster;
	}

	public void setFacilityDispatchStatusMaster(FacilityDispatchStatusMaster facilityDispatchStatusMaster) {
		this.facilityDispatchStatusMaster = facilityDispatchStatusMaster;
	}

	public FacilityRelocationRequestStatusMaster getFacilityRelocationRequestStatusMaster() {
		return this.facilityRelocationRequestStatusMaster;
	}

	public void setFacilityRelocationRequestStatusMaster(FacilityRelocationRequestStatusMaster facilityRelocationRequestStatusMaster) {
		this.facilityRelocationRequestStatusMaster = facilityRelocationRequestStatusMaster;
	}

	public MasterInventoryUnregisteredSource getMasterInventoryUnregisteredSource() {
		return this.masterInventoryUnregisteredSource;
	}

	public void setMasterInventoryUnregisteredSource(MasterInventoryUnregisteredSource masterInventoryUnregisteredSource) {
		this.masterInventoryUnregisteredSource = masterInventoryUnregisteredSource;
	}

	public Set<FacilityDispatchProduct> getFacilityDispatchProducts() {
		return this.facilityDispatchProducts;
	}

	public void setFacilityDispatchProducts(Set<FacilityDispatchProduct> facilityDispatchProducts) {
		this.facilityDispatchProducts = facilityDispatchProducts;
	}

	public FacilityDispatchProduct addFacilityDispatchProduct(FacilityDispatchProduct facilityDispatchProduct) {
		getFacilityDispatchProducts().add(facilityDispatchProduct);
		facilityDispatchProduct.setFacilityDispatch(this);

		return facilityDispatchProduct;
	}

	public FacilityDispatchProduct removeFacilityDispatchProduct(FacilityDispatchProduct facilityDispatchProduct) {
		getFacilityDispatchProducts().remove(facilityDispatchProduct);
		facilityDispatchProduct.setFacilityDispatch(null);

		return facilityDispatchProduct;
	}

	public Set<FacilityDispatchReceiptRemark> getFacilityDispatchReceiptRemarks() {
		return this.facilityDispatchReceiptRemarks;
	}

	public void setFacilityDispatchReceiptRemarks(Set<FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarks) {
		this.facilityDispatchReceiptRemarks = facilityDispatchReceiptRemarks;
	}

	public FacilityDispatchReceiptRemark addFacilityDispatchReceiptRemark(FacilityDispatchReceiptRemark facilityDispatchReceiptRemark) {
		getFacilityDispatchReceiptRemarks().add(facilityDispatchReceiptRemark);
		facilityDispatchReceiptRemark.setFacilityDispatch(this);

		return facilityDispatchReceiptRemark;
	}

	public FacilityDispatchReceiptRemark removeFacilityDispatchReceiptRemark(FacilityDispatchReceiptRemark facilityDispatchReceiptRemark) {
		getFacilityDispatchReceiptRemarks().remove(facilityDispatchReceiptRemark);
		facilityDispatchReceiptRemark.setFacilityDispatch(null);

		return facilityDispatchReceiptRemark;
	}

	public Set<FacilityDispatchStatusTracking> getFacilityDispatchStatusTrackings() {
		return this.facilityDispatchStatusTrackings;
	}

	public void setFacilityDispatchStatusTrackings(Set<FacilityDispatchStatusTracking> facilityDispatchStatusTrackings) {
		this.facilityDispatchStatusTrackings = facilityDispatchStatusTrackings;
	}

	public FacilityDispatchStatusTracking addFacilityDispatchStatusTracking(FacilityDispatchStatusTracking facilityDispatchStatusTracking) {
		getFacilityDispatchStatusTrackings().add(facilityDispatchStatusTracking);
		facilityDispatchStatusTracking.setFacilityDispatch(this);

		return facilityDispatchStatusTracking;
	}

	public FacilityDispatchStatusTracking removeFacilityDispatchStatusTracking(FacilityDispatchStatusTracking facilityDispatchStatusTracking) {
		getFacilityDispatchStatusTrackings().remove(facilityDispatchStatusTracking);
		facilityDispatchStatusTracking.setFacilityDispatch(null);

		return facilityDispatchStatusTracking;
	}

	public Set<FacilityReceipt> getFacilityReceipts() {
		return this.facilityReceipts;
	}

	public void setFacilityReceipts(Set<FacilityReceipt> facilityReceipts) {
		this.facilityReceipts = facilityReceipts;
	}

	public FacilityReceipt addFacilityReceipt(FacilityReceipt facilityReceipt) {
		getFacilityReceipts().add(facilityReceipt);
		facilityReceipt.setFacilityDispatch(this);

		return facilityReceipt;
	}

	public FacilityReceipt removeFacilityReceipt(FacilityReceipt facilityReceipt) {
		getFacilityReceipts().remove(facilityReceipt);
		facilityReceipt.setFacilityDispatch(null);

		return facilityReceipt;
	}

}