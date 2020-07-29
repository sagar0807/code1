package gov.naco.soch.cst.dto;

import java.time.LocalDate;

public class LinkedFacilityBeneficiaryDto {
	
	private Long id;
    private Boolean isLinked;
    private LocalDate linkDate;
    private LocalDate unlinkDate;
    private Boolean isActive;
    private Boolean isDelete;
    private Long beneficiary;
    private String firstName;
    private String address;
    private String preArtNumber;
    private String artNumber;
    private String contactNumber;
    private String lacName;
    private Long lacId;
    private String Age;
    private String gender;
    private String status;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getBeneficiary() {
		return beneficiary;
	}
	public void setBeneficiary(Long beneficiary) {
		this.beneficiary = beneficiary;
	}
	public Boolean getIsLinked() {
		return isLinked;
	}
	public void setIsLinked(Boolean isLinked) {
		this.isLinked = isLinked;
	}
	public LocalDate getLinkDate() {
		return linkDate;
	}
	public void setLinkDate(LocalDate linkDate) {
		this.linkDate = linkDate;
	}
	public LocalDate getUnlinkDate() {
		return unlinkDate;
	}
	public void setUnlinkDate(LocalDate unlinkDate) {
		this.unlinkDate = unlinkDate;
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
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPreArtNumber() {
		return preArtNumber;
	}
	public void setPreArtNumber(String preArtNumber) {
		this.preArtNumber = preArtNumber;
	}
	public String getArtNumber() {
		return artNumber;
	}
	public void setArtNumber(String artNumber) {
		this.artNumber = artNumber;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getLacName() {
		return lacName;
	}
	public void setLacName(String lacName) {
		this.lacName = lacName;
	}
	public Long getLacId() {
		return lacId;
	}
	public void setLacId(Long lacId) {
		this.lacId = lacId;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
