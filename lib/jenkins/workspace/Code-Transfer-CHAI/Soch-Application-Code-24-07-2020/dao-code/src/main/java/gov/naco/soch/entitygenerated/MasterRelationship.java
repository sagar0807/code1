package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the master_relationship database table.
 * 
 */
@Entity
@Table(name="master_relationship")
@NamedQuery(name="MasterRelationship.findAll", query="SELECT m FROM MasterRelationship m")
public class MasterRelationship implements Serializable {
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

	@Column(name="relationship_code")
	private String relationshipCode;

	@Column(name="relationship_description")
	private String relationshipDescription;

	@Column(name="relationship_name")
	private String relationshipName;

	//bi-directional many-to-one association to BeneficiaryFamilyDetail
	@OneToMany(mappedBy="masterRelationship")
	private Set<BeneficiaryFamilyDetail> beneficiaryFamilyDetails;

	public MasterRelationship() {
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

	public String getRelationshipCode() {
		return this.relationshipCode;
	}

	public void setRelationshipCode(String relationshipCode) {
		this.relationshipCode = relationshipCode;
	}

	public String getRelationshipDescription() {
		return this.relationshipDescription;
	}

	public void setRelationshipDescription(String relationshipDescription) {
		this.relationshipDescription = relationshipDescription;
	}

	public String getRelationshipName() {
		return this.relationshipName;
	}

	public void setRelationshipName(String relationshipName) {
		this.relationshipName = relationshipName;
	}

	public Set<BeneficiaryFamilyDetail> getBeneficiaryFamilyDetails() {
		return this.beneficiaryFamilyDetails;
	}

	public void setBeneficiaryFamilyDetails(Set<BeneficiaryFamilyDetail> beneficiaryFamilyDetails) {
		this.beneficiaryFamilyDetails = beneficiaryFamilyDetails;
	}

	public BeneficiaryFamilyDetail addBeneficiaryFamilyDetail(BeneficiaryFamilyDetail beneficiaryFamilyDetail) {
		getBeneficiaryFamilyDetails().add(beneficiaryFamilyDetail);
		beneficiaryFamilyDetail.setMasterRelationship(this);

		return beneficiaryFamilyDetail;
	}

	public BeneficiaryFamilyDetail removeBeneficiaryFamilyDetail(BeneficiaryFamilyDetail beneficiaryFamilyDetail) {
		getBeneficiaryFamilyDetails().remove(beneficiaryFamilyDetail);
		beneficiaryFamilyDetail.setMasterRelationship(null);

		return beneficiaryFamilyDetail;
	}

}