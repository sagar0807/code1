package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the ti_ben_ext_details database table.
 * 
 */
@Entity
@Table(name="ti_ben_ext_details")
@NamedQuery(name="TiBenExtDetail.findAll", query="SELECT t FROM TiBenExtDetail t")
public class TiBenExtDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="friday_avbl")
	private Boolean fridayAvbl;

	@Column(name="guardian_contact_number")
	private String guardianContactNumber;

	@Column(name="guardian_name")
	private String guardianName;

	@Column(name="hiv_art_adherence")
	private String hivArtAdherence;

	@Column(name="hiv_art_center")
	private String hivArtCenter;

	@Column(name="hiv_art_linked")
	private Boolean hivArtLinked;

	@Column(name="hiv_art_number")
	private String hivArtNumber;

	@Column(name="hiv_art_status")
	private String hivArtStatus;

	@Temporal(TemporalType.DATE)
	@Column(name="hiv_last_screen_date")
	private Date hivLastScreenDate;

	@Temporal(TemporalType.DATE)
	@Column(name="hiv_next_screen_date")
	private Date hivNextScreenDate;

	@Column(name="hiv_screening_status")
	private String hivScreeningStatus;

	@Column(name="hiv_status")
	private String hivStatus;

	@Column(name="is_outward_referal")
	private Boolean isOutwardReferal;

	@Column(name="is_syphilis_tested")
	private Boolean isSyphilisTested;

	@Column(name="is_syphilis_treatment_sti")
	private Boolean isSyphilisTreatmentSti;

	@Column(name="is_tb_diagnosed")
	private Boolean isTbDiagnosed;

	@Column(name="is_tb_symptoms")
	private Boolean isTbSymptoms;

	@Column(name="is_transfer")
	private Boolean isTransfer;

	@Column(name="is_transit")
	private Boolean isTransit;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="monday_avbl")
	private Boolean mondayAvbl;

	@Column(name="outside_the_state_no_of_days")
	private String outsideTheStateNoOfDays;

	@Column(name="outside_the_state_no_of_times")
	private String outsideTheStateNoOfTimes;

	@Column(name="referral_status")
	private String referralStatus;

	@Column(name="referred_facility")
	private String referredFacility;

	@Column(name="referred_to")
	private String referredTo;

	private String relation;

	@Column(name="saturday_avbl")
	private Boolean saturdayAvbl;

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

	@Column(name="thursday_avbl")
	private Boolean thursdayAvbl;

	@Temporal(TemporalType.DATE)
	@Column(name="transit_end_date")
	private Date transitEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name="transit_start_date")
	private Date transitStartDate;

	@Column(name="tuesday_avbl")
	private Boolean tuesdayAvbl;

	@Column(name="wednesday_avbl")
	private Boolean wednesdayAvbl;

	@Column(name="within_the_district_no_of_days")
	private String withinTheDistrictNoOfDays;

	@Column(name="within_the_district_no_of_times")
	private String withinTheDistrictNoOfTimes;

	@Column(name="within_the_state_no_of_days")
	private String withinTheStateNoOfDays;

	@Column(name="within_the_state_no_of_times")
	private String withinTheStateNoOfTimes;

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

	public TiBenExtDetail() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Boolean getFridayAvbl() {
		return this.fridayAvbl;
	}

	public void setFridayAvbl(Boolean fridayAvbl) {
		this.fridayAvbl = fridayAvbl;
	}

	public String getGuardianContactNumber() {
		return this.guardianContactNumber;
	}

	public void setGuardianContactNumber(String guardianContactNumber) {
		this.guardianContactNumber = guardianContactNumber;
	}

	public String getGuardianName() {
		return this.guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public String getHivArtAdherence() {
		return this.hivArtAdherence;
	}

	public void setHivArtAdherence(String hivArtAdherence) {
		this.hivArtAdherence = hivArtAdherence;
	}

	public String getHivArtCenter() {
		return this.hivArtCenter;
	}

	public void setHivArtCenter(String hivArtCenter) {
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

	public Date getHivLastScreenDate() {
		return this.hivLastScreenDate;
	}

	public void setHivLastScreenDate(Date hivLastScreenDate) {
		this.hivLastScreenDate = hivLastScreenDate;
	}

	public Date getHivNextScreenDate() {
		return this.hivNextScreenDate;
	}

	public void setHivNextScreenDate(Date hivNextScreenDate) {
		this.hivNextScreenDate = hivNextScreenDate;
	}

	public String getHivScreeningStatus() {
		return this.hivScreeningStatus;
	}

	public void setHivScreeningStatus(String hivScreeningStatus) {
		this.hivScreeningStatus = hivScreeningStatus;
	}

	public String getHivStatus() {
		return this.hivStatus;
	}

	public void setHivStatus(String hivStatus) {
		this.hivStatus = hivStatus;
	}

	public Boolean getIsOutwardReferal() {
		return this.isOutwardReferal;
	}

	public void setIsOutwardReferal(Boolean isOutwardReferal) {
		this.isOutwardReferal = isOutwardReferal;
	}

	public Boolean getIsSyphilisTested() {
		return this.isSyphilisTested;
	}

	public void setIsSyphilisTested(Boolean isSyphilisTested) {
		this.isSyphilisTested = isSyphilisTested;
	}

	public Boolean getIsSyphilisTreatmentSti() {
		return this.isSyphilisTreatmentSti;
	}

	public void setIsSyphilisTreatmentSti(Boolean isSyphilisTreatmentSti) {
		this.isSyphilisTreatmentSti = isSyphilisTreatmentSti;
	}

	public Boolean getIsTbDiagnosed() {
		return this.isTbDiagnosed;
	}

	public void setIsTbDiagnosed(Boolean isTbDiagnosed) {
		this.isTbDiagnosed = isTbDiagnosed;
	}

	public Boolean getIsTbSymptoms() {
		return this.isTbSymptoms;
	}

	public void setIsTbSymptoms(Boolean isTbSymptoms) {
		this.isTbSymptoms = isTbSymptoms;
	}

	public Boolean getIsTransfer() {
		return this.isTransfer;
	}

	public void setIsTransfer(Boolean isTransfer) {
		this.isTransfer = isTransfer;
	}

	public Boolean getIsTransit() {
		return this.isTransit;
	}

	public void setIsTransit(Boolean isTransit) {
		this.isTransit = isTransit;
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

	public Boolean getMondayAvbl() {
		return this.mondayAvbl;
	}

	public void setMondayAvbl(Boolean mondayAvbl) {
		this.mondayAvbl = mondayAvbl;
	}

	public String getOutsideTheStateNoOfDays() {
		return this.outsideTheStateNoOfDays;
	}

	public void setOutsideTheStateNoOfDays(String outsideTheStateNoOfDays) {
		this.outsideTheStateNoOfDays = outsideTheStateNoOfDays;
	}

	public String getOutsideTheStateNoOfTimes() {
		return this.outsideTheStateNoOfTimes;
	}

	public void setOutsideTheStateNoOfTimes(String outsideTheStateNoOfTimes) {
		this.outsideTheStateNoOfTimes = outsideTheStateNoOfTimes;
	}

	public String getReferralStatus() {
		return this.referralStatus;
	}

	public void setReferralStatus(String referralStatus) {
		this.referralStatus = referralStatus;
	}

	public String getReferredFacility() {
		return this.referredFacility;
	}

	public void setReferredFacility(String referredFacility) {
		this.referredFacility = referredFacility;
	}

	public String getReferredTo() {
		return this.referredTo;
	}

	public void setReferredTo(String referredTo) {
		this.referredTo = referredTo;
	}

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Boolean getSaturdayAvbl() {
		return this.saturdayAvbl;
	}

	public void setSaturdayAvbl(Boolean saturdayAvbl) {
		this.saturdayAvbl = saturdayAvbl;
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

	public Boolean getThursdayAvbl() {
		return this.thursdayAvbl;
	}

	public void setThursdayAvbl(Boolean thursdayAvbl) {
		this.thursdayAvbl = thursdayAvbl;
	}

	public Date getTransitEndDate() {
		return this.transitEndDate;
	}

	public void setTransitEndDate(Date transitEndDate) {
		this.transitEndDate = transitEndDate;
	}

	public Date getTransitStartDate() {
		return this.transitStartDate;
	}

	public void setTransitStartDate(Date transitStartDate) {
		this.transitStartDate = transitStartDate;
	}

	public Boolean getTuesdayAvbl() {
		return this.tuesdayAvbl;
	}

	public void setTuesdayAvbl(Boolean tuesdayAvbl) {
		this.tuesdayAvbl = tuesdayAvbl;
	}

	public Boolean getWednesdayAvbl() {
		return this.wednesdayAvbl;
	}

	public void setWednesdayAvbl(Boolean wednesdayAvbl) {
		this.wednesdayAvbl = wednesdayAvbl;
	}

	public String getWithinTheDistrictNoOfDays() {
		return this.withinTheDistrictNoOfDays;
	}

	public void setWithinTheDistrictNoOfDays(String withinTheDistrictNoOfDays) {
		this.withinTheDistrictNoOfDays = withinTheDistrictNoOfDays;
	}

	public String getWithinTheDistrictNoOfTimes() {
		return this.withinTheDistrictNoOfTimes;
	}

	public void setWithinTheDistrictNoOfTimes(String withinTheDistrictNoOfTimes) {
		this.withinTheDistrictNoOfTimes = withinTheDistrictNoOfTimes;
	}

	public String getWithinTheStateNoOfDays() {
		return this.withinTheStateNoOfDays;
	}

	public void setWithinTheStateNoOfDays(String withinTheStateNoOfDays) {
		this.withinTheStateNoOfDays = withinTheStateNoOfDays;
	}

	public String getWithinTheStateNoOfTimes() {
		return this.withinTheStateNoOfTimes;
	}

	public void setWithinTheStateNoOfTimes(String withinTheStateNoOfTimes) {
		this.withinTheStateNoOfTimes = withinTheStateNoOfTimes;
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