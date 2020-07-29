package gov.naco.soch.dto;

//DTO class used for transfer data between front end and back end.
public class BeneficiaryDueDto extends BaseDto{

	private static final long serialVersionUID = 1L;
	
	// DTO class properties
	private Long id;
	private String beneficiaryUid;
	private String beneficiaryName;
	private String artRegistrationNumber;
	private String orw;
	private String reasonForFollowUp;
	
	private String gender;
	private String artNumber;
	private String preArtNumber;
	private String beneficiaryArtStatus;
	private String reasonForStop;
	private String category;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBeneficiaryUid() {
		return beneficiaryUid;
	}
	public void setBeneficiaryUid(String beneficiaryUid) {
		this.beneficiaryUid = beneficiaryUid;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public String getArtRegistrationNumber() {
		return artRegistrationNumber;
	}
	public void setArtRegistrationNumber(String artRegistrationNumber) {
		this.artRegistrationNumber = artRegistrationNumber;
	}
	public String getOrw() {
		return orw;
	}
	public void setOrw(String orw) {
		this.orw = orw;
	}
	public String getReasonForFollowUp() {
		return reasonForFollowUp;
	}
	public void setReasonForFollowUp(String reasonForFollowUp) {
		this.reasonForFollowUp = reasonForFollowUp;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getArtNumber() {
		return artNumber;
	}
	public void setArtNumber(String artNumber) {
		this.artNumber = artNumber;
	}
	public String getPreArtNumber() {
		return preArtNumber;
	}
	public void setPreArtNumber(String preArtNumber) {
		this.preArtNumber = preArtNumber;
	}
	public String getBeneficiaryArtStatus() {
		return beneficiaryArtStatus;
	}
	public void setBeneficiaryArtStatus(String beneficiaryArtStatus) {
		this.beneficiaryArtStatus = beneficiaryArtStatus;
	}
	public String getReasonForStop() {
		return reasonForStop;
	}
	public void setReasonForStop(String reasonForStop) {
		this.reasonForStop = reasonForStop;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "BeneficiaryDueDto [id=" + id + ", beneficiaryUid=" + beneficiaryUid + ", beneficiaryName="
				+ beneficiaryName + ", artRegistrationNumber=" + artRegistrationNumber + ", orw=" + orw
				+ ", reasonForFollowUp=" + reasonForFollowUp + ", gender=" + gender + ", artNumber=" + artNumber
				+ ", preArtNumber=" + preArtNumber + ", beneficiaryArtStatus=" + beneficiaryArtStatus
				+ ", reasonForStop=" + reasonForStop + ", category=" + category + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeneficiaryDueDto other = (BeneficiaryDueDto) obj;
		if (artNumber == null) {
			if (other.artNumber != null)
				return false;
		} else if (!artNumber.equals(other.artNumber))
			return false;
		if (artRegistrationNumber == null) {
			if (other.artRegistrationNumber != null)
				return false;
		} else if (!artRegistrationNumber.equals(other.artRegistrationNumber))
			return false;
		if (beneficiaryArtStatus == null) {
			if (other.beneficiaryArtStatus != null)
				return false;
		} else if (!beneficiaryArtStatus.equals(other.beneficiaryArtStatus))
			return false;
		if (beneficiaryName == null) {
			if (other.beneficiaryName != null)
				return false;
		} else if (!beneficiaryName.equals(other.beneficiaryName))
			return false;
		if (beneficiaryUid == null) {
			if (other.beneficiaryUid != null)
				return false;
		} else if (!beneficiaryUid.equals(other.beneficiaryUid))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orw == null) {
			if (other.orw != null)
				return false;
		} else if (!orw.equals(other.orw))
			return false;
		if (preArtNumber == null) {
			if (other.preArtNumber != null)
				return false;
		} else if (!preArtNumber.equals(other.preArtNumber))
			return false;
		if (reasonForFollowUp == null) {
			if (other.reasonForFollowUp != null)
				return false;
		} else if (!reasonForFollowUp.equals(other.reasonForFollowUp))
			return false;
		if (reasonForStop == null) {
			if (other.reasonForStop != null)
				return false;
		} else if (!reasonForStop.equals(other.reasonForStop))
			return false;
		return true;
	}
	
	
}
