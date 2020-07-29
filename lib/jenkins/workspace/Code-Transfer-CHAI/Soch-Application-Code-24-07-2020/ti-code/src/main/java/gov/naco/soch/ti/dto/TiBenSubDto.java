package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.time.LocalDate;

import gov.naco.soch.dto.MiniMasterDto;

public class TiBenSubDto implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String tiCode;
    private LocalDate dateOfReg;
    private MiniMasterDto hrgPrimary;
    private MiniMasterDto hrgSecondary;
    private MiniMasterDto status;
    private Integer lapTreatments;
    private Integer ibTreatments;
    private MasterBenSubDto masterBeneficiary;

   
    public TiBenSubDto() {
	
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTiCode() {
        return tiCode;
    }


    public void setTiCode(String tiCode) {
        this.tiCode = tiCode;
    }


    public LocalDate getDateOfReg() {
        return dateOfReg;
    }


    public void setDateOfReg(LocalDate dateOfReg) {
        this.dateOfReg = dateOfReg;
    }


    public MasterBenSubDto getMasterBeneficiary() {
	return masterBeneficiary;
    }


    public void setMasterBeneficiary(MasterBenSubDto masterBeneficiary) {
	this.masterBeneficiary = masterBeneficiary;
    }


    public MiniMasterDto getHrgPrimary() {
        return hrgPrimary;
    }


    public void setHrgPrimary(MiniMasterDto hrgPrimary) {
        this.hrgPrimary = hrgPrimary;
    }


    public MiniMasterDto getHrgSecondary() {
        return hrgSecondary;
    }


    public void setHrgSecondary(MiniMasterDto hrgSecondary) {
        this.hrgSecondary = hrgSecondary;
    }


    public MiniMasterDto getStatus() {
        return status;
    }


    public void setStatus(MiniMasterDto status) {
        this.status = status;
    }


    public Integer getLapTreatments() {
        return lapTreatments;
    }


    public void setLapTreatments(Integer lapTreatments) {
        this.lapTreatments = lapTreatments;
    }


    public Integer getIbTreatments() {
        return ibTreatments;
    }


    public void setIbTreatments(Integer ibTreatments) {
        this.ibTreatments = ibTreatments;
    }
    
    
    
    

}
