package gov.naco.soch.inventory.dto;

import java.util.List;

public class CMSSPOWiseStockDto {

	private String poNo;
	private List<CMSSStockDto> poList;
	private Long qtyActive;
	private Long qtyQuar;
	private Long qtyRej;

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public List<CMSSStockDto> getPoList() {
		return poList;
	}

	public void setPoList(List<CMSSStockDto> poList) {
		this.poList = poList;
	}

	public Long getQtyActive() {
		return qtyActive;
	}

	public void setQtyActive(Long qtyActive) {
		this.qtyActive = qtyActive;
	}

	public Long getQtyQuar() {
		return qtyQuar;
	}

	public void setQtyQuar(Long qtyQuar) {
		this.qtyQuar = qtyQuar;
	}

	public Long getQtyRej() {
		return qtyRej;
	}

	public void setQtyRej(Long qtyRej) {
		this.qtyRej = qtyRej;
	}

}
