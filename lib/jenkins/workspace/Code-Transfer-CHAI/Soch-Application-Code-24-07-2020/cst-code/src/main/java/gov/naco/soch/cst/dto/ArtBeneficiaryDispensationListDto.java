package gov.naco.soch.cst.dto;

import java.time.LocalDate;
import java.util.List;

import gov.naco.soch.dto.BaseDto;

public class ArtBeneficiaryDispensationListDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private Long beneficiaryId;
	private String beneficiaryFirstName;
	private String beneficiaryLastName;
	private String gender;
	private String barcode;
	private String age;
	private String weight;
	private String artStatus;
	private String artNumber;
	private String preArtNumber;
	private LocalDate lastVisitDate;
	private LocalDate nextAppoinmentDate;
	private Long reimenId;
	private String regimen;
	private List<LastDispensationDetailsDto> lastDispensationDetails;
	private List<LastDispensationProductDto> regimenProducts;

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public String getBeneficiaryFirstName() {
		return beneficiaryFirstName;
	}

	public void setBeneficiaryFirstName(String beneficiaryFirstName) {
		this.beneficiaryFirstName = beneficiaryFirstName;
	}

	public String getBeneficiaryLastName() {
		return beneficiaryLastName;
	}

	public void setBeneficiaryLastName(String beneficiaryLastName) {
		this.beneficiaryLastName = beneficiaryLastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getArtStatus() {
		return artStatus;
	}

	public void setArtStatus(String artStatus) {
		this.artStatus = artStatus;
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

	public LocalDate getLastVisitDate() {
		return lastVisitDate;
	}

	public void setLastVisitDate(LocalDate lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}

	public LocalDate getNextAppoinmentDate() {
		return nextAppoinmentDate;
	}

	public void setNextAppoinmentDate(LocalDate nextAppoinmentDate) {
		this.nextAppoinmentDate = nextAppoinmentDate;
	}

	public String getRegimen() {
		return regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

	public List<LastDispensationDetailsDto> getLastDispensationDetails() {
		return lastDispensationDetails;
	}

	public void setLastDispensationDetails(List<LastDispensationDetailsDto> lastDispensationDetails) {
		this.lastDispensationDetails = lastDispensationDetails;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Long getReimenId() {
		return reimenId;
	}

	public void setReimenId(Long reimenId) {
		this.reimenId = reimenId;
	}

	public List<LastDispensationProductDto> getRegimenProducts() {
		return regimenProducts;
	}

	public void setRegimenProducts(List<LastDispensationProductDto> regimenProducts) {
		this.regimenProducts = regimenProducts;
	}


}
