package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entitygenerated.MasterRvAssementStatus;

@Mapper(componentModel = "spring")
@Named("assementStatus")
public interface MMRVAssessmentMapper {

	MasterRvAssementStatus toEntitity(MiniMasterDto assementStatus);
	
	MiniMasterDto toDto(MasterRvAssementStatus assementStatus);
}
