package gov.naco.soch.dto;

import java.time.LocalDate;

public class TiBeneficiaryrVassessmentDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer alcohol;
	private LocalDate assessmentDate;
	private Integer assessmentPending;
	private Integer condomRequirementPerWeekIdu;
	private Integer condomRequirementPerWeekTi;
	private LocalDate dueDateOfAssessment;
	private Integer firstYearInSexWorkAndBelowAgeOf25Years;
	private Integer highNumberOfDrugUsingPartners;
	private Integer highNumberOfSexualEncounters;
	private Integer injectingGreaterThanThreeTimes;
	private Boolean isActive;
	private Boolean isDelete;
	private Integer lowCondomUse;
	private Integer mobilityFromOneHotspotToAnother;
	private Integer needlesSyringesRequiremenPerWeek;
	private Integer sharingOfNeedlesSyringes;
	private Integer stiReportedInLastThreeMonthsIdu;
	private Integer stiReportedInLastThreeMonthsTi;
	private Integer unsafeSex;
	private Integer unsafeSexSexWithNonRegularPartner;
	private Integer useOfAlcoholAndOtherDrugsApartFromInjections;
	private Integer violence;
	private Integer ost_id;
	private Long beneficiaryId;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the alcohol
	 */
	public Integer getAlcohol() {
		return alcohol;
	}

	/**
	 * @param alcohol the alcohol to set
	 */
	public void setAlcohol(Integer alcohol) {
		this.alcohol = alcohol;
	}

	/**
	 * @return the assessmentDate
	 */
	public LocalDate getAssessmentDate() {
		return assessmentDate;
	}

	/**
	 * @param assessmentDate the assessmentDate to set
	 */
	public void setAssessmentDate(LocalDate assessmentDate) {
		this.assessmentDate = assessmentDate;
	}

	/**
	 * @return the assessmentPending
	 */
	public Integer getAssessmentPending() {
		return assessmentPending;
	}

	/**
	 * @param assessmentPending the assessmentPending to set
	 */
	public void setAssessmentPending(Integer assessmentPending) {
		this.assessmentPending = assessmentPending;
	}

	/**
	 * @return the condomRequirementPerWeekIdu
	 */
	public Integer getCondomRequirementPerWeekIdu() {
		return condomRequirementPerWeekIdu;
	}

	/**
	 * @param condomRequirementPerWeekIdu the condomRequirementPerWeekIdu to set
	 */
	public void setCondomRequirementPerWeekIdu(Integer condomRequirementPerWeekIdu) {
		this.condomRequirementPerWeekIdu = condomRequirementPerWeekIdu;
	}

	/**
	 * @return the condomRequirementPerWeekTi
	 */
	public Integer getCondomRequirementPerWeekTi() {
		return condomRequirementPerWeekTi;
	}

	/**
	 * @param condomRequirementPerWeekTi the condomRequirementPerWeekTi to set
	 */
	public void setCondomRequirementPerWeekTi(Integer condomRequirementPerWeekTi) {
		this.condomRequirementPerWeekTi = condomRequirementPerWeekTi;
	}

	/**
	 * @return the dueDateOfAssessment
	 */
	public LocalDate getDueDateOfAssessment() {
		return dueDateOfAssessment;
	}

	/**
	 * @param dueDateOfAssessment the dueDateOfAssessment to set
	 */
	public void setDueDateOfAssessment(LocalDate dueDateOfAssessment) {
		this.dueDateOfAssessment = dueDateOfAssessment;
	}

	/**
	 * @return the firstYearInSexWorkAndBelowAgeOf25Years
	 */
	public Integer getFirstYearInSexWorkAndBelowAgeOf25Years() {
		return firstYearInSexWorkAndBelowAgeOf25Years;
	}

	/**
	 * @param firstYearInSexWorkAndBelowAgeOf25Years the
	 *                                               firstYearInSexWorkAndBelowAgeOf25Years
	 *                                               to set
	 */
	public void setFirstYearInSexWorkAndBelowAgeOf25Years(Integer firstYearInSexWorkAndBelowAgeOf25Years) {
		this.firstYearInSexWorkAndBelowAgeOf25Years = firstYearInSexWorkAndBelowAgeOf25Years;
	}

	/**
	 * @return the highNumberOfDrugUsingPartners
	 */
	public Integer getHighNumberOfDrugUsingPartners() {
		return highNumberOfDrugUsingPartners;
	}

	/**
	 * @param highNumberOfDrugUsingPartners the highNumberOfDrugUsingPartners to set
	 */
	public void setHighNumberOfDrugUsingPartners(Integer highNumberOfDrugUsingPartners) {
		this.highNumberOfDrugUsingPartners = highNumberOfDrugUsingPartners;
	}

	/**
	 * @return the highNumberOfSexualEncounters
	 */
	public Integer getHighNumberOfSexualEncounters() {
		return highNumberOfSexualEncounters;
	}

	/**
	 * @param highNumberOfSexualEncounters the highNumberOfSexualEncounters to set
	 */
	public void setHighNumberOfSexualEncounters(Integer highNumberOfSexualEncounters) {
		this.highNumberOfSexualEncounters = highNumberOfSexualEncounters;
	}

	/**
	 * @return the injectingGreaterThanThreeTimes
	 */
	public Integer getInjectingGreaterThanThreeTimes() {
		return injectingGreaterThanThreeTimes;
	}

	/**
	 * @param injectingGreaterThanThreeTimes the injectingGreaterThanThreeTimes to
	 *                                       set
	 */
	public void setInjectingGreaterThanThreeTimes(Integer injectingGreaterThanThreeTimes) {
		this.injectingGreaterThanThreeTimes = injectingGreaterThanThreeTimes;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the isDelete
	 */
	public Boolean getIsDelete() {
		return isDelete;
	}

	/**
	 * @param isDelete the isDelete to set
	 */
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	/**
	 * @return the lowCondomUse
	 */
	public Integer getLowCondomUse() {
		return lowCondomUse;
	}

	/**
	 * @param lowCondomUse the lowCondomUse to set
	 */
	public void setLowCondomUse(Integer lowCondomUse) {
		this.lowCondomUse = lowCondomUse;
	}

	/**
	 * @return the mobilityFromOneHotspotToAnother
	 */
	public Integer getMobilityFromOneHotspotToAnother() {
		return mobilityFromOneHotspotToAnother;
	}

	/**
	 * @param mobilityFromOneHotspotToAnother the mobilityFromOneHotspotToAnother to
	 *                                        set
	 */
	public void setMobilityFromOneHotspotToAnother(Integer mobilityFromOneHotspotToAnother) {
		this.mobilityFromOneHotspotToAnother = mobilityFromOneHotspotToAnother;
	}

	/**
	 * @return the needlesSyringesRequiremenPerWeek
	 */
	public Integer getNeedlesSyringesRequiremenPerWeek() {
		return needlesSyringesRequiremenPerWeek;
	}

	/**
	 * @param needlesSyringesRequiremenPerWeek the needlesSyringesRequiremenPerWeek
	 *                                         to set
	 */
	public void setNeedlesSyringesRequiremenPerWeek(Integer needlesSyringesRequiremenPerWeek) {
		this.needlesSyringesRequiremenPerWeek = needlesSyringesRequiremenPerWeek;
	}

	/**
	 * @return the sharingOfNeedlesSyringes
	 */
	public Integer getSharingOfNeedlesSyringes() {
		return sharingOfNeedlesSyringes;
	}

	/**
	 * @param sharingOfNeedlesSyringes the sharingOfNeedlesSyringes to set
	 */
	public void setSharingOfNeedlesSyringes(Integer sharingOfNeedlesSyringes) {
		this.sharingOfNeedlesSyringes = sharingOfNeedlesSyringes;
	}

	/**
	 * @return the stiReportedInLastThreeMonthsIdu
	 */
	public Integer getStiReportedInLastThreeMonthsIdu() {
		return stiReportedInLastThreeMonthsIdu;
	}

	/**
	 * @param stiReportedInLastThreeMonthsIdu the stiReportedInLastThreeMonthsIdu to
	 *                                        set
	 */
	public void setStiReportedInLastThreeMonthsIdu(Integer stiReportedInLastThreeMonthsIdu) {
		this.stiReportedInLastThreeMonthsIdu = stiReportedInLastThreeMonthsIdu;
	}

	/**
	 * @return the stiReportedInLastThreeMonthsTi
	 */
	public Integer getStiReportedInLastThreeMonthsTi() {
		return stiReportedInLastThreeMonthsTi;
	}

	/**
	 * @param stiReportedInLastThreeMonthsTi the stiReportedInLastThreeMonthsTi to
	 *                                       set
	 */
	public void setStiReportedInLastThreeMonthsTi(Integer stiReportedInLastThreeMonthsTi) {
		this.stiReportedInLastThreeMonthsTi = stiReportedInLastThreeMonthsTi;
	}

	/**
	 * @return the unsafeSex
	 */
	public Integer getUnsafeSex() {
		return unsafeSex;
	}

	/**
	 * @param unsafeSex the unsafeSex to set
	 */
	public void setUnsafeSex(Integer unsafeSex) {
		this.unsafeSex = unsafeSex;
	}

	/**
	 * @return the unsafeSexSexWithNonRegularPartner
	 */
	public Integer getUnsafeSexSexWithNonRegularPartner() {
		return unsafeSexSexWithNonRegularPartner;
	}

	/**
	 * @param unsafeSexSexWithNonRegularPartner the
	 *                                          unsafeSexSexWithNonRegularPartner to
	 *                                          set
	 */
	public void setUnsafeSexSexWithNonRegularPartner(Integer unsafeSexSexWithNonRegularPartner) {
		this.unsafeSexSexWithNonRegularPartner = unsafeSexSexWithNonRegularPartner;
	}

	/**
	 * @return the useOfAlcoholAndOtherDrugsApartFromInjections
	 */
	public Integer getUseOfAlcoholAndOtherDrugsApartFromInjections() {
		return useOfAlcoholAndOtherDrugsApartFromInjections;
	}

	/**
	 * @param useOfAlcoholAndOtherDrugsApartFromInjections the
	 *                                                     useOfAlcoholAndOtherDrugsApartFromInjections
	 *                                                     to set
	 */
	public void setUseOfAlcoholAndOtherDrugsApartFromInjections(Integer useOfAlcoholAndOtherDrugsApartFromInjections) {
		this.useOfAlcoholAndOtherDrugsApartFromInjections = useOfAlcoholAndOtherDrugsApartFromInjections;
	}

	/**
	 * @return the violence
	 */
	public Integer getViolence() {
		return violence;
	}

	/**
	 * @param violence the violence to set
	 */
	public void setViolence(Integer violence) {
		this.violence = violence;
	}

	/**
	 * @return the ost_id
	 */
	public Integer getOst_id() {
		return ost_id;
	}

	/**
	 * @param ost_id the ost_id to set
	 */
	public void setOst_id(Integer ost_id) {
		this.ost_id = ost_id;
	}

	/**
	 * @return the beneficiaryId
	 */
	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	/**
	 * @param beneficiaryId the beneficiaryId to set
	 */
	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TiBeneficiaryrVassessmentDto [id=" + id + ", alcohol=" + alcohol + ", assessmentDate=" + assessmentDate
				+ ", assessmentPending=" + assessmentPending + ", condomRequirementPerWeekIdu="
				+ condomRequirementPerWeekIdu + ", condomRequirementPerWeekTi=" + condomRequirementPerWeekTi
				+ ", dueDateOfAssessment=" + dueDateOfAssessment + ", firstYearInSexWorkAndBelowAgeOf25Years="
				+ firstYearInSexWorkAndBelowAgeOf25Years + ", highNumberOfDrugUsingPartners="
				+ highNumberOfDrugUsingPartners + ", highNumberOfSexualEncounters=" + highNumberOfSexualEncounters
				+ ", injectingGreaterThanThreeTimes=" + injectingGreaterThanThreeTimes + ", isActive=" + isActive
				+ ", isDelete=" + isDelete + ", lowCondomUse=" + lowCondomUse + ", mobilityFromOneHotspotToAnother="
				+ mobilityFromOneHotspotToAnother + ", needlesSyringesRequiremenPerWeek="
				+ needlesSyringesRequiremenPerWeek + ", sharingOfNeedlesSyringes=" + sharingOfNeedlesSyringes
				+ ", stiReportedInLastThreeMonthsIdu=" + stiReportedInLastThreeMonthsIdu
				+ ", stiReportedInLastThreeMonthsTi=" + stiReportedInLastThreeMonthsTi + ", unsafeSex=" + unsafeSex
				+ ", unsafeSexSexWithNonRegularPartner=" + unsafeSexSexWithNonRegularPartner
				+ ", useOfAlcoholAndOtherDrugsApartFromInjections=" + useOfAlcoholAndOtherDrugsApartFromInjections
				+ ", violence=" + violence + ", ost_id=" + ost_id + ", beneficiaryId=" + beneficiaryId + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TiBeneficiaryrVassessmentDto other = (TiBeneficiaryrVassessmentDto) obj;
		if (alcohol == null) {
			if (other.alcohol != null)
				return false;
		} else if (!alcohol.equals(other.alcohol))
			return false;
		if (assessmentDate == null) {
			if (other.assessmentDate != null)
				return false;
		} else if (!assessmentDate.equals(other.assessmentDate))
			return false;
		if (assessmentPending == null) {
			if (other.assessmentPending != null)
				return false;
		} else if (!assessmentPending.equals(other.assessmentPending))
			return false;
		if (beneficiaryId == null) {
			if (other.beneficiaryId != null)
				return false;
		} else if (!beneficiaryId.equals(other.beneficiaryId))
			return false;
		if (condomRequirementPerWeekIdu == null) {
			if (other.condomRequirementPerWeekIdu != null)
				return false;
		} else if (!condomRequirementPerWeekIdu.equals(other.condomRequirementPerWeekIdu))
			return false;
		if (condomRequirementPerWeekTi == null) {
			if (other.condomRequirementPerWeekTi != null)
				return false;
		} else if (!condomRequirementPerWeekTi.equals(other.condomRequirementPerWeekTi))
			return false;
		if (dueDateOfAssessment == null) {
			if (other.dueDateOfAssessment != null)
				return false;
		} else if (!dueDateOfAssessment.equals(other.dueDateOfAssessment))
			return false;
		if (firstYearInSexWorkAndBelowAgeOf25Years == null) {
			if (other.firstYearInSexWorkAndBelowAgeOf25Years != null)
				return false;
		} else if (!firstYearInSexWorkAndBelowAgeOf25Years.equals(other.firstYearInSexWorkAndBelowAgeOf25Years))
			return false;
		if (highNumberOfDrugUsingPartners == null) {
			if (other.highNumberOfDrugUsingPartners != null)
				return false;
		} else if (!highNumberOfDrugUsingPartners.equals(other.highNumberOfDrugUsingPartners))
			return false;
		if (highNumberOfSexualEncounters == null) {
			if (other.highNumberOfSexualEncounters != null)
				return false;
		} else if (!highNumberOfSexualEncounters.equals(other.highNumberOfSexualEncounters))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (injectingGreaterThanThreeTimes == null) {
			if (other.injectingGreaterThanThreeTimes != null)
				return false;
		} else if (!injectingGreaterThanThreeTimes.equals(other.injectingGreaterThanThreeTimes))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (isDelete == null) {
			if (other.isDelete != null)
				return false;
		} else if (!isDelete.equals(other.isDelete))
			return false;
		if (lowCondomUse == null) {
			if (other.lowCondomUse != null)
				return false;
		} else if (!lowCondomUse.equals(other.lowCondomUse))
			return false;
		if (mobilityFromOneHotspotToAnother == null) {
			if (other.mobilityFromOneHotspotToAnother != null)
				return false;
		} else if (!mobilityFromOneHotspotToAnother.equals(other.mobilityFromOneHotspotToAnother))
			return false;
		if (needlesSyringesRequiremenPerWeek == null) {
			if (other.needlesSyringesRequiremenPerWeek != null)
				return false;
		} else if (!needlesSyringesRequiremenPerWeek.equals(other.needlesSyringesRequiremenPerWeek))
			return false;
		if (ost_id == null) {
			if (other.ost_id != null)
				return false;
		} else if (!ost_id.equals(other.ost_id))
			return false;
		if (sharingOfNeedlesSyringes == null) {
			if (other.sharingOfNeedlesSyringes != null)
				return false;
		} else if (!sharingOfNeedlesSyringes.equals(other.sharingOfNeedlesSyringes))
			return false;
		if (stiReportedInLastThreeMonthsIdu == null) {
			if (other.stiReportedInLastThreeMonthsIdu != null)
				return false;
		} else if (!stiReportedInLastThreeMonthsIdu.equals(other.stiReportedInLastThreeMonthsIdu))
			return false;
		if (stiReportedInLastThreeMonthsTi == null) {
			if (other.stiReportedInLastThreeMonthsTi != null)
				return false;
		} else if (!stiReportedInLastThreeMonthsTi.equals(other.stiReportedInLastThreeMonthsTi))
			return false;
		if (unsafeSex == null) {
			if (other.unsafeSex != null)
				return false;
		} else if (!unsafeSex.equals(other.unsafeSex))
			return false;
		if (unsafeSexSexWithNonRegularPartner == null) {
			if (other.unsafeSexSexWithNonRegularPartner != null)
				return false;
		} else if (!unsafeSexSexWithNonRegularPartner.equals(other.unsafeSexSexWithNonRegularPartner))
			return false;
		if (useOfAlcoholAndOtherDrugsApartFromInjections == null) {
			if (other.useOfAlcoholAndOtherDrugsApartFromInjections != null)
				return false;
		} else if (!useOfAlcoholAndOtherDrugsApartFromInjections
				.equals(other.useOfAlcoholAndOtherDrugsApartFromInjections))
			return false;
		if (violence == null) {
			if (other.violence != null)
				return false;
		} else if (!violence.equals(other.violence))
			return false;
		return true;
	}

}
