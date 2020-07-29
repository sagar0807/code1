package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the ti_ost_bulk_dispensation database table.
 * 
 */
@Entity
@Table(name="ti_ost_bulk_dispensation")
@NamedQuery(name="TiOstBulkDispensation.findAll", query="SELECT t FROM TiOstBulkDispensation t")
public class TiOstBulkDispensation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ost_bulk_dispensation_id")
	private Integer ostBulkDispensationId;

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
	@Column(name="ost_bulk_dispensation_date")
	private Date ostBulkDispensationDate;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to MasterDrug
	@ManyToOne
	@JoinColumn(name="substitution_drug")
	private MasterDrug masterDrug;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="substitution_drug")
	private Product product;

	//bi-directional many-to-one association to TiOstDispensation
	@OneToMany(mappedBy="tiOstBulkDispensation")
	private Set<TiOstDispensation> tiOstDispensations;

	//bi-directional many-to-one association to TiOstDispensationItem
	@OneToMany(mappedBy="tiOstBulkDispensation")
	private Set<TiOstDispensationItem> tiOstDispensationItems;

	public TiOstBulkDispensation() {
	}

	public Integer getOstBulkDispensationId() {
		return this.ostBulkDispensationId;
	}

	public void setOstBulkDispensationId(Integer ostBulkDispensationId) {
		this.ostBulkDispensationId = ostBulkDispensationId;
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

	public Date getOstBulkDispensationDate() {
		return this.ostBulkDispensationDate;
	}

	public void setOstBulkDispensationDate(Date ostBulkDispensationDate) {
		this.ostBulkDispensationDate = ostBulkDispensationDate;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public MasterDrug getMasterDrug() {
		return this.masterDrug;
	}

	public void setMasterDrug(MasterDrug masterDrug) {
		this.masterDrug = masterDrug;
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
		tiOstDispensation.setTiOstBulkDispensation(this);

		return tiOstDispensation;
	}

	public TiOstDispensation removeTiOstDispensation(TiOstDispensation tiOstDispensation) {
		getTiOstDispensations().remove(tiOstDispensation);
		tiOstDispensation.setTiOstBulkDispensation(null);

		return tiOstDispensation;
	}

	public Set<TiOstDispensationItem> getTiOstDispensationItems() {
		return this.tiOstDispensationItems;
	}

	public void setTiOstDispensationItems(Set<TiOstDispensationItem> tiOstDispensationItems) {
		this.tiOstDispensationItems = tiOstDispensationItems;
	}

	public TiOstDispensationItem addTiOstDispensationItem(TiOstDispensationItem tiOstDispensationItem) {
		getTiOstDispensationItems().add(tiOstDispensationItem);
		tiOstDispensationItem.setTiOstBulkDispensation(this);

		return tiOstDispensationItem;
	}

	public TiOstDispensationItem removeTiOstDispensationItem(TiOstDispensationItem tiOstDispensationItem) {
		getTiOstDispensationItems().remove(tiOstDispensationItem);
		tiOstDispensationItem.setTiOstBulkDispensation(null);

		return tiOstDispensationItem;
	}

}