package gov.naco.soch.ti.dto;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import gov.naco.soch.constructordto.TiOstDispensationItemDTO;
import gov.naco.soch.dto.BeneficiaryDto;
import gov.naco.soch.dto.BeneficiaryReferralDto;
import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.dto.TiBeneficiaryAddressDto;

public class TIOstBeneficiaryDTO extends BaseDto {

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

	private Integer hotspotId;

	private Integer followups;

	private TiBeneficiaryAddressDto address;

	private Set<TIOstAssessDTO_Initial> ostAssess;

	private BeneficiaryDto masterBeneficiary;

	private FacilityDTO facility;

	private BeneficiaryReferralDto beneficiaryReferral;

	private TiBenTransferDto benTransferDto;

	private TiOstDispensationItemDTO dispensation;

	private Set<BeneficiaryTransitFacilityDto> transitFacilities;

	private Set<TIOstPrescriptionDTO> tiOstPrescriptions;

	private Set<TiBenFollowUpDTO_Initial> ostFollowUp;

	private Long linkedFacilityId;

	private String currentTransferStatus;

	private LocalDate consentTakenDate;

	private MiniMasterDto referredFrom;
	
	private MiniMasterDto status;
	
	private Set<HotspotBenMappingDto> hotspotBenMapping; 
	
	private long count;
	
	private Boolean isTransferred;

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

	public Integer getFollowups() {
		return followups;
	}

	public void setFollowups(Integer followups) {
		this.followups = followups;
	}

	public Long getLinkedFacilityId() {
		return linkedFacilityId;
	}

	public void setLinkedFacilityId(Long linkedFacilityId) {
		this.linkedFacilityId = linkedFacilityId;
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

	public Integer getHotspotId() {
		return hotspotId;
	}

	public void setHotspotId(Integer hotspotId) {
		this.hotspotId = hotspotId;
	}

	public TiBeneficiaryAddressDto getAddress() {
		return address;
	}

	public void setAddress(TiBeneficiaryAddressDto address) {
		this.address = address;
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

	public Set<TIOstPrescriptionDTO> getTiOstPrescriptions() {
		return tiOstPrescriptions;
	}

	public void setTiOstPrescriptions(Set<TIOstPrescriptionDTO> tiOstPrescriptions) {
		this.tiOstPrescriptions = tiOstPrescriptions;
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

	public MiniMasterDto getReferredFrom() {
		return referredFrom;
	}

	public void setReferredFrom(MiniMasterDto referredFrom) {
		this.referredFrom = referredFrom;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
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

	public LocalDate getConsentTakenDate() {
		return consentTakenDate;
	}

	public void setConsentTakenDate(LocalDate consentTakenDate) {
		this.consentTakenDate = consentTakenDate;
	}

	public String getCurrentTransferStatus() {
		return currentTransferStatus;
	}

	public void setCurrentTransferStatus(String currentTransferStatus) {
		this.currentTransferStatus = currentTransferStatus;
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

	public Boolean getTbSymptoms() {
		return tbSymptoms;
	}

	public void setTbSymptoms(Boolean tbSymptoms) {
		this.tbSymptoms = tbSymptoms;
	}

	public Set<HotspotBenMappingDto> getHotspotBenMapping() {
		return hotspotBenMapping;
	}

	public void setHotspotBenMapping(Set<HotspotBenMappingDto> hotspotBenMapping) {
		this.hotspotBenMapping = hotspotBenMapping;
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

	public BeneficiaryDto getMasterBeneficiary() {
		return masterBeneficiary;
	}

	public void setMasterBeneficiary(BeneficiaryDto masterBeneficiary) {
		this.masterBeneficiary = masterBeneficiary;
	}

	public TiBenTransferDto getBenTransferDto() {
		return benTransferDto;
	}

	public void setBenTransferDto(TiBenTransferDto benTransferDto) {
		this.benTransferDto = benTransferDto;
	}

	public BeneficiaryReferralDto getBeneficiaryReferral() {
		return beneficiaryReferral;
	}

	public void setBeneficiaryReferral(BeneficiaryReferralDto beneficiaryReferral) {
		this.beneficiaryReferral = beneficiaryReferral;
	}

	public Set<TIOstAssessDTO_Initial> getOstAssess() {
		return ostAssess;
	}

	public void setOstAssess(Set<TIOstAssessDTO_Initial> ostAssess) {
		this.ostAssess = ostAssess;
	}

	public Set<TiBenFollowUpDTO_Initial> getOstFollowUp() {
		return ostFollowUp;
	}

	public void setOstFollowUp(Set<TiBenFollowUpDTO_Initial> ostFollowUp) {
		this.ostFollowUp = ostFollowUp;
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

	// private Set<TiOstPrescription> tiOstPrescriptions;

}
