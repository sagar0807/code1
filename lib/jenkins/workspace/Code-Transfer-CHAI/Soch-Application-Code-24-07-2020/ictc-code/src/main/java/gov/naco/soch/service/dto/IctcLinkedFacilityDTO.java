package gov.naco.soch.service.dto;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.IctcLinkedFacility} entity.
 */
public class IctcLinkedFacilityDTO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private Long id;

    @Size(max = 99)
    private String facilityName;

    private Long linkedFacilityId;

    private Long facilityId;

    @Size(max = 99)
    private String facilityType;

    private Boolean isActive;

    private Boolean isDeleted;

    private String status;

    private Long createdBy;

    private LocalDate createdTime;

    private Long modifiedBy;

    private LocalDate modifiedTime;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public Long getLinkedFacilityId() {
        return linkedFacilityId;
    }

    public void setLinkedFacilityId(Long linkedFacilityId) {
        this.linkedFacilityId = linkedFacilityId;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDate createdTime) {
        this.createdTime = createdTime;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDate getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDate modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IctcLinkedFacilityDTO ictcLinkedFacilityDTO = (IctcLinkedFacilityDTO) o;
        if (ictcLinkedFacilityDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ictcLinkedFacilityDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "IctcLinkedFacilityDTO{" +
            "id=" + getId() +
            ", facilityName='" + getFacilityName() + "'" +
            ", linkedFacilityId=" + getLinkedFacilityId() +
            ", facilityId=" + getFacilityId() +
            ", facilityType='" + getFacilityType() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", isDeleted='" + isIsDeleted() + "'" +
            ", status='" + getStatus() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", createdTime='" + getCreatedTime() + "'" +
            ", modifiedBy=" + getModifiedBy() +
            ", modifiedTime='" + getModifiedTime() + "'" +
            "}";
    }
}
