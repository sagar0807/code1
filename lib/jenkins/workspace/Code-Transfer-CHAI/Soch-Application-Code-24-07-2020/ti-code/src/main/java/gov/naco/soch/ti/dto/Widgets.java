package gov.naco.soch.ti.dto;

import java.util.ArrayList;
import java.util.List;

import gov.naco.soch.dto.Category;
import gov.naco.soch.dto.Series;

public class Widgets {

	private String type;
	private String chartTitle;
	private String xAxisTitle;
	private String yAxisTitle;
	private List<String> labels = new ArrayList<>();
	private List<Series> series = new ArrayList<>();
	private List<Filters> filters = new ArrayList<>();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getChartTitle() {
		return chartTitle;
	}

	public void setChartTitle(String chartTitle) {
		this.chartTitle = chartTitle;
	}

	public String getxAxisTitle() {
		return xAxisTitle;
	}

	public void setxAxisTitle(String xAxisTitle) {
		this.xAxisTitle = xAxisTitle;
	}

	public String getyAxisTitle() {
		return yAxisTitle;
	}

	public void setyAxisTitle(String yAxisTitle) {
		this.yAxisTitle = yAxisTitle;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public List<Series> getSeries() {
		return series;
	}

	public void setSeries(List<Series> series) {
		this.series = series;
	}

	public List<Category> setCategoriesForTI(List<Category> categoryForMonth) {
		categoryForMonth = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			Category category = new Category();
			if (i == 1) {
				category.setAbbreviation("Jan");
				category.setName("January");

			} else if (i == 2) {
				category.setAbbreviation("Feb");
				category.setName("February");
			} else if (i == 3) {
				category.setAbbreviation("Mar");
				category.setName("March");
			} else if (i == 4) {
				category.setAbbreviation("Apr");
				category.setName("April");
			} else if (i == 5) {
				category.setAbbreviation("May");
				category.setName("May");
			} else if (i == 6) {
				category.setAbbreviation("Jun");
				category.setName("June");
			} else if (i == 7) {
				category.setAbbreviation("Jul");
				category.setName("July");
			} else if (i == 8) {
				category.setAbbreviation("Aug");
				category.setName("August");
			} else if (i == 9) {
				category.setAbbreviation("Sep");
				category.setName("September");
			} else if (i == 10) {
				category.setAbbreviation("Oct");
				category.setName("October");
			} else if (i == 11) {
				category.setAbbreviation("Nov");
				category.setName("November");
			} else if (i == 12) {
				category.setAbbreviation("Dec");
				category.setName("December");
			}
			categoryForMonth.add(category);
		}

		return categoryForMonth;

	}

	public List<String> setLabelForTI(List<String> labels) {

		this.labels.add("Jan");
		this.labels.add("Feb");
		this.labels.add("Mar");
		this.labels.add("Apr");
		this.labels.add("May");
		this.labels.add("Jun");
		this.labels.add("Jul");
		this.labels.add("Aug");
		this.labels.add("Sep");
		this.labels.add("Oct");
		this.labels.add("Nov");
		this.labels.add("Dec");

		return this.labels;

	}

	public List<Filters> getFilters() {
		return filters;
	}

	public void setFilters(List<Filters> filters) {
		this.filters = filters;
	}

}
