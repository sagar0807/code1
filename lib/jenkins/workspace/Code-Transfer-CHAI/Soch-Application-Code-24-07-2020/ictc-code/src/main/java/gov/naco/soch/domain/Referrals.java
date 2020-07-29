package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A Referrals.
 */
@Entity
@Table(name = "referrals")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Referrals implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "source_facility_type")
    private String sourceFacilityType;

    @Column(name = "referral_status")
    private String referralStatus;

    @Column(name = "hiv_status")
    private String hivStatus;

    @Column(name = "category")
    private String category;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "initiation_date")
    private LocalDate initiationDate;

    @Column(name = "destination_facility_type")
    private String destinationFacilityType;

    @Column(name = "dsrc_code")
    private String dsrcCode;

    @Column(name = "ti_code")
    private String tiCode;

    @Column(name = "art_code")
    private String artCode;

    @Column(name = "ost_code")
    private String ostCode;

    @Column(name = "pid_code")
    private String pidCode;

    @Column(name = "reporting_date")
    private LocalDate reportingDate;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_time")
    private LocalDate createdTime;

    @Column(name = "modified_by")
    private Integer modifiedBy;

    @Column(name = "modified_time")
    private LocalDate modifiedTime;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @NotNull
    @JsonIgnoreProperties("referrals")
    @JoinColumn(name="beneficiary_id")
    private Beneficiary beneficiary;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @NotNull
    @JsonIgnoreProperties("referrals")
    private Facility sourceFacility;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @NotNull
    @JsonIgnoreProperties("referrals")
    private Facility destinationFacility;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceFacilityType() {
        return sourceFacilityType;
    }

    public Referrals sourceFacilityType(String sourceFacilityType) {
        this.sourceFacilityType = sourceFacilityType;
        return this;
    }

    public void setSourceFacilityType(String sourceFacilityType) {
        this.sourceFacilityType = sourceFacilityType;
    }

    public String getReferralStatus() {
        return referralStatus;
    }

    public Referrals referralStatus(String referralStatus) {
        this.referralStatus = referralStatus;
        return this;
    }

    public void setReferralStatus(String referralStatus) {
        this.referralStatus = referralStatus;
    }

    public String getHivStatus() {
        return hivStatus;
    }

    public Referrals hivStatus(String hivStatus) {
        this.hivStatus = hivStatus;
        return this;
    }

    public void setHivStatus(String hivStatus) {
        this.hivStatus = hivStatus;
    }

    public String getCategory() {
        return category;
    }

    public Referrals category(String category) {
        this.category = category;
        return this;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRemarks() {
        return remarks;
    }

    public Referrals remarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDate getInitiationDate() {
        return initiationDate;
    }

    public Referrals initiationDate(LocalDate initiationDate) {
        this.initiationDate = initiationDate;
        return this;
    }

    public void setInitiationDate(LocalDate initiationDate) {
        this.initiationDate = initiationDate;
    }

    public String getDestinationFacilityType() {
        return destinationFacilityType;
    }

    public Referrals destinationFacilityType(String destinationFacilityType) {
        this.destinationFacilityType = destinationFacilityType;
        return this;
    }

    public void setDestinationFacilityType(String destinationFacilityType) {
        this.destinationFacilityType = destinationFacilityType;
    }

    public String getDsrcCode() {
        return dsrcCode;
    }

    public Referrals dsrcCode(String dsrcCode) {
        this.dsrcCode = dsrcCode;
        return this;
    }

    public void setDsrcCode(String dsrcCode) {
        this.dsrcCode = dsrcCode;
    }

    public String getTiCode() {
        return tiCode;
    }

    public Referrals tiCode(String tiCode) {
        this.tiCode = tiCode;
        return this;
    }

    public void setTiCode(String tiCode) {
        this.tiCode = tiCode;
    }

    public String getArtCode() {
        return artCode;
    }

    public Referrals artCode(String artCode) {
        this.artCode = artCode;
        return this;
    }

    public void setArtCode(String artCode) {
        this.artCode = artCode;
    }

    public String getOstCode() {
        return ostCode;
    }

    public Referrals ostCode(String ostCode) {
        this.ostCode = ostCode;
        return this;
    }

    public void setOstCode(String ostCode) {
        this.ostCode = ostCode;
    }

    public String getPidCode() {
        return pidCode;
    }

    public Referrals pidCode(String pidCode) {
        this.pidCode = pidCode;
        return this;
    }

    public void setPidCode(String pidCode) {
        this.pidCode = pidCode;
    }

    public LocalDate getReportingDate() {
        return reportingDate;
    }

    public Referrals reportingDate(LocalDate reportingDate) {
        this.reportingDate = reportingDate;
        return this;
    }

    public void setReportingDate(LocalDate reportingDate) {
        this.reportingDate = reportingDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public Referrals createdBy(Integer createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedTime() {
        return createdTime;
    }

    public Referrals createdTime(LocalDate createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public void setCreatedTime(LocalDate createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public Referrals modifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDate getModifiedTime() {
        return modifiedTime;
    }

    public Referrals modifiedTime(LocalDate modifiedTime) {
        this.modifiedTime = modifiedTime;
        return this;
    }

    public void setModifiedTime(LocalDate modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public Referrals isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isIsDeleted() {
        return isDeleted;
    }

    public Referrals isDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public Referrals beneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
        return this;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    public Facility getSourceFacility() {
        return sourceFacility;
    }

    public Referrals sourceFacility(Facility facility) {
        this.sourceFacility = facility;
        return this;
    }

    public void setSourceFacility(Facility facility) {
        this.sourceFacility = facility;
    }

    public Facility getDestinationFacility() {
        return destinationFacility;
    }

    public Referrals destinationFacility(Facility facility) {
        this.destinationFacility = facility;
        return this;
    }

    public void setDestinationFacility(Facility facility) {
        this.destinationFacility = facility;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Referrals)) {
            return false;
        }
        return id != null && id.equals(((Referrals) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Referrals{" +
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
            "}";
    }
}
