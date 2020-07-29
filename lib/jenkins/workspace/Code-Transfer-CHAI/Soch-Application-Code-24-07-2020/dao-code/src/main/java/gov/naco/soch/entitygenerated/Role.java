package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="is_primary")
	private Boolean isPrimary;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private String name;

	//bi-directional many-to-one association to NotificationEventRole
	@OneToMany(mappedBy="role")
	private Set<NotificationEventRole> notificationEventRoles;

	//bi-directional many-to-one association to FacilityType
	@ManyToOne
	@JoinColumn(name="facility_type_id")
	private FacilityType facilityType;

	//bi-directional many-to-one association to RoleAccessMapping
	@OneToMany(mappedBy="role")
	private Set<RoleAccessMapping> roleAccessMappings;

	//bi-directional many-to-one association to UserRoleMapping
	@OneToMany(mappedBy="role")
	private Set<UserRoleMapping> userRoleMappings;

	public Role() {
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

	public Boolean getIsPrimary() {
		return this.isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
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

	public Set<NotificationEventRole> getNotificationEventRoles() {
		return this.notificationEventRoles;
	}

	public void setNotificationEventRoles(Set<NotificationEventRole> notificationEventRoles) {
		this.notificationEventRoles = notificationEventRoles;
	}

	public NotificationEventRole addNotificationEventRole(NotificationEventRole notificationEventRole) {
		getNotificationEventRoles().add(notificationEventRole);
		notificationEventRole.setRole(this);

		return notificationEventRole;
	}

	public NotificationEventRole removeNotificationEventRole(NotificationEventRole notificationEventRole) {
		getNotificationEventRoles().remove(notificationEventRole);
		notificationEventRole.setRole(null);

		return notificationEventRole;
	}

	public FacilityType getFacilityType() {
		return this.facilityType;
	}

	public void setFacilityType(FacilityType facilityType) {
		this.facilityType = facilityType;
	}

	public Set<RoleAccessMapping> getRoleAccessMappings() {
		return this.roleAccessMappings;
	}

	public void setRoleAccessMappings(Set<RoleAccessMapping> roleAccessMappings) {
		this.roleAccessMappings = roleAccessMappings;
	}

	public RoleAccessMapping addRoleAccessMapping(RoleAccessMapping roleAccessMapping) {
		getRoleAccessMappings().add(roleAccessMapping);
		roleAccessMapping.setRole(this);

		return roleAccessMapping;
	}

	public RoleAccessMapping removeRoleAccessMapping(RoleAccessMapping roleAccessMapping) {
		getRoleAccessMappings().remove(roleAccessMapping);
		roleAccessMapping.setRole(null);

		return roleAccessMapping;
	}

	public Set<UserRoleMapping> getUserRoleMappings() {
		return this.userRoleMappings;
	}

	public void setUserRoleMappings(Set<UserRoleMapping> userRoleMappings) {
		this.userRoleMappings = userRoleMappings;
	}

	public UserRoleMapping addUserRoleMapping(UserRoleMapping userRoleMapping) {
		getUserRoleMappings().add(userRoleMapping);
		userRoleMapping.setRole(this);

		return userRoleMapping;
	}

	public UserRoleMapping removeUserRoleMapping(UserRoleMapping userRoleMapping) {
		getUserRoleMappings().remove(userRoleMapping);
		userRoleMapping.setRole(null);

		return userRoleMapping;
	}

}