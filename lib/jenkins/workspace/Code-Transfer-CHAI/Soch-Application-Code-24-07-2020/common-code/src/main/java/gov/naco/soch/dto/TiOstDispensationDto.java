package gov.naco.soch.dto;

import java.time.LocalDate;
import java.util.List;

public class TiOstDispensationDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long facilityId;
	private Long substituitionDrugId;
	private String substituitionDrug;
	private LocalDate date;
	private List<BeneficiaryDispensationDto> beneficiaries;
	private List<OstDispenseBatchDto> batchDetails;
	private String warningMessage;
	private  boolean isOk;

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public String getSubstituitionDrug() {
		return substituitionDrug;
	}

	public void setSubstituitionDrug(String substituitionDrug) {
		this.substituitionDrug = substituitionDrug;
	}

	public boolean isOk() {
	    return isOk;
	}

	public void setOk(boolean isOk) {
	    this.isOk = isOk;
	}

	public String getWarningMessage() {
	    return warningMessage;
	}

	public void setWarningMessage(String warningMessage) {
	    this.warningMessage = warningMessage;
	}

	public List<BeneficiaryDispensationDto> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(List<BeneficiaryDispensationDto> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	public List<OstDispenseBatchDto> getBatchDetails() {
		return batchDetails;
	}

	public void setBatchDetails(List<OstDispenseBatchDto> batchDetails) {
		this.batchDetails = batchDetails;
	}

	public Long getSubstituitionDrugId() {
		return substituitionDrugId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setSubstituitionDrugId(Long substituitionDrugId) {
		this.substituitionDrugId = substituitionDrugId;
	}

}
