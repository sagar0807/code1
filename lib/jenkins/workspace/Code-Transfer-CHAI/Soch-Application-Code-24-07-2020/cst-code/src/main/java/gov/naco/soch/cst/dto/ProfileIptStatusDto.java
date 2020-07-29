package gov.naco.soch.cst.dto;

import java.util.Date;

public class ProfileIptStatusDto {

	private Date iptStartDate;
	private Date iptStopDate;
	private Date iptRestartDate;
	private Date iptEndDate;

	public Date getIptStartDate() {
		return iptStartDate;
	}

	public void setIptStartDate(Date iptStartDate) {
		this.iptStartDate = iptStartDate;
	}

	public Date getIptStopDate() {
		return iptStopDate;
	}

	public void setIptStopDate(Date iptStopDate) {
		this.iptStopDate = iptStopDate;
	}

	public Date getIptRestartDate() {
		return iptRestartDate;
	}

	public void setIptRestartDate(Date iptRestartDate) {
		this.iptRestartDate = iptRestartDate;
	}

	public Date getIptEndDate() {
		return iptEndDate;
	}

	public void setIptEndDate(Date iptEndDate) {
		this.iptEndDate = iptEndDate;
	}

}
