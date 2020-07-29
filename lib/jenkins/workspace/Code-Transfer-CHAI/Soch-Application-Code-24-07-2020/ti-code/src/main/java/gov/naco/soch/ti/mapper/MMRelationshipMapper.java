package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterRelationship;

@Mapper(componentModel = "spring")
@Named("relationship")
public interface MMRelationshipMapper { 

	
	MasterRelationship toGenderEntity(MiniMasterDto miniMasterDto);
	
	MiniMasterDto toGenderDto(MasterRelationship masterMaritalStatus);
	
}

