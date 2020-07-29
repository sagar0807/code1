package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterSyphilisStatus;

@Mapper(componentModel = "spring")
@Named("syphilisStatus")
public interface MMSyphilisStatusMapper {

	MasterSyphilisStatus toInfectionTypeEntity(MiniMasterDto miniMasterDto);

	MiniMasterDto toInfectionTypeDto(MasterSyphilisStatus masterHivStatus); 
}

