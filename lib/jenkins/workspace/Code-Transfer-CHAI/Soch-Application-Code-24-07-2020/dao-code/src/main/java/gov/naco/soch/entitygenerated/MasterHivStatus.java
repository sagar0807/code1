package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the master_hiv_status database table.
 * 
 */
@Entity
@Table(name="master_hiv_status")
@NamedQuery(name="MasterHivStatus.findAll", query="SELECT m FROM MasterHivStatus m")
public class MasterHivStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String code;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	private String description;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private String name;

	//bi-directional many-to-one association to ArtPep
	@OneToMany(mappedBy="masterHivStatus1")
	private Set<ArtPep> artPeps1;

	//bi-directional many-to-one association to ArtPep
	@OneToMany(mappedBy="masterHivStatus2")
	private Set<ArtPep> artPeps2;

	//bi-directional many-to-one association to ArtPep
	@OneToMany(mappedBy="masterHivStatus3")
	private Set<ArtPep> artPeps3;

	//bi-directional many-to-one association to Beneficiary
	@OneToMany(mappedBy="masterHivStatus")
	private Set<Beneficiary> beneficiaries;

	//bi-directional many-to-one association to BeneficiaryFamilyDetail
	@OneToMany(mappedBy="masterHivStatus")
	private Set<BeneficiaryFamilyDetail> beneficiaryFamilyDetails;

	public MasterHivStatus() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ArtPep> getArtPeps1() {
		return this.artPeps1;
	}

	public void setArtPeps1(Set<ArtPep> artPeps1) {
		this.artPeps1 = artPeps1;
	}

	public ArtPep addArtPeps1(ArtPep artPeps1) {
		getArtPeps1().add(artPeps1);
		artPeps1.setMasterHivStatus1(this);

		return artPeps1;
	}

	public ArtPep removeArtPeps1(ArtPep artPeps1) {
		getArtPeps1().remove(artPeps1);
		artPeps1.setMasterHivStatus1(null);

		return artPeps1;
	}

	public Set<ArtPep> getArtPeps2() {
		return this.artPeps2;
	}

	public void setArtPeps2(Set<ArtPep> artPeps2) {
		this.artPeps2 = artPeps2;
	}

	public ArtPep addArtPeps2(ArtPep artPeps2) {
		getArtPeps2().add(artPeps2);
		artPeps2.setMasterHivStatus2(this);

		return artPeps2;
	}

	public ArtPep removeArtPeps2(ArtPep artPeps2) {
		getArtPeps2().remove(artPeps2);
		artPeps2.setMasterHivStatus2(null);

		return artPeps2;
	}

	public Set<ArtPep> getArtPeps3() {
		return this.artPeps3;
	}

	public void setArtPeps3(Set<ArtPep> artPeps3) {
		this.artPeps3 = artPeps3;
	}

	public ArtPep addArtPeps3(ArtPep artPeps3) {
		getArtPeps3().add(artPeps3);
		artPeps3.setMasterHivStatus3(this);

		return artPeps3;
	}

	public ArtPep removeArtPeps3(ArtPep artPeps3) {
		getArtPeps3().remove(artPeps3);
		artPeps3.setMasterHivStatus3(null);

		return artPeps3;
	}

	public Set<Beneficiary> getBeneficiaries() {
		return this.beneficiaries;
	}

	public void setBeneficiaries(Set<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	public Beneficiary addBeneficiary(Beneficiary beneficiary) {
		getBeneficiaries().add(beneficiary);
		beneficiary.setMasterHivStatus(this);

		return beneficiary;
	}

	public Beneficiary removeBeneficiary(Beneficiary beneficiary) {
		getBeneficiaries().remove(beneficiary);
		beneficiary.setMasterHivStatus(null);

		return beneficiary;
	}

	public Set<BeneficiaryFamilyDetail> getBeneficiaryFamilyDetails() {
		return this.beneficiaryFamilyDetails;
	}

	public void setBeneficiaryFamilyDetails(Set<BeneficiaryFamilyDetail> beneficiaryFamilyDetails) {
		this.beneficiaryFamilyDetails = beneficiaryFamilyDetails;
	}

	public BeneficiaryFamilyDetail addBeneficiaryFamilyDetail(BeneficiaryFamilyDetail beneficiaryFamilyDetail) {
		getBeneficiaryFamilyDetails().add(beneficiaryFamilyDetail);
		beneficiaryFamilyDetail.setMasterHivStatus(this);

		return beneficiaryFamilyDetail;
	}

	public BeneficiaryFamilyDetail removeBeneficiaryFamilyDetail(BeneficiaryFamilyDetail beneficiaryFamilyDetail) {
		getBeneficiaryFamilyDetails().remove(beneficiaryFamilyDetail);
		beneficiaryFamilyDetail.setMasterHivStatus(null);

		return beneficiaryFamilyDetail;
	}

}