package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterReferredfrom;

@Mapper(componentModel = "spring")
@Named("referredFrom")
public interface MMReferredFromMapper {//extends EntityMapper<MiniMasterDto,MasterReferredfrom> {

	MasterReferredfrom toReferredFromEntity(MiniMasterDto miniMasterDto);
   
    MiniMasterDto toReferredFromDto(MasterReferredfrom masterReferredFrom);
}
