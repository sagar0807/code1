package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the ti_ost_beneficiary database table.
 * 
 */
@Entity
@Table(name="ti_ost_beneficiary")
@NamedQuery(name="TiOstBeneficiary.findAll", query="SELECT t FROM TiOstBeneficiary t")
public class TiOstBeneficiary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="consent_documented")
	private Boolean consentDocumented;

	@Temporal(TemporalType.DATE)
	@Column(name="consent_taken_date")
	private Date consentTakenDate;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="deleted_reason")
	private String deletedReason;

	private Integer followups;

	@Column(name="guardian_contact_number")
	private String guardianContactNumber;

	@Column(name="guardian_name")
	private String guardianName;

	@Column(name="guardian_relationship_type")
	private Integer guardianRelationshipType;

	@Column(name="hotspot_id")
	private Integer hotspotId;

	@Column(name="hrg_primary_category")
	private Integer hrgPrimaryCategory;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="is_on_dot")
	private Boolean isOnDot;

	@Column(name="is_tb_diagnosed")
	private Boolean isTbDiagnosed;

	@Column(name="is_tested_for_syphilis")
	private Boolean isTestedForSyphilis;

	@Column(name="is_transfer_out")
	private Boolean isTransferOut;

	@Column(name="is_transit")
	private Boolean isTransit;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="number_of_partners")
	private Integer numberOfPartners;

	@Column(name="ost_code")
	private String ostCode;

	@Column(name="ost_number")
	private String ostNumber;

	@Column(name="ost_status")
	private Integer ostStatus;

	@Column(name="received_sti_treatment")
	private Boolean receivedStiTreatment;

	@Column(name="referred_from")
	private Integer referredFrom;

	@Temporal(TemporalType.DATE)
	@Column(name="registration_date")
	private Date registrationDate;

	@Column(name="regular_partners")
	private Boolean regularPartners;

	@Column(name="satellite_unlink_reason")
	private String satelliteUnlinkReason;

	@Temporal(TemporalType.DATE)
	@Column(name="transit_end_date")
	private Date transitEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name="transit_start_date")
	private Date transitStartDate;

	//bi-directional many-to-one association to BeneficiaryTransitFacility
	@OneToMany(mappedBy="tiOstBeneficiary")
	private Set<BeneficiaryTransitFacility> beneficiaryTransitFacilities;

	//bi-directional many-to-one association to FacilityLinkedFacilityBeneficiary
	@OneToMany(mappedBy="tiOstBeneficiary")
	private Set<FacilityLinkedFacilityBeneficiary> facilityLinkedFacilityBeneficiaries;

	//bi-directional many-to-one association to TiBeneficiaryDispensationStatus
	@OneToMany(mappedBy="tiOstBeneficiary")
	private Set<TiBeneficiaryDispensationStatus> tiBeneficiaryDispensationStatuses;

	//bi-directional many-to-one association to TiOstAssessment
	@OneToMany(mappedBy="tiOstBeneficiary")
	private Set<TiOstAssessment> tiOstAssessments;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="active_address_id")
	private Address address;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="facility_id")
	private Facility facility1;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="linked_facility_id")
	private Facility facility2;

	//bi-directional many-to-one association to TiOstDispensationItem
	@OneToMany(mappedBy="tiOstBeneficiary")
	private Set<TiOstDispensationItem> tiOstDispensationItems;

	//bi-directional many-to-one association to TiOstFollowUp
	@OneToMany(mappedBy="tiOstBeneficiary")
	private Set<TiOstFollowUp> tiOstFollowUps;

	//bi-directional many-to-one association to TiOstPrescription
	@OneToMany(mappedBy="tiOstBeneficiary")
	private Set<TiOstPrescription> tiOstPrescriptions;

	public TiOstBeneficiary() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getConsentDocumented() {
		return this.consentDocumented;
	}

	public void setConsentDocumented(Boolean consentDocumented) {
		this.consentDocumented = consentDocumented;
	}

	public Date getConsentTakenDate() {
		return this.consentTakenDate;
	}

	public void setConsentTakenDate(Date consentTakenDate) {
		this.consentTakenDate = consentTakenDate;
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

	public String getDeletedReason() {
		return this.deletedReason;
	}

	public void setDeletedReason(String deletedReason) {
		this.deletedReason = deletedReason;
	}

	public Integer getFollowups() {
		return this.followups;
	}

	public void setFollowups(Integer followups) {
		this.followups = followups;
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

	public Integer getGuardianRelationshipType() {
		return this.guardianRelationshipType;
	}

	public void setGuardianRelationshipType(Integer guardianRelationshipType) {
		this.guardianRelationshipType = guardianRelationshipType;
	}

	public Integer getHotspotId() {
		return this.hotspotId;
	}

	public void setHotspotId(Integer hotspotId) {
		this.hotspotId = hotspotId;
	}

	public Integer getHrgPrimaryCategory() {
		return this.hrgPrimaryCategory;
	}

	public void setHrgPrimaryCategory(Integer hrgPrimaryCategory) {
		this.hrgPrimaryCategory = hrgPrimaryCategory;
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

	public Boolean getIsOnDot() {
		return this.isOnDot;
	}

	public void setIsOnDot(Boolean isOnDot) {
		this.isOnDot = isOnDot;
	}

	public Boolean getIsTbDiagnosed() {
		return this.isTbDiagnosed;
	}

	public void setIsTbDiagnosed(Boolean isTbDiagnosed) {
		this.isTbDiagnosed = isTbDiagnosed;
	}

	public Boolean getIsTestedForSyphilis() {
		return this.isTestedForSyphilis;
	}

	public void setIsTestedForSyphilis(Boolean isTestedForSyphilis) {
		this.isTestedForSyphilis = isTestedForSyphilis;
	}

	public Boolean getIsTransferOut() {
		return this.isTransferOut;
	}

	public void setIsTransferOut(Boolean isTransferOut) {
		this.isTransferOut = isTransferOut;
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

	public Integer getNumberOfPartners() {
		return this.numberOfPartners;
	}

	public void setNumberOfPartners(Integer numberOfPartners) {
		this.numberOfPartners = numberOfPartners;
	}

	public String getOstCode() {
		return this.ostCode;
	}

	public void setOstCode(String ostCode) {
		this.ostCode = ostCode;
	}

	public String getOstNumber() {
		return this.ostNumber;
	}

	public void setOstNumber(String ostNumber) {
		this.ostNumber = ostNumber;
	}

	public Integer getOstStatus() {
		return this.ostStatus;
	}

	public void setOstStatus(Integer ostStatus) {
		this.ostStatus = ostStatus;
	}

	public Boolean getReceivedStiTreatment() {
		return this.receivedStiTreatment;
	}

	public void setReceivedStiTreatment(Boolean receivedStiTreatment) {
		this.receivedStiTreatment = receivedStiTreatment;
	}

	public Integer getReferredFrom() {
		return this.referredFrom;
	}

	public void setReferredFrom(Integer referredFrom) {
		this.referredFrom = referredFrom;
	}

	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Boolean getRegularPartners() {
		return this.regularPartners;
	}

	public void setRegularPartners(Boolean regularPartners) {
		this.regularPartners = regularPartners;
	}

	public String getSatelliteUnlinkReason() {
		return this.satelliteUnlinkReason;
	}

	public void setSatelliteUnlinkReason(String satelliteUnlinkReason) {
		this.satelliteUnlinkReason = satelliteUnlinkReason;
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

	public Set<BeneficiaryTransitFacility> getBeneficiaryTransitFacilities() {
		return this.beneficiaryTransitFacilities;
	}

	public void setBeneficiaryTransitFacilities(Set<BeneficiaryTransitFacility> beneficiaryTransitFacilities) {
		this.beneficiaryTransitFacilities = beneficiaryTransitFacilities;
	}

	public BeneficiaryTransitFacility addBeneficiaryTransitFacility(BeneficiaryTransitFacility beneficiaryTransitFacility) {
		getBeneficiaryTransitFacilities().add(beneficiaryTransitFacility);
		beneficiaryTransitFacility.setTiOstBeneficiary(this);

		return beneficiaryTransitFacility;
	}

	public BeneficiaryTransitFacility removeBeneficiaryTransitFacility(BeneficiaryTransitFacility beneficiaryTransitFacility) {
		getBeneficiaryTransitFacilities().remove(beneficiaryTransitFacility);
		beneficiaryTransitFacility.setTiOstBeneficiary(null);

		return beneficiaryTransitFacility;
	}

	public Set<FacilityLinkedFacilityBeneficiary> getFacilityLinkedFacilityBeneficiaries() {
		return this.facilityLinkedFacilityBeneficiaries;
	}

	public void setFacilityLinkedFacilityBeneficiaries(Set<FacilityLinkedFacilityBeneficiary> facilityLinkedFacilityBeneficiaries) {
		this.facilityLinkedFacilityBeneficiaries = facilityLinkedFacilityBeneficiaries;
	}

	public FacilityLinkedFacilityBeneficiary addFacilityLinkedFacilityBeneficiary(FacilityLinkedFacilityBeneficiary facilityLinkedFacilityBeneficiary) {
		getFacilityLinkedFacilityBeneficiaries().add(facilityLinkedFacilityBeneficiary);
		facilityLinkedFacilityBeneficiary.setTiOstBeneficiary(this);

		return facilityLinkedFacilityBeneficiary;
	}

	public FacilityLinkedFacilityBeneficiary removeFacilityLinkedFacilityBeneficiary(FacilityLinkedFacilityBeneficiary facilityLinkedFacilityBeneficiary) {
		getFacilityLinkedFacilityBeneficiaries().remove(facilityLinkedFacilityBeneficiary);
		facilityLinkedFacilityBeneficiary.setTiOstBeneficiary(null);

		return facilityLinkedFacilityBeneficiary;
	}

	public Set<TiBeneficiaryDispensationStatus> getTiBeneficiaryDispensationStatuses() {
		return this.tiBeneficiaryDispensationStatuses;
	}

	public void setTiBeneficiaryDispensationStatuses(Set<TiBeneficiaryDispensationStatus> tiBeneficiaryDispensationStatuses) {
		this.tiBeneficiaryDispensationStatuses = tiBeneficiaryDispensationStatuses;
	}

	public TiBeneficiaryDispensationStatus addTiBeneficiaryDispensationStatus(TiBeneficiaryDispensationStatus tiBeneficiaryDispensationStatus) {
		getTiBeneficiaryDispensationStatuses().add(tiBeneficiaryDispensationStatus);
		tiBeneficiaryDispensationStatus.setTiOstBeneficiary(this);

		return tiBeneficiaryDispensationStatus;
	}

	public TiBeneficiaryDispensationStatus removeTiBeneficiaryDispensationStatus(TiBeneficiaryDispensationStatus tiBeneficiaryDispensationStatus) {
		getTiBeneficiaryDispensationStatuses().remove(tiBeneficiaryDispensationStatus);
		tiBeneficiaryDispensationStatus.setTiOstBeneficiary(null);

		return tiBeneficiaryDispensationStatus;
	}

	public Set<TiOstAssessment> getTiOstAssessments() {
		return this.tiOstAssessments;
	}

	public void setTiOstAssessments(Set<TiOstAssessment> tiOstAssessments) {
		this.tiOstAssessments = tiOstAssessments;
	}

	public TiOstAssessment addTiOstAssessment(TiOstAssessment tiOstAssessment) {
		getTiOstAssessments().add(tiOstAssessment);
		tiOstAssessment.setTiOstBeneficiary(this);

		return tiOstAssessment;
	}

	public TiOstAssessment removeTiOstAssessment(TiOstAssessment tiOstAssessment) {
		getTiOstAssessments().remove(tiOstAssessment);
		tiOstAssessment.setTiOstBeneficiary(null);

		return tiOstAssessment;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Facility getFacility1() {
		return this.facility1;
	}

	public void setFacility1(Facility facility1) {
		this.facility1 = facility1;
	}

	public Facility getFacility2() {
		return this.facility2;
	}

	public void setFacility2(Facility facility2) {
		this.facility2 = facility2;
	}

	public Set<TiOstDispensationItem> getTiOstDispensationItems() {
		return this.tiOstDispensationItems;
	}

	public void setTiOstDispensationItems(Set<TiOstDispensationItem> tiOstDispensationItems) {
		this.tiOstDispensationItems = tiOstDispensationItems;
	}

	public TiOstDispensationItem addTiOstDispensationItem(TiOstDispensationItem tiOstDispensationItem) {
		getTiOstDispensationItems().add(tiOstDispensationItem);
		tiOstDispensationItem.setTiOstBeneficiary(this);

		return tiOstDispensationItem;
	}

	public TiOstDispensationItem removeTiOstDispensationItem(TiOstDispensationItem tiOstDispensationItem) {
		getTiOstDispensationItems().remove(tiOstDispensationItem);
		tiOstDispensationItem.setTiOstBeneficiary(null);

		return tiOstDispensationItem;
	}

	public Set<TiOstFollowUp> getTiOstFollowUps() {
		return this.tiOstFollowUps;
	}

	public void setTiOstFollowUps(Set<TiOstFollowUp> tiOstFollowUps) {
		this.tiOstFollowUps = tiOstFollowUps;
	}

	public TiOstFollowUp addTiOstFollowUp(TiOstFollowUp tiOstFollowUp) {
		getTiOstFollowUps().add(tiOstFollowUp);
		tiOstFollowUp.setTiOstBeneficiary(this);

		return tiOstFollowUp;
	}

	public TiOstFollowUp removeTiOstFollowUp(TiOstFollowUp tiOstFollowUp) {
		getTiOstFollowUps().remove(tiOstFollowUp);
		tiOstFollowUp.setTiOstBeneficiary(null);

		return tiOstFollowUp;
	}

	public Set<TiOstPrescription> getTiOstPrescriptions() {
		return this.tiOstPrescriptions;
	}

	public void setTiOstPrescriptions(Set<TiOstPrescription> tiOstPrescriptions) {
		this.tiOstPrescriptions = tiOstPrescriptions;
	}

	public TiOstPrescription addTiOstPrescription(TiOstPrescription tiOstPrescription) {
		getTiOstPrescriptions().add(tiOstPrescription);
		tiOstPrescription.setTiOstBeneficiary(this);

		return tiOstPrescription;
	}

	public TiOstPrescription removeTiOstPrescription(TiOstPrescription tiOstPrescription) {
		getTiOstPrescriptions().remove(tiOstPrescription);
		tiOstPrescription.setTiOstBeneficiary(null);

		return tiOstPrescription;
	}

}