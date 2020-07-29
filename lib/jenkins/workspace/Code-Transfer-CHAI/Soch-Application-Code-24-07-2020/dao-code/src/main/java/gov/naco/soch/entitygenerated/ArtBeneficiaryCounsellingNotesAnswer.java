package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the art_beneficiary_counselling_notes_answers database table.
 * 
 */
@Entity
@Table(name="art_beneficiary_counselling_notes_answers")
@NamedQuery(name="ArtBeneficiaryCounsellingNotesAnswer.findAll", query="SELECT a FROM ArtBeneficiaryCounsellingNotesAnswer a")
public class ArtBeneficiaryCounsellingNotesAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="art_counselling_note_answer")
	private String artCounsellingNoteAnswer;

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

	//bi-directional many-to-one association to ArtBeneficiaryCounsellingNote
	@ManyToOne
	@JoinColumn(name="art_beneficiary_counselling_note_id")
	private ArtBeneficiaryCounsellingNote artBeneficiaryCounsellingNote;

	public ArtBeneficiaryCounsellingNotesAnswer() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArtCounsellingNoteAnswer() {
		return this.artCounsellingNoteAnswer;
	}

	public void setArtCounsellingNoteAnswer(String artCounsellingNoteAnswer) {
		this.artCounsellingNoteAnswer = artCounsellingNoteAnswer;
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

	public ArtBeneficiaryCounsellingNote getArtBeneficiaryCounsellingNote() {
		return this.artBeneficiaryCounsellingNote;
	}

	public void setArtBeneficiaryCounsellingNote(ArtBeneficiaryCounsellingNote artBeneficiaryCounsellingNote) {
		this.artBeneficiaryCounsellingNote = artBeneficiaryCounsellingNote;
	}

}