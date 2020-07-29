package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ti_beneficiary_comm_dis database table.
 * 
 */
@Entity
@Table(name="ti_beneficiary_comm_dis")
@NamedQuery(name="TiBeneficiaryCommDi.findAll", query="SELECT t FROM TiBeneficiaryCommDi t")
public class TiBeneficiaryCommDi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="condom_use_during_last_sex")
	private Boolean condomUseDuringLastSex;

	@Column(name="condoms_distributed")
	private Integer condomsDistributed;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_deleted")
	private Boolean isDeleted;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="not_sharing_needle_syringe")
	private Boolean notSharingNeedleSyringe;

	@Column(name="syringes_needles_distributed")
	private Integer syringesNeedlesDistributed;

	@Column(name="syringes_needles_returned")
	private Integer syringesNeedlesReturned;

	@Column(name="type_of_contact")
	private String typeOfContact;

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

	public TiBeneficiaryCommDi() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getCondomUseDuringLastSex() {
		return this.condomUseDuringLastSex;
	}

	public void setCondomUseDuringLastSex(Boolean condomUseDuringLastSex) {
		this.condomUseDuringLastSex = condomUseDuringLastSex;
	}

	public Integer getCondomsDistributed() {
		return this.condomsDistributed;
	}

	public void setCondomsDistributed(Integer condomsDistributed) {
		this.condomsDistributed = condomsDistributed;
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

	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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

	public Boolean getNotSharingNeedleSyringe() {
		return this.notSharingNeedleSyringe;
	}

	public void setNotSharingNeedleSyringe(Boolean notSharingNeedleSyringe) {
		this.notSharingNeedleSyringe = notSharingNeedleSyringe;
	}

	public Integer getSyringesNeedlesDistributed() {
		return this.syringesNeedlesDistributed;
	}

	public void setSyringesNeedlesDistributed(Integer syringesNeedlesDistributed) {
		this.syringesNeedlesDistributed = syringesNeedlesDistributed;
	}

	public Integer getSyringesNeedlesReturned() {
		return this.syringesNeedlesReturned;
	}

	public void setSyringesNeedlesReturned(Integer syringesNeedlesReturned) {
		this.syringesNeedlesReturned = syringesNeedlesReturned;
	}

	public String getTypeOfContact() {
		return this.typeOfContact;
	}

	public void setTypeOfContact(String typeOfContact) {
		this.typeOfContact = typeOfContact;
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

}