package gov.naco.soch.dto;

public class FacilityUserDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String role;
	private Long role_id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	@Override
	public String toString() {
		return "FacilityUserDto [id=" + id + ", name=" + name + ", role=" + role + ", role_id=" + role_id + "]";
	}
	
	

}
