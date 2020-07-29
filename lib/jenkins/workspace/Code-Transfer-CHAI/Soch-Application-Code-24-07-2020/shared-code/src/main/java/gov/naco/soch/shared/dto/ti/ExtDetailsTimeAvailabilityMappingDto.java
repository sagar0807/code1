package gov.naco.soch.shared.dto.ti;

import java.io.Serializable;

import gov.naco.soch.dto.MiniMasterDto;

public class ExtDetailsTimeAvailabilityMappingDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long tiBeneficiaryExtDetailsId;
	private MiniMasterDto masterBenificiaryTimeAvailability;
	private Boolean isActive;
	private Boolean isDelete;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTiBeneficiaryExtDetailsId() {
		return tiBeneficiaryExtDetailsId;
	}
	public void setTiBeneficiaryExtDetailsId(Long tiBeneficiaryExtDetailsId) {
		this.tiBeneficiaryExtDetailsId = tiBeneficiaryExtDetailsId;
	}
	
	public MiniMasterDto getMasterBenificiaryTimeAvailability() {
		return masterBenificiaryTimeAvailability;
	}
	public void setMasterBenificiaryTimeAvailability(MiniMasterDto masterBenificiaryTimeAvailability) {
		this.masterBenificiaryTimeAvailability = masterBenificiaryTimeAvailability;
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
