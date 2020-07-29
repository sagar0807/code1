package gov.naco.soch.ti.dto;

import java.time.LocalDate;
import java.util.Objects;

import gov.naco.soch.dto.MiniMasterDto;

public class TIStiTreatmentDTO_Initial extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long facilityId;
	private Long beneficiaryId;
	private LocalDate nextFollowUpDate;

	private Boolean partnerNotified;

	private LocalDate followUpDate;
	
	private LocalDate firstFollowupDate;

	private String clinicalDetailsAbscess;

	private String treatmentProvidedAbscess;

	private String clinicalDetailsOverdose;
	
	private String treatmentProvidedOverdose;
	
	private MiniMasterDto diagnosisType;
	
	private MiniMasterDto kitType;

	private Boolean isActive;

	private Boolean isDelete;
	
	private Boolean isEarly;
	
	

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsEarly() {
	    return isEarly;
	}

	public void setIsEarly(Boolean isEarly) {
	    this.isEarly = isEarly;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
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

	public Boolean getPartnerNotified() {
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

	public LocalDate getFirstFollowupDate() {
		return firstFollowupDate;
	}

	public void setFirstFollowupDate(LocalDate firstFollowupDate) {
		this.firstFollowupDate = firstFollowupDate;
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

	public LocalDate getNextFollowUpDate() {
		return nextFollowUpDate;
	}

	public void setNextFollowUpDate(LocalDate nextFollowUpDate) {
		this.nextFollowUpDate = nextFollowUpDate;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		TIStiTreatmentDTO_Initial tIStiTreatmentDTO_Initial = (TIStiTreatmentDTO_Initial) o;
		if (tIStiTreatmentDTO_Initial.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), tIStiTreatmentDTO_Initial.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

}
