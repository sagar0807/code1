package gov.naco.soch.dto;

public class FacilityTypeListByDivisionDTO extends BaseDto{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
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
	@Override
	public String toString() {
		return "FacilityTypeListByDivisionDTO [id=" + id + ", name=" + name + "]";
	}
	
	
}
