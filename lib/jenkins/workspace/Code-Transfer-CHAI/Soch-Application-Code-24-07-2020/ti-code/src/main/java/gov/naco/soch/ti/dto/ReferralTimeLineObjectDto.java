package gov.naco.soch.ti.dto;

import java.time.LocalDateTime;

public class ReferralTimeLineObjectDto {
	private Long referralId;
	private String codeType;
	private String benCode;
	private Long facilityFrom;
	private String facilityFromName;
	private Long facilityTo;
	private String facilityToName;
	private LocalDateTime acceptedDate;
	private String referralReason;
	private String status;
	private String clientStatus;

	public Long getReferralId() {
		return referralId;
	}

	public void setReferralId(Long referralId) {
		this.referralId = referralId;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getBenCode() {
		return benCode;
	}

	public void setBenCode(String benCode) {
		this.benCode = benCode;
	}

	public Long getFacilityFrom() {
		return facilityFrom;
	}

	public void setFacilityFrom(Long facilityFrom) {
		this.facilityFrom = facilityFrom;
	}

	public String getFacilityFromName() {
		return facilityFromName;
	}

	public void setFacilityFromName(String facilityFromName) {
		this.facilityFromName = facilityFromName;
	}

	public Long getFacilityTo() {
		return facilityTo;
	}

	public void setFacilityTo(Long facilityTo) {
		this.facilityTo = facilityTo;
	}

	public String getFacilityToName() {
		return facilityToName;
	}

	public void setFacilityToName(String facilityToName) {
		this.facilityToName = facilityToName;
	}

	public LocalDateTime getAcceptedDate() {
		return acceptedDate;
	}

	public void setAcceptedDate(LocalDateTime acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

	public String getReferralReason() {
		return referralReason;
	}

	public void setReferralReason(String referralReason) {
		this.referralReason = referralReason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getClientStatus() {
		return clientStatus;
	}

	public void setClientStatus(String clientStatus) {
		this.clientStatus = clientStatus;
	}

}
