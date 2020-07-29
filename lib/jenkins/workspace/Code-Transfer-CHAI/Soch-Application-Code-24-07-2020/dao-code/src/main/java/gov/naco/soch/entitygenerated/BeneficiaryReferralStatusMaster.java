package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the beneficiary_referral_status_master database table.
 * 
 */
@Entity
@Table(name="beneficiary_referral_status_master")
@NamedQuery(name="BeneficiaryReferralStatusMaster.findAll", query="SELECT b FROM BeneficiaryReferralStatusMaster b")
public class BeneficiaryReferralStatusMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="referral_status_id")
	private Integer referralStatusId;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private String status;

	//bi-directional many-to-one association to BeneficiaryReferral
	@OneToMany(mappedBy="beneficiaryReferralStatusMaster")
	private Set<BeneficiaryReferral> beneficiaryReferrals;

	public BeneficiaryReferralStatusMaster() {
	}

	public Integer getReferralStatusId() {
		return this.referralStatusId;
	}

	public void setReferralStatusId(Integer referralStatusId) {
		this.referralStatusId = referralStatusId;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<BeneficiaryReferral> getBeneficiaryReferrals() {
		return this.beneficiaryReferrals;
	}

	public void setBeneficiaryReferrals(Set<BeneficiaryReferral> beneficiaryReferrals) {
		this.beneficiaryReferrals = beneficiaryReferrals;
	}

	public BeneficiaryReferral addBeneficiaryReferral(BeneficiaryReferral beneficiaryReferral) {
		getBeneficiaryReferrals().add(beneficiaryReferral);
		beneficiaryReferral.setBeneficiaryReferralStatusMaster(this);

		return beneficiaryReferral;
	}

	public BeneficiaryReferral removeBeneficiaryReferral(BeneficiaryReferral beneficiaryReferral) {
		getBeneficiaryReferrals().remove(beneficiaryReferral);
		beneficiaryReferral.setBeneficiaryReferralStatusMaster(null);

		return beneficiaryReferral;
	}

}