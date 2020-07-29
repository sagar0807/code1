package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the ti_ben_rv_assessment database table.
 * 
 */
@Entity
@Table(name="ti_ben_rv_assessment")
@NamedQuery(name="TiBenRvAssessment.findAll", query="SELECT t FROM TiBenRvAssessment t")
public class TiBenRvAssessment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer alcohol;

	@Temporal(TemporalType.DATE)
	@Column(name="assessment_date")
	private Date assessmentDate;

	@Temporal(TemporalType.DATE)
	@Column(name="assessment_date_bti")
	private Date assessmentDateBti;

	@Column(name="assessment_pending")
	private Integer assessmentPending;

	@Column(name="condom_requirement_per_week")
	private Integer condomRequirementPerWeek;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="drugs_or_alcohol_before_or_during_sex_bti")
	private Integer drugsOrAlcoholBeforeOrDuringSexBti;

	@Temporal(TemporalType.DATE)
	@Column(name="due_date_of_assessment")
	private Date dueDateOfAssessment;

	@Column(name="exposure_to_other_sexual_contacts_bti")
	private Integer exposureToOtherSexualContactsBti;

	@Column(name="first_year_in_sex_work_and_below_age_of_25_years")
	private Integer firstYearInSexWorkAndBelowAgeOf25Years;

	@Column(name="high_number_of_drug_using_partners")
	private Integer highNumberOfDrugUsingPartners;

	@Column(name="high_number_of_sexual_encounters")
	private Integer highNumberOfSexualEncounters;

	@Column(name="hiv_positive_not_under_art_bti")
	private Integer hivPositiveNotUnderArtBti;

	@Column(name="injecting_greater_than_three_times")
	private Integer injectingGreaterThanThreeTimes;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="low_condom_use")
	private Integer lowCondomUse;

	@Column(name="mobility_from_one_hotspot_to_another")
	private Integer mobilityFromOneHotspotToAnother;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="needles_syringes_requirement_per_week")
	private Integer needlesSyringesRequirementPerWeek;

	@Column(name="provided_sex_in_last_three_months_bti")
	private Integer providedSexInLastThreeMonthsBti;

	@Column(name="sharing_of_needles_syringes")
	private Integer sharingOfNeedlesSyringes;

	@Column(name="sti_reported_in_last_three_months_bti")
	private Integer stiReportedInLastThreeMonthsBti;

	@Column(name="sti_reported_in_last_three_months_idu")
	private Integer stiReportedInLastThreeMonthsIdu;

	@Column(name="sti_reported_in_last_three_months_ti")
	private Integer stiReportedInLastThreeMonthsTi;

	@Column(name="unsafe_sex")
	private Integer unsafeSex;

	@Column(name="unsafe_sex_sex_with_non_regular_partner")
	private Integer unsafeSexSexWithNonRegularPartner;

	@Column(name="use_of_alcohol_and_other_drugs_apart_from_injections")
	private Integer useOfAlcoholAndOtherDrugsApartFromInjections;

	private Integer violence;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to TiBeneficiary
	@ManyToOne
	@JoinColumn(name="beneficiary_id")
	private TiBeneficiary tiBeneficiary;

	public TiBenRvAssessment() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAlcohol() {
		return this.alcohol;
	}

	public void setAlcohol(Integer alcohol) {
		this.alcohol = alcohol;
	}

	public Date getAssessmentDate() {
		return this.assessmentDate;
	}

	public void setAssessmentDate(Date assessmentDate) {
		this.assessmentDate = assessmentDate;
	}

	public Date getAssessmentDateBti() {
		return this.assessmentDateBti;
	}

	public void setAssessmentDateBti(Date assessmentDateBti) {
		this.assessmentDateBti = assessmentDateBti;
	}

	public Integer getAssessmentPending() {
		return this.assessmentPending;
	}

	public void setAssessmentPending(Integer assessmentPending) {
		this.assessmentPending = assessmentPending;
	}

	public Integer getCondomRequirementPerWeek() {
		return this.condomRequirementPerWeek;
	}

	public void setCondomRequirementPerWeek(Integer condomRequirementPerWeek) {
		this.condomRequirementPerWeek = condomRequirementPerWeek;
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

	public Integer getDrugsOrAlcoholBeforeOrDuringSexBti() {
		return this.drugsOrAlcoholBeforeOrDuringSexBti;
	}

	public void setDrugsOrAlcoholBeforeOrDuringSexBti(Integer drugsOrAlcoholBeforeOrDuringSexBti) {
		this.drugsOrAlcoholBeforeOrDuringSexBti = drugsOrAlcoholBeforeOrDuringSexBti;
	}

	public Date getDueDateOfAssessment() {
		return this.dueDateOfAssessment;
	}

	public void setDueDateOfAssessment(Date dueDateOfAssessment) {
		this.dueDateOfAssessment = dueDateOfAssessment;
	}

	public Integer getExposureToOtherSexualContactsBti() {
		return this.exposureToOtherSexualContactsBti;
	}

	public void setExposureToOtherSexualContactsBti(Integer exposureToOtherSexualContactsBti) {
		this.exposureToOtherSexualContactsBti = exposureToOtherSexualContactsBti;
	}

	public Integer getFirstYearInSexWorkAndBelowAgeOf25Years() {
		return this.firstYearInSexWorkAndBelowAgeOf25Years;
	}

	public void setFirstYearInSexWorkAndBelowAgeOf25Years(Integer firstYearInSexWorkAndBelowAgeOf25Years) {
		this.firstYearInSexWorkAndBelowAgeOf25Years = firstYearInSexWorkAndBelowAgeOf25Years;
	}

	public Integer getHighNumberOfDrugUsingPartners() {
		return this.highNumberOfDrugUsingPartners;
	}

	public void setHighNumberOfDrugUsingPartners(Integer highNumberOfDrugUsingPartners) {
		this.highNumberOfDrugUsingPartners = highNumberOfDrugUsingPartners;
	}

	public Integer getHighNumberOfSexualEncounters() {
		return this.highNumberOfSexualEncounters;
	}

	public void setHighNumberOfSexualEncounters(Integer highNumberOfSexualEncounters) {
		this.highNumberOfSexualEncounters = highNumberOfSexualEncounters;
	}

	public Integer getHivPositiveNotUnderArtBti() {
		return this.hivPositiveNotUnderArtBti;
	}

	public void setHivPositiveNotUnderArtBti(Integer hivPositiveNotUnderArtBti) {
		this.hivPositiveNotUnderArtBti = hivPositiveNotUnderArtBti;
	}

	public Integer getInjectingGreaterThanThreeTimes() {
		return this.injectingGreaterThanThreeTimes;
	}

	public void setInjectingGreaterThanThreeTimes(Integer injectingGreaterThanThreeTimes) {
		this.injectingGreaterThanThreeTimes = injectingGreaterThanThreeTimes;
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

	public Integer getLowCondomUse() {
		return this.lowCondomUse;
	}

	public void setLowCondomUse(Integer lowCondomUse) {
		this.lowCondomUse = lowCondomUse;
	}

	public Integer getMobilityFromOneHotspotToAnother() {
		return this.mobilityFromOneHotspotToAnother;
	}

	public void setMobilityFromOneHotspotToAnother(Integer mobilityFromOneHotspotToAnother) {
		this.mobilityFromOneHotspotToAnother = mobilityFromOneHotspotToAnother;
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

	public Integer getNeedlesSyringesRequirementPerWeek() {
		return this.needlesSyringesRequirementPerWeek;
	}

	public void setNeedlesSyringesRequirementPerWeek(Integer needlesSyringesRequirementPerWeek) {
		this.needlesSyringesRequirementPerWeek = needlesSyringesRequirementPerWeek;
	}

	public Integer getProvidedSexInLastThreeMonthsBti() {
		return this.providedSexInLastThreeMonthsBti;
	}

	public void setProvidedSexInLastThreeMonthsBti(Integer providedSexInLastThreeMonthsBti) {
		this.providedSexInLastThreeMonthsBti = providedSexInLastThreeMonthsBti;
	}

	public Integer getSharingOfNeedlesSyringes() {
		return this.sharingOfNeedlesSyringes;
	}

	public void setSharingOfNeedlesSyringes(Integer sharingOfNeedlesSyringes) {
		this.sharingOfNeedlesSyringes = sharingOfNeedlesSyringes;
	}

	public Integer getStiReportedInLastThreeMonthsBti() {
		return this.stiReportedInLastThreeMonthsBti;
	}

	public void setStiReportedInLastThreeMonthsBti(Integer stiReportedInLastThreeMonthsBti) {
		this.stiReportedInLastThreeMonthsBti = stiReportedInLastThreeMonthsBti;
	}

	public Integer getStiReportedInLastThreeMonthsIdu() {
		return this.stiReportedInLastThreeMonthsIdu;
	}

	public void setStiReportedInLastThreeMonthsIdu(Integer stiReportedInLastThreeMonthsIdu) {
		this.stiReportedInLastThreeMonthsIdu = stiReportedInLastThreeMonthsIdu;
	}

	public Integer getStiReportedInLastThreeMonthsTi() {
		return this.stiReportedInLastThreeMonthsTi;
	}

	public void setStiReportedInLastThreeMonthsTi(Integer stiReportedInLastThreeMonthsTi) {
		this.stiReportedInLastThreeMonthsTi = stiReportedInLastThreeMonthsTi;
	}

	public Integer getUnsafeSex() {
		return this.unsafeSex;
	}

	public void setUnsafeSex(Integer unsafeSex) {
		this.unsafeSex = unsafeSex;
	}

	public Integer getUnsafeSexSexWithNonRegularPartner() {
		return this.unsafeSexSexWithNonRegularPartner;
	}

	public void setUnsafeSexSexWithNonRegularPartner(Integer unsafeSexSexWithNonRegularPartner) {
		this.unsafeSexSexWithNonRegularPartner = unsafeSexSexWithNonRegularPartner;
	}

	public Integer getUseOfAlcoholAndOtherDrugsApartFromInjections() {
		return this.useOfAlcoholAndOtherDrugsApartFromInjections;
	}

	public void setUseOfAlcoholAndOtherDrugsApartFromInjections(Integer useOfAlcoholAndOtherDrugsApartFromInjections) {
		this.useOfAlcoholAndOtherDrugsApartFromInjections = useOfAlcoholAndOtherDrugsApartFromInjections;
	}

	public Integer getViolence() {
		return this.violence;
	}

	public void setViolence(Integer violence) {
		this.violence = violence;
	}

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public TiBeneficiary getTiBeneficiary() {
		return this.tiBeneficiary;
	}

	public void setTiBeneficiary(TiBeneficiary tiBeneficiary) {
		this.tiBeneficiary = tiBeneficiary;
	}

}