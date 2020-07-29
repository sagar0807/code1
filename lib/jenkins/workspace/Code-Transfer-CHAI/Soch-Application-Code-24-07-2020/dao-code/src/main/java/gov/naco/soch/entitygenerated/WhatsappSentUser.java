package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the whatsapp_sent_user database table.
 * 
 */
@Entity
@Table(name="whatsapp_sent_user")
@NamedQuery(name="WhatsappSentUser.findAll", query="SELECT w FROM WhatsappSentUser w")
public class WhatsappSentUser implements Serializable {
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

	//bi-directional many-to-one association to WhatsappSent
	@ManyToOne
	@JoinColumn(name="sent_id")
	private WhatsappSent whatsappSent;

	public WhatsappSentUser() {
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

	public WhatsappSent getWhatsappSent() {
		return this.whatsappSent;
	}

	public void setWhatsappSent(WhatsappSent whatsappSent) {
		this.whatsappSent = whatsappSent;
	}

}