package gov.naco.soch.ti.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import gov.naco.soch.entity.BeneficiaryFacilityMapping;
import gov.naco.soch.entity.BeneficiaryFacilityMappingReadOnly;
import gov.naco.soch.entity.MasterGender;

@Entity(name = "MasterBenSubEntity")
@Table(name = "beneficiary")
@Immutable
public class MasterBenSubEntity implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(name = "age")
    private String age;
    
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "uid")
    private String uid;
    
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private MasterGender genderId;
    
  
    @JsonIgnore
    @OneToMany(mappedBy = "beneficiary")
    private Set<BeneficiaryFacilityMappingReadOnly> beneficiaryFacilityMappings;
    
    public MasterBenSubEntity() {
	
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public MasterGender getGenderId() {
        return genderId;
    }

    public void setGenderId(MasterGender genderId) {
        this.genderId = genderId;
    }

    public Set<BeneficiaryFacilityMappingReadOnly> getBeneficiaryFacilityMappings() {
        return beneficiaryFacilityMappings;
    }

    public void setBeneficiaryFacilityMappings(Set<BeneficiaryFacilityMappingReadOnly> beneficiaryFacilityMappings) {
        this.beneficiaryFacilityMappings = beneficiaryFacilityMappings;
    }
    
    
    
    

}
