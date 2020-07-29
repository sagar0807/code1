package gov.naco.soch.dto;

import java.util.List;

public class StateDto extends BaseDto implements Comparable<StateDto> {

	private static final long serialVersionUID = 1L;

	public StateDto() {
		super();
	}

	private Long id;
	private String name;

	private List<DistrictDto> districts;

	public Long getId() {
		return id;
	}

	public List<DistrictDto> getDistricts() {
		return districts;
	}

	public void setDistricts(List<DistrictDto> districts) {
		this.districts = districts;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "StateDto [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compareTo(StateDto o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}

}
