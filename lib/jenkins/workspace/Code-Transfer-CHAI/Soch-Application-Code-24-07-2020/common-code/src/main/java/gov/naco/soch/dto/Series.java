package gov.naco.soch.dto;

import java.math.BigInteger;
import java.util.List;

public class Series {
	
	private String name;
	private List<BigInteger> data;
	public List<BigInteger> getData() {
		return data;
	}
	public void setData(List<BigInteger> data) {
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
