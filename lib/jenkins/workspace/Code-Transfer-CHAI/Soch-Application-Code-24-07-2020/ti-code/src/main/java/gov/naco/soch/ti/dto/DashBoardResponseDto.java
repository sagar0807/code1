package gov.naco.soch.ti.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import gov.naco.soch.constructordto.SummaryDto;

@JsonInclude(Include.NON_EMPTY)
public class DashBoardResponseDto {

	private SummaryDto summary;
	private List<DashboardGraphsDto> categories = new ArrayList<DashboardGraphsDto>();

	public SummaryDto getSummary() {
		return summary;
	}

	public void setSummary(SummaryDto summary) {
		this.summary = summary;
	}

	public List<DashboardGraphsDto> getCategories() {
		return categories;
	}

	public void setCategories(List<DashboardGraphsDto> categories) {
		this.categories = categories;
	}

	
	
}
