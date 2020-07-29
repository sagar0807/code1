package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the master_data database table.
 * 
 */
@Entity
@Table(name="master_data")
@NamedQuery(name="MasterData.findAll", query="SELECT m FROM MasterData m")
public class MasterData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String code;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	private String description;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="master_type")
	private String masterType;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private String name;

	//bi-directional many-to-one association to Regimen
	@OneToMany(mappedBy="masterData1")
	private Set<Regimen> regimens1;

	//bi-directional many-to-one association to Regimen
	@OneToMany(mappedBy="masterData2")
	private Set<Regimen> regimens2;

	public MasterData() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getMasterType() {
		return this.masterType;
	}

	public void setMasterType(String masterType) {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Regimen> getRegimens1() {
		return this.regimens1;
	}

	public void setRegimens1(Set<Regimen> regimens1) {
		this.regimens1 = regimens1;
	}

	public Regimen addRegimens1(Regimen regimens1) {
		getRegimens1().add(regimens1);
		regimens1.setMasterData1(this);

		return regimens1;
	}

	public Regimen removeRegimens1(Regimen regimens1) {
		getRegimens1().remove(regimens1);
		regimens1.setMasterData1(null);

		return regimens1;
	}

	public Set<Regimen> getRegimens2() {
		return this.regimens2;
	}

	public void setRegimens2(Set<Regimen> regimens2) {
		this.regimens2 = regimens2;
	}

	public Regimen addRegimens2(Regimen regimens2) {
		getRegimens2().add(regimens2);
		regimens2.setMasterData2(this);

		return regimens2;
	}

	public Regimen removeRegimens2(Regimen regimens2) {
		getRegimens2().remove(regimens2);
		regimens2.setMasterData2(null);

		return regimens2;
	}

}