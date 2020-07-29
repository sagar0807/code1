package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class VisitRegisterDto implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String module;
    private Long masterBenId;
    private Long tiBeneficiaryId;
    private Long ostBeneficiaryId;
    private LocalDateTime ostStatusDate;
    private LocalDateTime ostClientStatusDate;
    private LocalDateTime tiClientStatusDate;
    private Long ostClientStatusId;
    private Long tiClientStatusId;
    private Long ostStatusId;
    private Long facilityId;
    
    
    public Long getTiBeneficiaryId() {
        return tiBeneficiaryId;
    }
    public void setTiBeneficiaryId(Long tiBeneficiaryId) {
        this.tiBeneficiaryId = tiBeneficiaryId;
    }
    public Long getOstBeneficiaryId() {
        return ostBeneficiaryId;
    }
    public void setOstBeneficiaryId(Long ostBeneficiaryId) {
        this.ostBeneficiaryId = ostBeneficiaryId;
    }
    public LocalDateTime getOstStatusDate() {
        return ostStatusDate;
    }
    public void setOstStatusDate(LocalDateTime ostStatusDate) {
        this.ostStatusDate = ostStatusDate;
    }
    public LocalDateTime getOstClientStatusDate() {
        return ostClientStatusDate;
    }
    public void setOstClientStatusDate(LocalDateTime ostClientStatusDate) {
        this.ostClientStatusDate = ostClientStatusDate;
    }
    public Long getMasterBenId() {
	return masterBenId;
    }
    public void setMasterBenId(Long masterBenId) {
	this.masterBenId = masterBenId;
    }
    public Long getFacilityId() {
	return facilityId;
    }
    public void setFacilityId(Long facilityId) {
	this.facilityId = facilityId;
    }
    public String getModule() {
	return module;
    }
    public void setModule(String module) {
	this.module = module;
    }
    public LocalDateTime getTiClientStatusDate() {
        return tiClientStatusDate;
    }
    public void setTiClientStatusDate(LocalDateTime tiClientStatusDate) {
        this.tiClientStatusDate = tiClientStatusDate;
    }
    public Long getOstClientStatusId() {
        return ostClientStatusId;
    }
    public void setOstClientStatusId(Long ostClientStatusId) {
        this.ostClientStatusId = ostClientStatusId;
    }
    public Long getTiClientStatusId() {
        return tiClientStatusId;
    }
    public void setTiClientStatusId(Long tiClientStatusId) {
        this.tiClientStatusId = tiClientStatusId;
    }
    public Long getOstStatusId() {
        return ostStatusId;
    }
    public void setOstStatusId(Long ostStatusId) {
        this.ostStatusId = ostStatusId;
    }
    
    

}
