package gov.naco.soch.inventory.dto;

import java.util.List;

public class CMSSExternalIndentIssuesDto {

	private List<String> dataHeading;
	private List<List<String>> dataValue;

	public List<String> getDataHeading() {
		return dataHeading;
	}

	public void setDataHeading(List<String> dataHeading) {
		this.dataHeading = dataHeading;
	}

	public List<List<String>> getDataValue() {
		return dataValue;
	}

	public void setDataValue(List<List<String>> dataValue) {
		this.dataValue = dataValue;
	}

}
