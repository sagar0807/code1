package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the beneficiary_family_details database table.
 * 
 */
@Entity
@Table(name="beneficiary_family_details")
@NamedQuery(name="BeneficiaryFamilyDetail.findAll", query="SELECT b FROM BeneficiaryFamilyDetail b")
public class BeneficiaryFamilyDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="age_months")
	private Integer ageMonths;

	@Column(name="age_years")
	private Integer ageYears;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="family_uid")
	private String familyUid;

	@Column(name="first_name")
	private String firstName;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_alive")
	private Boolean isAlive;

	@Column(name="is_beneficiary")
	private Boolean isBeneficiary;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="last_name")
	private String lastName;

	@Column(name="middle_name")
	private String middleName;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="on_art")
	private Boolean onArt;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	@JoinColumn(name="beneficiary_id")
	private Beneficiary beneficiary1;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne
	@JoinColumn(name="member_beneficiary_id")
	private Beneficiary beneficiary2;

	//bi-directional many-to-one association to MasterGender
	@ManyToOne
	@JoinColumn(name="gender_id")
	private MasterGender masterGender;

	//bi-directional many-to-one association to MasterHivStatus
	@ManyToOne
	@JoinColumn(name="hiv_status_id")
	private MasterHivStatus masterHivStatus;

	//bi-directional many-to-one association to MasterRelationship
	@ManyToOne
	@JoinColumn(name="relationship_id")
	private MasterRelationship masterRelationship;

	public BeneficiaryFamilyDetail() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAgeMonths() {
		return this.ageMonths;
	}

	public void setAgeMonths(Integer ageMonths) {
		this.ageMonths = ageMonths;
	}

	public Integer getAgeYears() {
		return this.ageYears;
	}

	public void setAgeYears(Integer ageYears) {
		this.ageYears = ageYears;
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

	public String getFamilyUid() {
		return this.familyUid;
	}

	public void setFamilyUid(String familyUid) {
		this.familyUid = familyUid;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsAlive() {
		return this.isAlive;
	}

	public void setIsAlive(Boolean isAlive) {
		this.isAlive = isAlive;
	}

	public Boolean getIsBeneficiary() {
		return this.isBeneficiary;
	}

	public void setIsBeneficiary(Boolean isBeneficiary) {
		this.isBeneficiary = isBeneficiary;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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

	public Boolean getOnArt() {
		return this.onArt;
	}

	public void setOnArt(Boolean onArt) {
		this.onArt = onArt;
	}

	public Beneficiary getBeneficiary1() {
		return this.beneficiary1;
	}

	public void setBeneficiary1(Beneficiary beneficiary1) {
		this.beneficiary1 = beneficiary1;
	}

	public Beneficiary getBeneficiary2() {
		return this.beneficiary2;
	}

	public void setBeneficiary2(Beneficiary beneficiary2) {
		this.beneficiary2 = beneficiary2;
	}

	public MasterGender getMasterGender() {
		return this.masterGender;
	}

	public void setMasterGender(MasterGender masterGender) {
		this.masterGender = masterGender;
	}

	public MasterHivStatus getMasterHivStatus() {
		return this.masterHivStatus;
	}

	public void setMasterHivStatus(MasterHivStatus masterHivStatus) {
		this.masterHivStatus = masterHivStatus;
	}

	public MasterRelationship getMasterRelationship() {
		return this.masterRelationship;
	}

	public void setMasterRelationship(MasterRelationship masterRelationship) {
		this.masterRelationship = masterRelationship;
	}

}