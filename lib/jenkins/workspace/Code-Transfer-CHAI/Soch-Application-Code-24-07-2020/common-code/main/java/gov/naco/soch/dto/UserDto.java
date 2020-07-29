package gov.naco.soch.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//DTO class used for transfer data between front end and back end.
public class UserDto implements Serializable,Comparable<UserDto> {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Long id;

	@Size(max = 20)
	@NotEmpty(message = "firstName must not be empty")
	private String firstName;
	private String lastName;

	private String type;

	@NotEmpty(message = "email must not be empty")
	private String email;

	private String mobileNumber;
	private String division;
	private Long designation;
	private String landline;
	private String status;
	private String username;
	private String password;
	private LocalDateTime createdTime;
	private boolean isDelete;
	private boolean active;

	private List<RoleDto> role;

	// define getter and setter for the above properties.
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public Long getDesignation() {
		return designation;
	}

	public void setDesignation(Long designation) {
		this.designation = designation;
	}

	public String getLandline() {
		return landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public List<RoleDto> getRole() {
		return role;
	}

	public void setRole(List<RoleDto> role) {
		this.role = role;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", type=" + type
				+ ", email=" + email + ", mobileNumber=" + mobileNumber + ", division=" + division + ", designation="
				+ designation + ", landline=" + landline + ", status=" + status + ", username=" + username
				+ ", password=" + password + ", createdTime=" + createdTime + ", isDelete=" + isDelete + ", active="
				+ active + ", role=" + role + "]";
	}

	@Override
	public int compareTo(UserDto o) {
		// TODO Auto-generated method stub
		return this.getId().compareTo(o.getId());
	}

}
