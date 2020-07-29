package gov.naco.soch.service.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class ICTCDashBoardResponseDTO {

	private List<DashBoardSummaryDTO> summary;
	private List<DashboardGraphsDto> categories = new ArrayList<DashboardGraphsDto>();

	public List<DashBoardSummaryDTO> getSummary() {
		return summary;
	}

	public void setSummary(List<DashBoardSummaryDTO> summary) {
		this.summary = summary;
	}

	public List<DashboardGraphsDto> getCategories() {
		return categories;
	}

	public void setCategories(List<DashboardGraphsDto> categories) {
		this.categories = categories;
	}

}
