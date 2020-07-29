package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the beneficiary_facility_mapping database table.
 * 
 */
@Entity
@Table(name="beneficiary_facility_mapping")
@NamedQuery(name="BeneficiaryFacilityMapping.findAll", query="SELECT b FROM BeneficiaryFacilityMapping b")
public class BeneficiaryFacilityMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="art_number")
	private String artNumber;

	@Column(name="art_previous_clinic")
	private String artPreviousClinic;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="is_transferred")
	private Boolean isTransferred;

	@Temporal(TemporalType.DATE)
	@Column(name="mapping_date")
	private Date mappingDate;

	@Temporal(TemporalType.DATE)
	@Column(name="mapping_updated_date")
	private Date mappingUpdatedDate;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="ost_code")
	private String ostCode;

	private String pid;

	@Column(name="pre_art_number")
	private String preArtNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="registration_date")
	private Date registrationDate;

	@Column(name="ti_code")
	private String tiCode;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="facility_id")
	private Facility facility1;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="previous_not_transferred_art_id")
	private Facility facility2;

	public BeneficiaryFacilityMapping() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArtNumber() {
		return this.artNumber;
	}

	public void setArtNumber(String artNumber) {
		this.artNumber = artNumber;
	}

	public String getArtPreviousClinic() {
		return this.artPreviousClinic;
	}

	public void setArtPreviousClinic(String artPreviousClinic) {
		this.artPreviousClinic = artPreviousClinic;
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

	public Boolean getIsTransferred() {
		return this.isTransferred;
	}

	public void setIsTransferred(Boolean isTransferred) {
		this.isTransferred = isTransferred;
	}

	public Date getMappingDate() {
		return this.mappingDate;
	}

	public void setMappingDate(Date mappingDate) {
		this.mappingDate = mappingDate;
	}

	public Date getMappingUpdatedDate() {
		return this.mappingUpdatedDate;
	}

	public void setMappingUpdatedDate(Date mappingUpdatedDate) {
		this.mappingUpdatedDate = mappingUpdatedDate;
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

	public String getOstCode() {
		return this.ostCode;
	}

	public void setOstCode(String ostCode) {
		this.ostCode = ostCode;
	}

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPreArtNumber() {
		return this.preArtNumber;
	}

	public void setPreArtNumber(String preArtNumber) {
		this.preArtNumber = preArtNumber;
	}

	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
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