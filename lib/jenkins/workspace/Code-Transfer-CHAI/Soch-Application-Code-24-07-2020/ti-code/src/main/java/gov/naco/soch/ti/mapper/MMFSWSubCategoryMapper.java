package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterFSWSubCategory;

@Mapper(componentModel = "spring")
@Named("fswSubCategory")
public interface MMFSWSubCategoryMapper { 

	
	MasterFSWSubCategory toFSWEntity(MiniMasterDto miniMasterDto);

	MiniMasterDto toFSWDto(MasterFSWSubCategory masterFSWSubCategory);
	
}