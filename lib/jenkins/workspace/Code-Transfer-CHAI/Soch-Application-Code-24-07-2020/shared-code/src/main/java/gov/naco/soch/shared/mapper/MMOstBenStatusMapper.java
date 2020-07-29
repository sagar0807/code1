package gov.naco.soch.shared.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterOstClientStatus;

@Mapper(componentModel = "spring")
@Named("ostBenStatus")
public interface MMOstBenStatusMapper {

      MasterOstClientStatus toOstBenStatusEntity(MiniMasterDto miniMasterDto);

	MiniMasterDto toOstBenStatusDto(MasterOstClientStatus masterOstBenStatus); 
}
