package gov.naco.soch.shared.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BeneficiaryReferralDto {

	private LocalDate referralDate;
	private Long referredFromId;
	private String referredFrom;
	private Long referredToId;
	private String referredTo;
	private LocalDate acceptedDate;
	

	public LocalDate getReferralDate() {
		return referralDate;
	}

	public void setReferralDate(LocalDate referralDate) {
		this.referralDate = referralDate;
	}

	public Long getReferredFromId() {
		return referredFromId;
	}

	public void setReferredFromId(Long referredFromId) {
		this.referredFromId = referredFromId;
	}

	public String getReferredFrom() {
		return referredFrom;
	}

	public void setReferredFrom(String referredFrom) {
		this.referredFrom = referredFrom;
	}

	public Long getReferredToId() {
		return referredToId;
	}

	public void setReferredToId(Long referredToId) {
		this.referredToId = referredToId;
	}

	public String getReferredTo() {
		return referredTo;
	}

	public void setReferredTo(String referredTo) {
		this.referredTo = referredTo;
	}

	public LocalDate getAcceptedDate() {
		return acceptedDate;
	}

	public void setAcceptedDate(LocalDate acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

}
