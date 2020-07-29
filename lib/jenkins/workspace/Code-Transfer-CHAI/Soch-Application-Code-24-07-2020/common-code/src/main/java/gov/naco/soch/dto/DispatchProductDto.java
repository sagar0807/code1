package gov.naco.soch.dto;

import java.time.LocalDate;
import java.util.List;

public class DispatchProductDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long productId;

	String productCode;
	String productName;
	String uom;
	String batchNumber;
	LocalDate manufacturedDate;
	List<BatchDto>batchDtos;
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public LocalDate getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(LocalDate manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	public List<BatchDto> getBatchDtos() {
		return batchDtos;
	}

	public void setBatchDtos(List<BatchDto> batchDtos) {
		this.batchDtos = batchDtos;
	}

}
