package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the facility_stock database table.
 * 
 */
@Entity
@Table(name="facility_stock")
@NamedQuery(name="FacilityStock.findAll", query="SELECT f FROM FacilityStock f")
public class FacilityStock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="bacth_completion_date")
	private Date bacthCompletionDate;

	@Temporal(TemporalType.DATE)
	@Column(name="batch_inception_date")
	private Date batchInceptionDate;

	@Column(name="batch_number")
	private String batchNumber;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="current_quantity")
	private Integer currentQuantity;

	@Temporal(TemporalType.DATE)
	@Column(name="expired_date")
	private Date expiredDate;

	private Integer git;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Temporal(TemporalType.DATE)
	@Column(name="manufacturing_date")
	private Date manufacturingDate;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="number_of_boxes")
	private Integer numberOfBoxes;

	private String status;

	//bi-directional many-to-one association to ArtDispensationItem
	@OneToMany(mappedBy="facilityStock")
	private Set<ArtDispensationItem> artDispensationItems;

	//bi-directional many-to-one association to ArtPepDispensationItem
	@OneToMany(mappedBy="facilityStock")
	private Set<ArtPepDispensationItem> artPepDispensationItems;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	//bi-directional many-to-one association to TiOstDispensation
	@OneToMany(mappedBy="facilityStock")
	private Set<TiOstDispensation> tiOstDispensations;

	public FacilityStock() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBacthCompletionDate() {
		return this.bacthCompletionDate;
	}

	public void setBacthCompletionDate(Date bacthCompletionDate) {
		this.bacthCompletionDate = bacthCompletionDate;
	}

	public Date getBatchInceptionDate() {
		return this.batchInceptionDate;
	}

	public void setBatchInceptionDate(Date batchInceptionDate) {
		this.batchInceptionDate = batchInceptionDate;
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

	public Integer getCurrentQuantity() {
		return this.currentQuantity;
	}

	public void setCurrentQuantity(Integer currentQuantity) {
		this.currentQuantity = currentQuantity;
	}

	public Date getExpiredDate() {
		return this.expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
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

	public Date getManufacturingDate() {
		return this.manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
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

	public Integer getNumberOfBoxes() {
		return this.numberOfBoxes;
	}

	public void setNumberOfBoxes(Integer numberOfBoxes) {
		this.numberOfBoxes = numberOfBoxes;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<ArtDispensationItem> getArtDispensationItems() {
		return this.artDispensationItems;
	}

	public void setArtDispensationItems(Set<ArtDispensationItem> artDispensationItems) {
		this.artDispensationItems = artDispensationItems;
	}

	public ArtDispensationItem addArtDispensationItem(ArtDispensationItem artDispensationItem) {
		getArtDispensationItems().add(artDispensationItem);
		artDispensationItem.setFacilityStock(this);

		return artDispensationItem;
	}

	public ArtDispensationItem removeArtDispensationItem(ArtDispensationItem artDispensationItem) {
		getArtDispensationItems().remove(artDispensationItem);
		artDispensationItem.setFacilityStock(null);

		return artDispensationItem;
	}

	public Set<ArtPepDispensationItem> getArtPepDispensationItems() {
		return this.artPepDispensationItems;
	}

	public void setArtPepDispensationItems(Set<ArtPepDispensationItem> artPepDispensationItems) {
		this.artPepDispensationItems = artPepDispensationItems;
	}

	public ArtPepDispensationItem addArtPepDispensationItem(ArtPepDispensationItem artPepDispensationItem) {
		getArtPepDispensationItems().add(artPepDispensationItem);
		artPepDispensationItem.setFacilityStock(this);

		return artPepDispensationItem;
	}

	public ArtPepDispensationItem removeArtPepDispensationItem(ArtPepDispensationItem artPepDispensationItem) {
		getArtPepDispensationItems().remove(artPepDispensationItem);
		artPepDispensationItem.setFacilityStock(null);

		return artPepDispensationItem;
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

	public Set<TiOstDispensation> getTiOstDispensations() {
		return this.tiOstDispensations;
	}

	public void setTiOstDispensations(Set<TiOstDispensation> tiOstDispensations) {
		this.tiOstDispensations = tiOstDispensations;
	}

	public TiOstDispensation addTiOstDispensation(TiOstDispensation tiOstDispensation) {
		getTiOstDispensations().add(tiOstDispensation);
		tiOstDispensation.setFacilityStock(this);

		return tiOstDispensation;
	}

	public TiOstDispensation removeTiOstDispensation(TiOstDispensation tiOstDispensation) {
		getTiOstDispensations().remove(tiOstDispensation);
		tiOstDispensation.setFacilityStock(null);

		return tiOstDispensation;
	}

}