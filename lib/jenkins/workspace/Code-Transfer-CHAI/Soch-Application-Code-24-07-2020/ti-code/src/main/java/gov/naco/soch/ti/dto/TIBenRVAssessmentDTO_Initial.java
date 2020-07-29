package gov.naco.soch.ti.dto;

import java.time.LocalDate;
import java.util.Objects;

public class TIBenRVAssessmentDTO_Initial extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long facilityId;
	private Long beneficiaryId;
	private LocalDate dueDateOfAssessment;
	private Boolean isEarly;

	// private Integer ostId;

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

	private Boolean isActive;

	private Boolean isDelete;
	
	private LocalDate assessmentDateBTi;

	private Integer exposureToOtherSexualContactsBTi;

	private Integer providedSexInLastThreeMonthsBTi;

	private Integer stiReportedInLastThreeMonthsBTi;

	private Integer drugsOrAlcoholBeforeOrDuringSexBTi;

	private Integer hivPositiveNotUnderARTBTi;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	// public Integer getOstId() {
	// return ostId;
	// }
	//
	// public void setOstId(Integer ostId) {
	// this.ostId = ostId;
	// }

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

	public Boolean getIsEarly() {
	    return isEarly;
	}

	public void setIsEarly(Boolean isEarly) {
	    this.isEarly = isEarly;
	}

	public Integer getNeedlesSyringesRequirementPerWeek() {
		return needlesSyringesRequirementPerWeek;
	}

	public void setNeedlesSyringesRequirementPerWeek(Integer needlesSyringesRequirementPerWeek) {
		this.needlesSyringesRequirementPerWeek = needlesSyringesRequirementPerWeek;
	}

	public LocalDate getDueDateOfAssessment() {
		return dueDateOfAssessment;
	}

	public void setDueDateOfAssessment(LocalDate dueDateOfAssessment) {
		this.dueDateOfAssessment = dueDateOfAssessment;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		TIBenRVAssessmentDTO_Initial tIBenRVAssessmentDTO_Initial = (TIBenRVAssessmentDTO_Initial) o;
		if (tIBenRVAssessmentDTO_Initial.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), tIBenRVAssessmentDTO_Initial.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

}
