package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the machine database table.
 * 
 */
@Entity
@NamedQuery(name="Machine.findAll", query="SELECT m FROM Machine m")
public class Machine implements Serializable {
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

	@Column(name="machine_name")
	private String machineName;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private String status;

	//bi-directional many-to-one association to Facility
	@OneToMany(mappedBy="machine")
	private Set<Facility> facilities;

	//bi-directional many-to-one association to LabMachineMapping
	@OneToMany(mappedBy="machine")
	private Set<LabMachineMapping> labMachineMappings;

	//bi-directional many-to-one association to LabTestSample
	@OneToMany(mappedBy="machine")
	private Set<LabTestSample> labTestSamples;

	public Machine() {
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

	public String getMachineName() {
		return this.machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Facility> getFacilities() {
		return this.facilities;
	}

	public void setFacilities(Set<Facility> facilities) {
		this.facilities = facilities;
	}

	public Facility addFacility(Facility facility) {
		getFacilities().add(facility);
		facility.setMachine(this);

		return facility;
	}

	public Facility removeFacility(Facility facility) {
		getFacilities().remove(facility);
		facility.setMachine(null);

		return facility;
	}

	public Set<LabMachineMapping> getLabMachineMappings() {
		return this.labMachineMappings;
	}

	public void setLabMachineMappings(Set<LabMachineMapping> labMachineMappings) {
		this.labMachineMappings = labMachineMappings;
	}

	public LabMachineMapping addLabMachineMapping(LabMachineMapping labMachineMapping) {
		getLabMachineMappings().add(labMachineMapping);
		labMachineMapping.setMachine(this);

		return labMachineMapping;
	}

	public LabMachineMapping removeLabMachineMapping(LabMachineMapping labMachineMapping) {
		getLabMachineMappings().remove(labMachineMapping);
		labMachineMapping.setMachine(null);

		return labMachineMapping;
	}

	public Set<LabTestSample> getLabTestSamples() {
		return this.labTestSamples;
	}

	public void setLabTestSamples(Set<LabTestSample> labTestSamples) {
		this.labTestSamples = labTestSamples;
	}

	public LabTestSample addLabTestSample(LabTestSample labTestSample) {
		getLabTestSamples().add(labTestSample);
		labTestSample.setMachine(this);

		return labTestSample;
	}

	public LabTestSample removeLabTestSample(LabTestSample labTestSample) {
		getLabTestSamples().remove(labTestSample);
		labTestSample.setMachine(null);

		return labTestSample;
	}

}