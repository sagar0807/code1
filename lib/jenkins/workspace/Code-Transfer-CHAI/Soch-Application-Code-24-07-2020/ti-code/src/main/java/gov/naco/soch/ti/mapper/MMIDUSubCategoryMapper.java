package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterIDUSubCategory;

@Mapper(componentModel = "spring")
@Named("iduSubCategory")
public interface MMIDUSubCategoryMapper { 

	
	MasterIDUSubCategory toIDUEntity(MiniMasterDto miniMasterDto);

	MiniMasterDto toIDUDto(MasterIDUSubCategory masterIDUSubCategory);
	
}