package gov.naco.soch.shared.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import gov.naco.soch.entity.Facility;
import gov.naco.soch.shared.dto.FacilityListResponseDTO;

@Mapper(componentModel = "spring")
public interface FacilityMapper extends EntityMapper<FacilityListResponseDTO,Facility> {
	
	List<FacilityListResponseDTO> toDto(List<Facility> facility);

}
