package gov.naco.soch.dto;

import java.time.LocalDateTime;
import java.util.List;

public class AcceptConsignmentDto extends BaseDto{
	
	private static final long serialVersionUID = 1L;
	
	private Long dispatchId;
	private Integer receiptId;
	private String remarks;
	private LocalDateTime date;
	private Long userId;
	private String userName;
	private Long facilityId;
	private List<ConsignmentBatchDto> consignmentBatches;
	public Long getDispatchId() {
		return dispatchId;
	}
	public void setDispatchId(Long dispatchId) {
		this.dispatchId = dispatchId;
	}
	public Integer getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(Integer receiptId) {
		this.receiptId = receiptId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public List<ConsignmentBatchDto> getConsignmentBatches() {
		return consignmentBatches;
	}
	
	
	public Long getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}
	public void setConsignmentBatches(List<ConsignmentBatchDto> consignmentBatches) {
		this.consignmentBatches = consignmentBatches;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
