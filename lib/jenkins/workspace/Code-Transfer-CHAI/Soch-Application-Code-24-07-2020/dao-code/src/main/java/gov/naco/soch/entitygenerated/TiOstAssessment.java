package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the ti_ost_assessment database table.
 * 
 */
@Entity
@Table(name="ti_ost_assessment")
@NamedQuery(name="TiOstAssessment.findAll", query="SELECT t FROM TiOstAssessment t")
public class TiOstAssessment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String abdomen;

	private String abscess;

	@Column(name="abstinence_attempts")
	private Integer abstinenceAttempts;

	private String advice;

	@Column(name="age_at_onset")
	private Integer ageAtOnset;

	@Column(name="blood_pressure_diastolic")
	private Integer bloodPressureDiastolic;

	@Column(name="blood_pressure_systolic")
	private Integer bloodPressureSystolic;

	private String chest;

	private Boolean clubbing;

	@Column(name="consent_taken")
	private Boolean consentTaken;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="current_living_arrangement")
	private String currentLivingArrangement;

	private Boolean cyanosis;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_assessment")
	private Date dateOfAssessment;

	private Boolean dependence;

	private String diagnosis;

	@Column(name="duration_of_abstinence")
	private Integer durationOfAbstinence;

	@Column(name="follow_up_reason")
	private String followUpReason;

	@Column(name="help_intervention_type")
	private String helpInterventionType;

	@Column(name="initiate_ost")
	private Boolean initiateOst;

	@Column(name="injecting_route")
	private Boolean injectingRoute;

	@Column(name="is_abstinence_attempted_previously")
	private Boolean isAbstinenceAttemptedPreviously;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="is_needles_and_syringes_shared")
	private Boolean isNeedlesAndSyringesShared;

	@Column(name="is_needles_and_syringes_shared_last_occasion")
	private Boolean isNeedlesAndSyringesSharedLastOccasion;

	@Column(name="is_other_paraphernalia_shared_ever")
	private Boolean isOtherParaphernaliaSharedEver;

	@Column(name="is_other_paraphernalia_shared_last_occasion")
	private Boolean isOtherParaphernaliaSharedLastOccasion;

	private Boolean jaundice;

	@Temporal(TemporalType.DATE)
	@Column(name="last_sexual_encounter")
	private Date lastSexualEncounter;

	private Boolean lymphadenopathy;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="needle_marks")
	private String needleMarks;

	@Column(name="neurological_examination")
	private String neurologicalExamination;

	@Temporal(TemporalType.DATE)
	@Column(name="next_date_of_assessment")
	private Date nextDateOfAssessment;

	@Column(name="no_of_sexual_partners")
	private Integer noOfSexualPartners;

	@Column(name="no_years_in_use")
	private Integer noYearsInUse;

	private Boolean oedema;

	@Column(name="open_wounds")
	private String openWounds;

	@Column(name="ost_number")
	private String ostNumber;

	@Column(name="pulse_rate")
	private Integer pulseRate;

	@Column(name="respiratory_rate")
	private Integer respiratoryRate;

	@Column(name="skin_marks")
	private String skinMarks;

	private Integer temperature;

	@Temporal(TemporalType.DATE)
	@Column(name="time_period_abstinence")
	private Date timePeriodAbstinence;

	@Column(name="use_in_last_one_month")
	private Boolean useInLastOneMonth;

	private Integer weight;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to TiOstBeneficiary
	@ManyToOne
	@JoinColumn(name="ti_ost_beneficiary_id")
	private TiOstBeneficiary tiOstBeneficiary;

	//bi-directional many-to-one association to TiOstAssessmentDrugcomplication
	@OneToMany(mappedBy="tiOstAssessment")
	private Set<TiOstAssessmentDrugcomplication> tiOstAssessmentDrugcomplications;

	//bi-directional many-to-one association to TiOstAssessmentDrugusage
	@OneToMany(mappedBy="tiOstAssessment")
	private Set<TiOstAssessmentDrugusage> tiOstAssessmentDrugusages;

	//bi-directional many-to-one association to TiOstPrescription
	@OneToMany(mappedBy="tiOstAssessment")
	private Set<TiOstPrescription> tiOstPrescriptions;

	public TiOstAssessment() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAbdomen() {
		return this.abdomen;
	}

	public void setAbdomen(String abdomen) {
		this.abdomen = abdomen;
	}

	public String getAbscess() {
		return this.abscess;
	}

	public void setAbscess(String abscess) {
		this.abscess = abscess;
	}

	public Integer getAbstinenceAttempts() {
		return this.abstinenceAttempts;
	}

	public void setAbstinenceAttempts(Integer abstinenceAttempts) {
		this.abstinenceAttempts = abstinenceAttempts;
	}

	public String getAdvice() {
		return this.advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public Integer getAgeAtOnset() {
		return this.ageAtOnset;
	}

	public void setAgeAtOnset(Integer ageAtOnset) {
		this.ageAtOnset = ageAtOnset;
	}

	public Integer getBloodPressureDiastolic() {
		return this.bloodPressureDiastolic;
	}

	public void setBloodPressureDiastolic(Integer bloodPressureDiastolic) {
		this.bloodPressureDiastolic = bloodPressureDiastolic;
	}

	public Integer getBloodPressureSystolic() {
		return this.bloodPressureSystolic;
	}

	public void setBloodPressureSystolic(Integer bloodPressureSystolic) {
		this.bloodPressureSystolic = bloodPressureSystolic;
	}

	public String getChest() {
		return this.chest;
	}

	public void setChest(String chest) {
		this.chest = chest;
	}

	public Boolean getClubbing() {
		return this.clubbing;
	}

	public void setClubbing(Boolean clubbing) {
		this.clubbing = clubbing;
	}

	public Boolean getConsentTaken() {
		return this.consentTaken;
	}

	public void setConsentTaken(Boolean consentTaken) {
		this.consentTaken = consentTaken;
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

	public String getCurrentLivingArrangement() {
		return this.currentLivingArrangement;
	}

	public void setCurrentLivingArrangement(String currentLivingArrangement) {
		this.currentLivingArrangement = currentLivingArrangement;
	}

	public Boolean getCyanosis() {
		return this.cyanosis;
	}

	public void setCyanosis(Boolean cyanosis) {
		this.cyanosis = cyanosis;
	}

	public Date getDateOfAssessment() {
		return this.dateOfAssessment;
	}

	public void setDateOfAssessment(Date dateOfAssessment) {
		this.dateOfAssessment = dateOfAssessment;
	}

	public Boolean getDependence() {
		return this.dependence;
	}

	public void setDependence(Boolean dependence) {
		this.dependence = dependence;
	}

	public String getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Integer getDurationOfAbstinence() {
		return this.durationOfAbstinence;
	}

	public void setDurationOfAbstinence(Integer durationOfAbstinence) {
		this.durationOfAbstinence = durationOfAbstinence;
	}

	public String getFollowUpReason() {
		return this.followUpReason;
	}

	public void setFollowUpReason(String followUpReason) {
		this.followUpReason = followUpReason;
	}

	public String getHelpInterventionType() {
		return this.helpInterventionType;
	}

	public void setHelpInterventionType(String helpInterventionType) {
		this.helpInterventionType = helpInterventionType;
	}

	public Boolean getInitiateOst() {
		return this.initiateOst;
	}

	public void setInitiateOst(Boolean initiateOst) {
		this.initiateOst = initiateOst;
	}

	public Boolean getInjectingRoute() {
		return this.injectingRoute;
	}

	public void setInjectingRoute(Boolean injectingRoute) {
		this.injectingRoute = injectingRoute;
	}

	public Boolean getIsAbstinenceAttemptedPreviously() {
		return this.isAbstinenceAttemptedPreviously;
	}

	public void setIsAbstinenceAttemptedPreviously(Boolean isAbstinenceAttemptedPreviously) {
		this.isAbstinenceAttemptedPreviously = isAbstinenceAttemptedPreviously;
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

	public Boolean getIsNeedlesAndSyringesShared() {
		return this.isNeedlesAndSyringesShared;
	}

	public void setIsNeedlesAndSyringesShared(Boolean isNeedlesAndSyringesShared) {
		this.isNeedlesAndSyringesShared = isNeedlesAndSyringesShared;
	}

	public Boolean getIsNeedlesAndSyringesSharedLastOccasion() {
		return this.isNeedlesAndSyringesSharedLastOccasion;
	}

	public void setIsNeedlesAndSyringesSharedLastOccasion(Boolean isNeedlesAndSyringesSharedLastOccasion) {
		this.isNeedlesAndSyringesSharedLastOccasion = isNeedlesAndSyringesSharedLastOccasion;
	}

	public Boolean getIsOtherParaphernaliaSharedEver() {
		return this.isOtherParaphernaliaSharedEver;
	}

	public void setIsOtherParaphernaliaSharedEver(Boolean isOtherParaphernaliaSharedEver) {
		this.isOtherParaphernaliaSharedEver = isOtherParaphernaliaSharedEver;
	}

	public Boolean getIsOtherParaphernaliaSharedLastOccasion() {
		return this.isOtherParaphernaliaSharedLastOccasion;
	}

	public void setIsOtherParaphernaliaSharedLastOccasion(Boolean isOtherParaphernaliaSharedLastOccasion) {
		this.isOtherParaphernaliaSharedLastOccasion = isOtherParaphernaliaSharedLastOccasion;
	}

	public Boolean getJaundice() {
		return this.jaundice;
	}

	public void setJaundice(Boolean jaundice) {
		this.jaundice = jaundice;
	}

	public Date getLastSexualEncounter() {
		return this.lastSexualEncounter;
	}

	public void setLastSexualEncounter(Date lastSexualEncounter) {
		this.lastSexualEncounter = lastSexualEncounter;
	}

	public Boolean getLymphadenopathy() {
		return this.lymphadenopathy;
	}

	public void setLymphadenopathy(Boolean lymphadenopathy) {
		this.lymphadenopathy = lymphadenopathy;
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

	public String getNeedleMarks() {
		return this.needleMarks;
	}

	public void setNeedleMarks(String needleMarks) {
		this.needleMarks = needleMarks;
	}

	public String getNeurologicalExamination() {
		return this.neurologicalExamination;
	}

	public void setNeurologicalExamination(String neurologicalExamination) {
		this.neurologicalExamination = neurologicalExamination;
	}

	public Date getNextDateOfAssessment() {
		return this.nextDateOfAssessment;
	}

	public void setNextDateOfAssessment(Date nextDateOfAssessment) {
		this.nextDateOfAssessment = nextDateOfAssessment;
	}

	public Integer getNoOfSexualPartners() {
		return this.noOfSexualPartners;
	}

	public void setNoOfSexualPartners(Integer noOfSexualPartners) {
		this.noOfSexualPartners = noOfSexualPartners;
	}

	public Integer getNoYearsInUse() {
		return this.noYearsInUse;
	}

	public void setNoYearsInUse(Integer noYearsInUse) {
		this.noYearsInUse = noYearsInUse;
	}

	public Boolean getOedema() {
		return this.oedema;
	}

	public void setOedema(Boolean oedema) {
		this.oedema = oedema;
	}

	public String getOpenWounds() {
		return this.openWounds;
	}

	public void setOpenWounds(String openWounds) {
		this.openWounds = openWounds;
	}

	public String getOstNumber() {
		return this.ostNumber;
	}

	public void setOstNumber(String ostNumber) {
		this.ostNumber = ostNumber;
	}

	public Integer getPulseRate() {
		return this.pulseRate;
	}

	public void setPulseRate(Integer pulseRate) {
		this.pulseRate = pulseRate;
	}

	public Integer getRespiratoryRate() {
		return this.respiratoryRate;
	}

	public void setRespiratoryRate(Integer respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}

	public String getSkinMarks() {
		return this.skinMarks;
	}

	public void setSkinMarks(String skinMarks) {
		this.skinMarks = skinMarks;
	}

	public Integer getTemperature() {
		return this.temperature;
	}

	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}

	public Date getTimePeriodAbstinence() {
		return this.timePeriodAbstinence;
	}

	public void setTimePeriodAbstinence(Date timePeriodAbstinence) {
		this.timePeriodAbstinence = timePeriodAbstinence;
	}

	public Boolean getUseInLastOneMonth() {
		return this.useInLastOneMonth;
	}

	public void setUseInLastOneMonth(Boolean useInLastOneMonth) {
		this.useInLastOneMonth = useInLastOneMonth;
	}

	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public TiOstBeneficiary getTiOstBeneficiary() {
		return this.tiOstBeneficiary;
	}

	public void setTiOstBeneficiary(TiOstBeneficiary tiOstBeneficiary) {
		this.tiOstBeneficiary = tiOstBeneficiary;
	}

	public Set<TiOstAssessmentDrugcomplication> getTiOstAssessmentDrugcomplications() {
		return this.tiOstAssessmentDrugcomplications;
	}

	public void setTiOstAssessmentDrugcomplications(Set<TiOstAssessmentDrugcomplication> tiOstAssessmentDrugcomplications) {
		this.tiOstAssessmentDrugcomplications = tiOstAssessmentDrugcomplications;
	}

	public TiOstAssessmentDrugcomplication addTiOstAssessmentDrugcomplication(TiOstAssessmentDrugcomplication tiOstAssessmentDrugcomplication) {
		getTiOstAssessmentDrugcomplications().add(tiOstAssessmentDrugcomplication);
		tiOstAssessmentDrugcomplication.setTiOstAssessment(this);

		return tiOstAssessmentDrugcomplication;
	}

	public TiOstAssessmentDrugcomplication removeTiOstAssessmentDrugcomplication(TiOstAssessmentDrugcomplication tiOstAssessmentDrugcomplication) {
		getTiOstAssessmentDrugcomplications().remove(tiOstAssessmentDrugcomplication);
		tiOstAssessmentDrugcomplication.setTiOstAssessment(null);

		return tiOstAssessmentDrugcomplication;
	}

	public Set<TiOstAssessmentDrugusage> getTiOstAssessmentDrugusages() {
		return this.tiOstAssessmentDrugusages;
	}

	public void setTiOstAssessmentDrugusages(Set<TiOstAssessmentDrugusage> tiOstAssessmentDrugusages) {
		this.tiOstAssessmentDrugusages = tiOstAssessmentDrugusages;
	}

	public TiOstAssessmentDrugusage addTiOstAssessmentDrugusage(TiOstAssessmentDrugusage tiOstAssessmentDrugusage) {
		getTiOstAssessmentDrugusages().add(tiOstAssessmentDrugusage);
		tiOstAssessmentDrugusage.setTiOstAssessment(this);

		return tiOstAssessmentDrugusage;
	}

	public TiOstAssessmentDrugusage removeTiOstAssessmentDrugusage(TiOstAssessmentDrugusage tiOstAssessmentDrugusage) {
		getTiOstAssessmentDrugusages().remove(tiOstAssessmentDrugusage);
		tiOstAssessmentDrugusage.setTiOstAssessment(null);

		return tiOstAssessmentDrugusage;
	}

	public Set<TiOstPrescription> getTiOstPrescriptions() {
		return this.tiOstPrescriptions;
	}

	public void setTiOstPrescriptions(Set<TiOstPrescription> tiOstPrescriptions) {
		this.tiOstPrescriptions = tiOstPrescriptions;
	}

	public TiOstPrescription addTiOstPrescription(TiOstPrescription tiOstPrescription) {
		getTiOstPrescriptions().add(tiOstPrescription);
		tiOstPrescription.setTiOstAssessment(this);

		return tiOstPrescription;
	}

	public TiOstPrescription removeTiOstPrescription(TiOstPrescription tiOstPrescription) {
		getTiOstPrescriptions().remove(tiOstPrescription);
		tiOstPrescription.setTiOstAssessment(null);

		return tiOstPrescription;
	}

}