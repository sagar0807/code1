package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String address;

	@Column(name="address_line_one")
	private String addressLineOne;

	@Column(name="address_line_two")
	private String addressLineTwo;

	private String block;

	private String city;

	private String country;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="geo_latitude")
	private String geoLatitude;

	@Column(name="geo_longitude")
	private String geoLongitude;

	@Column(name="house_no")
	private Integer houseNo;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private String taluk;

	//bi-directional many-to-one association to District
	@ManyToOne
	private District district;

	//bi-directional many-to-one association to Pincode
	@ManyToOne
	@JoinColumn(name="pincode")
	private Pincode pincode1;

	//bi-directional many-to-one association to Pincode
	@ManyToOne
	@JoinColumn(name="pincode_id")
	private Pincode pincode2;

	//bi-directional many-to-one association to State
	@ManyToOne
	private State state;

	//bi-directional many-to-one association to Subdistrict
	@ManyToOne
	@JoinColumn(name="subdistrict_id")
	private Subdistrict subdistrict;

	//bi-directional many-to-one association to Town
	@ManyToOne
	@JoinColumn(name="town_id")
	private Town town;

	//bi-directional many-to-one association to Beneficiary
	@OneToMany(mappedBy="address")
	private Set<Beneficiary> beneficiaries;

	//bi-directional many-to-one association to Facility
	@OneToMany(mappedBy="address")
	private Set<Facility> facilities;

	//bi-directional many-to-one association to MasterInventoryUnregisteredSource
	@OneToMany(mappedBy="address")
	private Set<MasterInventoryUnregisteredSource> masterInventoryUnregisteredSources;

	//bi-directional many-to-one association to TiOstBeneficiary
	@OneToMany(mappedBy="address")
	private Set<TiOstBeneficiary> tiOstBeneficiaries;

	public Address() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressLineOne() {
		return this.addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return this.addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getBlock() {
		return this.block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public Integer getHouseNo() {
		return this.houseNo;
	}

	public void setHouseNo(Integer houseNo) {
		this.houseNo = houseNo;
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

	public String getTaluk() {
		return this.taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	public District getDistrict() {
		return this.district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Pincode getPincode1() {
		return this.pincode1;
	}

	public void setPincode1(Pincode pincode1) {
		this.pincode1 = pincode1;
	}

	public Pincode getPincode2() {
		return this.pincode2;
	}

	public void setPincode2(Pincode pincode2) {
		this.pincode2 = pincode2;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Subdistrict getSubdistrict() {
		return this.subdistrict;
	}

	public void setSubdistrict(Subdistrict subdistrict) {
		this.subdistrict = subdistrict;
	}

	public Town getTown() {
		return this.town;
	}

	public void setTown(Town town) {
		this.town = town;
	}

	public Set<Beneficiary> getBeneficiaries() {
		return this.beneficiaries;
	}

	public void setBeneficiaries(Set<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	public Beneficiary addBeneficiary(Beneficiary beneficiary) {
		getBeneficiaries().add(beneficiary);
		beneficiary.setAddress(this);

		return beneficiary;
	}

	public Beneficiary removeBeneficiary(Beneficiary beneficiary) {
		getBeneficiaries().remove(beneficiary);
		beneficiary.setAddress(null);

		return beneficiary;
	}

	public Set<Facility> getFacilities() {
		return this.facilities;
	}

	public void setFacilities(Set<Facility> facilities) {
		this.facilities = facilities;
	}

	public Facility addFacility(Facility facility) {
		getFacilities().add(facility);
		facility.setAddress(this);

		return facility;
	}

	public Facility removeFacility(Facility facility) {
		getFacilities().remove(facility);
		facility.setAddress(null);

		return facility;
	}

	public Set<MasterInventoryUnregisteredSource> getMasterInventoryUnregisteredSources() {
		return this.masterInventoryUnregisteredSources;
	}

	public void setMasterInventoryUnregisteredSources(Set<MasterInventoryUnregisteredSource> masterInventoryUnregisteredSources) {
		this.masterInventoryUnregisteredSources = masterInventoryUnregisteredSources;
	}

	public MasterInventoryUnregisteredSource addMasterInventoryUnregisteredSource(MasterInventoryUnregisteredSource masterInventoryUnregisteredSource) {
		getMasterInventoryUnregisteredSources().add(masterInventoryUnregisteredSource);
		masterInventoryUnregisteredSource.setAddress(this);

		return masterInventoryUnregisteredSource;
	}

	public MasterInventoryUnregisteredSource removeMasterInventoryUnregisteredSource(MasterInventoryUnregisteredSource masterInventoryUnregisteredSource) {
		getMasterInventoryUnregisteredSources().remove(masterInventoryUnregisteredSource);
		masterInventoryUnregisteredSource.setAddress(null);

		return masterInventoryUnregisteredSource;
	}

	public Set<TiOstBeneficiary> getTiOstBeneficiaries() {
		return this.tiOstBeneficiaries;
	}

	public void setTiOstBeneficiaries(Set<TiOstBeneficiary> tiOstBeneficiaries) {
		this.tiOstBeneficiaries = tiOstBeneficiaries;
	}

	public TiOstBeneficiary addTiOstBeneficiary(TiOstBeneficiary tiOstBeneficiary) {
		getTiOstBeneficiaries().add(tiOstBeneficiary);
		tiOstBeneficiary.setAddress(this);

		return tiOstBeneficiary;
	}

	public TiOstBeneficiary removeTiOstBeneficiary(TiOstBeneficiary tiOstBeneficiary) {
		getTiOstBeneficiaries().remove(tiOstBeneficiary);
		tiOstBeneficiary.setAddress(null);

		return tiOstBeneficiary;
	}

}