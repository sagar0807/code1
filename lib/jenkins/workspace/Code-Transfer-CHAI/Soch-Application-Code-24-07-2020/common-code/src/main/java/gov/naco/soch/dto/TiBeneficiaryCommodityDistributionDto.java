package gov.naco.soch.dto;

public class TiBeneficiaryCommodityDistributionDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String condomUseDuringLastSex;
	private Integer condomsDistributed;
	private Boolean isActive;
	private String notSharingNeedleSyringe;
	private Integer syringesNeedlesDistributed;
	private Integer syringesNeedlesReturned;
	private String typeOfContact;

	private Long beneficiaryId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCondomUseDuringLastSex() {
		return condomUseDuringLastSex;
	}

	public void setCondomUseDuringLastSex(String condomUseDuringLastSex) {
		this.condomUseDuringLastSex = condomUseDuringLastSex;
	}

	public Integer getCondomsDistributed() {
		return condomsDistributed;
	}

	public void setCondomsDistributed(Integer condomsDistributed) {
		this.condomsDistributed = condomsDistributed;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getNotSharingNeedleSyringe() {
		return notSharingNeedleSyringe;
	}

	public void setNotSharingNeedleSyringe(String notSharingNeedleSyringe) {
		this.notSharingNeedleSyringe = notSharingNeedleSyringe;
	}

	public Integer getSyringesNeedlesDistributed() {
		return syringesNeedlesDistributed;
	}

	public void setSyringesNeedlesDistributed(Integer syringesNeedlesDistributed) {
		this.syringesNeedlesDistributed = syringesNeedlesDistributed;
	}

	public Integer getSyringesNeedlesReturned() {
		return syringesNeedlesReturned;
	}

	public void setSyringesNeedlesReturned(Integer syringesNeedlesReturned) {
		this.syringesNeedlesReturned = syringesNeedlesReturned;
	}

	public String getTypeOfContact() {
		return typeOfContact;
	}

	public void setTypeOfContact(String typeOfContact) {
		this.typeOfContact = typeOfContact;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TiCommodityDistributionDto [id=" + id + ", condomUseDuringLastSex=" + condomUseDuringLastSex
				+ ", condomsDistributed=" + condomsDistributed + ", isActive=" + isActive + ", notSharingNeedleSyringe="
				+ notSharingNeedleSyringe + ", syringesNeedlesDistributed=" + syringesNeedlesDistributed
				+ ", syringesNeedlesReturned=" + syringesNeedlesReturned + ", typeOfContact=" + typeOfContact
				+ ", beneficiaryId=" + beneficiaryId + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TiBeneficiaryCommodityDistributionDto other = (TiBeneficiaryCommodityDistributionDto) obj;
		if (beneficiaryId == null) {
			if (other.beneficiaryId != null)
				return false;
		} else if (!beneficiaryId.equals(other.beneficiaryId))
			return false;
		if (condomUseDuringLastSex == null) {
			if (other.condomUseDuringLastSex != null)
				return false;
		} else if (!condomUseDuringLastSex.equals(other.condomUseDuringLastSex))
			return false;
		if (condomsDistributed == null) {
			if (other.condomsDistributed != null)
				return false;
		} else if (!condomsDistributed.equals(other.condomsDistributed))
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
		if (notSharingNeedleSyringe == null) {
			if (other.notSharingNeedleSyringe != null)
				return false;
		} else if (!notSharingNeedleSyringe.equals(other.notSharingNeedleSyringe))
			return false;
		if (syringesNeedlesDistributed == null) {
			if (other.syringesNeedlesDistributed != null)
				return false;
		} else if (!syringesNeedlesDistributed.equals(other.syringesNeedlesDistributed))
			return false;
		if (syringesNeedlesReturned == null) {
			if (other.syringesNeedlesReturned != null)
				return false;
		} else if (!syringesNeedlesReturned.equals(other.syringesNeedlesReturned))
			return false;
		if (typeOfContact == null) {
			if (other.typeOfContact != null)
				return false;
		} else if (!typeOfContact.equals(other.typeOfContact))
			return false;
		return true;
	}

}
