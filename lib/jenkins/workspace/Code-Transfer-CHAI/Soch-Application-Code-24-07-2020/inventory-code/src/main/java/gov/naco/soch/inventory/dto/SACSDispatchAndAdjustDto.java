package gov.naco.soch.inventory.dto;

import java.util.Date;

public class SACSDispatchAndAdjustDto {
	private Long getSlNo;

	private String getPName;

	private Date getAdjustDate;

	private String getUom;

	private Long getQuantity;

	private String getAdjustreason;

	public Long getGetSlNo() {
		return getSlNo;
	}

	public void setGetSlNo(Long getSlNo) {
		this.getSlNo = getSlNo;
	}

	public String getGetPName() {
		return getPName;
	}

	public void setGetPName(String getPName) {
		this.getPName = getPName;
	}

	public Date getGetAdjustDate() {
		return getAdjustDate;
	}

	public void setGetAdjustDate(Date getAdjustDate) {
		this.getAdjustDate = getAdjustDate;
	}

	public String getGetUom() {
		return getUom;
	}

	public void setGetUom(String getUom) {
		this.getUom = getUom;
	}

	public Long getGetQuantity() {
		return getQuantity;
	}

	public void setGetQuantity(Long getQuantity) {
		this.getQuantity = getQuantity;
	}

	public String getGetAdjustreason() {
		return getAdjustreason;
	}

	public void setGetAdjustreason(String getAdjustreason) {
		this.getAdjustreason = getAdjustreason;
	}

}
