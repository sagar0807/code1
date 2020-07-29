package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the referrals database table.
 * 
 */
@Entity
@Table(name="referrals")
@NamedQuery(name="Referral.findAll", query="SELECT r FROM Referral r")
public class Referral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="art_code")
	private String artCode;

	private String category;

	@Column(name="created_by")
	private Integer createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="created_time")
	private Date createdTime;

	@Column(name="destination_facility_type")
	private String destinationFacilityType;

	@Column(name="dsrc_code")
	private String dsrcCode;

	@Column(name="hiv_status")
	private String hivStatus;

	@Temporal(TemporalType.DATE)
	@Column(name="initiation_date")
	private Date initiationDate;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_deleted")
	private Boolean isDeleted;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="modified_time")
	private Date modifiedTime;

	@Column(name="ost_code")
	private String ostCode;

	@Column(name="pid_code")
	private String pidCode;

	@Column(name="referral_status")
	private String referralStatus;

	private String remarks;

	@Temporal(TemporalType.DATE)
	@Column(name="reporting_date")
	private Date reportingDate;

	@Column(name="source_facility_type")
	private String sourceFacilityType;

	@Column(name="ti_code")
	private String tiCode;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="destination_facility_id")
	private Facility facility1;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="source_facility_id")
	private Facility facility2;

	public Referral() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArtCode() {
		return this.artCode;
	}

	public void setArtCode(String artCode) {
		this.artCode = artCode;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getDestinationFacilityType() {
		return this.destinationFacilityType;
	}

	public void setDestinationFacilityType(String destinationFacilityType) {
		this.destinationFacilityType = destinationFacilityType;
	}

	public String getDsrcCode() {
		return this.dsrcCode;
	}

	public void setDsrcCode(String dsrcCode) {
		this.dsrcCode = dsrcCode;
	}

	public String getHivStatus() {
		return this.hivStatus;
	}

	public void setHivStatus(String hivStatus) {
		this.hivStatus = hivStatus;
	}

	public Date getInitiationDate() {
		return this.initiationDate;
	}

	public void setInitiationDate(Date initiationDate) {
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

	public Integer getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getOstCode() {
		return this.ostCode;
	}

	public void setOstCode(String ostCode) {
		this.ostCode = ostCode;
	}

	public String getPidCode() {
		return this.pidCode;
	}

	public void setPidCode(String pidCode) {
		this.pidCode = pidCode;
	}

	public String getReferralStatus() {
		return this.referralStatus;
	}

	public void setReferralStatus(String referralStatus) {
		this.referralStatus = referralStatus;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getReportingDate() {
		return this.reportingDate;
	}

	public void setReportingDate(Date reportingDate) {
		this.reportingDate = reportingDate;
	}

	public String getSourceFacilityType() {
		return this.sourceFacilityType;
	}

	public void setSourceFacilityType(String sourceFacilityType) {
		this.sourceFacilityType = sourceFacilityType;
	}

	public String getTiCode() {
		return this.tiCode;
	}

	public void setTiCode(String tiCode) {
		this.tiCode = tiCode;
	}

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Facility getFacility1() {
		return this.facility1;
	}

	public void setFacility1(Facility facility1) {
		this.facility1 = facility1;
	}

	public Facility getFacility2() {
		return this.facility2;
	}

	public void setFacility2(Facility facility2) {
		this.facility2 = facility2;
	}

}