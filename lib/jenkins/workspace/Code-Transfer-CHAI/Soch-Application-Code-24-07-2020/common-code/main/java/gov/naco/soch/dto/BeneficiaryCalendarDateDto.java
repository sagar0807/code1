package gov.naco.soch.dto;

import java.util.Date;
import java.util.List;

public class BeneficiaryCalendarDateDto {
	private Date date;
	private int oId;

	private List<BeneficiaryCalendarEventDto> beneficiaryCalendarEventDtos;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public List<BeneficiaryCalendarEventDto> getBeneficiaryCalendarEventDtos() {
		return beneficiaryCalendarEventDtos;
	}

	public void setBeneficiaryCalendarEventDtos(List<BeneficiaryCalendarEventDto> beneficiaryCalendarEventDtos) {
		this.beneficiaryCalendarEventDtos = beneficiaryCalendarEventDtos;
	}

}
