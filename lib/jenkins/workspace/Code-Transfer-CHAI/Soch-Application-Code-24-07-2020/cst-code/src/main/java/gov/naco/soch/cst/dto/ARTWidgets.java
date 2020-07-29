package gov.naco.soch.cst.dto;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Locale;

import gov.naco.soch.dto.Category;

public class ARTWidgets {

	private String type;
	private String chartTitle;
	private String xAxisTitle;
	private String yAxisTitle;
	private String filterName;
	private String filterType;
	private List<String> labels = new ArrayList<>();
	private List<ARTSeries> series = new ArrayList<>();
	private List<ARTFilters> filters = new ArrayList<>();

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

	public List<ARTSeries> getSeries() {
		return series;
	}

	public void setSeries(List<ARTSeries> series) {
		this.series = series;
	}

	public List<ARTFilters> getFilters() {
		return filters;
	}

	public void setFilters(List<ARTFilters> filters) {
		this.filters = filters;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public String getFilterType() {
		return filterType;
	}

	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}

	/*
	 * public void setCategoriesForArt(List<Category> labels, Integer interval) {
	 * 
	 * labels = new ArrayList<>();
	 * 
	 * Integer currentDayOfMonth = LocalDate.now().getDayOfMonth(); Integer
	 * currentMonthValue = LocalDate.now().getMonthValue(); YearMonth yearMonth =
	 * YearMonth.of(LocalDate.now().getYear(), currentMonthValue); Integer
	 * totalDaysInMonth = yearMonth.lengthOfMonth(); YearMonth yearMonth_previous =
	 * YearMonth.of(LocalDate.now().getYear(), currentMonthValue - 1); Integer
	 * totalDaysInPreviousMonth = yearMonth_previous.lengthOfMonth(); Integer
	 * daysLimit = 0; Integer nextMonthDays = 0; if (Integer.signum(interval) > 0) {
	 * if (currentDayOfMonth + interval > totalDaysInMonth) { nextMonthDays =
	 * (currentDayOfMonth + interval) - totalDaysInMonth; daysLimit =
	 * totalDaysInMonth; } else { daysLimit = currentDayOfMonth + interval; } int
	 * index = 0; for (Integer i = currentDayOfMonth; i <= daysLimit; i++) {
	 * Category category = new Category(); String dateField = (i < 10 ? "0" : "") +
	 * i; String monthField = (currentMonthValue < 10 ? "0" : "") +
	 * currentMonthValue; category.setAbbreviation(dateField + "/" + monthField);
	 * labels.add(index, category); index++; } if (nextMonthDays > 0) {
	 * currentMonthValue = currentMonthValue + 1; for (Integer i = 1; i <=
	 * nextMonthDays; i++) { Category category = new Category(); String dateField =
	 * (i < 10 ? "0" : "") + i; String monthField = (currentMonthValue < 10 ? "0" :
	 * "") + currentMonthValue; category.setAbbreviation(dateField + "/" +
	 * monthField); labels.add(index, category); index++; } } } else { if
	 * (currentDayOfMonth + interval < 1) { nextMonthDays = totalDaysInPreviousMonth
	 * - (-currentDayOfMonth - interval); daysLimit = 1; } else { daysLimit =
	 * currentDayOfMonth + interval; } int index = 0; for (Integer i =
	 * currentDayOfMonth; i >= daysLimit; i--) { Category category = new Category();
	 * String dateField = (i < 10 ? "0" : "") + i; String monthField =
	 * (currentMonthValue < 10 ? "0" : "") + currentMonthValue;
	 * category.setAbbreviation(dateField + "/" + monthField); labels.add(index,
	 * category); index++; } if (nextMonthDays > 0) { currentMonthValue =
	 * currentMonthValue - 1; for (Integer i = totalDaysInPreviousMonth; i >=
	 * nextMonthDays; i--) { Category category = new Category(); String dateField =
	 * (i < 10 ? "0" : "") + i; String monthField = (currentMonthValue < 10 ? "0" :
	 * "") + currentMonthValue; category.setAbbreviation(dateField + "/" +
	 * monthField); labels.add(index, category); index++; } } }
	 * 
	 * this.labels.addAll(labels); }
	 */

	public List<Category> setCategoriesForCst(List<Category> categoryForMonth) {
		categoryForMonth = new ArrayList<>();
		LocalDate now = LocalDate.now();
		for (int i = 1; i <= 12; i++) {
			Category category = new Category();
			LocalDate earlier = now.minusMonths(i);
			category.setAbbreviation(earlier.getMonth().getDisplayName(TextStyle.SHORT, Locale.US));
			category.setName(earlier.getMonth().toString());
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

	public List<String> setDefaultLabelsForCst(List<String> labels) {

		LocalDate now1 = LocalDate.now();

		for (int i = 11; i > 0; i--) {
			LocalDate earlier = now1.minusMonths(i);
			this.labels.add(earlier.getMonth().getDisplayName(TextStyle.SHORT, Locale.US));
		}
		this.labels.add(now1.getMonth().getDisplayName(TextStyle.SHORT, Locale.US));
		return this.labels;

	}

	public void setLabelsWithDatesCst(List<String> labels, Long numberOfDays, String dateFrom, String dateTo)
			throws ParseException {

		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		  LocalDate start= LocalDate.parse(dateFrom,formatter);
		  LocalDate end =LocalDate.parse(dateTo,formatter); 
		  while (!start.isAfter(end)) {
			this.labels.add(start.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
			start = start.plusDays(1);
		}

	}

	public void setLabelWithMonthInDuration(ArrayList<String> arrayList, String dateFrom, String dateTo) {
		
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		  LocalDate fromDate= LocalDate.parse(dateFrom,formatter);
		  LocalDate toDate =LocalDate.parse(dateTo,formatter); 
		  Period age = Period.between(fromDate, toDate);
		  int months = age.getMonths();
		  
		  this.labels.add(fromDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.US));
			for (int i = 1; i <= months; i++) {
				LocalDate earlier = fromDate.plusMonths(i);
				this.labels.add(earlier.getMonth().getDisplayName(TextStyle.SHORT, Locale.US));
			}
			
	}
	
	

}
