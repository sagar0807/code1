package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class UpdateTestResultDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long resultId;

	private Integer hivStatus;

	private Integer hivType;

	private LocalDate testedDate;

	private LocalDate reportReceivedDate;

	private LocalDate reportDeliveryDate;
	
	private Long labInchargeId;

	public Long getResultId() {
		return resultId;
	}

	public void setResultId(Long resultId) {
		this.resultId = resultId;
	}

	public Integer getHivStatus() {
		return hivStatus;
	}

	public void setHivStatus(Integer hivStatus) {
		this.hivStatus = hivStatus;
	}

	public Integer getHivType() {
		return hivType;
	}

	public void setHivType(Integer hivType) {
		this.hivType = hivType;
	}

	public LocalDate getTestedDate() {
		return testedDate;
	}

	public void setTestedDate(LocalDate testedDate) {
		this.testedDate = testedDate;
	}

	public LocalDate getReportReceivedDate() {
		return reportReceivedDate;
	}

	public void setReportReceivedDate(LocalDate reportReceivedDate) {
		this.reportReceivedDate = reportReceivedDate;
	}

	public LocalDate getReportDeliveryDate() {
		return reportDeliveryDate;
	}

	public void setReportDeliveryDate(LocalDate reportDeliveryDate) {
		this.reportDeliveryDate = reportDeliveryDate;
	}
	
	public Long getLabInchargeId() {
		return labInchargeId;
	}

	public void setLabInchargeId(Long labInchargeId) {
		this.labInchargeId = labInchargeId;
	}

	@Override
	public String toString() {
		return "UpdateTestResultDTO [resultId=" + resultId + ", hivStatus=" + hivStatus + ", hivType=" + hivType
				+ ", testedDate=" + testedDate + ", reportReceivedDate=" + reportReceivedDate + ", reportDeliveryDate="
				+ reportDeliveryDate + ", labInchargeId=" + labInchargeId + "]";
	}

}
