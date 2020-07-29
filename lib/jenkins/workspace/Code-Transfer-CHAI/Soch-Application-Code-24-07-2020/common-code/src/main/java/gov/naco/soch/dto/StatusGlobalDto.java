
package gov.naco.soch.dto;

import java.io.Serializable;

/**
 * @date 2020-Jan-01 9:55:26 AM
 */

// DTO class used for transfer data between front end and back end.
public class StatusGlobalDto implements Serializable {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Long id;
	private String globalStatusName;
	private boolean isDelete;
	private boolean isActive;

	public StatusGlobalDto() {
		super();
	}

	// getters and setters
	public Long getId() {
		return id;
	}

	public String getGlobalStatusName() {
		return globalStatusName;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setGlobalStatusName(String globalStatusName) {
		this.globalStatusName = globalStatusName;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	//toString method
	@Override
	public String toString() {
		return "StatusGlobalDto [id=" + id + ", globalStatusName=" + globalStatusName + ", isDelete=" + isDelete
				+ ", isActive=" + isActive + "]";
	}

	// equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatusGlobalDto other = (StatusGlobalDto) obj;
		if (globalStatusName == null) {
			if (other.globalStatusName != null)
				return false;
		} else if (!globalStatusName.equals(other.globalStatusName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive != other.isActive)
			return false;
		if (isDelete != other.isDelete)
			return false;
		return true;
	}

}
