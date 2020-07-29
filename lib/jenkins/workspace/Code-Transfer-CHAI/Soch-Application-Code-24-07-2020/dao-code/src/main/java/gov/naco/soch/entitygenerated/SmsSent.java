package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the sms_sent database table.
 * 
 */
@Entity
@Table(name="sms_sent")
@NamedQuery(name="SmsSent.findAll", query="SELECT s FROM SmsSent s")
public class SmsSent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sent_id")
	private Integer sentId;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private String sms;

	//bi-directional many-to-one association to NotificationEvent
	@ManyToOne
	@JoinColumn(name="event_id")
	private NotificationEvent notificationEvent;

	//bi-directional many-to-one association to SmsSentUser
	@OneToMany(mappedBy="smsSent")
	private Set<SmsSentUser> smsSentUsers;

	public SmsSent() {
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

	public String getSms() {
		return this.sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public NotificationEvent getNotificationEvent() {
		return this.notificationEvent;
	}

	public void setNotificationEvent(NotificationEvent notificationEvent) {
		this.notificationEvent = notificationEvent;
	}

	public Set<SmsSentUser> getSmsSentUsers() {
		return this.smsSentUsers;
	}

	public void setSmsSentUsers(Set<SmsSentUser> smsSentUsers) {
		this.smsSentUsers = smsSentUsers;
	}

	public SmsSentUser addSmsSentUser(SmsSentUser smsSentUser) {
		getSmsSentUsers().add(smsSentUser);
		smsSentUser.setSmsSent(this);

		return smsSentUser;
	}

	public SmsSentUser removeSmsSentUser(SmsSentUser smsSentUser) {
		getSmsSentUsers().remove(smsSentUser);
		smsSentUser.setSmsSent(null);

		return smsSentUser;
	}

}