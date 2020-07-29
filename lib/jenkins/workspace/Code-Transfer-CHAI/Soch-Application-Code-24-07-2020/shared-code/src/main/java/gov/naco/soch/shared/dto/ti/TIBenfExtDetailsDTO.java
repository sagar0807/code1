package gov.naco.soch.shared.dto.ti;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


public class TIBenfExtDetailsDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private String withinTheDistrictNoOfTimes;

    private String withinTheDistrictNoOfDays;

    private String withinTheStateNoOfTimes;

    private String withinTheStateNoOfDays;

    private String outsideTheStateNoOfTimes;

    private String outsideTheStateNoOfDays;

    private Boolean mondayAvbl;

    private Boolean tuesdayAvbl;

    private Boolean wednesdayAvbl;

    private Boolean thursdayAvbl;

    private Boolean fridayAvbl;

    private Boolean saturdayAvbl;

    private LocalDate syphilisLastScreenDate;

    private String syphilisStatus;

    private LocalDate syphilisNextScreenDate;

    private LocalDate tbLastScreenDate;

    private String tbScreeningStatus;

    private String tbConfStatus;

    private String hivStatus;

    private LocalDate hivNextScreenDate;

    private Boolean hivArtLinked;

    private String hivArtCenter;

    private String hivArtNumber;

    private String hivArtStatus;

    private String hivArtAdherence;

    private String referredFacility;

    private String referredTo;

    private String referralStatus;

    private Boolean isOutwardReferal;

    private Boolean isTransit;

    private LocalDate transitStartDate;

    private LocalDate transitEndDate;

    private String guardianName;

    private String relation;

    private String guardianContactNumber;

    private Boolean isTransfer;


    private Long beneficiaryId;
    
    private Long facilityId;   
    
    private Boolean isSyphilisTested;

    private Boolean isSyphilisTreatmentSTI;

    private Boolean isTbDiagnosed;

    private Boolean isTbSymptoms; 
    
    private Boolean isActive;
    
	private Boolean isDelete;
	
	private Set<ExtDetailsTimeAvailabilityMappingDto> extDetailsTimeAvailabilityMapping;
 
	public Boolean getIsSyphilisTested() {
		return isSyphilisTested;
	}

	public void setIsSyphilisTested(Boolean isSyphilisTested) {
		this.isSyphilisTested = isSyphilisTested;
	}

	public Boolean getIsSyphilisTreatmentSTI() {
		return isSyphilisTreatmentSTI;
	}

	public void setIsSyphilisTreatmentSTI(Boolean isSyphilisTreatmentSTI) {
		this.isSyphilisTreatmentSTI = isSyphilisTreatmentSTI;
	}
	
	public Set<ExtDetailsTimeAvailabilityMappingDto> getExtDetailsTimeAvailabilityMapping() {
		return extDetailsTimeAvailabilityMapping;
	}

	public void setExtDetailsTimeAvailabilityMapping(
			Set<ExtDetailsTimeAvailabilityMappingDto> extDetailsTimeAvailabilityMapping) {
		this.extDetailsTimeAvailabilityMapping = extDetailsTimeAvailabilityMapping;
	}

	public Boolean getIsTbDiagnosed() {
		return isTbDiagnosed;
	}

	public void setIsTbDiagnosed(Boolean isTbDiagnosed) {
		this.isTbDiagnosed = isTbDiagnosed;
	}

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

	public Boolean getIsTbSymptoms() {
		return isTbSymptoms;
	}

	public void setIsTbSymptoms(Boolean isTbSymptoms) {
		this.isTbSymptoms = isTbSymptoms;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWithinTheDistrictNoOfTimes() {
        return withinTheDistrictNoOfTimes;
    }

    public void setWithinTheDistrictNoOfTimes(String withinTheDistrictNoOfTimes) {
        this.withinTheDistrictNoOfTimes = withinTheDistrictNoOfTimes;
    }

    public String getWithinTheDistrictNoOfDays() {
        return withinTheDistrictNoOfDays;
    }

    public void setWithinTheDistrictNoOfDays(String withinTheDistrictNoOfDays) {
        this.withinTheDistrictNoOfDays = withinTheDistrictNoOfDays;
    }

    public String getWithinTheStateNoOfTimes() {
        return withinTheStateNoOfTimes;
    }

    public void setWithinTheStateNoOfTimes(String withinTheStateNoOfTimes) {
        this.withinTheStateNoOfTimes = withinTheStateNoOfTimes;
    }

    public String getWithinTheStateNoOfDays() {
        return withinTheStateNoOfDays;
    }

    public void setWithinTheStateNoOfDays(String withinTheStateNoOfDays) {
        this.withinTheStateNoOfDays = withinTheStateNoOfDays;
    }

    public String getOutsideTheStateNoOfTimes() {
        return outsideTheStateNoOfTimes;
    }

    public void setOutsideTheStateNoOfTimes(String outsideTheStateNoOfTimes) {
        this.outsideTheStateNoOfTimes = outsideTheStateNoOfTimes;
    }

    public String getOutsideTheStateNoOfDays() {
        return outsideTheStateNoOfDays;
    }

    public void setOutsideTheStateNoOfDays(String outsideTheStateNoOfDays) {
        this.outsideTheStateNoOfDays = outsideTheStateNoOfDays;
    }

    public Boolean isMondayAvbl() {
        return mondayAvbl;
    }

    public void setMondayAvbl(Boolean mondayAvbl) {
        this.mondayAvbl = mondayAvbl;
    }

    public Boolean isTuesdayAvbl() {
        return tuesdayAvbl;
    }

    public void setTuesdayAvbl(Boolean tuesdayAvbl) {
        this.tuesdayAvbl = tuesdayAvbl;
    }

    public Boolean isWednesdayAvbl() {
        return wednesdayAvbl;
    }

    public void setWednesdayAvbl(Boolean wednesdayAvbl) {
        this.wednesdayAvbl = wednesdayAvbl;
    }

    public Boolean isThursdayAvbl() {
        return thursdayAvbl;
    }

    public void setThursdayAvbl(Boolean thursdayAvbl) {
        this.thursdayAvbl = thursdayAvbl;
    }

    public Boolean isFridayAvbl() {
        return fridayAvbl;
    }

    public void setFridayAvbl(Boolean fridayAvbl) {
        this.fridayAvbl = fridayAvbl;
    }

    public Boolean isSaturdayAvbl() {
        return saturdayAvbl;
    }

    public void setSaturdayAvbl(Boolean saturdayAvbl) {
        this.saturdayAvbl = saturdayAvbl;
    }

    public LocalDate getSyphilisLastScreenDate() {
        return syphilisLastScreenDate;
    }

    public void setSyphilisLastScreenDate(LocalDate syphilisLastScreenDate) {
        this.syphilisLastScreenDate = syphilisLastScreenDate;
    }

    public String getSyphilisStatus() {
        return syphilisStatus;
    }

    public void setSyphilisStatus(String syphilisStatus) {
        this.syphilisStatus = syphilisStatus;
    }

    public LocalDate getSyphilisNextScreenDate() {
        return syphilisNextScreenDate;
    }

    public void setSyphilisNextScreenDate(LocalDate syphilisNextScreenDate) {
        this.syphilisNextScreenDate = syphilisNextScreenDate;
    }

    public LocalDate getTbLastScreenDate() {
        return tbLastScreenDate;
    }

    public void setTbLastScreenDate(LocalDate tbLastScreenDate) {
        this.tbLastScreenDate = tbLastScreenDate;
    }

    public String getTbScreeningStatus() {
        return tbScreeningStatus;
    }

    public void setTbScreeningStatus(String tbScreeningStatus) {
        this.tbScreeningStatus = tbScreeningStatus;
    }

    public String getTbConfStatus() {
        return tbConfStatus;
    }

    public void setTbConfStatus(String tbConfStatus) {
        this.tbConfStatus = tbConfStatus;
    }

    public String getHivStatus() {
        return hivStatus;
    }

    public void setHivStatus(String hivStatus) {
        this.hivStatus = hivStatus;
    }

    public LocalDate getHivNextScreenDate() {
        return hivNextScreenDate;
    }

    public void setHivNextScreenDate(LocalDate hivNextScreenDate) {
        this.hivNextScreenDate = hivNextScreenDate;
    }

    public Boolean isHivArtLinked() {
        return hivArtLinked;
    }

    public void setHivArtLinked(Boolean hivArtLinked) {
        this.hivArtLinked = hivArtLinked;
    }

    public String getHivArtCenter() {
        return hivArtCenter;
    }

    public void setHivArtCenter(String hivArtCenter) {
        this.hivArtCenter = hivArtCenter;
    }

    public String getHivArtNumber() {
        return hivArtNumber;
    }

    public void setHivArtNumber(String hivArtNumber) {
        this.hivArtNumber = hivArtNumber;
    }

    public String getHivArtStatus() {
        return hivArtStatus;
    }

    public void setHivArtStatus(String hivArtStatus) {
        this.hivArtStatus = hivArtStatus;
    }

    public String getHivArtAdherence() {
        return hivArtAdherence;
    }

    public void setHivArtAdherence(String hivArtAdherence) {
        this.hivArtAdherence = hivArtAdherence;
    }

    public String getReferredFacility() {
        return referredFacility;
    }

    public void setReferredFacility(String referredFacility) {
        this.referredFacility = referredFacility;
    }

    public String getReferredTo() {
        return referredTo;
    }

    public void setReferredTo(String referredTo) {
        this.referredTo = referredTo;
    }

    public String getReferralStatus() {
        return referralStatus;
    }

    public void setReferralStatus(String referralStatus) {
        this.referralStatus = referralStatus;
    }

    public Boolean isIsOutwardReferal() {
        return isOutwardReferal;
    }

    public void setIsOutwardReferal(Boolean isOutwardReferal) {
        this.isOutwardReferal = isOutwardReferal;
    }

    public Boolean isIsTransit() {
        return isTransit;
    }

    public void setIsTransit(Boolean isTransit) {
        this.isTransit = isTransit;
    }

    public LocalDate getTransitStartDate() {
        return transitStartDate;
    }

    public void setTransitStartDate(LocalDate transitStartDate) {
        this.transitStartDate = transitStartDate;
    }

    public LocalDate getTransitEndDate() {
        return transitEndDate;
    }

    public void setTransitEndDate(LocalDate transitEndDate) {
        this.transitEndDate = transitEndDate;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getGuardianContactNumber() {
        return guardianContactNumber;
    }

    public void setGuardianContactNumber(String guardianContactNumber) {
        this.guardianContactNumber = guardianContactNumber;
    }

    public Boolean isIsTransfer() {
        return isTransfer;
    }

    public void setIsTransfer(Boolean isTransfer) {
        this.isTransfer = isTransfer;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long tIBeneficiaryId) {
        this.beneficiaryId = tIBeneficiaryId;
    }

    public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public Boolean getMondayAvbl() {
		return mondayAvbl;
	}

	public Boolean getTuesdayAvbl() {
		return tuesdayAvbl;
	}

	public Boolean getWednesdayAvbl() {
		return wednesdayAvbl;
	}

	public Boolean getThursdayAvbl() {
		return thursdayAvbl;
	}

	public Boolean getFridayAvbl() {
		return fridayAvbl;
	}

	public Boolean getSaturdayAvbl() {
		return saturdayAvbl;
	}

	public Boolean getHivArtLinked() {
		return hivArtLinked;
	}

	public Boolean getIsOutwardReferal() {
		return isOutwardReferal;
	}

	public Boolean getIsTransit() {
		return isTransit;
	}

	public Boolean getIsTransfer() {
		return isTransfer;
	}
	
	

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TIBenfExtDetailsDTO tIBenfExtDetailsDTO = (TIBenfExtDetailsDTO) o;
        if (tIBenfExtDetailsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tIBenfExtDetailsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TIBenExtDetailsDTO{" +
            "id=" + getId() +
            ", withinTheDistrictNoOfTimes='" + getWithinTheDistrictNoOfTimes() + "'" +
            ", withinTheDistrictNoOfDays='" + getWithinTheDistrictNoOfDays() + "'" +
            ", withinTheStateNoOfTimes='" + getWithinTheStateNoOfTimes() + "'" +
            ", withinTheStateNoOfDays='" + getWithinTheStateNoOfDays() + "'" +
            ", outsideTheStateNoOfTimes='" + getOutsideTheStateNoOfTimes() + "'" +
            ", outsideTheStateNoOfDays='" + getOutsideTheStateNoOfDays() + "'" +
            ", mondayAvbl='" + isMondayAvbl() + "'" +
            ", tuesdayAvbl='" + isTuesdayAvbl() + "'" +
            ", wednesdayAvbl='" + isWednesdayAvbl() + "'" +
            ", thursdayAvbl='" + isThursdayAvbl() + "'" +
            ", fridayAvbl='" + isFridayAvbl() + "'" +
            ", saturdayAvbl='" + isSaturdayAvbl() + "'" +
            ", syphilisLastScreenDate='" + getSyphilisLastScreenDate() + "'" +
            ", syphilisStatus='" + getSyphilisStatus() + "'" +
            ", syphilisNextScreenDate='" + getSyphilisNextScreenDate() + "'" +
            ", tbLastScreenDate='" + getTbLastScreenDate() + "'" +
            ", tbScreeningStatus='" + getTbScreeningStatus() + "'" +
            ", tbConfStatus='" + getTbConfStatus() + "'" +
            ", hivStatus='" + getHivStatus() + "'" +
            ", hivNextScreenDate='" + getHivNextScreenDate() + "'" +
            ", hivArtLinked='" + isHivArtLinked() + "'" +
            ", hivArtCenter='" + getHivArtCenter() + "'" +
            ", hivArtNumber='" + getHivArtNumber() + "'" +
            ", hivArtStatus='" + getHivArtStatus() + "'" +
            ", hivArtAdherence='" + getHivArtAdherence() + "'" +
            ", referredFacility='" + getReferredFacility() + "'" +
            ", referredTo='" + getReferredTo() + "'" +
            ", referralStatus='" + getReferralStatus() + "'" +
            ", isOutwardReferal='" + isIsOutwardReferal() + "'" +
            ", isTransit='" + isIsTransit() + "'" +
            ", transitStartDate='" + getTransitStartDate() + "'" +
            ", transitEndDate='" + getTransitEndDate() + "'" +
            ", guardianName='" + getGuardianName() + "'" +
            ", relation='" + getRelation() + "'" +
            ", guardianContactNumber='" + getGuardianContactNumber() + "'" +
            ", isTransfer='" + isIsTransfer() + "'" +
            ", beneficiary=" + getBeneficiaryId() +
            "}";
    }
}

