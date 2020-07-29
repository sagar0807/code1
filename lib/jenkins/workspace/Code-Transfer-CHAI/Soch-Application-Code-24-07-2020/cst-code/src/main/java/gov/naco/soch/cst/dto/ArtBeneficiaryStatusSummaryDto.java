package gov.naco.soch.cst.dto;

import java.time.LocalDate;

public class ArtBeneficiaryStatusSummaryDto {
	private LocalDate statusDate;
	private Long masterArtBeneficiaryStatusId;
	private String masterArtBeneficiaryStatusName;
	
	public LocalDate getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(LocalDate statusDate) {
		this.statusDate = statusDate;
	}
	public Long getMasterArtBeneficiaryStatusId() {
		return masterArtBeneficiaryStatusId;
	}
	public void setMasterArtBeneficiaryStatusId(Long masterArtBeneficiaryStatusId) {
		this.masterArtBeneficiaryStatusId = masterArtBeneficiaryStatusId;
	}
	public String getMasterArtBeneficiaryStatusName() {
		return masterArtBeneficiaryStatusName;
	}
	public void setMasterArtBeneficiaryStatusName(String masterArtBeneficiaryStatusName) {
		this.masterArtBeneficiaryStatusName = masterArtBeneficiaryStatusName;
	}
}
