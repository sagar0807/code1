package gov.naco.soch.dto;

//DTO class used for transfer data between front end and back end.
public class FacilitySettingDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Long id;
	private String dsrcDefault;
	private String ictcDefault;
	private Boolean isActive;
	private String rntcpDefault;
	private String tiDefault;

	private Long beneficiaryId;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDsrcDefault() {
		return dsrcDefault;
	}

	public void setDsrcDefault(String dsrcDefault) {
		this.dsrcDefault = dsrcDefault;
	}

	public String getIctcDefault() {
		return ictcDefault;
	}

	public void setIctcDefault(String ictcDefault) {
		this.ictcDefault = ictcDefault;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getRntcpDefault() {
		return rntcpDefault;
	}

	public void setRntcpDefault(String rntcpDefault) {
		this.rntcpDefault = rntcpDefault;
	}

	public String getTiDefault() {
		return tiDefault;
	}

	public void setTiDefault(String tiDefault) {
		this.tiDefault = tiDefault;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	// Overriding toString
	@Override
	public String toString() {
		return "FacilitySettingDto [id=" + id + ", dsrcDefault=" + dsrcDefault + ", ictcDefault=" + ictcDefault
				+ ", isActive=" + isActive + ", rntcpDefault=" + rntcpDefault + ", tiDefault=" + tiDefault
				+ ", beneficiaryId=" + beneficiaryId + "]";
	}

	// Overriding equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacilitySettingDto other = (FacilitySettingDto) obj;
		if (beneficiaryId == null) {
			if (other.beneficiaryId != null)
				return false;
		} else if (!beneficiaryId.equals(other.beneficiaryId))
			return false;
		if (dsrcDefault == null) {
			if (other.dsrcDefault != null)
				return false;
		} else if (!dsrcDefault.equals(other.dsrcDefault))
			return false;
		if (ictcDefault == null) {
			if (other.ictcDefault != null)
				return false;
		} else if (!ictcDefault.equals(other.ictcDefault))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (rntcpDefault == null) {
			if (other.rntcpDefault != null)
				return false;
		} else if (!rntcpDefault.equals(other.rntcpDefault))
			return false;
		if (tiDefault == null) {
			if (other.tiDefault != null)
				return false;
		} else if (!tiDefault.equals(other.tiDefault))
			return false;
		return true;
	}

}
