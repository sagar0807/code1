package gov.naco.soch.dto;

import java.io.Serializable;
import java.util.List;

public class OrwPeMappingDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private UserMasterDto orwUser;
	private List<UserMasterDto> peUsers;
	
	public UserMasterDto getOrwUser() {
		return orwUser;
	}


	public void setOrwUser(UserMasterDto orwUser) {
		this.orwUser = orwUser;
	}


	public List<UserMasterDto> getPeUsers() {
		return peUsers;
	}


	public void setPeUsers(List<UserMasterDto> peUsers) {
		this.peUsers = peUsers;
	}


	@Override
	public String toString() {
		return "OrwPeMappingDto [orwUser=" + orwUser + ", peUsers=" + peUsers + "]";
	}
	
	
}
