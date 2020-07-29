package gov.naco.soch.ti.dto;

import java.time.LocalDate;
import java.util.List;

import gov.naco.soch.dto.BaseDto;
import gov.naco.soch.dto.BeneficiaryDto;
import gov.naco.soch.dto.ProductDto;

public class TiDispenseResponseDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private BeneficiaryDto benefeciaryDetails;
	private List<ProductDto> productDetails;
	public BeneficiaryDto getBenefeciaryDetails() {
		return benefeciaryDetails;
	}
	public void setBenefeciaryDetails(BeneficiaryDto benefeciaryDetails) {
		this.benefeciaryDetails = benefeciaryDetails;
	}
	
	public LocalDate getNextFollowUpDate() {
		return nextFollowUpDate;
	}
	public void setNextFollowUpDate(LocalDate nextFollowUpDate) {
		this.nextFollowUpDate = nextFollowUpDate;
	}
	public Boolean getHivTestingDue() {
		return hivTestingDue;
	}
	public void setHivTestingDue(Boolean hivTestingDue) {
		this.hivTestingDue = hivTestingDue;
	}
	public String getClientStatus() {
		return clientStatus;
	}
	public void setClientStatus(String clientStatus) {
		this.clientStatus = clientStatus;
	}
	public List<ProductDto> getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(List<ProductDto> productDetails) {
		this.productDetails = productDetails;
	}
	private LocalDate nextFollowUpDate;
	private Boolean hivTestingDue;
	private String clientStatus;

}
