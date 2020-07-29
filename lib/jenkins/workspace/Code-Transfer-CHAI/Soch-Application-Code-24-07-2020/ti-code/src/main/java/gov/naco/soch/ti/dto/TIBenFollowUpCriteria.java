package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link gov.naco.soch.domain.TIBenFollowUp} entity. This class is used
 * in {@link gov.naco.soch.web.rest.TIBenFollowUpResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ti-ben-follow-ups?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class TIBenFollowUpCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;
    
    private LongFilter facilityId;

    private StringFilter followUpType;

    private LocalDateFilter followUpDate;

    private LocalDateFilter nextFollowupDate;

    private StringFilter followUpBy;

    private StringFilter primaryDrug;

    private StringFilter frequencyOfPrimaryDrugUse;

    private StringFilter lastDoseOfPrimaryDrug;

    private StringFilter otherDrug;

    private StringFilter frequencyOfOtherDrugUse;

    private StringFilter lastDoseOfOtherDrug;

    private StringFilter followUpReasonOther;

    private BooleanFilter doseStabilization;

    private BooleanFilter familyIssues;

    private BooleanFilter maritalIssue;

    private BooleanFilter occupationIssue;

    private BooleanFilter groupTherapy;

    private BooleanFilter cognitiveBehaviorTherapy;

    private BooleanFilter hostileAttitudeWithStaff;

    private BooleanFilter sideEffects;

    private BooleanFilter withdrawalSymptoms;

    private BooleanFilter noSideEffects;

    private BooleanFilter sedation;

    private BooleanFilter headaches;

    private BooleanFilter blurredVision;

    private BooleanFilter incoordination;

    private BooleanFilter oralUlceration;

    private BooleanFilter diplopia;

    private BooleanFilter confusion;

    private BooleanFilter hallucination;

    private BooleanFilter slurredSpeech;

    private BooleanFilter constipation;

    private BooleanFilter giddiness;

    private BooleanFilter lightHeadedness;

    private BooleanFilter drowsiness;

    private BooleanFilter itching;

    private BooleanFilter weakness;

    private StringFilter otherSideEffects;

    private BooleanFilter updatePrescription;

    private StringFilter substitutionDrug;

    private StringFilter dosage;

    private StringFilter dosageMeasureUnit;

    private LongFilter beneficiaryId;
    
    private StringFilter clientStatus;
    
    private StringFilter param;
    
    private StringFilter uid;
    
    private StringFilter ostNo;
    
    private StringFilter mobile;
    
    private StringFilter name;
    
    private LocalDateFilter date;
    
    private StringFilter drug;
    
    private LongFilter ostStatus;
    
    private BooleanFilter isDelete;
	
     private BooleanFilter isActiveFacility;
	
      private LongFilter status;
      
      private BooleanFilter isEarly;

    public TIBenFollowUpCriteria(){
    }

    public TIBenFollowUpCriteria(TIBenFollowUpCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.followUpType = other.followUpType == null ? null : other.followUpType.copy();
        this.followUpDate = other.followUpDate == null ? null : other.followUpDate.copy();
        this.nextFollowupDate = other.nextFollowupDate == null ? null : other.nextFollowupDate.copy();
        this.followUpBy = other.followUpBy == null ? null : other.followUpBy.copy();
        this.primaryDrug = other.primaryDrug == null ? null : other.primaryDrug.copy();
        this.frequencyOfPrimaryDrugUse = other.frequencyOfPrimaryDrugUse == null ? null : other.frequencyOfPrimaryDrugUse.copy();
        this.lastDoseOfPrimaryDrug = other.lastDoseOfPrimaryDrug == null ? null : other.lastDoseOfPrimaryDrug.copy();
        this.otherDrug = other.otherDrug == null ? null : other.otherDrug.copy();
        this.frequencyOfOtherDrugUse = other.frequencyOfOtherDrugUse == null ? null : other.frequencyOfOtherDrugUse.copy();
        this.lastDoseOfOtherDrug = other.lastDoseOfOtherDrug == null ? null : other.lastDoseOfOtherDrug.copy();
        this.followUpReasonOther = other.followUpReasonOther == null ? null : other.followUpReasonOther.copy();
        this.doseStabilization = other.doseStabilization == null ? null : other.doseStabilization.copy();
        this.familyIssues = other.familyIssues == null ? null : other.familyIssues.copy();
        this.maritalIssue = other.maritalIssue == null ? null : other.maritalIssue.copy();
        this.occupationIssue = other.occupationIssue == null ? null : other.occupationIssue.copy();
        this.groupTherapy = other.groupTherapy == null ? null : other.groupTherapy.copy();
        this.cognitiveBehaviorTherapy = other.cognitiveBehaviorTherapy == null ? null : other.cognitiveBehaviorTherapy.copy();
        this.hostileAttitudeWithStaff = other.hostileAttitudeWithStaff == null ? null : other.hostileAttitudeWithStaff.copy();
        this.sideEffects = other.sideEffects == null ? null : other.sideEffects.copy();
        this.withdrawalSymptoms = other.withdrawalSymptoms == null ? null : other.withdrawalSymptoms.copy();
        this.noSideEffects = other.noSideEffects == null ? null : other.noSideEffects.copy();
        this.sedation = other.sedation == null ? null : other.sedation.copy();
        this.headaches = other.headaches == null ? null : other.headaches.copy();
        this.blurredVision = other.blurredVision == null ? null : other.blurredVision.copy();
        this.incoordination = other.incoordination == null ? null : other.incoordination.copy();
        this.oralUlceration = other.oralUlceration == null ? null : other.oralUlceration.copy();
        this.diplopia = other.diplopia == null ? null : other.diplopia.copy();
        this.confusion = other.confusion == null ? null : other.confusion.copy();
        this.hallucination = other.hallucination == null ? null : other.hallucination.copy();
        this.slurredSpeech = other.slurredSpeech == null ? null : other.slurredSpeech.copy();
        this.constipation = other.constipation == null ? null : other.constipation.copy();
        this.giddiness = other.giddiness == null ? null : other.giddiness.copy();
        this.lightHeadedness = other.lightHeadedness == null ? null : other.lightHeadedness.copy();
        this.drowsiness = other.drowsiness == null ? null : other.drowsiness.copy();
        this.itching = other.itching == null ? null : other.itching.copy();
        this.weakness = other.weakness == null ? null : other.weakness.copy();
        this.otherSideEffects = other.otherSideEffects == null ? null : other.otherSideEffects.copy();
        this.updatePrescription = other.updatePrescription == null ? null : other.updatePrescription.copy();
        this.substitutionDrug = other.substitutionDrug == null ? null : other.substitutionDrug.copy();
        this.dosage = other.dosage == null ? null : other.dosage.copy();
        this.dosageMeasureUnit = other.dosageMeasureUnit == null ? null : other.dosageMeasureUnit.copy();
        this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
        this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
        this.clientStatus = other.clientStatus == null ? null : other.clientStatus.copy();
        this.param = other.param == null ? null : other.param.copy();
        this.uid = other.uid == null ? null : other.uid.copy();
        this.ostNo = other.ostNo == null ? null : other.ostNo.copy();
        this.mobile = other.mobile == null ? null : other.mobile.copy();
        this.name = other.name == null ? null : other.name.copy();
        this.date = other.date == null ? null : other.date.copy();
        this.drug = other.drug == null ? null : other.drug.copy();
        this.ostStatus=other.ostStatus==null?null:other.ostStatus.copy();
        this.isDelete = other.isDelete == null ? null : other.isDelete.copy();
        this.isActiveFacility=other.isActiveFacility==null?null:other.isActiveFacility.copy();
        this.status=other.status==null?null:other.status.copy();
        this.isEarly=other.isEarly==null?null:other.isEarly.copy();
    }

    @Override
    public TIBenFollowUpCriteria copy() {
        return new TIBenFollowUpCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public LongFilter getOstStatus() {
		return ostStatus;
	}

	public void setOstStatus(LongFilter ostStatus) {
		this.ostStatus = ostStatus;
	}

	public StringFilter getFollowUpType() {
        return followUpType;
    }

    public void setFollowUpType(StringFilter followUpType) {
        this.followUpType = followUpType;
    }

    public BooleanFilter getIsEarly() {
        return isEarly;
    }

    public void setIsEarly(BooleanFilter isEarly) {
        this.isEarly = isEarly;
    }

    public LocalDateFilter getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(LocalDateFilter followUpDate) {
        this.followUpDate = followUpDate;
    }

    public LocalDateFilter getNextFollowupDate() {
        return nextFollowupDate;
    }

    public void setNextFollowupDate(LocalDateFilter nextFollowupDate) {
        this.nextFollowupDate = nextFollowupDate;
    }

    public StringFilter getFollowUpBy() {
        return followUpBy;
    }

    public void setFollowUpBy(StringFilter followUpBy) {
        this.followUpBy = followUpBy;
    }

    public StringFilter getPrimaryDrug() {
        return primaryDrug;
    }

    public void setPrimaryDrug(StringFilter primaryDrug) {
        this.primaryDrug = primaryDrug;
    }

    public StringFilter getFrequencyOfPrimaryDrugUse() {
        return frequencyOfPrimaryDrugUse;
    }

    public void setFrequencyOfPrimaryDrugUse(StringFilter frequencyOfPrimaryDrugUse) {
        this.frequencyOfPrimaryDrugUse = frequencyOfPrimaryDrugUse;
    }

    public StringFilter getLastDoseOfPrimaryDrug() {
        return lastDoseOfPrimaryDrug;
    }

    public void setLastDoseOfPrimaryDrug(StringFilter lastDoseOfPrimaryDrug) {
        this.lastDoseOfPrimaryDrug = lastDoseOfPrimaryDrug;
    }

    public StringFilter getOtherDrug() {
        return otherDrug;
    }

    public void setOtherDrug(StringFilter otherDrug) {
        this.otherDrug = otherDrug;
    }

    public StringFilter getFrequencyOfOtherDrugUse() {
        return frequencyOfOtherDrugUse;
    }

    public void setFrequencyOfOtherDrugUse(StringFilter frequencyOfOtherDrugUse) {
        this.frequencyOfOtherDrugUse = frequencyOfOtherDrugUse;
    }

    public StringFilter getLastDoseOfOtherDrug() {
        return lastDoseOfOtherDrug;
    }

    public void setLastDoseOfOtherDrug(StringFilter lastDoseOfOtherDrug) {
        this.lastDoseOfOtherDrug = lastDoseOfOtherDrug;
    }

    public StringFilter getFollowUpReasonOther() {
        return followUpReasonOther;
    }

    public void setFollowUpReasonOther(StringFilter followUpReasonOther) {
        this.followUpReasonOther = followUpReasonOther;
    }

    public BooleanFilter getDoseStabilization() {
        return doseStabilization;
    }

    public void setDoseStabilization(BooleanFilter doseStabilization) {
        this.doseStabilization = doseStabilization;
    }

    public BooleanFilter getFamilyIssues() {
        return familyIssues;
    }

    public void setFamilyIssues(BooleanFilter familyIssues) {
        this.familyIssues = familyIssues;
    }

    public BooleanFilter getMaritalIssue() {
        return maritalIssue;
    }

    public void setMaritalIssue(BooleanFilter maritalIssue) {
        this.maritalIssue = maritalIssue;
    }

    public BooleanFilter getOccupationIssue() {
        return occupationIssue;
    }

    public void setOccupationIssue(BooleanFilter occupationIssue) {
        this.occupationIssue = occupationIssue;
    }

    public BooleanFilter getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(BooleanFilter isDelete) {
		this.isDelete = isDelete;
	}

	public BooleanFilter getGroupTherapy() {
        return groupTherapy;
    }

    public void setGroupTherapy(BooleanFilter groupTherapy) {
        this.groupTherapy = groupTherapy;
    }

    public BooleanFilter getCognitiveBehaviorTherapy() {
        return cognitiveBehaviorTherapy;
    }

    public void setCognitiveBehaviorTherapy(BooleanFilter cognitiveBehaviorTherapy) {
        this.cognitiveBehaviorTherapy = cognitiveBehaviorTherapy;
    }

    public BooleanFilter getHostileAttitudeWithStaff() {
        return hostileAttitudeWithStaff;
    }

    public void setHostileAttitudeWithStaff(BooleanFilter hostileAttitudeWithStaff) {
        this.hostileAttitudeWithStaff = hostileAttitudeWithStaff;
    }

    public BooleanFilter getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(BooleanFilter sideEffects) {
        this.sideEffects = sideEffects;
    }

    public BooleanFilter getWithdrawalSymptoms() {
        return withdrawalSymptoms;
    }

    public void setWithdrawalSymptoms(BooleanFilter withdrawalSymptoms) {
        this.withdrawalSymptoms = withdrawalSymptoms;
    }

    public BooleanFilter getNoSideEffects() {
        return noSideEffects;
    }

    public void setNoSideEffects(BooleanFilter noSideEffects) {
        this.noSideEffects = noSideEffects;
    }

    public BooleanFilter getSedation() {
        return sedation;
    }

    public void setSedation(BooleanFilter sedation) {
        this.sedation = sedation;
    }

    public BooleanFilter getHeadaches() {
        return headaches;
    }

    public void setHeadaches(BooleanFilter headaches) {
        this.headaches = headaches;
    }

    public BooleanFilter getBlurredVision() {
        return blurredVision;
    }

    public void setBlurredVision(BooleanFilter blurredVision) {
        this.blurredVision = blurredVision;
    }

    public BooleanFilter getIncoordination() {
        return incoordination;
    }

    public void setIncoordination(BooleanFilter incoordination) {
        this.incoordination = incoordination;
    }

    public BooleanFilter getOralUlceration() {
        return oralUlceration;
    }

    public void setOralUlceration(BooleanFilter oralUlceration) {
        this.oralUlceration = oralUlceration;
    }

    public BooleanFilter getDiplopia() {
        return diplopia;
    }

    public void setDiplopia(BooleanFilter diplopia) {
        this.diplopia = diplopia;
    }

    public BooleanFilter getConfusion() {
        return confusion;
    }

    public void setConfusion(BooleanFilter confusion) {
        this.confusion = confusion;
    }

    public BooleanFilter getHallucination() {
        return hallucination;
    }

    public void setHallucination(BooleanFilter hallucination) {
        this.hallucination = hallucination;
    }

    public BooleanFilter getSlurredSpeech() {
        return slurredSpeech;
    }

    public void setSlurredSpeech(BooleanFilter slurredSpeech) {
        this.slurredSpeech = slurredSpeech;
    }

    public BooleanFilter getConstipation() {
        return constipation;
    }

    public void setConstipation(BooleanFilter constipation) {
        this.constipation = constipation;
    }

    public BooleanFilter getGiddiness() {
        return giddiness;
    }

    public void setGiddiness(BooleanFilter giddiness) {
        this.giddiness = giddiness;
    }

    public LongFilter getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(LongFilter facilityId) {
		this.facilityId = facilityId;
	}

	public BooleanFilter getLightHeadedness() {
        return lightHeadedness;
    }

    public void setLightHeadedness(BooleanFilter lightHeadedness) {
        this.lightHeadedness = lightHeadedness;
    }

    public BooleanFilter getDrowsiness() {
        return drowsiness;
    }

    public void setDrowsiness(BooleanFilter drowsiness) {
        this.drowsiness = drowsiness;
    }

    public BooleanFilter getItching() {
        return itching;
    }

    public void setItching(BooleanFilter itching) {
        this.itching = itching;
    }

    public BooleanFilter getWeakness() {
        return weakness;
    }

    public void setWeakness(BooleanFilter weakness) {
        this.weakness = weakness;
    }

    public StringFilter getOtherSideEffects() {
        return otherSideEffects;
    }

    public void setOtherSideEffects(StringFilter otherSideEffects) {
        this.otherSideEffects = otherSideEffects;
    }

    public BooleanFilter getUpdatePrescription() {
        return updatePrescription;
    }

    public void setUpdatePrescription(BooleanFilter updatePrescription) {
        this.updatePrescription = updatePrescription;
    }

    public StringFilter getSubstitutionDrug() {
        return substitutionDrug;
    }

    public void setSubstitutionDrug(StringFilter substitutionDrug) {
        this.substitutionDrug = substitutionDrug;
    }

    public StringFilter getDosage() {
        return dosage;
    }

    public void setDosage(StringFilter dosage) {
        this.dosage = dosage;
    }

    public StringFilter getDosageMeasureUnit() {
        return dosageMeasureUnit;
    }

    public void setDosageMeasureUnit(StringFilter dosageMeasureUnit) {
        this.dosageMeasureUnit = dosageMeasureUnit;
    }

    public LongFilter getStatus() {
	return status;
    }

    public void setStatus(LongFilter status) {
	this.status = status;
    }

    public LongFilter getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(LongFilter beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }
    
    public BooleanFilter getIsActiveFacility() {
		return isActiveFacility;
	}

	public void setIsActiveFacility(BooleanFilter isActiveFacility) {
		this.isActiveFacility = isActiveFacility;
	}

	public StringFilter getClientStatus() {
		return clientStatus;
	}

	public void setClientStatus(StringFilter clientStatus) {
		this.clientStatus = clientStatus;
	}
	public StringFilter getParam() {
		return param;
	}

	public void setParam(StringFilter param) {
		this.param = param;
	}

	public StringFilter getUid() {
		return uid;
	}

	public void setUid(StringFilter uid) {
		this.uid = uid;
	}

	public StringFilter getOstNo() {
		return ostNo;
	}

	public void setOstNo(StringFilter ostNo) {
		this.ostNo = ostNo;
	}

	public StringFilter getMobile() {
		return mobile;
	}

	public void setMobile(StringFilter mobile) {
		this.mobile = mobile;
	}

	public StringFilter getName() {
		return name;
	}

	public void setName(StringFilter name) {
		this.name = name;
	}

	public LocalDateFilter getDate() {
		return date;
	}

	public void setDate(LocalDateFilter date) {
		this.date = date;
	}

	public StringFilter getDrug() {
		return drug;
	}

	public void setDrug(StringFilter drug) {
		this.drug = drug;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final TIBenFollowUpCriteria that = (TIBenFollowUpCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(followUpType, that.followUpType) &&
            Objects.equals(followUpDate, that.followUpDate) &&
            Objects.equals(nextFollowupDate, that.nextFollowupDate) &&
            Objects.equals(followUpBy, that.followUpBy) &&
            Objects.equals(primaryDrug, that.primaryDrug) &&
            Objects.equals(frequencyOfPrimaryDrugUse, that.frequencyOfPrimaryDrugUse) &&
            Objects.equals(lastDoseOfPrimaryDrug, that.lastDoseOfPrimaryDrug) &&
            Objects.equals(otherDrug, that.otherDrug) &&
            Objects.equals(frequencyOfOtherDrugUse, that.frequencyOfOtherDrugUse) &&
            Objects.equals(lastDoseOfOtherDrug, that.lastDoseOfOtherDrug) &&
            Objects.equals(followUpReasonOther, that.followUpReasonOther) &&
            Objects.equals(doseStabilization, that.doseStabilization) &&
            Objects.equals(familyIssues, that.familyIssues) &&
            Objects.equals(maritalIssue, that.maritalIssue) &&
            Objects.equals(occupationIssue, that.occupationIssue) &&
            Objects.equals(groupTherapy, that.groupTherapy) &&
            Objects.equals(cognitiveBehaviorTherapy, that.cognitiveBehaviorTherapy) &&
            Objects.equals(hostileAttitudeWithStaff, that.hostileAttitudeWithStaff) &&
            Objects.equals(sideEffects, that.sideEffects) &&
            Objects.equals(withdrawalSymptoms, that.withdrawalSymptoms) &&
            Objects.equals(noSideEffects, that.noSideEffects) &&
            Objects.equals(sedation, that.sedation) &&
            Objects.equals(headaches, that.headaches) &&
            Objects.equals(blurredVision, that.blurredVision) &&
            Objects.equals(incoordination, that.incoordination) &&
            Objects.equals(oralUlceration, that.oralUlceration) &&
            Objects.equals(diplopia, that.diplopia) &&
            Objects.equals(confusion, that.confusion) &&
            Objects.equals(hallucination, that.hallucination) &&
            Objects.equals(slurredSpeech, that.slurredSpeech) &&
            Objects.equals(constipation, that.constipation) &&
            Objects.equals(giddiness, that.giddiness) &&
            Objects.equals(lightHeadedness, that.lightHeadedness) &&
            Objects.equals(drowsiness, that.drowsiness) &&
            Objects.equals(itching, that.itching) &&
            Objects.equals(weakness, that.weakness) &&
            Objects.equals(otherSideEffects, that.otherSideEffects) &&
            Objects.equals(updatePrescription, that.updatePrescription) &&
            Objects.equals(substitutionDrug, that.substitutionDrug) &&
            Objects.equals(dosage, that.dosage) &&
            Objects.equals(dosageMeasureUnit, that.dosageMeasureUnit) &&
            Objects.equals(facilityId, that.facilityId)&&
            Objects.equals(clientStatus, that.clientStatus)&&
            Objects.equals(beneficiaryId, that.beneficiaryId)&&
            Objects.equals(param, that.param)&&
        	Objects.equals(uid, that.uid)&&
        	Objects.equals(ostNo, that.ostNo)&&
        	Objects.equals(mobile, that.mobile)&&
        	Objects.equals(name, that.name)&&
        	Objects.equals(date, that.date)&&
        	Objects.equals(ostStatus, that.ostStatus)&&
        	Objects.equals(isDelete, that.isDelete)&&
        	Objects.equals(isActiveFacility, that.isActiveFacility)&&
        	Objects.equals(status, that.status)&&
        	Objects.equals(isEarly, that.isEarly)&&
        	Objects.equals(drug, that.drug);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        followUpType,
        followUpDate,
        nextFollowupDate,
        followUpBy,
        primaryDrug,
        frequencyOfPrimaryDrugUse,
        lastDoseOfPrimaryDrug,
        otherDrug,
        frequencyOfOtherDrugUse,
        lastDoseOfOtherDrug,
        followUpReasonOther,
        doseStabilization,
        familyIssues,
        maritalIssue,
        occupationIssue,
        groupTherapy,
        cognitiveBehaviorTherapy,
        hostileAttitudeWithStaff,
        sideEffects,
        withdrawalSymptoms,
        noSideEffects,
        sedation,
        headaches,
        blurredVision,
        incoordination,
        oralUlceration,
        diplopia,
        confusion,
        hallucination,
        isDelete,
        slurredSpeech,
        constipation,
        giddiness,
        lightHeadedness,
        drowsiness,
        itching,
        weakness,
        isEarly,
        otherSideEffects,
        updatePrescription,
        substitutionDrug,
        dosage,
        dosageMeasureUnit,
        facilityId,
        beneficiaryId,
        clientStatus,
        param,
        uid,
        ostNo,
        mobile,
        name,
        date,
        ostStatus,
        isActiveFacility,
        status,
        drug
        );
    }

	@Override
	public String toString() {
		return "TIBenFollowUpCriteria [id=" + id + ", facilityId=" + facilityId + ", followUpType=" + followUpType
				+ ", followUpDate=" + followUpDate + ", nextFollowupDate=" + nextFollowupDate + ", followUpBy="
				+ followUpBy + ", primaryDrug=" + primaryDrug + ", frequencyOfPrimaryDrugUse="
				+ frequencyOfPrimaryDrugUse + ", lastDoseOfPrimaryDrug=" + lastDoseOfPrimaryDrug + ", otherDrug="
				+ otherDrug + ", frequencyOfOtherDrugUse=" + frequencyOfOtherDrugUse + ", lastDoseOfOtherDrug="
				+ lastDoseOfOtherDrug + ", followUpReasonOther=" + followUpReasonOther + ", doseStabilization="
				+ doseStabilization + ", familyIssues=" + familyIssues + ", maritalIssue=" + maritalIssue
				+ ", occupationIssue=" + occupationIssue + ", groupTherapy=" + groupTherapy
				+ ", cognitiveBehaviorTherapy=" + cognitiveBehaviorTherapy + ", hostileAttitudeWithStaff="
				+ hostileAttitudeWithStaff + ", sideEffects=" + sideEffects + ", withdrawalSymptoms="
				+ withdrawalSymptoms + ", noSideEffects=" + noSideEffects + ", sedation=" + sedation + ", headaches="
				+ headaches + ", blurredVision=" + blurredVision + ", incoordination=" + incoordination
				+ ", oralUlceration=" + oralUlceration + ", diplopia=" + diplopia + ", confusion=" + confusion
				+ ", hallucination=" + hallucination + ", slurredSpeech=" + slurredSpeech + ", constipation="
				+ constipation + ", giddiness=" + giddiness + ", lightHeadedness=" + lightHeadedness + ", drowsiness="
				+ drowsiness + ", itching=" + itching + ", weakness=" + weakness + ", otherSideEffects="
				+ otherSideEffects + ", updatePrescription=" + updatePrescription + ", substitutionDrug="
				+ substitutionDrug + ", dosage=" + dosage + ", dosageMeasureUnit=" + dosageMeasureUnit
				+ ", beneficiaryId=" + beneficiaryId 
				+ ", param=" + param 
				+ ", uid=" + uid 
				+ ", ostNo=" + ostNo 
				+ ", mobile=" + mobile 
				+ ", name=" + name 
				+ ", date=" + date 
				+ ", drug=" + drug +"]";
	}

  
}
