/**
 * 
 */
package gov.naco.soch.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @date 2020-Jan-01 11:46:46 AM
 */

// DTO class used for transfer data between front end and back end
public class IndentReasonsDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Long id;

	@NotEmpty(message = "Indent Reasons Name is mandatory")
	@Size(max = 15, message = "Indent Reasons Name  size shouldn't exceed 15 characters")
	private String indentReasonsName;

	private boolean is_active;
	private boolean is_delete;

	// Getters and setters for mentioned properties
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIndentReasonsName() {
		return indentReasonsName;
	}

	public void setIndentReasonsName(String indentReasonsName) {
		this.indentReasonsName = indentReasonsName;
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
		return "IndentReasonsDto [id=" + id + ", indentReasonsName=" + indentReasonsName + ", is_active=" + is_active
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
		IndentReasonsDto other = (IndentReasonsDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (indentReasonsName == null) {
			if (other.indentReasonsName != null)
				return false;
		} else if (!indentReasonsName.equals(other.indentReasonsName))
			return false;
		if (is_active != other.is_active)
			return false;
		if (is_delete != other.is_delete)
			return false;
		return true;
	}

}
