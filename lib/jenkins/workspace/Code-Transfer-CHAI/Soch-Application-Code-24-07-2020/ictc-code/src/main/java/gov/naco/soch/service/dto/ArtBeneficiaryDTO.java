package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the ArtBeneficiary entity.
 */
public class ArtBeneficiaryDTO implements Serializable {
	
    private Long id;

    private LocalDate artEligibilityDate;

    private LocalDate artRegistrationDate;

    private LocalDate artStartDate;

    private Boolean isActive;

    private Boolean isDelete;

    private Boolean lacLinked;

    private String linkageInstituteName;

    private String previousClinic;

    private LocalDate registrationDate;

    private Long visitRegisterId;

    private Long artBeneficiaryStatusId;

    private Long hivRiskFactorId;

    private Long facilityId;
    
    private Long beneficiaryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getArtEligibilityDate() {
        return artEligibilityDate;
    }

    public void setArtEligibilityDate(LocalDate artEligibilityDate) {
        this.artEligibilityDate = artEligibilityDate;
    }

    public LocalDate getArtRegistrationDate() {
        return artRegistrationDate;
    }

    public void setArtRegistrationDate(LocalDate artRegistrationDate) {
        this.artRegistrationDate = artRegistrationDate;
    }

    public LocalDate getArtStartDate() {
        return artStartDate;
    }

    public void setArtStartDate(LocalDate artStartDate) {
        this.artStartDate = artStartDate;
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

    public Boolean isLacLinked() {
        return lacLinked;
    }

    public void setLacLinked(Boolean lacLinked) {
        this.lacLinked = lacLinked;
    }

    public String getLinkageInstituteName() {
        return linkageInstituteName;
    }

    public void setLinkageInstituteName(String linkageInstituteName) {
        this.linkageInstituteName = linkageInstituteName;
    }

    public String getPreviousClinic() {
        return previousClinic;
    }

    public void setPreviousClinic(String previousClinic) {
        this.previousClinic = previousClinic;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Long getVisitRegisterId() {
        return visitRegisterId;
    }

    public void setVisitRegisterId(Long visitRegisterId) {
        this.visitRegisterId = visitRegisterId;
    }

    public Long getArtBeneficiaryStatusId() {
        return artBeneficiaryStatusId;
    }

    public void setArtBeneficiaryStatusId(Long artBeneficiaryStatusId) {
        this.artBeneficiaryStatusId = artBeneficiaryStatusId;
    }

    public Long getHivRiskFactorId() {
        return hivRiskFactorId;
    }

    public void setHivRiskFactorId(Long hivRiskFactorId) {
        this.hivRiskFactorId = hivRiskFactorId;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }
    
    public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ArtBeneficiaryDTO artBeneficiaryDTO = (ArtBeneficiaryDTO) o;
        if (artBeneficiaryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), artBeneficiaryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ArtBeneficiaryDTO{" +
            "id=" + getId() +
            ", artEligibilityDate='" + getArtEligibilityDate() + "'" +
            ", artRegistrationDate='" + getArtRegistrationDate() + "'" +
            ", artStartDate='" + getArtStartDate() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", isDelete='" + isIsDelete() + "'" +
            ", lacLinked='" + isLacLinked() + "'" +
            ", linkageInstituteName='" + getLinkageInstituteName() + "'" +
            ", previousClinic='" + getPreviousClinic() + "'" +
            ", registrationDate='" + getRegistrationDate() + "'" +
            ", visitRegisterId=" + getVisitRegisterId() +
            ", artBeneficiaryStatusId=" + getArtBeneficiaryStatusId() +
            ", hivRiskFactorId=" + getHivRiskFactorId() +
            ", facility=" + getFacilityId() +
            ", beneficiary=" + getBeneficiaryId() +
            "}";
    }
}
