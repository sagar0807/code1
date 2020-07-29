package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the ictc_partner_details database table.
 * 
 */
@Entity
@Table(name="ictc_partner_details")
@NamedQuery(name="IctcPartnerDetail.findAll", query="SELECT i FROM IctcPartnerDetail i")
public class IctcPartnerDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="created_by")
	private Integer createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="created_date")
	private Date createdDate;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="is_partner_prev_treated_for_hiv")
	private Boolean isPartnerPrevTreatedForHiv;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="partner_hiv_status")
	private Integer partnerHivStatus;

	@Column(name="partner_not_tested_reason")
	private Integer partnerNotTestedReason;

	@Column(name="partner_status_known")
	private Integer partnerStatusKnown;

	@Temporal(TemporalType.DATE)
	@Column(name="partner_test_follow_up_date")
	private Date partnerTestFollowUpDate;

	//bi-directional many-to-one association to IctcBeneficiary
	@ManyToOne
	@JoinColumn(name="ictc_beneficiary_id")
	private IctcBeneficiary ictcBeneficiary;

	public IctcPartnerDetail() {
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

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	public Boolean getIsPartnerPrevTreatedForHiv() {
		return this.isPartnerPrevTreatedForHiv;
	}

	public void setIsPartnerPrevTreatedForHiv(Boolean isPartnerPrevTreatedForHiv) {
		this.isPartnerPrevTreatedForHiv = isPartnerPrevTreatedForHiv;
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

	public Integer getPartnerHivStatus() {
		return this.partnerHivStatus;
	}

	public void setPartnerHivStatus(Integer partnerHivStatus) {
		this.partnerHivStatus = partnerHivStatus;
	}

	public Integer getPartnerNotTestedReason() {
		return this.partnerNotTestedReason;
	}

	public void setPartnerNotTestedReason(Integer partnerNotTestedReason) {
		this.partnerNotTestedReason = partnerNotTestedReason;
	}

	public Integer getPartnerStatusKnown() {
		return this.partnerStatusKnown;
	}

	public void setPartnerStatusKnown(Integer partnerStatusKnown) {
		this.partnerStatusKnown = partnerStatusKnown;
	}

	public Date getPartnerTestFollowUpDate() {
		return this.partnerTestFollowUpDate;
	}

	public void setPartnerTestFollowUpDate(Date partnerTestFollowUpDate) {
		this.partnerTestFollowUpDate = partnerTestFollowUpDate;
	}

	public IctcBeneficiary getIctcBeneficiary() {
		return this.ictcBeneficiary;
	}

	public void setIctcBeneficiary(IctcBeneficiary ictcBeneficiary) {
		this.ictcBeneficiary = ictcBeneficiary;
	}

}