package gov.naco.soch.ti.dto;

import java.util.Set;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.dto.TiBeneficiaryAddressDto;
import gov.naco.soch.dto.TypologyDto;

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
	private FacilityDTO facility;
	private MiniMasterDto typology;
	private TiBeneficiaryAddressDto hotspotAddress;
	
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
	public FacilityDTO getFacility() {
		return facility;
	}
	public void setFacility(FacilityDTO facility) {
		this.facility = facility;
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
	
	public TiBeneficiaryAddressDto getHotspotAddress() {
		return hotspotAddress;
	}
	public void setHotspotAddress(TiBeneficiaryAddressDto hotspotAddress) {
		this.hotspotAddress = hotspotAddress;
	}
	public MiniMasterDto getTypology() {
		return typology;
	}
	public void setTypology(MiniMasterDto typology) {
		this.typology = typology;
	}
	
	
}
