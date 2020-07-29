package gov.naco.soch.shared.dto.ti;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import gov.naco.soch.dto.BaseDto;
import gov.naco.soch.dto.MiniMasterDto;

public class TIBenCounsellingDTO_Initial extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long facilityId;
	private Long beneficiaryId;
	private LocalDate nextCounsellingDate;
	
	//private String currentHealthStatus;

	private Integer durationOfCounselling;

	private Integer noOfCondomsDistributed;

	private LocalDate lastCounsellingDate;

	private LocalDate counsellingDate;
	
	private String remarks;
	
	private Boolean isActive;

	private Boolean isDelete;
	
	private Set<TiBenCounsellingTypeDTO> tiBenCounsellingType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
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

//	public String getCurrentHealthStatus() {
//		return currentHealthStatus;
//	}
//
//	public void setCurrentHealthStatus(String currentHealthStatus) {
//		this.currentHealthStatus = currentHealthStatus;
//	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		TIBenCounsellingDTO_Initial tIBenCounsellingDTO_Initial = (TIBenCounsellingDTO_Initial) o;
		if (tIBenCounsellingDTO_Initial.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), tIBenCounsellingDTO_Initial.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

}
