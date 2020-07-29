package gov.naco.soch.dto;

import java.time.LocalDate;

//DTO class used for transfer data between front end and back end.
public class TiScreeningDetailDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	// DTO class properties
	private Long screeningId;
	private Long beneficiaryId;
	private LocalDate dateOfScreening;
	private Boolean feverGreaterThanThreeWeeks;
	private String infection;
	private Boolean isActive;
	private Boolean isDelete;
	private LocalDate lastRiskVulnerabilityAssessment;
	private Boolean presenceOfSweatGreaterThanThreeWeeks;
	private Boolean prolongedCoughGreaterThanThreeWeeks;
	private String screeningStatusHiv;
	private String screeningStatusSyphilis;
	private String status;
	private String tbStatus;
	private Boolean weightlossGreaterThan3kgInLastFourWeeks;
	private String BeneficiaryActivityStatus;

	/**
	 * @return the screeningId
	 */
	public Long getScreeningId() {
		return screeningId;
	}

	/**
	 * @param screeningId the screeningId to set
	 */
	public void setScreeningId(Long screeningId) {
		this.screeningId = screeningId;
	}

	/**
	 * @return the beneficiaryId
	 */
	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	/**
	 * @param beneficiaryId the beneficiaryId to set
	 */
	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	/**
	 * @return the dateOfScreening
	 */
	public LocalDate getDateOfScreening() {
		return dateOfScreening;
	}

	/**
	 * @param dateOfScreening the dateOfScreening to set
	 */
	public void setDateOfScreening(LocalDate dateOfScreening) {
		this.dateOfScreening = dateOfScreening;
	}

	/**
	 * @return the feverGreaterThanThreeWeeks
	 */
	public Boolean getFeverGreaterThanThreeWeeks() {
		return feverGreaterThanThreeWeeks;
	}

	/**
	 * @param feverGreaterThanThreeWeeks the feverGreaterThanThreeWeeks to set
	 */
	public void setFeverGreaterThanThreeWeeks(Boolean feverGreaterThanThreeWeeks) {
		this.feverGreaterThanThreeWeeks = feverGreaterThanThreeWeeks;
	}

	/**
	 * @return the infection
	 */
	public String getInfection() {
		return infection;
	}

	/**
	 * @param infection the infection to set
	 */
	public void setInfection(String infection) {
		this.infection = infection;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the isDelete
	 */
	public Boolean getIsDelete() {
		return isDelete;
	}

	/**
	 * @param isDelete the isDelete to set
	 */
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	/**
	 * @return the lastRiskVulnerabilityAssessment
	 */
	public LocalDate getLastRiskVulnerabilityAssessment() {
		return lastRiskVulnerabilityAssessment;
	}

	/**
	 * @param lastRiskVulnerabilityAssessment the lastRiskVulnerabilityAssessment to
	 *                                        set
	 */
	public void setLastRiskVulnerabilityAssessment(LocalDate lastRiskVulnerabilityAssessment) {
		this.lastRiskVulnerabilityAssessment = lastRiskVulnerabilityAssessment;
	}

	/**
	 * @return the presenceOfSweatGreaterThanThreeWeeks
	 */
	public Boolean getPresenceOfSweatGreaterThanThreeWeeks() {
		return presenceOfSweatGreaterThanThreeWeeks;
	}

	/**
	 * @param presenceOfSweatGreaterThanThreeWeeks the
	 *                                             presenceOfSweatGreaterThanThreeWeeks
	 *                                             to set
	 */
	public void setPresenceOfSweatGreaterThanThreeWeeks(Boolean presenceOfSweatGreaterThanThreeWeeks) {
		this.presenceOfSweatGreaterThanThreeWeeks = presenceOfSweatGreaterThanThreeWeeks;
	}

	/**
	 * @return the prolongedCoughGreaterThanThreeWeeks
	 */
	public Boolean getProlongedCoughGreaterThanThreeWeeks() {
		return prolongedCoughGreaterThanThreeWeeks;
	}

	/**
	 * @param prolongedCoughGreaterThanThreeWeeks the
	 *                                            prolongedCoughGreaterThanThreeWeeks
	 *                                            to set
	 */
	public void setProlongedCoughGreaterThanThreeWeeks(Boolean prolongedCoughGreaterThanThreeWeeks) {
		this.prolongedCoughGreaterThanThreeWeeks = prolongedCoughGreaterThanThreeWeeks;
	}

	/**
	 * @return the screeningStatusHiv
	 */
	public String getScreeningStatusHiv() {
		return screeningStatusHiv;
	}

	/**
	 * @param screeningStatusHiv the screeningStatusHiv to set
	 */
	public void setScreeningStatusHiv(String screeningStatusHiv) {
		this.screeningStatusHiv = screeningStatusHiv;
	}

	/**
	 * @return the screeningStatusSyphilis
	 */
	public String getScreeningStatusSyphilis() {
		return screeningStatusSyphilis;
	}

	/**
	 * @param screeningStatusSyphilis the screeningStatusSyphilis to set
	 */
	public void setScreeningStatusSyphilis(String screeningStatusSyphilis) {
		this.screeningStatusSyphilis = screeningStatusSyphilis;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the tbStatus
	 */
	public String getTbStatus() {
		return tbStatus;
	}

	/**
	 * @param tbStatus the tbStatus to set
	 */
	public void setTbStatus(String tbStatus) {
		this.tbStatus = tbStatus;
	}

	/**
	 * @return the weightlossGreaterThan3kgInLastFourWeeks
	 */
	public Boolean getWeightlossGreaterThan3kgInLastFourWeeks() {
		return weightlossGreaterThan3kgInLastFourWeeks;
	}

	/**
	 * @param weightlossGreaterThan3kgInLastFourWeeks the
	 *                                                weightlossGreaterThan3kgInLastFourWeeks
	 *                                                to set
	 */
	public void setWeightlossGreaterThan3kgInLastFourWeeks(Boolean weightlossGreaterThan3kgInLastFourWeeks) {
		this.weightlossGreaterThan3kgInLastFourWeeks = weightlossGreaterThan3kgInLastFourWeeks;
	}

	/**
	 * @return the beneficiaryActivityStatus
	 */
	public String getBeneficiaryActivityStatus() {
		return BeneficiaryActivityStatus;
	}

	/**
	 * @param beneficiaryActivityStatus the beneficiaryActivityStatus to set
	 */
	public void setBeneficiaryActivityStatus(String beneficiaryActivityStatus) {
		BeneficiaryActivityStatus = beneficiaryActivityStatus;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TiScreeningDetailDto [screeningId=" + screeningId + ", beneficiaryId=" + beneficiaryId
				+ ", dateOfScreening=" + dateOfScreening + ", feverGreaterThanThreeWeeks=" + feverGreaterThanThreeWeeks
				+ ", infection=" + infection + ", isActive=" + isActive + ", isDelete=" + isDelete
				+ ", lastRiskVulnerabilityAssessment=" + lastRiskVulnerabilityAssessment
				+ ", presenceOfSweatGreaterThanThreeWeeks=" + presenceOfSweatGreaterThanThreeWeeks
				+ ", prolongedCoughGreaterThanThreeWeeks=" + prolongedCoughGreaterThanThreeWeeks
				+ ", screeningStatusHiv=" + screeningStatusHiv + ", screeningStatusSyphilis=" + screeningStatusSyphilis
				+ ", status=" + status + ", tbStatus=" + tbStatus + ", weightlossGreaterThan3kgInLastFourWeeks="
				+ weightlossGreaterThan3kgInLastFourWeeks + ", BeneficiaryActivityStatus=" + BeneficiaryActivityStatus
				+ "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TiScreeningDetailDto other = (TiScreeningDetailDto) obj;
		if (BeneficiaryActivityStatus == null) {
			if (other.BeneficiaryActivityStatus != null)
				return false;
		} else if (!BeneficiaryActivityStatus.equals(other.BeneficiaryActivityStatus))
			return false;
		if (beneficiaryId == null) {
			if (other.beneficiaryId != null)
				return false;
		} else if (!beneficiaryId.equals(other.beneficiaryId))
			return false;
		if (dateOfScreening == null) {
			if (other.dateOfScreening != null)
				return false;
		} else if (!dateOfScreening.equals(other.dateOfScreening))
			return false;
		if (feverGreaterThanThreeWeeks == null) {
			if (other.feverGreaterThanThreeWeeks != null)
				return false;
		} else if (!feverGreaterThanThreeWeeks.equals(other.feverGreaterThanThreeWeeks))
			return false;
		if (infection == null) {
			if (other.infection != null)
				return false;
		} else if (!infection.equals(other.infection))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (isDelete == null) {
			if (other.isDelete != null)
				return false;
		} else if (!isDelete.equals(other.isDelete))
			return false;
		if (lastRiskVulnerabilityAssessment == null) {
			if (other.lastRiskVulnerabilityAssessment != null)
				return false;
		} else if (!lastRiskVulnerabilityAssessment.equals(other.lastRiskVulnerabilityAssessment))
			return false;
		if (presenceOfSweatGreaterThanThreeWeeks == null) {
			if (other.presenceOfSweatGreaterThanThreeWeeks != null)
				return false;
		} else if (!presenceOfSweatGreaterThanThreeWeeks.equals(other.presenceOfSweatGreaterThanThreeWeeks))
			return false;
		if (prolongedCoughGreaterThanThreeWeeks == null) {
			if (other.prolongedCoughGreaterThanThreeWeeks != null)
				return false;
		} else if (!prolongedCoughGreaterThanThreeWeeks.equals(other.prolongedCoughGreaterThanThreeWeeks))
			return false;
		if (screeningId == null) {
			if (other.screeningId != null)
				return false;
		} else if (!screeningId.equals(other.screeningId))
			return false;
		if (screeningStatusHiv == null) {
			if (other.screeningStatusHiv != null)
				return false;
		} else if (!screeningStatusHiv.equals(other.screeningStatusHiv))
			return false;
		if (screeningStatusSyphilis == null) {
			if (other.screeningStatusSyphilis != null)
				return false;
		} else if (!screeningStatusSyphilis.equals(other.screeningStatusSyphilis))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tbStatus == null) {
			if (other.tbStatus != null)
				return false;
		} else if (!tbStatus.equals(other.tbStatus))
			return false;
		if (weightlossGreaterThan3kgInLastFourWeeks == null) {
			if (other.weightlossGreaterThan3kgInLastFourWeeks != null)
				return false;
		} else if (!weightlossGreaterThan3kgInLastFourWeeks.equals(other.weightlossGreaterThan3kgInLastFourWeeks))
			return false;
		return true;
	}

}