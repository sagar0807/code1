package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.Referrals} entity.
 */
public class ReferralsDTO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private String sourceFacilityType;

    private String referralStatus;

    private String hivStatus;

    private String category;

    private String remarks;

    private LocalDate initiationDate;

    private String destinationFacilityType;

    private String dsrcCode;

    private String tiCode;

    private String artCode;

    private String ostCode;

    private String pidCode;

    private LocalDate reportingDate;

    private Integer createdBy;

    private LocalDate createdTime;

    private Integer modifiedBy;

    private LocalDate modifiedTime;

    private Boolean isActive;

    private Boolean isDeleted;


    private Long beneficiaryId;

    private Long sourceFacilityId;

    private Long destinationFacilityId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceFacilityType() {
        return sourceFacilityType;
    }

    public void setSourceFacilityType(String sourceFacilityType) {
        this.sourceFacilityType = sourceFacilityType;
    }

    public String getReferralStatus() {
        return referralStatus;
    }

    public void setReferralStatus(String referralStatus) {
        this.referralStatus = referralStatus;
    }

    public String getHivStatus() {
        return hivStatus;
    }

    public void setHivStatus(String hivStatus) {
        this.hivStatus = hivStatus;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDate getInitiationDate() {
        return initiationDate;
    }

    public void setInitiationDate(LocalDate initiationDate) {
        this.initiationDate = initiationDate;
    }

    public String getDestinationFacilityType() {
        return destinationFacilityType;
    }

    public void setDestinationFacilityType(String destinationFacilityType) {
        this.destinationFacilityType = destinationFacilityType;
    }

    public String getDsrcCode() {
        return dsrcCode;
    }

    public void setDsrcCode(String dsrcCode) {
        this.dsrcCode = dsrcCode;
    }

    public String getTiCode() {
        return tiCode;
    }

    public void setTiCode(String tiCode) {
        this.tiCode = tiCode;
    }

    public String getArtCode() {
        return artCode;
    }

    public void setArtCode(String artCode) {
        this.artCode = artCode;
    }

    public String getOstCode() {
        return ostCode;
    }

    public void setOstCode(String ostCode) {
        this.ostCode = ostCode;
    }

    public String getPidCode() {
        return pidCode;
    }

    public void setPidCode(String pidCode) {
        this.pidCode = pidCode;
    }

    public LocalDate getReportingDate() {
        return reportingDate;
    }

    public void setReportingDate(LocalDate reportingDate) {
        this.reportingDate = reportingDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDate createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDate getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDate modifiedTime) {
        this.modifiedTime = modifiedTime;
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

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public Long getSourceFacilityId() {
        return sourceFacilityId;
    }

    public void setSourceFacilityId(Long facilityId) {
        this.sourceFacilityId = facilityId;
    }

    public Long getDestinationFacilityId() {
        return destinationFacilityId;
    }

    public void setDestinationFacilityId(Long facilityId) {
        this.destinationFacilityId = facilityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReferralsDTO referralsDTO = (ReferralsDTO) o;
        if (referralsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), referralsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ReferralsDTO{" +
            "id=" + getId() +
            ", sourceFacilityType='" + getSourceFacilityType() + "'" +
            ", referralStatus='" + getReferralStatus() + "'" +
            ", hivStatus='" + getHivStatus() + "'" +
            ", category='" + getCategory() + "'" +
            ", remarks='" + getRemarks() + "'" +
            ", initiationDate='" + getInitiationDate() + "'" +
            ", destinationFacilityType='" + getDestinationFacilityType() + "'" +
            ", dsrcCode='" + getDsrcCode() + "'" +
            ", tiCode='" + getTiCode() + "'" +
            ", artCode='" + getArtCode() + "'" +
            ", ostCode='" + getOstCode() + "'" +
            ", pidCode='" + getPidCode() + "'" +
            ", reportingDate='" + getReportingDate() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", createdTime='" + getCreatedTime() + "'" +
            ", modifiedBy=" + getModifiedBy() +
            ", modifiedTime='" + getModifiedTime() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", isDeleted='" + isIsDeleted() + "'" +
            ", beneficiaryId=" + getBeneficiaryId() +
            ", sourceFacilityId=" + getSourceFacilityId() +
            ", destinationFacilityId=" + getDestinationFacilityId() +
            "}";
    }
}
