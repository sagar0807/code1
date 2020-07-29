package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import gov.naco.soch.dto.BeneficiaryReferralDto;
import gov.naco.soch.dto.MiniMasterDto;

public class TiBenDto implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private LocalDate dateOfReg;
    private FacilityDTO facility;
    private String tiCode;
    private String peCode;
    private String orwCode;
    private String numberOfPartners;
    private String regularPartners;
    private String otherEmploymentStatus;
    private Long avgNoSexualActsUponReg;
    private Long noYearsInSexWork;
    private Boolean consumeAlcohol;
    private Long alcoholConsDaysInWeek;
    private Long hotspot;
    private Boolean sexOtherThanSpouse;
    private Integer noOfSexualActivity;
    private Boolean isActive;
    private Boolean isDeleted;
    private Integer lapTreatments;
    private Integer ibTreatments;
    private MasterBenDto masterBeneficiary;
    private BeneficiaryReferralDto beneficiaryReferralDto;
    private TiBenTransferDto benTransferDto;
    private TIBenfExtDetailsDTO tiBeneficiaryExtDetails;
    private Set<TIBenChildDetailsDTO> tiBenChildren;
    private Set<HotspotBenMappingDto> hotspotBenMapping; 
    private String currentTransferStatus;
    private MiniMasterDto hrgPrimary;
    private MiniMasterDto hrgSecondary;
    private MiniMasterDto masterRegistrationDoneAt;
    private MiniMasterDto masterStayingWith;
    private MiniMasterDto masterMobilityType;
    private MiniMasterDto masterDestinationDuration;
    private MiniMasterDto fswSubCategory;
    private MiniMasterDto msmSubCategory;
    private MiniMasterDto iduSubCategory;
    private MiniMasterDto tgSubCategory;
    private MiniMasterDto migrantOccupation;
    private MiniMasterDto truckerOccupation;
    private MiniMasterDto migrationPattern;
    private MiniMasterDto status;
    private long count;
    private Boolean isTransferred;
    private Integer distancePerDay;

    public TiBenDto() {

    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public LocalDate getDateOfReg() {
	return dateOfReg;
    }

    public void setDateOfReg(LocalDate dateOfReg) {
	this.dateOfReg = dateOfReg;
    }

    public FacilityDTO getFacility() {
	return facility;
    }

    public void setFacility(FacilityDTO facility) {
	this.facility = facility;
    }

    public String getTiCode() {
	return tiCode;
    }

    public void setTiCode(String tiCode) {
	this.tiCode = tiCode;
    }

    public String getPeCode() {
	return peCode;
    }

    public void setPeCode(String peCode) {
	this.peCode = peCode;
    }

    public String getOrwCode() {
	return orwCode;
    }
   
    public void setOrwCode(String orwCode) {
	this.orwCode = orwCode;
    }

    public String getNumberOfPartners() {
	return numberOfPartners;
    }

    public void setNumberOfPartners(String numberOfPartners) {
	this.numberOfPartners = numberOfPartners;
    }

    public String getRegularPartners() {
	return regularPartners;
    }

    public void setRegularPartners(String regularPartners) {
	this.regularPartners = regularPartners;
    }

    public String getOtherEmploymentStatus() {
	return otherEmploymentStatus;
    }

    public void setOtherEmploymentStatus(String otherEmploymentStatus) {
	this.otherEmploymentStatus = otherEmploymentStatus;
    }

    public Long getAvgNoSexualActsUponReg() {
	return avgNoSexualActsUponReg;
    }

    public void setAvgNoSexualActsUponReg(Long avgNoSexualActsUponReg) {
	this.avgNoSexualActsUponReg = avgNoSexualActsUponReg;
    }

    public Long getNoYearsInSexWork() {
	return noYearsInSexWork;
    }

    public void setNoYearsInSexWork(Long noYearsInSexWork) {
	this.noYearsInSexWork = noYearsInSexWork;
    }

    public Boolean getConsumeAlcohol() {
	return consumeAlcohol;
    }

    public void setConsumeAlcohol(Boolean consumeAlcohol) {
	this.consumeAlcohol = consumeAlcohol;
    }

    public Long getAlcoholConsDaysInWeek() {
	return alcoholConsDaysInWeek;
    }

    public void setAlcoholConsDaysInWeek(Long alcoholConsDaysInWeek) {
	this.alcoholConsDaysInWeek = alcoholConsDaysInWeek;
    }

    public Long getHotspot() {
	return hotspot;
    }

    public void setHotspot(Long hotspot) {
	this.hotspot = hotspot;
    }

    public Boolean getSexOtherThanSpouse() {
	return sexOtherThanSpouse;
    }

    public void setSexOtherThanSpouse(Boolean sexOtherThanSpouse) {
	this.sexOtherThanSpouse = sexOtherThanSpouse;
    }

    public Integer getNoOfSexualActivity() {
	return noOfSexualActivity;
    }

    public void setNoOfSexualActivity(Integer noOfSexualActivity) {
	this.noOfSexualActivity = noOfSexualActivity;
    }

    public Boolean getIsActive() {
	return isActive;
    }

    public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
    }

    public Boolean getIsDeleted() {
	return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
	this.isDeleted = isDeleted;
    }

    public Integer getLapTreatments() {
	return lapTreatments;
    }

    public void setLapTreatments(Integer lapTreatments) {
	this.lapTreatments = lapTreatments;
    }

    public Integer getIbTreatments() {
	return ibTreatments;
    }

    public void setIbTreatments(Integer ibTreatments) {
	this.ibTreatments = ibTreatments;
    }

    public MasterBenDto getMasterBeneficiary() {
	return masterBeneficiary;
    }

    public void setMasterBeneficiary(MasterBenDto masterBeneficiary) {
	this.masterBeneficiary = masterBeneficiary;
    }

    public BeneficiaryReferralDto getBeneficiaryReferralDto() {
	return beneficiaryReferralDto;
    }

    public void setBeneficiaryReferralDto(BeneficiaryReferralDto beneficiaryReferralDto) {
	this.beneficiaryReferralDto = beneficiaryReferralDto;
    }

    public TiBenTransferDto getBenTransferDto() {
	return benTransferDto;
    }

    public void setBenTransferDto(TiBenTransferDto benTransferDto) {
	this.benTransferDto = benTransferDto;
    }

    public TIBenfExtDetailsDTO getTiBeneficiaryExtDetails() {
	return tiBeneficiaryExtDetails;
    }

    public void setTiBeneficiaryExtDetails(TIBenfExtDetailsDTO tiBeneficiaryExtDetails) {
	this.tiBeneficiaryExtDetails = tiBeneficiaryExtDetails;
    }

    public Set<TIBenChildDetailsDTO> getTiBenChildren() {
	return tiBenChildren;
    }

    public void setTiBenChildren(Set<TIBenChildDetailsDTO> tiBenChildren) {
	this.tiBenChildren = tiBenChildren;
    }

    public String getCurrentTransferStatus() {
	return currentTransferStatus;
    }

    public void setCurrentTransferStatus(String currentTransferStatus) {
	this.currentTransferStatus = currentTransferStatus;
    }

    public MiniMasterDto getHrgPrimary() {
	return hrgPrimary;
    }

    public void setHrgPrimary(MiniMasterDto hrgPrimary) {
	this.hrgPrimary = hrgPrimary;
    }

    public MiniMasterDto getHrgSecondary() {
	return hrgSecondary;
    }

    public void setHrgSecondary(MiniMasterDto hrgSecondary) {
	this.hrgSecondary = hrgSecondary;
    }

    public MiniMasterDto getMasterRegistrationDoneAt() {
	return masterRegistrationDoneAt;
    }

    public void setMasterRegistrationDoneAt(MiniMasterDto masterRegistrationDoneAt) {
	this.masterRegistrationDoneAt = masterRegistrationDoneAt;
    }

    public Boolean getIsTransferred() {
	return isTransferred;
    }

    public void setIsTransferred(Boolean isTransferred) {
	this.isTransferred = isTransferred;
    }

    public Set<HotspotBenMappingDto> getHotspotBenMapping() {
	return hotspotBenMapping;
    }

    public void setHotspotBenMapping(Set<HotspotBenMappingDto> hotspotBenMapping) {
	this.hotspotBenMapping = hotspotBenMapping;
    }

    public MiniMasterDto getTruckerOccupation() {
	return truckerOccupation;
    }

    public void setTruckerOccupation(MiniMasterDto truckerOccupation) {
	this.truckerOccupation = truckerOccupation;
    }

    public MiniMasterDto getMasterStayingWith() {
	return masterStayingWith;
    }

    public void setMasterStayingWith(MiniMasterDto masterStayingWith) {
	this.masterStayingWith = masterStayingWith;
    }

    public MiniMasterDto getMasterMobilityType() {
	return masterMobilityType;
    }

    public void setMasterMobilityType(MiniMasterDto masterMobilityType) {
	this.masterMobilityType = masterMobilityType;
    }

    public MiniMasterDto getMigrationPattern() {
	return migrationPattern;
    }

    public void setMigrationPattern(MiniMasterDto migrationPattern) {
	this.migrationPattern = migrationPattern;
    }

    public MiniMasterDto getMasterDestinationDuration() {
	return masterDestinationDuration;
    }

    public void setMasterDestinationDuration(MiniMasterDto masterDestinationDuration) {
	this.masterDestinationDuration = masterDestinationDuration;
    }

    public MiniMasterDto getFswSubCategory() {
	return fswSubCategory;
    }
    
    

    public void setFswSubCategory(MiniMasterDto fswSubCategory) {
	this.fswSubCategory = fswSubCategory;
    }

    public MiniMasterDto getMsmSubCategory() {
	return msmSubCategory;
    }

    public void setMsmSubCategory(MiniMasterDto msmSubCategory) {
	this.msmSubCategory = msmSubCategory;
    }

    public MiniMasterDto getIduSubCategory() {
	return iduSubCategory;
    }

    public void setIduSubCategory(MiniMasterDto iduSubCategory) {
	this.iduSubCategory = iduSubCategory;
    }

    public MiniMasterDto getTgSubCategory() {
	return tgSubCategory;
    }

    public void setTgSubCategory(MiniMasterDto tgSubCategory) {
	this.tgSubCategory = tgSubCategory;
    }

    public MiniMasterDto getMigrantOccupation() {
	return migrantOccupation;
    }

    public void setMigrantOccupation(MiniMasterDto migrantOccupation) {
	this.migrantOccupation = migrantOccupation;
    }

    public MiniMasterDto getStatus() {
	return status;
    }

    public void setStatus(MiniMasterDto status) {
	this.status = status;
    }

    public long getCount() {
	return count;
    }

    public void setCount(long count) {
	this.count = count;
    }

	public Integer getDistancePerDay() {
		return distancePerDay;
	}

	public void setDistancePerDay(Integer distancePerDay) {
		this.distancePerDay = distancePerDay;
	}
}
