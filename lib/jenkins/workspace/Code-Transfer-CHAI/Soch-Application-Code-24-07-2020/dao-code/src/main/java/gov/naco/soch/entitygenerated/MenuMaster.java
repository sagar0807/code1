package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the menu_master database table.
 * 
 */
@Entity
@Table(name="menu_master")
@NamedQuery(name="MenuMaster.findAll", query="SELECT m FROM MenuMaster m")
public class MenuMaster implements Serializable {
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

	@Column(name="menu_name")
	private String menuName;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private Integer position;

	@Column(name="route_link")
	private String routeLink;

	//bi-directional many-to-one association to MenuAccessMapping
	@OneToMany(mappedBy="menuMaster")
	private Set<MenuAccessMapping> menuAccessMappings;

	public MenuMaster() {
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

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
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

	public Integer getPosition() {
		return this.position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getRouteLink() {
		return this.routeLink;
	}

	public void setRouteLink(String routeLink) {
		this.routeLink = routeLink;
	}

	public Set<MenuAccessMapping> getMenuAccessMappings() {
		return this.menuAccessMappings;
	}

	public void setMenuAccessMappings(Set<MenuAccessMapping> menuAccessMappings) {
		this.menuAccessMappings = menuAccessMappings;
	}

	public MenuAccessMapping addMenuAccessMapping(MenuAccessMapping menuAccessMapping) {
		getMenuAccessMappings().add(menuAccessMapping);
		menuAccessMapping.setMenuMaster(this);

		return menuAccessMapping;
	}

	public MenuAccessMapping removeMenuAccessMapping(MenuAccessMapping menuAccessMapping) {
		getMenuAccessMappings().remove(menuAccessMapping);
		menuAccessMapping.setMenuMaster(null);

		return menuAccessMapping;
	}

}