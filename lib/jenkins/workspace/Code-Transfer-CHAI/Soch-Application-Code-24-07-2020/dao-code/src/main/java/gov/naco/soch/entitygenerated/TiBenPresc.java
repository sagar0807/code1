package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ti_ben_presc database table.
 * 
 */
@Entity
@Table(name="ti_ben_presc")
@NamedQuery(name="TiBenPresc.findAll", query="SELECT t FROM TiBenPresc t")
public class TiBenPresc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="consent_taken")
	private Boolean consentTaken;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	private Integer dosage;

	@Column(name="initiation_date")
	private Timestamp initiationDate;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_deleted")
	private Boolean isDeleted;

	@Column(name="measure_of_unit")
	private String measureOfUnit;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="substitution_drug")
	private Integer substitutionDrug;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	public TiBenPresc() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getConsentTaken() {
		return this.consentTaken;
	}

	public void setConsentTaken(Boolean consentTaken) {
		this.consentTaken = consentTaken;
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

	public Integer getDosage() {
		return this.dosage;
	}

	public void setDosage(Integer dosage) {
		this.dosage = dosage;
	}

	public Timestamp getInitiationDate() {
		return this.initiationDate;
	}

	public void setInitiationDate(Timestamp initiationDate) {
		this.initiationDate = initiationDate;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getMeasureOfUnit() {
		return this.measureOfUnit;
	}

	public void setMeasureOfUnit(String measureOfUnit) {
		this.measureOfUnit = measureOfUnit;
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

	public Integer getSubstitutionDrug() {
		return this.substitutionDrug;
	}

	public void setSubstitutionDrug(Integer substitutionDrug) {
		this.substitutionDrug = substitutionDrug;
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

}