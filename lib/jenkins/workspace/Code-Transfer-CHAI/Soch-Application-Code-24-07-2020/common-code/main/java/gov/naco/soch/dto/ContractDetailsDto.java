package gov.naco.soch.dto;

import java.time.LocalDate;
import java.util.List;

public class ContractDetailsDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long Id;
	private String noaNumber;
	private String indentNumber;
	private LocalDate allotmentDate;
	private String contractStatus;
//	private List<ContractProductDto> products;
	private Long supplierId;
	private String supplierName;
	private List<String> products;
	private Long createdBy;

	public String getNoaNumber() {
		return noaNumber;
	}

	/*
	 * public LocalDate getAllotmentDate() { return allotmentDate; }
	 * 
	 * public List<ContractProductDto> getProducts() { return products; }
	 * 
	 * public void setProducts(List<ContractProductDto> products) { this.products =
	 * products; }
	 */
	public void setNoaNumber(String noaNumber) {
		this.noaNumber = noaNumber;
	}

	public void setAllotmentDate(LocalDate allotmentDate) {
		this.allotmentDate = allotmentDate;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public List<String> getProducts() {
		return products;
	}

	public void setProducts(List<String> products) {
		this.products = products;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public LocalDate getAllotmentDate() {
		return allotmentDate;
	}

	public String getIndentNumber() {
		return indentNumber;
	}

	public void setIndentNumber(String indentNumber) {
		this.indentNumber = indentNumber;
	}

	@Override
	public String toString() {
		return "ContractDetailsDto [Id=" + Id + ", noaNumber=" + noaNumber + ", indentNumber=" + indentNumber
				+ ", allotmentDate=" + allotmentDate + ", contractStatus=" + contractStatus + ", supplierId="
				+ supplierId + ", supplierName=" + supplierName + ", products=" + products + ", createdBy=" + createdBy
				+ "]";
	}

}
