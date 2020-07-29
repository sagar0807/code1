package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the BeneficiaryFacilityMapping entity.
 */
public class BeneficiaryFacilityMappingDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Boolean isActive;

    private Boolean isDelete;

    private String pid;

    private LocalDate mappingDate;

    private LocalDate registrationDate;

    private LocalDate createdTime;

    private LocalDate modifiedTime;
    
  	private String preArtNumber;

  	private String artNumber;

    private Long beneficiaryId;

    private Long facilityId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public LocalDate getMappingDate() {
        return mappingDate;
    }

    public void setMappingDate(LocalDate mappingDate) {
        this.mappingDate = mappingDate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDate createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDate getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDate modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }
    
    public String getPreArtNumber() {
		return preArtNumber;
	}

	public void setPreArtNumber(String preArtNumber) {
		this.preArtNumber = preArtNumber;
	}

	public String getArtNumber() {
		return artNumber;
	}

	public void setArtNumber(String artNumber) {
		this.artNumber = artNumber;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BeneficiaryFacilityMappingDTO beneficiaryFacilityMappingDTO = (BeneficiaryFacilityMappingDTO) o;
        if (beneficiaryFacilityMappingDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), beneficiaryFacilityMappingDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
	public String toString() {
		return "BeneficiaryFacilityMappingDTO [id=" + id + ", isActive=" + isActive + ", isDelete=" + isDelete
				+ ", pid=" + pid + ", mappingDate=" + mappingDate + ", registrationDate=" + registrationDate
				+ ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + ", preArtNumber=" + preArtNumber
				+ ", artNumber=" + artNumber + ", beneficiaryId=" + beneficiaryId + ", facilityId=" + facilityId + "]";
	}
}
