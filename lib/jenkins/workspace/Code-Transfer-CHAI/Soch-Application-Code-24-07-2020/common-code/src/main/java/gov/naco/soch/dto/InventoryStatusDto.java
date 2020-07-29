
package gov.naco.soch.dto;

import java.io.Serializable;

public class InventoryStatusDto implements Serializable {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Long id;
	private String inventoryStatusName;
	private boolean isDelete;
	private boolean isActive;

	// getters and setters
	public Long getId() {
		return id;
	}

	public String getInventoryStatusName() {
		return inventoryStatusName;
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

	public void setInventoryStatusName(String inventoryStatusName) {
		this.inventoryStatusName = inventoryStatusName;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	// toString
	@Override
	public String toString() {
		return "InventoryStatusDto [id=" + id + ", inventoryStatusName=" + inventoryStatusName + ", isDelete="
				+ isDelete + ", isActive=" + isActive + "]";
	}

	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryStatusDto other = (InventoryStatusDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inventoryStatusName == null) {
			if (other.inventoryStatusName != null)
				return false;
		} else if (!inventoryStatusName.equals(other.inventoryStatusName))
			return false;
		if (isActive != other.isActive)
			return false;
		if (isDelete != other.isDelete)
			return false;
		return true;
	}

}
