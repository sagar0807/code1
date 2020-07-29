package gov.naco.soch.dto;

public class FacilityReconciliationDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long facilityDispatchId;
	private Long facilityReceiptId;
	private Long facilityReceiptBatchId;
	private Long facilityId;
	private String stnNumber;
	private Long consignorId;
	private String consignorName;
	private Long consigneeId;
	private String consigneeName;
	private Long git;
	private String reconciliationStatus;
	private String remarks;
	private boolean lostInTransit;

	public String getStnNumber() {
		return stnNumber;
	}

	public Long getConsignorId() {
		return consignorId;
	}

	public String getConsignorName() {
		return consignorName;
	}

	public Long getConsigneeId() {
		return consigneeId;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public Long getGit() {
		return git;
	}

	public String getReconciliationStatus() {
		return reconciliationStatus;
	}

	public void setStnNumber(String stnNumber) {
		this.stnNumber = stnNumber;
	}

	public void setConsignorId(Long consignorId) {
		this.consignorId = consignorId;
	}

	public void setConsignorName(String consignorName) {
		this.consignorName = consignorName;
	}

	public void setConsigneeId(Long consigneeId) {
		this.consigneeId = consigneeId;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public void setGit(Long git) {
		this.git = git;
	}

	public void setReconciliationStatus(String reconciliationStatus) {
		this.reconciliationStatus = reconciliationStatus;
	}

	public Long getFacilityReceiptId() {
		return facilityReceiptId;
	}

	public void setFacilityReceiptId(Long facilityReceiptId) {
		this.facilityReceiptId = facilityReceiptId;
	}

	public Long getFacilityDispatchId() {
		return facilityDispatchId;
	}

	public Long getFacilityReceiptBatchId() {
		return facilityReceiptBatchId;
	}

	public void setFacilityReceiptBatchId(Long facilityReceiptBatchId) {
		this.facilityReceiptBatchId = facilityReceiptBatchId;
	}

	public void setFacilityDispatchId(Long facilityDispatchId) {
		this.facilityDispatchId = facilityDispatchId;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public boolean isLostInTransit() {
		return lostInTransit;
	}

	public void setLostInTransit(boolean lostInTransit) {
		this.lostInTransit = lostInTransit;
	}


}
