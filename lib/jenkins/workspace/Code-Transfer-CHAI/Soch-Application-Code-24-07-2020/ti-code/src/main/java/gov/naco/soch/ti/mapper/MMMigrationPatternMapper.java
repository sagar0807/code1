package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterMigrationPattern;

@Mapper(componentModel = "spring")
@Named("migrationPattern")
public interface MMMigrationPatternMapper {

	
        MasterMigrationPattern toMigrationEntity(MiniMasterDto miniMasterDto);
	
	MiniMasterDto toMigrationDto(MasterMigrationPattern master);
	
}