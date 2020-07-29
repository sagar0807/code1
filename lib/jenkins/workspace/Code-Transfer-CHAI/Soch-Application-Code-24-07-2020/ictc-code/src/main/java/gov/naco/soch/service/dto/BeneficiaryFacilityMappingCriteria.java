package gov.naco.soch.service.dto;

import java.io.Serializable;

import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;



/**
 * Criteria class for the BeneficiaryFacilityMapping entity. This class is used in BeneficiaryFacilityMappingResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /beneficiary-facility-mappings?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class BeneficiaryFacilityMappingCriteria implements Serializable {
    private static final long serialVersionUID = 1L;


    private LongFilter id;

    private BooleanFilter isActive;

    private BooleanFilter isDelete;

    private StringFilter pid;

    private LocalDateFilter mappingDate;

    private LocalDateFilter registrationDate;

    private LocalDateFilter createdTime;

    private LocalDateFilter modifiedTime;

    private LongFilter beneficiaryId;

    private LongFilter facilityId;
    
    private StringFilter firstName;
    
    private StringFilter lastName;
    
    private StringFilter middleName;
    
    private StringFilter uid;
    
	private StringFilter preArtNumber;

  	private StringFilter artNumber;
    
    private LongFilter facilityTypeId;
    
    private StringFilter artCode;
    
    private IntegerFilter genderId;
    
    private StringFilter mobileNumber;
    
    private StringFilter tiCode;
    
    private StringFilter ostCode;

    public IntegerFilter getGenderId() {
		return genderId;
	}

	public void setGenderId(IntegerFilter genderId) {
		this.genderId = genderId;
	}

	public BeneficiaryFacilityMappingCriteria() {
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
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

    public StringFilter getPid() {
        return pid;
    }

    public void setPid(StringFilter pid) {
        this.pid = pid;
    }

    public LocalDateFilter getMappingDate() {
        return mappingDate;
    }

    public void setMappingDate(LocalDateFilter mappingDate) {
        this.mappingDate = mappingDate;
    }

    public LocalDateFilter getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateFilter registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDateFilter getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateFilter createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateFilter getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateFilter modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public LongFilter getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(LongFilter beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public LongFilter getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(LongFilter facilityId) {
        this.facilityId = facilityId;
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

	public StringFilter getUid() {
		return uid;
	}

	public void setUid(StringFilter uid) {
		this.uid = uid;
	}
	

	public LongFilter getFacilityTypeId() {
		return facilityTypeId;
	}

	public void setFacilityTypeId(LongFilter facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}
	
	public StringFilter getPreArtNumber() {
		return preArtNumber;
	}

	public void setPreArtNumber(StringFilter preArtNumber) {
		this.preArtNumber = preArtNumber;
	}

	public StringFilter getArtNumber() {
		return artNumber;
	}

	public void setArtNumber(StringFilter artNumber) {
		this.artNumber = artNumber;
	}
	
	public StringFilter getArtCode() {
		return artCode;
	}

	public void setArtCode(StringFilter artCode) {
		this.artCode = artCode;
	}
	
	public StringFilter getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(StringFilter mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public StringFilter getTiCode() {
		return tiCode;
	}

	public void setTiCode(StringFilter tiCode) {
		this.tiCode = tiCode;
	}

	public StringFilter getOstCode() {
		return ostCode;
	}

	public void setOstCode(StringFilter ostCode) {
		this.ostCode = ostCode;
	}

	@Override
	public String toString() {
		return "BeneficiaryFacilityMappingCriteria [id=" + id + ", isActive=" + isActive + ", isDelete=" + isDelete
				+ ", pid=" + pid + ", mappingDate=" + mappingDate + ", registrationDate=" + registrationDate
				+ ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + ", beneficiaryId=" + beneficiaryId
				+ ", facilityId=" + facilityId + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", uid=" + uid + ", preArtNumber=" + preArtNumber + ", artNumber=" + artNumber
				+ ", facilityTypeId=" + facilityTypeId + ", artCode=" + artCode + ", genderId=" + genderId
				+ ", mobileNumber=" + mobileNumber + "]";
	}

}
