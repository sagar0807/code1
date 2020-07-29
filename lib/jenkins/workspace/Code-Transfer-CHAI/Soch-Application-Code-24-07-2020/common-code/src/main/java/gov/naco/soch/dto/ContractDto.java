package gov.naco.soch.dto;

import java.time.LocalDate;
import java.util.List;

public class ContractDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String indentNumber;
	private String noaNumber;
	private LocalDate allotmentDate;
	private Long supplierId;
	private String supplierName;
	private String contractStatus;
	List<ProductContractDto> product;

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNoaNumber() {
		return noaNumber;
	}

	public void setNoaNumber(String noaNumber) {
		this.noaNumber = noaNumber;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<ProductContractDto> getProduct() {
		return product;
	}

	public void setProduct(List<ProductContractDto> product) {
		this.product = product;
	}

	public LocalDate getAllotmentDate() {
		return allotmentDate;
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

	public String getIndentNumber() {
		return indentNumber;
	}

	public void setIndentNumber(String indentNumber) {
		this.indentNumber = indentNumber;
	}

}
