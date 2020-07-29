package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class TownDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long townId;

	private Integer createdBy;

	private Timestamp createdTime;

	private Boolean isActive;

	private Boolean isDelete;

	private Integer modifiedBy;

	private Timestamp modifiedTime;

	private String townName;

	private Long subdistrictId;

	public Long getTownId() {
		return townId;
	}

	public void setTownId(Long townId) {
		this.townId = townId;
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

	public String getTownName() {
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public Long getSubdistrictId() {
		return subdistrictId;
	}

	public void setSubdistrictId(Long subdistrictId) {
		this.subdistrictId = subdistrictId;
	}

	@Override
	public String toString() {
		return "TownDTO [townId=" + townId + ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", isActive="
				+ isActive + ", isDelete=" + isDelete + ", modifiedBy=" + modifiedBy + ", modifiedTime=" + modifiedTime
				+ ", townName=" + townName + ", subdistrictId=" + subdistrictId + "]";
	}
	
}
