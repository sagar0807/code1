package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the receipt_batch database table.
 * 
 */
@Entity
@Table(name="receipt_batch")
@NamedQuery(name="ReceiptBatch.findAll", query="SELECT r FROM ReceiptBatch r")
public class ReceiptBatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="batch_expiry_date")
	private Timestamp batchExpiryDate;

	@Column(name="batch_manufacture_date")
	private Timestamp batchManufactureDate;

	@Column(name="batch_number")
	private String batchNumber;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="damaged_quantity")
	private Integer damagedQuantity;

	@Column(name="dispatched_quantity")
	private Integer dispatchedQuantity;

	@Column(name="grn1_quantity")
	private Integer grn1Quantity;

	@Column(name="grn2_quantity")
	private Integer grn2Quantity;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	//bi-directional many-to-one association to Receipt
	@ManyToOne
	private Receipt receipt;

	public ReceiptBatch() {
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

	public String getBatchNumber() {
		return this.batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
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

	public Integer getDamagedQuantity() {
		return this.damagedQuantity;
	}

	public void setDamagedQuantity(Integer damagedQuantity) {
		this.damagedQuantity = damagedQuantity;
	}

	public Integer getDispatchedQuantity() {
		return this.dispatchedQuantity;
	}

	public void setDispatchedQuantity(Integer dispatchedQuantity) {
		this.dispatchedQuantity = dispatchedQuantity;
	}

	public Integer getGrn1Quantity() {
		return this.grn1Quantity;
	}

	public void setGrn1Quantity(Integer grn1Quantity) {
		this.grn1Quantity = grn1Quantity;
	}

	public Integer getGrn2Quantity() {
		return this.grn2Quantity;
	}

	public void setGrn2Quantity(Integer grn2Quantity) {
		this.grn2Quantity = grn2Quantity;
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

	public Receipt getReceipt() {
		return this.receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

}