package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import gov.naco.soch.dto.BeneficiaryDto;
import gov.naco.soch.dto.BeneficiaryReferralDto;
import gov.naco.soch.dto.MiniMasterDto;

/**
 * A DTO for the {@link gov.naco.soch.domain.TIBeneficiary} entity.
 */
public class TIBeneficiaryDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
//	private String geoLatitude;
//	private String geoLongitude;
	private LocalDate dateOfReg;
	private FacilityDTO facility;
	//private String typology;
	private String tiCode;
	private String peCode;
	private String orwCode;
	private String numberOfPartners;
	private String regularPartners;
	private String otherEmploymentStatus;
	//private Boolean condomUsage;
	private Long avgNoSexualActsUponReg;
	private Long noYearsInSexWork;
	private Boolean consumeAlcohol;
	private Long alcoholConsDaysInWeek;
//	private Boolean consentDocumented;
	private Long hotspot;
	private Boolean sexOtherThanSpouse;
//	private String category;
//	private String beneficiaryActivityStatus;
//	private String beneficiaryType;
//	private String uid;
//	private String benReferredFrom;
	private Integer noOfSexualActivity;
	private Boolean isActive;
	private Boolean isDeleted;
	private Integer lapTreatments;
	private Integer ibTreatments;
	private BeneficiaryDto masterBeneficiary;
	private BeneficiaryReferralDto beneficiaryReferralDto;
	private TiBenTransferDto benTransferDto;
	private TIBenfExtDetailsDTO tiBeneficiaryExtDetails;
	private Set<TIBenChildDetailsDTO> tiBenChildren;
	private Set<TIBenCounsellingDTO_Initial> tiCounselling;
	private Set<TIBenRVAssessmentDTO_Initial> tiAssessment;
	private Set<TIStiTreatmentDTO_Initial> tiStiTreatment;
	private Set<TIBenScrDetailsDTO_Initial> tiScreening;
	private Set<HotspotBenMappingDto> hotspotBenMapping; 
	private String currentTransferStatus;
	// Minimasters
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
	private MiniMasterDto status;
	private MiniMasterDto truckerOccupation;
	private MiniMasterDto migrationPattern;
	private long count;
	private Boolean isTransferred;
	private Integer distancePerDay;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public String getGeoLatitude() {
//		return geoLatitude;
//	}
//
//	public void setGeoLatitude(String geoLatitude) {
//		this.geoLatitude = geoLatitude;
//	}
//
//	public String getGeoLongitude() {
//		return geoLongitude;
//	}
//
//	public void setGeoLongitude(String geoLongitude) {
//		this.geoLongitude = geoLongitude;
//	}
//
//	public String getTypology() {
//		return typology;
//	}
//
//	public void setTypology(String typology) {
//		this.typology = typology;
//	}

	public String getTiCode() {
		return tiCode;
	}

	public void setTiCode(String tiCode) {
		this.tiCode = tiCode;
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

//	public Boolean getCondomUsage() {
//		return condomUsage;
//	}
//
//	public void setCondomUsage(Boolean condomUsage) {
//		this.condomUsage = condomUsage;
//	}

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

//	public Boolean getConsentDocumented() {
//		return consentDocumented;
//	}
//
//	public void setConsentDocumented(Boolean consentDocumented) {
//		this.consentDocumented = consentDocumented;
//	}

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
//
//	public String getCategory() {
//		return category;
//	}
//
//	public void setCategory(String category) {
//		this.category = category;
//	}
//
//	public String getBeneficiaryActivityStatus() {
//		return beneficiaryActivityStatus;
//	}
//
//	public void setBeneficiaryActivityStatus(String beneficiaryActivityStatus) {
//		this.beneficiaryActivityStatus = beneficiaryActivityStatus;
//	}
//
//	public String getBeneficiaryType() {
//		return beneficiaryType;
//	}
//
//	public void setBeneficiaryType(String beneficiaryType) {
//		this.beneficiaryType = beneficiaryType;
//	}
//
//	public String getUid() {
//		return uid;
//	}
//
//	public void setUid(String uid) {
//		this.uid = uid;
//	}
//
//	public String getBenReferredFrom() {
//		return benReferredFrom;
//	}
//
//	public void setBenReferredFrom(String benReferredFrom) {
//		this.benReferredFrom = benReferredFrom;
//	}

	public BeneficiaryDto getMasterBeneficiary() {
		return masterBeneficiary;
	}

	public void setMasterBeneficiary(BeneficiaryDto masterBeneficiary) {
		this.masterBeneficiary = masterBeneficiary;
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

	public MiniMasterDto getMasterStayingWith() {
		return masterStayingWith;
	}

	public TIBenfExtDetailsDTO getTiBeneficiaryExtDetails() {
		return tiBeneficiaryExtDetails;
	}

	public void setTiBeneficiaryExtDetails(TIBenfExtDetailsDTO tiBeneficiaryExtDetails) {
		this.tiBeneficiaryExtDetails = tiBeneficiaryExtDetails;

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

	public MiniMasterDto getMasterDestinationDuration() {
		return masterDestinationDuration;
	}

	public void setMasterDestinationDuration(MiniMasterDto masterDestinationDuration) {
		this.masterDestinationDuration = masterDestinationDuration;
	}

	public Integer getNoOfSexualActivity() {
		return noOfSexualActivity;
	}

	public void setNoOfSexualActivity(Integer noOfSexualActivity) {
		this.noOfSexualActivity = noOfSexualActivity;
	}

	public LocalDate getDateOfReg() {
		return dateOfReg;
	}

	public void setDateOfReg(LocalDate dateOfReg) {
		this.dateOfReg = dateOfReg;
	}

	public String getCurrentTransferStatus() {
		return currentTransferStatus;
	}

	public void setCurrentTransferStatus(String currentTransferStatus) {
		this.currentTransferStatus = currentTransferStatus;
	}

	public MiniMasterDto getMigrantOccupation() {
		return migrantOccupation;
	}

	public void setMigrantOccupation(MiniMasterDto migrantOccupation) {
		this.migrantOccupation = migrantOccupation;
	}

	public Set<HotspotBenMappingDto> getHotspotBenMapping() {
		return hotspotBenMapping;
	}

	public void setHotspotBenMapping(Set<HotspotBenMappingDto> hotspotBenMapping) {
		this.hotspotBenMapping = hotspotBenMapping;
	}

	public long getCount() {
	    return count;
	}

	public void setCount(long count) {
	    this.count = count;
	}

	public Set<TIBenChildDetailsDTO> getTiBenChildren() {
		return tiBenChildren;
	}

	public void setTiBenChildren(Set<TIBenChildDetailsDTO> tiBenChildren) {
		this.tiBenChildren = tiBenChildren;
	}

	public Boolean getIsTransferred() {
	    return isTransferred;
	}

	public void setIsTransferred(Boolean isTransferred) {
	    this.isTransferred = isTransferred;
	}

	public MiniMasterDto getTruckerOccupation() {
	    return truckerOccupation;
	}

	public void setTruckerOccupation(MiniMasterDto truckerOccupation) {
	    this.truckerOccupation = truckerOccupation;
	}

	public FacilityDTO getFacility() {
		return facility;
	}

	public void setFacility(FacilityDTO facility) {
		this.facility = facility;
	}

	public BeneficiaryReferralDto getBeneficiaryReferralDto() {
		return beneficiaryReferralDto;
	}

	public void setBeneficiaryReferralDto(BeneficiaryReferralDto beneficiaryReferralDto) {
		this.beneficiaryReferralDto = beneficiaryReferralDto;
	}

	public MiniMasterDto getMigrationPattern() {
	    return migrationPattern;
	}

	public void setMigrationPattern(MiniMasterDto migrationPattern) {
	    this.migrationPattern = migrationPattern;
	}

	public MiniMasterDto getStatus() {
	    return status;
	}

	public void setStatus(MiniMasterDto status) {
	    this.status = status;
	}

	public TiBenTransferDto getBenTransferDto() {
		return benTransferDto;
	}

	public void setBenTransferDto(TiBenTransferDto benTransferDto) {
		this.benTransferDto = benTransferDto;
	}

	public Set<TIBenCounsellingDTO_Initial> getTiCounselling() {
		return tiCounselling;
	}

	public void setTiCounselling(Set<TIBenCounsellingDTO_Initial> tiCounselling) {
		this.tiCounselling = tiCounselling;
	}

	public Set<TIBenRVAssessmentDTO_Initial> getTiAssessment() {
		return tiAssessment;
	}

	public void setTiAssessment(Set<TIBenRVAssessmentDTO_Initial> tiAssessment) {
		this.tiAssessment = tiAssessment;
	}

	public Set<TIStiTreatmentDTO_Initial> getTiStiTreatment() {
		return tiStiTreatment;
	}

	public void setTiStiTreatment(Set<TIStiTreatmentDTO_Initial> tiStiTreatment) {
		this.tiStiTreatment = tiStiTreatment;
	}

	public Set<TIBenScrDetailsDTO_Initial> getTiScreening() {
		return tiScreening;
	}

	public void setTiScreening(Set<TIBenScrDetailsDTO_Initial> tiScreening) {
		this.tiScreening = tiScreening;
	}

	public MiniMasterDto getHrgPrimary() {
		return hrgPrimary;
	}

	public void setHrgPrimary(MiniMasterDto hrgPrimary) {
		this.hrgPrimary = hrgPrimary;
	}
	
	public Integer getDistancePerDay() {
		return distancePerDay;
	}

	public void setDistancePerDay(Integer distancePerDay) {
		this.distancePerDay = distancePerDay;
	}
	

//	@Override
//	public String toString() {
//		return "TIBeneficiaryDTO [id=" + id + ", geoLatitude=" + geoLatitude + ", geoLongitude=" + geoLongitude
//				+ ", dateOfReg=" + dateOfReg + ", facility=" + facility + ", typology=" + typology + ", tiCode="
//				+ tiCode + ", peCode=" + peCode + ", orwCode=" + orwCode + ", numberOfPartners=" + numberOfPartners
//				+ ", regularPartners=" + regularPartners + ", otherEmploymentStatus=" + otherEmploymentStatus
//				+ ", condomUsage=" + condomUsage + ", avgNoSexualActsUponReg=" + avgNoSexualActsUponReg
//				+ ", noYearsInSexWork=" + noYearsInSexWork + ", consumeAlcohol=" + consumeAlcohol
//				+ ", alcoholConsDaysInWeek=" + alcoholConsDaysInWeek + ", consentDocumented=" + consentDocumented
//				+ ", hotspot=" + hotspot + ", deletedReason=" + deletedReason + ", sexOtherThanSpouse="
//				+ sexOtherThanSpouse + ", category=" + category + ", beneficiaryActivityStatus="
//				+ beneficiaryActivityStatus + ", beneficiaryType=" + beneficiaryType + ", uid=" + uid
//				+ ", benReferredFrom=" + benReferredFrom + ", noOfSexualActivity=" + noOfSexualActivity + ", isActive="
//				+ isActive + ", isDeleted=" + isDeleted + ", lapTreatments=" + lapTreatments + ", ibTreatments="
//				+ ibTreatments + ", masterBeneficiary=" + masterBeneficiary + ", beneficiaryReferralDto="
//				+ beneficiaryReferralDto + ", benTransferDto=" + benTransferDto + ", tiBenChildren=" + tiBenChildren
//				+ ", tiCounselling=" + tiCounselling + ", tiAssessment=" + tiAssessment + ", tiStiTreatment="
//				+ tiStiTreatment + ", tiScreening=" + tiScreening + ", currentTransferStatus=" + currentTransferStatus
//				+ ", hrgPrimary=" + hrgPrimary + ", hrgSecondary=" + hrgSecondary + ", subCategory=" + subCategory
//				+ ", masterRegistrationDoneAt=" + masterRegistrationDoneAt + ", masterStayingWith=" + masterStayingWith
//				+ ", masterMobilityType=" + masterMobilityType + ", masterDestinationDuration="
//				+ masterDestinationDuration + "]";
//	}
	

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		TIBeneficiaryDTO tIBeneficiaryDTO = (TIBeneficiaryDTO) o;
		if (tIBeneficiaryDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), tIBeneficiaryDTO.getId());
	}



	

	@Override
	public String toString() {
		return "TIBeneficiaryDTO [id=" + id + ", dateOfReg=" + dateOfReg + ", facility=" + facility + ", tiCode="
				+ tiCode + ", peCode=" + peCode + ", orwCode=" + orwCode + ", numberOfPartners=" + numberOfPartners
				+ ", regularPartners=" + regularPartners + ", otherEmploymentStatus=" + otherEmploymentStatus
				+ ", avgNoSexualActsUponReg=" + avgNoSexualActsUponReg + ", noYearsInSexWork=" + noYearsInSexWork
				+ ", consumeAlcohol=" + consumeAlcohol + ", alcoholConsDaysInWeek=" + alcoholConsDaysInWeek
				+ ", hotspot=" + hotspot + ", sexOtherThanSpouse=" + sexOtherThanSpouse + ", noOfSexualActivity="
				+ noOfSexualActivity + ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", lapTreatments="
				+ lapTreatments + ", ibTreatments=" + ibTreatments + ", masterBeneficiary=" + masterBeneficiary
				+ ", beneficiaryReferralDto=" + beneficiaryReferralDto + ", benTransferDto=" + benTransferDto
				+ ", tiBeneficiaryExtDetails=" + tiBeneficiaryExtDetails + ", tiBenChildren=" + tiBenChildren
				+ ", tiCounselling=" + tiCounselling + ", tiAssessment=" + tiAssessment + ", tiStiTreatment="
				+ tiStiTreatment + ", tiScreening=" + tiScreening + ", currentTransferStatus=" + currentTransferStatus
				+ ", hrgPrimary=" + hrgPrimary + ", hrgSecondary=" + hrgSecondary + ", masterRegistrationDoneAt="
				+ masterRegistrationDoneAt + ", masterStayingWith=" + masterStayingWith + ", masterMobilityType="
				+ masterMobilityType + ", masterDestinationDuration=" + masterDestinationDuration + ", fswSubCategory="
				+ fswSubCategory + ", msmSubCategory=" + msmSubCategory + ", iduSubCategory=" + iduSubCategory
				+ ", tgSubCategory=" + tgSubCategory + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

}
