package gov.naco.soch.dto;

import java.time.LocalDate;

public class TiOstBeneficiaryDispensationDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private String uid;
	private String ostNumber;
	private Long tiOstBeneficiaryId;
	private String beneficiaryName;
	private LocalDate dateOfVisit;
	private String age;
	private String sex;
	private Long tiOstPrescriptionId;
	private LocalDate lastDispensationDate;
	private String drug;
	private Double dosage;
	private Integer numberOf2mgTablet;
	private Double numberOf4mgTablet;
	private long count;
	private Boolean isTransit;

	public String getOstNumber() {
		return ostNumber;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public LocalDate getDateOfVisit() {
		return dateOfVisit;
	}

	public String getAge() {
		return age;
	}

	public String getSex() {
		return sex;
	}

	public LocalDate getLastDispensationDate() {
		return lastDispensationDate;
	}

	public String getDrug() {
		return drug;
	}

	public Double getDosage() {
		return dosage;
	}

	public void setOstNumber(String ostNumber) {
		this.ostNumber = ostNumber;
	}

	public Boolean getIsTransit() {
	    return isTransit;
	}

	public void setIsTransit(Boolean isTransit) {
	    this.isTransit = isTransit;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public void setDateOfVisit(LocalDate dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setLastDispensationDate(LocalDate lastDispensationDate) {
		this.lastDispensationDate = lastDispensationDate;
	}

	public void setDrug(String drug) {
		this.drug = drug;
	}

	public void setDosage(Double dosage) {
		this.dosage = dosage;
	}

	public Long getTiOstBeneficiaryId() {
		return tiOstBeneficiaryId;
	}

	public Long getTiOstPrescriptionId() {
		return tiOstPrescriptionId;
	}

	public void setTiOstBeneficiaryId(Long tiOstBeneficiaryId) {
		this.tiOstBeneficiaryId = tiOstBeneficiaryId;
	}

	public void setTiOstPrescriptionId(Long tiOstPrescriptionId) {
		this.tiOstPrescriptionId = tiOstPrescriptionId;
	}

	public Integer getNumberOf2mgTablet() {
		return numberOf2mgTablet;
	}

	public void setNumberOf2mgTablet(Integer numberOf2mgTablet) {
		this.numberOf2mgTablet = numberOf2mgTablet;
	}

	public Double getNumberOf4mgTablet() {
		return numberOf4mgTablet;
	}

	public void setNumberOf4mgTablet(Double numberOf4mgTablet) {
		this.numberOf4mgTablet = numberOf4mgTablet;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "TiOstBeneficiaryDispensationDto [ostNumber=" + ostNumber + ", beneficiaryName=" + beneficiaryName
				+ ", dateOfVisit=" + dateOfVisit + ", age=" + age + ", sex=" + sex + ", lastDispensationDate="
				+ lastDispensationDate + ", drug=" + drug + ", dosage=" + dosage + "]";
	}

}
