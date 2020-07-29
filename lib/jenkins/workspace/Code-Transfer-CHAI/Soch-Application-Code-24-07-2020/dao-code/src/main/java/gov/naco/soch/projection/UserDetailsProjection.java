package gov.naco.soch.projection;

import java.time.LocalDateTime;

public interface UserDetailsProjection {

	Long getUserId();

	String getFirstname();

	String getLastname();

	Long getDivisionId();

	Long getFacilityTypeId();

	Long getFacilityId();

	String getFacilityName();

	String getFacilityCode();

	Long getDesignationId();

	String getDesignation();

	String getUsername();

	String getPassword();

	Long getRoleId();

	String getRoleName();

	String getMobileNumber();

	String getEmail();

	LocalDateTime getLastLoginTime();
	
	String getFacilityCbStatus();

	void setUserId(Long userId);

	void setFirstname(String firstname);

	void setLastname(String lastname);

	void setDivisionId(Long divisionId);

	void setFacilityTypeId(Long facilityTypeId);

	void setFacilityId(Long facilityId);

	void setFacilityName(String facilityName);

	void setFacilityCode(String facilityCode);

	void setDesignationId(Long designationId);

	void setDesignation(String designation);

	void setUsername(String username);

	void setPassword(String password);

	void setRoleId(Long roleId);

	void setRoleName(String roleName);

	void setLastLoginTime(LocalDateTime lastLoginTime);
	
	void setFacilityCbStatus(String facilityCbStatus);

	void setMobileNumber(String mNumber);

	void setEmail(String email);

}
