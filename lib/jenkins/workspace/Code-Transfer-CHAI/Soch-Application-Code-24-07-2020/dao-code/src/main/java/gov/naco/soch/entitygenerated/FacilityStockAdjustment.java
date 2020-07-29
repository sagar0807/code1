package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the facility_stock_adjustment database table.
 * 
 */
@Entity
@Table(name="facility_stock_adjustment")
@NamedQuery(name="FacilityStockAdjustment.findAll", query="SELECT f FROM FacilityStockAdjustment f")
public class FacilityStockAdjustment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="adjust_stock_quantity")
	private Integer adjustStockQuantity;

	@Column(name="batch_number")
	private String batchNumber;

	@Column(name="beneficiary_quantity")
	private Integer beneficiaryQuantity;

	@Column(name="bulk_dispense_quantity")
	private Integer bulkDispenseQuantity;

	@Column(name="control_quantity")
	private Integer controlQuantity;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="current_quantity")
	private Integer currentQuantity;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_addition_or_consupmtion")
	private Date dateOfAdditionOrConsupmtion;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="other_quantity")
	private Integer otherQuantity;

	@Column(name="qa_quantity")
	private Integer qaQuantity;

	private String remark;

	@Column(name="testing_quantity")
	private Integer testingQuantity;

	@Column(name="total_quantity")
	private Integer totalQuantity;

	@Column(name="wastage_quantity")
	private Integer wastageQuantity;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to FacilityStockAdjustmentTypeMaster
	@ManyToOne
	@JoinColumn(name="type")
	private FacilityStockAdjustmentTypeMaster facilityStockAdjustmentTypeMaster;

	//bi-directional many-to-one association to FacilityStockAdjustmentTypeReason
	@ManyToOne
	@JoinColumn(name="reason_code")
	private FacilityStockAdjustmentTypeReason facilityStockAdjustmentTypeReason;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="created_by")
	private UserMaster userMaster1;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="modified_by")
	private UserMaster userMaster2;

	public FacilityStockAdjustment() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAdjustStockQuantity() {
		return this.adjustStockQuantity;
	}

	public void setAdjustStockQuantity(Integer adjustStockQuantity) {
		this.adjustStockQuantity = adjustStockQuantity;
	}

	public String getBatchNumber() {
		return this.batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public Integer getBeneficiaryQuantity() {
		return this.beneficiaryQuantity;
	}

	public void setBeneficiaryQuantity(Integer beneficiaryQuantity) {
		this.beneficiaryQuantity = beneficiaryQuantity;
	}

	public Integer getBulkDispenseQuantity() {
		return this.bulkDispenseQuantity;
	}

	public void setBulkDispenseQuantity(Integer bulkDispenseQuantity) {
		this.bulkDispenseQuantity = bulkDispenseQuantity;
	}

	public Integer getControlQuantity() {
		return this.controlQuantity;
	}

	public void setControlQuantity(Integer controlQuantity) {
		this.controlQuantity = controlQuantity;
	}

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getCurrentQuantity() {
		return this.currentQuantity;
	}

	public void setCurrentQuantity(Integer currentQuantity) {
		this.currentQuantity = currentQuantity;
	}

	public Date getDateOfAdditionOrConsupmtion() {
		return this.dateOfAdditionOrConsupmtion;
	}

	public void setDateOfAdditionOrConsupmtion(Date dateOfAdditionOrConsupmtion) {
		this.dateOfAdditionOrConsupmtion = dateOfAdditionOrConsupmtion;
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

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Integer getOtherQuantity() {
		return this.otherQuantity;
	}

	public void setOtherQuantity(Integer otherQuantity) {
		this.otherQuantity = otherQuantity;
	}

	public Integer getQaQuantity() {
		return this.qaQuantity;
	}

	public void setQaQuantity(Integer qaQuantity) {
		this.qaQuantity = qaQuantity;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getTestingQuantity() {
		return this.testingQuantity;
	}

	public void setTestingQuantity(Integer testingQuantity) {
		this.testingQuantity = testingQuantity;
	}

	public Integer getTotalQuantity() {
		return this.totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Integer getWastageQuantity() {
		return this.wastageQuantity;
	}

	public void setWastageQuantity(Integer wastageQuantity) {
		this.wastageQuantity = wastageQuantity;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public FacilityStockAdjustmentTypeMaster getFacilityStockAdjustmentTypeMaster() {
		return this.facilityStockAdjustmentTypeMaster;
	}

	public void setFacilityStockAdjustmentTypeMaster(FacilityStockAdjustmentTypeMaster facilityStockAdjustmentTypeMaster) {
		this.facilityStockAdjustmentTypeMaster = facilityStockAdjustmentTypeMaster;
	}

	public FacilityStockAdjustmentTypeReason getFacilityStockAdjustmentTypeReason() {
		return this.facilityStockAdjustmentTypeReason;
	}

	public void setFacilityStockAdjustmentTypeReason(FacilityStockAdjustmentTypeReason facilityStockAdjustmentTypeReason) {
		this.facilityStockAdjustmentTypeReason = facilityStockAdjustmentTypeReason;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public UserMaster getUserMaster1() {
		return this.userMaster1;
	}

	public void setUserMaster1(UserMaster userMaster1) {
		this.userMaster1 = userMaster1;
	}

	public UserMaster getUserMaster2() {
		return this.userMaster2;
	}

	public void setUserMaster2(UserMaster userMaster2) {
		this.userMaster2 = userMaster2;
	}

}