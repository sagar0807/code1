package gov.naco.soch.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the contract_product database table.
 * 
 */
@Entity
@GenericGenerator(name = "contract_product", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "contract_product_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "contract_product")
@NamedQuery(name = "ContractProduct.findAll", query = "SELECT c FROM ContractProduct c")
public class ContractProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "contract_product")
	private Long id;

	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "created_time")
	private Timestamp createdTime;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "modified_by")
	private Long modifiedBy;

	@Column(name = "modified_time")
	private Timestamp modifiedTime;

	// bi-directional many-to-one association to Contract
	@ManyToOne
	@JoinColumn(name = "contract_id")
	private Contract contract;

	// bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	// bi-directional many-to-one association to ContractProductSchedule
	@OneToMany(mappedBy = "contractProduct", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ContractProductSchedule> contractProductSchedules;

	// bi-directional many-to-one association to Dispatch
	@OneToMany(mappedBy = "contractProduct", cascade = CascadeType.ALL)
	private Set<Dispatch> dispatches;

	public ContractProduct() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
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

	public Long getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
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
		return dispatches;
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