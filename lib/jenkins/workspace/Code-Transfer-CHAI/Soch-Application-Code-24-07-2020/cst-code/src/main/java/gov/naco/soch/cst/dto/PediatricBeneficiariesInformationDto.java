
package gov.naco.soch.cst.dto;

import java.time.LocalDate;
import java.util.List;

import gov.naco.soch.dto.BaseDto;

public class PediatricBeneficiariesInformationDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long beneficiaryId;
	private Long sexId;
	private LocalDate age;
	private Long guardianHighestEducationId;
	private Long birthHistoryId;
	private Long birthWeight;
	private String neonatalComplications;
	private Long infantFeedingId;
	private Integer infantFeedingBreastFeedStopMonths;
	//private Long dnaPcrResultsId;
	private String milestoneAchieved;
	private Long assignedTo;
	private LocalDate nextVisitDate;
	private String otherVaccines;
	private Long stayingWithId;
	private String stayingWithOthers;
	private Long guardianCaregiverId;
	private String guardianCaregiverOthers;
	private List<ArtBeneficiaryImmunizationReportDto> artBeneficiaryImmunizationReportDtos;

	private List<DnaPcrResultsDto> dnaPcrResultsDtos;
	
	private List<VitaminAResultDto> vitaminAResultDtos;

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Long getSexId() {
		return sexId;
	}

	public void setSexId(Long sexId) {
		this.sexId = sexId;
	}

	public LocalDate getAge() {
		return age;
	}

	public void setAge(LocalDate age) {
		this.age = age;
	}

	public Long getGuardianHighestEducationId() {
		return guardianHighestEducationId;
	}

	public void setGuardianHighestEducationId(Long guardianHighestEducationId) {
		this.guardianHighestEducationId = guardianHighestEducationId;
	}

	public Long getBirthHistoryId() {
		return birthHistoryId;
	}

	public void setBirthHistoryId(Long birthHistoryId) {
		this.birthHistoryId = birthHistoryId;
	}

	public Long getBirthWeight() {
		return birthWeight;
	}

	public void setBirthWeight(Long birthWeight) {
		this.birthWeight = birthWeight;
	}

	public String getNeonatalComplications() {
		return neonatalComplications;
	}

	public void setNeonatalComplications(String neonatalComplications) {
		this.neonatalComplications = neonatalComplications;
	}

	public Long getInfantFeedingId() {
		return infantFeedingId;
	}

	public void setInfantFeedingId(Long infantFeedingId) {
		this.infantFeedingId = infantFeedingId;
	}

	public String getMilestoneAchieved() {
		return milestoneAchieved;
	}

	public void setMilestoneAchieved(String milestoneAchieved) {
		this.milestoneAchieved = milestoneAchieved;
	}

	public Long getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Long assignedTo) {
		this.assignedTo = assignedTo;
	}

	public LocalDate getNextVisitDate() {
		return nextVisitDate;
	}

	public void setNextVisitDate(LocalDate nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}

	public String getOtherVaccines() {
		return otherVaccines;
	}

	public void setOtherVaccines(String otherVaccines) {
		this.otherVaccines = otherVaccines;
	}

	public Long getStayingWithId() {
		return stayingWithId;
	}

	public void setStayingWithId(Long stayingWithId) {
		this.stayingWithId = stayingWithId;
	}

	public String getStayingWithOthers() {
		return stayingWithOthers;
	}

	public void setStayingWithOthers(String stayingWithOthers) {
		this.stayingWithOthers = stayingWithOthers;
	}

	public Long getGuardianCaregiverId() {
		return guardianCaregiverId;
	}

	public void setGuardianCaregiverId(Long guardianCaregiverId) {
		this.guardianCaregiverId = guardianCaregiverId;
	}

	public String getGuardianCaregiverOthers() {
		return guardianCaregiverOthers;
	}

	public void setGuardianCaregiverOthers(String guardianCaregiverOthers) {
		this.guardianCaregiverOthers = guardianCaregiverOthers;
	}

	public List<ArtBeneficiaryImmunizationReportDto> getArtBeneficiaryImmunizationReportDtos() {
		return artBeneficiaryImmunizationReportDtos;
	}

	public void setArtBeneficiaryImmunizationReportDtos(
			List<ArtBeneficiaryImmunizationReportDto> artBeneficiaryImmunizationReportDtos) {
		this.artBeneficiaryImmunizationReportDtos = artBeneficiaryImmunizationReportDtos;
	}

	public List<DnaPcrResultsDto> getDnaPcrResultsDtos() {
		return dnaPcrResultsDtos;
	}

	public void setDnaPcrResultsDtos(List<DnaPcrResultsDto> dnaPcrResultsDtos) {
		this.dnaPcrResultsDtos = dnaPcrResultsDtos;
	}

	public List<VitaminAResultDto> getVitaminAResultDtos() {
		return vitaminAResultDtos;
	}

	public void setVitaminAResultDtos(List<VitaminAResultDto> vitaminAResultDtos) {
		this.vitaminAResultDtos = vitaminAResultDtos;
	}

	public Integer getInfantFeedingBreastFeedStopMonths() {
		return infantFeedingBreastFeedStopMonths;
	}

	public void setInfantFeedingBreastFeedStopMonths(Integer infantFeedingBreastFeedStopMonths) {
		this.infantFeedingBreastFeedStopMonths = infantFeedingBreastFeedStopMonths;
	}

	
}
