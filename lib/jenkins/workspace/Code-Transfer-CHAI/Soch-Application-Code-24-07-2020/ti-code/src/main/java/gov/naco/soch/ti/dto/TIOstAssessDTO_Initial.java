package gov.naco.soch.ti.dto;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import gov.naco.soch.dto.MiniMasterDto;

public class TIOstAssessDTO_Initial extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private FacilityDTO facility;
	private Long beneficiaryId;
	private LocalDate nextDateOfAssessment;
	private LocalDate dateOfAssessment;

	private Integer abstinenceAttempts;

	private Integer ageAtOnset;

	private Integer bloodPressureDiastolic;

	private Integer bloodPressureSystolic;

	private Boolean clubbing;

	private String complicationsWithDrugUse;

	private Boolean cyanosis;

	private Boolean dependence;

	private String drugUsage;

	private Integer durationOfAbstinence;

	private Boolean injectingRoute;

	private Boolean isAbstinenceAttemptedPreviously;

	private Boolean isActive;

	private Boolean isDelete;

	private Boolean isNeedlesAndSyringesShared;

	private Boolean isNeedlesAndSyringesSharedLastOccasion;

	private Boolean isOtherParaphernaliaSharedEver;

	private Boolean isOtherParaphernaliaSharedLastOccasion;

	private Boolean jaundice;

	private LocalDate lastSexualEncounter;

	private Boolean lymphadenopathy;

	private Integer noOfSexualPartners;

	private Integer noYearsInUse;

	private Boolean oedema;

	private Integer pulseRate;

	private Integer respiratoryRate;

	private String skinMarks;

	private Integer temperature;

	private Boolean useInLastOneMonth;

	private Integer weight;

	private LocalDate timePeriodForAbstinence;

	private String typeOfHelpOrIntervention;

	private String currentLivingArrangement;

	private String needleMarks;

	private String abscess;

	private String openWounds;
	
	private String diagnosis;

	private String advice;

	private Boolean initiateOST;

	private Boolean consentTaken;
	
	private MiniMasterDto followUpReason;
	
	private Set<TIOstPrescriptionDTO> tiOstPrescriptions ;

	private Set<TiOstAssessmentDrugUsageDTO> tiOstDrugUsages;

	private Set<TiOstAssessmentDrugComplicationDTO> tiOstDrugComplications;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	

	public LocalDate getTimePeriodForAbstinence() {
		return timePeriodForAbstinence;
	}

	public void setTimePeriodForAbstinence(LocalDate timePeriodForAbstinence) {
		this.timePeriodForAbstinence = timePeriodForAbstinence;
	}

	public Set<TIOstPrescriptionDTO> getTiOstPrescriptions() {
		return tiOstPrescriptions;
	}

	public void setTiOstPrescriptions(Set<TIOstPrescriptionDTO> tiOstPrescriptions) {
		this.tiOstPrescriptions = tiOstPrescriptions;
	}

	public Set<TiOstAssessmentDrugUsageDTO> getTiOstDrugUsages() {
		return tiOstDrugUsages;
	}

	public void setTiOstDrugUsages(Set<TiOstAssessmentDrugUsageDTO> tiOstDrugUsages) {
		this.tiOstDrugUsages = tiOstDrugUsages;
	}

	public Set<TiOstAssessmentDrugComplicationDTO> getTiOstDrugComplications() {
		return tiOstDrugComplications;
	}

	public void setTiOstDrugComplications(Set<TiOstAssessmentDrugComplicationDTO> tiOstDrugComplications) {
		this.tiOstDrugComplications = tiOstDrugComplications;
	}

	public String getTypeOfHelpOrIntervention() {
		return typeOfHelpOrIntervention;
	}

	public void setTypeOfHelpOrIntervention(String typeOfHelpOrIntervention) {
		this.typeOfHelpOrIntervention = typeOfHelpOrIntervention;
	}

	public String getCurrentLivingArrangement() {
		return currentLivingArrangement;
	}

	public void setCurrentLivingArrangement(String currentLivingArrangement) {
		this.currentLivingArrangement = currentLivingArrangement;
	}

	public String getNeedleMarks() {
		return needleMarks;
	}

	public void setNeedleMarks(String needleMarks) {
		this.needleMarks = needleMarks;
	}

	public String getAbscess() {
		return abscess;
	}

	public void setAbscess(String abscess) {
		this.abscess = abscess;
	}

	public String getOpenWounds() {
		return openWounds;
	}

	public void setOpenWounds(String openWounds) {
		this.openWounds = openWounds;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public Boolean getInitiateOST() {
		return initiateOST;
	}

	public void setInitiateOST(Boolean initiateOST) {
		this.initiateOST = initiateOST;
	}

	public Boolean getConsentTaken() {
		return consentTaken;
	}

	public void setConsentTaken(Boolean consentTaken) {
		this.consentTaken = consentTaken;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getSkinMarks() {
		return skinMarks;
	}

	public void setSkinMarks(String skinMarks) {
		this.skinMarks = skinMarks;
	}

	public void setNoOfSexualPartners(Integer noOfSexualPartners) {
		this.noOfSexualPartners = noOfSexualPartners;
	}

	public LocalDate getDateOfAssessment() {
		return dateOfAssessment;
	}

	public void setDateOfAssessment(LocalDate dateOfAssessment) {
		this.dateOfAssessment = dateOfAssessment;
	}

	public Integer getAgeAtOnset() {
		return ageAtOnset;
	}

	public void setAgeAtOnset(Integer ageAtOnset) {
		this.ageAtOnset = ageAtOnset;
	}

	public Integer getNoYearsInUse() {
		return noYearsInUse;
	}

	public void setNoYearsInUse(Integer noYearsInUse) {
		this.noYearsInUse = noYearsInUse;
	}

	public Boolean getInjectingRoute() {
		return injectingRoute;
	}

	public void setInjectingRoute(Boolean injectingRoute) {
		this.injectingRoute = injectingRoute;
	}

	public Boolean getDependence() {
		return dependence;
	}

	public void setDependence(Boolean dependence) {
		this.dependence = dependence;
	}

	public Boolean getUseInLastOneMonth() {
		return useInLastOneMonth;
	}

	public void setUseInLastOneMonth(Boolean useInLastOneMonth) {
		this.useInLastOneMonth = useInLastOneMonth;
	}

	public String getComplicationsWithDrugUse() {
		return complicationsWithDrugUse;
	}

	public void setComplicationsWithDrugUse(String complicationsWithDrugUse) {
		this.complicationsWithDrugUse = complicationsWithDrugUse;
	}

	public Boolean getIsNeedlesAndSyringesShared() {
		return isNeedlesAndSyringesShared;
	}

	public void setIsNeedlesAndSyringesShared(Boolean isNeedlesAndSyringesShared) {
		this.isNeedlesAndSyringesShared = isNeedlesAndSyringesShared;
	}

	public Boolean getIsNeedlesAndSyringesSharedLastOccasion() {
		return isNeedlesAndSyringesSharedLastOccasion;
	}

	public void setIsNeedlesAndSyringesSharedLastOccasion(Boolean isNeedlesAndSyringesSharedLastOccasion) {
		this.isNeedlesAndSyringesSharedLastOccasion = isNeedlesAndSyringesSharedLastOccasion;
	}

	public Integer getNoOfSexualPartners() {
		return noOfSexualPartners;
	}

	public Boolean getIsOtherParaphernaliaSharedLastOccasion() {
		return isOtherParaphernaliaSharedLastOccasion;
	}

	public void setIsOtherParaphernaliaSharedLastOccasion(Boolean isOtherParaphernaliaSharedLastOccasion) {
		this.isOtherParaphernaliaSharedLastOccasion = isOtherParaphernaliaSharedLastOccasion;
	}

	public Boolean getIsOtherParaphernaliaSharedEver() {
		return isOtherParaphernaliaSharedEver;
	}

	public void setIsOtherParaphernaliaSharedEver(Boolean isOtherParaphernaliaSharedEver) {
		this.isOtherParaphernaliaSharedEver = isOtherParaphernaliaSharedEver;
	}

	public LocalDate getLastSexualEncounter() {
		return lastSexualEncounter;
	}

	public void setLastSexualEncounter(LocalDate lastSexualEncounter) {
		this.lastSexualEncounter = lastSexualEncounter;
	}

	public Boolean getIsAbstinenceAttemptedPreviously() {
		return isAbstinenceAttemptedPreviously;
	}

	public void setIsAbstinenceAttemptedPreviously(Boolean isAbstinenceAttemptedPreviously) {
		this.isAbstinenceAttemptedPreviously = isAbstinenceAttemptedPreviously;
	}

	public Integer getDurationOfAbstinence() {
		return durationOfAbstinence;
	}

	public void setDurationOfAbstinence(Integer durationOfAbstinence) {
		this.durationOfAbstinence = durationOfAbstinence;
	}

	public Integer getPulseRate() {
		return pulseRate;
	}

	public void setPulseRate(Integer pulseRate) {
		this.pulseRate = pulseRate;
	}

	public Integer getBloodPressureSystolic() {
		return bloodPressureSystolic;
	}

	public void setBloodPressureSystolic(Integer bloodPressureSystolic) {
		this.bloodPressureSystolic = bloodPressureSystolic;
	}

	public Integer getBloodPressureDiastolic() {
		return bloodPressureDiastolic;
	}

	public void setBloodPressureDiastolic(Integer bloodPressureDiastolic) {
		this.bloodPressureDiastolic = bloodPressureDiastolic;
	}

	public Integer getRespiratoryRate() {
		return respiratoryRate;
	}

	public void setRespiratoryRate(Integer respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getTemperature() {
		return temperature;
	}

	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}

	public Boolean getCyanosis() {
		return cyanosis;
	}

	public void setCyanosis(Boolean cyanosis) {
		this.cyanosis = cyanosis;
	}

	public FacilityDTO getFacility() {
		return facility;
	}

	public void setFacility(FacilityDTO facility) {
		this.facility = facility;
	}

	public Boolean getJaundice() {
		return jaundice;
	}

	public void setJaundice(Boolean jaundice) {
		this.jaundice = jaundice;
	}

	public MiniMasterDto getFollowUpReason() {
		return followUpReason;
	}

	public void setFollowUpReason(MiniMasterDto followUpReason) {
		this.followUpReason = followUpReason;
	}

	public Boolean getOedema() {
		return oedema;
	}

	public void setOedema(Boolean oedema) {
		this.oedema = oedema;
	}

	public Boolean getClubbing() {
		return clubbing;
	}

	public void setClubbing(Boolean clubbing) {
		this.clubbing = clubbing;
	}

	public Boolean getLymphadenopathy() {
		return lymphadenopathy;
	}

	public void setLymphadenopathy(Boolean lymphadenopathy) {
		this.lymphadenopathy = lymphadenopathy;
	}

	public String getDrugUsage() {
		return drugUsage;
	}

	public void setDrugUsage(String drugUsage) {
		this.drugUsage = drugUsage;
	}

	public Integer getAbstinenceAttempts() {
		return abstinenceAttempts;
	}

	public void setAbstinenceAttempts(Integer abstinenceAttempts) {
		this.abstinenceAttempts = abstinenceAttempts;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public LocalDate getNextDateOfAssessment() {
		return nextDateOfAssessment;
	}

	public void setNextDateOfAssessment(LocalDate nextDateOfAssessment) {
		this.nextDateOfAssessment = nextDateOfAssessment;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		TIOstAssessDTO_Initial tIOstAssessDTO_Initial = (TIOstAssessDTO_Initial) o;
		if (tIOstAssessDTO_Initial.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), tIOstAssessDTO_Initial.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

}
