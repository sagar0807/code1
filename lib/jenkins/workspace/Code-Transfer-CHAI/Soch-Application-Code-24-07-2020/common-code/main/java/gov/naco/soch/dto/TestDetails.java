
package gov.naco.soch.dto;

public class TestDetails {
	Long test;
	String barcode;
	String testName;
	Long testType;

	public Long getTest() {
		return test;
	}

	public void setTest(Long test) {
		this.test = test;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barCode) {
		this.barcode = barCode;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Long getTestType() {
		return testType;
	}

	public void setTestType(Long testType) {
		this.testType = testType;
	}

	@Override
	public String toString() {
		return "TestDetails [test=" + test + ", barcode=" + barcode + ", testName=" + testName + ", testType="
				+ testType + "]";
	}

}
