package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the master_name_list database table.
 * 
 */
@Entity
@Table(name="master_name_list")
@NamedQuery(name="MasterNameList.findAll", query="SELECT m FROM MasterNameList m")
public class MasterNameList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="fetch_endpoint")
	private String fetchEndpoint;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="master_description")
	private String masterDescription;

	@Column(name="master_name")
	private String masterName;

	@Column(name="master_type")
	private Integer masterType;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="save_endpoint")
	private String saveEndpoint;

	public MasterNameList() {
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

	public String getFetchEndpoint() {
		return this.fetchEndpoint;
	}

	public void setFetchEndpoint(String fetchEndpoint) {
		this.fetchEndpoint = fetchEndpoint;
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

	public String getMasterDescription() {
		return this.masterDescription;
	}

	public void setMasterDescription(String masterDescription) {
		this.masterDescription = masterDescription;
	}

	public String getMasterName() {
		return this.masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public Integer getMasterType() {
		return this.masterType;
	}

	public void setMasterType(Integer masterType) {
		this.masterType = masterType;
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

	public String getSaveEndpoint() {
		return this.saveEndpoint;
	}

	public void setSaveEndpoint(String saveEndpoint) {
		this.saveEndpoint = saveEndpoint;
	}

}