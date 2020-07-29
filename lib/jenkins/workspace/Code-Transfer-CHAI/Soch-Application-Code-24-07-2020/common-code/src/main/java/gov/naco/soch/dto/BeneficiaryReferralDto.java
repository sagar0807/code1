package gov.naco.soch.dto;

import java.time.LocalDate;

public class BeneficiaryReferralDto extends BaseDto{

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long beneficiaryId;
	private LocalDate dateOfVisit;	
	private LocalDate referDate;	
	private Long referredFromFacility;	
	private Long referredToFacility;	
	private String referredFromFacilityName;
	private String referredToFacilityName;
	private String status;
	private String referralType;
	private String referralReason;
	private Integer facilityType;
	private Long facilityFromType;
	private Boolean isDelete;
	private Boolean isActive;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBeneficiaryId() {
		return beneficiaryId;
	}
	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	public LocalDate getDateOfVisit() {
		return dateOfVisit;
	}
	public void setDateOfVisit(LocalDate dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public LocalDate getReferDate() {
		return referDate;
	}
	public void setReferDate(LocalDate referDate) {
		this.referDate = referDate;
	}
	public Long getReferredFromFacility() {
		return referredFromFacility;
	}
	public void setReferredFromFacility(Long referredFromFacility) {
		this.referredFromFacility = referredFromFacility;
	}
	public Long getReferredToFacility() {
		return referredToFacility;
	}
	public void setReferredToFacility(Long referredToFacility) {
		this.referredToFacility = referredToFacility;
	}
	
	public String getReferredFromFacilityName() {
		return referredFromFacilityName;
	}
	public void setReferredFromFacilityName(String referredFromFacilityName) {
		this.referredFromFacilityName = referredFromFacilityName;
	}
	public String getReferredToFacilityName() {
		return referredToFacilityName;
	}
	public void setReferredToFacilityName(String referredToFacilityName) {
		this.referredToFacilityName = referredToFacilityName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReferralType() {
		return referralType;
	}
	public void setReferralType(String referralType) {
		this.referralType = referralType;
	}
	public String getReferralReason() {
		return referralReason;
	}
	public void setReferralReason(String referralReason) {
		this.referralReason = referralReason;
	}
	public Integer getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(Integer facilityType) {
		this.facilityType = facilityType;
	}
	public Long getFacilityFromType() {
		return facilityFromType;
	}
	public void setFacilityFromType(Long facilityFromType) {
		this.facilityFromType = facilityFromType;
	}

	
}
