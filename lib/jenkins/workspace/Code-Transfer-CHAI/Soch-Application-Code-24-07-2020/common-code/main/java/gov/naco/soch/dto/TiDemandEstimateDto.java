package gov.naco.soch.dto;

public class TiDemandEstimateDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long weeklyNeedlesRequirement;
	private Long weeklyCondomsRequirement;

	public Long getWeeklyNeedlesRequirement() {
		return weeklyNeedlesRequirement;
	}

	public void setWeeklyNeedlesRequirement(Long weeklyNeedlesRequirement) {
		this.weeklyNeedlesRequirement = weeklyNeedlesRequirement;
	}

	public Long getWeeklyCondomsRequirement() {
		return weeklyCondomsRequirement;
	}

	public void setWeeklyCondomsRequirement(Long weeklyCondomsRequirement) {
		this.weeklyCondomsRequirement = weeklyCondomsRequirement;
	}

}
