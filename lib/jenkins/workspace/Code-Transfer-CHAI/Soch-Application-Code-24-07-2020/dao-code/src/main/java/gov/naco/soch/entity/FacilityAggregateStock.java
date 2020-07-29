package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the facility_aggregate_stock database table.
 * 
 */
@Entity
@GenericGenerator(name = "facility_aggregate_stock", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "facility_aggregate_stock_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "facility_aggregate_stock")
@NamedQuery(name = "FacilityAggregateStock.findAll", query = "SELECT f FROM FacilityAggregateStock f")
public class FacilityAggregateStock extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility_aggregate_stock")
	private Long id;

	@Column(name = "available_quantity")
	private Double availableQuantity;

	@Column(name = "damaged_quantity")
	private Double damagedQuantity;

	@Column(name = "batch_expiry_date")
	private LocalDate batchExpiryDate;

	@Column(name = "batch_manufacture_date")
	private LocalDate batchManufactureDate;

	@Column(name = "batch_number")
	private String batchNumber;

	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "created_time")
	private LocalDateTime createdTime;

	private Double git;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "modified_by")
	private Long modifiedBy;

	@Column(name = "modified_time")
	private LocalDateTime modifiedTime;

	// bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	// bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	public FacilityAggregateStock() {
	}

	public Double getAvailableQuantity() {
		return this.availableQuantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getBatchExpiryDate() {
		return batchExpiryDate;
	}

	public void setBatchExpiryDate(LocalDate batchExpiryDate) {
		this.batchExpiryDate = batchExpiryDate;
	}

	public LocalDate getBatchManufactureDate() {
		return batchManufactureDate;
	}

	public void setBatchManufactureDate(LocalDate batchManufactureDate) {
		this.batchManufactureDate = batchManufactureDate;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public void setAvailableQuantity(Double availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public String getBatchNumber() {
		return this.batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public Double getGit() {
		return this.git;
	}

	public void setGit(Double git) {
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

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Double getDamagedQuantity() {
		return damagedQuantity;
	}

	public void setDamagedQuantity(Double damagedQuantity) {
		this.damagedQuantity = damagedQuantity;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "FacilityAggregateStock [id=" + id + ", availableQuantity=" + availableQuantity + ", batchExpiryDate="
				+ batchExpiryDate + ", batchManufactureDate=" + batchManufactureDate + ", batchNumber=" + batchNumber
				+ ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", git=" + git + ", isActive="
				+ isActive + ", isDelete=" + isDelete + ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime
				+ ", facility=" + facility + ", product=" + product + "]";
	}

}