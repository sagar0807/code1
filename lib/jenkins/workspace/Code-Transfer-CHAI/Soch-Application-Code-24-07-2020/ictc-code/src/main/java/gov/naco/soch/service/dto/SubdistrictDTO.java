package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class SubdistrictDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long subdistrictId;

	private Integer createdBy;

	private Timestamp createdTime;

	private Boolean isActive;

	private Boolean isDelete;

	private Integer modifiedBy;

	private Timestamp modifiedTime;

	private String subdistrictName;

	private Long districtId;

	public Long getSubdistrictId() {
		return subdistrictId;
	}

	public void setSubdistrictId(Long subdistrictId) {
		this.subdistrictId = subdistrictId;
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

	public String getSubdistrictName() {
		return subdistrictName;
	}

	public void setSubdistrictName(String subdistrictName) {
		this.subdistrictName = subdistrictName;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	@Override
	public String toString() {
		return "SubdistrictDTO [subdistrictId=" + subdistrictId + ", createdBy=" + createdBy + ", createdTime="
				+ createdTime + ", isActive=" + isActive + ", isDelete=" + isDelete + ", modifiedBy=" + modifiedBy
				+ ", modifiedTime=" + modifiedTime + ", subdistrictName=" + subdistrictName + ", districtId="
				+ districtId + "]";
	}
	
}
