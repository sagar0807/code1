package gov.naco.soch.dto;

import javax.validation.constraints.NotEmpty;

public class FacilityRequestDto extends BaseDto{
	

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Division is mandatory")
	private Long divisionId;
	
	@NotEmpty(message = "Facility type is mandatory")
	private Long facilityTypeId;                   
	
	private Long facilityId;
	
	private String facilityName;

	public FacilityRequestDto() {
		super();
	}

	@Override
	public String toString() {
		return "FacilityRequestDto [divisionId=" + divisionId + ", facilityTypeId=" + facilityTypeId + ", facilityId="
				+ facilityId + ", facilityName=" + facilityName + "]";
	}
	
	public Long getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}

	public Long getFacilityTypeId() {
		return facilityTypeId;
	}

	public void setFacilityTypeId(Long facilityTypeId) {
		this.facilityTypeId = facilityTypeId;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

}
