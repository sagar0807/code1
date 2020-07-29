/**
 * 
 */
package gov.naco.soch.dto;

import java.io.Serializable;

// DTO class used for transfer data between front end and back end.
public class ProductTypesDto implements Serializable {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Long id;
	private String productTypeName;
	private boolean isDelete;
	private boolean isActive;

	// getters and setter for the above properties.
	public Long getId() {
		return id;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public boolean setIsDelete() {
		return isDelete;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
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
		ProductTypesDto other = (ProductTypesDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive != other.isActive)
			return false;
		if (isDelete != other.isDelete)
			return false;
		if (productTypeName == null) {
			if (other.productTypeName != null)
				return false;
		} else if (!productTypeName.equals(other.productTypeName))
			return false;
		return true;
	}

	// toString method
	@Override
	public String toString() {
		return "ProductTypesDto [id=" + id + ", productTypeName=" + productTypeName + ", isDelete=" + isDelete
				+ ", isActive=" + isActive + "]";
	}

}
