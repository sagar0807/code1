package gov.naco.soch.dto;

import java.io.Serializable;

//DTO class used for transfer data between front end and back end.
public class RoleDivisionMapDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//DTO class properties
		private Integer id;
		private String name;
		private String divisionName;
		private Integer divisionId;
		private String status;
		private Boolean isPrimary;
		private Boolean isDelete;
		
		//define getter and setter for the above properties.
		
		public RoleDivisionMapDto() {
			super();
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDivisionName() {
			return divisionName;
		}
		public void setDivisionName(String divisionName) {
			this.divisionName = divisionName;
		}
		public Integer getDivisionId() {
			return divisionId;
		}
		public void setDivisionId(Integer divisionId) {
			this.divisionId = divisionId;
		}
		public String getStatus() {
			return status;
		}
		
		public Boolean getIsPrimary() {
			return isPrimary;
		}
		public void setIsPrimary(Boolean isPrimary) {
			this.isPrimary = isPrimary;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Boolean getIsDelete() {
			return isDelete;
		}
		public void setIsDelete(Boolean isDelete) {
			this.isDelete = isDelete;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		@Override
		public String toString() {
			return "RoleDivisionMapDto [id=" + id + ", name=" + name + ", divisionName=" + divisionName
					+ ", divisionId=" + divisionId + ", status=" + status + ", isPrimary=" + isPrimary + ", isDelete="
					+ isDelete + "]";
		}
	

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			RoleDivisionMapDto other = (RoleDivisionMapDto) obj;
			if (divisionId == null) {
				if (other.divisionId != null)
					return false;
			} else if (!divisionId.equals(other.divisionId))
				return false;
			if (divisionName == null) {
				if (other.divisionName != null)
					return false;
			} else if (!divisionName.equals(other.divisionName))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (isDelete == null) {
				if (other.isDelete != null)
					return false;
			} else if (!isDelete.equals(other.isDelete))
				return false;
			if (isPrimary == null) {
				if (other.isPrimary != null)
					return false;
			} else if (!isPrimary.equals(other.isPrimary))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (status == null) {
				if (other.status != null)
					return false;
			} else if (!status.equals(other.status))
				return false;
			return true;
		}

		
		
		
}
