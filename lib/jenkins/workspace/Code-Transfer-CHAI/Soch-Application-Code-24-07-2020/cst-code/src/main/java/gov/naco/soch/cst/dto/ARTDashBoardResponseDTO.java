package gov.naco.soch.cst.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class ARTDashBoardResponseDTO {
	
	private List<ARTDashboardGraphsDto> categories = new ArrayList<ARTDashboardGraphsDto>();

	public List<ARTDashboardGraphsDto> getCategories() {
		return categories;
	}

	public void setCategories(List<ARTDashboardGraphsDto> categories) {
		this.categories = categories;
	}

}
