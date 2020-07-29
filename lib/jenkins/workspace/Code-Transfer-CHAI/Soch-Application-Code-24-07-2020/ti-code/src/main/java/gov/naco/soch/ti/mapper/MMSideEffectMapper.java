package gov.naco.soch.ti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import gov.naco.soch.dto.MiniMasterDto;
import gov.naco.soch.entity.MasterOstSideEffect;

@Mapper(componentModel = "spring")
@Named("sideEffect")
public interface MMSideEffectMapper { 

	
	MasterOstSideEffect toFollowUpSideEffectEntity(MiniMasterDto miniMasterDto);

	MiniMasterDto toFollowUpSideEffectDto(MasterOstSideEffect masterSideEffect);
	
}