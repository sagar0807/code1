package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the art_beneficiary_immunization_report database table.
 * 
 */
@Entity
@Table(name="art_beneficiary_immunization_report")
@NamedQuery(name="ArtBeneficiaryImmunizationReport.findAll", query="SELECT a FROM ArtBeneficiaryImmunizationReport a")
public class ArtBeneficiaryImmunizationReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Temporal(TemporalType.DATE)
	@Column(name="due_date")
	private Date dueDate;

	@Temporal(TemporalType.DATE)
	@Column(name="given_date")
	private Date givenDate;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="vaccination_age")
	private Integer vaccinationAge;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to MasterVaccineStage
	@ManyToOne
	@JoinColumn(name="vaccine_stage_id")
	private MasterVaccineStage masterVaccineStage;

	//bi-directional many-to-one association to MasterVaccineType
	@ManyToOne
	@JoinColumn(name="vaccine_type_id")
	private MasterVaccineType masterVaccineType;

	public ArtBeneficiaryImmunizationReport() {
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

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getGivenDate() {
		return this.givenDate;
	}

	public void setGivenDate(Date givenDate) {
		this.givenDate = givenDate;
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

	public Integer getVaccinationAge() {
		return this.vaccinationAge;
	}

	public void setVaccinationAge(Integer vaccinationAge) {
		this.vaccinationAge = vaccinationAge;
	}

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public MasterVaccineStage getMasterVaccineStage() {
		return this.masterVaccineStage;
	}

	public void setMasterVaccineStage(MasterVaccineStage masterVaccineStage) {
		this.masterVaccineStage = masterVaccineStage;
	}

	public MasterVaccineType getMasterVaccineType() {
		return this.masterVaccineType;
	}

	public void setMasterVaccineType(MasterVaccineType masterVaccineType) {
		this.masterVaccineType = masterVaccineType;
	}

}