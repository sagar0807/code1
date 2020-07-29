package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the ti_core_beneficiary database table.
 * 
 */
@Entity
@Table(name="ti_core_beneficiary")
@NamedQuery(name="TiCoreBeneficiary.findAll", query="SELECT t FROM TiCoreBeneficiary t")
public class TiCoreBeneficiary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="alcohol_cons_days_in_week")
	private Integer alcoholConsDaysInWeek;

	@Column(name="avg_no_sexual_acts_upon_reg")
	private Integer avgNoSexualActsUponReg;

	@Column(name="beneficiary_activity_status")
	private String beneficiaryActivityStatus;

	@Column(name="beneficiary_type")
	private String beneficiaryType;

	private String category;

	@Column(name="client_status")
	private String clientStatus;

	@Column(name="consent_documented")
	private Boolean consentDocumented;

	@Column(name="consume_alcohol")
	private Boolean consumeAlcohol;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_reg")
	private Date dateOfReg;

	@Column(name="hiv_art_adherence")
	private String hivArtAdherence;

	@Column(name="hiv_art_center")
	private Integer hivArtCenter;

	@Column(name="hiv_art_linked")
	private Boolean hivArtLinked;

	@Column(name="hiv_art_number")
	private String hivArtNumber;

	@Column(name="hiv_art_status")
	private String hivArtStatus;

	@Temporal(TemporalType.DATE)
	@Column(name="hiv_next_screen_date")
	private Date hivNextScreenDate;

	@Column(name="hiv_status")
	private String hivStatus;

	@Column(name="hrg_primary_category")
	private String hrgPrimaryCategory;

	@Column(name="hrg_secondary_category")
	private String hrgSecondaryCategory;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_deleted")
	private Boolean isDeleted;

	@Column(name="is_friday_avbl")
	private Boolean isFridayAvbl;

	@Column(name="is_monday_avbl")
	private Boolean isMondayAvbl;

	@Column(name="is_saturday_avbl")
	private Boolean isSaturdayAvbl;

	@Column(name="is_thursday_avbl")
	private Boolean isThursdayAvbl;

	@Column(name="is_tuesday_avbl")
	private Boolean isTuesdayAvbl;

	@Column(name="is_wednesday_avbl")
	private Boolean isWednesdayAvbl;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="no_years_in_sex_work")
	private Integer noYearsInSexWork;

	@Column(name="number_of_partners")
	private Integer numberOfPartners;

	@Column(name="orw_code")
	private Integer orwCode;

	@Column(name="ost_code")
	private Integer ostCode;

	@Column(name="ost_status")
	private String ostStatus;

	@Column(name="other_employment_status")
	private String otherEmploymentStatus;

	@Column(name="outside_the_state_count")
	private Integer outsideTheStateCount;

	@Column(name="outside_the_state_days_count")
	private Integer outsideTheStateDaysCount;

	@Column(name="pe_code")
	private Integer peCode;

	@Column(name="regular_partners")
	private Integer regularPartners;

	@Column(name="sub_category")
	private String subCategory;

	@Temporal(TemporalType.DATE)
	@Column(name="syphilis_last_screen_date")
	private Date syphilisLastScreenDate;

	@Temporal(TemporalType.DATE)
	@Column(name="syphilis_next_screen_date")
	private Date syphilisNextScreenDate;

	@Column(name="syphilis_status")
	private String syphilisStatus;

	@Column(name="tb_conf_status")
	private String tbConfStatus;

	@Temporal(TemporalType.DATE)
	@Column(name="tb_last_screen_date")
	private Date tbLastScreenDate;

	@Column(name="tb_screening_status")
	private String tbScreeningStatus;

	@Column(name="ti_core_beneficiary_id")
	private Integer tiCoreBeneficiaryId;

	private String typology;

	@Column(name="within_the_district_count")
	private Integer withinTheDistrictCount;

	@Column(name="within_the_district_days_count")
	private Integer withinTheDistrictDaysCount;

	@Column(name="within_the_state_count")
	private Integer withinTheStateCount;

	@Column(name="within_the_state_days_count")
	private Integer withinTheStateDaysCount;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	public TiCoreBeneficiary() {
	}

	public Integer getAlcoholConsDaysInWeek() {
		return this.alcoholConsDaysInWeek;
	}

	public void setAlcoholConsDaysInWeek(Integer alcoholConsDaysInWeek) {
		this.alcoholConsDaysInWeek = alcoholConsDaysInWeek;
	}

	public Integer getAvgNoSexualActsUponReg() {
		return this.avgNoSexualActsUponReg;
	}

	public void setAvgNoSexualActsUponReg(Integer avgNoSexualActsUponReg) {
		this.avgNoSexualActsUponReg = avgNoSexualActsUponReg;
	}

	public String getBeneficiaryActivityStatus() {
		return this.beneficiaryActivityStatus;
	}

	public void setBeneficiaryActivityStatus(String beneficiaryActivityStatus) {
		this.beneficiaryActivityStatus = beneficiaryActivityStatus;
	}

	public String getBeneficiaryType() {
		return this.beneficiaryType;
	}

	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getClientStatus() {
		return this.clientStatus;
	}

	public void setClientStatus(String clientStatus) {
		this.clientStatus = clientStatus;
	}

	public Boolean getConsentDocumented() {
		return this.consentDocumented;
	}

	public void setConsentDocumented(Boolean consentDocumented) {
		this.consentDocumented = consentDocumented;
	}

	public Boolean getConsumeAlcohol() {
		return this.consumeAlcohol;
	}

	public void setConsumeAlcohol(Boolean consumeAlcohol) {
		this.consumeAlcohol = consumeAlcohol;
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

	public Date getDateOfReg() {
		return this.dateOfReg;
	}

	public void setDateOfReg(Date dateOfReg) {
		this.dateOfReg = dateOfReg;
	}

	public String getHivArtAdherence() {
		return this.hivArtAdherence;
	}

	public void setHivArtAdherence(String hivArtAdherence) {
		this.hivArtAdherence = hivArtAdherence;
	}

	public Integer getHivArtCenter() {
		return this.hivArtCenter;
	}

	public void setHivArtCenter(Integer hivArtCenter) {
		this.hivArtCenter = hivArtCenter;
	}

	public Boolean getHivArtLinked() {
		return this.hivArtLinked;
	}

	public void setHivArtLinked(Boolean hivArtLinked) {
		this.hivArtLinked = hivArtLinked;
	}

	public String getHivArtNumber() {
		return this.hivArtNumber;
	}

	public void setHivArtNumber(String hivArtNumber) {
		this.hivArtNumber = hivArtNumber;
	}

	public String getHivArtStatus() {
		return this.hivArtStatus;
	}

	public void setHivArtStatus(String hivArtStatus) {
		this.hivArtStatus = hivArtStatus;
	}

	public Date getHivNextScreenDate() {
		return this.hivNextScreenDate;
	}

	public void setHivNextScreenDate(Date hivNextScreenDate) {
		this.hivNextScreenDate = hivNextScreenDate;
	}

	public String getHivStatus() {
		return this.hivStatus;
	}

	public void setHivStatus(String hivStatus) {
		this.hivStatus = hivStatus;
	}

	public String getHrgPrimaryCategory() {
		return this.hrgPrimaryCategory;
	}

	public void setHrgPrimaryCategory(String hrgPrimaryCategory) {
		this.hrgPrimaryCategory = hrgPrimaryCategory;
	}

	public String getHrgSecondaryCategory() {
		return this.hrgSecondaryCategory;
	}

	public void setHrgSecondaryCategory(String hrgSecondaryCategory) {
		this.hrgSecondaryCategory = hrgSecondaryCategory;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Boolean getIsFridayAvbl() {
		return this.isFridayAvbl;
	}

	public void setIsFridayAvbl(Boolean isFridayAvbl) {
		this.isFridayAvbl = isFridayAvbl;
	}

	public Boolean getIsMondayAvbl() {
		return this.isMondayAvbl;
	}

	public void setIsMondayAvbl(Boolean isMondayAvbl) {
		this.isMondayAvbl = isMondayAvbl;
	}

	public Boolean getIsSaturdayAvbl() {
		return this.isSaturdayAvbl;
	}

	public void setIsSaturdayAvbl(Boolean isSaturdayAvbl) {
		this.isSaturdayAvbl = isSaturdayAvbl;
	}

	public Boolean getIsThursdayAvbl() {
		return this.isThursdayAvbl;
	}

	public void setIsThursdayAvbl(Boolean isThursdayAvbl) {
		this.isThursdayAvbl = isThursdayAvbl;
	}

	public Boolean getIsTuesdayAvbl() {
		return this.isTuesdayAvbl;
	}

	public void setIsTuesdayAvbl(Boolean isTuesdayAvbl) {
		this.isTuesdayAvbl = isTuesdayAvbl;
	}

	public Boolean getIsWednesdayAvbl() {
		return this.isWednesdayAvbl;
	}

	public void setIsWednesdayAvbl(Boolean isWednesdayAvbl) {
		this.isWednesdayAvbl = isWednesdayAvbl;
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

	public Integer getNoYearsInSexWork() {
		return this.noYearsInSexWork;
	}

	public void setNoYearsInSexWork(Integer noYearsInSexWork) {
		this.noYearsInSexWork = noYearsInSexWork;
	}

	public Integer getNumberOfPartners() {
		return this.numberOfPartners;
	}

	public void setNumberOfPartners(Integer numberOfPartners) {
		this.numberOfPartners = numberOfPartners;
	}

	public Integer getOrwCode() {
		return this.orwCode;
	}

	public void setOrwCode(Integer orwCode) {
		this.orwCode = orwCode;
	}

	public Integer getOstCode() {
		return this.ostCode;
	}

	public void setOstCode(Integer ostCode) {
		this.ostCode = ostCode;
	}

	public String getOstStatus() {
		return this.ostStatus;
	}

	public void setOstStatus(String ostStatus) {
		this.ostStatus = ostStatus;
	}

	public String getOtherEmploymentStatus() {
		return this.otherEmploymentStatus;
	}

	public void setOtherEmploymentStatus(String otherEmploymentStatus) {
		this.otherEmploymentStatus = otherEmploymentStatus;
	}

	public Integer getOutsideTheStateCount() {
		return this.outsideTheStateCount;
	}

	public void setOutsideTheStateCount(Integer outsideTheStateCount) {
		this.outsideTheStateCount = outsideTheStateCount;
	}

	public Integer getOutsideTheStateDaysCount() {
		return this.outsideTheStateDaysCount;
	}

	public void setOutsideTheStateDaysCount(Integer outsideTheStateDaysCount) {
		this.outsideTheStateDaysCount = outsideTheStateDaysCount;
	}

	public Integer getPeCode() {
		return this.peCode;
	}

	public void setPeCode(Integer peCode) {
		this.peCode = peCode;
	}

	public Integer getRegularPartners() {
		return this.regularPartners;
	}

	public void setRegularPartners(Integer regularPartners) {
		this.regularPartners = regularPartners;
	}

	public String getSubCategory() {
		return this.subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public Date getSyphilisLastScreenDate() {
		return this.syphilisLastScreenDate;
	}

	public void setSyphilisLastScreenDate(Date syphilisLastScreenDate) {
		this.syphilisLastScreenDate = syphilisLastScreenDate;
	}

	public Date getSyphilisNextScreenDate() {
		return this.syphilisNextScreenDate;
	}

	public void setSyphilisNextScreenDate(Date syphilisNextScreenDate) {
		this.syphilisNextScreenDate = syphilisNextScreenDate;
	}

	public String getSyphilisStatus() {
		return this.syphilisStatus;
	}

	public void setSyphilisStatus(String syphilisStatus) {
		this.syphilisStatus = syphilisStatus;
	}

	public String getTbConfStatus() {
		return this.tbConfStatus;
	}

	public void setTbConfStatus(String tbConfStatus) {
		this.tbConfStatus = tbConfStatus;
	}

	public Date getTbLastScreenDate() {
		return this.tbLastScreenDate;
	}

	public void setTbLastScreenDate(Date tbLastScreenDate) {
		this.tbLastScreenDate = tbLastScreenDate;
	}

	public String getTbScreeningStatus() {
		return this.tbScreeningStatus;
	}

	public void setTbScreeningStatus(String tbScreeningStatus) {
		this.tbScreeningStatus = tbScreeningStatus;
	}

	public Integer getTiCoreBeneficiaryId() {
		return this.tiCoreBeneficiaryId;
	}

	public void setTiCoreBeneficiaryId(Integer tiCoreBeneficiaryId) {
		this.tiCoreBeneficiaryId = tiCoreBeneficiaryId;
	}

	public String getTypology() {
		return this.typology;
	}

	public void setTypology(String typology) {
		this.typology = typology;
	}

	public Integer getWithinTheDistrictCount() {
		return this.withinTheDistrictCount;
	}

	public void setWithinTheDistrictCount(Integer withinTheDistrictCount) {
		this.withinTheDistrictCount = withinTheDistrictCount;
	}

	public Integer getWithinTheDistrictDaysCount() {
		return this.withinTheDistrictDaysCount;
	}

	public void setWithinTheDistrictDaysCount(Integer withinTheDistrictDaysCount) {
		this.withinTheDistrictDaysCount = withinTheDistrictDaysCount;
	}

	public Integer getWithinTheStateCount() {
		return this.withinTheStateCount;
	}

	public void setWithinTheStateCount(Integer withinTheStateCount) {
		this.withinTheStateCount = withinTheStateCount;
	}

	public Integer getWithinTheStateDaysCount() {
		return this.withinTheStateDaysCount;
	}

	public void setWithinTheStateDaysCount(Integer withinTheStateDaysCount) {
		this.withinTheStateDaysCount = withinTheStateDaysCount;
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

}