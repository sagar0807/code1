package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the whatsapp_sent database table.
 * 
 */
@Entity
@Table(name="whatsapp_sent")
@NamedQuery(name="WhatsappSent.findAll", query="SELECT w FROM WhatsappSent w")
public class WhatsappSent implements Serializable {
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

	//bi-directional many-to-one association to WhatsappSentUser
	@OneToMany(mappedBy="whatsappSent")
	private Set<WhatsappSentUser> whatsappSentUsers;

	public WhatsappSent() {
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

	public Set<WhatsappSentUser> getWhatsappSentUsers() {
		return this.whatsappSentUsers;
	}

	public void setWhatsappSentUsers(Set<WhatsappSentUser> whatsappSentUsers) {
		this.whatsappSentUsers = whatsappSentUsers;
	}

	public WhatsappSentUser addWhatsappSentUser(WhatsappSentUser whatsappSentUser) {
		getWhatsappSentUsers().add(whatsappSentUser);
		whatsappSentUser.setWhatsappSent(this);

		return whatsappSentUser;
	}

	public WhatsappSentUser removeWhatsappSentUser(WhatsappSentUser whatsappSentUser) {
		getWhatsappSentUsers().remove(whatsappSentUser);
		whatsappSentUser.setWhatsappSent(null);

		return whatsappSentUser;
	}

}