package gov.naco.soch.dto;

import java.util.List;

public class ScheduleProductDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long scheduleId;
	private String scheduleNumber;
	private Long quantity;
	private Double unitPrice;
	private List<ContractSacsDto> sacs;
	private Long dispatchedQuantity;

	//added for drop down purpose
	List<LotContractDto> lots;

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public List<ContractSacsDto> getSacs() {
		return sacs;
	}

	public void setSacs(List<ContractSacsDto> sacs) {
		this.sacs = sacs;
	}

	public String getScheduleNumber() {
		return scheduleNumber;
	}

	public void setScheduleNumber(String scheduleNumber) {
		this.scheduleNumber = scheduleNumber;
	}
	public List<LotContractDto> getLots() {
		return lots;
	}

	public void setLots(List<LotContractDto> lots) {
		this.lots = lots;
	}
	
	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Long getDispatchedQuantity() {
		return dispatchedQuantity;
	}

	public void setDispatchedQuantity(Long dispatchedQuantity) {
		this.dispatchedQuantity = dispatchedQuantity;
	}



}
