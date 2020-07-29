package gov.naco.soch.dto;

import java.util.List;

import gov.naco.soch.constructordto.FacilityPerformanceDto;

public class FacilityPerformanceResultDto {

	private String sectionId;
	private String sectionDesc;
	private List<FacilityPerformanceDto> indicatorList;

	public String getSectionId() {
		return sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionDesc() {
		return sectionDesc;
	}

	public void setSectionDesc(String sectionDesc) {
		this.sectionDesc = sectionDesc;
	}

	public List<FacilityPerformanceDto> getIndicatorList() {
		return indicatorList;
	}

	public void setIndicatorList(List<FacilityPerformanceDto> indicatorList) {
		this.indicatorList = indicatorList;
	}

}
