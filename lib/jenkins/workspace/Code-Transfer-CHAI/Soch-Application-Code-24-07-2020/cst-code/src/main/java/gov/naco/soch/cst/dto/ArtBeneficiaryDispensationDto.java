package gov.naco.soch.cst.dto;

import java.time.LocalDate;
import java.util.List;

import gov.naco.soch.dto.BaseDto;

public class ArtBeneficiaryDispensationDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long artPepId;
	private Long beneficiaryId;
	private Long facilityId;
	private String dispensedTo;
	private String dispensationType;
	private LocalDate nextAppointmentDate;
	private Boolean isTransit;
	private Long regimenId;
	private List<LastDispensationProductDto> products;

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public Long getRegimenId() {
		return regimenId;
	}

	public void setRegimenId(Long regimenId) {
		this.regimenId = regimenId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public String getDispensedTo() {
		return dispensedTo;
	}

	public void setDispensedTo(String dispensedTo) {
		this.dispensedTo = dispensedTo;
	}

	public String getDispensationType() {
		return dispensationType;
	}

	public void setDispensationType(String dispensationType) {
		this.dispensationType = dispensationType;
	}

	public List<LastDispensationProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<LastDispensationProductDto> products) {
		this.products = products;
	}

	public LocalDate getNextAppointmentDate() {
		return nextAppointmentDate;
	}

	public void setNextAppointmentDate(LocalDate nextAppointmentDate) {
		this.nextAppointmentDate = nextAppointmentDate;
	}

	public Boolean getIsTransit() {
		return isTransit;
	}

	public void setIsTransit(Boolean isTransit) {
		this.isTransit = isTransit;
	}

	public Long getArtPepId() {
		return artPepId;
	}

	public void setArtPepId(Long artPepId) {
		this.artPepId = artPepId;
	}

}
