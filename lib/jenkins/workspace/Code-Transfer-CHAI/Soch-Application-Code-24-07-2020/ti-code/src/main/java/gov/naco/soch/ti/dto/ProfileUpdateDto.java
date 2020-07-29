package gov.naco.soch.ti.dto;

import java.io.Serializable;

public class ProfileUpdateDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;   
    private Long id;
    private Boolean isActive;
    private Boolean isDelete;
    private Long facilityId;
    private Integer advocacy;
    private Integer violenceReported;
    private Integer committees;
    private Integer orwSanctioned;
    private Integer orwTotal;
    private Integer peSanctioned;
    private Integer peTotal;
    private Integer otherStaffVacant;
    private Integer newStaffRecruit;
    private Integer month;
    private Integer year;
    
    
    public ProfileUpdateDto() {
	
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public Integer getAdvocacy() {
        return advocacy;
    }
    public void setAdvocacy(Integer advocacy) {
        this.advocacy = advocacy;
    }
    public Integer getViolenceReported() {
        return violenceReported;
    }
    public void setViolenceReported(Integer violenceReported) {
        this.violenceReported = violenceReported;
    }
    public Integer getCommittees() {
        return committees;
    }
    public void setCommittees(Integer committees) {
        this.committees = committees;
    }
    public Integer getOrwSanctioned() {
        return orwSanctioned;
    }
    public void setOrwSanctioned(Integer orwSanctioned) {
        this.orwSanctioned = orwSanctioned;
    }
    public Integer getOrwTotal() {
        return orwTotal;
    }
    public void setOrwTotal(Integer orwTotal) {
        this.orwTotal = orwTotal;
    }
    public Integer getPeSanctioned() {
        return peSanctioned;
    }
    public void setPeSanctioned(Integer peSanctioned) {
        this.peSanctioned = peSanctioned;
    }
    public Integer getPeTotal() {
        return peTotal;
    }
    public void setPeTotal(Integer peTotal) {
        this.peTotal = peTotal;
    }
    public Integer getOtherStaffVacant() {
        return otherStaffVacant;
    }
    public void setOtherStaffVacant(Integer otherStaffVacant) {
        this.otherStaffVacant = otherStaffVacant;
    }
    public Integer getNewStaffRecruit() {
        return newStaffRecruit;
    }
    public void setNewStaffRecruit(Integer newStaffRecruit) {
        this.newStaffRecruit = newStaffRecruit;
    }
    public Integer getMonth() {
        return month;
    }
    public void setMonth(Integer month) {
        this.month = month;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }

    
    

}
