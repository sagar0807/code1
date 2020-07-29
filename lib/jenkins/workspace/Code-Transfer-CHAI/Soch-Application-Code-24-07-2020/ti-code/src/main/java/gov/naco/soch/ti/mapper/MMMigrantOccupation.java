package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterMigrantOccupation;

@Mapper(componentModel = "spring")
@Named("migrant")
public interface MMMigrantOccupation {

	
	MasterMigrantOccupation toMigrantEntity(MiniMasterDto miniMasterDto);
	
	MiniMasterDto toMigrantDto(MasterMigrantOccupation master);
	
}