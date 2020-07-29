package gov.naco.soch.dto;

import java.io.Serializable;
import java.util.Arrays;

//DTO class used for transfer data between front end and back end.
public class SystemDto implements Serializable {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private String version;
	private String profile;
	private String updatedOn;
	private String[] mainChanges;
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	public String getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	public String[] getMainChanges() {
		return mainChanges;
	}
	public void setMainChanges(String[] mainChanges) {
		this.mainChanges = mainChanges;
	}
	@Override
	public String toString() {
		return "SystemDto [version=" + version + ", profile=" + profile + ", updatedOn=" + updatedOn + ", mainChanges="
				+ Arrays.toString(mainChanges) + "]";
	}
	

}
