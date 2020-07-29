package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the facility_stock_daily_balance database table.
 * 
 */
@Entity
@Table(name="facility_stock_daily_balance")
@NamedQuery(name="FacilityStockDailyBalance.findAll", query="SELECT f FROM FacilityStockDailyBalance f")
public class FacilityStockDailyBalance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="available_quantity")
	private Integer availableQuantity;

	@Column(name="balance_date")
	private Timestamp balanceDate;

	@Column(name="batch_expiry_date")
	private Timestamp batchExpiryDate;

	@Column(name="batch_manufacture_date")
	private Timestamp batchManufactureDate;

	@Column(name="batch_number")
	private String batchNumber;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	private Integer git;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	public FacilityStockDailyBalance() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAvailableQuantity() {
		return this.availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public Timestamp getBalanceDate() {
		return this.balanceDate;
	}

	public void setBalanceDate(Timestamp balanceDate) {
		this.balanceDate = balanceDate;
	}

	public Timestamp getBatchExpiryDate() {
		return this.batchExpiryDate;
	}

	public void setBatchExpiryDate(Timestamp batchExpiryDate) {
		this.batchExpiryDate = batchExpiryDate;
	}

	public Timestamp getBatchManufactureDate() {
		return this.batchManufactureDate;
	}

	public void setBatchManufactureDate(Timestamp batchManufactureDate) {
		this.batchManufactureDate = batchManufactureDate;
	}

	public String getBatchNumber() {
		return this.batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
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

	public Integer getGit() {
		return this.git;
	}

	public void setGit(Integer git) {
		this.git = git;
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

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}