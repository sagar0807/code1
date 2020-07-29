package gov.naco.soch.dto;

import java.time.LocalDate;

public class ReconcileResponseDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private String stnNumber;
	private String consigner;
	private String batchNumber;
	private String productName;
	private String consignee;
	private LocalDate dispatchDate;
	private Long gitQty;
	private Long dispatchedQty;
	private String status;

	public String getStnNumber() {
		return stnNumber;
	}

	public void setStnNumber(String stnNumber) {
		this.stnNumber = stnNumber;
	}

	public String getConsigner() {
		return consigner;
	}

	public void setConsigner(String consigner) {
		this.consigner = consigner;
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

	public Long getGitQty() {
		return gitQty;
	}

	public void setGitQty(Long gitQty) {
		this.gitQty = gitQty;
	}

	public Long getDispatchedQty() {
		return dispatchedQty;
	}

	public void setDispatchedQty(Long dispatchedQty) {
		this.dispatchedQty = dispatchedQty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

}
