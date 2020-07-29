package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the art_dispensation database table.
 * 
 */
@Entity
@Table(name="art_dispensation")
@NamedQuery(name="ArtDispensation.findAll", query="SELECT a FROM ArtDispensation a")
public class ArtDispensation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Temporal(TemporalType.DATE)
	@Column(name="dispense_date")
	private Date dispenseDate;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="is_transit")
	private Boolean isTransit;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to BeneficiaryVisitRegister
	@ManyToOne
	@JoinColumn(name="visit_register_id")
	private BeneficiaryVisitRegister beneficiaryVisitRegister;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to MasterModeOfDispensation
	@ManyToOne
	@JoinColumn(name="mode_of_dispensation")
	private MasterModeOfDispensation masterModeOfDispensation;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="entry_user")
	private UserMaster userMaster;

	//bi-directional many-to-one association to ArtDispensationItem
	@OneToMany(mappedBy="artDispensation")
	private Set<ArtDispensationItem> artDispensationItems;

	public ArtDispensation() {
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

	public Date getDispenseDate() {
		return this.dispenseDate;
	}

	public void setDispenseDate(Date dispenseDate) {
		this.dispenseDate = dispenseDate;
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

	public Boolean getIsTransit() {
		return this.isTransit;
	}

	public void setIsTransit(Boolean isTransit) {
		this.isTransit = isTransit;
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

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public BeneficiaryVisitRegister getBeneficiaryVisitRegister() {
		return this.beneficiaryVisitRegister;
	}

	public void setBeneficiaryVisitRegister(BeneficiaryVisitRegister beneficiaryVisitRegister) {
		this.beneficiaryVisitRegister = beneficiaryVisitRegister;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public MasterModeOfDispensation getMasterModeOfDispensation() {
		return this.masterModeOfDispensation;
	}

	public void setMasterModeOfDispensation(MasterModeOfDispensation masterModeOfDispensation) {
		this.masterModeOfDispensation = masterModeOfDispensation;
	}

	public UserMaster getUserMaster() {
		return this.userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

	public Set<ArtDispensationItem> getArtDispensationItems() {
		return this.artDispensationItems;
	}

	public void setArtDispensationItems(Set<ArtDispensationItem> artDispensationItems) {
		this.artDispensationItems = artDispensationItems;
	}

	public ArtDispensationItem addArtDispensationItem(ArtDispensationItem artDispensationItem) {
		getArtDispensationItems().add(artDispensationItem);
		artDispensationItem.setArtDispensation(this);

		return artDispensationItem;
	}

	public ArtDispensationItem removeArtDispensationItem(ArtDispensationItem artDispensationItem) {
		getArtDispensationItems().remove(artDispensationItem);
		artDispensationItem.setArtDispensation(null);

		return artDispensationItem;
	}

}