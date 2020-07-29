package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the art_beneficiary_followup database table.
 * 
 */
@Entity
@Table(name="art_beneficiary_followup")
@NamedQuery(name="ArtBeneficiaryFollowup.findAll", query="SELECT a FROM ArtBeneficiaryFollowup a")
public class ArtBeneficiaryFollowup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="adherence_to_art")
	private Integer adherenceToArt;

	@Column(name="any_other_medicine")
	private String anyOtherMedicine;

	@Column(name="condoms_given")
	private Boolean condomsGiven;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="drugs_prescribed_for_opportunistic_infections_prophylaxis")
	private Boolean drugsPrescribedForOpportunisticInfectionsProphylaxis;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="opportunistic_infections_remarks")
	private String opportunisticInfectionsRemarks;

	@Column(name="paediatric_milestone_achieved_as_per_age")
	private String paediatricMilestoneAchievedAsPerAge;

	@Column(name="remaining_pills")
	private Integer remainingPills;

	private String remarks;

	@Column(name="tb_treatment")
	private Boolean tbTreatment;

	@Temporal(TemporalType.DATE)
	@Column(name="visit_date")
	private Date visitDate;

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

	//bi-directional many-to-one association to MasterClinicalStage
	@ManyToOne
	@JoinColumn(name="clinical_stage_id")
	private MasterClinicalStage masterClinicalStage;

	//bi-directional many-to-one association to MasterFunctionalStatus
	@ManyToOne
	@JoinColumn(name="functional_status_id")
	private MasterFunctionalStatus masterFunctionalStatus;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="entry_user")
	private UserMaster userMaster;

	public ArtBeneficiaryFollowup() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAdherenceToArt() {
		return this.adherenceToArt;
	}

	public void setAdherenceToArt(Integer adherenceToArt) {
		this.adherenceToArt = adherenceToArt;
	}

	public String getAnyOtherMedicine() {
		return this.anyOtherMedicine;
	}

	public void setAnyOtherMedicine(String anyOtherMedicine) {
		this.anyOtherMedicine = anyOtherMedicine;
	}

	public Boolean getCondomsGiven() {
		return this.condomsGiven;
	}

	public void setCondomsGiven(Boolean condomsGiven) {
		this.condomsGiven = condomsGiven;
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

	public Boolean getDrugsPrescribedForOpportunisticInfectionsProphylaxis() {
		return this.drugsPrescribedForOpportunisticInfectionsProphylaxis;
	}

	public void setDrugsPrescribedForOpportunisticInfectionsProphylaxis(Boolean drugsPrescribedForOpportunisticInfectionsProphylaxis) {
		this.drugsPrescribedForOpportunisticInfectionsProphylaxis = drugsPrescribedForOpportunisticInfectionsProphylaxis;
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

	public String getOpportunisticInfectionsRemarks() {
		return this.opportunisticInfectionsRemarks;
	}

	public void setOpportunisticInfectionsRemarks(String opportunisticInfectionsRemarks) {
		this.opportunisticInfectionsRemarks = opportunisticInfectionsRemarks;
	}

	public String getPaediatricMilestoneAchievedAsPerAge() {
		return this.paediatricMilestoneAchievedAsPerAge;
	}

	public void setPaediatricMilestoneAchievedAsPerAge(String paediatricMilestoneAchievedAsPerAge) {
		this.paediatricMilestoneAchievedAsPerAge = paediatricMilestoneAchievedAsPerAge;
	}

	public Integer getRemainingPills() {
		return this.remainingPills;
	}

	public void setRemainingPills(Integer remainingPills) {
		this.remainingPills = remainingPills;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Boolean getTbTreatment() {
		return this.tbTreatment;
	}

	public void setTbTreatment(Boolean tbTreatment) {
		this.tbTreatment = tbTreatment;
	}

	public Date getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
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

	public MasterClinicalStage getMasterClinicalStage() {
		return this.masterClinicalStage;
	}

	public void setMasterClinicalStage(MasterClinicalStage masterClinicalStage) {
		this.masterClinicalStage = masterClinicalStage;
	}

	public MasterFunctionalStatus getMasterFunctionalStatus() {
		return this.masterFunctionalStatus;
	}

	public void setMasterFunctionalStatus(MasterFunctionalStatus masterFunctionalStatus) {
		this.masterFunctionalStatus = masterFunctionalStatus;
	}

	public UserMaster getUserMaster() {
		return this.userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

}