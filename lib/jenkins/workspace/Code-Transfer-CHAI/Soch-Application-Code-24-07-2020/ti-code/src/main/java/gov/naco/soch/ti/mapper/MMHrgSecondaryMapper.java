package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterHrgSecondary;

@Mapper(componentModel = "spring")
@Named("hrgSecondary")
public interface MMHrgSecondaryMapper {// extends EntityMapper<MiniMasterDto,MasterHrgSecondary>{

	MasterHrgSecondary toHrgSecondaryEntity(MiniMasterDto hrgsecondary);

	MiniMasterDto toHrgSecondaryDto(MasterHrgSecondary hrgsecondary); 
}
