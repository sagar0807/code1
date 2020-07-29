/**
 * 
 */
package gov.naco.soch.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * It contains all date related functions.
 */
public class DateUtil {

	private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

	/**
	 * This method gives current UTC time in LocalDateTime type. Example :
	 * 2020-01-14T10:17:53.062
	 * 
	 * @return LocalDateTime
	 */
	public static LocalDateTime getCurrentUTCDateTime() {
		LocalDateTime currentTimeUTC = LocalDateTime.now(ZoneOffset.UTC);
		return currentTimeUTC;
	}

	/**
	 * This method gives current UTC time in LocalDateTime type. Example :
	 * 2020-01-14T10:17:53.062
	 * 
	 * @return LocalDateTime
	 */
	public static LocalDate getTodayDateInIST() {
		LocalDate todayDateInIST = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		return todayDateInIST;
	}

}
