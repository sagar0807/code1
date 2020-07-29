package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the beneficiary_visit_register database table.
 * 
 */
@Entity
@Table(name="beneficiary_visit_register")
@NamedQuery(name="BeneficiaryVisitRegister.findAll", query="SELECT b FROM BeneficiaryVisitRegister b")
public class BeneficiaryVisitRegister implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="four_s_symptoms")
	private Boolean fourSSymptoms;

	private BigDecimal height;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="is_pregnant")
	private Boolean isPregnant;

	@Temporal(TemporalType.DATE)
	private Date lmp;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="visit_by")
	private String visitBy;

	@Temporal(TemporalType.DATE)
	@Column(name="visit_date")
	private Date visitDate;

	private BigDecimal weight;

	//bi-directional many-to-one association to ArtBeneficiaryClinicalDetail
	@OneToMany(mappedBy="beneficiaryVisitRegister")
	private Set<ArtBeneficiaryClinicalDetail> artBeneficiaryClinicalDetails;

	//bi-directional many-to-one association to ArtBeneficiaryCoexistingCondition
	@OneToMany(mappedBy="beneficiaryVisitRegister")
	private Set<ArtBeneficiaryCoexistingCondition> artBeneficiaryCoexistingConditions;

	//bi-directional many-to-one association to ArtBeneficiaryConcurrentCondition
	@OneToMany(mappedBy="beneficiaryVisitRegister")
	private Set<ArtBeneficiaryConcurrentCondition> artBeneficiaryConcurrentConditions;

	//bi-directional many-to-one association to ArtBeneficiaryContraception
	@OneToMany(mappedBy="beneficiaryVisitRegister")
	private Set<ArtBeneficiaryContraception> artBeneficiaryContraceptions;

	//bi-directional many-to-one association to ArtBeneficiaryCounsellingNote
	@OneToMany(mappedBy="beneficiaryVisitRegister")
	private Set<ArtBeneficiaryCounsellingNote> artBeneficiaryCounsellingNotes;

	//bi-directional many-to-one association to ArtBeneficiaryDueList
	@OneToMany(mappedBy="beneficiaryVisitRegister")
	private Set<ArtBeneficiaryDueList> artBeneficiaryDueLists;

	//bi-directional many-to-one association to ArtBeneficiaryFollowup
	@OneToMany(mappedBy="beneficiaryVisitRegister")
	private Set<ArtBeneficiaryFollowup> artBeneficiaryFollowups;

	//bi-directional many-to-one association to ArtBeneficiaryIptAttDetail
	@OneToMany(mappedBy="beneficiaryVisitRegister")
	private Set<ArtBeneficiaryIptAttDetail> artBeneficiaryIptAttDetails;

	//bi-directional many-to-one association to ArtBeneficiaryOpportunisticInfection
	@OneToMany(mappedBy="beneficiaryVisitRegister")
	private Set<ArtBeneficiaryOpportunisticInfection> artBeneficiaryOpportunisticInfections;

	//bi-directional many-to-one association to ArtBeneficiaryQueue
	@OneToMany(mappedBy="beneficiaryVisitRegister")
	private Set<ArtBeneficiaryQueue> artBeneficiaryQueues;

	//bi-directional many-to-one association to ArtBeneficiarySideEffect
	@OneToMany(mappedBy="beneficiaryVisitRegister")
	private Set<ArtBeneficiarySideEffect> artBeneficiarySideEffects;

	//bi-directional many-to-one association to ArtDispensation
	@OneToMany(mappedBy="beneficiaryVisitRegister")
	private Set<ArtDispensation> artDispensations;

	//bi-directional many-to-one association to BeneficiaryFourSSymptomsPerVisit
	@OneToMany(mappedBy="beneficiaryVisitRegister")
	private Set<BeneficiaryFourSSymptomsPerVisit> beneficiaryFourSSymptomsPerVisits;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to MasterPregnancyTypeCase
	@ManyToOne
	@JoinColumn(name="pregnant_case_type_id")
	private MasterPregnancyTypeCase masterPregnancyTypeCase;

	public BeneficiaryVisitRegister() {
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

	public Boolean getFourSSymptoms() {
		return this.fourSSymptoms;
	}

	public void setFourSSymptoms(Boolean fourSSymptoms) {
		this.fourSSymptoms = fourSSymptoms;
	}

	public BigDecimal getHeight() {
		return this.height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
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

	public Boolean getIsPregnant() {
		return this.isPregnant;
	}

	public void setIsPregnant(Boolean isPregnant) {
		this.isPregnant = isPregnant;
	}

	public Date getLmp() {
		return this.lmp;
	}

	public void setLmp(Date lmp) {
		this.lmp = lmp;
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

	public String getVisitBy() {
		return this.visitBy;
	}

	public void setVisitBy(String visitBy) {
		this.visitBy = visitBy;
	}

	public Date getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public Set<ArtBeneficiaryClinicalDetail> getArtBeneficiaryClinicalDetails() {
		return this.artBeneficiaryClinicalDetails;
	}

	public void setArtBeneficiaryClinicalDetails(Set<ArtBeneficiaryClinicalDetail> artBeneficiaryClinicalDetails) {
		this.artBeneficiaryClinicalDetails = artBeneficiaryClinicalDetails;
	}

	public ArtBeneficiaryClinicalDetail addArtBeneficiaryClinicalDetail(ArtBeneficiaryClinicalDetail artBeneficiaryClinicalDetail) {
		getArtBeneficiaryClinicalDetails().add(artBeneficiaryClinicalDetail);
		artBeneficiaryClinicalDetail.setBeneficiaryVisitRegister(this);

		return artBeneficiaryClinicalDetail;
	}

	public ArtBeneficiaryClinicalDetail removeArtBeneficiaryClinicalDetail(ArtBeneficiaryClinicalDetail artBeneficiaryClinicalDetail) {
		getArtBeneficiaryClinicalDetails().remove(artBeneficiaryClinicalDetail);
		artBeneficiaryClinicalDetail.setBeneficiaryVisitRegister(null);

		return artBeneficiaryClinicalDetail;
	}

	public Set<ArtBeneficiaryCoexistingCondition> getArtBeneficiaryCoexistingConditions() {
		return this.artBeneficiaryCoexistingConditions;
	}

	public void setArtBeneficiaryCoexistingConditions(Set<ArtBeneficiaryCoexistingCondition> artBeneficiaryCoexistingConditions) {
		this.artBeneficiaryCoexistingConditions = artBeneficiaryCoexistingConditions;
	}

	public ArtBeneficiaryCoexistingCondition addArtBeneficiaryCoexistingCondition(ArtBeneficiaryCoexistingCondition artBeneficiaryCoexistingCondition) {
		getArtBeneficiaryCoexistingConditions().add(artBeneficiaryCoexistingCondition);
		artBeneficiaryCoexistingCondition.setBeneficiaryVisitRegister(this);

		return artBeneficiaryCoexistingCondition;
	}

	public ArtBeneficiaryCoexistingCondition removeArtBeneficiaryCoexistingCondition(ArtBeneficiaryCoexistingCondition artBeneficiaryCoexistingCondition) {
		getArtBeneficiaryCoexistingConditions().remove(artBeneficiaryCoexistingCondition);
		artBeneficiaryCoexistingCondition.setBeneficiaryVisitRegister(null);

		return artBeneficiaryCoexistingCondition;
	}

	public Set<ArtBeneficiaryConcurrentCondition> getArtBeneficiaryConcurrentConditions() {
		return this.artBeneficiaryConcurrentConditions;
	}

	public void setArtBeneficiaryConcurrentConditions(Set<ArtBeneficiaryConcurrentCondition> artBeneficiaryConcurrentConditions) {
		this.artBeneficiaryConcurrentConditions = artBeneficiaryConcurrentConditions;
	}

	public ArtBeneficiaryConcurrentCondition addArtBeneficiaryConcurrentCondition(ArtBeneficiaryConcurrentCondition artBeneficiaryConcurrentCondition) {
		getArtBeneficiaryConcurrentConditions().add(artBeneficiaryConcurrentCondition);
		artBeneficiaryConcurrentCondition.setBeneficiaryVisitRegister(this);

		return artBeneficiaryConcurrentCondition;
	}

	public ArtBeneficiaryConcurrentCondition removeArtBeneficiaryConcurrentCondition(ArtBeneficiaryConcurrentCondition artBeneficiaryConcurrentCondition) {
		getArtBeneficiaryConcurrentConditions().remove(artBeneficiaryConcurrentCondition);
		artBeneficiaryConcurrentCondition.setBeneficiaryVisitRegister(null);

		return artBeneficiaryConcurrentCondition;
	}

	public Set<ArtBeneficiaryContraception> getArtBeneficiaryContraceptions() {
		return this.artBeneficiaryContraceptions;
	}

	public void setArtBeneficiaryContraceptions(Set<ArtBeneficiaryContraception> artBeneficiaryContraceptions) {
		this.artBeneficiaryContraceptions = artBeneficiaryContraceptions;
	}

	public ArtBeneficiaryContraception addArtBeneficiaryContraception(ArtBeneficiaryContraception artBeneficiaryContraception) {
		getArtBeneficiaryContraceptions().add(artBeneficiaryContraception);
		artBeneficiaryContraception.setBeneficiaryVisitRegister(this);

		return artBeneficiaryContraception;
	}

	public ArtBeneficiaryContraception removeArtBeneficiaryContraception(ArtBeneficiaryContraception artBeneficiaryContraception) {
		getArtBeneficiaryContraceptions().remove(artBeneficiaryContraception);
		artBeneficiaryContraception.setBeneficiaryVisitRegister(null);

		return artBeneficiaryContraception;
	}

	public Set<ArtBeneficiaryCounsellingNote> getArtBeneficiaryCounsellingNotes() {
		return this.artBeneficiaryCounsellingNotes;
	}

	public void setArtBeneficiaryCounsellingNotes(Set<ArtBeneficiaryCounsellingNote> artBeneficiaryCounsellingNotes) {
		this.artBeneficiaryCounsellingNotes = artBeneficiaryCounsellingNotes;
	}

	public ArtBeneficiaryCounsellingNote addArtBeneficiaryCounsellingNote(ArtBeneficiaryCounsellingNote artBeneficiaryCounsellingNote) {
		getArtBeneficiaryCounsellingNotes().add(artBeneficiaryCounsellingNote);
		artBeneficiaryCounsellingNote.setBeneficiaryVisitRegister(this);

		return artBeneficiaryCounsellingNote;
	}

	public ArtBeneficiaryCounsellingNote removeArtBeneficiaryCounsellingNote(ArtBeneficiaryCounsellingNote artBeneficiaryCounsellingNote) {
		getArtBeneficiaryCounsellingNotes().remove(artBeneficiaryCounsellingNote);
		artBeneficiaryCounsellingNote.setBeneficiaryVisitRegister(null);

		return artBeneficiaryCounsellingNote;
	}

	public Set<ArtBeneficiaryDueList> getArtBeneficiaryDueLists() {
		return this.artBeneficiaryDueLists;
	}

	public void setArtBeneficiaryDueLists(Set<ArtBeneficiaryDueList> artBeneficiaryDueLists) {
		this.artBeneficiaryDueLists = artBeneficiaryDueLists;
	}

	public ArtBeneficiaryDueList addArtBeneficiaryDueList(ArtBeneficiaryDueList artBeneficiaryDueList) {
		getArtBeneficiaryDueLists().add(artBeneficiaryDueList);
		artBeneficiaryDueList.setBeneficiaryVisitRegister(this);

		return artBeneficiaryDueList;
	}

	public ArtBeneficiaryDueList removeArtBeneficiaryDueList(ArtBeneficiaryDueList artBeneficiaryDueList) {
		getArtBeneficiaryDueLists().remove(artBeneficiaryDueList);
		artBeneficiaryDueList.setBeneficiaryVisitRegister(null);

		return artBeneficiaryDueList;
	}

	public Set<ArtBeneficiaryFollowup> getArtBeneficiaryFollowups() {
		return this.artBeneficiaryFollowups;
	}

	public void setArtBeneficiaryFollowups(Set<ArtBeneficiaryFollowup> artBeneficiaryFollowups) {
		this.artBeneficiaryFollowups = artBeneficiaryFollowups;
	}

	public ArtBeneficiaryFollowup addArtBeneficiaryFollowup(ArtBeneficiaryFollowup artBeneficiaryFollowup) {
		getArtBeneficiaryFollowups().add(artBeneficiaryFollowup);
		artBeneficiaryFollowup.setBeneficiaryVisitRegister(this);

		return artBeneficiaryFollowup;
	}

	public ArtBeneficiaryFollowup removeArtBeneficiaryFollowup(ArtBeneficiaryFollowup artBeneficiaryFollowup) {
		getArtBeneficiaryFollowups().remove(artBeneficiaryFollowup);
		artBeneficiaryFollowup.setBeneficiaryVisitRegister(null);

		return artBeneficiaryFollowup;
	}

	public Set<ArtBeneficiaryIptAttDetail> getArtBeneficiaryIptAttDetails() {
		return this.artBeneficiaryIptAttDetails;
	}

	public void setArtBeneficiaryIptAttDetails(Set<ArtBeneficiaryIptAttDetail> artBeneficiaryIptAttDetails) {
		this.artBeneficiaryIptAttDetails = artBeneficiaryIptAttDetails;
	}

	public ArtBeneficiaryIptAttDetail addArtBeneficiaryIptAttDetail(ArtBeneficiaryIptAttDetail artBeneficiaryIptAttDetail) {
		getArtBeneficiaryIptAttDetails().add(artBeneficiaryIptAttDetail);
		artBeneficiaryIptAttDetail.setBeneficiaryVisitRegister(this);

		return artBeneficiaryIptAttDetail;
	}

	public ArtBeneficiaryIptAttDetail removeArtBeneficiaryIptAttDetail(ArtBeneficiaryIptAttDetail artBeneficiaryIptAttDetail) {
		getArtBeneficiaryIptAttDetails().remove(artBeneficiaryIptAttDetail);
		artBeneficiaryIptAttDetail.setBeneficiaryVisitRegister(null);

		return artBeneficiaryIptAttDetail;
	}

	public Set<ArtBeneficiaryOpportunisticInfection> getArtBeneficiaryOpportunisticInfections() {
		return this.artBeneficiaryOpportunisticInfections;
	}

	public void setArtBeneficiaryOpportunisticInfections(Set<ArtBeneficiaryOpportunisticInfection> artBeneficiaryOpportunisticInfections) {
		this.artBeneficiaryOpportunisticInfections = artBeneficiaryOpportunisticInfections;
	}

	public ArtBeneficiaryOpportunisticInfection addArtBeneficiaryOpportunisticInfection(ArtBeneficiaryOpportunisticInfection artBeneficiaryOpportunisticInfection) {
		getArtBeneficiaryOpportunisticInfections().add(artBeneficiaryOpportunisticInfection);
		artBeneficiaryOpportunisticInfection.setBeneficiaryVisitRegister(this);

		return artBeneficiaryOpportunisticInfection;
	}

	public ArtBeneficiaryOpportunisticInfection removeArtBeneficiaryOpportunisticInfection(ArtBeneficiaryOpportunisticInfection artBeneficiaryOpportunisticInfection) {
		getArtBeneficiaryOpportunisticInfections().remove(artBeneficiaryOpportunisticInfection);
		artBeneficiaryOpportunisticInfection.setBeneficiaryVisitRegister(null);

		return artBeneficiaryOpportunisticInfection;
	}

	public Set<ArtBeneficiaryQueue> getArtBeneficiaryQueues() {
		return this.artBeneficiaryQueues;
	}

	public void setArtBeneficiaryQueues(Set<ArtBeneficiaryQueue> artBeneficiaryQueues) {
		this.artBeneficiaryQueues = artBeneficiaryQueues;
	}

	public ArtBeneficiaryQueue addArtBeneficiaryQueue(ArtBeneficiaryQueue artBeneficiaryQueue) {
		getArtBeneficiaryQueues().add(artBeneficiaryQueue);
		artBeneficiaryQueue.setBeneficiaryVisitRegister(this);

		return artBeneficiaryQueue;
	}

	public ArtBeneficiaryQueue removeArtBeneficiaryQueue(ArtBeneficiaryQueue artBeneficiaryQueue) {
		getArtBeneficiaryQueues().remove(artBeneficiaryQueue);
		artBeneficiaryQueue.setBeneficiaryVisitRegister(null);

		return artBeneficiaryQueue;
	}

	public Set<ArtBeneficiarySideEffect> getArtBeneficiarySideEffects() {
		return this.artBeneficiarySideEffects;
	}

	public void setArtBeneficiarySideEffects(Set<ArtBeneficiarySideEffect> artBeneficiarySideEffects) {
		this.artBeneficiarySideEffects = artBeneficiarySideEffects;
	}

	public ArtBeneficiarySideEffect addArtBeneficiarySideEffect(ArtBeneficiarySideEffect artBeneficiarySideEffect) {
		getArtBeneficiarySideEffects().add(artBeneficiarySideEffect);
		artBeneficiarySideEffect.setBeneficiaryVisitRegister(this);

		return artBeneficiarySideEffect;
	}

	public ArtBeneficiarySideEffect removeArtBeneficiarySideEffect(ArtBeneficiarySideEffect artBeneficiarySideEffect) {
		getArtBeneficiarySideEffects().remove(artBeneficiarySideEffect);
		artBeneficiarySideEffect.setBeneficiaryVisitRegister(null);

		return artBeneficiarySideEffect;
	}

	public Set<ArtDispensation> getArtDispensations() {
		return this.artDispensations;
	}

	public void setArtDispensations(Set<ArtDispensation> artDispensations) {
		this.artDispensations = artDispensations;
	}

	public ArtDispensation addArtDispensation(ArtDispensation artDispensation) {
		getArtDispensations().add(artDispensation);
		artDispensation.setBeneficiaryVisitRegister(this);

		return artDispensation;
	}

	public ArtDispensation removeArtDispensation(ArtDispensation artDispensation) {
		getArtDispensations().remove(artDispensation);
		artDispensation.setBeneficiaryVisitRegister(null);

		return artDispensation;
	}

	public Set<BeneficiaryFourSSymptomsPerVisit> getBeneficiaryFourSSymptomsPerVisits() {
		return this.beneficiaryFourSSymptomsPerVisits;
	}

	public void setBeneficiaryFourSSymptomsPerVisits(Set<BeneficiaryFourSSymptomsPerVisit> beneficiaryFourSSymptomsPerVisits) {
		this.beneficiaryFourSSymptomsPerVisits = beneficiaryFourSSymptomsPerVisits;
	}

	public BeneficiaryFourSSymptomsPerVisit addBeneficiaryFourSSymptomsPerVisit(BeneficiaryFourSSymptomsPerVisit beneficiaryFourSSymptomsPerVisit) {
		getBeneficiaryFourSSymptomsPerVisits().add(beneficiaryFourSSymptomsPerVisit);
		beneficiaryFourSSymptomsPerVisit.setBeneficiaryVisitRegister(this);

		return beneficiaryFourSSymptomsPerVisit;
	}

	public BeneficiaryFourSSymptomsPerVisit removeBeneficiaryFourSSymptomsPerVisit(BeneficiaryFourSSymptomsPerVisit beneficiaryFourSSymptomsPerVisit) {
		getBeneficiaryFourSSymptomsPerVisits().remove(beneficiaryFourSSymptomsPerVisit);
		beneficiaryFourSSymptomsPerVisit.setBeneficiaryVisitRegister(null);

		return beneficiaryFourSSymptomsPerVisit;
	}

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public MasterPregnancyTypeCase getMasterPregnancyTypeCase() {
		return this.masterPregnancyTypeCase;
	}

	public void setMasterPregnancyTypeCase(MasterPregnancyTypeCase masterPregnancyTypeCase) {
		this.masterPregnancyTypeCase = masterPregnancyTypeCase;
	}

}