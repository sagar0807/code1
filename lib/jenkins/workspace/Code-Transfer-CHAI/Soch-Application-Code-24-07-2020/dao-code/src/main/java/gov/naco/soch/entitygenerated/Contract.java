package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the contract database table.
 * 
 */
@Entity
@NamedQuery(name="Contract.findAll", query="SELECT c FROM Contract c")
public class Contract implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="contract_id")
	private Integer contractId;

	@Column(name="allotment_date")
	private Timestamp allotmentDate;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="indent_num")
	private String indentNum;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="noa_number")
	private String noaNumber;

	//bi-directional many-to-one association to ContractStatusMaster
	@ManyToOne
	@JoinColumn(name="contract_status_id")
	private ContractStatusMaster contractStatusMaster;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="supplier_id")
	private Facility facility;

	//bi-directional many-to-one association to ContractProduct
	@OneToMany(mappedBy="contract")
	private Set<ContractProduct> contractProducts;

	//bi-directional many-to-one association to ContractStatusTracking
	@OneToMany(mappedBy="contract")
	private Set<ContractStatusTracking> contractStatusTrackings;

	//bi-directional many-to-one association to Dispatch
	@OneToMany(mappedBy="contract")
	private Set<Dispatch> dispatches;

	public Contract() {
	}

	public Integer getContractId() {
		return this.contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	public Timestamp getAllotmentDate() {
		return this.allotmentDate;
	}

	public void setAllotmentDate(Timestamp allotmentDate) {
		this.allotmentDate = allotmentDate;
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

	public String getIndentNum() {
		return this.indentNum;
	}

	public void setIndentNum(String indentNum) {
		this.indentNum = indentNum;
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

	public String getNoaNumber() {
		return this.noaNumber;
	}

	public void setNoaNumber(String noaNumber) {
		this.noaNumber = noaNumber;
	}

	public ContractStatusMaster getContractStatusMaster() {
		return this.contractStatusMaster;
	}

	public void setContractStatusMaster(ContractStatusMaster contractStatusMaster) {
		this.contractStatusMaster = contractStatusMaster;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Set<ContractProduct> getContractProducts() {
		return this.contractProducts;
	}

	public void setContractProducts(Set<ContractProduct> contractProducts) {
		this.contractProducts = contractProducts;
	}

	public ContractProduct addContractProduct(ContractProduct contractProduct) {
		getContractProducts().add(contractProduct);
		contractProduct.setContract(this);

		return contractProduct;
	}

	public ContractProduct removeContractProduct(ContractProduct contractProduct) {
		getContractProducts().remove(contractProduct);
		contractProduct.setContract(null);

		return contractProduct;
	}

	public Set<ContractStatusTracking> getContractStatusTrackings() {
		return this.contractStatusTrackings;
	}

	public void setContractStatusTrackings(Set<ContractStatusTracking> contractStatusTrackings) {
		this.contractStatusTrackings = contractStatusTrackings;
	}

	public ContractStatusTracking addContractStatusTracking(ContractStatusTracking contractStatusTracking) {
		getContractStatusTrackings().add(contractStatusTracking);
		contractStatusTracking.setContract(this);

		return contractStatusTracking;
	}

	public ContractStatusTracking removeContractStatusTracking(ContractStatusTracking contractStatusTracking) {
		getContractStatusTrackings().remove(contractStatusTracking);
		contractStatusTracking.setContract(null);

		return contractStatusTracking;
	}

	public Set<Dispatch> getDispatches() {
		return this.dispatches;
	}

	public void setDispatches(Set<Dispatch> dispatches) {
		this.dispatches = dispatches;
	}

	public Dispatch addDispatch(Dispatch dispatch) {
		getDispatches().add(dispatch);
		dispatch.setContract(this);

		return dispatch;
	}

	public Dispatch removeDispatch(Dispatch dispatch) {
		getDispatches().remove(dispatch);
		dispatch.setContract(null);

		return dispatch;
	}

}