package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the division database table.
 * 
 */
@Entity
@NamedQuery(name="Division.findAll", query="SELECT d FROM Division d")
public class Division implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String code;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="head_ddg_name")
	private String headDdgName;

	@Column(name="head_email_id")
	private String headEmailId;

	@Column(name="head_phone_number")
	private String headPhoneNumber;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private String name;

	@Column(name="npo_email_id")
	private String npoEmailId;

	@Column(name="npo_mobile_number")
	private String npoMobileNumber;

	@Column(name="npo_name")
	private String npoName;

	@Column(name="scc_email_id")
	private String sccEmailId;

	@Column(name="scc_mobile_number")
	private String sccMobileNumber;

	@Column(name="scc_name")
	private String sccName;

	//bi-directional many-to-one association to Facility
	@OneToMany(mappedBy="division")
	private Set<Facility> facilities;

	//bi-directional many-to-one association to FacilityTypeDivisionMapping
	@OneToMany(mappedBy="division")
	private Set<FacilityTypeDivisionMapping> facilityTypeDivisionMappings;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="division")
	private Set<Product> products;

	//bi-directional many-to-one association to UserMaster
	@OneToMany(mappedBy="division")
	private Set<UserMaster> userMasters;

	public Division() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getHeadDdgName() {
		return this.headDdgName;
	}

	public void setHeadDdgName(String headDdgName) {
		this.headDdgName = headDdgName;
	}

	public String getHeadEmailId() {
		return this.headEmailId;
	}

	public void setHeadEmailId(String headEmailId) {
		this.headEmailId = headEmailId;
	}

	public String getHeadPhoneNumber() {
		return this.headPhoneNumber;
	}

	public void setHeadPhoneNumber(String headPhoneNumber) {
		this.headPhoneNumber = headPhoneNumber;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNpoEmailId() {
		return this.npoEmailId;
	}

	public void setNpoEmailId(String npoEmailId) {
		this.npoEmailId = npoEmailId;
	}

	public String getNpoMobileNumber() {
		return this.npoMobileNumber;
	}

	public void setNpoMobileNumber(String npoMobileNumber) {
		this.npoMobileNumber = npoMobileNumber;
	}

	public String getNpoName() {
		return this.npoName;
	}

	public void setNpoName(String npoName) {
		this.npoName = npoName;
	}

	public String getSccEmailId() {
		return this.sccEmailId;
	}

	public void setSccEmailId(String sccEmailId) {
		this.sccEmailId = sccEmailId;
	}

	public String getSccMobileNumber() {
		return this.sccMobileNumber;
	}

	public void setSccMobileNumber(String sccMobileNumber) {
		this.sccMobileNumber = sccMobileNumber;
	}

	public String getSccName() {
		return this.sccName;
	}

	public void setSccName(String sccName) {
		this.sccName = sccName;
	}

	public Set<Facility> getFacilities() {
		return this.facilities;
	}

	public void setFacilities(Set<Facility> facilities) {
		this.facilities = facilities;
	}

	public Facility addFacility(Facility facility) {
		getFacilities().add(facility);
		facility.setDivision(this);

		return facility;
	}

	public Facility removeFacility(Facility facility) {
		getFacilities().remove(facility);
		facility.setDivision(null);

		return facility;
	}

	public Set<FacilityTypeDivisionMapping> getFacilityTypeDivisionMappings() {
		return this.facilityTypeDivisionMappings;
	}

	public void setFacilityTypeDivisionMappings(Set<FacilityTypeDivisionMapping> facilityTypeDivisionMappings) {
		this.facilityTypeDivisionMappings = facilityTypeDivisionMappings;
	}

	public FacilityTypeDivisionMapping addFacilityTypeDivisionMapping(FacilityTypeDivisionMapping facilityTypeDivisionMapping) {
		getFacilityTypeDivisionMappings().add(facilityTypeDivisionMapping);
		facilityTypeDivisionMapping.setDivision(this);

		return facilityTypeDivisionMapping;
	}

	public FacilityTypeDivisionMapping removeFacilityTypeDivisionMapping(FacilityTypeDivisionMapping facilityTypeDivisionMapping) {
		getFacilityTypeDivisionMappings().remove(facilityTypeDivisionMapping);
		facilityTypeDivisionMapping.setDivision(null);

		return facilityTypeDivisionMapping;
	}

	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setDivision(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setDivision(null);

		return product;
	}

	public Set<UserMaster> getUserMasters() {
		return this.userMasters;
	}

	public void setUserMasters(Set<UserMaster> userMasters) {
		this.userMasters = userMasters;
	}

	public UserMaster addUserMaster(UserMaster userMaster) {
		getUserMasters().add(userMaster);
		userMaster.setDivision(this);

		return userMaster;
	}

	public UserMaster removeUserMaster(UserMaster userMaster) {
		getUserMasters().remove(userMaster);
		userMaster.setDivision(null);

		return userMaster;
	}

}