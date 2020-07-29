package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the dispatch_batch database table.
 * 
 */
@Entity
@Table(name="dispatch_batch")
@NamedQuery(name="DispatchBatch.findAll", query="SELECT d FROM DispatchBatch d")
public class DispatchBatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="batch_expiry_date")
	private Timestamp batchExpiryDate;

	@Column(name="batch_manufacture_date")
	private Timestamp batchManufactureDate;

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

	@Column(name="quantity_number")
	private Integer quantityNumber;

	//bi-directional many-to-one association to Dispatch
	@ManyToOne
	@JoinColumn(name="dispatch_id")
	private Dispatch dispatch;

	//bi-directional many-to-one association to SupplierStock
	@ManyToOne
	@JoinColumn(name="batch_number")
	private SupplierStock supplierStock;

	public DispatchBatch() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getBatchExpiryDate() {
		return this.batchExpiryDate;
	}

	public void setBatchExpiryDate(Timestamp batchExpiryDate) {
		this.batchExpiryDate = batchExpiryDate;
	}

	public Timestamp getBatchManufactureDate() {
		return this.batchManufactureDate;
	}

	public void setBatchManufactureDate(Timestamp batchManufactureDate) {
		this.batchManufactureDate = batchManufactureDate;
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

	public Integer getQuantityNumber() {
		return this.quantityNumber;
	}

	public void setQuantityNumber(Integer quantityNumber) {
		this.quantityNumber = quantityNumber;
	}

	public Dispatch getDispatch() {
		return this.dispatch;
	}

	public void setDispatch(Dispatch dispatch) {
		this.dispatch = dispatch;
	}

	public SupplierStock getSupplierStock() {
		return this.supplierStock;
	}

	public void setSupplierStock(SupplierStock supplierStock) {
		this.supplierStock = supplierStock;
	}

}