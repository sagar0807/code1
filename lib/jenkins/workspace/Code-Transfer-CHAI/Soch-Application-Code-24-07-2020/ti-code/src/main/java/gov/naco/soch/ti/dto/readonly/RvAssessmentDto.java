package gov.naco.soch.ti.dto.readonly;

import java.time.LocalDate;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.ti.dto.TiBenSubDto;

public class RvAssessmentDto {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private LocalDate dueDateOfAssessment;

	private Integer assessmentPending;

	private LocalDate assessmentDate;

	private Integer highNumberOfSexualEncounters;

	private Integer lowCondomUse;

	private Integer firstYearInSexWorkAndBelowAgeOf25Years;

	private Integer stiReportedInLastThreeMonthsTi;

	private Integer alcohol;

	private Integer unsafeSex;

	private Integer violence;

	private Integer condomRequirementPerWeek;

	private Integer highNumberOfDrugUsingPartners;

	private Integer sharingOfNeedlesSyringes;

	private Integer injectingGreaterThanThreeTimes;

	private Integer stiReportedInLastThreeMonthsIdu;

	private Integer useOfAlcoholAndOtherDrugsApartFromInjections;

	private Integer unsafeSexSexWithNonRegularPartner;

	private Integer mobilityFromOneHotspotToAnother;

	private Integer needlesSyringesRequirementPerWeek;

	private TiBenSubDto beneficiary;

	private Long facilityId;
	
	private Boolean isActive;

	private Boolean isDelete;
	
	private LocalDate assessmentDateBTi;
	
	private Integer exposureToOtherSexualContactsBTi;
	
	private Integer providedSexInLastThreeMonthsBTi;
	
	private Integer stiReportedInLastThreeMonthsBTi;
	
	private Integer drugsOrAlcoholBeforeOrDuringSexBTi ;
	
	private Integer hivPositiveNotUnderARTBTi; 
	
	private MiniMasterDto assementStatus;
	
	private long count;
	
	private Long previousId;
	
	private Boolean isEarly;
	
	public RvAssessmentDto() {
	 
	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}

	public LocalDate getDueDateOfAssessment() {
	    return dueDateOfAssessment;
	}

	public void setDueDateOfAssessment(LocalDate dueDateOfAssessment) {
	    this.dueDateOfAssessment = dueDateOfAssessment;
	}

	public Integer getAssessmentPending() {
	    return assessmentPending;
	}

	public void setAssessmentPending(Integer assessmentPending) {
	    this.assessmentPending = assessmentPending;
	}

	public LocalDate getAssessmentDate() {
	    return assessmentDate;
	}

	public void setAssessmentDate(LocalDate assessmentDate) {
	    this.assessmentDate = assessmentDate;
	}

	public Integer getHighNumberOfSexualEncounters() {
	    return highNumberOfSexualEncounters;
	}

	public void setHighNumberOfSexualEncounters(Integer highNumberOfSexualEncounters) {
	    this.highNumberOfSexualEncounters = highNumberOfSexualEncounters;
	}

	public Integer getLowCondomUse() {
	    return lowCondomUse;
	}

	public void setLowCondomUse(Integer lowCondomUse) {
	    this.lowCondomUse = lowCondomUse;
	}

	public Integer getFirstYearInSexWorkAndBelowAgeOf25Years() {
	    return firstYearInSexWorkAndBelowAgeOf25Years;
	}

	public void setFirstYearInSexWorkAndBelowAgeOf25Years(Integer firstYearInSexWorkAndBelowAgeOf25Years) {
	    this.firstYearInSexWorkAndBelowAgeOf25Years = firstYearInSexWorkAndBelowAgeOf25Years;
	}

	public Integer getStiReportedInLastThreeMonthsTi() {
	    return stiReportedInLastThreeMonthsTi;
	}

	public void setStiReportedInLastThreeMonthsTi(Integer stiReportedInLastThreeMonthsTi) {
	    this.stiReportedInLastThreeMonthsTi = stiReportedInLastThreeMonthsTi;
	}

	public Integer getAlcohol() {
	    return alcohol;
	}

	public void setAlcohol(Integer alcohol) {
	    this.alcohol = alcohol;
	}

	public Integer getUnsafeSex() {
	    return unsafeSex;
	}

	public void setUnsafeSex(Integer unsafeSex) {
	    this.unsafeSex = unsafeSex;
	}

	public Integer getViolence() {
	    return violence;
	}

	public void setViolence(Integer violence) {
	    this.violence = violence;
	}

	public Integer getCondomRequirementPerWeek() {
	    return condomRequirementPerWeek;
	}

	public void setCondomRequirementPerWeek(Integer condomRequirementPerWeek) {
	    this.condomRequirementPerWeek = condomRequirementPerWeek;
	}

	public Integer getHighNumberOfDrugUsingPartners() {
	    return highNumberOfDrugUsingPartners;
	}

	public void setHighNumberOfDrugUsingPartners(Integer highNumberOfDrugUsingPartners) {
	    this.highNumberOfDrugUsingPartners = highNumberOfDrugUsingPartners;
	}

