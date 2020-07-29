package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterMaritalStatus;

@Mapper(componentModel = "spring")
@Named("maritalStatus")
public interface MMMaritalStatusMapper { //extends EntityMapper<MiniMasterDto, MasterMaritalStatus>  {

	
	MasterMaritalStatus toMaritalStatusEntity(MiniMasterDto miniMasterDto);
	
	MiniMasterDto toMaritalStatusDto(MasterMaritalStatus masterMaritalStatus);
	
}