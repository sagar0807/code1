package gov.naco.soch.service.dto;

import gov.naco.soch.domain.Facility;

public class InfantMotherDetailsDTO {
	
	private Long beneficiaryId;
	
	private String artNumber;
	
	private String preArtNumber;
	
	private String firstName;
	
	private String lastName;
	
	private String middleName;
	
	private Long artCenterId;
	
	private String artCode;
	
	private Boolean artDetailsFound;
	
	private Facility motherArtCenter;

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public String getArtNumber() {
		return artNumber;
	}

	public void setArtNumber(String artNumber) {
		this.artNumber = artNumber;
	}

	public String getPreArtNumber() {
		return preArtNumber;
	}

	public void setPreArtNumber(String preArtNumber) {
		this.preArtNumber = preArtNumber;
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Long getArtCenterId() {
		return artCenterId;
	}

	public void setArtCenterId(Long artCenterId) {
		this.artCenterId = artCenterId;
	}

	public String getArtCode() {
		return artCode;
	}

	public void setArtCode(String artCode) {
		this.artCode = artCode;
	}
	
	public Boolean getArtDetailsFound() {
		return artDetailsFound;
	}

	public void setArtDetailsFound(Boolean artDetailsFound) {
		this.artDetailsFound = artDetailsFound;
	}

	public Facility getMotherArtCenter() {
		return motherArtCenter;
	}

	public void setMotherArtCenter(Facility motherArtCenter) {
		this.motherArtCenter = motherArtCenter;
	}

	@Override
	public String toString() {
		return "InfantMotherDetailsDTO [beneficiaryId=" + beneficiaryId + ", artNumber=" + artNumber + ", preArtNumber="
				+ preArtNumber + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", artCenterId=" + artCenterId + ", artCode=" + artCode + ", artDetailsFound=" + artDetailsFound
				+ "]";
	}
	
	
}
