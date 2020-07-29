package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the supplier_stock database table.
 * 
 */
@Entity
@Table(name="supplier_stock")
@NamedQuery(name="SupplierStock.findAll", query="SELECT s FROM SupplierStock s")
public class SupplierStock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="supplier_stock_id")
	private Integer supplierStockId;

	@Column(name="batch_number")
	private String batchNumber;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="expiry_date")
	private Timestamp expiryDate;

	@Column(name="manufacture_date")
	private Timestamp manufactureDate;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="remaining_self_life")
	private String remainingSelfLife;

	//bi-directional many-to-one association to DispatchBatch
	@OneToMany(mappedBy="supplierStock")
	private Set<DispatchBatch> dispatchBatches;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="supplier_id")
	private Facility facility;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	public SupplierStock() {
	}

	public Integer getSupplierStockId() {
		return this.supplierStockId;
	}

	public void setSupplierStockId(Integer supplierStockId) {
		this.supplierStockId = supplierStockId;
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

	public Timestamp getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Timestamp getManufactureDate() {
		return this.manufactureDate;
	}

	public void setManufactureDate(Timestamp manufactureDate) {
		this.manufactureDate = manufactureDate;
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

	public String getRemainingSelfLife() {
		return this.remainingSelfLife;
	}

	public void setRemainingSelfLife(String remainingSelfLife) {
		this.remainingSelfLife = remainingSelfLife;
	}

	public Set<DispatchBatch> getDispatchBatches() {
		return this.dispatchBatches;
	}

	public void setDispatchBatches(Set<DispatchBatch> dispatchBatches) {
		this.dispatchBatches = dispatchBatches;
	}

	public DispatchBatch addDispatchBatch(DispatchBatch dispatchBatch) {
		getDispatchBatches().add(dispatchBatch);
		dispatchBatch.setSupplierStock(this);

		return dispatchBatch;
	}

	public DispatchBatch removeDispatchBatch(DispatchBatch dispatchBatch) {
		getDispatchBatches().remove(dispatchBatch);
		dispatchBatch.setSupplierStock(null);

		return dispatchBatch;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}