package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class TiOstDrugItemDispensationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long drugId;
	private LocalDate lastDispensationDate;
	private Double dosageQuantity;

	public Long getDrugId() {
		return drugId;
	}

	public void setDrugId(Long drugId) {
		this.drugId = drugId;
	}

	public LocalDate getLastDispensationDate() {
		return lastDispensationDate;
	}

	public void setLastDispensationDate(LocalDate lastDispensationDate) {
		this.lastDispensationDate = lastDispensationDate;
	}

	public Double getDosageQuantity() {
		return dosageQuantity;
	}

	public void setDosageQuantity(Double dosageQuantity) {
		this.dosageQuantity = dosageQuantity;
	}

}
