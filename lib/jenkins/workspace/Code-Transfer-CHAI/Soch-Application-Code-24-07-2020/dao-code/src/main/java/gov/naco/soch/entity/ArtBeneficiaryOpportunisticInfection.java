package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the art_beneficiary_opportunistic_infections
 * database table.
 * 
 */

@GenericGenerator(name = "art_beneficiary_opportunistic_infections", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "art_beneficiary_opportunistic_infections_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name = "art_beneficiary_opportunistic_infections")
@NamedQuery(name = "ArtBeneficiaryOpportunisticInfection.findAll", query = "SELECT a FROM ArtBeneficiaryOpportunisticInfection a")
public class ArtBeneficiaryOpportunisticInfection extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator  = "art_beneficiary_opportunistic_infections")
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to BeneficiaryVisitRegister
	@ManyToOne
	@JoinColumn(name = "visit_register_id")
	private BeneficiaryVisitRegister beneficiaryVisitRegister;

	// bi-directional many-to-one association to MasterOpportunisticInfection
	@ManyToOne
	@JoinColumn(name = "opportunistic_infection_id")
	private MasterOpportunisticInfection masterOpportunisticInfection;

	public ArtBeneficiaryOpportunisticInfection() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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