package gov.naco.soch.inventory.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import gov.naco.soch.constructordto.SACSSummaryDto;

@JsonInclude(Include.NON_EMPTY)
public class DashBoardResponseDto {

	private SACSSummaryDto summary;
	private List<DashboardGraphsDto> categories = new ArrayList<DashboardGraphsDto>();

	public SACSSummaryDto getSummary() {
		return summary;
	}

	public void setSummary(SACSSummaryDto summary) {
		this.summary = summary;
	}

	public List<DashboardGraphsDto> getCategories() {
		return categories;
	}

	public void setCategories(List<DashboardGraphsDto> categories) {
		this.categories = categories;
	}

}
