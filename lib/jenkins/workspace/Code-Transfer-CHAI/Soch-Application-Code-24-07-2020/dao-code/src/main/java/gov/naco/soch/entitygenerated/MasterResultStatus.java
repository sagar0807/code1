package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the master_result_status database table.
 * 
 */
@Entity
@Table(name="master_result_status")
@NamedQuery(name="MasterResultStatus.findAll", query="SELECT m FROM MasterResultStatus m")
public class MasterResultStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private String status;

	//bi-directional many-to-one association to LabTestSample
	@OneToMany(mappedBy="masterResultStatus")
	private Set<LabTestSample> labTestSamples;

	public MasterResultStatus() {
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<LabTestSample> getLabTestSamples() {
		return this.labTestSamples;
	}

	public void setLabTestSamples(Set<LabTestSample> labTestSamples) {
		this.labTestSamples = labTestSamples;
	}

	public LabTestSample addLabTestSample(LabTestSample labTestSample) {
		getLabTestSamples().add(labTestSample);
		labTestSample.setMasterResultStatus(this);

		return labTestSample;
	}

	public LabTestSample removeLabTestSample(LabTestSample labTestSample) {
		getLabTestSamples().remove(labTestSample);
		labTestSample.setMasterResultStatus(null);

		return labTestSample;
	}

}