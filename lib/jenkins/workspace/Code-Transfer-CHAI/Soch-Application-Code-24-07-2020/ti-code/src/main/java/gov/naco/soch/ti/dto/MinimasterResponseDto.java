package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.util.List;

import gov.naco.soch.projection.MinimasterProjection;

public class MinimasterResponseDto implements Serializable {

    /**
     * 
     */
    
    private static final long serialVersionUID = 1L;

    private List<MinimasterProjection> gender;
    private List<MinimasterProjection> migrantOccupation;
    private List<MinimasterProjection>  maritalStatus;
    private List<MinimasterProjection> hrgSecondary;
    private List<MinimasterProjection> educationLevel;
    private List<MinimasterProjection> occupation;
    private List<MinimasterProjection> regDoneAt;
    private List<MinimasterProjection> destDuration;
    private List<MinimasterProjection> stayingWith;
    private List<MinimasterProjection> mobilityType;
    private List<MinimasterProjection> tiBenStatus;
    private List<MinimasterProjection> ostBenStatus;
    
    public MinimasterResponseDto() {
	
    }
    
    public List<MinimasterProjection> getGender() {
        return gender;
    }
    public void setGender(List<MinimasterProjection> gender) {
        this.gender = gender;
    }
    public List<MinimasterProjection> getMigrantOccupation() {
        return migrantOccupation;
    }
    public void setMigrantOccupation(List<MinimasterProjection> migrantOccupation) {
        this.migrantOccupation = migrantOccupation;
    }
    public List<MinimasterProjection> getMaritalStatus() {
        return maritalStatus;
    }
    public void setMaritalStatus(List<MinimasterProjection> maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    public List<MinimasterProjection> getHrgSecondary() {
        return hrgSecondary;
    }
    public void setHrgSecondary(List<MinimasterProjection> hrgSecondary) {
        this.hrgSecondary = hrgSecondary;
    }
    public List<MinimasterProjection> getEducationLevel() {
        return educationLevel;
    }
    public void setEducationLevel(List<MinimasterProjection> educationLevel) {
        this.educationLevel = educationLevel;
    }
    public List<MinimasterProjection> getOccupation() {
        return occupation;
    }
    public void setOccupation(List<MinimasterProjection> occupation) {
        this.occupation = occupation;
    }
    public List<MinimasterProjection> getRegDoneAt() {
        return regDoneAt;
    }
    public void setRegDoneAt(List<MinimasterProjection> regDoneAt) {
        this.regDoneAt = regDoneAt;
    }
    public List<MinimasterProjection> getDestDuration() {
        return destDuration;
    }
    public void setDestDuration(List<MinimasterProjection> destDuration) {
        this.destDuration = destDuration;
    }
    public List<MinimasterProjection> getStayingWith() {
        return stayingWith;
    }
    public void setStayingWith(List<MinimasterProjection> stayingWith) {
        this.stayingWith = stayingWith;
    }
    public List<MinimasterProjection> getMobilityType() {
        return mobilityType;
    }
    public void setMobilityType(List<MinimasterProjection> mobilityType) {
        this.mobilityType = mobilityType;
    }
    public List<MinimasterProjection> getTiBenStatus() {
        return tiBenStatus;
    }
    public void setTiBenStatus(List<MinimasterProjection> tiBenStatus) {
        this.tiBenStatus = tiBenStatus;
    }
    public List<MinimasterProjection> getOstBenStatus() {
        return ostBenStatus;
    }
    public void setOstBenStatus(List<MinimasterProjection> ostBenStatus) {
        this.ostBenStatus = ostBenStatus;
    }

    
   
    
    

}
