package gov.naco.soch.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @date 2020-Dec-30 12:18:00 PM
 */

// DTO class used for transfer data between front end and back end
public class GitStatusDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Long id;

	@NotEmpty(message = "Git status name is mandatory")
	@Size(max = 15, message = "Git status name  size shouldn't exceed 15 characters")
	private String gitStatusName;

	private boolean is_active;
	private boolean is_delete;

	// Getters and setters for above mentioned properties
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGitStatusName() {
		return gitStatusName;
	}

	public void setGitStatusName(String gitStatusName) {
		this.gitStatusName = gitStatusName;
	}

	public boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public boolean getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
	}

	

	public static long getSerialVersionUid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "GitStatusDto [id=" + id + ", gitStatusName=" + gitStatusName + ", is_active=" + is_active
				+ ", is_delete=" + is_delete + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GitStatusDto other = (GitStatusDto) obj;
		if (gitStatusName == null) {
			if (other.gitStatusName != null)
				return false;
		} else if (!gitStatusName.equals(other.gitStatusName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (is_active != other.is_active)
			return false;
		if (is_delete != other.is_delete)
			return false;
		return true;
	}

}
