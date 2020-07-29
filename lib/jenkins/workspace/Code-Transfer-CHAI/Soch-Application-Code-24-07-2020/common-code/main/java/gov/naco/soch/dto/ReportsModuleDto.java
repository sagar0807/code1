package gov.naco.soch.dto;

import java.util.List;

public class ReportsModuleDto {

	private int orderId;
	private String moduleName;
	private List<SubModuleDto> submodule;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public List<SubModuleDto> getSubmodule() {
		return submodule;
	}

	public void setSubmodule(List<SubModuleDto> submodule) {
		this.submodule = submodule;
	}

}
