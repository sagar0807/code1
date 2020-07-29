package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterTiClientStatus;

@Mapper(componentModel = "spring")
@Named("tiBenStatus")
public interface MMTiStatusMapper {

      MasterTiClientStatus toTiBenStatusEntity(MiniMasterDto miniMasterDto);

	MiniMasterDto toTiBenStatusDto(MasterTiClientStatus masterTiBenStatus); 
}
