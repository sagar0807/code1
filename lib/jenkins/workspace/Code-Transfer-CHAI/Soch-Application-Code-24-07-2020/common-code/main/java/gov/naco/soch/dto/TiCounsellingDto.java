package gov.naco.soch.dto;

public class TiCounsellingDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private Long id;

	private Integer durationOfCounselling;
	private String typeOfCounsellingProvided;
	private Integer noOfCondomsDistributed;
	private Boolean isActive;

	private Long beneficiaryId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDurationOfCounselling() {
		return durationOfCounselling;
	}

	public void setDurationOfCounselling(Integer durationOfCounselling) {
		this.durationOfCounselling = durationOfCounselling;
	}

	public String getTypeOfCounsellingProvided() {
		return typeOfCounsellingProvided;
	}

	public void setTypeOfCounsellingProvided(String typeOfCounsellingProvided) {
		this.typeOfCounsellingProvided = typeOfCounsellingProvided;
	}

	public Integer getNoOfCondomsDistributed() {
		return noOfCondomsDistributed;
	}

	public void setNoOfCondomsDistributed(Integer noOfCondomsDistributed) {
		this.noOfCondomsDistributed = noOfCondomsDistributed;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	@Override
	public String toString() {
		return "TiCounsellingDto [id=" + id + ", durationOfCounselling=" + durationOfCounselling
				+ ", typeOfCounsellingProvided=" + typeOfCounsellingProvided + ", noOfCondomsDistributed="
				+ noOfCondomsDistributed + ", isActive=" + isActive + ", beneficiaryId=" + beneficiaryId + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TiCounsellingDto other = (TiCounsellingDto) obj;
		if (beneficiaryId == null) {
			if (other.beneficiaryId != null)
				return false;
		} else if (!beneficiaryId.equals(other.beneficiaryId))
			return false;
		if (durationOfCounselling == null) {
			if (other.durationOfCounselling != null)
				return false;
		} else if (!durationOfCounselling.equals(other.durationOfCounselling))
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
		if (noOfCondomsDistributed == null) {
			if (other.noOfCondomsDistributed != null)
				return false;
		} else if (!noOfCondomsDistributed.equals(other.noOfCondomsDistributed))
			return false;
		if (typeOfCounsellingProvided == null) {
			if (other.typeOfCounsellingProvided != null)
				return false;
		} else if (!typeOfCounsellingProvided.equals(other.typeOfCounsellingProvided))
			return false;
		return true;
	}

}
