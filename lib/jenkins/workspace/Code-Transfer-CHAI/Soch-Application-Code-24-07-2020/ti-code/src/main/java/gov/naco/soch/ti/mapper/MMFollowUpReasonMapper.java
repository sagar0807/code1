package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterOstFollowUpReason;

@Mapper(componentModel = "spring")
@Named("followUpReason")
public interface MMFollowUpReasonMapper { 

	
	MasterOstFollowUpReason toFollowUpReasonEntity(MiniMasterDto miniMasterDto);

	MiniMasterDto toFollowUpReasonDto(MasterOstFollowUpReason masterFollowUpType);
	
}