package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the ti_ben_referral database table.
 * 
 */
@Entity
@Table(name="ti_ben_referral")
@NamedQuery(name="TiBenReferral.findAll", query="SELECT t FROM TiBenReferral t")
public class TiBenReferral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_referral")
	private Date dateOfReferral;

	@Column(name="hiv_status")
	private String hivStatus;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_completed")
	private Integer isCompleted;

	@Column(name="is_deleted")
	private Boolean isDeleted;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="referral_facility")
	private Integer referralFacility;

	@Column(name="referral_status")
	private String referralStatus;

	@Column(name="referred_facility")
	private Integer referredFacility;

	@Column(name="refferal_requestor_id")
	private Integer refferalRequestorId;

	@Column(name="time_of_appointment")
	private Timestamp timeOfAppointment;

	@Temporal(TemporalType.DATE)
	@Column(name="transfer_date")
	private Date transferDate;

	@Column(name="transfer_from")
	private String transferFrom;

	@Column(name="transfer_status")
	private String transferStatus;

	@Column(name="transfer_to")
	private String transferTo;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	public TiBenReferral() {
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

	public Date getDateOfReferral() {
		return this.dateOfReferral;
	}

	public void setDateOfReferral(Date dateOfReferral) {
		this.dateOfReferral = dateOfReferral;
	}

	public String getHivStatus() {
		return this.hivStatus;
	}

	public void setHivStatus(String hivStatus) {
		this.hivStatus = hivStatus;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getIsCompleted() {
		return this.isCompleted;
	}

	public void setIsCompleted(Integer isCompleted) {
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

	public Integer getReferralFacility() {
		return this.referralFacility;
	}

	public void setReferralFacility(Integer referralFacility) {
		this.referralFacility = referralFacility;
	}

	public String getReferralStatus() {
		return this.referralStatus;
	}

	public void setReferralStatus(String referralStatus) {
		this.referralStatus = referralStatus;
	}

	public Integer getReferredFacility() {
		return this.referredFacility;
	}

	public void setReferredFacility(Integer referredFacility) {
		this.referredFacility = referredFacility;
	}

	public Integer getRefferalRequestorId() {
		return this.refferalRequestorId;
	}

	public void setRefferalRequestorId(Integer refferalRequestorId) {
		this.refferalRequestorId = refferalRequestorId;
	}

	public Timestamp getTimeOfAppointment() {
		return this.timeOfAppointment;
	}

	public void setTimeOfAppointment(Timestamp timeOfAppointment) {
		this.timeOfAppointment = timeOfAppointment;
	}

	public Date getTransferDate() {
		return this.transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public String getTransferFrom() {
		return this.transferFrom;
	}

	public void setTransferFrom(String transferFrom) {
		this.transferFrom = transferFrom;
	}

	public String getTransferStatus() {
		return this.transferStatus;
	}

	public void setTransferStatus(String transferStatus) {
		this.transferStatus = transferStatus;
	}

	public String getTransferTo() {
		return this.transferTo;
	}

	public void setTransferTo(String transferTo) {
		this.transferTo = transferTo;
	}

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

}