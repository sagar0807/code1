package gov.naco.soch.cst.dto;

public class ProfileFamilyDetailsDto {

	private Long beneficiaryId;
	private String beneficiaryName;
	private String relationType;
	private String artStatus;
	private Long artNumber;
	private Long preArtNumber;

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	public String getArtStatus() {
		return artStatus;
	}

	public void setArtStatus(String artStatus) {
		this.artStatus = artStatus;
	}

	public Long getArtNumber() {
		return artNumber;
	}

	public void setArtNumber(Long artNumber) {
		this.artNumber = artNumber;
	}

	public Long getPreArtNumber() {
		return preArtNumber;
	}

	public void setPreArtNumber(Long preArtNumber) {
		this.preArtNumber = preArtNumber;
	}

}
