package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * The persistent class for the user_master database table.
 * 
 */
@Entity
@Table(name = "user_master")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UserMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "active_role")
	private Boolean activeRole;

	@Column(name = "designation_id")
	private Long designationId;

	@Column(length = 99)
	private String email;

	@Column(length = 99)
	private String firstname;

	@Column(name = "orw_code", length = 99)
	private String orwCode;

	@Column(name = "pe_code", length = 99)
	private String peCode;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_beneficiary", length = 99)
	private String isBeneficiary;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "landline_number", length = 99)
	private String landlineNumber;

	@Column(length = 99)
	private String lastname;

	@Column(name = "mobile_number", length = 16)
	private String mobileNumber;

	@Column(name = "last_training_date")
	private LocalDate lastDateOfTraining;

	@ManyToOne(cascade = CascadeType.ALL)
	private Facility facility;

	public UserMaster(Long id) {
		super();
		this.id = id;
	}

	public UserMaster() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getActiveRole() {
		return activeRole;
	}

	public void setActiveRole(Boolean activeRole) {
		this.activeRole = activeRole;
	}

	public Long getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getOrwCode() {
		return orwCode;
	}

	public void setOrwCode(String orwCode) {
		this.orwCode = orwCode;
	}

	public String getPeCode() {
		return peCode;
	}

	public void setPeCode(String peCode) {
		this.peCode = peCode;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getIsBeneficiary() {
		return isBeneficiary;
	}

	public void setIsBeneficiary(String isBeneficiary) {
		this.isBeneficiary = isBeneficiary;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getLandlineNumber() {
		return landlineNumber;
	}

	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LocalDate getLastDateOfTraining() {
		return lastDateOfTraining;
	}

	public void setLastDateOfTraining(LocalDate lastDateOfTraining) {
		this.lastDateOfTraining = lastDateOfTraining;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserMaster [id=" + id + ", activeRole=" + activeRole + ", designationId=" + designationId + ", email="
				+ email + ", firstname=" + firstname + ", orwCode=" + orwCode + ", peCode=" + peCode + ", isActive="
				+ isActive + ", isBeneficiary=" + isBeneficiary + ", isDelete=" + isDelete + ", landlineNumber="
				+ landlineNumber + ", lastname=" + lastname + ", mobileNumber=" + mobileNumber + ", lastDateOfTraining="
				+ lastDateOfTraining + ", facility=" + facility + "]";
	}
	
}
