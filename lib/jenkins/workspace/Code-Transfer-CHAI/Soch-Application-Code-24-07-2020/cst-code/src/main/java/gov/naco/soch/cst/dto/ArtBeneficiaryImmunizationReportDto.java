/**
 * 
 */
package gov.naco.soch.cst.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class ArtBeneficiaryImmunizationReportDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long benefciaryId;
	private Long vaccineStageId;
	private String vaccineStageName;
	private Long vaccineTypeId;
	private String vaccineTypeName;
	private LocalDate dueDate;
	private LocalDate giveDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBenefciaryId() {
		return benefciaryId;
	}
	public void setBenefciaryId(Long benefciaryId) {
		this.benefciaryId = benefciaryId;
	}
	public Long getVaccineStageId() {
		return vaccineStageId;
	}
	public void setVaccineStageId(Long vaccineStageId) {
		this.vaccineStageId = vaccineStageId;
	}
	public String getVaccineStageName() {
		return vaccineStageName;
	}
	public void setVaccineStageName(String vaccineStageName) {
		this.vaccineStageName = vaccineStageName;
	}
	public Long getVaccineTypeId() {
		return vaccineTypeId;
	}
	public void setVaccineTypeId(Long vaccineTypeId) {
		this.vaccineTypeId = vaccineTypeId;
	}
	public String getVaccineTypeName() {
		return vaccineTypeName;
	}
	public void setVaccineTypeName(String vaccineTypeName) {
		this.vaccineTypeName = vaccineTypeName;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public LocalDate getGiveDate() {
		return giveDate;
	}
	public void setGiveDate(LocalDate giveDate) {
		this.giveDate = giveDate;
	}
	

	
}
