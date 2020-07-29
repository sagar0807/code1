package gov.naco.soch.shared.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterEmploymentStatus;

@Mapper(componentModel = "spring")
@Named("employmentStatus")
public interface MMEmploymentStatusMapper{ //extends EntityMapper<MiniMasterDto, MasterEmploymentStatus>  {

	
	MasterEmploymentStatus toEmploymentStatusEntity(MiniMasterDto miniMasterDto);
	
	MiniMasterDto toEmploymentStatusDto(MasterEmploymentStatus masterMaritalStatus);
	
}