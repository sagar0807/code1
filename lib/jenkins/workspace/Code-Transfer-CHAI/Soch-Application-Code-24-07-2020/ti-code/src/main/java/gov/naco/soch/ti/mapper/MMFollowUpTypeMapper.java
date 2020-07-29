package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterFollowUpType;

@Mapper(componentModel = "spring")
@Named("followUpType")
public interface MMFollowUpTypeMapper { 

	
	MasterFollowUpType toFollowUpTypeEntity(MiniMasterDto miniMasterDto);

	MiniMasterDto toFollowUpTypeDto(MasterFollowUpType masterFollowUpType);
	
}