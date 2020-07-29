package gov.naco.soch.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class UserBasicDto implements Serializable, Comparable<UserBasicDto> {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String firstname;
	private String lastname;
	private String userName;
	private String email;
	private Long divisionId;
	private Long roleId;
	private String roleName;
	private String peCode;
	private String orwCode;
	private Long facilityTypeId;
	private Long typologyId;
	private Long isTrained;
	private String mobileNumber;
	private Long status;
	private Long facilityId;
	private Boolean smsEnabled;
	private Boolean whatsappEnabled;
	private LocalDate lastDateOfTraining;
	private Long typeOfTraining;
	private Boolean isActive;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPeCode() {
		return peCode;
	}

	public void setPeCode(String peCode) {
		this.peCode = peCode;
	}

	public String getOrwCode() {
		return orwCode;
	}

	public void setOrwCode(String orwCode) {
		this.orwCode = orwCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getFacilityTypeId() {
		return facilityTypeId;
	}

	public void setFacilityTypeId(Long facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}

	public Long getTypologyId() {
		return typologyId;
	}

	public void setTypologyId(Long typologyId) {
		this.typologyId = typologyId;
	}

	public Long getIsTrained() {
		return isTrained;
	}

	public void setIsTrained(Long isTrained) {
		this.isTrained = isTrained;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public Boolean getSmsEnabled() {
		return smsEnabled;
	}

	public void setSmsEnabled(Boolean smsEnabled) {
		this.smsEnabled = smsEnabled;
	}

	public Boolean getWhatsappEnabled() {
		return whatsappEnabled;
	}

	public void setWhatsappEnabled(Boolean whatsappEnabled) {
		this.whatsappEnabled = whatsappEnabled;
	}

	public LocalDate getLastDateOfTraining() {
		return lastDateOfTraining;
	}

	public void setLastDateOfTraining(LocalDate lastDateOfTraining) {
		this.lastDateOfTraining = lastDateOfTraining;
	}

	public Long getTypeOfTraining() {
		return typeOfTraining;
	}

	public void setTypeOfTraining(Long typeOfTraining) {
		this.typeOfTraining = typeOfTraining;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "UserBasicDto [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", userName="
				+ userName + ", divisionId=" + divisionId + ", roleId=" + roleId + ", roleName=" + roleName
				+ ", peCode=" + peCode + ", orwCode=" + orwCode + ", email=" + email + ", facilityTypeId="
				+ facilityTypeId + ", typologyId=" + typologyId + ", isTrained=" + isTrained + ", mobileNumber="
				+ mobileNumber + ", status=" + status + ", facilityId=" + facilityId + ", smsEnabled=" + smsEnabled
				+ ", whatsappEnabled=" + whatsappEnabled + ", lastDateOfTraining=" + lastDateOfTraining
				+ ", typeOfTraining=" + typeOfTraining + ", isActive=" + isActive + "]";
	}

	@Override
	public int compareTo(UserBasicDto o) {
		// TODO Auto-generated method stub
		return this.getFirstname().compareTo(o.getFirstname());
	}
}
