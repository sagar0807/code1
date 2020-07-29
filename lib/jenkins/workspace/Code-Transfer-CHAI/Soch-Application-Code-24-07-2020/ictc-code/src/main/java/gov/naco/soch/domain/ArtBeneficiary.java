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
 * A ArtBeneficiary.
 */
@Entity
@Table(name = "art_beneficiary")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ArtBeneficiary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "art_eligibility_date")
    private LocalDate artEligibilityDate;

    @Column(name = "art_registration_date")
    private LocalDate artRegistrationDate;

    @Column(name = "art_start_date")
    private LocalDate artStartDate;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @Column(name = "lac_linked")
    private Boolean lacLinked;

    @Column(name = "linkage_institute_name")
    private String linkageInstituteName;

//    @Column(name = "registration_date")
//    private LocalDate registrationDate;

//    @Column(name = "visit_register_id")
//    private Long visitRegisterId;

    @Column(name = "art_beneficiary_status_id")
    private Long artBeneficiaryStatusId;

    @Column(name = "hiv_risk_factor_id")
    private Long hivRiskFactorId;

    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;
    
    @ManyToOne
    @JoinColumn(name = "beneficiary_id")
	private Beneficiary beneficiary;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getArtEligibilityDate() {
        return artEligibilityDate;
    }

    public ArtBeneficiary artEligibilityDate(LocalDate artEligibilityDate) {
        this.artEligibilityDate = artEligibilityDate;
        return this;
    }

    public void setArtEligibilityDate(LocalDate artEligibilityDate) {
        this.artEligibilityDate = artEligibilityDate;
    }

    public LocalDate getArtRegistrationDate() {
        return artRegistrationDate;
    }

    public ArtBeneficiary artRegistrationDate(LocalDate artRegistrationDate) {
        this.artRegistrationDate = artRegistrationDate;
        return this;
    }

    public void setArtRegistrationDate(LocalDate artRegistrationDate) {
        this.artRegistrationDate = artRegistrationDate;
    }

    public LocalDate getArtStartDate() {
        return artStartDate;
    }

    public ArtBeneficiary artStartDate(LocalDate artStartDate) {
        this.artStartDate = artStartDate;
        return this;
    }

    public void setArtStartDate(LocalDate artStartDate) {
        this.artStartDate = artStartDate;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public ArtBeneficiary isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isIsDelete() {
        return isDelete;
    }

    public ArtBeneficiary isDelete(Boolean isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Boolean isLacLinked() {
        return lacLinked;
    }

    public ArtBeneficiary lacLinked(Boolean lacLinked) {
        this.lacLinked = lacLinked;
        return this;
    }

    public void setLacLinked(Boolean lacLinked) {
        this.lacLinked = lacLinked;
    }

    public String getLinkageInstituteName() {
        return linkageInstituteName;
    }

    public ArtBeneficiary linkageInstituteName(String linkageInstituteName) {
        this.linkageInstituteName = linkageInstituteName;
        return this;
    }

    public void setLinkageInstituteName(String linkageInstituteName) {
        this.linkageInstituteName = linkageInstituteName;
    }

//    public LocalDate getRegistrationDate() {
//        return registrationDate;
//    }
//
//    public ArtBeneficiary registrationDate(LocalDate registrationDate) {
//        this.registrationDate = registrationDate;
//        return this;
//    }
//
//    public void setRegistrationDate(LocalDate registrationDate) {
//        this.registrationDate = registrationDate;
//    }

//    public Long getVisitRegisterId() {
//        return visitRegisterId;
//    }
//
//    public ArtBeneficiary visitRegisterId(Long visitRegisterId) {
//        this.visitRegisterId = visitRegisterId;
//        return this;
//    }
//
//    public void setVisitRegisterId(Long visitRegisterId) {
//        this.visitRegisterId = visitRegisterId;
//    }

    public Long getArtBeneficiaryStatusId() {
        return artBeneficiaryStatusId;
    }

    public ArtBeneficiary artBeneficiaryStatusId(Long artBeneficiaryStatusId) {
        this.artBeneficiaryStatusId = artBeneficiaryStatusId;
        return this;
    }

    public void setArtBeneficiaryStatusId(Long artBeneficiaryStatusId) {
        this.artBeneficiaryStatusId = artBeneficiaryStatusId;
    }

    public Long getHivRiskFactorId() {
        return hivRiskFactorId;
    }

    public ArtBeneficiary hivRiskFactorId(Long hivRiskFactorId) {
        this.hivRiskFactorId = hivRiskFactorId;
        return this;
    }

    public void setHivRiskFactorId(Long hivRiskFactorId) {
        this.hivRiskFactorId = hivRiskFactorId;
    }

    public Facility getFacility() {
        return facility;
    }

    public ArtBeneficiary facility(Facility facility) {
        this.facility = facility;
        return this;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
    
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArtBeneficiary artBeneficiary = (ArtBeneficiary) o;
        if (artBeneficiary.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), artBeneficiary.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "ArtBeneficiary [id=" + id + ", artEligibilityDate=" + artEligibilityDate + ", artRegistrationDate="
				+ artRegistrationDate + ", artStartDate=" + artStartDate + ", isActive=" + isActive + ", isDelete="
				+ isDelete + ", lacLinked=" + lacLinked + ", linkageInstituteName=" + linkageInstituteName
				+ ", artBeneficiaryStatusId=" + artBeneficiaryStatusId + ", hivRiskFactorId=" + hivRiskFactorId
				+ ", facility=" + facility + ", beneficiary=" + beneficiary + "]";
	}

}
