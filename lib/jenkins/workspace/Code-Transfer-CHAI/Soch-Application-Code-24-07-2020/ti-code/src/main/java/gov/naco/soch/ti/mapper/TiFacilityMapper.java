package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;

import gov.naco.soch.entity.Facility;
import gov.naco.soch.ti.dto.FacilityDTO;

@Mapper(componentModel = "spring")
public interface TiFacilityMapper extends EntityMapper<FacilityDTO,Facility> {

	
	Facility toEntity(FacilityDTO facilityDto);

	FacilityDTO toDto(Facility facility); 
	
	default Facility fromId(Long id) {
		if (id == null) {
			return null;
		}
		Facility facility = new Facility();
		facility.setId(id);
		return facility;
	}
}
