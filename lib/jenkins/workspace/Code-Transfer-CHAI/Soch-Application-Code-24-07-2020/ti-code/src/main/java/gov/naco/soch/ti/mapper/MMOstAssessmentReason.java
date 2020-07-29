package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterOstAssessmentReason;

@Mapper(componentModel = "spring")
@Named("followUpReason")
public interface MMOstAssessmentReason { 

	
	MasterOstAssessmentReason toReasonEntity(MiniMasterDto mmDto);
	
	MiniMasterDto toReasonDto(MasterOstAssessmentReason masterEducationLevel);
	
}

