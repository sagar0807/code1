package gov.naco.soch.service.dto;

import java.math.BigInteger;
import java.util.List;

public class DashBoardSummaryDTO {
	private int id;
	private String name;
	private String title;
	private BigInteger value;
	private List<DashBoardFilterDTO> filters;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public List<DashBoardFilterDTO> getFilters() {
		return filters;
	}

	public void setFilters(List<DashBoardFilterDTO> filters) {
		this.filters = filters;
	}

}
