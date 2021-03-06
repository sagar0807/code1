package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the emails_sent_user database table.
 * 
 */
@Entity
@Table(name="emails_sent_user")
@NamedQuery(name="EmailsSentUser.findAll", query="SELECT e FROM EmailsSentUser e")
public class EmailsSentUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sent_user_id")
	private Integer sentUserId;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="user_id")
	private Integer userId;

	//bi-directional many-to-one association to EmailsSent
	@ManyToOne
	@JoinColumn(name="sent_id")
	private EmailsSent emailsSent;

	public EmailsSentUser() {
	}

	public Integer getSentUserId() {
		return this.sentUserId;
	}

	public void setSentUserId(Integer sentUserId) {
		this.sentUserId = sentUserId;
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

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public EmailsSent getEmailsSent() {
		return this.emailsSent;
	}

	public void setEmailsSent(EmailsSent emailsSent) {
		this.emailsSent = emailsSent;
	}

}