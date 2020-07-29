package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the typology_facility_mapping database table.
 * 
 */
@Entity
@Table(name="typology_facility_mapping")
@NamedQuery(name="TypologyFacilityMapping.findAll", query="SELECT t FROM TypologyFacilityMapping t")
public class TypologyFacilityMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="typology_facility_mapping_id")
	private Integer typologyFacilityMappingId;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="typology_target")
	private Integer typologyTarget;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to TypologyMaster
	@ManyToOne
	@JoinColumn(name="typology_id")
	private TypologyMaster typologyMaster;

	public TypologyFacilityMapping() {
	}

	public Integer getTypologyFacilityMappingId() {
		return this.typologyFacilityMappingId;
	}

	public void setTypologyFacilityMappingId(Integer typologyFacilityMappingId) {
		this.typologyFacilityMappingId = typologyFacilityMappingId;
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

	public Integer getTypologyTarget() {
		return this.typologyTarget;
	}

	public void setTypologyTarget(Integer typologyTarget) {
		this.typologyTarget = typologyTarget;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public TypologyMaster getTypologyMaster() {
		return this.typologyMaster;
	}

	public void setTypologyMaster(TypologyMaster typologyMaster) {
		this.typologyMaster = typologyMaster;
	}

}