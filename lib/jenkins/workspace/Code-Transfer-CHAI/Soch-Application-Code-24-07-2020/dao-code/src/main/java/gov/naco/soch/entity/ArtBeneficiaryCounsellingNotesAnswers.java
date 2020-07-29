package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "artBeneficiaryCounsellingNotesAnswersSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "art_beneficiary_counselling_notes_answers_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "art_beneficiary_counselling_notes_answers")
@NamedQuery(name = "ArtBeneficiaryCounsellingNotesAnswers.findAll", query = "SELECT n FROM ArtBeneficiaryCounsellingNotesAnswers n")
public class ArtBeneficiaryCounsellingNotesAnswers extends Auditable<Long> implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "artBeneficiaryCounsellingNotesAnswersSequence")
	private Long id;
	
	@Column(name = "art_counselling_note_answer")
	private String artCounsellingNoteAnswer;
	
	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;
	
	@ManyToOne
	@JoinColumn(name = "art_beneficiary_counselling_note_id")
	private ArtBeneficiaryCounsellingNotes artBeneficiaryCounsellingNotes;
	
	public ArtBeneficiaryCounsellingNotesAnswers() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArtCounsellingNoteAnswer() {
		return artCounsellingNoteAnswer;
	}

	public void setArtCounsellingNoteAnswer(String artCounsellingNoteAnswer) {
		this.artCounsellingNoteAnswer = artCounsellingNoteAnswer;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public ArtBeneficiaryCounsellingNotes getArtBeneficiaryCounsellingNotes() {
		return artBeneficiaryCounsellingNotes;
	}

	public void setArtBeneficiaryCounsellingNotes(ArtBeneficiaryCounsellingNotes artBeneficiaryCounsellingNotes) {
		this.artBeneficiaryCounsellingNotes = artBeneficiaryCounsellingNotes;
	}

	

	
	
	
	
	
}
