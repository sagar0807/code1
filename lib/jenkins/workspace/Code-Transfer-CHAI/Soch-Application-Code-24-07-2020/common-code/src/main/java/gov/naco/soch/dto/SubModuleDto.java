package gov.naco.soch.dto;

import java.util.List;

public class SubModuleDto {

	private int orderId;
	private String subModuleName;
	private List<ReportsDto> reports;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getSubModuleName() {
		return subModuleName;
	}

	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}

	public List<ReportsDto> getReports() {
		return reports;
	}

	public void setReports(List<ReportsDto> reports) {
		this.reports = reports;
	}

}
