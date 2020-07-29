package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the facility_dispatch_receipt_remarks database table.
 * 
 */
@Entity
@Table(name="facility_dispatch_receipt_remarks")
@NamedQuery(name="FacilityDispatchReceiptRemark.findAll", query="SELECT f FROM FacilityDispatchReceiptRemark f")
public class FacilityDispatchReceiptRemark implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private String remarks;

	//bi-directional many-to-one association to FacilityDispatch
	@ManyToOne
	@JoinColumn(name="facility_dispatch_id")
	private FacilityDispatch facilityDispatch;

	//bi-directional many-to-one association to FacilityDispatchStatusMaster
	@ManyToOne
	@JoinColumn(name="facility_dispatch_status_id")
	private FacilityDispatchStatusMaster facilityDispatchStatusMaster;

	//bi-directional many-to-one association to FacilityReceipt
	@ManyToOne
	@JoinColumn(name="facility_receipt_id")
	private FacilityReceipt facilityReceipt;

	//bi-directional many-to-one association to FacilityReceiptStatusMaster
	@ManyToOne
	@JoinColumn(name="facility_receipt_status_id")
	private FacilityReceiptStatusMaster facilityReceiptStatusMaster;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="created_by")
	private UserMaster userMaster1;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="modified_by")
	private UserMaster userMaster2;

	public FacilityDispatchReceiptRemark() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public FacilityDispatch getFacilityDispatch() {
		return this.facilityDispatch;
	}

	public void setFacilityDispatch(FacilityDispatch facilityDispatch) {
		this.facilityDispatch = facilityDispatch;
	}

	public FacilityDispatchStatusMaster getFacilityDispatchStatusMaster() {
		return this.facilityDispatchStatusMaster;
	}

	public void setFacilityDispatchStatusMaster(FacilityDispatchStatusMaster facilityDispatchStatusMaster) {
		this.facilityDispatchStatusMaster = facilityDispatchStatusMaster;
	}

	public FacilityReceipt getFacilityReceipt() {
		return this.facilityReceipt;
	}

	public void setFacilityReceipt(FacilityReceipt facilityReceipt) {
		this.facilityReceipt = facilityReceipt;
	}

	public FacilityReceiptStatusMaster getFacilityReceiptStatusMaster() {
		return this.facilityReceiptStatusMaster;
	}

	public void setFacilityReceiptStatusMaster(FacilityReceiptStatusMaster facilityReceiptStatusMaster) {
		this.facilityReceiptStatusMaster = facilityReceiptStatusMaster;
	}

	public UserMaster getUserMaster1() {
		return this.userMaster1;
	}

	public void setUserMaster1(UserMaster userMaster1) {
		this.userMaster1 = userMaster1;
	}

	public UserMaster getUserMaster2() {
		return this.userMaster2;
	}

	public void setUserMaster2(UserMaster userMaster2) {
		this.userMaster2 = userMaster2;
	}

}