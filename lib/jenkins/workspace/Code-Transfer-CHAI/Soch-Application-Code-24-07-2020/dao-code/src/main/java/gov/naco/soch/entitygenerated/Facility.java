package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the facility database table.
 * 
 */
@Entity
@NamedQuery(name="Facility.findAll", query="SELECT f FROM Facility f")
public class Facility implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="art_code")
	private String artCode;

	@Column(name="c_b_status")
	private String cBStatus;

	@Column(name="clinic_present")
	private Boolean clinicPresent;

	private String code;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="facility_no")
	private String facilityNo;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="is_lab")
	private Boolean isLab;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="monthly_active_target")
	private Integer monthlyActiveTarget;

	@Column(name="monthly_ost_target")
	private Integer monthlyOstTarget;

	private String name;

	@Column(name="national_id")
	private String nationalId;

	@Column(name="nodal_centre")
	private String nodalCentre;

	@Column(name="ti_type")
	private String tiType;

	@Column(name="valid_till")
	private Timestamp validTill;

	//bi-directional many-to-one association to ArtBeneficiary
	@OneToMany(mappedBy="facility")
	private Set<ArtBeneficiary> artBeneficiaries;

	//bi-directional many-to-one association to ArtBeneficiaryClinicalDetail
	@OneToMany(mappedBy="facility")
	private Set<ArtBeneficiaryClinicalDetail> artBeneficiaryClinicalDetails;

	//bi-directional many-to-one association to ArtBeneficiaryCounsellingNote
	@OneToMany(mappedBy="facility")
	private Set<ArtBeneficiaryCounsellingNote> artBeneficiaryCounsellingNotes;

	//bi-directional many-to-one association to ArtBeneficiaryDueList
	@OneToMany(mappedBy="facility")
	private Set<ArtBeneficiaryDueList> artBeneficiaryDueLists;

	//bi-directional many-to-one association to ArtBeneficiaryFollowup
	@OneToMany(mappedBy="facility")
	private Set<ArtBeneficiaryFollowup> artBeneficiaryFollowups;

	//bi-directional many-to-one association to ArtBeneficiaryInvestigation
	@OneToMany(mappedBy="facility")
	private Set<ArtBeneficiaryInvestigation> artBeneficiaryInvestigations;

	//bi-directional many-to-one association to ArtBeneficiaryIptAttDetail
	@OneToMany(mappedBy="facility")
	private Set<ArtBeneficiaryIptAttDetail> artBeneficiaryIptAttDetails;

	//bi-directional many-to-one association to ArtBeneficiaryQueue
	@OneToMany(mappedBy="facility")
	private Set<ArtBeneficiaryQueue> artBeneficiaryQueues;

	//bi-directional many-to-one association to ArtDispensation
	@OneToMany(mappedBy="facility")
	private Set<ArtDispensation> artDispensations;

	//bi-directional many-to-one association to ArtPep
	@OneToMany(mappedBy="facility")
	private Set<ArtPep> artPeps;

	//bi-directional many-to-one association to ArtPepDispensation
	@OneToMany(mappedBy="facility")
	private Set<ArtPepDispensation> artPepDispensations;

	//bi-directional many-to-one association to ArtPepDueList
	@OneToMany(mappedBy="facility")
	private Set<ArtPepDueList> artPepDueLists;

	//bi-directional many-to-one association to ArtPepQueue
	@OneToMany(mappedBy="facility")
	private Set<ArtPepQueue> artPepQueues;

	//bi-directional many-to-one association to BeneficiaryFacilityMapping
	@OneToMany(mappedBy="facility1")
	private Set<BeneficiaryFacilityMapping> beneficiaryFacilityMappings1;

	//bi-directional many-to-one association to BeneficiaryFacilityMapping
	@OneToMany(mappedBy="facility2")
	private Set<BeneficiaryFacilityMapping> beneficiaryFacilityMappings2;

	//bi-directional many-to-one association to BeneficiaryReferral
	@OneToMany(mappedBy="facility1")
	private Set<BeneficiaryReferral> beneficiaryReferrals1;

	//bi-directional many-to-one association to BeneficiaryReferral
	@OneToMany(mappedBy="facility2")
	private Set<BeneficiaryReferral> beneficiaryReferrals2;

	//bi-directional many-to-one association to BeneficiaryTransitFacility
	@OneToMany(mappedBy="facility")
	private Set<BeneficiaryTransitFacility> beneficiaryTransitFacilities;

	//bi-directional many-to-one association to BeneficiaryVisitRegister
	@OneToMany(mappedBy="facility")
	private Set<BeneficiaryVisitRegister> beneficiaryVisitRegisters;

	//bi-directional many-to-one association to CmssIndentDispatch
	@OneToMany(mappedBy="facility")
	private Set<CmssIndentDispatch> cmssIndentDispatches;

	//bi-directional many-to-one association to CmssIndent
	@OneToMany(mappedBy="facility")
	private Set<CmssIndent> cmssIndents;

	//bi-directional many-to-one association to CmssStoreSacsMapping
	@OneToMany(mappedBy="facility")
	private Set<CmssStoreSacsMapping> cmssStoreSacsMappings;

	//bi-directional many-to-one association to Contract
	@OneToMany(mappedBy="facility")
	private Set<Contract> contracts;

	//bi-directional many-to-one association to ContractProductScheduleSac
	@OneToMany(mappedBy="facility")
	private Set<ContractProductScheduleSac> contractProductScheduleSacs;

	//bi-directional many-to-one association to Dispatch
	@OneToMany(mappedBy="facility1")
	private Set<Dispatch> dispatches1;

	//bi-directional many-to-one association to Dispatch
	@OneToMany(mappedBy="facility2")
	private Set<Dispatch> dispatches2;

	//bi-directional many-to-one association to Dispatch
	@OneToMany(mappedBy="facility3")
	private Set<Dispatch> dispatches3;

	//bi-directional many-to-one association to Address
	@ManyToOne
	private Address address;

	//bi-directional many-to-one association to Division
	@ManyToOne
	private Division division;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="parent_facility_id")
	private Facility facility1;

	//bi-directional many-to-one association to Facility
	@OneToMany(mappedBy="facility1")
	private Set<Facility> facilities1;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="sacs_id")
	private Facility facility2;

	//bi-directional many-to-one association to Facility
	@OneToMany(mappedBy="facility2")
	private Set<Facility> facilities2;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="ti_center_id")
	private Facility facility3;

	//bi-directional many-to-one association to Facility
	@OneToMany(mappedBy="facility3")
	private Set<Facility> facilities3;

	//bi-directional many-to-one association to FacilityType
	@ManyToOne
	@JoinColumn(name="facility_type_id")
	private FacilityType facilityType;

	//bi-directional many-to-one association to Machine
	@ManyToOne
	@JoinColumn(name="machine_type_id")
	private Machine machine;

	//bi-directional many-to-one association to MasterTiOstType
	@ManyToOne
	@JoinColumn(name="ost_type_id")
	private MasterTiOstType masterTiOstType;

	//bi-directional many-to-one association to FacilityAggregateStock
	@OneToMany(mappedBy="facility")
	private Set<FacilityAggregateStock> facilityAggregateStocks;

	//bi-directional many-to-one association to FacilityDispatch
	@OneToMany(mappedBy="facility1")
	private Set<FacilityDispatch> facilityDispatches1;

	//bi-directional many-to-one association to FacilityDispatch
	@OneToMany(mappedBy="facility2")
	private Set<FacilityDispatch> facilityDispatches2;

	//bi-directional many-to-one association to FacilityLinkedFacilityBeneficiary
	@OneToMany(mappedBy="facility1")
	private Set<FacilityLinkedFacilityBeneficiary> facilityLinkedFacilityBeneficiaries1;

	//bi-directional many-to-one association to FacilityLinkedFacilityBeneficiary
	@OneToMany(mappedBy="facility2")
	private Set<FacilityLinkedFacilityBeneficiary> facilityLinkedFacilityBeneficiaries2;

	//bi-directional many-to-one association to FacilityReceipt
	@OneToMany(mappedBy="facility")
	private Set<FacilityReceipt> facilityReceipts;

	//bi-directional many-to-one association to FacilityReconciliation
	@OneToMany(mappedBy="facility")
	private Set<FacilityReconciliation> facilityReconciliations;

	//bi-directional many-to-one association to FacilitySetting
	@OneToMany(mappedBy="facility")
	private Set<FacilitySetting> facilitySettings;

	//bi-directional many-to-one association to FacilityStock
	@OneToMany(mappedBy="facility")
	private Set<FacilityStock> facilityStocks;

	//bi-directional many-to-one association to FacilityStockAdjustment
	@OneToMany(mappedBy="facility")
	private Set<FacilityStockAdjustment> facilityStockAdjustments;

	//bi-directional many-to-one association to FacilityStockDailyBalance
	@OneToMany(mappedBy="facility")
	private Set<FacilityStockDailyBalance> facilityStockDailyBalances;

	//bi-directional many-to-one association to FacilityStockTracking
	@OneToMany(mappedBy="facility")
	private Set<FacilityStockTracking> facilityStockTrackings;

	//bi-directional many-to-one association to GoodsRequest
	@OneToMany(mappedBy="facility1")
	private Set<GoodsRequest> goodsRequests1;

	//bi-directional many-to-one association to GoodsRequest
	@OneToMany(mappedBy="facility2")
	private Set<GoodsRequest> goodsRequests2;

	//bi-directional many-to-one association to IctcBeneficiary
	@OneToMany(mappedBy="facility")
	private Set<IctcBeneficiary> ictcBeneficiaries;

	//bi-directional many-to-one association to IctcFollowUp
	@OneToMany(mappedBy="facility")
	private Set<IctcFollowUp> ictcFollowUps;

	//bi-directional many-to-one association to IctcLinkedFacility
	@OneToMany(mappedBy="facility")
	private Set<IctcLinkedFacility> ictcLinkedFacilities;

	//bi-directional many-to-one association to IctcSampleBatch
	@OneToMany(mappedBy="facility1")
	private Set<IctcSampleBatch> ictcSampleBatches1;

	//bi-directional many-to-one association to IctcSampleBatch
	@OneToMany(mappedBy="facility2")
	private Set<IctcSampleBatch> ictcSampleBatches2;

	//bi-directional many-to-one association to IctcSampleCollection
	@OneToMany(mappedBy="facility")
	private Set<IctcSampleCollection> ictcSampleCollections;

	//bi-directional many-to-one association to IctcVisit
	@OneToMany(mappedBy="facility")
	private Set<IctcVisit> ictcVisits;

	//bi-directional many-to-one association to IndentProductScheduleSac
	@OneToMany(mappedBy="facility")
	private Set<IndentProductScheduleSac> indentProductScheduleSacs;

	//bi-directional many-to-one association to LabMachineMapping
	@OneToMany(mappedBy="facility")
	private Set<LabMachineMapping> labMachineMappings;

	//bi-directional many-to-one association to LabTestSample
	@OneToMany(mappedBy="facility1")
	private Set<LabTestSample> labTestSamples1;

	//bi-directional many-to-one association to LabTestSample
	@OneToMany(mappedBy="facility2")
	private Set<LabTestSample> labTestSamples2;

	//bi-directional many-to-one association to LabTestSampleBatch
	@OneToMany(mappedBy="facility1")
	private Set<LabTestSampleBatch> labTestSampleBatches1;

	//bi-directional many-to-one association to LabTestSampleBatch
	@OneToMany(mappedBy="facility2")
	private Set<LabTestSampleBatch> labTestSampleBatches2;

	//bi-directional many-to-one association to MappingLabFacility
	@OneToMany(mappedBy="facility1")
	private Set<MappingLabFacility> mappingLabFacilities1;

	//bi-directional many-to-one association to MappingLabFacility
	@OneToMany(mappedBy="facility2")
	private Set<MappingLabFacility> mappingLabFacilities2;

	//bi-directional many-to-one association to Referral
	@OneToMany(mappedBy="facility1")
	private Set<Referral> referrals1;

	//bi-directional many-to-one association to Referral
	@OneToMany(mappedBy="facility2")
	private Set<Referral> referrals2;

	//bi-directional many-to-one association to SacsCmssWarehouseMapping
	@OneToMany(mappedBy="facility")
	private Set<SacsCmssWarehouseMapping> sacsCmssWarehouseMappings;

	//bi-directional many-to-one association to SupplierStock
	@OneToMany(mappedBy="facility")
	private Set<SupplierStock> supplierStocks;

	//bi-directional many-to-one association to TiBenChildDetail
	@OneToMany(mappedBy="facility")
	private Set<TiBenChildDetail> tiBenChildDetails;

	//bi-directional many-to-one association to TiBenCounselling
	@OneToMany(mappedBy="facility")
	private Set<TiBenCounselling> tiBenCounsellings;

	//bi-directional many-to-one association to TiBenExtDetail
	@OneToMany(mappedBy="facility")
	private Set<TiBenExtDetail> tiBenExtDetails;

	//bi-directional many-to-one association to TiBenFollowUp
	@OneToMany(mappedBy="facility")
	private Set<TiBenFollowUp> tiBenFollowUps;

	//bi-directional many-to-one association to TiBenPresc
	@OneToMany(mappedBy="facility")
	private Set<TiBenPresc> tiBenPrescs;

	//bi-directional many-to-one association to TiBenReferral
	@OneToMany(mappedBy="facility")
	private Set<TiBenReferral> tiBenReferrals;

	//bi-directional many-to-one association to TiBenRvAssessment
	@OneToMany(mappedBy="facility")
	private Set<TiBenRvAssessment> tiBenRvAssessments;

	//bi-directional many-to-one association to TiBenScrDetail
	@OneToMany(mappedBy="facility")
	private Set<TiBenScrDetail> tiBenScrDetails;

	//bi-directional many-to-one association to TiBeneficiary
	@OneToMany(mappedBy="facility")
	private Set<TiBeneficiary> tiBeneficiaries;

	//bi-directional many-to-one association to TiBeneficiaryCommDi
	@OneToMany(mappedBy="facility")
	private Set<TiBeneficiaryCommDi> tiBeneficiaryCommDis;

	//bi-directional many-to-one association to TiCoreBeneficiary
	@OneToMany(mappedBy="facility")
	private Set<TiCoreBeneficiary> tiCoreBeneficiaries;

	//bi-directional many-to-one association to TiHotspot
	@OneToMany(mappedBy="facility")
	private Set<TiHotspot> tiHotspots;

	//bi-directional many-to-one association to TiOstAssessment
	@OneToMany(mappedBy="facility")
	private Set<TiOstAssessment> tiOstAssessments;

	//bi-directional many-to-one association to TiOstBeneficiary
	@OneToMany(mappedBy="facility1")
	private Set<TiOstBeneficiary> tiOstBeneficiaries1;

	//bi-directional many-to-one association to TiOstBeneficiary
	@OneToMany(mappedBy="facility2")
	private Set<TiOstBeneficiary> tiOstBeneficiaries2;

	//bi-directional many-to-one association to TiOstBulkDispensation
	@OneToMany(mappedBy="facility")
	private Set<TiOstBulkDispensation> tiOstBulkDispensations;

	//bi-directional many-to-one association to TiOstDetail
	@OneToMany(mappedBy="facility")
	private Set<TiOstDetail> tiOstDetails;

	//bi-directional many-to-one association to TiOstDispensation
	@OneToMany(mappedBy="facility")
	private Set<TiOstDispensation> tiOstDispensations;

	//bi-directional many-to-one association to TiOstDispensationItem
	@OneToMany(mappedBy="facility")
	private Set<TiOstDispensationItem> tiOstDispensationItems;

	//bi-directional many-to-one association to TiOstDrugDispensation
	@OneToMany(mappedBy="facility")
	private Set<TiOstDrugDispensation> tiOstDrugDispensations;

	//bi-directional many-to-one association to TiOstFollowUp
	@OneToMany(mappedBy="facility")
	private Set<TiOstFollowUp> tiOstFollowUps;

	//bi-directional many-to-one association to TiOstPrescription
	@OneToMany(mappedBy="facility")
	private Set<TiOstPrescription> tiOstPrescriptions;

	//bi-directional many-to-one association to TiStiTreatment
	@OneToMany(mappedBy="facility")
	private Set<TiStiTreatment> tiStiTreatments;

	//bi-directional many-to-one association to Transfer
	@OneToMany(mappedBy="facility1")
	private Set<Transfer> transfers1;

	//bi-directional many-to-one association to Transfer
	@OneToMany(mappedBy="facility2")
	private Set<Transfer> transfers2;

	//bi-directional many-to-one association to TypologyFacilityMapping
	@OneToMany(mappedBy="facility")
	private Set<TypologyFacilityMapping> typologyFacilityMappings;

	//bi-directional many-to-one association to UserMaster
	@OneToMany(mappedBy="facility")
	private Set<UserMaster> userMasters;

	public Facility() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArtCode() {
		return this.artCode;
	}

	public void setArtCode(String artCode) {
		this.artCode = artCode;
	}

	public String getCBStatus() {
		return this.cBStatus;
	}

	public void setCBStatus(String cBStatus) {
		this.cBStatus = cBStatus;
	}

	public Boolean getClinicPresent() {
		return this.clinicPresent;
	}

	public void setClinicPresent(Boolean clinicPresent) {
		this.clinicPresent = clinicPresent;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getFacilityNo() {
		return this.facilityNo;
	}

	public void setFacilityNo(String facilityNo) {
		this.facilityNo = facilityNo;
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

	public Boolean getIsLab() {
		return this.isLab;
	}

	public void setIsLab(Boolean isLab) {
		this.isLab = isLab;
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

	public Integer getMonthlyActiveTarget() {
		return this.monthlyActiveTarget;
	}

	public void setMonthlyActiveTarget(Integer monthlyActiveTarget) {
		this.monthlyActiveTarget = monthlyActiveTarget;
	}

	public Integer getMonthlyOstTarget() {
		return this.monthlyOstTarget;
	}

	public void setMonthlyOstTarget(Integer monthlyOstTarget) {
		this.monthlyOstTarget = monthlyOstTarget;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationalId() {
		return this.nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public String getNodalCentre() {
		return this.nodalCentre;
	}

	public void setNodalCentre(String nodalCentre) {
		this.nodalCentre = nodalCentre;
	}

	public String getTiType() {
		return this.tiType;
	}

	public void setTiType(String tiType) {
		this.tiType = tiType;
	}

	public Timestamp getValidTill() {
		return this.validTill;
	}

	public void setValidTill(Timestamp validTill) {
		this.validTill = validTill;
	}

	public Set<ArtBeneficiary> getArtBeneficiaries() {
		return this.artBeneficiaries;
	}

	public void setArtBeneficiaries(Set<ArtBeneficiary> artBeneficiaries) {
		this.artBeneficiaries = artBeneficiaries;
	}

	public ArtBeneficiary addArtBeneficiary(ArtBeneficiary artBeneficiary) {
		getArtBeneficiaries().add(artBeneficiary);
		artBeneficiary.setFacility(this);

		return artBeneficiary;
	}

	public ArtBeneficiary removeArtBeneficiary(ArtBeneficiary artBeneficiary) {
		getArtBeneficiaries().remove(artBeneficiary);
		artBeneficiary.setFacility(null);

		return artBeneficiary;
	}

	public Set<ArtBeneficiaryClinicalDetail> getArtBeneficiaryClinicalDetails() {
		return this.artBeneficiaryClinicalDetails;
	}

	public void setArtBeneficiaryClinicalDetails(Set<ArtBeneficiaryClinicalDetail> artBeneficiaryClinicalDetails) {
		this.artBeneficiaryClinicalDetails = artBeneficiaryClinicalDetails;
	}

	public ArtBeneficiaryClinicalDetail addArtBeneficiaryClinicalDetail(ArtBeneficiaryClinicalDetail artBeneficiaryClinicalDetail) {
		getArtBeneficiaryClinicalDetails().add(artBeneficiaryClinicalDetail);
		artBeneficiaryClinicalDetail.setFacility(this);

		return artBeneficiaryClinicalDetail;
	}

	public ArtBeneficiaryClinicalDetail removeArtBeneficiaryClinicalDetail(ArtBeneficiaryClinicalDetail artBeneficiaryClinicalDetail) {
		getArtBeneficiaryClinicalDetails().remove(artBeneficiaryClinicalDetail);
		artBeneficiaryClinicalDetail.setFacility(null);

		return artBeneficiaryClinicalDetail;
	}

	public Set<ArtBeneficiaryCounsellingNote> getArtBeneficiaryCounsellingNotes() {
		return this.artBeneficiaryCounsellingNotes;
	}

	public void setArtBeneficiaryCounsellingNotes(Set<ArtBeneficiaryCounsellingNote> artBeneficiaryCounsellingNotes) {
		this.artBeneficiaryCounsellingNotes = artBeneficiaryCounsellingNotes;
	}

	public ArtBeneficiaryCounsellingNote addArtBeneficiaryCounsellingNote(ArtBeneficiaryCounsellingNote artBeneficiaryCounsellingNote) {
		getArtBeneficiaryCounsellingNotes().add(artBeneficiaryCounsellingNote);
		artBeneficiaryCounsellingNote.setFacility(this);

		return artBeneficiaryCounsellingNote;
	}

	public ArtBeneficiaryCounsellingNote removeArtBeneficiaryCounsellingNote(ArtBeneficiaryCounsellingNote artBeneficiaryCounsellingNote) {
		getArtBeneficiaryCounsellingNotes().remove(artBeneficiaryCounsellingNote);
		artBeneficiaryCounsellingNote.setFacility(null);

		return artBeneficiaryCounsellingNote;
	}

	public Set<ArtBeneficiaryDueList> getArtBeneficiaryDueLists() {
		return this.artBeneficiaryDueLists;
	}

	public void setArtBeneficiaryDueLists(Set<ArtBeneficiaryDueList> artBeneficiaryDueLists) {
		this.artBeneficiaryDueLists = artBeneficiaryDueLists;
	}

	public ArtBeneficiaryDueList addArtBeneficiaryDueList(ArtBeneficiaryDueList artBeneficiaryDueList) {
		getArtBeneficiaryDueLists().add(artBeneficiaryDueList);
		artBeneficiaryDueList.setFacility(this);

		return artBeneficiaryDueList;
	}

	public ArtBeneficiaryDueList removeArtBeneficiaryDueList(ArtBeneficiaryDueList artBeneficiaryDueList) {
		getArtBeneficiaryDueLists().remove(artBeneficiaryDueList);
		artBeneficiaryDueList.setFacility(null);

		return artBeneficiaryDueList;
	}

	public Set<ArtBeneficiaryFollowup> getArtBeneficiaryFollowups() {
		return this.artBeneficiaryFollowups;
	}

	public void setArtBeneficiaryFollowups(Set<ArtBeneficiaryFollowup> artBeneficiaryFollowups) {
		this.artBeneficiaryFollowups = artBeneficiaryFollowups;
	}

	public ArtBeneficiaryFollowup addArtBeneficiaryFollowup(ArtBeneficiaryFollowup artBeneficiaryFollowup) {
		getArtBeneficiaryFollowups().add(artBeneficiaryFollowup);
		artBeneficiaryFollowup.setFacility(this);

		return artBeneficiaryFollowup;
	}

	public ArtBeneficiaryFollowup removeArtBeneficiaryFollowup(ArtBeneficiaryFollowup artBeneficiaryFollowup) {
		getArtBeneficiaryFollowups().remove(artBeneficiaryFollowup);
		artBeneficiaryFollowup.setFacility(null);

		return artBeneficiaryFollowup;
	}

	public Set<ArtBeneficiaryInvestigation> getArtBeneficiaryInvestigations() {
		return this.artBeneficiaryInvestigations;
	}

	public void setArtBeneficiaryInvestigations(Set<ArtBeneficiaryInvestigation> artBeneficiaryInvestigations) {
		this.artBeneficiaryInvestigations = artBeneficiaryInvestigations;
	}

	public ArtBeneficiaryInvestigation addArtBeneficiaryInvestigation(ArtBeneficiaryInvestigation artBeneficiaryInvestigation) {
		getArtBeneficiaryInvestigations().add(artBeneficiaryInvestigation);
		artBeneficiaryInvestigation.setFacility(this);

		return artBeneficiaryInvestigation;
	}

	public ArtBeneficiaryInvestigation removeArtBeneficiaryInvestigation(ArtBeneficiaryInvestigation artBeneficiaryInvestigation) {
		getArtBeneficiaryInvestigations().remove(artBeneficiaryInvestigation);
		artBeneficiaryInvestigation.setFacility(null);

		return artBeneficiaryInvestigation;
	}

	public Set<ArtBeneficiaryIptAttDetail> getArtBeneficiaryIptAttDetails() {
		return this.artBeneficiaryIptAttDetails;
	}

	public void setArtBeneficiaryIptAttDetails(Set<ArtBeneficiaryIptAttDetail> artBeneficiaryIptAttDetails) {
		this.artBeneficiaryIptAttDetails = artBeneficiaryIptAttDetails;
	}

	public ArtBeneficiaryIptAttDetail addArtBeneficiaryIptAttDetail(ArtBeneficiaryIptAttDetail artBeneficiaryIptAttDetail) {
		getArtBeneficiaryIptAttDetails().add(artBeneficiaryIptAttDetail);
		artBeneficiaryIptAttDetail.setFacility(this);

		return artBeneficiaryIptAttDetail;
	}

	public ArtBeneficiaryIptAttDetail removeArtBeneficiaryIptAttDetail(ArtBeneficiaryIptAttDetail artBeneficiaryIptAttDetail) {
		getArtBeneficiaryIptAttDetails().remove(artBeneficiaryIptAttDetail);
		artBeneficiaryIptAttDetail.setFacility(null);

		return artBeneficiaryIptAttDetail;
	}

	public Set<ArtBeneficiaryQueue> getArtBeneficiaryQueues() {
		return this.artBeneficiaryQueues;
	}

	public void setArtBeneficiaryQueues(Set<ArtBeneficiaryQueue> artBeneficiaryQueues) {
		this.artBeneficiaryQueues = artBeneficiaryQueues;
	}

	public ArtBeneficiaryQueue addArtBeneficiaryQueue(ArtBeneficiaryQueue artBeneficiaryQueue) {
		getArtBeneficiaryQueues().add(artBeneficiaryQueue);
		artBeneficiaryQueue.setFacility(this);

		return artBeneficiaryQueue;
	}

	public ArtBeneficiaryQueue removeArtBeneficiaryQueue(ArtBeneficiaryQueue artBeneficiaryQueue) {
		getArtBeneficiaryQueues().remove(artBeneficiaryQueue);
		artBeneficiaryQueue.setFacility(null);

		return artBeneficiaryQueue;
	}

	public Set<ArtDispensation> getArtDispensations() {
		return this.artDispensations;
	}

	public void setArtDispensations(Set<ArtDispensation> artDispensations) {
		this.artDispensations = artDispensations;
	}

	public ArtDispensation addArtDispensation(ArtDispensation artDispensation) {
		getArtDispensations().add(artDispensation);
		artDispensation.setFacility(this);

		return artDispensation;
	}

	public ArtDispensation removeArtDispensation(ArtDispensation artDispensation) {
		getArtDispensations().remove(artDispensation);
		artDispensation.setFacility(null);

		return artDispensation;
	}

	public Set<ArtPep> getArtPeps() {
		return this.artPeps;
	}

	public void setArtPeps(Set<ArtPep> artPeps) {
		this.artPeps = artPeps;
	}

	public ArtPep addArtPep(ArtPep artPep) {
		getArtPeps().add(artPep);
		artPep.setFacility(this);

		return artPep;
	}

	public ArtPep removeArtPep(ArtPep artPep) {
		getArtPeps().remove(artPep);
		artPep.setFacility(null);

		return artPep;
	}

	public Set<ArtPepDispensation> getArtPepDispensations() {
		return this.artPepDispensations;
	}

	public void setArtPepDispensations(Set<ArtPepDispensation> artPepDispensations) {
		this.artPepDispensations = artPepDispensations;
	}

	public ArtPepDispensation addArtPepDispensation(ArtPepDispensation artPepDispensation) {
		getArtPepDispensations().add(artPepDispensation);
		artPepDispensation.setFacility(this);

		return artPepDispensation;
	}

	public ArtPepDispensation removeArtPepDispensation(ArtPepDispensation artPepDispensation) {
		getArtPepDispensations().remove(artPepDispensation);
		artPepDispensation.setFacility(null);

		return artPepDispensation;
	}

	public Set<ArtPepDueList> getArtPepDueLists() {
		return this.artPepDueLists;
	}

	public void setArtPepDueLists(Set<ArtPepDueList> artPepDueLists) {
		this.artPepDueLists = artPepDueLists;
	}

	public ArtPepDueList addArtPepDueList(ArtPepDueList artPepDueList) {
		getArtPepDueLists().add(artPepDueList);
		artPepDueList.setFacility(this);

		return artPepDueList;
	}

	public ArtPepDueList removeArtPepDueList(ArtPepDueList artPepDueList) {
		getArtPepDueLists().remove(artPepDueList);
		artPepDueList.setFacility(null);

		return artPepDueList;
	}

	public Set<ArtPepQueue> getArtPepQueues() {
		return this.artPepQueues;
	}

	public void setArtPepQueues(Set<ArtPepQueue> artPepQueues) {
		this.artPepQueues = artPepQueues;
	}

	public ArtPepQueue addArtPepQueue(ArtPepQueue artPepQueue) {
		getArtPepQueues().add(artPepQueue);
		artPepQueue.setFacility(this);

		return artPepQueue;
	}

	public ArtPepQueue removeArtPepQueue(ArtPepQueue artPepQueue) {
		getArtPepQueues().remove(artPepQueue);
		artPepQueue.setFacility(null);

		return artPepQueue;
	}

	public Set<BeneficiaryFacilityMapping> getBeneficiaryFacilityMappings1() {
		return this.beneficiaryFacilityMappings1;
	}

	public void setBeneficiaryFacilityMappings1(Set<BeneficiaryFacilityMapping> beneficiaryFacilityMappings1) {
		this.beneficiaryFacilityMappings1 = beneficiaryFacilityMappings1;
	}

	public BeneficiaryFacilityMapping addBeneficiaryFacilityMappings1(BeneficiaryFacilityMapping beneficiaryFacilityMappings1) {
		getBeneficiaryFacilityMappings1().add(beneficiaryFacilityMappings1);
		beneficiaryFacilityMappings1.setFacility1(this);

		return beneficiaryFacilityMappings1;
	}

	public BeneficiaryFacilityMapping removeBeneficiaryFacilityMappings1(BeneficiaryFacilityMapping beneficiaryFacilityMappings1) {
		getBeneficiaryFacilityMappings1().remove(beneficiaryFacilityMappings1);
		beneficiaryFacilityMappings1.setFacility1(null);

		return beneficiaryFacilityMappings1;
	}

	public Set<BeneficiaryFacilityMapping> getBeneficiaryFacilityMappings2() {
		return this.beneficiaryFacilityMappings2;
	}

	public void setBeneficiaryFacilityMappings2(Set<BeneficiaryFacilityMapping> beneficiaryFacilityMappings2) {
		this.beneficiaryFacilityMappings2 = beneficiaryFacilityMappings2;
	}

	public BeneficiaryFacilityMapping addBeneficiaryFacilityMappings2(BeneficiaryFacilityMapping beneficiaryFacilityMappings2) {
		getBeneficiaryFacilityMappings2().add(beneficiaryFacilityMappings2);
		beneficiaryFacilityMappings2.setFacility2(this);

		return beneficiaryFacilityMappings2;
	}

	public BeneficiaryFacilityMapping removeBeneficiaryFacilityMappings2(BeneficiaryFacilityMapping beneficiaryFacilityMappings2) {
		getBeneficiaryFacilityMappings2().remove(beneficiaryFacilityMappings2);
		beneficiaryFacilityMappings2.setFacility2(null);

		return beneficiaryFacilityMappings2;
	}

	public Set<BeneficiaryReferral> getBeneficiaryReferrals1() {
		return this.beneficiaryReferrals1;
	}

	public void setBeneficiaryReferrals1(Set<BeneficiaryReferral> beneficiaryReferrals1) {
		this.beneficiaryReferrals1 = beneficiaryReferrals1;
	}

	public BeneficiaryReferral addBeneficiaryReferrals1(BeneficiaryReferral beneficiaryReferrals1) {
		getBeneficiaryReferrals1().add(beneficiaryReferrals1);
		beneficiaryReferrals1.setFacility1(this);

		return beneficiaryReferrals1;
	}

	public BeneficiaryReferral removeBeneficiaryReferrals1(BeneficiaryReferral beneficiaryReferrals1) {
		getBeneficiaryReferrals1().remove(beneficiaryReferrals1);
		beneficiaryReferrals1.setFacility1(null);

		return beneficiaryReferrals1;
	}

	public Set<BeneficiaryReferral> getBeneficiaryReferrals2() {
		return this.beneficiaryReferrals2;
	}

	public void setBeneficiaryReferrals2(Set<BeneficiaryReferral> beneficiaryReferrals2) {
		this.beneficiaryReferrals2 = beneficiaryReferrals2;
	}

	public BeneficiaryReferral addBeneficiaryReferrals2(BeneficiaryReferral beneficiaryReferrals2) {
		getBeneficiaryReferrals2().add(beneficiaryReferrals2);
		beneficiaryReferrals2.setFacility2(this);

		return beneficiaryReferrals2;
	}

	public BeneficiaryReferral removeBeneficiaryReferrals2(BeneficiaryReferral beneficiaryReferrals2) {
		getBeneficiaryReferrals2().remove(beneficiaryReferrals2);
		beneficiaryReferrals2.setFacility2(null);

		return beneficiaryReferrals2;
	}

	public Set<BeneficiaryTransitFacility> getBeneficiaryTransitFacilities() {
		return this.beneficiaryTransitFacilities;
	}

	public void setBeneficiaryTransitFacilities(Set<BeneficiaryTransitFacility> beneficiaryTransitFacilities) {
		this.beneficiaryTransitFacilities = beneficiaryTransitFacilities;
	}

	public BeneficiaryTransitFacility addBeneficiaryTransitFacility(BeneficiaryTransitFacility beneficiaryTransitFacility) {
		getBeneficiaryTransitFacilities().add(beneficiaryTransitFacility);
		beneficiaryTransitFacility.setFacility(this);

		return beneficiaryTransitFacility;
	}

	public BeneficiaryTransitFacility removeBeneficiaryTransitFacility(BeneficiaryTransitFacility beneficiaryTransitFacility) {
		getBeneficiaryTransitFacilities().remove(beneficiaryTransitFacility);
		beneficiaryTransitFacility.setFacility(null);

		return beneficiaryTransitFacility;
	}

	public Set<BeneficiaryVisitRegister> getBeneficiaryVisitRegisters() {
		return this.beneficiaryVisitRegisters;
	}

	public void setBeneficiaryVisitRegisters(Set<BeneficiaryVisitRegister> beneficiaryVisitRegisters) {
		this.beneficiaryVisitRegisters = beneficiaryVisitRegisters;
	}

	public BeneficiaryVisitRegister addBeneficiaryVisitRegister(BeneficiaryVisitRegister beneficiaryVisitRegister) {
		getBeneficiaryVisitRegisters().add(beneficiaryVisitRegister);
		beneficiaryVisitRegister.setFacility(this);

		return beneficiaryVisitRegister;
	}

	public BeneficiaryVisitRegister removeBeneficiaryVisitRegister(BeneficiaryVisitRegister beneficiaryVisitRegister) {
		getBeneficiaryVisitRegisters().remove(beneficiaryVisitRegister);
		beneficiaryVisitRegister.setFacility(null);

		return beneficiaryVisitRegister;
	}

	public Set<CmssIndentDispatch> getCmssIndentDispatches() {
		return this.cmssIndentDispatches;
	}

	public void setCmssIndentDispatches(Set<CmssIndentDispatch> cmssIndentDispatches) {
		this.cmssIndentDispatches = cmssIndentDispatches;
	}

	public CmssIndentDispatch addCmssIndentDispatch(CmssIndentDispatch cmssIndentDispatch) {
		getCmssIndentDispatches().add(cmssIndentDispatch);
		cmssIndentDispatch.setFacility(this);

		return cmssIndentDispatch;
	}

	public CmssIndentDispatch removeCmssIndentDispatch(CmssIndentDispatch cmssIndentDispatch) {
		getCmssIndentDispatches().remove(cmssIndentDispatch);
		cmssIndentDispatch.setFacility(null);

		return cmssIndentDispatch;
	}

	public Set<CmssIndent> getCmssIndents() {
		return this.cmssIndents;
	}

	public void setCmssIndents(Set<CmssIndent> cmssIndents) {
		this.cmssIndents = cmssIndents;
	}

	public CmssIndent addCmssIndent(CmssIndent cmssIndent) {
		getCmssIndents().add(cmssIndent);
		cmssIndent.setFacility(this);

		return cmssIndent;
	}

	public CmssIndent removeCmssIndent(CmssIndent cmssIndent) {
		getCmssIndents().remove(cmssIndent);
		cmssIndent.setFacility(null);

		return cmssIndent;
	}

	public Set<CmssStoreSacsMapping> getCmssStoreSacsMappings() {
		return this.cmssStoreSacsMappings;
	}

	public void setCmssStoreSacsMappings(Set<CmssStoreSacsMapping> cmssStoreSacsMappings) {
		this.cmssStoreSacsMappings = cmssStoreSacsMappings;
	}

	public CmssStoreSacsMapping addCmssStoreSacsMapping(CmssStoreSacsMapping cmssStoreSacsMapping) {
		getCmssStoreSacsMappings().add(cmssStoreSacsMapping);
		cmssStoreSacsMapping.setFacility(this);

		return cmssStoreSacsMapping;
	}

	public CmssStoreSacsMapping removeCmssStoreSacsMapping(CmssStoreSacsMapping cmssStoreSacsMapping) {
		getCmssStoreSacsMappings().remove(cmssStoreSacsMapping);
		cmssStoreSacsMapping.setFacility(null);

		return cmssStoreSacsMapping;
	}

	public Set<Contract> getContracts() {
		return this.contracts;
	}

	public void setContracts(Set<Contract> contracts) {
		this.contracts = contracts;
	}

	public Contract addContract(Contract contract) {
		getContracts().add(contract);
		contract.setFacility(this);

		return contract;
	}

	public Contract removeContract(Contract contract) {
		getContracts().remove(contract);
		contract.setFacility(null);

		return contract;
	}

	public Set<ContractProductScheduleSac> getContractProductScheduleSacs() {
		return this.contractProductScheduleSacs;
	}

	public void setContractProductScheduleSacs(Set<ContractProductScheduleSac> contractProductScheduleSacs) {
		this.contractProductScheduleSacs = contractProductScheduleSacs;
	}

	public ContractProductScheduleSac addContractProductScheduleSac(ContractProductScheduleSac contractProductScheduleSac) {
		getContractProductScheduleSacs().add(contractProductScheduleSac);
		contractProductScheduleSac.setFacility(this);

		return contractProductScheduleSac;
	}

	public ContractProductScheduleSac removeContractProductScheduleSac(ContractProductScheduleSac contractProductScheduleSac) {
		getContractProductScheduleSacs().remove(contractProductScheduleSac);
		contractProductScheduleSac.setFacility(null);

		return contractProductScheduleSac;
	}

	public Set<Dispatch> getDispatches1() {
		return this.dispatches1;
	}

	public void setDispatches1(Set<Dispatch> dispatches1) {
		this.dispatches1 = dispatches1;
	}

	public Dispatch addDispatches1(Dispatch dispatches1) {
		getDispatches1().add(dispatches1);
		dispatches1.setFacility1(this);

		return dispatches1;
	}

	public Dispatch removeDispatches1(Dispatch dispatches1) {
		getDispatches1().remove(dispatches1);
		dispatches1.setFacility1(null);

		return dispatches1;
	}

	public Set<Dispatch> getDispatches2() {
		return this.dispatches2;
	}

	public void setDispatches2(Set<Dispatch> dispatches2) {
		this.dispatches2 = dispatches2;
	}

	public Dispatch addDispatches2(Dispatch dispatches2) {
		getDispatches2().add(dispatches2);
		dispatches2.setFacility2(this);

		return dispatches2;
	}

	public Dispatch removeDispatches2(Dispatch dispatches2) {
		getDispatches2().remove(dispatches2);
		dispatches2.setFacility2(null);

		return dispatches2;
	}

	public Set<Dispatch> getDispatches3() {
		return this.dispatches3;
	}

	public void setDispatches3(Set<Dispatch> dispatches3) {
		this.dispatches3 = dispatches3;
	}

	public Dispatch addDispatches3(Dispatch dispatches3) {
		getDispatches3().add(dispatches3);
		dispatches3.setFacility3(this);

		return dispatches3;
	}

	public Dispatch removeDispatches3(Dispatch dispatches3) {
		getDispatches3().remove(dispatches3);
		dispatches3.setFacility3(null);

		return dispatches3;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Division getDivision() {
		return this.division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public Facility getFacility1() {
		return this.facility1;
	}

	public void setFacility1(Facility facility1) {
		this.facility1 = facility1;
	}

	public Set<Facility> getFacilities1() {
		return this.facilities1;
	}

	public void setFacilities1(Set<Facility> facilities1) {
		this.facilities1 = facilities1;
	}

	public Facility addFacilities1(Facility facilities1) {
		getFacilities1().add(facilities1);
		facilities1.setFacility1(this);

		return facilities1;
	}

	public Facility removeFacilities1(Facility facilities1) {
		getFacilities1().remove(facilities1);
		facilities1.setFacility1(null);

		return facilities1;
	}

	public Facility getFacility2() {
		return this.facility2;
	}

	public void setFacility2(Facility facility2) {
		this.facility2 = facility2;
	}

	public Set<Facility> getFacilities2() {
		return this.facilities2;
	}

	public void setFacilities2(Set<Facility> facilities2) {
		this.facilities2 = facilities2;
	}

	public Facility addFacilities2(Facility facilities2) {
		getFacilities2().add(facilities2);
		facilities2.setFacility2(this);

		return facilities2;
	}

	public Facility removeFacilities2(Facility facilities2) {
		getFacilities2().remove(facilities2);
		facilities2.setFacility2(null);

		return facilities2;
	}

	public Facility getFacility3() {
		return this.facility3;
	}

	public void setFacility3(Facility facility3) {
		this.facility3 = facility3;
	}

	public Set<Facility> getFacilities3() {
		return this.facilities3;
	}

	public void setFacilities3(Set<Facility> facilities3) {
		this.facilities3 = facilities3;
	}

	public Facility addFacilities3(Facility facilities3) {
		getFacilities3().add(facilities3);
		facilities3.setFacility3(this);

		return facilities3;
	}

	public Facility removeFacilities3(Facility facilities3) {
		getFacilities3().remove(facilities3);
		facilities3.setFacility3(null);

		return facilities3;
	}

	public FacilityType getFacilityType() {
		return this.facilityType;
	}

	public void setFacilityType(FacilityType facilityType) {
		this.facilityType = facilityType;
	}

	public Machine getMachine() {
		return this.machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public MasterTiOstType getMasterTiOstType() {
		return this.masterTiOstType;
	}

	public void setMasterTiOstType(MasterTiOstType masterTiOstType) {
		this.masterTiOstType = masterTiOstType;
	}

	public Set<FacilityAggregateStock> getFacilityAggregateStocks() {
		return this.facilityAggregateStocks;
	}

	public void setFacilityAggregateStocks(Set<FacilityAggregateStock> facilityAggregateStocks) {
		this.facilityAggregateStocks = facilityAggregateStocks;
	}

	public FacilityAggregateStock addFacilityAggregateStock(FacilityAggregateStock facilityAggregateStock) {
		getFacilityAggregateStocks().add(facilityAggregateStock);
		facilityAggregateStock.setFacility(this);

		return facilityAggregateStock;
	}

	public FacilityAggregateStock removeFacilityAggregateStock(FacilityAggregateStock facilityAggregateStock) {
		getFacilityAggregateStocks().remove(facilityAggregateStock);
		facilityAggregateStock.setFacility(null);

		return facilityAggregateStock;
	}

	public Set<FacilityDispatch> getFacilityDispatches1() {
		return this.facilityDispatches1;
	}

	public void setFacilityDispatches1(Set<FacilityDispatch> facilityDispatches1) {
		this.facilityDispatches1 = facilityDispatches1;
	}

	public FacilityDispatch addFacilityDispatches1(FacilityDispatch facilityDispatches1) {
		getFacilityDispatches1().add(facilityDispatches1);
		facilityDispatches1.setFacility1(this);

		return facilityDispatches1;
	}

	public FacilityDispatch removeFacilityDispatches1(FacilityDispatch facilityDispatches1) {
		getFacilityDispatches1().remove(facilityDispatches1);
		facilityDispatches1.setFacility1(null);

		return facilityDispatches1;
	}

	public Set<FacilityDispatch> getFacilityDispatches2() {
		return this.facilityDispatches2;
	}

	public void setFacilityDispatches2(Set<FacilityDispatch> facilityDispatches2) {
		this.facilityDispatches2 = facilityDispatches2;
	}

	public FacilityDispatch addFacilityDispatches2(FacilityDispatch facilityDispatches2) {
		getFacilityDispatches2().add(facilityDispatches2);
		facilityDispatches2.setFacility2(this);

		return facilityDispatches2;
	}

	public FacilityDispatch removeFacilityDispatches2(FacilityDispatch facilityDispatches2) {
		getFacilityDispatches2().remove(facilityDispatches2);
		facilityDispatches2.setFacility2(null);

		return facilityDispatches2;
	}

	public Set<FacilityLinkedFacilityBeneficiary> getFacilityLinkedFacilityBeneficiaries1() {
		return this.facilityLinkedFacilityBeneficiaries1;
	}

	public void setFacilityLinkedFacilityBeneficiaries1(Set<FacilityLinkedFacilityBeneficiary> facilityLinkedFacilityBeneficiaries1) {
		this.facilityLinkedFacilityBeneficiaries1 = facilityLinkedFacilityBeneficiaries1;
	}

	public FacilityLinkedFacilityBeneficiary addFacilityLinkedFacilityBeneficiaries1(FacilityLinkedFacilityBeneficiary facilityLinkedFacilityBeneficiaries1) {
		getFacilityLinkedFacilityBeneficiaries1().add(facilityLinkedFacilityBeneficiaries1);
		facilityLinkedFacilityBeneficiaries1.setFacility1(this);

		return facilityLinkedFacilityBeneficiaries1;
	}

	public FacilityLinkedFacilityBeneficiary removeFacilityLinkedFacilityBeneficiaries1(FacilityLinkedFacilityBeneficiary facilityLinkedFacilityBeneficiaries1) {
		getFacilityLinkedFacilityBeneficiaries1().remove(facilityLinkedFacilityBeneficiaries1);
		facilityLinkedFacilityBeneficiaries1.setFacility1(null);

		return facilityLinkedFacilityBeneficiaries1;
	}

	public Set<FacilityLinkedFacilityBeneficiary> getFacilityLinkedFacilityBeneficiaries2() {
		return this.facilityLinkedFacilityBeneficiaries2;
	}

	public void setFacilityLinkedFacilityBeneficiaries2(Set<FacilityLinkedFacilityBeneficiary> facilityLinkedFacilityBeneficiaries2) {
		this.facilityLinkedFacilityBeneficiaries2 = facilityLinkedFacilityBeneficiaries2;
	}

	public FacilityLinkedFacilityBeneficiary addFacilityLinkedFacilityBeneficiaries2(FacilityLinkedFacilityBeneficiary facilityLinkedFacilityBeneficiaries2) {
		getFacilityLinkedFacilityBeneficiaries2().add(facilityLinkedFacilityBeneficiaries2);
		facilityLinkedFacilityBeneficiaries2.setFacility2(this);

		return facilityLinkedFacilityBeneficiaries2;
	}

	public FacilityLinkedFacilityBeneficiary removeFacilityLinkedFacilityBeneficiaries2(FacilityLinkedFacilityBeneficiary facilityLinkedFacilityBeneficiaries2) {
		getFacilityLinkedFacilityBeneficiaries2().remove(facilityLinkedFacilityBeneficiaries2);
		facilityLinkedFacilityBeneficiaries2.setFacility2(null);

		return facilityLinkedFacilityBeneficiaries2;
	}

	public Set<FacilityReceipt> getFacilityReceipts() {
		return this.facilityReceipts;
	}

	public void setFacilityReceipts(Set<FacilityReceipt> facilityReceipts) {
		this.facilityReceipts = facilityReceipts;
	}

	public FacilityReceipt addFacilityReceipt(FacilityReceipt facilityReceipt) {
		getFacilityReceipts().add(facilityReceipt);
		facilityReceipt.setFacility(this);

		return facilityReceipt;
	}

	public FacilityReceipt removeFacilityReceipt(FacilityReceipt facilityReceipt) {
		getFacilityReceipts().remove(facilityReceipt);
		facilityReceipt.setFacility(null);

		return facilityReceipt;
	}

	public Set<FacilityReconciliation> getFacilityReconciliations() {
		return this.facilityReconciliations;
	}

	public void setFacilityReconciliations(Set<FacilityReconciliation> facilityReconciliations) {
		this.facilityReconciliations = facilityReconciliations;
	}

	public FacilityReconciliation addFacilityReconciliation(FacilityReconciliation facilityReconciliation) {
		getFacilityReconciliations().add(facilityReconciliation);
		facilityReconciliation.setFacility(this);

		return facilityReconciliation;
	}

	public FacilityReconciliation removeFacilityReconciliation(FacilityReconciliation facilityReconciliation) {
		getFacilityReconciliations().remove(facilityReconciliation);
		facilityReconciliation.setFacility(null);

		return facilityReconciliation;
	}

	public Set<FacilitySetting> getFacilitySettings() {
		return this.facilitySettings;
	}

	public void setFacilitySettings(Set<FacilitySetting> facilitySettings) {
		this.facilitySettings = facilitySettings;
	}

	public FacilitySetting addFacilitySetting(FacilitySetting facilitySetting) {
		getFacilitySettings().add(facilitySetting);
		facilitySetting.setFacility(this);

		return facilitySetting;
	}

	public FacilitySetting removeFacilitySetting(FacilitySetting facilitySetting) {
		getFacilitySettings().remove(facilitySetting);
		facilitySetting.setFacility(null);

		return facilitySetting;
	}

	public Set<FacilityStock> getFacilityStocks() {
		return this.facilityStocks;
	}

	public void setFacilityStocks(Set<FacilityStock> facilityStocks) {
		this.facilityStocks = facilityStocks;
	}

	public FacilityStock addFacilityStock(FacilityStock facilityStock) {
		getFacilityStocks().add(facilityStock);
		facilityStock.setFacility(this);

		return facilityStock;
	}

	public FacilityStock removeFacilityStock(FacilityStock facilityStock) {
		getFacilityStocks().remove(facilityStock);
		facilityStock.setFacility(null);

		return facilityStock;
	}

	public Set<FacilityStockAdjustment> getFacilityStockAdjustments() {
		return this.facilityStockAdjustments;
	}

	public void setFacilityStockAdjustments(Set<FacilityStockAdjustment> facilityStockAdjustments) {
		this.facilityStockAdjustments = facilityStockAdjustments;
	}

	public FacilityStockAdjustment addFacilityStockAdjustment(FacilityStockAdjustment facilityStockAdjustment) {
		getFacilityStockAdjustments().add(facilityStockAdjustment);
		facilityStockAdjustment.setFacility(this);

		return facilityStockAdjustment;
	}

	public FacilityStockAdjustment removeFacilityStockAdjustment(FacilityStockAdjustment facilityStockAdjustment) {
		getFacilityStockAdjustments().remove(facilityStockAdjustment);
		facilityStockAdjustment.setFacility(null);

		return facilityStockAdjustment;
	}

	public Set<FacilityStockDailyBalance> getFacilityStockDailyBalances() {
		return this.facilityStockDailyBalances;
	}

	public void setFacilityStockDailyBalances(Set<FacilityStockDailyBalance> facilityStockDailyBalances) {
		this.facilityStockDailyBalances = facilityStockDailyBalances;
	}

	public FacilityStockDailyBalance addFacilityStockDailyBalance(FacilityStockDailyBalance facilityStockDailyBalance) {
		getFacilityStockDailyBalances().add(facilityStockDailyBalance);
		facilityStockDailyBalance.setFacility(this);

		return facilityStockDailyBalance;
	}

	public FacilityStockDailyBalance removeFacilityStockDailyBalance(FacilityStockDailyBalance facilityStockDailyBalance) {
		getFacilityStockDailyBalances().remove(facilityStockDailyBalance);
		facilityStockDailyBalance.setFacility(null);

		return facilityStockDailyBalance;
	}

	public Set<FacilityStockTracking> getFacilityStockTrackings() {
		return this.facilityStockTrackings;
	}

	public void setFacilityStockTrackings(Set<FacilityStockTracking> facilityStockTrackings) {
		this.facilityStockTrackings = facilityStockTrackings;
	}

	public FacilityStockTracking addFacilityStockTracking(FacilityStockTracking facilityStockTracking) {
		getFacilityStockTrackings().add(facilityStockTracking);
		facilityStockTracking.setFacility(this);

		return facilityStockTracking;
	}

	public FacilityStockTracking removeFacilityStockTracking(FacilityStockTracking facilityStockTracking) {
		getFacilityStockTrackings().remove(facilityStockTracking);
		facilityStockTracking.setFacility(null);

		return facilityStockTracking;
	}

	public Set<GoodsRequest> getGoodsRequests1() {
		return this.goodsRequests1;
	}

	public void setGoodsRequests1(Set<GoodsRequest> goodsRequests1) {
		this.goodsRequests1 = goodsRequests1;
	}

	public GoodsRequest addGoodsRequests1(GoodsRequest goodsRequests1) {
		getGoodsRequests1().add(goodsRequests1);
		goodsRequests1.setFacility1(this);

		return goodsRequests1;
	}

	public GoodsRequest removeGoodsRequests1(GoodsRequest goodsRequests1) {
		getGoodsRequests1().remove(goodsRequests1);
		goodsRequests1.setFacility1(null);

		return goodsRequests1;
	}

	public Set<GoodsRequest> getGoodsRequests2() {
		return this.goodsRequests2;
	}

	public void setGoodsRequests2(Set<GoodsRequest> goodsRequests2) {
		this.goodsRequests2 = goodsRequests2;
	}

	public GoodsRequest addGoodsRequests2(GoodsRequest goodsRequests2) {
		getGoodsRequests2().add(goodsRequests2);
		goodsRequests2.setFacility2(this);

		return goodsRequests2;
	}

	public GoodsRequest removeGoodsRequests2(GoodsRequest goodsRequests2) {
		getGoodsRequests2().remove(goodsRequests2);
		goodsRequests2.setFacility2(null);

		return goodsRequests2;
	}

	public Set<IctcBeneficiary> getIctcBeneficiaries() {
		return this.ictcBeneficiaries;
	}

	public void setIctcBeneficiaries(Set<IctcBeneficiary> ictcBeneficiaries) {
		this.ictcBeneficiaries = ictcBeneficiaries;
	}

	public IctcBeneficiary addIctcBeneficiary(IctcBeneficiary ictcBeneficiary) {
		getIctcBeneficiaries().add(ictcBeneficiary);
		ictcBeneficiary.setFacility(this);

		return ictcBeneficiary;
	}

	public IctcBeneficiary removeIctcBeneficiary(IctcBeneficiary ictcBeneficiary) {
		getIctcBeneficiaries().remove(ictcBeneficiary);
		ictcBeneficiary.setFacility(null);

		return ictcBeneficiary;
	}

	public Set<IctcFollowUp> getIctcFollowUps() {
		return this.ictcFollowUps;
	}

	public void setIctcFollowUps(Set<IctcFollowUp> ictcFollowUps) {
		this.ictcFollowUps = ictcFollowUps;
	}

	public IctcFollowUp addIctcFollowUp(IctcFollowUp ictcFollowUp) {
		getIctcFollowUps().add(ictcFollowUp);
		ictcFollowUp.setFacility(this);

		return ictcFollowUp;
	}

	public IctcFollowUp removeIctcFollowUp(IctcFollowUp ictcFollowUp) {
		getIctcFollowUps().remove(ictcFollowUp);
		ictcFollowUp.setFacility(null);

		return ictcFollowUp;
	}

	public Set<IctcLinkedFacility> getIctcLinkedFacilities() {
		return this.ictcLinkedFacilities;
	}

	public void setIctcLinkedFacilities(Set<IctcLinkedFacility> ictcLinkedFacilities) {
		this.ictcLinkedFacilities = ictcLinkedFacilities;
	}

	public IctcLinkedFacility addIctcLinkedFacility(IctcLinkedFacility ictcLinkedFacility) {
		getIctcLinkedFacilities().add(ictcLinkedFacility);
		ictcLinkedFacility.setFacility(this);

		return ictcLinkedFacility;
	}

	public IctcLinkedFacility removeIctcLinkedFacility(IctcLinkedFacility ictcLinkedFacility) {
		getIctcLinkedFacilities().remove(ictcLinkedFacility);
		ictcLinkedFacility.setFacility(null);

		return ictcLinkedFacility;
	}

	public Set<IctcSampleBatch> getIctcSampleBatches1() {
		return this.ictcSampleBatches1;
	}

	public void setIctcSampleBatches1(Set<IctcSampleBatch> ictcSampleBatches1) {
		this.ictcSampleBatches1 = ictcSampleBatches1;
	}

	public IctcSampleBatch addIctcSampleBatches1(IctcSampleBatch ictcSampleBatches1) {
		getIctcSampleBatches1().add(ictcSampleBatches1);
		ictcSampleBatches1.setFacility1(this);

		return ictcSampleBatches1;
	}

	public IctcSampleBatch removeIctcSampleBatches1(IctcSampleBatch ictcSampleBatches1) {
		getIctcSampleBatches1().remove(ictcSampleBatches1);
		ictcSampleBatches1.setFacility1(null);

		return ictcSampleBatches1;
	}

	public Set<IctcSampleBatch> getIctcSampleBatches2() {
		return this.ictcSampleBatches2;
	}

	public void setIctcSampleBatches2(Set<IctcSampleBatch> ictcSampleBatches2) {
		this.ictcSampleBatches2 = ictcSampleBatches2;
	}

	public IctcSampleBatch addIctcSampleBatches2(IctcSampleBatch ictcSampleBatches2) {
		getIctcSampleBatches2().add(ictcSampleBatches2);
		ictcSampleBatches2.setFacility2(this);

		return ictcSampleBatches2;
	}

	public IctcSampleBatch removeIctcSampleBatches2(IctcSampleBatch ictcSampleBatches2) {
		getIctcSampleBatches2().remove(ictcSampleBatches2);
		ictcSampleBatches2.setFacility2(null);

		return ictcSampleBatches2;
	}

	public Set<IctcSampleCollection> getIctcSampleCollections() {
		return this.ictcSampleCollections;
	}

	public void setIctcSampleCollections(Set<IctcSampleCollection> ictcSampleCollections) {
		this.ictcSampleCollections = ictcSampleCollections;
	}

	public IctcSampleCollection addIctcSampleCollection(IctcSampleCollection ictcSampleCollection) {
		getIctcSampleCollections().add(ictcSampleCollection);
		ictcSampleCollection.setFacility(this);

		return ictcSampleCollection;
	}

	public IctcSampleCollection removeIctcSampleCollection(IctcSampleCollection ictcSampleCollection) {
		getIctcSampleCollections().remove(ictcSampleCollection);
		ictcSampleCollection.setFacility(null);

		return ictcSampleCollection;
	}

	public Set<IctcVisit> getIctcVisits() {
		return this.ictcVisits;
	}

	public void setIctcVisits(Set<IctcVisit> ictcVisits) {
		this.ictcVisits = ictcVisits;
	}

	public IctcVisit addIctcVisit(IctcVisit ictcVisit) {
		getIctcVisits().add(ictcVisit);
		ictcVisit.setFacility(this);

		return ictcVisit;
	}

	public IctcVisit removeIctcVisit(IctcVisit ictcVisit) {
		getIctcVisits().remove(ictcVisit);
		ictcVisit.setFacility(null);

		return ictcVisit;
	}

	public Set<IndentProductScheduleSac> getIndentProductScheduleSacs() {
		return this.indentProductScheduleSacs;
	}

	public void setIndentProductScheduleSacs(Set<IndentProductScheduleSac> indentProductScheduleSacs) {
		this.indentProductScheduleSacs = indentProductScheduleSacs;
	}

	public IndentProductScheduleSac addIndentProductScheduleSac(IndentProductScheduleSac indentProductScheduleSac) {
		getIndentProductScheduleSacs().add(indentProductScheduleSac);
		indentProductScheduleSac.setFacility(this);

		return indentProductScheduleSac;
	}

	public IndentProductScheduleSac removeIndentProductScheduleSac(IndentProductScheduleSac indentProductScheduleSac) {
		getIndentProductScheduleSacs().remove(indentProductScheduleSac);
		indentProductScheduleSac.setFacility(null);

		return indentProductScheduleSac;
	}

	public Set<LabMachineMapping> getLabMachineMappings() {
		return this.labMachineMappings;
	}

	public void setLabMachineMappings(Set<LabMachineMapping> labMachineMappings) {
		this.labMachineMappings = labMachineMappings;
	}

	public LabMachineMapping addLabMachineMapping(LabMachineMapping labMachineMapping) {
		getLabMachineMappings().add(labMachineMapping);
		labMachineMapping.setFacility(this);

		return labMachineMapping;
	}

	public LabMachineMapping removeLabMachineMapping(LabMachineMapping labMachineMapping) {
		getLabMachineMappings().remove(labMachineMapping);
		labMachineMapping.setFacility(null);

		return labMachineMapping;
	}

	public Set<LabTestSample> getLabTestSamples1() {
		return this.labTestSamples1;
	}

	public void setLabTestSamples1(Set<LabTestSample> labTestSamples1) {
		this.labTestSamples1 = labTestSamples1;
	}

	public LabTestSample addLabTestSamples1(LabTestSample labTestSamples1) {
		getLabTestSamples1().add(labTestSamples1);
		labTestSamples1.setFacility1(this);

		return labTestSamples1;
	}

	public LabTestSample removeLabTestSamples1(LabTestSample labTestSamples1) {
		getLabTestSamples1().remove(labTestSamples1);
		labTestSamples1.setFacility1(null);

		return labTestSamples1;
	}

	public Set<LabTestSample> getLabTestSamples2() {
		return this.labTestSamples2;
	}

	public void setLabTestSamples2(Set<LabTestSample> labTestSamples2) {
		this.labTestSamples2 = labTestSamples2;
	}

	public LabTestSample addLabTestSamples2(LabTestSample labTestSamples2) {
		getLabTestSamples2().add(labTestSamples2);
		labTestSamples2.setFacility2(this);

		return labTestSamples2;
	}

	public LabTestSample removeLabTestSamples2(LabTestSample labTestSamples2) {
		getLabTestSamples2().remove(labTestSamples2);
		labTestSamples2.setFacility2(null);

		return labTestSamples2;
	}

	public Set<LabTestSampleBatch> getLabTestSampleBatches1() {
		return this.labTestSampleBatches1;
	}

	public void setLabTestSampleBatches1(Set<LabTestSampleBatch> labTestSampleBatches1) {
		this.labTestSampleBatches1 = labTestSampleBatches1;
	}

	public LabTestSampleBatch addLabTestSampleBatches1(LabTestSampleBatch labTestSampleBatches1) {
		getLabTestSampleBatches1().add(labTestSampleBatches1);
		labTestSampleBatches1.setFacility1(this);

		return labTestSampleBatches1;
	}

	public LabTestSampleBatch removeLabTestSampleBatches1(LabTestSampleBatch labTestSampleBatches1) {
		getLabTestSampleBatches1().remove(labTestSampleBatches1);
		labTestSampleBatches1.setFacility1(null);

		return labTestSampleBatches1;
	}

	public Set<LabTestSampleBatch> getLabTestSampleBatches2() {
		return this.labTestSampleBatches2;
	}

	public void setLabTestSampleBatches2(Set<LabTestSampleBatch> labTestSampleBatches2) {
		this.labTestSampleBatches2 = labTestSampleBatches2;
	}

	public LabTestSampleBatch addLabTestSampleBatches2(LabTestSampleBatch labTestSampleBatches2) {
		getLabTestSampleBatches2().add(labTestSampleBatches2);
		labTestSampleBatches2.setFacility2(this);

		return labTestSampleBatches2;
	}

	public LabTestSampleBatch removeLabTestSampleBatches2(LabTestSampleBatch labTestSampleBatches2) {
		getLabTestSampleBatches2().remove(labTestSampleBatches2);
		labTestSampleBatches2.setFacility2(null);

		return labTestSampleBatches2;
	}

	public Set<MappingLabFacility> getMappingLabFacilities1() {
		return this.mappingLabFacilities1;
	}

	public void setMappingLabFacilities1(Set<MappingLabFacility> mappingLabFacilities1) {
		this.mappingLabFacilities1 = mappingLabFacilities1;
	}

	public MappingLabFacility addMappingLabFacilities1(MappingLabFacility mappingLabFacilities1) {
		getMappingLabFacilities1().add(mappingLabFacilities1);
		mappingLabFacilities1.setFacility1(this);

		return mappingLabFacilities1;
	}

	public MappingLabFacility removeMappingLabFacilities1(MappingLabFacility mappingLabFacilities1) {
		getMappingLabFacilities1().remove(mappingLabFacilities1);
		mappingLabFacilities1.setFacility1(null);

		return mappingLabFacilities1;
	}

	public Set<MappingLabFacility> getMappingLabFacilities2() {
		return this.mappingLabFacilities2;
	}

	public void setMappingLabFacilities2(Set<MappingLabFacility> mappingLabFacilities2) {
		this.mappingLabFacilities2 = mappingLabFacilities2;
	}

	public MappingLabFacility addMappingLabFacilities2(MappingLabFacility mappingLabFacilities2) {
		getMappingLabFacilities2().add(mappingLabFacilities2);
		mappingLabFacilities2.setFacility2(this);

		return mappingLabFacilities2;
	}

	public MappingLabFacility removeMappingLabFacilities2(MappingLabFacility mappingLabFacilities2) {
		getMappingLabFacilities2().remove(mappingLabFacilities2);
		mappingLabFacilities2.setFacility2(null);

		return mappingLabFacilities2;
	}


	public Set<Referral> getReferrals1() {
		return this.referrals1;
	}

	public void setReferrals1(Set<Referral> referrals1) {
		this.referrals1 = referrals1;
	}

	public Referral addReferrals1(Referral referrals1) {
		getReferrals1().add(referrals1);
		referrals1.setFacility1(this);

		return referrals1;
	}

	public Referral removeReferrals1(Referral referrals1) {
		getReferrals1().remove(referrals1);
		referrals1.setFacility1(null);

		return referrals1;
	}

	public Set<Referral> getReferrals2() {
		return this.referrals2;
	}

	public void setReferrals2(Set<Referral> referrals2) {
		this.referrals2 = referrals2;
	}

	public Referral addReferrals2(Referral referrals2) {
		getReferrals2().add(referrals2);
		referrals2.setFacility2(this);

		return referrals2;
	}

	public Referral removeReferrals2(Referral referrals2) {
		getReferrals2().remove(referrals2);
		referrals2.setFacility2(null);

		return referrals2;
	}

	public Set<SacsCmssWarehouseMapping> getSacsCmssWarehouseMappings() {
		return this.sacsCmssWarehouseMappings;
	}

	public void setSacsCmssWarehouseMappings(Set<SacsCmssWarehouseMapping> sacsCmssWarehouseMappings) {
		this.sacsCmssWarehouseMappings = sacsCmssWarehouseMappings;
	}

	public SacsCmssWarehouseMapping addSacsCmssWarehouseMapping(SacsCmssWarehouseMapping sacsCmssWarehouseMapping) {
		getSacsCmssWarehouseMappings().add(sacsCmssWarehouseMapping);
		sacsCmssWarehouseMapping.setFacility(this);

		return sacsCmssWarehouseMapping;
	}

	public SacsCmssWarehouseMapping removeSacsCmssWarehouseMapping(SacsCmssWarehouseMapping sacsCmssWarehouseMapping) {
		getSacsCmssWarehouseMappings().remove(sacsCmssWarehouseMapping);
		sacsCmssWarehouseMapping.setFacility(null);

		return sacsCmssWarehouseMapping;
	}

	public Set<SupplierStock> getSupplierStocks() {
		return this.supplierStocks;
	}

	public void setSupplierStocks(Set<SupplierStock> supplierStocks) {
		this.supplierStocks = supplierStocks;
	}

	public SupplierStock addSupplierStock(SupplierStock supplierStock) {
		getSupplierStocks().add(supplierStock);
		supplierStock.setFacility(this);

		return supplierStock;
	}

	public SupplierStock removeSupplierStock(SupplierStock supplierStock) {
		getSupplierStocks().remove(supplierStock);
		supplierStock.setFacility(null);

		return supplierStock;
	}

	public Set<TiBenChildDetail> getTiBenChildDetails() {
		return this.tiBenChildDetails;
	}

	public void setTiBenChildDetails(Set<TiBenChildDetail> tiBenChildDetails) {
		this.tiBenChildDetails = tiBenChildDetails;
	}

	public TiBenChildDetail addTiBenChildDetail(TiBenChildDetail tiBenChildDetail) {
		getTiBenChildDetails().add(tiBenChildDetail);
		tiBenChildDetail.setFacility(this);

		return tiBenChildDetail;
	}

	public TiBenChildDetail removeTiBenChildDetail(TiBenChildDetail tiBenChildDetail) {
		getTiBenChildDetails().remove(tiBenChildDetail);
		tiBenChildDetail.setFacility(null);

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
		tiBenCounselling.setFacility(this);

		return tiBenCounselling;
	}

	public TiBenCounselling removeTiBenCounselling(TiBenCounselling tiBenCounselling) {
		getTiBenCounsellings().remove(tiBenCounselling);
		tiBenCounselling.setFacility(null);

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
		tiBenExtDetail.setFacility(this);

		return tiBenExtDetail;
	}

	public TiBenExtDetail removeTiBenExtDetail(TiBenExtDetail tiBenExtDetail) {
		getTiBenExtDetails().remove(tiBenExtDetail);
		tiBenExtDetail.setFacility(null);

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
		tiBenFollowUp.setFacility(this);

		return tiBenFollowUp;
	}

	public TiBenFollowUp removeTiBenFollowUp(TiBenFollowUp tiBenFollowUp) {
		getTiBenFollowUps().remove(tiBenFollowUp);
		tiBenFollowUp.setFacility(null);

		return tiBenFollowUp;
	}

	public Set<TiBenPresc> getTiBenPrescs() {
		return this.tiBenPrescs;
	}

	public void setTiBenPrescs(Set<TiBenPresc> tiBenPrescs) {
		this.tiBenPrescs = tiBenPrescs;
	}

	public TiBenPresc addTiBenPresc(TiBenPresc tiBenPresc) {
		getTiBenPrescs().add(tiBenPresc);
		tiBenPresc.setFacility(this);

		return tiBenPresc;
	}

	public TiBenPresc removeTiBenPresc(TiBenPresc tiBenPresc) {
		getTiBenPrescs().remove(tiBenPresc);
		tiBenPresc.setFacility(null);

		return tiBenPresc;
	}

	public Set<TiBenReferral> getTiBenReferrals() {
		return this.tiBenReferrals;
	}

	public void setTiBenReferrals(Set<TiBenReferral> tiBenReferrals) {
		this.tiBenReferrals = tiBenReferrals;
	}

	public TiBenReferral addTiBenReferral(TiBenReferral tiBenReferral) {
		getTiBenReferrals().add(tiBenReferral);
		tiBenReferral.setFacility(this);

		return tiBenReferral;
	}

	public TiBenReferral removeTiBenReferral(TiBenReferral tiBenReferral) {
		getTiBenReferrals().remove(tiBenReferral);
		tiBenReferral.setFacility(null);

		return tiBenReferral;
	}

	public Set<TiBenRvAssessment> getTiBenRvAssessments() {
		return this.tiBenRvAssessments;
	}

	public void setTiBenRvAssessments(Set<TiBenRvAssessment> tiBenRvAssessments) {
		this.tiBenRvAssessments = tiBenRvAssessments;
	}

	public TiBenRvAssessment addTiBenRvAssessment(TiBenRvAssessment tiBenRvAssessment) {
		getTiBenRvAssessments().add(tiBenRvAssessment);
		tiBenRvAssessment.setFacility(this);

		return tiBenRvAssessment;
	}

	public TiBenRvAssessment removeTiBenRvAssessment(TiBenRvAssessment tiBenRvAssessment) {
		getTiBenRvAssessments().remove(tiBenRvAssessment);
		tiBenRvAssessment.setFacility(null);

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
		tiBenScrDetail.setFacility(this);

		return tiBenScrDetail;
	}

	public TiBenScrDetail removeTiBenScrDetail(TiBenScrDetail tiBenScrDetail) {
		getTiBenScrDetails().remove(tiBenScrDetail);
		tiBenScrDetail.setFacility(null);

		return tiBenScrDetail;
	}

	public Set<TiBeneficiary> getTiBeneficiaries() {
		return this.tiBeneficiaries;
	}

	public void setTiBeneficiaries(Set<TiBeneficiary> tiBeneficiaries) {
		this.tiBeneficiaries = tiBeneficiaries;
	}

	public TiBeneficiary addTiBeneficiary(TiBeneficiary tiBeneficiary) {
		getTiBeneficiaries().add(tiBeneficiary);
		tiBeneficiary.setFacility(this);

		return tiBeneficiary;
	}

	public TiBeneficiary removeTiBeneficiary(TiBeneficiary tiBeneficiary) {
		getTiBeneficiaries().remove(tiBeneficiary);
		tiBeneficiary.setFacility(null);

		return tiBeneficiary;
	}

	public Set<TiBeneficiaryCommDi> getTiBeneficiaryCommDis() {
		return this.tiBeneficiaryCommDis;
	}

	public void setTiBeneficiaryCommDis(Set<TiBeneficiaryCommDi> tiBeneficiaryCommDis) {
		this.tiBeneficiaryCommDis = tiBeneficiaryCommDis;
	}

	public TiBeneficiaryCommDi addTiBeneficiaryCommDi(TiBeneficiaryCommDi tiBeneficiaryCommDi) {
		getTiBeneficiaryCommDis().add(tiBeneficiaryCommDi);
		tiBeneficiaryCommDi.setFacility(this);

		return tiBeneficiaryCommDi;
	}

	public TiBeneficiaryCommDi removeTiBeneficiaryCommDi(TiBeneficiaryCommDi tiBeneficiaryCommDi) {
		getTiBeneficiaryCommDis().remove(tiBeneficiaryCommDi);
		tiBeneficiaryCommDi.setFacility(null);

		return tiBeneficiaryCommDi;
	}

	public Set<TiCoreBeneficiary> getTiCoreBeneficiaries() {
		return this.tiCoreBeneficiaries;
	}

	public void setTiCoreBeneficiaries(Set<TiCoreBeneficiary> tiCoreBeneficiaries) {
		this.tiCoreBeneficiaries = tiCoreBeneficiaries;
	}

	public TiCoreBeneficiary addTiCoreBeneficiary(TiCoreBeneficiary tiCoreBeneficiary) {
		getTiCoreBeneficiaries().add(tiCoreBeneficiary);
		tiCoreBeneficiary.setFacility(this);

		return tiCoreBeneficiary;
	}

	public TiCoreBeneficiary removeTiCoreBeneficiary(TiCoreBeneficiary tiCoreBeneficiary) {
		getTiCoreBeneficiaries().remove(tiCoreBeneficiary);
		tiCoreBeneficiary.setFacility(null);

		return tiCoreBeneficiary;
	}

	public Set<TiHotspot> getTiHotspots() {
		return this.tiHotspots;
	}

	public void setTiHotspots(Set<TiHotspot> tiHotspots) {
		this.tiHotspots = tiHotspots;
	}

	public TiHotspot addTiHotspot(TiHotspot tiHotspot) {
		getTiHotspots().add(tiHotspot);
		tiHotspot.setFacility(this);

		return tiHotspot;
	}

	public TiHotspot removeTiHotspot(TiHotspot tiHotspot) {
		getTiHotspots().remove(tiHotspot);
		tiHotspot.setFacility(null);

		return tiHotspot;
	}

	public Set<TiOstAssessment> getTiOstAssessments() {
		return this.tiOstAssessments;
	}

	public void setTiOstAssessments(Set<TiOstAssessment> tiOstAssessments) {
		this.tiOstAssessments = tiOstAssessments;
	}

	public TiOstAssessment addTiOstAssessment(TiOstAssessment tiOstAssessment) {
		getTiOstAssessments().add(tiOstAssessment);
		tiOstAssessment.setFacility(this);

		return tiOstAssessment;
	}

	public TiOstAssessment removeTiOstAssessment(TiOstAssessment tiOstAssessment) {
		getTiOstAssessments().remove(tiOstAssessment);
		tiOstAssessment.setFacility(null);

		return tiOstAssessment;
	}

	public Set<TiOstBeneficiary> getTiOstBeneficiaries1() {
		return this.tiOstBeneficiaries1;
	}

	public void setTiOstBeneficiaries1(Set<TiOstBeneficiary> tiOstBeneficiaries1) {
		this.tiOstBeneficiaries1 = tiOstBeneficiaries1;
	}

	public TiOstBeneficiary addTiOstBeneficiaries1(TiOstBeneficiary tiOstBeneficiaries1) {
		getTiOstBeneficiaries1().add(tiOstBeneficiaries1);
		tiOstBeneficiaries1.setFacility1(this);

		return tiOstBeneficiaries1;
	}

	public TiOstBeneficiary removeTiOstBeneficiaries1(TiOstBeneficiary tiOstBeneficiaries1) {
		getTiOstBeneficiaries1().remove(tiOstBeneficiaries1);
		tiOstBeneficiaries1.setFacility1(null);

		return tiOstBeneficiaries1;
	}

	public Set<TiOstBeneficiary> getTiOstBeneficiaries2() {
		return this.tiOstBeneficiaries2;
	}

	public void setTiOstBeneficiaries2(Set<TiOstBeneficiary> tiOstBeneficiaries2) {
		this.tiOstBeneficiaries2 = tiOstBeneficiaries2;
	}

	public TiOstBeneficiary addTiOstBeneficiaries2(TiOstBeneficiary tiOstBeneficiaries2) {
		getTiOstBeneficiaries2().add(tiOstBeneficiaries2);
		tiOstBeneficiaries2.setFacility2(this);

		return tiOstBeneficiaries2;
	}

	public TiOstBeneficiary removeTiOstBeneficiaries2(TiOstBeneficiary tiOstBeneficiaries2) {
		getTiOstBeneficiaries2().remove(tiOstBeneficiaries2);
		tiOstBeneficiaries2.setFacility2(null);

		return tiOstBeneficiaries2;
	}

	public Set<TiOstBulkDispensation> getTiOstBulkDispensations() {
		return this.tiOstBulkDispensations;
	}

	public void setTiOstBulkDispensations(Set<TiOstBulkDispensation> tiOstBulkDispensations) {
		this.tiOstBulkDispensations = tiOstBulkDispensations;
	}

	public TiOstBulkDispensation addTiOstBulkDispensation(TiOstBulkDispensation tiOstBulkDispensation) {
		getTiOstBulkDispensations().add(tiOstBulkDispensation);
		tiOstBulkDispensation.setFacility(this);

		return tiOstBulkDispensation;
	}

	public TiOstBulkDispensation removeTiOstBulkDispensation(TiOstBulkDispensation tiOstBulkDispensation) {
		getTiOstBulkDispensations().remove(tiOstBulkDispensation);
		tiOstBulkDispensation.setFacility(null);

		return tiOstBulkDispensation;
	}

	public Set<TiOstDetail> getTiOstDetails() {
		return this.tiOstDetails;
	}

	public void setTiOstDetails(Set<TiOstDetail> tiOstDetails) {
		this.tiOstDetails = tiOstDetails;
	}

	public TiOstDetail addTiOstDetail(TiOstDetail tiOstDetail) {
		getTiOstDetails().add(tiOstDetail);
		tiOstDetail.setFacility(this);

		return tiOstDetail;
	}

	public TiOstDetail removeTiOstDetail(TiOstDetail tiOstDetail) {
		getTiOstDetails().remove(tiOstDetail);
		tiOstDetail.setFacility(null);

		return tiOstDetail;
	}

	public Set<TiOstDispensation> getTiOstDispensations() {
		return this.tiOstDispensations;
	}

	public void setTiOstDispensations(Set<TiOstDispensation> tiOstDispensations) {
		this.tiOstDispensations = tiOstDispensations;
	}

	public TiOstDispensation addTiOstDispensation(TiOstDispensation tiOstDispensation) {
		getTiOstDispensations().add(tiOstDispensation);
		tiOstDispensation.setFacility(this);

		return tiOstDispensation;
	}

	public TiOstDispensation removeTiOstDispensation(TiOstDispensation tiOstDispensation) {
		getTiOstDispensations().remove(tiOstDispensation);
		tiOstDispensation.setFacility(null);

		return tiOstDispensation;
	}

	public Set<TiOstDispensationItem> getTiOstDispensationItems() {
		return this.tiOstDispensationItems;
	}

	public void setTiOstDispensationItems(Set<TiOstDispensationItem> tiOstDispensationItems) {
		this.tiOstDispensationItems = tiOstDispensationItems;
	}

	public TiOstDispensationItem addTiOstDispensationItem(TiOstDispensationItem tiOstDispensationItem) {
		getTiOstDispensationItems().add(tiOstDispensationItem);
		tiOstDispensationItem.setFacility(this);

		return tiOstDispensationItem;
	}

	public TiOstDispensationItem removeTiOstDispensationItem(TiOstDispensationItem tiOstDispensationItem) {
		getTiOstDispensationItems().remove(tiOstDispensationItem);
		tiOstDispensationItem.setFacility(null);

		return tiOstDispensationItem;
	}

	public Set<TiOstDrugDispensation> getTiOstDrugDispensations() {
		return this.tiOstDrugDispensations;
	}

	public void setTiOstDrugDispensations(Set<TiOstDrugDispensation> tiOstDrugDispensations) {
		this.tiOstDrugDispensations = tiOstDrugDispensations;
	}

	public TiOstDrugDispensation addTiOstDrugDispensation(TiOstDrugDispensation tiOstDrugDispensation) {
		getTiOstDrugDispensations().add(tiOstDrugDispensation);
		tiOstDrugDispensation.setFacility(this);

		return tiOstDrugDispensation;
	}

	public TiOstDrugDispensation removeTiOstDrugDispensation(TiOstDrugDispensation tiOstDrugDispensation) {
		getTiOstDrugDispensations().remove(tiOstDrugDispensation);
		tiOstDrugDispensation.setFacility(null);

		return tiOstDrugDispensation;
	}

	public Set<TiOstFollowUp> getTiOstFollowUps() {
		return this.tiOstFollowUps;
	}

	public void setTiOstFollowUps(Set<TiOstFollowUp> tiOstFollowUps) {
		this.tiOstFollowUps = tiOstFollowUps;
	}

	public TiOstFollowUp addTiOstFollowUp(TiOstFollowUp tiOstFollowUp) {
		getTiOstFollowUps().add(tiOstFollowUp);
		tiOstFollowUp.setFacility(this);

		return tiOstFollowUp;
	}

	public TiOstFollowUp removeTiOstFollowUp(TiOstFollowUp tiOstFollowUp) {
		getTiOstFollowUps().remove(tiOstFollowUp);
		tiOstFollowUp.setFacility(null);

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
		tiOstPrescription.setFacility(this);

		return tiOstPrescription;
	}

	public TiOstPrescription removeTiOstPrescription(TiOstPrescription tiOstPrescription) {
		getTiOstPrescriptions().remove(tiOstPrescription);
		tiOstPrescription.setFacility(null);

		return tiOstPrescription;
	}

	public Set<TiStiTreatment> getTiStiTreatments() {
		return this.tiStiTreatments;
	}

	public void setTiStiTreatments(Set<TiStiTreatment> tiStiTreatments) {
		this.tiStiTreatments = tiStiTreatments;
	}

	public TiStiTreatment addTiStiTreatment(TiStiTreatment tiStiTreatment) {
		getTiStiTreatments().add(tiStiTreatment);
		tiStiTreatment.setFacility(this);

		return tiStiTreatment;
	}

	public TiStiTreatment removeTiStiTreatment(TiStiTreatment tiStiTreatment) {
		getTiStiTreatments().remove(tiStiTreatment);
		tiStiTreatment.setFacility(null);

		return tiStiTreatment;
	}

	public Set<Transfer> getTransfers1() {
		return this.transfers1;
	}

	public void setTransfers1(Set<Transfer> transfers1) {
		this.transfers1 = transfers1;
	}

	public Transfer addTransfers1(Transfer transfers1) {
		getTransfers1().add(transfers1);
		transfers1.setFacility1(this);

		return transfers1;
	}

	public Transfer removeTransfers1(Transfer transfers1) {
		getTransfers1().remove(transfers1);
		transfers1.setFacility1(null);

		return transfers1;
	}

	public Set<Transfer> getTransfers2() {
		return this.transfers2;
	}

	public void setTransfers2(Set<Transfer> transfers2) {
		this.transfers2 = transfers2;
	}

	public Transfer addTransfers2(Transfer transfers2) {
		getTransfers2().add(transfers2);
		transfers2.setFacility2(this);

		return transfers2;
	}

	public Transfer removeTransfers2(Transfer transfers2) {
		getTransfers2().remove(transfers2);
		transfers2.setFacility2(null);

		return transfers2;
	}

	public Set<TypologyFacilityMapping> getTypologyFacilityMappings() {
		return this.typologyFacilityMappings;
	}

	public void setTypologyFacilityMappings(Set<TypologyFacilityMapping> typologyFacilityMappings) {
		this.typologyFacilityMappings = typologyFacilityMappings;
	}

	public TypologyFacilityMapping addTypologyFacilityMapping(TypologyFacilityMapping typologyFacilityMapping) {
		getTypologyFacilityMappings().add(typologyFacilityMapping);
		typologyFacilityMapping.setFacility(this);

		return typologyFacilityMapping;
	}

	public TypologyFacilityMapping removeTypologyFacilityMapping(TypologyFacilityMapping typologyFacilityMapping) {
		getTypologyFacilityMappings().remove(typologyFacilityMapping);
		typologyFacilityMapping.setFacility(null);

		return typologyFacilityMapping;
	}

	public Set<UserMaster> getUserMasters() {
		return this.userMasters;
	}

	public void setUserMasters(Set<UserMaster> userMasters) {
		this.userMasters = userMasters;
	}

	public UserMaster addUserMaster(UserMaster userMaster) {
		getUserMasters().add(userMaster);
		userMaster.setFacility(this);

		return userMaster;
	}

	public UserMaster removeUserMaster(UserMaster userMaster) {
		getUserMasters().remove(userMaster);
		userMaster.setFacility(null);

		return userMaster;
	}

}