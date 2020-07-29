package gov.naco.soch.inventory.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.util.StringUtils;

public class CMSSUtils {

	private static DateTimeFormatter DATE_FORMATTOR = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
	
	public static LocalDate getDate(String date) {
		if (!StringUtils.isEmpty(date)) {
			String newDate = date.substring(0, 4).toUpperCase() + date.substring(4).toLowerCase();
			return LocalDate.parse(newDate, DATE_FORMATTOR);
		} else {
			return null;
		}
	}

	public static String getCMSSProductName(String drugName) {

		int index = drugName.indexOf("[");
		if (index != -1) {
			drugName = drugName.substring(0, index - 1);
		}
		return drugName;
	}

	public static String getStoreName(String storeName) {

		int index = storeName.indexOf("-");
		if (index != -1) {
			storeName = storeName.substring(0, index);
		}
		return storeName;
	}

}
