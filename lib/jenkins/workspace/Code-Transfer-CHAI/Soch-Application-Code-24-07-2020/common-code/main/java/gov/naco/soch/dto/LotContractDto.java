package gov.naco.soch.dto;

import java.util.Date;

public class LotContractDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private Long lotId;
	private Date startDate;
	private Date endDate;
	private Long quantity;
	private String lotNumber;

	private Long scheduleId;
	private String scheduleNumber;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getLotId() {
		return lotId;
	}

	public void setLotId(Long lotId) {
		this.lotId = lotId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Long getQuantity() {
		return quantity;
	}

	public String getLotNumber() {
		return lotNumber;
	}

	public Long getScheduleId() {
		return scheduleId;
	}

	public String getScheduleNumber() {
		return scheduleNumber;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public void setScheduleNumber(String scheduleNumber) {
		this.scheduleNumber = scheduleNumber;
	}

}
