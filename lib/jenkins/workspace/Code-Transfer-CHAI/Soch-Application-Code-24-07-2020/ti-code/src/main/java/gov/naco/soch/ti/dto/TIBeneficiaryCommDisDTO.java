package gov.naco.soch.ti.dto;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;

import gov.naco.soch.dto.MiniMasterDto;

/**
 * A DTO for the {@link gov.naco.soch.domain.TIBeneficiaryCommDis} entity.
 */
public class TIBeneficiaryCommDisDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private Integer condomsDistributed;

    private Integer syringesDistributed;

    private Integer syringesReturned;
    
    private Integer needlesDistributed;

    private Integer needlesReturned;
    
    private Boolean condomUseDuringLastSex;

    private Boolean notSharingNeedleSyringe;

    private Boolean isActive;

    private Boolean isDeleted;

    private Long facilityId;
    
    private LocalDate distributionDate;

    private TIBeneficiaryDTO beneficiary;
    
    private MiniMasterDto contactType;
    
    private Boolean csm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCondomsDistributed() {
        return condomsDistributed;
    }

    public void setCondomsDistributed(Integer condomsDistributed) {
        this.condomsDistributed = condomsDistributed;
    }

    public Integer getSyringesDistributed() {
		return syringesDistributed;
	}

	public void setSyringesDistributed(Integer syringesDistributed) {
		this.syringesDistributed = syringesDistributed;
	}

	public Integer getSyringesReturned() {
		return syringesReturned;
	}

	public void setSyringesReturned(Integer syringesReturned) {
		this.syringesReturned = syringesReturned;
	}

	public Integer getNeedlesDistributed() {
		return needlesDistributed;
	}

	public void setNeedlesDistributed(Integer needlesDistributed) {
		this.needlesDistributed = needlesDistributed;
	}

	public Integer getNeedlesReturned() {
		return needlesReturned;
	}

	public void setNeedlesReturned(Integer needlesReturned) {
		this.needlesReturned = needlesReturned;
	}
	
	public LocalDate getDistributionDate() {
	    return distributionDate;
	}

	public void setDistributionDate(LocalDate distributionDate) {
	    this.distributionDate = distributionDate;
	}

	public Boolean isCondomUseDuringLastSex() {
        return condomUseDuringLastSex;
    }

    public void setCondomUseDuringLastSex(Boolean condomUseDuringLastSex) {
        this.condomUseDuringLastSex = condomUseDuringLastSex;
    }

    public Boolean isNotSharingNeedleSyringe() {
        return notSharingNeedleSyringe;
    }

    public void setNotSharingNeedleSyringe(Boolean notSharingNeedleSyringe) {
        this.notSharingNeedleSyringe = notSharingNeedleSyringe;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

   

	public TIBeneficiaryDTO getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(TIBeneficiaryDTO beneficiary) {
		this.beneficiary = beneficiary;
	}

	
	
	public MiniMasterDto getContactType() {
		return contactType;
	}

	public void setContactType(MiniMasterDto contactType) {
		this.contactType = contactType;
	}

	public Boolean getCondomUseDuringLastSex() {
		return condomUseDuringLastSex;
	}

	public Boolean getNotSharingNeedleSyringe() {
		return notSharingNeedleSyringe;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public Boolean getCsm() {
		return csm;
	}

	public void setCsm(Boolean csm) {
		this.csm = csm;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TIBeneficiaryCommDisDTO tIBeneficiaryCommDisDTO = (TIBeneficiaryCommDisDTO) o;
        if (tIBeneficiaryCommDisDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tIBeneficiaryCommDisDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "TIBeneficiaryCommDisDTO [id=" + id + ", condomsDistributed=" + condomsDistributed
				+ ", syringesDistributed=" + syringesDistributed + ", syringesReturned=" + syringesReturned
				+ ", needlesDistributed=" + needlesDistributed + ", needlesReturned=" + needlesReturned
				+ ", condomUseDuringLastSex=" + condomUseDuringLastSex + ", notSharingNeedleSyringe="
				+ notSharingNeedleSyringe + ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", facilityId="
				+ facilityId + ", beneficiary=" + beneficiary + ", contactType=" + contactType + "]";
	}

	
	

    
}
