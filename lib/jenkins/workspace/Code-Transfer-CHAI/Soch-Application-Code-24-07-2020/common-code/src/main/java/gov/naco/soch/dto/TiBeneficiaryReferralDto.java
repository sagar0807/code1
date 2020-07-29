package gov.naco.soch.dto;

import java.time.LocalDate;

public class TiBeneficiaryReferralDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Long beneficiaryId;
	private Integer referralFacility;
	private String referralStatus;

	private LocalDate dateOfReferral;
	private Integer referredFacility;
	private String hivStatus;
	private boolean isActive;

	private String transferTo;
	private String transferFrom;
	private LocalDate transferDate;
	private String transferlStatus;
	private String referralType;

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

	public Integer getReferralFacility() {
		return referralFacility;
	}

	public void setReferralFacility(Integer referralFacility) {
		this.referralFacility = referralFacility;
	}

	public String getReferralStatus() {
		return referralStatus;
	}

	public void setReferralStatus(String referralStatus) {
		this.referralStatus = referralStatus;
	}

	public LocalDate getDateOfReferral() {
		return dateOfReferral;
	}

	public void setDateOfReferral(LocalDate dateOfReferral) {
		this.dateOfReferral = dateOfReferral;
	}

	public Integer getReferredFacility() {
		return referredFacility;
	}

	public void setReferredFacility(Integer referredFacility) {
		this.referredFacility = referredFacility;
	}

	public String getHivStatus() {
		return hivStatus;
	}

	public void setHivStatus(String hivStatus) {
		this.hivStatus = hivStatus;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getTransferTo() {
		return transferTo;
	}

	public void setTransferTo(String transferTo) {
		this.transferTo = transferTo;
	}

	public String getTransferFrom() {
		return transferFrom;
	}

	public void setTransferFrom(String transferFrom) {
		this.transferFrom = transferFrom;
	}

	public LocalDate getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(LocalDate transferDate) {
		this.transferDate = transferDate;
	}

	public String getTransferlStatus() {
		return transferlStatus;
	}

	public void setTransferlStatus(String transferlStatus) {
		this.transferlStatus = transferlStatus;
	}
	
	public String getReferralType() {
		return referralType;
	}

	public void setReferralType(String referralType) {
		this.referralType = referralType;
	}

	@Override
	public String toString() {
		return "TiBeneficiaryReferralDto [id=" + id + ", beneficiaryId=" + beneficiaryId + ", referralFacility="
				+ referralFacility + ", referralStatus=" + referralStatus + ", dateOfReferral=" + dateOfReferral
				+ ", referredFacility=" + referredFacility + ", hivStatus=" + hivStatus + ", isActive=" + isActive
				+ ", transferTo=" + transferTo + ", transferFrom=" + transferFrom + ", transferDate=" + transferDate
				+ ", transferlStatus=" + transferlStatus + "]"+ ", referralType=" + referralType + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TiBeneficiaryReferralDto other = (TiBeneficiaryReferralDto) obj;
		if (beneficiaryId == null) {
			if (other.beneficiaryId != null)
				return false;
		} else if (!beneficiaryId.equals(other.beneficiaryId))
			return false;
		if (dateOfReferral == null) {
			if (other.dateOfReferral != null)
				return false;
		} else if (!dateOfReferral.equals(other.dateOfReferral))
			return false;
		if (hivStatus == null) {
			if (other.hivStatus != null)
				return false;
		} else if (!hivStatus.equals(other.hivStatus))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive != other.isActive)
			return false;
		if (referralFacility == null) {
			if (other.referralFacility != null)
				return false;
		} else if (!referralFacility.equals(other.referralFacility))
			return false;
		if (referralStatus == null) {
			if (other.referralStatus != null)
				return false;
		} else if (!referralStatus.equals(other.referralStatus))
			return false;
		if (referredFacility == null) {
			if (other.referredFacility != null)
				return false;
		} else if (!referredFacility.equals(other.referredFacility))
			return false;
		if (transferDate == null) {
			if (other.transferDate != null)
				return false;
		} else if (!transferDate.equals(other.transferDate))
			return false;
		if (transferFrom == null) {
			if (other.transferFrom != null)
				return false;
		} else if (!transferFrom.equals(other.transferFrom))
			return false;
		if (transferTo == null) {
			if (other.transferTo != null)
				return false;
		} else if (!transferTo.equals(other.transferTo))
			return false;
		if (transferlStatus == null) {
			if (other.transferlStatus != null)
				return false;
		} else if (!transferlStatus.equals(other.transferlStatus))
			return false;
		if (referralType == null) {
			if (other.referralType != null)
				return false;
		} else if (!referralType.equals(other.referralType))
			return false;
		return true;
	}

}
