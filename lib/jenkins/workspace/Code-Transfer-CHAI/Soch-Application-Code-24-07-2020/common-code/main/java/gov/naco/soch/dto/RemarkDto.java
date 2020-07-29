package gov.naco.soch.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class RemarkDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private String userName;
	private String remarks;
	private String date;
	private static final String DATEFORMAT = "dd MMM yyyy - hh:mm a";
	private static final String ZONEID = "Asia/Kolkata";

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String convertLocalDateTimeToDate(LocalDateTime remarkDate) {
		if (remarkDate != null) {
			ZoneId zoneId = ZoneId.of(ZONEID);
			ZonedDateTime zdtAtAsia = remarkDate.atZone(zoneId);
			this.date = DateTimeFormatter.ofPattern(DATEFORMAT).format(zdtAtAsia);
		}

		return this.date;

	}

}
