package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the facility_receipt_product database table.
 * 
 */
@Entity
@Table(name="facility_receipt_product")
@NamedQuery(name="FacilityReceiptProduct.findAll", query="SELECT f FROM FacilityReceiptProduct f")
public class FacilityReceiptProduct implements Serializable {
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

	//bi-directional many-to-one association to FacilityReceipt
	@ManyToOne
	@JoinColumn(name="facility_receipt_id")
	private FacilityReceipt facilityReceipt;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	//bi-directional many-to-one association to FacilityReceiptProductBatch
	@OneToMany(mappedBy="facilityReceiptProduct")
	private Set<FacilityReceiptProductBatch> facilityReceiptProductBatches;

	public FacilityReceiptProduct() {
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

	public FacilityReceipt getFacilityReceipt() {
		return this.facilityReceipt;
	}

	public void setFacilityReceipt(FacilityReceipt facilityReceipt) {
		this.facilityReceipt = facilityReceipt;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Set<FacilityReceiptProductBatch> getFacilityReceiptProductBatches() {
		return this.facilityReceiptProductBatches;
	}

	public void setFacilityReceiptProductBatches(Set<FacilityReceiptProductBatch> facilityReceiptProductBatches) {
		this.facilityReceiptProductBatches = facilityReceiptProductBatches;
	}

	public FacilityReceiptProductBatch addFacilityReceiptProductBatch(FacilityReceiptProductBatch facilityReceiptProductBatch) {
		getFacilityReceiptProductBatches().add(facilityReceiptProductBatch);
		facilityReceiptProductBatch.setFacilityReceiptProduct(this);

		return facilityReceiptProductBatch;
	}

	public FacilityReceiptProductBatch removeFacilityReceiptProductBatch(FacilityReceiptProductBatch facilityReceiptProductBatch) {
		getFacilityReceiptProductBatches().remove(facilityReceiptProductBatch);
		facilityReceiptProductBatch.setFacilityReceiptProduct(null);

		return facilityReceiptProductBatch;
	}

}