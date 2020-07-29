package gov.naco.soch.dto;

import java.time.LocalDateTime;
import java.util.List;

public class LoginResponseDto {

	private String token;
	private String ssoSessionId;
	private Long userId;
	private String firstname;
	private String lastname;
	private Long divisionId;
	private Long facilityTypeId;
	private Long facilityId;
	private String facilityName;
	private String facilityCode;
	private Long designationId;
	private String designation;
	private String userName;
	private Long roleId;
	private String roleName;
	private String facilityCbStatus;
	private LocalDateTime lastLogin;
	private List<String> accessCodes;
	private List<MenuItemDto> menuItems;
	private String activeToken;
	private LocalDateTime currentLoginTime;

	public LoginResponseDto() {
		super();
	}

	public String getToken() {
		return token;
	}

	public String getSsoSessionId() {
		return ssoSessionId;
	}

	public void setSsoSessionId(String ssoSessionId) {
		this.ssoSessionId = ssoSessionId;
	}

	public Long getUserId() {
		return userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public Long getDivisionId() {
		return divisionId;
	}

	public Long getFacilityTypeId() {
		return facilityTypeId;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public String getFacilityCode() {
		return facilityCode;
	}

	public Long getDesignationId() {
		return designationId;
	}

	public String getDesignation() {
		return designation;
	}

	public String getUserName() {
		return userName;
	}

	public Long getRoleId() {
		return roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public List<String> getAccessCodes() {
		return accessCodes;
	}

	public List<MenuItemDto> getMenuItems() {
		return menuItems;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}

	public void setFacilityTypeId(Long facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}

	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setAccessCodes(List<String> accessCodes) {
		this.accessCodes = accessCodes;
	}

	public void setMenuItems(List<MenuItemDto> menuItems) {
		this.menuItems = menuItems;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getFacilityCbStatus() {
		return facilityCbStatus;
	}

	public void setFacilityCbStatus(String facilityCbStatus) {
		this.facilityCbStatus = facilityCbStatus;
	}

	public LocalDateTime getCurrentLoginTime() {
		return currentLoginTime;
	}

	public void setCurrentLoginTime(LocalDateTime currentLoginTime) {
		this.currentLoginTime = currentLoginTime;
	}

	public String getActiveToken() {
		return activeToken;
	}

	public void setActiveToken(String activeToken) {
		this.activeToken = activeToken;
	}

	@Override
	public String toString() {
		return "LoginResponseDto [token=" + token + ", userId=" + userId + ", firstname=" + firstname + ", lastname="
				+ lastname + ", divisionId=" + divisionId + ", facilityTypeId=" + facilityTypeId + ", facilityId="
				+ facilityId + ", facilityName=" + facilityName + ", facilityCode=" + facilityCode + ", designationId="
				+ designationId + ", designation=" + designation + ", userName=" + userName + ", roleId=" + roleId
				+ ", roleName=" + roleName + ", facilityCbStatus=" + facilityCbStatus + ", lastLogin=" + lastLogin
				+ ", accessCodes=" + accessCodes + ", menuItems=" + menuItems + "]";
	}

}
