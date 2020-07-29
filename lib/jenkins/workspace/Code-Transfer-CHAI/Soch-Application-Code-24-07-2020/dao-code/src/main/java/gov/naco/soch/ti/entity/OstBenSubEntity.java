package gov.naco.soch.ti.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Immutable;

import gov.naco.soch.entity.MasterBeneficiaryOstStatus;
import gov.naco.soch.entity.MasterOstClientStatus;

@Entity(name = "OstBenSubEntity")
@Table(name = "ti_ost_beneficiary")
@Immutable
public class OstBenSubEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;

    @Column(name = "ost_code")
    private String ostCode;

    @Size(max = 25)
    @Column(name = "ost_number")
    private String ostNumber;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "followups")
    private Integer followups;

    @Column(name = "consent_taken_date")
    private LocalDate consentTakenDate;

    @ManyToOne
    @JoinColumn(name = "ost_status_id")
    private MasterBeneficiaryOstStatus ostStatus;

    @ManyToOne
    private MasterBenSubEntity beneficiary;
    
    @OneToMany(mappedBy = "tiOstBeneficiary")
    private Set<OstPrescription> tiOstPrescriptions;
    
    @ManyToOne
    @JoinColumn(name = "status_id")
    private MasterOstClientStatus status;
    
    @Column(name="facility_id")
    private Long facilityId;

    public OstBenSubEntity() {

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
    
    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public String getOstNumber() {
	return ostNumber;
    }

    public void setOstNumber(String ostNumber) {
	this.ostNumber = ostNumber;
    }

    public LocalDate getRegistrationDate() {
	return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
	this.registrationDate = registrationDate;
    }

    public MasterOstClientStatus getStatus() {
        return status;
    }

    public void setStatus(MasterOstClientStatus status) {
        this.status = status;
    }

    public Integer getFollowups() {
	return followups;
    }

    public void setFollowups(Integer followups) {
	this.followups = followups;
    }

    public LocalDate getConsentTakenDate() {
	return consentTakenDate;
    }

    public void setConsentTakenDate(LocalDate consentTakenDate) {
	this.consentTakenDate = consentTakenDate;
    }

    public MasterBeneficiaryOstStatus getOstStatus() {
	return ostStatus;
    }

    public void setOstStatus(MasterBeneficiaryOstStatus ostStatus) {
	this.ostStatus = ostStatus;
    }

    public MasterBenSubEntity getBeneficiary() {
	return beneficiary;
    }

    public void setBeneficiary(MasterBenSubEntity beneficiary) {
	this.beneficiary = beneficiary;
    }

    public Set<OstPrescription> getTiOstPrescriptions() {
        return tiOstPrescriptions;
    }

    public void setTiOstPrescriptions(Set<OstPrescription> tiOstPrescriptions) {
        this.tiOstPrescriptions = tiOstPrescriptions;
    }
    
    

}
