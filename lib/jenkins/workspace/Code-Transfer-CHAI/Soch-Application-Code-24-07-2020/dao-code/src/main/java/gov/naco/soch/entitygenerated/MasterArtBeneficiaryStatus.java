package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the master_art_beneficiary_status database table.
 * 
 */
@Entity
@Table(name="master_art_beneficiary_status")
@NamedQuery(name="MasterArtBeneficiaryStatus.findAll", query="SELECT m FROM MasterArtBeneficiaryStatus m")
public class MasterArtBeneficiaryStatus implements Serializable {
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

	//bi-directional many-to-one association to ArtBeneficiary
	@OneToMany(mappedBy="masterArtBeneficiaryStatus1")
	private Set<ArtBeneficiary> artBeneficiaries1;

	//bi-directional many-to-one association to ArtBeneficiary
	@OneToMany(mappedBy="masterArtBeneficiaryStatus2")
	private Set<ArtBeneficiary> artBeneficiaries2;

	public MasterArtBeneficiaryStatus() {
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

	public Set<ArtBeneficiary> getArtBeneficiaries1() {
		return this.artBeneficiaries1;
	}

	public void setArtBeneficiaries1(Set<ArtBeneficiary> artBeneficiaries1) {
		this.artBeneficiaries1 = artBeneficiaries1;
	}

	public ArtBeneficiary addArtBeneficiaries1(ArtBeneficiary artBeneficiaries1) {
		getArtBeneficiaries1().add(artBeneficiaries1);
		artBeneficiaries1.setMasterArtBeneficiaryStatus1(this);

		return artBeneficiaries1;
	}

	public ArtBeneficiary removeArtBeneficiaries1(ArtBeneficiary artBeneficiaries1) {
		getArtBeneficiaries1().remove(artBeneficiaries1);
		artBeneficiaries1.setMasterArtBeneficiaryStatus1(null);

		return artBeneficiaries1;
	}

	public Set<ArtBeneficiary> getArtBeneficiaries2() {
		return this.artBeneficiaries2;
	}

	public void setArtBeneficiaries2(Set<ArtBeneficiary> artBeneficiaries2) {
		this.artBeneficiaries2 = artBeneficiaries2;
	}

	public ArtBeneficiary addArtBeneficiaries2(ArtBeneficiary artBeneficiaries2) {
		getArtBeneficiaries2().add(artBeneficiaries2);
		artBeneficiaries2.setMasterArtBeneficiaryStatus2(this);

		return artBeneficiaries2;
	}

	public ArtBeneficiary removeArtBeneficiaries2(ArtBeneficiary artBeneficiaries2) {
		getArtBeneficiaries2().remove(artBeneficiaries2);
		artBeneficiaries2.setMasterArtBeneficiaryStatus2(null);

		return artBeneficiaries2;
	}


}