package gov.naco.soch.dto;

import java.time.LocalDate;

public class DispatchBatchDto extends BaseDto{
 String batchNumber;
 LocalDate manufacturingDate;
 LocalDate expiryDate;
public String getBatchNumber() {
	return batchNumber;
}
public void setBatchNumber(String batchNumber) {
	this.batchNumber = batchNumber;
}
public LocalDate getManufacturingDate() {
	return manufacturingDate;
}
public void setManufacturingDate(LocalDate manufacturingDate) {
	this.manufacturingDate = manufacturingDate;
}
public LocalDate getExpiryDate() {
	return expiryDate;
}
public void setExpiryDate(LocalDate expiryDate) {
	this.expiryDate = expiryDate;
}
 
}
