package gov.naco.soch.cst.dto;

import java.util.Date;

public class MiniProfileOIDto {

	private Long visitId;
	private Long beneficiaryId;
	private Date visitDate;
	private String oiItems;
	private String infectionRemarks;

	public Long getVisitId() {
		return visitId;
	}

	public void setVisitId(Long visitId) {
		this.visitId = visitId;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getOiItems() {
		return oiItems;
	}

	public void setOiItems(String oiItems) {
		this.oiItems = oiItems;
	}

	public String getInfectionRemarks() {
		return infectionRemarks;
	}

	public void setInfectionRemarks(String infectionRemarks) {
		this.infectionRemarks = infectionRemarks;
	}

}
