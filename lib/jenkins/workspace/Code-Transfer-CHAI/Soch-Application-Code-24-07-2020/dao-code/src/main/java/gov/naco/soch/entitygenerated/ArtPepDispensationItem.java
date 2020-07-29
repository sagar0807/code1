package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the art_pep_dispensation_item database table.
 * 
 */
@Entity
@Table(name="art_pep_dispensation_item")
@NamedQuery(name="ArtPepDispensationItem.findAll", query="SELECT a FROM ArtPepDispensationItem a")
public class ArtPepDispensationItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="batch_number")
	private String batchNumber;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="dispense_quantity")
	private Integer dispenseQuantity;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	//bi-directional many-to-one association to ArtPepDispensation
	@ManyToOne
	@JoinColumn(name="art_pep_dispensation_id")
	private ArtPepDispensation artPepDispensation;

	//bi-directional many-to-one association to FacilityStock
	@ManyToOne
	@JoinColumn(name="facility_stock_id")
	private FacilityStock facilityStock;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	public ArtPepDispensationItem() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public ArtPepDispensation getArtPepDispensation() {
		return this.artPepDispensation;
	}

	public void setArtPepDispensation(ArtPepDispensation artPepDispensation) {
		this.artPepDispensation = artPepDispensation;
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

}