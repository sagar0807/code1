package gov.naco.soch.ti.mapper.readonly;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.ti.dto.TiOstFollowUpReasonDTO;
import gov.naco.soch.ti.entity.OstFollowUpReason;
import gov.naco.soch.ti.mapper.EntityMapper;
import gov.naco.soch.ti.mapper.MMFollowUpReasonMapper;

    @Mapper(componentModel = "spring",uses=MMFollowUpReasonMapper.class)
    public interface FollowUpReasonMapper extends EntityMapper<TiOstFollowUpReasonDTO, OstFollowUpReason> {
    	
    	@Mapping(source="tiostFollowUp.id",target="followUpId")
    	@Mapping(target="followUpReason",qualifiedByName="followUpReason")
    	TiOstFollowUpReasonDTO toDto(OstFollowUpReason tIOstFollowUpReason);

}
