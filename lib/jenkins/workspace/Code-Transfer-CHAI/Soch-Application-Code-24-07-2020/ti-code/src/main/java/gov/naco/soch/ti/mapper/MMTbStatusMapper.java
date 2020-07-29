package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterTbScreeningStatus;

@Mapper(componentModel = "spring")
@Named("tbStatus")
public interface MMTbStatusMapper {

	MasterTbScreeningStatus toInfectionTypeEntity(MiniMasterDto miniMasterDto);

	MiniMasterDto toInfectionTypeDto(MasterTbScreeningStatus masterHivStatus); 
}
