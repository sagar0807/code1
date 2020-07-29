package gov.naco.soch.ti.dto.readonly;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import gov.naco.soch.ti.dto.TiBenCounsellingTypeDTO;
import gov.naco.soch.ti.dto.TiBenSubDto;

public class CounsellingDto implements Serializable{
    
    private static final long serialVersionUID = 1L;

	private Long id;

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

	private TiBenSubDto beneficiary;

	private Set<TiBenCounsellingTypeDTO> tiBenCounsellingType;
	
	private long count;
	
	private Long previousId;
	
	private Boolean isEarly;
	
	public CounsellingDto() {
	  
	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}

	public Integer getDurationOfCounselling() {
	    return durationOfCounselling;
	}

	public void setDurationOfCounselling(Integer durationOfCounselling) {
	    this.durationOfCounselling = durationOfCounselling;
	}

	public String getTypeOfCounsellingProvided() {
	    return typeOfCounsellingProvided;
	}

	public void setTypeOfCounsellingProvided(String typeOfCounsellingProvided) {
	    this.typeOfCounsellingProvided = typeOfCounsellingProvided;
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

	public String getRemarks() {
	    return remarks;
	}

	public void setRemarks(String remarks) {
	    this.remarks = remarks;
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

	public Long getFacilityId() {
	    return facilityId;
	}

	public void setFacilityId(Long facilityId) {
	    this.facilityId = facilityId;
	}

	public TiBenSubDto getBeneficiary() {
	    return beneficiary;
	}

	public void setBeneficiary(TiBenSubDto beneficiary) {
	    this.beneficiary = beneficiary;
	}

	public Set<TiBenCounsellingTypeDTO> getTiBenCounsellingType() {
	    return tiBenCounsellingType;
	}

	public void setTiBenCounsellingType(Set<TiBenCounsellingTypeDTO> tiBenCounsellingType) {
	    this.tiBenCounsellingType = tiBenCounsellingType;
	}

	public long getCount() {
	    return count;
	}

	public void setCount(long count) {
	    this.count = count;
	}

	public Long getPreviousId() {
	    return previousId;
	}

	public void setPreviousId(Long previousId) {
	    this.previousId = previousId;
	}

	public Boolean getIsEarly() {
	    return isEarly;
	}

	public void setIsEarly(Boolean isEarly) {
	    this.isEarly = isEarly;
	}
	
	

}
