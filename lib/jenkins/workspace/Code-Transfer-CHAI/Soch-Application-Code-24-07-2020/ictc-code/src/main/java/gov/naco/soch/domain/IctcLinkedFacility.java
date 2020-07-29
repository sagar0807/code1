package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A IctcLinkedFacility.
 */
@Entity
@Table(name = "ictc_linked_facility")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class IctcLinkedFacility implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 99)
    @Column(name = "facility_name", length = 99)
    private String facilityName;

    @Column(name = "linked_facility_id")
    private Long linkedFacilityId;

    @Column(name = "facility_id")
    private Long facilityId;

    @Size(max = 99)
    @Column(name = "facility_type", length = 99)
    private String facilityType;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "status")
    private String status;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_time")
    private LocalDate createdTime;

    @Column(name = "modified_by")
    private Long modifiedBy;

    @Column(name = "modified_time")
    private LocalDate modifiedTime;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public IctcLinkedFacility facilityName(String facilityName) {
        this.facilityName = facilityName;
        return this;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public Long getLinkedFacilityId() {
        return linkedFacilityId;
    }

    public IctcLinkedFacility linkedFacilityId(Long linkedFacilityId) {
        this.linkedFacilityId = linkedFacilityId;
        return this;
    }

    public void setLinkedFacilityId(Long linkedFacilityId) {
        this.linkedFacilityId = linkedFacilityId;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public IctcLinkedFacility facilityId(Long facilityId) {
        this.facilityId = facilityId;
        return this;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public IctcLinkedFacility facilityType(String facilityType) {
        this.facilityType = facilityType;
        return this;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public IctcLinkedFacility isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isIsDeleted() {
        return isDeleted;
    }

    public IctcLinkedFacility isDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getStatus() {
        return status;
    }

    public IctcLinkedFacility status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public IctcLinkedFacility createdBy(Long createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedTime() {
        return createdTime;
    }

    public IctcLinkedFacility createdTime(LocalDate createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public void setCreatedTime(LocalDate createdTime) {
        this.createdTime = createdTime;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public IctcLinkedFacility modifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDate getModifiedTime() {
        return modifiedTime;
    }

    public IctcLinkedFacility modifiedTime(LocalDate modifiedTime) {
        this.modifiedTime = modifiedTime;
        return this;
    }

    public void setModifiedTime(LocalDate modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IctcLinkedFacility)) {
            return false;
        }
        return id != null && id.equals(((IctcLinkedFacility) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "IctcLinkedFacility{" +
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
