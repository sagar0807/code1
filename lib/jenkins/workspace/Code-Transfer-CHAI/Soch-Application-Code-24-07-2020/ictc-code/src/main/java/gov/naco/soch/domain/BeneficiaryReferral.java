package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * A BeneficiaryReferral.
 */
@Entity
@Table(name = "beneficiary_referral")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BeneficiaryReferral implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
//    @Column(name = "date_of_hiv_test")
//    private LocalDate dateOfHivTest;
    
    @Column(name = "date_of_visit")
    private LocalDate dateOfVisit;

//    @Column(name = "hiv_status")
//    private String hivStatus;
    
    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_delete")
    private Boolean isDelete;
    
    @Column(name = "refer_date")
    private LocalDate referDate;
    
	@Column(name="referral_type")
	private String referralType;
    
//	@Column(name = "type_of_hiv")
//	private String typeOfHiv;
	
	@Column(name="accepted_date")
	private LocalDate acceptedDate;
	
	@Column(name = "declined_date")
	private LocalDate declinedDate;
    
	@Column(name = "referral_reason")
	private String referralReason;
	
	@Column(name = "referred_by")
	private Integer referredBy;

    @Column(name = "referral_status_id")
    private Integer referralStatusId;

    @Column(name = "ti_beneficiary_id")
    private Long tiBeneficiaryId;

    @Column(name = "ti_ben_scr_id")
    private Long tiBenScrId;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_time")
    private LocalDate createdTime;

    @Column(name = "modified_by")
    private Integer modifiedBy;
    
    @Column(name = "referral_type_id")
    private Integer referralTypeId;

    @Column(name = "modified_time")
    private LocalDate modifiedTime;
    
    @ManyToOne
    @JoinColumn(name = "beneficiary_id")
    private Beneficiary beneficiary;
    
    @ManyToOne
    @JoinColumn(name = "refered_from")
    private Facility referedFrom;
    
    @ManyToOne
    @JoinColumn(name = "refered_to")
    private Facility referedTo;
    
    @Transient
    private ICTCBeneficiary ictcBeneficiary;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public LocalDate getDateOfHivTest() {
//		return dateOfHivTest;
//	}
//
//	public void setDateOfHivTest(LocalDate dateOfHivTest) {
//		this.dateOfHivTest = dateOfHivTest;
//	}

	public LocalDate getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(LocalDate dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

//	public String getHivStatus() {
//		return hivStatus;
//	}
//
//	public void setHivStatus(String hivStatus) {
//		this.hivStatus = hivStatus;
//	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public LocalDate getReferDate() {
		return referDate;
	}

	public void setReferDate(LocalDate referDate) {
		this.referDate = referDate;
	}

	public String getReferralType() {
		return referralType;
	}

	public void setReferralType(String referralType) {
		this.referralType = referralType;
	}

//	public String getTypeOfHiv() {
//		return typeOfHiv;
//	}
//
//	public void setTypeOfHiv(String typeOfHiv) {
//		this.typeOfHiv = typeOfHiv;
//	}

	public LocalDate getAcceptedDate() {
		return acceptedDate;
	}

	public void setAcceptedDate(LocalDate acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

	public LocalDate getDeclinedDate() {
		return declinedDate;
	}

	public void setDeclinedDate(LocalDate declinedDate) {
		this.declinedDate = declinedDate;
	}

	public String getReferralReason() {
		return referralReason;
	}

	public void setReferralReason(String referralReason) {
		this.referralReason = referralReason;
	}

	public Integer getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(Integer referredBy) {
		this.referredBy = referredBy;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Facility getReferedFrom() {
		return referedFrom;
	}

	public void setReferedFrom(Facility referedFrom) {
		this.referedFrom = referedFrom;
	}

	public Facility getReferedTo() {
		return referedTo;
	}

	public void setReferedTo(Facility referedTo) {
		this.referedTo = referedTo;
	}

	public Integer getReferralStatusId() {
		return referralStatusId;
	}

	public void setReferralStatusId(Integer referralStatusId) {
		this.referralStatusId = referralStatusId;
	}

	public Long getTiBeneficiaryId() {
		return tiBeneficiaryId;
	}

	public void setTiBeneficiaryId(Long tiBeneficiaryId) {
		this.tiBeneficiaryId = tiBeneficiaryId;
	}

	public Long getTiBenScrId() {
		return tiBenScrId;
	}

	public void setTiBenScrId(Long tiBenScrId) {
		this.tiBenScrId = tiBenScrId;
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
	
	public Integer getReferralTypeId() {
		return referralTypeId;
	}

	public void setReferralTypeId(Integer referralTypeId) {
		this.referralTypeId = referralTypeId;
	}
	

	public ICTCBeneficiary getIctcBeneficiary() {
		return ictcBeneficiary;
	}

	public void setIctcBeneficiary(ICTCBeneficiary ictcBeneficiary) {
		this.ictcBeneficiary = ictcBeneficiary;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BeneficiaryReferral)) {
            return false;
        }
        return id != null && id.equals(((BeneficiaryReferral) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

	@Override
	public String toString() {
		return "BeneficiaryReferral [id=" + id + ", dateOfVisit=" + dateOfVisit + ", isActive=" + isActive
				+ ", isDelete=" + isDelete + ", referDate=" + referDate + ", referralType=" + referralType
				+ ", acceptedDate=" + acceptedDate + ", declinedDate=" + declinedDate + ", referralReason="
				+ referralReason + ", referredBy=" + referredBy + ", referralStatusId=" + referralStatusId
				+ ", tiBeneficiaryId=" + tiBeneficiaryId + ", tiBenScrId=" + tiBenScrId + ", createdBy=" + createdBy
				+ ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy + ", referralTypeId=" + referralTypeId
				+ ", modifiedTime=" + modifiedTime + ", beneficiary=" + beneficiary + ", referedFrom=" + referedFrom
				+ ", referedTo=" + referedTo + ", ictcBeneficiary=" + ictcBeneficiary + "]";
	}

}
