package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the master_art_counselling_type database table.
 * 
 */
@Entity
@Table(name="master_art_counselling_type")
@NamedQuery(name="MasterArtCounsellingType.findAll", query="SELECT m FROM MasterArtCounsellingType m")
public class MasterArtCounsellingType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="counselling_type")
	private String counsellingType;

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
	@OneToMany(mappedBy="masterArtCounsellingType")
	private Set<MasterArtCounsellingNote> masterArtCounsellingNotes;

	public MasterArtCounsellingType() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCounsellingType() {
		return this.counsellingType;
	}

	public void setCounsellingType(String counsellingType) {
		this.counsellingType = counsellingType;
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

	public Set<MasterArtCounsellingNote> getMasterArtCounsellingNotes() {
		return this.masterArtCounsellingNotes;
	}

	public void setMasterArtCounsellingNotes(Set<MasterArtCounsellingNote> masterArtCounsellingNotes) {
		this.masterArtCounsellingNotes = masterArtCounsellingNotes;
	}

	public MasterArtCounsellingNote addMasterArtCounsellingNote(MasterArtCounsellingNote masterArtCounsellingNote) {
		getMasterArtCounsellingNotes().add(masterArtCounsellingNote);
		masterArtCounsellingNote.setMasterArtCounsellingType(this);

		return masterArtCounsellingNote;
	}

	public MasterArtCounsellingNote removeMasterArtCounsellingNote(MasterArtCounsellingNote masterArtCounsellingNote) {
		getMasterArtCounsellingNotes().remove(masterArtCounsellingNote);
		masterArtCounsellingNote.setMasterArtCounsellingType(null);

		return masterArtCounsellingNote;
	}

}