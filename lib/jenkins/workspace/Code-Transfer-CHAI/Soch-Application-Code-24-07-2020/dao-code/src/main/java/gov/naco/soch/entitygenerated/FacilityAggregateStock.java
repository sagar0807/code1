package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the facility_aggregate_stock database table.
 * 
 */
@Entity
@Table(name="facility_aggregate_stock")
@NamedQuery(name="FacilityAggregateStock.findAll", query="SELECT f FROM FacilityAggregateStock f")
public class FacilityAggregateStock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="available_quantity")
	private Integer availableQuantity;

	@Temporal(TemporalType.DATE)
	@Column(name="bacth_completion_date")
	private Date bacthCompletionDate;

	@Temporal(TemporalType.DATE)
	@Column(name="batch_expiry_date")
	private Date batchExpiryDate;

	@Temporal(TemporalType.DATE)
	@Column(name="batch_inception_date")
	private Date batchInceptionDate;

	@Temporal(TemporalType.DATE)
	@Column(name="batch_manufacture_date")
	private Date batchManufactureDate;

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

	public FacilityAggregateStock() {
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

	public Date getBacthCompletionDate() {
		return this.bacthCompletionDate;
	}

	public void setBacthCompletionDate(Date bacthCompletionDate) {
		this.bacthCompletionDate = bacthCompletionDate;
	}

	public Date getBatchExpiryDate() {
		return this.batchExpiryDate;
	}

	public void setBatchExpiryDate(Date batchExpiryDate) {
		this.batchExpiryDate = batchExpiryDate;
	}

	public Date getBatchInceptionDate() {
		return this.batchInceptionDate;
	}

	public void setBatchInceptionDate(Date batchInceptionDate) {
		this.batchInceptionDate = batchInceptionDate;
	}

	public Date getBatchManufactureDate() {
		return this.batchManufactureDate;
	}

	public void setBatchManufactureDate(Date batchManufactureDate) {
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