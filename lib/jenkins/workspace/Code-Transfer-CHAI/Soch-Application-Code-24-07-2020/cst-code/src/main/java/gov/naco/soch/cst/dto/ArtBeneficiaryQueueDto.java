package gov.naco.soch.cst.dto;

import java.io.Serializable;

public class ArtBeneficiaryQueueDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
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
	private String assignedToUser;
	private Long visitRegisterId;
	private String changedAssignedTo;
	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public String getChangedAssignedTo() {
		return changedAssignedTo;
	}

	public void setChangedAssignedTo(String changedAssignedTo) {
		this.changedAssignedTo = changedAssignedTo;
	}

	public Long getVisitRegisterId() {
		return visitRegisterId;
	}

	public void setVisitRegisterId(Long visitRegisterId) {
		this.visitRegisterId = visitRegisterId;
	}


	public String getAssignedToUser() {
		return assignedToUser;
	}

	public void setAssignedToUser(String assignedToUser) {
		this.assignedToUser = assignedToUser;
	}

	public Boolean getLacLinked() {
		return lacLinked;
	}

	public void setLacLinked(Boolean lacLinked) {
		this.lacLinked = lacLinked;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
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

	public ArtBeneficiaryQueueDto() {
	}

}