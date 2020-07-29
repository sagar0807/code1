package gov.naco.soch.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserMasterDto implements Serializable, Comparable<UserMasterDto> {

	private static final long serialVersionUID = 1L;

	// DTO class properties

	private Long id;

	private Boolean activeRole;

	private Integer createdBy;

	private String userName;

	private LocalDateTime createdTime;

	private Long designationId;

	private Long divisionId;

	private Long roleId;

	private String peCode;

	private String orwCode;

	@Email(message = "Must enter in email format")
	@NotEmpty(message = "E-mail must not be empty")
	private String email;

	private Long facilityTypeId;

	@Size(max = 99)
	@NotEmpty(message = "First Name must not be empty")
	private String firstname;

	private Boolean isActive;

	private Long isTrained;

	private String isBeneficiary;

	private Boolean isDelete;

	private String landlineNumber;

	private String lastname;

	private String mobileNumber;

	private Integer modifiedBy;

	private LocalDateTime modifiedTime;

	private Long status;

	private List<RoleDto> roleDto;

	private UserAuthDto userAuthsDto;

	private DivisionDto divisionDto;

	private FacilityTypeDto facilityTypeDto;

	private Set<UserRoleMappingDto> userRoleMappingsDto;

	private Long facilityId;

	private Boolean smsEnabled;

	private Boolean whatsappEnabled;

	private String password;

	private LocalDate lastDateOfTraining;

	private Long typeOfTraining;
	
	private String role;
	
	private Long typologyId;
	
	private TypologyDto typologyDto;

	// define getter and setter for the above properties.

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public Boolean getActiveRole() {
		return activeRole;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public String getUserName() {
		return userName;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public String getEmail() {
		return email;
	}

	public Long getFacilityTypeId() {
		return facilityTypeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public String getIsBeneficiary() {
		return isBeneficiary;
	}

	public Long getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}

	public Long getDesignationId() {
		return designationId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getLandlineNumber() {
		return landlineNumber;
	}

	public String getLastname() {
		return lastname;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public Long getStatus() {
		return status;
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

	public UserAuthDto getUserAuthsDto() {
		return userAuthsDto;
	}

	public DivisionDto getDivisionDto() {
		return divisionDto;
	}

	public Set<UserRoleMappingDto> getUserRoleMappingsDto() {
		return userRoleMappingsDto;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setActiveRole(Boolean activeRole) {
		this.activeRole = activeRole;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setIsBeneficiary(String isBeneficiary) {
		this.isBeneficiary = isBeneficiary;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
	}

	public void setRoleDto(List<RoleDto> roleDto) {
		this.roleDto = roleDto;
	}

	public FacilityTypeDto getFacilityTypeDto() {
		return facilityTypeDto;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public void setUserAuthsDto(UserAuthDto userAuthsDto) {
		this.userAuthsDto = userAuthsDto;
	}

	public void setDivisionDto(DivisionDto divisionDto) {
		this.divisionDto = divisionDto;
	}

	public void setFacilityTypeId(Long facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}

	public void setFacilityTypeDto(FacilityTypeDto facilityTypeDto) {
		this.facilityTypeDto = facilityTypeDto;
	}

	public void setUserRoleMappingsDto(Set<UserRoleMappingDto> userRoleMappingsDto) {
		this.userRoleMappingsDto = userRoleMappingsDto;
	}

	public List<RoleDto> getRoleDto() {
		return roleDto;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserMasterDto [id=" + id + ", activeRole=" + activeRole + ", createdBy=" + createdBy + ", userName="
				+ userName + ", createdTime=" + createdTime + ", designationId=" + designationId + ", divisionId="
				+ divisionId + ", roleId=" + roleId + ", peCode=" + peCode + ", orwCode=" + orwCode + ", email=" + email
				+ ", facilityTypeId=" + facilityTypeId + ", firstname=" + firstname + ", isActive=" + isActive
				+ ", isTrained=" + isTrained + ", isBeneficiary=" + isBeneficiary + ", isDelete=" + isDelete
				+ ", landlineNumber=" + landlineNumber + ", lastname=" + lastname + ", mobileNumber=" + mobileNumber
				+ ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime + ", status=" + status + ", roleDto="
				+ roleDto + ", userAuthsDto=" + userAuthsDto + ", divisionDto=" + divisionDto + ", facilityTypeDto="
				+ facilityTypeDto + ", userRoleMappingsDto=" + userRoleMappingsDto + ", facilityId=" + facilityId
				+ ", smsEnabled=" + smsEnabled + ", whatsappEnabled=" + whatsappEnabled + ", password=" + password
				+ ", lastDateOfTraining=" + lastDateOfTraining + ", typeOfTraining=" + typeOfTraining + ", role=" + role
				+ ", typologyId=" + typologyId
				+ "]"; 
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserMasterDto other = (UserMasterDto) obj;
		if (activeRole == null) {
			if (other.activeRole != null)
				return false;
		} else if (!activeRole.equals(other.activeRole))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdTime == null) {
			if (other.createdTime != null)
				return false;
		} else if (!createdTime.equals(other.createdTime))
			return false;
		if (designationId == null) {
			if (other.designationId != null)
				return false;
		} else if (!designationId.equals(other.designationId))
			return false;
		if (divisionDto == null) {
			if (other.divisionDto != null)
				return false;
		} else if (!divisionDto.equals(other.divisionDto))
			return false;
		if (divisionId == null) {
			if (other.divisionId != null)
				return false;
		} else if (!divisionId.equals(other.divisionId))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (facilityId == null) {
			if (other.facilityId != null)
				return false;
		} else if (!facilityId.equals(other.facilityId))
			return false;
		if (facilityTypeDto == null) {
			if (other.facilityTypeDto != null)
				return false;
		} else if (!facilityTypeDto.equals(other.facilityTypeDto))
			return false;
		if (facilityTypeId == null) {
			if (other.facilityTypeId != null)
				return false;
		} else if (!facilityTypeId.equals(other.facilityTypeId))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (isBeneficiary == null) {
			if (other.isBeneficiary != null)
				return false;
		} else if (!isBeneficiary.equals(other.isBeneficiary))
			return false;
		if (isDelete == null) {
			if (other.isDelete != null)
				return false;
		} else if (!isDelete.equals(other.isDelete))
			return false;
		if (isTrained == null) {
			if (other.isTrained != null)
				return false;
		} else if (!isTrained.equals(other.isTrained))
			return false;
		if (landlineNumber == null) {
			if (other.landlineNumber != null)
				return false;
		} else if (!landlineNumber.equals(other.landlineNumber))
			return false;
		if (lastDateOfTraining == null) {
			if (other.lastDateOfTraining != null)
				return false;
		} else if (!lastDateOfTraining.equals(other.lastDateOfTraining))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (modifiedBy == null) {
			if (other.modifiedBy != null)
				return false;
		} else if (!modifiedBy.equals(other.modifiedBy))
			return false;
		if (modifiedTime == null) {
			if (other.modifiedTime != null)
				return false;
		} else if (!modifiedTime.equals(other.modifiedTime))
			return false;
		if (orwCode == null) {
			if (other.orwCode != null)
				return false;
		} else if (!orwCode.equals(other.orwCode))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (peCode == null) {
			if (other.peCode != null)
				return false;
		} else if (!peCode.equals(other.peCode))
			return false;
		if (roleDto == null) {
			if (other.roleDto != null)
				return false;
		} else if (!roleDto.equals(other.roleDto))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (smsEnabled == null) {
			if (other.smsEnabled != null)
				return false;
		} else if (!smsEnabled.equals(other.smsEnabled))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (typeOfTraining == null) {
			if (other.typeOfTraining != null)
				return false;
		} else if (!typeOfTraining.equals(other.typeOfTraining))
			return false;
		if (userAuthsDto == null) {
			if (other.userAuthsDto != null)
				return false;
		} else if (!userAuthsDto.equals(other.userAuthsDto))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userRoleMappingsDto == null) {
			if (other.userRoleMappingsDto != null)
				return false;
		} else if (!userRoleMappingsDto.equals(other.userRoleMappingsDto))
			return false;
		if (whatsappEnabled == null) {
			if (other.whatsappEnabled != null)
				return false;
		} else if (!whatsappEnabled.equals(other.whatsappEnabled))
			return false;
		return true;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Long getIsTrained() {
		return isTrained;
	}

	public void setIsTrained(Long isTrained) {
		this.isTrained = isTrained;
	}

	public LocalDate getLastDateOfTraining() {
		return lastDateOfTraining;
	}

	public void setLastDateOfTraining(LocalDate lastDateOfTraining) {
		this.lastDateOfTraining = lastDateOfTraining;
	}

	@Override
	public int compareTo(UserMasterDto o) {
		// TODO Auto-generated method stub
		return this.getId().compareTo(o.getId());
	}

	public Long getTypeOfTraining() {
		return typeOfTraining;
	}

	public void setTypeOfTraining(Long typeOfTraining) {
		this.typeOfTraining = typeOfTraining;
	}

	public Long getTypologyId() {
		return typologyId;
	}

	public void setTypologyId(Long typologyId) {
		this.typologyId = typologyId;
	}

	public TypologyDto getTypologyDto() {
		return typologyDto;
	}

	public void setTypologyDto(TypologyDto typologyDto) {
		this.typologyDto = typologyDto;
	}
	
}
