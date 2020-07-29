package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the beneficiary_referral database table.
 * 
 */
@Entity
@Table(name="beneficiary_referral")
@NamedQuery(name="BeneficiaryReferral.findAll", query="SELECT b FROM BeneficiaryReferral b")
public class BeneficiaryReferral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="accepted_date")
	private Date acceptedDate;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_hiv_test")
	private Date dateOfHivTest;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_visit")
	private Date dateOfVisit;

	@Temporal(TemporalType.DATE)
	@Column(name="declined_date")
	private Date declinedDate;

	@Column(name="hiv_status")
	private String hivStatus;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Temporal(TemporalType.DATE)
	@Column(name="refer_date")
	private Date referDate;

	@Column(name="referral_reason")
	private String referralReason;

	@Column(name="referral_type")
	private String referralType;

	@Column(name="referral_type_id")
	private Integer referralTypeId;

	@Column(name="type_of_hiv")
	private String typeOfHiv;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to BeneficiaryReferralStatusMaster
	@ManyToOne
	@JoinColumn(name="referral_status_id")
	private BeneficiaryReferralStatusMaster beneficiaryReferralStatusMaster;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="refered_from")
	private Facility facility1;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="refered_to")
	private Facility facility2;

	//bi-directional many-to-one association to MasterReferralStatus
	@ManyToOne
	@JoinColumn(name="referral_status_id")
	private MasterReferralStatus masterReferralStatus;

	//bi-directional many-to-one association to TiBenScrDetail
	@ManyToOne
	@JoinColumn(name="ti_ben_scr_id")
	private TiBenScrDetail tiBenScrDetail;

	//bi-directional many-to-one association to TiBeneficiary
	@ManyToOne
	@JoinColumn(name="ti_beneficiary_id")
	private TiBeneficiary tiBeneficiary;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="referred_by")
	private UserMaster userMaster;

	public BeneficiaryReferral() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getAcceptedDate() {
		return this.acceptedDate;
	}

	public void setAcceptedDate(Date acceptedDate) {
		this.acceptedDate = acceptedDate;
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

	public Date getDateOfHivTest() {
		return this.dateOfHivTest;
	}

	public void setDateOfHivTest(Date dateOfHivTest) {
		this.dateOfHivTest = dateOfHivTest;
	}

	public Date getDateOfVisit() {
		return this.dateOfVisit;
	}

	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public Date getDeclinedDate() {
		return this.declinedDate;
	}

	public void setDeclinedDate(Date declinedDate) {
		this.declinedDate = declinedDate;
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

	public Date getReferDate() {
		return this.referDate;
	}

	public void setReferDate(Date referDate) {
		this.referDate = referDate;
	}

	public String getReferralReason() {
		return this.referralReason;
	}

	public void setReferralReason(String referralReason) {
		this.referralReason = referralReason;
	}

	public String getReferralType() {
		return this.referralType;
	}

	public void setReferralType(String referralType) {
		this.referralType = referralType;
	}

	public Integer getReferralTypeId() {
		return this.referralTypeId;
	}

	public void setReferralTypeId(Integer referralTypeId) {
		this.referralTypeId = referralTypeId;
	}

	public String getTypeOfHiv() {
		return this.typeOfHiv;
	}

	public void setTypeOfHiv(String typeOfHiv) {
		this.typeOfHiv = typeOfHiv;
	}

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public BeneficiaryReferralStatusMaster getBeneficiaryReferralStatusMaster() {
		return this.beneficiaryReferralStatusMaster;
	}

	public void setBeneficiaryReferralStatusMaster(BeneficiaryReferralStatusMaster beneficiaryReferralStatusMaster) {
		this.beneficiaryReferralStatusMaster = beneficiaryReferralStatusMaster;
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

	public MasterReferralStatus getMasterReferralStatus() {
		return this.masterReferralStatus;
	}

	public void setMasterReferralStatus(MasterReferralStatus masterReferralStatus) {
		this.masterReferralStatus = masterReferralStatus;
	}

	public TiBenScrDetail getTiBenScrDetail() {
		return this.tiBenScrDetail;
	}

	public void setTiBenScrDetail(TiBenScrDetail tiBenScrDetail) {
		this.tiBenScrDetail = tiBenScrDetail;
	}

	public TiBeneficiary getTiBeneficiary() {
		return this.tiBeneficiary;
	}

	public void setTiBeneficiary(TiBeneficiary tiBeneficiary) {
		this.tiBeneficiary = tiBeneficiary;
	}

	public UserMaster getUserMaster() {
		return this.userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

}