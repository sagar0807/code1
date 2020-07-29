package gov.naco.soch.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A BeneficiaryFamilyDetails.
 */
@Entity
@Table(name = "beneficiary_family_details")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BeneficiaryFamilyDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "family_uid")
    private String familyUid;

    @Column(name = "relationship_id")
    private Integer relationshipId;

    @Column(name = "beneficiary_id")
    private Long beneficiaryId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender_id")
    private Integer genderId;

    @Column(name = "age_years")
    private Integer ageYears;

    @Column(name = "age_months")
    private Integer ageMonths;

    @Column(name = "is_alive")
    private Boolean isAlive;

    @Column(name = "hiv_status_id")
    private Integer hivStatusId;

    @Column(name = "on_art")
    private Boolean onArt;

    @Column(name = "is_beneficiary")
    private Boolean isBeneficiary;

    @Column(name = "member_beneficiary_id")
    private Long memberBeneficiaryId;

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

    @Column(name = "is_delete")
    private Boolean isDelete;

    @OneToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(unique = true, name="member_beneficiary_id", insertable=false, updatable=false)
    private Beneficiary memberBeneficiary;
    
    @Transient
    private List<BeneficiaryReferral> referrals;
//
//    @OneToOne(optional = false)
//    @NotNull
//    @JoinColumn(unique = true)
//    private Beneficiary beneficiary;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFamilyUid() {
        return familyUid;
    }

    public BeneficiaryFamilyDetails familyUid(String familyUid) {
        this.familyUid = familyUid;
        return this;
    }

    public void setFamilyUid(String familyUid) {
        this.familyUid = familyUid;
    }

    public Integer getRelationshipId() {
        return relationshipId;
    }

    public BeneficiaryFamilyDetails relationshipId(Integer relationshipId) {
        this.relationshipId = relationshipId;
        return this;
    }

    public void setRelationshipId(Integer relationshipId) {
        this.relationshipId = relationshipId;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public BeneficiaryFamilyDetails beneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
        return this;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public String getFirstName() {
        return firstName;
    }

    public BeneficiaryFamilyDetails firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public BeneficiaryFamilyDetails middleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public BeneficiaryFamilyDetails lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getGenderId() {
        return genderId;
    }

    public BeneficiaryFamilyDetails genderId(Integer genderId) {
        this.genderId = genderId;
        return this;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public Integer getAgeYears() {
        return ageYears;
    }

    public BeneficiaryFamilyDetails ageYears(Integer ageYears) {
        this.ageYears = ageYears;
        return this;
    }

    public void setAgeYears(Integer ageYears) {
        this.ageYears = ageYears;
    }

    public Integer getAgeMonths() {
        return ageMonths;
    }

    public BeneficiaryFamilyDetails ageMonths(Integer ageMonths) {
        this.ageMonths = ageMonths;
        return this;
    }

    public void setAgeMonths(Integer ageMonths) {
        this.ageMonths = ageMonths;
    }

    public Boolean isIsAlive() {
        return isAlive;
    }

    public BeneficiaryFamilyDetails isAlive(Boolean isAlive) {
        this.isAlive = isAlive;
        return this;
    }

    public void setIsAlive(Boolean isAlive) {
        this.isAlive = isAlive;
    }

    public Integer getHivStatusId() {
        return hivStatusId;
    }

    public BeneficiaryFamilyDetails hivStatusId(Integer hivStatusId) {
        this.hivStatusId = hivStatusId;
        return this;
    }

    public void setHivStatusId(Integer hivStatusId) {
        this.hivStatusId = hivStatusId;
    }

    public Boolean isOnArt() {
        return onArt;
    }

    public BeneficiaryFamilyDetails onArt(Boolean onArt) {
        this.onArt = onArt;
        return this;
    }

    public void setOnArt(Boolean onArt) {
        this.onArt = onArt;
    }

    public BeneficiaryFamilyDetails isBeneficiary(Boolean isBeneficiary) {
        this.isBeneficiary = isBeneficiary;
        return this;
    }
    
    public Boolean getIsBeneficiary() {
		return isBeneficiary;
	}

	public void setIsBeneficiary(Boolean isBeneficiary) {
		this.isBeneficiary = isBeneficiary;
	}

	public Long getMemberBeneficiaryId() {
        return memberBeneficiaryId;
    }

    public BeneficiaryFamilyDetails memberBeneficiaryId(Long memberBeneficiaryId) {
        this.memberBeneficiaryId = memberBeneficiaryId;
        return this;
    }

    public void setMemberBeneficiaryId(Long memberBeneficiaryId) {
        this.memberBeneficiaryId = memberBeneficiaryId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public BeneficiaryFamilyDetails createdBy(Integer createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedTime() {
        return createdTime;
    }

    public BeneficiaryFamilyDetails createdTime(LocalDate createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public void setCreatedTime(LocalDate createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public BeneficiaryFamilyDetails modifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDate getModifiedTime() {
        return modifiedTime;
    }

    public BeneficiaryFamilyDetails modifiedTime(LocalDate modifiedTime) {
        this.modifiedTime = modifiedTime;
        return this;
    }

    public void setModifiedTime(LocalDate modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Boolean isIsActive() {
        return isActive;
    }

    public BeneficiaryFamilyDetails isActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean isIsDelete() {
        return isDelete;
    }

    public BeneficiaryFamilyDetails isDelete(Boolean isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Beneficiary getMemberBeneficiary() {
        return memberBeneficiary;
    }

    public BeneficiaryFamilyDetails memberBeneficiary(Beneficiary beneficiary) {
        this.memberBeneficiary = beneficiary;
        return this;
    }

    public void setMemberBeneficiary(Beneficiary beneficiary) {
        this.memberBeneficiary = beneficiary;
    }
    
    
    
    

//    public Beneficiary getBeneficiary() {
//        return beneficiary;
//    }
//
//    public BeneficiaryFamilyDetails beneficiary(Beneficiary beneficiary) {
//        this.beneficiary = beneficiary;
//        return this;
//    }
//
//    public void setBeneficiary(Beneficiary beneficiary) {
//        this.beneficiary = beneficiary;
//    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    public List<BeneficiaryReferral> getReferrals() {
		return referrals;
	}

	public void setReferrals(List<BeneficiaryReferral> referrals) {
		this.referrals = referrals;
	}
	
    public BeneficiaryFamilyDetails referrals(List<BeneficiaryReferral> referrals) {
    	this.referrals = referrals;
        return this;
    }

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BeneficiaryFamilyDetails)) {
            return false;
        }
        return id != null && id.equals(((BeneficiaryFamilyDetails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "BeneficiaryFamilyDetails{" +
            "id=" + getId() +
            ", familyUid='" + getFamilyUid() + "'" +
            ", relationshipId=" + getRelationshipId() +
            ", beneficiaryId=" + getBeneficiaryId() +
            ", firstName='" + getFirstName() + "'" +
            ", middleName='" + getMiddleName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", genderId=" + getGenderId() +
            ", ageYears=" + getAgeYears() +
            ", ageMonths=" + getAgeMonths() +
            ", isAlive='" + isIsAlive() + "'" +
            ", hivStatusId=" + getHivStatusId() +
            ", onArt='" + isOnArt() + "'" +
            ", isBeneficiary='" + getIsBeneficiary() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", createdTime='" + getCreatedTime() + "'" +
            ", modifiedBy=" + getModifiedBy() +
            ", modifiedTime='" + getModifiedTime() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", isDelete='" + isIsDelete() + "'" +
            "}";
    }
}
