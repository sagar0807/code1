package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterSubcategory;

@Mapper(componentModel = "spring")
@Named("subCategory")
public interface MMSubCategoryMapper {//extends EntityMapper<MiniMasterDto, MasterSubcategory>{

	MasterSubcategory toSubCategoryEntity(MiniMasterDto subCategory);
	
	MiniMasterDto toSubCategoryDto(MasterSubcategory subCategory);
}
