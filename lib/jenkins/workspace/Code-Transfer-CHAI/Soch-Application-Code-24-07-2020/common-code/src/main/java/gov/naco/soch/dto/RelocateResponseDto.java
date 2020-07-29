package gov.naco.soch.dto;

import java.time.LocalDate;

public class RelocateResponseDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private String stnNumber;
	private String productName;
	private String consignee;
	private LocalDate dispatchDate;
	private Long requestedQuantity;
	private String dispatchStatus;
	private String requestStatus;

	public String getStnNumber() {
		return stnNumber;
	}

	public void setStnNumber(String stnNumber) {
		this.stnNumber = stnNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public LocalDate getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(LocalDate dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public Long getRequestedQuantity() {
		return requestedQuantity;
	}

	public void setRequestedQuantity(Long requestedQuantity) {
		this.requestedQuantity = requestedQuantity;
	}

	public String getDispatchStatus() {
		return dispatchStatus;
	}

	public void setDispatchStatus(String dispatchStatus) {
		this.dispatchStatus = dispatchStatus;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

}
