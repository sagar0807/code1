package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the master_batch_status database table.
 * 
 */
@Entity
@Table(name="master_batch_status")
@NamedQuery(name="MasterBatchStatus.findAll", query="SELECT m FROM MasterBatchStatus m")
public class MasterBatchStatus implements Serializable {
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

	//bi-directional many-to-one association to LabTestSampleBatch
	@OneToMany(mappedBy="masterBatchStatus")
	private Set<LabTestSampleBatch> labTestSampleBatches;

	public MasterBatchStatus() {
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

	public Set<LabTestSampleBatch> getLabTestSampleBatches() {
		return this.labTestSampleBatches;
	}

	public void setLabTestSampleBatches(Set<LabTestSampleBatch> labTestSampleBatches) {
		this.labTestSampleBatches = labTestSampleBatches;
	}

	public LabTestSampleBatch addLabTestSampleBatch(LabTestSampleBatch labTestSampleBatch) {
		getLabTestSampleBatches().add(labTestSampleBatch);
		labTestSampleBatch.setMasterBatchStatus(this);

		return labTestSampleBatch;
	}

	public LabTestSampleBatch removeLabTestSampleBatch(LabTestSampleBatch labTestSampleBatch) {
		getLabTestSampleBatches().remove(labTestSampleBatch);
		labTestSampleBatch.setMasterBatchStatus(null);

		return labTestSampleBatch;
	}

}