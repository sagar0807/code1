package gov.naco.soch.shared.dto.ti;

import gov.naco.soch.dto.BaseDto;
import gov.naco.soch.dto.MiniMasterDto;

public class TiOstAssessmentDrugUsageDTO extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long assessmentId;
	private MiniMasterDto drugUsage;
	private Boolean isActive;
	private Boolean isDelete;

	public Long getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(Long assessmentId) {
		this.assessmentId = assessmentId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MiniMasterDto getDrugUsage() {
		return drugUsage;
	}

	public void setDrugUsage(MiniMasterDto drugUsage) {
		this.drugUsage = drugUsage;
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
