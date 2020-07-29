package gov.naco.soch.dto;

import java.io.Serializable;


/**
* @author Vidhya A V (145144)
* @email vidhya.AV@ust-global.com
* @date 2020-Dec-30 4:17:45 PM 
 * 
*/

//DTO class used for transfer data between front end and back end.
public class NotificationEventDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String eventName;
	private String eventType;
	private String eventController;
	private String notificationType;
	private String module;
	private String eventGeneratedBy;
	private String emailDigestAllowed;
	private boolean isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventController() {
		return eventController;
	}

	public void setEventController(String eventController) {
		this.eventController = eventController;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getEventGeneratedBy() {
		return eventGeneratedBy;
	}

	public void setEventGeneratedBy(String eventGeneratedBy) {
		this.eventGeneratedBy = eventGeneratedBy;
	}

	public String getEmailDigestAllowed() {
		return emailDigestAllowed;
	}

	public void setEmailDigestAllowed(String emailDigestAllowed) {
		this.emailDigestAllowed = emailDigestAllowed;
	}

	public boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
