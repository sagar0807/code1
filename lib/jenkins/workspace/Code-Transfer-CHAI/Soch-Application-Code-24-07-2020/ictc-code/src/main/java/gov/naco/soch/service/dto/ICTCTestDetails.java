package gov.naco.soch.service.dto;

import gov.naco.soch.domain.Beneficiary;
import gov.naco.soch.domain.Facility;
import gov.naco.soch.domain.LabTestSample;

public class ICTCTestDetails {

	private Facility ictcDetails;
	
	private Facility eidLabDetails;
	
	private Beneficiary beneficiaryDetails;
	
	private ICTCBeneficiaryDTO ictcBeneficiaryDetails;
	
	private ICTCSampleCollectionDTO sampleDetails;
	
	private ICTCTestResultDTO resultDto;
	
	private ICTCVisitDTO visitDetails;
	
	private LabTestSample eidLabSampleDetails;
	
	private Beneficiary motherDetails;

	public Facility getIctcDetails() {
		return ictcDetails;
	}

	public void setIctcDetails(Facility ictcDetails) {
		this.ictcDetails = ictcDetails;
	}

	public Facility getEidLabDetails() {
		return eidLabDetails;
	}

	public void setEidLabDetails(Facility eidLabDetails) {
		this.eidLabDetails = eidLabDetails;
	}

	public Beneficiary getBeneficiaryDetails() {
		return beneficiaryDetails;
	}

	public void setBeneficiaryDetails(Beneficiary beneficiaryDetails) {
		this.beneficiaryDetails = beneficiaryDetails;
	}

	public ICTCBeneficiaryDTO getIctcBeneficiaryDetails() {
		return ictcBeneficiaryDetails;
	}

	public void setIctcBeneficiaryDetails(ICTCBeneficiaryDTO ictcBeneficiaryDetails) {
		this.ictcBeneficiaryDetails = ictcBeneficiaryDetails;
	}

	public ICTCSampleCollectionDTO getSampleDetails() {
		return sampleDetails;
	}

	public void setSampleDetails(ICTCSampleCollectionDTO sampleDetails) {
		this.sampleDetails = sampleDetails;
	}

	public ICTCTestResultDTO getResultDto() {
		return resultDto;
	}

	public void setResultDto(ICTCTestResultDTO resultDto) {
		this.resultDto = resultDto;
	}

	public ICTCVisitDTO getVisitDetails() {
		return visitDetails;
	}

	public void setVisitDetails(ICTCVisitDTO visitDetails) {
		this.visitDetails = visitDetails;
	}
	
	public LabTestSample getEidLabSampleDetails() {
		return eidLabSampleDetails;
	}

	public void setEidLabSampleDetails(LabTestSample eidLabSampleDetails) {
		this.eidLabSampleDetails = eidLabSampleDetails;
	}

	public Beneficiary getMotherDetails() {
		return motherDetails;
	}

	public void setMotherDetails(Beneficiary motherDetails) {
		this.motherDetails = motherDetails;
	}

	@Override
	public String toString() {
		return "ICTCTestDetails [ictcDetails=" + ictcDetails + ", eidLabDetails=" + eidLabDetails
				+ ", beneficiaryDetails=" + beneficiaryDetails + ", ictcBeneficiaryDetails=" + ictcBeneficiaryDetails
				+ ", sampleDetails=" + sampleDetails + ", resultDto=" + resultDto + ", visitDetails=" + visitDetails
				+ ", eidLabSampleDetails=" + eidLabSampleDetails + ", motherDetails=" + motherDetails + "]";
	}
	
}
