package gov.naco.soch.dto;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class DashBoardGraphDto {

	private List<Category> categories = new ArrayList<>();
	private List<Series> series = new ArrayList<>();

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategoriesForArt(List<Category> categories, Integer interval) {
			
		categories = new ArrayList<>();

		Integer currentDayOfMonth = LocalDate.now().getDayOfMonth();
		Integer currentMonthValue = LocalDate.now().getMonthValue();
		YearMonth yearMonth = YearMonth.of(LocalDate.now().getYear(), currentMonthValue);
		Integer totalDaysInMonth = yearMonth.lengthOfMonth();
		YearMonth yearMonth_previous = YearMonth.of(LocalDate.now().getYear(), currentMonthValue-1);
		Integer totalDaysInPreviousMonth = yearMonth_previous.lengthOfMonth();
		Integer daysLimit = 0;
		Integer nextMonthDays=0;
		if(Integer.signum(interval)>0)
		{
			if (currentDayOfMonth + interval > totalDaysInMonth) {
				nextMonthDays = (currentDayOfMonth + interval) - totalDaysInMonth;
				daysLimit=totalDaysInMonth;
			}
			else
			{
				daysLimit=currentDayOfMonth + interval;
			}
			int index=0;
			for (Integer i = currentDayOfMonth; i <= daysLimit; i++) {
				Category category = new Category();
				String dateField = (i < 10 ? "0" : "") + i;
				String monthField = (currentMonthValue < 10 ? "0" : "") + currentMonthValue;
				category.setAbbreviation(dateField + "/" + monthField);
				categories.add(index,category);
				index++;
			}
			if (nextMonthDays > 0) {
				currentMonthValue = currentMonthValue + 1;
				for (Integer i = 1; i <= nextMonthDays; i++) {
					Category category = new Category();
					String dateField = (i < 10 ? "0" : "") + i;
					String monthField = (currentMonthValue < 10 ? "0" : "") + currentMonthValue;
					category.setAbbreviation(dateField + "/" + monthField);
					categories.add(index,category);
					index++;
				}
			}
		}
		else
		{
			if (currentDayOfMonth + interval < 1) {
				nextMonthDays = totalDaysInPreviousMonth-(-currentDayOfMonth-interval);
				daysLimit=1;
			}
			else
			{
				daysLimit=currentDayOfMonth + interval;
			}
			int index=0;
			for (Integer i = currentDayOfMonth; i >= daysLimit; i--) {
				Category category = new Category();
				String dateField = (i < 10 ? "0" : "") + i;
				String monthField = (currentMonthValue < 10 ? "0" : "") + currentMonthValue;
				category.setAbbreviation(dateField + "/" + monthField);
				categories.add(index,category);
				index++;
			}
			if (nextMonthDays > 0) {
				currentMonthValue = currentMonthValue-1;
				for (Integer i = totalDaysInPreviousMonth;i>=nextMonthDays;i--) {
					Category category = new Category();
					String dateField = (i < 10 ? "0" : "") + i;
					String monthField = (currentMonthValue < 10 ? "0" : "") + currentMonthValue;
					category.setAbbreviation(dateField + "/" + monthField);
					categories.add(index,category);
					index++;
				}
			}
		}
			
	
		this.categories.addAll(categories);
	}

	public void setCategoriesForTI(List<Category> categories) {
		categories = new ArrayList<>();
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
			categories.add(category);
		}

		this.categories.addAll(categories);

	}

	public List<Series> getSeries() {
		return series;
	}

	public void setSeries(List<Series> series) {
		this.series = series;
	}

}
