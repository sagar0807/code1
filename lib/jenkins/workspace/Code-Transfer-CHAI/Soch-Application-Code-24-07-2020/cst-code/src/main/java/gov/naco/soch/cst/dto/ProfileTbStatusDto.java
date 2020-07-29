package gov.naco.soch.cst.dto;

import java.util.Date;

public class ProfileTbStatusDto {
	private Date tbDiagnoseDate;
	private Date attStartDate;
	private Date tbCompleteDate;

	public Date getTbDiagnoseDate() {
		return tbDiagnoseDate;
	}

	public void setTbDiagnoseDate(Date tbDiagnoseDate) {
		this.tbDiagnoseDate = tbDiagnoseDate;
	}

	public Date getAttStartDate() {
		return attStartDate;
	}

	public void setAttStartDate(Date attStartDate) {
		this.attStartDate = attStartDate;
	}

	public Date getTbCompleteDate() {
		return tbCompleteDate;
	}

	public void setTbCompleteDate(Date tbCompleteDate) {
		this.tbCompleteDate = tbCompleteDate;
	}

}
