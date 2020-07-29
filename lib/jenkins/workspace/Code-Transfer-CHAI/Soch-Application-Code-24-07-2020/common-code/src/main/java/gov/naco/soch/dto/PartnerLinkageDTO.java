package gov.naco.soch.dto;

import gov.naco.soch.dto.BaseDto;
import gov.naco.soch.dto.BeneficiaryDto;
import gov.naco.soch.dto.MiniMasterDto;

public class PartnerLinkageDTO extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private Long id;

	private Integer ageMonths;

	private Integer ageYears;

	private String familyUid;

	private Boolean isActive;
	
	private Boolean isDelete;

	private Boolean isAlive;

	private Boolean isBeneficiary;

	private Boolean onArt;

	private BeneficiaryDto beneficiary;

	private BeneficiaryDto partnerBeneficiary;

	private MiniMasterDto masterGender;

	private MiniMasterDto masterHivStatus;

	private MiniMasterDto masterRelationship;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAgeMonths() {
		return ageMonths;
	}

	public void setAgeMonths(Integer ageMonths) {
		this.ageMonths = ageMonths;
	}

	public Integer getAgeYears() {
		return ageYears;
	}

	public void setAgeYears(Integer ageYears) {
		this.ageYears = ageYears;
	}

	public String getFamilyUid() {
		return familyUid;
	}

	public void setFamilyUid(String familyUid) {
		this.familyUid = familyUid;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean getIsAlive() {
		return isAlive;
	}

	public void setIsAlive(Boolean isAlive) {
		this.isAlive = isAlive;
	}

	public Boolean getIsBeneficiary() {
		return isBeneficiary;
	}

	public void setIsBeneficiary(Boolean isBeneficiary) {
		this.isBeneficiary = isBeneficiary;
	}

	public Boolean getOnArt() {
		return onArt;
	}

	public void setOnArt(Boolean onArt) {
		this.onArt = onArt;
	}

	public BeneficiaryDto getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(BeneficiaryDto beneficiary) {
		this.beneficiary = beneficiary;
	}

	public BeneficiaryDto getPartnerBeneficiary() {
		return partnerBeneficiary;
	}

	public void setPartnerBeneficiary(BeneficiaryDto partnerBeneficiary) {
		this.partnerBeneficiary = partnerBeneficiary;
	}

	public MiniMasterDto getMasterGender() {
		return masterGender;
	}

	public void setMasterGender(MiniMasterDto masterGender) {
		this.masterGender = masterGender;
	}

	public MiniMasterDto getMasterHivStatus() {
		return masterHivStatus;
	}

	public void setMasterHivStatus(MiniMasterDto masterHivStatus) {
		this.masterHivStatus = masterHivStatus;
	}

	public MiniMasterDto getMasterRelationship() {
		return masterRelationship;
	}

	public void setMasterRelationship(MiniMasterDto masterRelationship) {
		this.masterRelationship = masterRelationship;
	}

	@Override
	public String toString() {
		return "PartnerLinkageDTO [id=" + id + ", ageMonths=" + ageMonths + ", ageYears=" + ageYears + ", familyUid="
				+ familyUid + ", isActive=" + isActive + ", isDelete=" + isDelete + ", isAlive=" + isAlive
				+ ", isBeneficiary=" + isBeneficiary + ", onArt=" + onArt + ", beneficiary=" + beneficiary
				+ ", partnerBeneficiary=" + partnerBeneficiary + ", masterGender=" + masterGender + ", masterHivStatus="
				+ masterHivStatus + ", masterRelationship=" + masterRelationship + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ageMonths == null) ? 0 : ageMonths.hashCode());
		result = prime * result + ((ageYears == null) ? 0 : ageYears.hashCode());
		result = prime * result + ((beneficiary == null) ? 0 : beneficiary.hashCode());
		result = prime * result + ((familyUid == null) ? 0 : familyUid.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((isAlive == null) ? 0 : isAlive.hashCode());
		result = prime * result + ((isBeneficiary == null) ? 0 : isBeneficiary.hashCode());
		result = prime * result + ((isDelete == null) ? 0 : isDelete.hashCode());
		result = prime * result + ((masterGender == null) ? 0 : masterGender.hashCode());
		result = prime * result + ((masterHivStatus == null) ? 0 : masterHivStatus.hashCode());
		result = prime * result + ((masterRelationship == null) ? 0 : masterRelationship.hashCode());
		result = prime * result + ((onArt == null) ? 0 : onArt.hashCode());
		result = prime * result + ((partnerBeneficiary == null) ? 0 : partnerBeneficiary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartnerLinkageDTO other = (PartnerLinkageDTO) obj;
		if (ageMonths == null) {
			if (other.ageMonths != null)
				return false;
		} else if (!ageMonths.equals(other.ageMonths))
			return false;
		if (ageYears == null) {
			if (other.ageYears != null)
				return false;
		} else if (!ageYears.equals(other.ageYears))
			return false;
		if (beneficiary == null) {
			if (other.beneficiary != null)
				return false;
		} else if (!beneficiary.equals(other.beneficiary))
			return false;
		if (familyUid == null) {
			if (other.familyUid != null)
				return false;
		} else if (!familyUid.equals(other.familyUid))
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
		if (isAlive == null) {
			if (other.isAlive != null)
				return false;
		} else if (!isAlive.equals(other.isAlive))
			return false;
		if (isBeneficiary == null) {
			if (other.isBeneficiary != null)
				return false;
		} else if (!isBeneficiary.equals(other.isBeneficiary))
			return false;
		if (isDelete == null) {
			if (other.isDelete != null)
				return false;
		} else if (!isDelete.equals(other.isDelete))
			return false;
		if (masterGender == null) {
			if (other.masterGender != null)
				return false;
		} else if (!masterGender.equals(other.masterGender))
			return false;
		if (masterHivStatus == null) {
			if (other.masterHivStatus != null)
				return false;
		} else if (!masterHivStatus.equals(other.masterHivStatus))
			return false;
		if (masterRelationship == null) {
			if (other.masterRelationship != null)
				return false;
		} else if (!masterRelationship.equals(other.masterRelationship))
			return false;
		if (onArt == null) {
			if (other.onArt != null)
				return false;
		} else if (!onArt.equals(other.onArt))
			return false;
		if (partnerBeneficiary == null) {
			if (other.partnerBeneficiary != null)
				return false;
		} else if (!partnerBeneficiary.equals(other.partnerBeneficiary))
			return false;
		return true;
	}
	
	
	

	

}
