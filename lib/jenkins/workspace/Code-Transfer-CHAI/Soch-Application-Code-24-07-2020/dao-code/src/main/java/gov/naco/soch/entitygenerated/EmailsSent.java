package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the emails_sent database table.
 * 
 */
@Entity
@Table(name="emails_sent")
@NamedQuery(name="EmailsSent.findAll", query="SELECT e FROM EmailsSent e")
public class EmailsSent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sent_id")
	private Integer sentId;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="email_body")
	private String emailBody;

	@Column(name="email_subject")
	private String emailSubject;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private String sender;

	//bi-directional many-to-one association to NotificationEvent
	@ManyToOne
	@JoinColumn(name="event_id")
	private NotificationEvent notificationEvent;

	//bi-directional many-to-one association to EmailsSentUser
	@OneToMany(mappedBy="emailsSent")
	private Set<EmailsSentUser> emailsSentUsers;

	public EmailsSent() {
	}

	public Integer getSentId() {
		return this.sentId;
	}

	public void setSentId(Integer sentId) {
		this.sentId = sentId;
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

	public String getEmailBody() {
		return this.emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	public String getEmailSubject() {
		return this.emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
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

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public NotificationEvent getNotificationEvent() {
		return this.notificationEvent;
	}

	public void setNotificationEvent(NotificationEvent notificationEvent) {
		this.notificationEvent = notificationEvent;
	}

	public Set<EmailsSentUser> getEmailsSentUsers() {
		return this.emailsSentUsers;
	}

	public void setEmailsSentUsers(Set<EmailsSentUser> emailsSentUsers) {
		this.emailsSentUsers = emailsSentUsers;
	}

	public EmailsSentUser addEmailsSentUser(EmailsSentUser emailsSentUser) {
		getEmailsSentUsers().add(emailsSentUser);
		emailsSentUser.setEmailsSent(this);

		return emailsSentUser;
	}

	public EmailsSentUser removeEmailsSentUser(EmailsSentUser emailsSentUser) {
		getEmailsSentUsers().remove(emailsSentUser);
		emailsSentUser.setEmailsSent(null);

		return emailsSentUser;
	}

}