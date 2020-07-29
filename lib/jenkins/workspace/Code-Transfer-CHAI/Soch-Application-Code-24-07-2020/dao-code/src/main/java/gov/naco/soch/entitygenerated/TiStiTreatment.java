package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the ti_sti_treatment database table.
 * 
 */
@Entity
@Table(name="ti_sti_treatment")
@NamedQuery(name="TiStiTreatment.findAll", query="SELECT t FROM TiStiTreatment t")
public class TiStiTreatment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="clinical_details")
	private String clinicalDetails;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Temporal(TemporalType.DATE)
	@Column(name="follow_up_date")
	private Date followUpDate;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="kit_prescribed")
	private String kitPrescribed;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Temporal(TemporalType.DATE)
	@Column(name="next_follow_up_date")
	private Date nextFollowUpDate;

	@Column(name="partner_notified")
	private Boolean partnerNotified;

	@Column(name="sti_rti_diagnosis")
	private String stiRtiDiagnosis;

	@Column(name="treatment_provided")
	private String treatmentProvided;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to TiBeneficiary
	@ManyToOne
	@JoinColumn(name="beneficiary_id")
	private TiBeneficiary tiBeneficiary;

	public TiStiTreatment() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClinicalDetails() {
		return this.clinicalDetails;
	}

	public void setClinicalDetails(String clinicalDetails) {
		this.clinicalDetails = clinicalDetails;
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

	public String getKitPrescribed() {
		return this.kitPrescribed;
	}

	public void setKitPrescribed(String kitPrescribed) {
		this.kitPrescribed = kitPrescribed;
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

	public Date getNextFollowUpDate() {
		return this.nextFollowUpDate;
	}

	public void setNextFollowUpDate(Date nextFollowUpDate) {
		this.nextFollowUpDate = nextFollowUpDate;
	}

	public Boolean getPartnerNotified() {
		return this.partnerNotified;
	}

	public void setPartnerNotified(Boolean partnerNotified) {
		this.partnerNotified = partnerNotified;
	}

	public String getStiRtiDiagnosis() {
		return this.stiRtiDiagnosis;
	}

	public void setStiRtiDiagnosis(String stiRtiDiagnosis) {
		this.stiRtiDiagnosis = stiRtiDiagnosis;
	}

	public String getTreatmentProvided() {
		return this.treatmentProvided;
	}

	public void setTreatmentProvided(String treatmentProvided) {
		this.treatmentProvided = treatmentProvided;
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

	public TiBeneficiary getTiBeneficiary() {
		return this.tiBeneficiary;
	}

	public void setTiBeneficiary(TiBeneficiary tiBeneficiary) {
		this.tiBeneficiary = tiBeneficiary;
	}

}