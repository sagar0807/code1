package gov.naco.soch.ti.dto;
import gov.naco.soch.dto.MiniMasterDto;

public class TiOstFollowUpSideEffectDTO extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long followUpId;
	private MiniMasterDto sideEffect;
	private Boolean isActive;
	private Boolean isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MiniMasterDto getSideEffect() {
		return sideEffect;
	}

	public void setSideEffect(MiniMasterDto sideEffect) {
		this.sideEffect = sideEffect;
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

	public Long getFollowUpId() {
		return followUpId;
	}

	public void setFollowUpId(Long followUpId) {
		this.followUpId = followUpId;
	}

}
