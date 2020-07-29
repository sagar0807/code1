package gov.naco.soch.cst.dto;

public class ArtBeneficiaryCoexistingConditionDto {

	private Long clinicalDetailsCoexistingConditionId;

	private Long otherAilmentId;

	private String otherAilment;

	public Long getClinicalDetailsCoexistingConditionId() {
		return clinicalDetailsCoexistingConditionId;
	}

	public void setClinicalDetailsCoexistingConditionId(Long clinicalDetailsCoexistingConditionId) {
		this.clinicalDetailsCoexistingConditionId = clinicalDetailsCoexistingConditionId;
	}

	public Long getOtherAilmentId() {
		return otherAilmentId;
	}

	public void setOtherAilmentId(Long otherAilmentId) {
		this.otherAilmentId = otherAilmentId;
	}

	public String getOtherAilment() {
		return otherAilment;
	}

	public void setOtherAilment(String otherAilment) {
		this.otherAilment = otherAilment;
	}

}
