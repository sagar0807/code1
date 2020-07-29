package gov.naco.soch.dto;

public class FacilityBasicListDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Long facilityTypeId;
	private String facilityTypeName;

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

	public Long getFacilityTypeId() {
		return facilityTypeId;
	}

	public void setFacilityTypeId(Long facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}

	public String getFacilityTypeName() {
		return facilityTypeName;
	}

	public void setFacilityTypeName(String facilityTypeName) {
		this.facilityTypeName = facilityTypeName;
	}

	@Override
	public String toString() {
		return "FacilityBasicListDto [id=" + id + ", name=" + name + ", facilityTypeId=" + facilityTypeId
				+ ", facilityTypeName=" + facilityTypeName + "]";
	}

}
