package gov.naco.soch.dto;

import java.io.Serializable;
import java.sql.Date;

public class StockTransactionDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String strCenName;
	
	private String strPrdName;
	
	private Date strTrnDate;
	
	private String strTrnType;
	
	private int strWdlTbs;
	
	private int strDepTbs;
	
	private int strBalance;
	
	private String strTrnRem;

	public String getStrCenName() {
		return strCenName;
	}

	public void setStrCenName(String strCenName) {
		this.strCenName = strCenName;
	}

	public String getStrPrdName() {
		return strPrdName;
	}

	public void setStrPrdName(String strPrdName) {
		this.strPrdName = strPrdName;
	}

	public Date getStrTrnDate() {
		return strTrnDate;
	}

	public void setStrTrnDate(Date strTrnDate) {
		this.strTrnDate = strTrnDate;
	}

	public String getStrTrnType() {
		return strTrnType;
	}

	public void setStrTrnType(String strTrnType) {
		this.strTrnType = strTrnType;
	}

	public int getStrWdlTbs() {
		return strWdlTbs;
	}

	public void setStrWdlTbs(int strWdlTbs) {
		this.strWdlTbs = strWdlTbs;
	}

	public int getStrDepTbs() {
		return strDepTbs;
	}

	public void setStrDepTbs(int strDepTbs) {
		this.strDepTbs = strDepTbs;
	}

	public int getStrBalance() {
		return strBalance;
	}

	public void setStrBalance(int strBalance) {
		this.strBalance = strBalance;
	}

	public String getStrTrnRem() {
		return strTrnRem;
	}

	public void setStrTrnRem(String strTrnRem) {
		this.strTrnRem = strTrnRem;
	}

}
