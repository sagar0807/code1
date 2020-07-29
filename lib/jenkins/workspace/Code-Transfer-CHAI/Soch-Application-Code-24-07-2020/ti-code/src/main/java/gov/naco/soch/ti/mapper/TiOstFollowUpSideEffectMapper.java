package gov.naco.soch.ti.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import gov.naco.soch.entity.TiOstFollowUpSideEffectMapping;
import gov.naco.soch.ti.dto.TiOstFollowUpSideEffectDTO;

@Mapper(componentModel = "spring",uses=MMSideEffectMapper.class)
public interface TiOstFollowUpSideEffectMapper extends EntityMapper<TiOstFollowUpSideEffectDTO, TiOstFollowUpSideEffectMapping> {
	
	@Mapping(source="tiostFollowUp.id",target="followUpId")
	@Mapping(target="sideEffect",qualifiedByName="sideEffect")
	TiOstFollowUpSideEffectDTO toDto(TiOstFollowUpSideEffectMapping tIOstSideEffect);
	
	@InheritInverseConfiguration
	TiOstFollowUpSideEffectMapping toEntity(TiOstFollowUpSideEffectDTO tIOstFollowUpSideEffectDTO);
	
	 default TiOstFollowUpSideEffectMapping fromId(Long id) {
	        if (id == null) {
	            return null;
	        }
	        TiOstFollowUpSideEffectMapping tiOstFollowUpSideEffectMapping = new TiOstFollowUpSideEffectMapping();
	        tiOstFollowUpSideEffectMapping.setId(id);
	        return tiOstFollowUpSideEffectMapping;
	    }

}