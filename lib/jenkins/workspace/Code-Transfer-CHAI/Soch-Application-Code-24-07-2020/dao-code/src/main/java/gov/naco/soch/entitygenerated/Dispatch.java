package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the dispatch database table.
 * 
 */
@Entity
@NamedQuery(name="Dispatch.findAll", query="SELECT d FROM Dispatch d")
public class Dispatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dispatch_id")
	private Integer dispatchId;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="driver_name")
	private String driverName;

	@Column(name="expected_arrival_date")
	private Timestamp expectedArrivalDate;

	@Column(name="expected_dispatch_date")
	private Timestamp expectedDispatchDate;

	@Column(name="invoice_date")
	private Timestamp invoiceDate;

	@Column(name="invoice_number")
	private String invoiceNumber;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="stn_number")
	private String stnNumber;

	@Column(name="transporter_name")
	private String transporterName;

	@Column(name="transporter_phone")
	private String transporterPhone;

	//bi-directional many-to-one association to ConsignmentStatusMaster
	@ManyToOne
	@JoinColumn(name="consignment_status_id")
	private ConsignmentStatusMaster consignmentStatusMaster;

	//bi-directional many-to-one association to Contract
	@ManyToOne
	@JoinColumn(name="contract_id")
	private Contract contract;

	//bi-directional many-to-one association to ContractProduct
	@ManyToOne
	@JoinColumn(name="contract_product_id")
	private ContractProduct contractProduct;

	//bi-directional many-to-one association to ContractProductSchedule
	@ManyToOne
	@JoinColumn(name="schedule_id")
	private ContractProductSchedule contractProductSchedule;

	//bi-directional many-to-one association to ContractProductScheduleSacsLot
	@ManyToOne
	@JoinColumn(name="lot_id")
	private ContractProductScheduleSacsLot contractProductScheduleSacsLot;

	//bi-directional many-to-one association to DispatchStatusMaster
	@ManyToOne
	@JoinColumn(name="dispatch_status_id")
	private DispatchStatusMaster dispatchStatusMaster;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="bill_consignee_id")
	private Facility facility1;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="ship_consignee_id")
	private Facility facility2;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="consignor_id")
	private Facility facility3;

	//bi-directional many-to-one association to DispatchBatch
	@OneToMany(mappedBy="dispatch")
	private Set<DispatchBatch> dispatchBatches;

	//bi-directional many-to-one association to DispatchReceiptRemark
	@OneToMany(mappedBy="dispatch")
	private Set<DispatchReceiptRemark> dispatchReceiptRemarks;

	//bi-directional many-to-one association to DispatchStatusTracking
	@OneToMany(mappedBy="dispatch")
	private Set<DispatchStatusTracking> dispatchStatusTrackings;

	//bi-directional many-to-one association to Receipt
	@OneToMany(mappedBy="dispatch")
	private Set<Receipt> receipts;

	public Dispatch() {
	}

	public Integer getDispatchId() {
		return this.dispatchId;
	}

	public void setDispatchId(Integer dispatchId) {
		this.dispatchId = dispatchId;
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

	public String getDriverName() {
		return this.driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Timestamp getExpectedArrivalDate() {
		return this.expectedArrivalDate;
	}

	public void setExpectedArrivalDate(Timestamp expectedArrivalDate) {
		this.expectedArrivalDate = expectedArrivalDate;
	}

	public Timestamp getExpectedDispatchDate() {
		return this.expectedDispatchDate;
	}

	public void setExpectedDispatchDate(Timestamp expectedDispatchDate) {
		this.expectedDispatchDate = expectedDispatchDate;
	}

	public Timestamp getInvoiceDate() {
		return this.invoiceDate;
	}

	public void setInvoiceDate(Timestamp invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceNumber() {
		return this.invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
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

	public String getTransporterPhone() {
		return this.transporterPhone;
	}

	public void setTransporterPhone(String transporterPhone) {
		this.transporterPhone = transporterPhone;
	}

	public ConsignmentStatusMaster getConsignmentStatusMaster() {
		return this.consignmentStatusMaster;
	}

	public void setConsignmentStatusMaster(ConsignmentStatusMaster consignmentStatusMaster) {
		this.consignmentStatusMaster = consignmentStatusMaster;
	}

	public Contract getContract() {
		return this.contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public ContractProduct getContractProduct() {
		return this.contractProduct;
	}

	public void setContractProduct(ContractProduct contractProduct) {
		this.contractProduct = contractProduct;
	}

	public ContractProductSchedule getContractProductSchedule() {
		return this.contractProductSchedule;
	}

	public void setContractProductSchedule(ContractProductSchedule contractProductSchedule) {
		this.contractProductSchedule = contractProductSchedule;
	}

	public ContractProductScheduleSacsLot getContractProductScheduleSacsLot() {
		return this.contractProductScheduleSacsLot;
	}

	public void setContractProductScheduleSacsLot(ContractProductScheduleSacsLot contractProductScheduleSacsLot) {
		this.contractProductScheduleSacsLot = contractProductScheduleSacsLot;
	}

	public DispatchStatusMaster getDispatchStatusMaster() {
		return this.dispatchStatusMaster;
	}

	public void setDispatchStatusMaster(DispatchStatusMaster dispatchStatusMaster) {
		this.dispatchStatusMaster = dispatchStatusMaster;
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

	public Facility getFacility3() {
		return this.facility3;
	}

	public void setFacility3(Facility facility3) {
		this.facility3 = facility3;
	}

	public Set<DispatchBatch> getDispatchBatches() {
		return this.dispatchBatches;
	}

	public void setDispatchBatches(Set<DispatchBatch> dispatchBatches) {
		this.dispatchBatches = dispatchBatches;
	}

	public DispatchBatch addDispatchBatch(DispatchBatch dispatchBatch) {
		getDispatchBatches().add(dispatchBatch);
		dispatchBatch.setDispatch(this);

		return dispatchBatch;
	}

	public DispatchBatch removeDispatchBatch(DispatchBatch dispatchBatch) {
		getDispatchBatches().remove(dispatchBatch);
		dispatchBatch.setDispatch(null);

		return dispatchBatch;
	}

	public Set<DispatchReceiptRemark> getDispatchReceiptRemarks() {
		return this.dispatchReceiptRemarks;
	}

	public void setDispatchReceiptRemarks(Set<DispatchReceiptRemark> dispatchReceiptRemarks) {
		this.dispatchReceiptRemarks = dispatchReceiptRemarks;
	}

	public DispatchReceiptRemark addDispatchReceiptRemark(DispatchReceiptRemark dispatchReceiptRemark) {
		getDispatchReceiptRemarks().add(dispatchReceiptRemark);
		dispatchReceiptRemark.setDispatch(this);

		return dispatchReceiptRemark;
	}

	public DispatchReceiptRemark removeDispatchReceiptRemark(DispatchReceiptRemark dispatchReceiptRemark) {
		getDispatchReceiptRemarks().remove(dispatchReceiptRemark);
		dispatchReceiptRemark.setDispatch(null);

		return dispatchReceiptRemark;
	}

	public Set<DispatchStatusTracking> getDispatchStatusTrackings() {
		return this.dispatchStatusTrackings;
	}

	public void setDispatchStatusTrackings(Set<DispatchStatusTracking> dispatchStatusTrackings) {
		this.dispatchStatusTrackings = dispatchStatusTrackings;
	}

	public DispatchStatusTracking addDispatchStatusTracking(DispatchStatusTracking dispatchStatusTracking) {
		getDispatchStatusTrackings().add(dispatchStatusTracking);
		dispatchStatusTracking.setDispatch(this);

		return dispatchStatusTracking;
	}

	public DispatchStatusTracking removeDispatchStatusTracking(DispatchStatusTracking dispatchStatusTracking) {
		getDispatchStatusTrackings().remove(dispatchStatusTracking);
		dispatchStatusTracking.setDispatch(null);

		return dispatchStatusTracking;
	}

	public Set<Receipt> getReceipts() {
		return this.receipts;
	}

	public void setReceipts(Set<Receipt> receipts) {
		this.receipts = receipts;
	}

	public Receipt addReceipt(Receipt receipt) {
		getReceipts().add(receipt);
		receipt.setDispatch(this);

		return receipt;
	}

	public Receipt removeReceipt(Receipt receipt) {
		getReceipts().remove(receipt);
		receipt.setDispatch(null);

		return receipt;
	}

}