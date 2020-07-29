package gov.naco.soch.dto;

import java.time.LocalDate;
import java.util.List;

public class IndentDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	Long indentId;
	String indentNumber;
	private LocalDate indentDate;
	private Long indentStatusId;
	private String indentStatus;
	private Boolean isAllContractCreated;
	List<IndentProductDto> products;

	public Long getIndentId() {
		return indentId;
	}

	public void setIndentId(Long indentId) {
		this.indentId = indentId;
	}

	public String getIndentNumber() {
		return indentNumber;
	}

	public void setIndentNumber(String indentNumber) {
		this.indentNumber = indentNumber;
	}

	public LocalDate getIndentDate() {
		return indentDate;
	}

	public void setIndentDate(LocalDate indentDate) {
		this.indentDate = indentDate;
	}

	public Long getIndentStatusId() {
		return indentStatusId;
	}

	public void setIndentStatusId(Long indentStatusId) {
		this.indentStatusId = indentStatusId;
	}

	public String getIndentStatus() {
		return indentStatus;
	}

	public void setIndentStatus(String indentStatus) {
		this.indentStatus = indentStatus;
	}

	public List<IndentProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<IndentProductDto> products) {
		this.products = products;
	}

	public Boolean getIsAllContractCreated() {
		return isAllContractCreated;
	}

	public void setIsAllContractCreated(Boolean isAllContractCreated) {
		this.isAllContractCreated = isAllContractCreated;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}