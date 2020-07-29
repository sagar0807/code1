package gov.naco.soch.dto;

import java.util.List;

public class DistrictFacilityDto {

	private List<DistrictDto> districts;

	private List<FacilityTypeDto> facilityTypes;

	private List<FacilityDto> facilities;

	public List<DistrictDto> getDistricts() {
		return districts;
	}

	public void setDistricts(List<DistrictDto> districts) {
		this.districts = districts;
	}

	public List<FacilityTypeDto> getFacilityTypes() {
		return facilityTypes;
	}

	public void setFacilityTypes(List<FacilityTypeDto> facilityTypes) {
		this.facilityTypes = facilityTypes;
	}

	public List<FacilityDto> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<FacilityDto> facilities) {
		this.facilities = facilities;
	}

}
