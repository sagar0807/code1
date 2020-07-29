package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the facility_grn_status_master database table.
 * 
 */
@Entity
@Table(name="facility_grn_status_master")
@NamedQuery(name="FacilityGrnStatusMaster.findAll", query="SELECT f FROM FacilityGrnStatusMaster f")
public class FacilityGrnStatusMaster implements Serializable {
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

	//bi-directional many-to-one association to FacilityReceipt
	@OneToMany(mappedBy="facilityGrnStatusMaster")
	private Set<FacilityReceipt> facilityReceipts;

	public FacilityGrnStatusMaster() {
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

	public Set<FacilityReceipt> getFacilityReceipts() {
		return this.facilityReceipts;
	}

	public void setFacilityReceipts(Set<FacilityReceipt> facilityReceipts) {
		this.facilityReceipts = facilityReceipts;
	}

	public FacilityReceipt addFacilityReceipt(FacilityReceipt facilityReceipt) {
		getFacilityReceipts().add(facilityReceipt);
		facilityReceipt.setFacilityGrnStatusMaster(this);

		return facilityReceipt;
	}

	public FacilityReceipt removeFacilityReceipt(FacilityReceipt facilityReceipt) {
		getFacilityReceipts().remove(facilityReceipt);
		facilityReceipt.setFacilityGrnStatusMaster(null);

		return facilityReceipt;
	}

}