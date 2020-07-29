package gov.naco.soch.shared.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterOccupation;


@Mapper(componentModel = "spring")
@Named("occupation")
public interface MMOccupationMapper{ //extends EntityMapper<MiniMasterDto,MasterOccupation> {

   MasterOccupation toOccupationEntity(MiniMasterDto occupationId);
   
   MiniMasterDto toOccupationDto(MasterOccupation occupationId);
}
