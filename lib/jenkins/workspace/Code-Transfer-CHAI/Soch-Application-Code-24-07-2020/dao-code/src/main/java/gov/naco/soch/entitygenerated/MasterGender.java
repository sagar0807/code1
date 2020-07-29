package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the master_gender database table.
 * 
 */
@Entity
@Table(name="master_gender")
@NamedQuery(name="MasterGender.findAll", query="SELECT m FROM MasterGender m")
public class MasterGender implements Serializable {
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
	@OneToMany(mappedBy="masterGender")
	private Set<ArtPep> artPeps;

	//bi-directional many-to-one association to Beneficiary
	@OneToMany(mappedBy="masterGender")
	private Set<Beneficiary> beneficiaries;

	//bi-directional many-to-one association to BeneficiaryFamilyDetail
	@OneToMany(mappedBy="masterGender")
	private Set<BeneficiaryFamilyDetail> beneficiaryFamilyDetails;

	public MasterGender() {
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

	public Set<ArtPep> getArtPeps() {
		return this.artPeps;
	}

	public void setArtPeps(Set<ArtPep> artPeps) {
		this.artPeps = artPeps;
	}

	public ArtPep addArtPep(ArtPep artPep) {
		getArtPeps().add(artPep);
		artPep.setMasterGender(this);

		return artPep;
	}

	public ArtPep removeArtPep(ArtPep artPep) {
		getArtPeps().remove(artPep);
		artPep.setMasterGender(null);

		return artPep;
	}

	public Set<Beneficiary> getBeneficiaries() {
		return this.beneficiaries;
	}

	public void setBeneficiaries(Set<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	public Beneficiary addBeneficiary(Beneficiary beneficiary) {
		getBeneficiaries().add(beneficiary);
		beneficiary.setMasterGender(this);

		return beneficiary;
	}

	public Beneficiary removeBeneficiary(Beneficiary beneficiary) {
		getBeneficiaries().remove(beneficiary);
		beneficiary.setMasterGender(null);

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
		beneficiaryFamilyDetail.setMasterGender(this);

		return beneficiaryFamilyDetail;
	}

	public BeneficiaryFamilyDetail removeBeneficiaryFamilyDetail(BeneficiaryFamilyDetail beneficiaryFamilyDetail) {
		getBeneficiaryFamilyDetails().remove(beneficiaryFamilyDetail);
		beneficiaryFamilyDetail.setMasterGender(null);

		return beneficiaryFamilyDetail;
	}

}