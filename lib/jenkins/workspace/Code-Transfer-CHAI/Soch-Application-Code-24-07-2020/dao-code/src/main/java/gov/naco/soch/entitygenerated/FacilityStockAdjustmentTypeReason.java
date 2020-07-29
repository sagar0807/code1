package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the facility_stock_adjustment_type_reasons database table.
 * 
 */
@Entity
@Table(name="facility_stock_adjustment_type_reasons")
@NamedQuery(name="FacilityStockAdjustmentTypeReason.findAll", query="SELECT f FROM FacilityStockAdjustmentTypeReason f")
public class FacilityStockAdjustmentTypeReason implements Serializable {
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

	@Column(name="stock_adjustment_reason")
	private String stockAdjustmentReason;

	//bi-directional many-to-one association to FacilityStockAdjustment
	@OneToMany(mappedBy="facilityStockAdjustmentTypeReason")
	private Set<FacilityStockAdjustment> facilityStockAdjustments;

	//bi-directional many-to-one association to FacilityStockAdjustmentTypeMaster
	@ManyToOne
	@JoinColumn(name="adjust_type")
	private FacilityStockAdjustmentTypeMaster facilityStockAdjustmentTypeMaster;

	public FacilityStockAdjustmentTypeReason() {
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

	public String getStockAdjustmentReason() {
		return this.stockAdjustmentReason;
	}

	public void setStockAdjustmentReason(String stockAdjustmentReason) {
		this.stockAdjustmentReason = stockAdjustmentReason;
	}

	public Set<FacilityStockAdjustment> getFacilityStockAdjustments() {
		return this.facilityStockAdjustments;
	}

	public void setFacilityStockAdjustments(Set<FacilityStockAdjustment> facilityStockAdjustments) {
		this.facilityStockAdjustments = facilityStockAdjustments;
	}

	public FacilityStockAdjustment addFacilityStockAdjustment(FacilityStockAdjustment facilityStockAdjustment) {
		getFacilityStockAdjustments().add(facilityStockAdjustment);
		facilityStockAdjustment.setFacilityStockAdjustmentTypeReason(this);

		return facilityStockAdjustment;
	}

	public FacilityStockAdjustment removeFacilityStockAdjustment(FacilityStockAdjustment facilityStockAdjustment) {
		getFacilityStockAdjustments().remove(facilityStockAdjustment);
		facilityStockAdjustment.setFacilityStockAdjustmentTypeReason(null);

		return facilityStockAdjustment;
	}

	public FacilityStockAdjustmentTypeMaster getFacilityStockAdjustmentTypeMaster() {
		return this.facilityStockAdjustmentTypeMaster;
	}

	public void setFacilityStockAdjustmentTypeMaster(FacilityStockAdjustmentTypeMaster facilityStockAdjustmentTypeMaster) {
		this.facilityStockAdjustmentTypeMaster = facilityStockAdjustmentTypeMaster;
	}

}