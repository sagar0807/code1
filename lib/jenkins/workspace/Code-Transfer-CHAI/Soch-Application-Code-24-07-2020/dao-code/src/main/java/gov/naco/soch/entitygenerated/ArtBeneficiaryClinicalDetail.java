package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the art_beneficiary_clinical_details database table.
 * 
 */
@Entity
@Table(name="art_beneficiary_clinical_details")
@NamedQuery(name="ArtBeneficiaryClinicalDetail.findAll", query="SELECT a FROM ArtBeneficiaryClinicalDetail a")
public class ArtBeneficiaryClinicalDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="current_medication")
	private String currentMedication;

	@Column(name="drug_allergy")
	private String drugAllergy;

	@Temporal(TemporalType.DATE)
	@Column(name="entry_date")
	private Date entryDate;

	@Column(name="gynaecological_exam")
	private String gynaecologicalExam;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="obstetric_abortus_value")
	private Integer obstetricAbortusValue;

	@Column(name="obstetric_gravida_value")
	private Integer obstetricGravidaValue;

	@Column(name="obstetric_parity_value")
	private Integer obstetricParityValue;

	@Column(name="pap_smear")
	private String papSmear;

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

	//bi-directional many-to-one association to MasterHabitsAlcoholUse
	@ManyToOne
	@JoinColumn(name="habits_alcohol_use")
	private MasterHabitsAlcoholUse masterHabitsAlcoholUse;

	//bi-directional many-to-one association to MasterHabitsSmoking
	@ManyToOne
	@JoinColumn(name="habits_smoking")
	private MasterHabitsSmoking masterHabitsSmoking;

	//bi-directional many-to-one association to MasterHbvStatus
	@ManyToOne
	@JoinColumn(name="hbv_status_id")
	private MasterHbvStatus masterHbvStatus;

	//bi-directional many-to-one association to MasterHcvStatus
	@ManyToOne
	@JoinColumn(name="hcv_status_id")
	private MasterHcvStatus masterHcvStatus;

	//bi-directional many-to-one association to MasterTobaccoUse
	@ManyToOne
	@JoinColumn(name="tobacco_use")
	private MasterTobaccoUse masterTobaccoUse;

	//bi-directional many-to-one association to Regimen
	@ManyToOne
	private Regimen regimen;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="entry_user")
	private UserMaster userMaster;

	public ArtBeneficiaryClinicalDetail() {
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

	public String getCurrentMedication() {
		return this.currentMedication;
	}

	public void setCurrentMedication(String currentMedication) {
		this.currentMedication = currentMedication;
	}

	public String getDrugAllergy() {
		return this.drugAllergy;
	}

	public void setDrugAllergy(String drugAllergy) {
		this.drugAllergy = drugAllergy;
	}

	public Date getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getGynaecologicalExam() {
		return this.gynaecologicalExam;
	}

	public void setGynaecologicalExam(String gynaecologicalExam) {
		this.gynaecologicalExam = gynaecologicalExam;
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

	public Integer getObstetricAbortusValue() {
		return this.obstetricAbortusValue;
	}

	public void setObstetricAbortusValue(Integer obstetricAbortusValue) {
		this.obstetricAbortusValue = obstetricAbortusValue;
	}

	public Integer getObstetricGravidaValue() {
		return this.obstetricGravidaValue;
	}

	public void setObstetricGravidaValue(Integer obstetricGravidaValue) {
		this.obstetricGravidaValue = obstetricGravidaValue;
	}

	public Integer getObstetricParityValue() {
		return this.obstetricParityValue;
	}

	public void setObstetricParityValue(Integer obstetricParityValue) {
		this.obstetricParityValue = obstetricParityValue;
	}

	public String getPapSmear() {
		return this.papSmear;
	}

	public void setPapSmear(String papSmear) {
		this.papSmear = papSmear;
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

	public MasterHabitsAlcoholUse getMasterHabitsAlcoholUse() {
		return this.masterHabitsAlcoholUse;
	}

	public void setMasterHabitsAlcoholUse(MasterHabitsAlcoholUse masterHabitsAlcoholUse) {
		this.masterHabitsAlcoholUse = masterHabitsAlcoholUse;
	}

	public MasterHabitsSmoking getMasterHabitsSmoking() {
		return this.masterHabitsSmoking;
	}

	public void setMasterHabitsSmoking(MasterHabitsSmoking masterHabitsSmoking) {
		this.masterHabitsSmoking = masterHabitsSmoking;
	}

	public MasterHbvStatus getMasterHbvStatus() {
		return this.masterHbvStatus;
	}

	public void setMasterHbvStatus(MasterHbvStatus masterHbvStatus) {
		this.masterHbvStatus = masterHbvStatus;
	}

	public MasterHcvStatus getMasterHcvStatus() {
		return this.masterHcvStatus;
	}

	public void setMasterHcvStatus(MasterHcvStatus masterHcvStatus) {
		this.masterHcvStatus = masterHcvStatus;
	}

	public MasterTobaccoUse getMasterTobaccoUse() {
		return this.masterTobaccoUse;
	}

	public void setMasterTobaccoUse(MasterTobaccoUse masterTobaccoUse) {
		this.masterTobaccoUse = masterTobaccoUse;
	}

	public Regimen getRegimen() {
		return this.regimen;
	}

	public void setRegimen(Regimen regimen) {
		this.regimen = regimen;
	}

	public UserMaster getUserMaster() {
		return this.userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

}