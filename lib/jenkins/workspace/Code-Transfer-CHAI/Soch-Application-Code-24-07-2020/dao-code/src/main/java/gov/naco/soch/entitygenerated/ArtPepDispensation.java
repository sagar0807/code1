package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the art_pep_dispensation database table.
 * 
 */
@Entity
@Table(name="art_pep_dispensation")
@NamedQuery(name="ArtPepDispensation.findAll", query="SELECT a FROM ArtPepDispensation a")
public class ArtPepDispensation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="dispense_date")
	private Timestamp dispenseDate;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	//bi-directional many-to-one association to ArtPep
	@ManyToOne
	@JoinColumn(name="pep_id")
	private ArtPep artPep;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="entry_user")
	private UserMaster userMaster;

	//bi-directional many-to-one association to ArtPepDispensationItem
	@OneToMany(mappedBy="artPepDispensation")
	private Set<ArtPepDispensationItem> artPepDispensationItems;

	public ArtPepDispensation() {
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

	public Timestamp getDispenseDate() {
		return this.dispenseDate;
	}

	public void setDispenseDate(Timestamp dispenseDate) {
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

	public ArtPep getArtPep() {
		return this.artPep;
	}

	public void setArtPep(ArtPep artPep) {
		this.artPep = artPep;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public UserMaster getUserMaster() {
		return this.userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

	public Set<ArtPepDispensationItem> getArtPepDispensationItems() {
		return this.artPepDispensationItems;
	}

	public void setArtPepDispensationItems(Set<ArtPepDispensationItem> artPepDispensationItems) {
		this.artPepDispensationItems = artPepDispensationItems;
	}

	public ArtPepDispensationItem addArtPepDispensationItem(ArtPepDispensationItem artPepDispensationItem) {
		getArtPepDispensationItems().add(artPepDispensationItem);
		artPepDispensationItem.setArtPepDispensation(this);

		return artPepDispensationItem;
	}

	public ArtPepDispensationItem removeArtPepDispensationItem(ArtPepDispensationItem artPepDispensationItem) {
		getArtPepDispensationItems().remove(artPepDispensationItem);
		artPepDispensationItem.setArtPepDispensation(null);

		return artPepDispensationItem;
	}

}