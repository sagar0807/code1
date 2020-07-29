package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterFollowUpBy;

@Mapper(componentModel = "spring")
@Named("followUpBy")
public interface MMFollowUpByMapper { 

	
	MasterFollowUpBy toFollowUpByEntity(MiniMasterDto miniMasterDto);

	MiniMasterDto toFollowUpByDto(MasterFollowUpBy masterFollowUpType);
	
}