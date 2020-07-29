package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterMSMSubCategory;

@Mapper(componentModel = "spring")
@Named("msmSubCategory")
public interface MMMSMSubCategoryMapper { 

	
	MasterMSMSubCategory toMSMEntity(MiniMasterDto miniMasterDto);

	MiniMasterDto toMSMDto(MasterMSMSubCategory masterMSMSubCategory);
	
}