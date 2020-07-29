package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class PincodeDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;

	private Integer createdBy;

	private Timestamp createdTime;

	private Boolean isActive;

	private Boolean isDelete;

	private Integer modifiedBy;

	private Timestamp modifiedTime;

	private String pincode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "PincodeDTO [id=" + id + ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", isActive="
				+ isActive + ", isDelete=" + isDelete + ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime
				+ ", pincode=" + pincode + "]";
	}
	
}
