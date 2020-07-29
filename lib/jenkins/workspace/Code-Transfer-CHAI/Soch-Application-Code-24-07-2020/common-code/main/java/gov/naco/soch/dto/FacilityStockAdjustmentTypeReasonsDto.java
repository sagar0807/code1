package gov.naco.soch.dto;

public class FacilityStockAdjustmentTypeReasonsDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long reasonId;
	private String reasonCode;

	public Long getReasonId() {
		return reasonId;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonId(Long reasonId) {
		this.reasonId = reasonId;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	@Override
	public String toString() {
		return "FacilityStockAdjustmentTypeReasonsDto [reasonId=" + reasonId + ", reasonCode=" + reasonCode + "]";
	}

}
