package gov.naco.soch.ti.dto;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import gov.naco.soch.dto.MiniMasterDto;

public class TiBenFollowUpDTO_Initial extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private FacilityDTO facility;

	private Long beneficiaryId;
	
	private Boolean isEarly;

	private Boolean blurredVision;

	private Boolean cognitiveBehaviorTherapy;

	private Boolean confusion;

	private Boolean constipation;

	private Boolean diplopia;

	private Boolean doseStabilization;

	private Boolean drowsiness;

	private Boolean familyIssues;

	private LocalDate followUpDate;

	private MiniMasterDto followUpType;

	private Integer frequencyOfOtherDrugUse;

	private Integer frequencyOfPrimaryDrugUse;

	private Boolean giddiness;

	private Boolean groupTherapy;

	private Boolean hallucination;

	private Boolean headaches;

	private Boolean hostileAttitudeWithStaff;

	private Boolean incoordination;

	private Boolean itching;

	private Integer lastDoseOfOtherDrug;

	private Integer lastDoseOfPrimaryDrug;

	private Boolean lightHeadedness;

	private Boolean maritalIssue;

	private LocalDate nextFollowupDate;

	private Boolean noSideEffects;

	private Boolean occupationIssue;

	private Boolean oralUlceration;

	private MiniMasterDto otherDrug;

	private MiniMasterDto primaryDrug;

	private Boolean isActive;

	private Boolean isDelete;

	private String followUpReason;

	private Set<TIOstPrescriptionDTO> tiOstPrescriptions;

	private Set<TiOstFollowUpByDTO> tiOstFollowUpBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// public Long getFacilityId() {
	// return facilityId;
	// }
	//
	// public void setFacilityId(Long facilityId) {
	// this.facilityId = facilityId;
	// }

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Set<TIOstPrescriptionDTO> getTiOstPrescriptions() {
		return tiOstPrescriptions;
	}

	public void setTiOstPrescriptions(Set<TIOstPrescriptionDTO> tiOstPrescriptions) {
		this.tiOstPrescriptions = tiOstPrescriptions;
	}

	public Set<TiOstFollowUpByDTO> getTiOstFollowUpBy() {
		return tiOstFollowUpBy;
	}

	public void setTiOstFollowUpBy(Set<TiOstFollowUpByDTO> tiOstFollowUpBy) {
		this.tiOstFollowUpBy = tiOstFollowUpBy;
	}

	public Boolean getBlurredVision() {
		return blurredVision;
	}

	public void setBlurredVision(Boolean blurredVision) {
		this.blurredVision = blurredVision;
	}

	public Boolean getCognitiveBehaviorTherapy() {
		return cognitiveBehaviorTherapy;
	}

	public void setCognitiveBehaviorTherapy(Boolean cognitiveBehaviorTherapy) {
		this.cognitiveBehaviorTherapy = cognitiveBehaviorTherapy;
	}

	public Boolean getConfusion() {
		return confusion;
	}

	public void setConfusion(Boolean confusion) {
		this.confusion = confusion;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean getConstipation() {
		return constipation;
	}

	public void setConstipation(Boolean constipation) {
		this.constipation = constipation;
	}

	public Boolean getDiplopia() {
		return diplopia;
	}

	public void setDiplopia(Boolean diplopia) {
		this.diplopia = diplopia;
	}

	public Boolean getDoseStabilization() {
		return doseStabilization;
	}

	public void setDoseStabilization(Boolean doseStabilization) {
		this.doseStabilization = doseStabilization;
	}

	public Boolean getDrowsiness() {
		return drowsiness;
	}

	public void setDrowsiness(Boolean drowsiness) {
		this.drowsiness = drowsiness;
	}

	public Boolean getFamilyIssues() {
		return familyIssues;
	}

	public void setFamilyIssues(Boolean familyIssues) {
		this.familyIssues = familyIssues;
	}

	public LocalDate getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(LocalDate followUpDate) {
		this.followUpDate = followUpDate;
	}

	public Integer getFrequencyOfOtherDrugUse() {
		return frequencyOfOtherDrugUse;
	}

	public void setFrequencyOfOtherDrugUse(Integer frequencyOfOtherDrugUse) {
		this.frequencyOfOtherDrugUse = frequencyOfOtherDrugUse;
	}

	public Integer getFrequencyOfPrimaryDrugUse() {
		return frequencyOfPrimaryDrugUse;
	}

	public void setFrequencyOfPrimaryDrugUse(Integer frequencyOfPrimaryDrugUse) {
		this.frequencyOfPrimaryDrugUse = frequencyOfPrimaryDrugUse;
	}

	public Boolean getGiddiness() {
		return giddiness;
	}

	public void setGiddiness(Boolean giddiness) {
		this.giddiness = giddiness;
	}

	public Boolean getGroupTherapy() {
		return groupTherapy;
	}

	public void setGroupTherapy(Boolean groupTherapy) {
		this.groupTherapy = groupTherapy;
	}

	public Boolean getHallucination() {
		return hallucination;
	}

	public void setHallucination(Boolean hallucination) {
		this.hallucination = hallucination;
	}

	public Boolean getHeadaches() {
		return headaches;
	}

	public void setHeadaches(Boolean headaches) {
		this.headaches = headaches;
	}

	public Boolean getHostileAttitudeWithStaff() {
		return hostileAttitudeWithStaff;
	}

	public void setHostileAttitudeWithStaff(Boolean hostileAttitudeWithStaff) {
		this.hostileAttitudeWithStaff = hostileAttitudeWithStaff;
	}

	public Boolean getIncoordination() {
		return incoordination;
	}

	public void setIncoordination(Boolean incoordination) {
		this.incoordination = incoordination;
	}

	public Boolean getItching() {
		return itching;
	}

	public void setItching(Boolean itching) {
		this.itching = itching;
	}

	public Integer getLastDoseOfOtherDrug() {
		return lastDoseOfOtherDrug;
	}

	public void setLastDoseOfOtherDrug(Integer lastDoseOfOtherDrug) {
		this.lastDoseOfOtherDrug = lastDoseOfOtherDrug;
	}

	public Integer getLastDoseOfPrimaryDrug() {
		return lastDoseOfPrimaryDrug;
	}

	public void setLastDoseOfPrimaryDrug(Integer lastDoseOfPrimaryDrug) {
		this.lastDoseOfPrimaryDrug = lastDoseOfPrimaryDrug;
	}

	public Boolean getLightHeadedness() {
		return lightHeadedness;
	}

	public void setLightHeadedness(Boolean lightHeadedness) {
		this.lightHeadedness = lightHeadedness;
	}

	public Boolean getMaritalIssue() {
		return maritalIssue;
	}

	public void setMaritalIssue(Boolean maritalIssue) {
		this.maritalIssue = maritalIssue;
	}

	public LocalDate getNextFollowupDate() {
		return nextFollowupDate;
	}

	public void setNextFollowupDate(LocalDate nextFollowupDate) {
		this.nextFollowupDate = nextFollowupDate;
	}

	public Boolean getNoSideEffects() {
		return noSideEffects;
	}

	public void setNoSideEffects(Boolean noSideEffects) {
		this.noSideEffects = noSideEffects;
	}

	public Boolean getOccupationIssue() {
		return occupationIssue;
	}

	public void setOccupationIssue(Boolean occupationIssue) {
		this.occupationIssue = occupationIssue;
	}

	public MiniMasterDto getOtherDrug() {
		return otherDrug;
	}

	public void setOtherDrug(MiniMasterDto otherDrug) {
		this.otherDrug = otherDrug;
	}

	public String getFollowUpReason() {
		return followUpReason;
	}

	public void setFollowUpReason(String followUpReason) {
		this.followUpReason = followUpReason;
	}

	public Boolean getOralUlceration() {
		return oralUlceration;
	}

	public void setOralUlceration(Boolean oralUlceration) {
		this.oralUlceration = oralUlceration;
	}
	//
	// public MiniMasterDto getFollowUpType() {
	// return followUpType;
	// }
	//
	// public void setFollowUpType(MiniMasterDto followUpType) {
	// this.followUpType = followUpType;
	// }

	// public MiniMasterDto getOtherDrug() {
	// return otherDrug;
	// }
	//
	// public void setOtherDrug(MiniMasterDto otherDrug) {
	// this.otherDrug = otherDrug;
	// }

	public MiniMasterDto getFollowUpType() {
		return followUpType;
	}

	public void setFollowUpType(MiniMasterDto followUpType) {
		this.followUpType = followUpType;
	}

	public Boolean getIsEarly() {
	    return isEarly;
	}

	public void setIsEarly(Boolean isEarly) {
	    this.isEarly = isEarly;
	}

	public Boolean getOtherFollowupReason() {
		return otherFollowupReason;
	}

	public void setOtherFollowupReason(Boolean otherFollowupReason) {
		this.otherFollowupReason = otherFollowupReason;
	}

	public String getOtherSideEffects() {
		return otherSideEffects;
	}

	public void setOtherSideEffects(String otherSideEffects) {
		this.otherSideEffects = otherSideEffects;
	}

	public MiniMasterDto getPrimaryDrug() {
		return this.primaryDrug;
	}

	public FacilityDTO getFacility() {
		return facility;
	}

	public void setFacility(FacilityDTO facility) {
		this.facility = facility;
	}

	public Boolean getSedation() {
		return sedation;

	}

	public void setPrimaryDrug(MiniMasterDto primaryDrug) {
		this.primaryDrug = primaryDrug;
	}

	public void setSedation(Boolean sedation) {
		this.sedation = sedation;
	}

	public Boolean getSideEffects() {
		return sideEffects;
	}

	public void setSideEffects(Boolean sideEffects) {
		this.sideEffects = sideEffects;
	}

	public Boolean getSlurredSpeech() {
		return slurredSpeech;
	}

	public void setSlurredSpeech(Boolean slurredSpeech) {
		this.slurredSpeech = slurredSpeech;
	}

	public Boolean getWeakness() {
		return weakness;
	}

	public void setWeakness(Boolean weakness) {
		this.weakness = weakness;
	}

	public Boolean getWithdrawalSymptoms() {
		return withdrawalSymptoms;
	}

	public void setWithdrawalSymptoms(Boolean withdrawalSymptoms) {
		this.withdrawalSymptoms = withdrawalSymptoms;
	}

	private Boolean otherFollowupReason;

	private String otherSideEffects;

	private Boolean sedation;

	private Boolean sideEffects;

	private Boolean slurredSpeech;

	private Boolean weakness;

	private Boolean withdrawalSymptoms;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		TiBenFollowUpDTO_Initial tiBenFollowUpDTO_Initial = (TiBenFollowUpDTO_Initial) o;
		if (tiBenFollowUpDTO_Initial.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), tiBenFollowUpDTO_Initial.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

}
