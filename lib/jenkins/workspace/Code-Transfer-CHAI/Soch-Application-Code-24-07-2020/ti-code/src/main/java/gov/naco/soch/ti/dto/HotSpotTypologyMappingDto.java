package gov.naco.soch.ti.dto;

import java.io.Serializable;

import gov.naco.soch.dto.MiniMasterDto;

public class HotSpotTypologyMappingDto  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long hotspotId;
	private MiniMasterDto masterTypology;
	private Boolean isActive;
	private Boolean isDelete;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getHotspotId() {
		return hotspotId;
	}
	public void setHotspotId(Long hotspotId) {
		this.hotspotId = hotspotId;
	}
	public MiniMasterDto getMasterTypology() {
		return masterTypology;
	}
	public void setMasterTypology(MiniMasterDto masterTypology) {
		this.masterTypology = masterTypology;
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
	
}
