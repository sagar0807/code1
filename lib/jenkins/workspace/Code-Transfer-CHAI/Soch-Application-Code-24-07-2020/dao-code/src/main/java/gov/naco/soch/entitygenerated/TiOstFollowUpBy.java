package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ti_ost_follow_up_by database table.
 * 
 */
@Entity
@Table(name="ti_ost_follow_up_by")
@NamedQuery(name="TiOstFollowUpBy.findAll", query="SELECT t FROM TiOstFollowUpBy t")
public class TiOstFollowUpBy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="follow_up_by")
	private Integer followUpBy;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	//bi-directional many-to-one association to TiOstFollowUp
	@ManyToOne
	@JoinColumn(name="followup_id")
	private TiOstFollowUp tiOstFollowUp;

	public TiOstFollowUpBy() {
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

	public Integer getFollowUpBy() {
		return this.followUpBy;
	}

	public void setFollowUpBy(Integer followUpBy) {
		this.followUpBy = followUpBy;
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

	public TiOstFollowUp getTiOstFollowUp() {
		return this.tiOstFollowUp;
	}

	public void setTiOstFollowUp(TiOstFollowUp tiOstFollowUp) {
		this.tiOstFollowUp = tiOstFollowUp;
	}

}