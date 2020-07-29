package gov.naco.soch.cst.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import gov.naco.soch.dto.BeneficiaryDto;

public class BeneficiaryReferralDto {

	private Long id;
	private LocalDate dateOfHivTest;
	private LocalDate dateOfVisit;
	private String hivStatus;
	private Boolean isActive;
	private Boolean isDelete;
	private LocalDate referDate;
	private String referralType;
	private String typeOfHiv;
	private LocalDateTime acceptedDate;
	private LocalDateTime declinedDate;
	private String referralReason;
	private Integer facilityType;
	private Long beneficiaryId;
	private Long referredFrom;
	private Long referralStatus;
	private Long referredTo;
	private BeneficiaryDto beneficiary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateOfHivTest() {
		return dateOfHivTest;
	}

	public void setDateOfHivTest(LocalDate dateOfHivTest) {
		this.dateOfHivTest = dateOfHivTest;
	}

	public LocalDate getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(LocalDate dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public String getHivStatus() {
		return hivStatus;
	}

	public void setHivStatus(String hivStatus) {
		this.hivStatus = hivStatus;
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

	public LocalDate getReferDate() {
		return referDate;
	}

	public void setReferDate(LocalDate referDate) {
		this.referDate = referDate;
	}

	public String getReferralType() {
		return referralType;
	}

	public void setReferralType(String referralType) {
		this.referralType = referralType;
	}

	public String getTypeOfHiv() {
		return typeOfHiv;
	}

	public void setTypeOfHiv(String typeOfHiv) {
		this.typeOfHiv = typeOfHiv;
	}

	public LocalDateTime getAcceptedDate() {
		return acceptedDate;
	}

	public void setAcceptedDate(LocalDateTime acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

	public LocalDateTime getDeclinedDate() {
		return declinedDate;
	}

	public void setDeclinedDate(LocalDateTime declinedDate) {
		this.declinedDate = declinedDate;
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

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Long getReferredFrom() {
		return referredFrom;
	}

	public void setReferredFrom(Long referredFrom) {
		this.referredFrom = referredFrom;
	}

	public Long getReferralStatus() {
		return referralStatus;
	}

	public void setReferralStatus(Long referralStatus) {
		this.referralStatus = referralStatus;
	}

	public Long getReferredTo() {
		return referredTo;
	}

	public void setReferredTo(Long referredTo) {
		this.referredTo = referredTo;
	}

	public BeneficiaryDto getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(BeneficiaryDto beneficiary) {
		this.beneficiary = beneficiary;
	}
	
}
