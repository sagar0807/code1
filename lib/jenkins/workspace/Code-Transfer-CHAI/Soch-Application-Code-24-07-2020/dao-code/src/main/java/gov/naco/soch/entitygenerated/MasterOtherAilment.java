package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the master_other_ailments database table.
 * 
 */
@Entity
@Table(name="master_other_ailments")
@NamedQuery(name="MasterOtherAilment.findAll", query="SELECT m FROM MasterOtherAilment m")
public class MasterOtherAilment implements Serializable {
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

	//bi-directional many-to-one association to ArtBeneficiaryCoexistingCondition
	@OneToMany(mappedBy="masterOtherAilment")
	private Set<ArtBeneficiaryCoexistingCondition> artBeneficiaryCoexistingConditions;

	//bi-directional many-to-one association to ArtBeneficiaryConcurrentCondition
	@OneToMany(mappedBy="masterOtherAilment")
	private Set<ArtBeneficiaryConcurrentCondition> artBeneficiaryConcurrentConditions;

	public MasterOtherAilment() {
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

	public Set<ArtBeneficiaryCoexistingCondition> getArtBeneficiaryCoexistingConditions() {
		return this.artBeneficiaryCoexistingConditions;
	}

	public void setArtBeneficiaryCoexistingConditions(Set<ArtBeneficiaryCoexistingCondition> artBeneficiaryCoexistingConditions) {
		this.artBeneficiaryCoexistingConditions = artBeneficiaryCoexistingConditions;
	}

	public ArtBeneficiaryCoexistingCondition addArtBeneficiaryCoexistingCondition(ArtBeneficiaryCoexistingCondition artBeneficiaryCoexistingCondition) {
		getArtBeneficiaryCoexistingConditions().add(artBeneficiaryCoexistingCondition);
		artBeneficiaryCoexistingCondition.setMasterOtherAilment(this);

		return artBeneficiaryCoexistingCondition;
	}

	public ArtBeneficiaryCoexistingCondition removeArtBeneficiaryCoexistingCondition(ArtBeneficiaryCoexistingCondition artBeneficiaryCoexistingCondition) {
		getArtBeneficiaryCoexistingConditions().remove(artBeneficiaryCoexistingCondition);
		artBeneficiaryCoexistingCondition.setMasterOtherAilment(null);

		return artBeneficiaryCoexistingCondition;
	}

	public Set<ArtBeneficiaryConcurrentCondition> getArtBeneficiaryConcurrentConditions() {
		return this.artBeneficiaryConcurrentConditions;
	}

	public void setArtBeneficiaryConcurrentConditions(Set<ArtBeneficiaryConcurrentCondition> artBeneficiaryConcurrentConditions) {
		this.artBeneficiaryConcurrentConditions = artBeneficiaryConcurrentConditions;
	}

	public ArtBeneficiaryConcurrentCondition addArtBeneficiaryConcurrentCondition(ArtBeneficiaryConcurrentCondition artBeneficiaryConcurrentCondition) {
		getArtBeneficiaryConcurrentConditions().add(artBeneficiaryConcurrentCondition);
		artBeneficiaryConcurrentCondition.setMasterOtherAilment(this);

		return artBeneficiaryConcurrentCondition;
	}

	public ArtBeneficiaryConcurrentCondition removeArtBeneficiaryConcurrentCondition(ArtBeneficiaryConcurrentCondition artBeneficiaryConcurrentCondition) {
		getArtBeneficiaryConcurrentConditions().remove(artBeneficiaryConcurrentCondition);
		artBeneficiaryConcurrentCondition.setMasterOtherAilment(null);

		return artBeneficiaryConcurrentCondition;
	}

}