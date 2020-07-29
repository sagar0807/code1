package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the ti_ost_details database table.
 * 
 */
@Entity
@Table(name="ti_ost_details")
@NamedQuery(name="TiOstDetail.findAll", query="SELECT t FROM TiOstDetail t")
public class TiOstDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="current_dose")
	private String currentDose;

	@Column(name="current_ost_status")
	private String currentOstStatus;

	@Column(name="dispensation_status")
	private String dispensationStatus;

	@Temporal(TemporalType.DATE)
	@Column(name="dispensed_last_date")
	private Date dispensedLastDate;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Temporal(TemporalType.DATE)
	@Column(name="next_follow_up_date")
	private Date nextFollowUpDate;

	@Column(name="ost_code")
	private String ostCode;

	@Column(name="ost_id")
	private String ostId;

	@Column(name="ost_initiated")
	private String ostInitiated;

	@Column(name="ost_number")
	private Integer ostNumber;

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

	public TiOstDetail() {
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

	public String getCurrentDose() {
		return this.currentDose;
	}

	public void setCurrentDose(String currentDose) {
		this.currentDose = currentDose;
	}

	public String getCurrentOstStatus() {
		return this.currentOstStatus;
	}

	public void setCurrentOstStatus(String currentOstStatus) {
		this.currentOstStatus = currentOstStatus;
	}

	public String getDispensationStatus() {
		return this.dispensationStatus;
	}

	public void setDispensationStatus(String dispensationStatus) {
		this.dispensationStatus = dispensationStatus;
	}

	public Date getDispensedLastDate() {
		return this.dispensedLastDate;
	}

	public void setDispensedLastDate(Date dispensedLastDate) {
		this.dispensedLastDate = dispensedLastDate;
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

	public Date getNextFollowUpDate() {
		return this.nextFollowUpDate;
	}

	public void setNextFollowUpDate(Date nextFollowUpDate) {
		this.nextFollowUpDate = nextFollowUpDate;
	}

	public String getOstCode() {
		return this.ostCode;
	}

	public void setOstCode(String ostCode) {
		this.ostCode = ostCode;
	}

	public String getOstId() {
		return this.ostId;
	}

	public void setOstId(String ostId) {
		this.ostId = ostId;
	}

	public String getOstInitiated() {
		return this.ostInitiated;
	}

	public void setOstInitiated(String ostInitiated) {
		this.ostInitiated = ostInitiated;
	}

	public Integer getOstNumber() {
		return this.ostNumber;
	}

	public void setOstNumber(Integer ostNumber) {
		this.ostNumber = ostNumber;
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