	public Integer getSharingOfNeedlesSyringes() {
	    return sharingOfNeedlesSyringes;
	}

	public void setSharingOfNeedlesSyringes(Integer sharingOfNeedlesSyringes) {
	    this.sharingOfNeedlesSyringes = sharingOfNeedlesSyringes;
	}

	public Integer getInjectingGreaterThanThreeTimes() {
	    return injectingGreaterThanThreeTimes;
	}

	public void setInjectingGreaterThanThreeTimes(Integer injectingGreaterThanThreeTimes) {
	    this.injectingGreaterThanThreeTimes = injectingGreaterThanThreeTimes;
	}

	public Integer getStiReportedInLastThreeMonthsIdu() {
	    return stiReportedInLastThreeMonthsIdu;
	}

	public void setStiReportedInLastThreeMonthsIdu(Integer stiReportedInLastThreeMonthsIdu) {
	    this.stiReportedInLastThreeMonthsIdu = stiReportedInLastThreeMonthsIdu;
	}

	public Integer getUseOfAlcoholAndOtherDrugsApartFromInjections() {
	    return useOfAlcoholAndOtherDrugsApartFromInjections;
	}

	public void setUseOfAlcoholAndOtherDrugsApartFromInjections(Integer useOfAlcoholAndOtherDrugsApartFromInjections) {
	    this.useOfAlcoholAndOtherDrugsApartFromInjections = useOfAlcoholAndOtherDrugsApartFromInjections;
	}

	public Integer getUnsafeSexSexWithNonRegularPartner() {
	    return unsafeSexSexWithNonRegularPartner;
	}

	public void setUnsafeSexSexWithNonRegularPartner(Integer unsafeSexSexWithNonRegularPartner) {
	    this.unsafeSexSexWithNonRegularPartner = unsafeSexSexWithNonRegularPartner;
	}

	public Integer getMobilityFromOneHotspotToAnother() {
	    return mobilityFromOneHotspotToAnother;
	}

	public void setMobilityFromOneHotspotToAnother(Integer mobilityFromOneHotspotToAnother) {
	    this.mobilityFromOneHotspotToAnother = mobilityFromOneHotspotToAnother;
	}

	public Integer getNeedlesSyringesRequirementPerWeek() {
	    return needlesSyringesRequirementPerWeek;
	}

	public void setNeedlesSyringesRequirementPerWeek(Integer needlesSyringesRequirementPerWeek) {
	    this.needlesSyringesRequirementPerWeek = needlesSyringesRequirementPerWeek;
	}

	public TiBenSubDto getBeneficiary() {
	    return beneficiary;
	}

	public void setBeneficiary(TiBenSubDto beneficiary) {
	    this.beneficiary = beneficiary;
	}

	public Long getFacilityId() {
	    return facilityId;
	}

	public void setFacilityId(Long facilityId) {
	    this.facilityId = facilityId;
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

	public LocalDate getAssessmentDateBTi() {
	    return assessmentDateBTi;
	}

	public void setAssessmentDateBTi(LocalDate assessmentDateBTi) {
	    this.assessmentDateBTi = assessmentDateBTi;
	}

	public Integer getExposureToOtherSexualContactsBTi() {
	    return exposureToOtherSexualContactsBTi;
	}

	public void setExposureToOtherSexualContactsBTi(Integer exposureToOtherSexualContactsBTi) {
	    this.exposureToOtherSexualContactsBTi = exposureToOtherSexualContactsBTi;
	}

	public Integer getProvidedSexInLastThreeMonthsBTi() {
	    return providedSexInLastThreeMonthsBTi;
	}

	public void setProvidedSexInLastThreeMonthsBTi(Integer providedSexInLastThreeMonthsBTi) {
	    this.providedSexInLastThreeMonthsBTi = providedSexInLastThreeMonthsBTi;
	}

	public Integer getStiReportedInLastThreeMonthsBTi() {
	    return stiReportedInLastThreeMonthsBTi;
	}

	public void setStiReportedInLastThreeMonthsBTi(Integer stiReportedInLastThreeMonthsBTi) {
	    this.stiReportedInLastThreeMonthsBTi = stiReportedInLastThreeMonthsBTi;
	}

	public Integer getDrugsOrAlcoholBeforeOrDuringSexBTi() {
	    return drugsOrAlcoholBeforeOrDuringSexBTi;
	}

	public void setDrugsOrAlcoholBeforeOrDuringSexBTi(Integer drugsOrAlcoholBeforeOrDuringSexBTi) {
	    this.drugsOrAlcoholBeforeOrDuringSexBTi = drugsOrAlcoholBeforeOrDuringSexBTi;
	}

	public Integer getHivPositiveNotUnderARTBTi() {
	    return hivPositiveNotUnderARTBTi;
	}

	public void setHivPositiveNotUnderARTBTi(Integer hivPositiveNotUnderARTBTi) {
	    this.hivPositiveNotUnderARTBTi = hivPositiveNotUnderARTBTi;
	}

	public MiniMasterDto getAssementStatus() {
	    return assementStatus;
	}

	public void setAssementStatus(MiniMasterDto assementStatus) {
	    this.assementStatus = assementStatus;
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
