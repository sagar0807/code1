package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterInfectionType;

@Mapper(componentModel = "spring")
@Named("infectionType")
public interface MMInfectionTypeMapper {

	MasterInfectionType toInfectionTypeEntity(MiniMasterDto miniMasterDto);

	MiniMasterDto toInfectionTypeDto(MasterInfectionType masterInfectionType); 
}