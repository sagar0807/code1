package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the receipt_status_master database table.
 * 
 */
@Entity
@Table(name="receipt_status_master")
@NamedQuery(name="ReceiptStatusMaster.findAll", query="SELECT r FROM ReceiptStatusMaster r")
public class ReceiptStatusMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private String status;

	//bi-directional many-to-one association to CmssIndentDispatch
	@OneToMany(mappedBy="receiptStatusMaster")
	private Set<CmssIndentDispatch> cmssIndentDispatches;

	//bi-directional many-to-one association to DispatchReceiptRemark
	@OneToMany(mappedBy="receiptStatusMaster")
	private Set<DispatchReceiptRemark> dispatchReceiptRemarks;

	//bi-directional many-to-one association to DispatchStatusTracking
	@OneToMany(mappedBy="receiptStatusMaster")
	private Set<DispatchStatusTracking> dispatchStatusTrackings;

	//bi-directional many-to-one association to Receipt
	@OneToMany(mappedBy="receiptStatusMaster")
	private Set<Receipt> receipts;

	public ReceiptStatusMaster() {
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

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<CmssIndentDispatch> getCmssIndentDispatches() {
		return this.cmssIndentDispatches;
	}

	public void setCmssIndentDispatches(Set<CmssIndentDispatch> cmssIndentDispatches) {
		this.cmssIndentDispatches = cmssIndentDispatches;
	}

	public CmssIndentDispatch addCmssIndentDispatch(CmssIndentDispatch cmssIndentDispatch) {
		getCmssIndentDispatches().add(cmssIndentDispatch);
		cmssIndentDispatch.setReceiptStatusMaster(this);

		return cmssIndentDispatch;
	}

	public CmssIndentDispatch removeCmssIndentDispatch(CmssIndentDispatch cmssIndentDispatch) {
		getCmssIndentDispatches().remove(cmssIndentDispatch);
		cmssIndentDispatch.setReceiptStatusMaster(null);

		return cmssIndentDispatch;
	}

	public Set<DispatchReceiptRemark> getDispatchReceiptRemarks() {
		return this.dispatchReceiptRemarks;
	}

	public void setDispatchReceiptRemarks(Set<DispatchReceiptRemark> dispatchReceiptRemarks) {
		this.dispatchReceiptRemarks = dispatchReceiptRemarks;
	}

	public DispatchReceiptRemark addDispatchReceiptRemark(DispatchReceiptRemark dispatchReceiptRemark) {
		getDispatchReceiptRemarks().add(dispatchReceiptRemark);
		dispatchReceiptRemark.setReceiptStatusMaster(this);

		return dispatchReceiptRemark;
	}

	public DispatchReceiptRemark removeDispatchReceiptRemark(DispatchReceiptRemark dispatchReceiptRemark) {
		getDispatchReceiptRemarks().remove(dispatchReceiptRemark);
		dispatchReceiptRemark.setReceiptStatusMaster(null);

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
		dispatchStatusTracking.setReceiptStatusMaster(this);

		return dispatchStatusTracking;
	}

	public DispatchStatusTracking removeDispatchStatusTracking(DispatchStatusTracking dispatchStatusTracking) {
		getDispatchStatusTrackings().remove(dispatchStatusTracking);
		dispatchStatusTracking.setReceiptStatusMaster(null);

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
		receipt.setReceiptStatusMaster(this);

		return receipt;
	}

	public Receipt removeReceipt(Receipt receipt) {
		getReceipts().remove(receipt);
		receipt.setReceiptStatusMaster(null);

		return receipt;
	}

}