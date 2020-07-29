package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterKitType;

@Mapper(componentModel = "spring")
@Named("kitType")
public interface MMKittypeMapper {

	MasterKitType toEntity(MiniMasterDto kitType);
	
	MiniMasterDto toDto(MasterKitType kitType);
}
