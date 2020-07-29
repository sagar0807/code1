package gov.naco.soch.cst.dto;

import java.util.ArrayList;
import java.util.List;

public class ARTDashboardRequestDTO {

	private Long facilityId;
	private String filterType;
	private String filterName;
	private List<String> items = new ArrayList<String>();
	private String fromDate;
	private String toDate;

	public Long getFacilityId() {
		return facilityId;
	}
	
	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public String getFilterType() {
		return filterType;
	}

	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

}
