package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the facility_dispatch_product database table.
 * 
 */
@Entity
@Table(name="facility_dispatch_product")
@NamedQuery(name="FacilityDispatchProduct.findAll", query="SELECT f FROM FacilityDispatchProduct f")
public class FacilityDispatchProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="facility_dispatch_product_id")
	private Integer facilityDispatchProductId;

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

	//bi-directional many-to-one association to FacilityDispatch
	@ManyToOne
	@JoinColumn(name="facility_dispatch_id")
	private FacilityDispatch facilityDispatch;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	//bi-directional many-to-one association to FacilityDispatchProductBatch
	@OneToMany(mappedBy="facilityDispatchProduct")
	private Set<FacilityDispatchProductBatch> facilityDispatchProductBatches;

	public FacilityDispatchProduct() {
	}

	public Integer getFacilityDispatchProductId() {
		return this.facilityDispatchProductId;
	}

	public void setFacilityDispatchProductId(Integer facilityDispatchProductId) {
		this.facilityDispatchProductId = facilityDispatchProductId;
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

	public FacilityDispatch getFacilityDispatch() {
		return this.facilityDispatch;
	}

	public void setFacilityDispatch(FacilityDispatch facilityDispatch) {
		this.facilityDispatch = facilityDispatch;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Set<FacilityDispatchProductBatch> getFacilityDispatchProductBatches() {
		return this.facilityDispatchProductBatches;
	}

	public void setFacilityDispatchProductBatches(Set<FacilityDispatchProductBatch> facilityDispatchProductBatches) {
		this.facilityDispatchProductBatches = facilityDispatchProductBatches;
	}

	public FacilityDispatchProductBatch addFacilityDispatchProductBatch(FacilityDispatchProductBatch facilityDispatchProductBatch) {
		getFacilityDispatchProductBatches().add(facilityDispatchProductBatch);
		facilityDispatchProductBatch.setFacilityDispatchProduct(this);

		return facilityDispatchProductBatch;
	}

	public FacilityDispatchProductBatch removeFacilityDispatchProductBatch(FacilityDispatchProductBatch facilityDispatchProductBatch) {
		getFacilityDispatchProductBatches().remove(facilityDispatchProductBatch);
		facilityDispatchProductBatch.setFacilityDispatchProduct(null);

		return facilityDispatchProductBatch;
	}

}