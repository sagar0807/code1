package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the art_dispensation_item database table.
 * 
 */
@Entity
@Table(name="art_dispensation_item")
@NamedQuery(name="ArtDispensationItem.findAll", query="SELECT a FROM ArtDispensationItem a")
public class ArtDispensationItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="adherence_to_art")
	private BigDecimal adherenceToArt;

	@Column(name="batch_number")
	private String batchNumber;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="dispense_quantity")
	private Integer dispenseQuantity;

	@Column(name="dosage_qty")
	private Integer dosageQty;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="remaining_pills")
	private Integer remainingPills;

	@Column(name="return_qty")
	private Integer returnQty;

	//bi-directional many-to-one association to ArtDispensation
	@ManyToOne
	@JoinColumn(name="art_dispensation_id")
	private ArtDispensation artDispensation;

	//bi-directional many-to-one association to FacilityStock
	@ManyToOne
	@JoinColumn(name="facility_stock_id")
	private FacilityStock facilityStock;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	//bi-directional many-to-one association to Regimen
	@ManyToOne
	private Regimen regimen;

	public ArtDispensationItem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getAdherenceToArt() {
		return this.adherenceToArt;
	}

	public void setAdherenceToArt(BigDecimal adherenceToArt) {
		this.adherenceToArt = adherenceToArt;
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

	public Integer getDispenseQuantity() {
		return this.dispenseQuantity;
	}

	public void setDispenseQuantity(Integer dispenseQuantity) {
		this.dispenseQuantity = dispenseQuantity;
	}

	public Integer getDosageQty() {
		return this.dosageQty;
	}

	public void setDosageQty(Integer dosageQty) {
		this.dosageQty = dosageQty;
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

	public Integer getRemainingPills() {
		return this.remainingPills;
	}

	public void setRemainingPills(Integer remainingPills) {
		this.remainingPills = remainingPills;
	}

	public Integer getReturnQty() {
		return this.returnQty;
	}

	public void setReturnQty(Integer returnQty) {
		this.returnQty = returnQty;
	}

	public ArtDispensation getArtDispensation() {
		return this.artDispensation;
	}

	public void setArtDispensation(ArtDispensation artDispensation) {
		this.artDispensation = artDispensation;
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

	public Regimen getRegimen() {
		return this.regimen;
	}

	public void setRegimen(Regimen regimen) {
		this.regimen = regimen;
	}

}