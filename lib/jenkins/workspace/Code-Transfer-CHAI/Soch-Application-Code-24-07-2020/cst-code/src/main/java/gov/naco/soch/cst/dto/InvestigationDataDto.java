package gov.naco.soch.cst.dto;

import java.time.LocalDate;

public class InvestigationDataDto {

	private LocalDate investigationDate;

	private String investigationValue;

	public LocalDate getInvestigationDate() {
		return investigationDate;
	}

	public void setInvestigationDate(LocalDate investigationDate) {
		this.investigationDate = investigationDate;
	}

	public String getInvestigationValue() {
		return investigationValue;
	}

	public void setInvestigationValue(String investigationValue) {
		this.investigationValue = investigationValue;
	}

	

}
