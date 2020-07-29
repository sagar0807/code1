package gov.naco.soch.ti.mapper;

import java.util.List;

import gov.naco.soch.entity.Facility;
import gov.naco.soch.ti.dto.FacilityDTO;

public class FacilityMapper {

	public static List<FacilityDTO> mapFacilityListToFacilityDtoList(List<Facility> facilities,
			List<FacilityDTO> facilityDTOs) {
		for(Facility facility : facilities) {
			FacilityDTO dto = new FacilityDTO();
			dto.setId(facility.getId());
			dto.setName(facility.getName());
			facilityDTOs.add(dto);
		}
		return facilityDTOs;
	}

}
