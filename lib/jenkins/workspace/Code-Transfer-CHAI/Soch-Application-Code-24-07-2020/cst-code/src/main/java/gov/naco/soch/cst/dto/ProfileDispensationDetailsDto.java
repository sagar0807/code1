package gov.naco.soch.cst.dto;

import java.util.Date;

import gov.naco.soch.cst.enums.RegulationVisitEnum;

public class ProfileDispensationDetailsDto {

	private Date visitDate;
	private String productname;
	private int givenQty;
	private int adherencePercentage;
	private RegulationVisitEnum regulationOfVisitStatus;

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getGivenQty() {
		return givenQty;
	}

	public void setGivenQty(int givenQty) {
		this.givenQty = givenQty;
	}

	public int getAdherencePercentage() {
		return adherencePercentage;
	}

	public void setAdherencePercentage(int adherencePercentage) {
		this.adherencePercentage = adherencePercentage;
	}

	public RegulationVisitEnum getRegulationOfVisitStatus() {
		return regulationOfVisitStatus;
	}

	public void setRegulationOfVisitStatus(RegulationVisitEnum regulationVisitEnum) {
		this.regulationOfVisitStatus = regulationVisitEnum;
	}


}
