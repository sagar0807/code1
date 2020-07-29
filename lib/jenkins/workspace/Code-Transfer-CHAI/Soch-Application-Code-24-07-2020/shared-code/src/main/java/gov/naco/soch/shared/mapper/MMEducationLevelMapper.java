package gov.naco.soch.shared.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterEducationLevel;


@Mapper(componentModel = "spring")
@Named("educationLevel")
public interface MMEducationLevelMapper { // extends EntityMapper<MiniMasterDto, MasterEducationLevel>  {

	
	MasterEducationLevel toEducationLevelEntity(MiniMasterDto mmEducationLevelDto);
	
	MiniMasterDto toEducationLevelDto(MasterEducationLevel masterEducationLevel);
	
}
