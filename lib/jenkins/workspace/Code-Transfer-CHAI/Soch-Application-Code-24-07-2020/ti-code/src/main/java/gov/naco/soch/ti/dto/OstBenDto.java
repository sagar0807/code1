package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import gov.naco.soch.constructordto.TiOstDispensationItemDTO;
import gov.naco.soch.dto.BeneficiaryDto;
import gov.naco.soch.dto.BeneficiaryReferralDto;
import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.dto.TiBeneficiaryAddressDto;

public class OstBenDto implements Serializable {

    /**
    * 
    */
    private static final long serialVersionUID = 1L;

    private Long id;

    private Boolean consentDocumented;

    private String guardianContactNumber;

    private String guardianName;

    private MiniMasterDto guardianRelationshipType;

    private Boolean isActive;

    private Boolean isDeleted;

    private Boolean isOnDot;

    private Boolean isTbDiagnosed;

    private Boolean isTestedForSyphilis;

    private Boolean isTransferOut;

    private Boolean isTransit;

    private String ostCode;

    private String ostNumber;

    private MiniMasterDto ostStatus;

    private Boolean receivedStiTreatment;

    private LocalDate registrationDate;

    private Boolean tbSymptoms;

    private LocalDate transitEndDate;

    private LocalDate transitStartDate;

    private MiniMasterDto hrgPrimary;

    private Integer numberOfPartners;

    private Boolean regularPartners;

    private Integer followups;

    private TiBeneficiaryAddressDto address;

    private MasterBenDto masterBeneficiary;

    private FacilityDTO facility;

    private TiOstDispensationItemDTO dispensation;

    private Set<BeneficiaryTransitFacilityDto> transitFacilities;

    private Long linkedFacilityId;

    private String currentTransferStatus;

    private LocalDate consentTakenDate;

    private MiniMasterDto referredFrom;

    private MiniMasterDto status;

    private Set<HotspotBenMappingDto> hotspotBenMapping;

    private long count;
    
    private Boolean isTransferred;

