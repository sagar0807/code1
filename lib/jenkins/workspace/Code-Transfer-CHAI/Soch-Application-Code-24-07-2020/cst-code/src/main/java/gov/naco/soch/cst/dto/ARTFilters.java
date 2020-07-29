package gov.naco.soch.cst.dto;

import java.util.List;

import gov.naco.soch.dto.Series;

public class ARTFilters {

	private String name;
	private List<Series> series;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Series> getSeries() {
		return series;
	}

	public void setSeries(List<Series> series) {
		this.series = series;
	}

}
