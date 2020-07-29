package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.BeneficiaryFamilyDetails} entity.
 */
public class BeneficiaryFamilyDetailsDTO implements Serializable {
    
    private Long id;

    private String familyUid;

    private Integer relationshipId;

    private Long beneficiaryId;

    private String firstName;

    private String middleName;

    private String lastName;

    private Integer genderId;

    private Integer ageYears;

    private Integer ageMonths;

    private Boolean isAlive;

    private Integer hivStatusId;

    private Boolean onArt;

    private Boolean isBeneficiary;

    private Long memberBeneficiaryId;

    private Integer createdBy;

    private LocalDate createdTime;

    private Integer modifiedBy;

    private LocalDate modifiedTime;

    private Boolean isActive;

    private Boolean isDelete;
    

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFamilyUid() {
        return familyUid;
    }

    public void setFamilyUid(String familyUid) {
        this.familyUid = familyUid;
    }

    public Integer getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(Integer relationshipId) {
        this.relationshipId = relationshipId;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public Integer getAgeYears() {
        return ageYears;
    }

    public void setAgeYears(Integer ageYears) {
        this.ageYears = ageYears;
    }

    public Integer getAgeMonths() {
        return ageMonths;
    }

    public void setAgeMonths(Integer ageMonths) {
        this.ageMonths = ageMonths;
    }

    public Boolean isIsAlive() {
        return isAlive;
    }

    public void setIsAlive(Boolean isAlive) {
        this.isAlive = isAlive;
    }

    public Integer getHivStatusId() {
        return hivStatusId;
    }

    public void setHivStatusId(Integer hivStatusId) {
        this.hivStatusId = hivStatusId;
    }

    public Boolean isOnArt() {
        return onArt;
    }

    public void setOnArt(Boolean onArt) {
        this.onArt = onArt;
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

    public void setMemberBeneficiaryId(Long memberBeneficiaryId) {
        this.memberBeneficiaryId = memberBeneficiaryId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BeneficiaryFamilyDetailsDTO beneficiaryFamilyDetailsDTO = (BeneficiaryFamilyDetailsDTO) o;
        if (beneficiaryFamilyDetailsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), beneficiaryFamilyDetailsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BeneficiaryFamilyDetailsDTO{" +
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
            ", memberBeneficiaryId=" + getMemberBeneficiaryId() +
            ", createdBy=" + getCreatedBy() +
            ", createdTime='" + getCreatedTime() + "'" +
            ", modifiedBy=" + getModifiedBy() +
            ", modifiedTime='" + getModifiedTime() + "'" +
            ", isActive='" + isIsActive() + "'" +
            ", isDelete='" + isIsDelete() + "'" +
            "}";
    }
}
