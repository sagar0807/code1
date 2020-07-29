/**
 * 
 */
package gov.naco.soch.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @date 2020-Jan-02 3:06:10 PM
 */

// DTO class used for transfer data between front end and back end
public class DatavaluesPatientInformationMasterDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Long id;

	@NotEmpty(message = "dataType is mandatory")
	@Size(max = 25, message = "dataType field size shouldn't exceed 25 characters")
	private String dataType;

	@NotEmpty(message = "dataValue is mandatory")
	@Size(max = 55, message = "dataValue field size shouldn't exceed 55 characters")
	private String dataValue;

	private boolean is_active;
	private boolean is_delete;

	// Getters and setters for mentioned properties
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataValue() {
		return dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}



	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public boolean isIs_delete() {
		return is_delete;
	}

	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static long getSerialVersionUid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DatavaluesPatientInformationMasterDto [id=" + id + ", dataType=" + dataType + ", dataValue=" + dataValue
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
		DatavaluesPatientInformationMasterDto other = (DatavaluesPatientInformationMasterDto) obj;
		if (dataType == null) {
			if (other.dataType != null)
				return false;
		} else if (!dataType.equals(other.dataType))
			return false;
		if (dataValue == null) {
			if (other.dataValue != null)
				return false;
		} else if (!dataValue.equals(other.dataValue))
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
