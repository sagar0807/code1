package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the art_beneficiary_opportunistic_infections database table.
 * 
 */
@Entity
@Table(name="art_beneficiary_opportunistic_infections")
@NamedQuery(name="ArtBeneficiaryOpportunisticInfection.findAll", query="SELECT a FROM ArtBeneficiaryOpportunisticInfection a")
public class ArtBeneficiaryOpportunisticInfection implements Serializable {
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

	//bi-directional many-to-one association to BeneficiaryVisitRegister
	@ManyToOne
	@JoinColumn(name="visit_register_id")
	private BeneficiaryVisitRegister beneficiaryVisitRegister;

	//bi-directional many-to-one association to MasterOpportunisticInfection
	@ManyToOne
	@JoinColumn(name="opportunistic_infection_id")
	private MasterOpportunisticInfection masterOpportunisticInfection;

	public ArtBeneficiaryOpportunisticInfection() {
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

	public BeneficiaryVisitRegister getBeneficiaryVisitRegister() {
		return this.beneficiaryVisitRegister;
	}

	public void setBeneficiaryVisitRegister(BeneficiaryVisitRegister beneficiaryVisitRegister) {
		this.beneficiaryVisitRegister = beneficiaryVisitRegister;
	}

	public MasterOpportunisticInfection getMasterOpportunisticInfection() {
		return this.masterOpportunisticInfection;
	}

	public void setMasterOpportunisticInfection(MasterOpportunisticInfection masterOpportunisticInfection) {
		this.masterOpportunisticInfection = masterOpportunisticInfection;
	}

}