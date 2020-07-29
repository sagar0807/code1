package gov.naco.soch.cst.dto;

import java.math.BigInteger;

public class InvestigationCountDto {
	
	private BigInteger count;
	
	private String month ;

	public BigInteger getCount() {
		return count;
	}

	public void setCount(BigInteger count) {
		this.count = count;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}
