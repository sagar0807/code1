package gov.naco.soch.ti.dto;

import java.io.Serializable;

import gov.naco.soch.dto.MiniMasterDto;

public class MasterBenSubDto implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private Long id;

    private String age;
    
    private String firstName;
    
    private String lastName;
    
    private String mobileNumber;

    private String uid;
    
    private MiniMasterDto genderId;

    
    public MasterBenSubDto() {
	
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

    public MiniMasterDto getGenderId() {
        return genderId;
    }

    public void setGenderId(MiniMasterDto genderId) {
        this.genderId = genderId;
    } 	 
    
    

}
