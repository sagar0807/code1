package gov.naco.soch.dto;

import java.util.List;

public class BeneficiaryServiceCalendarDto {
	private int serviceId;
	private List<BeneficiaryCalendarDateDto> dateList;

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public List<BeneficiaryCalendarDateDto> getDateList() {
		return dateList;
	}

	public void setDateList(List<BeneficiaryCalendarDateDto> dateList) {
		this.dateList = dateList;
	}

}