package gov.naco.soch.dto;

import java.util.Date;

public class TiStiTreatmentDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String clinicalDetails;
	private Date followUpDate;
	private Boolean isActive;
	private Boolean isDelete;
	private String kitPrescribed;
	private Boolean partnerNotified;
	private String stiRtiDiagnosis;
	private String treatmentProvided;
	private Long facilityId;
	private Long beneficiaryId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClinicalDetails() {
		return clinicalDetails;
	}

	public void setClinicalDetails(String clinicalDetails) {
		this.clinicalDetails = clinicalDetails;
	}

	public Date getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(Date followUpDate) {
		this.followUpDate = followUpDate;
	}

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

	public String getStiRtiDiagnosis() {
		return stiRtiDiagnosis;
	}

	public void setStiRtiDiagnosis(String stiRtiDiagnosis) {
		this.stiRtiDiagnosis = stiRtiDiagnosis;
	}

	public String getTreatmentProvided() {
		return treatmentProvided;
	}

	public void setTreatmentProvided(String treatmentProvided) {
		this.treatmentProvided = treatmentProvided;
	}
	
	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}
	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TiStiTreatmentDto [id=" + id + ", clinicalDetails=" + clinicalDetails + ", followUpDate=" + followUpDate
				+ ", isActive=" + isActive + ", isDelete=" + isDelete + ", kitPrescribed=" + kitPrescribed
				+ ", partnerNotified=" + partnerNotified + ", stiRtiDiagnosis=" + stiRtiDiagnosis
				+ ", treatmentProvided=" + treatmentProvided + ", facilityId=" + facilityId + ", beneficiaryId=" + beneficiaryId + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TiStiTreatmentDto other = (TiStiTreatmentDto) obj;
		if (beneficiaryId == null) {
			if (other.beneficiaryId != null)
				return false;
		} else if (!beneficiaryId.equals(other.beneficiaryId))
			return false;
		if (facilityId == null) {
			if (other.facilityId != null)
				return false;
		} else if (!facilityId.equals(other.facilityId))
			return false;
		if (clinicalDetails == null) {
			if (other.clinicalDetails != null)
				return false;
		} else if (!clinicalDetails.equals(other.clinicalDetails))
			return false;
		if (followUpDate == null) {
			if (other.followUpDate != null)
				return false;
		} else if (!followUpDate.equals(other.followUpDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		if (kitPrescribed == null) {
			if (other.kitPrescribed != null)
				return false;
		} else if (!kitPrescribed.equals(other.kitPrescribed))
			return false;
		if (partnerNotified == null) {
			if (other.partnerNotified != null)
				return false;
		} else if (!partnerNotified.equals(other.partnerNotified))
			return false;
		if (stiRtiDiagnosis == null) {
			if (other.stiRtiDiagnosis != null)
				return false;
		} else if (!stiRtiDiagnosis.equals(other.stiRtiDiagnosis))
			return false;
		if (treatmentProvided == null) {
			if (other.treatmentProvided != null)
				return false;
		} else if (!treatmentProvided.equals(other.treatmentProvided))
			return false;
		return true;
	}
}
