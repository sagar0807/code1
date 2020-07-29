package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the art_beneficiary_investigation database table.
 * 
 */
@Entity
@Table(name="art_beneficiary_investigation")
@NamedQuery(name="ArtBeneficiaryInvestigation.findAll", query="SELECT a FROM ArtBeneficiaryInvestigation a")
public class ArtBeneficiaryInvestigation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Temporal(TemporalType.DATE)
	@Column(name="investigation_date")
	private Date investigationDate;

	@Column(name="investigation_value")
	private Integer investigationValue;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="visit_register_id")
	private Integer visitRegisterId;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to MasterInvestigation
	@ManyToOne
	@JoinColumn(name="investigation_id")
	private MasterInvestigation masterInvestigation;

	public ArtBeneficiaryInvestigation() {
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

	public Date getInvestigationDate() {
		return this.investigationDate;
	}

	public void setInvestigationDate(Date investigationDate) {
		this.investigationDate = investigationDate;
	}

	public Integer getInvestigationValue() {
		return this.investigationValue;
	}

	public void setInvestigationValue(Integer investigationValue) {
		this.investigationValue = investigationValue;
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

	public Integer getVisitRegisterId() {
		return this.visitRegisterId;
	}

	public void setVisitRegisterId(Integer visitRegisterId) {
		this.visitRegisterId = visitRegisterId;
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

	public MasterInvestigation getMasterInvestigation() {
		return this.masterInvestigation;
	}

	public void setMasterInvestigation(MasterInvestigation masterInvestigation) {
		this.masterInvestigation = masterInvestigation;
	}

}