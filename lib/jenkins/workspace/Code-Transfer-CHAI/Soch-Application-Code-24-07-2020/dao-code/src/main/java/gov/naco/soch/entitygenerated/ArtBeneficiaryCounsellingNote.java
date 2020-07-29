package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the art_beneficiary_counselling_notes database table.
 * 
 */
@Entity
@Table(name="art_beneficiary_counselling_notes")
@NamedQuery(name="ArtBeneficiaryCounsellingNote.findAll", query="SELECT a FROM ArtBeneficiaryCounsellingNote a")
public class ArtBeneficiaryCounsellingNote implements Serializable {
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

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to BeneficiaryVisitRegister
	@ManyToOne
	@JoinColumn(name="visit_register_id")
	private BeneficiaryVisitRegister beneficiaryVisitRegister;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to MasterArtCounsellingNote
	@ManyToOne
	@JoinColumn(name="art_counselling_note_id")
	private MasterArtCounsellingNote masterArtCounsellingNote;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="entry_user")
	private UserMaster userMaster;

	//bi-directional many-to-one association to ArtBeneficiaryCounsellingNotesAnswer
	@OneToMany(mappedBy="artBeneficiaryCounsellingNote")
	private Set<ArtBeneficiaryCounsellingNotesAnswer> artBeneficiaryCounsellingNotesAnswers;

	public ArtBeneficiaryCounsellingNote() {
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

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public BeneficiaryVisitRegister getBeneficiaryVisitRegister() {
		return this.beneficiaryVisitRegister;
	}

	public void setBeneficiaryVisitRegister(BeneficiaryVisitRegister beneficiaryVisitRegister) {
		this.beneficiaryVisitRegister = beneficiaryVisitRegister;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public MasterArtCounsellingNote getMasterArtCounsellingNote() {
		return this.masterArtCounsellingNote;
	}

	public void setMasterArtCounsellingNote(MasterArtCounsellingNote masterArtCounsellingNote) {
		this.masterArtCounsellingNote = masterArtCounsellingNote;
	}

	public UserMaster getUserMaster() {
		return this.userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

	public Set<ArtBeneficiaryCounsellingNotesAnswer> getArtBeneficiaryCounsellingNotesAnswers() {
		return this.artBeneficiaryCounsellingNotesAnswers;
	}

	public void setArtBeneficiaryCounsellingNotesAnswers(Set<ArtBeneficiaryCounsellingNotesAnswer> artBeneficiaryCounsellingNotesAnswers) {
		this.artBeneficiaryCounsellingNotesAnswers = artBeneficiaryCounsellingNotesAnswers;
	}

	public ArtBeneficiaryCounsellingNotesAnswer addArtBeneficiaryCounsellingNotesAnswer(ArtBeneficiaryCounsellingNotesAnswer artBeneficiaryCounsellingNotesAnswer) {
		getArtBeneficiaryCounsellingNotesAnswers().add(artBeneficiaryCounsellingNotesAnswer);
		artBeneficiaryCounsellingNotesAnswer.setArtBeneficiaryCounsellingNote(this);

		return artBeneficiaryCounsellingNotesAnswer;
	}

	public ArtBeneficiaryCounsellingNotesAnswer removeArtBeneficiaryCounsellingNotesAnswer(ArtBeneficiaryCounsellingNotesAnswer artBeneficiaryCounsellingNotesAnswer) {
		getArtBeneficiaryCounsellingNotesAnswers().remove(artBeneficiaryCounsellingNotesAnswer);
		artBeneficiaryCounsellingNotesAnswer.setArtBeneficiaryCounsellingNote(null);

		return artBeneficiaryCounsellingNotesAnswer;
	}

}