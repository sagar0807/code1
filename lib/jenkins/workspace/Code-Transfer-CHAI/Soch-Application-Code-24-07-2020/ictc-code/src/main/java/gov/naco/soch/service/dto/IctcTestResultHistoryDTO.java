package gov.naco.soch.service.dto;

import java.util.List;

import gov.naco.soch.domain.Beneficiary;
import gov.naco.soch.domain.ICTCTestResult;
import gov.naco.soch.domain.LabTestSample;

public class IctcTestResultHistoryDTO {
	
	private List<ICTCTestResult> testResults;
	
	private Beneficiary motherDetails;
	
	private LabTestSample labTestSample;

	public List<ICTCTestResult> getTestResults() {
		return testResults;
	}

	public void setTestResults(List<ICTCTestResult> testResults) {
		this.testResults = testResults;
	}

	public Beneficiary getMotherDetails() {
		return motherDetails;
	}

	public void setMotherDetails(Beneficiary motherDetails) {
		this.motherDetails = motherDetails;
	}

	public LabTestSample getLabTestSample() {
		return labTestSample;
	}

	public void setLabTestSample(LabTestSample labTestSample) {
		this.labTestSample = labTestSample;
	}

	@Override
	public String toString() {
		return "IctcTestResultHistoryDTO [testResults=" + testResults + ", motherDetails=" + motherDetails
				+ ", labTestSample=" + labTestSample + "]";
	}
	
}