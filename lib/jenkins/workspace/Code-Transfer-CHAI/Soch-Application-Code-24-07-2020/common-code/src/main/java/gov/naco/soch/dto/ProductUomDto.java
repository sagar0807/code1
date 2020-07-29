
package gov.naco.soch.dto;

import java.io.Serializable;

// DTO class used for transfer data between front end and back end.
public class ProductUomDto implements Serializable {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Long id;
	private String uomName;
	private boolean isDelete;
	private boolean isActive;

	// define getter and setter for the above properties.
	public Long getId() {
		return id;
	}

	public String getUomName() {
		return uomName;
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

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "ProductUomDto [id=" + id + ", uomName=" + uomName + ", isDelete=" + isDelete + ", isActive=" + isActive
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + (isDelete ? 1231 : 1237);
		result = prime * result + ((uomName == null) ? 0 : uomName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductUomDto other = (ProductUomDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive != other.isActive)
			return false;
		if (isDelete != other.isDelete)
			return false;
		if (uomName == null) {
			if (other.uomName != null)
				return false;
		} else if (!uomName.equals(other.uomName))
			return false;
		return true;
	}

}
