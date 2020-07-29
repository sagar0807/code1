package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterHivScreeningStatus;

@Mapper(componentModel = "spring")
@Named("hivStatus")
public interface MMHivStatusMapper {

	MasterHivScreeningStatus toInfectionTypeEntity(MiniMasterDto miniMasterDto);

	MiniMasterDto toInfectionTypeDto(MasterHivScreeningStatus masterHivStatus); 
}
