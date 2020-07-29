package gov.naco.soch.cst.dto;

import java.time.LocalDate;
import java.util.List;

import gov.naco.soch.dto.BaseDto;
import gov.naco.soch.projection.ArtDispensationItemProjection;

public class TodaysDispensedDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private Long artDispensationId;
	private Long artPepDispensedId;
	private Long beneficiaryId;
	private String beneficiaryName;
	private String artNumber;
	private String preArtNumber;
	private String gender;
	private String age;
	private LocalDate dispenseDate;
	private LocalDate nextAppointmentDate;
	private Long visitRegisterId;
	private List<LastDispensationProductDto> product;
	private String category;
	private String isProxy;
	private String modeOfDispensation;

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDispenseDate() {
		return dispenseDate;
	}

	public void setDispenseDate(LocalDate dispenseDate) {
		this.dispenseDate = dispenseDate;
	}

	public LocalDate getNextAppointmentDate() {
		return nextAppointmentDate;
	}

	public void setNextAppointmentDate(LocalDate nextAppointmentDate) {
		this.nextAppointmentDate = nextAppointmentDate;
	}

	public List<LastDispensationProductDto> getProduct() {
		return product;
	}

	public void setProduct(List<LastDispensationProductDto> product) {
		this.product = product;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIsProxy() {
		return isProxy;
	}

	public void setIsProxy(String isProxy) {
		this.isProxy = isProxy;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getModeOfDispensation() {
		return modeOfDispensation;
	}

	public Long getVisitRegisterId() {
		return visitRegisterId;
	}

	public void setVisitRegisterId(Long visitRegisterId) {
		this.visitRegisterId = visitRegisterId;
	}

	public Long getArtDispensationId() {
		return artDispensationId;
	}

	public void setArtDispensationId(Long artDispensationId) {
		this.artDispensationId = artDispensationId;
	}

	public Long getArtPepDispensedId() {
		return artPepDispensedId;
	}

	public void setArtPepDispensedId(Long artPepDispensedId) {
		this.artPepDispensedId = artPepDispensedId;
	}

	public void setModeOfDispensation(String modeOfDispensation) {
		this.modeOfDispensation = modeOfDispensation;
	}

}
