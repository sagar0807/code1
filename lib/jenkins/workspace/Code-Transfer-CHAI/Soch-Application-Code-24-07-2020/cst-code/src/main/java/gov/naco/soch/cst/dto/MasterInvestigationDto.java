package gov.naco.soch.cst.dto;

import java.math.BigInteger;

public class MasterInvestigationDto {
	
	private BigInteger investigationId;
	
	private String investigationName;

	public BigInteger getInvestigationId() {
		return investigationId;
	}

	public void setInvestigationId(BigInteger investigationId) {
		this.investigationId = investigationId;
	}

	public String getInvestigationName() {
		return investigationName;
	}

	public void setInvestigationName(String investigationName) {
		this.investigationName = investigationName;
	}

}
