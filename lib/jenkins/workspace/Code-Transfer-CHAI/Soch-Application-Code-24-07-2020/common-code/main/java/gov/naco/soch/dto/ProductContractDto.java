package gov.naco.soch.dto;

import java.util.List;

public class ProductContractDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long contarctId;
	private Long contarctProductId;
	private Long productId;
	private String productName;
	private String uom;
	private Long contractQuantity;
	private Long dispatchedQuantity;
	private Long authorizedQuantity;
	private List<ScheduleProductDto> schedule;
	private List<NoaDto> noa;

	public Long getContarctId() {
		return contarctId;
	}

	public void setContarctId(Long contarctId) {
		this.contarctId = contarctId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public List<ScheduleProductDto> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<ScheduleProductDto> schedule) {
		this.schedule = schedule;
	}

	public Long getContarctProductId() {
		return contarctProductId;
	}

	public void setContarctProductId(Long contarctProductId) {
		this.contarctProductId = contarctProductId;
	}

	public List<NoaDto> getNoa() {
		return noa;
	}

	public void setNoa(List<NoaDto> noa) {
		this.noa = noa;
	}

	public Long getAuthorizedQuantity() {
		return authorizedQuantity;
	}

	public Long getContractQuantity() {
		return contractQuantity;
	}

	public void setContractQuantity(Long contractQuantity) {
		this.contractQuantity = contractQuantity;
	}

	public void setAuthorizedQuantity(Long authorizedQuantity) {
		this.authorizedQuantity = authorizedQuantity;
	}

	public Long getDispatchedQuantity() {
		return dispatchedQuantity;
	}

	public void setDispatchedQuantity(Long dispatchedQuantity) {
		this.dispatchedQuantity = dispatchedQuantity;
	}

}
