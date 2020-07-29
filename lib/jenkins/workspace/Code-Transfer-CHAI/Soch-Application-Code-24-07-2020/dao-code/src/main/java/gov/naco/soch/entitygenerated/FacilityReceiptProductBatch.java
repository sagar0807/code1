package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the facility_receipt_product_batch database table.
 * 
 */
@Entity
@Table(name="facility_receipt_product_batch")
@NamedQuery(name="FacilityReceiptProductBatch.findAll", query="SELECT f FROM FacilityReceiptProductBatch f")
public class FacilityReceiptProductBatch implements Serializable {
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

	private Integer git;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="quantity_received")
	private Integer quantityReceived;

	@Temporal(TemporalType.DATE)
	@Column(name="reconciliation_date")
	private Date reconciliationDate;

	//bi-directional many-to-one association to FacilityReceiptProduct
	@ManyToOne
	@JoinColumn(name="facility_receipt_product_id")
	private FacilityReceiptProduct facilityReceiptProduct;

	//bi-directional many-to-one association to ReceiptBatchStatusMaster
	@ManyToOne
	@JoinColumn(name="receipt_batch_status_id")
	private ReceiptBatchStatusMaster receiptBatchStatusMaster;

	//bi-directional many-to-one association to FacilityReconciliation
	@OneToMany(mappedBy="facilityReceiptProductBatch")
	private Set<FacilityReconciliation> facilityReconciliations;

	public FacilityReceiptProductBatch() {
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

	public Integer getGit() {
		return this.git;
	}

	public void setGit(Integer git) {
		this.git = git;
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

	public Integer getQuantityReceived() {
		return this.quantityReceived;
	}

	public void setQuantityReceived(Integer quantityReceived) {
		this.quantityReceived = quantityReceived;
	}

	public Date getReconciliationDate() {
		return this.reconciliationDate;
	}

	public void setReconciliationDate(Date reconciliationDate) {
		this.reconciliationDate = reconciliationDate;
	}

	public FacilityReceiptProduct getFacilityReceiptProduct() {
		return this.facilityReceiptProduct;
	}

	public void setFacilityReceiptProduct(FacilityReceiptProduct facilityReceiptProduct) {
		this.facilityReceiptProduct = facilityReceiptProduct;
	}

	public ReceiptBatchStatusMaster getReceiptBatchStatusMaster() {
		return this.receiptBatchStatusMaster;
	}

	public void setReceiptBatchStatusMaster(ReceiptBatchStatusMaster receiptBatchStatusMaster) {
		this.receiptBatchStatusMaster = receiptBatchStatusMaster;
	}

	public Set<FacilityReconciliation> getFacilityReconciliations() {
		return this.facilityReconciliations;
	}

	public void setFacilityReconciliations(Set<FacilityReconciliation> facilityReconciliations) {
		this.facilityReconciliations = facilityReconciliations;
	}

	public FacilityReconciliation addFacilityReconciliation(FacilityReconciliation facilityReconciliation) {
		getFacilityReconciliations().add(facilityReconciliation);
		facilityReconciliation.setFacilityReceiptProductBatch(this);

		return facilityReconciliation;
	}

	public FacilityReconciliation removeFacilityReconciliation(FacilityReconciliation facilityReconciliation) {
		getFacilityReconciliations().remove(facilityReconciliation);
		facilityReconciliation.setFacilityReceiptProductBatch(null);

		return facilityReconciliation;
	}

}