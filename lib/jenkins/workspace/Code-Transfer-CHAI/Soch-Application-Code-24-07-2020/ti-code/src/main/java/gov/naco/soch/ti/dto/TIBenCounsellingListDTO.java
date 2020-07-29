package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class TIBenCounsellingListDTO implements Serializable {


	private Long beneficiaryId;
	private String beneficiaryUId;
	private String tiCode;
	private String typology;
	private String gender;
	private Long age;
	private String currentStatus;
	private LocalDate lastCouncellingDate;
	public Long getBeneficiaryId() {
		return beneficiaryId;
	}
	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	
	public String getBeneficiaryUId() {
		return beneficiaryUId;
	}
	public void setBeneficiaryUId(String beneficiaryUId) {
		this.beneficiaryUId = beneficiaryUId;
	}
	public String getTiCode() {
		return tiCode;
	}
	public void setTiCode(String tiCode) {
		this.tiCode = tiCode;
	}
	public String getTypology() {
		return typology;
	}
	public void setTypology(String typology) {
		this.typology = typology;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public LocalDate getLastCouncellingDate() {
		return lastCouncellingDate;
	}
	public void setLastCouncellingDate(LocalDate lastCouncellingDate) {
		this.lastCouncellingDate = lastCouncellingDate;
	}



}
