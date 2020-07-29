package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterTGSubCategory;

@Mapper(componentModel = "spring")
@Named("tgSubCategory")
public interface MMTGSubCategoryMapper { 

	
	MasterTGSubCategory toTGEntity(MiniMasterDto miniMasterDto);

	MiniMasterDto toTGDto(MasterTGSubCategory masterTGSubCategory);
	
}