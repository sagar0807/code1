package gov.naco.soch.ti.mapper.readonly;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.ti.dto.TiOstFollowUpSideEffectDTO;
import gov.naco.soch.ti.entity.OstSideEffect;
import gov.naco.soch.ti.mapper.EntityMapper;
import gov.naco.soch.ti.mapper.MMSideEffectMapper;

@Mapper(componentModel = "spring",uses=MMSideEffectMapper.class)
public interface SideEffectMapper extends EntityMapper<TiOstFollowUpSideEffectDTO, OstSideEffect> {
	
	@Mapping(source="tiostFollowUp.id",target="followUpId")
	@Mapping(target="sideEffect",qualifiedByName="sideEffect")
	TiOstFollowUpSideEffectDTO toDto(OstSideEffect tIOstSideEffect);
	
	
}
