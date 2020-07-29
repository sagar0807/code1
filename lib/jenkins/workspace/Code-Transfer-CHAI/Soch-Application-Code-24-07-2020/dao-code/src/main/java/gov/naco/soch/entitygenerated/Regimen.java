package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the regimen database table.
 * 
 */
@Entity
@NamedQuery(name="Regimen.findAll", query="SELECT r FROM Regimen r")
public class Regimen implements Serializable {
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

	@Column(name="regimen_name")
	private String regimenName;

	//bi-directional many-to-one association to ArtBeneficiaryClinicalDetail
	@OneToMany(mappedBy="regimen")
	private Set<ArtBeneficiaryClinicalDetail> artBeneficiaryClinicalDetails;

	//bi-directional many-to-one association to ArtDispensationItem
	@OneToMany(mappedBy="regimen")
	private Set<ArtDispensationItem> artDispensationItems;

	//bi-directional many-to-one association to MasterData
	@ManyToOne
	@JoinColumn(name="adult_ped")
	private MasterData masterData1;

	//bi-directional many-to-one association to MasterData
	@ManyToOne
	@JoinColumn(name="line")
	private MasterData masterData2;

	//bi-directional many-to-one association to RegimenConstituent
	@OneToMany(mappedBy="regimen")
	private Set<RegimenConstituent> regimenConstituents;

	public Regimen() {
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

	public String getRegimenName() {
		return this.regimenName;
	}

	public void setRegimenName(String regimenName) {
		this.regimenName = regimenName;
	}

	public Set<ArtBeneficiaryClinicalDetail> getArtBeneficiaryClinicalDetails() {
		return this.artBeneficiaryClinicalDetails;
	}

	public void setArtBeneficiaryClinicalDetails(Set<ArtBeneficiaryClinicalDetail> artBeneficiaryClinicalDetails) {
		this.artBeneficiaryClinicalDetails = artBeneficiaryClinicalDetails;
	}

	public ArtBeneficiaryClinicalDetail addArtBeneficiaryClinicalDetail(ArtBeneficiaryClinicalDetail artBeneficiaryClinicalDetail) {
		getArtBeneficiaryClinicalDetails().add(artBeneficiaryClinicalDetail);
		artBeneficiaryClinicalDetail.setRegimen(this);

		return artBeneficiaryClinicalDetail;
	}

	public ArtBeneficiaryClinicalDetail removeArtBeneficiaryClinicalDetail(ArtBeneficiaryClinicalDetail artBeneficiaryClinicalDetail) {
		getArtBeneficiaryClinicalDetails().remove(artBeneficiaryClinicalDetail);
		artBeneficiaryClinicalDetail.setRegimen(null);

		return artBeneficiaryClinicalDetail;
	}

	public Set<ArtDispensationItem> getArtDispensationItems() {
		return this.artDispensationItems;
	}

	public void setArtDispensationItems(Set<ArtDispensationItem> artDispensationItems) {
		this.artDispensationItems = artDispensationItems;
	}

	public ArtDispensationItem addArtDispensationItem(ArtDispensationItem artDispensationItem) {
		getArtDispensationItems().add(artDispensationItem);
		artDispensationItem.setRegimen(this);

		return artDispensationItem;
	}

	public ArtDispensationItem removeArtDispensationItem(ArtDispensationItem artDispensationItem) {
		getArtDispensationItems().remove(artDispensationItem);
		artDispensationItem.setRegimen(null);

		return artDispensationItem;
	}

	public MasterData getMasterData1() {
		return this.masterData1;
	}

	public void setMasterData1(MasterData masterData1) {
		this.masterData1 = masterData1;
	}

	public MasterData getMasterData2() {
		return this.masterData2;
	}

	public void setMasterData2(MasterData masterData2) {
		this.masterData2 = masterData2;
	}

	public Set<RegimenConstituent> getRegimenConstituents() {
		return this.regimenConstituents;
	}

	public void setRegimenConstituents(Set<RegimenConstituent> regimenConstituents) {
		this.regimenConstituents = regimenConstituents;
	}

	public RegimenConstituent addRegimenConstituent(RegimenConstituent regimenConstituent) {
		getRegimenConstituents().add(regimenConstituent);
		regimenConstituent.setRegimen(this);

		return regimenConstituent;
	}

	public RegimenConstituent removeRegimenConstituent(RegimenConstituent regimenConstituent) {
		getRegimenConstituents().remove(regimenConstituent);
		regimenConstituent.setRegimen(null);

		return regimenConstituent;
	}

}