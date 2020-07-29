package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the ictc_test_result database table.
 * 
 */
@Entity
@Table(name="ictc_test_result")
@NamedQuery(name="IctcTestResult.findAll", query="SELECT i FROM IctcTestResult i")
public class IctcTestResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="created_time")
	private Date createdTime;

//	@Column(name="followup_required")
//	private Boolean followupRequired;

	@Column(name="hiv_status")
	private Integer hivStatus;

	@Column(name="hiv_type")
	private Integer hivType;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_deleted")
	private Boolean isDeleted;

//	@Column(name="is_refered_to_art")
//	private Boolean isReferedToArt;

	@Column(name="is_tested_for_syphilis")
	private Boolean isTestedForSyphilis;

	@Column(name="is_tested_for_tb")
	private Boolean isTestedForTb;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="modified_time")
	private Date modifiedTime;

	@Temporal(TemporalType.DATE)
	@Column(name="report_delivery_date")
	private Date reportDeliveryDate;

	@Temporal(TemporalType.DATE)
	@Column(name="report_received_date")
	private Date reportReceivedDate;

	@Column(name="result_status")
	private Integer resultStatus;

	@Column(name="syphilis_test_result")
	private Integer syphilisTestResult;

	@Column(name="tb_test_result")
	private Integer tbTestResult;

//	@Column(name="test_sequence")
//	private Integer testSequence;

	@Temporal(TemporalType.DATE)
	@Column(name="tested_date")
	private Date testedDate;

	//bi-directional many-to-one association to IctcFollowUp
	@OneToMany(mappedBy="ictcTestResult")
	private Set<IctcFollowUp> ictcFollowUps;

	//bi-directional many-to-one association to IctcBeneficiary
	@ManyToOne
	@JoinColumn(name="ictc_beneficiary_id")
	private IctcBeneficiary ictcBeneficiary;

	//bi-directional many-to-one association to IctcSampleCollection
	@ManyToOne
	@JoinColumn(name="sample_id")
	private IctcSampleCollection ictcSampleCollection;

	//bi-directional many-to-one association to IctcVisit
	@ManyToOne
	@JoinColumn(name="visit_id")
	private IctcVisit ictcVisit;

	public IctcTestResult() {
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

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

//	public Boolean getFollowupRequired() {
//		return this.followupRequired;
//	}
//
//	public void setFollowupRequired(Boolean followupRequired) {
//		this.followupRequired = followupRequired;
//	}

	public Integer getHivStatus() {
		return this.hivStatus;
	}

	public void setHivStatus(Integer hivStatus) {
		this.hivStatus = hivStatus;
	}

	public Integer getHivType() {
		return this.hivType;
	}

	public void setHivType(Integer hivType) {
		this.hivType = hivType;
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

//	public Boolean getIsReferedToArt() {
//		return this.isReferedToArt;
//	}
//
//	public void setIsReferedToArt(Boolean isReferedToArt) {
//		this.isReferedToArt = isReferedToArt;
//	}

	public Boolean getIsTestedForSyphilis() {
		return this.isTestedForSyphilis;
	}

	public void setIsTestedForSyphilis(Boolean isTestedForSyphilis) {
		this.isTestedForSyphilis = isTestedForSyphilis;
	}

	public Boolean getIsTestedForTb() {
		return this.isTestedForTb;
	}

	public void setIsTestedForTb(Boolean isTestedForTb) {
		this.isTestedForTb = isTestedForTb;
	}

	public Integer getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Date getReportDeliveryDate() {
		return this.reportDeliveryDate;
	}

	public void setReportDeliveryDate(Date reportDeliveryDate) {
		this.reportDeliveryDate = reportDeliveryDate;
	}

	public Date getReportReceivedDate() {
		return this.reportReceivedDate;
	}

	public void setReportReceivedDate(Date reportReceivedDate) {
		this.reportReceivedDate = reportReceivedDate;
	}

	public Integer getResultStatus() {
		return this.resultStatus;
	}

	public void setResultStatus(Integer resultStatus) {
		this.resultStatus = resultStatus;
	}

	public Integer getSyphilisTestResult() {
		return this.syphilisTestResult;
	}

	public void setSyphilisTestResult(Integer syphilisTestResult) {
		this.syphilisTestResult = syphilisTestResult;
	}

	public Integer getTbTestResult() {
		return this.tbTestResult;
	}

	public void setTbTestResult(Integer tbTestResult) {
		this.tbTestResult = tbTestResult;
	}

//	public Integer getTestSequence() {
//		return this.testSequence;
//	}
//
//	public void setTestSequence(Integer testSequence) {
//		this.testSequence = testSequence;
//	}

	public Date getTestedDate() {
		return this.testedDate;
	}

	public void setTestedDate(Date testedDate) {
		this.testedDate = testedDate;
	}

	public Set<IctcFollowUp> getIctcFollowUps() {
		return this.ictcFollowUps;
	}

	public void setIctcFollowUps(Set<IctcFollowUp> ictcFollowUps) {
		this.ictcFollowUps = ictcFollowUps;
	}

	public IctcFollowUp addIctcFollowUp(IctcFollowUp ictcFollowUp) {
		getIctcFollowUps().add(ictcFollowUp);
		ictcFollowUp.setIctcTestResult(this);

		return ictcFollowUp;
	}

	public IctcFollowUp removeIctcFollowUp(IctcFollowUp ictcFollowUp) {
		getIctcFollowUps().remove(ictcFollowUp);
		ictcFollowUp.setIctcTestResult(null);

		return ictcFollowUp;
	}

	public IctcBeneficiary getIctcBeneficiary() {
		return this.ictcBeneficiary;
	}

	public void setIctcBeneficiary(IctcBeneficiary ictcBeneficiary) {
		this.ictcBeneficiary = ictcBeneficiary;
	}

	public IctcSampleCollection getIctcSampleCollection() {
		return this.ictcSampleCollection;
	}

	public void setIctcSampleCollection(IctcSampleCollection ictcSampleCollection) {
		this.ictcSampleCollection = ictcSampleCollection;
	}

	public IctcVisit getIctcVisit() {
		return this.ictcVisit;
	}

	public void setIctcVisit(IctcVisit ictcVisit) {
		this.ictcVisit = ictcVisit;
	}

}