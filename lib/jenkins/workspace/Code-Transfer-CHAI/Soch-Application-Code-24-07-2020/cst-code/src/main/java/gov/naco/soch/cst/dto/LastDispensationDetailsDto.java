package gov.naco.soch.cst.dto;

import java.time.LocalDate;
import java.util.List;

import gov.naco.soch.dto.BaseDto;

public class LastDispensationDetailsDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private LocalDate visitDate;
	private List<LastDispensationProductDto> products;

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public List<LastDispensationProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<LastDispensationProductDto> products) {
		this.products = products;
	}

}
