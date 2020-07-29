package gov.naco.soch.ti.dto;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.TIBenPresc} entity.
 */
public class TIBenPrescDTO implements Serializable {

    private Long id;

    @NotNull
    private Integer facilityId;

    private ZonedDateTime initiationDate;

    private Integer substitutionDrug;

    private Boolean consentTaken;

    private Integer dosage;

    private String measureOfUnit;

    private Boolean isActive;

    private Boolean isDelete;

    private Integer createdBy;

    private ZonedDateTime createdTime;

    private Integer modifiedBy;

    private ZonedDateTime modifiedTime;


    private Long beneficiaryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    public ZonedDateTime getInitiationDate() {
        return initiationDate;
    }

    public void setInitiationDate(ZonedDateTime initiationDate) {
        this.initiationDate = initiationDate;
    }

    public Integer getSubstitutionDrug() {
        return substitutionDrug;
    }

    public void setSubstitutionDrug(Integer substitutionDrug) {
        this.substitutionDrug = substitutionDrug;
    }

    public Boolean isConsentTaken() {
        return consentTaken;
    }

    public void setConsentTaken(Boolean consentTaken) {
        this.consentTaken = consentTaken;
    }

    public Integer getDosage() {
        return dosage;
    }

    public void setDosage(Integer dosage) {
        this.dosage = dosage;
    }

    public String getMeasureOfUnit() {
        return measureOfUnit;
    }

    public void setMeasureOfUnit(String measureOfUnit) {
        this.measureOfUnit = measureOfUnit;
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

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public ZonedDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(ZonedDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long tIBeneficiaryId) {
        this.beneficiaryId = tIBeneficiaryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TIBenPrescDTO tIBenPrescDTO = (TIBenPrescDTO) o;
        if (tIBenPrescDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tIBenPrescDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TIBenPrescDTO{" +
            "id=" + getId() +
            ", facilityId=" + getFacilityId() +
            ", initiationDate='" + getInitiationDate() + "'" +
            ", substitutionDrug=" + getSubstitutionDrug() +
            ", consentTaken='" + isConsentTaken() + "'" +
            ", dosage=" + getDosage() +
            ", measureOfUnit='" + getMeasureOfUnit() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", isDelete='" + isIsDelete() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", createdTime='" + getCreatedTime() + "'" +
            ", modifiedBy=" + getModifiedBy() +
            ", modifiedTime='" + getModifiedTime() + "'" +
            ", beneficiary=" + getBeneficiaryId() +
            "}";
    }
}
