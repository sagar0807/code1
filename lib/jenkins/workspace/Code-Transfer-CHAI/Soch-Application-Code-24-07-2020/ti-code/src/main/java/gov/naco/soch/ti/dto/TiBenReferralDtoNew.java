package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import gov.naco.soch.dto.MiniMasterDto;

public class TiBenReferralDtoNew implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    private String uId;

    private String name;

    private int age;

    private String tiCode;

    private Long registeredFacility;

    private String registeredFacilityName;

    private Long referredFacilityFrom;

    private String referredFacilityFromName;

    private Long referredFacilityTo;

    private String referredFacilityToName;

    private LocalDate dateOfReferral;

    private String mobileNumber;

    private Long beneficiaryId;

    private Integer facilityType;

    private String facilityTypeName;

    private String referralReason;

    private String status;

    private MiniMasterDto masterClientStatus;

    private MiniMasterDto genderId;

    private String hivStatus;

    private String typeOfHiv;

    private String infectionName;

    private Long infectionId;

    private TIBenScrDetailsDTO tiBenScrDetails;
    
    private long count;
    
    private String facilityType_Name;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getuId() {
	return uId;
    }

    public void setuId(String uId) {
	this.uId = uId;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public String getTiCode() {
	return tiCode;
    }

    public void setTiCode(String tiCode) {
	this.tiCode = tiCode;
    }

    public String getHivStatus() {
	return hivStatus;
    }

    public void setHivStatus(String hivStatus) {
	this.hivStatus = hivStatus;
    }

    public String getTypeOfHiv() {
	return typeOfHiv;
    }

    public void setTypeOfHiv(String typeOfHiv) {
	this.typeOfHiv = typeOfHiv;
    }

    public LocalDate getDateOfReferral() {
	return dateOfReferral;
    }

    public void setDateOfReferral(LocalDate dateOfReferral) {
	this.dateOfReferral = dateOfReferral;
    }

    public String getInfectionName() {
	return infectionName;
    }

    public void setInfectionName(String infectionName) {
	this.infectionName = infectionName;
    }

    public Long getInfectionId() {
	return infectionId;
    }

    public void setInfectionId(Long infectionId) {
	this.infectionId = infectionId;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public Long getReferredFacilityFrom() {
	return referredFacilityFrom;
    }

    public void setReferredFacilityFrom(Long referredFacilityFrom) {
	this.referredFacilityFrom = referredFacilityFrom;
    }

    public String getReferredFacilityFromName() {
	return referredFacilityFromName;
    }

    public void setReferredFacilityFromName(String referredFacilityFromName) {
	this.referredFacilityFromName = referredFacilityFromName;
    }

    public Long getReferredFacilityTo() {
	return referredFacilityTo;
    }

    public void setReferredFacilityTo(Long referredFacilityTo) {
	this.referredFacilityTo = referredFacilityTo;
    }

    public String getReferredFacilityToName() {
	return referredFacilityToName;
    }

    public void setReferredFacilityToName(String referredFacilityToName) {
	this.referredFacilityToName = referredFacilityToName;
    }

    public Long getRegisteredFacility() {
	return registeredFacility;
    }

    public void setRegisteredFacility(Long registeredFacility) {
	this.registeredFacility = registeredFacility;
    }

    public String getMobileNumber() {
	return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
    }

    public long getCount() {
	return count;
    }

    public void setCount(long count) {
	this.count = count;
    }

    public TIBenScrDetailsDTO getTiBenScrDetails() {
	return tiBenScrDetails;
    }

    public void setTiBenScrDetails(TIBenScrDetailsDTO tiBenScrDetails) {
	this.tiBenScrDetails = tiBenScrDetails;
    }

    public Long getBeneficiaryId() {
	return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
	this.beneficiaryId = beneficiaryId;
    }

    public String getFacilityType_Name() {
	return facilityType_Name;
    }

    public void setFacilityType_Name(String facilityType_Name) {
	this.facilityType_Name = facilityType_Name;
    }

    public String getRegisteredFacilityName() {
	return registeredFacilityName;
    }

    public void setRegisteredFacilityName(String registeredFacilityName) {
	this.registeredFacilityName = registeredFacilityName;
    }

    public Integer getFacilityType() {
	return facilityType;
    }

    public void setFacilityType(Integer facilityType) {
	this.facilityType = facilityType;
    }

    public String getFacilityTypeName() {
	return facilityTypeName;
    }

    public void setFacilityTypeName(String facilityTypeName) {
	this.facilityTypeName = facilityTypeName;
    }

    public String getReferralReason() {
	return referralReason;
    }

    public void setReferralReason(String referralReason) {
	this.referralReason = referralReason;
    }

    public MiniMasterDto getMasterClientStatus() {
	return masterClientStatus;
    }

    public void setMasterClientStatus(MiniMasterDto masterClientStatus) {
	this.masterClientStatus = masterClientStatus;
    }

//	public MiniMasterDto getScreeningStatusHiv() {
//		return screeningStatusHiv;
//	}
//
//	public void setScreeningStatusHiv(MiniMasterDto screeningStatusHiv) {
//		this.screeningStatusHiv = screeningStatusHiv;
//	}
//
//	public MiniMasterDto getTbStatus() {
//		return tbStatus;
//	}
//
//	public void setTbStatus(MiniMasterDto tbStatus) {
//		this.tbStatus = tbStatus;
//	}
//
//	public MiniMasterDto getScreeningStatusSyphilis() {
//		return screeningStatusSyphilis;
//	}
//
//	public void setScreeningStatusSyphilis(MiniMasterDto screeningStatusSyphilis) {
//		this.screeningStatusSyphilis = screeningStatusSyphilis;
//	}

    public MiniMasterDto getGenderId() {
	return genderId;
    }

    public void setGenderId(MiniMasterDto genderId) {
	this.genderId = genderId;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o) {
	    return true;
	}
	if (o == null || getClass() != o.getClass()) {
	    return false;
	}

	TiBenReferralDtoNew tIBenReferralDTONew = (TiBenReferralDtoNew) o;
	if (tIBenReferralDTONew.getId() == null || getId() == null) {
	    return false;
	}
	return Objects.equals(getId(), tIBenReferralDTONew.getId());
    }

    @Override
    public int hashCode() {
	return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
	return "TIBenReferralDTO{" + "id=" + getId() + ", uId=" + getuId() + ", name=" + getName() + ", age=" + getAge()
		+ ", tiCode=" + getTiCode() + ", referredFacilityFrom=" + getReferredFacilityFrom()
		+ ", referredFacilityFromName=" + getReferredFacilityFromName() + ", referredFacilityTo="
		+ getReferredFacilityTo() + ", referredFacilityToName=" + getReferredFacilityToName()
		+ ", registeredFacility=" + getRegisteredFacility() + ", mobileNumber=" + getMobileNumber()
		+ ", beneficiaryId=" + getBeneficiaryId() + ", registeredFacilityName" + getRegisteredFacilityName()
		+ "}";
    }
}