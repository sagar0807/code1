package gov.naco.soch.ti.dto;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.TIBenReferral} entity.
 */
public class TIBenReferralDTO implements Serializable {

    private Long id;

    private Integer refferalRequestorId;

    private ZonedDateTime timeOfAppointment;

    private Integer referralFacility;

    private Integer referredFacility;

    private String transferTo;

    private String transferFrom;

    private LocalDate transferDate;

    private String transferStatus;

    private String referralStatus;

    private LocalDate dateOfReferral;

    private String hivStatus;

    private Integer isCompleted;

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

    public Integer getRefferalRequestorId() {
        return refferalRequestorId;
    }

    public void setRefferalRequestorId(Integer refferalRequestorId) {
        this.refferalRequestorId = refferalRequestorId;
    }

    public ZonedDateTime getTimeOfAppointment() {
        return timeOfAppointment;
    }

    public void setTimeOfAppointment(ZonedDateTime timeOfAppointment) {
        this.timeOfAppointment = timeOfAppointment;
    }

    public Integer getReferralFacility() {
        return referralFacility;
    }

    public void setReferralFacility(Integer referralFacility) {
        this.referralFacility = referralFacility;
    }

    public Integer getReferredFacility() {
        return referredFacility;
    }

    public void setReferredFacility(Integer referredFacility) {
        this.referredFacility = referredFacility;
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

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
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

    public String getHivStatus() {
        return hivStatus;
    }

    public void setHivStatus(String hivStatus) {
        this.hivStatus = hivStatus;
    }

    public Integer getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Integer isCompleted) {
        this.isCompleted = isCompleted;
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

        TIBenReferralDTO tIBenReferralDTO = (TIBenReferralDTO) o;
        if (tIBenReferralDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tIBenReferralDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TIBenReferralDTO{" +
            "id=" + getId() +
            ", refferalRequestorId=" + getRefferalRequestorId() +
            ", timeOfAppointment='" + getTimeOfAppointment() + "'" +
            ", referralFacility=" + getReferralFacility() +
            ", referredFacility=" + getReferredFacility() +
            ", transferTo='" + getTransferTo() + "'" +
            ", transferFrom='" + getTransferFrom() + "'" +
            ", transferDate='" + getTransferDate() + "'" +
            ", transferStatus='" + getTransferStatus() + "'" +
            ", referralStatus='" + getReferralStatus() + "'" +
            ", dateOfReferral='" + getDateOfReferral() + "'" +
            ", hivStatus='" + getHivStatus() + "'" +
            ", isCompleted=" + getIsCompleted() +
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
