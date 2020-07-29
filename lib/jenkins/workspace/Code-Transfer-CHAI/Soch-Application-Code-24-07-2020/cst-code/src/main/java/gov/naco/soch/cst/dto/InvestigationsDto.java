package gov.naco.soch.cst.dto;

import java.util.List;

public class InvestigationsDto {

	private Long investigationId;

	private List<InvestigationDataDto> investigationData;

	public Long getInvestigationId() {
		return investigationId;
	}

	public void setInvestigationId(Long investigationId) {
		this.investigationId = investigationId;
	}

	public List<InvestigationDataDto> getInvestigationData() {
		return investigationData;
	}

	public void setInvestigationData(List<InvestigationDataDto> investigationData) {
		this.investigationData = investigationData;
	}

}
