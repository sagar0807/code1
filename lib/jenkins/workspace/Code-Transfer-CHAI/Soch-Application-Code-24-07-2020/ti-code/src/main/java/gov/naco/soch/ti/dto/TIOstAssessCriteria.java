package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link gov.naco.soch.domain.TIOstAssess} entity. This
 * class is used in {@link gov.naco.soch.web.rest.TIOstAssessResource} to
 * receive all the possible filtering options from the Http GET request
 * parameters. For example the following could be a valid request:
 * {@code /ti-ost-assesses?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific
 * {@link Filter} class are used, we need to use fix type specific filters.
 */
public class TIOstAssessCriteria implements Serializable, Criteria {

	private static final long serialVersionUID = 1L;

	private LongFilter id;

	private LongFilter facilityId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateFilter dateOfAssessment;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateFilter nextDateOfAssessment;

	private StringFilter chooseDrug;

	private IntegerFilter ageAtOnset;

	private IntegerFilter noYearsInUse;

	private BooleanFilter injectingRoute;

	private BooleanFilter dependence;

	private BooleanFilter useInLastOneMonth;

	private StringFilter complicationsWithDrugUse;

	private BooleanFilter isNeedlesAndSyringesShared;

	private BooleanFilter isNeedlesAndSyringesSharedLastOccasion;

	private BooleanFilter isOtherParaphernaliaSharedLastOccasion;

	private BooleanFilter isOtherParaphernaliaSharedEver;

	private IntegerFilter noOfSexualPartners;

	private LocalDateFilter lastSexualEncounter;

	private BooleanFilter isAbstinenceAttemptedPreviously;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateFilter timePeriodForAbstinence;

	private IntegerFilter durationOfAbstinence;

	private StringFilter typeOfHelpOrIntervention;

	private StringFilter currentLivingArrangement;

	private IntegerFilter pulseRate;

	private IntegerFilter bloodPressureSystolic;

	private IntegerFilter bloodPressureDiastolic;

	private IntegerFilter respiratoryRate;

	private IntegerFilter weight;

	private IntegerFilter temperature;

	private BooleanFilter cyanosis;

	private BooleanFilter jaundice;

	private BooleanFilter oedema;

	private BooleanFilter clubbing;

	private BooleanFilter lymphadenopathy;

	private StringFilter skinIdentificationMark;

	private StringFilter needleMarks;

	private StringFilter abscess;

	private StringFilter openWounds;

	private StringFilter chest;

	private StringFilter abdomen;

	private StringFilter neurologicalExamination;

	private StringFilter diagnosis;

	private StringFilter advice;

	private BooleanFilter initiateOST;

	private BooleanFilter consentTaken;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateFilter consentTakenDate;

	private StringFilter substitutionDrug;

	private StringFilter dosage;

	private StringFilter measureOfUnit;

	private IntegerFilter createdBy;

	private ZonedDateTimeFilter createdTime;

	private IntegerFilter modifiedBy;

	private ZonedDateTimeFilter modifiedTime;

	private IntegerFilter abstinenceDuration;

	private IntegerFilter abstinenceAttempts;

	private StringFilter abstinenceReason;

	private LongFilter beneficiaryId;

	private StringFilter clientStatus;

	private StringFilter param;

	private StringFilter ostNumber;

	private BooleanFilter isDelete;
	
	private BooleanFilter isActiveFacility;
	
	private LongFilter status;

	public TIOstAssessCriteria() {
	}

	public TIOstAssessCriteria(TIOstAssessCriteria other) {
		this.id = other.id == null ? null : other.id.copy();
		this.dateOfAssessment = other.dateOfAssessment == null ? null : other.dateOfAssessment.copy();
		this.nextDateOfAssessment = other.nextDateOfAssessment == null ? null : other.nextDateOfAssessment.copy();
		this.chooseDrug = other.chooseDrug == null ? null : other.chooseDrug.copy();
		this.ageAtOnset = other.ageAtOnset == null ? null : other.ageAtOnset.copy();
		this.noYearsInUse = other.noYearsInUse == null ? null : other.noYearsInUse.copy();
		this.injectingRoute = other.injectingRoute == null ? null : other.injectingRoute.copy();
		this.dependence = other.dependence == null ? null : other.dependence.copy();
		this.useInLastOneMonth = other.useInLastOneMonth == null ? null : other.useInLastOneMonth.copy();
		this.complicationsWithDrugUse = other.complicationsWithDrugUse == null ? null
				: other.complicationsWithDrugUse.copy();
		this.isNeedlesAndSyringesShared = other.isNeedlesAndSyringesShared == null ? null
				: other.isNeedlesAndSyringesShared.copy();
		this.isNeedlesAndSyringesSharedLastOccasion = other.isNeedlesAndSyringesSharedLastOccasion == null ? null
				: other.isNeedlesAndSyringesSharedLastOccasion.copy();
		this.isOtherParaphernaliaSharedLastOccasion = other.isOtherParaphernaliaSharedLastOccasion == null ? null
				: other.isOtherParaphernaliaSharedLastOccasion.copy();
		this.isOtherParaphernaliaSharedEver = other.isOtherParaphernaliaSharedEver == null ? null
				: other.isOtherParaphernaliaSharedEver.copy();
		this.noOfSexualPartners = other.noOfSexualPartners == null ? null : other.noOfSexualPartners.copy();
		this.lastSexualEncounter = other.lastSexualEncounter == null ? null : other.lastSexualEncounter.copy();
		this.isAbstinenceAttemptedPreviously = other.isAbstinenceAttemptedPreviously == null ? null
				: other.isAbstinenceAttemptedPreviously.copy();
		this.timePeriodForAbstinence = other.timePeriodForAbstinence == null ? null
				: other.timePeriodForAbstinence.copy();
		this.durationOfAbstinence = other.durationOfAbstinence == null ? null : other.durationOfAbstinence.copy();
		this.typeOfHelpOrIntervention = other.typeOfHelpOrIntervention == null ? null
				: other.typeOfHelpOrIntervention.copy();
		this.currentLivingArrangement = other.currentLivingArrangement == null ? null
				: other.currentLivingArrangement.copy();
		this.pulseRate = other.pulseRate == null ? null : other.pulseRate.copy();
		this.bloodPressureSystolic = other.bloodPressureSystolic == null ? null : other.bloodPressureSystolic.copy();
		this.bloodPressureDiastolic = other.bloodPressureDiastolic == null ? null : other.bloodPressureDiastolic.copy();
		this.respiratoryRate = other.respiratoryRate == null ? null : other.respiratoryRate.copy();
		this.weight = other.weight == null ? null : other.weight.copy();
		this.temperature = other.temperature == null ? null : other.temperature.copy();
		this.cyanosis = other.cyanosis == null ? null : other.cyanosis.copy();
		this.jaundice = other.jaundice == null ? null : other.jaundice.copy();
		this.oedema = other.oedema == null ? null : other.oedema.copy();
		this.clubbing = other.clubbing == null ? null : other.clubbing.copy();
		this.lymphadenopathy = other.lymphadenopathy == null ? null : other.lymphadenopathy.copy();
		this.skinIdentificationMark = other.skinIdentificationMark == null ? null : other.skinIdentificationMark.copy();
		this.needleMarks = other.needleMarks == null ? null : other.needleMarks.copy();
		this.abscess = other.abscess == null ? null : other.abscess.copy();
		this.openWounds = other.openWounds == null ? null : other.openWounds.copy();
		this.chest = other.chest == null ? null : other.chest.copy();
		this.abdomen = other.abdomen == null ? null : other.abdomen.copy();
		this.neurologicalExamination = other.neurologicalExamination == null ? null
				: other.neurologicalExamination.copy();
		this.diagnosis = other.diagnosis == null ? null : other.diagnosis.copy();
		this.advice = other.advice == null ? null : other.advice.copy();
		this.initiateOST = other.initiateOST == null ? null : other.initiateOST.copy();
		this.consentTaken = other.consentTaken == null ? null : other.consentTaken.copy();
		this.consentTakenDate = other.consentTakenDate == null ? null : other.consentTakenDate.copy();
		this.substitutionDrug = other.substitutionDrug == null ? null : other.substitutionDrug.copy();
		this.dosage = other.dosage == null ? null : other.dosage.copy();
		this.measureOfUnit = other.measureOfUnit == null ? null : other.measureOfUnit.copy();
		this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
		this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
		this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
		this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
		this.abstinenceDuration = other.abstinenceDuration == null ? null : other.abstinenceDuration.copy();
		this.abstinenceAttempts = other.abstinenceAttempts == null ? null : other.abstinenceAttempts.copy();
		this.abstinenceReason = other.abstinenceReason == null ? null : other.abstinenceReason.copy();
		this.beneficiaryId = other.beneficiaryId == null ? null : other.beneficiaryId.copy();
		this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
		this.clientStatus = other.clientStatus == null ? null : other.clientStatus.copy();
		this.param = other.param == null ? null : other.param.copy();
		this.ostNumber = other.ostNumber == null ? null : other.ostNumber.copy();
		this.isDelete = other.isDelete == null ? null : other.isDelete.copy();
		this.isActiveFacility=other.isActiveFacility==null?null:other.isActiveFacility.copy();
		this.status=other.status==null?null:other.status.copy();
	}

	public StringFilter getOstNumber() {
		return ostNumber;
	}

	public void setOstNumber(StringFilter ostNumber) {
		this.ostNumber = ostNumber;
	}

	@Override
	public TIOstAssessCriteria copy() {
		return new TIOstAssessCriteria(this);
	}

	public LongFilter getId() {
		return id;
	}

	public void setId(LongFilter id) {
		this.id = id;
	}

	public LocalDateFilter getDateOfAssessment() {
		return dateOfAssessment;
	}

	public void setDateOfAssessment(LocalDateFilter dateOfAssessment) {
		this.dateOfAssessment = dateOfAssessment;
	}

	public LocalDateFilter getNextDateOfAssessment() {
		return nextDateOfAssessment;
	}

	public void setNextDateOfAssessment(LocalDateFilter nextDateOfAssessment) {
		this.nextDateOfAssessment = nextDateOfAssessment;
	}

	public StringFilter getChooseDrug() {
		return chooseDrug;
	}

	public void setChooseDrug(StringFilter chooseDrug) {
		this.chooseDrug = chooseDrug;
	}

	public IntegerFilter getAgeAtOnset() {
		return ageAtOnset;
	}

	public void setAgeAtOnset(IntegerFilter ageAtOnset) {
		this.ageAtOnset = ageAtOnset;
	}

	public StringFilter getParam() {
		return param;
	}

	public void setParam(StringFilter param) {
		this.param = param;
	}

	public IntegerFilter getNoYearsInUse() {
		return noYearsInUse;
	}

	public void setNoYearsInUse(IntegerFilter noYearsInUse) {
		this.noYearsInUse = noYearsInUse;
	}

	public BooleanFilter getInjectingRoute() {
		return injectingRoute;
	}

	public void setInjectingRoute(BooleanFilter injectingRoute) {
		this.injectingRoute = injectingRoute;
	}

	public BooleanFilter getDependence() {
		return dependence;
	}

	public void setDependence(BooleanFilter dependence) {
		this.dependence = dependence;
	}

	public BooleanFilter getUseInLastOneMonth() {
		return useInLastOneMonth;
	}

	public void setUseInLastOneMonth(BooleanFilter useInLastOneMonth) {
		this.useInLastOneMonth = useInLastOneMonth;
	}

	public StringFilter getComplicationsWithDrugUse() {
		return complicationsWithDrugUse;
	}

	public void setComplicationsWithDrugUse(StringFilter complicationsWithDrugUse) {
		this.complicationsWithDrugUse = complicationsWithDrugUse;
	}

	public BooleanFilter getIsNeedlesAndSyringesShared() {
		return isNeedlesAndSyringesShared;
	}

	public void setIsNeedlesAndSyringesShared(BooleanFilter isNeedlesAndSyringesShared) {
		this.isNeedlesAndSyringesShared = isNeedlesAndSyringesShared;
	}

	public BooleanFilter getIsNeedlesAndSyringesSharedLastOccasion() {
		return isNeedlesAndSyringesSharedLastOccasion;
	}

	public void setIsNeedlesAndSyringesSharedLastOccasion(BooleanFilter isNeedlesAndSyringesSharedLastOccasion) {
		this.isNeedlesAndSyringesSharedLastOccasion = isNeedlesAndSyringesSharedLastOccasion;
	}

	public BooleanFilter getIsOtherParaphernaliaSharedLastOccasion() {
		return isOtherParaphernaliaSharedLastOccasion;
	}

	public void setIsOtherParaphernaliaSharedLastOccasion(BooleanFilter isOtherParaphernaliaSharedLastOccasion) {
		this.isOtherParaphernaliaSharedLastOccasion = isOtherParaphernaliaSharedLastOccasion;
	}

	public BooleanFilter getIsOtherParaphernaliaSharedEver() {
		return isOtherParaphernaliaSharedEver;
	}

	public void setIsOtherParaphernaliaSharedEver(BooleanFilter isOtherParaphernaliaSharedEver) {
		this.isOtherParaphernaliaSharedEver = isOtherParaphernaliaSharedEver;
	}

	public IntegerFilter getNoOfSexualPartners() {
		return noOfSexualPartners;
	}

	public void setNoOfSexualPartners(IntegerFilter noOfSexualPartners) {
		this.noOfSexualPartners = noOfSexualPartners;
	}

	public LocalDateFilter getLastSexualEncounter() {
		return lastSexualEncounter;
	}

	public void setLastSexualEncounter(LocalDateFilter lastSexualEncounter) {
		this.lastSexualEncounter = lastSexualEncounter;
	}

	public BooleanFilter getIsAbstinenceAttemptedPreviously() {
		return isAbstinenceAttemptedPreviously;
	}

	public void setIsAbstinenceAttemptedPreviously(BooleanFilter isAbstinenceAttemptedPreviously) {
		this.isAbstinenceAttemptedPreviously = isAbstinenceAttemptedPreviously;
	}

	public LocalDateFilter getTimePeriodForAbstinence() {
		return timePeriodForAbstinence;
	}

	public void setTimePeriodForAbstinence(LocalDateFilter timePeriodForAbstinence) {
		this.timePeriodForAbstinence = timePeriodForAbstinence;
	}

	public IntegerFilter getDurationOfAbstinence() {
		return durationOfAbstinence;
	}

	public void setDurationOfAbstinence(IntegerFilter durationOfAbstinence) {
		this.durationOfAbstinence = durationOfAbstinence;
	}

	public StringFilter getTypeOfHelpOrIntervention() {
		return typeOfHelpOrIntervention;
	}

	public void setTypeOfHelpOrIntervention(StringFilter typeOfHelpOrIntervention) {
		this.typeOfHelpOrIntervention = typeOfHelpOrIntervention;
	}

	public StringFilter getCurrentLivingArrangement() {
		return currentLivingArrangement;
	}

	public void setCurrentLivingArrangement(StringFilter currentLivingArrangement) {
		this.currentLivingArrangement = currentLivingArrangement;
	}

	public IntegerFilter getPulseRate() {
		return pulseRate;
	}

	public void setPulseRate(IntegerFilter pulseRate) {
		this.pulseRate = pulseRate;
	}

	public IntegerFilter getBloodPressureSystolic() {
		return bloodPressureSystolic;
	}

	public void setBloodPressureSystolic(IntegerFilter bloodPressureSystolic) {
		this.bloodPressureSystolic = bloodPressureSystolic;
	}

	public IntegerFilter getBloodPressureDiastolic() {
		return bloodPressureDiastolic;
	}

	public void setBloodPressureDiastolic(IntegerFilter bloodPressureDiastolic) {
		this.bloodPressureDiastolic = bloodPressureDiastolic;
	}

	public IntegerFilter getRespiratoryRate() {
		return respiratoryRate;
	}

	public void setRespiratoryRate(IntegerFilter respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}

	public IntegerFilter getWeight() {
		return weight;
	}

	public void setWeight(IntegerFilter weight) {
		this.weight = weight;
	}

	public IntegerFilter getTemperature() {
		return temperature;
	}

	public void setTemperature(IntegerFilter temperature) {
		this.temperature = temperature;
	}

	public BooleanFilter getCyanosis() {
		return cyanosis;
	}

	public void setCyanosis(BooleanFilter cyanosis) {
		this.cyanosis = cyanosis;
	}

	public BooleanFilter getJaundice() {
		return jaundice;
	}

	public void setJaundice(BooleanFilter jaundice) {
		this.jaundice = jaundice;
	}

	public BooleanFilter getOedema() {
		return oedema;
	}

	public void setOedema(BooleanFilter oedema) {
		this.oedema = oedema;
	}

	public BooleanFilter getClubbing() {
		return clubbing;
	}

	public void setClubbing(BooleanFilter clubbing) {
		this.clubbing = clubbing;
	}

	public BooleanFilter getLymphadenopathy() {
		return lymphadenopathy;
	}

	public void setLymphadenopathy(BooleanFilter lymphadenopathy) {
		this.lymphadenopathy = lymphadenopathy;
	}

	public StringFilter getSkinIdentificationMark() {
		return skinIdentificationMark;
	}

	public void setSkinIdentificationMark(StringFilter skinIdentificationMark) {
		this.skinIdentificationMark = skinIdentificationMark;
	}

	public StringFilter getNeedleMarks() {
		return needleMarks;
	}

	public void setNeedleMarks(StringFilter needleMarks) {
		this.needleMarks = needleMarks;
	}

	public StringFilter getAbscess() {
		return abscess;
	}

	public void setAbscess(StringFilter abscess) {
		this.abscess = abscess;
	}

	public StringFilter getOpenWounds() {
		return openWounds;
	}

	public void setOpenWounds(StringFilter openWounds) {
		this.openWounds = openWounds;
	}

	public StringFilter getChest() {
		return chest;
	}

	public void setChest(StringFilter chest) {
		this.chest = chest;
	}

	public StringFilter getAbdomen() {
		return abdomen;
	}

	public void setAbdomen(StringFilter abdomen) {
		this.abdomen = abdomen;
	}

	public StringFilter getNeurologicalExamination() {
		return neurologicalExamination;
	}

	public void setNeurologicalExamination(StringFilter neurologicalExamination) {
		this.neurologicalExamination = neurologicalExamination;
	}

	public StringFilter getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(StringFilter diagnosis) {
		this.diagnosis = diagnosis;
	}

	public StringFilter getAdvice() {
		return advice;
	}

	public void setAdvice(StringFilter advice) {
		this.advice = advice;
	}

	public BooleanFilter getInitiateOST() {
		return initiateOST;
	}

	public void setInitiateOST(BooleanFilter initiateOST) {
		this.initiateOST = initiateOST;
	}

	public BooleanFilter getConsentTaken() {
		return consentTaken;
	}

	public void setConsentTaken(BooleanFilter consentTaken) {
		this.consentTaken = consentTaken;
	}

	public LocalDateFilter getConsentTakenDate() {
		return consentTakenDate;
	}

	public void setConsentTakenDate(LocalDateFilter consentTakenDate) {
		this.consentTakenDate = consentTakenDate;
	}

	public LongFilter getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(LongFilter facilityId) {
		this.facilityId = facilityId;
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

	public StringFilter getMeasureOfUnit() {
		return measureOfUnit;
	}

	public void setMeasureOfUnit(StringFilter measureOfUnit) {
		this.measureOfUnit = measureOfUnit;
	}

	public IntegerFilter getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(IntegerFilter createdBy) {
		this.createdBy = createdBy;
	}

	public StringFilter getClientStatus() {
		return clientStatus;
	}

	public void setClientStatus(StringFilter clientStatus) {
		this.clientStatus = clientStatus;
	}

	public BooleanFilter getIsActiveFacility() {
		return isActiveFacility;
	}

	public void setIsActiveFacility(BooleanFilter isActiveFacility) {
		this.isActiveFacility = isActiveFacility;
	}

	public LongFilter getStatus() {
	    return status;
	}

	public void setStatus(LongFilter status) {
	    this.status = status;
	}

	public BooleanFilter getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(BooleanFilter isDelete) {
		this.isDelete = isDelete;
	}

	public ZonedDateTimeFilter getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(ZonedDateTimeFilter createdTime) {
		this.createdTime = createdTime;
	}

	public IntegerFilter getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(IntegerFilter modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public ZonedDateTimeFilter getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(ZonedDateTimeFilter modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public IntegerFilter getAbstinenceDuration() {
		return abstinenceDuration;
	}

	public void setAbstinenceDuration(IntegerFilter abstinenceDuration) {
		this.abstinenceDuration = abstinenceDuration;
	}

	public IntegerFilter getAbstinenceAttempts() {
		return abstinenceAttempts;
	}

	public void setAbstinenceAttempts(IntegerFilter abstinenceAttempts) {
		this.abstinenceAttempts = abstinenceAttempts;
	}

	public StringFilter getAbstinenceReason() {
		return abstinenceReason;
	}

	public void setAbstinenceReason(StringFilter abstinenceReason) {
		this.abstinenceReason = abstinenceReason;
	}

	public LongFilter getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(LongFilter beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final TIOstAssessCriteria that = (TIOstAssessCriteria) o;
		return Objects.equals(id, that.id) && Objects.equals(dateOfAssessment, that.dateOfAssessment)
				&& Objects.equals(nextDateOfAssessment, that.nextDateOfAssessment)
				&& Objects.equals(chooseDrug, that.chooseDrug) && Objects.equals(ageAtOnset, that.ageAtOnset)
				&& Objects.equals(noYearsInUse, that.noYearsInUse)
				&& Objects.equals(injectingRoute, that.injectingRoute) && Objects.equals(dependence, that.dependence)
				&& Objects.equals(useInLastOneMonth, that.useInLastOneMonth)
				&& Objects.equals(complicationsWithDrugUse, that.complicationsWithDrugUse)
				&& Objects.equals(isNeedlesAndSyringesShared, that.isNeedlesAndSyringesShared)
				&& Objects.equals(isNeedlesAndSyringesSharedLastOccasion, that.isNeedlesAndSyringesSharedLastOccasion)
				&& Objects.equals(isOtherParaphernaliaSharedLastOccasion, that.isOtherParaphernaliaSharedLastOccasion)
				&& Objects.equals(isOtherParaphernaliaSharedEver, that.isOtherParaphernaliaSharedEver)
				&& Objects.equals(noOfSexualPartners, that.noOfSexualPartners)
				&& Objects.equals(lastSexualEncounter, that.lastSexualEncounter)
				&& Objects.equals(isAbstinenceAttemptedPreviously, that.isAbstinenceAttemptedPreviously)
				&& Objects.equals(timePeriodForAbstinence, that.timePeriodForAbstinence)
				&& Objects.equals(durationOfAbstinence, that.durationOfAbstinence)
				&& Objects.equals(typeOfHelpOrIntervention, that.typeOfHelpOrIntervention)
				&& Objects.equals(currentLivingArrangement, that.currentLivingArrangement)
				&& Objects.equals(pulseRate, that.pulseRate)
				&& Objects.equals(bloodPressureSystolic, that.bloodPressureSystolic)
				&& Objects.equals(bloodPressureDiastolic, that.bloodPressureDiastolic)
				&& Objects.equals(respiratoryRate, that.respiratoryRate) && Objects.equals(weight, that.weight)
				&& Objects.equals(temperature, that.temperature) && Objects.equals(cyanosis, that.cyanosis)
				&& Objects.equals(jaundice, that.jaundice) && Objects.equals(oedema, that.oedema)
				&& Objects.equals(clubbing, that.clubbing) && Objects.equals(lymphadenopathy, that.lymphadenopathy)
				&& Objects.equals(skinIdentificationMark, that.skinIdentificationMark)
				&& Objects.equals(needleMarks, that.needleMarks) && Objects.equals(abscess, that.abscess)
				&& Objects.equals(openWounds, that.openWounds) && Objects.equals(chest, that.chest)
				&& Objects.equals(abdomen, that.abdomen)
				&& Objects.equals(neurologicalExamination, that.neurologicalExamination)
				&& Objects.equals(diagnosis, that.diagnosis) && Objects.equals(advice, that.advice)
				&& Objects.equals(initiateOST, that.initiateOST) && Objects.equals(consentTaken, that.consentTaken)
				&& Objects.equals(consentTakenDate, that.consentTakenDate)
				&& Objects.equals(substitutionDrug, that.substitutionDrug) && Objects.equals(dosage, that.dosage)
				&& Objects.equals(measureOfUnit, that.measureOfUnit) && Objects.equals(createdBy, that.createdBy)
				&& Objects.equals(createdTime, that.createdTime) && Objects.equals(modifiedBy, that.modifiedBy)
				&& Objects.equals(modifiedTime, that.modifiedTime)
				&& Objects.equals(abstinenceDuration, that.abstinenceDuration)
				&& Objects.equals(abstinenceAttempts, that.abstinenceAttempts)
				&& Objects.equals(abstinenceReason, that.abstinenceReason)
				&& Objects.equals(clientStatus, that.clientStatus) && Objects.equals(isActiveFacility, that.isActiveFacility)
				&& Objects.equals(isDelete, that.isDelete)
				&& Objects.equals(status, that.status)
				&& Objects.equals(facilityId, that.facilityId) && Objects.equals(beneficiaryId, that.beneficiaryId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, dateOfAssessment, nextDateOfAssessment, chooseDrug, ageAtOnset, noYearsInUse,
				injectingRoute, dependence, useInLastOneMonth, complicationsWithDrugUse, isNeedlesAndSyringesShared,
				isNeedlesAndSyringesSharedLastOccasion, isOtherParaphernaliaSharedLastOccasion,
				isOtherParaphernaliaSharedEver, noOfSexualPartners, lastSexualEncounter,
				isAbstinenceAttemptedPreviously, timePeriodForAbstinence, durationOfAbstinence,
				typeOfHelpOrIntervention, currentLivingArrangement, pulseRate, bloodPressureSystolic,
				bloodPressureDiastolic, respiratoryRate, weight, temperature, cyanosis, jaundice, oedema, clubbing,
				lymphadenopathy, skinIdentificationMark, needleMarks, abscess, openWounds, chest, abdomen,
				neurologicalExamination, diagnosis, advice, initiateOST, consentTaken, consentTakenDate,
				substitutionDrug, dosage, measureOfUnit, createdBy, createdTime, modifiedBy, modifiedTime, isDelete,
				abstinenceDuration, abstinenceAttempts, abstinenceReason, facilityId, beneficiaryId, status,clientStatus,isActiveFacility);
	}

	@Override
	public String toString() {
		return "TIOstAssessCriteria [id=" + id + ", facilityId=" + facilityId + ", dateOfAssessment=" + dateOfAssessment
				+ ", nextDateOfAssessment=" + nextDateOfAssessment + ", chooseDrug=" + chooseDrug + ", ageAtOnset="
				+ ageAtOnset + ", noYearsInUse=" + noYearsInUse + ", injectingRoute=" + injectingRoute + ", dependence="
				+ dependence + ", useInLastOneMonth=" + useInLastOneMonth + ", complicationsWithDrugUse="
				+ complicationsWithDrugUse + ", isNeedlesAndSyringesShared=" + isNeedlesAndSyringesShared
				+ ", isNeedlesAndSyringesSharedLastOccasion=" + isNeedlesAndSyringesSharedLastOccasion
				+ ", isOtherParaphernaliaSharedLastOccasion=" + isOtherParaphernaliaSharedLastOccasion
				+ ", isOtherParaphernaliaSharedEver=" + isOtherParaphernaliaSharedEver + ", noOfSexualPartners="
				+ noOfSexualPartners + ", lastSexualEncounter=" + lastSexualEncounter
				+ ", isAbstinenceAttemptedPreviously=" + isAbstinenceAttemptedPreviously + ", timePeriodForAbstinence="
				+ timePeriodForAbstinence + ", durationOfAbstinence=" + durationOfAbstinence
				+ ", typeOfHelpOrIntervention=" + typeOfHelpOrIntervention + ", currentLivingArrangement="
				+ currentLivingArrangement + ", pulseRate=" + pulseRate + ", bloodPressureSystolic="
				+ bloodPressureSystolic + ", bloodPressureDiastolic=" + bloodPressureDiastolic + ", respiratoryRate="
				+ respiratoryRate + ", weight=" + weight + ", temperature=" + temperature + ", cyanosis=" + cyanosis
				+ ", jaundice=" + jaundice + ", oedema=" + oedema + ", clubbing=" + clubbing + ", lymphadenopathy="
				+ lymphadenopathy + ", skinIdentificationMark=" + skinIdentificationMark + ", needleMarks="
				+ needleMarks + ", abscess=" + abscess + ", openWounds=" + openWounds + ", chest=" + chest
				+ ", abdomen=" + abdomen + ", neurologicalExamination=" + neurologicalExamination + ", diagnosis="
				+ diagnosis + ", advice=" + advice + ", initiateOST=" + initiateOST + ", consentTaken=" + consentTaken
				+ ", consentTakenDate=" + consentTakenDate + ", substitutionDrug=" + substitutionDrug + ", dosage="
				+ dosage + ", measureOfUnit=" + measureOfUnit + ", createdBy=" + createdBy + ", createdTime="
				+ createdTime + ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime
				+ ", abstinenceDuration=" + abstinenceDuration + ", abstinenceAttempts=" + abstinenceAttempts
				+ ", abstinenceReason=" + abstinenceReason + ", beneficiaryId=" + beneficiaryId + ", param=" + param
				+ ", ostNumber=" + ostNumber + "]";
	}

}
