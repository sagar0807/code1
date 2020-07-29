package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterCounsellingType;

@Mapper(componentModel = "spring")
@Named("counsellingType")
public interface MMCounsellingTypeMapper { // extends EntityMapper<MiniMasterDto, MasterCounsellingType>{

	MasterCounsellingType toCounsellingTypeEntity(MiniMasterDto masterCounsellingType);
	
	MiniMasterDto toCounsellingTypeDto(MasterCounsellingType masterCounsellingType);
}
