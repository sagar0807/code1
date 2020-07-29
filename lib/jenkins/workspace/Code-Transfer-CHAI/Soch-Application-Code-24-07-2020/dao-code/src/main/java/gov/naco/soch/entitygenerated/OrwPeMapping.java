package gov.naco.soch.entitygenerated;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the orw_pe_mapping database table.
 * 
 */
@Entity
@Table(name="orw_pe_mapping")
@NamedQuery(name="OrwPeMapping.findAll", query="SELECT o FROM OrwPeMapping o")
public class OrwPeMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="orw_user_id")
	private UserMaster userMaster1;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name="pe_user_id")
	private UserMaster userMaster2;

	public OrwPeMapping() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
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

	public UserMaster getUserMaster1() {
		return this.userMaster1;
	}

	public void setUserMaster1(UserMaster userMaster1) {
		this.userMaster1 = userMaster1;
	}

	public UserMaster getUserMaster2() {
		return this.userMaster2;
	}

	public void setUserMaster2(UserMaster userMaster2) {
		this.userMaster2 = userMaster2;
	}

}