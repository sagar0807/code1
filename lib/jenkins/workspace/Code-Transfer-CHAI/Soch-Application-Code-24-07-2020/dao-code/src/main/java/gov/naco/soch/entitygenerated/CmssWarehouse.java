package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the cmss_warehouse database table.
 * 
 */
@Entity
@Table(name="cmss_warehouse")
@NamedQuery(name="CmssWarehouse.findAll", query="SELECT c FROM CmssWarehouse c")
public class CmssWarehouse implements Serializable {
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

	@Column(name="store_id")
	private String storeId;

	@Column(name="store_name")
	private String storeName;

	//bi-directional many-to-one association to SacsCmssWarehouseMapping
	@OneToMany(mappedBy="cmssWarehouse")
	private Set<SacsCmssWarehouseMapping> sacsCmssWarehouseMappings;

	public CmssWarehouse() {
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

	public String getStoreId() {
		return this.storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Set<SacsCmssWarehouseMapping> getSacsCmssWarehouseMappings() {
		return this.sacsCmssWarehouseMappings;
	}

	public void setSacsCmssWarehouseMappings(Set<SacsCmssWarehouseMapping> sacsCmssWarehouseMappings) {
		this.sacsCmssWarehouseMappings = sacsCmssWarehouseMappings;
	}

	public SacsCmssWarehouseMapping addSacsCmssWarehouseMapping(SacsCmssWarehouseMapping sacsCmssWarehouseMapping) {
		getSacsCmssWarehouseMappings().add(sacsCmssWarehouseMapping);
		sacsCmssWarehouseMapping.setCmssWarehouse(this);

		return sacsCmssWarehouseMapping;
	}

	public SacsCmssWarehouseMapping removeSacsCmssWarehouseMapping(SacsCmssWarehouseMapping sacsCmssWarehouseMapping) {
		getSacsCmssWarehouseMappings().remove(sacsCmssWarehouseMapping);
		sacsCmssWarehouseMapping.setCmssWarehouse(null);

		return sacsCmssWarehouseMapping;
	}

}