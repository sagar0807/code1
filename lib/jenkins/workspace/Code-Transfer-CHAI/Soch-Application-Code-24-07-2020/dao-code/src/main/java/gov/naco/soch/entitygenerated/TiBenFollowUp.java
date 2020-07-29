package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the ti_ben_follow_up database table.
 * 
 */
@Entity
@Table(name="ti_ben_follow_up")
@NamedQuery(name="TiBenFollowUp.findAll", query="SELECT t FROM TiBenFollowUp t")
public class TiBenFollowUp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="blurred_vision")
	private Boolean blurredVision;

	@Column(name="cognitive_behavior_therapy")
	private Boolean cognitiveBehaviorTherapy;

	private Boolean confusion;

	private Boolean constipation;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	private Boolean diplopia;

	private String dosage;

	@Column(name="dosage_measure_unit")
	private String dosageMeasureUnit;

	@Column(name="dose_stabilization")
	private Boolean doseStabilization;

	private Boolean drowsiness;

	@Column(name="family_issues")
	private Boolean familyIssues;

	@Column(name="follow_up_by")
	private String followUpBy;

	@Temporal(TemporalType.DATE)
	@Column(name="follow_up_date")
	private Date followUpDate;

	@Column(name="follow_up_reason_other")
	private String followUpReasonOther;

	@Column(name="follow_up_type")
	private String followUpType;

	@Column(name="frequency_of_other_drug_use")
	private String frequencyOfOtherDrugUse;

	@Column(name="frequency_of_primary_drug_use")
	private String frequencyOfPrimaryDrugUse;

	private Boolean giddiness;

	@Column(name="group_therapy")
	private Boolean groupTherapy;

	private Boolean hallucination;

	private Boolean headaches;

	@Column(name="hostile_attitude_with_staff")
	private Boolean hostileAttitudeWithStaff;

	private Boolean incoordination;

	private Boolean itching;

	@Column(name="last_dose_of_other_drug")
	private String lastDoseOfOtherDrug;

	@Column(name="last_dose_of_primary_drug")
	private String lastDoseOfPrimaryDrug;

	@Column(name="light_headedness")
	private Boolean lightHeadedness;

	@Column(name="marital_issue")
	private Boolean maritalIssue;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Temporal(TemporalType.DATE)
	@Column(name="next_followup_date")
	private Date nextFollowupDate;

	@Column(name="no_side_effects")
	private Boolean noSideEffects;

	@Column(name="occupation_issue")
	private Boolean occupationIssue;

	@Column(name="oral_ulceration")
	private Boolean oralUlceration;

	@Column(name="other_drug")
	private String otherDrug;

	@Column(name="other_side_effects")
	private String otherSideEffects;

	@Column(name="primary_drug")
	private String primaryDrug;

	private Boolean sedation;

	@Column(name="side_effects")
	private Boolean sideEffects;

	@Column(name="slurred_speech")
	private Boolean slurredSpeech;

	@Column(name="substitution_drug")
	private String substitutionDrug;

	@Column(name="update_prescription")
	private Boolean updatePrescription;

	private Boolean weakness;

	@Column(name="withdrawal_symptoms")
	private Boolean withdrawalSymptoms;

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

	public TiBenFollowUp() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getBlurredVision() {
		return this.blurredVision;
	}

	public void setBlurredVision(Boolean blurredVision) {
		this.blurredVision = blurredVision;
	}

	public Boolean getCognitiveBehaviorTherapy() {
		return this.cognitiveBehaviorTherapy;
	}

	public void setCognitiveBehaviorTherapy(Boolean cognitiveBehaviorTherapy) {
		this.cognitiveBehaviorTherapy = cognitiveBehaviorTherapy;
	}

	public Boolean getConfusion() {
		return this.confusion;
	}

	public void setConfusion(Boolean confusion) {
		this.confusion = confusion;
	}

	public Boolean getConstipation() {
		return this.constipation;
	}

	public void setConstipation(Boolean constipation) {
		this.constipation = constipation;
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

	public Boolean getDiplopia() {
		return this.diplopia;
	}

	public void setDiplopia(Boolean diplopia) {
		this.diplopia = diplopia;
	}

	public String getDosage() {
		return this.dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getDosageMeasureUnit() {
		return this.dosageMeasureUnit;
	}

	public void setDosageMeasureUnit(String dosageMeasureUnit) {
		this.dosageMeasureUnit = dosageMeasureUnit;
	}

	public Boolean getDoseStabilization() {
		return this.doseStabilization;
	}

	public void setDoseStabilization(Boolean doseStabilization) {
		this.doseStabilization = doseStabilization;
	}

	public Boolean getDrowsiness() {
		return this.drowsiness;
	}

	public void setDrowsiness(Boolean drowsiness) {
		this.drowsiness = drowsiness;
	}

	public Boolean getFamilyIssues() {
		return this.familyIssues;
	}

	public void setFamilyIssues(Boolean familyIssues) {
		this.familyIssues = familyIssues;
	}

	public String getFollowUpBy() {
		return this.followUpBy;
	}

	public void setFollowUpBy(String followUpBy) {
		this.followUpBy = followUpBy;
	}

	public Date getFollowUpDate() {
		return this.followUpDate;
	}

	public void setFollowUpDate(Date followUpDate) {
		this.followUpDate = followUpDate;
	}

	public String getFollowUpReasonOther() {
		return this.followUpReasonOther;
	}

	public void setFollowUpReasonOther(String followUpReasonOther) {
		this.followUpReasonOther = followUpReasonOther;
	}

	public String getFollowUpType() {
		return this.followUpType;
	}

	public void setFollowUpType(String followUpType) {
		this.followUpType = followUpType;
	}

	public String getFrequencyOfOtherDrugUse() {
		return this.frequencyOfOtherDrugUse;
	}

	public void setFrequencyOfOtherDrugUse(String frequencyOfOtherDrugUse) {
		this.frequencyOfOtherDrugUse = frequencyOfOtherDrugUse;
	}

	public String getFrequencyOfPrimaryDrugUse() {
		return this.frequencyOfPrimaryDrugUse;
	}

	public void setFrequencyOfPrimaryDrugUse(String frequencyOfPrimaryDrugUse) {
		this.frequencyOfPrimaryDrugUse = frequencyOfPrimaryDrugUse;
	}

	public Boolean getGiddiness() {
		return this.giddiness;
	}

	public void setGiddiness(Boolean giddiness) {
		this.giddiness = giddiness;
	}

	public Boolean getGroupTherapy() {
		return this.groupTherapy;
	}

	public void setGroupTherapy(Boolean groupTherapy) {
		this.groupTherapy = groupTherapy;
	}

	public Boolean getHallucination() {
		return this.hallucination;
	}

	public void setHallucination(Boolean hallucination) {
		this.hallucination = hallucination;
	}

	public Boolean getHeadaches() {
		return this.headaches;
	}

	public void setHeadaches(Boolean headaches) {
		this.headaches = headaches;
	}

	public Boolean getHostileAttitudeWithStaff() {
		return this.hostileAttitudeWithStaff;
	}

	public void setHostileAttitudeWithStaff(Boolean hostileAttitudeWithStaff) {
		this.hostileAttitudeWithStaff = hostileAttitudeWithStaff;
	}

	public Boolean getIncoordination() {
		return this.incoordination;
	}

	public void setIncoordination(Boolean incoordination) {
		this.incoordination = incoordination;
	}

	public Boolean getItching() {
		return this.itching;
	}

	public void setItching(Boolean itching) {
		this.itching = itching;
	}

	public String getLastDoseOfOtherDrug() {
		return this.lastDoseOfOtherDrug;
	}

	public void setLastDoseOfOtherDrug(String lastDoseOfOtherDrug) {
		this.lastDoseOfOtherDrug = lastDoseOfOtherDrug;
	}

	public String getLastDoseOfPrimaryDrug() {
		return this.lastDoseOfPrimaryDrug;
	}

	public void setLastDoseOfPrimaryDrug(String lastDoseOfPrimaryDrug) {
		this.lastDoseOfPrimaryDrug = lastDoseOfPrimaryDrug;
	}

	public Boolean getLightHeadedness() {
		return this.lightHeadedness;
	}

	public void setLightHeadedness(Boolean lightHeadedness) {
		this.lightHeadedness = lightHeadedness;
	}

	public Boolean getMaritalIssue() {
		return this.maritalIssue;
	}

	public void setMaritalIssue(Boolean maritalIssue) {
		this.maritalIssue = maritalIssue;
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

	public Date getNextFollowupDate() {
		return this.nextFollowupDate;
	}

	public void setNextFollowupDate(Date nextFollowupDate) {
		this.nextFollowupDate = nextFollowupDate;
	}

	public Boolean getNoSideEffects() {
		return this.noSideEffects;
	}

	public void setNoSideEffects(Boolean noSideEffects) {
		this.noSideEffects = noSideEffects;
	}

	public Boolean getOccupationIssue() {
		return this.occupationIssue;
	}

	public void setOccupationIssue(Boolean occupationIssue) {
		this.occupationIssue = occupationIssue;
	}

	public Boolean getOralUlceration() {
		return this.oralUlceration;
	}

	public void setOralUlceration(Boolean oralUlceration) {
		this.oralUlceration = oralUlceration;
	}

	public String getOtherDrug() {
		return this.otherDrug;
	}

	public void setOtherDrug(String otherDrug) {
		this.otherDrug = otherDrug;
	}

	public String getOtherSideEffects() {
		return this.otherSideEffects;
	}

	public void setOtherSideEffects(String otherSideEffects) {
		this.otherSideEffects = otherSideEffects;
	}

	public String getPrimaryDrug() {
		return this.primaryDrug;
	}

	public void setPrimaryDrug(String primaryDrug) {
		this.primaryDrug = primaryDrug;
	}

	public Boolean getSedation() {
		return this.sedation;
	}

	public void setSedation(Boolean sedation) {
		this.sedation = sedation;
	}

	public Boolean getSideEffects() {
		return this.sideEffects;
	}

	public void setSideEffects(Boolean sideEffects) {
		this.sideEffects = sideEffects;
	}

	public Boolean getSlurredSpeech() {
		return this.slurredSpeech;
	}

	public void setSlurredSpeech(Boolean slurredSpeech) {
		this.slurredSpeech = slurredSpeech;
	}

	public String getSubstitutionDrug() {
		return this.substitutionDrug;
	}

	public void setSubstitutionDrug(String substitutionDrug) {
		this.substitutionDrug = substitutionDrug;
	}

	public Boolean getUpdatePrescription() {
		return this.updatePrescription;
	}

	public void setUpdatePrescription(Boolean updatePrescription) {
		this.updatePrescription = updatePrescription;
	}

	public Boolean getWeakness() {
		return this.weakness;
	}

	public void setWeakness(Boolean weakness) {
		this.weakness = weakness;
	}

	public Boolean getWithdrawalSymptoms() {
		return this.withdrawalSymptoms;
	}

	public void setWithdrawalSymptoms(Boolean withdrawalSymptoms) {
		this.withdrawalSymptoms = withdrawalSymptoms;
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