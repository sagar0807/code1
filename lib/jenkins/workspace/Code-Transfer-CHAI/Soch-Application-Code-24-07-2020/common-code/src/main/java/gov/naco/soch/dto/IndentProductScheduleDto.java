package gov.naco.soch.dto;

import java.util.List;

public class IndentProductScheduleDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long scheduleId;
	private String scheduleNumber;
	private Long quantity;
	private Double unitPrice;
	private List<IndentProductScheduleSacsDto> sacsList;

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getScheduleNumber() {
		return scheduleNumber;
	}

	public void setScheduleNumber(String scheduleNumber) {
		this.scheduleNumber = scheduleNumber;
	}

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

	public List<IndentProductScheduleSacsDto> getSacsList() {
		return sacsList;
	}

	public void setSacsList(List<IndentProductScheduleSacsDto> sacsList) {
		this.sacsList = sacsList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
