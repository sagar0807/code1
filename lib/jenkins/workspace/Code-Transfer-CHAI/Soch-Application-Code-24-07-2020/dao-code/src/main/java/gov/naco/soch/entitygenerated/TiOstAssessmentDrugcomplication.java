package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ti_ost_assessment_drugcomplication database table.
 * 
 */
@Entity
@Table(name="ti_ost_assessment_drugcomplication")
@NamedQuery(name="TiOstAssessmentDrugcomplication.findAll", query="SELECT t FROM TiOstAssessmentDrugcomplication t")
public class TiOstAssessmentDrugcomplication implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String complication;

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

	//bi-directional many-to-one association to TiOstAssessment
	@ManyToOne
	@JoinColumn(name="assessment_id")
	private TiOstAssessment tiOstAssessment;

	public TiOstAssessmentDrugcomplication() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComplication() {
		return this.complication;
	}

	public void setComplication(String complication) {
		this.complication = complication;
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

	public TiOstAssessment getTiOstAssessment() {
		return this.tiOstAssessment;
	}

	public void setTiOstAssessment(TiOstAssessment tiOstAssessment) {
		this.tiOstAssessment = tiOstAssessment;
	}

}