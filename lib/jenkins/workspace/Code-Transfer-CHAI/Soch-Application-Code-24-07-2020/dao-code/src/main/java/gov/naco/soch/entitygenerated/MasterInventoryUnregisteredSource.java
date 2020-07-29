package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the master_inventory_unregistered_source database table.
 * 
 */
@Entity
@Table(name="master_inventory_unregistered_source")
@NamedQuery(name="MasterInventoryUnregisteredSource.findAll", query="SELECT m FROM MasterInventoryUnregisteredSource m")
public class MasterInventoryUnregisteredSource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="is_facility")
	private Boolean isFacility;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="source_name")
	private String sourceName;

	//bi-directional many-to-one association to FacilityDispatch
	@OneToMany(mappedBy="masterInventoryUnregisteredSource")
	private Set<FacilityDispatch> facilityDispatches;

	//bi-directional many-to-one association to FacilityReceipt
	@OneToMany(mappedBy="masterInventoryUnregisteredSource")
	private Set<FacilityReceipt> facilityReceipts;

	//bi-directional many-to-one association to Address
	@ManyToOne
	private Address address;

	public MasterInventoryUnregisteredSource() {
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

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean getIsFacility() {
		return this.isFacility;
	}

	public void setIsFacility(Boolean isFacility) {
		this.isFacility = isFacility;
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

	public String getSourceName() {
		return this.sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public Set<FacilityDispatch> getFacilityDispatches() {
		return this.facilityDispatches;
	}

	public void setFacilityDispatches(Set<FacilityDispatch> facilityDispatches) {
		this.facilityDispatches = facilityDispatches;
	}

	public FacilityDispatch addFacilityDispatch(FacilityDispatch facilityDispatch) {
		getFacilityDispatches().add(facilityDispatch);
		facilityDispatch.setMasterInventoryUnregisteredSource(this);

		return facilityDispatch;
	}

	public FacilityDispatch removeFacilityDispatch(FacilityDispatch facilityDispatch) {
		getFacilityDispatches().remove(facilityDispatch);
		facilityDispatch.setMasterInventoryUnregisteredSource(null);

		return facilityDispatch;
	}

	public Set<FacilityReceipt> getFacilityReceipts() {
		return this.facilityReceipts;
	}

	public void setFacilityReceipts(Set<FacilityReceipt> facilityReceipts) {
		this.facilityReceipts = facilityReceipts;
	}

	public FacilityReceipt addFacilityReceipt(FacilityReceipt facilityReceipt) {
		getFacilityReceipts().add(facilityReceipt);
		facilityReceipt.setMasterInventoryUnregisteredSource(this);

		return facilityReceipt;
	}

	public FacilityReceipt removeFacilityReceipt(FacilityReceipt facilityReceipt) {
		getFacilityReceipts().remove(facilityReceipt);
		facilityReceipt.setMasterInventoryUnregisteredSource(null);

		return facilityReceipt;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}