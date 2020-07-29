package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the facility_dispatch_product_batch database table.
 * 
 */
@Entity
@Table(name="facility_dispatch_product_batch")
@NamedQuery(name="FacilityDispatchProductBatch.findAll", query="SELECT f FROM FacilityDispatchProductBatch f")
public class FacilityDispatchProductBatch implements Serializable {
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

	@Column(name="boxes_no")
	private Integer boxesNo;

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

	@Column(name="quantity_dispatched")
	private Integer quantityDispatched;

	//bi-directional many-to-one association to FacilityDispatchProduct
	@ManyToOne
	@JoinColumn(name="facility_dispatch_product_id")
	private FacilityDispatchProduct facilityDispatchProduct;

	public FacilityDispatchProductBatch() {
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

	public Integer getBoxesNo() {
		return this.boxesNo;
	}

	public void setBoxesNo(Integer boxesNo) {
		this.boxesNo = boxesNo;
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

	public Integer getQuantityDispatched() {
		return this.quantityDispatched;
	}

	public void setQuantityDispatched(Integer quantityDispatched) {
		this.quantityDispatched = quantityDispatched;
	}

	public FacilityDispatchProduct getFacilityDispatchProduct() {
		return this.facilityDispatchProduct;
	}

	public void setFacilityDispatchProduct(FacilityDispatchProduct facilityDispatchProduct) {
		this.facilityDispatchProduct = facilityDispatchProduct;
	}

}