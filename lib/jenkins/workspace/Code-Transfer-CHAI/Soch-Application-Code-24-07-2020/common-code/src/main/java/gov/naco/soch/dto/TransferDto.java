package gov.naco.soch.dto;

import java.time.LocalDate;

public class TransferDto extends BaseDto{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String category;
	
	private String destinationFacilityType;

	private String dsrcCode;

	private String hivStatus;

	private LocalDate initiationDate;

	private Boolean isActive;

	private Boolean isDeleted;

	private String ostCode;

	private String pidCode;

	private String remarks;

	private LocalDate reportingDate;

	private String sourceFacilityType;

	private String tiCode;
	
	private String transferStatus;
	
	private Long beneficiaryId;

	private Long destinationFacilityId;

	private Long sourceFacilityId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDestinationFacilityType() {
		return destinationFacilityType;
	}

	public void setDestinationFacilityType(String destinationFacilityType) {
		this.destinationFacilityType = destinationFacilityType;
	}

	public String getDsrcCode() {
		return dsrcCode;
	}

	public void setDsrcCode(String dsrcCode) {
		this.dsrcCode = dsrcCode;
	}

	public String getHivStatus() {
		return hivStatus;
	}

	public void setHivStatus(String hivStatus) {
		this.hivStatus = hivStatus;
	}

	public LocalDate getInitiationDate() {
		return initiationDate;
	}

	public void setInitiationDate(LocalDate initiationDate) {
		this.initiationDate = initiationDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getOstCode() {
		return ostCode;
	}

	public void setOstCode(String ostCode) {
		this.ostCode = ostCode;
	}

	public String getPidCode() {
		return pidCode;
	}

	public void setPidCode(String pidCode) {
		this.pidCode = pidCode;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDate getReportingDate() {
		return reportingDate;
	}

	public void setReportingDate(LocalDate reportingDate) {
		this.reportingDate = reportingDate;
	}

	public String getSourceFacilityType() {
		return sourceFacilityType;
	}

	public void setSourceFacilityType(String sourceFacilityType) {
		this.sourceFacilityType = sourceFacilityType;
	}

	public String getTiCode() {
		return tiCode;
	}

	public void setTiCode(String tiCode) {
		this.tiCode = tiCode;
	}

	public String getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(String transferStatus) {
		this.transferStatus = transferStatus;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Long getDestinationFacilityId() {
		return destinationFacilityId;
	}

	public void setDestinationFacilityId(Long destinationFacilityId) {
		this.destinationFacilityId = destinationFacilityId;
	}

	public Long getSourceFacilityId() {
		return sourceFacilityId;
	}

	public void setSourceFacilityId(Long sourceFacilityId) {
		this.sourceFacilityId = sourceFacilityId;
	}
	
	

}
