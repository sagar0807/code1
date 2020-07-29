package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterContactType;

@Mapper(componentModel = "spring")
@Named("contactType")
public interface MMContactTypeMapper {
	
	MasterContactType toEntity(MiniMasterDto contactType);
	
	MiniMasterDto toDto(MasterContactType contactTpe);

}
