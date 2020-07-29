package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the facility_dispatch_status_master database table.
 * 
 */
@Entity
@Table(name="facility_dispatch_status_master")
@NamedQuery(name="FacilityDispatchStatusMaster.findAll", query="SELECT f FROM FacilityDispatchStatusMaster f")
public class FacilityDispatchStatusMaster implements Serializable {
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

	//bi-directional many-to-one association to FacilityDispatch
	@OneToMany(mappedBy="facilityDispatchStatusMaster")
	private Set<FacilityDispatch> facilityDispatches;

	//bi-directional many-to-one association to FacilityDispatchReceiptRemark
	@OneToMany(mappedBy="facilityDispatchStatusMaster")
	private Set<FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarks;

	//bi-directional many-to-one association to FacilityDispatchStatusTracking
	@OneToMany(mappedBy="facilityDispatchStatusMaster")
	private Set<FacilityDispatchStatusTracking> facilityDispatchStatusTrackings;

	public FacilityDispatchStatusMaster() {
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

	public Set<FacilityDispatch> getFacilityDispatches() {
		return this.facilityDispatches;
	}

	public void setFacilityDispatches(Set<FacilityDispatch> facilityDispatches) {
		this.facilityDispatches = facilityDispatches;
	}

	public FacilityDispatch addFacilityDispatch(FacilityDispatch facilityDispatch) {
		getFacilityDispatches().add(facilityDispatch);
		facilityDispatch.setFacilityDispatchStatusMaster(this);

		return facilityDispatch;
	}

	public FacilityDispatch removeFacilityDispatch(FacilityDispatch facilityDispatch) {
		getFacilityDispatches().remove(facilityDispatch);
		facilityDispatch.setFacilityDispatchStatusMaster(null);

		return facilityDispatch;
	}

	public Set<FacilityDispatchReceiptRemark> getFacilityDispatchReceiptRemarks() {
		return this.facilityDispatchReceiptRemarks;
	}

	public void setFacilityDispatchReceiptRemarks(Set<FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarks) {
		this.facilityDispatchReceiptRemarks = facilityDispatchReceiptRemarks;
	}

	public FacilityDispatchReceiptRemark addFacilityDispatchReceiptRemark(FacilityDispatchReceiptRemark facilityDispatchReceiptRemark) {
		getFacilityDispatchReceiptRemarks().add(facilityDispatchReceiptRemark);
		facilityDispatchReceiptRemark.setFacilityDispatchStatusMaster(this);

		return facilityDispatchReceiptRemark;
	}

	public FacilityDispatchReceiptRemark removeFacilityDispatchReceiptRemark(FacilityDispatchReceiptRemark facilityDispatchReceiptRemark) {
		getFacilityDispatchReceiptRemarks().remove(facilityDispatchReceiptRemark);
		facilityDispatchReceiptRemark.setFacilityDispatchStatusMaster(null);

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
		facilityDispatchStatusTracking.setFacilityDispatchStatusMaster(this);

		return facilityDispatchStatusTracking;
	}

	public FacilityDispatchStatusTracking removeFacilityDispatchStatusTracking(FacilityDispatchStatusTracking facilityDispatchStatusTracking) {
		getFacilityDispatchStatusTrackings().remove(facilityDispatchStatusTracking);
		facilityDispatchStatusTracking.setFacilityDispatchStatusMaster(null);

		return facilityDispatchStatusTracking;
	}

}