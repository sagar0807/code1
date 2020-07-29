package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the ti_ben_counselling database table.
 * 
 */
@Entity
@Table(name="ti_ben_counselling")
@NamedQuery(name="TiBenCounselling.findAll", query="SELECT t FROM TiBenCounselling t")
public class TiBenCounselling implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="counselling_date")
	private Date counsellingDate;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="duration_of_counselling")
	private Integer durationOfCounselling;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_deleted")
	private Boolean isDeleted;

	@Temporal(TemporalType.DATE)
	@Column(name="last_counselling_date")
	private Date lastCounsellingDate;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Temporal(TemporalType.DATE)
	@Column(name="next_counselling_date")
	private Date nextCounsellingDate;

	@Column(name="no_of_condoms_distributed")
	private Integer noOfCondomsDistributed;

	private String remarks;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to TiBeneficiary
	@ManyToOne
	@JoinColumn(name="beneficiary_id")
	private TiBeneficiary tiBeneficiary;

	//bi-directional many-to-one association to TiBenCounsellingType
	@OneToMany(mappedBy="tiBenCounselling")
	private Set<TiBenCounsellingType> tiBenCounsellingTypes;

	public TiBenCounselling() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCounsellingDate() {
		return this.counsellingDate;
	}

	public void setCounsellingDate(Date counsellingDate) {
		this.counsellingDate = counsellingDate;
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

	public Integer getDurationOfCounselling() {
		return this.durationOfCounselling;
	}

	public void setDurationOfCounselling(Integer durationOfCounselling) {
		this.durationOfCounselling = durationOfCounselling;
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

	public Date getLastCounsellingDate() {
		return this.lastCounsellingDate;
	}

	public void setLastCounsellingDate(Date lastCounsellingDate) {
		this.lastCounsellingDate = lastCounsellingDate;
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

	public Date getNextCounsellingDate() {
		return this.nextCounsellingDate;
	}

	public void setNextCounsellingDate(Date nextCounsellingDate) {
		this.nextCounsellingDate = nextCounsellingDate;
	}

	public Integer getNoOfCondomsDistributed() {
		return this.noOfCondomsDistributed;
	}

	public void setNoOfCondomsDistributed(Integer noOfCondomsDistributed) {
		this.noOfCondomsDistributed = noOfCondomsDistributed;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public TiBeneficiary getTiBeneficiary() {
		return this.tiBeneficiary;
	}

	public void setTiBeneficiary(TiBeneficiary tiBeneficiary) {
		this.tiBeneficiary = tiBeneficiary;
	}

	public Set<TiBenCounsellingType> getTiBenCounsellingTypes() {
		return this.tiBenCounsellingTypes;
	}

	public void setTiBenCounsellingTypes(Set<TiBenCounsellingType> tiBenCounsellingTypes) {
		this.tiBenCounsellingTypes = tiBenCounsellingTypes;
	}

	public TiBenCounsellingType addTiBenCounsellingType(TiBenCounsellingType tiBenCounsellingType) {
		getTiBenCounsellingTypes().add(tiBenCounsellingType);
		tiBenCounsellingType.setTiBenCounselling(this);

		return tiBenCounsellingType;
	}

	public TiBenCounsellingType removeTiBenCounsellingType(TiBenCounsellingType tiBenCounsellingType) {
		getTiBenCounsellingTypes().remove(tiBenCounsellingType);
		tiBenCounsellingType.setTiBenCounselling(null);

		return tiBenCounsellingType;
	}

}