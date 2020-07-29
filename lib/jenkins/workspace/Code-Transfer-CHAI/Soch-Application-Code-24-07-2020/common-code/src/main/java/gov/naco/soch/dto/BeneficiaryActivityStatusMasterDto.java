package gov.naco.soch.dto;

import java.sql.Timestamp;

public class BeneficiaryActivityStatusMasterDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Integer id;
	private String beneficiaryActivityStatusName;
	private Integer createdBy;
	private Timestamp createdTime;
	private Boolean isActive;
	private Boolean isDelete;
	private Integer modifiedBy;
	private Timestamp modifiedTime;
	
	private BeneficiaryDto beneficiaryDto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBeneficiaryActivityStatusName() {
		return beneficiaryActivityStatusName;
	}

	public void setBeneficiaryActivityStatusName(String beneficiaryActivityStatusName) {
		this.beneficiaryActivityStatusName = beneficiaryActivityStatusName;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
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

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public BeneficiaryDto getBeneficiaryDto() {
		return beneficiaryDto;
	}

	public void setBeneficiaryDto(BeneficiaryDto beneficiaryDto) {
		this.beneficiaryDto = beneficiaryDto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BeneficiaryActivityStatusMasterDto [id=" + id + ", beneficiaryActivityStatusName="
				+ beneficiaryActivityStatusName + ", createdBy=" + createdBy + ", createdTime=" + createdTime
				+ ", isActive=" + isActive + ", isDelete=" + isDelete + ", modifiedBy=" + modifiedBy + ", modifiedTime="
				+ modifiedTime + ", beneficiaryDto=" + beneficiaryDto + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeneficiaryActivityStatusMasterDto other = (BeneficiaryActivityStatusMasterDto) obj;
		if (beneficiaryActivityStatusName == null) {
			if (other.beneficiaryActivityStatusName != null)
				return false;
		} else if (!beneficiaryActivityStatusName.equals(other.beneficiaryActivityStatusName))
			return false;
		if (beneficiaryDto == null) {
			if (other.beneficiaryDto != null)
				return false;
		} else if (!beneficiaryDto.equals(other.beneficiaryDto))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdTime == null) {
			if (other.createdTime != null)
				return false;
		} else if (!createdTime.equals(other.createdTime))
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
		if (modifiedBy == null) {
			if (other.modifiedBy != null)
				return false;
		} else if (!modifiedBy.equals(other.modifiedBy))
			return false;
		if (modifiedTime == null) {
			if (other.modifiedTime != null)
				return false;
		} else if (!modifiedTime.equals(other.modifiedTime))
			return false;
		return true;
	}
	
	
}
