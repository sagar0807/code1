package gov.naco.soch.dto;

import java.util.List;

public class IndentProductDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long indentProductId;
	Long indentId;
	private Long productId;
	private String productName;
	private String uom;
	private List<IndentProductScheduleDto> schedules;

	public Long getIndentProductId() {
		return indentProductId;
	}

	public void setIndentProductId(Long indentProductId) {
		this.indentProductId = indentProductId;
	}

	public Long getIndentId() {
		return indentId;
	}

	public void setIndentId(Long indentId) {
		this.indentId = indentId;
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

	public List<IndentProductScheduleDto> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<IndentProductScheduleDto> schedules) {
		this.schedules = schedules;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}