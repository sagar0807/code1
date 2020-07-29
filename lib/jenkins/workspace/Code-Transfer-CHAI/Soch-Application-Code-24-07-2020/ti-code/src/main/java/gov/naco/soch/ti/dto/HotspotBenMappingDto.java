package gov.naco.soch.ti.dto;

import java.io.Serializable;

public class HotspotBenMappingDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Long tiBeneficiaryId;
	
	private Long tiOstBeneficiaryId;
	
	private Long hotspotId;
	
	private Boolean isActive;
	
	private Boolean isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTiBeneficiaryId() {
		return tiBeneficiaryId;
	}

	public void setTiBeneficiaryId(Long tiBeneficiaryId) {
		this.tiBeneficiaryId = tiBeneficiaryId;
	}

	public Long getTiOstBeneficiaryId() {
		return tiOstBeneficiaryId;
	}

	public void setTiOstBeneficiaryId(Long tiOstBeneficiaryId) {
		this.tiOstBeneficiaryId = tiOstBeneficiaryId;
	}

	public Long getHotspotId() {
		return hotspotId;
	}

	public void setHotspotId(Long hotspotId) {
		this.hotspotId = hotspotId;
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
