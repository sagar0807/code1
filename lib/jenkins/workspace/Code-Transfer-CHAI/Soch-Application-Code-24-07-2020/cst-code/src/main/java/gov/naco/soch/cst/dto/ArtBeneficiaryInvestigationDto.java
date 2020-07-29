package gov.naco.soch.cst.dto;

import java.time.LocalDate;
import java.util.List;

public class ArtBeneficiaryInvestigationDto {

	private Long beneficiaryId;
	private Long facilityId;
	private Long visitRegisterId;
	private List<LocalDate> investigationDates;
	private List<InvestigationsDto> investigations;

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public Long getVisitRegisterId() {
		return visitRegisterId;
	}

	public void setVisitRegisterId(Long visitRegisterId) {
		this.visitRegisterId = visitRegisterId;
	}

	public List<LocalDate> getInvestigationDates() {
		return investigationDates;
	}

	public void setInvestigationDates(List<LocalDate> investigationDates) {
		this.investigationDates = investigationDates;
	}

	public List<InvestigationsDto> getInvestigations() {
		return investigations;
	}

	public void setInvestigations(List<InvestigationsDto> investigations) {
		this.investigations = investigations;
	}

}
