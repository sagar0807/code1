package gov.naco.soch.cst.dto;

import java.math.BigInteger;
import java.util.List;

public class InvestigationDetailsDto {
	
	private List<InvestigationCountDto> investigationCountDtoList;
	
	private Long investigationId ;

	public List<InvestigationCountDto> getInvestigationCountDtoList() {
		return investigationCountDtoList;
	}

	public void setInvestigationCountDtoList(List<InvestigationCountDto> investigationCountDtoList) {
		this.investigationCountDtoList = investigationCountDtoList;
	}

	public Long getInvestigationId() {
		return investigationId;
	}

	public void setInvestigationId(Long investigationId) {
		this.investigationId = investigationId;
	}
	
}
