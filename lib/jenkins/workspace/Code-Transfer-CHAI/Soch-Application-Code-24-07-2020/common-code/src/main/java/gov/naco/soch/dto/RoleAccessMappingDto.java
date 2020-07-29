package gov.naco.soch.dto;

//DTO class used for transfer data between front end and back end.
public class RoleAccessMappingDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	//DTO class properties
	private Long id;
	private Long roleId;
	private String accessCode;
	private String accessName;
	private String accessDescription;
	private String module;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getAccessCode() {
		return accessCode;
	}
	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}
	public String getAccessName() {
		return accessName;
	}
	public void setAccessName(String accessName) {
		this.accessName = accessName;
	}
	
	public String getAccessDescription() {
		return accessDescription;
	}
	public void setAccessDescription(String accessDescription) {
		this.accessDescription = accessDescription;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	@Override
	public String toString() {
		return "RoleAccessMappingDto [id=" + id + ", roleId=" + roleId + ", accessCode=" + accessCode + ", accessName="
				+ accessName + ", accessDescription=" + accessDescription + ", module=" + module + "]";
	}
	
	
}
