package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TiOstFollowUpReasonMapping;
import gov.naco.soch.ti.dto.TiOstFollowUpReasonDTO;

@Mapper(componentModel = "spring",uses=MMFollowUpReasonMapper.class)
public interface TiOstFollowUpReasonMapper extends EntityMapper<TiOstFollowUpReasonDTO, TiOstFollowUpReasonMapping> {
	
	@Mapping(source="tiostFollowUp.id",target="followUpId")
	@Mapping(target="followUpReason",qualifiedByName="followUpReason")
	TiOstFollowUpReasonDTO toDto(TiOstFollowUpReasonMapping tIOstFollowUpReason);
	
	@InheritInverseConfiguration
	TiOstFollowUpReasonMapping toEntity(TiOstFollowUpReasonDTO tIOstFollowUpReasonDTO);
	
	 default TiOstFollowUpReasonMapping fromId(Long id) {
	        if (id == null) {
	            return null;
	        }
	        TiOstFollowUpReasonMapping tiOstFollowUpReasonMapping = new TiOstFollowUpReasonMapping();
	        tiOstFollowUpReasonMapping.setId(id);
	        return tiOstFollowUpReasonMapping;
	    }

}