    public OstBenDto() {
	// TODO Auto-generated constructor stub
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Boolean getConsentDocumented() {
	return consentDocumented;
    }

    public void setConsentDocumented(Boolean consentDocumented) {
	this.consentDocumented = consentDocumented;
    }

    public String getGuardianContactNumber() {
	return guardianContactNumber;
    }

    public void setGuardianContactNumber(String guardianContactNumber) {
	this.guardianContactNumber = guardianContactNumber;
    }

    public String getGuardianName() {
	return guardianName;
    }

    public void setGuardianName(String guardianName) {
	this.guardianName = guardianName;
    }

    public MiniMasterDto getGuardianRelationshipType() {
	return guardianRelationshipType;
    }

    public void setGuardianRelationshipType(MiniMasterDto guardianRelationshipType) {
	this.guardianRelationshipType = guardianRelationshipType;
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

    public Boolean getIsOnDot() {
	return isOnDot;
    }

    public void setIsOnDot(Boolean isOnDot) {
	this.isOnDot = isOnDot;
    }

    public Boolean getIsTbDiagnosed() {
	return isTbDiagnosed;
    }

    public void setIsTbDiagnosed(Boolean isTbDiagnosed) {
	this.isTbDiagnosed = isTbDiagnosed;
    }

    public Boolean getIsTestedForSyphilis() {
	return isTestedForSyphilis;
    }

    public void setIsTestedForSyphilis(Boolean isTestedForSyphilis) {
	this.isTestedForSyphilis = isTestedForSyphilis;
    }

    public Boolean getIsTransferOut() {
	return isTransferOut;
    }

    public void setIsTransferOut(Boolean isTransferOut) {
	this.isTransferOut = isTransferOut;
    }

    public Boolean getIsTransit() {
	return isTransit;
    }

    public void setIsTransit(Boolean isTransit) {
	this.isTransit = isTransit;
    }

    public String getOstCode() {
	return ostCode;
    }

    public void setOstCode(String ostCode) {
	this.ostCode = ostCode;
    }

    public String getOstNumber() {
	return ostNumber;
    }

    public void setOstNumber(String ostNumber) {
	this.ostNumber = ostNumber;
    }

    public MiniMasterDto getOstStatus() {
	return ostStatus;
    }

    public void setOstStatus(MiniMasterDto ostStatus) {
	this.ostStatus = ostStatus;
    }

    public Boolean getReceivedStiTreatment() {
	return receivedStiTreatment;
    }

    public void setReceivedStiTreatment(Boolean receivedStiTreatment) {
	this.receivedStiTreatment = receivedStiTreatment;
    }

    public LocalDate getRegistrationDate() {
	return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
	this.registrationDate = registrationDate;
    }

    public Boolean getTbSymptoms() {
	return tbSymptoms;
    }

    public void setTbSymptoms(Boolean tbSymptoms) {
	this.tbSymptoms = tbSymptoms;
    }

    public LocalDate getTransitEndDate() {
	return transitEndDate;
    }

    public void setTransitEndDate(LocalDate transitEndDate) {
	this.transitEndDate = transitEndDate;
    }

    public LocalDate getTransitStartDate() {
	return transitStartDate;
    }

    public void setTransitStartDate(LocalDate transitStartDate) {
	this.transitStartDate = transitStartDate;
    }

    public MiniMasterDto getHrgPrimary() {
	return hrgPrimary;
    }

    public void setHrgPrimary(MiniMasterDto hrgPrimary) {
	this.hrgPrimary = hrgPrimary;
    }

    public Integer getNumberOfPartners() {
	return numberOfPartners;
    }

    public void setNumberOfPartners(Integer numberOfPartners) {
	this.numberOfPartners = numberOfPartners;
    }

    public Boolean getRegularPartners() {
	return regularPartners;
    }

    public void setRegularPartners(Boolean regularPartners) {
	this.regularPartners = regularPartners;
    }

    public Integer getFollowups() {
	return followups;
    }

    public void setFollowups(Integer followups) {
	this.followups = followups;
    }

    public TiBeneficiaryAddressDto getAddress() {
	return address;
    }

    public void setAddress(TiBeneficiaryAddressDto address) {
	this.address = address;
    }

    public MasterBenDto getMasterBeneficiary() {
	return masterBeneficiary;
    }

    public void setMasterBeneficiary(MasterBenDto masterBeneficiary) {
	this.masterBeneficiary = masterBeneficiary;
    }

    public FacilityDTO getFacility() {
	return facility;
    }

    public void setFacility(FacilityDTO facility) {
	this.facility = facility;
    }

    public Boolean getIsTransferred() {
	return isTransferred;
    }

    public void setIsTransferred(Boolean isTransferred) {
	this.isTransferred = isTransferred;
    }

    public TiOstDispensationItemDTO getDispensation() {
	return dispensation;
    }

    public void setDispensation(TiOstDispensationItemDTO dispensation) {
	this.dispensation = dispensation;
    }

    public Set<BeneficiaryTransitFacilityDto> getTransitFacilities() {
	return transitFacilities;
    }

    public void setTransitFacilities(Set<BeneficiaryTransitFacilityDto> transitFacilities) {
	this.transitFacilities = transitFacilities;
    }

    public Long getLinkedFacilityId() {
	return linkedFacilityId;
    }

    public void setLinkedFacilityId(Long linkedFacilityId) {
	this.linkedFacilityId = linkedFacilityId;
    }

    public String getCurrentTransferStatus() {
	return currentTransferStatus;
    }

    public void setCurrentTransferStatus(String currentTransferStatus) {
	this.currentTransferStatus = currentTransferStatus;
    }

    public LocalDate getConsentTakenDate() {
	return consentTakenDate;
    }

    public void setConsentTakenDate(LocalDate consentTakenDate) {
	this.consentTakenDate = consentTakenDate;
    }

    public MiniMasterDto getReferredFrom() {
	return referredFrom;
    }

    public void setReferredFrom(MiniMasterDto referredFrom) {
	this.referredFrom = referredFrom;
    }

    public MiniMasterDto getStatus() {
	return status;
    }

    public void setStatus(MiniMasterDto status) {
	this.status = status;
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

    @Override
    public boolean equals(Object o) {
	if (this == o) {
	    return true;
	}
	if (o == null || getClass() != o.getClass()) {
	    return false;
	}

	TIOstBeneficiaryDTO tIOstBeneficiaryDTO = (TIOstBeneficiaryDTO) o;
	if (tIOstBeneficiaryDTO.getId() == null || getId() == null) {
	    return false;
	}
	return Objects.equals(getId(), tIOstBeneficiaryDTO.getId());
    }

    @Override
    public int hashCode() {
	return Objects.hashCode(getId());
    }

}
