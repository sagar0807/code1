package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the contract_product database table.
 * 
 */
@Entity
@Table(name="contract_product")
@NamedQuery(name="ContractProduct.findAll", query="SELECT c FROM ContractProduct c")
public class ContractProduct implements Serializable {
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

	//bi-directional many-to-one association to Contract
	@ManyToOne
	@JoinColumn(name="contract_id")
	private Contract contract;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	//bi-directional many-to-one association to ContractProductSchedule
	@OneToMany(mappedBy="contractProduct")
	private Set<ContractProductSchedule> contractProductSchedules;

	//bi-directional many-to-one association to Dispatch
	@OneToMany(mappedBy="contractProduct")
	private Set<Dispatch> dispatches;

	public ContractProduct() {
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

	public Contract getContract() {
		return this.contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Set<ContractProductSchedule> getContractProductSchedules() {
		return this.contractProductSchedules;
	}

	public void setContractProductSchedules(Set<ContractProductSchedule> contractProductSchedules) {
		this.contractProductSchedules = contractProductSchedules;
	}

	public ContractProductSchedule addContractProductSchedule(ContractProductSchedule contractProductSchedule) {
		getContractProductSchedules().add(contractProductSchedule);
		contractProductSchedule.setContractProduct(this);

		return contractProductSchedule;
	}

	public ContractProductSchedule removeContractProductSchedule(ContractProductSchedule contractProductSchedule) {
		getContractProductSchedules().remove(contractProductSchedule);
		contractProductSchedule.setContractProduct(null);

		return contractProductSchedule;
	}

	public Set<Dispatch> getDispatches() {
		return this.dispatches;
	}

	public void setDispatches(Set<Dispatch> dispatches) {
		this.dispatches = dispatches;
	}

	public Dispatch addDispatch(Dispatch dispatch) {
		getDispatches().add(dispatch);
		dispatch.setContractProduct(this);

		return dispatch;
	}

	public Dispatch removeDispatch(Dispatch dispatch) {
		getDispatches().remove(dispatch);
		dispatch.setContractProduct(null);

		return dispatch;
	}

}