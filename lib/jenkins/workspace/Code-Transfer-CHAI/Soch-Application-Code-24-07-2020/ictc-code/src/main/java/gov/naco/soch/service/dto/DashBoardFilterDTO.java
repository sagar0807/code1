package gov.naco.soch.service.dto;

import java.math.BigInteger;

public class DashBoardFilterDTO {
	private String name;
	private String title;
	private BigInteger value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigInteger getValue() {
		return value;
	}

	public void setValue(BigInteger value) {
		this.value = value;
	}

}
