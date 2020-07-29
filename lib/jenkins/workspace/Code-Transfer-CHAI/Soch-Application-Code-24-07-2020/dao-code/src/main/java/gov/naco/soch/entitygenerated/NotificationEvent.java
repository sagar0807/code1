package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the notification_event database table.
 * 
 */
@Entity
@Table(name="notification_event")
@NamedQuery(name="NotificationEvent.findAll", query="SELECT n FROM NotificationEvent n")
public class NotificationEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="event_id")
	private Integer eventId;

	private String code;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	private String description;

	@Column(name="email_subject")
	private String emailSubject;

	@Column(name="email_template")
	private String emailTemplate;

	@Column(name="is_enabled")
	private Boolean isEnabled;

	@Column(name="is_specific")
	private Boolean isSpecific;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private String module;

	private String name;

	private String sender;

	@Column(name="sms_template")
	private String smsTemplate;

	@Column(name="whatsapp_template")
	private String whatsappTemplate;

	//bi-directional many-to-one association to EmailsSent
	@OneToMany(mappedBy="notificationEvent")
	private Set<EmailsSent> emailsSents;

	//bi-directional many-to-one association to NotificationEventPlaceholder
	@OneToMany(mappedBy="notificationEvent")
	private Set<NotificationEventPlaceholder> notificationEventPlaceholders;

	//bi-directional many-to-one association to NotificationEventRole
	@OneToMany(mappedBy="notificationEvent")
	private Set<NotificationEventRole> notificationEventRoles;

	//bi-directional many-to-one association to SmsSent
	@OneToMany(mappedBy="notificationEvent")
	private Set<SmsSent> smsSents;

	//bi-directional many-to-one association to WhatsappSent
	@OneToMany(mappedBy="notificationEvent")
	private Set<WhatsappSent> whatsappSents;

	public NotificationEvent() {
	}

	public Integer getEventId() {
		return this.eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmailSubject() {
		return this.emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailTemplate() {
		return this.emailTemplate;
	}

	public void setEmailTemplate(String emailTemplate) {
		this.emailTemplate = emailTemplate;
	}

	public Boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Boolean getIsSpecific() {
		return this.isSpecific;
	}

	public void setIsSpecific(Boolean isSpecific) {
		this.isSpecific = isSpecific;
	}

	public Integer getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSmsTemplate() {
		return this.smsTemplate;
	}

	public void setSmsTemplate(String smsTemplate) {
		this.smsTemplate = smsTemplate;
	}

	public String getWhatsappTemplate() {
		return this.whatsappTemplate;
	}

	public void setWhatsappTemplate(String whatsappTemplate) {
		this.whatsappTemplate = whatsappTemplate;
	}

	public Set<EmailsSent> getEmailsSents() {
		return this.emailsSents;
	}

	public void setEmailsSents(Set<EmailsSent> emailsSents) {
		this.emailsSents = emailsSents;
	}

	public EmailsSent addEmailsSent(EmailsSent emailsSent) {
		getEmailsSents().add(emailsSent);
		emailsSent.setNotificationEvent(this);

		return emailsSent;
	}

	public EmailsSent removeEmailsSent(EmailsSent emailsSent) {
		getEmailsSents().remove(emailsSent);
		emailsSent.setNotificationEvent(null);

		return emailsSent;
	}

	public Set<NotificationEventPlaceholder> getNotificationEventPlaceholders() {
		return this.notificationEventPlaceholders;
	}

	public void setNotificationEventPlaceholders(Set<NotificationEventPlaceholder> notificationEventPlaceholders) {
		this.notificationEventPlaceholders = notificationEventPlaceholders;
	}

	public NotificationEventPlaceholder addNotificationEventPlaceholder(NotificationEventPlaceholder notificationEventPlaceholder) {
		getNotificationEventPlaceholders().add(notificationEventPlaceholder);
		notificationEventPlaceholder.setNotificationEvent(this);

		return notificationEventPlaceholder;
	}

	public NotificationEventPlaceholder removeNotificationEventPlaceholder(NotificationEventPlaceholder notificationEventPlaceholder) {
		getNotificationEventPlaceholders().remove(notificationEventPlaceholder);
		notificationEventPlaceholder.setNotificationEvent(null);

		return notificationEventPlaceholder;
	}

	public Set<NotificationEventRole> getNotificationEventRoles() {
		return this.notificationEventRoles;
	}

	public void setNotificationEventRoles(Set<NotificationEventRole> notificationEventRoles) {
		this.notificationEventRoles = notificationEventRoles;
	}

	public NotificationEventRole addNotificationEventRole(NotificationEventRole notificationEventRole) {
		getNotificationEventRoles().add(notificationEventRole);
		notificationEventRole.setNotificationEvent(this);

		return notificationEventRole;
	}

	public NotificationEventRole removeNotificationEventRole(NotificationEventRole notificationEventRole) {
		getNotificationEventRoles().remove(notificationEventRole);
		notificationEventRole.setNotificationEvent(null);

		return notificationEventRole;
	}

	public Set<SmsSent> getSmsSents() {
		return this.smsSents;
	}

	public void setSmsSents(Set<SmsSent> smsSents) {
		this.smsSents = smsSents;
	}

	public SmsSent addSmsSent(SmsSent smsSent) {
		getSmsSents().add(smsSent);
		smsSent.setNotificationEvent(this);

		return smsSent;
	}

	public SmsSent removeSmsSent(SmsSent smsSent) {
		getSmsSents().remove(smsSent);
		smsSent.setNotificationEvent(null);

		return smsSent;
	}

	public Set<WhatsappSent> getWhatsappSents() {
		return this.whatsappSents;
	}

	public void setWhatsappSents(Set<WhatsappSent> whatsappSents) {
		this.whatsappSents = whatsappSents;
	}

	public WhatsappSent addWhatsappSent(WhatsappSent whatsappSent) {
		getWhatsappSents().add(whatsappSent);
		whatsappSent.setNotificationEvent(this);

		return whatsappSent;
	}

	public WhatsappSent removeWhatsappSent(WhatsappSent whatsappSent) {
		getWhatsappSents().remove(whatsappSent);
		whatsappSent.setNotificationEvent(null);

		return whatsappSent;
	}

}