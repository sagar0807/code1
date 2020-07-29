package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the facility_type database table.
 * 
 */
@Entity
@Table(name="facility_type")
@NamedQuery(name="FacilityType.findAll", query="SELECT f FROM FacilityType f")
public class FacilityType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="facility_type_name")
	private String facilityTypeName;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	//bi-directional many-to-one association to Facility
	@OneToMany(mappedBy="facilityType")
	private Set<Facility> facilities;

	//bi-directional many-to-one association to FacilityLinkedFacilityBeneficiary
	@OneToMany(mappedBy="facilityTypeBean")
	private Set<FacilityLinkedFacilityBeneficiary> facilityLinkedFacilityBeneficiaries;

	//bi-directional many-to-one association to FacilitySetting
	@OneToMany(mappedBy="facilityType")
	private Set<FacilitySetting> facilitySettings;

	//bi-directional many-to-one association to FacilityTypeDivisionMapping
	@OneToMany(mappedBy="facilityType")
	private Set<FacilityTypeDivisionMapping> facilityTypeDivisionMappings;

	//bi-directional many-to-one association to Role
	@OneToMany(mappedBy="facilityType")
	private Set<Role> roles;

	//bi-directional many-to-one association to UserMaster
	@OneToMany(mappedBy="facilityType")
	private Set<UserMaster> userMasters;

	public FacilityType() {
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

	public String getFacilityTypeName() {
		return this.facilityTypeName;
	}

	public void setFacilityTypeName(String facilityTypeName) {
		this.facilityTypeName = facilityTypeName;
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

	public Set<Facility> getFacilities() {
		return this.facilities;
	}

	public void setFacilities(Set<Facility> facilities) {
		this.facilities = facilities;
	}

	public Facility addFacility(Facility facility) {
		getFacilities().add(facility);
		facility.setFacilityType(this);

		return facility;
	}

	public Facility removeFacility(Facility facility) {
		getFacilities().remove(facility);
		facility.setFacilityType(null);

		return facility;
	}

	public Set<FacilityLinkedFacilityBeneficiary> getFacilityLinkedFacilityBeneficiaries() {
		return this.facilityLinkedFacilityBeneficiaries;
	}

	public void setFacilityLinkedFacilityBeneficiaries(Set<FacilityLinkedFacilityBeneficiary> facilityLinkedFacilityBeneficiaries) {
		this.facilityLinkedFacilityBeneficiaries = facilityLinkedFacilityBeneficiaries;
	}

	public FacilityLinkedFacilityBeneficiary addFacilityLinkedFacilityBeneficiary(FacilityLinkedFacilityBeneficiary facilityLinkedFacilityBeneficiary) {
		getFacilityLinkedFacilityBeneficiaries().add(facilityLinkedFacilityBeneficiary);
		facilityLinkedFacilityBeneficiary.setFacilityTypeBean(this);

		return facilityLinkedFacilityBeneficiary;
	}

	public FacilityLinkedFacilityBeneficiary removeFacilityLinkedFacilityBeneficiary(FacilityLinkedFacilityBeneficiary facilityLinkedFacilityBeneficiary) {
		getFacilityLinkedFacilityBeneficiaries().remove(facilityLinkedFacilityBeneficiary);
		facilityLinkedFacilityBeneficiary.setFacilityTypeBean(null);

		return facilityLinkedFacilityBeneficiary;
	}

	public Set<FacilitySetting> getFacilitySettings() {
		return this.facilitySettings;
	}

	public void setFacilitySettings(Set<FacilitySetting> facilitySettings) {
		this.facilitySettings = facilitySettings;
	}

	public FacilitySetting addFacilitySetting(FacilitySetting facilitySetting) {
		getFacilitySettings().add(facilitySetting);
		facilitySetting.setFacilityType(this);

		return facilitySetting;
	}

	public FacilitySetting removeFacilitySetting(FacilitySetting facilitySetting) {
		getFacilitySettings().remove(facilitySetting);
		facilitySetting.setFacilityType(null);

		return facilitySetting;
	}

	public Set<FacilityTypeDivisionMapping> getFacilityTypeDivisionMappings() {
		return this.facilityTypeDivisionMappings;
	}

	public void setFacilityTypeDivisionMappings(Set<FacilityTypeDivisionMapping> facilityTypeDivisionMappings) {
		this.facilityTypeDivisionMappings = facilityTypeDivisionMappings;
	}

	public FacilityTypeDivisionMapping addFacilityTypeDivisionMapping(FacilityTypeDivisionMapping facilityTypeDivisionMapping) {
		getFacilityTypeDivisionMappings().add(facilityTypeDivisionMapping);
		facilityTypeDivisionMapping.setFacilityType(this);

		return facilityTypeDivisionMapping;
	}

	public FacilityTypeDivisionMapping removeFacilityTypeDivisionMapping(FacilityTypeDivisionMapping facilityTypeDivisionMapping) {
		getFacilityTypeDivisionMappings().remove(facilityTypeDivisionMapping);
		facilityTypeDivisionMapping.setFacilityType(null);

		return facilityTypeDivisionMapping;
	}

	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Role addRole(Role role) {
		getRoles().add(role);
		role.setFacilityType(this);

		return role;
	}

	public Role removeRole(Role role) {
		getRoles().remove(role);
		role.setFacilityType(null);

		return role;
	}

	public Set<UserMaster> getUserMasters() {
		return this.userMasters;
	}

	public void setUserMasters(Set<UserMaster> userMasters) {
		this.userMasters = userMasters;
	}

	public UserMaster addUserMaster(UserMaster userMaster) {
		getUserMasters().add(userMaster);
		userMaster.setFacilityType(this);

		return userMaster;
	}

	public UserMaster removeUserMaster(UserMaster userMaster) {
		getUserMasters().remove(userMaster);
		userMaster.setFacilityType(null);

		return userMaster;
	}

}