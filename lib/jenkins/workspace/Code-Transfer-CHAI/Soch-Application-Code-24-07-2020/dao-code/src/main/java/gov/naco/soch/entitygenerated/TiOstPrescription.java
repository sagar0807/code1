package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the ti_ost_prescription database table.
 * 
 */
@Entity
@Table(name="ti_ost_prescription")
@NamedQuery(name="TiOstPrescription.findAll", query="SELECT t FROM TiOstPrescription t")
public class TiOstPrescription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="dosage_qty")
	private BigDecimal dosageQty;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Temporal(TemporalType.DATE)
	@Column(name="ost_prescription_date")
	private Date ostPrescriptionDate;

	//bi-directional many-to-one association to TiOstDispensationItem
	@OneToMany(mappedBy="tiOstPrescription")
	private Set<TiOstDispensationItem> tiOstDispensationItems;

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

	//bi-directional many-to-one association to TiOstAssessment
	@ManyToOne
	@JoinColumn(name="ost_assessment_id")
	private TiOstAssessment tiOstAssessment;

	//bi-directional many-to-one association to TiOstBeneficiary
	@ManyToOne
	@JoinColumn(name="ti_ost_beneficiary_id")
	private TiOstBeneficiary tiOstBeneficiary;

	//bi-directional many-to-one association to TiOstFollowUp
	@ManyToOne
	@JoinColumn(name="ost_follow_up_id")
	private TiOstFollowUp tiOstFollowUp;

	public TiOstPrescription() {
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

	public Date getOstPrescriptionDate() {
		return this.ostPrescriptionDate;
	}

	public void setOstPrescriptionDate(Date ostPrescriptionDate) {
		this.ostPrescriptionDate = ostPrescriptionDate;
	}

	public Set<TiOstDispensationItem> getTiOstDispensationItems() {
		return this.tiOstDispensationItems;
	}

	public void setTiOstDispensationItems(Set<TiOstDispensationItem> tiOstDispensationItems) {
		this.tiOstDispensationItems = tiOstDispensationItems;
	}

	public TiOstDispensationItem addTiOstDispensationItem(TiOstDispensationItem tiOstDispensationItem) {
		getTiOstDispensationItems().add(tiOstDispensationItem);
		tiOstDispensationItem.setTiOstPrescription(this);

		return tiOstDispensationItem;
	}

	public TiOstDispensationItem removeTiOstDispensationItem(TiOstDispensationItem tiOstDispensationItem) {
		getTiOstDispensationItems().remove(tiOstDispensationItem);
		tiOstDispensationItem.setTiOstPrescription(null);

		return tiOstDispensationItem;
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

	public TiOstAssessment getTiOstAssessment() {
		return this.tiOstAssessment;
	}

	public void setTiOstAssessment(TiOstAssessment tiOstAssessment) {
		this.tiOstAssessment = tiOstAssessment;
	}

	public TiOstBeneficiary getTiOstBeneficiary() {
		return this.tiOstBeneficiary;
	}

	public void setTiOstBeneficiary(TiOstBeneficiary tiOstBeneficiary) {
		this.tiOstBeneficiary = tiOstBeneficiary;
	}

	public TiOstFollowUp getTiOstFollowUp() {
		return this.tiOstFollowUp;
	}

	public void setTiOstFollowUp(TiOstFollowUp tiOstFollowUp) {
		this.tiOstFollowUp = tiOstFollowUp;
	}

}