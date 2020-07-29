package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the receipt database table.
 * 
 */
@Entity
@NamedQuery(name="Receipt.findAll", query="SELECT r FROM Receipt r")
public class Receipt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="grn1_date")
	private Timestamp grn1Date;

	@Column(name="grn2_date")
	private Timestamp grn2Date;

	@Column(name="is_batch_match")
	private Boolean isBatchMatch;

	@Column(name="is_product_match")
	private Boolean isProductMatch;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	//bi-directional many-to-one association to DispatchReceiptRemark
	@OneToMany(mappedBy="receipt")
	private Set<DispatchReceiptRemark> dispatchReceiptRemarks;

	//bi-directional many-to-one association to DispatchStatusTracking
	@OneToMany(mappedBy="receipt")
	private Set<DispatchStatusTracking> dispatchStatusTrackings;

	//bi-directional many-to-one association to Dispatch
	@ManyToOne
	@JoinColumn(name="dispatch_id")
	private Dispatch dispatch;

	//bi-directional many-to-one association to Grn1StatusMaster
	@ManyToOne
	@JoinColumn(name="grn1_status_id")
	private Grn1StatusMaster grn1StatusMaster;

	//bi-directional many-to-one association to Grn2StatusMaster
	@ManyToOne
	@JoinColumn(name="grn2_status_id")
	private Grn2StatusMaster grn2StatusMaster;

	//bi-directional many-to-one association to ReceiptStatusMaster
	@ManyToOne
	@JoinColumn(name="receipt_status_id")
	private ReceiptStatusMaster receiptStatusMaster;

	//bi-directional many-to-one association to ReceiptBatch
	@OneToMany(mappedBy="receipt")
	private Set<ReceiptBatch> receiptBatches;

	public Receipt() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Timestamp getGrn1Date() {
		return this.grn1Date;
	}

	public void setGrn1Date(Timestamp grn1Date) {
		this.grn1Date = grn1Date;
	}

	public Timestamp getGrn2Date() {
		return this.grn2Date;
	}

	public void setGrn2Date(Timestamp grn2Date) {
		this.grn2Date = grn2Date;
	}

	public Boolean getIsBatchMatch() {
		return this.isBatchMatch;
	}

	public void setIsBatchMatch(Boolean isBatchMatch) {
		this.isBatchMatch = isBatchMatch;
	}

	public Boolean getIsProductMatch() {
		return this.isProductMatch;
	}

	public void setIsProductMatch(Boolean isProductMatch) {
		this.isProductMatch = isProductMatch;
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

	public Set<DispatchReceiptRemark> getDispatchReceiptRemarks() {
		return this.dispatchReceiptRemarks;
	}

	public void setDispatchReceiptRemarks(Set<DispatchReceiptRemark> dispatchReceiptRemarks) {
		this.dispatchReceiptRemarks = dispatchReceiptRemarks;
	}

	public DispatchReceiptRemark addDispatchReceiptRemark(DispatchReceiptRemark dispatchReceiptRemark) {
		getDispatchReceiptRemarks().add(dispatchReceiptRemark);
		dispatchReceiptRemark.setReceipt(this);

		return dispatchReceiptRemark;
	}

	public DispatchReceiptRemark removeDispatchReceiptRemark(DispatchReceiptRemark dispatchReceiptRemark) {
		getDispatchReceiptRemarks().remove(dispatchReceiptRemark);
		dispatchReceiptRemark.setReceipt(null);

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
		dispatchStatusTracking.setReceipt(this);

		return dispatchStatusTracking;
	}

	public DispatchStatusTracking removeDispatchStatusTracking(DispatchStatusTracking dispatchStatusTracking) {
		getDispatchStatusTrackings().remove(dispatchStatusTracking);
		dispatchStatusTracking.setReceipt(null);

		return dispatchStatusTracking;
	}

	public Dispatch getDispatch() {
		return this.dispatch;
	}

	public void setDispatch(Dispatch dispatch) {
		this.dispatch = dispatch;
	}

	public Grn1StatusMaster getGrn1StatusMaster() {
		return this.grn1StatusMaster;
	}

	public void setGrn1StatusMaster(Grn1StatusMaster grn1StatusMaster) {
		this.grn1StatusMaster = grn1StatusMaster;
	}

	public Grn2StatusMaster getGrn2StatusMaster() {
		return this.grn2StatusMaster;
	}

	public void setGrn2StatusMaster(Grn2StatusMaster grn2StatusMaster) {
		this.grn2StatusMaster = grn2StatusMaster;
	}

	public ReceiptStatusMaster getReceiptStatusMaster() {
		return this.receiptStatusMaster;
	}

	public void setReceiptStatusMaster(ReceiptStatusMaster receiptStatusMaster) {
		this.receiptStatusMaster = receiptStatusMaster;
	}

	public Set<ReceiptBatch> getReceiptBatches() {
		return this.receiptBatches;
	}

	public void setReceiptBatches(Set<ReceiptBatch> receiptBatches) {
		this.receiptBatches = receiptBatches;
	}

	public ReceiptBatch addReceiptBatch(ReceiptBatch receiptBatch) {
		getReceiptBatches().add(receiptBatch);
		receiptBatch.setReceipt(this);

		return receiptBatch;
	}

	public ReceiptBatch removeReceiptBatch(ReceiptBatch receiptBatch) {
		getReceiptBatches().remove(receiptBatch);
		receiptBatch.setReceipt(null);

		return receiptBatch;
	}

}