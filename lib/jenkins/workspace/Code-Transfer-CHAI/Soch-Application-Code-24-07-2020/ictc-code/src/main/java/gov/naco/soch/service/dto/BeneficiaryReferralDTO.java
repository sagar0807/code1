package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link gov.naco.soch.domain.BeneficiaryReferral} entity.
 */
public class BeneficiaryReferralDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

//	private LocalDate dateOfHivTest;

	private LocalDate dateOfVisit;

//	private String hivStatus;

	private Boolean isActive;

	private Boolean isDelete;

	private LocalDate referDate;

	private String referralType;
	
	private Integer referralTypeId;

//	private String typeOfHiv;

	private LocalDate acceptedDate;

	private LocalDate declinedDate;

	private String referralReason;

	private Integer referredBy;

	private Long beneficiaryId;

	private Long referedFrom;

	private Long referedTo;

	private Integer referralStatusId;

	private Long tiBeneficiaryId;

	private Long tiBenScrId;

	private Integer createdBy;

	private LocalDate createdTime;

	private Integer modifiedBy;

	private LocalDate modifiedTime;
	
	private Long ictcBeneficiaryId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public LocalDate getDateOfHivTest() {
//		return dateOfHivTest;
//	}
//
//	public void setDateOfHivTest(LocalDate dateOfHivTest) {
//		this.dateOfHivTest = dateOfHivTest;
//	}

	public LocalDate getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(LocalDate dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

//	public String getHivStatus() {
//		return hivStatus;
//	}
//
//	public void setHivStatus(String hivStatus) {
//		this.hivStatus = hivStatus;
//	}

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

//	public String getTypeOfHiv() {
//		return typeOfHiv;
//	}
//
//	public void setTypeOfHiv(String typeOfHiv) {
//		this.typeOfHiv = typeOfHiv;
//	}

	public LocalDate getAcceptedDate() {
		return acceptedDate;
	}

	public void setAcceptedDate(LocalDate acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

	public LocalDate getDeclinedDate() {
		return declinedDate;
	}

	public void setDeclinedDate(LocalDate declinedDate) {
		this.declinedDate = declinedDate;
	}

	public String getReferralReason() {
		return referralReason;
	}

	public void setReferralReason(String referralReason) {
		this.referralReason = referralReason;
	}

	public Integer getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(Integer referredBy) {
		this.referredBy = referredBy;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Long getReferedFrom() {
		return referedFrom;
	}

	public void setReferedFrom(Long referedFrom) {
		this.referedFrom = referedFrom;
	}

	public Long getReferedTo() {
		return referedTo;
	}

	public void setReferedTo(Long referedTo) {
		this.referedTo = referedTo;
	}

	public Integer getReferralStatusId() {
		return referralStatusId;
	}

	public void setReferralStatusId(Integer referralStatusId) {
		this.referralStatusId = referralStatusId;
	}

	public Long getTiBeneficiaryId() {
		return tiBeneficiaryId;
	}

	public void setTiBeneficiaryId(Long tiBeneficiaryId) {
		this.tiBeneficiaryId = tiBeneficiaryId;
	}

	public Long getTiBenScrId() {
		return tiBenScrId;
	}

	public void setTiBenScrId(Long tiBenScrId) {
		this.tiBenScrId = tiBenScrId;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDate createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDate getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDate modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Integer getReferralTypeId() {
		return referralTypeId;
	}

	public void setReferralTypeId(Integer referralTypeId) {
		this.referralTypeId = referralTypeId;
	}
	
	public Long getIctcBeneficiaryId() {
		return ictcBeneficiaryId;
	}

	public void setIctcBeneficiaryId(Long ictcBeneficiaryId) {
		this.ictcBeneficiaryId = ictcBeneficiaryId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		BeneficiaryReferralDTO beneficiaryReferralDTO = (BeneficiaryReferralDTO) o;
		if (beneficiaryReferralDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), beneficiaryReferralDTO.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return "BeneficiaryReferralDTO [id=" + id + ", dateOfVisit=" + dateOfVisit + ", isActive=" + isActive
				+ ", isDelete=" + isDelete + ", referDate=" + referDate + ", referralType=" + referralType
				+ ", referralTypeId=" + referralTypeId + ", acceptedDate=" + acceptedDate + ", declinedDate="
				+ declinedDate + ", referralReason=" + referralReason + ", referredBy=" + referredBy
				+ ", beneficiaryId=" + beneficiaryId + ", referedFrom=" + referedFrom + ", referedTo=" + referedTo
				+ ", referralStatusId=" + referralStatusId + ", tiBeneficiaryId=" + tiBeneficiaryId + ", tiBenScrId="
				+ tiBenScrId + ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", modifiedBy="
				+ modifiedBy + ", modifiedTime=" + modifiedTime + ", ictcBeneficiaryId=" + ictcBeneficiaryId + "]";
	}

}
