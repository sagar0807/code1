package gov.naco.soch.ti.dto.readonly;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import gov.naco.soch.dto.BeneficiaryReferralDto;
import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.ti.dto.TiBenSubDto;

public class ScreeningDto  implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

	private Long id;
	
	private ZonedDateTime dateOfScreening;

	private LocalDate nextDateOfScreening;
	
	private Boolean prolongedCoughGreaterThanThreeWeeks;

	private Boolean presenceOfSweatGreaterThanThreeWeeks;

	private Boolean weightlossGreaterThan3kgInLastFourWeeks;

	private Boolean feverGreaterThanThreeWeeks;

	private String status;

	private Boolean isActive;

	private Boolean isDeleted;

	private Long facilityId;
	
        private long count;
	
	private Long previousId;
	
	private Boolean isEarly;
	
	private TiBenSubDto beneficiary;
	
	private MiniMasterDto screeningStatusHiv;

	private MiniMasterDto screeningStatusSyphilis;
	
	private MiniMasterDto tbStatus;
	
	private MiniMasterDto infection;
	
	private BeneficiaryReferralDto beneficiaryReferral;
	
	public ScreeningDto() {
	    
	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
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

	public String getStatus() {
	    return status;
	}

	public void setStatus(String status) {
	    this.status = status;
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

	public Long getFacilityId() {
	    return facilityId;
	}

	public void setFacilityId(Long facilityId) {
	    this.facilityId = facilityId;
	}

	public long getCount() {
	    return count;
	}

	public void setCount(long count) {
	    this.count = count;
	}

	public Long getPreviousId() {
	    return previousId;
	}

	public void setPreviousId(Long previousId) {
	    this.previousId = previousId;
	}

	public Boolean getIsEarly() {
	    return isEarly;
	}

	public void setIsEarly(Boolean isEarly) {
	    this.isEarly = isEarly;
	}

	public TiBenSubDto getBeneficiary() {
	    return beneficiary;
	}

	public void setBeneficiary(TiBenSubDto beneficiary) {
	    this.beneficiary = beneficiary;
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

	public MiniMasterDto getInfection() {
	    return infection;
	}

	public void setInfection(MiniMasterDto infection) {
	    this.infection = infection;
	}

	public BeneficiaryReferralDto getBeneficiaryReferral() {
	    return beneficiaryReferral;
	}

	public void setBeneficiaryReferral(BeneficiaryReferralDto beneficiaryReferral) {
	    this.beneficiaryReferral = beneficiaryReferral;
	}
	
	


}
