package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the ictc_sample_batch database table.
 * 
 */
@Entity
@Table(name="ictc_sample_batch")
@NamedQuery(name="IctcSampleBatch.findAll", query="SELECT i FROM IctcSampleBatch i")
public class IctcSampleBatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="batch_status")
	private Integer batchStatus;

	@Column(name="consignment_id")
	private String consignmentId;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Temporal(TemporalType.DATE)
	@Column(name="dispatch_date")
	private Date dispatchDate;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_deleted")
	private Boolean isDeleted;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="facility_id")
	private Facility facility1;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="lab_id")
	private Facility facility2;

	//bi-directional many-to-one association to IctcSampleCollection
	@OneToMany(mappedBy="ictcSampleBatch")
	private Set<IctcSampleCollection> ictcSampleCollections;

	public IctcSampleBatch() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBatchStatus() {
		return this.batchStatus;
	}

	public void setBatchStatus(Integer batchStatus) {
		this.batchStatus = batchStatus;
	}

	public String getConsignmentId() {
		return this.consignmentId;
	}

	public void setConsignmentId(String consignmentId) {
		this.consignmentId = consignmentId;
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

	public Date getDispatchDate() {
		return this.dispatchDate;
	}

	public void setDispatchDate(Date dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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

	public Facility getFacility1() {
		return this.facility1;
	}

	public void setFacility1(Facility facility1) {
		this.facility1 = facility1;
	}

	public Facility getFacility2() {
		return this.facility2;
	}

	public void setFacility2(Facility facility2) {
		this.facility2 = facility2;
	}

	public Set<IctcSampleCollection> getIctcSampleCollections() {
		return this.ictcSampleCollections;
	}

	public void setIctcSampleCollections(Set<IctcSampleCollection> ictcSampleCollections) {
		this.ictcSampleCollections = ictcSampleCollections;
	}

	public IctcSampleCollection addIctcSampleCollection(IctcSampleCollection ictcSampleCollection) {
		getIctcSampleCollections().add(ictcSampleCollection);
		ictcSampleCollection.setIctcSampleBatch(this);

		return ictcSampleCollection;
	}

	public IctcSampleCollection removeIctcSampleCollection(IctcSampleCollection ictcSampleCollection) {
		getIctcSampleCollections().remove(ictcSampleCollection);
		ictcSampleCollection.setIctcSampleBatch(null);

		return ictcSampleCollection;
	}

}