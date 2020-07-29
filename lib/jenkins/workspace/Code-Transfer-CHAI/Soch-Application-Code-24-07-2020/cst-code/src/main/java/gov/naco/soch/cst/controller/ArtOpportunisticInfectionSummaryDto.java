package gov.naco.soch.cst.controller;

import java.time.LocalDate;

public class ArtOpportunisticInfectionSummaryDto {
	private Long visiterRegisterId;
	private Long masterOpportunisticInfectionId;
	private LocalDate visitDateOi;
	private String masterOpportunisticInfectionValue;
	public Long getVisiterRegisterId() {
		return visiterRegisterId;
	}
	public void setVisiterRegisterId(Long visiterRegisterId) {
		this.visiterRegisterId = visiterRegisterId;
	}
	public Long getMasterOpportunisticInfectionId() {
		return masterOpportunisticInfectionId;
	}
	public void setMasterOpportunisticInfectionId(Long masterOpportunisticInfectionId) {
		this.masterOpportunisticInfectionId = masterOpportunisticInfectionId;
	}
	
	public LocalDate getVisitDateOi() {
		return visitDateOi;
	}
	public void setVisitDateOi(LocalDate visitDateOi) {
		this.visitDateOi = visitDateOi;
	}
	public String getMasterOpportunisticInfectionValue() {
		return masterOpportunisticInfectionValue;
	}
	public void setMasterOpportunisticInfectionValue(String masterOpportunisticInfectionValue) {
		this.masterOpportunisticInfectionValue = masterOpportunisticInfectionValue;
	}

}
