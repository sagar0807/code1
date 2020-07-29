/**
 * 
 */
package gov.naco.soch.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @date 2019-Dec-31 9:35:35 AM
 */

// DTO class used for transfer data between front end and back end
public class IndentRequestStatusDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Long id;

	@NotEmpty(message = "Indent Request Status Name is mandatory")
	@Size(max = 15, message = "Indent Request Status Name size shouldn't exceed 15 characters")
	private String indentRequestStatusName;

	private boolean is_active;
	private boolean is_delete;

	// Getters and setters for mentioned properties
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIndentRequestStatusName() {
		return indentRequestStatusName;
	}

	public void setIndentRequestStatusName(String indentRequestStatusName) {
		this.indentRequestStatusName = indentRequestStatusName;
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

	

	@Override
	public String toString() {
		return "IndentRequestStatusDto [id=" + id + ", indentRequestStatusName=" + indentRequestStatusName
				+ ", is_active=" + is_active + ", is_delete=" + is_delete + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IndentRequestStatusDto other = (IndentRequestStatusDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (indentRequestStatusName == null) {
			if (other.indentRequestStatusName != null)
				return false;
		} else if (!indentRequestStatusName.equals(other.indentRequestStatusName))
			return false;
		if (is_active != other.is_active)
			return false;
		if (is_delete != other.is_delete)
			return false;
		return true;
	}

}
