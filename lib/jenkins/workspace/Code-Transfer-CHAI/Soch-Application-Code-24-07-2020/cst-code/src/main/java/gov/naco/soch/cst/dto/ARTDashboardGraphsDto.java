package gov.naco.soch.cst.dto;

import java.util.ArrayList;
import java.util.List;


public class ARTDashboardGraphsDto {
	

	private String title;
	private List<ARTWidgets> widgets= new ArrayList<ARTWidgets>();
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<ARTWidgets> getWidgets() {
		return widgets;
	}
	public void setWidgets(List<ARTWidgets> widgets) {
		this.widgets = widgets;
	}
	
}
