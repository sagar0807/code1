package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the contract_product_schedule database table.
 * 
 */
@Entity
@GenericGenerator(name = "contract_product_schedule", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "contract_product_schedule_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name="contract_product_schedule")
@NamedQuery(name="ContractProductSchedule.findAll", query="SELECT c FROM ContractProductSchedule c")
public class ContractProductSchedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="contract_product_schedule")
	private Long id;

	@Column(name="created_by")
	private Long createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Long modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private Long quantity;

	@Column(name="schedule_number")
	private String scheduleNumber;

	@Column(name="unit_price")
	private Double unitPrice;

	//bi-directional many-to-one association to ContractProduct
	@ManyToOne
	@JoinColumn(name="contract_product_id")
	private ContractProduct contractProduct;

	//bi-directional many-to-one association to ContractProductScheduleSac
	@OneToMany(mappedBy="contractProductSchedule" ,cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<ContractProductScheduleSac> contractProductScheduleSacs;

	//bi-directional many-to-one association to Dispatch
	@OneToMany(mappedBy="contractProductSchedule",cascade = CascadeType.ALL)
	private Set<Dispatch> dispatches;

	public ContractProductSchedule() {
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

	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getScheduleNumber() {
		return this.scheduleNumber;
	}

	public void setScheduleNumber(String scheduleNumber) {
		this.scheduleNumber = scheduleNumber;
	}

	public Double getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public ContractProduct getContractProduct() {
		return this.contractProduct;
	}

	public void setContractProduct(ContractProduct contractProduct) {
		this.contractProduct = contractProduct;
	}

	public Set<ContractProductScheduleSac> getContractProductScheduleSacs() {
		return this.contractProductScheduleSacs;
	}

	public void setContractProductScheduleSacs(Set<ContractProductScheduleSac> contractProductScheduleSacs) {
		this.contractProductScheduleSacs = contractProductScheduleSacs;
	}

	public ContractProductScheduleSac addContractProductScheduleSac(ContractProductScheduleSac contractProductScheduleSac) {
		getContractProductScheduleSacs().add(contractProductScheduleSac);
		contractProductScheduleSac.setContractProductSchedule(this);

		return contractProductScheduleSac;
	}

	public ContractProductScheduleSac removeContractProductScheduleSac(ContractProductScheduleSac contractProductScheduleSac) {
		getContractProductScheduleSacs().remove(contractProductScheduleSac);
		contractProductScheduleSac.setContractProductSchedule(null);

		return contractProductScheduleSac;
	}

	public Set<Dispatch> getDispatches() {
		return this.dispatches;
	}

	public void setDispatches(Set<Dispatch> dispatches) {
		this.dispatches = dispatches;
	}

	public Dispatch addDispatch(Dispatch dispatch) {
		getDispatches().add(dispatch);
		dispatch.setContractProductSchedule(this);

		return dispatch;
	}

	public Dispatch removeDispatch(Dispatch dispatch) {
		getDispatches().remove(dispatch);
		dispatch.setContractProductSchedule(null);

		return dispatch;
	}

}