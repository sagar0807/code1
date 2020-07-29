package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the dispatch_status_tracking database table.
 * 
 */
@Entity
@Table(name="dispatch_status_tracking")
@NamedQuery(name="DispatchStatusTracking.findAll", query="SELECT d FROM DispatchStatusTracking d")
public class DispatchStatusTracking implements Serializable {
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

	//bi-directional many-to-one association to Dispatch
	@ManyToOne
	@JoinColumn(name="dispatch_id")
	private Dispatch dispatch;

	//bi-directional many-to-one association to DispatchStatusMaster
	@ManyToOne
	@JoinColumn(name="dispatch_status_id")
	private DispatchStatusMaster dispatchStatusMaster;

	//bi-directional many-to-one association to Receipt
	@ManyToOne
	private Receipt receipt;

	//bi-directional many-to-one association to ReceiptStatusMaster
	@ManyToOne
	@JoinColumn(name="receipt_status_id")
	private ReceiptStatusMaster receiptStatusMaster;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="status_changed_user")
	private UserMaster userMaster;

	public DispatchStatusTracking() {
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

	public Dispatch getDispatch() {
		return this.dispatch;
	}

	public void setDispatch(Dispatch dispatch) {
		this.dispatch = dispatch;
	}

	public DispatchStatusMaster getDispatchStatusMaster() {
		return this.dispatchStatusMaster;
	}

	public void setDispatchStatusMaster(DispatchStatusMaster dispatchStatusMaster) {
		this.dispatchStatusMaster = dispatchStatusMaster;
	}

	public Receipt getReceipt() {
		return this.receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public ReceiptStatusMaster getReceiptStatusMaster() {
		return this.receiptStatusMaster;
	}

	public void setReceiptStatusMaster(ReceiptStatusMaster receiptStatusMaster) {
		this.receiptStatusMaster = receiptStatusMaster;
	}

	public UserMaster getUserMaster() {
		return this.userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

}