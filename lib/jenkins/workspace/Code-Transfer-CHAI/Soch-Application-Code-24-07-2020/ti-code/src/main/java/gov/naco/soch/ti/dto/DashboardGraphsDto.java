package gov.naco.soch.ti.dto;

import java.util.ArrayList;
import java.util.List;

public class DashboardGraphsDto {

	private String title;
	private List<Widgets> widgets= new ArrayList<Widgets>();
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Widgets> getWidgets() {
		return widgets;
	}
	public void setWidgets(List<Widgets> widgets) {
		this.widgets = widgets;
	}
	
	
}

