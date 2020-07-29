package gov.naco.soch.dto;

public class TIHotspotDto extends BaseDto {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String hotspotName;
	private String hotspotStatus;
	private String hotspotCode;
	private String status;
	private Boolean isDelete;
	private Boolean isActive;
	private Long facilityId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHotspotName() {
		return hotspotName;
	}
	public void setHotspotName(String hotspotName) {
		this.hotspotName = hotspotName;
	}
	public String getHotspotStatus() {
		return hotspotStatus;
	}
	public void setHotspotStatus(String hotspotStatus) {
		this.hotspotStatus = hotspotStatus;
	}
	public String getHotspotCode() {
		return hotspotCode;
	}
	public void setHotspotCode(String hotspotCode) {
		this.hotspotCode = hotspotCode;
	}
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}
		
	
}
