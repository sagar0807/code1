package gov.naco.soch.shared.dto.ti;

import java.time.LocalDate;
import java.util.Objects;

import gov.naco.soch.dto.BaseDto;

public class TIStiTreatmentDTO_Initial extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long facilityId;
	private Long beneficiaryId;
	private LocalDate nextFollowUpDate;
	private String stiRtiDiagnosis;

	private String kitPrescribed;

	private Boolean partnerNotified;

	private LocalDate followUpDate;

	private String clinicalDetails;

	private String treatmentProvided;
	
	private Boolean isActive;

	private Boolean isDelete;
	
	

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

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public String getStiRtiDiagnosis() {
		return stiRtiDiagnosis;
	}

	public void setStiRtiDiagnosis(String stiRtiDiagnosis) {
		this.stiRtiDiagnosis = stiRtiDiagnosis;
	}

	public String getKitPrescribed() {
		return kitPrescribed;
	}

	public void setKitPrescribed(String kitPrescribed) {
		this.kitPrescribed = kitPrescribed;
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

	public String getClinicalDetails() {
		return clinicalDetails;
	}

	public void setClinicalDetails(String clinicalDetails) {
		this.clinicalDetails = clinicalDetails;
	}

	public String getTreatmentProvided() {
		return treatmentProvided;
	}

	public void setTreatmentProvided(String treatmentProvided) {
		this.treatmentProvided = treatmentProvided;
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
