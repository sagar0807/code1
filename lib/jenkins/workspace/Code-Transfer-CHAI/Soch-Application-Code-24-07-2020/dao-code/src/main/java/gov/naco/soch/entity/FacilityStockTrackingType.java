package gov.naco.soch.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the facility_stock_tracking_type database table.
 * 
 */
@Entity
@GenericGenerator(name = "facility_stock_tracking_type", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "facility_stock_tracking_type_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "facility_stock_tracking_type")
@NamedQuery(name = "FacilityStockTrackingType.findAll", query = "SELECT f FROM FacilityStockTrackingType f")
public class FacilityStockTrackingType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility_stock_tracking_type")
	private Long id;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "created_time")
	private Timestamp createdTime;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "modified_by")
	private Integer modifiedBy;

	@Column(name = "modified_time")
	private Timestamp modifiedTime;

	private String type;

	// bi-directional many-to-one association to FacilityStockTracking
	@OneToMany(mappedBy = "facilityStockTrackingType")
	private Set<FacilityStockTracking> facilityStockTrackings;

	public FacilityStockTrackingType() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<FacilityStockTracking> getFacilityStockTrackings() {
		return this.facilityStockTrackings;
	}

	public void setFacilityStockTrackings(Set<FacilityStockTracking> facilityStockTrackings) {
		this.facilityStockTrackings = facilityStockTrackings;
	}

	public FacilityStockTracking addFacilityStockTracking(FacilityStockTracking facilityStockTracking) {
		getFacilityStockTrackings().add(facilityStockTracking);
		facilityStockTracking.setFacilityStockTrackingType(this);

		return facilityStockTracking;
	}

	public FacilityStockTracking removeFacilityStockTracking(FacilityStockTracking facilityStockTracking) {
		getFacilityStockTrackings().remove(facilityStockTracking);
		facilityStockTracking.setFacilityStockTrackingType(null);

		return facilityStockTracking;
	}

}