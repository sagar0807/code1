package gov.naco.soch.dto;

import java.io.Serializable;
import java.util.List;

public class ViralLoadPreviousDispatchDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long acceptedSamples;
	private String bdnSerialNumber;
	private String dispatchDate;
	private Long numOfSamples;
	private String receivedDate;
	private Long rejectedSamples;

	private List<ArtSampleCollectionDto> artSampleCollectionDto;

	private Long facilityId;
	private Long dispatchToLabId;
	private Long dispatchToLabFacilityTypeId;
	private Long masterBatchStatusId;
	private Long artcLabTechUserId;
	private Long vlLabTechUserId;
	private String facilityName;
	private String facilityCode;
	private String dispatchToLabName;
	private String dispatchToLabCode;
	private String masterBatchStatusName;
	private String artcLabTechUserName;
	private String artcLabTechUserContact;
	private String vlLabTechUserName;
	private String vlLabTechUserContact;
	private String status;
	private String labAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAcceptedSamples() {
		return acceptedSamples;
	}

	public void setAcceptedSamples(Long acceptedSamples) {
		this.acceptedSamples = acceptedSamples;
	}

	public String getBdnSerialNumber() {
		return bdnSerialNumber;
	}

	public void setBdnSerialNumber(String bdnSerialNumber) {
		this.bdnSerialNumber = bdnSerialNumber;
	}

	public String getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(String dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getNumOfSamples() {
		return numOfSamples;
	}

	public void setNumOfSamples(Long numOfSamples) {
		this.numOfSamples = numOfSamples;
	}

	public String getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}

	public Long getRejectedSamples() {
		return rejectedSamples;
	}

	public void setRejectedSamples(Long rejectedSamples) {
		this.rejectedSamples = rejectedSamples;
	}

	public Long getDispatchToLabId() {
		return dispatchToLabId;
	}

	public void setDispatchToLabId(Long dispatchToLabId) {
		this.dispatchToLabId = dispatchToLabId;
	}

	public Long getDispatchToLabFacilityTypeId() {
		return dispatchToLabFacilityTypeId;
	}

	public void setDispatchToLabFacilityTypeId(Long dispatchToLabFacilityTypeId) {
		this.dispatchToLabFacilityTypeId = dispatchToLabFacilityTypeId;
	}

	public String getDispatchToLabName() {
		return dispatchToLabName;
	}

	public void setDispatchToLabName(String dispatchToLabName) {
		this.dispatchToLabName = dispatchToLabName;
	}

	public List<ArtSampleCollectionDto> getArtSampleCollectionDto() {
		return artSampleCollectionDto;
	}

	public void setArtSampleCollectionDto(List<ArtSampleCollectionDto> artSampleCollectionDto) {
		this.artSampleCollectionDto = artSampleCollectionDto;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public Long getMasterBatchStatusId() {
		return masterBatchStatusId;
	}

	public void setMasterBatchStatusId(Long masterBatchStatusId) {
		this.masterBatchStatusId = masterBatchStatusId;
	}

	public Long getArtcLabTechUserId() {
		return artcLabTechUserId;
	}

	public void setArtcLabTechUserId(Long artcLabTechUserId) {
		this.artcLabTechUserId = artcLabTechUserId;
	}

	public Long getVlLabTechUserId() {
		return vlLabTechUserId;
	}

	public void setVlLabTechUserId(Long vlLabTechUserId) {
		this.vlLabTechUserId = vlLabTechUserId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getMasterBatchStatusName() {
		return masterBatchStatusName;
	}

	public void setMasterBatchStatusName(String masterBatchStatusName) {
		this.masterBatchStatusName = masterBatchStatusName;
	}

	public String getArtcLabTechUserName() {
		return artcLabTechUserName;
	}

	public void setArtcLabTechUserName(String artcLabTechUserName) {
		this.artcLabTechUserName = artcLabTechUserName;
	}

	public String getVlLabTechUserName() {
		return vlLabTechUserName;
	}

	public void setVlLabTechUserName(String vlLabTechUserName) {
		this.vlLabTechUserName = vlLabTechUserName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLabAddress() {
		return labAddress;
	}

	public void setLabAddress(String labAddress) {
		this.labAddress = labAddress;
	}

	public String getFacilityCode() {
		return facilityCode;
	}

	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
	}

	public String getDispatchToLabCode() {
		return dispatchToLabCode;
	}

	public void setDispatchToLabCode(String dispatchToLabCode) {
		this.dispatchToLabCode = dispatchToLabCode;
	}

	public String getArtcLabTechUserContact() {
		return artcLabTechUserContact;
	}

	public void setArtcLabTechUserContact(String artcLabTechUserContact) {
		this.artcLabTechUserContact = artcLabTechUserContact;
	}

	public String getVlLabTechUserContact() {
		return vlLabTechUserContact;
	}

	public void setVlLabTechUserContact(String vlLabTechUserContact) {
		this.vlLabTechUserContact = vlLabTechUserContact;
	}

	@Override
	public String toString() {
		return "ViralLoadPreviousDispatchDto [id=" + id + ", acceptedSamples=" + acceptedSamples + ", bdnSerialNumber="
				+ bdnSerialNumber + ", dispatchDate=" + dispatchDate + ", numOfSamples=" + numOfSamples
				+ ", receivedDate=" + receivedDate + ", rejectedSamples=" + rejectedSamples
				+ ", artSampleCollectionDto=" + artSampleCollectionDto + ", facilityId=" + facilityId
				+ ", dispatchToLabId=" + dispatchToLabId + ", masterBatchStatusId=" + masterBatchStatusId
				+ ", artcLabTechUserId=" + artcLabTechUserId + ", vlLabTechUserId=" + vlLabTechUserId
				+ ", facilityName=" + facilityName + ", facilityCode=" + facilityCode + ", dispatchToLabName="
				+ dispatchToLabName + ", dispatchToLabCode=" + dispatchToLabCode + ", masterBatchStatusName="
				+ masterBatchStatusName + ", artcLabTechUserName=" + artcLabTechUserName + ", artcLabTechUserContact="
				+ artcLabTechUserContact + ", vlLabTechUserName=" + vlLabTechUserName + ", vlLabTechUserContact="
				+ vlLabTechUserContact + ", status=" + status + ", labAddress=" + labAddress + "]";
	}

}
