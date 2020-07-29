package gov.naco.soch.dto;

public class DistrictDto extends BaseDto implements Comparable<DistrictDto> {

	private static final long serialVersionUID = 1L;

	public DistrictDto() {
		super();
	}

	private Long id;
	private String name;
	private Long stateid;

	public Long getId() {
		return id;
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

	public Long getStateid() {
		return stateid;
	}

	public void setStateid(Long stateid) {
		this.stateid = stateid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DistrictDto [id=" + id + ", name=" + name + ", stateid=" + stateid + "]";
	}

	@Override
	public int compareTo(DistrictDto d) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(d.getName());
	}

}
