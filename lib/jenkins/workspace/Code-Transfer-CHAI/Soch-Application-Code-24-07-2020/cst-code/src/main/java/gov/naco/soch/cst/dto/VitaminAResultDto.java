
package gov.naco.soch.cst.dto;

import java.time.LocalDate;

import gov.naco.soch.dto.BaseDto;

public class VitaminAResultDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long vitaminAAgeId;
	private String vitaminAAgeName;
	private LocalDate givenDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getVitaminAAgeId() {
		return vitaminAAgeId;
	}
	public void setVitaminAAgeId(Long vitaminAAgeId) {
		this.vitaminAAgeId = vitaminAAgeId;
	}
	public String getVitaminAAgeName() {
		return vitaminAAgeName;
	}
	public void setVitaminAAgeName(String vitaminAAgeName) {
		this.vitaminAAgeName = vitaminAAgeName;
	}
	public LocalDate getGivenDate() {
		return givenDate;
	}
	public void setGivenDate(LocalDate givenDate) {
		this.givenDate = givenDate;
	}
	
	
}
