package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterDestinationDuration;

@Mapper(componentModel = "spring")
@Named("destinationDuration")
public interface MMDestinationDurationMapper { // extends EntityMapper<MiniMasterDto, MasterDestinationDuration> {

	MasterDestinationDuration toDestinationDurationEntity(MiniMasterDto masterDestinationDuration);
	
	MiniMasterDto toDestinationDurationDto(MasterDestinationDuration masterDestinationDuration);
}
