package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the master_habits_alcohol_use database table.
 * 
 */
@Entity
@Table(name="master_habits_alcohol_use")
@NamedQuery(name="MasterHabitsAlcoholUse.findAll", query="SELECT m FROM MasterHabitsAlcoholUse m")
public class MasterHabitsAlcoholUse implements Serializable {
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

	//bi-directional many-to-one association to ArtBeneficiaryClinicalDetail
	@OneToMany(mappedBy="masterHabitsAlcoholUse")
	private Set<ArtBeneficiaryClinicalDetail> artBeneficiaryClinicalDetails;

	public MasterHabitsAlcoholUse() {
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

	public Set<ArtBeneficiaryClinicalDetail> getArtBeneficiaryClinicalDetails() {
		return this.artBeneficiaryClinicalDetails;
	}

	public void setArtBeneficiaryClinicalDetails(Set<ArtBeneficiaryClinicalDetail> artBeneficiaryClinicalDetails) {
		this.artBeneficiaryClinicalDetails = artBeneficiaryClinicalDetails;
	}

	public ArtBeneficiaryClinicalDetail addArtBeneficiaryClinicalDetail(ArtBeneficiaryClinicalDetail artBeneficiaryClinicalDetail) {
		getArtBeneficiaryClinicalDetails().add(artBeneficiaryClinicalDetail);
		artBeneficiaryClinicalDetail.setMasterHabitsAlcoholUse(this);

		return artBeneficiaryClinicalDetail;
	}

	public ArtBeneficiaryClinicalDetail removeArtBeneficiaryClinicalDetail(ArtBeneficiaryClinicalDetail artBeneficiaryClinicalDetail) {
		getArtBeneficiaryClinicalDetails().remove(artBeneficiaryClinicalDetail);
		artBeneficiaryClinicalDetail.setMasterHabitsAlcoholUse(null);

		return artBeneficiaryClinicalDetail;
	}

}