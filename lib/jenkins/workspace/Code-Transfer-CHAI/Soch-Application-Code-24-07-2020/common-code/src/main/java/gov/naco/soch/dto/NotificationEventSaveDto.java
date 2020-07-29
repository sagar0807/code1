package gov.naco.soch.dto;

import java.util.HashSet;
import java.util.Set;

public class NotificationEventSaveDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long eventId;
	private String emailSubject;
	private String emailTemplate;
	private String whatsAppTemplate;
	private String smsTemplate;
	private Boolean enable;
	private Set<Long> roleIds = new HashSet<>();

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailTemplate() {
		return emailTemplate;
	}

	public void setEmailTemplate(String emailTemplate) {
		this.emailTemplate = emailTemplate;
	}

	public String getWhatsAppTemplate() {
		return whatsAppTemplate;
	}

	public void setWhatsAppTemplate(String whatsAppTemplate) {
		this.whatsAppTemplate = whatsAppTemplate;
	}

	public String getSmsTemplate() {
		return smsTemplate;
	}

	public void setSmsTemplate(String smsTemplate) {
		this.smsTemplate = smsTemplate;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Set<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Set<Long> roleIds) {
		this.roleIds = roleIds;
	}

}
