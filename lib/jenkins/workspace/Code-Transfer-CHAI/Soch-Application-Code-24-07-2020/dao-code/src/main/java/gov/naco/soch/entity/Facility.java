package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the facility database table.
 * 
 */
@GenericGenerator(name = "facility", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "facility_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "facility")
@NamedQuery(name = "Facility.findAll", query = "SELECT f FROM Facility f")
public class Facility extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility")
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(length = 99)
	private String code;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(length = 99)
	private String name;

	@Column(name = "sacs_id")
	private Long sacsId;

	@Column(name = "is_lab")
	private Boolean isLab;

	@Column(name = "art_code", length = 99)
	private String artcode;

	@Column(name = "nodal_centre", length = 99)
	private String nodalCentre;

	@Column(name = "facility_no", length = 99)
	private String facilityNo;

	@Column(name = "monthly_active_target")
	private Integer monthlyActiveTarget;

	@Column(name = "monthly_ost_target")
	private Integer monthlyOstTarget;

	@Column(name = "ti_type")
	private String tiType;

	@Column(name = "c_b_status")
	private String cBStatus;

	@Column(name = "national_id")
	private String nationalId;
	
	@Column(name = "clinic_present")
	private Boolean clinicPresent;
	
	@Column(name = "valid_till")
	private LocalDate validTill;
	
	@Column(name="is_external")
	private Boolean isExternal;
	
	//bi-directional many-to-one association to ArtPepDispensation
	@OneToMany(mappedBy="facility")
	private Set<ArtPepDispensation> artPepDispensations;

	// bi-directional many-to-one association to TypologyFacilityMapping
	@OneToMany(mappedBy = "facility", fetch = FetchType.LAZY)
	private Set<TypologyFacilityMapping> typologyFacilityMappings;

	// bi-directional many-to-one association to BeneficiaryFacilityMapping
	@OneToMany(mappedBy = "facility")
	private Set<BeneficiaryFacilityMapping> beneficiaryFacilityMappings;

	// bi-directional many-to-one association to Dispensation
	@OneToMany(mappedBy = "facility")
	private Set<Dispensation> dispensations;

	@OneToMany(mappedBy = "facility1")
	private Set<BeneficiaryReferral> beneficiaryReferrals;

	@OneToMany(mappedBy = "facility2")
	private Set<BeneficiaryReferral> beneficiaryReferrals_Two;

	// bi-directional many-to-one association to Address
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	// bi-directional many-to-one association to Division
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "division_id", nullable = false)
	private Division division;

	// bi-directional many-to-one association to FacilityType
	@ManyToOne
	@JoinColumn(name = "facility_type_id")
	private FacilityType facilityType;

	// bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name = "parent_facility_id")
	private Facility facility;

	// bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name = "machine_type_id")
	private Machine machine;

	// bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name = "ost_type_id")
	private MasterTiOstType ostType;

	// bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name = "ti_center_id")
	private Facility tiCenter;

	// bi-directional many-to-one association to FacilityProductStock
	@OneToMany(mappedBy = "facility")
	private Set<FacilityProductStock> facilityProductStocks;

	// bi-directional many-to-one association to FacilityProductStockTran
	@OneToMany(mappedBy = "facility")
	private Set<FacilityProductStockTran> facilityProductStockTrans;

	// bi-directional many-to-one association to UserMaster
	@OneToMany(mappedBy = "facility")
	private Set<UserMaster> userMasters;

	// bi-directional many-to-one association to FacilitySetting
	@OneToMany(mappedBy = "facility", cascade = CascadeType.ALL)
	private Set<FacilitySetting> facilitySettings;

	// bi-directional many-to-one association to FacilityStock
	@OneToMany(mappedBy = "facility")
	private Set<FacilityStock> facilityStocks;

	// bi-directional many-to-one association to FacilityStockTransfer
	@OneToMany(mappedBy = "facility1")
	private Set<FacilityStockTransfer> facilityStockTransfers1;

	// bi-directional many-to-one association to FacilityStockTransfer
	@OneToMany(mappedBy = "facility2")
	private Set<FacilityStockTransfer> facilityStockTransfers2;

	// bi-directional many-to-one association to ContractProductScheduleSac
	@OneToMany(mappedBy = "facility")
	private Set<ContractProductScheduleSac> contractProductScheduleSacs;

	// bi-directional many-to-one association to Dispatch
	@OneToMany(mappedBy = "billToConsignee")
	private Set<Dispatch> dispatches1;

	// bi-directional many-to-one association to Dispatch
	@OneToMany(mappedBy = "shipToConsignee")
	private Set<Dispatch> dispatches2;

	// bi-directional many-to-one association to Dispatch
	@OneToMany(mappedBy = "consignor")
	private Set<Dispatch> dispatches3;

	// bi-directional many-to-one association to SupplierStock
	@OneToMany(mappedBy = "facility")
	private Set<SupplierStock> supplierStocks;

	// bi-directional many-to-one association to Contract
	@OneToMany(mappedBy = "facility")
	private Set<Contract> contracts;

	// bi-directional many-to-one association to FacilityAggregateStock
	@OneToMany(mappedBy = "facility")
	private Set<FacilityAggregateStock> facilityAggregateStocks;

	// bi-directional many-to-one association to FacilityStockTracking
	@OneToMany(mappedBy = "facility")
	private Set<FacilityStockTracking> facilityStockTrackings;

	// bi-directional many-to-one association to FacilityStockAdjustment
	@OneToMany(mappedBy = "facility")
	private Set<FacilityStockAdjustment> facilityStockAdjustments;

	@OneToMany(mappedBy = "facility")
	private Set<FacilityReconciliation> facilityReconciliations;

	// bi-directional many-to-one association to FacilityStockDailyBalance
	@OneToMany(mappedBy = "facility")
	private Set<FacilityStockDailyBalance> facilityStockDailyBalances;

	@OneToMany(mappedBy = "facility")
	private Set<TIBeneficiary> tiBeneficiary;

	@OneToMany(mappedBy = "facility")
	private Set<TiOstBeneficiary> tiOstBeneficiary;

	@OneToMany(mappedBy = "facility")
	private Set<TIBenChildDetails> tiBenChildDetails;

	@OneToMany(mappedBy = "facility")
	private Set<TIBeneficiaryExtDetails> tiBeneficiaryExtDetails;

	@OneToMany(mappedBy = "facility")
	private Set<TIBenCounselling> tiCounselling;

	@OneToMany(mappedBy = "facility")
	private Set<TIBenRVAssessment> tiRVAssessment;

	@OneToMany(mappedBy = "facility")
	private Set<TIStiTreatment> tiStiTreatment;

	@OneToMany(mappedBy = "facility")
	private Set<TIBenScrDetails> tiScreening;

