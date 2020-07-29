package gov.naco.soch.dto;

import java.time.LocalDate;

public class BeneficiaryFollowUpListDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long beneficiayId;

	private LocalDate currentFollowUpDate;
	private LocalDate nextFollowUpDate;
	private boolean isActive;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBeneficiayId() {
		return beneficiayId;
	}

	public void setBeneficiayId(Long beneficiayId) {
		this.beneficiayId = beneficiayId;
	}

	public LocalDate getCurrentFollowUpDate() {
		return currentFollowUpDate;
	}

	public void setCurrentFollowUpDate(LocalDate currentFollowUpDate) {
		this.currentFollowUpDate = currentFollowUpDate;
	}

	public LocalDate getNextFollowUpDate() {
		return nextFollowUpDate;
	}

	public void setNextFollowUpDate(LocalDate nextFollowUpDate) {
		this.nextFollowUpDate = nextFollowUpDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
