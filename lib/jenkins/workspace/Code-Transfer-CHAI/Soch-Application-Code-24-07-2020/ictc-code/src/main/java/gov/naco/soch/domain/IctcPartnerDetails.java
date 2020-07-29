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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A IctcPartnerDetails.
 */
@Entity
@Table(name = "ictc_partner_details")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class IctcPartnerDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "partner_status_known")
    private Integer partnerStatusKnown;

    @Column(name = "partner_hiv_status")
    private Integer partnerHivStatus;

    @Column(name = "partner_not_tested_reason")
    private Integer partnerNotTestedReason;

    @Column(name = "partner_test_follow_up_date")
    private LocalDate partnerTestFollowUpDate;

    @Column(name = "is_partner_prev_treated_for_hiv")
    private Boolean isPartnerPrevTreatedForHiv;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name="ictc_beneficiary_id")
    private ICTCBeneficiary ictcBeneficiary;
    
    @ManyToOne
    @JoinColumn(name = "partner_art_center_id")
    private Facility partnerArtCenter;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPartnerStatusKnown() {
        return partnerStatusKnown;
    }

    public IctcPartnerDetails partnerStatusKnown(Integer partnerStatusKnown) {
        this.partnerStatusKnown = partnerStatusKnown;
        return this;
    }

    public void setPartnerStatusKnown(Integer partnerStatusKnown) {
        this.partnerStatusKnown = partnerStatusKnown;
    }

    public Integer getPartnerHivStatus() {
        return partnerHivStatus;
    }

    public IctcPartnerDetails partnerHivStatus(Integer partnerHivStatus) {
        this.partnerHivStatus = partnerHivStatus;
        return this;
    }

    public void setPartnerHivStatus(Integer partnerHivStatus) {
        this.partnerHivStatus = partnerHivStatus;
    }

    public Integer getPartnerNotTestedReason() {
        return partnerNotTestedReason;
    }

    public IctcPartnerDetails partnerNotTestedReason(Integer partnerNotTestedReason) {
        this.partnerNotTestedReason = partnerNotTestedReason;
        return this;
    }

    public void setPartnerNotTestedReason(Integer partnerNotTestedReason) {
        this.partnerNotTestedReason = partnerNotTestedReason;
    }

    public LocalDate getPartnerTestFollowUpDate() {
        return partnerTestFollowUpDate;
    }

    public IctcPartnerDetails partnerTestFollowUpDate(LocalDate partnerTestFollowUpDate) {
        this.partnerTestFollowUpDate = partnerTestFollowUpDate;
        return this;
    }

    public void setPartnerTestFollowUpDate(LocalDate partnerTestFollowUpDate) {
        this.partnerTestFollowUpDate = partnerTestFollowUpDate;
    }

    public Boolean isIsPartnerPrevTreatedForHiv() {
        return isPartnerPrevTreatedForHiv;
    }

    public IctcPartnerDetails isPartnerPrevTreatedForHiv(Boolean isPartnerPrevTreatedForHiv) {
        this.isPartnerPrevTreatedForHiv = isPartnerPrevTreatedForHiv;
        return this;
    }

    public void setIsPartnerPrevTreatedForHiv(Boolean isPartnerPrevTreatedForHiv) {
        this.isPartnerPrevTreatedForHiv = isPartnerPrevTreatedForHiv;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public IctcPartnerDetails createdDate(LocalDate createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public ICTCBeneficiary getIctcBeneficiary() {
        return ictcBeneficiary;
    }

    public IctcPartnerDetails ictcBeneficiary(ICTCBeneficiary iCTCBeneficiary) {
        this.ictcBeneficiary = iCTCBeneficiary;
        return this;
    }

    public void setIctcBeneficiary(ICTCBeneficiary iCTCBeneficiary) {
        this.ictcBeneficiary = iCTCBeneficiary;
    }
    
    
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    public Facility getPartnerArtCenter() {
		return partnerArtCenter;
	}

	public void setPartnerArtCenter(Facility partnerArtCenter) {
		this.partnerArtCenter = partnerArtCenter;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IctcPartnerDetails ictcPartnerDetails = (IctcPartnerDetails) o;
        if (ictcPartnerDetails.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ictcPartnerDetails.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
	public String toString() {
		return "IctcPartnerDetails [id=" + id + ", partnerStatusKnown=" + partnerStatusKnown + ", partnerHivStatus="
				+ partnerHivStatus + ", partnerNotTestedReason=" + partnerNotTestedReason + ", partnerTestFollowUpDate="
				+ partnerTestFollowUpDate + ", isPartnerPrevTreatedForHiv=" + isPartnerPrevTreatedForHiv
				+ ", createdDate=" + createdDate + ", ictcBeneficiary=" + ictcBeneficiary + ", partnerArtCenter="
				+ partnerArtCenter + "]";
	}
}
