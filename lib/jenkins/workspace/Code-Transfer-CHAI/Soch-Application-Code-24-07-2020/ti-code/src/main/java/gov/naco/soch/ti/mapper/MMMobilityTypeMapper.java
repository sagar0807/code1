package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterMobilityType;

@Mapper(componentModel = "spring")
@Named("mobilityType")
public interface MMMobilityTypeMapper {//extends EntityMapper<MiniMasterDto, MasterMobilityType>{

	MasterMobilityType toMobilityTypeEntity(MiniMasterDto masterMobilityType);
	
	MiniMasterDto toMobilityTypeDto(MasterMobilityType masterMobilityType);
}
