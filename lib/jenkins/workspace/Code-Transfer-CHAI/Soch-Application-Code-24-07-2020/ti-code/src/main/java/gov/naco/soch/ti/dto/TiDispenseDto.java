package gov.naco.soch.ti.dto;

import java.time.LocalDate;
import java.util.List;

import gov.naco.soch.dto.BaseDto;

public class TiDispenseDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private Long benficiaryId;
	private List<Long> productIds;
	private LocalDate nextFollowUpDate;
	private Boolean hivTestingDue;
	private String clientStatus;

	public Long getBenficiaryId() {
		return benficiaryId;
	}

	public void setBenficiaryId(Long benficiaryId) {
		this.benficiaryId = benficiaryId;
	}

	public List<Long> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}

	public LocalDate getNextFollowUpDate() {
		return nextFollowUpDate;
	}

	public void setNextFollowUpDate(LocalDate nextFollowUpDate) {
		this.nextFollowUpDate = nextFollowUpDate;
	}

	public Boolean getHivTestingDue() {
		return hivTestingDue;
	}

	public void setHivTestingDue(Boolean hivTestingDue) {
		this.hivTestingDue = hivTestingDue;
	}

	public String getClientStatus() {
		return clientStatus;
	}

	public void setClientStatus(String clientStatus) {
		this.clientStatus = clientStatus;
	}

	@Override
	public String toString() {
		return "TiDispenseDto [benficiaryId=" + benficiaryId + ", productIds=" + productIds + ", nextFollowUpDate="
				+ nextFollowUpDate + ", hivTestingDue=" + hivTestingDue + ", clientStatus=" + clientStatus + "]";
	}

	

}
