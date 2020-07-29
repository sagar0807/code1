package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link gov.naco.soch.domain.TIBeneficiary} entity. This class is used
 * in {@link gov.naco.soch.web.rest.TIBeneficiaryResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ti-beneficiaries?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class TIBeneficiaryCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter uid;

    private StringFilter firstName;

    private StringFilter middleName;

    private StringFilter lastName;

    private StringFilter mobileNumber;

    private StringFilter clientStatus;

    private StringFilter maritalStatus;

    private StringFilter occupation;

    private StringFilter employmentStatus;

    private StringFilter educationLevel;

    private StringFilter beneficiaryType;

    private StringFilter barcode;

    private StringFilter gender;

    private StringFilter aadharNumber;

    private StringFilter beneficiaryActivityStatus;

    private LocalDateFilter dateOfBirth;

    private StringFilter category;

    private IntegerFilter age;

    private IntegerFilter houseNo;

    private StringFilter district;

    private StringFilter state;

    private StringFilter taluk;

    private StringFilter city;

    private StringFilter block;

    private IntegerFilter pinCode;

    private BooleanFilter isActive;

    private BooleanFilter isDeleted;
  
    private StringFilter geoLatitude;

    private StringFilter geoLongitude;

    private LongFilter facilityId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateFilter dateOfReg;

    private StringFilter typology;

    private StringFilter tiCode;

    private StringFilter peCode;

    private StringFilter orwCode;

    private StringFilter numberOfPartners;

    private StringFilter regularPartners;

    private StringFilter otherEmploymentStatus;

    private LongFilter hrgPrimaryCategory;

    private LongFilter hrgSecondaryCategory;

    private LongFilter subCategory;

    private IntegerFilter avgNoSexualActsUponReg;

    private IntegerFilter noYearsInSexWork;

    private BooleanFilter consumeAlcohol;

    private IntegerFilter alcoholConsDaysInWeek;

    private StringFilter ostCode;

    private StringFilter ostStatus;

    private BooleanFilter consentDocumented;

    private IntegerFilter hotspot;

    private StringFilter deletedReason;

    private BooleanFilter sexOtherThanSpouse;

    private BooleanFilter condomUsage;

    private LongFilter typeOfMobility;

    private LongFilter stayingWith;

    private LongFilter durationOfTheStays;

    private LongFilter registrationPlace;

    private IntegerFilter noOfSexualActivity;

    private StringFilter benReferredFrom;
    
    private StringFilter param;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateFilter visitStartDate;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateFilter visitEndDate;
    
    private BooleanFilter isActiveFacility;
    
    private LongFilter status;

    public TIBeneficiaryCriteria(){
    }

    public TIBeneficiaryCriteria(TIBeneficiaryCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.uid = other.uid == null ? null : other.uid.copy();
        this.firstName = other.firstName == null ? null : other.firstName.copy();
        this.middleName = other.middleName == null ? null : other.middleName.copy();
        this.lastName = other.lastName == null ? null : other.lastName.copy();
        this.mobileNumber = other.mobileNumber == null ? null : other.mobileNumber.copy();
        this.clientStatus = other.clientStatus == null ? null : other.clientStatus.copy();
        this.maritalStatus = other.maritalStatus == null ? null : other.maritalStatus.copy();
        this.occupation = other.occupation == null ? null : other.occupation.copy();
        this.employmentStatus = other.employmentStatus == null ? null : other.employmentStatus.copy();
        this.educationLevel = other.educationLevel == null ? null : other.educationLevel.copy();
        this.beneficiaryType = other.beneficiaryType == null ? null : other.beneficiaryType.copy();
        this.barcode = other.barcode == null ? null : other.barcode.copy();
        this.gender = other.gender == null ? null : other.gender.copy();
        this.aadharNumber = other.aadharNumber == null ? null : other.aadharNumber.copy();
        this.beneficiaryActivityStatus = other.beneficiaryActivityStatus == null ? null : other.beneficiaryActivityStatus.copy();
        this.dateOfBirth = other.dateOfBirth == null ? null : other.dateOfBirth.copy();
        this.category = other.category == null ? null : other.category.copy();
        this.age = other.age == null ? null : other.age.copy();
        this.houseNo = other.houseNo == null ? null : other.houseNo.copy();
        this.district = other.district == null ? null : other.district.copy();
        this.state = other.state == null ? null : other.state.copy();
        this.taluk = other.taluk == null ? null : other.taluk.copy();
        this.city = other.city == null ? null : other.city.copy();
        this.block = other.block == null ? null : other.block.copy();
        this.pinCode = other.pinCode == null ? null : other.pinCode.copy();
        this.isActive = other.isActive == null ? null : other.isActive.copy();
        this.isDeleted = other.isDeleted == null ? null : other.isDeleted.copy();
        this.geoLatitude = other.geoLatitude == null ? null : other.geoLatitude.copy();
        this.geoLongitude = other.geoLongitude == null ? null : other.geoLongitude.copy();
        this.facilityId = other.facilityId == null ? null : other.facilityId.copy();
        this.dateOfReg = other.dateOfReg == null ? null : other.dateOfReg.copy();
        this.typology = other.typology == null ? null : other.typology.copy();
        this.tiCode = other.tiCode == null ? null : other.tiCode.copy();
        this.peCode = other.peCode == null ? null : other.peCode.copy();
        this.orwCode = other.orwCode == null ? null : other.orwCode.copy();
        this.numberOfPartners = other.numberOfPartners == null ? null : other.numberOfPartners.copy();
        this.regularPartners = other.regularPartners == null ? null : other.regularPartners.copy();
        this.otherEmploymentStatus = other.otherEmploymentStatus == null ? null : other.otherEmploymentStatus.copy();
        this.hrgPrimaryCategory = other.hrgPrimaryCategory == null ? null : other.hrgPrimaryCategory.copy();
        this.hrgSecondaryCategory = other.hrgSecondaryCategory == null ? null : other.hrgSecondaryCategory.copy();
        this.subCategory = other.subCategory == null ? null : other.subCategory.copy();
        this.avgNoSexualActsUponReg = other.avgNoSexualActsUponReg == null ? null : other.avgNoSexualActsUponReg.copy();
        this.noYearsInSexWork = other.noYearsInSexWork == null ? null : other.noYearsInSexWork.copy();
        this.consumeAlcohol = other.consumeAlcohol == null ? null : other.consumeAlcohol.copy();
        this.alcoholConsDaysInWeek = other.alcoholConsDaysInWeek == null ? null : other.alcoholConsDaysInWeek.copy();
        this.ostCode = other.ostCode == null ? null : other.ostCode.copy();
        this.ostStatus = other.ostStatus == null ? null : other.ostStatus.copy();
        this.consentDocumented = other.consentDocumented == null ? null : other.consentDocumented.copy();
        this.hotspot = other.hotspot == null ? null : other.hotspot.copy();
        this.deletedReason = other.deletedReason == null ? null : other.deletedReason.copy();
        this.sexOtherThanSpouse = other.sexOtherThanSpouse == null ? null : other.sexOtherThanSpouse.copy();
        this.condomUsage = other.condomUsage == null ? null : other.condomUsage.copy();
        this.typeOfMobility = other.typeOfMobility == null ? null : other.typeOfMobility.copy();
        this.stayingWith = other.stayingWith == null ? null : other.stayingWith.copy();
        this.durationOfTheStays = other.durationOfTheStays == null ? null : other.durationOfTheStays.copy();
        this.registrationPlace = other.registrationPlace == null ? null : other.registrationPlace.copy();
        this.noOfSexualActivity = other.noOfSexualActivity == null ? null : other.noOfSexualActivity.copy();
        this.benReferredFrom = other.benReferredFrom == null ? null : other.benReferredFrom.copy();
        this.param = other.param == null ? null : other.param.copy();
        this.visitStartDate = other.visitStartDate == null ? null : other.visitStartDate.copy();
        this.visitEndDate = other.visitEndDate == null ? null : other.visitEndDate.copy();
        this.isActiveFacility=other.isActiveFacility==null?null:other.isActiveFacility.copy();
        this.status=other.status==null?null:other.status.copy();
    }

    @Override
    public TIBeneficiaryCriteria copy() {
        return new TIBeneficiaryCriteria(this);
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
    
    public StringFilter getParam() {
		return param;
	}
    
	public LocalDateFilter getVisitStartDate() {
		return visitStartDate;
	}

	public void setVisitStartDate(LocalDateFilter visitStartDate) {
		this.visitStartDate = visitStartDate;
	}

	public LocalDateFilter getVisitEndDate() {
		return visitEndDate;
	}

	public void setVisitEndDate(LocalDateFilter visitEndDate) {
		this.visitEndDate = visitEndDate;
	}

	public void setParam(StringFilter param) {
		this.param = param;
	}

	public void setUid(StringFilter uid) {
        this.uid = uid;
    }

    public StringFilter getFirstName() {
        return firstName;
    }

    public void setFirstName(StringFilter firstName) {
        this.firstName = firstName;
    }

    public StringFilter getMiddleName() {
        return middleName;
    }

    public void setMiddleName(StringFilter middleName) {
        this.middleName = middleName;
    }

    public StringFilter getLastName() {
        return lastName;
    }

    public void setLastName(StringFilter lastName) {
        this.lastName = lastName;
    }

    public StringFilter getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(StringFilter mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public StringFilter getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(StringFilter clientStatus) {
        this.clientStatus = clientStatus;
    }

    public StringFilter getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(StringFilter maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public StringFilter getOccupation() {
        return occupation;
    }

    public void setOccupation(StringFilter occupation) {
        this.occupation = occupation;
    }

    public StringFilter getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(StringFilter employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public StringFilter getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(StringFilter educationLevel) {
        this.educationLevel = educationLevel;
    }

    public StringFilter getBeneficiaryType() {
        return beneficiaryType;
    }

    public void setBeneficiaryType(StringFilter beneficiaryType) {
        this.beneficiaryType = beneficiaryType;
    }

    public StringFilter getBarcode() {
        return barcode;
    }

    public void setBarcode(StringFilter barcode) {
        this.barcode = barcode;
    }

    public StringFilter getGender() {
        return gender;
    }

    public void setGender(StringFilter gender) {
        this.gender = gender;
    }

    public StringFilter getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(StringFilter aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public StringFilter getBeneficiaryActivityStatus() {
        return beneficiaryActivityStatus;
    }

    public void setBeneficiaryActivityStatus(StringFilter beneficiaryActivityStatus) {
        this.beneficiaryActivityStatus = beneficiaryActivityStatus;
    }

    public LocalDateFilter getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateFilter dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public StringFilter getCategory() {
        return category;
    }

    public void setCategory(StringFilter category) {
        this.category = category;
    }

    public IntegerFilter getAge() {
        return age;
    }

    public void setAge(IntegerFilter age) {
        this.age = age;
    }

    public IntegerFilter getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(IntegerFilter houseNo) {
        this.houseNo = houseNo;
    }

    public StringFilter getDistrict() {
        return district;
    }

    public void setDistrict(StringFilter district) {
        this.district = district;
    }

    public StringFilter getState() {
        return state;
    }

    public void setState(StringFilter state) {
        this.state = state;
    }

    public StringFilter getTaluk() {
        return taluk;
    }

    public void setTaluk(StringFilter taluk) {
        this.taluk = taluk;
    }

    public StringFilter getCity() {
        return city;
    }

    public void setCity(StringFilter city) {
        this.city = city;
    }

    public StringFilter getBlock() {
        return block;
    }

    public void setBlock(StringFilter block) {
        this.block = block;
    }

    public IntegerFilter getPinCode() {
        return pinCode;
    }

    public void setPinCode(IntegerFilter pinCode) {
        this.pinCode = pinCode;
    }

    public BooleanFilter getIsActive() {
        return isActive;
    }

    public void setIsActive(BooleanFilter isActive) {
        this.isActive = isActive;
    }

    public BooleanFilter getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(BooleanFilter isDeleted) {
        this.isDeleted = isDeleted;
    }

    public StringFilter getGeoLatitude() {
        return geoLatitude;
    }

    public void setGeoLatitude(StringFilter geoLatitude) {
        this.geoLatitude = geoLatitude;
    }

    public StringFilter getGeoLongitude() {
        return geoLongitude;
    }

    public void setGeoLongitude(StringFilter geoLongitude) {
        this.geoLongitude = geoLongitude;
    }

    public LongFilter getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(LongFilter facilityId) {
        this.facilityId = facilityId;
    }

    public LocalDateFilter getDateOfReg() {
        return dateOfReg;
    }

    public void setDateOfReg(LocalDateFilter dateOfReg) {
        this.dateOfReg = dateOfReg;
    }

    
	

	public StringFilter getTypology() {
		return typology;
	}

	public void setTypology(StringFilter typology) {
		this.typology = typology;
	}

	public StringFilter getTiCode() {
        return tiCode;
    }

    public void setTiCode(StringFilter tiCode) {
        this.tiCode = tiCode;
    }

    public StringFilter getPeCode() {
        return peCode;
    }

    public void setPeCode(StringFilter peCode) {
        this.peCode = peCode;
    }

    public StringFilter getOrwCode() {
        return orwCode;
    }

    public void setOrwCode(StringFilter orwCode) {
        this.orwCode = orwCode;
    }

    public StringFilter getNumberOfPartners() {
        return numberOfPartners;
    }

    public void setNumberOfPartners(StringFilter numberOfPartners) {
        this.numberOfPartners = numberOfPartners;
    }

    public StringFilter getRegularPartners() {
        return regularPartners;
    }

    public void setRegularPartners(StringFilter regularPartners) {
        this.regularPartners = regularPartners;
    }

    public StringFilter getOtherEmploymentStatus() {
        return otherEmploymentStatus;
    }

    public void setOtherEmploymentStatus(StringFilter otherEmploymentStatus) {
        this.otherEmploymentStatus = otherEmploymentStatus;
    }

    

    public LongFilter getHrgPrimaryCategory() {
		return hrgPrimaryCategory;
	}

	public void setHrgPrimaryCategory(LongFilter hrgPrimaryCategory) {
		this.hrgPrimaryCategory = hrgPrimaryCategory;
	}

	

    public LongFilter getHrgSecondaryCategory() {
		return hrgSecondaryCategory;
	}

	public void setHrgSecondaryCategory(LongFilter hrgSecondaryCategory) {
		this.hrgSecondaryCategory = hrgSecondaryCategory;
	}


    public LongFilter getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(LongFilter subCategory) {
		this.subCategory = subCategory;
	}

	public IntegerFilter getAvgNoSexualActsUponReg() {
        return avgNoSexualActsUponReg;
    }

    public void setAvgNoSexualActsUponReg(IntegerFilter avgNoSexualActsUponReg) {
        this.avgNoSexualActsUponReg = avgNoSexualActsUponReg;
    }

    public IntegerFilter getNoYearsInSexWork() {
        return noYearsInSexWork;
    }

    public void setNoYearsInSexWork(IntegerFilter noYearsInSexWork) {
        this.noYearsInSexWork = noYearsInSexWork;
    }

    public BooleanFilter getConsumeAlcohol() {
        return consumeAlcohol;
    }

    public void setConsumeAlcohol(BooleanFilter consumeAlcohol) {
        this.consumeAlcohol = consumeAlcohol;
    }

    public IntegerFilter getAlcoholConsDaysInWeek() {
        return alcoholConsDaysInWeek;
    }

    public void setAlcoholConsDaysInWeek(IntegerFilter alcoholConsDaysInWeek) {
        this.alcoholConsDaysInWeek = alcoholConsDaysInWeek;
    }

    public StringFilter getOstCode() {
        return ostCode;
    }

    public void setOstCode(StringFilter ostCode) {
        this.ostCode = ostCode;
    }

    public StringFilter getOstStatus() {
        return ostStatus;
    }

    public void setOstStatus(StringFilter ostStatus) {
        this.ostStatus = ostStatus;
    }

    public BooleanFilter getConsentDocumented() {
        return consentDocumented;
    }

    public void setConsentDocumented(BooleanFilter consentDocumented) {
        this.consentDocumented = consentDocumented;
    }

    public BooleanFilter getIsActiveFacility() {
		return isActiveFacility;
	}

	public void setIsActiveFacility(BooleanFilter isActiveFacility) {
		this.isActiveFacility = isActiveFacility;
	}

	public IntegerFilter getHotspot() {
        return hotspot;
    }

    public void setHotspot(IntegerFilter hotspot) {
        this.hotspot = hotspot;
    }

    public LongFilter getStatus() {
	return status;
    }

    public void setStatus(LongFilter status) {
	this.status = status;
    }

    public StringFilter getDeletedReason() {
        return deletedReason;
    }

    public void setDeletedReason(StringFilter deletedReason) {
        this.deletedReason = deletedReason;
    }

    public BooleanFilter getSexOtherThanSpouse() {
        return sexOtherThanSpouse;
    }

    public void setSexOtherThanSpouse(BooleanFilter sexOtherThanSpouse) {
        this.sexOtherThanSpouse = sexOtherThanSpouse;
    }

    public BooleanFilter getCondomUsage() {
        return condomUsage;
    }

    public void setCondomUsage(BooleanFilter condomUsage) {
        this.condomUsage = condomUsage;
    }

    

    public LongFilter getTypeOfMobility() {
		return typeOfMobility;
	}

	public void setTypeOfMobility(LongFilter typeOfMobility) {
		this.typeOfMobility = typeOfMobility;
	}


    public LongFilter getStayingWith() {
		return stayingWith;
	}

	public void setStayingWith(LongFilter stayingWith) {
		this.stayingWith = stayingWith;
	}

	public LongFilter getDurationOfTheStays() {
		return durationOfTheStays;
	}

	public void setDurationOfTheStays(LongFilter durationOfTheStays) {
		this.durationOfTheStays = durationOfTheStays;
	}

	public LongFilter getRegistrationPlace() {
		return registrationPlace;
	}

	public void setRegistrationPlace(LongFilter registrationPlace) {
		this.registrationPlace = registrationPlace;
	}

	public IntegerFilter getNoOfSexualActivity() {
        return noOfSexualActivity;
    }

    public void setNoOfSexualActivity(IntegerFilter noOfSexualActivity) {
        this.noOfSexualActivity = noOfSexualActivity;
    }

    public StringFilter getBenReferredFrom() {
        return benReferredFrom;
    }

    public void setBenReferredFrom(StringFilter benReferredFrom) {
        this.benReferredFrom = benReferredFrom;
    }


	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final TIBeneficiaryCriteria that = (TIBeneficiaryCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(uid, that.uid) &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(middleName, that.middleName) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(mobileNumber, that.mobileNumber) &&
            Objects.equals(clientStatus, that.clientStatus) &&
            Objects.equals(maritalStatus, that.maritalStatus) &&
            Objects.equals(occupation, that.occupation) &&
            Objects.equals(employmentStatus, that.employmentStatus) &&
            Objects.equals(educationLevel, that.educationLevel) &&
            Objects.equals(beneficiaryType, that.beneficiaryType) &&
            Objects.equals(barcode, that.barcode) &&
            Objects.equals(gender, that.gender) &&
            Objects.equals(aadharNumber, that.aadharNumber) &&
            Objects.equals(beneficiaryActivityStatus, that.beneficiaryActivityStatus) &&
            Objects.equals(dateOfBirth, that.dateOfBirth) &&
            Objects.equals(category, that.category) &&
            Objects.equals(age, that.age) &&
            Objects.equals(houseNo, that.houseNo) &&
            Objects.equals(district, that.district) &&
            Objects.equals(state, that.state) &&
            Objects.equals(taluk, that.taluk) &&
            Objects.equals(city, that.city) &&
            Objects.equals(block, that.block) &&
            Objects.equals(pinCode, that.pinCode) &&
            Objects.equals(isActive, that.isActive) &&
            Objects.equals(isDeleted, that.isDeleted) &&
            Objects.equals(geoLatitude, that.geoLatitude) &&
            Objects.equals(geoLongitude, that.geoLongitude) &&
            Objects.equals(facilityId, that.facilityId) &&
            Objects.equals(dateOfReg, that.dateOfReg) &&
            Objects.equals(typology, that.typology) &&
            Objects.equals(tiCode, that.tiCode) &&
            Objects.equals(peCode, that.peCode) &&
            Objects.equals(orwCode, that.orwCode) &&
            Objects.equals(numberOfPartners, that.numberOfPartners) &&
            Objects.equals(regularPartners, that.regularPartners) &&
            Objects.equals(otherEmploymentStatus, that.otherEmploymentStatus) &&
            Objects.equals(hrgPrimaryCategory, that.hrgPrimaryCategory) &&
            Objects.equals(hrgSecondaryCategory, that.hrgSecondaryCategory) &&
            Objects.equals(subCategory, that.subCategory) &&
            Objects.equals(avgNoSexualActsUponReg, that.avgNoSexualActsUponReg) &&
            Objects.equals(noYearsInSexWork, that.noYearsInSexWork) &&
            Objects.equals(consumeAlcohol, that.consumeAlcohol) &&
            Objects.equals(alcoholConsDaysInWeek, that.alcoholConsDaysInWeek) &&
            Objects.equals(ostCode, that.ostCode) &&
            Objects.equals(ostStatus, that.ostStatus) &&
            Objects.equals(consentDocumented, that.consentDocumented) &&
            Objects.equals(hotspot, that.hotspot) &&
            Objects.equals(deletedReason, that.deletedReason) &&
            Objects.equals(sexOtherThanSpouse, that.sexOtherThanSpouse) &&
            Objects.equals(condomUsage, that.condomUsage) &&
            Objects.equals(typeOfMobility, that.typeOfMobility) &&
            Objects.equals(stayingWith, that.stayingWith) &&
            Objects.equals(durationOfTheStays, that.durationOfTheStays) &&
            Objects.equals(registrationPlace, that.registrationPlace) &&
            Objects.equals(noOfSexualActivity, that.noOfSexualActivity) &&
            Objects.equals(isActiveFacility, that.isActiveFacility)&&
            Objects.equals(status, that.status)&&
            Objects.equals(benReferredFrom, that.benReferredFrom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        uid,
        firstName,
        middleName,
        lastName,
        mobileNumber,
        clientStatus,
        maritalStatus,
        occupation,
        employmentStatus,
        educationLevel,
        beneficiaryType,
        barcode,
        gender,
        aadharNumber,
        beneficiaryActivityStatus,
        dateOfBirth,
        category,
        age,
        houseNo,
        district,
        state,
        taluk,
        city,
        block,
        pinCode,
        isActive,
        isDeleted,
        geoLatitude,
        geoLongitude,
        facilityId,
        dateOfReg,
        typology,
        tiCode,
        peCode,
        orwCode,
        numberOfPartners,
        regularPartners,
        otherEmploymentStatus,
        hrgPrimaryCategory,
        hrgSecondaryCategory,
        subCategory,
        avgNoSexualActsUponReg,
        noYearsInSexWork,
        consumeAlcohol,
        alcoholConsDaysInWeek,
        ostCode,
        ostStatus,
        consentDocumented,
        hotspot,
        deletedReason,
        sexOtherThanSpouse,
        condomUsage,
        typeOfMobility,
        stayingWith,
        durationOfTheStays,
        registrationPlace,
        noOfSexualActivity,
        isActiveFacility,
        status,
        benReferredFrom
        );
    }

    @Override
    public String toString() {
        return "TIBeneficiaryCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (uid != null ? "uid=" + uid + ", " : "") +
                (firstName != null ? "firstName=" + firstName + ", " : "") +
                (middleName != null ? "middleName=" + middleName + ", " : "") +
                (lastName != null ? "lastName=" + lastName + ", " : "") +
                (mobileNumber != null ? "mobileNumber=" + mobileNumber + ", " : "") +
                (clientStatus != null ? "clientStatus=" + clientStatus + ", " : "") +
                (maritalStatus != null ? "maritalStatus=" + maritalStatus + ", " : "") +
                (occupation != null ? "occupation=" + occupation + ", " : "") +
                (employmentStatus != null ? "employmentStatus=" + employmentStatus + ", " : "") +
                (educationLevel != null ? "educationLevel=" + educationLevel + ", " : "") +
                (beneficiaryType != null ? "beneficiaryType=" + beneficiaryType + ", " : "") +
                (barcode != null ? "barcode=" + barcode + ", " : "") +
                (gender != null ? "gender=" + gender + ", " : "") +
                (aadharNumber != null ? "aadharNumber=" + aadharNumber + ", " : "") +
                (beneficiaryActivityStatus != null ? "beneficiaryActivityStatus=" + beneficiaryActivityStatus + ", " : "") +
                (dateOfBirth != null ? "dateOfBirth=" + dateOfBirth + ", " : "") +
                (category != null ? "category=" + category + ", " : "") +
                (age != null ? "age=" + age + ", " : "") +
                (houseNo != null ? "houseNo=" + houseNo + ", " : "") +
                (district != null ? "district=" + district + ", " : "") +
                (state != null ? "state=" + state + ", " : "") +
                (taluk != null ? "taluk=" + taluk + ", " : "") +
                (city != null ? "city=" + city + ", " : "") +
                (block != null ? "block=" + block + ", " : "") +
                (pinCode != null ? "pinCode=" + pinCode + ", " : "") +
                (isActive != null ? "isActive=" + isActive + ", " : "") +
                (isDeleted != null ? "isDeleted=" + isDeleted + ", " : "") +
                (geoLatitude != null ? "geoLatitude=" + geoLatitude + ", " : "") +
                (geoLongitude != null ? "geoLongitude=" + geoLongitude + ", " : "") +
                (facilityId != null ? "facilityId=" + facilityId + ", " : "") +
                (dateOfReg != null ? "dateOfReg=" + dateOfReg + ", " : "") +
                (typology != null ? "typology=" + typology + ", " : "") +
                (tiCode != null ? "tiCode=" + tiCode + ", " : "") +
                (peCode != null ? "peCode=" + peCode + ", " : "") +
                (orwCode != null ? "orwCode=" + orwCode + ", " : "") +
                (numberOfPartners != null ? "numberOfPartners=" + numberOfPartners + ", " : "") +
                (regularPartners != null ? "regularPartners=" + regularPartners + ", " : "") +
                (otherEmploymentStatus != null ? "otherEmploymentStatus=" + otherEmploymentStatus + ", " : "") +
                (hrgPrimaryCategory != null ? "hrgPrimaryCategory=" + hrgPrimaryCategory + ", " : "") +
                (hrgSecondaryCategory != null ? "hrgSecondaryCategory=" + hrgSecondaryCategory + ", " : "") +
                (subCategory != null ? "subCategory=" + subCategory + ", " : "") +
                (avgNoSexualActsUponReg != null ? "avgNoSexualActsUponReg=" + avgNoSexualActsUponReg + ", " : "") +
                (noYearsInSexWork != null ? "noYearsInSexWork=" + noYearsInSexWork + ", " : "") +
                (consumeAlcohol != null ? "consumeAlcohol=" + consumeAlcohol + ", " : "") +
                (alcoholConsDaysInWeek != null ? "alcoholConsDaysInWeek=" + alcoholConsDaysInWeek + ", " : "") +
                (ostCode != null ? "ostCode=" + ostCode + ", " : "") +
                (ostStatus != null ? "ostStatus=" + ostStatus + ", " : "") +
                (consentDocumented != null ? "consentDocumented=" + consentDocumented + ", " : "") +
                (hotspot != null ? "hotspot=" + hotspot + ", " : "") +
                (deletedReason != null ? "deletedReason=" + deletedReason + ", " : "") +
                (sexOtherThanSpouse != null ? "sexOtherThanSpouse=" + sexOtherThanSpouse + ", " : "") +
                (condomUsage != null ? "condomUsage=" + condomUsage + ", " : "") +
                (typeOfMobility != null ? "typeOfMobility=" + typeOfMobility + ", " : "") +
                (stayingWith != null ? "stayingWith=" + stayingWith + ", " : "") +
                (durationOfTheStays != null ? "durationOfTheStays=" + durationOfTheStays + ", " : "") +
                (registrationPlace != null ? "registrationPlace=" + registrationPlace + ", " : "") +
                (noOfSexualActivity != null ? "noOfSexualActivity=" + noOfSexualActivity + ", " : "") +
                (benReferredFrom != null ? "benReferredFrom=" + benReferredFrom + ", " : "") +
                (param != null ? "param=" + param + ", " : "") +
                (visitStartDate != null ? "visitStartDate=" + visitStartDate + ", " : "") +
                (visitEndDate != null ? "visitEndDate=" + visitEndDate + ", " : "") +
            "}";
    }

}
