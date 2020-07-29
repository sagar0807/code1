package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the ti_ost_dispensation_item database table.
 * 
 */
@Entity
@Table(name="ti_ost_dispensation_item")
@NamedQuery(name="TiOstDispensationItem.findAll", query="SELECT t FROM TiOstDispensationItem t")
public class TiOstDispensationItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ost_dispensation_item_id")
	private Integer ostDispensationItemId;

	@Temporal(TemporalType.DATE)
	@Column(name="actual_dispensation_date")
	private Date actualDispensationDate;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Temporal(TemporalType.DATE)
	@Column(name="dispensation_date")
	private Date dispensationDate;

	@Column(name="dispensed_qty")
	private BigDecimal dispensedQty;

	@Column(name="dosage_qty")
	private BigDecimal dosageQty;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_deleted")
	private Boolean isDeleted;

	@Temporal(TemporalType.DATE)
	@Column(name="last_dispensation_date")
	private Date lastDispensationDate;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="substitution_drug")
	private Product product;

	//bi-directional many-to-one association to TiOstBeneficiary
	@ManyToOne
	@JoinColumn(name="ti_ost_beneficiary_id")
	private TiOstBeneficiary tiOstBeneficiary;

	//bi-directional many-to-one association to TiOstBulkDispensation
	@ManyToOne
	@JoinColumn(name="ost_bulk_dispensation_id")
	private TiOstBulkDispensation tiOstBulkDispensation;

	//bi-directional many-to-one association to TiOstPrescription
	@ManyToOne
	@JoinColumn(name="ti_ost_prescription_id")
	private TiOstPrescription tiOstPrescription;

	public TiOstDispensationItem() {
	}

	public Integer getOstDispensationItemId() {
		return this.ostDispensationItemId;
	}

	public void setOstDispensationItemId(Integer ostDispensationItemId) {
		this.ostDispensationItemId = ostDispensationItemId;
	}

	public Date getActualDispensationDate() {
		return this.actualDispensationDate;
	}

	public void setActualDispensationDate(Date actualDispensationDate) {
		this.actualDispensationDate = actualDispensationDate;
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

	public Date getDispensationDate() {
		return this.dispensationDate;
	}

	public void setDispensationDate(Date dispensationDate) {
		this.dispensationDate = dispensationDate;
	}

	public BigDecimal getDispensedQty() {
		return this.dispensedQty;
	}

	public void setDispensedQty(BigDecimal dispensedQty) {
		this.dispensedQty = dispensedQty;
	}

	public BigDecimal getDosageQty() {
		return this.dosageQty;
	}

	public void setDosageQty(BigDecimal dosageQty) {
		this.dosageQty = dosageQty;
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

	public Date getLastDispensationDate() {
		return this.lastDispensationDate;
	}

	public void setLastDispensationDate(Date lastDispensationDate) {
		this.lastDispensationDate = lastDispensationDate;
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

	public TiOstBeneficiary getTiOstBeneficiary() {
		return this.tiOstBeneficiary;
	}

	public void setTiOstBeneficiary(TiOstBeneficiary tiOstBeneficiary) {
		this.tiOstBeneficiary = tiOstBeneficiary;
	}

	public TiOstBulkDispensation getTiOstBulkDispensation() {
		return this.tiOstBulkDispensation;
	}

	public void setTiOstBulkDispensation(TiOstBulkDispensation tiOstBulkDispensation) {
		this.tiOstBulkDispensation = tiOstBulkDispensation;
	}

	public TiOstPrescription getTiOstPrescription() {
		return this.tiOstPrescription;
	}

	public void setTiOstPrescription(TiOstPrescription tiOstPrescription) {
		this.tiOstPrescription = tiOstPrescription;
	}

}