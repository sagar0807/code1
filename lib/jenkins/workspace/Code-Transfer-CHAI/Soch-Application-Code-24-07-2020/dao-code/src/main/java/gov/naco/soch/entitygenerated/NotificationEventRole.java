package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the notification_event_role database table.
 * 
 */
@Entity
@Table(name="notification_event_role")
@NamedQuery(name="NotificationEventRole.findAll", query="SELECT n FROM NotificationEventRole n")
public class NotificationEventRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="event_role_id")
	private Integer eventRoleId;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	//bi-directional many-to-one association to NotificationEvent
	@ManyToOne
	@JoinColumn(name="event_id")
	private NotificationEvent notificationEvent;

	//bi-directional many-to-one association to Role
	@ManyToOne
	private Role role;

	public NotificationEventRole() {
	}

	public Integer getEventRoleId() {
		return this.eventRoleId;
	}

	public void setEventRoleId(Integer eventRoleId) {
		this.eventRoleId = eventRoleId;
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

	public NotificationEvent getNotificationEvent() {
		return this.notificationEvent;
	}

	public void setNotificationEvent(NotificationEvent notificationEvent) {
		this.notificationEvent = notificationEvent;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}