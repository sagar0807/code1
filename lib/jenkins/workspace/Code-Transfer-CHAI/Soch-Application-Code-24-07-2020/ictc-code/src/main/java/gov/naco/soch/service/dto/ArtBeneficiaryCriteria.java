package gov.naco.soch.service.dto;

import java.io.Serializable;

import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;



/**
 * Criteria class for the ArtBeneficiary entity. This class is used in ArtBeneficiaryResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /art-beneficiaries?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ArtBeneficiaryCriteria implements Serializable {
    private static final long serialVersionUID = 1L;


    private LongFilter id;

    private LocalDateFilter artEligibilityDate;

    private LocalDateFilter artRegistrationDate;

    private LocalDateFilter artStartDate;

    private BooleanFilter isActive;

    private BooleanFilter isDelete;

    private BooleanFilter lacLinked;

    private StringFilter linkageInstituteName;

    private StringFilter previousClinic;

    private LocalDateFilter registrationDate;

    private LongFilter visitRegisterId;

    private LongFilter artBeneficiaryStatusId;

    private LongFilter hivRiskFactorId;

    private LongFilter facilityId;
    
    private LongFilter beneficiaryId;
    
    private StringFilter firstName;
    
    private StringFilter lastName;
    
    private StringFilter middleName;
    
    private StringFilter mobileNumber;
    
    private StringFilter artCentreCode;
    
    private StringFilter artNumber;
    
    private StringFilter preArtNumber;

    public ArtBeneficiaryCriteria() {
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public LocalDateFilter getArtEligibilityDate() {
        return artEligibilityDate;
    }

    public void setArtEligibilityDate(LocalDateFilter artEligibilityDate) {
        this.artEligibilityDate = artEligibilityDate;
    }

    public LocalDateFilter getArtRegistrationDate() {
        return artRegistrationDate;
    }

    public void setArtRegistrationDate(LocalDateFilter artRegistrationDate) {
        this.artRegistrationDate = artRegistrationDate;
    }

    public LocalDateFilter getArtStartDate() {
        return artStartDate;
    }

    public void setArtStartDate(LocalDateFilter artStartDate) {
        this.artStartDate = artStartDate;
    }

    public BooleanFilter getIsActive() {
        return isActive;
    }

    public void setIsActive(BooleanFilter isActive) {
        this.isActive = isActive;
    }

    public BooleanFilter getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(BooleanFilter isDelete) {
        this.isDelete = isDelete;
    }

    public BooleanFilter getLacLinked() {
        return lacLinked;
    }

    public void setLacLinked(BooleanFilter lacLinked) {
        this.lacLinked = lacLinked;
    }

    public StringFilter getLinkageInstituteName() {
        return linkageInstituteName;
    }

    public void setLinkageInstituteName(StringFilter linkageInstituteName) {
        this.linkageInstituteName = linkageInstituteName;
    }

    public StringFilter getPreviousClinic() {
        return previousClinic;
    }

    public void setPreviousClinic(StringFilter previousClinic) {
        this.previousClinic = previousClinic;
    }

    public LocalDateFilter getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateFilter registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LongFilter getVisitRegisterId() {
        return visitRegisterId;
    }

    public void setVisitRegisterId(LongFilter visitRegisterId) {
        this.visitRegisterId = visitRegisterId;
    }

    public LongFilter getArtBeneficiaryStatusId() {
        return artBeneficiaryStatusId;
    }

    public void setArtBeneficiaryStatusId(LongFilter artBeneficiaryStatusId) {
        this.artBeneficiaryStatusId = artBeneficiaryStatusId;
    }

    public LongFilter getHivRiskFactorId() {
        return hivRiskFactorId;
    }

    public void setHivRiskFactorId(LongFilter hivRiskFactorId) {
        this.hivRiskFactorId = hivRiskFactorId;
    }

    public LongFilter getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(LongFilter facilityId) {
        this.facilityId = facilityId;
    }
    
    public LongFilter getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(LongFilter beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	
	public StringFilter getFirstName() {
		return firstName;
	}

	public void setFirstName(StringFilter firstName) {
		this.firstName = firstName;
	}

	public StringFilter getLastName() {
		return lastName;
	}

	public void setLastName(StringFilter lastName) {
		this.lastName = lastName;
	}

	public StringFilter getMiddleName() {
		return middleName;
	}

	public void setMiddleName(StringFilter middleName) {
		this.middleName = middleName;
	}

	public StringFilter getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(StringFilter mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public StringFilter getArtCentreCode() {
		return artCentreCode;
	}

	public void setArtCentreCode(StringFilter artCentreCode) {
		this.artCentreCode = artCentreCode;
	}

	public StringFilter getArtNumber() {
		return artNumber;
	}

	public void setArtNumber(StringFilter artNumber) {
		this.artNumber = artNumber;
	}

	public StringFilter getPreArtNumber() {
		return preArtNumber;
	}

	public void setPreArtNumber(StringFilter preArtNumber) {
		this.preArtNumber = preArtNumber;
	}

	@Override
	public String toString() {
		return "ArtBeneficiaryCriteria [id=" + id + ", artEligibilityDate=" + artEligibilityDate
				+ ", artRegistrationDate=" + artRegistrationDate + ", artStartDate=" + artStartDate
				+ ", isDelete=" + isDelete + ", lacLinked=" + lacLinked + ", linkageInstituteName="
				+ linkageInstituteName + ", previousClinic=" + previousClinic + ", registrationDate=" + registrationDate
				+ ", visitRegisterId=" + visitRegisterId + ", artBeneficiaryStatusId=" + artBeneficiaryStatusId
				+ ", hivRiskFactorId=" + hivRiskFactorId + ", facilityId=" + facilityId + ", beneficiaryId="
				+ beneficiaryId + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", mobileNumber=" + mobileNumber + ", artCentreCode=" + artCentreCode + ", artNumber=" + artNumber
				+ ", preArtNumber=" + preArtNumber + "]";
	}

}
