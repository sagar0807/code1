package gov.naco.soch.ti.dto.readonly;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.ti.dto.FacilityDTO;
import gov.naco.soch.ti.dto.MasterBenSubDto;
import gov.naco.soch.ti.dto.TIOstPrescriptionDTO;

public class OstBenSubDto implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private String ostCode;
    private String ostNumber;
    private MiniMasterDto ostStatus;
    private MiniMasterDto status;
    private LocalDate registrationDate;
    private LocalDate consentTakenDate;
    private Integer followups;
    private MasterBenSubDto masterBeneficiary;
    private Set<TIOstPrescriptionDTO> tiOstPrescriptions;
    private FacilityDTO facility;
    
    public OstBenSubDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOstCode() {
        return ostCode;
    }

    public void setOstCode(String ostCode) {
        this.ostCode = ostCode;
    }

    public String getOstNumber() {
        return ostNumber;
    }

    public void setOstNumber(String ostNumber) {
        this.ostNumber = ostNumber;
    }

    public MiniMasterDto getOstStatus() {
        return ostStatus;
    }
   
    public void setOstStatus(MiniMasterDto ostStatus) {
        this.ostStatus = ostStatus;
    }

    public Set<TIOstPrescriptionDTO> getTiOstPrescriptions() {
	return tiOstPrescriptions;
    }

    public void setTiOstPrescriptions(Set<TIOstPrescriptionDTO> tiOstPrescriptions) {
	this.tiOstPrescriptions = tiOstPrescriptions;
    }

    public FacilityDTO getFacility() {
	return facility;
    }

    public void setFacility(FacilityDTO facility) {
	this.facility = facility;
    }

    public MiniMasterDto getStatus() {
	return status;
    }

    public void setStatus(MiniMasterDto status) {
	this.status = status;
    }
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getConsentTakenDate() {
        return consentTakenDate;
    }

    public void setConsentTakenDate(LocalDate consentTakenDate) {
        this.consentTakenDate = consentTakenDate;
    }

    public Integer getFollowups() {
        return followups;
    }

    public void setFollowups(Integer followups) {
        this.followups = followups;
    }

    public MasterBenSubDto getMasterBeneficiary() {
        return masterBeneficiary;
    }

    public void setMasterBeneficiary(MasterBenSubDto masterBeneficiary) {
        this.masterBeneficiary = masterBeneficiary;
    }
    
    
    
    
    

}
