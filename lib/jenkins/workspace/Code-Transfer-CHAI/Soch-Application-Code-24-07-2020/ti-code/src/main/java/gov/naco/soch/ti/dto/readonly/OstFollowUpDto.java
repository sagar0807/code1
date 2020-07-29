package gov.naco.soch.ti.dto.readonly;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.ti.dto.FacilityDTO;
import gov.naco.soch.ti.dto.TiOstFollowUpByDTO;
import gov.naco.soch.ti.dto.TiOstFollowUpReasonDTO;
import gov.naco.soch.ti.dto.TiOstFollowUpSideEffectDTO;

public class OstFollowUpDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private LocalDate followUpDate;

    private MiniMasterDto followUpType;

    private Integer frequencyOfOtherDrugUse;

    private Integer frequencyOfPrimaryDrugUse;

    private Integer lastDoseOfOtherDrug;

    private Integer lastDoseOfPrimaryDrug;

    private LocalDate nextFollowupDate;

    private Boolean noSideEffects;

    private MiniMasterDto otherDrug;

    private Boolean otherFollowupReason;

    private MiniMasterDto primaryDrug;

    private FacilityDTO facility;

    private Boolean isActive;

    private Boolean isDelete;

    private OstBenSubDto tiOstBeneficiary;

    private Set<TiOstFollowUpByDTO> tiOstFollowUpBy;

    private Set<TiOstFollowUpReasonDTO> tiOstFollowUpReason;

    private Set<TiOstFollowUpSideEffectDTO> tiOstSideEffect;

    private long count;

    private Long previousId;

    private Boolean isEarly;

    public OstFollowUpDto() {

    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public LocalDate getFollowUpDate() {
	return followUpDate;
    }

    public void setFollowUpDate(LocalDate followUpDate) {
	this.followUpDate = followUpDate;
    }

    public MiniMasterDto getFollowUpType() {
	return followUpType;
    }

    public void setFollowUpType(MiniMasterDto followUpType) {
	this.followUpType = followUpType;
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

    public MiniMasterDto getOtherDrug() {
	return otherDrug;
    }

    public void setOtherDrug(MiniMasterDto otherDrug) {
	this.otherDrug = otherDrug;
    }

    public Boolean getOtherFollowupReason() {
	return otherFollowupReason;
    }

    public void setOtherFollowupReason(Boolean otherFollowupReason) {
	this.otherFollowupReason = otherFollowupReason;
    }

    public MiniMasterDto getPrimaryDrug() {
	return primaryDrug;
    }

    public void setPrimaryDrug(MiniMasterDto primaryDrug) {
	this.primaryDrug = primaryDrug;
    }

    public FacilityDTO getFacility() {
	return facility;
    }

    public void setFacility(FacilityDTO facility) {
	this.facility = facility;
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

    public OstBenSubDto getTiOstBeneficiary() {
	return tiOstBeneficiary;
    }

    public void setTiOstBeneficiary(OstBenSubDto tiOstBeneficiary) {
	this.tiOstBeneficiary = tiOstBeneficiary;
    }

    public Set<TiOstFollowUpByDTO> getTiOstFollowUpBy() {
	return tiOstFollowUpBy;
    }

    public void setTiOstFollowUpBy(Set<TiOstFollowUpByDTO> tiOstFollowUpBy) {
	this.tiOstFollowUpBy = tiOstFollowUpBy;
    }

    public Set<TiOstFollowUpReasonDTO> getTiOstFollowUpReason() {
	return tiOstFollowUpReason;
    }

    public void setTiOstFollowUpReason(Set<TiOstFollowUpReasonDTO> tiOstFollowUpReason) {
	this.tiOstFollowUpReason = tiOstFollowUpReason;
    }

    public Set<TiOstFollowUpSideEffectDTO> getTiOstSideEffect() {
	return tiOstSideEffect;
    }

    public void setTiOstSideEffect(Set<TiOstFollowUpSideEffectDTO> tiOstSideEffect) {
	this.tiOstSideEffect = tiOstSideEffect;
    }

    public long getCount() {
	return count;
    }

    public void setCount(long count) {
	this.count = count;
    }

    public Long getPreviousId() {
	return previousId;
    }

    public void setPreviousId(Long previousId) {
	this.previousId = previousId;
    }

    public Boolean getIsEarly() {
	return isEarly;
    }

    public void setIsEarly(Boolean isEarly) {
	this.isEarly = isEarly;
    }

}
