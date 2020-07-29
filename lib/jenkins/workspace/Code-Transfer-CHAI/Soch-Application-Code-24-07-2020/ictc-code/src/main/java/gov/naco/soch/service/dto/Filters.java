package gov.naco.soch.service.dto;

import java.util.List;

public class Filters {
	
	private String name;
	private List<Series> series ;
	
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
