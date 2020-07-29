package gov.naco.soch.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.Size;

/**
 * A DTO for the {@link gov.naco.soch.domain.ICTCBeneficiary} entity.
 */
public class ICTCBeneficiaryDTO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
    private Long id;

    @Size(max = 99)
    private String pid;

    private Boolean isConsentDocumented;

    private Long infantMotherArtId;

    @Size(max = 99)
    private String infantCode;

    private Long facilityId;

    private LocalDate registrationDate;

    private Integer createdBy;
    
    private Integer referredBy;

    private LocalDate createdTime;

    private Integer modifiedBy;

    private LocalDate modifiedTime;

    private Boolean isActive;

    private Boolean isDeleted;

    private Long beneficiaryId;
    
    private Long currentTestResultId;
    
//    private Long relationshipRecordId;
//
//    private Integer relationshipType;
    
    private Long recentVisitId;
    
    private Long tiReferralId;
    
    private String tiReferralName;
    
    private Long artReferralId;
    
    private String artReferralName;
    
    private Long dsrcReferralId;
    
    private String dsrcReferralName;
    
    private Long rntcpReferralId;
    
    private String rntcpReferralName;
    
    private Boolean onTbTreatment;
    
    private Boolean onSyphilisTreatment;
    
    private LocalDate dateOfStartOfAntiTbTreatment;
    
    private Integer deleteReason;
    
    private String deleteReasonComment;
    
    private Integer beneficiaryStatus;
   
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Boolean getIsConsentDocumented() {
		return isConsentDocumented;
	}

	public void setIsConsentDocumented(Boolean isConsentDocumented) {
		this.isConsentDocumented = isConsentDocumented;
	}

	public Long getInfantMotherArtId() {
		return infantMotherArtId;
	}

	public void setInfantMotherArtId(Long infantMotherArtId) {
		this.infantMotherArtId = infantMotherArtId;
	}

	public String getInfantCode() {
		return infantCode;
	}

	public void setInfantCode(String infantCode) {
		this.infantCode = infantCode;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(Integer referredBy) {
		this.referredBy = referredBy;
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

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Long getCurrentTestResultId() {
		return currentTestResultId;
	}

	public void setCurrentTestResultId(Long currentTestResultId) {
		this.currentTestResultId = currentTestResultId;
	}
	
//	public Long getRelationshipRecordId() {
//		return relationshipRecordId;
//	}
//
//	public void setRelationshipRecordId(Long relationshipRecordId) {
//		this.relationshipRecordId = relationshipRecordId;
//	}
//
//	public Integer getRelationshipType() {
//		return relationshipType;
//	}
//
//	public void setRelationshipType(Integer relationshipType) {
//		this.relationshipType = relationshipType;
//	}
	
	public Long getRecentVisitId() {
		return recentVisitId;
	}

	public void setRecentVisitId(Long recentVisitId) {
		this.recentVisitId = recentVisitId;
	}

	public Long getTiReferralId() {
		return tiReferralId;
	}

	public void setTiReferralId(Long tiReferralId) {
		this.tiReferralId = tiReferralId;
	}

	public String getTiReferralName() {
		return tiReferralName;
	}

	public void setTiReferralName(String tiReferralName) {
		this.tiReferralName = tiReferralName;
	}

	public Long getArtReferralId() {
		return artReferralId;
	}

	public void setArtReferralId(Long artReferralId) {
		this.artReferralId = artReferralId;
	}

	public String getArtReferralName() {
		return artReferralName;
	}

	public void setArtReferralName(String artReferralName) {
		this.artReferralName = artReferralName;
	}

	public Long getDsrcReferralId() {
		return dsrcReferralId;
	}

	public void setDsrcReferralId(Long dsrcReferralId) {
		this.dsrcReferralId = dsrcReferralId;
	}

	public String getDsrcReferralName() {
		return dsrcReferralName;
	}

	public void setDsrcReferralName(String dsrcReferralName) {
		this.dsrcReferralName = dsrcReferralName;
	}

	public Long getRntcpReferralId() {
		return rntcpReferralId;
	}

	public void setRntcpReferralId(Long rntcpReferralId) {
		this.rntcpReferralId = rntcpReferralId;
	}

	public String getRntcpReferralName() {
		return rntcpReferralName;
	}

	public void setRntcpReferralName(String rntcpReferralName) {
		this.rntcpReferralName = rntcpReferralName;
	}
	
	public Boolean getOnTbTreatment() {
		return onTbTreatment;
	}

	public void setOnTbTreatment(Boolean onTbTreatment) {
		this.onTbTreatment = onTbTreatment;
	}

	public Boolean getOnSyphilisTreatment() {
		return onSyphilisTreatment;
	}

	public void setOnSyphilisTreatment(Boolean onSyphilisTreatment) {
		this.onSyphilisTreatment = onSyphilisTreatment;
	}

	public LocalDate getDateOfStartOfAntiTbTreatment() {
		return dateOfStartOfAntiTbTreatment;
	}

	public void setDateOfStartOfAntiTbTreatment(LocalDate dateOfStartOfAntiTbTreatment) {
		this.dateOfStartOfAntiTbTreatment = dateOfStartOfAntiTbTreatment;
	}
	
	public Integer getDeleteReason() {
		return deleteReason;
	}

	public void setDeleteReason(Integer deleteReason) {
		this.deleteReason = deleteReason;
	}

	public String getDeleteReasonComment() {
		return deleteReasonComment;
	}

	public void setDeleteReasonComment(String deleteReasonComment) {
		this.deleteReasonComment = deleteReasonComment;
	}
	
	public Integer getBeneficiaryStatus() {
		return beneficiaryStatus;
	}

	public void setBeneficiaryStatus(Integer beneficiaryStatus) {
		this.beneficiaryStatus = beneficiaryStatus;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ICTCBeneficiaryDTO iCTCBeneficiaryDTO = (ICTCBeneficiaryDTO) o;
        if (iCTCBeneficiaryDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), iCTCBeneficiaryDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

	@Override
	public String toString() {
		return "ICTCBeneficiaryDTO [id=" + id + ", pid=" + pid + ", isConsentDocumented=" + isConsentDocumented
				+ ", infantMotherArtId=" + infantMotherArtId + ", infantCode=" + infantCode + ", facilityId="
				+ facilityId + ", registrationDate=" + registrationDate + ", createdBy=" + createdBy + ", referredBy="
				+ referredBy + ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy + ", modifiedTime="
				+ modifiedTime + ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", beneficiaryId="
				+ beneficiaryId + ", currentTestResultId=" + currentTestResultId + ", recentVisitId=" + recentVisitId
				+ ", tiReferralId=" + tiReferralId + ", tiReferralName=" + tiReferralName + ", artReferralId="
				+ artReferralId + ", artReferralName=" + artReferralName + ", dsrcReferralId=" + dsrcReferralId
				+ ", dsrcReferralName=" + dsrcReferralName + ", rntcpReferralId=" + rntcpReferralId
				+ ", rntcpReferralName=" + rntcpReferralName + ", onTbTreatment=" + onTbTreatment
				+ ", onSyphilisTreatment=" + onSyphilisTreatment + ", dateOfStartOfAntiTbTreatment="
				+ dateOfStartOfAntiTbTreatment + ", deleteReason=" + deleteReason + ", deleteReasonComment="
				+ deleteReasonComment + ", beneficiaryStatus=" + beneficiaryStatus + "]";
	}

}
