package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the ti_beneficiary database table.
 * 
 */
@Entity
@Table(name="ti_beneficiary")
@NamedQuery(name="TiBeneficiary.findAll", query="SELECT t FROM TiBeneficiary t")
public class TiBeneficiary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="alcohol_cons_days_in_week")
	private Integer alcoholConsDaysInWeek;

	@Column(name="avg_no_sexual_acts_upon_reg")
	private Integer avgNoSexualActsUponReg;

	@Column(name="ben_referred_from")
	private String benReferredFrom;

	@Column(name="beneficiary_activity_status")
	private String beneficiaryActivityStatus;

	@Column(name="beneficiary_type")
	private String beneficiaryType;

	private String category;

	@Column(name="condom_usage")
	private Boolean condomUsage;

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

	@Column(name="deleted_reason")
	private String deletedReason;

	@Column(name="duration_of_the_stays")
	private String durationOfTheStays;

	@Column(name="geo_latitude")
	private String geoLatitude;

	@Column(name="geo_longitude")
	private String geoLongitude;

	private Integer hotspot;

	@Column(name="hrg_primary_category")
	private String hrgPrimaryCategory;

	@Column(name="hrg_secondary_category")
	private String hrgSecondaryCategory;

	@Column(name="ib_treatments")
	private Integer ibTreatments;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_deleted")
	private Boolean isDeleted;

	@Column(name="lap_treatments")
	private Integer lapTreatments;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="no_of_sexual_activity")
	private Integer noOfSexualActivity;

	@Column(name="no_years_in_sex_work")
	private Integer noYearsInSexWork;

	@Column(name="number_of_partners")
	private String numberOfPartners;

	@Column(name="orw_code")
	private String orwCode;

	@Column(name="ost_code")
	private String ostCode;

	@Column(name="ost_status")
	private String ostStatus;

	@Column(name="other_employment_status")
	private String otherEmploymentStatus;

	@Column(name="pe_code")
	private String peCode;

	@Column(name="registration_place")
	private String registrationPlace;

	@Column(name="regular_partners")
	private String regularPartners;

	@Column(name="sex_other_than_spouse")
	private Boolean sexOtherThanSpouse;

	@Column(name="staying_with")
	private String stayingWith;

	@Column(name="sub_category")
	private String subCategory;

	@Column(name="ti_code")
	private String tiCode;

	@Column(name="type_of_mobility")
	private String typeOfMobility;

	private String typology;

	private String uid;

	//bi-directional many-to-one association to BeneficiaryReferral
	@OneToMany(mappedBy="tiBeneficiary")
	private Set<BeneficiaryReferral> beneficiaryReferrals;

	//bi-directional many-to-one association to TiBenChildDetail
	@OneToMany(mappedBy="tiBeneficiary")
	private Set<TiBenChildDetail> tiBenChildDetails;

	//bi-directional many-to-one association to TiBenCounselling
	@OneToMany(mappedBy="tiBeneficiary")
	private Set<TiBenCounselling> tiBenCounsellings;

	//bi-directional many-to-one association to TiBenExtDetail
	@OneToMany(mappedBy="tiBeneficiary")
	private Set<TiBenExtDetail> tiBenExtDetails;

	//bi-directional many-to-one association to TiBenFollowUp
	@OneToMany(mappedBy="tiBeneficiary")
	private Set<TiBenFollowUp> tiBenFollowUps;

	//bi-directional many-to-one association to TiBenRvAssessment
	@OneToMany(mappedBy="tiBeneficiary")
	private Set<TiBenRvAssessment> tiBenRvAssessments;

	//bi-directional many-to-one association to TiBenScrDetail
	@OneToMany(mappedBy="tiBeneficiary")
	private Set<TiBenScrDetail> tiBenScrDetails;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to TiBeneficiaryCommDi
	@OneToMany(mappedBy="tiBeneficiary")
	private Set<TiBeneficiaryCommDi> tiBeneficiaryCommDis;

	//bi-directional many-to-one association to TiOstDetail
	@OneToMany(mappedBy="tiBeneficiary")
	private Set<TiOstDetail> tiOstDetails;

	//bi-directional many-to-one association to TiStiTreatment
	@OneToMany(mappedBy="tiBeneficiary")
	private Set<TiStiTreatment> tiStiTreatments;

	//bi-directional many-to-one association to Transfer
	@OneToMany(mappedBy="tiBeneficiary")
	private Set<Transfer> transfers;

	public TiBeneficiary() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getBenReferredFrom() {
		return this.benReferredFrom;
	}

	public void setBenReferredFrom(String benReferredFrom) {
		this.benReferredFrom = benReferredFrom;
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

	public Boolean getCondomUsage() {
		return this.condomUsage;
	}

	public void setCondomUsage(Boolean condomUsage) {
		this.condomUsage = condomUsage;
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

	public String getDeletedReason() {
		return this.deletedReason;
	}

	public void setDeletedReason(String deletedReason) {
		this.deletedReason = deletedReason;
	}

	public String getDurationOfTheStays() {
		return this.durationOfTheStays;
	}

	public void setDurationOfTheStays(String durationOfTheStays) {
		this.durationOfTheStays = durationOfTheStays;
	}

	public String getGeoLatitude() {
		return this.geoLatitude;
	}

	public void setGeoLatitude(String geoLatitude) {
		this.geoLatitude = geoLatitude;
	}

	public String getGeoLongitude() {
		return this.geoLongitude;
	}

	public void setGeoLongitude(String geoLongitude) {
		this.geoLongitude = geoLongitude;
	}

	public Integer getHotspot() {
		return this.hotspot;
	}

	public void setHotspot(Integer hotspot) {
		this.hotspot = hotspot;
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

	public Integer getIbTreatments() {
		return this.ibTreatments;
	}

	public void setIbTreatments(Integer ibTreatments) {
		this.ibTreatments = ibTreatments;
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

	public Integer getLapTreatments() {
		return this.lapTreatments;
	}

	public void setLapTreatments(Integer lapTreatments) {
		this.lapTreatments = lapTreatments;
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

	public Integer getNoOfSexualActivity() {
		return this.noOfSexualActivity;
	}

	public void setNoOfSexualActivity(Integer noOfSexualActivity) {
		this.noOfSexualActivity = noOfSexualActivity;
	}

	public Integer getNoYearsInSexWork() {
		return this.noYearsInSexWork;
	}

	public void setNoYearsInSexWork(Integer noYearsInSexWork) {
		this.noYearsInSexWork = noYearsInSexWork;
	}

	public String getNumberOfPartners() {
		return this.numberOfPartners;
	}

	public void setNumberOfPartners(String numberOfPartners) {
		this.numberOfPartners = numberOfPartners;
	}

	public String getOrwCode() {
		return this.orwCode;
	}

	public void setOrwCode(String orwCode) {
		this.orwCode = orwCode;
	}

	public String getOstCode() {
		return this.ostCode;
	}

	public void setOstCode(String ostCode) {
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

	public String getPeCode() {
		return this.peCode;
	}

	public void setPeCode(String peCode) {
		this.peCode = peCode;
	}

	public String getRegistrationPlace() {
		return this.registrationPlace;
	}

	public void setRegistrationPlace(String registrationPlace) {
		this.registrationPlace = registrationPlace;
	}

	public String getRegularPartners() {
		return this.regularPartners;
	}

	public void setRegularPartners(String regularPartners) {
		this.regularPartners = regularPartners;
	}

	public Boolean getSexOtherThanSpouse() {
		return this.sexOtherThanSpouse;
	}

	public void setSexOtherThanSpouse(Boolean sexOtherThanSpouse) {
		this.sexOtherThanSpouse = sexOtherThanSpouse;
	}

	public String getStayingWith() {
		return this.stayingWith;
	}

	public void setStayingWith(String stayingWith) {
		this.stayingWith = stayingWith;
	}

	public String getSubCategory() {
		return this.subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getTiCode() {
		return this.tiCode;
	}

	public void setTiCode(String tiCode) {
		this.tiCode = tiCode;
	}

	public String getTypeOfMobility() {
		return this.typeOfMobility;
	}

	public void setTypeOfMobility(String typeOfMobility) {
		this.typeOfMobility = typeOfMobility;
	}

	public String getTypology() {
		return this.typology;
	}

	public void setTypology(String typology) {
		this.typology = typology;
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Set<BeneficiaryReferral> getBeneficiaryReferrals() {
		return this.beneficiaryReferrals;
	}

	public void setBeneficiaryReferrals(Set<BeneficiaryReferral> beneficiaryReferrals) {
		this.beneficiaryReferrals = beneficiaryReferrals;
	}

	public BeneficiaryReferral addBeneficiaryReferral(BeneficiaryReferral beneficiaryReferral) {
		getBeneficiaryReferrals().add(beneficiaryReferral);
		beneficiaryReferral.setTiBeneficiary(this);

		return beneficiaryReferral;
	}

	public BeneficiaryReferral removeBeneficiaryReferral(BeneficiaryReferral beneficiaryReferral) {
		getBeneficiaryReferrals().remove(beneficiaryReferral);
		beneficiaryReferral.setTiBeneficiary(null);

		return beneficiaryReferral;
	}

	public Set<TiBenChildDetail> getTiBenChildDetails() {
		return this.tiBenChildDetails;
	}

	public void setTiBenChildDetails(Set<TiBenChildDetail> tiBenChildDetails) {
		this.tiBenChildDetails = tiBenChildDetails;
	}

	public TiBenChildDetail addTiBenChildDetail(TiBenChildDetail tiBenChildDetail) {
		getTiBenChildDetails().add(tiBenChildDetail);
		tiBenChildDetail.setTiBeneficiary(this);

		return tiBenChildDetail;
	}

	public TiBenChildDetail removeTiBenChildDetail(TiBenChildDetail tiBenChildDetail) {
		getTiBenChildDetails().remove(tiBenChildDetail);
		tiBenChildDetail.setTiBeneficiary(null);

		return tiBenChildDetail;
	}

	public Set<TiBenCounselling> getTiBenCounsellings() {
		return this.tiBenCounsellings;
	}

	public void setTiBenCounsellings(Set<TiBenCounselling> tiBenCounsellings) {
		this.tiBenCounsellings = tiBenCounsellings;
	}

	public TiBenCounselling addTiBenCounselling(TiBenCounselling tiBenCounselling) {
		getTiBenCounsellings().add(tiBenCounselling);
		tiBenCounselling.setTiBeneficiary(this);

		return tiBenCounselling;
	}

	public TiBenCounselling removeTiBenCounselling(TiBenCounselling tiBenCounselling) {
		getTiBenCounsellings().remove(tiBenCounselling);
		tiBenCounselling.setTiBeneficiary(null);

		return tiBenCounselling;
	}

	public Set<TiBenExtDetail> getTiBenExtDetails() {
		return this.tiBenExtDetails;
	}

	public void setTiBenExtDetails(Set<TiBenExtDetail> tiBenExtDetails) {
		this.tiBenExtDetails = tiBenExtDetails;
	}

	public TiBenExtDetail addTiBenExtDetail(TiBenExtDetail tiBenExtDetail) {
		getTiBenExtDetails().add(tiBenExtDetail);
		tiBenExtDetail.setTiBeneficiary(this);

		return tiBenExtDetail;
	}

	public TiBenExtDetail removeTiBenExtDetail(TiBenExtDetail tiBenExtDetail) {
		getTiBenExtDetails().remove(tiBenExtDetail);
		tiBenExtDetail.setTiBeneficiary(null);

		return tiBenExtDetail;
	}

	public Set<TiBenFollowUp> getTiBenFollowUps() {
		return this.tiBenFollowUps;
	}

	public void setTiBenFollowUps(Set<TiBenFollowUp> tiBenFollowUps) {
		this.tiBenFollowUps = tiBenFollowUps;
	}

	public TiBenFollowUp addTiBenFollowUp(TiBenFollowUp tiBenFollowUp) {
		getTiBenFollowUps().add(tiBenFollowUp);
		tiBenFollowUp.setTiBeneficiary(this);

		return tiBenFollowUp;
	}

	public TiBenFollowUp removeTiBenFollowUp(TiBenFollowUp tiBenFollowUp) {
		getTiBenFollowUps().remove(tiBenFollowUp);
		tiBenFollowUp.setTiBeneficiary(null);

		return tiBenFollowUp;
	}

	public Set<TiBenRvAssessment> getTiBenRvAssessments() {
		return this.tiBenRvAssessments;
	}

	public void setTiBenRvAssessments(Set<TiBenRvAssessment> tiBenRvAssessments) {
		this.tiBenRvAssessments = tiBenRvAssessments;
	}

	public TiBenRvAssessment addTiBenRvAssessment(TiBenRvAssessment tiBenRvAssessment) {
		getTiBenRvAssessments().add(tiBenRvAssessment);
		tiBenRvAssessment.setTiBeneficiary(this);

		return tiBenRvAssessment;
	}

	public TiBenRvAssessment removeTiBenRvAssessment(TiBenRvAssessment tiBenRvAssessment) {
		getTiBenRvAssessments().remove(tiBenRvAssessment);
		tiBenRvAssessment.setTiBeneficiary(null);

		return tiBenRvAssessment;
	}

	public Set<TiBenScrDetail> getTiBenScrDetails() {
		return this.tiBenScrDetails;
	}

	public void setTiBenScrDetails(Set<TiBenScrDetail> tiBenScrDetails) {
		this.tiBenScrDetails = tiBenScrDetails;
	}

	public TiBenScrDetail addTiBenScrDetail(TiBenScrDetail tiBenScrDetail) {
		getTiBenScrDetails().add(tiBenScrDetail);
		tiBenScrDetail.setTiBeneficiary(this);

		return tiBenScrDetail;
	}

	public TiBenScrDetail removeTiBenScrDetail(TiBenScrDetail tiBenScrDetail) {
		getTiBenScrDetails().remove(tiBenScrDetail);
		tiBenScrDetail.setTiBeneficiary(null);

		return tiBenScrDetail;
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

	public Set<TiBeneficiaryCommDi> getTiBeneficiaryCommDis() {
		return this.tiBeneficiaryCommDis;
	}

	public void setTiBeneficiaryCommDis(Set<TiBeneficiaryCommDi> tiBeneficiaryCommDis) {
		this.tiBeneficiaryCommDis = tiBeneficiaryCommDis;
	}

	public TiBeneficiaryCommDi addTiBeneficiaryCommDi(TiBeneficiaryCommDi tiBeneficiaryCommDi) {
		getTiBeneficiaryCommDis().add(tiBeneficiaryCommDi);
		tiBeneficiaryCommDi.setTiBeneficiary(this);

		return tiBeneficiaryCommDi;
	}

	public TiBeneficiaryCommDi removeTiBeneficiaryCommDi(TiBeneficiaryCommDi tiBeneficiaryCommDi) {
		getTiBeneficiaryCommDis().remove(tiBeneficiaryCommDi);
		tiBeneficiaryCommDi.setTiBeneficiary(null);

		return tiBeneficiaryCommDi;
	}

	public Set<TiOstDetail> getTiOstDetails() {
		return this.tiOstDetails;
	}

	public void setTiOstDetails(Set<TiOstDetail> tiOstDetails) {
		this.tiOstDetails = tiOstDetails;
	}

	public TiOstDetail addTiOstDetail(TiOstDetail tiOstDetail) {
		getTiOstDetails().add(tiOstDetail);
		tiOstDetail.setTiBeneficiary(this);

		return tiOstDetail;
	}

	public TiOstDetail removeTiOstDetail(TiOstDetail tiOstDetail) {
		getTiOstDetails().remove(tiOstDetail);
		tiOstDetail.setTiBeneficiary(null);

		return tiOstDetail;
	}

	public Set<TiStiTreatment> getTiStiTreatments() {
		return this.tiStiTreatments;
	}

	public void setTiStiTreatments(Set<TiStiTreatment> tiStiTreatments) {
		this.tiStiTreatments = tiStiTreatments;
	}

	public TiStiTreatment addTiStiTreatment(TiStiTreatment tiStiTreatment) {
		getTiStiTreatments().add(tiStiTreatment);
		tiStiTreatment.setTiBeneficiary(this);

		return tiStiTreatment;
	}

	public TiStiTreatment removeTiStiTreatment(TiStiTreatment tiStiTreatment) {
		getTiStiTreatments().remove(tiStiTreatment);
		tiStiTreatment.setTiBeneficiary(null);

		return tiStiTreatment;
	}

	public Set<Transfer> getTransfers() {
		return this.transfers;
	}

	public void setTransfers(Set<Transfer> transfers) {
		this.transfers = transfers;
	}

	public Transfer addTransfer(Transfer transfer) {
		getTransfers().add(transfer);
		transfer.setTiBeneficiary(this);

		return transfer;
	}

	public Transfer removeTransfer(Transfer transfer) {
		getTransfers().remove(transfer);
		transfer.setTiBeneficiary(null);

		return transfer;
	}

}