package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the art_beneficiary_ipt_att_details database table.
 * 
 */
@Entity
@Table(name="art_beneficiary_ipt_att_details")
@NamedQuery(name="ArtBeneficiaryIptAttDetail.findAll", query="SELECT a FROM ArtBeneficiaryIptAttDetail a")
public class ArtBeneficiaryIptAttDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="att_start_date")
	private Date attStartDate;

	@Temporal(TemporalType.DATE)
	@Column(name="cpt_start_date")
	private Date cptStartDate;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Temporal(TemporalType.DATE)
	@Column(name="entry_date")
	private Date entryDate;

	@Temporal(TemporalType.DATE)
	@Column(name="ipt_end_date")
	private Date iptEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name="ipt_restart_date")
	private Date iptRestartDate;

	@Temporal(TemporalType.DATE)
	@Column(name="ipt_start_date")
	private Date iptStartDate;

	@Temporal(TemporalType.DATE)
	@Column(name="ipt_stop_date")
	private Date iptStopDate;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="nikshay_id")
	private Integer nikshayId;

	@Column(name="rif_resistance")
	private Boolean rifResistance;

	@Temporal(TemporalType.DATE)
	@Column(name="tb_diagnosis")
	private Date tbDiagnosis;

	@Column(name="tb_history")
	private Boolean tbHistory;

	@Temporal(TemporalType.DATE)
	@Column(name="tb_treatment_completion_date")
	private Date tbTreatmentCompletionDate;

	@Column(name="treatment_under_id")
	private Integer treatmentUnderId;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to BeneficiaryVisitRegister
	@ManyToOne
	@JoinColumn(name="visit_register_id")
	private BeneficiaryVisitRegister beneficiaryVisitRegister;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to MasterDiagnosedBy
	@ManyToOne
	@JoinColumn(name="diagnosed_by_id")
	private MasterDiagnosedBy masterDiagnosedBy;

	//bi-directional many-to-one association to MasterFourSScreening
	@ManyToOne
	@JoinColumn(name="four_s_screening_id")
	private MasterFourSScreening masterFourSScreening;

	//bi-directional many-to-one association to MasterIptStatus
	@ManyToOne
	@JoinColumn(name="ipt_status_id")
	private MasterIptStatus masterIptStatus;

	//bi-directional many-to-one association to MasterTbRegimen
	@ManyToOne
	@JoinColumn(name="tb_regimen_id")
	private MasterTbRegimen masterTbRegimen;

	//bi-directional many-to-one association to MasterTbResult
	@ManyToOne
	@JoinColumn(name="tb_diagnosis_id")
	private MasterTbResult masterTbResult;

	//bi-directional many-to-one association to MasterTbTreatmentStatus
	@ManyToOne
	@JoinColumn(name="tb_treatment_status_id")
	private MasterTbTreatmentStatus masterTbTreatmentStatus;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="entry_user")
	private UserMaster userMaster;

	public ArtBeneficiaryIptAttDetail() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getAttStartDate() {
		return this.attStartDate;
	}

	public void setAttStartDate(Date attStartDate) {
		this.attStartDate = attStartDate;
	}

	public Date getCptStartDate() {
		return this.cptStartDate;
	}

	public void setCptStartDate(Date cptStartDate) {
		this.cptStartDate = cptStartDate;
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

	public Date getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getIptEndDate() {
		return this.iptEndDate;
	}

	public void setIptEndDate(Date iptEndDate) {
		this.iptEndDate = iptEndDate;
	}

	public Date getIptRestartDate() {
		return this.iptRestartDate;
	}

	public void setIptRestartDate(Date iptRestartDate) {
		this.iptRestartDate = iptRestartDate;
	}

	public Date getIptStartDate() {
		return this.iptStartDate;
	}

	public void setIptStartDate(Date iptStartDate) {
		this.iptStartDate = iptStartDate;
	}

	public Date getIptStopDate() {
		return this.iptStopDate;
	}

	public void setIptStopDate(Date iptStopDate) {
		this.iptStopDate = iptStopDate;
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

	public Integer getNikshayId() {
		return this.nikshayId;
	}

	public void setNikshayId(Integer nikshayId) {
		this.nikshayId = nikshayId;
	}

	public Boolean getRifResistance() {
		return this.rifResistance;
	}

	public void setRifResistance(Boolean rifResistance) {
		this.rifResistance = rifResistance;
	}

	public Date getTbDiagnosis() {
		return this.tbDiagnosis;
	}

	public void setTbDiagnosis(Date tbDiagnosis) {
		this.tbDiagnosis = tbDiagnosis;
	}

	public Boolean getTbHistory() {
		return this.tbHistory;
	}

	public void setTbHistory(Boolean tbHistory) {
		this.tbHistory = tbHistory;
	}

	public Date getTbTreatmentCompletionDate() {
		return this.tbTreatmentCompletionDate;
	}

	public void setTbTreatmentCompletionDate(Date tbTreatmentCompletionDate) {
		this.tbTreatmentCompletionDate = tbTreatmentCompletionDate;
	}

	public Integer getTreatmentUnderId() {
		return this.treatmentUnderId;
	}

	public void setTreatmentUnderId(Integer treatmentUnderId) {
		this.treatmentUnderId = treatmentUnderId;
	}

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public BeneficiaryVisitRegister getBeneficiaryVisitRegister() {
		return this.beneficiaryVisitRegister;
	}

	public void setBeneficiaryVisitRegister(BeneficiaryVisitRegister beneficiaryVisitRegister) {
		this.beneficiaryVisitRegister = beneficiaryVisitRegister;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public MasterDiagnosedBy getMasterDiagnosedBy() {
		return this.masterDiagnosedBy;
	}

	public void setMasterDiagnosedBy(MasterDiagnosedBy masterDiagnosedBy) {
		this.masterDiagnosedBy = masterDiagnosedBy;
	}

	public MasterFourSScreening getMasterFourSScreening() {
		return this.masterFourSScreening;
	}

	public void setMasterFourSScreening(MasterFourSScreening masterFourSScreening) {
		this.masterFourSScreening = masterFourSScreening;
	}

	public MasterIptStatus getMasterIptStatus() {
		return this.masterIptStatus;
	}

	public void setMasterIptStatus(MasterIptStatus masterIptStatus) {
		this.masterIptStatus = masterIptStatus;
	}

	public MasterTbRegimen getMasterTbRegimen() {
		return this.masterTbRegimen;
	}

	public void setMasterTbRegimen(MasterTbRegimen masterTbRegimen) {
		this.masterTbRegimen = masterTbRegimen;
	}

	public MasterTbResult getMasterTbResult() {
		return this.masterTbResult;
	}

	public void setMasterTbResult(MasterTbResult masterTbResult) {
		this.masterTbResult = masterTbResult;
	}

	public MasterTbTreatmentStatus getMasterTbTreatmentStatus() {
		return this.masterTbTreatmentStatus;
	}

	public void setMasterTbTreatmentStatus(MasterTbTreatmentStatus masterTbTreatmentStatus) {
		this.masterTbTreatmentStatus = masterTbTreatmentStatus;
	}

	public UserMaster getUserMaster() {
		return this.userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

}