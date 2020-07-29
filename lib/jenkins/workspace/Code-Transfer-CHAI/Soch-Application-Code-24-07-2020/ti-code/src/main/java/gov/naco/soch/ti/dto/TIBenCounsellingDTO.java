package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link gov.naco.soch.domain.TIBenCounselling} entity.
 */
public class TIBenCounsellingDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	//private String currentHealthStatus;

	private Integer durationOfCounselling;

	private String typeOfCounsellingProvided;

	private Integer noOfCondomsDistributed;

	private LocalDate lastCounsellingDate;

	private LocalDate counsellingDate;

	private LocalDate nextCounsellingDate;
	
	private String remarks;

	private Boolean isActive;

	private Boolean isDelete;

	private Long facilityId;

	private TIBeneficiaryDTO beneficiary;

	private Set<TiBenCounsellingTypeDTO> tiBenCounsellingType;
	
	private long count;
	
	private Long previousId;
	
	private Boolean isEarly;
	
	private Boolean csm;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public String getCurrentHealthStatus() {
//		return currentHealthStatus;
//	}
//
//	public void setCurrentHealthStatus(String currentHealthStatus) {
//		this.currentHealthStatus = currentHealthStatus;
//	}

	public Integer getDurationOfCounselling() {
		return durationOfCounselling;
	}

	public void setDurationOfCounselling(Integer durationOfCounselling) {
		this.durationOfCounselling = durationOfCounselling;
	}

	public Set<TiBenCounsellingTypeDTO> getTiBenCounsellingType() {
		return tiBenCounsellingType;
	}

	public void setTiBenCounsellingType(Set<TiBenCounsellingTypeDTO> tiBenCounsellingType) {
		this.tiBenCounsellingType = tiBenCounsellingType;
	}

	public String getTypeOfCounsellingProvided() {
		return typeOfCounsellingProvided;
	}

	public void setTypeOfCounsellingProvided(String typeOfCounsellingProvided) {
		this.typeOfCounsellingProvided = typeOfCounsellingProvided;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public TIBeneficiaryDTO getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(TIBeneficiaryDTO beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Boolean getIsEarly() {
	    return isEarly;
	}

	public void setIsEarly(Boolean isEarly) {
	    this.isEarly = isEarly;
	}

	public Long getPreviousId() {
	    return previousId;
	}

	public void setPreviousId(Long previousId) {
	    this.previousId = previousId;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public long getCount() {
	    return count;
	}

	public void setCount(long count) {
	    this.count = count;
	}

	public Integer getNoOfCondomsDistributed() {
		return noOfCondomsDistributed;
	}

	public void setNoOfCondomsDistributed(Integer noOfCondomsDistributed) {
		this.noOfCondomsDistributed = noOfCondomsDistributed;
	}

	public LocalDate getLastCounsellingDate() {
		return lastCounsellingDate;
	}

	public void setLastCounsellingDate(LocalDate lastCounsellingDate) {
		this.lastCounsellingDate = lastCounsellingDate;
	}

	public LocalDate getCounsellingDate() {
		return counsellingDate;
	}

	public void setCounsellingDate(LocalDate counsellingDate) {
		this.counsellingDate = counsellingDate;
	}

	public LocalDate getNextCounsellingDate() {
		return nextCounsellingDate;
	}

	public void setNextCounsellingDate(LocalDate nextCounsellingDate) {
		this.nextCounsellingDate = nextCounsellingDate;
	}

	public Boolean isIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean isIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		TIBenCounsellingDTO tIBenCounsellingDTO = (TIBenCounsellingDTO) o;
		if (tIBenCounsellingDTO.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), tIBenCounsellingDTO.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}
	
	
	public Boolean getCsm() {
		return csm;
	}

	public void setCsm(Boolean csm) {
		this.csm = csm;
	}

	@Override
	public String toString() {
		return "TIBenCounsellingDTO [id=" + id + ", durationOfCounselling=" + durationOfCounselling + ", typeOfCounsellingProvided="
				+ typeOfCounsellingProvided + ", noOfCondomsDistributed=" + noOfCondomsDistributed
				+ ", lastCounsellingDate=" + lastCounsellingDate + ", counsellingDate=" + counsellingDate
				+ ", nextCounsellingDate=" + nextCounsellingDate + ", isActive=" + isActive + ", isDelete=" + isDelete
				+ ", facilityId=" + facilityId + ", beneficiary=" + beneficiary + "]";
	}

}
