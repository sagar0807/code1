package gov.naco.soch.ti.dto;

import gov.naco.soch.dto.MiniMasterDto;

public class TiBenCounsellingTypeDTO extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private MiniMasterDto masterCounsellingType;
	private String name;
	private Boolean isActive;
	private Boolean isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MiniMasterDto getMasterCounsellingType() {
		return masterCounsellingType;
	}

	public void setMasterCounsellingType(MiniMasterDto masterCounsellingType) {
		this.masterCounsellingType = masterCounsellingType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
