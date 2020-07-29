package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the art_beneficiary_queue database table.
 * 
 */
@Entity
@Table(name="art_beneficiary_queue")
@NamedQuery(name="ArtBeneficiaryQueue.findAll", query="SELECT a FROM ArtBeneficiaryQueue a")
public class ArtBeneficiaryQueue implements Serializable {
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

	@Column(name="is_visited")
	private Boolean isVisited;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Temporal(TemporalType.DATE)
	@Column(name="visit_date")
	private Date visitDate;

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

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="assigned_to")
	private UserMaster userMaster1;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="entry_user")
	private UserMaster userMaster2;

	public ArtBeneficiaryQueue() {
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

	public Boolean getIsVisited() {
		return this.isVisited;
	}

	public void setIsVisited(Boolean isVisited) {
		this.isVisited = isVisited;
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

	public Date getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
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

	public UserMaster getUserMaster1() {
		return this.userMaster1;
	}

	public void setUserMaster1(UserMaster userMaster1) {
		this.userMaster1 = userMaster1;
	}

	public UserMaster getUserMaster2() {
		return this.userMaster2;
	}

	public void setUserMaster2(UserMaster userMaster2) {
		this.userMaster2 = userMaster2;
	}

}