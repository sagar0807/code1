package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the contract_product_schedule_sacs_lot database table.
 * 
 */
@Entity
@Table(name="contract_product_schedule_sacs_lot")
@NamedQuery(name="ContractProductScheduleSacsLot.findAll", query="SELECT c FROM ContractProductScheduleSacsLot c")
public class ContractProductScheduleSacsLot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="lot_number")
	private String lotNumber;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private Integer quantity;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	//bi-directional many-to-one association to ContractProductScheduleSac
	@ManyToOne
	@JoinColumn(name="contract_product_scedule_sacs_id")
	private ContractProductScheduleSac contractProductScheduleSac;

	//bi-directional many-to-one association to Dispatch
	@OneToMany(mappedBy="contractProductScheduleSacsLot")
	private Set<Dispatch> dispatches;

	public ContractProductScheduleSacsLot() {
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

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public String getLotNumber() {
		return this.lotNumber;
	}

	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
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

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public ContractProductScheduleSac getContractProductScheduleSac() {
		return this.contractProductScheduleSac;
	}

	public void setContractProductScheduleSac(ContractProductScheduleSac contractProductScheduleSac) {
		this.contractProductScheduleSac = contractProductScheduleSac;
	}

	public Set<Dispatch> getDispatches() {
		return this.dispatches;
	}

	public void setDispatches(Set<Dispatch> dispatches) {
		this.dispatches = dispatches;
	}

	public Dispatch addDispatch(Dispatch dispatch) {
		getDispatches().add(dispatch);
		dispatch.setContractProductScheduleSacsLot(this);

		return dispatch;
	}

	public Dispatch removeDispatch(Dispatch dispatch) {
		getDispatches().remove(dispatch);
		dispatch.setContractProductScheduleSacsLot(null);

		return dispatch;
	}

}