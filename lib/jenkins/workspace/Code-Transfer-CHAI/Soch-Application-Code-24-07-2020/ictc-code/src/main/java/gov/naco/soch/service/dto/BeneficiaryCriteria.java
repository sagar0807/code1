package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link gov.naco.soch.domain.Beneficiary} entity. This class is used
 * in {@link gov.naco.soch.web.rest.BeneficiaryResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /beneficiaries?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class BeneficiaryCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter uid;

    private StringFilter aadharNumber;

    private StringFilter age;

    private StringFilter barcode;

    private StringFilter beneficiaryType;

    private StringFilter category;

    private LocalDateFilter dateOfBirth;

    private StringFilter educationLevel;

    private StringFilter employmentStatus;

    private StringFilter otherEmploymentStatus;

    private StringFilter firstName;

    private StringFilter gender;

    private BooleanFilter isPlhiv;

    private StringFilter lastName;

    private StringFilter maritalStatus;

    private StringFilter middleName;

    private StringFilter mobileNumber;

    private StringFilter occupation;

    private StringFilter status;

    private IntegerFilter createdBy;

    private LocalDateFilter createdTime;

    private IntegerFilter modifiedBy;

    private LocalDateFilter modifiedTime;

    private BooleanFilter isActive;

    private BooleanFilter isDelete;

    private LongFilter addressId;
    
    private IntegerFilter maritalStatusId;
    
    private IntegerFilter occupationId;
    
    private IntegerFilter monthlyIncomeId;
    
    private IntegerFilter masterEmploymentStatus;
    
    private IntegerFilter educationLevelId;
    
    private IntegerFilter genderId;
    
    private StringFilter alternatePhonenumber;
    
    private IntegerFilter address;
    
    private StringFilter caregiverName;
    
    private StringFilter caregiverPhoneNumber;
    
    private IntegerFilter caregiverAddressId;
    
    private IntegerFilter hivTypeId;
    
	private IntegerFilter hivStatusId;
	
	private LocalDateFilter deathDate;
	
	private StringFilter deathReason;
	
	private StringFilter bankAccountName;
	
	private StringFilter bankAccountNumber;
	
	private StringFilter bankIfsc;
	
	private IntegerFilter stayingWithId;

//	private StringFilter guardianCaregiverName;
	
	private IntegerFilter guardianCaregiverHighestEducationId;
	
	private IntegerFilter birthHistoryId;
	
	private IntegerFilter birthWeight;
	
	private StringFilter neoNatalComplications;
	
	private StringFilter artNumber;
	
	private StringFilter preArtNumber;
	
	private IntegerFilter categoryId;
	
	private StringFilter clientStatus;
	
	public IntegerFilter getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(IntegerFilter maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public IntegerFilter getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(IntegerFilter occupationId) {
		this.occupationId = occupationId;
	}

	public IntegerFilter getMonthlyIncomeId() {
		return monthlyIncomeId;
	}

	public void setMonthlyIncomeId(IntegerFilter monthlyIncomeId) {
		this.monthlyIncomeId = monthlyIncomeId;
	}

	public IntegerFilter getMasterEmploymentStatus() {
		return masterEmploymentStatus;
	}

	public void setMasterEmploymentStatus(IntegerFilter masterEmploymentStatus) {
		this.masterEmploymentStatus = masterEmploymentStatus;
	}

	public IntegerFilter getEducationLevelId() {
		return educationLevelId;
	}

	public void setEducationLevelId(IntegerFilter educationLevelId) {
		this.educationLevelId = educationLevelId;
	}

	public IntegerFilter getGenderId() {
		return genderId;
	}

	public void setGenderId(IntegerFilter genderId) {
		this.genderId = genderId;
	}

	public StringFilter getAlternatePhonenumber() {
		return alternatePhonenumber;
	}

	public void setAlternatePhonenumber(StringFilter alternatePhonenumber) {
		this.alternatePhonenumber = alternatePhonenumber;
	}

	public IntegerFilter getAddress() {
		return address;
	}

	public void setAddress(IntegerFilter address) {
		this.address = address;
	}

	public StringFilter getCaregiverName() {
		return caregiverName;
	}

	public void setCaregiverName(StringFilter caregiverName) {
		this.caregiverName = caregiverName;
	}

	public StringFilter getCaregiverPhoneNumber() {
		return caregiverPhoneNumber;
	}

	public void setCaregiverPhoneNumber(StringFilter caregiverPhoneNumber) {
		this.caregiverPhoneNumber = caregiverPhoneNumber;
	}

	public IntegerFilter getCaregiverAddressId() {
		return caregiverAddressId;
	}

	public void setCaregiverAddressId(IntegerFilter caregiverAddressId) {
		this.caregiverAddressId = caregiverAddressId;
	}

	public IntegerFilter getHivTypeId() {
		return hivTypeId;
	}

	public void setHivTypeId(IntegerFilter hivTypeId) {
		this.hivTypeId = hivTypeId;
	}

	public IntegerFilter getHivStatusId() {
		return hivStatusId;
	}

	public void setHivStatusId(IntegerFilter hivStatusId) {
		this.hivStatusId = hivStatusId;
	}

	public LocalDateFilter getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(LocalDateFilter deathDate) {
		this.deathDate = deathDate;
	}

	public StringFilter getDeathReason() {
		return deathReason;
	}

	public void setDeathReason(StringFilter deathReason) {
		this.deathReason = deathReason;
	}

	public StringFilter getBankAccountName() {
		return bankAccountName;
	}

	public void setBankAccountName(StringFilter bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	public StringFilter getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(StringFilter bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public StringFilter getBankIfsc() {
		return bankIfsc;
	}

	public void setBankIfsc(StringFilter bankIfsc) {
		this.bankIfsc = bankIfsc;
	}

	public IntegerFilter getStayingWithId() {
		return stayingWithId;
	}

	public void setStayingWithId(IntegerFilter stayingWithId) {
		this.stayingWithId = stayingWithId;
	}

//	public StringFilter getGuardianCaregiverName() {
//		return guardianCaregiverName;
//	}
//
//	public void setGuardianCaregiverName(StringFilter guardianCaregiverName) {
//		this.guardianCaregiverName = guardianCaregiverName;
//	}

	public IntegerFilter getGuardianCaregiverHighestEducationId() {
		return guardianCaregiverHighestEducationId;
	}

	public void setGuardianCaregiverHighestEducationId(IntegerFilter guardianCaregiverHighestEducationId) {
		this.guardianCaregiverHighestEducationId = guardianCaregiverHighestEducationId;
	}

	public IntegerFilter getBirthHistoryId() {
		return birthHistoryId;
	}

	public void setBirthHistoryId(IntegerFilter birthHistoryId) {
		this.birthHistoryId = birthHistoryId;
	}

	public IntegerFilter getBirthWeight() {
		return birthWeight;
	}

	public void setBirthWeight(IntegerFilter birthWeight) {
		this.birthWeight = birthWeight;
	}

	public StringFilter getNeoNatalComplications() {
		return neoNatalComplications;
	}

	public void setNeoNatalComplications(StringFilter neoNatalComplications) {
		this.neoNatalComplications = neoNatalComplications;
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

	public IntegerFilter getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(IntegerFilter categoryId) {
		this.categoryId = categoryId;
	}

	public StringFilter getClientStatus() {
		return clientStatus;
	}

	public void setClientStatus(StringFilter clientStatus) {
		this.clientStatus = clientStatus;
	}

	public IntegerFilter getMasterClientStatus() {
		return masterClientStatus;
	}

	public void setMasterClientStatus(IntegerFilter masterClientStatus) {
		this.masterClientStatus = masterClientStatus;
	}

	private IntegerFilter masterClientStatus;
	
    public BeneficiaryCriteria() {
    }

    public BeneficiaryCriteria(BeneficiaryCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.uid = other.uid == null ? null : other.uid.copy();
        this.aadharNumber = other.aadharNumber == null ? null : other.aadharNumber.copy();
        this.age = other.age == null ? null : other.age.copy();
        this.barcode = other.barcode == null ? null : other.barcode.copy();
        this.beneficiaryType = other.beneficiaryType == null ? null : other.beneficiaryType.copy();
        this.category = other.category == null ? null : other.category.copy();
        this.dateOfBirth = other.dateOfBirth == null ? null : other.dateOfBirth.copy();
        this.educationLevel = other.educationLevel == null ? null : other.educationLevel.copy();
        this.employmentStatus = other.employmentStatus == null ? null : other.employmentStatus.copy();
        this.otherEmploymentStatus = other.otherEmploymentStatus == null ? null : other.otherEmploymentStatus.copy();
        this.firstName = other.firstName == null ? null : other.firstName.copy();
        this.gender = other.gender == null ? null : other.gender.copy();
        this.isPlhiv = other.isPlhiv == null ? null : other.isPlhiv.copy();
        this.lastName = other.lastName == null ? null : other.lastName.copy();
        this.maritalStatus = other.maritalStatus == null ? null : other.maritalStatus.copy();
        this.middleName = other.middleName == null ? null : other.middleName.copy();
        this.mobileNumber = other.mobileNumber == null ? null : other.mobileNumber.copy();
        this.occupation = other.occupation == null ? null : other.occupation.copy();
        this.status = other.status == null ? null : other.status.copy();
        this.createdBy = other.createdBy == null ? null : other.createdBy.copy();
        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
        this.modifiedBy = other.modifiedBy == null ? null : other.modifiedBy.copy();
        this.modifiedTime = other.modifiedTime == null ? null : other.modifiedTime.copy();
        this.isActive = other.isActive == null ? null : other.isActive.copy();
        this.isDelete = other.isDelete == null ? null : other.isDelete.copy();
        this.addressId = other.addressId == null ? null : other.addressId.copy();
        
        this.maritalStatusId = other.maritalStatusId == null ? null : other.maritalStatusId.copy();
        this.occupationId = other.occupationId == null ? null : other.occupationId.copy();
        this.monthlyIncomeId = other.monthlyIncomeId == null ? null : other.monthlyIncomeId.copy();
        this.masterEmploymentStatus = other.masterEmploymentStatus == null ? null : other.masterEmploymentStatus.copy();
        this.educationLevelId = other.educationLevelId == null ? null : other.educationLevelId.copy();
        this.genderId = other.genderId == null ? null : other.genderId.copy();
        this.alternatePhonenumber = other.alternatePhonenumber == null ? null : other.alternatePhonenumber.copy();
        this.address = other.address == null ? null : other.address.copy();
        this.caregiverName = other.caregiverName == null ? null : other.caregiverName.copy();
        this.caregiverPhoneNumber = other.caregiverPhoneNumber == null ? null : other.caregiverPhoneNumber.copy();
        this.caregiverAddressId = other.caregiverAddressId == null ? null : other.caregiverAddressId.copy();
        this.hivTypeId = other.hivTypeId == null ? null : other.hivTypeId.copy();
        this.hivStatusId = other.hivStatusId == null ? null : other.hivStatusId.copy();
        this.deathDate = other.deathDate == null ? null : other.deathDate.copy();
        this.deathReason = other.deathReason == null ? null : other.deathReason.copy();
        this.bankAccountName = other.bankAccountName == null ? null : other.bankAccountName.copy();
        this.bankAccountNumber = other.bankAccountNumber == null ? null : other.bankAccountNumber.copy();
        this.bankIfsc = other.bankIfsc == null ? null : other.bankIfsc.copy();
        this.stayingWithId = other.stayingWithId == null ? null : other.stayingWithId.copy();
//        this.guardianCaregiverName = other.guardianCaregiverName == null ? null : other.guardianCaregiverName.copy();
        this.guardianCaregiverHighestEducationId = other.guardianCaregiverHighestEducationId == null ? null : other.guardianCaregiverHighestEducationId.copy();
        this.birthHistoryId = other.birthHistoryId == null ? null : other.birthHistoryId.copy();
        this.birthWeight = other.birthWeight == null ? null : other.birthWeight.copy();
        this.neoNatalComplications = other.neoNatalComplications == null ? null : other.neoNatalComplications.copy();
        this.artNumber = other.artNumber == null ? null : other.artNumber.copy();
        this.preArtNumber = other.preArtNumber == null ? null : other.preArtNumber.copy();
        this.categoryId = other.categoryId == null ? null : other.categoryId.copy();
        this.clientStatus = other.clientStatus == null ? null : other.clientStatus.copy();
        this.masterClientStatus = other.masterClientStatus == null ? null : other.masterClientStatus.copy();
    }

    @Override
    public BeneficiaryCriteria copy() {
        return new BeneficiaryCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getUid() {
        return uid;
    }

    public void setUid(StringFilter uid) {
        this.uid = uid;
    }

    public StringFilter getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(StringFilter aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public StringFilter getAge() {
        return age;
    }

    public void setAge(StringFilter age) {
        this.age = age;
    }

    public StringFilter getBarcode() {
        return barcode;
    }

    public void setBarcode(StringFilter barcode) {
        this.barcode = barcode;
    }

    public StringFilter getBeneficiaryType() {
        return beneficiaryType;
    }

    public void setBeneficiaryType(StringFilter beneficiaryType) {
        this.beneficiaryType = beneficiaryType;
    }

    public StringFilter getCategory() {
        return category;
    }

    public void setCategory(StringFilter category) {
        this.category = category;
    }

    public LocalDateFilter getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateFilter dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public StringFilter getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(StringFilter educationLevel) {
        this.educationLevel = educationLevel;
    }

    public StringFilter getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(StringFilter employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public StringFilter getOtherEmploymentStatus() {
        return otherEmploymentStatus;
    }

    public void setOtherEmploymentStatus(StringFilter otherEmploymentStatus) {
        this.otherEmploymentStatus = otherEmploymentStatus;
    }

    public StringFilter getFirstName() {
        return firstName;
    }

    public void setFirstName(StringFilter firstName) {
        this.firstName = firstName;
    }

    public StringFilter getGender() {
        return gender;
    }

    public void setGender(StringFilter gender) {
        this.gender = gender;
    }

    public BooleanFilter getIsPlhiv() {
        return isPlhiv;
    }

    public void setIsPlhiv(BooleanFilter isPlhiv) {
        this.isPlhiv = isPlhiv;
    }

    public StringFilter getLastName() {
        return lastName;
    }

    public void setLastName(StringFilter lastName) {
        this.lastName = lastName;
    }

    public StringFilter getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(StringFilter maritalStatus) {
        this.maritalStatus = maritalStatus;
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

    public StringFilter getOccupation() {
        return occupation;
    }

    public void setOccupation(StringFilter occupation) {
        this.occupation = occupation;
    }

    public StringFilter getStatus() {
        return status;
    }

    public void setStatus(StringFilter status) {
        this.status = status;
    }

    public IntegerFilter getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(IntegerFilter createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateFilter getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateFilter createdTime) {
        this.createdTime = createdTime;
    }

    public IntegerFilter getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(IntegerFilter modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateFilter getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateFilter modifiedTime) {
        this.modifiedTime = modifiedTime;
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

    public LongFilter getAddressId() {
        return addressId;
    }

    public void setAddressId(LongFilter addressId) {
        this.addressId = addressId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BeneficiaryCriteria that = (BeneficiaryCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(uid, that.uid) &&
            Objects.equals(aadharNumber, that.aadharNumber) &&
            Objects.equals(age, that.age) &&
            Objects.equals(barcode, that.barcode) &&
            Objects.equals(beneficiaryType, that.beneficiaryType) &&
            Objects.equals(category, that.category) &&
            Objects.equals(dateOfBirth, that.dateOfBirth) &&
            Objects.equals(educationLevel, that.educationLevel) &&
            Objects.equals(employmentStatus, that.employmentStatus) &&
            Objects.equals(otherEmploymentStatus, that.otherEmploymentStatus) &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(gender, that.gender) &&
            Objects.equals(isPlhiv, that.isPlhiv) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(maritalStatus, that.maritalStatus) &&
            Objects.equals(middleName, that.middleName) &&
            Objects.equals(mobileNumber, that.mobileNumber) &&
            Objects.equals(occupation, that.occupation) &&
            Objects.equals(status, that.status) &&
            Objects.equals(createdBy, that.createdBy) &&
            Objects.equals(createdTime, that.createdTime) &&
            Objects.equals(modifiedBy, that.modifiedBy) &&
            Objects.equals(modifiedTime, that.modifiedTime) &&
            Objects.equals(isActive, that.isActive) &&
            Objects.equals(isDelete, that.isDelete) &&
            Objects.equals(addressId, that.addressId) &&
            Objects.equals(maritalStatusId, that.maritalStatusId) &&
            Objects.equals(occupationId, that.occupationId) &&
            Objects.equals(monthlyIncomeId, that.monthlyIncomeId) &&
            Objects.equals(masterEmploymentStatus, that.masterEmploymentStatus) &&
            Objects.equals(educationLevelId, that.educationLevelId) &&
            Objects.equals(genderId, that.genderId) &&
            Objects.equals(alternatePhonenumber, that.alternatePhonenumber) &&
            Objects.equals(address, that.address) &&
            Objects.equals(caregiverName, that.caregiverName) &&
            Objects.equals(caregiverPhoneNumber, that.caregiverPhoneNumber) &&
            Objects.equals(caregiverAddressId, that.caregiverAddressId) &&
            Objects.equals(hivTypeId, that.hivTypeId) &&
            Objects.equals(hivStatusId, that.hivStatusId) &&
            Objects.equals(deathDate, that.deathDate) &&
            Objects.equals(deathReason, that.deathReason) &&
            Objects.equals(bankAccountName, that.bankAccountName) &&
            Objects.equals(bankAccountNumber, that.bankAccountNumber) &&
            Objects.equals(bankIfsc, that.bankIfsc) &&
            Objects.equals(stayingWithId, that.stayingWithId) &&
//            Objects.equals(guardianCaregiverName, that.guardianCaregiverName) &&
            Objects.equals(guardianCaregiverHighestEducationId, that.guardianCaregiverHighestEducationId) &&
            Objects.equals(birthHistoryId, that.birthHistoryId) &&
            Objects.equals(birthWeight, that.birthWeight) &&
            Objects.equals(neoNatalComplications, that.neoNatalComplications) &&
            Objects.equals(artNumber, that.artNumber) &&
            Objects.equals(preArtNumber, that.preArtNumber) &&
            Objects.equals(categoryId, that.categoryId) &&
            Objects.equals(clientStatus, that.clientStatus) &&
            Objects.equals(masterClientStatus, that.masterClientStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        uid,
        aadharNumber,
        age,
        barcode,
        beneficiaryType,
        category,
        dateOfBirth,
        educationLevel,
        employmentStatus,
        otherEmploymentStatus,
        firstName,
        gender,
        isPlhiv,
        lastName,
        maritalStatus,
        middleName,
        mobileNumber,
        occupation,
        status,
        createdBy,
        createdTime,
        modifiedBy,
        modifiedTime,
        isActive,
        isDelete,
        addressId,
        maritalStatusId,
        occupationId,
        monthlyIncomeId,
        masterEmploymentStatus,
        educationLevelId,
        genderId,
        alternatePhonenumber,
        address,
        caregiverName,
        caregiverPhoneNumber,
        caregiverAddressId,
        hivTypeId,
        hivStatusId,
        deathDate,
        deathReason,
        bankAccountName,
        bankAccountNumber,
        bankIfsc,
        stayingWithId,
//        guardianCaregiverName,
        guardianCaregiverHighestEducationId,
        birthHistoryId,
        birthWeight,
        neoNatalComplications,
        artNumber,
        preArtNumber,
        categoryId,
        clientStatus,
        masterClientStatus
        );
    }

    @Override
    public String toString() {
        return "BeneficiaryCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (uid != null ? "uid=" + uid + ", " : "") +
                (aadharNumber != null ? "aadharNumber=" + aadharNumber + ", " : "") +
                (age != null ? "age=" + age + ", " : "") +
                (barcode != null ? "barcode=" + barcode + ", " : "") +
                (beneficiaryType != null ? "beneficiaryType=" + beneficiaryType + ", " : "") +
                (category != null ? "category=" + category + ", " : "") +
                (dateOfBirth != null ? "dateOfBirth=" + dateOfBirth + ", " : "") +
                (educationLevel != null ? "educationLevel=" + educationLevel + ", " : "") +
                (employmentStatus != null ? "employmentStatus=" + employmentStatus + ", " : "") +
                (otherEmploymentStatus != null ? "otherEmploymentStatus=" + otherEmploymentStatus + ", " : "") +
                (firstName != null ? "firstName=" + firstName + ", " : "") +
                (gender != null ? "gender=" + gender + ", " : "") +
                (isPlhiv != null ? "isPlhiv=" + isPlhiv + ", " : "") +
                (lastName != null ? "lastName=" + lastName + ", " : "") +
                (maritalStatus != null ? "maritalStatus=" + maritalStatus + ", " : "") +
                (middleName != null ? "middleName=" + middleName + ", " : "") +
                (mobileNumber != null ? "mobileNumber=" + mobileNumber + ", " : "") +
                (occupation != null ? "occupation=" + occupation + ", " : "") +
                (status != null ? "status=" + status + ", " : "") +
                (createdBy != null ? "createdBy=" + createdBy + ", " : "") +
                (createdTime != null ? "createdTime=" + createdTime + ", " : "") +
                (modifiedBy != null ? "modifiedBy=" + modifiedBy + ", " : "") +
                (modifiedTime != null ? "modifiedTime=" + modifiedTime + ", " : "") +
                (isActive != null ? "isActive=" + isActive + ", " : "") +
                (isDelete != null ? "isDelete=" + isDelete + ", " : "") +
                (addressId != null ? "addressId=" + addressId + ", " : "") +
                (maritalStatusId != null ? "maritalStatusId=" + maritalStatusId + ", " : "") +
                (occupationId != null ? "occupationId=" + occupationId + ", " : "") +
                (monthlyIncomeId != null ? "monthlyIncomeId=" + monthlyIncomeId + ", " : "") +
                (masterEmploymentStatus != null ? "masterEmploymentStatus=" + masterEmploymentStatus + ", " : "") +
                (educationLevelId != null ? "educationLevelId=" + educationLevelId + ", " : "") +
                (genderId != null ? "genderId=" + genderId + ", " : "") +
                (alternatePhonenumber != null ? "alternatePhonenumber=" + alternatePhonenumber + ", " : "") +
                (address != null ? "address=" + address + ", " : "") +
                (caregiverName != null ? "caregiverName=" + caregiverName + ", " : "") +
                (caregiverPhoneNumber != null ? "caregiverPhoneNumber=" + caregiverPhoneNumber + ", " : "") +
                (caregiverAddressId != null ? "caregiverAddressId=" + caregiverAddressId + ", " : "") +
                (hivTypeId != null ? "hivTypeId=" + hivTypeId + ", " : "") +
                (hivStatusId != null ? "hivStatusId=" + hivStatusId + ", " : "") +
                (deathDate != null ? "deathDate=" + deathDate + ", " : "") +
                (deathReason != null ? "deathReason=" + deathReason + ", " : "") +
                (bankAccountName != null ? "bankAccountName=" + bankAccountName + ", " : "") +
                (bankAccountNumber != null ? "bankAccountNumber=" + bankAccountNumber + ", " : "") +
                (bankIfsc != null ? "bankIfsc=" + bankIfsc + ", " : "") +
                (stayingWithId != null ? "stayingWithId=" + stayingWithId + ", " : "") +
//                (guardianCaregiverName != null ? "guardianCaregiverName=" + guardianCaregiverName + ", " : "") +
                (guardianCaregiverHighestEducationId != null ? "guardianCaregiverHighestEducationId=" + guardianCaregiverHighestEducationId + ", " : "") +
                (birthHistoryId != null ? "birthHistoryId=" + birthHistoryId + ", " : "") +
                (birthWeight != null ? "birthWeight=" + birthWeight + ", " : "") +
                (neoNatalComplications != null ? "neoNatalComplications=" + neoNatalComplications + ", " : "") +
                (artNumber != null ? "artNumber=" + artNumber + ", " : "") +
                (preArtNumber != null ? "preArtNumber=" + preArtNumber + ", " : "") +
                (categoryId != null ? "categoryId=" + categoryId + ", " : "") +
                (clientStatus != null ? "clientStatus=" + clientStatus + ", " : "") +
                (masterClientStatus != null ? "masterClientStatus=" + masterClientStatus + ", " : "") +
                

                "}";
    }

}
