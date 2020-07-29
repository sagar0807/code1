package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the ictc_follow_up database table.
 * 
 */
@Entity
@Table(name="ictc_follow_up")
@NamedQuery(name="IctcFollowUp.findAll", query="SELECT i FROM IctcFollowUp i")
public class IctcFollowUp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Temporal(TemporalType.DATE)
	@Column(name="follow_up_date")
	private Date followUpDate;

	@Column(name="follow_up_type")
	private Integer followUpType;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_completed")
	private Boolean isCompleted;

	@Column(name="is_deleted")
	private Boolean isDeleted;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

//	private String remarks;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to IctcBeneficiary
	@ManyToOne
	@JoinColumn(name="ictc_beneficiary_id")
	private IctcBeneficiary ictcBeneficiary;

	//bi-directional many-to-one association to IctcTestResult
	@ManyToOne
	@JoinColumn(name="test_result_id")
	private IctcTestResult ictcTestResult;

	//bi-directional many-to-one association to IctcVisit
	@ManyToOne
	@JoinColumn(name="visit_id")
	private IctcVisit ictcVisit;

	public IctcFollowUp() {
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

	public Date getFollowUpDate() {
		return this.followUpDate;
	}

	public void setFollowUpDate(Date followUpDate) {
		this.followUpDate = followUpDate;
	}

	public Integer getFollowUpType() {
		return this.followUpType;
	}

	public void setFollowUpType(Integer followUpType) {
		this.followUpType = followUpType;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsCompleted() {
		return this.isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
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

//	public String getRemarks() {
//		return this.remarks;
//	}
//
//	public void setRemarks(String remarks) {
//		this.remarks = remarks;
//	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public IctcBeneficiary getIctcBeneficiary() {
		return this.ictcBeneficiary;
	}

	public void setIctcBeneficiary(IctcBeneficiary ictcBeneficiary) {
		this.ictcBeneficiary = ictcBeneficiary;
	}

	public IctcTestResult getIctcTestResult() {
		return this.ictcTestResult;
	}

	public void setIctcTestResult(IctcTestResult ictcTestResult) {
		this.ictcTestResult = ictcTestResult;
	}

	public IctcVisit getIctcVisit() {
		return this.ictcVisit;
	}

	public void setIctcVisit(IctcVisit ictcVisit) {
		this.ictcVisit = ictcVisit;
	}

}