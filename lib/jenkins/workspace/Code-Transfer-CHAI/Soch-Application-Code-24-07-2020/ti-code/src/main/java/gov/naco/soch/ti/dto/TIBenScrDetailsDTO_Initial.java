package gov.naco.soch.ti.dto;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;

import gov.naco.soch.dto.MiniMasterDto;

public class TIBenScrDetailsDTO_Initial extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long facilityId;
	private Long beneficiaryId;
	private LocalDate nextDateOfScreening;
	private MiniMasterDto infection;

	private ZonedDateTime dateOfScreening;

	private MiniMasterDto screeningStatusHiv;

	private MiniMasterDto screeningStatusSyphilis;

	private Boolean prolongedCoughGreaterThanThreeWeeks;

	private Boolean presenceOfSweatGreaterThanThreeWeeks;

	private Boolean weightlossGreaterThan3kgInLastFourWeeks;

	private Boolean feverGreaterThanThreeWeeks;

	private MiniMasterDto tbStatus;

	private LocalDate lastRiskVulnerabilityAssessment;

	private String status;
	
	private Boolean isActive;

	 private Boolean isDeleted;
	 
	 private Boolean isEarly;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
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

	public Boolean getProlongedCoughGreaterThanThreeWeeks() {
		return prolongedCoughGreaterThanThreeWeeks;
	}

	public void setProlongedCoughGreaterThanThreeWeeks(Boolean prolongedCoughGreaterThanThreeWeeks) {
		this.prolongedCoughGreaterThanThreeWeeks = prolongedCoughGreaterThanThreeWeeks;
	}

	public Boolean getPresenceOfSweatGreaterThanThreeWeeks() {
		return presenceOfSweatGreaterThanThreeWeeks;
	}

	public void setPresenceOfSweatGreaterThanThreeWeeks(Boolean presenceOfSweatGreaterThanThreeWeeks) {
		this.presenceOfSweatGreaterThanThreeWeeks = presenceOfSweatGreaterThanThreeWeeks;
	}

	public Boolean getWeightlossGreaterThan3kgInLastFourWeeks() {
		return weightlossGreaterThan3kgInLastFourWeeks;
	}

	public void setWeightlossGreaterThan3kgInLastFourWeeks(Boolean weightlossGreaterThan3kgInLastFourWeeks) {
		this.weightlossGreaterThan3kgInLastFourWeeks = weightlossGreaterThan3kgInLastFourWeeks;
	}

	public Boolean getFeverGreaterThanThreeWeeks() {
		return feverGreaterThanThreeWeeks;
	}

	public void setFeverGreaterThanThreeWeeks(Boolean feverGreaterThanThreeWeeks) {
		this.feverGreaterThanThreeWeeks = feverGreaterThanThreeWeeks;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsEarly() {
	    return isEarly;
	}

	public void setIsEarly(Boolean isEarly) {
	    this.isEarly = isEarly;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

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

	public MiniMasterDto getTbStatus() {
		return tbStatus;
	}

	public void setTbStatus(MiniMasterDto tbStatus) {
		this.tbStatus = tbStatus;
	}

	public LocalDate getLastRiskVulnerabilityAssessment() {
		return lastRiskVulnerabilityAssessment;
	}

	public void setLastRiskVulnerabilityAssessment(LocalDate lastRiskVulnerabilityAssessment) {
		this.lastRiskVulnerabilityAssessment = lastRiskVulnerabilityAssessment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public LocalDate getNextDateOfScreening() {
		return nextDateOfScreening;
	}

	public void setNextDateOfScreening(LocalDate nextDateOfScreening) {
		this.nextDateOfScreening = nextDateOfScreening;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		TIBenScrDetailsDTO_Initial tIBenScrDetailsDTO_Initial = (TIBenScrDetailsDTO_Initial) o;
		if (tIBenScrDetailsDTO_Initial.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), tIBenScrDetailsDTO_Initial.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

}
