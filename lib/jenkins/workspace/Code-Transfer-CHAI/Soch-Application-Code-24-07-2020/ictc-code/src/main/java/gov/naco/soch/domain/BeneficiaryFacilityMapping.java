package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A BeneficiaryFacilityMapping.
 */
@Entity
@Table(name = "beneficiary_facility_mapping")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BeneficiaryFacilityMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @Column(name = "pid")
    private String pid;

    @Column(name = "mapping_date")
    private LocalDate mappingDate;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "created_time")
    private LocalDate createdTime;

    @Column(name = "modified_time")
    private LocalDate modifiedTime;
    
    @Column(name = "pre_art_number")
	private String preArtNumber;

	@Column(name = "art_number")
	private String artNumber;

	@ManyToOne
	@JoinColumn(name = "beneficiary_id")
	private Beneficiary beneficiary;

	@ManyToOne
	@JoinColumn(name = "facility_id")
	private Facility facility;

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

	// jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public BeneficiaryFacilityMapping isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isIsDelete() {
        return isDelete;
    }

    public BeneficiaryFacilityMapping isDelete(Boolean isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getPid() {
        return pid;
    }

    public BeneficiaryFacilityMapping pid(String pid) {
        this.pid = pid;
        return this;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public LocalDate getMappingDate() {
        return mappingDate;
    }

    public BeneficiaryFacilityMapping mappingDate(LocalDate mappingDate) {
        this.mappingDate = mappingDate;
        return this;
    }

    public void setMappingDate(LocalDate mappingDate) {
        this.mappingDate = mappingDate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public BeneficiaryFacilityMapping registrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getCreatedTime() {
        return createdTime;
    }

    public BeneficiaryFacilityMapping createdTime(LocalDate createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public void setCreatedTime(LocalDate createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDate getModifiedTime() {
        return modifiedTime;
    }

    public BeneficiaryFacilityMapping modifiedTime(LocalDate modifiedTime) {
        this.modifiedTime = modifiedTime;
        return this;
    }

    public void setModifiedTime(LocalDate modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public BeneficiaryFacilityMapping beneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
        return this;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    public Facility getFacility() {
        return facility;
    }

    public BeneficiaryFacilityMapping facility(Facility facility) {
        this.facility = facility;
        return this;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BeneficiaryFacilityMapping beneficiaryFacilityMapping = (BeneficiaryFacilityMapping) o;
        if (beneficiaryFacilityMapping.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), beneficiaryFacilityMapping.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
	public String toString() {
		return "BeneficiaryFacilityMapping [id=" + id + ", isActive=" + isActive + ", isDelete=" + isDelete + ", pid="
				+ pid + ", mappingDate=" + mappingDate + ", registrationDate=" + registrationDate + ", createdTime="
				+ createdTime + ", modifiedTime=" + modifiedTime + ", preArtNumber=" + preArtNumber + ", artNumber="
				+ artNumber + ", beneficiary=" + beneficiary + ", facility=" + facility + "]";
	}
}
