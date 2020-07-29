package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the notification_event_placeholder database table.
 * 
 */
@Entity
@Table(name="notification_event_placeholder")
@NamedQuery(name="NotificationEventPlaceholder.findAll", query="SELECT n FROM NotificationEventPlaceholder n")
public class NotificationEventPlaceholder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="placeholder_id")
	private Integer placeholderId;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	private String description;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private String placeholder;

	//bi-directional many-to-one association to NotificationEvent
	@ManyToOne
	@JoinColumn(name="event_id")
	private NotificationEvent notificationEvent;

	public NotificationEventPlaceholder() {
	}

	public Integer getPlaceholderId() {
		return this.placeholderId;
	}

	public void setPlaceholderId(Integer placeholderId) {
		this.placeholderId = placeholderId;
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

	public String getPlaceholder() {
		return this.placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public NotificationEvent getNotificationEvent() {
		return this.notificationEvent;
	}

	public void setNotificationEvent(NotificationEvent notificationEvent) {
		this.notificationEvent = notificationEvent;
	}

}