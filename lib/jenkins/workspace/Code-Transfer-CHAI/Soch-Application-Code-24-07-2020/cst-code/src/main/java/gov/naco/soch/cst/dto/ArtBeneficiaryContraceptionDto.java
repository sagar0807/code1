package gov.naco.soch.cst.dto;

public class ArtBeneficiaryContraceptionDto {

	private Long clinicalDetailsContraceptionId;

	private Long contraceptionId;

	private String contraception;

	public Long getClinicalDetailsContraceptionId() {
		return clinicalDetailsContraceptionId;
	}

	public void setClinicalDetailsContraceptionId(Long clinicalDetailsContraceptionId) {
		this.clinicalDetailsContraceptionId = clinicalDetailsContraceptionId;
	}

	public Long getContraceptionId() {
		return contraceptionId;
	}

	public void setContraceptionId(Long contraceptionId) {
		this.contraceptionId = contraceptionId;
	}

	public String getContraception() {
		return contraception;
	}

	public void setContraception(String contraception) {
		this.contraception = contraception;
	}

}