//	@OneToMany(mappedBy = "facility")
//	private Set<TiOstAssessment> tiOstAssess;

	@OneToMany(mappedBy = "facility")
	private Set<TiOstPrescription> tiOstPrescription;

	// bi-directional many-to-one association to SacsCmssWarehouseMapping
	@OneToMany(mappedBy = "facility")
	private Set<SacsCmssWarehouseMapping> sacsCmssWarehouseMappings;

	// bi-directional many-to-one association to ArtDispensation
	@OneToMany(mappedBy = "facility")
	private Set<ArtDispensation> artDispensations;
	
	@OneToMany(mappedBy = "facility")
	private Set<ArtBeneficiaryCounsellingNotes> artBeneficiaryCounsellingNotes;

	public Facility() {
	}

	public Facility(Long benFacFacilityId) {
	   this.id=benFacFacilityId;
	}

	public Facility(Long benFacFacilityId, Long benFacFacilityType) {
	   this.id=benFacFacilityId;
	   this.facilityType=new FacilityType(benFacFacilityType);
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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
//
//	public Set<TiOstAssessment> getTiOstAssess() {
//		return tiOstAssess;
//	}
//
//	public void setTiOstAssess(Set<TiOstAssessment> tiOstAssess) {
//		this.tiOstAssess = tiOstAssess;
//	}

	public String getName() {
		return this.name;
	}

	public Set<TiOstPrescription> getTiOstPrescription() {
		return tiOstPrescription;
	}

	public void setTiOstPrescription(Set<TiOstPrescription> tiOstPrescription) {
		this.tiOstPrescription = tiOstPrescription;
	}

	public Set<TIBeneficiary> getTiBeneficiary() {
		return tiBeneficiary;
	}

	public void setTiBeneficiary(Set<TIBeneficiary> tiBeneficiary) {
		this.tiBeneficiary = tiBeneficiary;
	}

	public Set<TIBenChildDetails> getTiBenChildDetails() {
		return tiBenChildDetails;
	}

	public void setTiBenChildDetails(Set<TIBenChildDetails> tiBenChildDetails) {
		this.tiBenChildDetails = tiBenChildDetails;
	}


	public Set<TIBeneficiaryExtDetails> getTiBeneficiaryExtDetails() {
		return tiBeneficiaryExtDetails;
	}

	public void setTiBeneficiaryExtDetails(Set<TIBeneficiaryExtDetails> tiBeneficiaryExtDetails) {
		this.tiBeneficiaryExtDetails = tiBeneficiaryExtDetails;
	}

	public Set<TIBenCounselling> getTiCounselling() {
		return tiCounselling;
	}

	public void setTiCounselling(Set<TIBenCounselling> tiCounselling) {
		this.tiCounselling = tiCounselling;
	}

	public Set<TIBenRVAssessment> getTiRVAssessment() {
		return tiRVAssessment;
	}

	public void setTiRVAssessment(Set<TIBenRVAssessment> tiRVAssessment) {
		this.tiRVAssessment = tiRVAssessment;
	}

	public Set<TIStiTreatment> getTiStiTreatment() {
		return tiStiTreatment;
	}

	public void setTiStiTreatment(Set<TIStiTreatment> tiStiTreatment) {
		this.tiStiTreatment = tiStiTreatment;
	}

	public Set<TIBenScrDetails> getTiScreening() {
		return tiScreening;
	}

	public void setTiScreening(Set<TIBenScrDetails> tiScreening) {
		this.tiScreening = tiScreening;
	}
	
	public Boolean getIsExternal() {
		return isExternal;
	}

	public void setIsExternal(Boolean isExternal) {
		this.isExternal = isExternal;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public Set<BeneficiaryFacilityMapping> getBeneficiaryFacilityMappings() {
		return this.beneficiaryFacilityMappings;
	}

	public void setBeneficiaryFacilityMappings(Set<BeneficiaryFacilityMapping> beneficiaryFacilityMappings) {
		this.beneficiaryFacilityMappings = beneficiaryFacilityMappings;
	}

	public BeneficiaryFacilityMapping addBeneficiaryFacilityMapping(
			BeneficiaryFacilityMapping beneficiaryFacilityMapping) {
		getBeneficiaryFacilityMappings().add(beneficiaryFacilityMapping);
		beneficiaryFacilityMapping.setFacility(this);

		return beneficiaryFacilityMapping;
	}

	public BeneficiaryFacilityMapping removeBeneficiaryFacilityMapping(
			BeneficiaryFacilityMapping beneficiaryFacilityMapping) {
		getBeneficiaryFacilityMappings().remove(beneficiaryFacilityMapping);
		beneficiaryFacilityMapping.setFacility(null);

		return beneficiaryFacilityMapping;
	}

	public MasterTiOstType getOstType() {
		return ostType;
	}

	public void setOstType(MasterTiOstType ostType) {
		this.ostType = ostType;
	}

	public Facility getTiCenter() {
		return tiCenter;
	}

	public void setTiCenter(Facility tiCenter) {
		this.tiCenter = tiCenter;
	}

	public Set<Dispensation> getDispensations() {
		return this.dispensations;
	}

	public void setDispensations(Set<Dispensation> dispensations) {
		this.dispensations = dispensations;
	}

	public Set<ArtDispensation> getArtDispensations() {
		return artDispensations;
	}

	public void setArtDispensations(Set<ArtDispensation> artDispensations) {
		this.artDispensations = artDispensations;
	}

	public Dispensation addDispensation(Dispensation dispensation) {
		getDispensations().add(dispensation);
		dispensation.setFacility(this);

		return dispensation;
	}

	public Boolean getClinicPresent() {
		return clinicPresent;
	}

	public void setClinicPresent(Boolean clinicPresent) {
		this.clinicPresent = clinicPresent;
	}

	public LocalDate getValidTill() {
		return validTill;
	}

	public void setValidTill(LocalDate validTill) {
		this.validTill = validTill;
	}

	public Long getSacsId() {
		return sacsId;
	}

	public void setSacsId(Long sacsId) {
		this.sacsId = sacsId;
	}

	public Boolean getIsLab() {
		return isLab;
	}

	public void setIsLab(Boolean isLab) {
		this.isLab = isLab;
	}

	public String getArtcode() {
		return artcode;
	}

	public void setArtcode(String artcode) {
		this.artcode = artcode;
	}

	public String getNodalCentre() {
		return nodalCentre;
	}

	public void setNodalCentre(String nodalCentre) {
		this.nodalCentre = nodalCentre;
	}

	public String getFacilityNo() {
		return facilityNo;
	}

	public void setFacilityNo(String facilityNo) {
		this.facilityNo = facilityNo;
	}

	public Dispensation removeDispensation(Dispensation dispensation) {
		getDispensations().remove(dispensation);
		dispensation.setFacility(null);

		return dispensation;
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

	public FacilityType getFacilityType() {
		return this.facilityType;
	}

	public void setFacilityType(FacilityType facilityType) {
		this.facilityType = facilityType;
	}

	public Set<FacilityProductStock> getFacilityProductStocks() {
		return this.facilityProductStocks;
	}

	public void setFacilityProductStocks(Set<FacilityProductStock> facilityProductStocks) {
		this.facilityProductStocks = facilityProductStocks;
	}

	public FacilityProductStock addFacilityProductStock(FacilityProductStock facilityProductStock) {
		getFacilityProductStocks().add(facilityProductStock);
		facilityProductStock.setFacility(this);

		return facilityProductStock;
	}

	public FacilityProductStock removeFacilityProductStock(FacilityProductStock facilityProductStock) {
		getFacilityProductStocks().remove(facilityProductStock);
		facilityProductStock.setFacility(null);

		return facilityProductStock;
	}

	public Set<FacilityProductStockTran> getFacilityProductStockTrans() {
		return this.facilityProductStockTrans;
	}

	public void setFacilityProductStockTrans(Set<FacilityProductStockTran> facilityProductStockTrans) {
		this.facilityProductStockTrans = facilityProductStockTrans;
	}

	public FacilityProductStockTran addFacilityProductStockTran(FacilityProductStockTran facilityProductStockTran) {
		getFacilityProductStockTrans().add(facilityProductStockTran);
		facilityProductStockTran.setFacility(this);

		return facilityProductStockTran;
	}

	public FacilityProductStockTran removeFacilityProductStockTran(FacilityProductStockTran facilityProductStockTran) {
		getFacilityProductStockTrans().remove(facilityProductStockTran);
		facilityProductStockTran.setFacility(null);

		return facilityProductStockTran;
	}

	public Set<UserMaster> getUserMasters() {
		return this.userMasters;
	}

	public void setUserMasters(Set<UserMaster> userMasters) {
		this.userMasters = userMasters;
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

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
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

	public Set<FacilityStockTransfer> getFacilityStockTransfers1() {
		return this.facilityStockTransfers1;
	}

	public void setFacilityStockTransfers1(Set<FacilityStockTransfer> facilityStockTransfers1) {
		this.facilityStockTransfers1 = facilityStockTransfers1;
	}

	public FacilityStockTransfer addFacilityStockTransfers1(FacilityStockTransfer facilityStockTransfers1) {
		getFacilityStockTransfers1().add(facilityStockTransfers1);
		facilityStockTransfers1.setFacility1(this);

		return facilityStockTransfers1;
	}

	public FacilityStockTransfer removeFacilityStockTransfers1(FacilityStockTransfer facilityStockTransfers1) {
		getFacilityStockTransfers1().remove(facilityStockTransfers1);
		facilityStockTransfers1.setFacility1(null);

		return facilityStockTransfers1;
	}

	public Set<FacilityStockTransfer> getFacilityStockTransfers2() {
		return this.facilityStockTransfers2;
	}

	public void setFacilityStockTransfers2(Set<FacilityStockTransfer> facilityStockTransfers2) {
		this.facilityStockTransfers2 = facilityStockTransfers2;
	}

	public Set<ArtBeneficiaryCounsellingNotes> getArtBeneficiaryCounsellingNotes() {
		return artBeneficiaryCounsellingNotes;
	}

	public void setArtBeneficiaryCounsellingNotes(Set<ArtBeneficiaryCounsellingNotes> artBeneficiaryCounsellingNotes) {
		this.artBeneficiaryCounsellingNotes = artBeneficiaryCounsellingNotes;
	}

	public FacilityStockTransfer addFacilityStockTransfers2(FacilityStockTransfer facilityStockTransfers2) {
		getFacilityStockTransfers2().add(facilityStockTransfers2);
		facilityStockTransfers2.setFacility2(this);

		return facilityStockTransfers2;
	}

	public FacilityStockTransfer removeFacilityStockTransfers2(FacilityStockTransfer facilityStockTransfers2) {
		getFacilityStockTransfers2().remove(facilityStockTransfers2);
		facilityStockTransfers2.setFacility2(null);

		return facilityStockTransfers2;
	}

	public Set<ContractProductScheduleSac> getContractProductScheduleSacs() {
		return this.contractProductScheduleSacs;
	}

	public void setContractProductScheduleSacs(Set<ContractProductScheduleSac> contractProductScheduleSacs) {
		this.contractProductScheduleSacs = contractProductScheduleSacs;
	}

	public ContractProductScheduleSac addContractProductScheduleSac(
			ContractProductScheduleSac contractProductScheduleSac) {
		getContractProductScheduleSacs().add(contractProductScheduleSac);
		contractProductScheduleSac.setFacility(this);

		return contractProductScheduleSac;
	}

	public ContractProductScheduleSac removeContractProductScheduleSac(
			ContractProductScheduleSac contractProductScheduleSac) {
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
		dispatches1.setBillToConsignee(this);

		return dispatches1;
	}

	public Dispatch removeDispatches1(Dispatch dispatches1) {
		getDispatches1().remove(dispatches1);
		dispatches1.setBillToConsignee(null);

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
		dispatches2.setShipToConsignee(this);

		return dispatches2;
	}

	public Dispatch removeDispatches2(Dispatch dispatches2) {
		getDispatches2().remove(dispatches2);
		dispatches2.setShipToConsignee(null);

		return dispatches2;
	}

	public Set<Dispatch> getDispatches3() {
		return this.dispatches3;
	}

	public void setDispatches3(Set<Dispatch> dispatches3) {
		this.dispatches3 = dispatches3;
	}

	public Set<TiOstBeneficiary> getTiOstBeneficiary() {
		return tiOstBeneficiary;
	}

	public void setTiOstBeneficiary(Set<TiOstBeneficiary> tiOstBeneficiary) {
		this.tiOstBeneficiary = tiOstBeneficiary;
	}

	public Dispatch addDispatches3(Dispatch dispatches3) {
		getDispatches2().add(dispatches3);
		dispatches3.setConsignor(this);

		return dispatches3;
	}

	public Dispatch removeDispatches3(Dispatch dispatches3) {
		getDispatches3().remove(dispatches3);
		dispatches3.setConsignor(null);

		return dispatches3;
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

	public Set<FacilityReconciliation> getFacilityReconciliations() {
		return facilityReconciliations;
	}

	public void setFacilityReconciliations(Set<FacilityReconciliation> facilityReconciliations) {
		this.facilityReconciliations = facilityReconciliations;
	}

	public FacilityReconciliation addFacilityReconciliation(FacilityReconciliation facilityReconciliation) {
		getFacilityReconciliations().add(facilityReconciliation);
		facilityReconciliation.setFacility(this);

		return facilityReconciliation;
	}

	public FacilityReconciliation removeFacilityStockAdjustment(FacilityReconciliation facilityReconciliation) {
		getFacilityReconciliations().remove(facilityReconciliation);
		facilityReconciliation.setFacility(null);

		return facilityReconciliation;
	}

	public Integer getMonthlyActiveTarget() {
		return monthlyActiveTarget;
	}

	public void setMonthlyActiveTarget(Integer monthlyActiveTarget) {
		this.monthlyActiveTarget = monthlyActiveTarget;
	}

	public Integer getMonthlyOstTarget() {
		return monthlyOstTarget;
	}

	public void setMonthlyOstTarget(Integer monthlyOstTarget) {
		this.monthlyOstTarget = monthlyOstTarget;
	}

	public String getTiType() {
		return tiType;
	}

	public void setTiType(String tiType) {
		this.tiType = tiType;
	}

	public String getcBStatus() {
		return cBStatus;
	}

	public void setcBStatus(String cBStatus) {
		this.cBStatus = cBStatus;
	}

	public Set<TypologyFacilityMapping> getTypologyFacilityMappings() {
		return typologyFacilityMappings;
	}

	public void setTypologyFacilityMappings(Set<TypologyFacilityMapping> typologyFacilityMappings) {
		this.typologyFacilityMappings = typologyFacilityMappings;
	}

	public Set<FacilityStockDailyBalance> getFacilityStockDailyBalances() {
		return this.facilityStockDailyBalances;
	}

	public void setFacilityStockDailyBalances(Set<FacilityStockDailyBalance> facilityStockDailyBalances) {
		this.facilityStockDailyBalances = facilityStockDailyBalances;
	}

	public Set<BeneficiaryReferral> getBeneficiaryReferrals() {
		return beneficiaryReferrals;
	}

	public void setBeneficiaryReferrals(Set<BeneficiaryReferral> beneficiaryReferrals) {
		this.beneficiaryReferrals = beneficiaryReferrals;
	}

	public Set<BeneficiaryReferral> getBeneficiaryReferrals_Two() {
		return beneficiaryReferrals_Two;
	}

	public void setBeneficiaryReferrals_Two(Set<BeneficiaryReferral> beneficiaryReferrals_Two) {
		this.beneficiaryReferrals_Two = beneficiaryReferrals_Two;
	}

	public FacilityStockDailyBalance addFacilityStockDailyBalance(FacilityStockDailyBalance facilityStockDailyBalance) {
		getFacilityStockDailyBalances().add(facilityStockDailyBalance);
		facilityStockDailyBalance.setFacility(this);

		return facilityStockDailyBalance;
	}

	public FacilityStockDailyBalance removeFacilityStockDailyBalance(
			FacilityStockDailyBalance facilityStockDailyBalance) {
		getFacilityStockDailyBalances().remove(facilityStockDailyBalance);
		facilityStockDailyBalance.setFacility(null);

		return facilityStockDailyBalance;
	}

	public Set<SacsCmssWarehouseMapping> getSacsCmssWarehouseMappings() {
		return sacsCmssWarehouseMappings;
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

}