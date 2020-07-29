package gov.naco.soch.service.dto;

public class ICTCDashboardRequestDTO {

	private Long facilityId;
	private int filterYear;
	private int filterMonth;

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public int getFilterYear() {
		return filterYear;
	}

	public void setFilterYear(int filterYear) {
		this.filterYear = filterYear;
	}

	public int getFilterMonth() {
		return filterMonth;
	}

	public void setFilterMonth(int filterMonth) {
		this.filterMonth = filterMonth;
	}

}
