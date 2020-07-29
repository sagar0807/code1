package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the master_art_counselling_options database table.
 * 
 */
@Entity
@Table(name="master_art_counselling_options")
@NamedQuery(name="MasterArtCounsellingOption.findAll", query="SELECT m FROM MasterArtCounsellingOption m")
public class MasterArtCounsellingOption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="counselling_option")
	private String counsellingOption;

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

	//bi-directional many-to-one association to MasterArtCounsellingNote
	@ManyToOne
	@JoinColumn(name="counselling_note_id")
	private MasterArtCounsellingNote masterArtCounsellingNote;

	public MasterArtCounsellingOption() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCounsellingOption() {
		return this.counsellingOption;
	}

	public void setCounsellingOption(String counsellingOption) {
		this.counsellingOption = counsellingOption;
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

	public MasterArtCounsellingNote getMasterArtCounsellingNote() {
		return this.masterArtCounsellingNote;
	}

	public void setMasterArtCounsellingNote(MasterArtCounsellingNote masterArtCounsellingNote) {
		this.masterArtCounsellingNote = masterArtCounsellingNote;
	}

}