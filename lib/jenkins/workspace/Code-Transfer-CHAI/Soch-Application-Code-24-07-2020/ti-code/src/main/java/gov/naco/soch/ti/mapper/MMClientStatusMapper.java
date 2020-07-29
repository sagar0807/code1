package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterClientStatus;

@Mapper(componentModel = "spring")
@Named("clientStatus")
public interface MMClientStatusMapper {  

	MasterClientStatus toClientStatusEntity(MiniMasterDto miniMasterDto);
	
	MiniMasterDto toClientStatusDto(MasterClientStatus masterClientStatus);
	
}