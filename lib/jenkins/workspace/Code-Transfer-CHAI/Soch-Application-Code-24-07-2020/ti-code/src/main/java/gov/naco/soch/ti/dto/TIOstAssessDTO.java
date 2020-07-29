package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import gov.naco.soch.dto.MiniMasterDto;

/**
 * A DTO for the {@link gov.naco.soch.domain.TIOstAssess} entity.
 */
public class TIOstAssessDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private Integer abstinenceAttempts;

	private Integer ageAtOnset;

	private Integer bloodPressureDiastolic;

	private Integer bloodPressureSystolic;

	private Boolean clubbing;

	private Boolean cyanosis;

	private LocalDate dateOfAssessment;

	private Boolean dependence;

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

	private LocalDate nextDateOfAssessment;

	private Integer noOfSexualPartners;

	private Integer noYearsInUse;

	private Boolean oedema;

	private Integer pulseRate;

	private Integer respiratoryRate;

	private String skinMarks;

	private MiniMasterDto followUpReason;

	private Integer temperature;

	private Boolean useInLastOneMonth;

	private Integer weight;

	private LocalDate timePeriodForAbstinence;
	
	private String needleMarks;

	private String abscess;

	private String openWounds;

	private String diagnosis;

	private String advice;

	private Boolean initiateOST;

	private Boolean consentTaken;

	private TIOstBeneficiaryDTO tiOstBeneficiary;

	private Set<TIOstPrescriptionDTO> tiOstPrescriptions;

	private Set<TiOstAssessmentDrugUsageDTO> tiOstDrugUsages;

	private Set<TiOstAssessmentDrugComplicationDTO> tiOstDrugComplications;

	private LocalDate nextFollowUpDate;

	private FacilityDTO facility;
	
	private long count;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAbstinenceAttempts() {
		return abstinenceAttempts;
	}

	public void setAbstinenceAttempts(Integer abstinenceAttempts) {
		this.abstinenceAttempts = abstinenceAttempts;
	}

	public Set<TIOstPrescriptionDTO> getTiOstPrescriptions() {
		return tiOstPrescriptions;
	}

	public void setTiOstPrescriptions(Set<TIOstPrescriptionDTO> tiOstPrescriptions) {
		this.tiOstPrescriptions = tiOstPrescriptions;
	}

	public Integer getAgeAtOnset() {
		return ageAtOnset;
	}

	public void setAgeAtOnset(Integer ageAtOnset) {
		this.ageAtOnset = ageAtOnset;
	}

	public Integer getBloodPressureDiastolic() {
		return bloodPressureDiastolic;
	}

	public void setBloodPressureDiastolic(Integer bloodPressureDiastolic) {
		this.bloodPressureDiastolic = bloodPressureDiastolic;
	}

	public LocalDate getTimePeriodForAbstinence() {
		return timePeriodForAbstinence;
	}

	public void setTimePeriodForAbstinence(LocalDate timePeriodForAbstinence) {
		this.timePeriodForAbstinence = timePeriodForAbstinence;
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

	public LocalDate getNextFollowUpDate() {
		return nextFollowUpDate;
	}

	public void setNextFollowUpDate(LocalDate nextFollowUpDate) {
		this.nextFollowUpDate = nextFollowUpDate;
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

	public Integer getBloodPressureSystolic() {
		return bloodPressureSystolic;
	}

	public void setBloodPressureSystolic(Integer bloodPressureSystolic) {
		this.bloodPressureSystolic = bloodPressureSystolic;
	}

	public Boolean getClubbing() {
		return clubbing;
	}

	public void setClubbing(Boolean clubbing) {
		this.clubbing = clubbing;
	}

	public Boolean getCyanosis() {
		return cyanosis;
	}

	public void setCyanosis(Boolean cyanosis) {
		this.cyanosis = cyanosis;
	}

	public LocalDate getDateOfAssessment() {
		return dateOfAssessment;
	}

	public void setDateOfAssessment(LocalDate dateOfAssessment) {
		this.dateOfAssessment = dateOfAssessment;
	}

	public Boolean getDependence() {
		return dependence;
	}

	public void setDependence(Boolean dependence) {
		this.dependence = dependence;
	}

	public Set<TiOstAssessmentDrugUsageDTO> getTiOstDrugUsages() {
		return tiOstDrugUsages;
	}

	public void setTiOstDrugUsages(Set<TiOstAssessmentDrugUsageDTO> tiOstDrugUsages) {
		this.tiOstDrugUsages = tiOstDrugUsages;
	}

	public Integer getDurationOfAbstinence() {
		return durationOfAbstinence;
	}

	public void setDurationOfAbstinence(Integer durationOfAbstinence) {
		this.durationOfAbstinence = durationOfAbstinence;
	}

	public Boolean getInjectingRoute() {
		return injectingRoute;
	}

	public void setInjectingRoute(Boolean injectingRoute) {
		this.injectingRoute = injectingRoute;
	}

	public Boolean getIsAbstinenceAttemptedPreviously() {
		return isAbstinenceAttemptedPreviously;
	}

	public void setIsAbstinenceAttemptedPreviously(Boolean isAbstinenceAttemptedPreviously) {
		this.isAbstinenceAttemptedPreviously = isAbstinenceAttemptedPreviously;
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

	public Boolean getIsOtherParaphernaliaSharedEver() {
		return isOtherParaphernaliaSharedEver;
	}

	public void setIsOtherParaphernaliaSharedEver(Boolean isOtherParaphernaliaSharedEver) {
		this.isOtherParaphernaliaSharedEver = isOtherParaphernaliaSharedEver;
	}

	public Boolean getIsOtherParaphernaliaSharedLastOccasion() {
		return isOtherParaphernaliaSharedLastOccasion;
	}

	public void setIsOtherParaphernaliaSharedLastOccasion(Boolean isOtherParaphernaliaSharedLastOccasion) {
		this.isOtherParaphernaliaSharedLastOccasion = isOtherParaphernaliaSharedLastOccasion;
	}

	public Boolean getJaundice() {
		return jaundice;
	}

	public void setJaundice(Boolean jaundice) {
		this.jaundice = jaundice;
	}

	public LocalDate getLastSexualEncounter() {
		return lastSexualEncounter;
	}

	public void setLastSexualEncounter(LocalDate lastSexualEncounter) {
		this.lastSexualEncounter = lastSexualEncounter;
	}

	public Boolean getLymphadenopathy() {
		return lymphadenopathy;
	}

	public void setLymphadenopathy(Boolean lymphadenopathy) {
		this.lymphadenopathy = lymphadenopathy;
	}

	public LocalDate getNextDateOfAssessment() {
		return nextDateOfAssessment;
	}

	public void setNextDateOfAssessment(LocalDate nextDateOfAssessment) {
		this.nextDateOfAssessment = nextDateOfAssessment;
	}

	public Integer getNoOfSexualPartners() {
		return noOfSexualPartners;
	}

	public void setNoOfSexualPartners(Integer noOfSexualPartners) {
		this.noOfSexualPartners = noOfSexualPartners;
	}

	public MiniMasterDto getFollowUpReason() {
		return followUpReason;
	}

	public void setFollowUpReason(MiniMasterDto followUpReason) {
		this.followUpReason = followUpReason;
	}

	public Integer getNoYearsInUse() {
		return noYearsInUse;
	}

	public void setNoYearsInUse(Integer noYearsInUse) {
		this.noYearsInUse = noYearsInUse;
	}

	public Boolean getOedema() {
		return oedema;
	}

	public void setOedema(Boolean oedema) {
		this.oedema = oedema;
	}

	public Integer getPulseRate() {
		return pulseRate;
	}

	public void setPulseRate(Integer pulseRate) {
		this.pulseRate = pulseRate;
	}

	public long getCount() {
	    return count;
	}

	public void setCount(long count) {
	    this.count = count;
	}

	public Integer getRespiratoryRate() {
		return respiratoryRate;
	}

	public void setRespiratoryRate(Integer respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}

	public String getSkinMarks() {
		return skinMarks;
	}

	public void setSkinMarks(String skinMarks) {
		this.skinMarks = skinMarks;
	}

	public Integer getTemperature() {
		return temperature;
	}

	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}

	public Set<TiOstAssessmentDrugComplicationDTO> getTiOstDrugComplications() {
		return tiOstDrugComplications;
	}

	public void setTiOstDrugComplications(Set<TiOstAssessmentDrugComplicationDTO> tiOstDrugComplications) {
		this.tiOstDrugComplications = tiOstDrugComplications;
	}

	public Boolean getUseInLastOneMonth() {
		return useInLastOneMonth;
	}

	public void setUseInLastOneMonth(Boolean useInLastOneMonth) {
		this.useInLastOneMonth = useInLastOneMonth;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public TIOstBeneficiaryDTO getTiOstBeneficiary() {
		return tiOstBeneficiary;
	}

	public void setTiOstBeneficiary(TIOstBeneficiaryDTO tiOstBeneficiary) {
		this.tiOstBeneficiary = tiOstBeneficiary;
	}

	public FacilityDTO getFacility() {
		return facility;
	}

	public void setFacility(FacilityDTO facility) {
		this.facility = facility;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		TIOstAssessDTO tIOstAssessDTO = (TIOstAssessDTO) o;
		if (tIOstAssessDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), tIOstAssessDTO.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

}
