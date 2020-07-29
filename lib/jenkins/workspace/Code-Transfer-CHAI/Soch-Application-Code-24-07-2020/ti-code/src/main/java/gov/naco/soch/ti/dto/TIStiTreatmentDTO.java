package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import gov.naco.soch.dto.MiniMasterDto;

/**
 * A DTO for the {@link gov.naco.soch.domain.TIStiTreatment} entity.
 */
public class TIStiTreatmentDTO implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Boolean partnerNotified;

	private LocalDate followUpDate;

	private LocalDate nextFollowUpDate;
	
	private LocalDate firstFollowupDate;

	private String clinicalDetailsAbscess;

	private String treatmentProvidedAbscess;

	private String clinicalDetailsOverdose;
	
	private String treatmentProvidedOverdose;

	private Boolean isActive;

	private Boolean isDelete;

	private Long facilityId;

	private TIBeneficiaryDTO beneficiary;
	
	private MiniMasterDto diagnosisType;
	
	private MiniMasterDto kitType;
	
	private long count;
	
	private Long previousId;
	
	private Boolean isEarly;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Boolean getPartnerNotified() {
		return partnerNotified;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public String getClinicalDetailsAbscess() {
		return clinicalDetailsAbscess;
	}

	public void setClinicalDetailsAbscess(String clinicalDetailsAbscess) {
		this.clinicalDetailsAbscess = clinicalDetailsAbscess;
	}

	public String getTreatmentProvidedAbscess() {
		return treatmentProvidedAbscess;
	}

	public void setTreatmentProvidedAbscess(String treatmentProvidedAbscess) {
		this.treatmentProvidedAbscess = treatmentProvidedAbscess;
	}

	public String getClinicalDetailsOverdose() {
		return clinicalDetailsOverdose;
	}

	public void setClinicalDetailsOverdose(String clinicalDetailsOverdose) {
		this.clinicalDetailsOverdose = clinicalDetailsOverdose;
	}

	public String getTreatmentProvidedOverdose() {
		return treatmentProvidedOverdose;
	}

	public void setTreatmentProvidedOverdose(String treatmentProvidedOverdose) {
		this.treatmentProvidedOverdose = treatmentProvidedOverdose;
	}

	public Long getPreviousId() {
	    return previousId;
	}

	public void setPreviousId(Long previousId) {
	    this.previousId = previousId;
	}

	public LocalDate getFirstFollowupDate() {
		return firstFollowupDate;
	}

	public void setFirstFollowupDate(LocalDate firstFollowupDate) {
		this.firstFollowupDate = firstFollowupDate;
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

	public MiniMasterDto getDiagnosisType() {
		return diagnosisType;
	}

	public void setDiagnosisType(MiniMasterDto diagnosisType) {
		this.diagnosisType = diagnosisType;
	}

	public MiniMasterDto getKitType() {
		return kitType;
	}

	public void setKitType(MiniMasterDto kitType) {
		this.kitType = kitType;
	}

	public Boolean isPartnerNotified() {
		return partnerNotified;
	}

	public void setPartnerNotified(Boolean partnerNotified) {
		this.partnerNotified = partnerNotified;
	}

	public LocalDate getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(LocalDate followUpDate) {
		this.followUpDate = followUpDate;
	}

	public TIBeneficiaryDTO getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(TIBeneficiaryDTO beneficiary) {
		this.beneficiary = beneficiary;
	}

	public LocalDate getNextFollowUpDate() {
		return nextFollowUpDate;
	}

	public void setNextFollowUpDate(LocalDate nextFollowUpDate) {
		this.nextFollowUpDate = nextFollowUpDate;
	}

	
	public Boolean isIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean isIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		TIStiTreatmentDTO tIStiTreatmentDTO = (TIStiTreatmentDTO) o;
		if (tIStiTreatmentDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), tIStiTreatmentDTO.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	

}
