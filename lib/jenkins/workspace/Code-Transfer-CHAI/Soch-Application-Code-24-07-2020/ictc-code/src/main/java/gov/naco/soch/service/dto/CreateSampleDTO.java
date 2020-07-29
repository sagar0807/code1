package gov.naco.soch.service.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreateSampleDTO {

	private Long ictcBeneficiaryId;

	private Integer testType;

	private Integer infantBreastFed;

	private String barcode;

	private LocalDate visitDate;

	private Long visitId;

	private Long facilityId;
	
	private Long labTechnicianId;
	
	private LocalDateTime sampleCollectionDate;

	public Long getIctcBeneficiaryId() {
		return ictcBeneficiaryId;
	}

	public void setIctcBeneficiaryId(Long ictcBeneficiaryId) {
		this.ictcBeneficiaryId = ictcBeneficiaryId;
	}

	public Integer getTestType() {
		return testType;
	}

	public void setTestType(Integer testType) {
		this.testType = testType;
	}

	public Integer getInfantBreastFed() {
		return infantBreastFed;
	}

	public void setInfantBreastFed(Integer infantBreastFed) {
		this.infantBreastFed = infantBreastFed;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public Long getVisitId() {
		return visitId;
	}

	public void setVisitId(Long visitId) {
		this.visitId = visitId;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}
	
	public LocalDateTime getSampleCollectionDate() {
		return sampleCollectionDate;
	}

	public void setSampleCollectionDate(LocalDateTime sampleCollectionDate) {
		this.sampleCollectionDate = sampleCollectionDate;
	}
	
	public Long getLabTechnicianId() {
		return labTechnicianId;
	}

	public void setLabTechnicianId(Long labTechnicianId) {
		this.labTechnicianId = labTechnicianId;
	}

	@Override
	public String toString() {
		return "CreateSampleDTO [ictcBeneficiaryId=" + ictcBeneficiaryId + ", testType=" + testType
				+ ", infantBreastFed=" + infantBreastFed + ", barcode=" + barcode + ", visitDate=" + visitDate
				+ ", visitId=" + visitId + ", facilityId=" + facilityId + ", sampleCollectionDate="
				+ sampleCollectionDate + "]";
	}
	
}
