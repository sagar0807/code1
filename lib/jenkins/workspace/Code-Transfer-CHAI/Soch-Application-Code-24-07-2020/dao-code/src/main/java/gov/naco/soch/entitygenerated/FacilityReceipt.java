package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the facility_receipt database table.
 * 
 */
@Entity
@Table(name="facility_receipt")
@NamedQuery(name="FacilityReceipt.findAll", query="SELECT f FROM FacilityReceipt f")
public class FacilityReceipt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="facility_receipt_id")
	private Integer facilityReceiptId;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="grn_date")
	private Timestamp grnDate;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	//bi-directional many-to-one association to FacilityDispatchReceiptRemark
	@OneToMany(mappedBy="facilityReceipt")
	private Set<FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarks;

	//bi-directional many-to-one association to FacilityDispatchStatusTracking
	@OneToMany(mappedBy="facilityReceipt")
	private Set<FacilityDispatchStatusTracking> facilityDispatchStatusTrackings;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="received_facility_id")
	private Facility facility;

	//bi-directional many-to-one association to FacilityDispatch
	@ManyToOne
	@JoinColumn(name="facility_dispatch_id")
	private FacilityDispatch facilityDispatch;

	//bi-directional many-to-one association to FacilityGrnStatusMaster
	@ManyToOne
	@JoinColumn(name="facility_grn_status_id")
	private FacilityGrnStatusMaster facilityGrnStatusMaster;

	//bi-directional many-to-one association to FacilityReceiptStatusMaster
	@ManyToOne
	@JoinColumn(name="facility_receipt_status_id")
	private FacilityReceiptStatusMaster facilityReceiptStatusMaster;

	//bi-directional many-to-one association to MasterInventoryUnregisteredSource
	@ManyToOne
	@JoinColumn(name="unregistered_source_id")
	private MasterInventoryUnregisteredSource masterInventoryUnregisteredSource;

	//bi-directional many-to-one association to ReconciliationStatusMaster
	@ManyToOne
	@JoinColumn(name="reconciliation_status_id")
	private ReconciliationStatusMaster reconciliationStatusMaster;

	//bi-directional many-to-one association to FacilityReceiptProduct
	@OneToMany(mappedBy="facilityReceipt")
	private Set<FacilityReceiptProduct> facilityReceiptProducts;

	public FacilityReceipt() {
	}

	public Integer getFacilityReceiptId() {
		return this.facilityReceiptId;
	}

	public void setFacilityReceiptId(Integer facilityReceiptId) {
		this.facilityReceiptId = facilityReceiptId;
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

	public Timestamp getGrnDate() {
		return this.grnDate;
	}

	public void setGrnDate(Timestamp grnDate) {
		this.grnDate = grnDate;
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

	public Set<FacilityDispatchReceiptRemark> getFacilityDispatchReceiptRemarks() {
		return this.facilityDispatchReceiptRemarks;
	}

	public void setFacilityDispatchReceiptRemarks(Set<FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarks) {
		this.facilityDispatchReceiptRemarks = facilityDispatchReceiptRemarks;
	}

	public FacilityDispatchReceiptRemark addFacilityDispatchReceiptRemark(FacilityDispatchReceiptRemark facilityDispatchReceiptRemark) {
		getFacilityDispatchReceiptRemarks().add(facilityDispatchReceiptRemark);
		facilityDispatchReceiptRemark.setFacilityReceipt(this);

		return facilityDispatchReceiptRemark;
	}

	public FacilityDispatchReceiptRemark removeFacilityDispatchReceiptRemark(FacilityDispatchReceiptRemark facilityDispatchReceiptRemark) {
		getFacilityDispatchReceiptRemarks().remove(facilityDispatchReceiptRemark);
		facilityDispatchReceiptRemark.setFacilityReceipt(null);

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
		facilityDispatchStatusTracking.setFacilityReceipt(this);

		return facilityDispatchStatusTracking;
	}

	public FacilityDispatchStatusTracking removeFacilityDispatchStatusTracking(FacilityDispatchStatusTracking facilityDispatchStatusTracking) {
		getFacilityDispatchStatusTrackings().remove(facilityDispatchStatusTracking);
		facilityDispatchStatusTracking.setFacilityReceipt(null);

		return facilityDispatchStatusTracking;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public FacilityDispatch getFacilityDispatch() {
		return this.facilityDispatch;
	}

	public void setFacilityDispatch(FacilityDispatch facilityDispatch) {
		this.facilityDispatch = facilityDispatch;
	}

	public FacilityGrnStatusMaster getFacilityGrnStatusMaster() {
		return this.facilityGrnStatusMaster;
	}

	public void setFacilityGrnStatusMaster(FacilityGrnStatusMaster facilityGrnStatusMaster) {
		this.facilityGrnStatusMaster = facilityGrnStatusMaster;
	}

	public FacilityReceiptStatusMaster getFacilityReceiptStatusMaster() {
		return this.facilityReceiptStatusMaster;
	}

	public void setFacilityReceiptStatusMaster(FacilityReceiptStatusMaster facilityReceiptStatusMaster) {
		this.facilityReceiptStatusMaster = facilityReceiptStatusMaster;
	}

	public MasterInventoryUnregisteredSource getMasterInventoryUnregisteredSource() {
		return this.masterInventoryUnregisteredSource;
	}

	public void setMasterInventoryUnregisteredSource(MasterInventoryUnregisteredSource masterInventoryUnregisteredSource) {
		this.masterInventoryUnregisteredSource = masterInventoryUnregisteredSource;
	}

	public ReconciliationStatusMaster getReconciliationStatusMaster() {
		return this.reconciliationStatusMaster;
	}

	public void setReconciliationStatusMaster(ReconciliationStatusMaster reconciliationStatusMaster) {
		this.reconciliationStatusMaster = reconciliationStatusMaster;
	}

	public Set<FacilityReceiptProduct> getFacilityReceiptProducts() {
		return this.facilityReceiptProducts;
	}

	public void setFacilityReceiptProducts(Set<FacilityReceiptProduct> facilityReceiptProducts) {
		this.facilityReceiptProducts = facilityReceiptProducts;
	}

	public FacilityReceiptProduct addFacilityReceiptProduct(FacilityReceiptProduct facilityReceiptProduct) {
		getFacilityReceiptProducts().add(facilityReceiptProduct);
		facilityReceiptProduct.setFacilityReceipt(this);

		return facilityReceiptProduct;
	}

	public FacilityReceiptProduct removeFacilityReceiptProduct(FacilityReceiptProduct facilityReceiptProduct) {
		getFacilityReceiptProducts().remove(facilityReceiptProduct);
		facilityReceiptProduct.setFacilityReceipt(null);

		return facilityReceiptProduct;
	}

}