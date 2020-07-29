package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the master_art_counselling_note database table.
 * 
 */
@Entity
@Table(name="master_art_counselling_note")
@NamedQuery(name="MasterArtCounsellingNote.findAll", query="SELECT m FROM MasterArtCounsellingNote m")
public class MasterArtCounsellingNote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="counselling_note")
	private String counsellingNote;

	@Column(name="counselling_section")
	private String counsellingSection;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="first_visit_only")
	private Boolean firstVisitOnly;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="question_key")
	private String questionKey;

	//bi-directional many-to-one association to ArtBeneficiaryCounsellingNote
	@OneToMany(mappedBy="masterArtCounsellingNote")
	private Set<ArtBeneficiaryCounsellingNote> artBeneficiaryCounsellingNotes;

	//bi-directional many-to-one association to MasterArtCounsellingType
	@ManyToOne
	@JoinColumn(name="counselling_type_id")
	private MasterArtCounsellingType masterArtCounsellingType;

	//bi-directional many-to-one association to MasterArtCounsellingOption
	@OneToMany(mappedBy="masterArtCounsellingNote")
	private Set<MasterArtCounsellingOption> masterArtCounsellingOptions;

	public MasterArtCounsellingNote() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCounsellingNote() {
		return this.counsellingNote;
	}

	public void setCounsellingNote(String counsellingNote) {
		this.counsellingNote = counsellingNote;
	}

	public String getCounsellingSection() {
		return this.counsellingSection;
	}

	public void setCounsellingSection(String counsellingSection) {
		this.counsellingSection = counsellingSection;
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

	public Boolean getFirstVisitOnly() {
		return this.firstVisitOnly;
	}

	public void setFirstVisitOnly(Boolean firstVisitOnly) {
		this.firstVisitOnly = firstVisitOnly;
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

	public String getQuestionKey() {
		return this.questionKey;
	}

	public void setQuestionKey(String questionKey) {
		this.questionKey = questionKey;
	}

	public Set<ArtBeneficiaryCounsellingNote> getArtBeneficiaryCounsellingNotes() {
		return this.artBeneficiaryCounsellingNotes;
	}

	public void setArtBeneficiaryCounsellingNotes(Set<ArtBeneficiaryCounsellingNote> artBeneficiaryCounsellingNotes) {
		this.artBeneficiaryCounsellingNotes = artBeneficiaryCounsellingNotes;
	}

	public ArtBeneficiaryCounsellingNote addArtBeneficiaryCounsellingNote(ArtBeneficiaryCounsellingNote artBeneficiaryCounsellingNote) {
		getArtBeneficiaryCounsellingNotes().add(artBeneficiaryCounsellingNote);
		artBeneficiaryCounsellingNote.setMasterArtCounsellingNote(this);

		return artBeneficiaryCounsellingNote;
	}

	public ArtBeneficiaryCounsellingNote removeArtBeneficiaryCounsellingNote(ArtBeneficiaryCounsellingNote artBeneficiaryCounsellingNote) {
		getArtBeneficiaryCounsellingNotes().remove(artBeneficiaryCounsellingNote);
		artBeneficiaryCounsellingNote.setMasterArtCounsellingNote(null);

		return artBeneficiaryCounsellingNote;
	}

	public MasterArtCounsellingType getMasterArtCounsellingType() {
		return this.masterArtCounsellingType;
	}

	public void setMasterArtCounsellingType(MasterArtCounsellingType masterArtCounsellingType) {
		this.masterArtCounsellingType = masterArtCounsellingType;
	}

	public Set<MasterArtCounsellingOption> getMasterArtCounsellingOptions() {
		return this.masterArtCounsellingOptions;
	}

	public void setMasterArtCounsellingOptions(Set<MasterArtCounsellingOption> masterArtCounsellingOptions) {
		this.masterArtCounsellingOptions = masterArtCounsellingOptions;
	}

	public MasterArtCounsellingOption addMasterArtCounsellingOption(MasterArtCounsellingOption masterArtCounsellingOption) {
		getMasterArtCounsellingOptions().add(masterArtCounsellingOption);
		masterArtCounsellingOption.setMasterArtCounsellingNote(this);

		return masterArtCounsellingOption;
	}

	public MasterArtCounsellingOption removeMasterArtCounsellingOption(MasterArtCounsellingOption masterArtCounsellingOption) {
		getMasterArtCounsellingOptions().remove(masterArtCounsellingOption);
		masterArtCounsellingOption.setMasterArtCounsellingNote(null);

		return masterArtCounsellingOption;
	}

}