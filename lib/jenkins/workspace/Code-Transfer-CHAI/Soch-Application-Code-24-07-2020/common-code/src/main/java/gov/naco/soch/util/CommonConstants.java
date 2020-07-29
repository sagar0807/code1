/**
 * 
 */
package gov.naco.soch.util;

/**
 * @date 2020-Jan-06 4:35:26 PM
 */

public class CommonConstants {

	public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
	public static final String VALIDATION_FAILED = "Validation Failed";
	public static final String FORBIDDEN = "You dont have permission to access this URL";
	public static final String BAD_CREDENTIALS = "Invalid username or password";

	public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 24 * 60 * 60;
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";

	public static final String ACTIVE = "Active";
	public static final String INACTIVE = "Inactive";
	public static final String TIMEZONE_UTC = "Etc/UTC";
	public static final String TIMEZONE_IST = "Asia/Kolkata";

	public static final String MENU_ACCESS_CODE_ART_BENEFICIARIES = "ART-BENEFICIARIES";
	public static final String NOTIFICATION_TO_SPECIFIC_EMAILS_PLACEHOLDER = "to_emails_specific";
	public static final String NOTIFICATION_SPECIFIC_RECIPIENT_NAME_PLACEHOLDER = "recipient_specific";
	
	public static final String PROPERTY_PROFILE = "spring.profiles.active";
	public static final String PROPERTY_ACCESS_KEY = "accessKey";
}
