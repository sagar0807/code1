package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;

import gov.naco.soch.dto.BeneficiaryReferralDto;
import gov.naco.soch.dto.MiniMasterDto;

/**
 * A DTO for the {@link gov.naco.soch.domain.TIBenScrDetails} entity.
 */
public class TIBenScrDetailsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private MiniMasterDto infection;

	private ZonedDateTime dateOfScreening;

	private LocalDate nextDateOfScreening;

	private MiniMasterDto screeningStatusHiv;

	private MiniMasterDto screeningStatusSyphilis;

	private Boolean prolongedCoughGreaterThanThreeWeeks;

	private Boolean presenceOfSweatGreaterThanThreeWeeks;

	private Boolean weightlossGreaterThan3kgInLastFourWeeks;

	private Boolean feverGreaterThanThreeWeeks;

	private MiniMasterDto tbStatus;
	
	private String status;

	private Boolean isActive;

	private Boolean isDeleted;

	private TIBeneficiaryDTO beneficiary;

	private Long facilityId;
	
	private BeneficiaryReferralDto beneficiaryReferral;
	
	private long count;
	
	private Long previousId;
	
	private Boolean isEarly;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MiniMasterDto getInfection() {
		return infection;
	}

	public void setInfection(MiniMasterDto infection) {
		this.infection = infection;
	}

	public ZonedDateTime getDateOfScreening() {
		return dateOfScreening;
	}

	public void setDateOfScreening(ZonedDateTime dateOfScreening) {
		this.dateOfScreening = dateOfScreening;
	}

	public LocalDate getNextDateOfScreening() {
		return nextDateOfScreening;
	}

	public void setNextDateOfScreening(LocalDate nextDateOfScreening) {
		this.nextDateOfScreening = nextDateOfScreening;
	}
	public Long getPreviousId() {
	    return previousId;
	}

	public void setPreviousId(Long previousId) {
	    this.previousId = previousId;
	}

	public Boolean isProlongedCoughGreaterThanThreeWeeks() {
		return prolongedCoughGreaterThanThreeWeeks;
	}

	public void setProlongedCoughGreaterThanThreeWeeks(Boolean prolongedCoughGreaterThanThreeWeeks) {
		this.prolongedCoughGreaterThanThreeWeeks = prolongedCoughGreaterThanThreeWeeks;
	}

	public Boolean isPresenceOfSweatGreaterThanThreeWeeks() {
		return presenceOfSweatGreaterThanThreeWeeks;
	}

	public void setPresenceOfSweatGreaterThanThreeWeeks(Boolean presenceOfSweatGreaterThanThreeWeeks) {
		this.presenceOfSweatGreaterThanThreeWeeks = presenceOfSweatGreaterThanThreeWeeks;
	}

	public Boolean isWeightlossGreaterThan3kgInLastFourWeeks() {
		return weightlossGreaterThan3kgInLastFourWeeks;
	}

	public void setWeightlossGreaterThan3kgInLastFourWeeks(Boolean weightlossGreaterThan3kgInLastFourWeeks) {
		this.weightlossGreaterThan3kgInLastFourWeeks = weightlossGreaterThan3kgInLastFourWeeks;
	}

	public Boolean isFeverGreaterThanThreeWeeks() {
		return feverGreaterThanThreeWeeks;
	}

	public void setFeverGreaterThanThreeWeeks(Boolean feverGreaterThanThreeWeeks) {
		this.feverGreaterThanThreeWeeks = feverGreaterThanThreeWeeks;
	}

	public Boolean getProlongedCoughGreaterThanThreeWeeks() {
		return prolongedCoughGreaterThanThreeWeeks;
	}

	public Boolean getPresenceOfSweatGreaterThanThreeWeeks() {
		return presenceOfSweatGreaterThanThreeWeeks;
	}

	public Boolean getWeightlossGreaterThan3kgInLastFourWeeks() {
		return weightlossGreaterThan3kgInLastFourWeeks;
	}

	public Boolean getFeverGreaterThanThreeWeeks() {
		return feverGreaterThanThreeWeeks;
	}



//	public LocalDate getLastRiskVulnerabilityAssessment() {
//		return lastRiskVulnerabilityAssessment;
//	}
//
//	public void setLastRiskVulnerabilityAssessment(LocalDate lastRiskVulnerabilityAssessment) {
//		this.lastRiskVulnerabilityAssessment = lastRiskVulnerabilityAssessment;
//	}

	public MiniMasterDto getScreeningStatusHiv() {
		return screeningStatusHiv;
	}

	public void setScreeningStatusHiv(MiniMasterDto screeningStatusHiv) {
		this.screeningStatusHiv = screeningStatusHiv;
	}

	public MiniMasterDto getScreeningStatusSyphilis() {
		return screeningStatusSyphilis;
	}

	public void setScreeningStatusSyphilis(MiniMasterDto screeningStatusSyphilis) {
		this.screeningStatusSyphilis = screeningStatusSyphilis;
	}

	public Boolean getIsEarly() {
	    return isEarly;
	}

	public void setIsEarly(Boolean isEarly) {
	    this.isEarly = isEarly;
	}

	public long getCount() {
	    return count;
	}

	public void setCount(long count) {
	    this.count = count;
	}

	public MiniMasterDto getTbStatus() {
		return tbStatus;
	}

	public void setTbStatus(MiniMasterDto tbStatus) {
		this.tbStatus = tbStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean isIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean isIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public TIBeneficiaryDTO getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(TIBeneficiaryDTO beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public BeneficiaryReferralDto getBeneficiaryReferral() {
		return beneficiaryReferral;
	}

	public void setBeneficiaryReferral(BeneficiaryReferralDto beneficiaryReferral) {
		this.beneficiaryReferral = beneficiaryReferral;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		TIBenScrDetailsDTO tIBenScrDetailsDTO = (TIBenScrDetailsDTO) o;
		if (tIBenScrDetailsDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), tIBenScrDetailsDTO.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "TIBenScrDetailsDTO [id=" + id + ", infection=" + infection + ", dateOfScreening=" + dateOfScreening
				+ ", nextDateOfScreening=" + nextDateOfScreening + ", screeningStatusHiv=" + screeningStatusHiv
				+ ", screeningStatusSyphilis=" + screeningStatusSyphilis + ", prolongedCoughGreaterThanThreeWeeks="
				+ prolongedCoughGreaterThanThreeWeeks + ", presenceOfSweatGreaterThanThreeWeeks="
				+ presenceOfSweatGreaterThanThreeWeeks + ", weightlossGreaterThan3kgInLastFourWeeks="
				+ weightlossGreaterThan3kgInLastFourWeeks + ", feverGreaterThanThreeWeeks=" + feverGreaterThanThreeWeeks
				+ ", tbStatus=" + tbStatus + ", status=" + status + ", isActive=" + isActive + ", isDeleted="
				+ isDeleted + ", beneficiary=" + beneficiary + ", facilityId=" + facilityId + ", beneficiaryReferral="
				+ beneficiaryReferral + "]";
	}



}
