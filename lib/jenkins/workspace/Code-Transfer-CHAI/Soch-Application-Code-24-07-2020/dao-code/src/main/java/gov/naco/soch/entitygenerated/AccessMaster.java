package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the access_master database table.
 * 
 */
@Entity
@Table(name="access_master")
@NamedQuery(name="AccessMaster.findAll", query="SELECT a FROM AccessMaster a")
public class AccessMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String code;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	private String description;

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

	private String module;

	private String name;

	//bi-directional many-to-one association to MenuAccessMapping
	@OneToMany(mappedBy="accessMaster")
	private Set<MenuAccessMapping> menuAccessMappings;

	//bi-directional many-to-one association to RoleAccessMapping
	@OneToMany(mappedBy="accessMaster")
	private Set<RoleAccessMapping> roleAccessMappings;

	public AccessMaster() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<MenuAccessMapping> getMenuAccessMappings() {
		return this.menuAccessMappings;
	}

	public void setMenuAccessMappings(Set<MenuAccessMapping> menuAccessMappings) {
		this.menuAccessMappings = menuAccessMappings;
	}

	public MenuAccessMapping addMenuAccessMapping(MenuAccessMapping menuAccessMapping) {
		getMenuAccessMappings().add(menuAccessMapping);
		menuAccessMapping.setAccessMaster(this);

		return menuAccessMapping;
	}

	public MenuAccessMapping removeMenuAccessMapping(MenuAccessMapping menuAccessMapping) {
		getMenuAccessMappings().remove(menuAccessMapping);
		menuAccessMapping.setAccessMaster(null);

		return menuAccessMapping;
	}

	public Set<RoleAccessMapping> getRoleAccessMappings() {
		return this.roleAccessMappings;
	}

	public void setRoleAccessMappings(Set<RoleAccessMapping> roleAccessMappings) {
		this.roleAccessMappings = roleAccessMappings;
	}

	public RoleAccessMapping addRoleAccessMapping(RoleAccessMapping roleAccessMapping) {
		getRoleAccessMappings().add(roleAccessMapping);
		roleAccessMapping.setAccessMaster(this);

		return roleAccessMapping;
	}

	public RoleAccessMapping removeRoleAccessMapping(RoleAccessMapping roleAccessMapping) {
		getRoleAccessMappings().remove(roleAccessMapping);
		roleAccessMapping.setAccessMaster(null);

		return roleAccessMapping;
	}

}