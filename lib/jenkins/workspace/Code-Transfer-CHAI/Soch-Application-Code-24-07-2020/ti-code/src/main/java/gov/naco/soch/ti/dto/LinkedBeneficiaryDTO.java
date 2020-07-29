package gov.naco.soch.ti.dto;

import java.time.LocalDate;

public class LinkedBeneficiaryDTO extends BaseDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long id;

	private Boolean isLinked;

	private LocalDate linkDate;

	private LocalDate unlinkDate;

	private Boolean isActive;

	private Boolean isDelete;

	private Long ostBeneficiaryId;

	private Long parentFacilityId;
    
	private Long linkedFacilityId;

	private Long facilityTypeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsLinked() {
		return isLinked;
	}

	public void setIsLinked(Boolean isLinked) {
		this.isLinked = isLinked;
	}

	public LocalDate getLinkDate() {
		return linkDate;
	}

	public void setLinkDate(LocalDate linkDate) {
		this.linkDate = linkDate;
	}

	public LocalDate getUnlinkDate() {
		return unlinkDate;
	}

	public void setUnlinkDate(LocalDate unlinkDate) {
		this.unlinkDate = unlinkDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Long getOstBeneficiaryId() {
		return ostBeneficiaryId;
	}

	public void setOstBeneficiaryId(Long ostBeneficiaryId) {
		this.ostBeneficiaryId = ostBeneficiaryId;
	}

	public Long getParentFacilityId() {
		return parentFacilityId;
	}

	public void setParentFacilityId(Long parentFacilityId) {
		this.parentFacilityId = parentFacilityId;
	}

	public Long getLinkedFacilityId() {
		return linkedFacilityId;
	}

	public void setLinkedFacilityId(Long linkedFacilityId) {
		this.linkedFacilityId = linkedFacilityId;
	}

	public Long getFacilityTypeId() {
		return facilityTypeId;
	}

	public void setFacilityTypeId(Long facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}
	
	
	

}
