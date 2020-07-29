package gov.naco.soch.ti.mapper.readonly;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.ti.dto.TiOstFollowUpByDTO;
import gov.naco.soch.ti.entity.OstFollowUpBy;
import gov.naco.soch.ti.mapper.EntityMapper;
import gov.naco.soch.ti.mapper.MMFollowUpByMapper;

@Mapper(componentModel = "spring",uses=MMFollowUpByMapper.class)
public interface FollowUpByMapper extends EntityMapper<TiOstFollowUpByDTO, OstFollowUpBy> {
	
	@Mapping(source="tiostFollowUp.id",target="followUpId")
	@Mapping(target="followUpBy",qualifiedByName="followUpBy")
	TiOstFollowUpByDTO toDto(OstFollowUpBy tIOstFollowUpBy);
	
}