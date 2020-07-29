package gov.naco.soch.dto;

import java.time.LocalDate;

public class TiBeneficiaryPrescriptionDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long beneficiaryId;
	private Long facilityId;
	private LocalDate initiationDate;
	private boolean consentTaken;
	private Long substitutionDrug;
	private Long dosage;
	private String measureOfUnit;

	public Long getId() {
		return id;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public LocalDate getInitiationDate() {
		return initiationDate;
	}

	public boolean isConsentTaken() {
		return consentTaken;
	}

	public Long getSubstitutionDrug() {
		return substitutionDrug;
	}

	public Long getDosage() {
		return dosage;
	}

	public String getMeasureOfUnit() {
		return measureOfUnit;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public void setInitiationDate(LocalDate initiationDate) {
		this.initiationDate = initiationDate;
	}

	public void setConsentTaken(boolean consentTaken) {
		this.consentTaken = consentTaken;
	}

	public void setSubstitutionDrug(Long substitutionDrug) {
		this.substitutionDrug = substitutionDrug;
	}

	public void setDosage(Long dosage) {
		this.dosage = dosage;
	}

	public void setMeasureOfUnit(String measureOfUnit) {
		this.measureOfUnit = measureOfUnit;
	}


	@Override
	public String toString() {
		return "TiBeneficiaryPrescriptionDto [id=" + id + ", beneficiaryId=" + beneficiaryId + ", facilityId="
				+ facilityId + ", initiationDate=" + initiationDate + ", consentTaken="
				+ consentTaken + ", substitutionDrug=" + substitutionDrug + ", dosage=" + dosage + ", measureOfUnit="
				+ measureOfUnit + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TiBeneficiaryPrescriptionDto other = (TiBeneficiaryPrescriptionDto) obj;
		if (beneficiaryId == null) {
			if (other.beneficiaryId != null)
				return false;
		} else if (!beneficiaryId.equals(other.beneficiaryId))
			return false;
		if (consentTaken != other.consentTaken)
			return false;
		if (dosage == null) {
			if (other.dosage != null)
				return false;
		} else if (!dosage.equals(other.dosage))
			return false;
		if (facilityId == null) {
			if (other.facilityId != null)
				return false;
		} else if (!facilityId.equals(other.facilityId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (initiationDate == null) {
			if (other.initiationDate != null)
				return false;
		} else if (!initiationDate.equals(other.initiationDate))
			return false;
		if (measureOfUnit == null) {
			if (other.measureOfUnit != null)
				return false;
		} else if (!measureOfUnit.equals(other.measureOfUnit))
			return false;
		if (substitutionDrug == null) {
			if (other.substitutionDrug != null)
				return false;
		} else if (!substitutionDrug.equals(other.substitutionDrug))
			return false;
		return true;
	}

}
