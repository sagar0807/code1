package gov.naco.soch.dto;

import java.time.LocalDate;

public class BeneficiaryDispensationDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private Long tiOstBeneficiaryId;
	private Long tiOstPrescriptionId;
	private Double dispensedQuantity;
	private double numberOf2mgTablet;
	private double numberOf4mgTablet;
	private LocalDate lastDispensationDate;
	private Double dosage;

	public Long getTiOstBeneficiaryId() {
		return tiOstBeneficiaryId;
	}

	public void setTiOstBeneficiaryId(Long tiOstBeneficiaryId) {
		this.tiOstBeneficiaryId = tiOstBeneficiaryId;
	}

	public Long getTiOstPrescriptionId() {
		return tiOstPrescriptionId;
	}

	public void setTiOstPrescriptionId(Long tiOstPrescriptionId) {
		this.tiOstPrescriptionId = tiOstPrescriptionId;
	}

	public Double getDispensedQuantity() {
		return dispensedQuantity;
	}

	public void setDispensedQuantity(Double dispensedQuantity) {
		this.dispensedQuantity = dispensedQuantity;
	}

	public double getNumberOf2mgTablet() {
		return numberOf2mgTablet;
	}

	public void setNumberOf2mgTablet(double numberOf2mgTablet) {
		this.numberOf2mgTablet = numberOf2mgTablet;
	}

	public double getNumberOf4mgTablet() {
		return numberOf4mgTablet;
	}

	public void setNumberOf4mgTablet(double numberOf4mgTablet) {
		this.numberOf4mgTablet = numberOf4mgTablet;
	}

	public Double getDosage() {
		return dosage;
	}

	public void setDosage(Double dosage) {
		this.dosage = dosage;
	}

	public LocalDate getLastDispensationDate() {
		return lastDispensationDate;
	}

	public void setLastDispensationDate(LocalDate lastDispensationDate) {
		this.lastDispensationDate = lastDispensationDate;
	}

}
