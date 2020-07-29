package gov.naco.soch.dto;

//DTO class used for transfer data between front end and back end.
public class BeneficiaryFacilityMappingDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Long id;
	private Long beneficiaryId;
	private Long facilityId;
       private String artNumber;
	private Boolean isActive;
	private Boolean isDelete;
	private Long facilityTypeId;
	private String preArtNumber;
	private Boolean isTransferred;

	// Getters and setters for mentioned properties
	public BeneficiaryFacilityMappingDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Boolean getIsTransferred() {
	    return isTransferred;
	}

	public void setIsTransferred(Boolean isTransferred) {
	    this.isTransferred = isTransferred;
	}

	public String getPreArtNumber() {
		return preArtNumber;
	}

	public void setPreArtNumber(String preArtNumber) {
		this.preArtNumber = preArtNumber;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Long getFacilityTypeId() {
		return facilityTypeId;
	}

	public void setFacilityTypeId(Long facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	

	public String getArtNumber() {
		return artNumber;
	}

	public void setArtNumber(String artNumber) {
		this.artNumber = artNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BeneficiaryFacilityMappingDto [id=" + id + ", beneficiaryId=" + beneficiaryId + ", facilityId="
				+ facilityId + ", isActive=" + isActive + ", isDelete=" + isDelete + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeneficiaryFacilityMappingDto other = (BeneficiaryFacilityMappingDto) obj;
		if (beneficiaryId == null) {
			if (other.beneficiaryId != null)
				return false;
		} else if (!beneficiaryId.equals(other.beneficiaryId))
			return false;
		if (facilityId == null) {
			if (other.facilityId != null)
				return false;
		} else if (!facilityId.equals(other.facilityId))
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
		if (isDelete == null) {
			if (other.isDelete != null)
				return false;
		} else if (!isDelete.equals(other.isDelete))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}
