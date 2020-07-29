package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the contract_product_schedule_sacs database table.
 * 
 */
@Entity
@Table(name="contract_product_schedule_sacs")
@NamedQuery(name="ContractProductScheduleSac.findAll", query="SELECT c FROM ContractProductScheduleSac c")
public class ContractProductScheduleSac implements Serializable {
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

	//bi-directional many-to-one association to ContractProductSchedule
	@ManyToOne
	@JoinColumn(name="contract_product_schedule_id")
	private ContractProductSchedule contractProductSchedule;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="to_facility")
	private Facility facility;

	//bi-directional many-to-one association to ContractProductScheduleSacsLot
	@OneToMany(mappedBy="contractProductScheduleSac")
	private Set<ContractProductScheduleSacsLot> contractProductScheduleSacsLots;

	public ContractProductScheduleSac() {
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

	public ContractProductSchedule getContractProductSchedule() {
		return this.contractProductSchedule;
	}

	public void setContractProductSchedule(ContractProductSchedule contractProductSchedule) {
		this.contractProductSchedule = contractProductSchedule;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Set<ContractProductScheduleSacsLot> getContractProductScheduleSacsLots() {
		return this.contractProductScheduleSacsLots;
	}

	public void setContractProductScheduleSacsLots(Set<ContractProductScheduleSacsLot> contractProductScheduleSacsLots) {
		this.contractProductScheduleSacsLots = contractProductScheduleSacsLots;
	}

	public ContractProductScheduleSacsLot addContractProductScheduleSacsLot(ContractProductScheduleSacsLot contractProductScheduleSacsLot) {
		getContractProductScheduleSacsLots().add(contractProductScheduleSacsLot);
		contractProductScheduleSacsLot.setContractProductScheduleSac(this);

		return contractProductScheduleSacsLot;
	}

	public ContractProductScheduleSacsLot removeContractProductScheduleSacsLot(ContractProductScheduleSacsLot contractProductScheduleSacsLot) {
		getContractProductScheduleSacsLots().remove(contractProductScheduleSacsLot);
		contractProductScheduleSacsLot.setContractProductScheduleSac(null);

		return contractProductScheduleSacsLot;
	}

}