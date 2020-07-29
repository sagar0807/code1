package gov.naco.soch.cst.dto;

import java.time.LocalDate;

public class ArtBeneficiaryListDto {

	private String uid;
	private String age;
	private String gender;
	private String preArtNumber;
	private String artNumber;
	private String status;
	private String firstName;
	private String middleName;
	private String lastName;
	private Long beneficiaryId;
	private Boolean lacLinked;
	private String artTransferStatus;
	private Boolean isTransit;
	private String 	transferredTo;
	private String contactNumber;
	private LocalDate registrationDate;
	private LocalDate artStartDate;
	private Long adhernceToArt;
	private String regimen;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

    public void setLacLinked(Boolean lacLinked) {
        this.lacLinked = lacLinked;
    }

    public Boolean getLacLinked() {
        return lacLinked;
    }

    public void setArtTransferStatus(String artTransferStatus) {
        this.artTransferStatus = artTransferStatus;
    }

    public String getArtTransferStatus() {
        return artTransferStatus;
    }

	public void setIsTransit(Boolean isTransit) {
		this.isTransit = isTransit;
	}

	public Boolean getIsTransit() {
		return isTransit;
	}

	public void setTransferredTo(String transferredTo) {
		this.transferredTo = transferredTo;
	}

	public String getTransferredTo() {
		return transferredTo;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setArtStartDate(LocalDate artStartDate) {
		this.artStartDate = artStartDate;
	}

	public LocalDate getArtStartDate() {
		return artStartDate;
	}

	public void setAdhernceToArt(Long adhernceToArt) {
		this.adhernceToArt = adhernceToArt;
	}

	public Long getAdhernceToArt() {
		return adhernceToArt;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

	public String getRegimen() {
		return regimen;
	}
}
