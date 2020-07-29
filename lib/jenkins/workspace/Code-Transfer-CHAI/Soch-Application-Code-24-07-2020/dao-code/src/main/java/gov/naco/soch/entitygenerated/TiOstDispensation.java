package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the ti_ost_dispensation database table.
 * 
 */
@Entity
@Table(name="ti_ost_dispensation")
@NamedQuery(name="TiOstDispensation.findAll", query="SELECT t FROM TiOstDispensation t")
public class TiOstDispensation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ost_dispensation_id")
	private Integer ostDispensationId;

	@Column(name="available_qty")
	private Integer availableQty;

	@Column(name="batch_number")
	private String batchNumber;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_deleted")
	private Boolean isDeleted;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Temporal(TemporalType.DATE)
	@Column(name="ost_dispensation_date")
	private Date ostDispensationDate;

	@Column(name="total_dispensed_qty")
	private BigDecimal totalDispensedQty;

	@Column(name="total_dosage_qty")
	private BigDecimal totalDosageQty;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to FacilityStock
	@ManyToOne
	@JoinColumn(name="facility_stock_id")
	private FacilityStock facilityStock;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="substitution_drug")
	private Product product;

	//bi-directional many-to-one association to TiOstBulkDispensation
	@ManyToOne
	@JoinColumn(name="ost_bulk_dispensation_id")
	private TiOstBulkDispensation tiOstBulkDispensation;

	public TiOstDispensation() {
	}

	public Integer getOstDispensationId() {
		return this.ostDispensationId;
	}

	public void setOstDispensationId(Integer ostDispensationId) {
		this.ostDispensationId = ostDispensationId;
	}

	public Integer getAvailableQty() {
		return this.availableQty;
	}

	public void setAvailableQty(Integer availableQty) {
		this.availableQty = availableQty;
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

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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

	public Date getOstDispensationDate() {
		return this.ostDispensationDate;
	}

	public void setOstDispensationDate(Date ostDispensationDate) {
		this.ostDispensationDate = ostDispensationDate;
	}

	public BigDecimal getTotalDispensedQty() {
		return this.totalDispensedQty;
	}

	public void setTotalDispensedQty(BigDecimal totalDispensedQty) {
		this.totalDispensedQty = totalDispensedQty;
	}

	public BigDecimal getTotalDosageQty() {
		return this.totalDosageQty;
	}

	public void setTotalDosageQty(BigDecimal totalDosageQty) {
		this.totalDosageQty = totalDosageQty;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public FacilityStock getFacilityStock() {
		return this.facilityStock;
	}

	public void setFacilityStock(FacilityStock facilityStock) {
		this.facilityStock = facilityStock;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public TiOstBulkDispensation getTiOstBulkDispensation() {
		return this.tiOstBulkDispensation;
	}

	public void setTiOstBulkDispensation(TiOstBulkDispensation tiOstBulkDispensation) {
		this.tiOstBulkDispensation = tiOstBulkDispensation;
	}

}