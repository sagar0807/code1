package gov.naco.soch.cst.dto;

import java.time.LocalDate;
import java.util.List;

public class TbOiDetailsDto {

	private Long beneficiaryId;
	private Long id;
	private LocalDate visitDate;
	private String remarks;
	private Long vistorRegisterId;
	private List<ArtBeneficiaryOpportunisticInfectionDto> infectionDto;

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getVistorRegisterId() {
		return vistorRegisterId;
	}

	public void setVistorRegisterId(Long vistorRegisterId) {
		this.vistorRegisterId = vistorRegisterId;
	}

	public List<ArtBeneficiaryOpportunisticInfectionDto> getInfectionDto() {
		return infectionDto;
	}

	public void setInfectionDto(List<ArtBeneficiaryOpportunisticInfectionDto> infectionDto) {
		this.infectionDto = infectionDto;
	}
	
	

}
