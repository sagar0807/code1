package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the ti_ost_follow_up database table.
 * 
 */
@Entity
@Table(name="ti_ost_follow_up")
@NamedQuery(name="TiOstFollowUp.findAll", query="SELECT t FROM TiOstFollowUp t")
public class TiOstFollowUp implements Serializable {
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

	@Column(name="dose_stabilization")
	private Boolean doseStabilization;

	private Boolean drowsiness;

	@Column(name="family_issues")
	private Boolean familyIssues;

	@Temporal(TemporalType.DATE)
	@Column(name="follow_up_date")
	private Date followUpDate;

	@Column(name="follow_up_reason")
	private String followUpReason;

	@Column(name="follow_up_type")
	private Integer followUpType;

	@Column(name="frequency_of_other_drug_use")
	private Integer frequencyOfOtherDrugUse;

	@Column(name="frequency_of_primary_drug_use")
	private Integer frequencyOfPrimaryDrugUse;

	private Boolean giddiness;

	@Column(name="group_therapy")
	private Boolean groupTherapy;

	private Boolean hallucination;

	private Boolean headaches;

	@Column(name="hostile_attitude_with_staff")
	private Boolean hostileAttitudeWithStaff;

	private Boolean incoordination;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	private Boolean itching;

	@Column(name="last_dose_of_other_drug")
	private Integer lastDoseOfOtherDrug;

	@Column(name="last_dose_of_primary_drug")
	private Integer lastDoseOfPrimaryDrug;

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
	private Integer otherDrug;

	@Column(name="other_followup_reason")
	private Boolean otherFollowupReason;

	@Column(name="other_side_effects")
	private String otherSideEffects;

	@Column(name="primary_drug")
	private Integer primaryDrug;

	private Boolean sedation;

	@Column(name="side_effects")
	private Boolean sideEffects;

	@Column(name="slurred_speech")
	private Boolean slurredSpeech;

	private Boolean weakness;

	@Column(name="withdrawal_symptoms")
	private Boolean withdrawalSymptoms;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to TiOstBeneficiary
	@ManyToOne
	@JoinColumn(name="ti_ost_beneficiary_id")
	private TiOstBeneficiary tiOstBeneficiary;

	//bi-directional many-to-one association to TiOstFollowUpBy
	@OneToMany(mappedBy="tiOstFollowUp")
	private Set<TiOstFollowUpBy> tiOstFollowUpBies;

	//bi-directional many-to-one association to TiOstPrescription
	@OneToMany(mappedBy="tiOstFollowUp")
	private Set<TiOstPrescription> tiOstPrescriptions;

	public TiOstFollowUp() {
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

	public Date getFollowUpDate() {
		return this.followUpDate;
	}

	public void setFollowUpDate(Date followUpDate) {
		this.followUpDate = followUpDate;
	}

	public String getFollowUpReason() {
		return this.followUpReason;
	}

	public void setFollowUpReason(String followUpReason) {
		this.followUpReason = followUpReason;
	}

	public Integer getFollowUpType() {
		return this.followUpType;
	}

	public void setFollowUpType(Integer followUpType) {
		this.followUpType = followUpType;
	}

	public Integer getFrequencyOfOtherDrugUse() {
		return this.frequencyOfOtherDrugUse;
	}

	public void setFrequencyOfOtherDrugUse(Integer frequencyOfOtherDrugUse) {
		this.frequencyOfOtherDrugUse = frequencyOfOtherDrugUse;
	}

	public Integer getFrequencyOfPrimaryDrugUse() {
		return this.frequencyOfPrimaryDrugUse;
	}

	public void setFrequencyOfPrimaryDrugUse(Integer frequencyOfPrimaryDrugUse) {
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

	public Boolean getItching() {
		return this.itching;
	}

	public void setItching(Boolean itching) {
		this.itching = itching;
	}

	public Integer getLastDoseOfOtherDrug() {
		return this.lastDoseOfOtherDrug;
	}

	public void setLastDoseOfOtherDrug(Integer lastDoseOfOtherDrug) {
		this.lastDoseOfOtherDrug = lastDoseOfOtherDrug;
	}

	public Integer getLastDoseOfPrimaryDrug() {
		return this.lastDoseOfPrimaryDrug;
	}

	public void setLastDoseOfPrimaryDrug(Integer lastDoseOfPrimaryDrug) {
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

	public Integer getOtherDrug() {
		return this.otherDrug;
	}

	public void setOtherDrug(Integer otherDrug) {
		this.otherDrug = otherDrug;
	}

	public Boolean getOtherFollowupReason() {
		return this.otherFollowupReason;
	}

	public void setOtherFollowupReason(Boolean otherFollowupReason) {
		this.otherFollowupReason = otherFollowupReason;
	}

	public String getOtherSideEffects() {
		return this.otherSideEffects;
	}

	public void setOtherSideEffects(String otherSideEffects) {
		this.otherSideEffects = otherSideEffects;
	}

	public Integer getPrimaryDrug() {
		return this.primaryDrug;
	}

	public void setPrimaryDrug(Integer primaryDrug) {
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

	public Set<TiOstFollowUpBy> getTiOstFollowUpBies() {
		return this.tiOstFollowUpBies;
	}

	public void setTiOstFollowUpBies(Set<TiOstFollowUpBy> tiOstFollowUpBies) {
		this.tiOstFollowUpBies = tiOstFollowUpBies;
	}

	public TiOstFollowUpBy addTiOstFollowUpBy(TiOstFollowUpBy tiOstFollowUpBy) {
		getTiOstFollowUpBies().add(tiOstFollowUpBy);
		tiOstFollowUpBy.setTiOstFollowUp(this);

		return tiOstFollowUpBy;
	}

	public TiOstFollowUpBy removeTiOstFollowUpBy(TiOstFollowUpBy tiOstFollowUpBy) {
		getTiOstFollowUpBies().remove(tiOstFollowUpBy);
		tiOstFollowUpBy.setTiOstFollowUp(null);

		return tiOstFollowUpBy;
	}

	public Set<TiOstPrescription> getTiOstPrescriptions() {
		return this.tiOstPrescriptions;
	}

	public void setTiOstPrescriptions(Set<TiOstPrescription> tiOstPrescriptions) {
		this.tiOstPrescriptions = tiOstPrescriptions;
	}

	public TiOstPrescription addTiOstPrescription(TiOstPrescription tiOstPrescription) {
		getTiOstPrescriptions().add(tiOstPrescription);
		tiOstPrescription.setTiOstFollowUp(this);

		return tiOstPrescription;
	}

	public TiOstPrescription removeTiOstPrescription(TiOstPrescription tiOstPrescription) {
		getTiOstPrescriptions().remove(tiOstPrescription);
		tiOstPrescription.setTiOstFollowUp(null);

		return tiOstPrescription;
	}

}