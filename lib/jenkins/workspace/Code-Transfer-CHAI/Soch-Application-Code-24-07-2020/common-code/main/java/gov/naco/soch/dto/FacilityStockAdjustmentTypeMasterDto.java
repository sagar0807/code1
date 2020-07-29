package gov.naco.soch.dto;

import java.util.List;

public class FacilityStockAdjustmentTypeMasterDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long typeId;
	private String type;
	private List<FacilityStockAdjustmentTypeReasonsDto> reasons;

	public Long getTypeId() {
		return typeId;
	}

	public String getType() {
		return type;
	}

	public List<FacilityStockAdjustmentTypeReasonsDto> getReasons() {
		return reasons;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setReasons(List<FacilityStockAdjustmentTypeReasonsDto> reasons) {
		this.reasons = reasons;
	}

}
